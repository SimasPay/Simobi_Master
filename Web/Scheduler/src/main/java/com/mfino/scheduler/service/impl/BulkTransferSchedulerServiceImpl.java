/**
 * 
 */
package com.mfino.scheduler.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.stereotype.Service;

import com.mfino.constants.ServiceAndTransactionConstants;
import com.mfino.constants.SystemParameterKeys;
import com.mfino.dao.query.BulkUploadQuery;
import com.mfino.domain.BulkUpload;
import com.mfino.domain.BulkUploadEntry;
import com.mfino.domain.ChannelCode;
import com.mfino.domain.CommodityTransfer;
import com.mfino.domain.Pocket;
import com.mfino.fix.CmFinoFIX;
import com.mfino.hibernate.Timestamp;
import com.mfino.result.XMLResult;
import com.mfino.scheduler.service.BulkTransferSchedulerService;
import com.mfino.service.BulkUploadEntryService;
import com.mfino.service.BulkUploadService;
import com.mfino.service.ChannelCodeService;
import com.mfino.service.PocketService;
import com.mfino.service.SystemParametersService;
import com.mfino.task.BulkTransferJob;
import com.mfino.transactionapi.handlers.money.BulkTransferHandler;
import com.mfino.transactionapi.handlers.money.BulkTransferInquiryHandler;
import com.mfino.transactionapi.service.BulkTransferService;
import com.mfino.transactionapi.vo.TransactionDetails;

/**
 * @author Bala Sunku
 *
 */
