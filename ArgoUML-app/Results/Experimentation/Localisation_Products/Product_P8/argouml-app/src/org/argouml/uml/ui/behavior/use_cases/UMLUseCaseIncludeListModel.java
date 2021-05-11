package org.argouml.uml.ui.behavior.use_cases;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementListModel2;
public class UMLUseCaseIncludeListModel extends UMLModelElementListModel2
  { 
protected void buildModelList()
    { 
setAllElements(Model.getFacade().getIncludes(getTarget()));
} 
protected boolean isValidElement(Object o)
    { 
return Model.getFacade().getIncludes(getTarget()).contains(o);
} 
public UMLUseCaseIncludeListModel()
    { 
super("include");
} 

 } 
