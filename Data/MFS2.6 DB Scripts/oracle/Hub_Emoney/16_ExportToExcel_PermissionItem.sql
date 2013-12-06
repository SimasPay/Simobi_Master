﻿DELETE FROM permission_item where Permission in (10242,12115,10422,10243);

INSERT INTO permission_item (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Permission, ItemType, ItemID, FieldID, Action) VALUES ('1',sysdate,'system',sysdate,'system','10242','1','subscriberlist.download.excel','All','default');

INSERT INTO permission_item (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Permission, ItemType, ItemID, FieldID, Action) VALUES ('1',sysdate,'system',sysdate,'system','12115','1','servicepartnerlist.download.excel','All','default');

INSERT INTO permission_item (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Permission, ItemType, ItemID, FieldID, Action) VALUES ('1',sysdate,'system',sysdate,'system','10422','1','txngrid.download.excel','All','default');

INSERT INTO permission_item (VERSION, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Permission, ItemType, ItemID, FieldID, Action) VALUES ('1',sysdate,'system',sysdate,'system','10243','1','sub.pockettxn.download.excel','All','default');

DELETE FROM role_permission where Permission in (10242,12115,10422,10243);

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','1','10242');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','1','12115');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','1','10422');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','1','10243');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','2','10242');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','2','12115');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','2','10422');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','2','10243');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','3','10242');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','3','12115');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','3','10422');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','3','10243');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','4','10242');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','4','12115');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','4','10422');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','4','10243');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','5','10242');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','5','12115');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','5','10422');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','5','10243');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','6','10242');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','6','12115');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','6','10422');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','6','10243');


INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','7','10242');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','7','12115');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','7','10422');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','7','10243');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','8','10242');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','8','12115');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','8','10422');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','8','10243');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','10','10242');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','10','12115');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','10','10422');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','10','10243');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','11','10242');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','11','12115');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','11','10422');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','11','10243');


INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','12','10242');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','12','12115');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','12','10422');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','12','10243');


INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','13','10242');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','13','12115');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','13','10422');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','13','10243');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','16','10242');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','16','12115');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','16','10422');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','16','10243');


INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','17','10242');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','17','12115');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','17','10422');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','17','10243');



INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','19','10242');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','19','12115');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','19','10422');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','19','10243');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','26','10242');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','26','12115');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','26','10422');

INSERT INTO role_permission (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, Role, Permission) VALUES ('1',sysdate,'system',sysdate,'system','26','10243');

commit;