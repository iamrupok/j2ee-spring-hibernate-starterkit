ValidationManager = Ext.extend(Ext.util.MixedCollection, {
	allowFunctions: true, // MixedCollection requirement
	
	components: new Array(),
	groups: new Array(),
	errors: new Array(),
		
	registerGroup: function(id, label) {
		this.groups[id] = label;
	},
	registerCmp: function(id, label, group, explanation) {
		var cmp = new Array();
		cmp['id'] = id;
		cmp['label'] = label;
		cmp['group'] = group;
		cmp['explanation'] = explanation;
		this.components[id] = cmp; // prevents duplicate registrations I guess		
	},
	getErrors: function() {
		this.doValidation();
		
		var errorStr = '';
		for(var i = 0; i < this.errors.length; i++)
			errorStr += this.errors[i];
		return errorStr;
	},
	doValidation: function() {
		this.errors = new Array();
		for(var i in this.components) {	
			if(i == 'remove')
				continue;
			
			var error = this.validateCmp(this.components[i]);
			if(error != '')
				this.errors[this.errors.length] = error; 
		}
		
		this.errors.sort();
	},
	getGroupLabel: function(id) {
		if(!this.groups[id])
			return '';
		return this.groups[id];
	},
	validateCmp: function(cmp) {
		var extCmp = Ext.getCmp(cmp['id']);
		
		if(!extCmp) { // object no longer exists
			this.components.remove(cmp);
			return '';
		}
		
		if(!extCmp.isValid) {
			this.components.remove(cmp);
			return '';
		}
		
		var groupLabel = this.getGroupLabel(cmp['group']);
				
		if(extCmp.isValid())
			return '';		
		
		var error = '<br>'+cmp['label'];
		if(groupLabel != '')
			error+' ('+groupLabel+')';
		if(cmp['explanation'] != undefined && cmp['explanation'] != null && cmp['explanation'] != '')
			error+' ['+cmp['explanation']+']';
				
		return error;
	}
});

validationMgr = new ValidationManager();

VTextField = Ext.extend(Ext.form.TextField, {
	constructor: function(config) {
		VTextField.superclass.constructor.call(this, config);
		
		if(!config.id)
			return;
		
		if(!config.allowBlank) // by default, lets require data
			this.allowBlank = false;
		
		var mgr = validationMgr;
		if(config.vMgr) // in case someone wants to use multiple validation managers
			mgr = vMgr;
		
		var id = config.id;
		var label = '';
		if(config.vLabel)
			label = config.vLabel;
		else if(config.fieldLabel)
			label = config.fieldLabel;
		var group = '';
		if(config.vGroup)
			group = config.vGroup;
		var explanation = '';
		if(config.vExplanation)
			explanation = config.vExplanation;
		
		mgr.registerCmp(id, label, group, explanation);
	}
});

VNumberField = Ext.extend(Ext.form.NumberField, {
	constructor: function(config) {
		VNumberField.superclass.constructor.call(this, config);
		
		if(!config.id)
			return;
		
		if(!config.allowBlank) // by default, lets require data
			this.allowBlank = false;
		
		var mgr = validationMgr;
		if(config.vMgr) // in case someone wants to use multiple validation managers
			mgr = vMgr;
		
		var id = config.id;
		var label = '';
		if(config.vLabel)
			label = config.vLabel;
		else if(config.fieldLabel)
			label = config.fieldLabel;
		var group = '';
		if(config.vGroup)
			group = config.vGroup;
		var explanation = '';
		if(config.vExplanation)
			explanation = config.vExplanation;
		
		mgr.registerCmp(id, label, group, explanation);
	}
});

VComboBox = Ext.extend(Ext.form.ComboBox, {
	constructor: function(config) {
		VComboBox.superclass.constructor.call(this, config);
		
		if(!config.id)
			return;
		
		if(!config.allowBlank) // by default, lets require data
			this.allowBlank = false;
		
		var mgr = validationMgr;
		if(config.vMgr) // in case someone wants to use multiple validation managers
			mgr = vMgr;
		
		var id = config.id;
		var label = '';
		if(config.vLabel)
			label = config.vLabel;
		else if(config.fieldLabel)
			label = config.fieldLabel;
		var group = '';
		if(config.vGroup)
			group = config.vGroup;
		var explanation = '';
		if(config.vExplanation)
			explanation = config.vExplanation;
		
		mgr.registerCmp(id, label, group, explanation);
	}
});


VHidden = Ext.extend(Ext.form.Hidden, {	
	constructor: function(config) {
		VHidden.superclass.constructor.call(this, config);
		
		if(!config.id)
			return;
		
		var mgr = validationMgr;
		if(config.vMgr) // in case someone wants to use multiple validation managers
			mgr = vMgr;
		
		var id = config.id;
		var label = '';
		if(config.vLabel)
			label = config.vLabel;
		var group = '';
		if(config.vGroup)
			group = config.vGroup;
		var explanation = '';
		if(config.vExplanation)
			explanation = config.vExplanation;
		
		mgr.registerCmp(id, label, group, explanation);
	},	
	isValid: function() {
		if(!this.value)
			return false;
		return true;
	}
});
