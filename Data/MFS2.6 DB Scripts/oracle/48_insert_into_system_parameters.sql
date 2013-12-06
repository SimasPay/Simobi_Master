DELETE FROM system_parameters WHERE parametername='days.to.inactivate.of.active.subscriber.when.no.fundmovement';
INSERT INTO system_parameters (version, lastupdatetime, updatedby, createtime, createdby, parametername, parametervalue, description) VALUES (1,sysdate,'System',sysdate,'system','days.to.inactivate.of.active.subscriber.when.no.fundmovement','15','number of days to inactivate active subscriber when no fund movement is done after activation');

commit;