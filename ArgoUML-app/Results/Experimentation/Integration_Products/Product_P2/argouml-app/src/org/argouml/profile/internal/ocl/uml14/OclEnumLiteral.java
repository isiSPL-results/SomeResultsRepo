package org.argouml.profile.internal.ocl.uml14;
import org.argouml.model.Model;
public class OclEnumLiteral  { 
private String name;
public OclEnumLiteral(String literalName)
    { 
this.name = literalName;
} 
public int hashCode()
    { 
return name.hashCode();
} 
public boolean equals(Object obj)
    { 
if(obj instanceof OclEnumLiteral)//1
{ 
return name.equals(((OclEnumLiteral) obj).name);
} 
else
if(Model.getFacade().isAEnumerationLiteral(obj))//1
{ 
return name.equals(Model.getFacade().getName(obj));
} 
else
{ 
return false;
} 
} 

 } 
