
//#if -1527505428 
// Compilation Unit of /PredIsStartState.java 
 

//#if 1762014476 
package org.argouml.uml.diagram.state;
//#endif 


//#if 36682799 
import org.argouml.model.Model;
//#endif 


//#if 973601195 
import org.tigris.gef.util.Predicate;
//#endif 


//#if 1153964307 
public class PredIsStartState implements 
//#if -802605290 
Predicate
//#endif 

  { 

//#if -507689407 
private static PredIsStartState theInstance = new PredIsStartState();
//#endif 


//#if 999690912 
public boolean predicate(Object obj)
    { 

//#if -1591632068 
return (Model.getFacade().isAPseudostate(obj))
               && (Model.getPseudostateKind().getInitial().equals(
                       Model.getFacade().getKind(obj)));
//#endif 

} 

//#endif 


//#if 1752103715 
public static PredIsStartState getTheInstance()
    { 

//#if -1526047611 
return theInstance;
//#endif 

} 

//#endif 


//#if -847694915 
private PredIsStartState() { 
} 

//#endif 

 } 

//#endif 


//#endif 

