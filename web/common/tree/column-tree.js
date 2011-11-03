Ext.override(Ext.layout.FormLayout, {
    renderItem : function(c, position, target){
        if(c && !c.rendered && c.isFormField && c.inputType != 'hidden'){
            var args = [
                   c.id, c.fieldLabel,
                   c.labelStyle||this.labelStyle||'',
                   this.elementStyle||'',
                   typeof c.labelSeparator == 'undefined' ? this.labelSeparator : c.labelSeparator,
                   (c.itemCls||this.container.itemCls||'') + (c.hideLabel ? ' x-hide-label' : ''),
                   c.clearCls || 'x-form-clear-left' 
            ];
            if(typeof position == 'number'){
                position = target.dom.childNodes[position] || null;
            }
            if(position){
                c.formItem = this.fieldTpl.insertBefore(position, args, true);
            }else{
                c.formItem = this.fieldTpl.append(target, args, true);
            }

//          Remove the form layout wrapper on Field destroy.
            c.on('destroy', c.formItem.remove, c.formItem, {single: true});
            c.on('hide', c.formItem.hide, c.formItem, {single: false});
            c.on('show', c.formItem.show, c.formItem, {single: false});
            c.render('x-form-el-'+c.id);
        }else {
            Ext.layout.FormLayout.superclass.renderItem.apply(this, arguments);
        }
    }
});

Ext.onReady(function(){
	var form = new Ext.FormPanel({
		id: 'form-panel',
		frame: true,
		layout: 'table',
		width: 750,
		height: 400,
		layoutConfig: {
			columns: 2
		},
		items: [{
			xtype: 'treepanel',
			id: 'tree-panel',
			margins: '2 2 0 2',
			autoScroll: true,
			rootVisible: false,
			width: 240,
			height: 300,
			frame: true,
			root: {
				nodeType: 'async',	
				text: 'Products',
				draggable: false,
				id: '1'
			},
			useArrows:true,
			animate:true,
			enableDD:false,
			containerScroll:true,
			dataUrl: '/dbvendor/AjaxData?action=category_list',				
			plugins: [ new Ext.ux.plugins.TreePanelStatefull() ],
			listeners: {
				'render': function(tp) {
					tp.getSelectionModel().on('selectionchange', function(tree, node) {
						if (node.leaf) {
							Ext.getCmp('Save').disable();
							var myFieldSet = Ext.getCmp('field-id');
							for (var i=0; i<myFieldSet.items.length; i++) {
								myFieldSet.items.items[i].destroy();
							}
							if (node.attributes.details) {
								myFieldSet.add(new Ext.form.Hidden({id: 'category_select', name: 'category_select', value: node.id}));
								for (var i=0; i<node.attributes.details.length; i++) {
									var optionStore = new Ext.data.SimpleStore({
										fields:[{name:'id', type:'int'}, {name:'value', type:'string'}, {name: 'checked', type: 'bool'}]
									})

									var valueList = '';
									for (var j=0; j<node.attributes.details[i].choices.length; j++) {									
										var r = new Ext.data.Record({
											id: node.attributes.details[i].choices[j].id,
											value: node.attributes.details[i].choices[j].name,
											checked: (node.attributes.details[i].choices[j].selected) });
										if (node.attributes.details[i].choices[j].selected==true) {
											if (valueList.length > 0) valueList += ',';
											valueList += node.attributes.details[i].choices[j].id;
										}
										optionStore.add(r);
									}
									
									
									var lc = new Ext.ux.form.LovCombo({
										hideOnSelect:false,
										maxHeight:200,
										width: 300,
										displayField: 'value',
										valueField: 'id',
										store:optionStore,
										id: node.attributes.details[i].id, 
										name: node.attributes.details[i].name,
										fieldLabel: node.attributes.details[i].name, 
										mode:'local'
									});
									myFieldSet.add(lc);
									myFieldSet.doLayout();
									lc.setValue(valueList);									
								}
								Ext.getCmp('Save').enable();
							}
							myFieldSet.doLayout();							
						}
					})
				}
			}
		}, {
			xtype: 'fieldset',
			margins: '2 2 0 2',
			id: 'field-id',
			defaultType: 'textfield',
			width: 500,
			height: 300,
			containerScroll:true,
 			frame: true,
			buttons: [{
				id: 'Save',
				text: 'Save',
				type: 'submit',
				disabled: true,
				handler: function(){
				    form.getForm().submit({
				    	url: '/dbvendor/AjaxData?action=vendor_save', 
				    	success: function(form, action){
				    		Ext.getCmp('tree-panel').getRootNode().reload();
				    	}, 
				    	waitMsg:'Saving Data...'
				    });				    
				}
			}]
		}]
	});
	
	form.render('tree-ct');
	
});

