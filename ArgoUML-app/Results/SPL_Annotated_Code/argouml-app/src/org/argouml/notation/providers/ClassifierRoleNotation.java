// Compilation Unit of /ClassifierRoleNotation.java 
 
package org.argouml.notation.providers;
import java.beans.PropertyChangeListener;
import java.util.Collection;
import org.argouml.model.Model;
import org.argouml.notation.NotationProvider;
public abstract class ClassifierRoleNotation extends NotationProvider
  { 
public ClassifierRoleNotation(Object classifierRole)
    { 
if(!Model.getFacade().isAClassifierRole(classifierRole))//1
{ 
throw new IllegalArgumentException("This is not a ClassifierRole.");
} 

} 

@Override
    public void initialiseListener(PropertyChangeListener listener,
                                   Object modelElement)
    { 
super.initialiseListener(listener, modelElement);
Collection classifiers = Model.getFacade().getBases(modelElement);
for (Object c : classifiers) //1
{ 
addElementListener(listener, c, "name");
} 

} 

 } 


