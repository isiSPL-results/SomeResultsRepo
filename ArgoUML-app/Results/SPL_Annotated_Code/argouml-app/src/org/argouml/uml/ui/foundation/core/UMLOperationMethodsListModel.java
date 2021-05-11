// Compilation Unit of /UMLOperationMethodsListModel.java 
 
package org.argouml.uml.ui.foundation.core;
import java.util.Collection;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementListModel2;
public class UMLOperationMethodsListModel extends UMLModelElementListModel2
  { 
private static final long serialVersionUID = -6905298765859760688L;
public UMLOperationMethodsListModel()
    { 
super("method");
} 

protected boolean isValidElement(Object element)
    { 
Collection methods = null;
Object target = getTarget();
if(Model.getFacade().isAOperation(target))//1
{ 
methods = Model.getFacade().getMethods(target);
} 

return (methods != null) && methods.contains(element);
} 

protected void buildModelList()
    { 
if(getTarget() != null)//1
{ 
Collection methods = null;
Object target = getTarget();
if(Model.getFacade().isAOperation(target))//1
{ 
methods = Model.getFacade().getMethods(target);
} 

setAllElements(methods);
} 

} 

 } 


