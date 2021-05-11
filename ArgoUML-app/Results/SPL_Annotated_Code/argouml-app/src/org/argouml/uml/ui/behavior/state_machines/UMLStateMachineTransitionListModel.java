// Compilation Unit of /UMLStateMachineTransitionListModel.java 
 
package org.argouml.uml.ui.behavior.state_machines;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementListModel2;
public class UMLStateMachineTransitionListModel extends UMLModelElementListModel2
  { 
protected void buildModelList()
    { 
setAllElements(Model.getFacade().getTransitions(getTarget()));
} 

protected boolean isValidElement(Object element)
    { 
return Model.getFacade().getTransitions(getTarget()).contains(element);
} 

public UMLStateMachineTransitionListModel()
    { 
super("transition");
} 

 } 


