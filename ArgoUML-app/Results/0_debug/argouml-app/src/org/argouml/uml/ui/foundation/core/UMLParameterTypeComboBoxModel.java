
//#if -2103139737 
// Compilation Unit of /UMLParameterTypeComboBoxModel.java 
 

//#if -473098959 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 1759535788 
import org.argouml.model.Model;
//#endif 


//#if -325616991 
public class UMLParameterTypeComboBoxModel extends 
//#if 1438667150 
UMLStructuralFeatureTypeComboBoxModel
//#endif 

  { 

//#if 353517911 
protected Object getSelectedModelElement()
    { 

//#if 1218592219 
if(getTarget() != null)//1
{ 

//#if 25862644 
return Model.getFacade().getType(getTarget());
//#endif 

} 

//#endif 


//#if 609166193 
return null;
//#endif 

} 

//#endif 


//#if 1295347062 
public UMLParameterTypeComboBoxModel()
    { 

//#if 918397047 
super();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

