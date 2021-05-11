
//#if -743665402 
// Compilation Unit of /PropPanelAbstraction.java 
 

//#if -1883184920 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -2088786019 
import org.argouml.i18n.Translator;
//#endif 


//#if -1717197861 
import org.argouml.uml.ui.ActionNavigateNamespace;
//#endif 


//#if -1723766518 
public class PropPanelAbstraction extends 
//#if 1671309235 
PropPanelDependency
//#endif 

  { 

//#if 754375791 
private static final long serialVersionUID = 595724551744206773L;
//#endif 


//#if -870520408 
public PropPanelAbstraction()
    { 

//#if -874605797 
super("label.abstraction", lookupIcon("Abstraction"));
//#endif 


//#if -1663705279 
addField(Translator.localize("label.name"), getNameTextField());
//#endif 


//#if -853425671 
addField(Translator.localize("label.namespace"),
                 getNamespaceSelector());
//#endif 


//#if 2088682144 
addSeparator();
//#endif 


//#if 401319116 
addField(Translator.localize("label.suppliers"),
                 getSupplierScroll());
//#endif 


//#if -138283732 
addField(Translator.localize("label.clients"),
                 getClientScroll());
//#endif 


//#if 1128767694 
addAction(new ActionNavigateNamespace());
//#endif 


//#if 820398019 
addAction(getDeleteAction());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

