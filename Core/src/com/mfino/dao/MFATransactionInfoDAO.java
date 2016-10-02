package com.mfino.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.mfino.dao.query.MFATransactionInfoQuery;
import com.mfino.domain.ChannelCode;
import com.mfino.domain.MFATransactionInfo;
import com.mfino.domain.Service;
import com.mfino.domain.TransactionType;

public class MFATransactionInfoDAO extends BaseDAO<MFATransactionInfo> {
	public List<MFATransactionInfo> get(MFATransactionInfoQuery query){
		Criteria criteria = createCriteria();
		if (query.getServiceId() != null ) {
			criteria.createAlias(MFATransactionInfo.FieldName_Service, "s");
			criteria.add(Restrictions.eq("s." + Service.FieldName_RecordID, query.getServiceId()));
		}		
		if (query.getTransactionTypeId() != null) {
			criteria.createAlias(MFATransactionInfo.FieldName_TransactionType, "tt");
			criteria.add(Restrictions.eq("tt."+TransactionType.FieldName_RecordID, query.getTransactionTypeId()));
		}
		if (query.getChannelCodeId() != null) {
			criteria.createAlias(MFATransactionInfo.FieldName_ChannelCode, "cc");
			criteria.add(Restrictions.eq("cc."+ChannelCode.FieldName_RecordID, query.getChannelCodeId()));
		}
		if(query.getMfaMode()!=null){
			criteria.add(Restrictions.eq(MFATransactionInfo.FieldName_MFAMode, query.getMfaMode()));
		}
		
		
		processBaseQuery(query, criteria);
		processPaging(query, criteria);
		
		@SuppressWarnings("unchecked")
		List<MFATransactionInfo> results = criteria.list();
		return results;
	}
}
