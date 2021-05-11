// Compilation Unit of /UMLGuardTransitionListModel.java 
 
package org.argouml.uml.ui.behavior.state_machines;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementListModel2;
public class UMLGuardTransitionListModel extends UMLModelElementListModel2
  { 
protected boolean isValidElement(Object element)
    { 
return element == Model.getFacade().getTransition(getTarget());
} 

public UMLGuardTransitionListModel()
    { 
super("transition");
} 

protected void buildModelList()
    { 
removeAllElements();
addElement(Model.getFacade().getTransition(getTarget()));
} 

 } 


