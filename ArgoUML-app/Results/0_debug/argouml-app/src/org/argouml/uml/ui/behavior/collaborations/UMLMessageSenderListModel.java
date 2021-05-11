
//#if 796548610 
// Compilation Unit of /UMLMessageSenderListModel.java 
 

//#if 1312566590 
package org.argouml.uml.ui.behavior.collaborations;
//#endif 


//#if -471550167 
import org.argouml.model.Model;
//#endif 


//#if -1885566821 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -1646013756 
public class UMLMessageSenderListModel extends 
//#if -1405632556 
UMLModelElementListModel2
//#endif 

  { 

//#if 179867473 
protected boolean isValidElement(Object elem)
    { 

//#if 1726279303 
return Model.getFacade().getSender(getTarget()) == elem;
//#endif 

} 

//#endif 


//#if 230076482 
protected void buildModelList()
    { 

//#if -34790583 
removeAllElements();
//#endif 


//#if 144573436 
addElement(Model.getFacade().getSender(getTarget()));
//#endif 

} 

//#endif 


//#if 70791457 
public UMLMessageSenderListModel()
    { 

//#if 1035176089 
super("sender");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

