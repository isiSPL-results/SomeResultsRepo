
//#if 666282542 
// Compilation Unit of /CompositeModelInterpreter.java 
 

//#if -1572667127 
package org.argouml.profile.internal.ocl;
//#endif 


//#if 1848377769 
import java.util.HashSet;
//#endif 


//#if -111199551 
import java.util.Map;
//#endif 


//#if -111016837 
import java.util.Set;
//#endif 


//#if -1184486394 
public class CompositeModelInterpreter implements 
//#if 1278573782 
ModelInterpreter
//#endif 

  { 

//#if 136974405 
private Set<ModelInterpreter> set = new HashSet<ModelInterpreter>();
//#endif 


//#if 1562462788 
public void addModelInterpreter(ModelInterpreter mi)
    { 

//#if -276849447 
set.add(mi);
//#endif 

} 

//#endif 


//#if 1139288310 
public Object invokeFeature(Map<String, Object> vt, Object subject,
                                String feature, String type, Object[] parameters)
    { 

//#if -890127996 
for (ModelInterpreter mi : set) //1
{ 

//#if -224973967 
Object ret = mi.invokeFeature(vt, subject, feature, type,
                                          parameters);
//#endif 


//#if 754937019 
if(ret != null)//1
{ 

//#if -332574926 
return ret;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 192704284 
return null;
//#endif 

} 

//#endif 


//#if 649584681 
public Object getBuiltInSymbol(String sym)
    { 

//#if -1397712204 
for (ModelInterpreter mi : set) //1
{ 

//#if 1375443919 
Object ret = mi.getBuiltInSymbol(sym);
//#endif 


//#if 134872703 
if(ret != null)//1
{ 

//#if -841308730 
return ret;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 422591468 
return null;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

