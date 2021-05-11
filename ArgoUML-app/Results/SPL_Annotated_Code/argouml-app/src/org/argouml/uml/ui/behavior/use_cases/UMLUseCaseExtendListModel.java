// Compilation Unit of /UMLUseCaseExtendListModel.java 
 
package org.argouml.uml.ui.behavior.use_cases;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementListModel2;
public class UMLUseCaseExtendListModel extends UMLModelElementListModel2
  { 
protected void buildModelList()
    { 
setAllElements(Model.getFacade().getExtends(getTarget()));
} 

public UMLUseCaseExtendListModel()
    { 
super("extend");
} 

protected boolean isValidElement(Object o)
    { 
return Model.getFacade().getExtends(getTarget()).contains(o);
} 

 } 


