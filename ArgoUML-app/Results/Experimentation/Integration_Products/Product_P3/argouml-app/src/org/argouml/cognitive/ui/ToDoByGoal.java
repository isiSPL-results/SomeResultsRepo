package org.argouml.cognitive.ui;
import org.argouml.cognitive.Designer;
import org.argouml.cognitive.Goal;
import org.argouml.cognitive.ToDoItem;
import org.argouml.cognitive.ToDoListEvent;
import org.argouml.cognitive.ToDoListListener;
public class ToDoByGoal extends ToDoPerspective
 implements ToDoListListener
  { 
public void toDoItemsChanged(ToDoListEvent tde)
    { 
Object[] path = new Object[2];
path[0] = Designer.theDesigner().getToDoList();
for (Goal g : Designer.theDesigner().getGoalList()) //1
{ 
path[1] = g;
int nMatchingItems = 0;
for (ToDoItem item : tde.getToDoItemList()) //1
{ 
if(!item.supports(g))//1
{ 
continue;
} 
nMatchingItems++;
} 
if(nMatchingItems == 0)//1
{ 
continue;
} 
int[] childIndices = new int[nMatchingItems];
Object[] children = new Object[nMatchingItems];
nMatchingItems = 0;
for (ToDoItem item : tde.getToDoItemList()) //2
{ 
if(!item.supports(g))//1
{ 
continue;
} 
childIndices[nMatchingItems] = getIndexOfChild(g, item);
children[nMatchingItems] = item;
nMatchingItems++;
} 
fireTreeNodesChanged(this, path, childIndices, children);
} 
} 
public void toDoItemsRemoved(ToDoListEvent tde)
    { 
Object[] path = new Object[2];
path[0] = Designer.theDesigner().getToDoList();
for (Goal g : Designer.theDesigner().getGoalList()) //1
{ 
boolean anyInGoal = false;
for (ToDoItem item : tde.getToDoItemList()) //1
{ 
if(item.supports(g))//1
{ 
anyInGoal = true;
} 
} 
if(!anyInGoal)//1
{ 
continue;
} 
path[1] = g;
fireTreeStructureChanged(path);
} 
} 
public void toDoItemsAdded(ToDoListEvent tde)
    { 
Object[] path = new Object[2];
path[0] = Designer.theDesigner().getToDoList();
for (Goal g : Designer.theDesigner().getGoalList()) //1
{ 
path[1] = g;
int nMatchingItems = 0;
for (ToDoItem item : tde.getToDoItemList()) //1
{ 
if(!item.supports(g))//1
{ 
continue;
} 
nMatchingItems++;
} 
if(nMatchingItems == 0)//1
{ 
continue;
} 
int[] childIndices = new int[nMatchingItems];
Object[] children = new Object[nMatchingItems];
nMatchingItems = 0;
for (ToDoItem item : tde.getToDoItemList()) //2
{ 
if(!item.supports(g))//1
{ 
continue;
} 
childIndices[nMatchingItems] = getIndexOfChild(g, item);
children[nMatchingItems] = item;
nMatchingItems++;
} 
fireTreeNodesInserted(this, path, childIndices, children);
} 
} 
public ToDoByGoal()
    { 
super("combobox.todo-perspective-goal");
addSubTreeModel(new GoListToGoalsToItems());
} 
public void toDoListChanged(ToDoListEvent tde) { 
} 

 } 
