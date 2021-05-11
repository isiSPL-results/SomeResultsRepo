package org.argouml.uml.ui.foundation.extension_mechanisms;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementListModel2;
class UMLExtendedElementsListModel extends UMLModelElementListModel2
  { 
protected boolean isValidElement(Object element)
    { 
return Model.getFacade().isAModelElement(element)
               && Model.getFacade().getExtendedElements(getTarget())
               .contains(element);
} 
protected void buildModelList()
    { 
if(getTarget() != null)//1
{ 
setAllElements(Model.getFacade().getExtendedElements(getTarget()));
} 
} 
public UMLExtendedElementsListModel()
    { 
super("extendedElement");
} 

 } 
