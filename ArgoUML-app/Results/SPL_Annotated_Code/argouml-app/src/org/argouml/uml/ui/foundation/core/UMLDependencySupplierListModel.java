// Compilation Unit of /UMLDependencySupplierListModel.java 
 
package org.argouml.uml.ui.foundation.core;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementListModel2;
public class UMLDependencySupplierListModel extends UMLModelElementListModel2
  { 
protected boolean isValidElement(Object o)
    { 
return Model.getFacade().isAModelElement(o)
               && Model.getFacade().getSuppliers(getTarget()).contains(o);
} 

protected void buildModelList()
    { 
if(getTarget() != null)//1
{ 
setAllElements(Model.getFacade().getSuppliers(getTarget()));
} 

} 

public UMLDependencySupplierListModel()
    { 
super("supplier");
} 

 } 


