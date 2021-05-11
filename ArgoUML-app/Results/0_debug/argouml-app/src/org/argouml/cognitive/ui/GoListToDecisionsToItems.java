
//#if 1180116896 
// Compilation Unit of /GoListToDecisionsToItems.java 
 

//#if 1769724871 
package org.argouml.cognitive.ui;
//#endif 


//#if -444618432 
import java.util.ArrayList;
//#endif 


//#if 687392033 
import java.util.List;
//#endif 


//#if -685357028 
import java.util.Vector;
//#endif 


//#if 1493843540 
import javax.swing.event.TreeModelListener;
//#endif 


//#if -812206964 
import javax.swing.tree.TreePath;
//#endif 


//#if -1078407534 
import org.argouml.cognitive.Decision;
//#endif 


//#if 225806691 
import org.argouml.cognitive.Designer;
//#endif 


//#if -1294178955 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if -1291722422 
import org.argouml.cognitive.ToDoList;
//#endif 


//#if -517499737 
public class GoListToDecisionsToItems extends 
//#if 2052437277 
AbstractGoList
//#endif 

  { 

//#if -1916231470 
public boolean isLeaf(Object node)
    { 

//#if 61236084 
if(node instanceof ToDoList)//1
{ 

//#if 1980362772 
return false;
//#endif 

} 

//#endif 


//#if -694811172 
if(node instanceof Decision && hasChildren(node))//1
{ 

//#if -1866536125 
return false;
//#endif 

} 

//#endif 


//#if 316481036 
return true;
//#endif 

} 

//#endif 


//#if -1197996008 
public void valueForPathChanged(TreePath path, Object newValue) { 
} 

//#endif 


//#if -1259449564 
public void addTreeModelListener(TreeModelListener l) { 
} 

//#endif 


//#if 383140791 
private boolean hasChildren(Object parent)
    { 

//#if -585883237 
return getChildCountCond(parent, true) > 0;
//#endif 

} 

//#endif 


//#if 180119824 
public int getChildCount(Object parent)
    { 

//#if -1541476349 
return getChildCountCond(parent, false);
//#endif 

} 

//#endif 


//#if 771679375 
public List<Decision> getDecisionList()
    { 

//#if 183558276 
return Designer.theDesigner().getDecisionModel().getDecisionList();
//#endif 

} 

//#endif 


//#if -1409863425 
public int getIndexOfChild(Object parent, Object child)
    { 

//#if -1958962264 
if(parent instanceof ToDoList)//1
{ 

//#if -671552478 
return getDecisionList().indexOf(child);
//#endif 

} 

//#endif 


//#if 648235360 
if(parent instanceof Decision)//1
{ 

//#if -1985695494 
List<ToDoItem> candidates = new ArrayList<ToDoItem>();
//#endif 


//#if -121079025 
Decision dec = (Decision) parent;
//#endif 


//#if -45898987 
List<ToDoItem> itemList =
                Designer.theDesigner().getToDoList().getToDoItemList();
//#endif 


//#if -1257922585 
synchronized (itemList) //1
{ 

//#if 556146687 
for (ToDoItem item : itemList) //1
{ 

//#if -1185064590 
if(item.getPoster().supports(dec))//1
{ 

//#if -1314304685 
candidates.add(item);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 287557575 
return candidates.indexOf(child);
//#endif 

} 

//#endif 


//#if -1398087806 
return -1;
//#endif 

} 

//#endif 


//#if 658235560 
public Object getChild(Object parent, int index)
    { 

//#if 1585675060 
if(parent instanceof ToDoList)//1
{ 

//#if -849087324 
return getDecisionList().get(index);
//#endif 

} 

//#endif 


//#if -102094612 
if(parent instanceof Decision)//1
{ 

//#if 1734829038 
Decision dec = (Decision) parent;
//#endif 


//#if 398028822 
List<ToDoItem> itemList =
                Designer.theDesigner().getToDoList().getToDoItemList();
//#endif 


//#if 1476513862 
synchronized (itemList) //1
{ 

//#if -135673902 
for (ToDoItem item : itemList) //1
{ 

//#if -180207074 
if(item.getPoster().supports(dec))//1
{ 

//#if -190725629 
if(index == 0)//1
{ 

//#if -1277551806 
return item;
//#endif 

} 

//#endif 


//#if -2075560457 
index--;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 2103546974 
throw new IndexOutOfBoundsException("getChild shouldn't get here "
                                            + "GoListToDecisionsToItems");
//#endif 

} 

//#endif 


//#if 1452577469 
public void removeTreeModelListener(TreeModelListener l) { 
} 

//#endif 


//#if -978776998 
private int getChildCountCond(Object parent, boolean stopafterone)
    { 

//#if 899593244 
if(parent instanceof ToDoList)//1
{ 

//#if -1216382310 
return getDecisionList().size();
//#endif 

} 

//#endif 


//#if -788176428 
if(parent instanceof Decision)//1
{ 

//#if 81557639 
Decision dec = (Decision) parent;
//#endif 


//#if 1048209018 
int count = 0;
//#endif 


//#if -1237113699 
List<ToDoItem> itemList =
                Designer.theDesigner().getToDoList().getToDoItemList();
//#endif 


//#if -941418145 
synchronized (itemList) //1
{ 

//#if -1613409250 
for (ToDoItem item : itemList) //1
{ 

//#if 770587674 
if(item.getPoster().supports(dec))//1
{ 

//#if -1132525322 
count++;
//#endif 

} 

//#endif 


//#if 1444217393 
if(stopafterone && count > 0)//1
{ 

//#if 1999558320 
break;

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1187166582 
return count;
//#endif 

} 

//#endif 


//#if 99874380 
return 0;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

