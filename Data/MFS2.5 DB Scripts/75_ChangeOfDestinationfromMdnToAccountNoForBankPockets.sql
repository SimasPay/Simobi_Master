
use mfino;
 

INSERT INTO `pocket_template` (`Version`,`LastUpdateTime`,`UpdatedBy`,`CreateTime`,`CreatedBy`,`MSPID`,`Type`,`BankAccountCardType`,`Description`,`Commodity`,`CardPANSuffixLength`,`Units`,`Allowance`,`MaximumStoredValue`,`MinimumStoredValue`,`MaxAmountPerTransaction`,`MinAmountPerTransaction`,`MaxAmountPerDay`,`MaxAmountPerWeek`,`MaxAmountPerMonth`,`MaxTransactionsPerDay`,`MaxTransactionsPerWeek`,`MaxTransactionsPerMonth`,`MinTimeBetweenTransactions`,`BankCode`,`OperatorCode`,`BillingType`,`LowBalanceNtfcThresholdAmt`,`LowBalanceNotificationEnabled`,`WebTimeInterval`,`WebServiceTimeInterval`,`UTKTimeInterval`,`BankChannelTimeInterval`,`Denomination`,`MaxUnits`,`PocketCode`,`TypeOfCheck`,`RegularExpression`,`IsCollectorPocket`,`NumberOfPocketsAllowedForMDN`) VALUES 
(1,now(),'system',now(),'system',1,3,NULL,'BankAccount-System',4,NULL,NULL,0,'1000000000000.0000','0.0000','1000000.0000','0.0000','1000000000000.0000','1000000000000.0000','1000000000000.0000',1000000000,1000000000,1000000000,0,9999,NULL,NULL,'0.0000',0,NULL,NULL,NULL,NULL,NULL,NULL,'11',0,'',0,1000000);


INSERT INTO `subscriber`(Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, MSPID, CompanyID, ParentID, FirstName, LastName, Gender, BirthPlace, DateOfBirth, MDNBrand, Email, NotificationMethod, Language, Currency, Timezone, Restrictions, Type, Status, StatusTime, ActivationTime, ApproveOrRejectTime, ApprovedOrRejectedBy, ApproveOrRejectComment, AppliedBy, AppliedTime, DompetMerchant, UserID, SubscriberAddressID, SecurityQuestion, SecurityAnswer, PartnerType, KYCLevel, UpgradableKYCLevel, UpgradeState, IDExiparetionTime, SubscriberUserID, ReferenceAccount, AuthorizingPersonID, AliasName, DetailsRequired, RegistrationMedium, RegisteringPartnerID) VALUES (3,now(),'mfino(System)',now(),'user',1,1,0,'dummy','subscriber',NULL,NULL,NULL,NULL,'temp@temp.com',3,0,'NGN','WAT',0,1,1,now(),NULL,now(),'Approver','approved','user',now(),0,NULL,NULL,NULL,NULL,NULL,3,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL);


INSERT INTO `subscriber_mdn`(Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, SubscriberID, MDN, IMSI, MarketingCategory, IDType, IDNumber, AuthenticationPhoneNumber, Status, AuthenticationPhrase, Restrictions, WrongPINCount, DigestedPIN, MerchantDigestedPIN, MDNBrand, StatusTime, ActivationTime, LastTransactionTime, LastTransactionID, H2HAllowedIP, IsMDNRecycled, ScrambleCode, OTP, OTPExpirationTime, ApplicationID) VALUES (4,now(),'system',now(),'system',(select max(subscriber.ID) from subscriber),'2342000',NULL,NULL,NULL,NULL,NULL,1,NULL,0,0,'C22815F5149873A9C024B40C9AF35F40AAE47270450E86771ACDB3A627244282',NULL,NULL,now(),NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL);


