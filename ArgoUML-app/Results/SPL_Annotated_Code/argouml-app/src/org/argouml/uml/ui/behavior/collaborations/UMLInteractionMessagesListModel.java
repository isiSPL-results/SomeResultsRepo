// Compilation Unit of /UMLInteractionMessagesListModel.java 
 
package org.argouml.uml.ui.behavior.collaborations;
import java.util.Iterator;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementListModel2;
public class UMLInteractionMessagesListModel extends UMLModelElementListModel2
  { 
protected boolean isValidElement(Object elem)
    { 
return Model.getFacade().isAMessage(elem)
               && Model.getFacade().getInteraction(elem) == getTarget();
} 

protected void buildModelList()
    { 
removeAllElements();
Iterator it = Model.getFacade().getMessages(getTarget()).iterator();
while (it.hasNext()) //1
{ 
addElement(it.next());
} 

} 

public UMLInteractionMessagesListModel()
    { 
super("message");
} 

 } 


