

-- Define the Max value for CashOut At ATM system parameter
Delete from system_parameters where ParameterName = 'maximum.value.of.cashout.at.atm';
INSERT INTO system_parameters (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, ParameterName, ParameterValue, Description) VALUES (1,now(),'System',now(),'system','maximum.value.of.cashout.at.atm','2500','Maximum amount for Cashout At ATM');

-- Inserting Enum_text data
delete from enum_text where TagID=5636 and EnumCode='53';
INSERT INTO enum_text (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, LANGUAGE, TagName, TagID, EnumCode, EnumValue, DisplayText) VALUES ('1',now(),'system',now(),'system','0','TransactionUICategory','5636','53','Reverse_From_ATM','Reverse From ATM');

-- Inserting Notification messages

Delete from notification where Code = 748;
INSERT INTO notification (LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Version, MSPID, Code, CodeName ,NotificationMethod, Text, STKML, Language, Status, StatusTime, AccessCode, SMSNotificationCode, CompanyID) VALUES (now(),'System',now(),'System',0,1,748,'SuccessfulReversalFromATM',1,'Cash out for amount $(Currency) $(Amount) from ATM has been Reversed.',null,0,0,now(),null,null,1);
INSERT INTO notification (LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Version, MSPID, Code, CodeName ,NotificationMethod, Text, STKML, Language, Status, StatusTime, AccessCode, SMSNotificationCode, CompanyID) VALUES (now(),'System',now(),'System',0,1,748,'SuccessfulReversalFromATM',2,'Cash out for amount $(Currency) $(Amount) from ATM has been Reversed.',null,0,0,now(),null,null,1);
INSERT INTO notification (LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Version, MSPID, Code, CodeName ,NotificationMethod, Text, STKML, Language, Status, StatusTime, AccessCode, SMSNotificationCode, CompanyID) VALUES (now(),'System',now(),'System',0,1,748,'SuccessfulReversalFromATM',4,'Cash out for amount $(Currency) $(Amount) from ATM has been Reversed.',null,0,0,now(),null,null,1);
INSERT INTO notification (LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Version, MSPID, Code, CodeName ,NotificationMethod, Text, STKML, Language, Status, StatusTime, AccessCode, SMSNotificationCode, CompanyID) VALUES (now(),'System',now(),'System',0,1,748,'SuccessfulReversalFromATM',8,'Cash out for amount $(Currency) $(Amount) from ATM has been Reversed.',null,0,0,now(),null,null,1);
INSERT INTO notification (LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Version, MSPID, Code, CodeName ,NotificationMethod, Text, STKML, Language, Status, StatusTime, AccessCode, SMSNotificationCode, CompanyID) VALUES (now(),'System',now(),'System',0,1,748,'SuccessfulReversalFromATM',16,'Cash out for amount $(Currency) $(Amount) from ATM has been Reversed.',null,0,0,now(),null,null,1);

Delete from notification where Code = 749;
INSERT INTO notification (LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Version, MSPID, Code, CodeName ,NotificationMethod, Text, STKML, Language, Status, StatusTime, AccessCode, SMSNotificationCode, CompanyID) VALUES (now(),'System',now(),'System',0,1,749,'FailedReversalFromATM',1,'Cash out for amount $(Currency) $(Amount) from ATM has not processed. Please Contact Administrator',null,0,0,now(),null,null,1);
INSERT INTO notification (LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Version, MSPID, Code, CodeName ,NotificationMethod, Text, STKML, Language, Status, StatusTime, AccessCode, SMSNotificationCode, CompanyID) VALUES (now(),'System',now(),'System',0,1,749,'FailedReversalFromATM',2,'Cash out for amount $(Currency) $(Amount) from ATM has not processed. Please Contact Administrator',null,0,0,now(),null,null,1);
INSERT INTO notification (LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Version, MSPID, Code, CodeName ,NotificationMethod, Text, STKML, Language, Status, StatusTime, AccessCode, SMSNotificationCode, CompanyID) VALUES (now(),'System',now(),'System',0,1,749,'FailedReversalFromATM',4,'Cash out for amount $(Currency) $(Amount) from ATM has not processed. Please Contact Administrator',null,0,0,now(),null,null,1);
INSERT INTO notification (LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Version, MSPID, Code, CodeName ,NotificationMethod, Text, STKML, Language, Status, StatusTime, AccessCode, SMSNotificationCode, CompanyID) VALUES (now(),'System',now(),'System',0,1,749,'FailedReversalFromATM',8,'Cash out for amount $(Currency) $(Amount) from ATM has not processed. Please Contact Administrator',null,0,0,now(),null,null,1);
INSERT INTO notification (LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Version, MSPID, Code, CodeName ,NotificationMethod, Text, STKML, Language, Status, StatusTime, AccessCode, SMSNotificationCode, CompanyID) VALUES (now(),'System',now(),'System',0,1,749,'FailedReversalFromATM',16,'Cash out for amount $(Currency) $(Amount) from ATM has not processed. Please Contact Administrator',null,0,0,now(),null,null,1);

Delete from notification where Code = 750;
INSERT INTO notification (LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Version, MSPID, Code, CodeName ,NotificationMethod, Text, STKML, Language, Status, StatusTime, AccessCode, SMSNotificationCode, CompanyID) VALUES (now(),'System',now(),'System',0,1,750,'MaxValueOfCashOutAtATM',1,'Dear Customer, you can cash out from ATM only $(Currency) $(maxAmount).',null,0,0,now(),null,null,1);
INSERT INTO notification (LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Version, MSPID, Code, CodeName ,NotificationMethod, Text, STKML, Language, Status, StatusTime, AccessCode, SMSNotificationCode, CompanyID) VALUES (now(),'System',now(),'System',0,1,750,'MaxValueOfCashOutAtATM',2,'Dear Customer, you can cash out from ATM only $(Currency) $(maxAmount).',null,0,0,now(),null,null,1);
INSERT INTO notification (LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Version, MSPID, Code, CodeName ,NotificationMethod, Text, STKML, Language, Status, StatusTime, AccessCode, SMSNotificationCode, CompanyID) VALUES (now(),'System',now(),'System',0,1,750,'MaxValueOfCashOutAtATM',4,'Dear Customer, you can cash out from ATM only $(Currency) $(maxAmount).',null,0,0,now(),null,null,1);
INSERT INTO notification (LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Version, MSPID, Code, CodeName ,NotificationMethod, Text, STKML, Language, Status, StatusTime, AccessCode, SMSNotificationCode, CompanyID) VALUES (now(),'System',now(),'System',0,1,750,'MaxValueOfCashOutAtATM',8,'Dear Customer, you can cash out from ATM only $(Currency) $(maxAmount).',null,0,0,now(),null,null,1);
INSERT INTO notification (LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Version, MSPID, Code, CodeName ,NotificationMethod, Text, STKML, Language, Status, StatusTime, AccessCode, SMSNotificationCode, CompanyID) VALUES (now(),'System',now(),'System',0,1,750,'MaxValueOfCashOutAtATM',16,'Dear Customer, you can cash out from ATM only $(Currency) $(maxAmount).',null,0,0,now(),null,null,1);
