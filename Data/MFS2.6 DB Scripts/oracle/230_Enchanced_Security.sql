

INSERT INTO SYSTEM_PARAMETERS (ID, VERSION, LASTUPDATETIME, UPDATEDBY, CREATETIME, CREATEDBY, PARAMETERNAME, PARAMETERVALUE, DESCRIPTION) 
 VALUES (system_parameters_ID_SEQ.NEXTVAL,1,SYSDATE,'System',SYSDATE,'system','date.to.expire.mobile.app.pin','','Force Mobile App Pin Modification for the User.');
 
ALTER TABLE SUBSCRIBER_MDN ADD  (LASTAPPPINCHANGE TIMESTAMP) ;
 
DELETE FROM NOTIFICATION WHERE CODE = 2177;

INSERT INTO NOTIFICATION (VERSION, LASTUPDATETIME, UPDATEDBY, CREATETIME, CREATEDBY, MSPID, CODE, CODENAME, NOTIFICATIONMETHOD, TEXT, LANGUAGE, STATUS, STATUSTIME, COMPANYID, ISACTIVE) VALUES ('0', SYSDATE, 'System', SYSDATE, 'System', '1', '2177', 'ForceUpgradeAppForUsers', '1', 'Please update your Simobi Application before performing transaction.', '0', '0', SYSDATE, '1', '1');

INSERT INTO NOTIFICATION (VERSION, LASTUPDATETIME, UPDATEDBY, CREATETIME, CREATEDBY, MSPID, CODE, CODENAME, NOTIFICATIONMETHOD, TEXT, LANGUAGE, STATUS, STATUSTIME, COMPANYID, ISACTIVE) VALUES ('0', SYSDATE, 'System', SYSDATE, 'System', '1', '2177', 'ForceUpgradeAppForUsers', '2', 'Please update your Simobi Application before performing transaction.', '0', '0', SYSDATE, '1', '1');

INSERT INTO NOTIFICATION (VERSION, LASTUPDATETIME, UPDATEDBY, CREATETIME, CREATEDBY, MSPID, CODE, CODENAME, NOTIFICATIONMETHOD, TEXT, LANGUAGE, STATUS, STATUSTIME, COMPANYID, ISACTIVE) VALUES ('0', SYSDATE, 'System', SYSDATE, 'System', '1', '2177', 'ForceUpgradeAppForUsers', '4', 'Please update your Simobi Application before performing transaction.', '0', '0', SYSDATE, '1', '1');

INSERT INTO NOTIFICATION (VERSION, LASTUPDATETIME, UPDATEDBY, CREATETIME, CREATEDBY, MSPID, CODE, CODENAME, NOTIFICATIONMETHOD, TEXT, LANGUAGE, STATUS, STATUSTIME, COMPANYID, ISACTIVE) VALUES ('0', SYSDATE, 'System', SYSDATE, 'System', '1', '2177', 'ForceUpgradeAppForUsers', '8', 'Please update your Simobi Application before performing transaction.', '0', '0', SYSDATE, '1', '1');

INSERT INTO NOTIFICATION (VERSION, LASTUPDATETIME, UPDATEDBY, CREATETIME, CREATEDBY, MSPID, CODE, CODENAME, NOTIFICATIONMETHOD, TEXT, LANGUAGE, STATUS, STATUSTIME, COMPANYID, ISACTIVE) VALUES ('0', SYSDATE, 'System', SYSDATE, 'System', '1', '2177', 'ForceUpgradeAppForUsers', '16', 'User should change the Mobile App Pin Forcibiliy.', '0', '0', SYSDATE, '1', '1');

INSERT INTO NOTIFICATION (VERSION, LASTUPDATETIME, UPDATEDBY, CREATETIME, CREATEDBY, MSPID, CODE, CODENAME, NOTIFICATIONMETHOD, TEXT, LANGUAGE, STATUS, STATUSTIME, COMPANYID, ISACTIVE) VALUES ('0', SYSDATE, 'System', SYSDATE, 'System', '1', '2177', 'ForceUpgradeAppForUsers', '1', 'Silakan perbarui Aplikasi Simobi Anda sebelum melakukan transaksi.', '1', '0', SYSDATE, '1', '1');

INSERT INTO NOTIFICATION (VERSION, LASTUPDATETIME, UPDATEDBY, CREATETIME, CREATEDBY, MSPID, CODE, CODENAME, NOTIFICATIONMETHOD, TEXT, LANGUAGE, STATUS, STATUSTIME, COMPANYID, ISACTIVE) VALUES ('0', SYSDATE, 'System', SYSDATE, 'System', '1', '2177', 'ForceUpgradeAppForUsers', '2', 'Silakan perbarui Aplikasi Simobi Anda sebelum melakukan transaksi.', '1', '0', SYSDATE, '1', '1');

