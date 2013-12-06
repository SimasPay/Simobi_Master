/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mfino.dao;

import com.mfino.dao.query.CompanyQuery;
import com.mfino.domain.Company;
import com.mfino.fix.CmFinoFIX;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Diwakar
 */
public class CompanyDAO extends BaseDAO<Company> {

    public CompanyDAO() {
        super();
    }

    public List<Company> get(CompanyQuery query) {

        Criteria criteria = createCriteria();
        if (query.getId() != null) {
            criteria.add(Restrictions.eq(CmFinoFIX.CRCompany.FieldName_RecordID, query.getId()));
        }
        if (query.getCompanyCode() != null) {
            criteria.add(Restrictions.eq(CmFinoFIX.CRCompany.FieldName_CompanyCode, query.getCompanyCode()).ignoreCase());
        }
        if (query.getCompanyName() != null) {
            criteria.add(Restrictions.eq(CmFinoFIX.CRCompany.FieldName_CompanyName, query.getCompanyName()).ignoreCase());
        }
        processBaseQuery(query, criteria);

        // Paging
        processPaging(query, criteria);

        //applying Order
        criteria.addOrder(Order.desc(CmFinoFIX.CRCompany.FieldName_RecordID));
        applyOrder(query, criteria);
        @SuppressWarnings("unchecked")
        List<Company> results = criteria.list();

        return results;
    }
}
