package org.argouml.notation.providers;
import java.beans.PropertyChangeListener;
import java.util.Collection;
import org.argouml.model.Model;
import org.argouml.notation.NotationProvider;
public abstract class EnumerationLiteralNotation extends NotationProvider
  { 
@Override
    public void initialiseListener(PropertyChangeListener listener,
                                   Object modelElement)
    { 
addElementListener(listener, modelElement,
                           new String[] {"remove", "stereotype"} );
Collection c = Model.getFacade().getStereotypes(modelElement);
for (Object st : c) //1
{ 
addElementListener(listener, st, "name");
} 
} 
public EnumerationLiteralNotation(Object enumLiteral)
    { 
if(!Model.getFacade().isAEnumerationLiteral(enumLiteral))//1
{ 
throw new IllegalArgumentException(
                "This is not an Enumeration Literal.");
} 
} 

 } 
