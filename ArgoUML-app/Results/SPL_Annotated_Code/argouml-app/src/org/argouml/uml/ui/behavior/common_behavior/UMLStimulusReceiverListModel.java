// Compilation Unit of /UMLStimulusReceiverListModel.java 
 
package org.argouml.uml.ui.behavior.common_behavior;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementListModel2;
public class UMLStimulusReceiverListModel extends UMLModelElementListModel2
  { 
protected boolean isValidElement(Object element)
    { 
return Model.getFacade().getReceiver(getTarget()) == element;
} 

protected void buildModelList()
    { 
removeAllElements();
addElement(Model.getFacade().getReceiver(getTarget()));
} 

public UMLStimulusReceiverListModel()
    { 
super("receiver");
} 

 } 


