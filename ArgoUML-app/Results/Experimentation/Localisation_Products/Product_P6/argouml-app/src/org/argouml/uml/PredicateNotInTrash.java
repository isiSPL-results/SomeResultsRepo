package org.argouml.uml;
import org.argouml.kernel.ProjectManager;
public class PredicateNotInTrash implements org.argouml.util.Predicate
,org.tigris.gef.util.Predicate
  { 
public boolean evaluate(Object obj)
    { 
return !ProjectManager.getManager().getCurrentProject().isInTrash(obj);
} 
@Deprecated
    public boolean predicate(Object obj)
    { 
return evaluate(obj);
} 

 } 
