/**
 * 
 */
package com.mfino.service;

import java.util.List;

import com.mfino.dao.query.ClosedAccountSettlementMDNQuery;
import com.mfino.domain.CloseAcctSetlMdn;

/**
 * @author Sreenath
 *
 */
public interface ClosedAccountSettlementMDNService {
	/**
	 * Returns the list of records from ClosedAccountSettlementMDN table satisfying the query inputs
	 * @param casmQuery
	 * @return
	 */
	public List<CloseAcctSetlMdn> getClosedAccountSettlementMDNByQuery(
			ClosedAccountSettlementMDNQuery casmQuery);

	/**
	 * Saves the closedAccountSettlementMDN record into the database
	 * @param closedAccountSettlementMDN
	 */
	public void saveClosedAccountSettlementMDN(CloseAcctSetlMdn closedAccountSettlementMDN);

}
