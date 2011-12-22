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
	
	
	// create the UserGrid
	var checkBoxSelMod = new Ext.grid.CheckboxSelectionModel();
	var userListingEditorGrid = new Ext.grid.EditorGridPanel({
		store : userDataStore,
		id:"userListingEditorGrid",
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
					'specialkey': function(field, e){
						if(e.getKey() == 9 || e.getKey() == 13) {
							var itemIndex = userListingEditorGrid.store.indexOf(userListingEditorGrid.getSelectionModel().getSelected())
							if(userListingEditorGrid.getStore().getAt(itemIndex).get("id")   != ""){
								userListingEditorGrid.on("afteredit", saveUser);
							} else {
								userListingEditorGrid.un("afteredit", saveUser, this);
								userListingEditorGrid.startEditing(itemIndex,3);
							}
						}
					}
				}
			})
					
		}	,{
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
							if(userListingEditorGrid.getStore().getAt(itemIndex).get("id")   != ""){
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
							if(userListingEditorGrid.getStore().getAt(itemIndex).get("id")   != ""){
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
							if(userListingEditorGrid.getStore().getAt(itemIndex).get("id")   != ""){
								userListingEditorGrid.on("afteredit", saveUser);
							} else {
								userListingEditorGrid.un("afteredit", saveUser, this);
								userListingEditorGrid.startEditing(itemIndex,6);
							}
						}
					}
				}
			})
					
		},{
			header: "User Type",
			dataIndex: 'userType',
			width: 50,
			readOnly: false,
			editable: true,
			editor: new Ext.form.ComboBox({
				store : new Ext.data.ArrayStore({
					fields : ['typeId', 'typeText'],
					data : [["User",	'User'],["Admin",	'Admin']]
				}),
				hiddenName : 'xmlType',
				valueField : 'typeText',
				displayField : 'typeText',
				emptyText : 'Please select user type...',
				triggerAction : 'all',
				width : 115,
				hideTrigger : false,
				editable : false,
				mode : 'local',
				enableKeyEvents: true,
				listeners: {
					'specialkey': function(field, e){
						if(e.getKey() == 9 || e.getKey() == 13) {
							userListingEditorGrid.on("afteredit", saveUser);
							var itemIndex = userListingEditorGrid.store.indexOf(userListingEditorGrid.getSelectionModel().getSelected()) + 1;
							userListingEditorGrid.getSelectionModel().selectRow(itemIndex);
							userListingEditorGrid.startEditing(itemIndex,1);
						}
					},
					'blur': function(field, e){
						userListingEditorGrid.on("afteredit", saveUser);
						var itemIndex = userListingEditorGrid.store.indexOf(userListingEditorGrid.getSelectionModel().getSelected()) + 1;
						userListingEditorGrid.getSelectionModel().selectRow(itemIndex);
						userListingEditorGrid.startEditing(itemIndex,1);
					}
				}
			})
		}
		
		],
			stripeRows : true,
			height : 500,
			stateful : true,
			autoScroll : true,
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
			tooltip: "Delete Selected User",
			handler: function(){
				var itemIndex = userListingEditorGrid.store.indexOf(userListingEditorGrid.getSelectionModel().getSelected())
				if(userListingEditorGrid.getStore().getAt(itemIndex).get("id")   != ""){
					var id=userListingEditorGrid.getStore().getAt(itemIndex).get("id");
					Ext.Ajax.request({
					waitMsg: 'Please wait...',
					url: 'DeleteUser.dbv',
			
					params: {
							id: userListingEditorGrid.getStore().getAt(itemIndex).get("id")
							},
					success: function(response){
							if(Ext.decode(response.responseText).success == "true"){
								userDataStore.commitChanges();
								userDataStore.reload();
							} else {
								userDataStore.reload();
								Ext.MessageBox.alert("Message", "Couldn\'t delete user");
							}
						},
						failure: function(response){
							userDataStore.reload();
							Ext.MessageBox.alert("Error", "There is a problem for deleting user retry later again...");
						}
					})
				}
			}
		},'-','Search by UserName.',
		{
		                 xtype: 'textfield',
		                 name: 'searchField',
		                 id:'searchField',
		                 hideLabel: true,
		                 width: 200,
		                 enableKeyEvents: true,
		                 listeners: {
		                     keypress: {
		                     	fn: onTextFieldChange,
		                         scope: this,
		                         buffer: 100
		                     }
		                 }
		            }
		],
		viewConfig : {
			forceFit : true
		}

	});
	
	
	  function onTextFieldChange() {

     	var searchValue = document.getElementById("searchField").value;
     	var grid = Ext.getCmp("userListingEditorGrid");
     	grid.getStore().setBaseParam("task", searchValue);
     	
     	if(Ext.EventObject.getCharCode()==13) {
     			
     	  		grid.getStore().reload();	
     	}
     }
     

	var userpanel = new Ext.Panel({
			renderTo : 'user-List',
			width : 937,
			defaults : {
				height : 550,
				collapsible : true,
				border : false,
				titleCollapse : true
			},
			items : [
				new Ext.Panel({
					title : 'Users',
					items : [userListingEditorGrid]
				})
			]
		});
		
	

});