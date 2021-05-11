
//#if 511414715 
// Compilation Unit of /UMLStateMachineTransitionListModel.java 
 

//#if -984123845 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if 773971794 
import org.argouml.model.Model;
//#endif 


//#if 1846756370 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -1075688958 
public class UMLStateMachineTransitionListModel extends 
//#if 1692510622 
UMLModelElementListModel2
//#endif 

  { 

//#if 677553420 
protected void buildModelList()
    { 

//#if 338824327 
setAllElements(Model.getFacade().getTransitions(getTarget()));
//#endif 

} 

//#endif 


//#if -1915226816 
protected boolean isValidElement(Object element)
    { 

//#if -448830963 
return Model.getFacade().getTransitions(getTarget()).contains(element);
//#endif 

} 

//#endif 


//#if -2109450202 
public UMLStateMachineTransitionListModel()
    { 

//#if 1512928572 
super("transition");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

