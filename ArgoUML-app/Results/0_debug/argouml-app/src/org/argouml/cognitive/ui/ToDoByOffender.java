
//#if -833638374 
// Compilation Unit of /ToDoByOffender.java 
 

//#if 1240845712 
package org.argouml.cognitive.ui;
//#endif 


//#if 2065962744 
import java.util.List;
//#endif 


//#if 616995014 
import org.apache.log4j.Logger;
//#endif 


//#if 663244090 
import org.argouml.cognitive.Designer;
//#endif 


//#if 620672525 
import org.argouml.cognitive.ListSet;
//#endif 


//#if -856741556 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 521750491 
import org.argouml.cognitive.ToDoListEvent;
//#endif 


//#if -1267052339 
import org.argouml.cognitive.ToDoListListener;
//#endif 


//#if -1920437403 
public class ToDoByOffender extends 
//#if -523238108 
ToDoPerspective
//#endif 

 implements 
//#if 1237642634 
ToDoListListener
//#endif 

  { 

//#if -1498360686 
private static final Logger LOG = Logger.getLogger(ToDoByOffender.class);
//#endif 


//#if 1832862258 
public ToDoByOffender()
    { 

//#if 746038842 
super("combobox.todo-perspective-offender");
//#endif 


//#if -2005236668 
addSubTreeModel(new GoListToOffenderToItem());
//#endif 

} 

//#endif 


//#if -970343017 
public void toDoItemsRemoved(ToDoListEvent tde)
    { 

//#if 1019282180 
LOG.debug("toDoItemRemoved");
//#endif 


//#if 1389377366 
List<ToDoItem> items = tde.getToDoItemList();
//#endif 


//#if 654728169 
Object[] path = new Object[2];
//#endif 


//#if 1569569358 
path[0] = Designer.theDesigner().getToDoList();
//#endif 


//#if -763550437 
ListSet allOffenders = Designer.theDesigner().getToDoList()
                               .getOffenders();
//#endif 


//#if 154687721 
synchronized (allOffenders) //1
{ 

//#if -952773333 
for (Object off : allOffenders) //1
{ 

//#if -1624656748 
boolean anyInOff = false;
//#endif 


//#if 343745337 
synchronized (items) //1
{ 

//#if 2104722106 
for (ToDoItem item : items) //1
{ 

//#if -1688734187 
ListSet offenders = item.getOffenders();
//#endif 


//#if -551288199 
if(offenders.contains(off))//1
{ 

//#if -780230545 
anyInOff = true;
//#endif 


//#if -344813251 
break;

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -905569119 
if(!anyInOff)//1
{ 

//#if -457303444 
continue;
//#endif 

} 

//#endif 


//#if 1934608159 
LOG.debug("toDoItemRemoved updating PriorityNode");
//#endif 


//#if -1089244852 
path[1] = off;
//#endif 


//#if 1888257125 
fireTreeStructureChanged(path);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1032493803 
public void toDoItemsChanged(ToDoListEvent tde)
    { 

//#if -1350781218 
LOG.debug("toDoItemsChanged");
//#endif 


//#if 1079830449 
List<ToDoItem> items = tde.getToDoItemList();
//#endif 


//#if -1300422076 
Object[] path = new Object[2];
//#endif 


//#if 1152149523 
path[0] = Designer.theDesigner().getToDoList();
//#endif 


//#if -76217290 
ListSet allOffenders = Designer.theDesigner().getToDoList()
                               .getOffenders();
//#endif 


//#if -1674760018 
synchronized (allOffenders) //1
{ 

//#if -421897395 
for (Object off : allOffenders) //1
{ 

//#if -114634224 
path[1] = off;
//#endif 


//#if -1120440851 
int nMatchingItems = 0;
//#endif 


//#if -1611309315 
synchronized (items) //1
{ 

//#if 1866376107 
for (ToDoItem item : items) //1
{ 

//#if 714119635 
ListSet offenders = item.getOffenders();
//#endif 


//#if -1555560654 
if(!offenders.contains(off))//1
{ 

//#if -507168790 
continue;
//#endif 

} 

//#endif 


//#if 157622871 
nMatchingItems++;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 724292929 
if(nMatchingItems == 0)//1
{ 

//#if -1470540825 
continue;
//#endif 

} 

//#endif 


//#if -173032747 
int[] childIndices = new int[nMatchingItems];
//#endif 


//#if -1370488253 
Object[] children = new Object[nMatchingItems];
//#endif 


//#if -195712886 
nMatchingItems = 0;
//#endif 


//#if -1961226604 
synchronized (items) //2
{ 

//#if -2137311040 
for (ToDoItem item : items) //1
{ 

//#if -667583200 
ListSet offenders = item.getOffenders();
//#endif 


//#if -1711757249 
if(!offenders.contains(off))//1
{ 

//#if 2089290830 
continue;
//#endif 

} 

//#endif 


//#if -1694792764 
childIndices[nMatchingItems] = getIndexOfChild(off,
                                                       item);
//#endif 


//#if -1477364967 
children[nMatchingItems] = item;
//#endif 


//#if 560000548 
nMatchingItems++;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2112860079 
fireTreeNodesChanged(this, path, childIndices, children);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -2089611401 
public void toDoItemsAdded(ToDoListEvent tde)
    { 

//#if 940999684 
LOG.debug("toDoItemAdded");
//#endif 


//#if 1590401462 
List<ToDoItem> items = tde.getToDoItemList();
//#endif 


//#if 2077392457 
Object[] path = new Object[2];
//#endif 


//#if -1200964626 
path[0] = Designer.theDesigner().getToDoList();
//#endif 


//#if -382984325 
ListSet allOffenders = Designer.theDesigner().getToDoList()
                               .getOffenders();
//#endif 


//#if 9214601 
synchronized (allOffenders) //1
{ 

//#if -1076634505 
for (Object off : allOffenders) //1
{ 

//#if -386709001 
path[1] = off;
//#endif 


//#if -27717932 
int nMatchingItems = 0;
//#endif 


//#if 523395620 
synchronized (items) //1
{ 

//#if 1638902203 
for (ToDoItem item : items) //1
{ 

//#if -198773618 
ListSet offenders = item.getOffenders();
//#endif 


//#if 142330413 
if(!offenders.contains(off))//1
{ 

//#if -383719616 
continue;
//#endif 

} 

//#endif 


//#if 1608116370 
nMatchingItems++;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -818632024 
if(nMatchingItems == 0)//1
{ 

//#if -803830964 
continue;
//#endif 

} 

//#endif 


//#if 1518174286 
int[] childIndices = new int[nMatchingItems];
//#endif 


//#if 381832572 
Object[] children = new Object[nMatchingItems];
//#endif 


//#if 1013909763 
nMatchingItems = 0;
//#endif 


//#if 1747707405 
synchronized (items) //2
{ 

//#if 519873936 
for (ToDoItem item : items) //1
{ 

//#if 1293698047 
ListSet offenders = item.getOffenders();
//#endif 


//#if -642137506 
if(!offenders.contains(off))//1
{ 

//#if -1597814118 
continue;
//#endif 

} 

//#endif 


//#if -781717277 
childIndices[nMatchingItems] = getIndexOfChild(off,
                                                       item);
//#endif 


//#if 1050990874 
children[nMatchingItems] = item;
//#endif 


//#if -418211197 
nMatchingItems++;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -233332074 
fireTreeNodesInserted(this, path, childIndices, children);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1664047555 
public void toDoListChanged(ToDoListEvent tde)
    { 
} 

//#endif 

 } 

//#endif 


//#endif 

