
ALTER TABLE PARTNER ADD (
BANKBRANCHCODE NUMBER(10),
BRANCHSEQUENCE NUMBER(10), 
ACCOUNTNUMBEROFBANKSINARMAS VARCHAR2(255), 
COMPANYEMAILID VARCHAR2(255));


ALTER TABLE SUBSCRIBER_ADDI_INFO ADD (
AGREEMENTNUMBER VARCHAR2(255),
AGENTCOMPANYNAME VARCHAR2(255),
LATITUDE VARCHAR2(255),
LONGITUDE VARCHAR2(255),
USERBANKBRANCH VARCHAR2(255),
ELECTONICDEVICEUSED NUMBER(10),
BANKACCOUNTSTATUS NUMBER(10),
AGREMENTDATE TIMESTAMP,
IMPLEMENTATINDATE TIMESTAMP);

delete from enum_text where TagID = 6414;
INSERT INTO enum_text (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, LANGUAGE, TagName, TagID, EnumCode, EnumValue, DisplayText) VALUES ('1',sysdate,'system',sysdate,'system','0','BusinessPartnerTypeAgent','6414','4','DirectAgent','Perorangan');
INSERT INTO enum_text (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, LANGUAGE, TagName, TagID, EnumCode, EnumValue, DisplayText) VALUES ('1',sysdate,'system',sysdate,'system','0','BusinessPartnerTypeAgent','6414','5','SuperAgent','Badan Usaha');

delete from enum_text where TAGID=8302;
INSERT INTO enum_text (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, LANGUAGE, TagName, TagID, EnumCode, EnumValue, DisplayText) VALUES ('1',sysdate,'system',sysdate,'system','0','AgentType','8302','1','PersonalAgent','Perorangan');
INSERT INTO enum_text (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, LANGUAGE, TagName, TagID, EnumCode, EnumValue, DisplayText) VALUES ('1',sysdate,'system',sysdate,'system','0','AgentType','8302','2','Corporate','Badan Usaha');

delete from enum_text where TAGID=8303;
INSERT INTO enum_text (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, LANGUAGE, TagName, TagID, EnumCode, EnumValue, DisplayText) VALUES ('1',sysdate,'system',sysdate,'system','0','ClassificationAgent','8303','1','A','A');
INSERT INTO enum_text (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, LANGUAGE, TagName, TagID, EnumCode, EnumValue, DisplayText) VALUES ('1',sysdate,'system',sysdate,'system','0','ClassificationAgent','8303','2','B','B');
INSERT INTO enum_text (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, LANGUAGE, TagName, TagID, EnumCode, EnumValue, DisplayText) VALUES ('1',sysdate,'system',sysdate,'system','0','ClassificationAgent','8303','3','C','C');
INSERT INTO enum_text (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, LANGUAGE, TagName, TagID, EnumCode, EnumValue, DisplayText) VALUES ('1',sysdate,'system',sysdate,'system','0','ClassificationAgent','8303','4','D','D');
INSERT INTO enum_text (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, LANGUAGE, TagName, TagID, EnumCode, EnumValue, DisplayText) VALUES ('1',sysdate,'system',sysdate,'system','0','ClassificationAgent','8303','5','E','E');
INSERT INTO enum_text (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, LANGUAGE, TagName, TagID, EnumCode, EnumValue, DisplayText) VALUES ('1',sysdate,'system',sysdate,'system','0','ClassificationAgent','8303','6','F','F');
INSERT INTO enum_text (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, LANGUAGE, TagName, TagID, EnumCode, EnumValue, DisplayText) VALUES ('1',sysdate,'system',sysdate,'system','0','ClassificationAgent','8303','7','G','G');

