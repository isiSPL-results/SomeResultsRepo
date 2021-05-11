
//#if 250284068 
// Compilation Unit of /UMLModelElementClientDependencyListModel.java 
 

//#if -219856977 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -1560946134 
import org.argouml.model.Model;
//#endif 


//#if 1681195066 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -748406868 
public class UMLModelElementClientDependencyListModel extends 
//#if -336396992 
UMLModelElementListModel2
//#endif 

  { 

//#if 32432390 
public UMLModelElementClientDependencyListModel()
    { 

//#if 858110565 
super("clientDependency", Model.getMetaTypes().getDependency());
//#endif 

} 

//#endif 


//#if -263177073 
protected boolean isValidElement(Object o)
    { 

//#if 757336126 
return Model.getFacade().isADependency(o)
               && Model.getFacade().getClientDependencies(getTarget()).contains(o);
//#endif 

} 

//#endif 


//#if 1501386670 
protected void buildModelList()
    { 

//#if 1244638848 
if(getTarget() != null)//1
{ 

//#if -36777150 
setAllElements(
                Model.getFacade().getClientDependencies(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

