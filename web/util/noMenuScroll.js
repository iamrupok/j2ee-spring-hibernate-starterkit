Ext.override(Ext.menu.Menu, {
	initComponent: Ext.menu.Menu.prototype.initComponent.createSequence(function() {	
		if(!this.initialConfig.enableScrolling)
			this.enableScrolling = false;
	})
});