delete from enum_text where TAGID=8304;
INSERT INTO enum_text (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, LANGUAGE, TagName, TagID, EnumCode, EnumValue, DisplayText) VALUES ('1',sysdate,'system',sysdate,'system','0','TypeofBusinessAgent','8304','160010','LNDUSTRI PENGERINGAN DAN PENGOLAHAN TEMBAKAU','LNDUSTRI PENGERINGAN DAN PENGOLAHAN TEMBAKAU');
INSERT INTO enum_text (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, LANGUAGE, TagName, TagID, EnumCode, EnumValue, DisplayText) VALUES ('1',sysdate,'system',sysdate,'system','0','TypeofBusinessAgent','8304','181000','INDUSTRI PAKAIAN JADI DAN PERLENGKAPANNYA, KECUALI PAKAIAN JADI BERBULU','INDUSTRI PAKAIAN JADI DAN PERLENGKAPANNYA, KECUALI PAKAIAN JADI BERBULU');
INSERT INTO enum_text (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, LANGUAGE, TagName, TagID, EnumCode, EnumValue, DisplayText) VALUES ('1',sysdate,'system',sysdate,'system','0','TypeofBusinessAgent','8304','192000','INDUSTRI ALAS KAKI','INDUSTRI ALAS KAKI');
INSERT INTO enum_text (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, LANGUAGE, TagName, TagID, EnumCode, EnumValue, DisplayText) VALUES ('1',sysdate,'system',sysdate,'system','0','TypeofBusinessAgent','8304','512209','PERDAGANGAN DALAM NEGERI MAKANAN, MINUMAN DAN TEMBAKAU LAINNYA','PERDAGANGAN DALAM NEGERI MAKANAN, MINUMAN DAN TEMBAKAU LAINNYA');
INSERT INTO enum_text (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, LANGUAGE, TagName, TagID, EnumCode, EnumValue, DisplayText) VALUES ('1',sysdate,'system',sysdate,'system','0','TypeofBusinessAgent','8304','513900','PERDAGANGAN BESAR BARANG-BARANG KEPERLUAN RUMAH TANGGA LAINNYA','PERDAGANGAN BESAR BARANG-BARANG KEPERLUAN RUMAH TANGGA LAINNYA');
INSERT INTO enum_text (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, LANGUAGE, TagName, TagID, EnumCode, EnumValue, DisplayText) VALUES ('1',sysdate,'system',sysdate,'system','0','TypeofBusinessAgent','8304','521100','PERDAGANGAN ECERAN BERBAGAI MACAM BARANG YANG DIDOMINASI MAKANAN, MINUMAN DAN TEMBAKAU','PERDAGANGAN ECERAN BERBAGAI MACAM BARANG YANG DIDOMINASI MAKANAN, MINUMAN DAN TEMBAKAU');
INSERT INTO enum_text (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, LANGUAGE, TagName, TagID, EnumCode, EnumValue, DisplayText) VALUES ('1',sysdate,'system',sysdate,'system','0','TypeofBusinessAgent','8304','521900','PERDAGANGAN ECERAN BERBAGAI MACAM BARANG YANG DIDOMINASI OLEH BARANG BUKAN MAKANAN, MINUMAN DAN TEMBAKAU','PERDAGANGAN ECERAN BERBAGAI MACAM BARANG YANG DIDOMINASI OLEH BARANG BUKAN MAKANAN, MINUMAN DAN TEMBAKAU');
INSERT INTO enum_text (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, LANGUAGE, TagName, TagID, EnumCode, EnumValue, DisplayText) VALUES ('1',sysdate,'system',sysdate,'system','0','TypeofBusinessAgent','8304','522100','PERDAGANGAN ECERAN KOMODITI MAKANAN DARI HASIL PERTANIAN','PERDAGANGAN ECERAN KOMODITI MAKANAN DARI HASIL PERTANIAN');
INSERT INTO enum_text (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, LANGUAGE, TagName, TagID, EnumCode, EnumValue, DisplayText) VALUES ('1',sysdate,'system',sysdate,'system','0','TypeofBusinessAgent','8304','522200','PERDAGANGAN ECERAN KOMODITI MAKANAN, MINUMAN, ATAU TEMBAKAU HASIL INDUSTRI PENGOLAHAN','PERDAGANGAN ECERAN KOMODITI MAKANAN, MINUMAN, ATAU TEMBAKAU HASIL INDUSTRI PENGOLAHAN');
INSERT INTO enum_text (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, LANGUAGE, TagName, TagID, EnumCode, EnumValue, DisplayText) VALUES ('1',sysdate,'system',sysdate,'system','0','TypeofBusinessAgent','8304','523200','PERDAGANGAN ECERAN TEKSTIL, PAKAIAN JADI, ALAS KAKI, DAN BARANG KEPERLUAN PRIBADI','PERDAGANGAN ECERAN TEKSTIL, PAKAIAN JADI, ALAS KAKI, DAN BARANG KEPERLUAN PRIBADI');
INSERT INTO enum_text (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, LANGUAGE, TagName, TagID, EnumCode, EnumValue, DisplayText) VALUES ('1',sysdate,'system',sysdate,'system','0','TypeofBusinessAgent','8304','523300','PERDAGANGAN ECERAN PERLENGKAPAN RUMAH TANGGA DAN PERLENGKAPAN DAPUR','PERDAGANGAN ECERAN PERLENGKAPAN RUMAH TANGGA DAN PERLENGKAPAN DAPUR');
INSERT INTO enum_text (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, LANGUAGE, TagName, TagID, EnumCode, EnumValue, DisplayText) VALUES ('1',sysdate,'system',sysdate,'system','0','TypeofBusinessAgent','8304','523400','PERDAGANGAN ECERAN BAHAN KONSTRUKSI','PERDAGANGAN ECERAN BAHAN KONSTRUKSI');
INSERT INTO enum_text (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, LANGUAGE, TagName, TagID, EnumCode, EnumValue, DisplayText) VALUES ('1',sysdate,'system',sysdate,'system','0','TypeofBusinessAgent','8304','523600','PERDAGANGAN ECERAN KERTAS, BARANG-BARANG DARI KERTAS, ALAT TULIS, BARANG CETAKAN, ALAT OLAHRAGA, ALAT MUSIK, ALAT FOTOGRAFI, KOMPUTER','PERDAGANGAN ECERAN KERTAS, BARANG-BARANG DARI KERTAS, ALAT TULIS, BARANG CETAKAN, ALAT OLAHRAGA, ALAT MUSIK, ALAT FOTOGRAFI, KOMPUTER');
INSERT INTO enum_text (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, LANGUAGE, TagName, TagID, EnumCode, EnumValue, DisplayText) VALUES ('1',sysdate,'system',sysdate,'system','0','TypeofBusinessAgent','8304','524000','PERDAGANGAN ECERAN BARANG BEKAS','PERDAGANGAN ECERAN BARANG BEKAS');
INSERT INTO enum_text (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, LANGUAGE, TagName, TagID, EnumCode, EnumValue, DisplayText) VALUES ('1',sysdate,'system',sysdate,'system','0','TypeofBusinessAgent','8304','525100','PERDAGANGAN ECERAN KAKI LIMA KOMODITI DARI HASIL PERTANIAN','PERDAGANGAN ECERAN KAKI LIMA KOMODITI DARI HASIL PERTANIAN');
INSERT INTO enum_text (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, LANGUAGE, TagName, TagID, EnumCode, EnumValue, DisplayText) VALUES ('1',sysdate,'system',sysdate,'system','0','TypeofBusinessAgent','8304','525200','PERDAGANGAN ECERAN KAKI LIMA KOMODITI MAKANAN, MINUMAN HASIL INDUSTRI PENGOLAHAN','PERDAGANGAN ECERAN KAKI LIMA KOMODITI MAKANAN, MINUMAN HASIL INDUSTRI PENGOLAHAN');
INSERT INTO enum_text (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, LANGUAGE, TagName, TagID, EnumCode, EnumValue, DisplayText) VALUES ('1',sysdate,'system',sysdate,'system','0','TypeofBusinessAgent','8304','525400','PERDAGANGAN ECERAN KAKI LIMA TEKSTIL, PAKAIAN JADI, ALAS KAKI, DAN BARANG KEPERLUAN PRIBADI','PERDAGANGAN ECERAN KAKI LIMA TEKSTIL, PAKAIAN JADI, ALAS KAKI, DAN BARANG KEPERLUAN PRIBADI');
INSERT INTO enum_text (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, LANGUAGE, TagName, TagID, EnumCode, EnumValue, DisplayText) VALUES ('1',sysdate,'system',sysdate,'system','0','TypeofBusinessAgent','8304','525500','PERDAGANGAN ECERAN KAKI LIMA PERLENGKAPAN RUMAH TANGGA DAN PERLENGKAPAN DAPUR','PERDAGANGAN ECERAN KAKI LIMA PERLENGKAPAN RUMAH TANGGA DAN PERLENGKAPAN DAPUR');
INSERT INTO enum_text (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, LANGUAGE, TagName, TagID, EnumCode, EnumValue, DisplayText) VALUES ('1',sysdate,'system',sysdate,'system','0','TypeofBusinessAgent','8304','552009','PENYEDIAAN MAKAN MINUM LAINNYA','PENYEDIAAN MAKAN MINUM LAINNYA');
INSERT INTO enum_text (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, LANGUAGE, TagName, TagID, EnumCode, EnumValue, DisplayText) VALUES ('1',sysdate,'system',sysdate,'system','0','TypeofBusinessAgent','8304','552100','RESTORAN / RUMAH MAKAN','RESTORAN / RUMAH MAKAN');
INSERT INTO enum_text (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, LANGUAGE, TagName, TagID, EnumCode, EnumValue, DisplayText) VALUES ('1',sysdate,'system',sysdate,'system','0','TypeofBusinessAgent','8304','729000','KEGIATAN LAIN YANG BERKAITAN DENGAN KOMPUTER','KEGIATAN LAIN YANG BERKAITAN DENGAN KOMPUTER');
INSERT INTO enum_text (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, LANGUAGE, TagName, TagID, EnumCode, EnumValue, DisplayText) VALUES ('1',sysdate,'system',sysdate,'system','0','TypeofBusinessAgent','8304','743000','JASA PERIKLANAN','JASA PERIKLANAN');

