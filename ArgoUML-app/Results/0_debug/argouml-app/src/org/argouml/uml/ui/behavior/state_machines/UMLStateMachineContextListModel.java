
//#if -62105631 
// Compilation Unit of /UMLStateMachineContextListModel.java 
 

//#if -749942327 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if -1731328544 
import org.argouml.model.Model;
//#endif 


//#if 516448836 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if 723727006 
public class UMLStateMachineContextListModel extends 
//#if -1166352452 
UMLModelElementListModel2
//#endif 

  { 

//#if -626593698 
protected boolean isValidElement(Object element)
    { 

//#if -421536904 
return element == Model.getFacade().getContext(getTarget());
//#endif 

} 

//#endif 


//#if 1146107116 
public UMLStateMachineContextListModel()
    { 

//#if -587432702 
super("context");
//#endif 

} 

//#endif 


//#if 68656170 
protected void buildModelList()
    { 

//#if 141796243 
removeAllElements();
//#endif 


//#if 1272676640 
addElement(Model.getFacade().getContext(getTarget()));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

