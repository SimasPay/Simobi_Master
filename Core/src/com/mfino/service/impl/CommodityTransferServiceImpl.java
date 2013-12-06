/**
 * 
 */
package com.mfino.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mfino.constants.SystemParameterKeys;
import com.mfino.dao.ChargeTxnCommodityTransferMapDAO;
import com.mfino.dao.CommodityTransferDAO;
import com.mfino.dao.DAOFactory;
import com.mfino.dao.query.CommodityTransferQuery;
import com.mfino.domain.CommodityTransfer;
import com.mfino.domain.Pocket;
import com.mfino.domain.SubscriberMDN;
import com.mfino.fix.CmFinoFIX.CMGetTransactions;
import com.mfino.fix.CmFinoFIX.CMJSError;
import com.mfino.result.Result;
import com.mfino.service.CommodityTransferService;
import com.mfino.service.SystemParametersService;

/**
 * @author Sreenath
 *
 */
@Service("CommodityTransferServiceImpl")
public class CommodityTransferServiceImpl implements CommodityTransferService{
	
	private static Logger log = LoggerFactory.getLogger(CommodityTransferServiceImpl.class);
	
	@Autowired
	@Qualifier("SystemParametersServiceImpl")
	private SystemParametersService systemParametersService ;

	/**
	 * Retrieves and adds the details of the commoditytransfer using it's id to
	 * set it in result.This commoditytransfer is used in result.render() to
	 * send the details as xml.If reponse from multix is says not successful we
	 * will just add timestamp to the result and
	 * getDetailsofPresentTransaction() returns null
	 * 
	 * @author Gurram Karthik
	 * 
	 * @param result
	 *            returned by createResult()
	 */
	@Transactional(readOnly=true, propagation=Propagation.REQUIRED)
	public void addCommodityTransferToResult(Result result) {
		try {
			CMJSError response = (CMJSError) result.getMultixResponse();

			String message = ((CMJSError) response).getErrorDescription();

			int startIndex = message.indexOf('(');
			int endIndex = message.indexOf(')');
			if (startIndex == -1 && endIndex == -1) {
				return;
			}

			message = message.substring(endIndex + 1);

			String refID = StringUtils.EMPTY;
			try {

				String[] splitstr = message.split("REF:");
				if (splitstr.length > 1)
					refID = splitstr[1].trim();
			}
			catch (Exception ex) {
				log.warn("Error retrieving reference ID(REF:) from message");
			}
			try {
				CommodityTransfer ct = null;
				CommodityTransferDAO ctDAO = DAOFactory.getInstance().getCommodityTransferDAO();
				ct = ctDAO.getById(Long.parseLong(refID));
				result.setDetailsOfPresentTransaction(ct);
				result.setTransactionTime(ct.getStartTime());
			}
			catch (NumberFormatException ex) {
				log.info("Error retrieving commodity transfer: "+refID+" is not a number");
				result.setDetailsOfPresentTransaction(null);
			}
		}
		catch (Exception ex) {
			log.warn("trying to retrieve an invalid commodity transfer");
			result.setDetailsOfPresentTransaction(null);
		}
	}
	
	@Transactional(readOnly=true, propagation=Propagation.REQUIRED)
	public void addCommodityTransferToResult(Result result, Long commodityTransferId) {
		log.info("Adding the ct to the result");
		try {
			CommodityTransfer ct = null;
			CommodityTransferDAO ctDAO = DAOFactory.getInstance().getCommodityTransferDAO();
			ct = ctDAO.getById(commodityTransferId);
			if (ct != null) {
				result.setDetailsOfPresentTransaction(ct);
				result.setTransactionTime(ct.getStartTime());
			}
		}
		catch (Exception ex) {
			log.warn("trying to retrieve an invalid commodity transfer");
			result.setDetailsOfPresentTransaction(null);
		}
	}
	
