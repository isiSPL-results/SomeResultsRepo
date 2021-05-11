package org.argouml.uml.ui.behavior.common_behavior;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementListModel2;
public class UMLSignalContextListModel extends UMLModelElementListModel2
  { 
protected void buildModelList()
    { 
if(getTarget() != null)//1
{ 
setAllElements(Model.getFacade().getContexts(getTarget()));
} 
} 
public UMLSignalContextListModel()
    { 
super("context");
} 
protected boolean isValidElement(Object element)
    { 
return Model.getFacade().isABehavioralFeature(element)
               && Model.getFacade().getContexts(getTarget()).contains(
                   element);
} 

 } 
