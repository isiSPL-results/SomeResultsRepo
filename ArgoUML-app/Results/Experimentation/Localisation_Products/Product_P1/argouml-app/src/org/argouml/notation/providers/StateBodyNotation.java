package org.argouml.notation.providers;
import java.beans.PropertyChangeListener;
import java.util.Collection;
import java.util.Iterator;
import org.argouml.model.Model;
import org.argouml.notation.NotationProvider;
public abstract class StateBodyNotation extends NotationProvider
  { 
private void addListenersForEvent(PropertyChangeListener listener,
                                      Object event)
    { 
if(event != null)//1
{ 
addElementListener(listener, event,
                               new String[] {
                                   "parameter", "name",
                               });
Collection prms = Model.getFacade().getParameters(event);
Iterator i = prms.iterator();
while (i.hasNext()) //1
{ 
Object parameter = i.next();
addElementListener(listener, parameter);
} 
} 
} 
private void addListenersForAction(PropertyChangeListener listener,
                                       Object action)
    { 
if(action != null)//1
{ 
addElementListener(listener, action,
                               new String[] {
                                   "script", "actualArgument", "action"
                               });
Collection args = Model.getFacade().getActualArguments(action);
Iterator i = args.iterator();
while (i.hasNext()) //1
{ 
Object argument = i.next();
addElementListener(listener, argument, "value");
} 
if(Model.getFacade().isAActionSequence(action))//1
{ 
Collection subactions = Model.getFacade().getActions(action);
i = subactions.iterator();
while (i.hasNext()) //1
{ 
Object a = i.next();
addListenersForAction(listener, a);
} 
} 
} 
} 
public void initialiseListener(PropertyChangeListener listener,
                                   Object modelElement)
    { 
addElementListener(listener, modelElement);
Iterator it =
            Model.getFacade().getInternalTransitions(modelElement).iterator();
while (it.hasNext()) //1
{ 
addListenersForTransition(listener, it.next());
} 
Object doActivity = Model.getFacade().getDoActivity(modelElement);
addListenersForAction(listener, doActivity);
Object entryAction = Model.getFacade().getEntry(modelElement);
addListenersForAction(listener, entryAction);
Object exitAction = Model.getFacade().getExit(modelElement);
addListenersForAction(listener, exitAction);
} 
public StateBodyNotation(Object state)
    { 
if(!Model.getFacade().isAState(state))//1
{ 
throw new IllegalArgumentException("This is not a State.");
} 
} 
private void addListenersForTransition(PropertyChangeListener listener,
                                           Object transition)
    { 
addElementListener(listener, transition,
                           new String[] {"guard", "trigger", "effect"});
Object guard = Model.getFacade().getGuard(transition);
if(guard != null)//1
{ 
addElementListener(listener, guard, "expression");
} 
Object trigger = Model.getFacade().getTrigger(transition);
addListenersForEvent(listener, trigger);
Object effect = Model.getFacade().getEffect(transition);
addListenersForAction(listener, effect);
} 

 } 
