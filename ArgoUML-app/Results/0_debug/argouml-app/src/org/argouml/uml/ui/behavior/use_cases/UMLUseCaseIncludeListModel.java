
//#if -1295196758 
// Compilation Unit of /UMLUseCaseIncludeListModel.java 
 

//#if -742891271 
package org.argouml.uml.ui.behavior.use_cases;
//#endif 


//#if 1157172175 
import org.argouml.model.Model;
//#endif 


//#if 2130425781 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -1638512449 
public class UMLUseCaseIncludeListModel extends 
//#if 2009357012 
UMLModelElementListModel2
//#endif 

  { 

//#if -1149383870 
protected void buildModelList()
    { 

//#if -137657510 
setAllElements(Model.getFacade().getIncludes(getTarget()));
//#endif 

} 

//#endif 


//#if -1563146461 
protected boolean isValidElement(Object o)
    { 

//#if 1934160324 
return Model.getFacade().getIncludes(getTarget()).contains(o);
//#endif 

} 

//#endif 


//#if -453989878 
public UMLUseCaseIncludeListModel()
    { 

//#if -669615995 
super("include");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

