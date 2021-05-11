package org.argouml.cognitive.ui;
import java.util.ArrayList;
import java.util.List;
import org.argouml.cognitive.ToDoItem;
import org.argouml.ui.TreeModelComposite;
public abstract class ToDoPerspective extends TreeModelComposite
  { 
private boolean flat;
private List<ToDoItem> flatChildren;
public ToDoPerspective(String name)
    { 
super(name);
flatChildren = new ArrayList<ToDoItem>();
} 
@Override
    public Object getChild(Object parent, int index)
    { 
if(flat && parent == getRoot())//1
{ 
return flatChildren.get(index);
} 
return super.getChild(parent,  index);
} 
public void addFlatChildren(Object node)
    { 
if(node == null)//1
{ 
return;
} 
if((node instanceof ToDoItem) && !flatChildren.contains(node))//1
{ 
flatChildren.add((ToDoItem) node);
} 
int nKids = getChildCount(node);
for (int i = 0; i < nKids; i++) //1
{ 
addFlatChildren(getChild(node, i));
} 
} 
@Override
    public int getChildCount(Object parent)
    { 
if(flat && parent == getRoot())//1
{ 
return flatChildren.size();
} 
return super.getChildCount(parent);
} 
public void calcFlatChildren()
    { 
flatChildren.clear();
addFlatChildren(getRoot());
} 
@Override
    public int getIndexOfChild(Object parent, Object child)
    { 
if(flat && parent == getRoot())//1
{ 
return flatChildren.indexOf(child);
} 
return super.getIndexOfChild(parent, child);
} 
public boolean getFlat()
    { 
return flat;
} 
public void setFlat(boolean b)
    { 
flat = false;
if(b)//1
{ 
calcFlatChildren();
} 
flat = b;
} 

 } 
