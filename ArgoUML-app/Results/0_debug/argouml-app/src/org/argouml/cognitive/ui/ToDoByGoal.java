
//#if 1479053051 
// Compilation Unit of /ToDoByGoal.java 
 

//#if -1185256717 
package org.argouml.cognitive.ui;
//#endif 


//#if 1919496937 
import org.apache.log4j.Logger;
//#endif 


//#if 1215141303 
import org.argouml.cognitive.Designer;
//#endif 


//#if -1665593841 
import org.argouml.cognitive.Goal;
//#endif 


//#if -304844343 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 2005845374 
import org.argouml.cognitive.ToDoListEvent;
//#endif 


//#if -989737910 
import org.argouml.cognitive.ToDoListListener;
//#endif 


//#if 7921724 
public class ToDoByGoal extends 
//#if -1443564962 
ToDoPerspective
//#endif 

 implements 
//#if -1522686064 
ToDoListListener
//#endif 

  { 

//#if 512792230 
private static final Logger LOG =
        Logger.getLogger(ToDoByGoal.class);
//#endif 


//#if 954707953 
public void toDoItemsChanged(ToDoListEvent tde)
    { 

//#if 178099051 
LOG.debug("toDoItemsChanged");
//#endif 


//#if -2106307247 
Object[] path = new Object[2];
//#endif 


//#if -577814554 
path[0] = Designer.theDesigner().getToDoList();
//#endif 


//#if 1440881077 
for (Goal g : Designer.theDesigner().getGoalList()) //1
{ 

//#if -146774976 
path[1] = g;
//#endif 


//#if 1576507669 
int nMatchingItems = 0;
//#endif 


//#if 1129361503 
for (ToDoItem item : tde.getToDoItemList()) //1
{ 

//#if -95511598 
if(!item.supports(g))//1
{ 

//#if -581987260 
continue;
//#endif 

} 

//#endif 


//#if -300201379 
nMatchingItems++;
//#endif 

} 

//#endif 


//#if -871224215 
if(nMatchingItems == 0)//1
{ 

//#if 2061985136 
continue;
//#endif 

} 

//#endif 


//#if -936535891 
int[] childIndices = new int[nMatchingItems];
//#endif 


//#if -657602021 
Object[] children = new Object[nMatchingItems];
//#endif 


//#if 707890786 
nMatchingItems = 0;
//#endif 


//#if -1965184526 
for (ToDoItem item : tde.getToDoItemList()) //2
{ 

//#if 618087936 
if(!item.supports(g))//1
{ 

//#if -7396870 
continue;
//#endif 

} 

//#endif 


//#if 134167191 
childIndices[nMatchingItems] = getIndexOfChild(g, item);
//#endif 


//#if 1636698926 
children[nMatchingItems] = item;
//#endif 


//#if 842897391 
nMatchingItems++;
//#endif 

} 

//#endif 


//#if 1826861433 
fireTreeNodesChanged(this, path, childIndices, children);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1048128867 
public void toDoItemsRemoved(ToDoListEvent tde)
    { 

//#if 573709949 
LOG.debug("toDoItemAdded");
//#endif 


//#if 957165744 
Object[] path = new Object[2];
//#endif 


//#if 639371815 
path[0] = Designer.theDesigner().getToDoList();
//#endif 


//#if -1498509292 
for (Goal g : Designer.theDesigner().getGoalList()) //1
{ 

//#if -1425036475 
LOG.debug("toDoItemRemoved updating decision node!");
//#endif 


//#if 1336667215 
boolean anyInGoal = false;
//#endif 


//#if 764927896 
for (ToDoItem item : tde.getToDoItemList()) //1
{ 

//#if 1532022847 
if(item.supports(g))//1
{ 

//#if 1068749444 
anyInGoal = true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 15532396 
if(!anyInGoal)//1
{ 

//#if -990078674 
continue;
//#endif 

} 

//#endif 


//#if -1836402823 
path[1] = g;
//#endif 


//#if 963128160 
fireTreeStructureChanged(path);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 922594813 
public void toDoItemsAdded(ToDoListEvent tde)
    { 

//#if -793783293 
LOG.debug("toDoItemAdded");
//#endif 


//#if 81769066 
Object[] path = new Object[2];
//#endif 


//#if 765831725 
path[0] = Designer.theDesigner().getToDoList();
//#endif 


//#if -26868786 
for (Goal g : Designer.theDesigner().getGoalList()) //1
{ 

//#if 1726135492 
path[1] = g;
//#endif 


//#if -1904730983 
int nMatchingItems = 0;
//#endif 


//#if -1227884317 
for (ToDoItem item : tde.getToDoItemList()) //1
{ 

//#if 735679183 
if(!item.supports(g))//1
{ 

//#if -1937552126 
continue;
//#endif 

} 

//#endif 


//#if 751273472 
nMatchingItems++;
//#endif 

} 

//#endif 


//#if -102937107 
if(nMatchingItems == 0)//1
{ 

//#if 1792298578 
continue;
//#endif 

} 

//#endif 


//#if -1289670743 
int[] childIndices = new int[nMatchingItems];
//#endif 


//#if -717778409 
Object[] children = new Object[nMatchingItems];
//#endif 


//#if 936859998 
nMatchingItems = 0;
//#endif 


//#if 334848750 
for (ToDoItem item : tde.getToDoItemList()) //2
{ 

//#if -747094100 
if(!item.supports(g))//1
{ 

//#if 39109918 
continue;
//#endif 

} 

//#endif 


//#if -1001377685 
childIndices[nMatchingItems] = getIndexOfChild(g, item);
//#endif 


//#if 310383578 
children[nMatchingItems] = item;
//#endif 


//#if -1848711229 
nMatchingItems++;
//#endif 

} 

//#endif 


//#if -535046479 
fireTreeNodesInserted(this, path, childIndices, children);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 76174482 
public ToDoByGoal()
    { 

//#if 1024818261 
super("combobox.todo-perspective-goal");
//#endif 


//#if -301877171 
addSubTreeModel(new GoListToGoalsToItems());
//#endif 

} 

//#endif 


//#if 553159677 
public void toDoListChanged(ToDoListEvent tde) { 
} 

//#endif 

 } 

//#endif 


//#endif 