INSERT INTO `pocket`(`Version`, `LastUpdateTime`, `UpdatedBy`, `CreateTime`, `CreatedBy`, `PocketTemplateID`, `MDNID`, `LastTransactionTime`, `CurrentBalance`, `CurrentDailyExpenditure`, `CurrentWeeklyExpenditure`, `CurrentMonthlyExpenditure`, `CurrentDailyTxnsCount`, `CurrentWeeklyTxnsCount`, `CurrentMonthlyTxnsCount`, `LastBankResponseCode`, `LastBankAuthorizationCode`, `LastBankRequestCode`, `CardPAN`, `Restrictions`, `IsDefault`, `Status`, `StatusTime`, `ActivationTime`, `OldPocketTemplateID`, `PocketTemplateChangeTime`, `PocketTemplateChangedBy`, `LowBalNotifType`, `LowBalNotifTriggerTime`, `LowBalNotifRegistered`, `LowBalNotifQueryTime`, `CompanyID`) VALUES( 1,now(),'system',now(),'system',(Select pocket_template.ID from pocket_template where description = "BankAccount-System"), (select max(subscriber_mdn.ID) from subscriber_mdn),NULL,'/YST2/P0lVQ=',0.0000,0.0000,0.0000,0,0,0,NULL,NULL,NULL,'vEwAn1V24/45VlTdPdFhWA==',0,1,1,now(),now(),NULL,NULL,NULL,NULL,NULL,NULL,NULL,1);


Insert into system_parameters(Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, ParameterName, ParameterValue, Description) values(1, now(), 'System', now(), 'system', 'platform.dummy.subscriber.mdn', 2342000, 'used by transactions if there is no destionation MDN associated with the account');

INSERT INTO `notification` (`LastUpdateTime`,`UpdatedBy`,`CreateTime`,`CreatedBy`,`Version`,`MSPID`,`Code`,`CodeName`,`NotificationMethod`,`Text`,`STKML`,`Language`,`Status`,`StatusTime`,`AccessCode`,`SMSNotificationCode`,`CompanyID`) VALUES (now(),"System",now(),"System",0,1,703,"TransferToBankAccountCompletedToSender",1,"Transaction ID: $(TransferID). Dear Customer, you have successfully transferred $(Currency) $(Amount) to Account Number $(BankAccountNumber) and  Service Charge $(Currency) $(serviceCharge).",null,0,0,now(),null,null,1);

INSERT INTO `notification` (`LastUpdateTime`,`UpdatedBy`,`CreateTime`,`CreatedBy`,`Version`,`MSPID`,`Code`,`CodeName`,`NotificationMethod`,`Text`,`STKML`,`Language`,`Status`,`StatusTime`,`AccessCode`,`SMSNotificationCode`,`CompanyID`) VALUES (now(),"System",now(),"System",0,1,703,"TransferToBankAccountCompletedToSender",2,"Transaction ID: $(TransferID). Dear Customer, you have successfully transferred $(Currency) $(Amount) to Account Number $(BankAccountNumber) and  Service Charge $(Currency) $(serviceCharge).",null,0,0,now(),null,null,1);

INSERT INTO `notification` (`LastUpdateTime`,`UpdatedBy`,`CreateTime`,`CreatedBy`,`Version`,`MSPID`,`Code`,`CodeName`,`NotificationMethod`,`Text`,`STKML`,`Language`,`Status`,`StatusTime`,`AccessCode`,`SMSNotificationCode`,`CompanyID`) VALUES (now(),"System",now(),"System",0,1,703,"TransferToBankAccountCompletedToSender",4,"Transaction ID: $(TransferID). Dear Customer, you have successfully transferred $(Currency) $(Amount) to Account Number $(BankAccountNumber) and  Service Charge $(Currency) $(serviceCharge).",null,0,0,now(),null,null,1);

INSERT INTO `notification` (`LastUpdateTime`,`UpdatedBy`,`CreateTime`,`CreatedBy`,`Version`,`MSPID`,`Code`,`CodeName`,`NotificationMethod`,`Text`,`STKML`,`Language`,`Status`,`StatusTime`,`AccessCode`,`SMSNotificationCode`,`CompanyID`) VALUES (now(),"System",now(),"System",0,1,703,"TransferToBankAccountCompletedToSender",8,"Transaction ID: $(TransferID). Dear Customer, you have successfully transferred $(Currency) $(Amount) to Account Number $(BankAccountNumber) and  Service Charge $(Currency) $(serviceCharge).",null,0,0,now(),null,null,1);

