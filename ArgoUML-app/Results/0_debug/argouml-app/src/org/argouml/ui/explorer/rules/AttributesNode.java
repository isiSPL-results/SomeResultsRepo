
//#if 1222664788 
// Compilation Unit of /AttributesNode.java 
 

//#if 1836191096 
package org.argouml.ui.explorer.rules;
//#endif 


//#if 1062469159 
import org.argouml.ui.explorer.WeakExplorerNode;
//#endif 


//#if 1577862180 
public class AttributesNode implements 
//#if -1760901358 
WeakExplorerNode
//#endif 

  { 

//#if 263342056 
private Object parent;
//#endif 


//#if 694953722 
public boolean subsumes(Object obj)
    { 

//#if -1523834434 
return obj instanceof AttributesNode;
//#endif 

} 

//#endif 


//#if 1146142330 
public AttributesNode(Object theParent)
    { 

//#if -442501706 
this.parent = theParent;
//#endif 

} 

//#endif 


//#if 1574894080 
public Object getParent()
    { 

//#if 7071597 
return parent;
//#endif 

} 

//#endif 


//#if -1560579712 
public String toString()
    { 

//#if 697148489 
return "Attributes";
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

