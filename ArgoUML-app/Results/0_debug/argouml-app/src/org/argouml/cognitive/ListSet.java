
//#if 1688185586 
// Compilation Unit of /ListSet.java 
 

//#if -1014368390 
package org.argouml.cognitive;
//#endif 


//#if -220581551 
import java.io.Serializable;
//#endif 


//#if -76979885 
import java.util.ArrayList;
//#endif 


//#if -1046778258 
import java.util.Collection;
//#endif 


//#if 1909614165 
import java.util.Collections;
//#endif 


//#if 282335203 
import java.util.Enumeration;
//#endif 


//#if 1163888342 
import java.util.HashSet;
//#endif 


//#if -573481250 
import java.util.Iterator;
//#endif 


//#if -43315922 
import java.util.List;
//#endif 


//#if 1426820960 
import java.util.ListIterator;
//#endif 


//#if -1386665944 
import java.util.Set;
//#endif 


//#if -1104103747 
public class ListSet<T extends Object> implements 
//#if -1026184650 
Serializable
//#endif 

, 
//#if 1305248379 
Set<T>
//#endif 

, 
//#if 5674673 
List<T>
//#endif 

  { 

//#if 582013857 
private static final int TC_LIMIT = 50;
//#endif 


//#if 1216789057 
private List<T> list;
//#endif 


//#if 1654668617 
private Set<T> set;
//#endif 


//#if -658681310 
private final Object mutex = new Object();
//#endif 


//#if -10134056 
public void add(int arg0, T arg1)
    { 

//#if 763519987 
synchronized (mutex) //1
{ 

//#if -1363821063 
if(!set.contains(arg1))//1
{ 

//#if 1319936332 
list.add(arg0, arg1);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 98896535 
public ListSet(T o1)
    { 

//#if -886021282 
list = Collections.synchronizedList(new ArrayList<T>());
//#endif 


//#if 1856031465 
set = new HashSet<T>();
//#endif 


//#if -452545887 
add(o1);
//#endif 

} 

//#endif 


//#if -2099134774 
public boolean add(T arg0)
    { 

//#if -549432012 
synchronized (mutex) //1
{ 

//#if -1344026797 
boolean result = set.contains(arg0);
//#endif 


//#if 2031294905 
if(!result)//1
{ 

//#if -1136650235 
set.add(arg0);
//#endif 


//#if -116165507 
list.add(arg0);
//#endif 

} 

//#endif 


//#if -455330581 
return !result;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -867822713 
public Iterator<T> iterator()
    { 

//#if 1464650817 
return list.iterator();
//#endif 

} 

//#endif 


//#if 1498699578 
public void clear()
    { 

//#if 1149629960 
synchronized (mutex) //1
{ 

//#if 1278021042 
list.clear();
//#endif 


//#if 188642020 
set.clear();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 482282444 
public void addAllElementsSuchThat(Iterator<T> iter,
                                       org.argouml.util.Predicate p)
    { 

//#if -583189927 
if(p instanceof org.argouml.util.PredicateTrue)//1
{ 

//#if 1562108245 
addAllElements(iter);
//#endif 

} 
else
{ 

//#if -1750741055 
while (iter.hasNext()) //1
{ 

//#if -144555733 
T e = iter.next();
//#endif 


//#if -325264732 
if(p.evaluate(e))//1
{ 

//#if -1759377212 
add(e);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -305947853 
public ListSet<T> transitiveClosure(org.argouml.util.ChildGenerator cg)
    { 

//#if 507742576 
return transitiveClosure(cg, TC_LIMIT,
                                 org.argouml.util.PredicateTrue.getInstance());
//#endif 

} 

//#endif 


//#if -1386549395 
public boolean addAll(Collection< ? extends T> arg0)
    { 

//#if 1910411502 
return list.addAll(arg0);
//#endif 

} 

//#endif 


//#if -811601948 
public ListIterator<T> listIterator(int index)
    { 

//#if -1982131701 
return list.listIterator(index);
//#endif 

} 

//#endif 


//#if 1853240470 
public void addAllElements(Iterator<T> iter)
    { 

//#if -642591329 
while (iter.hasNext()) //1
{ 

//#if 1280634535 
add(iter.next());
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1395974464 
public <A> A[] toArray(A[] arg0)
    { 

//#if 1376072385 
return list.toArray(arg0);
//#endif 

} 

//#endif 


//#if -721232719 
public int size()
    { 

//#if 1145111902 
return list.size();
//#endif 

} 

//#endif 


//#if -1597053867 
public void addAllElements(Enumeration<T> iter)
    { 

//#if 630271655 
while (iter.hasMoreElements()) //1
{ 

//#if -2073443954 
add(iter.nextElement());
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1394248442 
public boolean retainAll(Collection< ? > arg0)
    { 

//#if -625344573 
return list.retainAll(arg0);
//#endif 

} 

//#endif 


//#if -83494978 
public boolean removeAll(Collection arg0)
    { 

//#if -1253644105 
boolean result = false;
//#endif 


//#if 336180162 
for (Iterator iter = arg0.iterator(); iter.hasNext();) //1
{ 

//#if 29392008 
result = result || remove(iter.next());
//#endif 

} 

//#endif 


//#if -576534073 
return result;
//#endif 

} 

//#endif 


//#if 158362215 
public int indexOf(Object o)
    { 

//#if -1376606453 
return list.indexOf(o);
//#endif 

} 

//#endif 


//#if -1733556256 
public T get(int index)
    { 

//#if 1208573823 
return list.get(index);
//#endif 

} 

//#endif 


//#if -684875645 
public Object findSuchThat(org.argouml.util.Predicate p)
    { 

//#if 624108837 
synchronized (list) //1
{ 

//#if 1500232632 
for (Object o : list) //1
{ 

//#if -475471104 
if(p.evaluate(o))//1
{ 

//#if -402048103 
return o;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 740046479 
return null;
//#endif 

} 

//#endif 


//#if -585798532 
@Override
    public String toString()
    { 

//#if -1694178457 
StringBuilder sb = new StringBuilder("Set{");
//#endif 


//#if 714339534 
synchronized (list) //1
{ 

//#if 1637280324 
for (Iterator it = iterator(); it.hasNext();) //1
{ 

//#if 619734000 
sb.append(it.next());
//#endif 


//#if 1931119060 
if(it.hasNext())//1
{ 

//#if 1047607404 
sb.append(", ");
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1238415134 
sb.append("}");
//#endif 


//#if 133684971 
return sb.toString();
//#endif 

} 

//#endif 


//#if 374407196 
public boolean isEmpty()
    { 

//#if 1830633003 
return list.isEmpty();
//#endif 

} 

//#endif 


//#if 779355828 
public boolean containsSuchThat(org.argouml.util.Predicate p)
    { 

//#if -1138562541 
return findSuchThat(p) != null;
//#endif 

} 

//#endif 


//#if 1386458049 
public void removeAllElements()
    { 

//#if 1446395739 
clear();
//#endif 

} 

//#endif 


//#if -401660515 
public int lastIndexOf(Object o)
    { 

//#if 1927357397 
return list.lastIndexOf(o);
//#endif 

} 

//#endif 


//#if -641093387 
public boolean remove(Object o)
    { 

//#if -875297123 
synchronized (mutex) //1
{ 

//#if 402028533 
boolean result = contains(o);
//#endif 


//#if -1789725836 
if(o != null)//1
{ 

//#if -12684475 
list.remove(o);
//#endif 


//#if -185262959 
set.remove(o);
//#endif 

} 

//#endif 


//#if 1303068265 
return result;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1021791798 
public T remove(int index)
    { 

//#if 1667227096 
synchronized (mutex) //1
{ 

//#if 1683210683 
T removedElement = list.remove(index);
//#endif 


//#if 346695774 
set.remove(removedElement);
//#endif 


//#if -1125287641 
return removedElement;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1243755016 
@Override
    public boolean equals(Object o)
    { 

//#if 1447153556 
if(!(o instanceof ListSet))//1
{ 

//#if 378192309 
return false;
//#endif 

} 

//#endif 


//#if 575358296 
ListSet set = (ListSet) o;
//#endif 


//#if 1755372001 
if(set.size() != size())//1
{ 

//#if -1167333211 
return false;
//#endif 

} 

//#endif 


//#if -299407908 
synchronized (list) //1
{ 

//#if 1007418674 
for (Object obj : list) //1
{ 

//#if -1853921971 
if(!(set.contains(obj)))//1
{ 

//#if 1276638070 
return false;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -893128481 
return true;
//#endif 

} 

//#endif 


//#if -434451526 
public boolean contains(Object o)
    { 

//#if -18714722 
synchronized (mutex) //1
{ 

//#if -542585077 
if(o != null)//1
{ 

//#if 699876910 
return set.contains(o);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 255500691 
return false;
//#endif 

} 

//#endif 


//#if 1681662019 
public boolean containsAll(Collection arg0)
    { 

//#if 644550038 
synchronized (mutex) //1
{ 

//#if -156702477 
return set.containsAll(arg0);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -357310479 
public T set(int arg0, T o)
    { 

//#if 1787066794 
throw new UnsupportedOperationException("set() method not supported");
//#endif 

} 

//#endif 


//#if 1775590464 
public List<T> subList(int fromIndex, int toIndex)
    { 

//#if -1965266754 
return subList(fromIndex, toIndex);
//#endif 

} 

//#endif 


//#if -848581115 
public ListSet()
    { 

//#if -192946800 
list =  Collections.synchronizedList(new ArrayList<T>());
//#endif 


//#if 873593463 
set = new HashSet<T>();
//#endif 

} 

//#endif 


//#if -1209743994 
public ListSet(int n)
    { 

//#if 250097993 
list = Collections.synchronizedList(new ArrayList<T>(n));
//#endif 


//#if 895116842 
set = new HashSet<T>(n);
//#endif 

} 

//#endif 


//#if 421971979 
public void addAllElementsSuchThat(ListSet<T> s,
                                       org.argouml.util.Predicate p)
    { 

//#if -1243691066 
synchronized (s.mutex()) //1
{ 

//#if 345067978 
addAllElementsSuchThat(s.iterator(), p);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1313032996 
public ListSet<T> reachable(org.argouml.util.ChildGenerator cg)
    { 

//#if 1016237122 
return reachable(cg, TC_LIMIT,
                         org.argouml.util.PredicateTrue.getInstance());
//#endif 

} 

//#endif 


//#if -524626821 
public ListSet<T> transitiveClosure(org.argouml.util.ChildGenerator cg,
                                        int max, org.argouml.util.Predicate predicate)
    { 

//#if 1671828247 
int iterCount = 0;
//#endif 


//#if 988570167 
int lastSize = -1;
//#endif 


//#if -882074078 
ListSet<T> touched = new ListSet<T>();
//#endif 


//#if -1656012541 
ListSet<T> frontier;
//#endif 


//#if 768464390 
ListSet<T> recent = this;
//#endif 


//#if 941466879 
touched.addAll(this);
//#endif 


//#if -1841835068 
while ((iterCount < max) && (touched.size() > lastSize)) //1
{ 

//#if 1959655599 
iterCount++;
//#endif 


//#if 1327302478 
lastSize = touched.size();
//#endif 


//#if 960700861 
frontier = new ListSet<T>();
//#endif 


//#if -785457140 
synchronized (recent) //1
{ 

//#if -1902656440 
for (T recentElement : recent) //1
{ 

//#if -403334299 
Iterator frontierChildren = cg.childIterator(recentElement);
//#endif 


//#if -1490937836 
frontier.addAllElementsSuchThat(frontierChildren,
                                                    predicate);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -676877076 
touched.addAll(frontier);
//#endif 


//#if -1799399593 
recent = frontier;
//#endif 

} 

//#endif 


//#if 1735224150 
return touched;
//#endif 

} 

//#endif 


//#if -1334929619 
@Override
    public int hashCode()
    { 

//#if -1155756647 
return 0;
//#endif 

} 

//#endif 


//#if 2043285981 
public void removeElement(Object o)
    { 

//#if -137444410 
if(o != null)//1
{ 

//#if 1088131795 
list.remove(o);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 761492929 
public Object mutex()
    { 

//#if 327110075 
return list;
//#endif 

} 

//#endif 


//#if 2138942258 
public ListSet<T> reachable(org.argouml.util.ChildGenerator cg, int max,
                                org.argouml.util.Predicate predicate)
    { 

//#if -1241949330 
ListSet<T> kids = new ListSet<T>();
//#endif 


//#if 744824770 
synchronized (list) //1
{ 

//#if 2003687625 
for (Object r : list) //1
{ 

//#if -1818269415 
kids.addAllElementsSuchThat(cg.childIterator(r), predicate);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2112152988 
return kids.transitiveClosure(cg, max, predicate);
//#endif 

} 

//#endif 


//#if -12248561 
public boolean addAll(int arg0, Collection< ? extends T> arg1)
    { 

//#if 1916423084 
return list.addAll(arg0, arg1);
//#endif 

} 

//#endif 


//#if 337099646 
public Object[] toArray()
    { 

//#if 815019383 
return list.toArray();
//#endif 

} 

//#endif 


//#if 2002179015 
public ListIterator<T> listIterator()
    { 

//#if 979620078 
return list.listIterator();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

