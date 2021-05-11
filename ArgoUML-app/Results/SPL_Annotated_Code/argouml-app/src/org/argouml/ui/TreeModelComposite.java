// Compilation Unit of /TreeModelComposite.java 
 
package org.argouml.ui;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

//#if LOGGING 
import org.apache.log4j.Logger;
//#endif 

public class TreeModelComposite extends TreeModelSupport
 implements TreeModel
  { 
private Object root;

//#if LOGGING 
private static final Logger LOG =
        Logger.getLogger(TreeModelComposite.class);
//#endif 

public int getIndexOfChild(Object parent, Object child)
    { 
int childCount = 0;
for (TreeModel tm : getGoRuleList()) //1
{ 
int childIndex = tm.getIndexOfChild(parent, child);
if(childIndex != -1)//1
{ 
return childIndex + childCount;
} 

childCount += tm.getChildCount(parent);
} 


//#if LOGGING 
LOG.debug("child not found!");
//#endif 

return -1;
} 

public Object getChild(Object parent, int index)
    { 
for (TreeModel tm : getGoRuleList()) //1
{ 
int childCount = tm.getChildCount(parent);
if(index < childCount)//1
{ 
return tm.getChild(parent, index);
} 

index -= childCount;
} 

return null;
} 

public TreeModelComposite(String name)
    { 
super(name);
} 

public void setRoot(Object r)
    { 
root = r;
} 

public void valueForPathChanged(TreePath path, Object newValue)
    { 
} 

public Object getRoot()
    { 
return root;
} 

public boolean isLeaf(Object node)
    { 
for (TreeModel tm : getGoRuleList()) //1
{ 
if(!tm.isLeaf(node))//1
{ 
return false;
} 

} 

return true;
} 

public int getChildCount(Object parent)
    { 
int childCount = 0;
for (TreeModel tm : getGoRuleList()) //1
{ 
childCount += tm.getChildCount(parent);
} 

return childCount;
} 

 } 


