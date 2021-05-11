// Compilation Unit of /EnumerationIterator.java 
 
package org.argouml.util;
import java.util.Enumeration;
import java.util.Iterator;
public class EnumerationIterator implements Iterator
  { 
private Enumeration enumeration;
public boolean hasNext()
    { 
return enumeration.hasMoreElements();
} 

public void remove()
    { 
throw new UnsupportedOperationException();
} 

public Object next()
    { 
return enumeration.nextElement();
} 

public EnumerationIterator(Enumeration e)
    { 
enumeration = e;
} 

 } 


