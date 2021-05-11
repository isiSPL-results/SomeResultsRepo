
//#if -902137882 
// Compilation Unit of /UMLStateMachineTopListModel.java 
 

//#if 1348344173 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if 1971359620 
import org.argouml.model.Model;
//#endif 


//#if 1138820896 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if 627804252 
public class UMLStateMachineTopListModel extends 
//#if 781055136 
UMLModelElementListModel2
//#endif 

  { 

//#if 2055077098 
public UMLStateMachineTopListModel()
    { 

//#if -368054561 
super("top");
//#endif 

} 

//#endif 


//#if -1297962174 
protected boolean isValidElement(Object element)
    { 

//#if -1171854453 
return element == Model.getFacade().getTop(getTarget());
//#endif 

} 

//#endif 


//#if 1561173774 
protected void buildModelList()
    { 

//#if -1981374506 
removeAllElements();
//#endif 


//#if -298118211 
addElement(Model.getFacade().getTop(getTarget()));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