INSERT INTO NOTIFICATION (VERSION, LASTUPDATETIME, UPDATEDBY, CREATETIME, CREATEDBY, MSPID, CODE, CODENAME, NOTIFICATIONMETHOD, TEXT, LANGUAGE, STATUS, STATUSTIME, COMPANYID, ISACTIVE) VALUES ('0', SYSDATE, 'System', SYSDATE, 'System', '1', '2177', 'ForceUpgradeAppForUsers', '4', 'Silakan perbarui Aplikasi Simobi Anda sebelum melakukan transaksi.', '1', '0', SYSDATE, '1', '1');

INSERT INTO NOTIFICATION (VERSION, LASTUPDATETIME, UPDATEDBY, CREATETIME, CREATEDBY, MSPID, CODE, CODENAME, NOTIFICATIONMETHOD, TEXT, LANGUAGE, STATUS, STATUSTIME, COMPANYID, ISACTIVE) VALUES ('0', SYSDATE, 'System', SYSDATE, 'System', '1', '2177', 'ForceUpgradeAppForUsers', '8', 'Silakan perbarui Aplikasi Simobi Anda sebelum melakukan transaksi.', '1', '0', SYSDATE, '1', '1');

INSERT INTO NOTIFICATION (VERSION, LASTUPDATETIME, UPDATEDBY, CREATETIME, CREATEDBY, MSPID, CODE, CODENAME, NOTIFICATIONMETHOD, TEXT, LANGUAGE, STATUS, STATUSTIME, COMPANYID, ISACTIVE) VALUES ('0', SYSDATE, 'System', SYSDATE, 'System', '1', '2177', 'ForceUpgradeAppForUsers', '16', 'Silakan perbarui Aplikasi Simobi Anda sebelum melakukan transaksi.', '1', '0', SYSDATE, '1', '1');

DELETE FROM NOTIFICATION WHERE CODE = 2178;

INSERT INTO NOTIFICATION (VERSION, LASTUPDATETIME, UPDATEDBY, CREATETIME, CREATEDBY, MSPID, CODE, CODENAME, NOTIFICATIONMETHOD, TEXT, LANGUAGE, STATUS, STATUSTIME, COMPANYID, ISACTIVE) VALUES ('0', SYSDATE, 'System', SYSDATE, 'System', '1', '2178', 'SequenceNumberAsPin', '1', 'Please don''t use sequence numbers as your mPIN.', '0', '0', SYSDATE, '1', '1');

INSERT INTO NOTIFICATION (VERSION, LASTUPDATETIME, UPDATEDBY, CREATETIME, CREATEDBY, MSPID, CODE, CODENAME, NOTIFICATIONMETHOD, TEXT, LANGUAGE, STATUS, STATUSTIME, COMPANYID, ISACTIVE) VALUES ('0', SYSDATE, 'System', SYSDATE, 'System', '1', '2178', 'SequenceNumberAsPin', '2', 'Please don''t use sequence numbers as your mPIN.', '0', '0', SYSDATE, '1', '1');

INSERT INTO NOTIFICATION (VERSION, LASTUPDATETIME, UPDATEDBY, CREATETIME, CREATEDBY, MSPID, CODE, CODENAME, NOTIFICATIONMETHOD, TEXT, LANGUAGE, STATUS, STATUSTIME, COMPANYID, ISACTIVE) VALUES ('0', SYSDATE, 'System', SYSDATE, 'System', '1', '2178', 'SequenceNumberAsPin', '4', 'Please don''t use sequence numbers as your mPIN.', '0', '0', SYSDATE, '1', '1');

INSERT INTO NOTIFICATION (VERSION, LASTUPDATETIME, UPDATEDBY, CREATETIME, CREATEDBY, MSPID, CODE, CODENAME, NOTIFICATIONMETHOD, TEXT, LANGUAGE, STATUS, STATUSTIME, COMPANYID, ISACTIVE) VALUES ('0', SYSDATE, 'System', SYSDATE, 'System', '1', '2178', 'SequenceNumberAsPin', '8', 'Please don''t use sequence numbers as your mPIN.', '0', '0', SYSDATE, '1', '1');

