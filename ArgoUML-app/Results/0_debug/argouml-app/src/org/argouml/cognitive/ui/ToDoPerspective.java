
//#if 1775972975 
// Compilation Unit of /ToDoPerspective.java 
 

//#if 1768699191 
package org.argouml.cognitive.ui;
//#endif 


//#if 1363924656 
import java.util.ArrayList;
//#endif 


//#if 1572991409 
import java.util.List;
//#endif 


//#if -164577747 
import org.apache.log4j.Logger;
//#endif 


//#if -950373883 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if -1171947954 
import org.argouml.ui.TreeModelComposite;
//#endif 


//#if -510571088 
public abstract class ToDoPerspective extends 
//#if 1658849860 
TreeModelComposite
//#endif 

  { 

//#if 784805416 
private static final Logger LOG = Logger.getLogger(ToDoPerspective.class);
//#endif 


//#if -1634672331 
private boolean flat;
//#endif 


//#if -1441991935 
private List<ToDoItem> flatChildren;
//#endif 


//#if -651587958 
public ToDoPerspective(String name)
    { 

//#if -1056539754 
super(name);
//#endif 


//#if -188281951 
flatChildren = new ArrayList<ToDoItem>();
//#endif 

} 

//#endif 


//#if 1067437305 
@Override
    public Object getChild(Object parent, int index)
    { 

//#if 90572152 
if(flat && parent == getRoot())//1
{ 

//#if 1332606894 
return flatChildren.get(index);
//#endif 

} 

//#endif 


//#if -306108548 
return super.getChild(parent,  index);
//#endif 

} 

//#endif 


//#if -1378817164 
public void addFlatChildren(Object node)
    { 

//#if 354192155 
if(node == null)//1
{ 

//#if -607625698 
return;
//#endif 

} 

//#endif 


//#if 334921693 
LOG.debug("addFlatChildren");
//#endif 


//#if 1094735263 
if((node instanceof ToDoItem) && !flatChildren.contains(node))//1
{ 

//#if -1580323049 
flatChildren.add((ToDoItem) node);
//#endif 

} 

//#endif 


//#if -792184893 
int nKids = getChildCount(node);
//#endif 


//#if 99644368 
for (int i = 0; i < nKids; i++) //1
{ 

//#if -1314179922 
addFlatChildren(getChild(node, i));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 454837727 
@Override
    public int getChildCount(Object parent)
    { 

//#if 191254061 
if(flat && parent == getRoot())//1
{ 

//#if -845777388 
return flatChildren.size();
//#endif 

} 

//#endif 


//#if -450032488 
return super.getChildCount(parent);
//#endif 

} 

//#endif 


//#if -2105638125 
public void calcFlatChildren()
    { 

//#if -33550422 
flatChildren.clear();
//#endif 


//#if 1963756643 
addFlatChildren(getRoot());
//#endif 

} 

//#endif 


//#if 1641084814 
@Override
    public int getIndexOfChild(Object parent, Object child)
    { 

//#if -1054859951 
if(flat && parent == getRoot())//1
{ 

//#if -1827063054 
return flatChildren.indexOf(child);
//#endif 

} 

//#endif 


//#if -1106265876 
return super.getIndexOfChild(parent, child);
//#endif 

} 

//#endif 


//#if 268455929 
public boolean getFlat()
    { 

//#if -1390407368 
return flat;
//#endif 

} 

//#endif 


//#if -603233827 
public void setFlat(boolean b)
    { 

//#if -2069028792 
flat = false;
//#endif 


//#if 1509129395 
if(b)//1
{ 

//#if 1477535664 
calcFlatChildren();
//#endif 

} 

//#endif 


//#if -33552151 
flat = b;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

