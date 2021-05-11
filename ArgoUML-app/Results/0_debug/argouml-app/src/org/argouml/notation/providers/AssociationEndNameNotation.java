
//#if -1908444921 
// Compilation Unit of /AssociationEndNameNotation.java 
 

//#if -1830788477 
package org.argouml.notation.providers;
//#endif 


//#if 958396695 
import java.beans.PropertyChangeEvent;
//#endif 


//#if 1699038737 
import java.beans.PropertyChangeListener;
//#endif 


//#if -1649132457 
import java.util.Collection;
//#endif 


//#if -1972989177 
import java.util.Iterator;
//#endif 


//#if -258715095 
import org.argouml.model.AddAssociationEvent;
//#endif 


//#if 1142122554 
import org.argouml.model.Model;
//#endif 


//#if 2015901590 
import org.argouml.model.RemoveAssociationEvent;
//#endif 


//#if -294283841 
import org.argouml.notation.NotationProvider;
//#endif 


//#if -1471599725 
public abstract class AssociationEndNameNotation extends 
//#if -2100586718 
NotationProvider
//#endif 

  { 

//#if 427948007 
protected AssociationEndNameNotation()
    { 
} 

//#endif 


//#if -816625710 
public void updateListener(PropertyChangeListener listener,
                               Object modelElement,
                               PropertyChangeEvent pce)
    { 

//#if -1894757298 
Object obj = pce.getSource();
//#endif 


//#if -1166954753 
if((obj == modelElement)
                && "stereotype".equals(pce.getPropertyName()))//1
{ 

//#if 1396026157 
if(pce instanceof AddAssociationEvent
                    && Model.getFacade().isAStereotype(pce.getNewValue()))//1
{ 

//#if -281786394 
addElementListener(
                    listener,
                    pce.getNewValue(),
                    new String[] {"name", "remove"});
//#endif 

} 

//#endif 


//#if 515561181 
if(pce instanceof RemoveAssociationEvent
                    && Model.getFacade().isAStereotype(pce.getOldValue()))//1
{ 

//#if -2032639848 
removeElementListener(
                    listener,
                    pce.getOldValue());
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 235618537 
public void initialiseListener(PropertyChangeListener listener,
                                   Object modelElement)
    { 

//#if 2101190701 
addElementListener(
            listener,
            modelElement,
            new String[] {"name", "visibility", "stereotype"});
//#endif 


//#if 132942129 
Collection stereotypes =
            Model.getFacade().getStereotypes(modelElement);
//#endif 


//#if -627446307 
Iterator iter = stereotypes.iterator();
//#endif 


//#if -1716743604 
while (iter.hasNext()) //1
{ 

//#if 805429318 
Object o = iter.next();
//#endif 


//#if 2109124008 
addElementListener(
                listener,
                o,
                new String[] {"name", "remove"});
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

