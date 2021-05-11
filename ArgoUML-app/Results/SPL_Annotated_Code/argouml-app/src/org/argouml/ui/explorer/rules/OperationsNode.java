// Compilation Unit of /OperationsNode.java 
 
package org.argouml.ui.explorer.rules;
import org.argouml.ui.explorer.WeakExplorerNode;
public class OperationsNode implements WeakExplorerNode
  { 
private Object parent;
public String toString()
    { 
return "Operations";
} 

public Object getParent()
    { 
return parent;
} 

public boolean subsumes(Object obj)
    { 
return obj instanceof OperationsNode;
} 

public OperationsNode(Object p)
    { 
parent = p;
} 

 } 


