/*jslint adsafe: false, bitwise: false, browser: true, cap: false, css: false, debug: false, eqeqeq: false, evil: true, forin: true, fragment: false, immed: false, laxbreak: true, newcap: false, nomen: false, on: false, onevar: false, passfail: false, plusplus: false, regexp: false, rhino: false, safe: false, sidebar: false, strict: false, sub: true, undef: false, white: false, widget: false */
/*global Ext: true */

Ext.ns("mFino.widget");

/*
 * @param config dataUrl is the base url to get data
 */
mFino.widget.CCReviewerGrid = function (config) {
    var localConfig = Ext.apply({}, config);
    if(!localConfig.store){
        localConfig.store = new FIX.FIXStore(config.dataUrl, CmFinoFIX.message.JSUsers);
    }

    this.action = new Ext.ux.grid.RowActions({
        header:'',
        keepSelection:true,
        actions:[{
            iconCls:'mfino-button-View',
            tooltip: _('View User Details')
        }
        ]
    });
    var sbun = new Ext.Toolbar.Button({
//      pressed: true,
      enableToggle: false,
      text: _('Export to Excel'),
      iconCls: 'mfino-button-excel',
      tooltip : _('Export data to Excel Sheet'),
      handler : this.onDownload.createDelegate(this)
  });
    localConfig = Ext.applyIf(localConfig || {}, {
        dataUrl : "fix.htm",
        layout : 'fit',
        frame:true,
        loadMask : true,
        viewConfig: { emptyText: Config.grid_no_data },
        bbar: new Ext.PagingToolbar({
            store: localConfig.store,
            displayInfo: true,
            pageSize: CmFinoFIX.PageSize.Default,
            items: [sbun]
        }),
        sm: new Ext.grid.RowSelectionModel({
            singleSelect: true
        }),
        autoScroll : true,
        plugins:[this.action],
        listeners : {
            render : function(){
                this.fireEvent("defaultSearch");
            }
        },
        columns: [
        this.action,
        {
            header: _("User Name"),
            dataIndex: CmFinoFIX.message.JSUsers.Entries.Username._name
        },
        {
            header: _("First Name"),
            dataIndex: CmFinoFIX.message.JSUsers.Entries.FirstName._name
        },
        {
            header: _("Last Name"),
            dataIndex: CmFinoFIX.message.JSUsers.Entries.LastName._name
        },
        {
            header: _("Role"),
            width : 150,
            dataIndex: CmFinoFIX.message.JSUsers.Entries.RoleText._name
        },
        {
            header: _("Status"),
            width : 150,
            dataIndex: CmFinoFIX.message.JSUsers.Entries.UserStatusText._name
        },
        {
            header: _("Security Lock"),
            dataIndex: CmFinoFIX.message.JSUsers.Entries.UserSecurityLocked._name
        },
        {
            header: _("Suspend"),
            dataIndex: CmFinoFIX.message.JSUsers.Entries.UserSuspended._name
        },
        {
            header: _("Created On"),
            anchor : '100%',
            renderer : 'date',
            width : 150,
            dataIndex: CmFinoFIX.message.JSUsers.Entries.CreateTime._name
        },
        {
            header: _("Created By"),
            dataIndex: CmFinoFIX.message.JSUsers.Entries.CreatedBy._name
        },
        {
            header: _("Activation Time"),
            renderer: "date",
            dataIndex: CmFinoFIX.message.JSUsers.Entries.UserActivationTime._name
        },
        {
            header: _("Rejection Time"),
            renderer: "date",
            dataIndex: CmFinoFIX.message.JSUsers.Entries.RejectionTime._name
        },
        {
            header: _("Confirmation Time"),
            renderer: "date",
            dataIndex: CmFinoFIX.message.JSUsers.Entries.ConfirmationTime._name
        },{
            header: _("Expiration Time"),
            renderer: "date",
            dataIndex: CmFinoFIX.message.JSUsers.Entries.ExpirationTime._name
        }
        ]
    });

    mFino.widget.CCReviewerGrid.superclass.constructor.call(this, localConfig);   
};

Ext.extend(mFino.widget.CCReviewerGrid, Ext.grid.GridPanel, {
    initComponent : function () {
        if(this.store){
            this.store.on("load", this.onStoreChange.createDelegate(this));
            this.store.on("update", this.onStoreChange.createDelegate(this));
        }
        this.addEvents("download");
        mFino.widget.CCReviewerGrid.superclass.initComponent.call(this);
    },
    onStoreChange : function(){
        if(this.store.getAt(0) && (!(this.getSelectionModel().getSelected()))){
            this.getSelectionModel().selectFirstRow();
        }
    },
    onDownload:function(){
        this.fireEvent("download");
    }
});
Ext.reg("ccreviewergrid", mFino.widget.CCReviewerGrid);
