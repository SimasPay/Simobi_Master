/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package com.mfino.uicore.fix.processor;

import java.util.List;

import com.mfino.dao.query.SubscriberMdnQuery;
import com.mfino.domain.SubscriberMDN;
import com.mfino.fix.processor.IFixProcessor;

/**
 *
 * @author sunil
 */
public interface SubscriberMdnProcessor extends IFixProcessor {
	public List<SubscriberMDN> get(SubscriberMdnQuery query);

}
