package org.argouml.uml.ui.foundation.core;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementListModel2;
public class UMLGeneralizationParentListModel extends UMLModelElementListModel2
  { 
protected void buildModelList()
    { 
if(getTarget() == null)//1
{ 
return;
} 
removeAllElements();
addElement(Model.getFacade().getGeneral(getTarget()));
} 
protected boolean isValidElement(Object o)
    { 
return (Model.getFacade().getGeneral(getTarget()) == o);
} 
public UMLGeneralizationParentListModel()
    { 
super("parent");
} 

 } 
