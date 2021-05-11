package org.argouml.util;
import java.util.Enumeration;
import java.util.Iterator;
public class IteratorEnumeration<T> implements Enumeration<T>
  { 
private Iterator<T> it;
public boolean hasMoreElements()
    { 
return it.hasNext();
} 
public IteratorEnumeration(Iterator<T> iterator)
    { 
it = iterator;
} 
public T nextElement()
    { 
return it.next();
} 

 } 
