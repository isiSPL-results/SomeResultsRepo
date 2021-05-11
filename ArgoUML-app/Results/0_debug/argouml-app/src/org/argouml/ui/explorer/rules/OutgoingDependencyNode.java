
//#if 742533059 
// Compilation Unit of /OutgoingDependencyNode.java 
 

//#if -501945400 
package org.argouml.ui.explorer.rules;
//#endif 


//#if -1410254729 
import org.argouml.ui.explorer.WeakExplorerNode;
//#endif 


//#if -543157772 
public class OutgoingDependencyNode implements 
//#if -310203041 
WeakExplorerNode
//#endif 

  { 

//#if 278453 
private Object parent;
//#endif 


//#if 28053624 
public OutgoingDependencyNode(Object p)
    { 

//#if -1730086009 
parent = p;
//#endif 

} 

//#endif 


//#if -961631731 
public String toString()
    { 

//#if 548489243 
return "Outgoing Dependencies";
//#endif 

} 

//#endif 


//#if -1332554989 
public Object getParent()
    { 

//#if 1574952401 
return parent;
//#endif 

} 

//#endif 


//#if -1838165177 
public boolean subsumes(Object obj)
    { 

//#if -1524337209 
return obj instanceof OutgoingDependencyNode;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

