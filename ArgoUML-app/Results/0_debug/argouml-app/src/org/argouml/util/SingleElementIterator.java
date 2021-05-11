
//#if 1222856925 
// Compilation Unit of /SingleElementIterator.java 
 

//#if 441923898 
package org.argouml.util;
//#endif 


//#if -397531036 
import java.util.Iterator;
//#endif 


//#if 560187831 
import java.util.NoSuchElementException;
//#endif 


//#if -2051594385 
public class SingleElementIterator<T> implements 
//#if 365676981 
Iterator
//#endif 

  { 

//#if 193395591 
private boolean done = false;
//#endif 


//#if -1861663374 
private T target;
//#endif 


//#if -1901686634 
public boolean hasNext()
    { 

//#if -1342178787 
if(!done)//1
{ 

//#if 1277132551 
return true;
//#endif 

} 

//#endif 


//#if -129586715 
return false;
//#endif 

} 

//#endif 


//#if -1697505431 
public void remove()
    { 

//#if -1084266096 
throw new UnsupportedOperationException();
//#endif 

} 

//#endif 


//#if 270747960 
public T next()
    { 

//#if 1125950651 
if(!done)//1
{ 

//#if -228598884 
done = true;
//#endif 


//#if 1822329360 
return target;
//#endif 

} 

//#endif 


//#if -216107990 
throw new NoSuchElementException();
//#endif 

} 

//#endif 


//#if 296045944 
public SingleElementIterator(T o)
    { 

//#if -1659872176 
target = o;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

