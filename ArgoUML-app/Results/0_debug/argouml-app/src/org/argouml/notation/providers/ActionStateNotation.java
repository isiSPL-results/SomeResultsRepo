
//#if 51112143 
// Compilation Unit of /ActionStateNotation.java 
 

//#if -1467103140 
package org.argouml.notation.providers;
//#endif 


//#if -986670678 
import java.beans.PropertyChangeListener;
//#endif 


//#if 642515998 
import java.util.Collection;
//#endif 


//#if -401891186 
import java.util.Iterator;
//#endif 


//#if -1158891757 
import org.argouml.model.Model;
//#endif 


//#if -85232424 
import org.argouml.notation.NotationProvider;
//#endif 


//#if 1009911370 
public abstract class ActionStateNotation extends 
//#if 1365994542 
NotationProvider
//#endif 

  { 

//#if -1940850083 
public void initialiseListener(PropertyChangeListener listener,
                                   Object modelElement)
    { 

//#if -1844780134 
addElementListener(listener, modelElement,
                           new String[] {"entry", "remove", "stereotype"} );
//#endif 


//#if -1514146606 
Object entry = Model.getFacade().getEntry(modelElement);
//#endif 


//#if 1777649733 
if(entry != null)//1
{ 

//#if 122872135 
addElementListener(listener, entry, "script");
//#endif 

} 

//#endif 


//#if -203609707 
Collection c = Model.getFacade().getStereotypes(modelElement);
//#endif 


//#if 1018117036 
Iterator i = c.iterator();
//#endif 


//#if 1659997895 
while (i.hasNext()) //1
{ 

//#if 1518517444 
Object st = i.next();
//#endif 


//#if 37982868 
addElementListener(listener, st, "name");
//#endif 

} 

//#endif 

} 

//#endif 


//#if -393291876 
public ActionStateNotation(Object actionState)
    { 

//#if 714209546 
if(!Model.getFacade().isAActionState(actionState))//1
{ 

//#if -191458904 
throw new IllegalArgumentException("This is not an ActionState.");
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

