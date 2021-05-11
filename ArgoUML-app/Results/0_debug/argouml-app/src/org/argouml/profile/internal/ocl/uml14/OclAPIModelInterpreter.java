
//#if -772830233 
// Compilation Unit of /OclAPIModelInterpreter.java 
 

//#if -458539067 
package org.argouml.profile.internal.ocl.uml14;
//#endif 


//#if 1916260774 
import java.util.Map;
//#endif 


//#if -2021246981 
import org.argouml.model.Model;
//#endif 


//#if -1303218676 
import org.argouml.profile.internal.ocl.ModelInterpreter;
//#endif 


//#if 426183816 
import org.apache.log4j.Logger;
//#endif 


//#if -791822912 
public class OclAPIModelInterpreter implements 
//#if -1540088555 
ModelInterpreter
//#endif 

  { 

//#if -1860879939 
private static final Logger LOG = Logger
                                      .getLogger(OclAPIModelInterpreter.class);
//#endif 


//#if -2099022441 
public Object invokeFeature(Map<String, Object> vt, Object subject,
                                String feature, String type, Object[] parameters)
    { 

//#if -213688387 
if(type.equals("."))//1
{ 

//#if 131499814 
if(feature.toString().trim().equals("oclIsKindOf")
                    || feature.toString().trim().equals("oclIsTypeOf"))//1
{ 

//#if 1334941136 
String typeName = ((OclType) parameters[0]).getName();
//#endif 


//#if -2063122228 
if(typeName.equals("OclAny"))//1
{ 

//#if 622769022 
return true;
//#endif 

} 
else
{ 

//#if 12627466 
return  Model.getFacade().isA(typeName, subject);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1986855936 
if(feature.toString().trim().equals("oclAsType"))//1
{ 

//#if -346514532 
return subject;
//#endif 

} 

//#endif 


//#if 1171014874 
if(subject instanceof OclType)//1
{ 

//#if 1380360628 
if(feature.toString().trim().equals("name"))//1
{ 

//#if -1149402035 
return ((OclType) subject).getName();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 758103353 
if(subject instanceof String)//1
{ 

//#if -2037328322 
if(feature.toString().trim().equals("size"))//1
{ 

//#if 1262508895 
return ((String) subject).length();
//#endif 

} 

//#endif 


//#if -1886380143 
if(feature.toString().trim().equals("concat"))//1
{ 

//#if 970789673 
return ((String) subject).concat((String) parameters[0]);
//#endif 

} 

//#endif 


//#if 166107047 
if(feature.toString().trim().equals("toLower"))//1
{ 

//#if -1566928396 
return ((String) subject).toLowerCase();
//#endif 

} 

//#endif 


//#if 744179848 
if(feature.toString().trim().equals("toUpper"))//1
{ 

//#if -519302687 
return ((String) subject).toUpperCase();
//#endif 

} 

//#endif 


//#if -956894222 
if(feature.toString().trim().equals("substring"))//1
{ 

//#if -962380626 
return ((String) subject).substring(
                               (Integer) parameters[0], (Integer) parameters[1]);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -505354810 
return null;
//#endif 

} 

//#endif 


//#if -1364760310 
public Object getBuiltInSymbol(String sym)
    { 

//#if -1199585572 
if(sym.equals("OclType"))//1
{ 

//#if 843102443 
return new OclType("OclType");
//#endif 

} 
else

//#if 1772639423 
if(sym.equals("OclExpression"))//1
{ 

//#if -311668559 
return new OclType("OclExpression");
//#endif 

} 

//#endif 


//#endif 


//#if -959697912 
if(sym.equals("OclAny"))//1
{ 

//#if 2081719046 
return new OclType("OclAny");
//#endif 

} 

//#endif 


//#if 2037740894 
return null;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

