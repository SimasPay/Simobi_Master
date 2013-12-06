/**
 * 
 */
package com.mfino.scheduler.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.stereotype.Service;

import com.mfino.constants.ServiceAndTransactionConstants;
import com.mfino.constants.SystemParameterKeys;
import com.mfino.dao.query.UnRegisteredTxnInfoQuery;
import com.mfino.domain.BulkUploadEntry;
import com.mfino.domain.ServiceChargeTransactionLog;
import com.mfino.domain.TransactionType;
import com.mfino.domain.UnRegisteredTxnInfo;
import com.mfino.fix.CmFinoFIX;
import com.mfino.hibernate.Timestamp;
import com.mfino.i18n.MessageText;
import com.mfino.result.Result;
import com.mfino.service.BulkUploadEntryService;
import com.mfino.service.ServiceChargeTransactionLogService;
import com.mfino.service.SystemParametersService;
import com.mfino.service.TransactionTypeService;
import com.mfino.service.UnRegisteredTxnInfoService;
import com.mfino.transactionapi.handlers.money.AutoReverseHandler;
import com.mfino.transactionapi.vo.TransactionDetails;

/**
 * @author Bala Sunku
 *
 */
@Service("TransferToUnRegisteredClearanceServiceImpl")
public class TransferToUnRegisteredClearanceServiceImpl  {
	public static final int TRANSFER_TO_UNREGISTERED_EXPIRY_TIME = 48; // Default 48 hrs
	private static Logger log = LoggerFactory.getLogger(TransferToUnRegisteredClearanceServiceImpl.class);
	@Autowired
	@Qualifier("AutoReverseHandlerImpl")
	private AutoReverseHandler autoReverseHandler;
	
	@Autowired
	@Qualifier("SystemParametersServiceImpl")
	private SystemParametersService systemParametersService;
	
	@Autowired
	@Qualifier("UnRegisteredTxnInfoServiceImpl")
	private UnRegisteredTxnInfoService unRegisteredTxnInfoService;
	
	@Autowired
	@Qualifier("TransactionTypeServiceImpl")
	private TransactionTypeService transactionTypeService;
	
	@Autowired
	@Qualifier("ServiceChargeTransactionLogServiceImpl")
	private ServiceChargeTransactionLogService  serviceChargeTransactionLogService;
	
	@Autowired
	@Qualifier("BulkUploadEntryServiceImpl")
	private BulkUploadEntryService  bulkUploadEntryService;
	
	private HibernateTransactionManager txManager;
	
	public HibernateTransactionManager getTxManager() {
		return txManager;
	}

	public void setTxManager(HibernateTransactionManager txManager) {
		this.txManager = txManager;
	}

