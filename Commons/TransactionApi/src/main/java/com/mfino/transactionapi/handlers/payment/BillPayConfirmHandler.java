/**
 * 
 */
package com.mfino.transactionapi.handlers.payment;

import com.mfino.result.Result;
import com.mfino.transactionapi.vo.TransactionDetails;

/**
 * @author Shashank
 *
 */
public interface BillPayConfirmHandler {
	public Result handle(TransactionDetails transactionDetails);
}
