
//#if -579127922 
// Compilation Unit of /GoListToGoalsToItems.java 
 

//#if -2083196291 
package org.argouml.cognitive.ui;
//#endif 


//#if -1555726218 
import java.util.ArrayList;
//#endif 


//#if -2035629013 
import java.util.List;
//#endif 


//#if -1709774454 
import javax.swing.event.TreeModelListener;
//#endif 


//#if -370160830 
import javax.swing.tree.TreePath;
//#endif 


//#if 1139553389 
import org.argouml.cognitive.Designer;
//#endif 


//#if 563050437 
import org.argouml.cognitive.Goal;
//#endif 


//#if -380432257 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if -377975724 
import org.argouml.cognitive.ToDoList;
//#endif 


//#if -1273283608 
public class GoListToGoalsToItems extends 
//#if -383398109 
AbstractGoList
//#endif 

  { 

//#if 2011565154 
public Object getChild(Object parent, int index)
    { 

//#if 184403942 
if(parent instanceof ToDoList)//1
{ 

//#if 712124151 
return getGoalList().get(index);
//#endif 

} 

//#endif 


//#if -377586091 
if(parent instanceof Goal)//1
{ 

//#if 832530081 
Goal g = (Goal) parent;
//#endif 


//#if -469675736 
List<ToDoItem> itemList =
                Designer.theDesigner().getToDoList().getToDoItemList();
//#endif 


//#if 1644519412 
synchronized (itemList) //1
{ 

//#if 958225574 
for (ToDoItem item : itemList) //1
{ 

//#if 284614342 
if(item.getPoster().supports(g))//1
{ 

//#if 913112842 
if(index == 0)//1
{ 

//#if -517201353 
return item;
//#endif 

} 

//#endif 


//#if -2098216240 
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


//#if -1048253604 
throw new IndexOutOfBoundsException("getChild shouldnt get here "
                                            + "GoListToGoalsToItems");
//#endif 

} 

//#endif 


//#if 1949384709 
public int getIndexOfChild(Object parent, Object child)
    { 

//#if -871733695 
if(parent instanceof ToDoList)//1
{ 

//#if -925658411 
return getGoalList().indexOf(child);
//#endif 

} 

//#endif 


//#if -1875475920 
if(parent instanceof Goal)//1
{ 

//#if 1708444592 
List<ToDoItem> candidates = new ArrayList<ToDoItem>();
//#endif 


//#if 167066846 
Goal g = (Goal) parent;
//#endif 


//#if 762654923 
List<ToDoItem> itemList =
                Designer.theDesigner().getToDoList().getToDoItemList();
//#endif 


//#if -151071631 
synchronized (itemList) //1
{ 

//#if 237327981 
for (ToDoItem item : itemList) //1
{ 

//#if -759760434 
if(item.getPoster().supports(g))//1
{ 

//#if -649483294 
candidates.add(item);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 294274045 
return candidates.indexOf(child);
//#endif 

} 

//#endif 


//#if 2059313883 
return -1;
//#endif 

} 

//#endif 


//#if 2099798570 
public void addTreeModelListener(TreeModelListener l) { 
} 

//#endif 


//#if 1451644087 
public List<Goal> getGoalList()
    { 

//#if -632616746 
return Designer.theDesigner().getGoalModel().getGoalList();
//#endif 

} 

//#endif 


//#if 1145477782 
public int getChildCount(Object parent)
    { 

//#if -1808747004 
if(parent instanceof ToDoList)//1
{ 

//#if -1713776296 
return getGoalList().size();
//#endif 

} 

//#endif 


//#if 1344875379 
if(parent instanceof Goal)//1
{ 

//#if 850752645 
Goal g = (Goal) parent;
//#endif 


//#if -973023309 
int count = 0;
//#endif 


//#if 1239434436 
List<ToDoItem> itemList =
                Designer.theDesigner().getToDoList().getToDoItemList();
//#endif 


//#if -2002095400 
synchronized (itemList) //1
{ 

//#if -781019089 
for (ToDoItem item : itemList) //1
{ 

//#if 166916438 
if(item.getPoster().supports(g))//1
{ 

//#if 415345416 
count++;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 579140721 
return count;
//#endif 

} 

//#endif 


//#if 1144256868 
return 0;
//#endif 

} 

//#endif 


//#if 89854860 
public boolean isLeaf(Object node)
    { 

//#if -954389859 
if(node instanceof ToDoList)//1
{ 

//#if 1447102163 
return false;
//#endif 

} 

//#endif 


//#if -595854402 
if(node instanceof Goal && getChildCount(node) > 0)//1
{ 

//#if -1736981364 
return false;
//#endif 

} 

//#endif 


//#if -1550873227 
return true;
//#endif 

} 

//#endif 


//#if -219226633 
public void removeTreeModelListener(TreeModelListener l) { 
} 

//#endif 


//#if 586002718 
public void valueForPathChanged(TreePath path, Object newValue) { 
} 

//#endif 

 } 

//#endif 


//#endif 

