// Compilation Unit of /ActionStateNotation.java 
 
package org.argouml.notation.providers;
import java.beans.PropertyChangeListener;
import java.util.Collection;
import java.util.Iterator;
import org.argouml.model.Model;
import org.argouml.notation.NotationProvider;
public abstract class ActionStateNotation extends NotationProvider
  { 
public void initialiseListener(PropertyChangeListener listener,
                                   Object modelElement)
    { 
addElementListener(listener, modelElement,
                           new String[] {"entry", "remove", "stereotype"} );
Object entry = Model.getFacade().getEntry(modelElement);
if(entry != null)//1
{ 
addElementListener(listener, entry, "script");
} 

Collection c = Model.getFacade().getStereotypes(modelElement);
Iterator i = c.iterator();
while (i.hasNext()) //1
{ 
Object st = i.next();
addElementListener(listener, st, "name");
} 

} 

public ActionStateNotation(Object actionState)
    { 
if(!Model.getFacade().isAActionState(actionState))//1
{ 
throw new IllegalArgumentException("This is not an ActionState.");
} 

} 

 } 


