
//#if -1812412545 
// Compilation Unit of /ModelElementNameNotation.java 
 

//#if 407475992 
package org.argouml.notation.providers;
//#endif 


//#if 892578150 
import java.beans.PropertyChangeListener;
//#endif 


//#if 609288655 
import org.argouml.model.Model;
//#endif 


//#if -1893185900 
import org.argouml.notation.NotationProvider;
//#endif 


//#if 1044556951 
public abstract class ModelElementNameNotation extends 
//#if 108275985 
NotationProvider
//#endif 

  { 

//#if 874334742 
public ModelElementNameNotation(Object modelElement)
    { 

//#if -293640207 
if(!Model.getFacade().isAModelElement(modelElement))//1
{ 

//#if 542329196 
throw new IllegalArgumentException("This is not a ModelElement.");
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1524159206 
public void initialiseListener(PropertyChangeListener listener,
                                   Object modelElement)
    { 

//#if 277063634 
addElementListener(listener, modelElement,
                           new String[] {"name", "visibility"});
//#endif 


//#if -578486073 
Object ns = Model.getFacade().getNamespace(modelElement);
//#endif 


//#if -731467904 
while (ns != null && !Model.getFacade().isAModel(ns)) //1
{ 

//#if -1492777254 
addElementListener(listener, ns,
                               new String[] {"name", "namespace"});
//#endif 


//#if 1901387309 
ns = Model.getFacade().getNamespace(ns);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

