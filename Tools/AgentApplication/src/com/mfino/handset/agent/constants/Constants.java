package com.mfino.handset.agent.constants;

public class Constants {

    public static final String ZEROES_STRING = "000";
    public static final String UTF_8 = "UTF-8";
    public static final String US_ASCII = "US-ASCII";
    public static final int PBE_ITERATION_COUNT = 20;
    public static final byte[] ZEROES_STRING_ENCODED = null;
    public static final String EMPTY_STRING = "";
    // services
    public static final String SERVICE_ACCOUNT = "Account";
    public static final String SERVICE_WALLET = "Wallet";
    public static final String SERVICE_BANK = "Bank";
    public static final String SERVICE_AGENT = "AgentServices";
    public static final String SERVICE_SHOPPING = "Shopping";
    // transactions
    public static final String TRANSACTION_PURCHASE_INQUIRY = "PurchaseInquiry";
    public static final String TRANSACTION_PURCHASE = "Purchase";
    public static final String TRANSACTION_ACTIVATION = "Activation";
    public static final String TRANSACTION_TRANSACTIONSTATUS = "TransactionStatus";
    public static final String TRANSACTION_CHANGEPIN = "ChangePIN";
    public static final String TRANSACTION_RESETPIN = "ResetPIN";
    public static final String TRANSACTION_AGENTACTIVATION = "AgentActivation";
    public static final String TRANSACTION_CHECKBALANCE = "CheckBalance";
    public static final String TRANSACTION_HISTORY = "History";
    public static final String TRANSACTION_TRANSFER = "Transfer";
    public static final String TRANSACTION_CASHOUT = "CashOut";
    public static final String TRANSACTION_SUBSCRIBERREGISTRATION = "SubscriberRegistration";
    public static final String TRANSACTION_CASHIN = "CashIn";
    public static final String 	TRANSACTION_AGENT_AGENT_TRANSFER_INQUIRY = "AgentToAgentTransferInquiry";
    public static final String TRANSACTION_AGENT_TO_AGENT_TRANSFER = "AgentToAgentTransfer";
    //webapi specific transactions
    public static final String TRANSACTION_LOGIN = "Login";
    public static final String TRANSACTION_LOGOUT = "Logout";
    public static final String TRANSACTION_TRANSFER_INQUIRY = "transferInquiry";
    public static final String TRANSACTION_CASHIN_INQUIRY = "CashInInquiry";
    public static final String TRANSACTION_CASHOUT_INQUIRY = "CashOutInquiry";
    //parameters
    public static final String PARAMETER_SERVICE_NAME = "service";
    public static final String PARAMETER_TRANSACTIONNAME = "txnName";
    public static final String PARAMETER_SOURCE_MDN = "sourceMDN";
    public static final String PARAMETER_NEW_PIN = "newPIN";
    public static final String PARAMETER_OTP = "otp";
    public static final String PARAMETER_ACTIVATION_NEWPIN = "activationNewPin";
    public static final String PARAMETER_ACTIVATION_CONFIRMPIN = "activationConfirmPin";
    public static final String PARAMETER_CHANNEL_ID = "channelID";
    public static final String PARAMETER_CONFIRM_PIN = "confirmPIN";
    public static final String PARAMETER_SOURCE_PIN = "sourcePIN";
    public static final String PARAMETER_TRANSACTIONID = "transactionID";
    public static final String PARAMETER_DEST_MDN = "destMDN";
    public static final String PARAMETER_AMOUNT = "amount";
    public static final String PARAMETER_OLD_PIN = "oldPIN";
    public static final String PARAMETER_SECRET_ANSWER = "secretAnswer";
    public static final String PARAMETER_CONTACT_NO = "contactNumber";
    public static final String PARAMETER_EMAIL = "email";
    public static final String PARAMETER_LANG = "language";
    public static final String PARAMETER_NOTIFICATION_METHOD = "notificationMethod";
    public static final String PARAMETER_PARTNER_CODE = "partnerCode";
    public static final String PARAMETER_AGENT_CODE = "agentCode";
    public static final String PARAMETER_BUCKET_TYPE = "bucketType";
    public static final String PARAMETER_SRC_POCKET_CODE = "sourcePocketCode";
    public static final String PARAMETER_CARDPAN_SUFFIX = "cardPANSuffix";
    public static final String PARAMETER_SRC_MESSAGE = "sourceMessage";
    public static final String PARAMETER_DEST_POCKET_CODE = "destPocketCode";
    public static final String PARAMETER_TRANSFER_ID = "transferID";
    public static final String PARAMETER_CONFIRMED = "confirmed";
    public static final String PARAMETER_PARENTTXN_ID = "parentTxnID";
    public static final String PARAMETER_ISDEFAULT = "isDefault";
    public static final String PARAMETER_BANK_ID = "bankID";
    public static final String PARAMETER_BILLER_NAME = "billerName";
    public static final String PARAMETER_CUSTOMER_ID = "customerID";
    public static final String PARAMETER_BILL_DETAILS = "billDetails";
    public static final String PARAMETER_DATA = "data";
    public static final String PARAMETER_MFS_BILLER_CODE = "mfsBillerCode";
    public static final String PARAMETER_INVOICE_NO = "invoiceNo";
    public static final String PARAMETER_SUB_MDN = "subMDN";
    public static final String PARAMETER_SUB_FIRSTNAME = "subFirstName";
    public static final String PARAMETER_SUB_LASTNAME = "subLastName";
    public static final String PARAMETER_ACCOUNT_TYPE = "accountType";
    public static final String PARAMETER_APPLICATION_ID = "appId";
    public static final String PARAMETER_DOB = "dob";
    public static final String PARAMETER_SALT = "salt";
    public static final String PARAMETER_AUTHENTICATION_STRING = "authenticationString";
    public static final String MESSAGE_MOBILE_TRANSFER = "Mobile Transfer";
    public static final String DUMMY_BANK_ID = "Not Yet";
    public static final String CONSTANT_VALUE_ZERO = "0";
    public static final String CONSTANT_VALUE_TRUE = "true";
    public static final String SERVICE_PROVIDER_NAME = "serviceProviderName";
    public static final String CONSTANT_VALUE_FALSE = "false";
    public static final String CONSTANT_CHANNEL_ID = "7";
    public static final String CONSTANT_EMONEY = "EMoney";
    public static final String CONSTANT_BANK = "Bank";
    public static final int COLOUR_GRAY = 0xB5B5B5;
    public static final int COLOUR_SLATEGRAY = 0x9FB6CD;
    public static final String XML_MESSAGE = "message";
    public static final String XML_TRANSACTION_TIME = "transactionTime";
    public static final String XML_REFID = "refID";
    public static final String XML_TRANSFERID = "transferID";
    public static final String XML_PARENT_TXNID = "parentTxnID";
    public static final String XML_INPUT = "input";
    public static final String XML_NAME = "name";
    public static final String XML_VALUE = "value";
    public static final String XML_AMOUNT = "amount";
    public static final String XML_BILL_DETAILS = "billDetails";
    public static final String XML_KEY = "key";
    public static final String XML_SALT = "salt";
    public static final String XML_AUTHENTICATION = "authentication";
    public static final String XML_TRANSACTION_CHARGES = "charges";
    public static final String XML_DEBIT_AMOUNT = "debitamt";
    public static final String XML_CREDIT_AMOUNT = "creditamt";
    
    //NOTIFICATIONS
    public static final String NOTIFICATIONCODE_INQUIRY_SUCCESS = "72";
    public static final String NOTIFICATIONCODE_WRONGPINSPECIFIED = "29";
    
    public static final int FIELD_LENGTH_DOB = 10;
    public static final int FIELD_LENGTH_AMOUNT = 8;
    public static final int FIELD_LENGTH_FIRSTNAME = 16;
    public static final int FIELD_LENGTH_LASTNAME = 16;
    public static final int FIELD_LENGTH_PIN = 4;
    public static final int FIELD_LENGTH_MOBIILENO = 13;
    public static final int FIELD_LENGTH_APPID = 16;
    public static final int FIELD_LENGTH_AGENTCODE = 20;
    public static final int FIELD_LENGTH_BILLERCODE = 20;
    public static final int FIELD_LENGTH_BILLNO = 30;
    
    public static final String POCKET_CODE_EMONEY = "1";
    public static final String POCKET_CODE_BANK = "2";
}
