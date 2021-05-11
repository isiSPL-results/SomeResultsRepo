package org.argouml.uml.ui.behavior.collaborations;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementListModel2;
public class UMLClassifierRoleBaseListModel extends UMLModelElementListModel2
  { 
protected boolean isValidElement(Object elem)
    { 
return Model.getFacade().isAClassifier(elem)
               && Model.getFacade().getBases(getTarget()).contains(elem);
} 
protected void buildModelList()
    { 
setAllElements(Model.getFacade().getBases(getTarget()));
} 
public UMLClassifierRoleBaseListModel()
    { 
super("base");
} 

 } 