@Service("BulkTransferSchedulerServiceImpl")
public class BulkTransferSchedulerServiceImpl  implements BulkTransferSchedulerService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	@Qualifier("BulkTransferHandlerImpl")
	private BulkTransferHandler bulkTransferHandler;
	
	@Autowired
	@Qualifier("BulkTransferInquiryHandlerImpl")
	private BulkTransferInquiryHandler bulkTransferInquiryHandler;
	
	@Autowired
	@Qualifier("PocketServiceImpl")
	private PocketService pocketService;
	
	@Autowired
	@Qualifier("BulkUploadServiceImpl")
	private BulkUploadService bulkUploadService;
	
	@Autowired
	@Qualifier("BulkUploadEntryServiceImpl")
	private  BulkUploadEntryService bulkUploadEntryService;
	
	@Autowired
	@Qualifier("ChannelCodeServiceImpl")
	private  ChannelCodeService channelCodeService;
	
	@Autowired
	@Qualifier("BulkTransferServiceImpl")
	private BulkTransferService btService;
	
	@Autowired
	@Qualifier("SystemParametersServiceImpl")
	private SystemParametersService systemParametersService;	
	
	private HibernateTransactionManager txManager;
	
	public HibernateTransactionManager getTxManager() {
		return txManager;
	}

	public void setTxManager(HibernateTransactionManager txManager) {
		this.txManager = txManager;
	}
	
	private long EXPIRATION_TIME = 900000;// 15mins

	@Override
	public void processBulkTransfer() {
		log.info("Processing of Bulk Transfer Requets :: BEGIN");
		processInitializedBulkTransfer();
		processApprovedBulkTransfer();
		checkCompletedBulkTransferForRevertAmount();
		log.info("Processing of Bulk Transfer Requets :: END");		
	}
	
	/**
	 * Change the status of intialized bulk transfers to Failed if they did not confirmed .
	 */
	private void processInitializedBulkTransfer() {
		log.info("processInitializedBulkTransfer:: BEGIN");
		BulkUploadQuery query = new BulkUploadQuery();
		query.setFileStatus(CmFinoFIX.BulkUploadDeliveryStatus_Initialized);
		List<BulkUpload> lstBulkUpload = bulkUploadService.getByQuery(query);
		Timestamp currentTime = new Timestamp();
		if (CollectionUtils.isNotEmpty(lstBulkUpload)) {
			for (BulkUpload bulkUpload: lstBulkUpload) {
				try {
					if ((currentTime.getTime() - bulkUpload.getLastUpdateTime().getTime()) > EXPIRATION_TIME) {
						bulkUpload.setDeliveryStatus(CmFinoFIX.BulkUploadDeliveryStatus_Failed);
						bulkUpload.setFailureReason("Falied as the request is timed out");
						bulkUploadService.save(bulkUpload);
					}
				} catch (Exception e) {
					log.error("Error: While Processing the Initialized bulk transfer Id: " + bulkUpload.getID(), e);
				} 
			}
		}
		log.info("processInitializedBulkTransfer :: END");
	}	
	
	/**
	 * Process the Approved Bulk Transfers .
	 */
	private void processApprovedBulkTransfer() {
		log.info("processApprovedBulkTransfer :: BEGIN");
		try {
			BulkUploadQuery query = new BulkUploadQuery();
			query.setFileStatus(CmFinoFIX.BulkUploadDeliveryStatus_Approved);
			List<BulkUpload> lstBulkUpload = bulkUploadService.getByQuery(query);
			if (CollectionUtils.isNotEmpty(lstBulkUpload)) {
				for (BulkUpload bulkUpload: lstBulkUpload) {
					try {
						schedulePayment(bulkUpload);
					} catch (Exception e) {
						log.error("Error: While Processing the Approved bulk transfer Id: " + bulkUpload.getID(), e);
					} 
				}
			}
		} catch (Exception e) {
			log.error("Error: While Processing the Approved bulk transfers " + e.getMessage(), e);
		} 
		log.info("processApprovedBulkTransfer :: END");
	}
	
	/**
	 * Check the Completed Bulk Transfers for Failed / Expired Transactions.
	 */
	private void checkCompletedBulkTransferForRevertAmount() {
		log.info("checkCompletedBulkTransferForRevertAmount:: BEGIN");
		try {
			BulkUploadQuery query = new BulkUploadQuery();
			query.setFileStatus(CmFinoFIX.BulkUploadDeliveryStatus_Complete);
			List<BulkUpload> lstBulkUpload = bulkUploadService.getByQuery(query);
			if (CollectionUtils.isNotEmpty(lstBulkUpload)) {
				for (BulkUpload bulkUpload: lstBulkUpload) {
					try {
						calculateRevertAmount(bulkUpload);
					} catch (Exception e) {
						log.error("Error: While calculating the Revert Amount for Bulk transfer : " + bulkUpload.getID(), e);
					}
				}
			}
		} catch (Exception e) {
			log.error("Error: While checking the completed bulk transfers " + e.getMessage(), e);
		} 
		log.info("checkCompletedBulkTransferForRevertAmount:: END");
	}
	
	/**
	 * Calculate the is there any amount to be reverted as part of Failed / Expired Transactions.
	 * @param bulkUpload
	 * @param buDAO
	 */
	private void calculateRevertAmount(BulkUpload bulkUpload){
		int pendingCount = 0;
		int failedCount = (bulkUpload.getFailedTransactionsCount() != null) ? bulkUpload.getFailedTransactionsCount() : 0;
		BigDecimal revertAmount = (bulkUpload.getRevertAmount()!=null) ? bulkUpload.getRevertAmount() : BigDecimal.ZERO;
		BigDecimal successAmount = (bulkUpload.getSuccessAmount()!=null) ? bulkUpload.getSuccessAmount() : BigDecimal.ZERO;
		boolean isAnyEntryModified = false;
		log.info("Checking the Bulk Transfer " + bulkUpload.getID() + " for expired  / Failed / Pending transfers.");
		
		List<BulkUploadEntry> bulkUploadEntries = bulkUploadEntryService.getNotCompleteBulkUploadEntriesForBulkUpload(bulkUpload.getID());
		if (CollectionUtils.isNotEmpty(bulkUploadEntries)) {
			for (BulkUploadEntry bue: bulkUploadEntries) {
				boolean isModified = false;
				if (CmFinoFIX.TransactionsTransferStatus_Pending.equals(bue.getStatus())) {
					pendingCount ++;
				}
				else if (CmFinoFIX.TransactionsTransferStatus_Failed.equals(bue.getStatus())) {
					log.info("Reversing the failed amount: " + bue.getAmount() + " for MDN: " + bue.getDestMDN());
					bue.setStatus(CmFinoFIX.TransactionsTransferStatus_Reversed);
					isModified = true;
					revertAmount = revertAmount.add(bue.getAmount());
				}
				else if (CmFinoFIX.TransactionsTransferStatus_Expired.equals(bue.getStatus())) {
					log.info("Reversing the expired amount: " + bue.getAmount() + " for MDN: " + bue.getDestMDN());
					bue.setStatus(CmFinoFIX.TransactionsTransferStatus_Reversed);
					isModified = true;
					revertAmount = revertAmount.add(bue.getAmount());
					successAmount = successAmount.subtract(bue.getAmount());
					failedCount ++;
				}
				if (isModified) {
					isAnyEntryModified = true;
					bulkUploadEntryService.saveBulkUploadEntry(bue);
				}
			}
		}
		
		bulkUpload.setFailedTransactionsCount(failedCount);
		bulkUpload.setSuccessAmount(successAmount);
		bulkUpload.setRevertAmount(revertAmount);
		log.info("No. of Pending txns = "+ pendingCount);
		if ((pendingCount == 0) && (revertAmount.compareTo(BigDecimal.ZERO) > 0) ) {
			log.info("Reverting the Amount " + revertAmount.toPlainString()
					+ " as part of Failed / Expired Transfers for Bulk transfer request " + bulkUpload.getID());
			isAnyEntryModified = true;
			bulkUpload = doReverseBulkTransfer(bulkUpload, revertAmount);
		}
		if (isAnyEntryModified) {
			bulkUploadService.save(bulkUpload);
		}
	}
	
	/**
	 * Revert the Amount from Suspense pocket to Source pocket
	 * @param bulkUpload
	 * @param amount
	 * @return
	 */
	private BulkUpload doReverseBulkTransfer(BulkUpload bulkUpload, BigDecimal amount) {
		
		Pocket destPocket = bulkUpload.getPocketBySourcePocket();
        long srcPocketId = systemParametersService.getLong(SystemParameterKeys.INTEREST_COMMISSION_FUNDING_POCKET_ID);
        Pocket sourcePocket = pocketService.getById(srcPocketId);		
		ChannelCode channelCode = channelCodeService.getChannelCodebySourceApplication(CmFinoFIX.SourceApplication_BackEnd);
		
		log.info("Creating the Reverse Bulk Transfer Inquiry object");

		TransactionDetails transactionDetails = new TransactionDetails();
		transactionDetails.setSourceMDN(sourcePocket.getSubscriberMDNByMDNID().getMDN());
		transactionDetails.setDestMDN(bulkUpload.getMDN());
		transactionDetails.setAmount(amount);
		transactionDetails.setSourcePIN("mFino260");
		transactionDetails.setServletPath(CmFinoFIX.ServletPath_Subscribers);
		transactionDetails.setSourceMessage(ServiceAndTransactionConstants.MESSAGE_SETTLE_BULK_TRANSFER);
		transactionDetails.setChannelCode(channelCode.getChannelCode());
		transactionDetails.setSrcPocketId(sourcePocket.getID());
		transactionDetails.setDestinationPocketId(destPocket.getID());
		transactionDetails.setServiceName(ServiceAndTransactionConstants.SERVICE_WALLET);
		transactionDetails.setTransactionName(ServiceAndTransactionConstants.TRANSACTION_SETTLE_BULK_TRANSFER);
		transactionDetails.setCc(channelCode);
		transactionDetails.setSctlId(bulkUpload.getServiceChargeTransactionLogID());
		

		XMLResult result = (XMLResult)bulkTransferInquiryHandler.handle(transactionDetails);
		
		if (result != null ) {
			Long sctlId = result.getSctlID();
			bulkUpload.setReverseSCTLID(sctlId);
			bulkUploadService.save(bulkUpload);
			
			if (CmFinoFIX.NotificationCode_BankAccountToBankAccountConfirmationPrompt.toString().equals(result.getCode())) {
				log.info("Creating the Reverse Bulk Transfer Confirmation object");

				transactionDetails.setParentTxnId(result.getParentTransactionID());
				transactionDetails.setTransferId(result.getTransferID());
				transactionDetails.setConfirmString(CmFinoFIX.Boolean_True.toString());

				result = (XMLResult)bulkTransferHandler.handle(transactionDetails);
				
				if (result != null && result.getDetailsOfPresentTransaction()!= null) {
					CommodityTransfer ct = result.getDetailsOfPresentTransaction();
					if (CmFinoFIX.TransferStatus_Completed.equals(ct.getTransferStatus())) {
						bulkUpload.setRevertAmount(BigDecimal.ZERO);
						log.info("Reverting the Amount " + amount.toPlainString()
								+ " as part of Failed / Expired Transfers for Bulk transfer request " + bulkUpload.getID() + " is Success");
					}
					else {
						log.info("Reverting the Amount " + amount.toPlainString()
								+ " as part of Failed / Expired Transfers for Bulk transfer request " + bulkUpload.getID() + " is Failed");
					}
				}
				// No Response from Back end after confirming the transaction
				else {
					bulkUpload.setDeliveryStatus(CmFinoFIX.BulkUploadDeliveryStatus_Settlement_Pending);
					bulkUpload.setDeliveryDate(new Timestamp());
					log.info("Reverting the Amount " + amount.toPlainString()
							+ " as part of Failed / Expired Transfers for Bulk transfer request " + bulkUpload.getID() + " is Pending");
				}
			}
			else {
				log.info("Reverting the Amount " + amount.toPlainString()
						+ " as part of Failed / Expired Transfers for Bulk transfer request " + bulkUpload.getID() + " is failed because of inquiry is failed");
			}
		}
		else {
			log.info("Reverting the Amount " + amount.toPlainString()
					+ " as part of Failed / Expired Transfers for Bulk transfer request " + bulkUpload.getID() + " is failed because of inquiry result is null");
		}
		
		return bulkUpload;
	}

	
	private void schedulePayment(BulkUpload bulkUpload){
		
		Timestamp scheduledTime = bulkUpload.getPaymentDate();
		Date todaysDate = new Timestamp();
		if(DateUtils.isSameDay(todaysDate, scheduledTime) || (scheduledTime.before(todaysDate)))
		{
			BulkTransferJob job = new BulkTransferJob();
			job.setBtService(btService);
			job.setBulkuploadService(bulkUploadService);
			job.setPocketService(pocketService);
			job.setChannelCodeService(channelCodeService);
			job.setBulkUploadEntryService(bulkUploadEntryService);
			job.setSystemParametersService(systemParametersService);
			job.doBulkTransfer(bulkUpload);
		}
	}
	
}
