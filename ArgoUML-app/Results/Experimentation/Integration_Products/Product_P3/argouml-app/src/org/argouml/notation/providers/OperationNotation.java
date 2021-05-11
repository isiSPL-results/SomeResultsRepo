package org.argouml.notation.providers;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.argouml.model.AddAssociationEvent;
import org.argouml.model.Model;
import org.argouml.model.RemoveAssociationEvent;
import org.argouml.notation.NotationProvider;
public abstract class OperationNotation extends NotationProvider
  { 
@Override
    public void updateListener(PropertyChangeListener listener,
                               Object modelElement, PropertyChangeEvent pce)
    { 
if(pce.getSource() == modelElement
                && ("stereotype".equals(pce.getPropertyName())
                    || "parameter".equals(pce.getPropertyName())
                    || "taggedValue".equals(pce.getPropertyName())))//1
{ 
if(pce instanceof AddAssociationEvent)//1
{ 
addElementListener(listener, pce.getNewValue());
} 
if(pce instanceof RemoveAssociationEvent)//1
{ 
removeElementListener(listener, pce.getOldValue());
} 
} 
if(!Model.getUmlFactory().isRemoved(modelElement))//1
{ 
for (Object param : Model.getFacade().getParameters(modelElement)) //1
{ 
if(pce.getSource() == param
                        && ("type".equals(pce.getPropertyName())))//1
{ 
if(pce instanceof AddAssociationEvent)//1
{ 
addElementListener(listener, pce.getNewValue());
} 
if(pce instanceof RemoveAssociationEvent)//1
{ 
removeElementListener(listener, pce.getOldValue());
} 
} 
} 
} 
} 
public OperationNotation(Object operation)
    { 
if(!Model.getFacade().isAOperation(operation)
                && !Model.getFacade().isAReception(operation))//1
{ 
throw new IllegalArgumentException(
                "This is not an Operation or Reception.");
} 
} 
@Override
    public void initialiseListener(PropertyChangeListener listener,
                                   Object modelElement)
    { 
addElementListener(listener, modelElement);
if(Model.getFacade().isAOperation(modelElement))//1
{ 
for (Object uml : Model.getFacade().getStereotypes(modelElement)) //1
{ 
addElementListener(listener, uml);
} 
for (Object uml : Model.getFacade().getParameters(modelElement)) //1
{ 
addElementListener(listener, uml);
Object type = Model.getFacade().getType(uml);
if(type != null)//1
{ 
addElementListener(listener, type);
} 
} 
for (Object uml : Model.getFacade()
                    .getTaggedValuesCollection(modelElement)) //1
{ 
addElementListener(listener, uml);
} 
} 
} 

 } 
