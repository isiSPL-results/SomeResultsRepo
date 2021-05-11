
//#if -442511099 
// Compilation Unit of /PropPanelActor.java 
 

//#if 1583820527 
package org.argouml.uml.ui.behavior.use_cases;
//#endif 


//#if -2035888485 
import org.argouml.uml.ui.ActionNavigateContainerElement;
//#endif 


//#if 2027282571 
import org.argouml.uml.ui.foundation.core.PropPanelClassifier;
//#endif 


//#if -2030338282 
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
//#endif 


//#if 28282851 
public class PropPanelActor extends 
//#if 1156379156 
PropPanelClassifier
//#endif 

  { 

//#if -1671038807 
private static final long serialVersionUID = 7368183497864490115L;
//#endif 


//#if 1171824780 
public PropPanelActor()
    { 

//#if 845963048 
super("label.actor", lookupIcon("Actor"));
//#endif 


//#if 1826394570 
addField("label.name", getNameTextField());
//#endif 


//#if -221853242 
addField("label.namespace", getNamespaceSelector());
//#endif 


//#if 1535236289 
add(getModifiersPanel());
//#endif 


//#if -1820759667 
addSeparator();
//#endif 


//#if 672975271 
addField("label.generalizations", getGeneralizationScroll());
//#endif 


//#if -1060956987 
addField("label.specializations", getSpecializationScroll());
//#endif 


//#if -1109211739 
addSeparator();
//#endif 


//#if 2066249452 
addField("label.association-ends", getAssociationEndScroll());
//#endif 


//#if -540545125 
addAction(new ActionNavigateContainerElement());
//#endif 


//#if -1576464252 
addAction(new ActionNewActor());
//#endif 


//#if -1130712172 
addAction(getActionNewReception());
//#endif 


//#if 2083473033 
addAction(new ActionNewStereotype());
//#endif 


//#if 23579632 
addAction(getDeleteAction());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

