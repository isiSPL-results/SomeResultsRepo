package org.argouml.uml.ui.behavior.use_cases;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementListModel2;
public abstract class UMLIncludeListModel extends UMLModelElementListModel2
  { 
protected boolean isValidElement(Object element)
    { 
return Model.getFacade().isAUseCase(element);
} 
public UMLIncludeListModel(String eventName)
    { 
super(eventName);
Model.getPump().addClassModelEventListener(this,
                Model.getMetaTypes().getNamespace(), "ownedElement");
} 
protected void buildModelList()
    { 
if(!isEmpty())//1
{ 
removeAllElements();
} 
} 

 } 
