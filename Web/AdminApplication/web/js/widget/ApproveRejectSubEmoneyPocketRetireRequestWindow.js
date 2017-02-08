/*jslint adsafe: false, bitwise: false, browser: true, cap: false, css: false, debug: false, eqeqeq: false, evil: true, forin: true, fragment: false, immed: false, laxbreak: true, newcap: false, nomen: false, on: false, onevar: false, passfail: false, plusplus: false, regexp: false, rhino: false, safe: false, sidebar: false, strict: false, sub: true, undef: false, white: false, widget: false */
/*global Ext: true */

Ext.ns("mFino.widget");

mFino.widget.ApproveRejectSubEmoneyPocketRetireRequestWindow = function (config){
    var localConfig = Ext.apply({}, config);
    localConfig = Ext.applyIf(localConfig, {
        modal:true,
        title : _("Approve/Reject  Emoney pocket/Subscriber Retire Request"),
        layout:'fit',
        floating: true,
        width:400,
        height:260,
        plain:true,
        closable: false,
        resizable: false
    });
    mFino.widget.ApproveRejectSubEmoneyPocketRetireRequestWindow.superclass.constructor.call(this, localConfig);
};

Ext.extend(mFino.widget.ApproveRejectSubEmoneyPocketRetireRequestWindow, Ext.Window, {
    initComponent : function(){
        this.buttons = [
        {
            text: _('Proceed'),
            handler: this.proceed.createDelegate(this)
        },
        {
            text: _('Cancel'),
            handler: this.cancel.createDelegate(this)
        }
        ];

        this.form = new Ext.form.FormPanel({
            frame : true,
            items : [
               {
            	   fieldLabel: 'Comment'
               },
               {
                xtype : 'textarea',
                itemId :'rcomment',
                fieldLabel : _('Comments'),
                allowBlank: false,
                hideLabel: true,
                labelSeparator :'',
                anchor : '100%'
               },
               {
                xtype: 'fieldset',
                title : _('Select One'),
                layout : 'column',
                autoHeight: true,
                anchor : '100%',
                columns: 1,
                items: [
                {
                    columnWidth: 0.5,
                    xtype : 'radio',
                    itemId : 'rapprove',
                    name: 'selectone',
                    anchor : '90%',
                    boxLabel: _('Approve')
                },
                {
                    columnWidth: 0.5,
                    xtype : 'radio',
                    itemId : 'rreject',
                    anchor : '90%',
                    name: 'selectone',
                    boxLabel: _('Reject')
                }]
            }]
        });
        this.items = [ this.form ];
        mFino.widget.ApproveRejectSubEmoneyPocketRetireRequestWindow.superclass.initComponent.call(this);
    },

    cancel : function(){
        this.hide();
    },
    
	proceed : function() {
		if(this.form.getForm().isValid()){
			if (this.form.find('itemId','rapprove')[0].checked || this.form.find('itemId','rreject')[0].checked) {
				if(this.form.find('itemId','rapprove')[0].checked) {
					Ext.Msg.confirm(_("Confirm?"), _("Are you sure want to Approve the request to retire e-money pocket/Subscriber ?"),
					function(btn){
						if(btn !== "yes"){
							return;
						}
						this.ok(this);
					}, this);
				} 
				else if(this.form.find('itemId','rreject')[0].checked) {
					Ext.Msg.confirm(_("Confirm?"), _("Are you sure want to Reject the request to retire e-money pocket/Subscriber ?"),
					function(btn){
						if(btn !== "yes"){
							return;
						}
						this.ok(this);
					}, this);					
				}
			}
			else {
				Ext.ux.Toast.msg(_("Error"), _("Please select one of the approval status."),5);				
			}
		}
		else{
            Ext.ux.Toast.msg(_("Error"), _("Please provide the comments."),5);
        }
	},    

    ok : function(){
		var msg = new CmFinoFIX.message.RetireSubscriberEmoneyPocket();
		msg.m_pComments = this.form.items.get('rcomment').getValue();
		msg.m_paction = "update";
		msg.m_pMDNID = this.record.data[CmFinoFIX.message.JSSubscriberMDN.Entries.ID._name];
		if(this.form.find('itemId','rapprove')[0].checked) {
			msg.m_pAdminAction = CmFinoFIX.AdminAction.Approve;
		} 
		else if(this.form.find('itemId','rreject')[0].checked) {
			msg.m_pAdminAction = CmFinoFIX.AdminAction.Reject;
		}
		var params = mFino.util.showResponse.getDisplayParam();
		mFino.util.fix.send(msg, params);
		this.hide();
		Ext.apply(params, {
		   success : function(response){
			   if(response.m_psuccess == true){
				   Ext.Msg.show({
					  title: _('Info'),
					  minProgressWidth:250,
					  msg: response.m_pErrorDescription,
					  buttons: Ext.MessageBox.OK,
					  multiline: false
				   });
			   }
			   else{
				   Ext.MessageBox.alert(_("Error"), _(response.m_pErrorDescription));   	   
			   }
		   }
		});				
	},
	
    setRecord : function(record){
        this.form.getForm().reset();
        this.record = record;
        this.form.getForm().loadRecord(record);
        this.form.getForm().clearInvalid();
    },

    setStore : function(store){
        this.store = store;
    }
});

Ext.reg("ApproveRejectSubEmoneyPocketRetireRequestWindow", mFino.widget.ApproveRejectSubEmoneyPocketRetireRequestWindow);