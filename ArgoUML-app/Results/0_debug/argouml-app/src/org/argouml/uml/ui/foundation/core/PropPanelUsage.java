
//#if -832658167 
// Compilation Unit of /PropPanelUsage.java 
 

//#if -722166879 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -1334695082 
import org.argouml.i18n.Translator;
//#endif 


//#if 1365645058 
import org.argouml.uml.ui.ActionNavigateNamespace;
//#endif 


//#if -210920148 
public class PropPanelUsage extends 
//#if 334952650 
PropPanelDependency
//#endif 

  { 

//#if -369803390 
private static final long serialVersionUID = 5927912703376526760L;
//#endif 


//#if -453021652 
public PropPanelUsage()
    { 

//#if 763839953 
super("label.usage", lookupIcon("Usage"));
//#endif 


//#if 348463511 
addField(Translator.localize("label.name"), getNameTextField());
//#endif 


//#if -773275549 
addField(Translator.localize("label.namespace"),
                 getNamespaceSelector());
//#endif 


//#if 194529526 
addSeparator();
//#endif 


//#if -1053208926 
addField(Translator.localize("label.suppliers"),
                 getSupplierScroll());
//#endif 


//#if 820640258 
addField(Translator.localize("label.clients"),
                 getClientScroll());
//#endif 


//#if 315803448 
addAction(new ActionNavigateNamespace());
//#endif 


//#if -376242279 
addAction(getDeleteAction());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

