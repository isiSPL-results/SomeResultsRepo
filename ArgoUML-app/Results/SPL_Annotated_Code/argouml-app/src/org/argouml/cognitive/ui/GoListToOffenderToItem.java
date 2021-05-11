// Compilation Unit of /GoListToOffenderToItem.java 
 

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
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.ToDoList;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.PredicateNotInTrash;
//#endif 


//#if COGNITIVE 
public class GoListToOffenderToItem extends AbstractGoList2
  { 
private Object lastParent;
private List<ToDoItem> cachedChildrenList;
public void valueForPathChanged(TreePath path, Object newValue)
    { 
} 

public Object getChild(Object parent, int index)
    { 
return getChildrenList(parent).get(index);
} 

public int getIndexOfChild(Object parent, Object child)
    { 
return getChildrenList(parent).indexOf(child);
} 

public boolean isLeaf(Object node)
    { 
if(node instanceof ToDoList)//1
{ 
return false;
} 

List<ToDoItem> itemList =
            Designer.theDesigner().getToDoList().getToDoItemList();
synchronized (itemList) //1
{ 
for (ToDoItem item : itemList) //1
{ 
if(item.getOffenders().contains(node))//1
{ 
return false;
} 

} 

} 

return true;
} 

public int getChildCount(Object parent)
    { 
return getChildrenList(parent).size();
} 

public void addTreeModelListener(TreeModelListener l)
    { 
} 

public void removeTreeModelListener(TreeModelListener l)
    { 
} 

public List<ToDoItem> getChildrenList(Object parent)
    { 
if(parent.equals(lastParent))//1
{ 
return cachedChildrenList;
} 

lastParent = parent;
ListSet<ToDoItem> allOffenders = new ListSet<ToDoItem>();
ListSet<ToDoItem> designerOffenders =
            Designer.theDesigner().getToDoList().getOffenders();
synchronized (designerOffenders) //1
{ 
allOffenders.addAllElementsSuchThat(designerOffenders,
                                                getPredicate());
} 

if(parent instanceof ToDoList)//1
{ 
cachedChildrenList = allOffenders;
return cachedChildrenList;
} 

if(allOffenders.contains(parent))//1
{ 
List<ToDoItem> result = new ArrayList<ToDoItem>();
List<ToDoItem> itemList =
                Designer.theDesigner().getToDoList().getToDoItemList();
synchronized (itemList) //1
{ 
for (ToDoItem item : itemList) //1
{ 
ListSet offs = new ListSet();
offs.addAllElementsSuchThat(item.getOffenders(),
                                                getPredicate());
if(offs.contains(parent))//1
{ 
result.add(item);
} 

} 

} 

cachedChildrenList = result;
return cachedChildrenList;
} 

cachedChildrenList = Collections.emptyList();
return cachedChildrenList;
} 

public GoListToOffenderToItem()
    { 
setListPredicate((org.argouml.util.Predicate) new PredicateNotInTrash());
} 

 } 

//#endif 


