// Compilation Unit of /UMLTransitionTargetListModel.java 
 
package org.argouml.uml.ui.behavior.state_machines;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementListModel2;
public class UMLTransitionTargetListModel extends UMLModelElementListModel2
  { 
protected boolean isValidElement(Object element)
    { 
return element == Model.getFacade().getTarget(getTarget());
} 

public UMLTransitionTargetListModel()
    { 
super("target");
} 

protected void buildModelList()
    { 
removeAllElements();
addElement(Model.getFacade().getTarget(getTarget()));
} 

 } 


