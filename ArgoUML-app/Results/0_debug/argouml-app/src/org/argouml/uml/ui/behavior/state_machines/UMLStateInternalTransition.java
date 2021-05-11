
//#if 761561678 
// Compilation Unit of /UMLStateInternalTransition.java 
 

//#if 2036877979 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if 1474339762 
import org.argouml.model.Model;
//#endif 


//#if 1008532402 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -53994235 
public class UMLStateInternalTransition extends 
//#if 253422787 
UMLModelElementListModel2
//#endif 

  { 

//#if -1068773967 
protected void buildModelList()
    { 

//#if -1615157799 
setAllElements(Model.getFacade().getInternalTransitions(getTarget()));
//#endif 

} 

//#endif 


//#if -1142082587 
protected boolean isValidElement(Object element)
    { 

//#if -542504743 
return Model.getFacade().getInternalTransitions(getTarget())
               .contains(element);
//#endif 

} 

//#endif 


//#if 830085188 
public UMLStateInternalTransition()
    { 

//#if -382219507 
super("internalTransition");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

