-- Transaction Type

insert into transaction_type(version, lastupdatetime, updatedby, createtime,createdby,mspid,transactionname,displayname) values (1,now(),'system',now(),'system',1,'NFCCardLink','NFC Card Link');

insert into service_transaction(version,lastupdatetime,updatedby,createtime,createdby,mspid,serviceid,transactiontypeid) values (1,now(),'system',now(),'system',1, (select id from service where servicename = 'NFCService'), (select id from transaction_type where transactionname = 'NFCCardLink'));

-- CMS channel

INSERT INTO channel_code (Version,LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,ChannelCode,ChannelName,Description,ChannelSourceApplication) VALUES (0,now(),'System',now(),'System','11','CMS','CMS',11);

-- Add new notifications Card Link

Delete from notification where code = 836;
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (now(),'System',now(),'System',0,1,836,'NFCCardLinkSuccess',1,'Link NFC card $(CardPan) with Mobile number $(SenderMDN) was successful.',null,0,0,now(),null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (now(),'System',now(),'System',0,1,836,'NFCCardLinkSuccess',2,'Link NFC card $(CardPan) with Mobile number $(SenderMDN) was successful.',null,0,0,now(),null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (now(),'System',now(),'System',0,1,836,'NFCCardLinkSuccess',4,'Link NFC card $(CardPan) with Mobile number $(SenderMDN) was successful.',null,0,0,now(),null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (now(),'System',now(),'System',0,1,836,'NFCCardLinkSuccess',8,'Link NFC card $(CardPan) with Mobile number $(SenderMDN) was successful.',null,0,0,now(),null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (now(),'System',now(),'System',0,1,836,'NFCCardLinkSuccess',16,'Link NFC card $(CardPan) with Mobile number $(SenderMDN) was successful.',null,0,0,now(),null,null,1);


Delete from notification where code = 837;
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (now(),'System',now(),'System',0,1,837,'NFCCardLinkFailed',1,'Link NFC card $(CardPan) with Mobile number $(SenderMDN) was failed.',null,0,0,now(),null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (now(),'System',now(),'System',0,1,837,'NFCCardLinkFailed',2,'Link NFC card $(CardPan) with Mobile number $(SenderMDN) was failed.',null,0,0,now(),null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (now(),'System',now(),'System',0,1,837,'NFCCardLinkFailed',4,'Link NFC card $(CardPan) with Mobile number $(SenderMDN) was failed.',null,0,0,now(),null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (now(),'System',now(),'System',0,1,837,'NFCCardLinkFailed',8,'Link NFC card $(CardPan) with Mobile number $(SenderMDN) was failed.',null,0,0,now(),null,null,1);
INSERT INTO notification (LastUpdateTime,UpdatedBy,CreateTime,CreatedBy,Version,MSPID,Code,CodeName,NotificationMethod,Text,STKML,Language,Status,StatusTime,AccessCode,SMSNotificationCode,CompanyID) VALUES (now(),'System',now(),'System',0,1,837,'NFCCardLinkFailed',16,'Link NFC card $(CardPan) with Mobile number $(SenderMDN) was failed.',null,0,0,now(),null,null,1);


