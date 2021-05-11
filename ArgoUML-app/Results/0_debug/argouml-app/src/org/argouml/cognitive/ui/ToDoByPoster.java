
//#if 269983493 
// Compilation Unit of /ToDoByPoster.java 
 

//#if 286096575 
package org.argouml.cognitive.ui;
//#endif 


//#if 354553641 
import java.util.List;
//#endif 


//#if 1594771381 
import org.apache.log4j.Logger;
//#endif 


//#if 655999851 
import org.argouml.cognitive.Designer;
//#endif 


//#if 758986172 
import org.argouml.cognitive.ListSet;
//#endif 


//#if -548676599 
import org.argouml.cognitive.Poster;
//#endif 


//#if -863985795 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if -509671350 
import org.argouml.cognitive.ToDoListEvent;
//#endif 


//#if 2135885310 
import org.argouml.cognitive.ToDoListListener;
//#endif 


//#if -268619542 
public class ToDoByPoster extends 
//#if 11469978 
ToDoPerspective
//#endif 

 implements 
//#if 633724116 
ToDoListListener
//#endif 

  { 

//#if 1348578396 
private static final Logger LOG =
        Logger.getLogger(ToDoByPoster.class);
//#endif 


//#if -1130706928 
public ToDoByPoster()
    { 

//#if 1478082969 
super("combobox.todo-perspective-poster");
//#endif 


//#if 1374034949 
addSubTreeModel(new GoListToPosterToItem());
//#endif 

} 

//#endif 


//#if -1594419403 
public void toDoItemsChanged(ToDoListEvent tde)
    { 

//#if 1926134631 
LOG.debug("toDoItemsChanged");
//#endif 


//#if -2025380166 
List<ToDoItem> items = tde.getToDoItemList();
//#endif 


//#if 1852871501 
Object[] path = new Object[2];
//#endif 


//#if -1171660694 
path[0] = Designer.theDesigner().getToDoList();
//#endif 


//#if 1714671890 
ListSet<Poster> allPosters =
            Designer.theDesigner().getToDoList().getPosters();
//#endif 


//#if -757076559 
synchronized (allPosters) //1
{ 

//#if -167394585 
for (Poster p : allPosters) //1
{ 

//#if 1440448119 
path[1] = p;
//#endif 


//#if 1759365685 
int nMatchingItems = 0;
//#endif 


//#if 772374634 
for (ToDoItem item : items) //1
{ 

//#if -1393415389 
Poster post = item.getPoster();
//#endif 


//#if 1981039890 
if(post != p)//1
{ 

//#if 451658803 
continue;
//#endif 

} 

//#endif 


//#if 113309989 
nMatchingItems++;
//#endif 

} 

//#endif 


//#if -1472541303 
if(nMatchingItems == 0)//1
{ 

//#if 2096236368 
continue;
//#endif 

} 

//#endif 


//#if 309812109 
int[] childIndices = new int[nMatchingItems];
//#endif 


//#if -1213049605 
Object[] children = new Object[nMatchingItems];
//#endif 


//#if 817754434 
nMatchingItems = 0;
//#endif 


//#if 1672993287 
for (ToDoItem item : items) //2
{ 

//#if -999108655 
Poster post = item.getPoster();
//#endif 


//#if 364024384 
if(post != p)//1
{ 

//#if 1867471363 
continue;
//#endif 

} 

//#endif 


//#if 1307420598 
childIndices[nMatchingItems] = getIndexOfChild(p, item);
//#endif 


//#if 570622694 
children[nMatchingItems] = item;
//#endif 


//#if -42437321 
nMatchingItems++;
//#endif 

} 

//#endif 


//#if -1776969063 
fireTreeNodesChanged(this, path, childIndices, children);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1618602431 
public void toDoItemsAdded(ToDoListEvent tde)
    { 

//#if -1933591721 
LOG.debug("toDoItemAdded");
//#endif 


//#if 2079879683 
List<ToDoItem> items = tde.getToDoItemList();
//#endif 


//#if 1984663702 
Object[] path = new Object[2];
//#endif 


//#if -569252735 
path[0] = Designer.theDesigner().getToDoList();
//#endif 


//#if -1029633509 
ListSet<Poster> allPosters =
            Designer.theDesigner().getToDoList().getPosters();
//#endif 


//#if -966485624 
synchronized (allPosters) //1
{ 

//#if 320964848 
for (Poster p : allPosters) //1
{ 

//#if 515217912 
path[1] = p;
//#endif 


//#if -1890568074 
int nMatchingItems = 0;
//#endif 


//#if -1830389269 
for (ToDoItem item : items) //1
{ 

//#if -406476492 
Poster post = item.getPoster();
//#endif 


//#if -785365789 
if(post != p)//1
{ 

//#if -1727176895 
continue;
//#endif 

} 

//#endif 


//#if -2045797452 
nMatchingItems++;
//#endif 

} 

//#endif 


//#if 1465529162 
if(nMatchingItems == 0)//1
{ 

//#if -1320129008 
continue;
//#endif 

} 

//#endif 


//#if 1701449708 
int[] childIndices = new int[nMatchingItems];
//#endif 


//#if 415853978 
Object[] children = new Object[nMatchingItems];
//#endif 


//#if -1227418975 
nMatchingItems = 0;
//#endif 


//#if -221846298 
for (ToDoItem item : items) //2
{ 

//#if -1457138116 
Poster post = item.getPoster();
//#endif 


//#if -343908373 
if(post != p)//1
{ 

//#if -341629909 
continue;
//#endif 

} 

//#endif 


//#if -429711445 
childIndices[nMatchingItems] = getIndexOfChild(p, item);
//#endif 


//#if -1509025135 
children[nMatchingItems] = item;
//#endif 


//#if -1777777748 
nMatchingItems++;
//#endif 

} 

//#endif 


//#if 1976141236 
fireTreeNodesInserted(this, path, childIndices, children);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 697711073 
public void toDoItemsRemoved(ToDoListEvent tde)
    { 

//#if -1005398967 
LOG.debug("toDoItemRemoved");
//#endif 


//#if -377397711 
List<ToDoItem> items = tde.getToDoItemList();
//#endif 


//#if -1671522108 
Object[] path = new Object[2];
//#endif 


//#if -1897504365 
path[0] = Designer.theDesigner().getToDoList();
//#endif 


//#if 434203337 
ListSet<Poster> allPosters = Designer.theDesigner().getToDoList()
                                     .getPosters();
//#endif 


//#if 1655871258 
synchronized (allPosters) //1
{ 

//#if -1476987907 
for (Poster p : allPosters) //1
{ 

//#if 772608775 
boolean anyInPoster = false;
//#endif 


//#if 1534811473 
for (ToDoItem item : items) //1
{ 

//#if 1482798855 
Poster post = item.getPoster();
//#endif 


//#if 1808345874 
if(post == p)//1
{ 

//#if -970851469 
anyInPoster = true;
//#endif 


//#if 1848412535 
break;

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1021458776 
if(!anyInPoster)//1
{ 

//#if -1153493645 
continue;
//#endif 

} 

//#endif 


//#if -463861410 
path[1] = p;
//#endif 


//#if 2028406610 
fireTreeStructureChanged(path);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -914543559 
public void toDoListChanged(ToDoListEvent tde)
    { 
} 

//#endif 

 } 

//#endif 


//#endif 

