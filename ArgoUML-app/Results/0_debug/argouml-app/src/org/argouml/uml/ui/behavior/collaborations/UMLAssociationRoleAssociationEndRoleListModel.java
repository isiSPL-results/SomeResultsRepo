
//#if -677816145 
// Compilation Unit of /UMLAssociationRoleAssociationEndRoleListModel.java 
 

//#if -998907156 
package org.argouml.uml.ui.behavior.collaborations;
//#endif 


//#if -167538729 
import org.argouml.model.Model;
//#endif 


//#if -526808915 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -1631906361 
public class UMLAssociationRoleAssociationEndRoleListModel extends 
//#if 699343951 
UMLModelElementListModel2
//#endif 

  { 

//#if 535166897 
public UMLAssociationRoleAssociationEndRoleListModel()
    { 

//#if 1520277036 
super("connection");
//#endif 

} 

//#endif 


//#if 2141282109 
protected void buildModelList()
    { 

//#if 644788470 
setAllElements(Model.getFacade().getConnections(getTarget()));
//#endif 

} 

//#endif 


//#if 639065438 
protected boolean isValidElement(Object o)
    { 

//#if -447328648 
return Model.getFacade().isAAssociationEndRole(o)
               && Model.getFacade().getConnections(getTarget()).contains(o);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

