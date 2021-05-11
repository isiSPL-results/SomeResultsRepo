
//#if -1124264013 
// Compilation Unit of /UMLInteractionMessagesListModel.java 
 

//#if 328579167 
package org.argouml.uml.ui.behavior.collaborations;
//#endif 


//#if -1494809481 
import java.util.Iterator;
//#endif 


//#if -1974444854 
import org.argouml.model.Model;
//#endif 


//#if 1970561434 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if 1530457347 
public class UMLInteractionMessagesListModel extends 
//#if 1373330989 
UMLModelElementListModel2
//#endif 

  { 

//#if 1606176280 
protected boolean isValidElement(Object elem)
    { 

//#if 28609899 
return Model.getFacade().isAMessage(elem)
               && Model.getFacade().getInteraction(elem) == getTarget();
//#endif 

} 

//#endif 


//#if -515802597 
protected void buildModelList()
    { 

//#if 131864316 
removeAllElements();
//#endif 


//#if 147102069 
Iterator it = Model.getFacade().getMessages(getTarget()).iterator();
//#endif 


//#if -1180982336 
while (it.hasNext()) //1
{ 

//#if 30738792 
addElement(it.next());
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1625040552 
public UMLInteractionMessagesListModel()
    { 

//#if -751995397 
super("message");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

