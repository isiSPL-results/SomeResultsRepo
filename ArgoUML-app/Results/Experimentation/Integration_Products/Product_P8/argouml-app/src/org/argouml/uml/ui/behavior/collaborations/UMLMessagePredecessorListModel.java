package org.argouml.uml.ui.behavior.collaborations;
import java.util.Iterator;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementListModel2;
public class UMLMessagePredecessorListModel extends UMLModelElementListModel2
  { 
protected void buildModelList()
    { 
Object message = getTarget();
removeAllElements();
Iterator it = Model.getFacade().getPredecessors(message).iterator();
while (it.hasNext()) //1
{ 
addElement(it.next());
} 
} 
protected boolean isValidElement(Object elem)
    { 
return Model.getFacade().isAMessage(elem)
               && Model.getFacade().getInteraction(elem)
               == Model.getFacade().getInteraction(getTarget())
               && Model.getFacade().getActivator(elem)
               == Model.getFacade().getActivator(getTarget());
} 
public UMLMessagePredecessorListModel()
    { 
super("predecessor");
} 

 } 
