
//#if 847935730 
// Compilation Unit of /TreeModelSupport.java 
 

//#if 1419180056 
package org.argouml.ui;
//#endif 


//#if 1329977604 
import javax.swing.event.EventListenerList;
//#endif 


//#if -848530281 
import javax.swing.event.TreeModelEvent;
//#endif 


//#if 362617489 
import javax.swing.event.TreeModelListener;
//#endif 


//#if -1606186401 
public class TreeModelSupport extends 
//#if -959196911 
PerspectiveSupport
//#endif 

  { 

//#if 1234998250 
private EventListenerList listenerList = new EventListenerList();
//#endif 


//#if -11096208 
public TreeModelSupport(String name)
    { 

//#if 708929225 
super(name);
//#endif 

} 

//#endif 


//#if -1340537843 
public void addTreeModelListener(TreeModelListener l)
    { 

//#if 2039432103 
listenerList.add(TreeModelListener.class, l);
//#endif 

} 

//#endif 


//#if -1947194752 
protected void fireTreeNodesChanged(
        final Object source,
        final Object[] path,
        final int[] childIndices,
        final Object[] children)
    { 

//#if 422094124 
Object[] listeners = listenerList.getListenerList();
//#endif 


//#if -1014513238 
TreeModelEvent e = null;
//#endif 


//#if 806987956 
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 

//#if 716888155 
if(listeners[i] == TreeModelListener.class)//1
{ 

//#if -1494172163 
if(e == null)//1
{ 

//#if 1486153276 
e =
                        new TreeModelEvent(
                        source,
                        path,
                        childIndices,
                        children);
//#endif 

} 

//#endif 


//#if 562734941 
((TreeModelListener) listeners[i + 1]).treeNodesChanged(e);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 8222222 
protected void fireTreeNodesInserted(
        Object source,
        Object[] path,
        int[] childIndices,
        Object[] children)
    { 

//#if 2039746949 
Object[] listeners = listenerList.getListenerList();
//#endif 


//#if -317653629 
TreeModelEvent e = null;
//#endif 


//#if 694124045 
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 

//#if 1207835651 
if(listeners[i] == TreeModelListener.class)//1
{ 

//#if -2073714180 
if(e == null)//1
{ 

//#if -1707999088 
e =
                        new TreeModelEvent(
                        source,
                        path,
                        childIndices,
                        children);
//#endif 

} 

//#endif 


//#if -736331090 
((TreeModelListener) listeners[i + 1]).treeNodesInserted(e);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 232720708 
protected void fireTreeNodesRemoved(
        Object source,
        Object[] path,
        int[] childIndices,
        Object[] children)
    { 

//#if -73162875 
Object[] listeners = listenerList.getListenerList();
//#endif 


//#if 912362371 
TreeModelEvent e = null;
//#endif 


//#if -2099442675 
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 

//#if -1537304113 
if(listeners[i] == TreeModelListener.class)//1
{ 

//#if 531150567 
if(e == null)//1
{ 

//#if -2008909277 
e =
                        new TreeModelEvent(
                        source,
                        path,
                        childIndices,
                        children);
//#endif 

} 

//#endif 


//#if 129620851 
((TreeModelListener) listeners[i + 1]).treeNodesRemoved(e);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1785896780 
protected void fireTreeStructureChanged(Object[] path)
    { 

//#if 319075000 
fireTreeStructureChanged(this, path);
//#endif 

} 

//#endif 


//#if -2005464115 
public void fireTreeStructureChanged(
        Object source,
        Object[] path,
        int[] childIndices,
        Object[] children)
    { 

//#if 49911090 
Object[] listeners = listenerList.getListenerList();
//#endif 


//#if 1648023216 
TreeModelEvent e = null;
//#endif 


//#if 1325792954 
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 

//#if 1424087136 
if(listeners[i] == TreeModelListener.class)//1
{ 

//#if 525474513 
if(e == null)//1
{ 

//#if -1746748494 
e =
                        new TreeModelEvent(
                        source,
                        path,
                        childIndices,
                        children);
//#endif 

} 

//#endif 


//#if -1959707729 
((TreeModelListener) listeners[i + 1]).treeStructureChanged(e);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -476721868 
public void removeTreeModelListener(TreeModelListener l)
    { 

//#if 1637687424 
listenerList.remove(TreeModelListener.class, l);
//#endif 

} 

//#endif 


//#if -12779136 
protected void fireTreeStructureChanged(Object source, Object[] path)
    { 

//#if 798578691 
fireTreeStructureChanged(source, path, null, null);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

