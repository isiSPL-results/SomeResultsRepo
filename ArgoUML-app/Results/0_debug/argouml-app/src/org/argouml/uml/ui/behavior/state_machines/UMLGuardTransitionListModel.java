
//#if 1737259376 
// Compilation Unit of /UMLGuardTransitionListModel.java 
 

//#if 1341226888 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if -660483809 
import org.argouml.model.Model;
//#endif 


//#if 918185061 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -1747938692 
public class UMLGuardTransitionListModel extends 
//#if -357725433 
UMLModelElementListModel2
//#endif 

  { 

//#if -626653143 
protected boolean isValidElement(Object element)
    { 

//#if -1367542536 
return element == Model.getFacade().getTransition(getTarget());
//#endif 

} 

//#endif 


//#if 1278002390 
public UMLGuardTransitionListModel()
    { 

//#if -1417102310 
super("transition");
//#endif 

} 

//#endif 


//#if 958245365 
protected void buildModelList()
    { 

//#if 1744376488 
removeAllElements();
//#endif 


//#if 1670414813 
addElement(Model.getFacade().getTransition(getTarget()));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

