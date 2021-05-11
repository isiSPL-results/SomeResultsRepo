
//#if 2069671510 
// Compilation Unit of /UMLMessageReceiverListModel.java 
 

//#if 154029299 
package org.argouml.uml.ui.behavior.collaborations;
//#endif 


//#if -20315298 
import org.argouml.model.Model;
//#endif 


//#if 854482822 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -1608679425 
public class UMLMessageReceiverListModel extends 
//#if -1101412779 
UMLModelElementListModel2
//#endif 

  { 

//#if -785932312 
public UMLMessageReceiverListModel()
    { 

//#if 112170636 
super("receiver");
//#endif 

} 

//#endif 


//#if -1702916541 
protected void buildModelList()
    { 

//#if -635300508 
removeAllElements();
//#endif 


//#if 1923091335 
addElement(Model.getFacade().getReceiver(getTarget()));
//#endif 

} 

//#endif 


//#if 931238007 
protected boolean isValidElement(Object element)
    { 

//#if 1692057754 
return Model.getFacade().getReceiver(getTarget()) == element;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

