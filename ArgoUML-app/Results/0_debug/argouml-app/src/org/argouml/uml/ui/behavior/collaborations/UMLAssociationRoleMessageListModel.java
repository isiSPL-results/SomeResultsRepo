
//#if 609294654 
// Compilation Unit of /UMLAssociationRoleMessageListModel.java 
 

//#if -502250731 
package org.argouml.uml.ui.behavior.collaborations;
//#endif 


//#if 257351296 
import org.argouml.model.Model;
//#endif 


//#if 1984638372 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -541579345 
public class UMLAssociationRoleMessageListModel extends 
//#if 565157196 
UMLModelElementListModel2
//#endif 

  { 

//#if 546509242 
protected void buildModelList()
    { 

//#if 1100485480 
setAllElements(Model.getFacade().getMessages(getTarget()));
//#endif 

} 

//#endif 


//#if -977414245 
protected boolean isValidElement(Object o)
    { 

//#if -1218310385 
return Model.getFacade().isAMessage(o)
               && Model.getFacade().getMessages(getTarget()).contains(o);
//#endif 

} 

//#endif 


//#if 536353299 
public UMLAssociationRoleMessageListModel()
    { 

//#if 1399023728 
super("message");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

