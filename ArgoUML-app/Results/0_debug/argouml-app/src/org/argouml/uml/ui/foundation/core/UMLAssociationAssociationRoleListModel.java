
//#if -1220150101 
// Compilation Unit of /UMLAssociationAssociationRoleListModel.java 
 

//#if -68942576 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 15788299 
import org.argouml.model.Model;
//#endif 


//#if -1395148807 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -2138504802 
public class UMLAssociationAssociationRoleListModel extends 
//#if -805308420 
UMLModelElementListModel2
//#endif 

  { 

//#if 618042474 
protected void buildModelList()
    { 

//#if -1792020850 
if(getTarget() != null)//1
{ 

//#if -13496144 
setAllElements(Model.getFacade().getAssociationRoles(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1237357501 
public UMLAssociationAssociationRoleListModel()
    { 

//#if -1172202204 
super("associationRole");
//#endif 

} 

//#endif 


//#if 306298443 
protected boolean isValidElement(Object o)
    { 

//#if 1009139714 
return Model.getFacade().isAAssociationRole(o)
               && Model.getFacade().getAssociationRoles(getTarget()).contains(o);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

