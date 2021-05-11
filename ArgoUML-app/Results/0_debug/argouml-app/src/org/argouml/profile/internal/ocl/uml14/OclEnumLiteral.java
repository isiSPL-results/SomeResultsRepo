
//#if -978016167 
// Compilation Unit of /OclEnumLiteral.java 
 

//#if -1097740755 
package org.argouml.profile.internal.ocl.uml14;
//#endif 


//#if -51997085 
import org.argouml.model.Model;
//#endif 


//#if 828616187 
public class OclEnumLiteral  { 

//#if 1747669903 
private String name;
//#endif 


//#if -984443530 
public OclEnumLiteral(String literalName)
    { 

//#if 1923807812 
this.name = literalName;
//#endif 

} 

//#endif 


//#if 103909039 
public int hashCode()
    { 

//#if -1145151022 
return name.hashCode();
//#endif 

} 

//#endif 


//#if 1413135918 
public boolean equals(Object obj)
    { 

//#if 1239583941 
if(obj instanceof OclEnumLiteral)//1
{ 

//#if -78875888 
return name.equals(((OclEnumLiteral) obj).name);
//#endif 

} 
else

//#if -1638272637 
if(Model.getFacade().isAEnumerationLiteral(obj))//1
{ 

//#if 2082832222 
return name.equals(Model.getFacade().getName(obj));
//#endif 

} 
else
{ 

//#if 2064056383 
return false;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

