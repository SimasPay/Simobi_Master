/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mfino.dao;

import com.mfino.dao.query.SMSPartnerQuery;
import com.mfino.domain.SMSPartner;
import com.mfino.fix.CmFinoFIX;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Srinu
 */
public class SMSPartnerDAO extends BaseDAO<SMSPartner>{

    public List<SMSPartner> get(SMSPartnerQuery query) {
        Criteria criteria = createCriteria();

        if (query.getPartnerName() != null) {
            criteria.add(Restrictions.eq(CmFinoFIX.CRSMSPartner.FieldName_PartnerName, query.getPartnerName()).ignoreCase());
        }
       if (query.getStartDate() != null) {
            criteria.add(Restrictions.gt(CmFinoFIX.CRSMSPartner.FieldName_CreateTime, query.getStartDate()));
        }
        if (query.getEndDate() != null) {
            criteria.add(Restrictions.lt(CmFinoFIX.CRSMSPartner.FieldName_CreateTime, query.getEndDate()));
        }

        processPaging(query, criteria);
        @SuppressWarnings("unchecked")
        List<SMSPartner> results = criteria.list();

        return results;
    }

}
