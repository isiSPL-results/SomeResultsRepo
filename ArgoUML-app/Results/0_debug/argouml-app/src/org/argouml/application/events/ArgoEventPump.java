
//#if 1372702051 
// Compilation Unit of /ArgoEventPump.java 
 

//#if 218972145 
package org.argouml.application.events;
//#endif 


//#if 1592676313 
import java.util.ArrayList;
//#endif 


//#if 2122359528 
import java.util.List;
//#endif 


//#if 1062453362 
import javax.swing.SwingUtilities;
//#endif 


//#if 1095882922 
import org.argouml.application.api.ArgoEventListener;
//#endif 


//#if 238058198 
import org.apache.log4j.Logger;
//#endif 


//#if -1019363410 
public final class ArgoEventPump  { 

//#if 1966905774 
private List<Pair> listeners;
//#endif 


//#if 1848720775 
static final ArgoEventPump SINGLETON = new ArgoEventPump();
//#endif 


//#if -638815478 
private static final Logger LOG = Logger.getLogger(ArgoEventPump.class);
//#endif 


//#if -1863773246 
private void handleFireProfileEvent(
        ArgoProfileEvent event,
        ArgoProfileEventListener listener)
    { 

//#if -813178907 
switch (event.getEventType()) //1
{ 
case ArgoEventTypes.PROFILE_ADDED://1


//#if -180891276 
listener.profileAdded(event);
//#endif 


//#if 1920378749 
break;

//#endif 


case ArgoEventTypes.PROFILE_REMOVED://1


//#if -1996508986 
listener.profileRemoved(event);
//#endif 


//#if -1972990133 
break;

//#endif 


default://1


//#if 791941187 
LOG.error("Invalid event:" + event.getEventType());
//#endif 


//#if 2130755090 
break;

//#endif 


} 

//#endif 

} 

//#endif 


//#if -811020013 
public static void removeListener(int event, ArgoEventListener listener)
    { 

//#if -1171062401 
SINGLETON.doRemoveListener(event, listener);
//#endif 

} 

//#endif 


//#if 1654152650 
public static void fireEvent(ArgoEvent event)
    { 

//#if 1873988032 
SINGLETON.doFireEvent(event);
//#endif 

} 

//#endif 


//#if 1472156001 
private void fireDiagramAppearanceEventInternal(
        final ArgoDiagramAppearanceEvent event,
        final ArgoDiagramAppearanceEventListener listener)
    { 

//#if -1285425359 
switch (event.getEventType()) //1
{ 
case ArgoEventTypes.DIAGRAM_FONT_CHANGED ://1


//#if -445717012 
listener.diagramFontChanged(event);
//#endif 


//#if 1632898016 
break;

//#endif 


default ://1


//#if -326389946 
LOG.error("Invalid event:" + event.getEventType());
//#endif 


//#if 2081652949 
break;

//#endif 


} 

//#endif 

} 

//#endif 


//#if 1828561454 
public static void removeListener(ArgoEventListener listener)
    { 

//#if -2098733184 
SINGLETON.doRemoveListener(ArgoEventTypes.ANY_EVENT, listener);
//#endif 

} 

//#endif 


//#if -902205512 
protected void doAddListener(int event, ArgoEventListener listener)
    { 

//#if -2136353873 
if(listeners == null)//1
{ 

//#if 507703362 
listeners = new ArrayList<Pair>();
//#endif 

} 

//#endif 


//#if 801578687 
synchronized (listeners) //1
{ 

//#if 570493337 
listeners.add(new Pair(event, listener));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1368792492 
private void handleFireGeneratorEvent(
        ArgoGeneratorEvent event,
        ArgoGeneratorEventListener listener)
    { 

//#if -866918418 
switch (event.getEventType()) //1
{ 
case ArgoEventTypes.GENERATOR_CHANGED://1


//#if -1368726782 
listener.generatorChanged(event);
//#endif 


//#if -768262791 
break;

//#endif 


case ArgoEventTypes.GENERATOR_ADDED://1


//#if -1058172700 
listener.generatorAdded(event);
//#endif 


//#if 2101274531 
break;

//#endif 


case ArgoEventTypes.GENERATOR_REMOVED://1


//#if 1133605959 
listener.generatorRemoved(event);
//#endif 


//#if -125785728 
break;

//#endif 


default://1


//#if 1011381308 
LOG.error("Invalid event:" + event.getEventType());
//#endif 


//#if 793590091 
break;

//#endif 


} 

//#endif 

} 

//#endif 


//#if 1106497551 
private void handleFireNotationEvent(
        final ArgoNotationEvent event,
        final ArgoNotationEventListener listener)
    { 

//#if -998964147 
if(SwingUtilities.isEventDispatchThread())//1
{ 

//#if 183831579 
fireNotationEventInternal(event, listener);
//#endif 

} 
else
{ 

//#if 504076402 
SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    fireNotationEventInternal(event, listener);
                }
            });
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2008367398 
private void handleFireHelpEvent(
        ArgoHelpEvent event,
        ArgoHelpEventListener listener)
    { 

//#if 836754959 
switch (event.getEventType()) //1
{ 
case ArgoEventTypes.HELP_CHANGED ://1


//#if 459690658 
listener.helpChanged(event);
//#endif 


//#if -1860756895 
break;

//#endif 


case ArgoEventTypes.HELP_REMOVED ://1


//#if 1696437119 
listener.helpRemoved(event);
//#endif 


//#if -445019054 
break;

//#endif 


default ://1


//#if -1916276805 
LOG.error("Invalid event:" + event.getEventType());
//#endif 


//#if 326824842 
break;

//#endif 


} 

//#endif 

} 

//#endif 


//#if 48281141 
public static void addListener(ArgoEventListener listener)
    { 

//#if -2129845383 
SINGLETON.doAddListener(ArgoEventTypes.ANY_EVENT, listener);
//#endif 

} 

//#endif 


//#if -1767856591 
public static ArgoEventPump getInstance()
    { 

//#if 546837174 
return SINGLETON;
//#endif 

} 

//#endif 


//#if -1212403001 
protected void doRemoveListener(int event, ArgoEventListener listener)
    { 

//#if -1574741127 
if(listeners == null)//1
{ 

//#if -612313489 
return;
//#endif 

} 

//#endif 


//#if 1715712393 
synchronized (listeners) //1
{ 

//#if -620246433 
List<Pair> removeList = new ArrayList<Pair>();
//#endif 


//#if -1587786111 
if(event == ArgoEventTypes.ANY_EVENT)//1
{ 

//#if -31649389 
for (Pair p : listeners) //1
{ 

//#if 425794973 
if(p.listener == listener)//1
{ 

//#if -1600061816 
removeList.add(p);
//#endif 

} 

//#endif 

} 

//#endif 

} 
else
{ 

//#if 398147659 
Pair test = new Pair(event, listener);
//#endif 


//#if 1421579448 
for (Pair p : listeners) //1
{ 

//#if 328695531 
if(p.equals(test))//1
{ 

//#if -1621687170 
removeList.add(p);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 736203687 
listeners.removeAll(removeList);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2000394646 
protected void doFireEvent(ArgoEvent event)
    { 

//#if 1676408963 
if(listeners == null)//1
{ 

//#if -2101443734 
return;
//#endif 

} 

//#endif 


//#if -1839742268 
List<Pair> readOnlyListeners;
//#endif 


//#if -1459439213 
synchronized (listeners) //1
{ 

//#if -1499364774 
readOnlyListeners = new ArrayList<Pair>(listeners);
//#endif 

} 

//#endif 


//#if 2007758206 
for (Pair pair : readOnlyListeners) //1
{ 

//#if -1679404093 
if(pair.getEventType() == ArgoEventTypes.ANY_EVENT)//1
{ 

//#if 1230284463 
handleFireEvent(event, pair.getListener());
//#endif 

} 
else

//#if -1066024308 
if(pair.getEventType() == event.getEventStartRange()
                       || pair.getEventType() == event.getEventType())//1
{ 

//#if 1789598819 
handleFireEvent(event, pair.getListener());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if -219969547 
private void handleFireStatusEvent(
        ArgoStatusEvent event,
        ArgoStatusEventListener listener)
    { 

//#if 1337911566 
switch (event.getEventType()) //1
{ 
case ArgoEventTypes.STATUS_TEXT ://1


//#if 1539670059 
listener.statusText(event);
//#endif 


//#if 1006561038 
break;

//#endif 


case ArgoEventTypes.STATUS_CLEARED ://1


//#if -971320634 
listener.statusCleared(event);
//#endif 


//#if 833091614 
break;

//#endif 


case ArgoEventTypes.STATUS_PROJECT_SAVED ://1


//#if -958523855 
listener.projectSaved(event);
//#endif 


//#if -1764429673 
break;

//#endif 


case ArgoEventTypes.STATUS_PROJECT_LOADED ://1


//#if 547973152 
listener.projectLoaded(event);
//#endif 


//#if 490043988 
break;

//#endif 


case ArgoEventTypes.STATUS_PROJECT_MODIFIED ://1


//#if 1334052864 
listener.projectModified(event);
//#endif 


//#if 1460570160 
break;

//#endif 


default ://1


//#if -1541991253 
LOG.error("Invalid event:" + event.getEventType());
//#endif 


//#if 462832762 
break;

//#endif 


} 

//#endif 

} 

//#endif 


//#if 2135032263 
private void handleFireEvent(ArgoEvent event, ArgoEventListener listener)
    { 

//#if -1685882354 
if(event.getEventType() == ArgoEventTypes.ANY_EVENT)//1
{ 

//#if 1301121403 
if(listener instanceof ArgoNotationEventListener)//1
{ 

//#if -1054766000 
handleFireNotationEvent((ArgoNotationEvent) event,
                                        (ArgoNotationEventListener) listener);
//#endif 

} 

//#endif 


//#if -866064484 
if(listener instanceof ArgoHelpEventListener)//1
{ 

//#if -203490228 
handleFireHelpEvent((ArgoHelpEvent) event,
                                    (ArgoHelpEventListener) listener);
//#endif 

} 

//#endif 


//#if 1823383883 
if(listener instanceof ArgoStatusEventListener)//1
{ 

//#if -1134216750 
handleFireStatusEvent((ArgoStatusEvent) event,
                                      (ArgoStatusEventListener) listener);
//#endif 

} 

//#endif 

} 
else
{ 

//#if 802809535 
if(event.getEventType() >= ArgoEventTypes.ANY_NOTATION_EVENT
                    && event.getEventType() < ArgoEventTypes.LAST_NOTATION_EVENT)//1
{ 

//#if 2096879066 
if(listener instanceof ArgoNotationEventListener)//1
{ 

//#if -524479080 
handleFireNotationEvent((ArgoNotationEvent) event,
                                            (ArgoNotationEventListener) listener);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1660706369 
if(event.getEventType() >= ArgoEventTypes
                    .ANY_DIAGRAM_APPEARANCE_EVENT
                    && event.getEventType() < ArgoEventTypes
                    .LAST_DIAGRAM_APPEARANCE_EVENT)//1
{ 

//#if -2144107728 
if(listener instanceof ArgoDiagramAppearanceEventListener)//1
{ 

//#if 1335891252 
handleFireDiagramAppearanceEvent(
                        (ArgoDiagramAppearanceEvent) event,
                        (ArgoDiagramAppearanceEventListener) listener);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -332723553 
if(event.getEventType() >= ArgoEventTypes.ANY_HELP_EVENT
                    && event.getEventType() < ArgoEventTypes.LAST_HELP_EVENT)//1
{ 

//#if 97014519 
if(listener instanceof ArgoHelpEventListener)//1
{ 

//#if 96305249 
handleFireHelpEvent((ArgoHelpEvent) event,
                                        (ArgoHelpEventListener) listener);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1099054531 
if(event.getEventType() >= ArgoEventTypes.ANY_GENERATOR_EVENT
                    && event.getEventType() < ArgoEventTypes.LAST_GENERATOR_EVENT)//1
{ 

//#if -1928543417 
if(listener instanceof ArgoGeneratorEventListener)//1
{ 

//#if 1543439502 
handleFireGeneratorEvent((ArgoGeneratorEvent) event,
                                             (ArgoGeneratorEventListener) listener);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1131481599 
if(event.getEventType() >= ArgoEventTypes.ANY_STATUS_EVENT
                    && event.getEventType() < ArgoEventTypes
                    .LAST_STATUS_EVENT)//1
{ 

//#if 1216909827 
if(listener instanceof ArgoStatusEventListener)//1
{ 

//#if 1009331369 
handleFireStatusEvent((ArgoStatusEvent) event,
                                          (ArgoStatusEventListener) listener);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1782602863 
if(event.getEventType() >= ArgoEventTypes.ANY_PROFILE_EVENT
                    && event.getEventType() < ArgoEventTypes
                    .LAST_PROFILE_EVENT)//1
{ 

//#if 1943474810 
if(listener instanceof ArgoProfileEventListener)//1
{ 

//#if 292535432 
handleFireProfileEvent((ArgoProfileEvent) event,
                                           (ArgoProfileEventListener) listener);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1079874334 
private ArgoEventPump()
    { 
} 

//#endif 


//#if 274654604 
private void handleFireDiagramAppearanceEvent(
        final ArgoDiagramAppearanceEvent event,
        final ArgoDiagramAppearanceEventListener listener)
    { 

//#if -358356433 
if(SwingUtilities.isEventDispatchThread())//1
{ 

//#if 84660390 
fireDiagramAppearanceEventInternal(event, listener);
//#endif 

} 
else
{ 

//#if -1177591075 
SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    fireDiagramAppearanceEventInternal(event, listener);
                }
            });
//#endif 

} 

//#endif 

} 

//#endif 


//#if -226569206 
private void fireNotationEventInternal(ArgoNotationEvent event,
                                           ArgoNotationEventListener listener)
    { 

//#if 1453862694 
switch (event.getEventType()) //1
{ 
case ArgoEventTypes.NOTATION_CHANGED ://1


//#if 328540538 
listener.notationChanged(event);
//#endif 


//#if -1235262758 
break;

//#endif 


case ArgoEventTypes.NOTATION_ADDED ://1


//#if 1237503034 
listener.notationAdded(event);
//#endif 


//#if 1640888014 
break;

//#endif 


case ArgoEventTypes.NOTATION_REMOVED ://1


//#if 146507863 
listener.notationRemoved(event);
//#endif 


//#if -311092405 
break;

//#endif 


case ArgoEventTypes.NOTATION_PROVIDER_ADDED ://1


//#if 416325127 
listener.notationProviderAdded(event);
//#endif 


//#if -1891918580 
break;

//#endif 


case ArgoEventTypes.NOTATION_PROVIDER_REMOVED ://1


//#if 1258620560 
listener.notationProviderRemoved(event);
//#endif 


//#if -1498995403 
break;

//#endif 


default ://1


//#if 1908857461 
LOG.error("Invalid event:" + event.getEventType());
//#endif 


//#if -1949399356 
break;

//#endif 


} 

//#endif 

} 

//#endif 


//#if -1812048660 
public static void addListener(int event, ArgoEventListener listener)
    { 

//#if -993367512 
SINGLETON.doAddListener(event, listener);
//#endif 

} 

//#endif 


//#if 618739853 
static class Pair  { 

//#if -1576287927 
private int eventType;
//#endif 


//#if -105690817 
private ArgoEventListener listener;
//#endif 


//#if 1635678776 
int getEventType()
        { 

//#if 1323819530 
return eventType;
//#endif 

} 

//#endif 


//#if -1294736647 
@Override
        public boolean equals(Object o)
        { 

//#if 1249469285 
if(o instanceof Pair)//1
{ 

//#if 1840168725 
Pair p = (Pair) o;
//#endif 


//#if -1425857124 
if(p.eventType == eventType && p.listener == listener)//1
{ 

//#if 988416058 
return true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 538496251 
return false;
//#endif 

} 

//#endif 


//#if 2105251389 
@Override
        public String toString()
        { 

//#if -409662451 
return "{Pair(" + eventType + "," + listener + ")}";
//#endif 

} 

//#endif 


//#if -1852840497 
Pair(int myEventType, ArgoEventListener myListener)
        { 

//#if 1017744757 
eventType = myEventType;
//#endif 


//#if -1215907093 
listener = myListener;
//#endif 

} 

//#endif 


//#if 1761268044 
ArgoEventListener getListener()
        { 

//#if -404282166 
return listener;
//#endif 

} 

//#endif 


//#if -1239831284 
@Override
        public int hashCode()
        { 

//#if -1972155947 
if(listener != null)//1
{ 

//#if 348964447 
return eventType + listener.hashCode();
//#endif 

} 

//#endif 


//#if -143997012 
return eventType;
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

