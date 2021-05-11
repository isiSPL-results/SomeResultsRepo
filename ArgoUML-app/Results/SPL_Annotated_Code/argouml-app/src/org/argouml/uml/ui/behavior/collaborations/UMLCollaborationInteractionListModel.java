// Compilation Unit of /UMLCollaborationInteractionListModel.java 
 
package org.argouml.uml.ui.behavior.collaborations;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementListModel2;
public class UMLCollaborationInteractionListModel extends UMLModelElementListModel2
  { 
protected boolean isValidElement(Object elem)
    { 
return Model.getFacade().isAInteraction(elem)
               && Model.getFacade().getContext(elem) == getTarget();
} 

protected void buildModelList()
    { 
setAllElements(Model.getFacade().getInteractions(getTarget()));
} 

public UMLCollaborationInteractionListModel()
    { 
super("interaction");
} 

 } 


