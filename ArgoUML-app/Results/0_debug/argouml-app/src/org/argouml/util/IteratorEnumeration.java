
//#if -1037830444 
// Compilation Unit of /IteratorEnumeration.java 
 

//#if -1931169915 
package org.argouml.util;
//#endif 


//#if 1735848296 
import java.util.Enumeration;
//#endif 


//#if -948995207 
import java.util.Iterator;
//#endif 


//#if 348262925 
public class IteratorEnumeration<T> implements 
//#if 998327076 
Enumeration<T>
//#endif 

  { 

//#if 2113716918 
private Iterator<T> it;
//#endif 


//#if -1690143763 
public boolean hasMoreElements()
    { 

//#if -948112802 
return it.hasNext();
//#endif 

} 

//#endif 


//#if -1733592704 
public IteratorEnumeration(Iterator<T> iterator)
    { 

//#if 1813682477 
it = iterator;
//#endif 

} 

//#endif 


//#if -177540764 
public T nextElement()
    { 

//#if -1639732440 
return it.next();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

