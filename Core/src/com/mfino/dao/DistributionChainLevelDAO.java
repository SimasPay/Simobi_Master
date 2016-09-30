/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mfino.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.mfino.constants.DAOConstants;
import com.mfino.dao.query.DistributionChainLevelQuery;
import com.mfino.domain.Base;
import com.mfino.domain.DistributionChainLevel;
import com.mfino.domain.DistributionChainTemplate;

/**
 *
 * @author xchen
 */
public class DistributionChainLevelDAO extends BaseDAO<DistributionChainLevel> {

    public List<DistributionChainLevel> get(DistributionChainLevelQuery query) {

        Criteria criteria = createCriteria();

        if (query.getId() != null) {
            criteria.add(Restrictions.eq(Base.FieldName_RecordID, query.getId()));
        }

        if (query.getDistributionChainTemplateID() != null) {
            final String templateNameAlias = DistributionChainLevel.FieldName_DistributionChainTemplateByTemplateID + DAOConstants.ALIAS_SUFFIX;
            criteria.createAlias(DistributionChainLevel.FieldName_DistributionChainTemplateByTemplateID, templateNameAlias);
            criteria.add(Restrictions.eq(templateNameAlias + DAOConstants.ALIAS_COLNAME_SEPARATOR + DistributionChainTemplate.FieldName_RecordID,
                    query.getDistributionChainTemplateID()));
        }

        if (query.getLevel() != null) {
            criteria.add(Restrictions.eq(DistributionChainLevel.FieldName_DistributionLevel, query.getLevel()));
        }

        processBaseQuery(query, criteria);
        // Paging
        processPaging(query, criteria);
        //applying Order
        applyOrder(query, criteria);
        @SuppressWarnings("unchecked")
        List<DistributionChainLevel> results = criteria.list();

        return results;
    }
}
