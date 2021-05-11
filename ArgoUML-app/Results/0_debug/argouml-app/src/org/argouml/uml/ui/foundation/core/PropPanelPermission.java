
//#if -1717221344 
// Compilation Unit of /PropPanelPermission.java 
 

//#if -599761607 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 1594164462 
import org.argouml.i18n.Translator;
//#endif 


//#if 4315754 
import org.argouml.uml.ui.ActionNavigateNamespace;
//#endif 


//#if -1835332932 
public class PropPanelPermission extends 
//#if 694448048 
PropPanelDependency
//#endif 

  { 

//#if -482906931 
private static final long serialVersionUID = 5724713380091275451L;
//#endif 


//#if -267747220 
public PropPanelPermission()
    { 

//#if -915800707 
super("label.permission", lookupIcon("Permission"));
//#endif 


//#if 449382263 
addField(Translator.localize("label.name"), getNameTextField());
//#endif 


//#if 1371108995 
addField(Translator.localize("label.namespace"),
                 getNamespaceSelector());
//#endif 


//#if -671912234 
addSeparator();
//#endif 


//#if 896617602 
addField(Translator.localize("label.suppliers"),
                 getSupplierScroll());
//#endif 


//#if -980686878 
addField(Translator.localize("label.clients"),
                 getClientScroll());
//#endif 


//#if 1510210904 
addAction(new ActionNavigateNamespace());
//#endif 


//#if -788112007 
addAction(getDeleteAction());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

