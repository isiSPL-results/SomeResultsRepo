
//#if -997041564 
// Compilation Unit of /UMLStateDoActivityListModel.java 
 

//#if 264639346 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if 1735654921 
import org.argouml.model.Model;
//#endif 


//#if 1903709627 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -1264724427 
public class UMLStateDoActivityListModel extends 
//#if -489374654 
UMLModelElementListModel2
//#endif 

  { 

//#if -1661693600 
public UMLStateDoActivityListModel()
    { 

//#if -1761922583 
super("doActivity");
//#endif 

} 

//#endif 


//#if 1737182692 
protected boolean isValidElement(Object element)
    { 

//#if 492071738 
return element == Model.getFacade().getDoActivity(getTarget());
//#endif 

} 

//#endif 


//#if 2072233392 
protected void buildModelList()
    { 

//#if 798638298 
removeAllElements();
//#endif 


//#if -27354906 
addElement(Model.getFacade().getDoActivity(getTarget()));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