	public void checkExpirationOfTransferToUnRegistered() {
		log.info("TransferToUnRegisteredClearanceServiceImpl :: checkExpirationOfTransferToUnRegistered :: BEGIN");
		long expiryHours = systemParametersService.getLong(SystemParameterKeys.TRANSFER_TO_UNREGISTERED_EXPIRY_TIME);
		if (expiryHours == -1) {
			expiryHours = TRANSFER_TO_UNREGISTERED_EXPIRY_TIME;
		}
		long expiryTime = expiryHours * 60 * 60 *1000;
		Timestamp cuurentTime = new Timestamp();
				
		UnRegisteredTxnInfoQuery urtiQuery = new UnRegisteredTxnInfoQuery();
		Integer[] status = new Integer[2];
		status[0] = CmFinoFIX.UnRegisteredTxnStatus_TRANSFER_COMPLETED;
		status[1] = CmFinoFIX.UnRegisteredTxnStatus_CASHOUT_FAILED;
		urtiQuery.setMultiStatus(status);
		
		List<UnRegisteredTxnInfo> unRegisteredTxnInfos = unRegisteredTxnInfoService.getUnRegisteredTxnInfoListByQuery(urtiQuery);
		
		if (CollectionUtils.isNotEmpty(unRegisteredTxnInfos)) {
			for (UnRegisteredTxnInfo urti: unRegisteredTxnInfos) {
				if ( !(ServiceAndTransactionConstants.TRANSACTION_CASHOUT_AT_ATM.equals(urti.getTransactionName())) ) {
					long diffTime = cuurentTime.getTime() - urti.getCreateTime().getTime();
					if (diffTime > expiryTime) {
						revertTransfer(urti);
					}
				}
			}
		}
		log.info("TransferToUnRegisteredClearanceServiceImpl :: checkExpirationOfTransferToUnRegistered :: END");
	}
	
	
	private void revertTransfer(UnRegisteredTxnInfo urti) {
		log.info("Reverting the Transfer to UnRegistered with ReferenceId: " + urti.getTransferSCTLId());
		
		String reverseCharge = systemParametersService.getString(SystemParameterKeys.REVERSE_CHARGE_FOR_EXPIRED_TRANSFER_TO_UNREGISTERED);
		boolean isChargeRevese = false;
		if ("true".equalsIgnoreCase(reverseCharge)) {
			isChargeRevese = true;
		}
		
		long sctlId = urti.getTransferSCTLId();
		ServiceChargeTransactionLog sctl = serviceChargeTransactionLogService.getById(sctlId);
		Long chargeRevFundPocket = systemParametersService.getLong(SystemParameterKeys.CHARGE_REVERSAL_FUNDING_POCKET);
		
		log.info("Reversal of Transfer to UnRegistered with ReferenceId: " + sctl.getID() + " is initialized");
		urti.setUnRegisteredTxnStatus(CmFinoFIX.UnRegisteredTxnStatus_REVERSAL_INITIALIZED);
		unRegisteredTxnInfoService.save(urti);
		

		TransactionDetails transactionDetails = new TransactionDetails();
		transactionDetails.setSctlId(sctl.getID());
		transactionDetails.setChargeReverseAlso(isChargeRevese);
		transactionDetails.setChargeRevFundPocket(chargeRevFundPocket);
		
		Result result = autoReverseHandler.handle(transactionDetails);
		if (CmFinoFIX.NotificationCode_AutoReverseSuccess.equals(result.getNotificationCode())) {
			sctl.setStatus(CmFinoFIX.SCTLStatus_Expired);
			sctl.setFailureReason(MessageText._("Transfer to UnRegistered Expired and Money reverted to source Account"));
			serviceChargeTransactionLogService.save(sctl);
			
			urti.setUnRegisteredTxnStatus(CmFinoFIX.UnRegisteredTxnStatus_CASHOUT_EXPIRED);
			urti.setFailureReason(MessageText._("Transfer to UnRegistered Expired and Money reverted to source Account"));
			unRegisteredTxnInfoService.save(urti);
			
			// Check if the Transaction is of type Sub Bulk Transfer then Change the Status in Bulkuploadentry so that
			// the amount will be reverted to Source pocket. (from suspence pocket to source pocket)
			long transactionTypeId = sctl.getTransactionTypeID();
			TransactionType transactionType = transactionTypeService.getTransactionTypeById(transactionTypeId);
			if (ServiceAndTransactionConstants.TRANSACTION_SUB_BULK_TRANSFER.equals(transactionType.getTransactionName())) {
				BulkUploadEntry bue = bulkUploadEntryService.getBulkUploadEntryBySctlID(sctlId);
				bue.setStatus(CmFinoFIX.TransactionsTransferStatus_Expired);
				bue.setFailureReason(MessageText._("Transfer to UnRegistered Expired and Money reverted to source Account"));
				bulkUploadEntryService.saveBulkUploadEntry(bue);
			}
			log.info("Successfully reverted the Transaction with Reference ID : " + sctlId);
		}
		else if (CmFinoFIX.NotificationCode_AutoReverseFailed.equals(result.getNotificationCode())) {
			log.info("Reversal of Transfer to UnRegistered with ReferenceId: " + sctlId + " is failed");
			urti.setUnRegisteredTxnStatus(CmFinoFIX.UnRegisteredTxnStatus_CASHOUT_FAILED);
			urti.setFailureReason(MessageText._("Reversal of 'Transfer to UnRegistered' is failed and will try in next trigger fire event"));
			unRegisteredTxnInfoService.save(urti);
		}
		else {
			log.info("Reversal of Transfer to UnRegistered with ReferenceId: " + sctlId + " is Pending");
		}
	}
}
