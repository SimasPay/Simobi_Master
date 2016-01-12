
  CREATE TABLE BRANCHCODES
   (ID NUMBER(19,0) NOT NULL PRIMARY KEY, 
	VERSION NUMBER(10,0) NOT NULL , 
	LASTUPDATETIME TIMESTAMP DEFAULT sysdate, 
	UPDATEDBY VARCHAR2(255), 
	CREATETIME TIMESTAMP DEFAULT sysdate NOT NULL , 
	CREATEDBY VARCHAR2(255) NOT NULL , 
	BRANCHCODE VARCHAR2(10) Not null, 
	BRANCHNAME VARCHAR2(200) NOT NULL 
   );

insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'002','KCU Thamrin ','System',1);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'003','KC Zainul Arifin ','System',2);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'004','KC Hasyim Ashari ','System',3);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'005','KCP ITC Cempaka Mas ','System',4);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'006','KC Mangga Dua ','System',5);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'007','KC Tanah Abang ','System',6);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'008','KCP Samanhudi ','System',7);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'009','KCP Roxy Mas ','System',8);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'010','KCP Kelapa Gading ','System',9);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'011','KCP Bumi Serpong Damai ','System',10);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'012','KC Abdul Rivai ','System',11);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'013','KCP Jamika ','System',12);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'014','KC Diponegoro Surabaya ','System',13);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'015','KC Medan ','System',14);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'016','KC Cirebon ','System',15);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'017','KC Manado - Sam Ratulangi ','System',16);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'018','KC Riau Pekanbaru ','System',17);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'019','KC Ringroad Yogyakarta ','System',18);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'020','KC Jambi ','System',19);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'021','KC Pengayoman Makasar ','System',20);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'022','KC Denpasar ','System',21);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'023','KC Semarang ','System',22);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'024','KC Purwokerto ','System',23);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'025','KC Pontianak ','System',24);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'026','KC Malang ','System',25);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'027','KC Jayapura ','System',26);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'028','KC Lampung ','System',27);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'029','KCP Manggis Makassar ','System',28);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'030','KC Batam ','System',29);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'031','KC Sorong ','System',30);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'032','KCP Depok ','System',31);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'033','KCP Serang ','System',32);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'034','KC Tasikmalaya ','System',33);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'035','KC Garut ','System',34);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'036','KCP Pindodeli Karawang ','System',35);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'037','KC Balikpapan ','System',36);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'038','KCP Mojokerto ','System',37);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'039','KC Magelang ','System',38);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'040','KC Mataram ','System',39);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'041','KC Palembang ','System',40);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'042','KCP Belilas ','System',41);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'043','KC Kudus ','System',42);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'044','KC Ambon ','System',43);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'045','KC Bengkulu ','System',44);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'046','KCP Surabaya - ITC ','System',45);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'047','KCP Gatsu Denpasar ','System',46);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'048','KC Banjarmasin ','System',47);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'049','KC Jember ','System',48);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'050','KC Tegal ','System',49);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'051','KCP Ahmad Yani - Bekasi ','System',50);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'052','KCP Perawang Pekanbaru ','System',51);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'053','KC Bogor-Pajajaran ','System',52);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'054','KC Kertabumi - Karawang ','System',53);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'055','KC Pekalongan ','System',54);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'056','KCP Tungkal Ulu Jambi ','System',55);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'057','KC Sukabumi ','System',56);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'058','KCP Jembatan Dua ','System',57);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'059','KCP Fatmawati ','System',58);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'060','KC Solo ','System',59);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'061','KCP Cibubur ','System',60);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'062','KCP Bintaro ','System',61);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'063','KCP Bandung MTC ','System',62);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'064','KC Madiun ','System',63);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'065','KCP Medan Asia ','System',64);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'066','KCP Medan Krakatau ','System',65);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'067','KC Kediri ','System',66);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'068','KC Rantau Prapat ','System',67);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'069','KC Padang ','System',68);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'070','KCP Serpong Indah Kiat ','System',69);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'071','KC Ketapang ','System',70);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'072','KCP Malang Suprapto ','System',71);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'073','KCP Bandung Sudirman ','System',72);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'074','KCP Surabaya Kembang Jepun ','System',73);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'075','KC Mojokerto ','System',74);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'076','KC Palu ','System',75);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'077','KC Samarinda ','System',76);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'078','KCP Bogor Sudirman ','System',77);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'079','KC Banda Aceh ','System',78);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'080','KCP Sultan Agung Semarang ','System',79);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'081','KCP Summitmas ','System',80);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'082','KCP Mangga Besar ','System',81);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'083','KCP Batu Tulis Jakarta ','System',82);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'084','KC Kendari ','System',83);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'085','KC Semarang - Pemuda ','System',84);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'086','KC Kupang ','System',85);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'087','KCP Jakarta Cik Ditiro ','System',86);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'088','KCP Bogor - Tajur ','System',87);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'089','KCP Lampung - Tanjung Karang ','System',88);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'090','KCP Surabaya - Klampis ','System',89);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'091','KC Pangkal Pinang ','System',90);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'092','KCP Jakarta Ambasador ','System',91);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'093','KCP Bekasi Grand Wisata ','System',92);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'094','KCP Jakarta Danau Sunter ','System',93);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'095','KCP Green Office Park ','System',94);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'096','KCP Mayjen Sungkono ','System',95);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'097','KC Tanjung Pinang ','System',96);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'098','KCP Pontianak Sudirman ','System',97);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'099','KCP Palembang Letkol Iskandar ','System',98);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'100','KCP Palembang Sudirman ','System',99);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'101','KCP Kali Besar ','System',100);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'102','KCP Cilacap ','System',101);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'103','KC Lubuk Linggau ','System',102);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'104','KC Gresik ','System',103);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'105','KC Gorontalo ','System',104);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'106','KCP Riau Duri Pekanbaru ','System',105);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'107','KCP Medan Sisingamanagraja ','System',106);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'108','KC Bojonegoro ','System',107);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'109','KCP Jakarta Rawamangun ','System',108);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'110','KCP Permata Hijau ','System',109);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'111','KC Dumai ','System',110);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'112','KCP Depok -Cinere ','System',111);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'113','KCP Muara Bungo Jambi ','System',112);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'114','KCP Mataram Penjangik ','System',113);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'115','KCP Lubuk Linggau ','System',114);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'116','KCP Magelang Metro ','System',115);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'117','KCP Jakarta Puri Kembangan ','System',116);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'118','KCP BSD Alam Sutra ','System',117);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'119','KCP Jakarta Kelapa Gading 2 ','System',118);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'120','KCP Bekasi Delta Mas ','System',119);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'121','KCP Jakarta - Roxy Square ','System',120);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'122','KCP Sumedang-Rancaekek ','System',121);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'123','KCP Cirebon Grand Center ','System',122);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'124','KCP Balikpapan ','System',123);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'125','KC Salatiga ','System',124);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'126','KCP Sumedang Mayor Abdurachman ','System',125);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'127','KCP Slipi ','System',126);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'128','KCP Bogor Pasar Anyar ','System',127);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'129','KCP Malang Kepanjen ','System',128);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'130','KCP Pemalang ','System',129);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'131','KCP Tabanan ','System',130);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'132','KCP Tulung Agung ','System',131);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'133','KCP Permata Kuningan ','System',132);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'134','KCP Bandung Ujung Berung ','System',133);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'135','KCP Bangka Sungai Liat ','System',134);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'142','KCP Cikampek ','System',135);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'143','KCP PGC Cililitan ','System',136);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'144','KC Batu Licin ','System',137);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'145','KC Palangkaraya ','System',138);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'146','KCP Buah Batu ','System',139);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'147','KCP Banjar - Ciamis ','System',140);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'148','KCP Tegal Adiwerna ','System',141);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'149','KCP Purbalingga ','System',142);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'150','KCP Sampit ','System',143);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'151','KCP Tanjung Duren ','System',144);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'152','KC Ternate ','System',145);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'154','KC Banyuwangi ','System',146);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'155','KCP Semarang Majapahit ','System',147);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'156','KCP Bandung - Lembang ','System',148);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'157','KCP Subang ','System',149);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'158','KCP Cianjur ','System',150);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'159','KCP Temanggung ','System',151);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'160','KCP Cimahi ','System',152);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'161','KCP Jambi - Pattimura ','System',153);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'162','KCP Veteran - Purwakarta ','System',154);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'163','KCP Bandung - Kopo ','System',155);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'164','KCP Sukabumi ','System',156);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'165','KCP Klaten ','System',157);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'166','KCP Solo Baru ','System',158);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'167','KCP Semarang Banyumanik ','System',159);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'168','KC Mamuju ','System',160);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'169','KC Pematang Siantar ','System',161);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'170','KCP Ubud Bali ','System',162);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'171','KC Belitung ','System',163);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'172','KCP Katamso Yogyakarta ','System',164);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'173','KCP Season City ','System',165);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'174','KC Singaraja Bali ','System',166);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'175','KCP Otista Tangerang ','System',167);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'176','KCP Lombok Timur ','System',168);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'177','KCP Banjarmasin ','System',169);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'178','KCP Sungai Danau ','System',170);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'179','KCP Kendal ','System',171);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'180','KCP Prabumulih ','System',172);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'181','KCP Pontianak Adisucipto ','System',173);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'182','KCP Pangkalan Bun ','System',174);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'183','KCP Ambon ','System',175);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'184','KC Padang Sidempuan ','System',176);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'185','KCP Medan Sisingamangaraja ','System',177);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'186','KCP Jend. Sudirman - Ciamis ','System',178);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'187','KCP Ahmad Karim - Bukittinggi ','System',179);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'188','KCP Siliwangi - Kuningan ','System',180);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'189','KCP KH. Abdul Halim - Majalengka ','System',181);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'190','KCP Babe Palar - Tomohon ','System',182);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'191','lebay Hasan - Muara Bungo ','System',183);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'192','KCP Veteran - Pare-Pare ','System',184);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'193','KCP Langsat - Bone ','System',185);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'194','KCP Lintas Sumatera - Sarolangun ','System',186);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'195','KCP Sudirman - Indramayu ','System',187);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'196','KCP Jend Sudirman - Wonogiri ','System',188);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'197','KCP Ngurah Rai - Badung ','System',189);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'198','KCP Melati - Ende ','System',190);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'199','KCP Lahat - Mayor Ruslan ','System',191);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'200','KCP Jend A. Yani - Baturaja ','System',192);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'201','KC Sibolga - Sisingamangaraja ','System',193);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'202','KC Bima ','System',194);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'203','KC Tarakan - Yos Sudarso ','System',195);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'204','KF Thamrin ','System',196);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'205','KCP Kebumen - Mayjend Sutoyo ','System',197);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'206','KCP Palopo - Lagaligo ','System',198);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'207','KCP Kolaka - Chairil Anwar ','System',199);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'208','KCP Bumiayu Tegal ','System',200);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'209','KC Merauke - Mandala ','System',201);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'210','KC Manokwari ','System',202);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'211','KCP Banggai - Luwuk ','System',203);
insert into branchcodes(version,branchcode,branchname,createdby,id) values(1,'212','KC Maumere - Jend Sudirman ','System',204);


ALTER TABLE mfino_user  ADD BRANCHCODEID NUMBER(10,0) DEFAULT 0;

commit;