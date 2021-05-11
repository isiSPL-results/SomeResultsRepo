
//#if 323852549 
// Compilation Unit of /NotationProvider.java 
 

//#if 1784178255 
package org.argouml.notation;
//#endif 


//#if 1698693375 
import java.beans.PropertyChangeEvent;
//#endif 


//#if 1220367657 
import java.beans.PropertyChangeListener;
//#endif 


//#if 68193122 
import java.util.ArrayList;
//#endif 


//#if -841382337 
import java.util.Collection;
//#endif 


//#if -313046876 
import java.util.Collections;
//#endif 


//#if -454164547 
import java.util.Map;
//#endif 


//#if 124187986 
import org.argouml.model.Model;
//#endif 


//#if -1723348513 
import org.apache.log4j.Logger;
//#endif 


//#if 1819026215 
public abstract class NotationProvider  { 

//#if -1642511211 
private static final String LIST_SEPARATOR = ", ";
//#endif 


//#if -634470847 
private final Collection<Object[]> listeners = new ArrayList<Object[]>();
//#endif 


//#if -578210288 
private static final Logger LOG = Logger.getLogger(NotationProvider.class);
//#endif 


//#if 1633984374 
public abstract void parse(Object modelElement, String text);
//#endif 


//#if -235565574 
protected StringBuilder formatNameList(Collection modelElements,
                                           String separator)
    { 

//#if -1030361810 
StringBuilder result = new StringBuilder();
//#endif 


//#if -2017353824 
for (Object element : modelElements) //1
{ 

//#if 2113645164 
String name = Model.getFacade().getName(element);
//#endif 


//#if -822441154 
result.append(name).append(separator);
//#endif 

} 

//#endif 


//#if -830210512 
if(result.length() >= separator.length())//1
{ 

//#if -661524058 
result.delete(result.length() - separator.length(),
                          result.length());
//#endif 

} 

//#endif 


//#if -1789237694 
return result;
//#endif 

} 

//#endif 


//#if 1682072137 
public abstract String getParsingHelp();
//#endif 


//#if 564223608 
public void updateListener(final PropertyChangeListener listener,
                               Object modelElement,
                               PropertyChangeEvent pce)
    { 

//#if 1562628022 
if(Model.getUmlFactory().isRemoved(modelElement))//1
{ 

//#if -300592115 
LOG.warn("Encountered deleted object during delete of "
                     + modelElement);
//#endif 


//#if -1635074305 
return;
//#endif 

} 

//#endif 


//#if -137245001 
cleanListener(listener, modelElement);
//#endif 


//#if -398240581 
initialiseListener(listener, modelElement);
//#endif 

} 

//#endif 


//#if 134420327 
public void initialiseListener(PropertyChangeListener listener,
                                   Object modelElement)
    { 

//#if 1871625170 
addElementListener(listener, modelElement);
//#endif 

} 

//#endif 


//#if -1950381818 
public static boolean isValue(final String key, final Map map)
    { 

//#if 1961996081 
if(map == null)//1
{ 

//#if -1807086904 
return false;
//#endif 

} 

//#endif 


//#if 1231201647 
Object o = map.get(key);
//#endif 


//#if 1201199395 
if(!(o instanceof Boolean))//1
{ 

//#if -355634826 
return false;
//#endif 

} 

//#endif 


//#if -836433537 
return ((Boolean) o).booleanValue();
//#endif 

} 

//#endif 


//#if 2075223783 
protected final void removeAllElementListeners(
        PropertyChangeListener listener)
    { 

//#if -1740859334 
for (Object[] lis : listeners) //1
{ 

//#if 800749935 
Object property = lis[1];
//#endif 


//#if 494153121 
if(property == null)//1
{ 

//#if -1020557920 
Model.getPump().removeModelEventListener(listener, lis[0]);
//#endif 

} 
else

//#if -13474377 
if(property instanceof String[])//1
{ 

//#if -1457675331 
Model.getPump().removeModelEventListener(listener, lis[0],
                        (String[]) property);
//#endif 

} 
else

//#if 908418132 
if(property instanceof String)//1
{ 

//#if -766217129 
Model.getPump().removeModelEventListener(listener, lis[0],
                        (String) property);
//#endif 

} 
else
{ 

//#if 2103600581 
throw new RuntimeException(
                    "Internal error in removeAllElementListeners");
//#endif 

} 

//#endif 


//#endif 


//#endif 

} 

//#endif 


//#if 844271301 
listeners.clear();
//#endif 

} 

//#endif 


//#if 2113541932 
@Deprecated
    public abstract String toString(Object modelElement, Map args);
//#endif 


//#if -910591743 
protected final void addElementListener(PropertyChangeListener listener,
                                            Object element, String property)
    { 

//#if 488155089 
if(Model.getUmlFactory().isRemoved(element))//1
{ 

//#if -1946234358 
LOG.warn("Encountered deleted object during delete of " + element);
//#endif 


//#if -206870813 
return;
//#endif 

} 

//#endif 


//#if -398073808 
Object[] entry = new Object[] {element, property};
//#endif 


//#if -1442004740 
if(!listeners.contains(entry))//1
{ 

//#if -702146244 
listeners.add(entry);
//#endif 


//#if -1347802073 
Model.getPump().addModelEventListener(listener, element, property);
//#endif 

} 
else
{ 

//#if 487429618 
LOG.debug("Attempted duplicate registration of event listener"
                      + " - Element: " + element + " Listener: " + listener);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1899777183 
protected final void addElementListener(PropertyChangeListener listener,
                                            Object element, String[] property)
    { 

//#if -224981169 
if(Model.getUmlFactory().isRemoved(element))//1
{ 

//#if 1062291654 
LOG.warn("Encountered deleted object during delete of " + element);
//#endif 


//#if 796492703 
return;
//#endif 

} 

//#endif 


//#if 1914100082 
Object[] entry = new Object[] {element, property};
//#endif 


//#if 1188756730 
if(!listeners.contains(entry))//1
{ 

//#if 2084433 
listeners.add(entry);
//#endif 


//#if -522693188 
Model.getPump().addModelEventListener(listener, element, property);
//#endif 

} 
else
{ 

//#if -1578186289 
LOG.debug("Attempted duplicate registration of event listener"
                      + " - Element: " + element + " Listener: " + listener);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 690218655 
protected final void addElementListener(PropertyChangeListener listener,
                                            Object element)
    { 

//#if -1904323315 
if(Model.getUmlFactory().isRemoved(element))//1
{ 

//#if -1679268288 
LOG.warn("Encountered deleted object during delete of " + element);
//#endif 


//#if -978384359 
return;
//#endif 

} 

//#endif 


//#if 1263978534 
Object[] entry = new Object[] {element, null};
//#endif 


//#if -1271396552 
if(!listeners.contains(entry))//1
{ 

//#if -1797252402 
listeners.add(entry);
//#endif 


//#if -423825748 
Model.getPump().addModelEventListener(listener, element);
//#endif 

} 
else
{ 

//#if -1804456159 
LOG.warn("Attempted duplicate registration of event listener"
                     + " - Element: " + element + " Listener: " + listener);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -369593373 
public void cleanListener(final PropertyChangeListener listener,
                              final Object modelElement)
    { 

//#if 1891730086 
removeAllElementListeners(listener);
//#endif 

} 

//#endif 


//#if -767878558 
protected final void removeElementListener(PropertyChangeListener listener,
            Object element)
    { 

//#if 1940942717 
listeners.remove(new Object[] {element, null});
//#endif 


//#if 764022829 
Model.getPump().removeModelEventListener(listener, element);
//#endif 

} 

//#endif 


//#if -2091287774 
protected StringBuilder formatNameList(Collection modelElements)
    { 

//#if -1683806250 
return formatNameList(modelElements, LIST_SEPARATOR);
//#endif 

} 

//#endif 


//#if -380937096 
public String toString(Object modelElement,
                           NotationSettings settings)
    { 

//#if -149007605 
return toString(modelElement, Collections.emptyMap());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

