--Add permisson item 
DELETE FROM PERMISSION_ITEM WHERE PERMISSION = 10250;

Insert into PERMISSION_ITEM (VERSION, LASTUPDATETIME, UPDATEDBY, CREATETIME, CREATEDBY, PERMISSION, ITEMTYPE, ITEMID, FIELDID, ACTION, PERMISSIONGROUPID, DESCRIPTION) values ('1', sysdate, 'system', sysdate, 'system', '10250', '1', 'emoneysub.add.bankpocket', 'default', 'default', '1', 'Add Bankpocket to Emoney Subscriber');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES('1', sysdate, 'system', sysdate, 'system', '1','10250');

ALTER TABLE SUBSCRIBER_UPGRADE_DATA ADD APPLICATIONID VARCHAR2(255);
ALTER TABLE SUBSCRIBER_UPGRADE_DATA ADD BANKACCOUNTNUMBER VARCHAR2(255);
ALTER TABLE SUBSCRIBER_UPGRADE_DATA  MODIFY FULLNAME  NULL;

COMMIT;
