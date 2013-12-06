/**
 * 
 */
package com.mfino.sms.handlers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mfino.domain.TransactionsLog;
import com.mfino.fix.CmFinoFIX;
import com.mfino.fix.CmFinoFIX.CMGetTransactions;
import com.mfino.fix2notification.processor.GetShareLoadHistoryProcessor;
import com.mfino.fix2notification.processor.GetTransactionHistoryProcessor;
import com.mfino.mailer.NotificationMessageParser;
import com.mfino.mailer.NotificationWrapper;
import com.mfino.service.SMSService;

/**
 * @author Deva
 *
 */
public class TransactionsHistoryHandler extends SMSHandler {

	private CMGetTransactions transactionsHistoryRequest = null;
	
	private String message = null;
	
	private String messageToSend;
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	public TransactionsHistoryHandler(CMGetTransactions transactionsHistoryRequest, 
			String actualMessage) {
		this.transactionsHistoryRequest = transactionsHistoryRequest;
		this.message = actualMessage;
	}
	
	/* (non-Javadoc)
	 * @see com.mfino.sms.handlers.SMSHandler#handle()
	 */
	@Override
	public boolean handle() {
		TransactionsLog transactionsLog = saveTransactionsLog(CmFinoFIX.MessageType_GetTransactions, message);
		transactionsHistoryRequest.setTransactionID(transactionsLog.getID());
		try {
			List<NotificationWrapper> notificationWrapperList = null;
			if ( CmFinoFIX.ServletPath_Subscribers.equals(transactionsHistoryRequest.getServletPath()) ) {
				GetShareLoadHistoryProcessor getShareLoadHistoryProcessor = new GetShareLoadHistoryProcessor();
				notificationWrapperList = getShareLoadHistoryProcessor.process(transactionsHistoryRequest);
			} else {
				GetTransactionHistoryProcessor getTransactionHistoryProcessor = new GetTransactionHistoryProcessor();
				notificationWrapperList = getTransactionHistoryProcessor.process(transactionsHistoryRequest);
			}
			for (NotificationWrapper notificationWrapper : notificationWrapperList) {
				notificationWrapper.setTransactionId(transactionsLog.getID());
				NotificationMessageParser nmp = new NotificationMessageParser(notificationWrapper);
				messageToSend = nmp.buildMessage();
				System.out.println(transactionsLog.getID());
				try {
					SMSService service = new SMSService();
					service.setDestinationMDN(transactionsHistoryRequest.getSourceMDN());
					service.setSourceMDN(notificationWrapper.getSMSNotificationCode());
					service.setMessage(messageToSend);
					service.setAccessCode(notificationWrapper.getAccessCode());
					log.info(messageToSend);
					if (notificationWrapper.getCompany() != null && notificationWrapper.getCompany().getsmsc() != null) {
						service.setSmsc(notificationWrapper.getCompany().getsmsc());
					}
					service.send();
				} catch (Exception err) {
					log.error("Exception while sending sms: ", err);
				}
			}
			
		} catch (Exception err) {
			log.error("Exception while sending sms: ", err);
			return false;
		}
		return true;
	}
	
}
