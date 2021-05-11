
//#if -896106398 
// Compilation Unit of /UMLAssociationEndTypeComboBoxModel.java 
 

//#if 18224225 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -2050315812 
import org.argouml.model.Model;
//#endif 


//#if 1070845552 
public class UMLAssociationEndTypeComboBoxModel extends 
//#if 1790004572 
UMLStructuralFeatureTypeComboBoxModel
//#endif 

  { 

//#if 211356361 
protected Object getSelectedModelElement()
    { 

//#if -345818426 
if(getTarget() != null)//1
{ 

//#if -783572727 
return Model.getFacade().getType(getTarget());
//#endif 

} 

//#endif 


//#if -1438743386 
return null;
//#endif 

} 

//#endif 


//#if -1581824001 
public UMLAssociationEndTypeComboBoxModel()
    { 

//#if -1057748795 
super();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

