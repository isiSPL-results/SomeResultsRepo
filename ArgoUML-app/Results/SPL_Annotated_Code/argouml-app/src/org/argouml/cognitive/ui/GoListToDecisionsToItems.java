// Compilation Unit of /GoListToDecisionsToItems.java 
 

//#if COGNITIVE 
package org.argouml.cognitive.ui;
//#endif 


//#if COGNITIVE 
import java.util.ArrayList;
//#endif 


//#if COGNITIVE 
import java.util.List;
//#endif 


//#if COGNITIVE 
import java.util.Vector;
//#endif 


//#if COGNITIVE 
import javax.swing.event.TreeModelListener;
//#endif 


//#if COGNITIVE 
import javax.swing.tree.TreePath;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Decision;
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
public class GoListToDecisionsToItems extends AbstractGoList
  { 
public boolean isLeaf(Object node)
    { 
if(node instanceof ToDoList)//1
{ 
return false;
} 

if(node instanceof Decision && hasChildren(node))//1
{ 
return false;
} 

return true;
} 

public void valueForPathChanged(TreePath path, Object newValue) { 
} 

public void addTreeModelListener(TreeModelListener l) { 
} 

private boolean hasChildren(Object parent)
    { 
return getChildCountCond(parent, true) > 0;
} 

public int getChildCount(Object parent)
    { 
return getChildCountCond(parent, false);
} 

public List<Decision> getDecisionList()
    { 
return Designer.theDesigner().getDecisionModel().getDecisionList();
} 

public int getIndexOfChild(Object parent, Object child)
    { 
if(parent instanceof ToDoList)//1
{ 
return getDecisionList().indexOf(child);
} 

if(parent instanceof Decision)//1
{ 
List<ToDoItem> candidates = new ArrayList<ToDoItem>();
Decision dec = (Decision) parent;
List<ToDoItem> itemList =
                Designer.theDesigner().getToDoList().getToDoItemList();
synchronized (itemList) //1
{ 
for (ToDoItem item : itemList) //1
{ 
if(item.getPoster().supports(dec))//1
{ 
candidates.add(item);
} 

} 

} 

return candidates.indexOf(child);
} 

return -1;
} 

public Object getChild(Object parent, int index)
    { 
if(parent instanceof ToDoList)//1
{ 
return getDecisionList().get(index);
} 

if(parent instanceof Decision)//1
{ 
Decision dec = (Decision) parent;
List<ToDoItem> itemList =
                Designer.theDesigner().getToDoList().getToDoItemList();
synchronized (itemList) //1
{ 
for (ToDoItem item : itemList) //1
{ 
if(item.getPoster().supports(dec))//1
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

throw new IndexOutOfBoundsException("getChild shouldn't get here "
                                            + "GoListToDecisionsToItems");
} 

public void removeTreeModelListener(TreeModelListener l) { 
} 

private int getChildCountCond(Object parent, boolean stopafterone)
    { 
if(parent instanceof ToDoList)//1
{ 
return getDecisionList().size();
} 

if(parent instanceof Decision)//1
{ 
Decision dec = (Decision) parent;
int count = 0;
List<ToDoItem> itemList =
                Designer.theDesigner().getToDoList().getToDoItemList();
synchronized (itemList) //1
{ 
for (ToDoItem item : itemList) //1
{ 
if(item.getPoster().supports(dec))//1
{ 
count++;
} 

if(stopafterone && count > 0)//1
{ 
break;

} 

} 

} 

return count;
} 

return 0;
} 

 } 

//#endif 


