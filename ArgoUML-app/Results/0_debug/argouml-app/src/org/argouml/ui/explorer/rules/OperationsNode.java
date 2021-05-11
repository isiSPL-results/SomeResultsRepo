
//#if 682777701 
// Compilation Unit of /OperationsNode.java 
 

//#if 401646347 
package org.argouml.ui.explorer.rules;
//#endif 


//#if -5310470 
import org.argouml.ui.explorer.WeakExplorerNode;
//#endif 


//#if 1873230412 
public class OperationsNode implements 
//#if -1996878206 
WeakExplorerNode
//#endif 

  { 

//#if 1624266584 
private Object parent;
//#endif 


//#if 617833712 
public String toString()
    { 

//#if -90821615 
return "Operations";
//#endif 

} 

//#endif 


//#if 386233488 
public Object getParent()
    { 

//#if 890038807 
return parent;
//#endif 

} 

//#endif 


//#if -1002533270 
public boolean subsumes(Object obj)
    { 

//#if -1381445110 
return obj instanceof OperationsNode;
//#endif 

} 

//#endif 


//#if -375226560 
public OperationsNode(Object p)
    { 

//#if -1717940985 
parent = p;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

