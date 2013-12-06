package com.mfino.uicore.fix.processor.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mfino.dao.DAOFactory;
import com.mfino.dao.DCTRestrictionsDao;
import com.mfino.dao.DistributionChainTemplateDAO;
import com.mfino.dao.TransactionTypeDAO;
import com.mfino.dao.query.DCTRestrictionsQuery;
import com.mfino.domain.DCTRestrictions;
import com.mfino.domain.DistributionChainTemplate;
import com.mfino.domain.TransactionType;
import com.mfino.fix.CFIXMsg;
import com.mfino.fix.CmFinoFIX;
import com.mfino.fix.CmFinoFIX.CMJSDCTRestrictions;
import com.mfino.uicore.fix.processor.BaseFixProcessor;
import com.mfino.uicore.fix.processor.DCTRestrictionsProcessor;

/**
 * @author Sasi
 *
 */
@Service("DCTRestrictionsProcessorImpl")
public class DCTRestrictionsProcessorImpl extends BaseFixProcessor implements DCTRestrictionsProcessor{
	
	@Override
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED,rollbackFor=Throwable.class)
	public CFIXMsg process(CFIXMsg msg) throws Exception {
		CMJSDCTRestrictions realMsg = (CMJSDCTRestrictions) msg;
		log.info("DCTRestrictionsProcessor :: process BEGIN "+realMsg.getaction());
		DCTRestrictionsDao dctRestrictionsDao = DAOFactory.getInstance().getDctRestrictionsDao();
		
		if (CmFinoFIX.JSaction_Select.equals(realMsg.getaction())) {
            DCTRestrictionsQuery query = new DCTRestrictionsQuery();
            query.setDctRestrictionsId(realMsg.getIDSearch());
            query.setDctId(realMsg.getDCTIDSearch());

            List<DCTRestrictions> results = dctRestrictionsDao.get(query);
            realMsg.allocateEntries(results.size());
            for (int i = 0; i < results.size(); i++) {
                DCTRestrictions s = results.get(i);
                CMJSDCTRestrictions.CGEntries entry = new CMJSDCTRestrictions.CGEntries();
                updateMessage(s, entry);
                realMsg.getEntries()[i] = entry;
            }
            realMsg.setsuccess(CmFinoFIX.Boolean_True);
            realMsg.settotal(query.getTotal());
		}
		
		if (CmFinoFIX.JSaction_Insert.equals(realMsg.getaction())) {
			CMJSDCTRestrictions.CGEntries[] entries = realMsg.getEntries();

            for (CMJSDCTRestrictions.CGEntries e : entries) {
            	DCTRestrictions s = new DCTRestrictions();
                updateEntity(s, e);
                try{
                	dctRestrictionsDao.save(s);
                }catch (ConstraintViolationException cve) {
                	return generateError(cve, CmFinoFIX.CMJSDCTRestrictions.FieldName_DCTIDSearch, "Duplicate DCT Restrictions are not allowed.");
				}
                updateMessage(s, e);
            }

            realMsg.setsuccess(CmFinoFIX.Boolean_True);
            realMsg.settotal(entries.length);
		}
		if (CmFinoFIX.JSaction_Update.equals(realMsg.getaction())) {
			CMJSDCTRestrictions.CGEntries[] entries = realMsg.getEntries();

            for (CMJSDCTRestrictions.CGEntries e : entries) {
            	DCTRestrictions s = dctRestrictionsDao.getById(e.getID());

/*                // Check for Stale Data
                if (!e.getRecordVersion().equals(s.getVersion())) {
                    handleStaleDataException();
                }*/

                updateEntity(s, e);
                dctRestrictionsDao.save(s);
                updateMessage(s, e);
            }

            realMsg.setsuccess(CmFinoFIX.Boolean_True);
            realMsg.settotal(entries.length);			
		}
		if (CmFinoFIX.JSaction_Delete.equals(realMsg.getaction())) {
			CMJSDCTRestrictions.CGEntries[] entries = realMsg.getEntries();

			List<DCTRestrictions> deletedRestrictions = new ArrayList<DCTRestrictions>();
			for (CMJSDCTRestrictions.CGEntries e : entries) {
				DCTRestrictions dctRestriction = dctRestrictionsDao.getById(e.getID());
                dctRestrictionsDao.deleteById(e.getID());
                deletedRestrictions.add(dctRestriction);
            }
			
            realMsg.setsuccess(CmFinoFIX.Boolean_True);
            realMsg.settotal(entries.length);
		}
		
		log.info("DCTRestrictionsProcessor :: process END");
		return realMsg;
	}
	
	private void updateMessage(DCTRestrictions dctRestrictions, CMJSDCTRestrictions.CGEntries dctRestrictionsEntry) {
		log.info("DCTRestrictionsProcessor :: updateMessage BEGIN");
		
		dctRestrictionsEntry.setID(dctRestrictions.getID());
		
		if(null != dctRestrictions.getDistributionChainTemplateByDCTID()){
			dctRestrictionsEntry.setDCTID(dctRestrictions.getDistributionChainTemplateByDCTID().getID());
		}
		
		if(null != dctRestrictions.getTransactionType()){
			dctRestrictionsEntry.setTransactionTypeID(dctRestrictions.getTransactionType().getID());
			dctRestrictionsEntry.setServiceID(dctRestrictions.getDistributionChainTemplateByDCTID().getService().getID());
		}
		
		if(null != dctRestrictions.getIsAllowed()){
			dctRestrictionsEntry.setIsAllowed(dctRestrictions.getIsAllowed());
		}

		if(null != dctRestrictions.getRelationShipType()){
			dctRestrictionsEntry.setRelationShipType(dctRestrictions.getRelationShipType());
		}
		
		if(null != dctRestrictions.getDistributionLevel()){
			dctRestrictionsEntry.setLevel(dctRestrictions.getDistributionLevel());
		}
		
		log.info("DCTRestrictionsProcessor :: updateMessage END");
	}
	
    private void updateEntity(DCTRestrictions dctRestrictions, CMJSDCTRestrictions.CGEntries dctRestrictionsEntry) {
    	log.info("DCTRestrictionsProcessor :: updateEntity BEGIN");
    	
    	DistributionChainTemplateDAO dctDao = DAOFactory.getInstance().getDistributionChainTemplateDAO();
    	TransactionTypeDAO transactionTypeDao = DAOFactory.getInstance().getTransactionTypeDAO();
    	
        if (null != dctRestrictionsEntry.getDCTID()) {
        	DistributionChainTemplate dct = dctDao.getById(dctRestrictionsEntry.getDCTID());
        	dctRestrictions.setDistributionChainTemplateByDCTID(dct);
        }
        
        if(null != dctRestrictionsEntry.getTransactionTypeID()){
        	TransactionType transactionType = transactionTypeDao.getById(dctRestrictionsEntry.getTransactionTypeID());
        	dctRestrictions.setTransactionType(transactionType);
        }
        
        if(null != dctRestrictionsEntry.getIsAllowed()){
        	dctRestrictions.setIsAllowed(dctRestrictionsEntry.getIsAllowed());
        }
        
        if(null != dctRestrictionsEntry.getRelationShipType()){
        	dctRestrictions.setRelationShipType(dctRestrictionsEntry.getRelationShipType());
        }
        
		if(null != dctRestrictionsEntry.getLevel()){
			dctRestrictions.setDistributionLevel(dctRestrictionsEntry.getLevel());
		}
		
    	log.info("DCTRestrictionsProcessor :: updateEntity END");
    }
    
	private CFIXMsg generateError(ConstraintViolationException cvError, String errorName, String message) {
		CmFinoFIX.CMJSError errorMsg = new CmFinoFIX.CMJSError();
		CmFinoFIX.CMJSError.CGEntries[] newEntries = errorMsg.allocateEntries(1);
		newEntries[0] = new CmFinoFIX.CMJSError.CGEntries();
		errorMsg.setErrorDescription(message);
		errorMsg.setErrorCode(CmFinoFIX.ErrorCode_Generic);
		newEntries[0].setErrorName(errorName);
		newEntries[0].setErrorDescription(message);
		
		if(cvError==null){
			log.error(message);
		}else{
			log.error(message, cvError);
		}
		
		return errorMsg;
	}
}
