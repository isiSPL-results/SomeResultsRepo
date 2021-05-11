// Compilation Unit of /UMLAssociationAssociationRoleListModel.java 
 
package org.argouml.uml.ui.foundation.core;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementListModel2;
public class UMLAssociationAssociationRoleListModel extends UMLModelElementListModel2
  { 
protected void buildModelList()
    { 
if(getTarget() != null)//1
{ 
setAllElements(Model.getFacade().getAssociationRoles(getTarget()));
} 

} 

public UMLAssociationAssociationRoleListModel()
    { 
super("associationRole");
} 

protected boolean isValidElement(Object o)
    { 
return Model.getFacade().isAAssociationRole(o)
               && Model.getFacade().getAssociationRoles(getTarget()).contains(o);
} 

 } 


