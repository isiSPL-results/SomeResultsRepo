// Compilation Unit of /Uml14ModelInterpreter.java 
 
package org.argouml.profile.internal.ocl.uml14;
import java.util.Collection;
import java.util.Map;
import org.argouml.model.Model;
import org.argouml.profile.internal.ocl.CompositeModelInterpreter;

//#if LOGGING 
import org.apache.log4j.Logger;
//#endif 

public class Uml14ModelInterpreter extends CompositeModelInterpreter
  { 

//#if LOGGING 
private static final Logger LOG = Logger
                                      .getLogger(Uml14ModelInterpreter.class);
//#endif 

private String toString(Object obj)
    { 
if(Model.getFacade().isAModelElement(obj))//1
{ 
return Model.getFacade().getName(obj);
} 
else
if(obj instanceof Collection)//1
{ 
return colToString((Collection) obj);
} 
else
{ 
return "" + obj;
} 


} 

public Uml14ModelInterpreter()
    { 
addModelInterpreter(new ModelAccessModelInterpreter());
addModelInterpreter(new OclAPIModelInterpreter());
addModelInterpreter(new CollectionsModelInterpreter());
} 

private String colToString(Collection collection)
    { 
String ret = "[";
for (Object object : collection) //1
{ 
ret += toString(object) + ",";
} 

return ret + "]";
} 

 } 


