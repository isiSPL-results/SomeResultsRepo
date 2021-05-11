package org.argouml.uml.ui.behavior.common_behavior;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementListModel2;
public class UMLInstanceClassifierListModel extends UMLModelElementListModel2
  { 
protected void buildModelList()
    { 
if(getTarget() != null)//1
{ 
setAllElements(Model.getFacade().getClassifiers(getTarget()));
} 
} 
public UMLInstanceClassifierListModel()
    { 
super("classifier");
} 
protected boolean isValidElement(Object o)
    { 
return Model.getFacade().isAClassifier(o)
               && Model.getFacade().getClassifiers(getTarget()).contains(o);
} 

 } 
