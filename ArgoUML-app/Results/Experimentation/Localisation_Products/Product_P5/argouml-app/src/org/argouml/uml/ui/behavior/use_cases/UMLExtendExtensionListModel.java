package org.argouml.uml.ui.behavior.use_cases;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementListModel2;
public class UMLExtendExtensionListModel extends UMLModelElementListModel2
  { 
protected void buildModelList()
    { 
if(!isEmpty())//1
{ 
removeAllElements();
} 
addElement(Model.getFacade().getExtension(getTarget()));
} 
public UMLExtendExtensionListModel()
    { 
super("extension");
} 
protected boolean isValidElement(Object element)
    { 
return Model.getFacade().isAUseCase(element);
} 

 } 