INSERT INTO NOTIFICATION (VERSION, LASTUPDATETIME, UPDATEDBY, CREATETIME, CREATEDBY, MSPID, CODE, CODENAME, NOTIFICATIONMETHOD, TEXT, LANGUAGE, STATUS, STATUSTIME, COMPANYID, ISACTIVE) VALUES ('0', SYSDATE, 'System', SYSDATE, 'System', '1', '2178', 'SequenceNumberAsPin', '16', 'Please don''t use sequence numbers as your mPIN.', '0', '0', SYSDATE, '1', '1');

INSERT INTO NOTIFICATION (VERSION, LASTUPDATETIME, UPDATEDBY, CREATETIME, CREATEDBY, MSPID, CODE, CODENAME, NOTIFICATIONMETHOD, TEXT, LANGUAGE, STATUS, STATUSTIME, COMPANYID, ISACTIVE) VALUES ('0', SYSDATE, 'System', SYSDATE, 'System', '1', '2178', 'SequenceNumberAsPin', '1', 'Mohon jangan gunakan angka berurutan sebagai mPIN Anda.', '1', '0', SYSDATE, '1', '1');

INSERT INTO NOTIFICATION (VERSION, LASTUPDATETIME, UPDATEDBY, CREATETIME, CREATEDBY, MSPID, CODE, CODENAME, NOTIFICATIONMETHOD, TEXT, LANGUAGE, STATUS, STATUSTIME, COMPANYID, ISACTIVE) VALUES ('0', SYSDATE, 'System', SYSDATE, 'System', '1', '2178', 'SequenceNumberAsPin', '2', 'Mohon jangan gunakan angka berurutan sebagai mPIN Anda.', '1', '0', SYSDATE, '1', '1');

INSERT INTO NOTIFICATION (VERSION, LASTUPDATETIME, UPDATEDBY, CREATETIME, CREATEDBY, MSPID, CODE, CODENAME, NOTIFICATIONMETHOD, TEXT, LANGUAGE, STATUS, STATUSTIME, COMPANYID, ISACTIVE) VALUES ('0', SYSDATE, 'System', SYSDATE, 'System', '1', '2178', 'SequenceNumberAsPin', '4', 'Mohon jangan gunakan angka berurutan sebagai mPIN Anda.', '1', '0', SYSDATE, '1', '1');

INSERT INTO NOTIFICATION (VERSION, LASTUPDATETIME, UPDATEDBY, CREATETIME, CREATEDBY, MSPID, CODE, CODENAME, NOTIFICATIONMETHOD, TEXT, LANGUAGE, STATUS, STATUSTIME, COMPANYID, ISACTIVE) VALUES ('0', SYSDATE, 'System', SYSDATE, 'System', '1', '2178', 'SequenceNumberAsPin', '8', 'Mohon jangan gunakan angka berurutan sebagai mPIN Anda.', '1', '0', SYSDATE, '1', '1');

INSERT INTO NOTIFICATION (VERSION, LASTUPDATETIME, UPDATEDBY, CREATETIME, CREATEDBY, MSPID, CODE, CODENAME, NOTIFICATIONMETHOD, TEXT, LANGUAGE, STATUS, STATUSTIME, COMPANYID, ISACTIVE) VALUES ('0', SYSDATE, 'System', SYSDATE, 'System', '1', '2178', 'SequenceNumberAsPin', '16', 'Mohon jangan gunakan angka berurutan sebagai mPIN Anda.', '1', '0', SYSDATE, '1', '1');

DELETE FROM NOTIFICATION WHERE CODE = 2179;

INSERT INTO NOTIFICATION (VERSION, LASTUPDATETIME, UPDATEDBY, CREATETIME, CREATEDBY, MSPID, CODE, CODENAME, NOTIFICATIONMETHOD, TEXT, LANGUAGE, STATUS, STATUSTIME, COMPANYID, ISACTIVE) VALUES ('0', SYSDATE, 'System', SYSDATE, 'System', '1', '2179', 'SameNumbersAsPin', '1', 'Please don''t use same numbers as your mPIN.', '0', '0', SYSDATE, '1', '1');

INSERT INTO NOTIFICATION (VERSION, LASTUPDATETIME, UPDATEDBY, CREATETIME, CREATEDBY, MSPID, CODE, CODENAME, NOTIFICATIONMETHOD, TEXT, LANGUAGE, STATUS, STATUSTIME, COMPANYID, ISACTIVE) VALUES ('0', SYSDATE, 'System', SYSDATE, 'System', '1', '2179', 'SameNumbersAsPin', '2', 'Please don''t use same numbers as your mPIN.', '0', '0', SYSDATE, '1', '1');

