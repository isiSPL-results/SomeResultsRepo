package org.argouml.uml.diagram.state;
import org.argouml.model.Model;
import org.tigris.gef.util.Predicate;
public class PredIsStartState implements Predicate
  { 
private static PredIsStartState theInstance = new PredIsStartState();
public boolean predicate(Object obj)
    { 
return (Model.getFacade().isAPseudostate(obj))
               && (Model.getPseudostateKind().getInitial().equals(
                       Model.getFacade().getKind(obj)));
} 
public static PredIsStartState getTheInstance()
    { 
return theInstance;
} 
private PredIsStartState() { 
} 

 } 
