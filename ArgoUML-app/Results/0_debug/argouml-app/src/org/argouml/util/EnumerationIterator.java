
//#if -609291739 
// Compilation Unit of /EnumerationIterator.java 
 

//#if 743104475 
package org.argouml.util;
//#endif 


//#if -1929312578 
import java.util.Enumeration;
//#endif 


//#if 349132259 
import java.util.Iterator;
//#endif 


//#if 62351787 
public class EnumerationIterator implements 
//#if -1926421423 
Iterator
//#endif 

  { 

//#if -1476232933 
private Enumeration enumeration;
//#endif 


//#if -313054670 
public boolean hasNext()
    { 

//#if 1515781495 
return enumeration.hasMoreElements();
//#endif 

} 

//#endif 


//#if 791144197 
public void remove()
    { 

//#if -2067297083 
throw new UnsupportedOperationException();
//#endif 

} 

//#endif 


//#if 8218687 
public Object next()
    { 

//#if -396665485 
return enumeration.nextElement();
//#endif 

} 

//#endif 


//#if 392382252 
public EnumerationIterator(Enumeration e)
    { 

//#if 419122095 
enumeration = e;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

