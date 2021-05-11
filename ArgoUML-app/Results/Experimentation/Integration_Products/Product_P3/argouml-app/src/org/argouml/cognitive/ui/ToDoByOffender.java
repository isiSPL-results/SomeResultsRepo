package org.argouml.cognitive.ui;
import java.util.List;
import org.argouml.cognitive.Designer;
import org.argouml.cognitive.ListSet;
import org.argouml.cognitive.ToDoItem;
import org.argouml.cognitive.ToDoListEvent;
import org.argouml.cognitive.ToDoListListener;
public class ToDoByOffender extends ToDoPerspective
 implements ToDoListListener
  { 
public ToDoByOffender()
    { 
super("combobox.todo-perspective-offender");
addSubTreeModel(new GoListToOffenderToItem());
} 
public void toDoItemsRemoved(ToDoListEvent tde)
    { 
List<ToDoItem> items = tde.getToDoItemList();
Object[] path = new Object[2];
path[0] = Designer.theDesigner().getToDoList();
ListSet allOffenders = Designer.theDesigner().getToDoList()
                               .getOffenders();
synchronized (allOffenders) //1
{ 
for (Object off : allOffenders) //1
{ 
boolean anyInOff = false;
synchronized (items) //1
{ 
for (ToDoItem item : items) //1
{ 
ListSet offenders = item.getOffenders();
if(offenders.contains(off))//1
{ 
anyInOff = true;
break;

} 
} 
} 
if(!anyInOff)//1
{ 
continue;
} 
path[1] = off;
fireTreeStructureChanged(path);
} 
} 
} 
public void toDoItemsChanged(ToDoListEvent tde)
    { 
List<ToDoItem> items = tde.getToDoItemList();
Object[] path = new Object[2];
path[0] = Designer.theDesigner().getToDoList();
ListSet allOffenders = Designer.theDesigner().getToDoList()
                               .getOffenders();
synchronized (allOffenders) //1
{ 
for (Object off : allOffenders) //1
{ 
path[1] = off;
int nMatchingItems = 0;
synchronized (items) //1
{ 
for (ToDoItem item : items) //1
{ 
ListSet offenders = item.getOffenders();
if(!offenders.contains(off))//1
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
ListSet offenders = item.getOffenders();
if(!offenders.contains(off))//1
{ 
continue;
} 
childIndices[nMatchingItems] = getIndexOfChild(off,
                                                       item);
children[nMatchingItems] = item;
nMatchingItems++;
} 
} 
fireTreeNodesChanged(this, path, childIndices, children);
} 
} 
} 
public void toDoItemsAdded(ToDoListEvent tde)
    { 
List<ToDoItem> items = tde.getToDoItemList();
Object[] path = new Object[2];
path[0] = Designer.theDesigner().getToDoList();
ListSet allOffenders = Designer.theDesigner().getToDoList()
                               .getOffenders();
synchronized (allOffenders) //1
{ 
for (Object off : allOffenders) //1
{ 
path[1] = off;
int nMatchingItems = 0;
synchronized (items) //1
{ 
for (ToDoItem item : items) //1
{ 
ListSet offenders = item.getOffenders();
if(!offenders.contains(off))//1
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
ListSet offenders = item.getOffenders();
if(!offenders.contains(off))//1
{ 
continue;
} 
childIndices[nMatchingItems] = getIndexOfChild(off,
                                                       item);
children[nMatchingItems] = item;
nMatchingItems++;
} 
} 
fireTreeNodesInserted(this, path, childIndices, children);
} 
} 
} 
public void toDoListChanged(ToDoListEvent tde)
    { 
} 

 } 
