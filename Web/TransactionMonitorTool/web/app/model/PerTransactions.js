Ext.define('Mfino.model.PerTransactions', {
	extend: 'Ext.data.Model',
	fields : [ {
		name : 'transactionType'
	}, {
		name : 'successful',
		type : 'int'
	}, {
		name : 'pending',
		type : 'int'
	}, {
		name : 'failed',
		type : 'int'
	}, {
		name : 'processing',
		type : 'int'
	}]
});