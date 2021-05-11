package org.argouml.uml.ui.foundation.core;
import org.argouml.model.Model;
public class UMLParameterTypeComboBoxModel extends UMLStructuralFeatureTypeComboBoxModel
  { 
protected Object getSelectedModelElement()
    { 
if(getTarget() != null)//1
{ 
return Model.getFacade().getType(getTarget());
} 
return null;
} 
public UMLParameterTypeComboBoxModel()
    { 
super();
} 

 } 
