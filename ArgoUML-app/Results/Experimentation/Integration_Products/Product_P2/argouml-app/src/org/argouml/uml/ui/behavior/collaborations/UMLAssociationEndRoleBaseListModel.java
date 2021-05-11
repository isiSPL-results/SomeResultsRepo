package org.argouml.uml.ui.behavior.collaborations;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementListModel2;
public class UMLAssociationEndRoleBaseListModel extends UMLModelElementListModel2
  { 
protected void buildModelList()
    { 
removeAllElements();
if(getTarget() != null
                && Model.getFacade().getBase(getTarget()) != null)//1
{ 
addElement(Model.getFacade().getBase(getTarget()));
} 
} 
public UMLAssociationEndRoleBaseListModel()
    { 
super("base");
} 
protected boolean isValidElement(Object base)
    { 
if(!Model.getFacade().isAAssociationEnd(base))//1
{ 
return false;
} 
Object assocEndRole = getTarget();
Object assocRole =
            Model.getFacade().getAssociation(assocEndRole);
return Model.getFacade().getConnections(
                   Model.getFacade().getBase(assocRole))
               .contains(base);
} 

 } 
