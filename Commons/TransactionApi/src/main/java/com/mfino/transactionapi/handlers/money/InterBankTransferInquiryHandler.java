/**
 * 
 */
package com.mfino.transactionapi.handlers.money;

import com.mfino.result.Result;
import com.mfino.transactionapi.vo.TransactionDetails;

/**
 * @author Shashank
 *
 */
public interface InterBankTransferInquiryHandler {

	Result handle(TransactionDetails transactionDetails);

}
