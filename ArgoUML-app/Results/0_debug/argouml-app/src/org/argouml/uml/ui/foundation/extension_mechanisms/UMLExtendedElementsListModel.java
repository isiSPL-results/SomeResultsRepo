
//#if 914643931 
// Compilation Unit of /UMLExtendedElementsListModel.java 
 

//#if 663200321 
package org.argouml.uml.ui.foundation.extension_mechanisms;
//#endif 


//#if 628291959 
import org.argouml.model.Model;
//#endif 


//#if -374709491 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -1503883647 
class UMLExtendedElementsListModel extends 
//#if 1658747508 
UMLModelElementListModel2
//#endif 

  { 

//#if -2060845290 
protected boolean isValidElement(Object element)
    { 

//#if -1781195888 
return Model.getFacade().isAModelElement(element)
               && Model.getFacade().getExtendedElements(getTarget())
               .contains(element);
//#endif 

} 

//#endif 


//#if 1195317986 
protected void buildModelList()
    { 

//#if 690097988 
if(getTarget() != null)//1
{ 

//#if -1318241215 
setAllElements(Model.getFacade().getExtendedElements(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2037013323 
public UMLExtendedElementsListModel()
    { 

//#if 671975509 
super("extendedElement");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

