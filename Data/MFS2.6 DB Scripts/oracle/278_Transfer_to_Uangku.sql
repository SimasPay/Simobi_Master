

DELETE FROM NOTIFICATION WHERE CODE = 2176;

INSERT INTO NOTIFICATION (VERSION, LASTUPDATETIME, UPDATEDBY, CREATETIME, CREATEDBY, MSPID, CODE, CODENAME, NOTIFICATIONMETHOD, TEXT, LANGUAGE, STATUS, STATUSTIME, COMPANYID, ISACTIVE) VALUES ('0', SYSDATE, 'System', SYSDATE, 'System', '1', '2176', 'TransferToUangkuAccountCompletedToSender', '1', 'Transaction ID: $(TransferID). Dear Customer, you have successfully transferred $(Currency) $(Amount) to $(OnBehalfOfMDN) and  Service Charge $(Currency) $(serviceCharge).', '0', '0', SYSDATE, '1', '1');

INSERT INTO NOTIFICATION (VERSION, LASTUPDATETIME, UPDATEDBY, CREATETIME, CREATEDBY, MSPID, CODE, CODENAME, NOTIFICATIONMETHOD, TEXT, LANGUAGE, STATUS, STATUSTIME, COMPANYID, ISACTIVE) VALUES ('0', SYSDATE, 'System', SYSDATE, 'System', '1', '2176', 'TransferToUangkuAccountCompletedToSender', '2', 'Transaction ID: $(TransferID). Dear Customer, you have successfully transferred $(Currency) $(Amount) to $(OnBehalfOfMDN) and  Service Charge $(Currency) $(serviceCharge).', '0', '0', SYSDATE, '1', '1');

INSERT INTO NOTIFICATION (VERSION, LASTUPDATETIME, UPDATEDBY, CREATETIME, CREATEDBY, MSPID, CODE, CODENAME, NOTIFICATIONMETHOD, TEXT, LANGUAGE, STATUS, STATUSTIME, COMPANYID, ISACTIVE) VALUES ('0', SYSDATE, 'System', SYSDATE, 'System', '1', '2176', 'TransferToUangkuAccountCompletedToSender', '4', 'Transaction ID: $(TransferID). Dear Customer, you have successfully transferred $(Currency) $(Amount) to $(OnBehalfOfMDN) and  Service Charge $(Currency) $(serviceCharge).', '0', '0', SYSDATE, '1', '1');

INSERT INTO NOTIFICATION (VERSION, LASTUPDATETIME, UPDATEDBY, CREATETIME, CREATEDBY, MSPID, CODE, CODENAME, NOTIFICATIONMETHOD, TEXT, LANGUAGE, STATUS, STATUSTIME, COMPANYID, ISACTIVE) VALUES ('0', SYSDATE, 'System', SYSDATE, 'System', '1', '2176', 'TransferToUangkuAccountCompletedToSender', '8', 'Transaction ID: $(TransferID). Dear Customer, you have successfully transferred $(Currency) $(Amount) to $(OnBehalfOfMDN) and  Service Charge $(Currency) $(serviceCharge).', '0', '0', SYSDATE, '1', '1');

INSERT INTO NOTIFICATION (VERSION, LASTUPDATETIME, UPDATEDBY, CREATETIME, CREATEDBY, MSPID, CODE, CODENAME, NOTIFICATIONMETHOD, TEXT, LANGUAGE, STATUS, STATUSTIME, COMPANYID, ISACTIVE) VALUES ('0', SYSDATE, 'System', SYSDATE, 'System', '1', '2176', 'TransferToUangkuAccountCompletedToSender', '16', 'Transaction ID: $(TransferID). Dear Customer, you have successfully transferred $(Currency) $(Amount) to $(OnBehalfOfMDN) and  Service Charge $(Currency) $(serviceCharge).', '0', '0', SYSDATE, '1', '1');

INSERT INTO NOTIFICATION (VERSION, LASTUPDATETIME, UPDATEDBY, CREATETIME, CREATEDBY, MSPID, CODE, CODENAME, NOTIFICATIONMETHOD, TEXT, LANGUAGE, STATUS, STATUSTIME, COMPANYID, ISACTIVE) VALUES ('0', SYSDATE, 'System', SYSDATE, 'System', '1', '2176', 'TransferToUangkuAccountCompletedToSender', '1', 'Transaction ID: $(TransferID). Dear Customer, you have successfully transferred $(Currency) $(Amount) to $(OnBehalfOfMDN) and  Service Charge $(Currency) $(serviceCharge).', '1', '0', SYSDATE, '1', '1');

INSERT INTO NOTIFICATION (VERSION, LASTUPDATETIME, UPDATEDBY, CREATETIME, CREATEDBY, MSPID, CODE, CODENAME, NOTIFICATIONMETHOD, TEXT, LANGUAGE, STATUS, STATUSTIME, COMPANYID, ISACTIVE) VALUES ('0', SYSDATE, 'System', SYSDATE, 'System', '1', '2176', 'TransferToUangkuAccountCompletedToSender', '2', 'Transaction ID: $(TransferID). Dear Customer, you have successfully transferred $(Currency) $(Amount) to $(OnBehalfOfMDN) and  Service Charge $(Currency) $(serviceCharge).', '1', '0', SYSDATE, '1', '1');

INSERT INTO NOTIFICATION (VERSION, LASTUPDATETIME, UPDATEDBY, CREATETIME, CREATEDBY, MSPID, CODE, CODENAME, NOTIFICATIONMETHOD, TEXT, LANGUAGE, STATUS, STATUSTIME, COMPANYID, ISACTIVE) VALUES ('0', SYSDATE, 'System', SYSDATE, 'System', '1', '2176', 'TransferToUangkuAccountCompletedToSender', '4', 'Transaction ID: $(TransferID). Dear Customer, you have successfully transferred $(Currency) $(Amount) to $(OnBehalfOfMDN) and  Service Charge $(Currency) $(serviceCharge).', '1', '0', SYSDATE, '1', '1');

INSERT INTO NOTIFICATION (VERSION, LASTUPDATETIME, UPDATEDBY, CREATETIME, CREATEDBY, MSPID, CODE, CODENAME, NOTIFICATIONMETHOD, TEXT, LANGUAGE, STATUS, STATUSTIME, COMPANYID, ISACTIVE) VALUES ('0', SYSDATE, 'System', SYSDATE, 'System', '1', '2176', 'TransferToUangkuAccountCompletedToSender', '8', 'Transaction ID: $(TransferID). Dear Customer, you have successfully transferred $(Currency) $(Amount) to $(OnBehalfOfMDN) and  Service Charge $(Currency) $(serviceCharge).', '1', '0', SYSDATE, '1', '1');

INSERT INTO NOTIFICATION (VERSION, LASTUPDATETIME, UPDATEDBY, CREATETIME, CREATEDBY, MSPID, CODE, CODENAME, NOTIFICATIONMETHOD, TEXT, LANGUAGE, STATUS, STATUSTIME, COMPANYID, ISACTIVE) VALUES ('0', SYSDATE, 'System', SYSDATE, 'System', '1', '2176', 'TransferToUangkuAccountCompletedToSender', '16', 'Transaction ID: $(TransferID). Dear Customer, you have successfully transferred $(Currency) $(Amount) to $(OnBehalfOfMDN) and  Service Charge $(Currency) $(serviceCharge).', '1', '0', SYSDATE, '1', '1');

COMMIT;