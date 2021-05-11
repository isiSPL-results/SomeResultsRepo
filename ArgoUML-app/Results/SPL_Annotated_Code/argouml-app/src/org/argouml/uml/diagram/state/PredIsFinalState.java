// Compilation Unit of /PredIsFinalState.java 
 
package org.argouml.uml.diagram.state;
import org.argouml.model.Model;
import org.tigris.gef.util.Predicate;
public class PredIsFinalState implements Predicate
  { 
private static PredIsFinalState theInstance = new PredIsFinalState();
public static PredIsFinalState getTheInstance()
    { 
return theInstance;
} 

public boolean predicate(Object obj)
    { 
return (Model.getFacade().isAFinalState(obj));
} 

private PredIsFinalState() { 
} 

 } 


