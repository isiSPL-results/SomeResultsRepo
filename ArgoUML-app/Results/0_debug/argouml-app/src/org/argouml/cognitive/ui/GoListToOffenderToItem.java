
//#if -247303817 
// Compilation Unit of /GoListToOffenderToItem.java 
 

//#if -500201152 
package org.argouml.cognitive.ui;
//#endif 


//#if -1543690887 
import java.util.ArrayList;
//#endif 


//#if 1149614331 
import java.util.Collections;
//#endif 


//#if -542455480 
import java.util.List;
//#endif 


//#if -1159583603 
import javax.swing.event.TreeModelListener;
//#endif 


//#if 1212834309 
import javax.swing.tree.TreePath;
//#endif 


//#if 293625738 
import org.argouml.cognitive.Designer;
//#endif 


//#if 1301486013 
import org.argouml.cognitive.ListSet;
//#endif 


//#if -1226359908 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if -1223903375 
import org.argouml.cognitive.ToDoList;
//#endif 


//#if 965843056 
import org.argouml.uml.PredicateNotInTrash;
//#endif 


//#if -91517209 
public class GoListToOffenderToItem extends 
//#if 214142725 
AbstractGoList2
//#endif 

  { 

//#if -2021576322 
private Object lastParent;
//#endif 


//#if 1193780983 
private List<ToDoItem> cachedChildrenList;
//#endif 


//#if -21867064 
public void valueForPathChanged(TreePath path, Object newValue)
    { 
} 

//#endif 


//#if -1268389640 
public Object getChild(Object parent, int index)
    { 

//#if 1342808009 
return getChildrenList(parent).get(index);
//#endif 

} 

//#endif 


//#if 1532112559 
public int getIndexOfChild(Object parent, Object child)
    { 

//#if 1296464341 
return getChildrenList(parent).indexOf(child);
//#endif 

} 

//#endif 


//#if 637575458 
public boolean isLeaf(Object node)
    { 

//#if 986361264 
if(node instanceof ToDoList)//1
{ 

//#if -777380352 
return false;
//#endif 

} 

//#endif 


//#if 2138974692 
List<ToDoItem> itemList =
            Designer.theDesigner().getToDoList().getToDoItemList();
//#endif 


//#if -1363732040 
synchronized (itemList) //1
{ 

//#if 858632865 
for (ToDoItem item : itemList) //1
{ 

//#if 1498885714 
if(item.getOffenders().contains(node))//1
{ 

//#if -700361850 
return false;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -145178808 
return true;
//#endif 

} 

//#endif 


//#if 1577589440 
public int getChildCount(Object parent)
    { 

//#if 1604534369 
return getChildrenList(parent).size();
//#endif 

} 

//#endif 


//#if 1682526420 
public void addTreeModelListener(TreeModelListener l)
    { 
} 

//#endif 


//#if -1538492659 
public void removeTreeModelListener(TreeModelListener l)
    { 
} 

//#endif 


//#if -440684650 
public List<ToDoItem> getChildrenList(Object parent)
    { 

//#if 1308223546 
if(parent.equals(lastParent))//1
{ 

//#if -245216302 
return cachedChildrenList;
//#endif 

} 

//#endif 


//#if 899284717 
lastParent = parent;
//#endif 


//#if 1161105149 
ListSet<ToDoItem> allOffenders = new ListSet<ToDoItem>();
//#endif 


//#if -691811023 
ListSet<ToDoItem> designerOffenders =
            Designer.theDesigner().getToDoList().getOffenders();
//#endif 


//#if -1927860420 
synchronized (designerOffenders) //1
{ 

//#if 1727312434 
allOffenders.addAllElementsSuchThat(designerOffenders,
                                                getPredicate());
//#endif 

} 

//#endif 


//#if 973989076 
if(parent instanceof ToDoList)//1
{ 

//#if 33812226 
cachedChildrenList = allOffenders;
//#endif 


//#if -1853235346 
return cachedChildrenList;
//#endif 

} 

//#endif 


//#if -562352031 
if(allOffenders.contains(parent))//1
{ 

//#if -1922506654 
List<ToDoItem> result = new ArrayList<ToDoItem>();
//#endif 


//#if 1227329904 
List<ToDoItem> itemList =
                Designer.theDesigner().getToDoList().getToDoItemList();
//#endif 


//#if 1809801900 
synchronized (itemList) //1
{ 

//#if 955118417 
for (ToDoItem item : itemList) //1
{ 

//#if -1756027875 
ListSet offs = new ListSet();
//#endif 


//#if -1408779747 
offs.addAllElementsSuchThat(item.getOffenders(),
                                                getPredicate());
//#endif 


//#if 1011048545 
if(offs.contains(parent))//1
{ 

//#if -2122152714 
result.add(item);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1071740801 
cachedChildrenList = result;
//#endif 


//#if -1458732245 
return cachedChildrenList;
//#endif 

} 

//#endif 


//#if 2101880941 
cachedChildrenList = Collections.emptyList();
//#endif 


//#if -52369613 
return cachedChildrenList;
//#endif 

} 

//#endif 


//#if -1552539593 
public GoListToOffenderToItem()
    { 

//#if 1080833472 
setListPredicate((org.argouml.util.Predicate) new PredicateNotInTrash());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

