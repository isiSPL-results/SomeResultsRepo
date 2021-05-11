package org.argouml.uml.ui.behavior.use_cases;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementListModel2;
public class UMLExtendBaseListModel extends UMLModelElementListModel2
  { 
protected boolean isValidElement(Object element)
    { 
return Model.getFacade().isAUseCase(element);
} 
protected void buildModelList()
    { 
if(!isEmpty())//1
{ 
removeAllElements();
} 
addElement(Model.getFacade().getBase(getTarget()));
} 
public UMLExtendBaseListModel()
    { 
super("base");
Model.getPump().addClassModelEventListener(this,
                Model.getMetaTypes().getNamespace(), "ownedElement");
} 

 } 
