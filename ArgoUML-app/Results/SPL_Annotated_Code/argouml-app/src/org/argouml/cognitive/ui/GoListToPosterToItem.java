// Compilation Unit of /GoListToPosterToItem.java 
 

//#if COGNITIVE 
package org.argouml.cognitive.ui;
//#endif 


//#if COGNITIVE 
import java.util.ArrayList;
//#endif 


//#if COGNITIVE 
import java.util.Collections;
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
import org.argouml.cognitive.ListSet;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Poster;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.ToDoList;
//#endif 


//#if COGNITIVE 
public class GoListToPosterToItem extends AbstractGoList
  { 
public void valueForPathChanged(TreePath path, Object newValue)
    { 
} 

public void addTreeModelListener(TreeModelListener l)
    { 
} 

public boolean isLeaf(Object node)
    { 
if(node instanceof ToDoList)//1
{ 
return false;
} 

if(getChildCount(node) > 0)//1
{ 
return false;
} 

return true;
} 

public List getChildrenList(Object parent)
    { 
ListSet allPosters =
            Designer.theDesigner().getToDoList().getPosters();
if(parent instanceof ToDoList)//1
{ 
return allPosters;
} 

if(allPosters.contains(parent))//1
{ 
List<ToDoItem> result = new ArrayList<ToDoItem>();
List<ToDoItem> itemList =
                Designer.theDesigner().getToDoList().getToDoItemList();
synchronized (itemList) //1
{ 
for (ToDoItem item : itemList) //1
{ 
Poster post = item.getPoster();
if(post == parent)//1
{ 
result.add(item);
} 

} 

} 

return result;
} 

return Collections.emptyList();
} 

public void removeTreeModelListener(TreeModelListener l)
    { 
} 

public int getIndexOfChild(Object parent, Object child)
    { 
return getChildrenList(parent).indexOf(child);
} 

public Object getChild(Object parent, int index)
    { 
return getChildrenList(parent).get(index);
} 

public int getChildCount(Object parent)
    { 
return getChildrenList(parent).size();
} 

 } 

//#endif 


