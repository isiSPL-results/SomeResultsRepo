// Compilation Unit of /ToDoByPriority.java 
 

//#if COGNITIVE 
package org.argouml.cognitive.ui;
//#endif 


//#if COGNITIVE 
import java.util.List;
//#endif 


//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
import org.apache.log4j.Logger;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Designer;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.ToDoListEvent;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.ToDoListListener;
//#endif 


//#if COGNITIVE 
public class ToDoByPriority extends ToDoPerspective
 implements ToDoListListener
  { 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
private static final Logger LOG =
        Logger.getLogger(ToDoByPriority.class);
//#endif 

public ToDoByPriority()
    { 
super("combobox.todo-perspective-priority");
addSubTreeModel(new GoListToPriorityToItem());
} 

public void toDoItemsAdded(ToDoListEvent tde)
    { 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.debug("toDoItemAdded");
//#endif 

List<ToDoItem> items = tde.getToDoItemList();
Object[] path = new Object[2];
path[0] = Designer.theDesigner().getToDoList();
for (PriorityNode pn : PriorityNode.getPriorityList()) //1
{ 
path[1] = pn;
int nMatchingItems = 0;
synchronized (items) //1
{ 
for (ToDoItem item : items) //1
{ 
if(item.getPriority() != pn.getPriority())//1
{ 
continue;
} 

nMatchingItems++;
} 

} 

if(nMatchingItems == 0)//1
{ 
continue;
} 

int[] childIndices = new int[nMatchingItems];
Object[] children = new Object[nMatchingItems];
nMatchingItems = 0;
synchronized (items) //2
{ 
for (ToDoItem item : items) //1
{ 
if(item.getPriority() != pn.getPriority())//1
{ 
continue;
} 

childIndices[nMatchingItems] = getIndexOfChild(pn, item);
children[nMatchingItems] = item;
nMatchingItems++;
} 

} 

fireTreeNodesInserted(this, path, childIndices, children);
} 

} 

public void toDoItemsRemoved(ToDoListEvent tde)
    { 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.debug("toDoItemRemoved");
//#endif 

List<ToDoItem> items = tde.getToDoItemList();
Object[] path = new Object[2];
path[0] = Designer.theDesigner().getToDoList();
for (PriorityNode pn : PriorityNode.getPriorityList()) //1
{ 
int nodePriority = pn.getPriority();
boolean anyInPri = false;
synchronized (items) //1
{ 
for (ToDoItem item : items) //1
{ 
int pri = item.getPriority();
if(pri == nodePriority)//1
{ 
anyInPri = true;
} 

} 

} 

if(!anyInPri)//1
{ 
continue;
} 


//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.debug("toDoItemRemoved updating PriorityNode");
//#endif 

path[1] = pn;
fireTreeStructureChanged(path);
} 

} 

public void toDoListChanged(ToDoListEvent tde) { 
} 

public void toDoItemsChanged(ToDoListEvent tde)
    { 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.debug("toDoItemChanged");
//#endif 

List<ToDoItem> items = tde.getToDoItemList();
Object[] path = new Object[2];
path[0] = Designer.theDesigner().getToDoList();
for (PriorityNode pn : PriorityNode.getPriorityList()) //1
{ 
path[1] = pn;
int nMatchingItems = 0;
synchronized (items) //1
{ 
for (ToDoItem item : items) //1
{ 
if(item.getPriority() != pn.getPriority())//1
{ 
continue;
} 

nMatchingItems++;
} 

} 

if(nMatchingItems == 0)//1
{ 
continue;
} 

int[] childIndices = new int[nMatchingItems];
Object[] children = new Object[nMatchingItems];
nMatchingItems = 0;
synchronized (items) //2
{ 
for (ToDoItem item : items) //1
{ 
if(item.getPriority() != pn.getPriority())//1
{ 
continue;
} 

childIndices[nMatchingItems] = getIndexOfChild(pn, item);
children[nMatchingItems] = item;
nMatchingItems++;
} 

} 

fireTreeNodesChanged(this, path, childIndices, children);
} 

} 

 } 

//#endif 


