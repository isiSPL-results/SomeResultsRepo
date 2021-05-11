package org.argouml.profile.internal.ocl.uml14;
import java.util.Collection;
import java.util.Map;
import org.argouml.model.Model;
import org.argouml.profile.internal.ocl.CompositeModelInterpreter;
public class Uml14ModelInterpreter extends CompositeModelInterpreter
  { 
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
