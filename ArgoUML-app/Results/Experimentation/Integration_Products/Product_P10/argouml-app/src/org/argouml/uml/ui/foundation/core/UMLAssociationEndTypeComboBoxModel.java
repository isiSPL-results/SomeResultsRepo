package org.argouml.uml.ui.foundation.core;
import org.argouml.model.Model;
public class UMLAssociationEndTypeComboBoxModel extends UMLStructuralFeatureTypeComboBoxModel
  { 
protected Object getSelectedModelElement()
    { 
if(getTarget() != null)//1
{ 
return Model.getFacade().getType(getTarget());
} 
return null;
} 
public UMLAssociationEndTypeComboBoxModel()
    { 
super();
} 

 } 
