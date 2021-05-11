
//#if -1370838270 
// Compilation Unit of /ToDoByType.java 
 

//#if 1523362342 
package org.argouml.cognitive.ui;
//#endif 


//#if -348570590 
import java.util.List;
//#endif 


//#if -1380474148 
import org.apache.log4j.Logger;
//#endif 


//#if -1768825244 
import org.argouml.cognitive.Designer;
//#endif 


//#if 1006156406 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 1678631153 
import org.argouml.cognitive.ToDoListEvent;
//#endif 


//#if 547166199 
import org.argouml.cognitive.ToDoListListener;
//#endif 


//#if -627297520 
public class ToDoByType extends 
//#if 1279771173 
ToDoPerspective
//#endif 

 implements 
//#if 1296355497 
ToDoListListener
//#endif 

  { 

//#if 1942164884 
private static final Logger LOG =
        Logger.getLogger(ToDoByType.class);
//#endif 


//#if -187389558 
public void toDoItemsChanged(ToDoListEvent tde)
    { 

//#if 1796690475 
LOG.debug("toDoItemsChanged");
//#endif 


//#if 2001729406 
List<ToDoItem> items = tde.getToDoItemList();
//#endif 


//#if -585405423 
Object[] path = new Object[2];
//#endif 


//#if -871880410 
path[0] = Designer.theDesigner().getToDoList();
//#endif 


//#if -963709433 
for (KnowledgeTypeNode ktn : KnowledgeTypeNode.getTypeList()) //1
{ 

//#if 592039241 
String kt = ktn.getName();
//#endif 


//#if 1795174989 
path[1] = ktn;
//#endif 


//#if -537622752 
int nMatchingItems = 0;
//#endif 


//#if 528195861 
for (ToDoItem item : items) //1
{ 

//#if 928721362 
if(!item.containsKnowledgeType(kt))//1
{ 

//#if -122909850 
continue;
//#endif 

} 

//#endif 


//#if 1589843496 
nMatchingItems++;
//#endif 

} 

//#endif 


//#if 176364788 
if(nMatchingItems == 0)//1
{ 

//#if -834669792 
continue;
//#endif 

} 

//#endif 


//#if -1225756798 
int[] childIndices = new int[nMatchingItems];
//#endif 


//#if 573980592 
Object[] children = new Object[nMatchingItems];
//#endif 


//#if -1803332553 
nMatchingItems = 0;
//#endif 


//#if -1277201028 
for (ToDoItem item : items) //2
{ 

//#if 1077688779 
if(!item.containsKnowledgeType(kt))//1
{ 

//#if 692897805 
continue;
//#endif 

} 

//#endif 


//#if 109641337 
childIndices[nMatchingItems] = getIndexOfChild(ktn, item);
//#endif 


//#if 1236290190 
children[nMatchingItems] = item;
//#endif 


//#if 646438031 
nMatchingItems++;
//#endif 

} 

//#endif 


//#if 1567972548 
fireTreeNodesChanged(this, path, childIndices, children);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2104740918 
public void toDoItemsRemoved(ToDoListEvent tde)
    { 

//#if 572554610 
LOG.debug("toDoItemRemoved");
//#endif 


//#if 523476904 
List<ToDoItem> items = tde.getToDoItemList();
//#endif 


//#if 320383035 
Object[] path = new Object[2];
//#endif 


//#if 1102485692 
path[0] = Designer.theDesigner().getToDoList();
//#endif 


//#if -372463695 
for (KnowledgeTypeNode ktn : KnowledgeTypeNode.getTypeList()) //1
{ 

//#if 1918152556 
boolean anyInKT = false;
//#endif 


//#if 670912174 
String kt = ktn.getName();
//#endif 


//#if 884631952 
for (ToDoItem item : items) //1
{ 

//#if 1189982396 
if(item.containsKnowledgeType(kt))//1
{ 

//#if -1146255719 
anyInKT = true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1493300747 
if(!anyInKT)//1
{ 

//#if -2117047764 
continue;
//#endif 

} 

//#endif 


//#if 209708461 
LOG.debug("toDoItemRemoved updating PriorityNode");
//#endif 


//#if -1110467064 
path[1] = ktn;
//#endif 


//#if 1957743219 
fireTreeStructureChanged(path);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -567394862 
public ToDoByType()
    { 

//#if -1940460697 
super("combobox.todo-perspective-type");
//#endif 


//#if 613792887 
addSubTreeModel(new GoListToTypeToItem());
//#endif 

} 

//#endif 


//#if -1423344828 
public void toDoListChanged(ToDoListEvent tde) { 
} 

//#endif 


//#if -388089386 
public void toDoItemsAdded(ToDoListEvent tde)
    { 

//#if 580632230 
LOG.debug("toDoItemAdded");
//#endif 


//#if 1144620756 
List<ToDoItem> items = tde.getToDoItemList();
//#endif 


//#if 541747047 
Object[] path = new Object[2];
//#endif 


//#if -1415097840 
path[0] = Designer.theDesigner().getToDoList();
//#endif 


//#if -821060643 
for (KnowledgeTypeNode ktn : KnowledgeTypeNode.getTypeList()) //1
{ 

//#if -1713817895 
String kt = ktn.getName();
//#endif 


//#if 1911759549 
path[1] = ktn;
//#endif 


//#if -622327920 
int nMatchingItems = 0;
//#endif 


//#if 445189509 
for (ToDoItem item : items) //1
{ 

//#if 461487573 
if(!item.containsKnowledgeType(kt))//1
{ 

//#if -710168679 
continue;
//#endif 

} 

//#endif 


//#if 1516021317 
nMatchingItems++;
//#endif 

} 

//#endif 


//#if 1709237604 
if(nMatchingItems == 0)//1
{ 

//#if 1717908892 
continue;
//#endif 

} 

//#endif 


//#if -642869998 
int[] childIndices = new int[nMatchingItems];
//#endif 


//#if -1912520384 
Object[] children = new Object[nMatchingItems];
//#endif 


//#if 1594173895 
nMatchingItems = 0;
//#endif 


//#if -218270964 
for (ToDoItem item : items) //2
{ 

//#if -1789955866 
if(!item.containsKnowledgeType(kt))//1
{ 

//#if -1734203938 
continue;
//#endif 

} 

//#endif 


//#if 751665342 
childIndices[nMatchingItems] = getIndexOfChild(ktn, item);
//#endif 


//#if 137219241 
children[nMatchingItems] = item;
//#endif 


//#if -2133194092 
nMatchingItems++;
//#endif 

} 

//#endif 


//#if 2010320986 
fireTreeNodesInserted(this, path, childIndices, children);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

