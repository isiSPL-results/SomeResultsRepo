
//#if 1255817612 
// Compilation Unit of /PredicateNotInTrash.java 
 

//#if -1938133776 
package org.argouml.uml;
//#endif 


//#if 1392746162 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 560866466 
public class PredicateNotInTrash implements 
//#if -1880471917 
org.argouml.util.Predicate
//#endif 

, 
//#if 1013537824 
org.tigris.gef.util.Predicate
//#endif 

  { 

//#if 1751696972 
public boolean evaluate(Object obj)
    { 

//#if 571924826 
return !ProjectManager.getManager().getCurrentProject().isInTrash(obj);
//#endif 

} 

//#endif 


//#if 533976665 
@Deprecated
    public boolean predicate(Object obj)
    { 

//#if 1404070669 
return evaluate(obj);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

