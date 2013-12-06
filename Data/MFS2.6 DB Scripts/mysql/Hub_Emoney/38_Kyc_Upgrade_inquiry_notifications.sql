Delete from notification where code = 2099;
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (now(),'System',now(),'System',0,1,2099,'SubscriberStatusNotValidForKYCUpgrade',1,'Subscriber not eligible for kyc upgradation.The status of the Mdn:$(SourceMDN) is $(SubscriberStatus)',null,0,0,now(),null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (now(),'System',now(),'System',0,1,2099,'SubscriberStatusNotValidForKYCUpgrade',2,'Subscriber not eligible for kyc upgradation.The status of the Mdn:$(SourceMDN) is $(SubscriberStatus)',null,0,0,now(),null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (now(),'System',now(),'System',0,1,2099,'SubscriberStatusNotValidForKYCUpgrade',4,'Subscriber not eligible for kyc upgradation.The status of the Mdn:$(SourceMDN) is $(SubscriberStatus)',null,0,0,now(),null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (now(),'System',now(),'System',0,1,2099,'SubscriberStatusNotValidForKYCUpgrade',8,'Subscriber not eligible for kyc upgradation.The status of the Mdn:$(SourceMDN) is $(SubscriberStatus)',null,0,0,now(),null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (now(),'System',now(),'System',0,1,2099,'SubscriberStatusNotValidForKYCUpgrade',16,'Subscriber not eligible for kyc upgradation.The status of the Mdn:$(SourceMDN) is $(SubscriberStatus)',null,0,0,now(),null,null,1);

Delete from notification where code = 2100;
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (now(),'System',now(),'System',0,1,2100,'KycUpgradeInquirySuccessful',1,'The Subscriber with Mdn:$(SourceMDN) is eligible for Kyc upgradation',null,0,0,now(),null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (now(),'System',now(),'System',0,1,2100,'KycUpgradeInquirySuccessful',2,'The Subscriber with Mdn:$(SourceMDN) is eligible for Kyc upgradation',null,0,0,now(),null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (now(),'System',now(),'System',0,1,2100,'KycUpgradeInquirySuccessful',4,'The Subscriber with Mdn:$(SourceMDN) is eligible for Kyc upgradation',null,0,0,now(),null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (now(),'System',now(),'System',0,1,2100,'KycUpgradeInquirySuccessful',8,'The Subscriber with Mdn:$(SourceMDN) is eligible for Kyc upgradation',null,0,0,now(),null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (now(),'System',now(),'System',0,1,2100,'KycUpgradeInquirySuccessful',16,'The Subscriber with Mdn:$(SourceMDN) is eligible for Kyc upgradation',null,0,0,now(),null,null,1);
