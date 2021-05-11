
//#if 1932670478 
// Compilation Unit of /UMLEventParameterListModel.java 
 

//#if 911498095 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if 680945286 
import org.argouml.model.Model;
//#endif 


//#if 481494366 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if 398713098 
public class UMLEventParameterListModel extends 
//#if 1098068486 
UMLModelElementListModel2
//#endif 

  { 

//#if -693520012 
protected void buildModelList()
    { 

//#if 1135594124 
setAllElements(Model.getFacade().getParameters(getTarget()));
//#endif 

} 

//#endif 


//#if -663144024 
protected boolean isValidElement(Object element)
    { 

//#if 698928087 
return Model.getFacade().getParameters(getTarget()).contains(element);
//#endif 

} 

//#endif 


//#if 142391674 
public UMLEventParameterListModel()
    { 

//#if 1293275530 
super("parameter");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

