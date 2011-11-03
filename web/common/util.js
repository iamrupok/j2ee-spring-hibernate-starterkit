HelpTextField = Ext.extend(Ext.form.TextField, {
  constructor: function(config) {
    HelpTextField.superclass.constructor.call(this, config);
    
    if(!config.help)
      return;
    
    if(!config.hideLabel)
    	this.hideLabel = true;
    
    this.setValue(config.help);
    this.addClass('x-form-empty-field');
           
    this.on('focus', function() {    	
      if(this.getValue() == config.help) {
        this.removeClass('x-form-empty-field');
    	this.setValue('');        
      }
    });      
     
    this.on('blur', function() {
      if(this.getValue() == '') {
    	this.addClass('x-form-empty-field');
        this.setValue(config.help);
      }
    });
  },
  afterRender: Ext.form.Field.prototype.afterRender.createSequence(function(){      
	  if(this.help){
		if(typeof this.help == 'object') {
          Ext.QuickTips.register(Ext.apply({
            target: this.el
          }, this.help));          
		} else {		  
		  this.el.dom.qtip = this.help;	
		}
      }
  })
});
HelpTextArea = Ext.extend(Ext.form.TextArea, {
  constructor: function(config) {
    HelpTextField.superclass.constructor.call(this, config);
    
    if(!config.help)
      return;
    
    if(!config.hideLabel)
    	this.hideLabel = true;
    
    this.setValue(config.help);
    this.addClass('x-form-empty-field');
           
    this.on('focus', function() {    	
      if(this.getValue() == config.help) {
        this.removeClass('x-form-empty-field');
    	this.setValue('');        
      }
    });      
     
    this.on('blur', function() {
      if(this.getValue() == '') {
    	this.addClass('x-form-empty-field');
        this.setValue(config.help);
      }
    });
  },
  afterRender: Ext.form.Field.prototype.afterRender.createSequence(function(){      
	  if(this.help){
		if(typeof this.help == 'object') {
          Ext.QuickTips.register(Ext.apply({
            target: this.el
          }, this.help));          
		} else {		  
		  this.el.dom.qtip = this.help;	
		}
      }
  })
});
Ext.QuickTips.init();