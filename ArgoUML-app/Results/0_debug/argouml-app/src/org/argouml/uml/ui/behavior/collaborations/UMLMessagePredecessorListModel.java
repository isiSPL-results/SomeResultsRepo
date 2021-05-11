
//#if -1218179284 
// Compilation Unit of /UMLMessagePredecessorListModel.java 
 

//#if 2000864990 
package org.argouml.uml.ui.behavior.collaborations;
//#endif 


//#if -1242153704 
import java.util.Iterator;
//#endif 


//#if 784359625 
import org.argouml.model.Model;
//#endif 


//#if -2023152901 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if 1342779124 
public class UMLMessagePredecessorListModel extends 
//#if -1632149228 
UMLModelElementListModel2
//#endif 

  { 

//#if -1996246654 
protected void buildModelList()
    { 

//#if -378356252 
Object message = getTarget();
//#endif 


//#if -51942462 
removeAllElements();
//#endif 


//#if 348444690 
Iterator it = Model.getFacade().getPredecessors(message).iterator();
//#endif 


//#if -1725636858 
while (it.hasNext()) //1
{ 

//#if 1882190693 
addElement(it.next());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1774687761 
protected boolean isValidElement(Object elem)
    { 

//#if -351022362 
return Model.getFacade().isAMessage(elem)
               && Model.getFacade().getInteraction(elem)
               == Model.getFacade().getInteraction(getTarget())
               && Model.getFacade().getActivator(elem)
               == Model.getFacade().getActivator(getTarget());
//#endif 

} 

//#endif 


//#if 310956665 
public UMLMessagePredecessorListModel()
    { 

//#if -451317677 
super("predecessor");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

