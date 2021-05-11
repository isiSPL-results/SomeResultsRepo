// Compilation Unit of /UMLStateInternalTransition.java 
 
package org.argouml.uml.ui.behavior.state_machines;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementListModel2;
public class UMLStateInternalTransition extends UMLModelElementListModel2
  { 
protected void buildModelList()
    { 
setAllElements(Model.getFacade().getInternalTransitions(getTarget()));
} 

protected boolean isValidElement(Object element)
    { 
return Model.getFacade().getInternalTransitions(getTarget())
               .contains(element);
} 

public UMLStateInternalTransition()
    { 
super("internalTransition");
} 

 } 


