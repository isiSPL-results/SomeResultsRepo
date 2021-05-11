
//#if -896627315 
// Compilation Unit of /ClassifierRoleNotation.java 
 

//#if -307718426 
package org.argouml.notation.providers;
//#endif 


//#if 785509812 
import java.beans.PropertyChangeListener;
//#endif 


//#if -1566513196 
import java.util.Collection;
//#endif 


//#if 1436266397 
import org.argouml.model.Model;
//#endif 


//#if 1280291810 
import org.argouml.notation.NotationProvider;
//#endif 


//#if -1827862462 
public abstract class ClassifierRoleNotation extends 
//#if 877843528 
NotationProvider
//#endif 

  { 

//#if -1516606750 
public ClassifierRoleNotation(Object classifierRole)
    { 

//#if -572299350 
if(!Model.getFacade().isAClassifierRole(classifierRole))//1
{ 

//#if 273599418 
throw new IllegalArgumentException("This is not a ClassifierRole.");
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2141506783 
@Override
    public void initialiseListener(PropertyChangeListener listener,
                                   Object modelElement)
    { 

//#if 775332739 
super.initialiseListener(listener, modelElement);
//#endif 


//#if 1010068838 
Collection classifiers = Model.getFacade().getBases(modelElement);
//#endif 


//#if -5651915 
for (Object c : classifiers) //1
{ 

//#if 1539809686 
addElementListener(listener, c, "name");
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

