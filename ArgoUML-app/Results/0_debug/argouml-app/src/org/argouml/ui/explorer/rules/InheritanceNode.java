
//#if -1024960392 
// Compilation Unit of /InheritanceNode.java 
 

//#if 1255629173 
package org.argouml.ui.explorer.rules;
//#endif 


//#if -1368245788 
import org.argouml.ui.explorer.WeakExplorerNode;
//#endif 


//#if -485237948 
public class InheritanceNode implements 
//#if -1935020252 
WeakExplorerNode
//#endif 

  { 

//#if 1383798522 
private Object parent;
//#endif 


//#if 934079244 
public boolean subsumes(Object obj)
    { 

//#if -583514913 
return obj instanceof InheritanceNode;
//#endif 

} 

//#endif 


//#if -1970405912 
public InheritanceNode(Object p)
    { 

//#if -946979645 
parent = p;
//#endif 

} 

//#endif 


//#if 1456260114 
public String toString()
    { 

//#if 854339084 
return "Inheritance";
//#endif 

} 

//#endif 


//#if 607648174 
public Object getParent()
    { 

//#if -1044912730 
return parent;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

