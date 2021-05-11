package org.argouml.cognitive.ui;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreePath;
import org.argouml.cognitive.Designer;
import org.argouml.cognitive.Goal;
import org.argouml.cognitive.ToDoItem;
import org.argouml.cognitive.ToDoList;
public class GoListToGoalsToItems extends AbstractGoList
  { 
public Object getChild(Object parent, int index)
    { 
if(parent instanceof ToDoList)//1
{ 
return getGoalList().get(index);
} 
if(parent instanceof Goal)//1
{ 
Goal g = (Goal) parent;
List<ToDoItem> itemList =
                Designer.theDesigner().getToDoList().getToDoItemList();
synchronized (itemList) //1
{ 
for (ToDoItem item : itemList) //1
{ 
if(item.getPoster().supports(g))//1
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
                                            + "GoListToGoalsToItems");
} 
public int getIndexOfChild(Object parent, Object child)
    { 
if(parent instanceof ToDoList)//1
{ 
return getGoalList().indexOf(child);
} 
if(parent instanceof Goal)//1
{ 
List<ToDoItem> candidates = new ArrayList<ToDoItem>();
Goal g = (Goal) parent;
List<ToDoItem> itemList =
                Designer.theDesigner().getToDoList().getToDoItemList();
synchronized (itemList) //1
{ 
for (ToDoItem item : itemList) //1
{ 
if(item.getPoster().supports(g))//1
{ 
candidates.add(item);
} 
} 
} 
return candidates.indexOf(child);
} 
return -1;
} 
public void addTreeModelListener(TreeModelListener l) { 
} 
public List<Goal> getGoalList()
    { 
return Designer.theDesigner().getGoalModel().getGoalList();
} 
public int getChildCount(Object parent)
    { 
if(parent instanceof ToDoList)//1
{ 
return getGoalList().size();
} 
if(parent instanceof Goal)//1
{ 
Goal g = (Goal) parent;
int count = 0;
List<ToDoItem> itemList =
                Designer.theDesigner().getToDoList().getToDoItemList();
synchronized (itemList) //1
{ 
for (ToDoItem item : itemList) //1
{ 
if(item.getPoster().supports(g))//1
{ 
count++;
} 
} 
} 
return count;
} 
return 0;
} 
public boolean isLeaf(Object node)
    { 
if(node instanceof ToDoList)//1
{ 
return false;
} 
if(node instanceof Goal && getChildCount(node) > 0)//1
{ 
return false;
} 
return true;
} 
public void removeTreeModelListener(TreeModelListener l) { 
} 
public void valueForPathChanged(TreePath path, Object newValue) { 
} 

 } 
