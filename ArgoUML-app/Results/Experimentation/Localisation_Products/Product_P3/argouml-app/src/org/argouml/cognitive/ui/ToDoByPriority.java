package org.argouml.cognitive.ui;
import java.util.List;
import org.argouml.cognitive.Designer;
import org.argouml.cognitive.ToDoItem;
import org.argouml.cognitive.ToDoListEvent;
import org.argouml.cognitive.ToDoListListener;
public class ToDoByPriority extends ToDoPerspective
 implements ToDoListListener
  { 
public ToDoByPriority()
    { 
super("combobox.todo-perspective-priority");
addSubTreeModel(new GoListToPriorityToItem());
} 
public void toDoItemsAdded(ToDoListEvent tde)
    { 
List<ToDoItem> items = tde.getToDoItemList();
Object[] path = new Object[2];
path[0] = Designer.theDesigner().getToDoList();
for (PriorityNode pn : PriorityNode.getPriorityList()) //1
{ 
path[1] = pn;
int nMatchingItems = 0;
synchronized (items) //1
{ 
for (ToDoItem item : items) //1
{ 
if(item.getPriority() != pn.getPriority())//1
{ 
continue;
} 
nMatchingItems++;
} 
} 
if(nMatchingItems == 0)//1
{ 
continue;
} 
int[] childIndices = new int[nMatchingItems];
Object[] children = new Object[nMatchingItems];
nMatchingItems = 0;
synchronized (items) //2
{ 
for (ToDoItem item : items) //1
{ 
if(item.getPriority() != pn.getPriority())//1
{ 
continue;
} 
childIndices[nMatchingItems] = getIndexOfChild(pn, item);
children[nMatchingItems] = item;
nMatchingItems++;
} 
} 
fireTreeNodesInserted(this, path, childIndices, children);
} 
} 
public void toDoItemsRemoved(ToDoListEvent tde)
    { 
List<ToDoItem> items = tde.getToDoItemList();
Object[] path = new Object[2];
path[0] = Designer.theDesigner().getToDoList();
for (PriorityNode pn : PriorityNode.getPriorityList()) //1
{ 
int nodePriority = pn.getPriority();
boolean anyInPri = false;
synchronized (items) //1
{ 
for (ToDoItem item : items) //1
{ 
int pri = item.getPriority();
if(pri == nodePriority)//1
{ 
anyInPri = true;
} 
} 
} 
if(!anyInPri)//1
{ 
continue;
} 
path[1] = pn;
fireTreeStructureChanged(path);
} 
} 
public void toDoListChanged(ToDoListEvent tde) { 
} 
public void toDoItemsChanged(ToDoListEvent tde)
    { 
List<ToDoItem> items = tde.getToDoItemList();
Object[] path = new Object[2];
path[0] = Designer.theDesigner().getToDoList();
for (PriorityNode pn : PriorityNode.getPriorityList()) //1
{ 
path[1] = pn;
int nMatchingItems = 0;
synchronized (items) //1
{ 
for (ToDoItem item : items) //1
{ 
if(item.getPriority() != pn.getPriority())//1
{ 
continue;
} 
nMatchingItems++;
} 
} 
if(nMatchingItems == 0)//1
{ 
continue;
} 
int[] childIndices = new int[nMatchingItems];
Object[] children = new Object[nMatchingItems];
nMatchingItems = 0;
synchronized (items) //2
{ 
for (ToDoItem item : items) //1
{ 
if(item.getPriority() != pn.getPriority())//1
{ 
continue;
} 
childIndices[nMatchingItems] = getIndexOfChild(pn, item);
children[nMatchingItems] = item;
nMatchingItems++;
} 
} 
fireTreeNodesChanged(this, path, childIndices, children);
} 
} 

 } 
