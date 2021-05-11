// Compilation Unit of /UMLExtensionPointExtendListModel.java 
 
package org.argouml.uml.ui.behavior.use_cases;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementListModel2;
public class UMLExtensionPointExtendListModel extends UMLModelElementListModel2
  { 
public UMLExtensionPointExtendListModel()
    { 
super("extend");
} 

protected void buildModelList()
    { 
setAllElements(Model.getFacade().getExtends(getTarget()));
} 

protected boolean isValidElement(Object o)
    { 
return Model.getFacade().isAExtend(o)
               && Model.getFacade().getExtends(getTarget()).contains(o);
} 

 } 


