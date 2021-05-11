package org.argouml.uml.ui.foundation.core;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementListModel2;
public class UMLFeatureOwnerListModel extends UMLModelElementListModel2
  { 
public UMLFeatureOwnerListModel()
    { 
super("owner");
} 
protected boolean isValidElement(Object o)
    { 
return Model.getFacade().getOwner(getTarget()) == o;
} 
protected void buildModelList()
    { 
if(getTarget() != null)//1
{ 
removeAllElements();
addElement(Model.getFacade().getOwner(getTarget()));
} 
} 

 } 
