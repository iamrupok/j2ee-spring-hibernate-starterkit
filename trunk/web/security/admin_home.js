Ext.onReady(function(){
	var userDataStore = "";
	
	userDataStore = new Ext.data.Store({
		id: 'userDataStore',
		url: "LoadUser.dbv",
		baseParams:{task: "ALL"},
		reader: new Ext.data.JsonReader({
			root: 'userList',
			totalProperty: 'totalCount',
			id: 'id'
		},[
			{name: 'id', type: 'int', mapping: 'id'},
			{name: 'username', type: 'string', mapping: 'username'},
			{name: 'password', type: 'string', mapping: 'password'},
			{name: 'email', type: 'string', mapping: 'email'},
			{name: 'firstName', type: 'string', mapping: 'firstName'},
			{name: 'lastName', type: 'string', mapping: 'lastName'},
			{name: 'userType', type: 'string', mapping: 'userType'}
		]),
		autoLoad : true
	});
	
	
			
	
	var saveUser = function(oGrid_event){
		Ext.Ajax.request({
			waitMsg: 'Please wait...',
			url: 'SaveUser.dbv',
			
			params: {
				jsonData: Ext.util.JSON.encode(oGrid_event.record.data),
				saveType: (oGrid_event.record.data.id == "" ) ? "create" : "update"
			},
			success: function(response){
				if(Ext.decode(response.responseText).success == "true"){
					userDataStore.commitChanges();
					userDataStore.reload();
				} else {
					userDataStore.reload();
					Ext.MessageBox.alert("Message", "Couldn\'t save user");
				}
			},
			failure: function(response){
				userDataStore.reload();
				Ext.MessageBox.alert("Error", "There is a problem for saving user retry later again...");
			}
		})
	}
	
	// create the Grid
	var checkBoxSelMod = new Ext.grid.CheckboxSelectionModel();
	var userListingEditorGrid = new Ext.grid.EditorGridPanel({
		store : userDataStore,
		selModel : checkBoxSelMod,
		clicksToEdit: 2,
		columns : [
		{
			dataIndex: 'id',
			header: "ID",
			width: 50
		},{
			id : 'username',
			header : 'Username',
			width : 100,
			sortable : true,
			dataIndex : 'username',
			align : 'left',
			editable: true,
			editor: new Ext.form.TextField({
				enableKeyEvents: true,
				listeners: {
					'specialkey': function(field, e){
						if(e.getKey() == 9 || e.getKey() == 13) {
							var itemIndex = userListingEditorGrid.store.indexOf(userListingEditorGrid.getSelectionModel().getSelected())
							if(userListingEditorGrid.getStore().getAt(itemIndex).get("id")   != ""){
								userListingEditorGrid.on("afteredit", saveUser);
							} else {
								userListingEditorGrid.un("afteredit", saveUser, this);
								userListingEditorGrid.startEditing(itemIndex,2);
							}
						}
					}
				}
			})
		},{
			header: 'Password',
			dataIndex: 'password',
			width: 120,
			readOnly: false,
			editable: true,
			editor: new Ext.form.TextField({
				enableKeyEvents: true,
				listeners: {
					'focus' : function(field){
						this.setValue("");
					},
					'specialkey': function(field, e){
						if(e.getKey() == 9 || e.getKey() == 13) {
							var itemIndex = userListingEditorGrid.store.indexOf(userListingEditorGrid.getSelectionModel().getSelected())
							if(userListingEditorGrid.getStore().getAt(itemIndex).get("id") != ""){
								userListingEditorGrid.on("afteredit", saveUser);
							} else {
								userListingEditorGrid.un("afteredit", saveUser, this);
								userListingEditorGrid.startEditing(itemIndex,3);
							}
						}
					}
				}
			})
		},{
			header: "Email",
			dataIndex: 'email',
			width: 100,
			readOnly: false,
			editable: true,
			editor: new Ext.form.TextField({
				enableKeyEvents: true,
				listeners: {
					'specialkey': function(field, e){
						if(e.getKey() == 9 || e.getKey() == 13) {
							var itemIndex = userListingEditorGrid.store.indexOf(userListingEditorGrid.getSelectionModel().getSelected())
							if(userListingEditorGrid.getStore().getAt(itemIndex).get("id") != ""){
								userListingEditorGrid.on("afteredit", saveUser);
							} else {
								userListingEditorGrid.un("afteredit", saveUser, this);
								userListingEditorGrid.startEditing(itemIndex,4);
							}	
						}
					}
				}
			})
		},{
			header: "First Name",
			dataIndex: 'firstName',
			width: 100,
			readOnly: false,
			editable: true,
			editor: new Ext.form.TextField({
				enableKeyEvents: true,
				listeners: {
					'specialkey': function(field, e){
						if(e.getKey() == 9 || e.getKey() == 13) {
							var itemIndex = userListingEditorGrid.store.indexOf(userListingEditorGrid.getSelectionModel().getSelected())
							if(userListingEditorGrid.getStore().getAt(itemIndex).get("id") != ""){
								userListingEditorGrid.on("afteredit", saveUser);
							} else {
								userListingEditorGrid.un("afteredit", saveUser, this);
								userListingEditorGrid.startEditing(itemIndex,5);
							}
						}
					}
				}
			})
		},{
			header: "Last Name",
			dataIndex: 'lastName',
			width: 100,
			readOnly: false,
			editable: true,
			editor: new Ext.form.TextField({
				enableKeyEvents: true,
				listeners: {
					'specialkey': function(field, e){
						if(e.getKey() == 9 || e.getKey() == 13) {
							var itemIndex = userListingEditorGrid.store.indexOf(userListingEditorGrid.getSelectionModel().getSelected())
							if(userListingEditorGrid.getStore().getAt(itemIndex).get("id") != ""){
								userListingEditorGrid.on("afteredit", saveUser);
							} else {
								userListingEditorGrid.un("afteredit", saveUser, this);
								userListingEditorGrid.startEditing(itemIndex,6);
							}
						}
					}
				}
			})
		}
		],
		stripeRows : true,
		autoHeight : true,
		layout : 'fit',
		// config options for stateful behavior
		stateful : true,
		layout : 'fit',

		bbar : new Ext.PagingToolbar({
			store : userDataStore,
			pageSize : 15,
			displayInfo : true,
			displaymsg : 'Displaying {0} - {1} of {2}',
			emptyMsg : "No records found"

		}),
		tbar: [{
			text: "Add User",
			iconCls: "add",
			tooltip: "Add a new User",
			handler: function(){
				if(userListingEditorGrid.getStore().getAt(0).get("id") != ""){
					var User = userListingEditorGrid.getStore().recordType;
					var user = new User({
						id: '',
						username: '',
						password: '',
						email: '',
						firstName: '',
						lastName: '',
						supplierId:'',
						distributorId:'',
						userType: ''
					});
					userDataStore.insert(0, user);
					userListingEditorGrid.startEditing(0,1);
					userListingEditorGrid.getSelectionModel().selectRow(0);
				} else {
					userListingEditorGrid.startEditing(0,1);
				}
            }
		},'-',{
			text: "Delete Selection",
			iconCls: "delete",
			tooltip: "Delete Selected User"
			//handler: deleteUser
		},'-',{
			text: 'Search',
			tooltip: 'Advanced Search',
			//handler: searchUser
			iconCls:'searchsupliersbtn'
		}],
		viewConfig : {
			forceFit : true
		}

	});
	
	//var addUser = 
	// render the grid to the specified div in the page
	userListingEditorGrid.getView().scrollOffset = 0, userListingEditorGrid.render('userManagementGrid');	
});