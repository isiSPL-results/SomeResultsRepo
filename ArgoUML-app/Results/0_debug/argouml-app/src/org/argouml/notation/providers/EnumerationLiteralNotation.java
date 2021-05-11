
//#if -2134757992 
// Compilation Unit of /EnumerationLiteralNotation.java 
 

//#if 1371949256 
package org.argouml.notation.providers;
//#endif 


//#if 38448918 
import java.beans.PropertyChangeListener;
//#endif 


//#if -1579184334 
import java.util.Collection;
//#endif 


//#if 1907516287 
import org.argouml.model.Model;
//#endif 


//#if 1222964292 
import org.argouml.notation.NotationProvider;
//#endif 


//#if 313802961 
public abstract class EnumerationLiteralNotation extends 
//#if 1960103490 
NotationProvider
//#endif 

  { 

//#if 489407259 
@Override
    public void initialiseListener(PropertyChangeListener listener,
                                   Object modelElement)
    { 

//#if -853166088 
addElementListener(listener, modelElement,
                           new String[] {"remove", "stereotype"} );
//#endif 


//#if -1475846963 
Collection c = Model.getFacade().getStereotypes(modelElement);
//#endif 


//#if -326946037 
for (Object st : c) //1
{ 

//#if -212975827 
addElementListener(listener, st, "name");
//#endif 

} 

//#endif 

} 

//#endif 


//#if -827461792 
public EnumerationLiteralNotation(Object enumLiteral)
    { 

//#if -421895440 
if(!Model.getFacade().isAEnumerationLiteral(enumLiteral))//1
{ 

//#if -1076594070 
throw new IllegalArgumentException(
                "This is not an Enumeration Literal.");
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

