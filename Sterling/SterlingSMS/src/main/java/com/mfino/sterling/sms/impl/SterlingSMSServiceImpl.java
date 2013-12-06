package com.mfino.sterling.sms.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mfino.dao.DAOFactory;
import com.mfino.dao.NotificationLogDetailsDAO;
import com.mfino.domain.NotificationLogDetails;
import com.mfino.fix.CmFinoFIX;
import com.mfino.mce.core.util.MCEUtil;
import com.mfino.mce.notification.SMSNotification;

public class SterlingSMSServiceImpl {

	public static final String WEBSERVICE_OPERATION_NAME = "mmSMS";
	private Log log = LogFactory.getLog(SterlingSMSServiceImpl.class);
 	private String webServiceEndpointBean;
 	
	public String getWebServiceEndpointBean() {
		return webServiceEndpointBean;
	}

	public void setWebServiceEndpointBean(String webServiceEndpointBean) {
		this.webServiceEndpointBean = webServiceEndpointBean;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED)
	public void process(Exchange exchange) {
		log.info("SterlingSMSServiceImpl::process");
		SMSNotification smsNotification = exchange.getIn().getBody(SMSNotification.class);
		List<Object> params = new ArrayList<Object>();
		List<Object> responseFromWS = null;
		
		Long notificationDetailsLogID = smsNotification.getNotificationLogDetailsID();
		NotificationLogDetailsDAO notificationLogDetailsDao = DAOFactory.getInstance().getNotificationLogDetailsDao();
		NotificationLogDetails notificationLogDetails = null;
		if(notificationDetailsLogID != null)
		{
			notificationLogDetails = notificationLogDetailsDao.getById(notificationDetailsLogID);
		}
		
			if (smsNotification != null) {
	 			params.add(smsNotification.getContent()); // Message
				params.add(smsNotification.getMdn()); //Mdn
				log.info("SMS to  --> " + smsNotification.getMdn() + ":: " + smsNotification.getContent());
				try
				{	
					ProducerTemplate template = exchange.getContext().createProducerTemplate();
					template.start();
					Map<String,Object> headersMap = new HashMap<String,Object>();
					headersMap.put("operationName",WEBSERVICE_OPERATION_NAME);
					MCEUtil.setMandatoryHeaders(exchange.getIn().getHeaders(), headersMap);
					responseFromWS = (List<Object>)template.requestBodyAndHeaders("cxf:bean:"+webServiceEndpointBean,params,headersMap);								
					template.stop();
				}
				catch(Exception e)
				{
					//any exception during call to web service need to be catched and it needs to be treated as failure
					log.info("Exception during call to web service for SMS",e);
					responseFromWS = new ArrayList<Object>();
					responseFromWS.add(MCEUtil.SERVICE_UNAVAILABLE); // TODO
					log.error(e.getMessage());
					if(notificationLogDetails != null )
					{
						notificationLogDetails.setStatus(CmFinoFIX.SendNotificationStatus_Failed);
						notificationLogDetailsDao.save(notificationLogDetails);
						log.info("Failed to send sms with notificationLogDetailsID " + notificationDetailsLogID);
					}
					
				}				
			}
		
		
		if((null != responseFromWS) && (responseFromWS.size() > 0)) {
			Object wsResponse = responseFromWS.get(0);
			log.info("Reponse from SMS WebService --> " + wsResponse);
			if(notificationLogDetails != null )
			{
				notificationLogDetails.setStatus(CmFinoFIX.SendNotificationStatus_Success);
				notificationLogDetailsDao.save(notificationLogDetails);
				log.info("SMS with NotificationLogDetailsID " + notificationDetailsLogID + " was successfully sent");
			}
		}				
	}

}
