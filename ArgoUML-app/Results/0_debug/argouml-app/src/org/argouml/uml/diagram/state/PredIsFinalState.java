
//#if 552076070 
// Compilation Unit of /PredIsFinalState.java 
 

//#if -1855961098 
package org.argouml.uml.diagram.state;
//#endif 


//#if 823835781 
import org.argouml.model.Model;
//#endif 


//#if 302702977 
import org.tigris.gef.util.Predicate;
//#endif 


//#if -163973143 
public class PredIsFinalState implements 
//#if 1351486715 
Predicate
//#endif 

  { 

//#if -1500480538 
private static PredIsFinalState theInstance = new PredIsFinalState();
//#endif 


//#if 1753098890 
public static PredIsFinalState getTheInstance()
    { 

//#if -1440377902 
return theInstance;
//#endif 

} 

//#endif 


//#if 1061210501 
public boolean predicate(Object obj)
    { 

//#if 1041725735 
return (Model.getFacade().isAFinalState(obj));
//#endif 

} 

//#endif 


//#if 164922382 
private PredIsFinalState() { 
} 

//#endif 

 } 

//#endif 


//#endif 

