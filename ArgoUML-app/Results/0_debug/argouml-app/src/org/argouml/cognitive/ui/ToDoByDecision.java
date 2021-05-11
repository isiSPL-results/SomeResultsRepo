
//#if -93382780 
// Compilation Unit of /ToDoByDecision.java 
 

//#if 1660227545 
package org.argouml.cognitive.ui;
//#endif 


//#if 586639439 
import java.util.List;
//#endif 


//#if -602678961 
import org.apache.log4j.Logger;
//#endif 


//#if -1533585984 
import org.argouml.cognitive.Decision;
//#endif 


//#if -229371759 
import org.argouml.cognitive.Designer;
//#endif 


//#if -1749357405 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if -1331363100 
import org.argouml.cognitive.ToDoListEvent;
//#endif 


//#if 135580964 
import org.argouml.cognitive.ToDoListListener;
//#endif 


//#if -576829857 
public class ToDoByDecision extends 
//#if 954626132 
ToDoPerspective
//#endif 

 implements 
//#if -193206182 
ToDoListListener
//#endif 

  { 

//#if -1794623003 
private static final Logger LOG =
        Logger.getLogger(ToDoByDecision.class);
//#endif 


//#if 431958373 
public ToDoByDecision()
    { 

//#if 434498317 
super("combobox.todo-perspective-decision");
//#endif 


//#if -615889067 
addSubTreeModel(new GoListToDecisionsToItems());
//#endif 

} 

//#endif 


//#if 2045730919 
public void toDoItemsRemoved(ToDoListEvent tde)
    { 

//#if -1805174123 
LOG.debug("toDoItemRemoved");
//#endif 


//#if -1378184347 
List<ToDoItem> items = tde.getToDoItemList();
//#endif 


//#if 1678816760 
Object[] path = new Object[2];
//#endif 


//#if -669208609 
path[0] = Designer.theDesigner().getToDoList();
//#endif 


//#if -229534199 
for (Decision dec : Designer.theDesigner().getDecisionModel()
                .getDecisionList()) //1
{ 

//#if 590771340 
LOG.debug("toDoItemRemoved updating decision node!");
//#endif 


//#if 993660685 
boolean anyInDec = false;
//#endif 


//#if 675731146 
for (ToDoItem item : items) //1
{ 

//#if -1105917028 
if(item.supports(dec))//1
{ 

//#if -2139529093 
anyInDec = true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1637392608 
if(!anyInDec)//1
{ 

//#if 1525639907 
continue;
//#endif 

} 

//#endif 


//#if -1791299451 
path[1] = dec;
//#endif 


//#if 1004114297 
fireTreeStructureChanged(path);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1390618183 
public void toDoItemsAdded(ToDoListEvent tde)
    { 

//#if -322876521 
LOG.debug("toDoItemAdded");
//#endif 


//#if 1797020099 
List<ToDoItem> items = tde.getToDoItemList();
//#endif 


//#if -1011419050 
Object[] path = new Object[2];
//#endif 


//#if -513284927 
path[0] = Designer.theDesigner().getToDoList();
//#endif 


//#if -1154936213 
for (Decision dec : Designer.theDesigner().getDecisionModel()
                .getDecisionList()) //1
{ 

//#if -698015373 
int nMatchingItems = 0;
//#endif 


//#if -735418525 
path[1] = dec;
//#endif 


//#if 674623784 
for (ToDoItem item : items) //1
{ 

//#if 2068448524 
if(!item.supports(dec))//1
{ 

//#if 2053676352 
continue;
//#endif 

} 

//#endif 


//#if 1570497736 
nMatchingItems++;
//#endif 

} 

//#endif 


//#if -945269305 
if(nMatchingItems == 0)//1
{ 

//#if -2129902710 
continue;
//#endif 

} 

//#endif 


//#if 908039951 
int[] childIndices = new int[nMatchingItems];
//#endif 


//#if -1841711107 
Object[] children = new Object[nMatchingItems];
//#endif 


//#if 1441927876 
nMatchingItems = 0;
//#endif 


//#if 1565247625 
for (ToDoItem item : items) //2
{ 

//#if 1792259626 
if(!item.supports(dec))//1
{ 

//#if 2118863181 
continue;
//#endif 

} 

//#endif 


//#if 47749399 
childIndices[nMatchingItems] = getIndexOfChild(dec, item);
//#endif 


//#if 784013587 
children[nMatchingItems] = item;
//#endif 


//#if -631842326 
nMatchingItems++;
//#endif 

} 

//#endif 


//#if 1673941911 
fireTreeNodesInserted(this, path, childIndices, children);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -246399557 
public void toDoItemsChanged(ToDoListEvent tde)
    { 

//#if 1754935947 
LOG.debug("toDoItemChanged");
//#endif 


//#if 347117787 
List<ToDoItem> items = tde.getToDoItemList();
//#endif 


//#if -1608751250 
Object[] path = new Object[2];
//#endif 


//#if -66965847 
path[0] = Designer.theDesigner().getToDoList();
//#endif 


//#if -1302404525 
for (Decision dec : Designer.theDesigner().getDecisionModel()
                .getDecisionList()) //1
{ 

//#if 451384583 
int nMatchingItems = 0;
//#endif 


//#if -1621905673 
path[1] = dec;
//#endif 


//#if -2064620100 
for (ToDoItem item : items) //1
{ 

//#if 1093667056 
if(!item.supports(dec))//1
{ 

//#if 1529212192 
continue;
//#endif 

} 

//#endif 


//#if 595275876 
nMatchingItems++;
//#endif 

} 

//#endif 


//#if 1474223963 
if(nMatchingItems == 0)//1
{ 

//#if -1926806962 
continue;
//#endif 

} 

//#endif 


//#if 251848699 
int[] childIndices = new int[nMatchingItems];
//#endif 


//#if -1081311767 
Object[] children = new Object[nMatchingItems];
//#endif 


//#if 1091200944 
nMatchingItems = 0;
//#endif 


//#if 1129323381 
for (ToDoItem item : items) //2
{ 

//#if -1625687678 
if(!item.supports(dec))//1
{ 

//#if -281078165 
continue;
//#endif 

} 

//#endif 


//#if -1466420033 
childIndices[nMatchingItems] = getIndexOfChild(dec, item);
//#endif 


//#if -2063601557 
children[nMatchingItems] = item;
//#endif 


//#if 2035217298 
nMatchingItems++;
//#endif 

} 

//#endif 


//#if -352702229 
fireTreeNodesChanged(this, path, childIndices, children);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2117985037 
public void toDoListChanged(ToDoListEvent tde) { 
} 

//#endif 

 } 

//#endif 


//#endif 

