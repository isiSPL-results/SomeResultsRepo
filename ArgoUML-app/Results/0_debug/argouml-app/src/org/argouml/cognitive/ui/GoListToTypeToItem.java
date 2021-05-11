
//#if 422466374 
// Compilation Unit of /GoListToTypeToItem.java 
 

//#if 979350400 
package org.argouml.cognitive.ui;
//#endif 


//#if 1160380345 
import java.util.ArrayList;
//#endif 


//#if 1005487880 
import java.util.List;
//#endif 


//#if 1435665101 
import javax.swing.event.TreeModelListener;
//#endif 


//#if -1602581435 
import javax.swing.tree.TreePath;
//#endif 


//#if 1880137034 
import org.argouml.cognitive.Designer;
//#endif 


//#if 360151388 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 362607921 
import org.argouml.cognitive.ToDoList;
//#endif 


//#if -1434575768 
public class GoListToTypeToItem extends 
//#if 2088698751 
AbstractGoList
//#endif 

  { 

//#if 911242849 
public int getIndexOfChild(Object parent, Object child)
    { 

//#if 1390508744 
if(parent instanceof ToDoList)//1
{ 

//#if -723589068 
return KnowledgeTypeNode.getTypeList().indexOf(child);
//#endif 

} 

//#endif 


//#if 1322275302 
if(parent instanceof KnowledgeTypeNode)//1
{ 

//#if 1565639506 
List<ToDoItem> candidates = new ArrayList<ToDoItem>();
//#endif 


//#if -760043410 
KnowledgeTypeNode ktn = (KnowledgeTypeNode) parent;
//#endif 


//#if -1929887379 
List<ToDoItem> itemList =
                Designer.theDesigner().getToDoList().getToDoItemList();
//#endif 


//#if -484681073 
synchronized (itemList) //1
{ 

//#if -1160306988 
for (ToDoItem item : itemList) //1
{ 

//#if -2104442708 
if(item.containsKnowledgeType(ktn.getName()))//1
{ 

//#if 1844804385 
candidates.add(item);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -995278817 
return candidates.indexOf(child);
//#endif 

} 

//#endif 


//#if 2051004066 
return -1;
//#endif 

} 

//#endif 


//#if 235850618 
public void valueForPathChanged(TreePath path, Object newValue) { 
} 

//#endif 


//#if -1072233082 
public Object getChild(Object parent, int index)
    { 

//#if -601929491 
if(parent instanceof ToDoList)//1
{ 

//#if 1754993988 
return KnowledgeTypeNode.getTypeList().get(index);
//#endif 

} 

//#endif 


//#if 1104649569 
if(parent instanceof KnowledgeTypeNode)//1
{ 

//#if -423696416 
KnowledgeTypeNode ktn = (KnowledgeTypeNode) parent;
//#endif 


//#if 2090898363 
List<ToDoItem> itemList =
                Designer.theDesigner().getToDoList().getToDoItemList();
//#endif 


//#if 361610113 
synchronized (itemList) //1
{ 

//#if 1407799569 
for (ToDoItem item : itemList) //1
{ 

//#if 1800245267 
if(item.containsKnowledgeType(ktn.getName()))//1
{ 

//#if 224103575 
if(index == 0)//1
{ 

//#if 1559039634 
return item;
//#endif 

} 

//#endif 


//#if 1033218531 
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


//#if 1321643378 
throw new IndexOutOfBoundsException("getChild shouldnt get here "
                                            + "GoListToTypeToItem");
//#endif 

} 

//#endif 


//#if 556120603 
public void removeTreeModelListener(TreeModelListener l) { 
} 

//#endif 


//#if 1061656710 
public void addTreeModelListener(TreeModelListener l) { 
} 

//#endif 


//#if -1680612878 
public int getChildCount(Object parent)
    { 

//#if 931668194 
if(parent instanceof ToDoList)//1
{ 

//#if 295374025 
return KnowledgeTypeNode.getTypeList().size();
//#endif 

} 

//#endif 


//#if -1279661812 
if(parent instanceof KnowledgeTypeNode)//1
{ 

//#if 330534952 
KnowledgeTypeNode ktn = (KnowledgeTypeNode) parent;
//#endif 


//#if -732448668 
int count = 0;
//#endif 


//#if -1465326989 
List<ToDoItem> itemList =
                Designer.theDesigner().getToDoList().getToDoItemList();
//#endif 


//#if -433206839 
synchronized (itemList) //1
{ 

//#if 1243887266 
for (ToDoItem item : itemList) //1
{ 

//#if -1841844604 
if(item.containsKnowledgeType(ktn.getName()))//1
{ 

//#if -1050858154 
count++;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -552980000 
return count;
//#endif 

} 

//#endif 


//#if -668471226 
return 0;
//#endif 

} 

//#endif 


//#if -1250057552 
public boolean isLeaf(Object node)
    { 

//#if -1489176585 
if(node instanceof ToDoList)//1
{ 

//#if 1203167019 
return false;
//#endif 

} 

//#endif 


//#if 1720531351 
if(node instanceof KnowledgeTypeNode)//1
{ 

//#if 645070258 
KnowledgeTypeNode ktn = (KnowledgeTypeNode) node;
//#endif 


//#if 2098999441 
List<ToDoItem> itemList = Designer.theDesigner().getToDoList()
                                      .getToDoItemList();
//#endif 


//#if 1547250923 
synchronized (itemList) //1
{ 

//#if -105014105 
for (ToDoItem item : itemList) //1
{ 

//#if 1682189101 
if(item.containsKnowledgeType(ktn.getName()))//1
{ 

//#if 572472189 
return false;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -403841713 
return true;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

