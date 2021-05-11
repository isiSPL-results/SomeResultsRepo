
//#if -1450825528 
// Compilation Unit of /UUIDHelper.java 
 

//#if 1084245247 
package org.argouml.uml;
//#endif 


//#if 2077669092 
import org.argouml.model.Model;
//#endif 


//#if -1300116261 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 567850751 
public final class UUIDHelper  { 

//#if -1215702012 
public static String getNewUUID()
    { 

//#if 1146083722 
return org.argouml.model.UUIDManager.getInstance().getNewUUID();
//#endif 

} 

//#endif 


//#if 1171948548 
public static String getUUID(Object base)
    { 

//#if 1499186910 
if(base instanceof Fig)//1
{ 

//#if 1474535444 
base = ((Fig) base).getOwner();
//#endif 

} 

//#endif 


//#if -462042415 
if(base == null)//1
{ 

//#if 1971991043 
return null;
//#endif 

} 

//#endif 


//#if -491768426 
if(base instanceof CommentEdge)//1
{ 

//#if -1992655881 
return (String) ((CommentEdge) base).getUUID();
//#endif 

} 

//#endif 


//#if -246265850 
return Model.getFacade().getUUID(base);
//#endif 

} 

//#endif 


//#if 523781815 
private UUIDHelper() { 
} 

//#endif 

 } 

//#endif 


//#endif 

