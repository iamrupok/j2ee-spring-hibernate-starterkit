
Ext.onReady(function() {

	function change(val) {
		if (val > 0) {
			return '<span style="color:green;">' + val + '</span>';
		} else if (val < 0) {
			return '<span style="color:red;">' + val + '</span>';
		}
		return val;
	}

	function renderView(v, p, record) {
		
		return 	" <a  href='EditEmployee.dbv?employeeId="+record.get('employeeId')+"'>Edit"+ '</a>' 
		 +" <a  href='DeleteEmployee.dbv?employeeId="+record.get('employeeId')+"'>Delete"+ '</a>';
				
	}

	
	
  var store = new Ext.data.Store({
				url : "/ekit/employee/LoadEmployeeList.dbv",
				reader : new Ext.data.JsonReader({
							root : "employeeList",
							id : "employeeId",
							totalProperty : 'totalCount'
						}, ["employeeId","lastName","firstName","address","country","homePhone","title","reportsTo","edit"]),
				autoLoad : true
			});

	// create the Grid
	var checkBoxSelMod = new Ext.grid.CheckboxSelectionModel();
	var grid = new Ext.grid.GridPanel({
				store : store,
				selModel : checkBoxSelMod,
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
						}, {
							header : '',
							width : 150,
							sortable : true,
							renderer:renderView,
							align : 'left'
						}],

				stripeRows : true,
				height : _LIST_PAGE_HEIGHT_GLOBAL,
				layout : 'fit',
				// config options for stateful behavior
				stateful : true,
				layout : 'fit',

				bbar : new Ext.PagingToolbar({
							store : store,
							pageSize : 15,
							displayInfo : true,
							displaymsg : 'Displaying {0} - {1} of {2}',
							emptyMsg : "No records found"
							

						}),
						
				viewConfig : {
					forceFit : true
				}

			});

	// render the grid to the specified div in the page
	grid.getView().scrollOffset = 0, grid.render('employee-historyList');


});