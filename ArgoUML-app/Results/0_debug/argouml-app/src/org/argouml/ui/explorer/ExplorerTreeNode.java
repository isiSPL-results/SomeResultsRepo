
//#if 663617711 
// Compilation Unit of /ExplorerTreeNode.java 
 

//#if -1039955305 
package org.argouml.ui.explorer;
//#endif 


//#if 467070954 
import java.beans.PropertyChangeEvent;
//#endif 


//#if 1862433374 
import java.beans.PropertyChangeListener;
//#endif 


//#if 233493849 
import java.util.Collections;
//#endif 


//#if -2024608166 
import java.util.Iterator;
//#endif 


//#if -1748837588 
import java.util.Set;
//#endif 


//#if 126850497 
import javax.swing.tree.DefaultMutableTreeNode;
//#endif 


//#if 1726881635 
import javax.swing.tree.TreePath;
//#endif 


//#if -1707671944 
import org.tigris.gef.base.Diagram;
//#endif 


//#if -1147268928 
public class ExplorerTreeNode extends 
//#if -1061922560 
DefaultMutableTreeNode
//#endif 

 implements 
//#if -663694540 
PropertyChangeListener
//#endif 

  { 

//#if -1405056321 
private static final long serialVersionUID = -6766504350537675845L;
//#endif 


//#if -543559882 
private ExplorerTreeModel model;
//#endif 


//#if 1998277890 
private boolean expanded;
//#endif 


//#if -37127388 
private boolean pending;
//#endif 


//#if -1854896621 
private Set modifySet = Collections.EMPTY_SET;
//#endif 


//#if 323379459 
public void nodeModified(Object node)
    { 

//#if 528422343 
if(modifySet.contains(node))//1
{ 

//#if -331233317 
model.getNodeUpdater().schedule(this);
//#endif 

} 

//#endif 


//#if -2139045972 
if(node == getUserObject())//1
{ 

//#if -62530312 
model.nodeChanged(this);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -72711740 
public ExplorerTreeNode(Object userObj, ExplorerTreeModel m)
    { 

//#if 162699688 
super(userObj);
//#endif 


//#if -2049134231 
this.model = m;
//#endif 


//#if 771815493 
if(userObj instanceof Diagram)//1
{ 

//#if -1514929431 
((Diagram) userObj).addPropertyChangeListener(this);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -999758640 
public void propertyChange(PropertyChangeEvent evt)
    { 

//#if 427037673 
if(evt.getSource() instanceof Diagram)//1
{ 

//#if -156968101 
if("name".equals(evt.getPropertyName()))//1
{ 

//#if -720490691 
model.nodeChanged(this);
//#endif 

} 

//#endif 


//#if -1981178365 
if("namespace".equals(evt.getPropertyName()))//1
{ 
} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1414926463 
public void setModifySet(Set set)
    { 

//#if 333331371 
if(set == null || set.size() == 0)//1
{ 

//#if 1962253789 
modifySet = Collections.EMPTY_SET;
//#endif 

} 
else
{ 

//#if 444027160 
modifySet = set;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1998457379 
public void remove()
    { 

//#if 1495377096 
this.userObject = null;
//#endif 


//#if -1500254324 
if(children != null)//1
{ 

//#if 348408735 
Iterator childrenIt = children.iterator();
//#endif 


//#if 1229395532 
while (childrenIt.hasNext()) //1
{ 

//#if 1141143641 
((ExplorerTreeNode) childrenIt.next()).remove();
//#endif 

} 

//#endif 


//#if -1510718087 
children.clear();
//#endif 


//#if 2068220121 
children = null;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1210672393 
@Override
    public boolean isLeaf()
    { 

//#if 1809896683 
if(!expanded)//1
{ 

//#if 1079344629 
model.updateChildren(new TreePath(model.getPathToRoot(this)));
//#endif 


//#if -371236039 
expanded = true;
//#endif 

} 

//#endif 


//#if 1520783355 
return super.isLeaf();
//#endif 

} 

//#endif 


//#if -859294564 
void setPending(boolean value)
    { 

//#if 1968582171 
pending = value;
//#endif 

} 

//#endif 


//#if 1439568591 
boolean getPending()
    { 

//#if -2052556968 
return pending;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

