
//#if 45849434 
// Compilation Unit of /CallStateNotation.java 
 

//#if -1453560357 
package org.argouml.notation.providers;
//#endif 


//#if -856958103 
import java.beans.PropertyChangeListener;
//#endif 


//#if -1130607726 
import org.argouml.model.Model;
//#endif 


//#if 1268891415 
import org.argouml.notation.NotationProvider;
//#endif 


//#if -1182897247 
public abstract class CallStateNotation extends 
//#if 652145369 
NotationProvider
//#endif 

  { 

//#if 122833490 
public void initialiseListener(PropertyChangeListener listener,
                                   Object modelElement)
    { 

//#if 869374865 
addElementListener(listener, modelElement,
                           new String[] {"entry", "name", "remove"});
//#endif 


//#if -1322575692 
Object entryAction = Model.getFacade().getEntry(modelElement);
//#endif 


//#if -1347413236 
if(Model.getFacade().isACallAction(entryAction))//1
{ 

//#if 1854108640 
addElementListener(listener, entryAction, "operation");
//#endif 


//#if -1164424090 
Object operation = Model.getFacade().getOperation(entryAction);
//#endif 


//#if 1326866483 
if(operation != null)//1
{ 

//#if -778891419 
addElementListener(listener, operation,
                                   new String[] {"owner", "name"});
//#endif 


//#if -1195750817 
Object classifier = Model.getFacade().getOwner(operation);
//#endif 


//#if 1585759173 
addElementListener(listener, classifier, "name");
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1509539351 
public CallStateNotation(Object callState)
    { 

//#if -79463715 
if(!Model.getFacade().isACallState(callState))//1
{ 

//#if -101948965 
throw new IllegalArgumentException("This is not an CallState.");
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

