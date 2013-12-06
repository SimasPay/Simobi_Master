/*jslint adsafe: false, bitwise: false, browser: true, cap: false, css: false, debug: false, eqeqeq: false, evil: true, forin: true, fragment: false, immed: false, laxbreak: true, newcap: false, nomen: false, on: false, onevar: false, passfail: false, plusplus: false, regexp: false, rhino: false, safe: false, sidebar: false, strict: false, sub: true, undef: false, white: false, widget: false */
/*global Ext: true */

Ext.ns("mFino.widget");

mFino.widget.GroupViewForm = function (config) {
    var localConfig = Ext.apply({}, config);
    localConfig = Ext.applyIf(localConfig, {
        bodyStyle:'padding:5px 5px 0',
        frame : true
    });

    mFino.widget.GroupViewForm.superclass.constructor.call(this, localConfig);
};

Ext.extend(mFino.widget.GroupViewForm, Ext.FormPanel, {
    initComponent : function () {
        this.labelWidth = 200;
        this.labelPad = 20;
        this.items = [
          {
              layout:'column',
              items : [
              {
                  columnWidth: 1,
                  layout: 'form',
                  labelWidth : 120,
                  labelPad : 5,
                  items : [
                  {
                      xtype : 'displayfield',
                      fieldLabel: _("Name"),
                      labelSeparator:':',
                      name: CmFinoFIX.message.JSGroup.Entries.GroupName._name
                  },
                  {
                      xtype : 'displayfield',
                      fieldLabel: _("Description"),
                      labelSeparator:':',
                      name: CmFinoFIX.message.JSGroup.Entries.Description._name
                  }                  
                  ]
              }
              ]
          }
          ];

        mFino.widget.GroupViewForm.superclass.initComponent.call(this);
    },
    setRecord : function(record){
        this.getForm().reset();
        this.record = record;
        this.getForm().loadRecord(record);
        this.getForm().clearInvalid();  
    }

});

Ext.reg("GroupViewForm", mFino.widget.GroupViewForm);
