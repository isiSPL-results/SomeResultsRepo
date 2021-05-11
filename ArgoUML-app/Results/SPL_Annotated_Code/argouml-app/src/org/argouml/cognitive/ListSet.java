// Compilation Unit of /ListSet.java 
 

//#if COGNITIVE 
package org.argouml.cognitive;
//#endif 


//#if COGNITIVE 
import java.io.Serializable;
//#endif 


//#if COGNITIVE 
import java.util.ArrayList;
//#endif 


//#if COGNITIVE 
import java.util.Collection;
//#endif 


//#if COGNITIVE 
import java.util.Collections;
//#endif 


//#if COGNITIVE 
import java.util.Enumeration;
//#endif 


//#if COGNITIVE 
import java.util.HashSet;
//#endif 


//#if COGNITIVE 
import java.util.Iterator;
//#endif 


//#if COGNITIVE 
import java.util.List;
//#endif 


//#if COGNITIVE 
import java.util.ListIterator;
//#endif 


//#if COGNITIVE 
import java.util.Set;
//#endif 


//#if COGNITIVE 
public class ListSet<T extends Object> implements Serializable
, Set<T>
, List<T>
  { 
private static final int TC_LIMIT = 50;
private List<T> list;
private Set<T> set;
private final Object mutex = new Object();
public void add(int arg0, T arg1)
    { 
synchronized (mutex) //1
{ 
if(!set.contains(arg1))//1
{ 
list.add(arg0, arg1);
} 

} 

} 

public ListSet(T o1)
    { 
list = Collections.synchronizedList(new ArrayList<T>());
set = new HashSet<T>();
add(o1);
} 

public boolean add(T arg0)
    { 
synchronized (mutex) //1
{ 
boolean result = set.contains(arg0);
if(!result)//1
{ 
set.add(arg0);
list.add(arg0);
} 

return !result;
} 

} 

public Iterator<T> iterator()
    { 
return list.iterator();
} 

public void clear()
    { 
synchronized (mutex) //1
{ 
list.clear();
set.clear();
} 

} 

public void addAllElementsSuchThat(Iterator<T> iter,
                                       org.argouml.util.Predicate p)
    { 
if(p instanceof org.argouml.util.PredicateTrue)//1
{ 
addAllElements(iter);
} 
else
{ 
while (iter.hasNext()) //1
{ 
T e = iter.next();
if(p.evaluate(e))//1
{ 
add(e);
} 

} 

} 

} 

public ListSet<T> transitiveClosure(org.argouml.util.ChildGenerator cg)
    { 
return transitiveClosure(cg, TC_LIMIT,
                                 org.argouml.util.PredicateTrue.getInstance());
} 

public boolean addAll(Collection< ? extends T> arg0)
    { 
return list.addAll(arg0);
} 

public ListIterator<T> listIterator(int index)
    { 
return list.listIterator(index);
} 

public void addAllElements(Iterator<T> iter)
    { 
while (iter.hasNext()) //1
{ 
add(iter.next());
} 

} 

public <A> A[] toArray(A[] arg0)
    { 
return list.toArray(arg0);
} 

public int size()
    { 
return list.size();
} 

public void addAllElements(Enumeration<T> iter)
    { 
while (iter.hasMoreElements()) //1
{ 
add(iter.nextElement());
} 

} 

public boolean retainAll(Collection< ? > arg0)
    { 
return list.retainAll(arg0);
} 

public boolean removeAll(Collection arg0)
    { 
boolean result = false;
for (Iterator iter = arg0.iterator(); iter.hasNext();) //1
{ 
result = result || remove(iter.next());
} 

return result;
} 

public int indexOf(Object o)
    { 
return list.indexOf(o);
} 

public T get(int index)
    { 
return list.get(index);
} 

public Object findSuchThat(org.argouml.util.Predicate p)
    { 
synchronized (list) //1
{ 
for (Object o : list) //1
{ 
if(p.evaluate(o))//1
{ 
return o;
} 

} 

} 

return null;
} 

@Override
    public String toString()
    { 
StringBuilder sb = new StringBuilder("Set{");
synchronized (list) //1
{ 
for (Iterator it = iterator(); it.hasNext();) //1
{ 
sb.append(it.next());
if(it.hasNext())//1
{ 
sb.append(", ");
} 

} 

} 

sb.append("}");
return sb.toString();
} 

public boolean isEmpty()
    { 
return list.isEmpty();
} 

public boolean containsSuchThat(org.argouml.util.Predicate p)
    { 
return findSuchThat(p) != null;
} 

public void removeAllElements()
    { 
clear();
} 

public int lastIndexOf(Object o)
    { 
return list.lastIndexOf(o);
} 

public boolean remove(Object o)
    { 
synchronized (mutex) //1
{ 
boolean result = contains(o);
if(o != null)//1
{ 
list.remove(o);
set.remove(o);
} 

return result;
} 

} 

public T remove(int index)
    { 
synchronized (mutex) //1
{ 
T removedElement = list.remove(index);
set.remove(removedElement);
return removedElement;
} 

} 

@Override
    public boolean equals(Object o)
    { 
if(!(o instanceof ListSet))//1
{ 
return false;
} 

ListSet set = (ListSet) o;
if(set.size() != size())//1
{ 
return false;
} 

synchronized (list) //1
{ 
for (Object obj : list) //1
{ 
if(!(set.contains(obj)))//1
{ 
return false;
} 

} 

} 

return true;
} 

public boolean contains(Object o)
    { 
synchronized (mutex) //1
{ 
if(o != null)//1
{ 
return set.contains(o);
} 

} 

return false;
} 

public boolean containsAll(Collection arg0)
    { 
synchronized (mutex) //1
{ 
return set.containsAll(arg0);
} 

} 

public T set(int arg0, T o)
    { 
throw new UnsupportedOperationException("set() method not supported");
} 

public List<T> subList(int fromIndex, int toIndex)
    { 
return subList(fromIndex, toIndex);
} 

public ListSet()
    { 
list =  Collections.synchronizedList(new ArrayList<T>());
set = new HashSet<T>();
} 

public ListSet(int n)
    { 
list = Collections.synchronizedList(new ArrayList<T>(n));
set = new HashSet<T>(n);
} 

public void addAllElementsSuchThat(ListSet<T> s,
                                       org.argouml.util.Predicate p)
    { 
synchronized (s.mutex()) //1
{ 
addAllElementsSuchThat(s.iterator(), p);
} 

} 

public ListSet<T> reachable(org.argouml.util.ChildGenerator cg)
    { 
return reachable(cg, TC_LIMIT,
                         org.argouml.util.PredicateTrue.getInstance());
} 

public ListSet<T> transitiveClosure(org.argouml.util.ChildGenerator cg,
                                        int max, org.argouml.util.Predicate predicate)
    { 
int iterCount = 0;
int lastSize = -1;
ListSet<T> touched = new ListSet<T>();
ListSet<T> frontier;
ListSet<T> recent = this;
touched.addAll(this);
while ((iterCount < max) && (touched.size() > lastSize)) //1
{ 
iterCount++;
lastSize = touched.size();
frontier = new ListSet<T>();
synchronized (recent) //1
{ 
for (T recentElement : recent) //1
{ 
Iterator frontierChildren = cg.childIterator(recentElement);
frontier.addAllElementsSuchThat(frontierChildren,
                                                    predicate);
} 

} 

touched.addAll(frontier);
recent = frontier;
} 

return touched;
} 

@Override
    public int hashCode()
    { 
return 0;
} 

public void removeElement(Object o)
    { 
if(o != null)//1
{ 
list.remove(o);
} 

} 

public Object mutex()
    { 
return list;
} 

public ListSet<T> reachable(org.argouml.util.ChildGenerator cg, int max,
                                org.argouml.util.Predicate predicate)
    { 
ListSet<T> kids = new ListSet<T>();
synchronized (list) //1
{ 
for (Object r : list) //1
{ 
kids.addAllElementsSuchThat(cg.childIterator(r), predicate);
} 

} 

return kids.transitiveClosure(cg, max, predicate);
} 

public boolean addAll(int arg0, Collection< ? extends T> arg1)
    { 
return list.addAll(arg0, arg1);
} 

public Object[] toArray()
    { 
return list.toArray();
} 

public ListIterator<T> listIterator()
    { 
return list.listIterator();
} 

 } 

//#endif 


