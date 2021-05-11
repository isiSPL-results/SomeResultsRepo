package org.argouml.notation.providers;
import org.argouml.model.Model;
import org.argouml.notation.NotationProvider;
public abstract class ObjectFlowStateTypeNotation extends NotationProvider
  { 
public ObjectFlowStateTypeNotation(Object objectflowstate)
    { 
if(!Model.getFacade().isAObjectFlowState(objectflowstate))//1
{ 
throw new IllegalArgumentException(
                "This is not a ObjectFlowState.");
} 
} 

 } 
