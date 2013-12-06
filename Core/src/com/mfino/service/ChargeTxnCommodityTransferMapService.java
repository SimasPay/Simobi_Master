/**
 * 
 */
package com.mfino.service;

import java.util.List;

import com.mfino.dao.query.ChargeTxnCommodityTransferMapQuery;
import com.mfino.domain.ChargeTxnCommodityTransferMap;

/**
 * @author Sreenath
 *
 */
public interface ChargeTxnCommodityTransferMapService {
	
	/**
	 * Returns the ChargeTxnCommodityTransferMap records matching the query given
	 * @param query
	 * @return
	 */
	public List<ChargeTxnCommodityTransferMap> getChargeTxnCommodityTransferMapByQuery
	(ChargeTxnCommodityTransferMapQuery query);

}
