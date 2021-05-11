package org.argouml.ui.explorer.rules;
import org.argouml.ui.explorer.WeakExplorerNode;
public class IncomingDependencyNode implements WeakExplorerNode
  { 
private Object parent;
public Object getParent()
    { 
return parent;
} 
public boolean subsumes(Object obj)
    { 
return obj instanceof IncomingDependencyNode;
} 
public IncomingDependencyNode(Object theParent)
    { 
this.parent = theParent;
} 
public String toString()
    { 
return "Incoming Dependencies";
} 

 } 
