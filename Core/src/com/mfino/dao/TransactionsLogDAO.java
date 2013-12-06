/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mfino.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.mfino.dao.query.TransactionsLogQuery;
import com.mfino.domain.TransactionsLog;
import com.mfino.domain.mFinoServiceProvider;
import com.mfino.fix.CmFinoFIX;

/**
 *
 * @author Venkata Krishna Teja D
 */
public class TransactionsLogDAO extends BaseDAO<TransactionsLog> {

    public List<TransactionsLog> get(TransactionsLogQuery query) {
        Criteria criteria = createCriteria();

        if(null != query.getId()) {
            criteria.add(Restrictions.eq(CmFinoFIX.CRTransactionsLog.FieldName_RecordID, query.getId()));
        }

        if (query.getCreateTimeGE() != null) {
            criteria.add(Restrictions.gt(CmFinoFIX.CRTransactionsLog.FieldName_TransactionTime, query.getCreateTimeGE()));
        }
        if (query.getCreateTimeLT() != null) {
            criteria.add(Restrictions.lt(CmFinoFIX.CRTransactionsLog.FieldName_TransactionTime, query.getCreateTimeLT()));
        }

        if(Boolean.TRUE == query.isTransactionsWithNullParentTxnIdSearch()) {
            criteria.add(Restrictions.isNull(CmFinoFIX.CRTransactionsLog.FieldName_ParentTransactionID));
        }

        if (null != query.getParentTransactionId()) {
            criteria.add(Restrictions.eq(CmFinoFIX.CRTransactionsLog.FieldName_ParentTransactionID, query.getParentTransactionId()));
        }

        criteria.addOrder(Order.asc(CmFinoFIX.CRTransactionsLog.FieldName_CreateTime));

        processBaseQuery(query, criteria);
        processPaging(query, criteria);
        @SuppressWarnings("unchecked")
        List<TransactionsLog> results = criteria.list();

        return results;
    }
    
    public int getAllTxnCountBetween(Date start, Date end) {
      Criteria criteria = createCriteria();
      criteria.add(Restrictions.ge(CmFinoFIX.CRTransactionsLog.FieldName_CreateTime, start));
      criteria.add(Restrictions.lt(CmFinoFIX.CRTransactionsLog.FieldName_CreateTime, end));
      criteria.setProjection(Projections.rowCount());
      Integer count = (Integer) criteria.uniqueResult();
      return count;
    }
    
    @Override
    public void save(TransactionsLog tl) {
        if (tl.getmFinoServiceProviderByMSPID() == null) {
            MfinoServiceProviderDAO mspDao = DAOFactory.getInstance().getMfinoServiceProviderDAO();
            mFinoServiceProvider msp = mspDao.getById(1);
            tl.setmFinoServiceProviderByMSPID(msp);
        }
        super.save(tl);
    }
}
