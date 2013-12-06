/*jslint adsafe: false, bitwise: false, browser: true, cap: false, css: false, debug: false, eqeqeq: false, evil: true, forin: true, fragment: false, immed: false, laxbreak: true, newcap: false, nomen: false, on: false, onevar: false, passfail: false, plusplus: false, regexp: false, rhino: false, safe: false, sidebar: false, strict: false, sub: true, undef: false, white: false, widget: false */
/*global Ext: true */

Ext.ns("mFino.widget");

mFino.widget.DenominationForm = function (config) {
    var localConfig = Ext.apply({}, config);
    localConfig = Ext.applyIf(localConfig, {
        bodyStyle:'padding:5px 5px 0',
        frame : true
    });
    mFino.widget.DenominationForm.superclass.constructor.call(this, localConfig);
};

Ext.extend(mFino.widget.DenominationForm, Ext.FormPanel, {
    initComponent : function () {
        this.labelWidth = 120;
        this.labelPad = 20;
        this.items = [
        {
            xtype : 'numberfield',
            fieldLabel: _("Denomination Amount"),
            allowBlank: false,
            allowNegative:false,
//            allowDecimals:true,
//            decimalPrecision : 2,
            name: CmFinoFIX.message.JSDenomination.Entries.DenominationAmount._name
        }
        ];
        mFino.widget.DenominationForm.superclass.initComponent.call(this);
        markMandatoryFields(this.form);
    },
    save : function(){
        if(this.getForm().isValid()){
            this.getForm().updateRecord(this.record);
            if(this.store){
                if(this.record.phantom
                    && this.store.getAt(0)!= this.record){
                    this.store.insert(0, this.record);
                }
                this.store.save();
            }
        }
    },
    setRecord : function(record){
        this.getForm().reset();
        this.record = record;
        this.getForm().loadRecord(record);
        this.getForm().clearInvalid();
    },
    setStore : function(store){
        if(this.store){
            this.store.un("update", this.onStoreUpdate, this);
        }
        this.store = store;
        this.store.on("update", this.onStoreUpdate, this);
    },

    onStoreUpdate: function(){
        this.setRecord(this.record);
    }
});
Ext.reg("Denominationform", mFino.widget.DenominationForm);
