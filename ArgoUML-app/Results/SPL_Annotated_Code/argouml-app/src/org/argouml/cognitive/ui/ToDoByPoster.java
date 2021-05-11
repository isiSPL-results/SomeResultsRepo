// Compilation Unit of /ToDoByPoster.java 
 

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
import org.argouml.cognitive.ListSet;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Poster;
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
public class ToDoByPoster extends ToDoPerspective
 implements ToDoListListener
  { 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
private static final Logger LOG =
        Logger.getLogger(ToDoByPoster.class);
//#endif 

public ToDoByPoster()
    { 
super("combobox.todo-perspective-poster");
addSubTreeModel(new GoListToPosterToItem());
} 

public void toDoItemsChanged(ToDoListEvent tde)
    { 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.debug("toDoItemsChanged");
//#endif 

List<ToDoItem> items = tde.getToDoItemList();
Object[] path = new Object[2];
path[0] = Designer.theDesigner().getToDoList();
ListSet<Poster> allPosters =
            Designer.theDesigner().getToDoList().getPosters();
synchronized (allPosters) //1
{ 
for (Poster p : allPosters) //1
{ 
path[1] = p;
int nMatchingItems = 0;
for (ToDoItem item : items) //1
{ 
Poster post = item.getPoster();
if(post != p)//1
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
Poster post = item.getPoster();
if(post != p)//1
{ 
continue;
} 

childIndices[nMatchingItems] = getIndexOfChild(p, item);
children[nMatchingItems] = item;
nMatchingItems++;
} 

fireTreeNodesChanged(this, path, childIndices, children);
} 

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
ListSet<Poster> allPosters =
            Designer.theDesigner().getToDoList().getPosters();
synchronized (allPosters) //1
{ 
for (Poster p : allPosters) //1
{ 
path[1] = p;
int nMatchingItems = 0;
for (ToDoItem item : items) //1
{ 
Poster post = item.getPoster();
if(post != p)//1
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
Poster post = item.getPoster();
if(post != p)//1
{ 
continue;
} 

childIndices[nMatchingItems] = getIndexOfChild(p, item);
children[nMatchingItems] = item;
nMatchingItems++;
} 

fireTreeNodesInserted(this, path, childIndices, children);
} 

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
ListSet<Poster> allPosters = Designer.theDesigner().getToDoList()
                                     .getPosters();
synchronized (allPosters) //1
{ 
for (Poster p : allPosters) //1
{ 
boolean anyInPoster = false;
for (ToDoItem item : items) //1
{ 
Poster post = item.getPoster();
if(post == p)//1
{ 
anyInPoster = true;
break;

} 

} 

if(!anyInPoster)//1
{ 
continue;
} 

path[1] = p;
fireTreeStructureChanged(path);
} 

} 

} 

public void toDoListChanged(ToDoListEvent tde)
    { 
} 

 } 

//#endif 


