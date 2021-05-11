// Compilation Unit of /ArgoEventPump.java 
 
package org.argouml.application.events;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;
import org.argouml.application.api.ArgoEventListener;

//#if LOGGING 
import org.apache.log4j.Logger;
//#endif 

public final class ArgoEventPump  { 
private List<Pair> listeners;
static final ArgoEventPump SINGLETON = new ArgoEventPump();

//#if LOGGING 
private static final Logger LOG = Logger.getLogger(ArgoEventPump.class);
//#endif 

private void handleFireProfileEvent(
        ArgoProfileEvent event,
        ArgoProfileEventListener listener)
    { 
switch (event.getEventType()) //1
{ 
case ArgoEventTypes.PROFILE_ADDED://1

listener.profileAdded(event);
break;


case ArgoEventTypes.PROFILE_REMOVED://1

listener.profileRemoved(event);
break;


default://1


//#if LOGGING 
LOG.error("Invalid event:" + event.getEventType());
//#endif 

break;


} 

} 

public static void removeListener(int event, ArgoEventListener listener)
    { 
SINGLETON.doRemoveListener(event, listener);
} 

public static void fireEvent(ArgoEvent event)
    { 
SINGLETON.doFireEvent(event);
} 

private void fireDiagramAppearanceEventInternal(
        final ArgoDiagramAppearanceEvent event,
        final ArgoDiagramAppearanceEventListener listener)
    { 
switch (event.getEventType()) //1
{ 
case ArgoEventTypes.DIAGRAM_FONT_CHANGED ://1

listener.diagramFontChanged(event);
break;


default ://1


//#if LOGGING 
LOG.error("Invalid event:" + event.getEventType());
//#endif 

break;


} 

} 

public static void removeListener(ArgoEventListener listener)
    { 
SINGLETON.doRemoveListener(ArgoEventTypes.ANY_EVENT, listener);
} 

protected void doAddListener(int event, ArgoEventListener listener)
    { 
if(listeners == null)//1
{ 
listeners = new ArrayList<Pair>();
} 

synchronized (listeners) //1
{ 
listeners.add(new Pair(event, listener));
} 

} 

private void handleFireGeneratorEvent(
        ArgoGeneratorEvent event,
        ArgoGeneratorEventListener listener)
    { 
switch (event.getEventType()) //1
{ 
case ArgoEventTypes.GENERATOR_CHANGED://1

listener.generatorChanged(event);
break;


case ArgoEventTypes.GENERATOR_ADDED://1

listener.generatorAdded(event);
break;


case ArgoEventTypes.GENERATOR_REMOVED://1

listener.generatorRemoved(event);
break;


default://1


//#if LOGGING 
LOG.error("Invalid event:" + event.getEventType());
//#endif 

break;


} 

} 

private void handleFireNotationEvent(
        final ArgoNotationEvent event,
        final ArgoNotationEventListener listener)
    { 
if(SwingUtilities.isEventDispatchThread())//1
{ 
fireNotationEventInternal(event, listener);
} 
else
{ 
SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    fireNotationEventInternal(event, listener);
                }
            });
} 

} 

private void handleFireHelpEvent(
        ArgoHelpEvent event,
        ArgoHelpEventListener listener)
    { 
switch (event.getEventType()) //1
{ 
case ArgoEventTypes.HELP_CHANGED ://1

listener.helpChanged(event);
break;


case ArgoEventTypes.HELP_REMOVED ://1

listener.helpRemoved(event);
break;


default ://1


//#if LOGGING 
LOG.error("Invalid event:" + event.getEventType());
//#endif 

break;


} 

} 

public static void addListener(ArgoEventListener listener)
    { 
SINGLETON.doAddListener(ArgoEventTypes.ANY_EVENT, listener);
} 

public static ArgoEventPump getInstance()
    { 
return SINGLETON;
} 

protected void doRemoveListener(int event, ArgoEventListener listener)
    { 
if(listeners == null)//1
{ 
return;
} 

synchronized (listeners) //1
{ 
List<Pair> removeList = new ArrayList<Pair>();
if(event == ArgoEventTypes.ANY_EVENT)//1
{ 
for (Pair p : listeners) //1
{ 
if(p.listener == listener)//1
{ 
removeList.add(p);
} 

} 

} 
else
{ 
Pair test = new Pair(event, listener);
for (Pair p : listeners) //1
{ 
if(p.equals(test))//1
{ 
removeList.add(p);
} 

} 

} 

listeners.removeAll(removeList);
} 

} 

protected void doFireEvent(ArgoEvent event)
    { 
if(listeners == null)//1
{ 
return;
} 

List<Pair> readOnlyListeners;
synchronized (listeners) //1
{ 
readOnlyListeners = new ArrayList<Pair>(listeners);
} 

for (Pair pair : readOnlyListeners) //1
{ 
if(pair.getEventType() == ArgoEventTypes.ANY_EVENT)//1
{ 
handleFireEvent(event, pair.getListener());
} 
else
if(pair.getEventType() == event.getEventStartRange()
                       || pair.getEventType() == event.getEventType())//1
{ 
handleFireEvent(event, pair.getListener());
} 


} 

} 

private void handleFireStatusEvent(
        ArgoStatusEvent event,
        ArgoStatusEventListener listener)
    { 
switch (event.getEventType()) //1
{ 
case ArgoEventTypes.STATUS_TEXT ://1

listener.statusText(event);
break;


case ArgoEventTypes.STATUS_CLEARED ://1

listener.statusCleared(event);
break;


case ArgoEventTypes.STATUS_PROJECT_SAVED ://1

listener.projectSaved(event);
break;


case ArgoEventTypes.STATUS_PROJECT_LOADED ://1

listener.projectLoaded(event);
break;


case ArgoEventTypes.STATUS_PROJECT_MODIFIED ://1

listener.projectModified(event);
break;


default ://1


//#if LOGGING 
LOG.error("Invalid event:" + event.getEventType());
//#endif 

break;


} 

} 

