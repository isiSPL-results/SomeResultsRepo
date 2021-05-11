
//#if 937303385 
// Compilation Unit of /Uml14ModelInterpreter.java 
 

//#if -1961723078 
package org.argouml.profile.internal.ocl.uml14;
//#endif 


//#if -1173380383 
import java.util.Collection;
//#endif 


//#if 1677981019 
import java.util.Map;
//#endif 


//#if 880082288 
import org.argouml.model.Model;
//#endif 


//#if 851321964 
import org.argouml.profile.internal.ocl.CompositeModelInterpreter;
//#endif 


//#if -967454211 
import org.apache.log4j.Logger;
//#endif 


//#if 1609136656 
public class Uml14ModelInterpreter extends 
//#if -941458873 
CompositeModelInterpreter
//#endif 

  { 

//#if 245654915 
private static final Logger LOG = Logger
                                      .getLogger(Uml14ModelInterpreter.class);
//#endif 


//#if 685786410 
private String toString(Object obj)
    { 

//#if -545373112 
if(Model.getFacade().isAModelElement(obj))//1
{ 

//#if -1860845878 
return Model.getFacade().getName(obj);
//#endif 

} 
else

//#if -422237270 
if(obj instanceof Collection)//1
{ 

//#if -2090760496 
return colToString((Collection) obj);
//#endif 

} 
else
{ 

//#if -563529925 
return "" + obj;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -473352017 
public Uml14ModelInterpreter()
    { 

//#if -413401240 
addModelInterpreter(new ModelAccessModelInterpreter());
//#endif 


//#if -958812465 
addModelInterpreter(new OclAPIModelInterpreter());
//#endif 


//#if -1733171440 
addModelInterpreter(new CollectionsModelInterpreter());
//#endif 

} 

//#endif 


//#if 230691822 
private String colToString(Collection collection)
    { 

//#if 307926891 
String ret = "[";
//#endif 


//#if 841979511 
for (Object object : collection) //1
{ 

//#if -1880774819 
ret += toString(object) + ",";
//#endif 

} 

//#endif 


//#if 1521187290 
return ret + "]";
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

