/**
 * 
 */
package com.mfino.scheduler.service.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mfino.domain.BulkUploadFile;
import com.mfino.domain.User;
import com.mfino.fix.CmFinoFIX;
import com.mfino.scheduler.service.BulkUploadSchedulerService;
import com.mfino.scheduler.upload.service.AgentBulkUploadService;
import com.mfino.scheduler.upload.service.SubscriberBulkUploadService;
import com.mfino.service.BulkUploadFileService;
import com.mfino.service.MailService;
import com.mfino.service.UserService;

/**
 * @author Maruthi
 *
 */
@Service("BulkUploadSchedulerServiceImpl")
public class BulkUploadSchedulerServiceImpl implements BulkUploadSchedulerService{

	private Logger log = LoggerFactory.getLogger(this.getClass());
			
	private SubscriberBulkUploadService subscriberBulkUploadService;
	
	private AgentBulkUploadService agentBulkUploadService;
	
	@Autowired
	@Qualifier("MailServiceImpl")
	private MailService mailService;
	
	@Autowired
	@Qualifier("BulkUploadFileServiceImpl")
	private BulkUploadFileService bulkuploadService;

	@Autowired
	@Qualifier("UserServiceImpl")
	private UserService userService;
	/* (non-Javadoc)
	 * @see com.mfino.scheduler.service.BulkUploadService#uploadData()
	 */
	
	private HibernateTransactionManager txManager;
	
	public HibernateTransactionManager getTxManager() {
		return txManager;
	}

	public void setTxManager(HibernateTransactionManager txManager) {
		this.txManager = txManager;
	}

	public void uploadData() throws Throwable {
			log.info("BEGIN BulkUploadServiceImpl:UploadData");
			List<BulkUploadFile> pendingFiles = bulkuploadService.getPendingFiles();
			log.debug("Number Pending Files to be processed = "+ pendingFiles.size());
			for (BulkUploadFile bulkUploadFile : pendingFiles) {
				try{
					uploadFile(bulkUploadFile);
				}catch(FileNotFoundException fileNotFoundEx){
					log.error("Could not process upload of file: "+ bulkUploadFile.getFileName()+" ID: "+bulkUploadFile.getID(), fileNotFoundEx);
				}
			}
		log.info("END UploadData");
	}

	
	private void uploadFile(BulkUploadFile bulkUploadFile) throws IOException{
		log.info("BEGIN bulk upload file ID: "+bulkUploadFile.getID());
		if(CmFinoFIX.UploadFileStatus_Uploaded.equals(bulkUploadFile.getUploadFileStatus())) {
			//set the file status as Processing only if it is under Uploaded state, 
			//skip updating the status of files which are already in Processing state
		bulkUploadFile.setUploadFileStatus(CmFinoFIX.UploadFileStatus_Processing);
		bulkuploadService.save(bulkUploadFile);
		}
		if (bulkUploadFile.getRecordType().equals(CmFinoFIX.RecordType_SubscriberFullyBanked)
				||bulkUploadFile.getRecordType().equals(CmFinoFIX.RecordType_SubscriberSemiBanked)
				||bulkUploadFile.getRecordType().equals(CmFinoFIX.RecordType_SubscriberUnBanked)
				||bulkUploadFile.getRecordType().equals(CmFinoFIX.RecordType_Upgrade_N_Approve)) {
			
			bulkUploadFile = subscriberBulkUploadService.ProcessBulkUploadFile(bulkUploadFile);
		}
		else if(bulkUploadFile.getRecordType().equals(CmFinoFIX.RecordType_Agent)){
			bulkUploadFile = agentBulkUploadService.ProcessBulkUploadFile(bulkUploadFile);
		}
		
		bulkuploadService.save(bulkUploadFile);
		//sendind mail to user
		User user=userService.getByUserName(bulkUploadFile.getCreatedBy());
		String email = user.getEmail();
		String to= user.getFirstName();
		String subject = "BulkUpload Result";
		String msg = "Total uploaded Records :"+bulkUploadFile.getTotalLineCount()+"\nSuccessful Records :"+
				(bulkUploadFile.getTotalLineCount()-bulkUploadFile.getErrorLineCount())+"\n Failed Records:"+bulkUploadFile.getErrorLineCount();
		try{			
			mailService.sendMail(email, to, subject, msg);
		}catch (Exception e) {
			log.error("Failed to send mail to "+email);
		}
		
		log.info("Processing Completed " + bulkUploadFile.getTotalLineCount() + " Bulk Upload File id: "+bulkUploadFile.getID());
	}

	

	public SubscriberBulkUploadService getSubscriberBulkUploadService() {
		return subscriberBulkUploadService;
	}

	public void setSubscriberBulkUploadService(
			SubscriberBulkUploadService subscriberBulkUploadService) {
		this.subscriberBulkUploadService = subscriberBulkUploadService;
	}

	public AgentBulkUploadService getAgentBulkUploadService() {
		return agentBulkUploadService;
	}

	public void setAgentBulkUploadService(AgentBulkUploadService agentBulkUploadService) {
		this.agentBulkUploadService = agentBulkUploadService;
	}
}
