package org.argouml.uml.ui.foundation.core;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementListModel2;
public class UMLParameterBehavioralFeatListModel extends UMLModelElementListModel2
  { 
protected boolean isValidElement(Object o)
    { 
return Model.getFacade().getBehavioralFeature(getTarget()) == o;
} 
public UMLParameterBehavioralFeatListModel()
    { 
super("behavioralFeature");
} 
protected void buildModelList()
    { 
if(getTarget() != null)//1
{ 
removeAllElements();
addElement(Model.getFacade().getBehavioralFeature(getTarget()));
} 
} 

 } 
