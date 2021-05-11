// Compilation Unit of /UMLEventParameterListModel.java 
 
package org.argouml.uml.ui.behavior.state_machines;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementListModel2;
public class UMLEventParameterListModel extends UMLModelElementListModel2
  { 
protected void buildModelList()
    { 
setAllElements(Model.getFacade().getParameters(getTarget()));
} 

protected boolean isValidElement(Object element)
    { 
return Model.getFacade().getParameters(getTarget()).contains(element);
} 

public UMLEventParameterListModel()
    { 
super("parameter");
} 

 } 


