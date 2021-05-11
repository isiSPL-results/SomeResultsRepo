package org.argouml.util;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class SingleElementIterator<T> implements Iterator
  { 
private boolean done = false;
private T target;
public boolean hasNext()
    { 
if(!done)//1
{ 
return true;
} 
return false;
} 
public void remove()
    { 
throw new UnsupportedOperationException();
} 
public T next()
    { 
if(!done)//1
{ 
done = true;
return target;
} 
throw new NoSuchElementException();
} 
public SingleElementIterator(T o)
    { 
target = o;
} 

 } 
