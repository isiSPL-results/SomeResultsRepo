
//#if -2107084980 
// Compilation Unit of /UMLEventTransitionListModel.java 
 

//#if -258645638 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if 639672337 
import org.argouml.model.Model;
//#endif 


//#if -1433222989 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if 1968260441 
public class UMLEventTransitionListModel extends 
//#if -1664577057 
UMLModelElementListModel2
//#endif 

  { 

//#if -970357555 
protected void buildModelList()
    { 

//#if -703857774 
removeAllElements();
//#endif 


//#if -1903023595 
addAll(Model.getFacade().getTransitions(getTarget()));
//#endif 

} 

//#endif 


//#if -1475267839 
protected boolean isValidElement(Object element)
    { 

//#if -782520571 
return Model.getFacade().getTransitions(getTarget()).contains(element);
//#endif 

} 

//#endif 


//#if 97010905 
public UMLEventTransitionListModel()
    { 

//#if 997958846 
super("transition");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

