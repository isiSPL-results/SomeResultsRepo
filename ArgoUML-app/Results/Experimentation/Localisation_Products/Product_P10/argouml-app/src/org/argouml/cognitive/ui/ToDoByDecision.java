package org.argouml.cognitive.ui;
import java.util.List;
import org.apache.log4j.Logger;
import org.argouml.cognitive.Decision;
import org.argouml.cognitive.Designer;
import org.argouml.cognitive.ToDoItem;
import org.argouml.cognitive.ToDoListEvent;
import org.argouml.cognitive.ToDoListListener;
public class ToDoByDecision extends ToDoPerspective
 implements ToDoListListener
  { 
private static final Logger LOG =
        Logger.getLogger(ToDoByDecision.class);
public ToDoByDecision()
    { 
super("combobox.todo-perspective-decision");
addSubTreeModel(new GoListToDecisionsToItems());
} 
public void toDoItemsRemoved(ToDoListEvent tde)
    { 
LOG.debug("toDoItemRemoved");
List<ToDoItem> items = tde.getToDoItemList();
Object[] path = new Object[2];
path[0] = Designer.theDesigner().getToDoList();
for (Decision dec : Designer.theDesigner().getDecisionModel()
                .getDecisionList()) //1
{ 
LOG.debug("toDoItemRemoved updating decision node!");
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
LOG.debug("toDoItemAdded");
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
LOG.debug("toDoItemChanged");
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
