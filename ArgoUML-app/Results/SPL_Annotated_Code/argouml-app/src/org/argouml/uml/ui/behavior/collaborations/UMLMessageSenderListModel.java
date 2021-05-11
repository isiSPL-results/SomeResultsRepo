// Compilation Unit of /UMLMessageSenderListModel.java 
 
package org.argouml.uml.ui.behavior.collaborations;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementListModel2;
public class UMLMessageSenderListModel extends UMLModelElementListModel2
  { 
protected boolean isValidElement(Object elem)
    { 
return Model.getFacade().getSender(getTarget()) == elem;
} 

protected void buildModelList()
    { 
removeAllElements();
addElement(Model.getFacade().getSender(getTarget()));
} 

public UMLMessageSenderListModel()
    { 
super("sender");
} 

 } 


