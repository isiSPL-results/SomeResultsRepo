
//#if 333443542 
// Compilation Unit of /AssociationNameNotation.java 
 

//#if 1000620885 
package org.argouml.notation.providers;
//#endif 


//#if -325830045 
import java.beans.PropertyChangeListener;
//#endif 


//#if 877963973 
import java.util.Collection;
//#endif 


//#if 1435223285 
import java.util.Iterator;
//#endif 


//#if -609862900 
import org.argouml.model.Model;
//#endif 


//#if -1850863343 
import org.argouml.notation.NotationProvider;
//#endif 


//#if -511600652 
public abstract class AssociationNameNotation extends 
//#if -2100328744 
NotationProvider
//#endif 

  { 

//#if -1590328209 
public AssociationNameNotation(Object modelElement)
    { 

//#if -1070728177 
if(!Model.getFacade().isAAssociation(modelElement))//1
{ 

//#if 423826640 
throw new IllegalArgumentException("This is not an Association.");
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2059521421 
public void initialiseListener(PropertyChangeListener listener,
                                   Object modelElement)
    { 

//#if -1254084898 
addElementListener(listener, modelElement,
                           new String[] {"name", "visibility", "stereotype"});
//#endif 


//#if -1941922272 
Collection stereotypes =
            Model.getFacade().getStereotypes(modelElement);
//#endif 


//#if 1464926990 
Iterator iter = stereotypes.iterator();
//#endif 


//#if 1610426621 
while (iter.hasNext()) //1
{ 

//#if 1089549679 
Object oneStereoType = iter.next();
//#endif 


//#if 1328396561 
addElementListener(
                listener,
                oneStereoType,
                new String[] {"name", "remove"});
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

