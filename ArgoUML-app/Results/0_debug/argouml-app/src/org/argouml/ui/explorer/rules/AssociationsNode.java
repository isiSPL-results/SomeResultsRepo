
//#if -1548018166 
// Compilation Unit of /AssociationsNode.java 
 

//#if -672766803 
package org.argouml.ui.explorer.rules;
//#endif 


//#if -1260349668 
import org.argouml.ui.explorer.WeakExplorerNode;
//#endif 


//#if 165806100 
public class AssociationsNode implements 
//#if -911314884 
WeakExplorerNode
//#endif 

  { 

//#if -2002170862 
private Object parent;
//#endif 


//#if 795643286 
public Object getParent()
    { 

//#if 712047249 
return parent;
//#endif 

} 

//#endif 


//#if 360463396 
public boolean subsumes(Object obj)
    { 

//#if 207399394 
return obj instanceof AssociationsNode;
//#endif 

} 

//#endif 


//#if -1012955467 
public AssociationsNode(Object theParent)
    { 

//#if 459085944 
this.parent = theParent;
//#endif 

} 

//#endif 


//#if -1170074838 
public String toString()
    { 

//#if -2071928007 
return "Associations";
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

