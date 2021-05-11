
//#if 1597374735 
// Compilation Unit of /UMLDependencySupplierListModel.java 
 

//#if 1301428329 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 1620482532 
import org.argouml.model.Model;
//#endif 


//#if -302303040 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -991711004 
public class UMLDependencySupplierListModel extends 
//#if -1390734259 
UMLModelElementListModel2
//#endif 

  { 

//#if -769099556 
protected boolean isValidElement(Object o)
    { 

//#if -384886851 
return Model.getFacade().isAModelElement(o)
               && Model.getFacade().getSuppliers(getTarget()).contains(o);
//#endif 

} 

//#endif 


//#if -1954996165 
protected void buildModelList()
    { 

//#if -632015417 
if(getTarget() != null)//1
{ 

//#if 1589185604 
setAllElements(Model.getFacade().getSuppliers(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1787756789 
public UMLDependencySupplierListModel()
    { 

//#if -696184755 
super("supplier");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