INSERT INTO NOTIFICATION (VERSION, LASTUPDATETIME, UPDATEDBY, CREATETIME, CREATEDBY, MSPID, CODE, CODENAME, NOTIFICATIONMETHOD, TEXT, LANGUAGE, STATUS, STATUSTIME, COMPANYID, ISACTIVE) VALUES ('0', SYSDATE, 'System', SYSDATE, 'System', '1', '2179', 'SameNumbersAsPin', '4', 'Please don''t use same numbers as your mPIN.', '0', '0', SYSDATE, '1', '1');

INSERT INTO NOTIFICATION (VERSION, LASTUPDATETIME, UPDATEDBY, CREATETIME, CREATEDBY, MSPID, CODE, CODENAME, NOTIFICATIONMETHOD, TEXT, LANGUAGE, STATUS, STATUSTIME, COMPANYID, ISACTIVE) VALUES ('0', SYSDATE, 'System', SYSDATE, 'System', '1', '2179', 'SameNumbersAsPin', '8', 'Please don''t use same numbers as your mPIN.', '0', '0', SYSDATE, '1', '1');

INSERT INTO NOTIFICATION (VERSION, LASTUPDATETIME, UPDATEDBY, CREATETIME, CREATEDBY, MSPID, CODE, CODENAME, NOTIFICATIONMETHOD, TEXT, LANGUAGE, STATUS, STATUSTIME, COMPANYID, ISACTIVE) VALUES ('0', SYSDATE, 'System', SYSDATE, 'System', '1', '2179', 'SameNumbersAsPin', '16', 'Please don''t use sequence numbers as your mPIN.', '0', '0', SYSDATE, '1', '1');

INSERT INTO NOTIFICATION (VERSION, LASTUPDATETIME, UPDATEDBY, CREATETIME, CREATEDBY, MSPID, CODE, CODENAME, NOTIFICATIONMETHOD, TEXT, LANGUAGE, STATUS, STATUSTIME, COMPANYID, ISACTIVE) VALUES ('0', SYSDATE, 'System', SYSDATE, 'System', '1', '2179', 'SameNumbersAsPin', '1', 'Mohon jangan gunakan angka yang sama sebagai mPIN Anda', '1', '0', SYSDATE, '1', '1');

INSERT INTO NOTIFICATION (VERSION, LASTUPDATETIME, UPDATEDBY, CREATETIME, CREATEDBY, MSPID, CODE, CODENAME, NOTIFICATIONMETHOD, TEXT, LANGUAGE, STATUS, STATUSTIME, COMPANYID, ISACTIVE) VALUES ('0', SYSDATE, 'System', SYSDATE, 'System', '1', '2179', 'SameNumbersAsPin', '2', 'Mohon jangan gunakan angka yang sama sebagai mPIN Anda', '1', '0', SYSDATE, '1', '1');

INSERT INTO NOTIFICATION (VERSION, LASTUPDATETIME, UPDATEDBY, CREATETIME, CREATEDBY, MSPID, CODE, CODENAME, NOTIFICATIONMETHOD, TEXT, LANGUAGE, STATUS, STATUSTIME, COMPANYID, ISACTIVE) VALUES ('0', SYSDATE, 'System', SYSDATE, 'System', '1', '2179', 'SameNumbersAsPin', '4', 'Mohon jangan gunakan angka yang sama sebagai mPIN Anda', '1', '0', SYSDATE, '1', '1');

INSERT INTO NOTIFICATION (VERSION, LASTUPDATETIME, UPDATEDBY, CREATETIME, CREATEDBY, MSPID, CODE, CODENAME, NOTIFICATIONMETHOD, TEXT, LANGUAGE, STATUS, STATUSTIME, COMPANYID, ISACTIVE) VALUES ('0', SYSDATE, 'System', SYSDATE, 'System', '1', '2179', 'SameNumbersAsPin', '8', 'Mohon jangan gunakan angka yang sama sebagai mPIN Anda', '1', '0', SYSDATE, '1', '1');

INSERT INTO NOTIFICATION (VERSION, LASTUPDATETIME, UPDATEDBY, CREATETIME, CREATEDBY, MSPID, CODE, CODENAME, NOTIFICATIONMETHOD, TEXT, LANGUAGE, STATUS, STATUSTIME, COMPANYID, ISACTIVE) VALUES ('0', SYSDATE, 'System', SYSDATE, 'System', '1', '2179', 'SameNumbersAsPin', '16', 'Mohon jangan gunakan angka yang sama sebagai mPIN Anda', '1', '0', SYSDATE, '1', '1');
 
 COMMIT;