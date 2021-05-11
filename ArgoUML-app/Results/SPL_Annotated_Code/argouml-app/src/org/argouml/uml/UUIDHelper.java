// Compilation Unit of /UUIDHelper.java 
 
package org.argouml.uml;
import org.argouml.model.Model;
import org.tigris.gef.presentation.Fig;
public final class UUIDHelper  { 
public static String getNewUUID()
    { 
return org.argouml.model.UUIDManager.getInstance().getNewUUID();
} 

public static String getUUID(Object base)
    { 
if(base instanceof Fig)//1
{ 
base = ((Fig) base).getOwner();
} 

if(base == null)//1
{ 
return null;
} 

if(base instanceof CommentEdge)//1
{ 
return (String) ((CommentEdge) base).getUUID();
} 

return Model.getFacade().getUUID(base);
} 

private UUIDHelper() { 
} 

 } 


