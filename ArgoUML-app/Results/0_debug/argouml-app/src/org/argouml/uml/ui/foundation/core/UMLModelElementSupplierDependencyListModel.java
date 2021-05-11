
//#if -2002823558 
// Compilation Unit of /UMLModelElementSupplierDependencyListModel.java 
 

//#if -1663824118 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 234134021 
import org.argouml.model.Model;
//#endif 


//#if 1050298175 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if 14051344 
public class UMLModelElementSupplierDependencyListModel extends 
//#if -825351708 
UMLModelElementListModel2
//#endif 

  { 

//#if -1553173965 
protected boolean isValidElement(Object o)
    { 

//#if 989983081 
return Model.getFacade().isADependency(o)
               && Model.getFacade().getSupplierDependencies(getTarget())
               .contains(o);
//#endif 

} 

//#endif 


//#if 1529711186 
protected void buildModelList()
    { 

//#if 868548721 
if(getTarget() != null)//1
{ 

//#if 1534101548 
setAllElements(
                Model.getFacade().getSupplierDependencies(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 73037185 
public UMLModelElementSupplierDependencyListModel()
    { 

//#if -124958207 
super("supplierDependency", Model.getMetaTypes().getDependency(), true);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

