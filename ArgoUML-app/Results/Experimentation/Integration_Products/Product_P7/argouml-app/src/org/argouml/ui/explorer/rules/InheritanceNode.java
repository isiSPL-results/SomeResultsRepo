package org.argouml.ui.explorer.rules;
import org.argouml.ui.explorer.WeakExplorerNode;
public class InheritanceNode implements WeakExplorerNode
  { 
private Object parent;
public boolean subsumes(Object obj)
    { 
return obj instanceof InheritanceNode;
} 
public InheritanceNode(Object p)
    { 
parent = p;
} 
public String toString()
    { 
return "Inheritance";
} 
public Object getParent()
    { 
return parent;
} 

 } 
