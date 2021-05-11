package org.argouml.cognitive.ui;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreePath;
import org.argouml.cognitive.Designer;
import org.argouml.cognitive.ToDoItem;
import org.argouml.cognitive.ToDoList;
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
