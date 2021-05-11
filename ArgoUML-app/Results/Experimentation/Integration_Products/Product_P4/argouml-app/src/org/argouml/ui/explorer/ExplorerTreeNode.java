package org.argouml.ui.explorer;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import org.tigris.gef.base.Diagram;
public class ExplorerTreeNode extends DefaultMutableTreeNode
 implements PropertyChangeListener
  { 
private static final long serialVersionUID = -6766504350537675845L;
private ExplorerTreeModel model;
private boolean expanded;
private boolean pending;
private Set modifySet = Collections.EMPTY_SET;
public void nodeModified(Object node)
    { 
if(modifySet.contains(node))//1
{ 
model.getNodeUpdater().schedule(this);
} 
if(node == getUserObject())//1
{ 
model.nodeChanged(this);
} 
} 
public ExplorerTreeNode(Object userObj, ExplorerTreeModel m)
    { 
super(userObj);
this.model = m;
if(userObj instanceof Diagram)//1
{ 
((Diagram) userObj).addPropertyChangeListener(this);
} 
} 
public void propertyChange(PropertyChangeEvent evt)
    { 
if(evt.getSource() instanceof Diagram)//1
{ 
if("name".equals(evt.getPropertyName()))//1
{ 
model.nodeChanged(this);
} 
if("namespace".equals(evt.getPropertyName()))//1
{ 
} 
} 
} 
public void setModifySet(Set set)
    { 
if(set == null || set.size() == 0)//1
{ 
modifySet = Collections.EMPTY_SET;
} 
else
{ 
modifySet = set;
} 
} 
public void remove()
    { 
this.userObject = null;
if(children != null)//1
{ 
Iterator childrenIt = children.iterator();
while (childrenIt.hasNext()) //1
{ 
((ExplorerTreeNode) childrenIt.next()).remove();
} 
children.clear();
children = null;
} 
} 
@Override
    public boolean isLeaf()
    { 
if(!expanded)//1
{ 
model.updateChildren(new TreePath(model.getPathToRoot(this)));
expanded = true;
} 
return super.isLeaf();
} 
void setPending(boolean value)
    { 
pending = value;
} 
boolean getPending()
    { 
return pending;
} 

 } 
