package org.argouml.uml.ui.foundation.core;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementListModel2;
public class UMLAssociationEndAssociationListModel extends UMLModelElementListModel2
  { 
public UMLAssociationEndAssociationListModel()
    { 
super("association");
} 
protected boolean isValidElement(Object element)
    { 
return Model.getFacade().isAAssociation(element)
               && Model.getFacade().getAssociation(getTarget()).equals(element);
} 
protected void buildModelList()
    { 
removeAllElements();
if(getTarget() != null)//1
{ 
addElement(Model.getFacade().getAssociation(getTarget()));
} 
} 

 } 
