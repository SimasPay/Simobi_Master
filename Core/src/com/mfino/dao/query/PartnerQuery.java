package com.mfino.dao.query;

import java.util.Date;

/**
 * @author sasidhar
 * 
 */
public class PartnerQuery extends BaseQuery {

	private Long partnerId;
	private String tradeName;
	private String authorizedEmail;
	private String partnerCode;
	private Integer partnerType;
	private Integer notPartnerType;
	private Long serviceId;
	private Long serviceProviderId;
	private Long transactionRuleId;
	private String partnerTypeSearchString;
	private Integer upgradeStateSearch;
	private String cardPAN;
	private Long subscriberID;
	private boolean partnerCodeLike;
	private Long distributionChainTemplateId;
    private Long parentId;
    private boolean firstLevelPartnerSearch;
    private String branchCode;
    private Integer branchSequence;
    private Integer businessPartnerType;
    
    private Date startRegistrationDate;
	private Date endRegistrationDate;

    


	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public Integer getBranchSequence() {
		return branchSequence;
	}

	public void setBranchSequence(Integer branchSequence) {
		this.branchSequence = branchSequence;
	}

	public Integer getBusinessPartnerType() {
		return businessPartnerType;
	}

	public void setBusinessPartnerType(Integer businessPartnerType) {
		this.businessPartnerType = businessPartnerType;
	}

	public Long getSubscriberID() {
		return subscriberID;
	}

	public void setSubscriberID(Long subscriberID) {
		this.subscriberID = subscriberID;
	}

	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}

	public Long getServiceProviderId() {
		return serviceProviderId;
	}

	public void setServiceProviderId(Long serviceProviderId) {
		this.serviceProviderId = serviceProviderId;
	}

	public Integer getPartnerType() {
		return partnerType;
	}

	public void setPartnerType(Integer partnerType) {
		this.partnerType = partnerType;
	}

	public Integer getNotPartnerType() {
		return notPartnerType;
	}

	public void setNotPartnerType(Integer notPartnerType) {
		this.notPartnerType = notPartnerType;
	}

	public String getTradeName() {
		return tradeName;
	}

	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}

	public String getAuthorizedEmail() {
		return authorizedEmail;
	}

	public void setAuthorizedEmail(String authorizedEmail) {
		this.authorizedEmail = authorizedEmail;
	}

	public String getPartnerCode() {
		return partnerCode;
	}

	public void setPartnerCode(String partnerCode) {
		this.partnerCode = partnerCode;
	}

	public Long getTransactionRuleId() {
		return transactionRuleId;
	}

	public void setTransactionRuleId(Long transactionRuleId) {
		this.transactionRuleId = transactionRuleId;
	}

	public String getPartnerTypeSearchString() {
		return partnerTypeSearchString;
	}

	public void setPartnerTypeSearchString(String partnerTypeSearchString) {
		this.partnerTypeSearchString = partnerTypeSearchString;
	}

	public void setUpgradeStateSearch(Integer upgradeStateSearch) {
		this.upgradeStateSearch = upgradeStateSearch;
	}

	public Integer getUpgradeStateSearch() {
		return upgradeStateSearch;
	}

	public String getCardPAN() {
		return cardPAN;
	}

	public void setCardPAN(String cardPAN) {
		this.cardPAN = cardPAN;
	}

	public Long getDistributionChainTemplateId() {
		return distributionChainTemplateId;
	}

	public void setDistributionChainTemplateId(Long distributionChainTemplateId) {
		this.distributionChainTemplateId = distributionChainTemplateId;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public boolean isFirstLevelPartnerSearch() {
		return firstLevelPartnerSearch;
	}

	public void setFirstLevelPartnerSearch(boolean firstLevelPartnerSearch) {
		this.firstLevelPartnerSearch = firstLevelPartnerSearch;
	}

	public Long getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(Long partnerId) {
		this.partnerId = partnerId;
	}

	public boolean isPartnerCodeLike() {
		return partnerCodeLike;
	}

	public void setPartnerCodeLike(boolean partnerCodeLike) {
		this.partnerCodeLike = partnerCodeLike;
	}
	public Date getStartRegistrationDate() {
		return startRegistrationDate;
	}

	public void setStartRegistrationDate(Date startRegistrationDate) {
		this.startRegistrationDate = startRegistrationDate;
	}

	public Date getEndRegistrationDate() {
		return endRegistrationDate;
	}

	public void setEndRegistrationDate(Date endRegistrationDate) {
		this.endRegistrationDate = endRegistrationDate;
	}
}
