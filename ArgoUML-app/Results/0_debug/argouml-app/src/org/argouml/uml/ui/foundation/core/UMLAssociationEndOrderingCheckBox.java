
//#if 623481511 
// Compilation Unit of /UMLAssociationEndOrderingCheckBox.java 
 

//#if 1671160733 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -881905838 
import org.argouml.i18n.Translator;
//#endif 


//#if 1224766232 
import org.argouml.model.Model;
//#endif 


//#if 1340074593 
import org.argouml.uml.ui.UMLCheckBox2;
//#endif 


//#if -1082714539 
public class UMLAssociationEndOrderingCheckBox extends 
//#if -1682923230 
UMLCheckBox2
//#endif 

  { 

//#if -1359449162 
public UMLAssociationEndOrderingCheckBox()
    { 

//#if 1785412324 
super(Translator.localize("label.ordered"),
              ActionSetAssociationEndOrdering.getInstance(), "ordering");
//#endif 

} 

//#endif 


//#if 440056160 
public void buildModel()
    { 

//#if 1618990155 
if(getTarget() != null)//1
{ 

//#if -733210263 
Object associationEnd = getTarget();
//#endif 


//#if 1465319564 
setSelected(
                Model.getOrderingKind().getOrdered().equals(
                    Model.getFacade().getOrdering(associationEnd)));
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

