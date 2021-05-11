// Compilation Unit of /PropPanelUsage.java 
 
package org.argouml.uml.ui.foundation.core;
import org.argouml.i18n.Translator;
import org.argouml.uml.ui.ActionNavigateNamespace;
public class PropPanelUsage extends PropPanelDependency
  { 
private static final long serialVersionUID = 5927912703376526760L;
public PropPanelUsage()
    { 
super("label.usage", lookupIcon("Usage"));
addField(Translator.localize("label.name"), getNameTextField());
addField(Translator.localize("label.namespace"),
                 getNamespaceSelector());
addSeparator();
addField(Translator.localize("label.suppliers"),
                 getSupplierScroll());
addField(Translator.localize("label.clients"),
                 getClientScroll());
addAction(new ActionNavigateNamespace());
addAction(getDeleteAction());
} 

 } 


