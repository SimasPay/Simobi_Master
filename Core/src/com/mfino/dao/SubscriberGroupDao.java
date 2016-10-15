package com.mfino.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.mfino.domain.SubscriberGroups;

/**
 * 
 * @author Sasi
 *
 */
public class SubscriberGroupDao extends BaseDAO<SubscriberGroups>{
	public SubscriberGroups getBySubscriberID(Long subscriberID) {
        Criteria criteria = createCriteria();
        criteria.add(Restrictions.eq(SubscriberGroups.FieldName_Subscriber, subscriberID));
        @SuppressWarnings("unchecked")
		List<SubscriberGroups> lst = criteria.list();
		if(criteria.list()==null||criteria.list().isEmpty())
			return null;
		return lst.get(0);
    }
	
	public List<SubscriberGroups> getAllBySubscriberID(BigDecimal subscriberID) {
        Criteria criteria = createCriteria();
        criteria.add(Restrictions.eq(SubscriberGroups.FieldName_Subscriber, subscriberID.longValue()));
        @SuppressWarnings("unchecked")
		List<SubscriberGroups> lst = criteria.list();
		if(criteria.list()==null||criteria.list().isEmpty())
			return null;
		return lst;
    }
}
