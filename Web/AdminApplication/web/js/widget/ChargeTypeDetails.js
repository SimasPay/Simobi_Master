/*jslint adsafe: false, bitwise: false, browser: true, cap: false, css: false, debug: false, eqeqeq: false, evil: true, forin: true, fragment: false, immed: false, laxbreak: true, newcap: false, nomen: false, on: false, onevar: false, passfail: false, plusplus: false, regexp: false, rhino: false, safe: false, sidebar: false, strict: false, sub: true, undef: false, white: false, widget: false */
/*global Ext: true */

Ext.ns("mFino.widget");

mFino.widget.ChargeTypeDetails = function (config) {
    var localConfig = Ext.apply({}, config);
    localConfig = Ext.applyIf(localConfig, {
        bodyStyle:'padding:5px 5px 0',
        frame : true
    });
    mFino.widget.ChargeTypeDetails.superclass.constructor.call(this, localConfig);
};

Ext.extend(mFino.widget.ChargeTypeDetails, Ext.FormPanel, {
    initComponent : function () {
        this.labelWidth = 160;
        this.labelPad = 20;
        this.autoScroll = true;
        this.items = [ {
            layout:'column',
            items : [
            {
                columnWidth:0.5,
                layout: 'form',
                items : [
                {
                    xtype : 'displayfield',
                    fieldLabel: _("Charge Type ID"),
                    anchor : '95%',
                    name: CmFinoFIX.message.JSChargeType.Entries.ID._name
                },
                {
                    xtype: 'displayfield',
                    fieldLabel: _('Name'),
                    anchor:'95%',
                    name: CmFinoFIX.message.JSChargeType.Entries.Name._name
                },
                {
                    xtype: 'displayfield',
                    fieldLabel: _('Description'),
                    anchor:'95%',
                    name : CmFinoFIX.message.JSChargeType.Entries.Description._name
                }
                ]
            },
            {
                columnWidth:0.5,
                layout: 'form',
                items : [
                {
                    xtype: 'displayfield',
                    fieldLabel: _('Created By'),
                    anchor:'95%',
                    name: CmFinoFIX.message.JSChargeType.Entries.CreatedBy._name
                },
                {
                    xtype: 'displayfield',
                    fieldLabel: _('Updated By'),
                    anchor:'95%',
                    name: CmFinoFIX.message.JSChargeType.Entries.UpdatedBy._name
                },                
                {
                    xtype : 'displayfield',
                    fieldLabel: _('Creation Time'),
                    anchor : '95%',
                    renderer: "date",
                    name: CmFinoFIX.message.JSChargeType.Entries.CreateTime._name
                },
                {
                    xtype : 'displayfield',
                    fieldLabel: _('Last Update Time'),
                    anchor : '95%',
                    renderer: "date",
                    name: CmFinoFIX.message.JSChargeType.Entries.LastUpdateTime._name
                }                
                ]
            }
            ]
        }
        ];

        mFino.widget.ChargeTypeDetails.superclass.initComponent.call(this);
    },
    setRecord : function(record){
        this.getForm().reset();
        this.record = record;
        this.getForm().record = record;
        this.getForm().loadRecord(record);
        this.getForm().clearInvalid();
    },

    setStore : function(store){
        this.store = store;
    }
});

Ext.reg("chargetypeDetails", mFino.widget.ChargeTypeDetails);
