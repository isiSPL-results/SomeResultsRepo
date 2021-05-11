// Compilation Unit of /GoListToTypeToItem.java 
 

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
import javax.swing.event.TreeModelListener;
//#endif 


//#if COGNITIVE 
import javax.swing.tree.TreePath;
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
public class GoListToTypeToItem extends AbstractGoList
  { 
public int getIndexOfChild(Object parent, Object child)
    { 
if(parent instanceof ToDoList)//1
{ 
return KnowledgeTypeNode.getTypeList().indexOf(child);
} 

if(parent instanceof KnowledgeTypeNode)//1
{ 
List<ToDoItem> candidates = new ArrayList<ToDoItem>();
KnowledgeTypeNode ktn = (KnowledgeTypeNode) parent;
List<ToDoItem> itemList =
                Designer.theDesigner().getToDoList().getToDoItemList();
synchronized (itemList) //1
{ 
for (ToDoItem item : itemList) //1
{ 
if(item.containsKnowledgeType(ktn.getName()))//1
{ 
candidates.add(item);
} 

} 

} 

return candidates.indexOf(child);
} 

return -1;
} 

public void valueForPathChanged(TreePath path, Object newValue) { 
} 

public Object getChild(Object parent, int index)
    { 
if(parent instanceof ToDoList)//1
{ 
return KnowledgeTypeNode.getTypeList().get(index);
} 

if(parent instanceof KnowledgeTypeNode)//1
{ 
KnowledgeTypeNode ktn = (KnowledgeTypeNode) parent;
List<ToDoItem> itemList =
                Designer.theDesigner().getToDoList().getToDoItemList();
synchronized (itemList) //1
{ 
for (ToDoItem item : itemList) //1
{ 
if(item.containsKnowledgeType(ktn.getName()))//1
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
                                            + "GoListToTypeToItem");
} 

public void removeTreeModelListener(TreeModelListener l) { 
} 

public void addTreeModelListener(TreeModelListener l) { 
} 

public int getChildCount(Object parent)
    { 
if(parent instanceof ToDoList)//1
{ 
return KnowledgeTypeNode.getTypeList().size();
} 

if(parent instanceof KnowledgeTypeNode)//1
{ 
KnowledgeTypeNode ktn = (KnowledgeTypeNode) parent;
int count = 0;
List<ToDoItem> itemList =
                Designer.theDesigner().getToDoList().getToDoItemList();
synchronized (itemList) //1
{ 
for (ToDoItem item : itemList) //1
{ 
if(item.containsKnowledgeType(ktn.getName()))//1
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

if(node instanceof KnowledgeTypeNode)//1
{ 
KnowledgeTypeNode ktn = (KnowledgeTypeNode) node;
List<ToDoItem> itemList = Designer.theDesigner().getToDoList()
                                      .getToDoItemList();
synchronized (itemList) //1
{ 
for (ToDoItem item : itemList) //1
{ 
if(item.containsKnowledgeType(ktn.getName()))//1
{ 
return false;
} 

} 

} 

} 

return true;
} 

 } 

//#endif 


