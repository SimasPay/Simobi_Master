
DELETE FROM system_parameters WHERE ParameterName='bank.service.status';

INSERT INTO system_parameters (Version, LastUpdateTime, UpdatedBy, CreateTime, CreatedBy, ParameterName, ParameterValue, Description) VALUES (1,sysdate,'System',sysdate,'system','bank.service.status','true','Bank Status');

commit;