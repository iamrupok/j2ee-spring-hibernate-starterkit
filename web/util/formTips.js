Ext.QuickTips.init();

Ext.override(Ext.form.Field, {	
	afterRender: Ext.form.Field.prototype.afterRender.createSequence(function() {				
		if(!this.helpText)
			return;
		
		var div = this.getEl().up('div.x-form-item');
		if(!div)
			return;
		
		var label = div.down('label');
		if(!label)
			return;
		
		var dequote = function(str) {
			str = str.replace(/\'/g,'&#39;');
			str = str.replace(/\"/g,'&#34;');
			return str;
		}
		
		var labelString = dequote(this.fieldLabel)+' <img src="/dbvendor/images/question.gif" qtip="'+dequote(this.helpText)+'"/>';
		label.dom.innerHTML = label.dom.innerHTML.replace(this.fieldLabel, labelString);
	})
});

