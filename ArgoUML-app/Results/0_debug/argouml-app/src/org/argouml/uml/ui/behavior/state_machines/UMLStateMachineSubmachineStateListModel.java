
//#if 1426110791 
// Compilation Unit of /UMLStateMachineSubmachineStateListModel.java 
 

//#if 414466984 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if 1914168639 
import org.argouml.model.Model;
//#endif 


//#if -2041568187 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -57381950 
public class UMLStateMachineSubmachineStateListModel extends 
//#if 887461655 
UMLModelElementListModel2
//#endif 

  { 

//#if 1364274693 
protected void buildModelList()
    { 

//#if 1762692337 
setAllElements(Model.getFacade().getSubmachineStates(getTarget()));
//#endif 

} 

//#endif 


//#if -839947207 
protected boolean isValidElement(Object element)
    { 

//#if -2086561012 
return Model.getFacade().getSubmachineStates(getTarget())
               .contains(element);
//#endif 

} 

//#endif 


//#if 383847180 
public UMLStateMachineSubmachineStateListModel()
    { 

//#if -918640157 
super("submachineState");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

