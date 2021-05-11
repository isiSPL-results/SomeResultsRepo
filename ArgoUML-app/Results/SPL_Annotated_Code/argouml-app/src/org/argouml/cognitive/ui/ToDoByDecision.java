// Compilation Unit of /ToDoByDecision.java 
 

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
import org.argouml.cognitive.Decision;
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
public class ToDoByDecision extends ToDoPerspective
 implements ToDoListListener
  { 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
private static final Logger LOG =
        Logger.getLogger(ToDoByDecision.class);
//#endif 

public ToDoByDecision()
    { 
super("combobox.todo-perspective-decision");
addSubTreeModel(new GoListToDecisionsToItems());
} 

public void toDoItemsRemoved(ToDoListEvent tde)
    { 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.debug("toDoItemRemoved");
//#endif 

List<ToDoItem> items = tde.getToDoItemList();
Object[] path = new Object[2];
path[0] = Designer.theDesigner().getToDoList();
for (Decision dec : Designer.theDesigner().getDecisionModel()
                .getDecisionList()) //1
{ 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.debug("toDoItemRemoved updating decision node!");
//#endif 

boolean anyInDec = false;
for (ToDoItem item : items) //1
{ 
if(item.supports(dec))//1
{ 
anyInDec = true;
} 

} 

if(!anyInDec)//1
{ 
continue;
} 

path[1] = dec;
fireTreeStructureChanged(path);
} 

} 

public void toDoItemsAdded(ToDoListEvent tde)
    { 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.debug("toDoItemAdded");
//#endif 

List<ToDoItem> items = tde.getToDoItemList();
Object[] path = new Object[2];
path[0] = Designer.theDesigner().getToDoList();
for (Decision dec : Designer.theDesigner().getDecisionModel()
                .getDecisionList()) //1
{ 
int nMatchingItems = 0;
path[1] = dec;
for (ToDoItem item : items) //1
{ 
if(!item.supports(dec))//1
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
if(!item.supports(dec))//1
{ 
continue;
} 

childIndices[nMatchingItems] = getIndexOfChild(dec, item);
children[nMatchingItems] = item;
nMatchingItems++;
} 

fireTreeNodesInserted(this, path, childIndices, children);
} 

} 

public void toDoItemsChanged(ToDoListEvent tde)
    { 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.debug("toDoItemChanged");
//#endif 

List<ToDoItem> items = tde.getToDoItemList();
Object[] path = new Object[2];
path[0] = Designer.theDesigner().getToDoList();
for (Decision dec : Designer.theDesigner().getDecisionModel()
                .getDecisionList()) //1
{ 
int nMatchingItems = 0;
path[1] = dec;
for (ToDoItem item : items) //1
{ 
if(!item.supports(dec))//1
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
if(!item.supports(dec))//1
{ 
continue;
} 

childIndices[nMatchingItems] = getIndexOfChild(dec, item);
children[nMatchingItems] = item;
nMatchingItems++;
} 

fireTreeNodesChanged(this, path, childIndices, children);
} 

} 

public void toDoListChanged(ToDoListEvent tde) { 
} 

 } 

//#endif 


