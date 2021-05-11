// Compilation Unit of /HashBag.java 
 
package org.argouml.profile.internal.ocl.uml14;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
public class HashBag<E> implements Bag<E>
  { 
private Map<E, Integer> map = new HashMap<E, Integer>();
@Override
    public String toString()
    { 
return map.toString();
} 

public boolean removeAll(Collection c)
    { 
boolean changed = false;
for (Object object : c) //1
{ 
changed |= remove(object);
} 

return changed;
} 

public HashBag()
    { 
} 

public Object[] toArray()
    { 
return map.keySet().toArray();
} 

public boolean remove(Object o)
    { 
return (map.remove(o) == null);
} 

public void clear()
    { 
map.clear();
} 

public Iterator<E> iterator()
    { 
return map.keySet().iterator();
} 

@Override
    public boolean equals(Object obj)
    { 
if(obj instanceof Bag)//1
{ 
Bag bag = (Bag) obj;
for (Object object : bag) //1
{ 
if(count(object) != bag.count(object))//1
{ 
return false;
} 

} 

return true;
} 
else
{ 
return false;
} 

} 

public boolean containsAll(Collection c)
    { 
return map.keySet().containsAll(c);
} 

public <T> T[] toArray(T[] a)
    { 
return map.keySet().toArray(a);
} 

public boolean add(E e)
    { 
if(e != null)//1
{ 
if(map.get(e) == null)//1
{ 
map.put(e, 1);
} 
else
{ 
map.put(e, map.get(e) + 1);
} 

} 

return true;
} 

@Override
    public int hashCode()
    { 
return map.hashCode() * 35;
} 

@SuppressWarnings("unchecked")

    public boolean addAll(Collection c)
    { 
for (Object object : c) //1
{ 
add((E) object);
} 

return true;
} 

public boolean retainAll(Collection c)
    { 
throw new UnsupportedOperationException();
} 

public boolean isEmpty()
    { 
return map.isEmpty();
} 

public int size()
    { 
int sum = 0;
for (E e : map.keySet()) //1
{ 
sum += count(e);
} 

return sum;
} 

public HashBag(Collection col)
    { 
this();
addAll(col);
} 

public boolean contains(Object o)
    { 
return map.containsKey(o);
} 

public int count(Object element)
    { 
Integer c = map.get(element);
return c == null ? 0 : c;
} 

 } 


