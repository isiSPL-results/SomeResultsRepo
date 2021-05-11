
//#if -1010869999 
// Compilation Unit of /ObjectNotation.java 
 

//#if -82943861 
package org.argouml.notation.providers;
//#endif 


//#if 599136783 
import java.beans.PropertyChangeEvent;
//#endif 


//#if 2045501977 
import java.beans.PropertyChangeListener;
//#endif 


//#if 492352335 
import java.util.Collection;
//#endif 


//#if 1680631807 
import java.util.Iterator;
//#endif 


//#if -709153955 
import org.argouml.model.AttributeChangeEvent;
//#endif 


//#if 671346242 
import org.argouml.model.Model;
//#endif 


//#if -690033209 
import org.argouml.notation.NotationProvider;
//#endif 


//#if 1038748037 
public abstract class ObjectNotation extends 
//#if 583609264 
NotationProvider
//#endif 

  { 

//#if -1790136679 
public ObjectNotation(Object theObject)
    { 

//#if -362771877 
if(!Model.getFacade().isAObject(theObject))//1
{ 

//#if 1855655238 
throw new IllegalArgumentException("This is not an Object.");
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1837411685 
public void initialiseListener(PropertyChangeListener listener,
                                   Object modelElement)
    { 

//#if -1859567025 
addElementListener(listener, modelElement,
                           new String[] {"name", "classifier"});
//#endif 


//#if 1782916235 
Collection c = Model.getFacade().getClassifiers(modelElement);
//#endif 


//#if -820429517 
Iterator i = c.iterator();
//#endif 


//#if -1725151730 
while (i.hasNext()) //1
{ 

//#if -767649371 
Object st = i.next();
//#endif 


//#if 1699888211 
addElementListener(listener, st, "name");
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1655088352 
public void updateListener(PropertyChangeListener listener,
                               Object modelElement, PropertyChangeEvent pce)
    { 

//#if 862427951 
if(pce instanceof AttributeChangeEvent
                && pce.getSource() == modelElement
                && "classifier".equals(pce.getPropertyName()))//1
{ 

//#if -239850956 
if(pce.getOldValue() != null)//1
{ 

//#if 1777905118 
removeElementListener(listener, pce.getOldValue());
//#endif 

} 

//#endif 


//#if 20803547 
if(pce.getNewValue() != null)//1
{ 

//#if -1096909214 
addElementListener(listener, pce.getNewValue(), "name");
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

