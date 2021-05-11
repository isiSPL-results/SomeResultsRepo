package org.argouml.uml.ui.behavior.use_cases;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementListModel2;
public class UMLExtensionPointUseCaseListModel extends UMLModelElementListModel2
  { 
protected void buildModelList()
    { 
addElement(Model.getFacade().getUseCase(getTarget()));
} 
protected boolean isValidElement(Object o)
    { 
return Model.getFacade().isAUseCase(o)
               && Model.getFacade().getUseCase(getTarget()) == o;
} 
public UMLExtensionPointUseCaseListModel()
    { 
super("useCase");
} 

 } 