delete from enum_text where TAGID=8305;
INSERT INTO enum_text (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, LANGUAGE, TagName, TagID, EnumCode, EnumValue, DisplayText) VALUES ('1',sysdate,'system',sysdate,'system','0','ElectonicDevieused','8305','1','EDC','Electronic Data Capture (EDC)');
INSERT INTO enum_text (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, LANGUAGE, TagName, TagID, EnumCode, EnumValue, DisplayText) VALUES ('1',sysdate,'system',sysdate,'system','0','ElectonicDevieused','8305','2','Telephone Selular','TeleponSelular (Handphone)');
INSERT INTO enum_text (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, LANGUAGE, TagName, TagID, EnumCode, EnumValue, DisplayText) VALUES ('1',sysdate,'system',sysdate,'system','0','ElectonicDevieused','8305','3','Computer','Komputer');
INSERT INTO enum_text (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, LANGUAGE, TagName, TagID, EnumCode, EnumValue, DisplayText) VALUES ('1',sysdate,'system',sysdate,'system','0','ElectonicDevieused','8305','4','Laptop','Laptop');

delete from enum_text where TAGID=8389;
INSERT INTO enum_text (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, LANGUAGE, TagName, TagID, EnumCode, EnumValue, DisplayText) VALUES ('1',sysdate,'system',sysdate,'system','0','BankAccountStatus','8389','1','Agen baru','Agen baru');
INSERT INTO enum_text (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, LANGUAGE, TagName, TagID, EnumCode, EnumValue, DisplayText) VALUES ('1',sysdate,'system',sysdate,'system','0','BankAccountStatus','8389','2','Perubahan klasifikasi Agen','Perubahan klasifikasi Agen');
INSERT INTO enum_text (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, LANGUAGE, TagName, TagID, EnumCode, EnumValue, DisplayText) VALUES ('1',sysdate,'system',sysdate,'system','0','BankAccountStatus','8389','3','Perubahan jenis usaha Agen','Perubahan jenis usaha Agen');
INSERT INTO enum_text (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, LANGUAGE, TagName, TagID, EnumCode, EnumValue, DisplayText) VALUES ('1',sysdate,'system',sysdate,'system','0','BankAccountStatus','8389','4','Perubahan lokasi Agen','Perubahan lokasi Agen');
INSERT INTO enum_text (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, LANGUAGE, TagName, TagID, EnumCode, EnumValue, DisplayText) VALUES ('1',sysdate,'system',sysdate,'system','0','BankAccountStatus','8389','5','Penghentian Agen karena pelanggaran','Penghentian Agen karena pelanggaran');
INSERT INTO enum_text (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, LANGUAGE, TagName, TagID, EnumCode, EnumValue, DisplayText) VALUES ('1',sysdate,'system',sysdate,'system','0','BankAccountStatus','8389','6','Penghentian Agen karena habis jangka waktu perjanjian kerjasama dan tanpa perpanjangan kerjasama','Penghentian Agen karena habis jangka waktu perjanjian kerjasama dan tanpa perpanjangan kerjasama');
INSERT INTO enum_text (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, LANGUAGE, TagName, TagID, EnumCode, EnumValue, DisplayText) VALUES ('1',sysdate,'system',sysdate,'system','0','BankAccountStatus','8389','7','Perubahan dan/atau penambahan perangkat elektronik','Perubahan dan/atau penambahan perangkat elektronik');
INSERT INTO enum_text (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, LANGUAGE, TagName, TagID, EnumCode, EnumValue, DisplayText) VALUES ('1',sysdate,'system',sysdate,'system','0','BankAccountStatus','8389','8','Agen pasif (Agen tidak aktif melayani transaksi selama lebih dari 90 hari)','Agen pasif (Agen tidak aktif melayani transaksi selama lebih dari 90 hari)');

