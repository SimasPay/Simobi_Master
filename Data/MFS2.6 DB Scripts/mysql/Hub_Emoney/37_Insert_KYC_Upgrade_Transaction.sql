
insert into transaction_type(version, lastupdatetime, updatedby, createtime,createdby,mspid,transactionname,displayname) values (1,now(),'system',now(),'system',1,'KYCUpgrade','KYC Upgrade');

insert into service_transaction(version,lastupdatetime,updatedby,createtime,createdby,mspid,serviceid,transactiontypeid) values (1,now(),'system',now(),'system',1, (select id from service where servicename = 'Account'), (select id from transaction_type where transactionname = 'KYCUpgrade'));

Delete from notification where code = 2097;
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (now(),'System',now(),'System',0,1,2097,'KYCUpgradeSuccess',1,'KYC Upgrade is success for Mdn:$(sourceMdn) with KYC Level:$(KycLevel)',null,0,0,now(),null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (now(),'System',now(),'System',0,1,2097,'KYCUpgradeSuccess',2,'KYC Upgrade is success for Mdn:$(sourceMdn) with KYC Level:$(KycLevel)',null,0,0,now(),null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (now(),'System',now(),'System',0,1,2097,'KYCUpgradeSuccess',4,'KYC Upgrade is success for Mdn:$(sourceMdn) with KYC Level:$(KycLevel)',null,0,0,now(),null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (now(),'System',now(),'System',0,1,2097,'KYCUpgradeSuccess',8,'KYC Upgrade is success for Mdn:$(sourceMdn) with KYC Level:$(KycLevel)',null,0,0,now(),null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (now(),'System',now(),'System',0,1,2097,'KYCUpgradeSuccess',16,'KYC Upgrade is success for Mdn:$(sourceMdn) with KYC Level:$(KycLevel)',null,0,0,now(),null,null,1);

Delete from notification where code = 2098;
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (now(),'System',now(),'System',0,1,2098,'KYCUpgradeFail',1,'KYC Upgrade is Fail for Mdn:$(sourceMdn) with KYC Level:$(KycLevel) ',null,0,0,now(),null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (now(),'System',now(),'System',0,1,2098,'KYCUpgradeFail',2,'KYC Upgrade is Fail for Mdn:$(sourceMdn) with KYC Level:$(KycLevel) ',null,0,0,now(),null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (now(),'System',now(),'System',0,1,2098,'KYCUpgradeFail',4,'KYC Upgrade is Fail for Mdn:$(sourceMdn) with KYC Level:$(KycLevel) ',null,0,0,now(),null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (now(),'System',now(),'System',0,1,2098,'KYCUpgradeFail',8,'KYC Upgrade is Fail for Mdn:$(sourceMdn) with KYC Level:$(KycLevel) ',null,0,0,now(),null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (now(),'System',now(),'System',0,1,2098,'KYCUpgradeFail',16,'KYC Upgrade is Fail for Mdn:$(sourceMdn) with KYC Level:$(KycLevel) ',null,0,0,now(),null,null,1);
