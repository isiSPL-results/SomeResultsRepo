
//#if -1638520793 
// Compilation Unit of /GoListToPosterToItem.java 
 

//#if 145109093 
package org.argouml.cognitive.ui;
//#endif 


//#if 1974815838 
import java.util.ArrayList;
//#endif 


//#if -1999652192 
import java.util.Collections;
//#endif 


//#if 322250563 
import java.util.List;
//#endif 


//#if 2072110450 
import javax.swing.event.TreeModelListener;
//#endif 


//#if 1858144554 
import javax.swing.tree.TreePath;
//#endif 


//#if -1120049275 
import org.argouml.cognitive.Designer;
//#endif 


//#if 2087167586 
import org.argouml.cognitive.ListSet;
//#endif 


//#if -228737373 
import org.argouml.cognitive.Poster;
//#endif 


//#if 1654932375 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 1657388908 
import org.argouml.cognitive.ToDoList;
//#endif 


//#if 1876863670 
public class GoListToPosterToItem extends 
//#if -1103839288 
AbstractGoList
//#endif 

  { 

//#if 2062679619 
public void valueForPathChanged(TreePath path, Object newValue)
    { 
} 

//#endif 


//#if 1688904783 
public void addTreeModelListener(TreeModelListener l)
    { 
} 

//#endif 


//#if -1542397561 
public boolean isLeaf(Object node)
    { 

//#if 1138492128 
if(node instanceof ToDoList)//1
{ 

//#if -1807532960 
return false;
//#endif 

} 

//#endif 


//#if -428232228 
if(getChildCount(node) > 0)//1
{ 

//#if -390568252 
return false;
//#endif 

} 

//#endif 


//#if 384172152 
return true;
//#endif 

} 

//#endif 


//#if 1312322884 
public List getChildrenList(Object parent)
    { 

//#if -1426114088 
ListSet allPosters =
            Designer.theDesigner().getToDoList().getPosters();
//#endif 


//#if 1846034348 
if(parent instanceof ToDoList)//1
{ 

//#if -1564659418 
return allPosters;
//#endif 

} 

//#endif 


//#if -1587410467 
if(allPosters.contains(parent))//1
{ 

//#if -613530345 
List<ToDoItem> result = new ArrayList<ToDoItem>();
//#endif 


//#if -2111512027 
List<ToDoItem> itemList =
                Designer.theDesigner().getToDoList().getToDoItemList();
//#endif 


//#if 1300289239 
synchronized (itemList) //1
{ 

//#if 2027206730 
for (ToDoItem item : itemList) //1
{ 

//#if 561585908 
Poster post = item.getPoster();
//#endif 


//#if -563700277 
if(post == parent)//1
{ 

//#if -1244566635 
result.add(item);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1756604280 
return result;
//#endif 

} 

//#endif 


//#if -1886195783 
return Collections.emptyList();
//#endif 

} 

//#endif 


//#if -499241550 
public void removeTreeModelListener(TreeModelListener l)
    { 
} 

//#endif 


//#if 1538490922 
public int getIndexOfChild(Object parent, Object child)
    { 

//#if 2012160374 
return getChildrenList(parent).indexOf(child);
//#endif 

} 

//#endif 


//#if 1976023517 
public Object getChild(Object parent, int index)
    { 

//#if -59535924 
return getChildrenList(parent).get(index);
//#endif 

} 

//#endif 


//#if 209277307 
public int getChildCount(Object parent)
    { 

//#if -213007363 
return getChildrenList(parent).size();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

