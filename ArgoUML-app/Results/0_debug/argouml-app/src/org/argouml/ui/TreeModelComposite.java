
//#if 1412279922 
// Compilation Unit of /TreeModelComposite.java 
 

//#if 961491181 
package org.argouml.ui;
//#endif 


//#if 111455306 
import javax.swing.tree.TreeModel;
//#endif 


//#if -1656603746 
import javax.swing.tree.TreePath;
//#endif 


//#if -1363219377 
import org.apache.log4j.Logger;
//#endif 


//#if -675465566 
public class TreeModelComposite extends 
//#if -2054907603 
TreeModelSupport
//#endif 

 implements 
//#if -339603390 
TreeModel
//#endif 

  { 

//#if 1593733600 
private Object root;
//#endif 


//#if -1642651487 
private static final Logger LOG =
        Logger.getLogger(TreeModelComposite.class);
//#endif 


//#if 103926419 
public int getIndexOfChild(Object parent, Object child)
    { 

//#if -158885792 
int childCount = 0;
//#endif 


//#if 1710781010 
for (TreeModel tm : getGoRuleList()) //1
{ 

//#if 196830219 
int childIndex = tm.getIndexOfChild(parent, child);
//#endif 


//#if 1012469804 
if(childIndex != -1)//1
{ 

//#if 2105678188 
return childIndex + childCount;
//#endif 

} 

//#endif 


//#if 2052591054 
childCount += tm.getChildCount(parent);
//#endif 

} 

//#endif 


//#if 643872245 
LOG.debug("child not found!");
//#endif 


//#if -641875443 
return -1;
//#endif 

} 

//#endif 


//#if 499262868 
public Object getChild(Object parent, int index)
    { 

//#if -1062733614 
for (TreeModel tm : getGoRuleList()) //1
{ 

//#if -1825403341 
int childCount = tm.getChildCount(parent);
//#endif 


//#if -1794164466 
if(index < childCount)//1
{ 

//#if -1634421839 
return tm.getChild(parent, index);
//#endif 

} 

//#endif 


//#if -1999453464 
index -= childCount;
//#endif 

} 

//#endif 


//#if 1187258250 
return null;
//#endif 

} 

//#endif 


//#if 302049043 
public TreeModelComposite(String name)
    { 

//#if -1341531565 
super(name);
//#endif 

} 

//#endif 


//#if 1728230912 
public void setRoot(Object r)
    { 

//#if 1650733757 
root = r;
//#endif 

} 

//#endif 


//#if -692466260 
public void valueForPathChanged(TreePath path, Object newValue)
    { 
} 

//#endif 


//#if -261259768 
public Object getRoot()
    { 

//#if -1266407563 
return root;
//#endif 

} 

//#endif 


//#if 1463674814 
public boolean isLeaf(Object node)
    { 

//#if 1649808662 
for (TreeModel tm : getGoRuleList()) //1
{ 

//#if -908239548 
if(!tm.isLeaf(node))//1
{ 

//#if -1985616600 
return false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1133963097 
return true;
//#endif 

} 

//#endif 


//#if -396716636 
public int getChildCount(Object parent)
    { 

//#if 431969651 
int childCount = 0;
//#endif 


//#if 497581663 
for (TreeModel tm : getGoRuleList()) //1
{ 

//#if -1353280586 
childCount += tm.getChildCount(parent);
//#endif 

} 

//#endif 


//#if -235139189 
return childCount;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

