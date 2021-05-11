
//#if -2056164866 
// Compilation Unit of /UMLTransitionTargetListModel.java 
 

//#if -707693577 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if -975236338 
import org.argouml.model.Model;
//#endif 


//#if 1826160086 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -243273013 
public class UMLTransitionTargetListModel extends 
//#if -1040306618 
UMLModelElementListModel2
//#endif 

  { 

//#if 1743492584 
protected boolean isValidElement(Object element)
    { 

//#if -2139507965 
return element == Model.getFacade().getTarget(getTarget());
//#endif 

} 

//#endif 


//#if -986919805 
public UMLTransitionTargetListModel()
    { 

//#if 1471003577 
super("target");
//#endif 

} 

//#endif 


//#if -455305804 
protected void buildModelList()
    { 

//#if -787531780 
removeAllElements();
//#endif 


//#if -1881598259 
addElement(Model.getFacade().getTarget(getTarget()));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

