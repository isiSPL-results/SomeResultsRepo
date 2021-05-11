// Compilation Unit of /GoListToPriorityToItem.java 
 

//#if COGNITIVE 
package org.argouml.cognitive.ui;
//#endif 


//#if COGNITIVE 
import java.util.List;
//#endif 


//#if COGNITIVE 
import javax.swing.event.TreeModelListener;
//#endif 


//#if COGNITIVE 
import javax.swing.tree.TreePath;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Designer;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.ToDoList;
//#endif 


//#if COGNITIVE 
public class GoListToPriorityToItem extends AbstractGoList
  { 
public int getIndexOfChild(Object parent, Object child)
    { 
if(parent instanceof ToDoList)//1
{ 
return PriorityNode.getPriorityList().indexOf(child);
} 

if(parent instanceof PriorityNode)//1
{ 
int index = 0;
PriorityNode pn = (PriorityNode) parent;
List<ToDoItem> itemList = Designer.theDesigner().getToDoList()
                                      .getToDoItemList();
synchronized (itemList) //1
{ 
for (ToDoItem item : itemList) //1
{ 
if(item.getPriority() == pn.getPriority())//1
{ 
if(item == child)//1
{ 
return index;
} 

index++;
} 

} 

} 

} 

return -1;
} 

public int getChildCount(Object parent)
    { 
if(parent instanceof ToDoList)//1
{ 
return PriorityNode.getPriorityList().size();
} 

if(parent instanceof PriorityNode)//1
{ 
PriorityNode pn = (PriorityNode) parent;
int count = 0;
List<ToDoItem> itemList = Designer.theDesigner().getToDoList()
                                      .getToDoItemList();
synchronized (itemList) //1
{ 
for (ToDoItem item : itemList) //1
{ 
if(item.getPriority() == pn.getPriority())//1
{ 
count++;
} 

} 

} 

return count;
} 

return 0;
} 

public void addTreeModelListener(TreeModelListener l) { 
} 

public Object getChild(Object parent, int index)
    { 
if(parent instanceof ToDoList)//1
{ 
return PriorityNode.getPriorityList().get(index);
} 

if(parent instanceof PriorityNode)//1
{ 
PriorityNode pn = (PriorityNode) parent;
List<ToDoItem> itemList =
                Designer.theDesigner().getToDoList().getToDoItemList();
synchronized (itemList) //1
{ 
for (ToDoItem item : itemList) //1
{ 
if(item.getPriority() == pn.getPriority())//1
{ 
if(index == 0)//1
{ 
return item;
} 

index--;
} 

} 

} 

} 

throw new IndexOutOfBoundsException("getChild shouldnt get here "
                                            + "GoListToPriorityToItem");
} 

public void valueForPathChanged(TreePath path, Object newValue) { 
} 

public boolean isLeaf(Object node)
    { 
if(node instanceof ToDoList)//1
{ 
return false;
} 

if(node instanceof PriorityNode && getChildCount(node) > 0)//1
{ 
return false;
} 

return true;
} 

public void removeTreeModelListener(TreeModelListener l) { 
} 

 } 

//#endif 


