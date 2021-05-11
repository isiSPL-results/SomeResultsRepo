package org.argouml.uml.ui.foundation.core;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementListModel2;
public class UMLDependencyClientListModel extends UMLModelElementListModel2
  { 
public UMLDependencyClientListModel()
    { 
super("client");
} 
protected boolean isValidElement(Object o)
    { 
return Model.getFacade().isAModelElement(o)
               && Model.getFacade().getClients(getTarget()).contains(o);
} 
protected void buildModelList()
    { 
if(getTarget() != null)//1
{ 
setAllElements(Model.getFacade().getClients(getTarget()));
} 
} 

 } 
