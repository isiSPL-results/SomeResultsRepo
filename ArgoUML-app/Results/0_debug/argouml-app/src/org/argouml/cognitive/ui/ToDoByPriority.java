
//#if 1245811456 
// Compilation Unit of /ToDoByPriority.java 
 

//#if 1523398287 
package org.argouml.cognitive.ui;
//#endif 


//#if 468997977 
import java.util.List;
//#endif 


//#if 1511142789 
import org.apache.log4j.Logger;
//#endif 


//#if 808823707 
import org.argouml.cognitive.Designer;
//#endif 


//#if -711161939 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if -2019770854 
import org.argouml.cognitive.ToDoListEvent;
//#endif 


//#if 249019950 
import org.argouml.cognitive.ToDoListListener;
//#endif 


//#if -1175918031 
public class ToDoByPriority extends 
//#if 1850607581 
ToDoPerspective
//#endif 

 implements 
//#if 1812414961 
ToDoListListener
//#endif 

  { 

//#if 167334070 
private static final Logger LOG =
        Logger.getLogger(ToDoByPriority.class);
//#endif 


//#if 1633004932 
public ToDoByPriority()
    { 

//#if -1471742790 
super("combobox.todo-perspective-priority");
//#endif 


//#if -2078015100 
addSubTreeModel(new GoListToPriorityToItem());
//#endif 

} 

//#endif 


//#if 542253342 
public void toDoItemsAdded(ToDoListEvent tde)
    { 

//#if -1879360966 
LOG.debug("toDoItemAdded");
//#endif 


//#if 183038144 
List<ToDoItem> items = tde.getToDoItemList();
//#endif 


//#if -368891565 
Object[] path = new Object[2];
//#endif 


//#if -490827612 
path[0] = Designer.theDesigner().getToDoList();
//#endif 


//#if 1374481786 
for (PriorityNode pn : PriorityNode.getPriorityList()) //1
{ 

//#if 1743048036 
path[1] = pn;
//#endif 


//#if 551422210 
int nMatchingItems = 0;
//#endif 


//#if -1268676398 
synchronized (items) //1
{ 

//#if -299316031 
for (ToDoItem item : items) //1
{ 

//#if 1001890611 
if(item.getPriority() != pn.getPriority())//1
{ 

//#if -848833344 
continue;
//#endif 

} 

//#endif 


//#if -1774382689 
nMatchingItems++;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -717955626 
if(nMatchingItems == 0)//1
{ 

//#if -884557997 
continue;
//#endif 

} 

//#endif 


//#if 1992314592 
int[] childIndices = new int[nMatchingItems];
//#endif 


//#if 764133262 
Object[] children = new Object[nMatchingItems];
//#endif 


//#if -1231950443 
nMatchingItems = 0;
//#endif 


//#if 573708447 
synchronized (items) //2
{ 

//#if 196812294 
for (ToDoItem item : items) //1
{ 

//#if -267486139 
if(item.getPriority() != pn.getPriority())//1
{ 

//#if -1138062027 
continue;
//#endif 

} 

//#endif 


//#if 928373348 
childIndices[nMatchingItems] = getIndexOfChild(pn, item);
//#endif 


//#if -1147559636 
children[nMatchingItems] = item;
//#endif 


//#if 1415585073 
nMatchingItems++;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1098680744 
fireTreeNodesInserted(this, path, childIndices, children);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1484062338 
public void toDoItemsRemoved(ToDoListEvent tde)
    { 

//#if -822497129 
LOG.debug("toDoItemRemoved");
//#endif 


//#if -1355583325 
List<ToDoItem> items = tde.getToDoItemList();
//#endif 


//#if 865586998 
Object[] path = new Object[2];
//#endif 


//#if -1672027679 
path[0] = Designer.theDesigner().getToDoList();
//#endif 


//#if -286084681 
for (PriorityNode pn : PriorityNode.getPriorityList()) //1
{ 

//#if 724411610 
int nodePriority = pn.getPriority();
//#endif 


//#if -722125051 
boolean anyInPri = false;
//#endif 


//#if 723943906 
synchronized (items) //1
{ 

//#if -101654443 
for (ToDoItem item : items) //1
{ 

//#if -2038462019 
int pri = item.getPriority();
//#endif 


//#if 499227985 
if(pri == nodePriority)//1
{ 

//#if 2097595050 
anyInPri = true;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1045653694 
if(!anyInPri)//1
{ 

//#if -2118668461 
continue;
//#endif 

} 

//#endif 


//#if 901351126 
LOG.debug("toDoItemRemoved updating PriorityNode");
//#endif 


//#if 142663252 
path[1] = pn;
//#endif 


//#if 67671004 
fireTreeStructureChanged(path);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1647475964 
public void toDoListChanged(ToDoListEvent tde) { 
} 

//#endif 


//#if 518774482 
public void toDoItemsChanged(ToDoListEvent tde)
    { 

//#if 388701358 
LOG.debug("toDoItemChanged");
//#endif 


//#if 733904792 
List<ToDoItem> items = tde.getToDoItemList();
//#endif 


//#if 331442219 
Object[] path = new Object[2];
//#endif 


//#if -692555060 
path[0] = Designer.theDesigner().getToDoList();
//#endif 


//#if -778688606 
for (PriorityNode pn : PriorityNode.getPriorityList()) //1
{ 

//#if 148625290 
path[1] = pn;
//#endif 


//#if -954660452 
int nMatchingItems = 0;
//#endif 


//#if -1210135828 
synchronized (items) //1
{ 

//#if -1028861014 
for (ToDoItem item : items) //1
{ 

//#if 907273764 
if(item.getPriority() != pn.getPriority())//1
{ 

//#if 1506223804 
continue;
//#endif 

} 

//#endif 


//#if 923443152 
nMatchingItems++;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -295042704 
if(nMatchingItems == 0)//1
{ 

//#if 1415914099 
continue;
//#endif 

} 

//#endif 


//#if 2144834182 
int[] childIndices = new int[nMatchingItems];
//#endif 


//#if 1306571188 
Object[] children = new Object[nMatchingItems];
//#endif 


//#if 1522942779 
nMatchingItems = 0;
//#endif 


//#if 799107141 
synchronized (items) //2
{ 

//#if 95549487 
for (ToDoItem item : items) //1
{ 

//#if -1757979194 
if(item.getPriority() != pn.getPriority())//1
{ 

//#if -479980218 
continue;
//#endif 

} 

//#endif 


//#if 168472131 
childIndices[nMatchingItems] = getIndexOfChild(pn, item);
//#endif 


//#if -2122620405 
children[nMatchingItems] = item;
//#endif 


//#if 1559977458 
nMatchingItems++;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1576419392 
fireTreeNodesChanged(this, path, childIndices, children);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

