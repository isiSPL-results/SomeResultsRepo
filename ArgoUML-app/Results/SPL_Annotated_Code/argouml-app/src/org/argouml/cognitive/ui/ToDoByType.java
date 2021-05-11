// Compilation Unit of /ToDoByType.java 
 

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
public class ToDoByType extends ToDoPerspective
 implements ToDoListListener
  { 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
private static final Logger LOG =
        Logger.getLogger(ToDoByType.class);
//#endif 

public void toDoItemsChanged(ToDoListEvent tde)
    { 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.debug("toDoItemsChanged");
//#endif 

List<ToDoItem> items = tde.getToDoItemList();
Object[] path = new Object[2];
path[0] = Designer.theDesigner().getToDoList();
for (KnowledgeTypeNode ktn : KnowledgeTypeNode.getTypeList()) //1
{ 
String kt = ktn.getName();
path[1] = ktn;
int nMatchingItems = 0;
for (ToDoItem item : items) //1
{ 
if(!item.containsKnowledgeType(kt))//1
{ 
continue;
} 

nMatchingItems++;
} 

if(nMatchingItems == 0)//1
{ 
continue;
} 

int[] childIndices = new int[nMatchingItems];
Object[] children = new Object[nMatchingItems];
nMatchingItems = 0;
for (ToDoItem item : items) //2
{ 
if(!item.containsKnowledgeType(kt))//1
{ 
continue;
} 

childIndices[nMatchingItems] = getIndexOfChild(ktn, item);
children[nMatchingItems] = item;
nMatchingItems++;
} 

fireTreeNodesChanged(this, path, childIndices, children);
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
for (KnowledgeTypeNode ktn : KnowledgeTypeNode.getTypeList()) //1
{ 
boolean anyInKT = false;
String kt = ktn.getName();
for (ToDoItem item : items) //1
{ 
if(item.containsKnowledgeType(kt))//1
{ 
anyInKT = true;
} 

} 

if(!anyInKT)//1
{ 
continue;
} 


//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.debug("toDoItemRemoved updating PriorityNode");
//#endif 

path[1] = ktn;
fireTreeStructureChanged(path);
} 

} 

public ToDoByType()
    { 
super("combobox.todo-perspective-type");
addSubTreeModel(new GoListToTypeToItem());
} 

public void toDoListChanged(ToDoListEvent tde) { 
} 

public void toDoItemsAdded(ToDoListEvent tde)
    { 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.debug("toDoItemAdded");
//#endif 

List<ToDoItem> items = tde.getToDoItemList();
Object[] path = new Object[2];
path[0] = Designer.theDesigner().getToDoList();
for (KnowledgeTypeNode ktn : KnowledgeTypeNode.getTypeList()) //1
{ 
String kt = ktn.getName();
path[1] = ktn;
int nMatchingItems = 0;
for (ToDoItem item : items) //1
{ 
if(!item.containsKnowledgeType(kt))//1
{ 
continue;
} 

nMatchingItems++;
} 

if(nMatchingItems == 0)//1
{ 
continue;
} 

int[] childIndices = new int[nMatchingItems];
Object[] children = new Object[nMatchingItems];
nMatchingItems = 0;
for (ToDoItem item : items) //2
{ 
if(!item.containsKnowledgeType(kt))//1
{ 
continue;
} 

childIndices[nMatchingItems] = getIndexOfChild(ktn, item);
children[nMatchingItems] = item;
nMatchingItems++;
} 

fireTreeNodesInserted(this, path, childIndices, children);
} 

} 

 } 

//#endif 


