
//#if -1347379466 
// Compilation Unit of /StateBodyNotation.java 
 

//#if -1183932877 
package org.argouml.notation.providers;
//#endif 


//#if 557012417 
import java.beans.PropertyChangeListener;
//#endif 


//#if 464940711 
import java.util.Collection;
//#endif 


//#if -2131682985 
import java.util.Iterator;
//#endif 


//#if 95441898 
import org.argouml.model.Model;
//#endif 


//#if -529248913 
import org.argouml.notation.NotationProvider;
//#endif 


//#if -112562439 
public abstract class StateBodyNotation extends 
//#if 1623206273 
NotationProvider
//#endif 

  { 

//#if -1999709539 
private void addListenersForEvent(PropertyChangeListener listener,
                                      Object event)
    { 

//#if -1501407236 
if(event != null)//1
{ 

//#if -1723266974 
addElementListener(listener, event,
                               new String[] {
                                   "parameter", "name",
                               });
//#endif 


//#if -1364006005 
Collection prms = Model.getFacade().getParameters(event);
//#endif 


//#if 1260518184 
Iterator i = prms.iterator();
//#endif 


//#if -995491462 
while (i.hasNext()) //1
{ 

//#if -1597740880 
Object parameter = i.next();
//#endif 


//#if 1563315485 
addElementListener(listener, parameter);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1724494267 
private void addListenersForAction(PropertyChangeListener listener,
                                       Object action)
    { 

//#if 558216600 
if(action != null)//1
{ 

//#if -1521574806 
addElementListener(listener, action,
                               new String[] {
                                   "script", "actualArgument", "action"
                               });
//#endif 


//#if -1153488002 
Collection args = Model.getFacade().getActualArguments(action);
//#endif 


//#if -63820927 
Iterator i = args.iterator();
//#endif 


//#if -508407594 
while (i.hasNext()) //1
{ 

//#if -982945670 
Object argument = i.next();
//#endif 


//#if 877431598 
addElementListener(listener, argument, "value");
//#endif 

} 

//#endif 


//#if 1052893304 
if(Model.getFacade().isAActionSequence(action))//1
{ 

//#if 1431036004 
Collection subactions = Model.getFacade().getActions(action);
//#endif 


//#if 1650848142 
i = subactions.iterator();
//#endif 


//#if -1412011141 
while (i.hasNext()) //1
{ 

//#if 1052467301 
Object a = i.next();
//#endif 


//#if -2001574940 
addListenersForAction(listener, a);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 2077023914 
public void initialiseListener(PropertyChangeListener listener,
                                   Object modelElement)
    { 

//#if 771385233 
addElementListener(listener, modelElement);
//#endif 


//#if 1896669840 
Iterator it =
            Model.getFacade().getInternalTransitions(modelElement).iterator();
//#endif 


//#if -2144129065 
while (it.hasNext()) //1
{ 

//#if 1154663813 
addListenersForTransition(listener, it.next());
//#endif 

} 

//#endif 


//#if 2057452886 
Object doActivity = Model.getFacade().getDoActivity(modelElement);
//#endif 


//#if -1662696528 
addListenersForAction(listener, doActivity);
//#endif 


//#if 1940164014 
Object entryAction = Model.getFacade().getEntry(modelElement);
//#endif 


//#if -1347857226 
addListenersForAction(listener, entryAction);
//#endif 


//#if -2036167752 
Object exitAction = Model.getFacade().getExit(modelElement);
//#endif 


//#if -235353750 
addListenersForAction(listener, exitAction);
//#endif 

} 

//#endif 


//#if 1856390209 
public StateBodyNotation(Object state)
    { 

//#if -1037895675 
if(!Model.getFacade().isAState(state))//1
{ 

//#if -1339573586 
throw new IllegalArgumentException("This is not a State.");
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1291417145 
private void addListenersForTransition(PropertyChangeListener listener,
                                           Object transition)
    { 

//#if 139508783 
addElementListener(listener, transition,
                           new String[] {"guard", "trigger", "effect"});
//#endif 


//#if 303483691 
Object guard = Model.getFacade().getGuard(transition);
//#endif 


//#if -1925893663 
if(guard != null)//1
{ 

//#if -13634445 
addElementListener(listener, guard, "expression");
//#endif 

} 

//#endif 


//#if -316784437 
Object trigger = Model.getFacade().getTrigger(transition);
//#endif 


//#if -1718095505 
addListenersForEvent(listener, trigger);
//#endif 


//#if 374941083 
Object effect = Model.getFacade().getEffect(transition);
//#endif 


//#if -742350792 
addListenersForAction(listener, effect);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

