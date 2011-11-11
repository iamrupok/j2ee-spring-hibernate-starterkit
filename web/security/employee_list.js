Ext.onReady(function(){

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
			
		
	var checkBoxSelModel = new Ext.grid.CheckboxSelectionModel();
	var employeeGrid = new Ext.grid.EditorGridPanel({
				store : employeeDataStore,
				id:"employeeDataStore",
				selModel : checkBoxSelModel,
				clicksToEdit: 2,
				
				columns : [{
								dataIndex: 'employeeId',
								header: "ID",
								width: 50
							},
							{
							header : 'FIRST NAME',
							width : 200,
							sortable : true,
							dataIndex : 'firstName',
							align : 'left',
							editable: true,
							editor: new Ext.form.TextField({
							enableKeyEvents: true,
								listeners: {
									'specialkey': function(field, e){
										if(e.getKey() == 9 || e.getKey() == 13) {
											var itemIndex = employeeGrid.store.indexOf(employeeGrid.getSelectionModel().getSelected())
											if(employeeGrid.getStore().getAt(itemIndex).get("employeeId")   != ""){
												employeeGrid.on("afteredit", saveEmployee);
											} else {
												employeeGrid.un("afteredit", saveEmployee, this);
												employeeGrid.startEditing(itemIndex,2);
											}
										}
									}
								}
							})
									
						}	, {
							id : 'distributor',
							header : 'LASTNAME',
							width : 150,
							sortable : true,
							dataIndex : 'lastName',
							align : 'left',
							editable: true,
							editor: new Ext.form.TextField({
							enableKeyEvents: true,
								listeners: {
									'specialkey': function(field, e){
										if(e.getKey() == 9 || e.getKey() == 13) {
											var itemIndex = employeeGrid.store.indexOf(employeeGrid.getSelectionModel().getSelected())
											if(employeeGrid.getStore().getAt(itemIndex).get("employeeId")   != ""){
												employeeGrid.on("afteredit", saveEmployee);
											} else {
												employeeGrid.un("afteredit", saveEmployee, this);
												employeeGrid.startEditing(itemIndex,3);
											}
										}
									}
								}
							})
									
						}, {
							header : 'ADDRESS',
							width : 100,
							sortable : true,
							dataIndex : 'address',
							align : 'left',
							editable: true,
							editor: new Ext.form.TextField({
							enableKeyEvents: true,
								listeners: {
									'specialkey': function(field, e){
										if(e.getKey() == 9 || e.getKey() == 13) {
											var itemIndex = employeeGrid.store.indexOf(employeeGrid.getSelectionModel().getSelected())
											if(employeeGrid.getStore().getAt(itemIndex).get("employeeId")   != ""){
												employeeGrid.on("afteredit", saveEmployee);
											} else {
												employeeGrid.un("afteredit", saveEmployee, this);
												employeeGrid.startEditing(itemIndex,4);
											}
										}
									}
								}
							})
									
						}, {
							header : 'COUNTRY',
							width : 150,
							sortable : true,
							dataIndex : 'country',
							align : 'left',editable: true,
							editor: new Ext.form.TextField({
							enableKeyEvents: true,
								listeners: {
									'specialkey': function(field, e){
										if(e.getKey() == 9 || e.getKey() == 13) {
											var itemIndex = employeeGrid.store.indexOf(employeeGrid.getSelectionModel().getSelected())
											if(employeeGrid.getStore().getAt(itemIndex).get("employeeId")   != ""){
												employeeGrid.on("afteredit", saveEmployee);
											} else {
												employeeGrid.un("afteredit", saveEmployee, this);
												employeeGrid.startEditing(itemIndex,5);
											}
										}
									}
								}
							})
									
						}, {
							header : 'HOME PHONE',
							width : 150,
							sortable : true,
							dataIndex : 'homePhone',
							align : 'left',
							editable: true,
							editor: new Ext.form.TextField({
							enableKeyEvents: true,
								listeners: {
									'specialkey': function(field, e){
										if(e.getKey() == 9 || e.getKey() == 13) {
											var itemIndex = employeeGrid.store.indexOf(employeeGrid.getSelectionModel().getSelected())
											if(employeeGrid.getStore().getAt(itemIndex).get("employeeId")   != ""){
												employeeGrid.on("afteredit", saveEmployee);
											} else {
												employeeGrid.un("afteredit", saveEmployee, this);
												employeeGrid.startEditing(itemIndex,6);
											}
										}
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


	
			var panel = new Ext.Panel({
			renderTo : 'employee-List',
			width : 937,
			defaults : {
				height : 550,
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