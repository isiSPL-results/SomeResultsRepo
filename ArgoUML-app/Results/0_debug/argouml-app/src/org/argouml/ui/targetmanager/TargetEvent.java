
//#if -1683315417 
// Compilation Unit of /TargetEvent.java 
 

//#if 874516134 
package org.argouml.ui.targetmanager;
//#endif 


//#if -218111591 
import java.util.ArrayList;
//#endif 


//#if -315450036 
import java.util.Arrays;
//#endif 


//#if -1126893848 
import java.util.Collection;
//#endif 


//#if 1333528759 
import java.util.EventObject;
//#endif 


//#if 581630248 
import java.util.List;
//#endif 


//#if 1795909514 
public class TargetEvent extends 
//#if 1229108033 
EventObject
//#endif 

  { 

//#if 1493913642 
public static final String TARGET_SET = "set";
//#endif 


//#if 578859306 
public static final String TARGET_ADDED = "added";
//#endif 


//#if 1626803050 
public static final String TARGET_REMOVED = "removed";
//#endif 


//#if 1305243403 
private String theEventName;
//#endif 


//#if -1477904645 
private Object[] theOldTargets;
//#endif 


//#if 1712744820 
private Object[] theNewTargets;
//#endif 


//#if 780745253 
private static final long serialVersionUID = -307886693486269426L;
//#endif 


//#if 1678288793 
public Collection getRemovedTargetCollection()
    { 

//#if 671394232 
List removedTargets = new ArrayList();
//#endif 


//#if -73934680 
List oldTargets = Arrays.asList(theOldTargets);
//#endif 


//#if 1712693622 
List newTargets = Arrays.asList(theNewTargets);
//#endif 


//#if -460931682 
for (Object o : oldTargets) //1
{ 

//#if 964623426 
if(!newTargets.contains(o))//1
{ 

//#if -590017169 
removedTargets.add(o);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2103790633 
return removedTargets;
//#endif 

} 

//#endif 


//#if 234616848 
public String getName()
    { 

//#if 440671354 
return theEventName;
//#endif 

} 

//#endif 


//#if 650238460 
public Object getNewTarget()
    { 

//#if -1202275304 
return theNewTargets == null
               || theNewTargets.length < 1 ? null : theNewTargets[0];
//#endif 

} 

//#endif 


//#if -1517967751 
public Collection getAddedTargetCollection()
    { 

//#if 981138713 
List addedTargets = new ArrayList();
//#endif 


//#if -1985907927 
List oldTargets = Arrays.asList(theOldTargets);
//#endif 


//#if -199279625 
List newTargets = Arrays.asList(theNewTargets);
//#endif 


//#if 2030236998 
for (Object o : newTargets) //1
{ 

//#if 2029990388 
if(!oldTargets.contains(o))//1
{ 

//#if 1668404351 
addedTargets.add(o);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -209175978 
return addedTargets;
//#endif 

} 

//#endif 


//#if -1380040829 
public TargetEvent(Object source, String tEName,
                       Object[] oldTargets, Object[] newTargets)
    { 

//#if 968184738 
super(source);
//#endif 


//#if 1959873342 
theEventName = tEName;
//#endif 


//#if -1719258745 
theOldTargets = oldTargets;
//#endif 


//#if -1442702361 
theNewTargets = newTargets;
//#endif 

} 

//#endif 


//#if -1540472041 
public Object[] getAddedTargets()
    { 

//#if 560626020 
return getAddedTargetCollection().toArray();
//#endif 

} 

//#endif 


//#if -2065207600 
public Object[] getOldTargets()
    { 

//#if -1714641605 
return theOldTargets == null ? new Object[] {} : theOldTargets;
//#endif 

} 

//#endif 


//#if -63079753 
public Object[] getRemovedTargets()
    { 

//#if -59688676 
return getRemovedTargetCollection().toArray();
//#endif 

} 

//#endif 


//#if -1939321993 
public Object[] getNewTargets()
    { 

//#if 1236116016 
return theNewTargets == null ? new Object[] {} : theNewTargets;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

