// Compilation Unit of /OclAPIModelInterpreter.java 
 
package org.argouml.profile.internal.ocl.uml14;
import java.util.Map;
import org.argouml.model.Model;
import org.argouml.profile.internal.ocl.ModelInterpreter;

//#if LOGGING 
import org.apache.log4j.Logger;
//#endif 

public class OclAPIModelInterpreter implements ModelInterpreter
  { 

//#if LOGGING 
private static final Logger LOG = Logger
                                      .getLogger(OclAPIModelInterpreter.class);
//#endif 

public Object invokeFeature(Map<String, Object> vt, Object subject,
                                String feature, String type, Object[] parameters)
    { 
if(type.equals("."))//1
{ 
if(feature.toString().trim().equals("oclIsKindOf")
                    || feature.toString().trim().equals("oclIsTypeOf"))//1
{ 
String typeName = ((OclType) parameters[0]).getName();
if(typeName.equals("OclAny"))//1
{ 
return true;
} 
else
{ 
return  Model.getFacade().isA(typeName, subject);
} 

} 

if(feature.toString().trim().equals("oclAsType"))//1
{ 
return subject;
} 

if(subject instanceof OclType)//1
{ 
if(feature.toString().trim().equals("name"))//1
{ 
return ((OclType) subject).getName();
} 

} 

if(subject instanceof String)//1
{ 
if(feature.toString().trim().equals("size"))//1
{ 
return ((String) subject).length();
} 

if(feature.toString().trim().equals("concat"))//1
{ 
return ((String) subject).concat((String) parameters[0]);
} 

if(feature.toString().trim().equals("toLower"))//1
{ 
return ((String) subject).toLowerCase();
} 

if(feature.toString().trim().equals("toUpper"))//1
{ 
return ((String) subject).toUpperCase();
} 

if(feature.toString().trim().equals("substring"))//1
{ 
return ((String) subject).substring(
                               (Integer) parameters[0], (Integer) parameters[1]);
} 

} 

} 

return null;
} 

public Object getBuiltInSymbol(String sym)
    { 
if(sym.equals("OclType"))//1
{ 
return new OclType("OclType");
} 
else
if(sym.equals("OclExpression"))//1
{ 
return new OclType("OclExpression");
} 


if(sym.equals("OclAny"))//1
{ 
return new OclType("OclAny");
} 

return null;
} 

 } 


