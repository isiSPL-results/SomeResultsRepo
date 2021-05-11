package org.argouml.uml.ui.behavior.collaborations;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementListModel2;
public class UMLMessageActionListModel extends UMLModelElementListModel2
  { 
protected void buildModelList()
    { 
removeAllElements();
addElement(Model.getFacade().getAction(getTarget()));
} 
protected boolean isValidElement(Object elem)
    { 
return Model.getFacade().isAAction(elem)
               && Model.getFacade().getAction(getTarget()) == elem;
} 
public UMLMessageActionListModel()
    { 
super("action");
} 

 } 
