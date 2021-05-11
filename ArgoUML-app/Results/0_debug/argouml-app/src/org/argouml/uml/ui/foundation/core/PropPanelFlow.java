
//#if -1048237958 
// Compilation Unit of /PropPanelFlow.java 
 

//#if -1644739404 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 1401722729 
import org.argouml.i18n.Translator;
//#endif 


//#if 634199062 
public class PropPanelFlow extends 
//#if -1988144569 
PropPanelRelationship
//#endif 

  { 

//#if 1475646847 
private static final long serialVersionUID = 2967789232647658450L;
//#endif 


//#if -1439540747 
public PropPanelFlow()
    { 

//#if -1979337258 
super("label.flow", lookupIcon("Flow"));
//#endif 


//#if 3439141 
initialize();
//#endif 

} 

//#endif 


//#if -1968139946 
private void initialize()
    { 

//#if -1570319905 
addField(Translator.localize("label.name"), getNameTextField());
//#endif 


//#if 1003807003 
addField(Translator.localize("label.namespace"),
                 getNamespaceSelector());
//#endif 


//#if 1326740490 
addField(Translator.localize("label.constraints"),
                 getConstraintScroll());
//#endif 


//#if 1959176510 
addSeparator();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

