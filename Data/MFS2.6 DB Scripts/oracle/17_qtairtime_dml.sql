
delete from system_parameters where parametername like 'profile';

delete from notification where code in (713, 714, 715);

INSERT INTO system_parameters (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, ParameterName, ParameterValue, Description) VALUES (1,sysdate,'System',sysdate,'system','profile','gtbank','profile');

INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (sysdate,'System',sysdate,'System',0,1,713,'BillpaymentInquirySuccessful',1,'You requested to top up $(ReceiverMDN) from $(BillerCode) with $(Currency) $(Amount), ServiceCharge $(Currency) $(serviceCharge). ParentTransactionID  $(ParentTransactionID) REF: $(TransferID)',null,0,0,sysdate,null,null,1);

INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (sysdate,'System',sysdate,'System',0,1,713,'BillpaymentInquirySuccessful',2,'You requested to top up $(ReceiverMDN) from $(BillerCode) with $(Currency) $(Amount), ServiceCharge $(Currency) $(serviceCharge). ParentTransactionID  $(ParentTransactionID) REF: $(TransferID)',null,0,0,sysdate,null,null,1);

INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (sysdate,'System',sysdate,'System',0,1,713,'BillpaymentInquirySuccessful',4,'You requested to top up $(ReceiverMDN) from $(BillerCode) with $(Currency) $(Amount), ServiceCharge $(Currency) $(serviceCharge). ParentTransactionID  $(ParentTransactionID) REF: $(TransferID)',null,0,0,sysdate,null,null,1);

INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (sysdate,'System',sysdate,'System',0,1,713,'BillpaymentInquirySuccessful',8,'You requested to top up $(ReceiverMDN) from $(BillerCode) with $(Currency) $(Amount), ServiceCharge $(Currency) $(serviceCharge). ParentTransactionID  $(ParentTransactionID) REF: $(TransferID)',null,0,0,sysdate,null,null,1);

INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (sysdate,'System',sysdate,'System',0,1,713,'BillpaymentInquirySuccessful',16,'You requested to top up $(ReceiverMDN) from $(BillerCode) with $(Currency) $(Amount), ServiceCharge $(Currency) $(serviceCharge). ParentTransactionID  $(ParentTransactionID) REF: $(TransferID)',null,0,0,sysdate,null,null,1);

INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (sysdate,'System',sysdate,'System',0,1,714,'BillpaymentFailed',1,'Your request to top up $(ReceiverMDN) from $(BillerCode) with $(Currency) $(Amount) failed, Please try again later. ParentTransactionID  $(ParentTransactionID) REF: $(TransferID)',null,0,0,sysdate,null,null,1);

INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (sysdate,'System',sysdate,'System',0,1,714,'BillpaymentFailed',2,'Your request to top up $(ReceiverMDN) from $(BillerCode) with $(Currency) $(Amount) failed, Please try again later. ParentTransactionID  $(ParentTransactionID) REF: $(TransferID)',null,0,0,sysdate,null,null,1);

INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (sysdate,'System',sysdate,'System',0,1,714,'BillpaymentFailed',4,'Your request to top up $(ReceiverMDN) from $(BillerCode) with $(Currency) $(Amount) failed, Please try again later. ParentTransactionID  $(ParentTransactionID) REF: $(TransferID)',null,0,0,sysdate,null,null,1);

INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (sysdate,'System',sysdate,'System',0,1,714,'BillpaymentFailed',8,'Your request to top up $(ReceiverMDN) from $(BillerCode) with $(Currency) $(Amount) failed, Please try again later. ParentTransactionID  $(ParentTransactionID) REF: $(TransferID)',null,0,0,sysdate,null,null,1);

INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (sysdate,'System',sysdate,'System',0,1,714,'BillpaymentFailed',16,'Your request to top up $(ReceiverMDN) from $(BillerCode) with $(Currency) $(Amount) failed, Please try again later. ParentTransactionID  $(ParentTransactionID) REF: $(TransferID)',null,0,0,sysdate,null,null,1);

INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (sysdate,'System',sysdate,'System',0,1,715,'BillpaymentConfirmationSuccessful',1,'Your top up request for $(ReceiverMDN) from $(BillerCode) with $(Currency) $(Amount), ServiceCharge $(Currency) $(serviceCharge) is successful. REF: $(TransferID)',null,0,0,sysdate,null,null,1);

INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (sysdate,'System',sysdate,'System',0,1,715,'BillpaymentConfirmationSuccessful',2,'Your top up request for $(ReceiverMDN) from $(BillerCode) with $(Currency) $(Amount), ServiceCharge $(Currency) $(serviceCharge) is successful. REF: $(TransferID)',null,0,0,sysdate,null,null,1);

INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (sysdate,'System',sysdate,'System',0,1,715,'BillpaymentConfirmationSuccessful',4,'Your top up request for $(ReceiverMDN) from $(BillerCode) with $(Currency) $(Amount), ServiceCharge $(Currency) $(serviceCharge) is successful. REF: $(TransferID)',null,0,0,sysdate,null,null,1);

INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (sysdate,'System',sysdate,'System',0,1,715,'BillpaymentConfirmationSuccessful',8,'Your top up request for $(ReceiverMDN) from $(BillerCode) with $(Currency) $(Amount), ServiceCharge $(Currency) $(serviceCharge) is successful. REF: $(TransferID)',null,0,0,sysdate,null,null,1);

INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (sysdate,'System',sysdate,'System',0,1,715,'BillpaymentConfirmationSuccessful',16,'Your top up request for $(ReceiverMDN) from $(BillerCode) with $(Currency) $(Amount), ServiceCharge $(Currency) $(serviceCharge) is successful. REF: $(TransferID)',null,0,0,sysdate,null,null,1);

COMMIT;