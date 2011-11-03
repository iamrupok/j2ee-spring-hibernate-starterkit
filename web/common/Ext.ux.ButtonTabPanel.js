Ext.ns('Ext.ux');



Ext.ux.ButtonTabPanel = Ext.extend(Ext.TabPanel, {

    onRender : function(ct, position) {

        Ext.ux.ButtonTabPanel.superclass.onRender.apply(this, arguments);

        var butEl = this.edge.insertSibling({

            tag: "li"

        });

        new Ext.Button(Ext.apply({

            renderTo: butEl

        }, this.button));

    },



    findTargets : function(e) {

        var item = null;

        var itemEl = e.getTarget("li", this.strip);

        if (itemEl) {

            item = this.getComponent(itemEl.id.split(this.idDelimiter)[1]);

            if (item && item.disabled) {

                return {

                    close : null,

                    item : null,

                    el : null

                };

            }

        }

        return {

            close : e.getTarget(".x-tab-strip-close", this.strip),

            item : item,

            el : itemEl

        }

    }

});



Ext.reg('buttontabpanel', Ext.ux.ButtonTabPanel); 