Insert into POCKET_TEMPLATE_CONFIG (VERSION,LASTUPDATETIME,UPDATEDBY,CREATETIME,CREATEDBY,SUBSCRIBERTYPE,BUSINESSPARTNERTYPE,KYCLEVEL,COMMODITY,POCKETTYPE,ISSUSPENCEPOCKET,ISCOLLECTORPOCKET,POCKETTEMPLATEID,ISDEFAULT) values (0,sysdate,'system',sysdate,'system',2,4,3,4,1,1,0,7,1);
Insert into POCKET_TEMPLATE_CONFIG (VERSION,LASTUPDATETIME,UPDATEDBY,CREATETIME,CREATEDBY,SUBSCRIBERTYPE,BUSINESSPARTNERTYPE,KYCLEVEL,COMMODITY,POCKETTYPE,ISSUSPENCEPOCKET,ISCOLLECTORPOCKET,POCKETTEMPLATEID,ISDEFAULT) values (0,sysdate,'system',sysdate,'system',2,5,3,4,1,1,0,7,1);
Insert into PTC_GROUP_MAPPING (VERSION,LASTUPDATETIME,UPDATEDBY,CREATETIME,CREATEDBY,GROUPID,PTCID) values (0,sysdate,'System',sysdate,'System',1, (select id from POCKET_TEMPLATE_CONFIG where SUBSCRIBERTYPE=2 and BUSINESSPARTNERTYPE=4 and KYCLEVEL=3 and POCKETTYPE=1 and ISSUSPENCEPOCKET=1 and POCKETTEMPLATEID=7 and ISDEFAULT=1));
Insert into PTC_GROUP_MAPPING (VERSION,LASTUPDATETIME,UPDATEDBY,CREATETIME,CREATEDBY,GROUPID,PTCID) values (0,sysdate,'System',sysdate,'System',1, (select id from POCKET_TEMPLATE_CONFIG where SUBSCRIBERTYPE=2 and BUSINESSPARTNERTYPE=5 and KYCLEVEL=3 and POCKETTYPE=1 and ISSUSPENCEPOCKET=1 and POCKETTEMPLATEID=7 and ISDEFAULT=1));

commit;
