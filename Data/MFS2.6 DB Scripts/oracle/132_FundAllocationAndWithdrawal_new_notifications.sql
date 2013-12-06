Delete from notification where code = 824;
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (sysdate,'System',sysdate,'System',0,1,824,'FundAllocationReversalToSender',1,'Transaction ID: $(TransferID). The allocated fund with TransactionID: $(ParentTransactionID) to $(OnBehalfOfMDN) has been reversed to the $(ReceiverMDN) pocket with amount $(Currency) $(Amount).',null,0,0,sysdate,null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (sysdate,'System',sysdate,'System',0,1,824,'FundAllocationReversalToSender',2,'Transaction ID: $(TransferID). The allocated fund with TransactionID: $(ParentTransactionID) to $(OnBehalfOfMDN) has been reversed to the $(ReceiverMDN) pocket with amount $(Currency) $(Amount).',null,0,0,sysdate,null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (sysdate,'System',sysdate,'System',0,1,824,'FundAllocationReversalToSender',4,'Transaction ID: $(TransferID). The allocated fund with TransactionID: $(ParentTransactionID) to $(OnBehalfOfMDN) has been reversed to the $(ReceiverMDN) pocket with amount $(Currency) $(Amount).',null,0,0,sysdate,null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (sysdate,'System',sysdate,'System',0,1,824,'FundAllocationReversalToSender',8,'Transaction ID: $(TransferID). The allocated fund with TransactionID: $(ParentTransactionID) to $(OnBehalfOfMDN) has been reversed to the $(ReceiverMDN) pocket with amount $(Currency) $(Amount).',null,0,0,sysdate,null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (sysdate,'System',sysdate,'System',0,1,824,'FundAllocationReversalToSender',16,'Transaction ID: $(TransferID). The allocated fund with TransactionID: $(ParentTransactionID) to $(OnBehalfOfMDN) has been reversed to the $(ReceiverMDN) pocket with amount $(Currency) $(Amount).',null,0,0,sysdate,null,null,1);

Delete from notification where code = 825;
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (sysdate,'System',sysdate,'System',0,1,825,'FundAllocationReversalToOnBehalfOfMDN',1,'Transaction ID: $(TransferID). The allocated fund for you with TransactionID: $(ParentTransactionID) from $(ReceiverMDN) has been reversed to the source pocket.',null,0,0,sysdate,null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (sysdate,'System',sysdate,'System',0,1,825,'FundAllocationReversalToOnBehalfOfMDN',2,'Transaction ID: $(TransferID). The allocated fund for you with TransactionID: $(ParentTransactionID) from $(ReceiverMDN) has been reversed to the source pocket.',null,0,0,sysdate,null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (sysdate,'System',sysdate,'System',0,1,825,'FundAllocationReversalToOnBehalfOfMDN',4,'Transaction ID: $(TransferID). The allocated fund for you with TransactionID: $(ParentTransactionID) from $(ReceiverMDN) has been reversed to the source pocket.',null,0,0,sysdate,null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (sysdate,'System',sysdate,'System',0,1,825,'FundAllocationReversalToOnBehalfOfMDN',8,'Transaction ID: $(TransferID). The allocated fund for you with TransactionID: $(ParentTransactionID) from $(ReceiverMDN) has been reversed to the source pocket.',null,0,0,sysdate,null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (sysdate,'System',sysdate,'System',0,1,825,'FundAllocationReversalToOnBehalfOfMDN',16,'Transaction ID: $(TransferID). The allocated fund for you with TransactionID: $(ParentTransactionID) from $(ReceiverMDN) has been reversed to the source pocket.',null,0,0,sysdate,null,null,1);

Delete from notification where code = 826;
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (sysdate,'System',sysdate,'System',0,1,826,'FundCompleteWithdrawalConfirmedToMerchant',1,'Transaction ID: $(TransferID). You have a successfull payment from customer $(OnBehalfOfMDN) with $(Currency) $(Amount) on $(TransactionDateTime)',null,0,0,sysdate,null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (sysdate,'System',sysdate,'System',0,1,826,'FundCompleteWithdrawalConfirmedToMerchant',2,'Transaction ID: $(TransferID). You have a successfull payment from customer $(OnBehalfOfMDN) with $(Currency) $(Amount) on $(TransactionDateTime)',null,0,0,sysdate,null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (sysdate,'System',sysdate,'System',0,1,826,'FundCompleteWithdrawalConfirmedToMerchant',4,'Transaction ID: $(TransferID). You have a successfull payment from customer $(OnBehalfOfMDN) with $(Currency) $(Amount) on $(TransactionDateTime)',null,0,0,sysdate,null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (sysdate,'System',sysdate,'System',0,1,826,'FundCompleteWithdrawalConfirmedToMerchant',8,'Transaction ID: $(TransferID). You have a successfull payment from customer $(OnBehalfOfMDN) with $(Currency) $(Amount) on $(TransactionDateTime)',null,0,0,sysdate,null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (sysdate,'System',sysdate,'System',0,1,826,'FundCompleteWithdrawalConfirmedToMerchant',16,'Transaction ID: $(TransferID). You have a successfull payment from customer $(OnBehalfOfMDN) with $(Currency) $(Amount) on $(TransactionDateTime)',null,0,0,sysdate,null,null,1);

Delete from notification where code = 827;
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (sysdate,'System',sysdate,'System',0,1,827,'FundCompleteWithdrawalConfirmedToOnBehalfOfMDN',1,'Transaction ID: $(TransferID). Your Fund Withdrawal request for amount $(Currency) $(Amount) is successful with Service Charge $(Currency) $(serviceCharge).The complete fund has been withdrawn.',null,0,0,sysdate,null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (sysdate,'System',sysdate,'System',0,1,827,'FundCompleteWithdrawalConfirmedToOnBehalfOfMDN',2,'Transaction ID: $(TransferID). Your Fund Withdrawal request for amount $(Currency) $(Amount) is successful with Service Charge $(Currency) $(serviceCharge).The complete fund has been withdrawn.',null,0,0,sysdate,null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (sysdate,'System',sysdate,'System',0,1,827,'FundCompleteWithdrawalConfirmedToOnBehalfOfMDN',4,'Transaction ID: $(TransferID). Your Fund Withdrawal request for amount $(Currency) $(Amount) is successful with Service Charge $(Currency) $(serviceCharge).The complete fund has been withdrawn.',null,0,0,sysdate,null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (sysdate,'System',sysdate,'System',0,1,827,'FundCompleteWithdrawalConfirmedToOnBehalfOfMDN',8,'Transaction ID: $(TransferID). Your Fund Withdrawal request for amount $(Currency) $(Amount) is successful with Service Charge $(Currency) $(serviceCharge).The complete fund has been withdrawn.',null,0,0,sysdate,null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (sysdate,'System',sysdate,'System',0,1,827,'FundCompleteWithdrawalConfirmedToOnBehalfOfMDN',16,'Transaction ID: $(TransferID). Your Fund Withdrawal request for amount $(Currency) $(Amount) is successful with Service Charge $(Currency) $(serviceCharge).The complete fund has been withdrawn.',null,0,0,sysdate,null,null,1);

Delete from notification where code = 828;
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (sysdate,'System',sysdate,'System',0,1,828,'FundAllocationReversalToReceiver',1,'Transaction ID: $(TransferID). The allocated fund with TransactionID: $(ParentTransactionID) to $(OnBehalfOfMDN) has been reversed to the your pocket with amount $(Currency) $(Amount)',null,0,0,sysdate,null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (sysdate,'System',sysdate,'System',0,1,828,'FundAllocationReversalToReceiver',2,'Transaction ID: $(TransferID). The allocated fund with TransactionID: $(ParentTransactionID) to $(OnBehalfOfMDN) has been reversed to the your pocket with amount $(Currency) $(Amount)',null,0,0,sysdate,null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (sysdate,'System',sysdate,'System',0,1,828,'FundAllocationReversalToReceiver',4,'Transaction ID: $(TransferID). The allocated fund with TransactionID: $(ParentTransactionID) to $(OnBehalfOfMDN) has been reversed to the your pocket with amount $(Currency) $(Amount)',null,0,0,sysdate,null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (sysdate,'System',sysdate,'System',0,1,828,'FundAllocationReversalToReceiver',8,'Transaction ID: $(TransferID). The allocated fund with TransactionID: $(ParentTransactionID) to $(OnBehalfOfMDN) has been reversed to the your pocket with amount $(Currency) $(Amount)',null,0,0,sysdate,null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (sysdate,'System',sysdate,'System',0,1,828,'FundAllocationReversalToReceiver',16,'Transaction ID: $(TransferID). The allocated fund with TransactionID: $(ParentTransactionID) to $(OnBehalfOfMDN) has been reversed to the your pocket with amount $(Currency) $(Amount)',null,0,0,sysdate,null,null,1);

Delete from notification where code = 829;
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (sysdate,'System',sysdate,'System',0,1,829,'FundWithdrawalFailedToMerchant',1,'Sorry the fund withdrawal transaction has failed.',null,0,0,sysdate,null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (sysdate,'System',sysdate,'System',0,1,829,'FundWithdrawalFailedToMerchant',2,'Sorry the fund withdrawal transaction has failed.',null,0,0,sysdate,null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (sysdate,'System',sysdate,'System',0,1,829,'FundWithdrawalFailedToMerchant',4,'Sorry the fund withdrawal transaction has failed.',null,0,0,sysdate,null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (sysdate,'System',sysdate,'System',0,1,829,'FundWithdrawalFailedToMerchant',8,'Sorry the fund withdrawal transaction has failed.',null,0,0,sysdate,null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (sysdate,'System',sysdate,'System',0,1,829,'FundWithdrawalFailedToMerchant',16,'Sorry the fund withdrawal transaction has failed.',null,0,0,sysdate,null,null,1);

commit;