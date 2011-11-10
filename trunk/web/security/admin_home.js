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
	
	 var employeeDataStore = new Ext.data.Store({
				url : "/ekit/employee/LoadEmployeeList.dbv",
				reader : new Ext.data.JsonReader({
							root : "employeeList",
							id : "employeeId",
							totalProperty : 'totalCount'
						}, [
								{name:'employeeId',type:'int',mapping:'employeeId'},
								{name:'lastName',type:'string',mapping:'lastName'},
								{name:'firstName',type:'string',mapping:'firstName'},
								{name:'address',type:'string',mapping:'address'},
								{name:'country',type:'string',mapping:'country'},
								{name:'homePhone',type:'string',mapping:'homePhone'},
								{name:'title',type:'string',mapping:'title'},
								{name:'reportsTo',type:'string',mapping:'reportsTo'}
								
							]),
				autoLoad : true
			});
			
	
	// create the UserGrid
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
			editable: true
			
		},{
			header: 'Password',
			dataIndex: 'password',
			width: 120,
			readOnly: false,
			editable: true
			
		},{
			header: "Email",
			dataIndex: 'email',
			width: 100,
			readOnly: false,
			editable: true
		},{
			header: "First Name",
			dataIndex: 'firstName',
			width: 100,
			readOnly: false,
			editable: true
		},{
			header: "Last Name",
			dataIndex: 'lastName',
			width: 100,
			readOnly: false,
			editable: true
		}
		],
			stripeRows : true,
			height : 200,
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
	

	
	
	var checkBoxSelModel = new Ext.grid.CheckboxSelectionModel();
	var employeeGrid = new Ext.grid.GridPanel({
				store : employeeDataStore,
				selModel : checkBoxSelModel,
				clicksToEdit: 2,
				columns : [{
							header : 'FIRST NAME',
							width : 200,
							sortable : true,
							dataIndex : 'firstName',
							align : 'left'
						}, {
							id : 'distributor',
							header : 'LASTNAME',
							width : 150,
							sortable : true,
							dataIndex : 'lastName',
							align : 'left'
						}, {
							header : 'ADDRESS',
							width : 100,
							sortable : true,
							dataIndex : 'address',
							align : 'left'
						}, {
							header : 'COUNTRY',
							width : 150,
							sortable : true,
							dataIndex : 'country',
							align : 'left'
						}, {
							header : 'HOME PHONE',
							width : 150,
							sortable : true,
							dataIndex : 'homePhone',
							align : 'left'
						}],

			stripeRows : true,
			height : 200,
			stateful : true,
			autoScroll : true,
			layout : 'fit',
			bbar : new Ext.PagingToolbar({
			store : employeeDataStore,
			pageSize : 15,
			displayInfo : true,
			displaymsg : 'Displaying {0} - {1} of {2}',
			emptyMsg : "No records found"

		}),
		tbar: [{
			text: "Add Employee",
			iconCls: "add",
			tooltip: "Add a new Employee",
			handler: function(){
				if(employeeGrid.getStore().getAt(0).get("employeeId") != ""){
					var Employee = employeeGrid.getStore().recordType;
					var employee = new Employee({
						employeeId: '',
						lastName: '',
						firstName: '',
						address: '',
						country: '',
						homePhone: '',
						title:'',
						reportsTo:''
					
					});
					employeeDataStore.insert(0, employee);
					employeeGrid.startEditing(0,1);
					employeeGrid.getSelectionModel().selectRow(0);
				} else {
					employeeGrid.startEditing(0,1);
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


			
			var panel1 = new Ext.Panel({
			renderTo : 'userManagementGrid',
			width : 937,
			defaults : {
				height : 250,
				collapsible : true,
				border : false,
				titleCollapse : true
			},
			items : [
				new Ext.Panel({
					title : 'User',
					items : [userListingEditorGrid]
				})
			]
		});
			var panel2 = new Ext.Panel({
			renderTo : 'employee-historyList',
			width : 937,
			defaults : {
				height : 250,
				collapsible : true,
				border : false,
				titleCollapse : true
			},
			items : [
				new Ext.Panel({
					title : 'Employee',
					items : [employeeGrid]
				})
			]
		});
		
	

});