private void handleFireEvent(ArgoEvent event, ArgoEventListener listener)
    { 
if(event.getEventType() == ArgoEventTypes.ANY_EVENT)//1
{ 
if(listener instanceof ArgoNotationEventListener)//1
{ 
handleFireNotationEvent((ArgoNotationEvent) event,
                                        (ArgoNotationEventListener) listener);
} 

if(listener instanceof ArgoHelpEventListener)//1
{ 
handleFireHelpEvent((ArgoHelpEvent) event,
                                    (ArgoHelpEventListener) listener);
} 

if(listener instanceof ArgoStatusEventListener)//1
{ 
handleFireStatusEvent((ArgoStatusEvent) event,
                                      (ArgoStatusEventListener) listener);
} 

} 
else
{ 
if(event.getEventType() >= ArgoEventTypes.ANY_NOTATION_EVENT
                    && event.getEventType() < ArgoEventTypes.LAST_NOTATION_EVENT)//1
{ 
if(listener instanceof ArgoNotationEventListener)//1
{ 
handleFireNotationEvent((ArgoNotationEvent) event,
                                            (ArgoNotationEventListener) listener);
} 

} 

if(event.getEventType() >= ArgoEventTypes
                    .ANY_DIAGRAM_APPEARANCE_EVENT
                    && event.getEventType() < ArgoEventTypes
                    .LAST_DIAGRAM_APPEARANCE_EVENT)//1
{ 
if(listener instanceof ArgoDiagramAppearanceEventListener)//1
{ 
handleFireDiagramAppearanceEvent(
                        (ArgoDiagramAppearanceEvent) event,
                        (ArgoDiagramAppearanceEventListener) listener);
} 

} 

if(event.getEventType() >= ArgoEventTypes.ANY_HELP_EVENT
                    && event.getEventType() < ArgoEventTypes.LAST_HELP_EVENT)//1
{ 
if(listener instanceof ArgoHelpEventListener)//1
{ 
handleFireHelpEvent((ArgoHelpEvent) event,
                                        (ArgoHelpEventListener) listener);
} 

} 

if(event.getEventType() >= ArgoEventTypes.ANY_GENERATOR_EVENT
                    && event.getEventType() < ArgoEventTypes.LAST_GENERATOR_EVENT)//1
{ 
if(listener instanceof ArgoGeneratorEventListener)//1
{ 
handleFireGeneratorEvent((ArgoGeneratorEvent) event,
                                             (ArgoGeneratorEventListener) listener);
} 

} 

if(event.getEventType() >= ArgoEventTypes.ANY_STATUS_EVENT
                    && event.getEventType() < ArgoEventTypes
                    .LAST_STATUS_EVENT)//1
{ 
if(listener instanceof ArgoStatusEventListener)//1
{ 
handleFireStatusEvent((ArgoStatusEvent) event,
                                          (ArgoStatusEventListener) listener);
} 

} 

if(event.getEventType() >= ArgoEventTypes.ANY_PROFILE_EVENT
                    && event.getEventType() < ArgoEventTypes
                    .LAST_PROFILE_EVENT)//1
{ 
if(listener instanceof ArgoProfileEventListener)//1
{ 
handleFireProfileEvent((ArgoProfileEvent) event,
                                           (ArgoProfileEventListener) listener);
} 

} 

} 

} 

private ArgoEventPump()
    { 
} 

private void handleFireDiagramAppearanceEvent(
        final ArgoDiagramAppearanceEvent event,
        final ArgoDiagramAppearanceEventListener listener)
    { 
if(SwingUtilities.isEventDispatchThread())//1
{ 
fireDiagramAppearanceEventInternal(event, listener);
} 
else
{ 
SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    fireDiagramAppearanceEventInternal(event, listener);
                }
            });
} 

} 

private void fireNotationEventInternal(ArgoNotationEvent event,
                                           ArgoNotationEventListener listener)
    { 
switch (event.getEventType()) //1
{ 
case ArgoEventTypes.NOTATION_CHANGED ://1

listener.notationChanged(event);
break;


case ArgoEventTypes.NOTATION_ADDED ://1

listener.notationAdded(event);
break;


case ArgoEventTypes.NOTATION_REMOVED ://1

listener.notationRemoved(event);
break;


case ArgoEventTypes.NOTATION_PROVIDER_ADDED ://1

listener.notationProviderAdded(event);
break;


case ArgoEventTypes.NOTATION_PROVIDER_REMOVED ://1

listener.notationProviderRemoved(event);
break;


default ://1


//#if LOGGING 
LOG.error("Invalid event:" + event.getEventType());
//#endif 

break;


} 

} 

public static void addListener(int event, ArgoEventListener listener)
    { 
SINGLETON.doAddListener(event, listener);
} 

static class Pair  { 
private int eventType;
private ArgoEventListener listener;
int getEventType()
        { 
return eventType;
} 

@Override
        public boolean equals(Object o)
        { 
if(o instanceof Pair)//1
{ 
Pair p = (Pair) o;
if(p.eventType == eventType && p.listener == listener)//1
{ 
return true;
} 

} 

return false;
} 

@Override
        public String toString()
        { 
return "{Pair(" + eventType + "," + listener + ")}";
} 

Pair(int myEventType, ArgoEventListener myListener)
        { 
eventType = myEventType;
listener = myListener;
} 

ArgoEventListener getListener()
        { 
return listener;
} 

@Override
        public int hashCode()
        { 
if(listener != null)//1
{ 
return eventType + listener.hashCode();
} 

return eventType;
} 

 } 

 } 


