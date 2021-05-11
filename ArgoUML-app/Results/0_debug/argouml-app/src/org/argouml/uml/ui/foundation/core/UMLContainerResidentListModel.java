
//#if 2135430256 
// Compilation Unit of /UMLContainerResidentListModel.java 
 

//#if -1473541535 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -1193205796 
import org.argouml.model.Model;
//#endif 


//#if 1400020424 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if 219364610 
public class UMLContainerResidentListModel extends 
//#if 1113913488 
UMLModelElementListModel2
//#endif 

  { 

//#if -490722337 
protected boolean isValidElement(Object o)
    { 

//#if 1955327676 
return (Model.getFacade().isAComponent(o)
                || Model.getFacade().isAInstance(o));
//#endif 

} 

//#endif 


//#if -455005442 
protected void buildModelList()
    { 

//#if -432982905 
setAllElements(Model.getFacade().getResidents(getTarget()));
//#endif 

} 

//#endif 


//#if 936214632 
public UMLContainerResidentListModel()
    { 

//#if 1756231488 
super("resident");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