INSERT INTO `notification` (`LastUpdateTime`,`UpdatedBy`,`CreateTime`,`CreatedBy`,`Version`,`MSPID`,`Code`,`CodeName`,`NotificationMethod`,`Text`,`STKML`,`Language`,`Status`,`StatusTime`,`AccessCode`,`SMSNotificationCode`,`CompanyID`) VALUES (now(),"System",now(),"System",0,1,703,"TransferToBankAccountCompletedToSender",16,"Transaction ID: $(TransferID). Dear Customer, you have successfully transferred $(Currency) $(Amount) to Account Number $(BankAccountNumber) and  Service Charge $(Currency) $(serviceCharge).",null,0,0,now(),null,null,1);

INSERT INTO `notification` (`LastUpdateTime`,`UpdatedBy`,`CreateTime`,`CreatedBy`,`Version`,`MSPID`,`Code`,`CodeName`,`NotificationMethod`,`Text`,`STKML`,`Language`,`Status`,`StatusTime`,`AccessCode`,`SMSNotificationCode`,`CompanyID`) VALUES (now(),"System",now(),"System",0,1,704,"TransferToBankAccountCompletedToReceiver",1,"Transaction ID: $(TransferID). Dear Customer, your Account Number $(BankAccountNumber) is credited $(Currency) $(Amount) From $(SenderMDN) on $(TransactionDateTime)",null,0,0,now(),null,null,1);

INSERT INTO `notification` (`LastUpdateTime`,`UpdatedBy`,`CreateTime`,`CreatedBy`,`Version`,`MSPID`,`Code`,`CodeName`,`NotificationMethod`,`Text`,`STKML`,`Language`,`Status`,`StatusTime`,`AccessCode`,`SMSNotificationCode`,`CompanyID`) VALUES (now(),"System",now(),"System",0,1,704,"TransferToBankAccountCompletedToReceiver",2,"Transaction ID: $(TransferID). Dear Customer, your Account Number $(BankAccountNumber) is credited $(Currency) $(Amount) From $(SenderMDN) on $(TransactionDateTime)",null,0,0,now(),null,null,1);

INSERT INTO `notification` (`LastUpdateTime`,`UpdatedBy`,`CreateTime`,`CreatedBy`,`Version`,`MSPID`,`Code`,`CodeName`,`NotificationMethod`,`Text`,`STKML`,`Language`,`Status`,`StatusTime`,`AccessCode`,`SMSNotificationCode`,`CompanyID`) VALUES (now(),"System",now(),"System",0,1,704,"TransferToBankAccountCompletedToReceiver",4,"Transaction ID: $(TransferID). Dear Customer, your Account Number $(BankAccountNumber) is credited $(Currency) $(Amount) From $(SenderMDN) on $(TransactionDateTime)",null,0,0,now(),null,null,1);

INSERT INTO `notification` (`LastUpdateTime`,`UpdatedBy`,`CreateTime`,`CreatedBy`,`Version`,`MSPID`,`Code`,`CodeName`,`NotificationMethod`,`Text`,`STKML`,`Language`,`Status`,`StatusTime`,`AccessCode`,`SMSNotificationCode`,`CompanyID`) VALUES (now(),"System",now(),"System",0,1,704,"TransferToBankAccountCompletedToReceiver",8,"Transaction ID: $(TransferID). Dear Customer, your Account Number $(BankAccountNumber) is credited $(Currency) $(Amount) From $(SenderMDN) on $(TransactionDateTime)",null,0,0,now(),null,null,1);

INSERT INTO `notification` (`LastUpdateTime`,`UpdatedBy`,`CreateTime`,`CreatedBy`,`Version`,`MSPID`,`Code`,`CodeName`,`NotificationMethod`,`Text`,`STKML`,`Language`,`Status`,`StatusTime`,`AccessCode`,`SMSNotificationCode`,`CompanyID`) VALUES (now(),"System",now(),"System",0,1,704,"TransferToBankAccountCompletedToReceiver",16,"Transaction ID: $(TransferID). Dear Customer, your Account Number $(BankAccountNumber) is credited $(Currency) $(Amount) From $(SenderMDN) on $(TransactionDateTime)",null,0,0,now(),null,null,1);

update notification set Text='You requested to transfer $(Currency) $(Amount) to $(DestinationType) $(ReceiverMDN) and Service Charge $(Currency) $(serviceCharge)  ParentTransactionID $(ParentTransactionID) REF: $(TransferID)' where Code=72;
