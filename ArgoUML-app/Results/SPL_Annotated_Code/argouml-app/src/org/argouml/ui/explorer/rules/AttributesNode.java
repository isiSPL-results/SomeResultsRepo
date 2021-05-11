// Compilation Unit of /AttributesNode.java 
 
package org.argouml.ui.explorer.rules;
import org.argouml.ui.explorer.WeakExplorerNode;
public class AttributesNode implements WeakExplorerNode
  { 
private Object parent;
public boolean subsumes(Object obj)
    { 
return obj instanceof AttributesNode;
} 

public AttributesNode(Object theParent)
    { 
this.parent = theParent;
} 

public Object getParent()
    { 
return parent;
} 

public String toString()
    { 
return "Attributes";
} 

 } 


