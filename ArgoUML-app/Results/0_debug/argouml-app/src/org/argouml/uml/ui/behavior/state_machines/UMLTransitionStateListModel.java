
//#if -1957629981 
// Compilation Unit of /UMLTransitionStateListModel.java 
 

//#if 104986702 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if -1802114843 
import org.argouml.model.Model;
//#endif 


//#if 1249444959 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -113361888 
public class UMLTransitionStateListModel extends 
//#if -302917218 
UMLModelElementListModel2
//#endif 

  { 

//#if 949041931 
public UMLTransitionStateListModel()
    { 

//#if -2037327489 
super("state");
//#endif 

} 

//#endif 


//#if -1661983424 
protected boolean isValidElement(Object element)
    { 

//#if 480028850 
return Model.getFacade().getState(getTarget()) == element;
//#endif 

} 

//#endif 


//#if 1306187020 
protected void buildModelList()
    { 

//#if -364643885 
removeAllElements();
//#endif 


//#if -725064386 
addElement(Model.getFacade().getState(getTarget()));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

