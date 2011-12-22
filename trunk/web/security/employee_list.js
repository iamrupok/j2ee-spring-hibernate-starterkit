Ext.onReady(function(){

	var countryStore = new Ext.data.JsonStore({
	    	autoLoad: true,
	    	storeId: 'countryStore',  
	        url: '/ekit/employee/GetCountries.dbv',
	        root: 'countries',	        
	        fields:[
	  			{name:'id', type:'string'},
	  			{name:'name', type:'string'},
	  			{name:'isoCode', type:'string'}
	  		]
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
			
		var saveEmployee = function(oGrid_event){
		Ext.Ajax.request({
			waitMsg: 'Please wait...',
			url: '/ekit/employee/SaveEmployee.dbv',
			
			params: {
				jsonData: Ext.util.JSON.encode(oGrid_event.record.data),
				saveType: (oGrid_event.record.data.employeeId == "" ) ? "create" : "update"
			},
			success: function(response){
				if(Ext.decode(response.responseText).success == "true"){
					employeeDataStore.commitChanges();
					employeeDataStore.reload();
				} else {
					employeeDataStore.reload();
					Ext.MessageBox.alert("Message", "Couldn\'t save user");
				}
			},
			failure: function(response){
				employeeDataStore.reload();
				Ext.MessageBox.alert("Error", "There is a problem for saving user retry later again...");
			}
		})
	}
	
	
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
							editor: new Ext.form.ComboBox({
							store :countryStore,
							hiddenName : 'xmlType',
							valueField : 'name',
							displayField : 'name',
							emptyText : 'Please select user type...',
							triggerAction : 'all',
							width : 115,
							hideTrigger : false,
							editable : false,
							mode : 'local',
							enableKeyEvents: true,
							listeners: {'specialkey': function(field, e){
										if(e.getKey() == 9 || e.getKey() == 13) {
											employeeGrid.on("afteredit", saveEmployee);
											var itemIndex = employeeGrid.store.indexOf(employeeGrid.getSelectionModel().getSelected()) + 1;
											employeeGrid.getSelectionModel().selectRow(itemIndex);
											employeeGrid.startEditing(itemIndex,1);
										}
									},
									'blur': function(field, e){
										var itemIndex = employeeGrid.store.indexOf(employeeGrid.getSelectionModel().getSelected())
										if(employeeGrid.getStore().getAt(itemIndex).get("employeeId")   != "")
										{
											employeeGrid.on("afteredit", saveEmployee);
											var itemIndex = employeeGrid.store.indexOf(employeeGrid.getSelectionModel().getSelected()) + 1;
											employeeGrid.getSelectionModel().selectRow(itemIndex);
											employeeGrid.startEditing(itemIndex,1);
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
												employeeGrid.on("afteredit", saveEmployee);
												//employeeGrid.startEditing(itemIndex,5);
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
			tooltip: "Delete Selected Employee",
			handler:  function(){
				var itemIndex = employeeGrid.store.indexOf(employeeGrid.getSelectionModel().getSelected())
				if(employeeGrid.getStore().getAt(itemIndex).get("employeeId")   != ""){
				Ext.Ajax.request({
					waitMsg: 'Please wait...',
					url: '/ekit/employee/DeleteEmployee.dbv',
					params: {
							employeeId: eval(employeeGrid.getStore().getAt(itemIndex).get("employeeId"))
							},
					success: function(response){
							if(Ext.decode(response.responseText).success == "true"){
								employeeDataStore.commitChanges();
								employeeDataStore.reload();
							} else {
								employeeDataStore.reload();
								Ext.MessageBox.alert("Message", "Couldn\'t delete Employee");
							}
						},
						failure: function(response){
							employeeDataStore.reload();
							Ext.MessageBox.alert("Error", "There is a problem for deleting Employee retry later again...");
						}
					})
				}
			}
		},'-',{
			text: 'Search',
			tooltip: 'Advanced Search',
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