
//#if -1316171037 
// Compilation Unit of /CollectionUtil.java 
 

//#if 401462387 
package org.argouml.util;
//#endif 


//#if 2034588827 
import java.util.Collection;
//#endif 


//#if -33922789 
import java.util.List;
//#endif 


//#if -1735338200 
public final class CollectionUtil  { 

//#if -959670054 
public static Object getFirstItem(Collection c)
    { 

//#if 1269447903 
if(c instanceof List)//1
{ 

//#if 389575832 
return ((List) c).get(0);
//#endif 

} 

//#endif 


//#if 432663544 
return c.iterator().next();
//#endif 

} 

//#endif 


//#if -55594896 
public static Object getFirstItemOrNull(Collection c)
    { 

//#if -907046081 
if(c.size() == 0)//1
{ 

//#if -1114679142 
return null;
//#endif 

} 

//#endif 


//#if 894695049 
return getFirstItem(c);
//#endif 

} 

//#endif 


//#if 217015733 
private CollectionUtil()
    { 
} 

//#endif 

 } 

//#endif 


//#endif 

