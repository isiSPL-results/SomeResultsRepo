
//#if 1228788296 
// Compilation Unit of /HashBag.java 
 

//#if 1410333250 
package org.argouml.profile.internal.ocl.uml14;
//#endif 


//#if -526602023 
import java.util.Collection;
//#endif 


//#if 1229032081 
import java.util.HashMap;
//#endif 


//#if 1451638793 
import java.util.Iterator;
//#endif 


//#if 171847267 
import java.util.Map;
//#endif 


//#if 1014101515 
public class HashBag<E> implements 
//#if -668568810 
Bag<E>
//#endif 

  { 

//#if -1442864185 
private Map<E, Integer> map = new HashMap<E, Integer>();
//#endif 


//#if 810901738 
@Override
    public String toString()
    { 

//#if -807479636 
return map.toString();
//#endif 

} 

//#endif 


//#if 1164256005 
public boolean removeAll(Collection c)
    { 

//#if 665765512 
boolean changed = false;
//#endif 


//#if 1738295375 
for (Object object : c) //1
{ 

//#if -1941009214 
changed |= remove(object);
//#endif 

} 

//#endif 


//#if -964191624 
return changed;
//#endif 

} 

//#endif 


//#if 1229414953 
public HashBag()
    { 
} 

//#endif 


//#if -414056980 
public Object[] toArray()
    { 

//#if 1156664146 
return map.keySet().toArray();
//#endif 

} 

//#endif 


//#if 1448985415 
public boolean remove(Object o)
    { 

//#if 828064698 
return (map.remove(o) == null);
//#endif 

} 

//#endif 


//#if -1403747288 
public void clear()
    { 

//#if 2029624413 
map.clear();
//#endif 

} 

//#endif 


//#if -1489715612 
public Iterator<E> iterator()
    { 

//#if 573227085 
return map.keySet().iterator();
//#endif 

} 

//#endif 


//#if 1226226014 
@Override
    public boolean equals(Object obj)
    { 

//#if 1165430701 
if(obj instanceof Bag)//1
{ 

//#if 1533559906 
Bag bag = (Bag) obj;
//#endif 


//#if -1835810747 
for (Object object : bag) //1
{ 

//#if 949859810 
if(count(object) != bag.count(object))//1
{ 

//#if 735332911 
return false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 177632299 
return true;
//#endif 

} 
else
{ 

//#if -307979354 
return false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2113711392 
public boolean containsAll(Collection c)
    { 

//#if -1989221518 
return map.keySet().containsAll(c);
//#endif 

} 

//#endif 


//#if -128877838 
public <T> T[] toArray(T[] a)
    { 

//#if -1426103833 
return map.keySet().toArray(a);
//#endif 

} 

//#endif 


//#if -1959668148 
public boolean add(E e)
    { 

//#if -1864720487 
if(e != null)//1
{ 

//#if 1267863605 
if(map.get(e) == null)//1
{ 

//#if -187588543 
map.put(e, 1);
//#endif 

} 
else
{ 

//#if 1009743245 
map.put(e, map.get(e) + 1);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2023095433 
return true;
//#endif 

} 

//#endif 


//#if 755149183 
@Override
    public int hashCode()
    { 

//#if -906985201 
return map.hashCode() * 35;
//#endif 

} 

//#endif 


//#if 26213174 

//#if -28138835 
@SuppressWarnings("unchecked")
//#endif 


    public boolean addAll(Collection c)
    { 

//#if -603456957 
for (Object object : c) //1
{ 

//#if -1156404897 
add((E) object);
//#endif 

} 

//#endif 


//#if 178491944 
return true;
//#endif 

} 

//#endif 


//#if 907082118 
public boolean retainAll(Collection c)
    { 

//#if -1333234835 
throw new UnsupportedOperationException();
//#endif 

} 

//#endif 


//#if 1320007662 
public boolean isEmpty()
    { 

//#if -301088098 
return map.isEmpty();
//#endif 

} 

//#endif 


//#if -161125089 
public int size()
    { 

//#if 550988552 
int sum = 0;
//#endif 


//#if 1757042101 
for (E e : map.keySet()) //1
{ 

//#if -2056285141 
sum += count(e);
//#endif 

} 

//#endif 


//#if -1088904572 
return sum;
//#endif 

} 

//#endif 


//#if 2000999 
public HashBag(Collection col)
    { 

//#if 1230187285 
this();
//#endif 


//#if -880605871 
addAll(col);
//#endif 

} 

//#endif 


//#if -1913417332 
public boolean contains(Object o)
    { 

//#if 1460875449 
return map.containsKey(o);
//#endif 

} 

//#endif 


//#if 976472034 
public int count(Object element)
    { 

//#if -324220779 
Integer c = map.get(element);
//#endif 


//#if -1113823670 
return c == null ? 0 : c;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

