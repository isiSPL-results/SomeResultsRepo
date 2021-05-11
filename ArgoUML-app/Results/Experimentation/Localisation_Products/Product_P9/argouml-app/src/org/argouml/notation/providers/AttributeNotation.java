package org.argouml.notation.providers;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.argouml.model.AddAssociationEvent;
import org.argouml.model.Model;
import org.argouml.model.RemoveAssociationEvent;
import org.argouml.notation.NotationProvider;
public abstract class AttributeNotation extends NotationProvider
  { 
protected AttributeNotation()
    { 
} 
@Override
    public void initialiseListener(PropertyChangeListener listener,
                                   Object modelElement)
    { 
addElementListener(listener, modelElement);
if(Model.getFacade().isAAttribute(modelElement))//1
{ 
for (Object uml : Model.getFacade().getStereotypes(modelElement)) //1
{ 
addElementListener(listener, uml);
} 
Object type = Model.getFacade().getType(modelElement);
if(type != null)//1
{ 
addElementListener(listener, type);
} 
} 
} 
@Override
    public void updateListener(PropertyChangeListener listener,
                               Object modelElement, PropertyChangeEvent pce)
    { 
if(pce.getSource() == modelElement
                && ("stereotype".equals(pce.getPropertyName())
                    || ("type".equals(pce.getPropertyName()))))//1
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
