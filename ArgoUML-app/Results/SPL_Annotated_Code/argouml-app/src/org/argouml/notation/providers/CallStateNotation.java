// Compilation Unit of /CallStateNotation.java 
 
package org.argouml.notation.providers;
import java.beans.PropertyChangeListener;
import org.argouml.model.Model;
import org.argouml.notation.NotationProvider;
public abstract class CallStateNotation extends NotationProvider
  { 
public void initialiseListener(PropertyChangeListener listener,
                                   Object modelElement)
    { 
addElementListener(listener, modelElement,
                           new String[] {"entry", "name", "remove"});
Object entryAction = Model.getFacade().getEntry(modelElement);
if(Model.getFacade().isACallAction(entryAction))//1
{ 
addElementListener(listener, entryAction, "operation");
Object operation = Model.getFacade().getOperation(entryAction);
if(operation != null)//1
{ 
addElementListener(listener, operation,
                                   new String[] {"owner", "name"});
Object classifier = Model.getFacade().getOwner(operation);
addElementListener(listener, classifier, "name");
} 

} 

} 

public CallStateNotation(Object callState)
    { 
if(!Model.getFacade().isACallState(callState))//1
{ 
throw new IllegalArgumentException("This is not an CallState.");
} 

} 

 } 


