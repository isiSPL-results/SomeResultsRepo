
//#if 1039036911 
// Compilation Unit of /GoListToPriorityToItem.java 
 

//#if 149924571 
package org.argouml.cognitive.ui;
//#endif 


//#if -1521509747 
import java.util.List;
//#endif 


//#if 321209448 
import javax.swing.event.TreeModelListener;
//#endif 


//#if 1862960032 
import javax.swing.tree.TreePath;
//#endif 


//#if 2066482895 
import org.argouml.cognitive.Designer;
//#endif 


//#if 546497249 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 548953782 
import org.argouml.cognitive.ToDoList;
//#endif 


//#if -489761961 
public class GoListToPriorityToItem extends 
//#if 1262110258 
AbstractGoList
//#endif 

  { 

//#if -2039768172 
public int getIndexOfChild(Object parent, Object child)
    { 

//#if 66853285 
if(parent instanceof ToDoList)//1
{ 

//#if 326005315 
return PriorityNode.getPriorityList().indexOf(child);
//#endif 

} 

//#endif 


//#if -735111225 
if(parent instanceof PriorityNode)//1
{ 

//#if -2115434948 
int index = 0;
//#endif 


//#if 205486950 
PriorityNode pn = (PriorityNode) parent;
//#endif 


//#if 54871064 
List<ToDoItem> itemList = Designer.theDesigner().getToDoList()
                                      .getToDoItemList();
//#endif 


//#if 1107408644 
synchronized (itemList) //1
{ 

//#if 301225312 
for (ToDoItem item : itemList) //1
{ 

//#if -1002144283 
if(item.getPriority() == pn.getPriority())//1
{ 

//#if -1837039050 
if(item == child)//1
{ 

//#if -1173808292 
return index;
//#endif 

} 

//#endif 


//#if -1114784519 
index++;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -2108360385 
return -1;
//#endif 

} 

//#endif 


//#if -2038444955 
public int getChildCount(Object parent)
    { 

//#if -1224222003 
if(parent instanceof ToDoList)//1
{ 

//#if 235659561 
return PriorityNode.getPriorityList().size();
//#endif 

} 

//#endif 


//#if -1415183121 
if(parent instanceof PriorityNode)//1
{ 

//#if 1990854944 
PriorityNode pn = (PriorityNode) parent;
//#endif 


//#if -1728799259 
int count = 0;
//#endif 


//#if 1689913682 
List<ToDoItem> itemList = Designer.theDesigner().getToDoList()
                                      .getToDoItemList();
//#endif 


//#if -144279158 
synchronized (itemList) //1
{ 

//#if -434067035 
for (ToDoItem item : itemList) //1
{ 

//#if 34604973 
if(item.getPriority() == pn.getPriority())//1
{ 

//#if -2123744064 
count++;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1375077249 
return count;
//#endif 

} 

//#endif 


//#if 1944208059 
return 0;
//#endif 

} 

//#endif 


//#if -1889354311 
public void addTreeModelListener(TreeModelListener l) { 
} 

//#endif 


//#if 204932019 
public Object getChild(Object parent, int index)
    { 

//#if -890912322 
if(parent instanceof ToDoList)//1
{ 

//#if -1768450492 
return PriorityNode.getPriorityList().get(index);
//#endif 

} 

//#endif 


//#if 1063586656 
if(parent instanceof PriorityNode)//1
{ 

//#if -1419168607 
PriorityNode pn = (PriorityNode) parent;
//#endif 


//#if -1102298221 
List<ToDoItem> itemList =
                Designer.theDesigner().getToDoList().getToDoItemList();
//#endif 


//#if -1655737175 
synchronized (itemList) //1
{ 

//#if 1364739253 
for (ToDoItem item : itemList) //1
{ 

//#if -1769843980 
if(item.getPriority() == pn.getPriority())//1
{ 

//#if 1220553326 
if(index == 0)//1
{ 

//#if -158699697 
return item;
//#endif 

} 

//#endif 


//#if 1978851308 
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


//#if -328087721 
throw new IndexOutOfBoundsException("getChild shouldnt get here "
                                            + "GoListToPriorityToItem");
//#endif 

} 

//#endif 


//#if -2133389907 
public void valueForPathChanged(TreePath path, Object newValue) { 
} 

//#endif 


//#if -495993763 
public boolean isLeaf(Object node)
    { 

//#if 1568982889 
if(node instanceof ToDoList)//1
{ 

//#if 874510732 
return false;
//#endif 

} 

//#endif 


//#if 1679564255 
if(node instanceof PriorityNode && getChildCount(node) > 0)//1
{ 

//#if 641284081 
return false;
//#endif 

} 

//#endif 


//#if 1023477057 
return true;
//#endif 

} 

//#endif 


//#if 672375816 
public void removeTreeModelListener(TreeModelListener l) { 
} 

//#endif 

 } 

//#endif 


//#endif 

