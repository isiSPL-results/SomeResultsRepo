
//#if -703674154 
// Compilation Unit of /IncomingDependencyNode.java 
 

//#if -521251694 
package org.argouml.ui.explorer.rules;
//#endif 


//#if 345877697 
import org.argouml.ui.explorer.WeakExplorerNode;
//#endif 


//#if -126851336 
public class IncomingDependencyNode implements 
//#if -51993597 
WeakExplorerNode
//#endif 

  { 

//#if 964969561 
private Object parent;
//#endif 


//#if 154065903 
public Object getParent()
    { 

//#if -1615055713 
return parent;
//#endif 

} 

//#endif 


//#if 1677328875 
public boolean subsumes(Object obj)
    { 

//#if 120275297 
return obj instanceof IncomingDependencyNode;
//#endif 

} 

//#endif 


//#if 206792367 
public IncomingDependencyNode(Object theParent)
    { 

//#if 414202746 
this.parent = theParent;
//#endif 

} 

//#endif 


//#if -1606412879 
public String toString()
    { 

//#if -628863501 
return "Incoming Dependencies";
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