	/**
	 * Returns a list of ct entries to create the transaction history.The no of items of list is based on a system paramter
	 * Max_txn_count_in_history
	 * @param pocket
	 * @param subscriberMDN
	 * @param transactionsHistory
	 * @return
	 * @throws Exception
	 */
	@Transactional(readOnly=true, propagation=Propagation.REQUIRED)
	public List<CommodityTransfer> getTranscationsHistory(Pocket pocket, SubscriberMDN subscriberMDN, CMGetTransactions transactionsHistory) throws Exception {
		log.info("getting the commodityTransfer list for SubscriberMDN: "+(subscriberMDN!=null?subscriberMDN.getMDN():null)+
				"and on pocket with id: "+(pocket!=null?pocket.getID():null));
		CommodityTransferDAO ctd = DAOFactory.getInstance().getCommodityTransferDAO();
		ChargeTxnCommodityTransferMapDAO ctMapDao = DAOFactory.getInstance().getTxnTransferMap();
		CommodityTransferQuery ctq = new CommodityTransferQuery();
		int maxCount = systemParametersService.getInteger(SystemParameterKeys.MAX_TXN_COUNT_IN_HISTORY);
		log.info("The system parameter 'max.txn.count.in.history' is set to: "+maxCount);
		if (maxCount != -1) {
			transactionsHistory.setMaxCount(maxCount);
		}

		ctq.setSourceDestnPocket(pocket);
		ctq.setSourceDestnMDN(subscriberMDN.getMDN());
		if(transactionsHistory.getFromDate() != null && transactionsHistory.getToDate() !=  null)
		{
			ctq.setStartTimeGE(transactionsHistory.getFromDate());
			ctq.setStartTimeLT(transactionsHistory.getToDate());
		}
		if(transactionsHistory.getPageNumber()!=null && transactionsHistory.getNumRecords()!=null){ 
			log.info(String.format("CommodityTransferServiceImpl::getTranscationsHistory()-- PageNumber:%s, NumRecords:%s",transactionsHistory.getPageNumber(),transactionsHistory.getNumRecords())); 
			ctq.setStart(transactionsHistory.getPageNumber() * transactionsHistory.getNumRecords()); 
			ctq.setLimit(transactionsHistory.getNumRecords()); 
			log.info(String.format("CommodityTransferServiceImpl::getTranscationsHistory()-- Start:%s, limit:%s",transactionsHistory.getPageNumber() * transactionsHistory.getNumRecords(),transactionsHistory.getNumRecords())); 
		}else{ 
			ctq.setStart(0); 
			ctq.setLimit(transactionsHistory.getMaxCount()); 
			log.info(String.format("CommodityTransferServiceImpl::getTranscationsHistory()-- Start:%s, limit:%s",0,transactionsHistory.getMaxCount())); 
		}
		List<CommodityTransfer> list = ctd.get(ctq);

		log.info("The size of the ctList is: "+list.size());
		for(int i=0;i<list.size();i++) {
			CommodityTransfer ct = list.get(i);
			long sctlId = ctMapDao.getSCTLIdByCommodityTransferId(ct.getID());
			ct.setSctlId(sctlId);
			if(!(pocket.getID().equals(ct.getPocketBySourcePocketID().getID())||
					pocket.getID().equals(ct.getDestPocketID()))) 
				list.remove(i);
		}
		return list;
	}

	/**
	 * Gets the Commodity transfer record by the commodity transfer id
	 * @param commodityTransferId
	 * @return
	 */
	@Transactional(readOnly=true, propagation=Propagation.REQUIRED)
	public CommodityTransfer getCommodityTransferById(Long commodityTransferId) {
		if(commodityTransferId!=null){
			CommodityTransferDAO ctDao = DAOFactory.getInstance().getCommodityTransferDAO();
			CommodityTransfer ct = ctDao.getById(commodityTransferId);
			return ct;
		}
		else{
			log.error("Commodity transfer ID obatined null");
			return null;
		}
		
	}
	/**
	 * Gets the Commodity transfer record by the commodity transfer id
	 * @param commodityTransferId
	 * @return
	 * @throws Exception 
	 */
	@Transactional(readOnly=true, propagation=Propagation.REQUIRED)
	public List<CommodityTransfer> get(CommodityTransferQuery query) throws Exception {
		if(query!=null){
			CommodityTransferDAO ctDao = DAOFactory.getInstance().getCommodityTransferDAO();
			return ctDao.get(query);
		}
		else{
			log.error("Commodity transfer ID obatined null");
			return null;
		}
		
	}
	

}
