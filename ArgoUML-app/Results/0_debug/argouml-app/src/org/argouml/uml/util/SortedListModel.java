
//#if 1263113005 
// Compilation Unit of /SortedListModel.java 
 

//#if -588716452 
package org.argouml.uml.util;
//#endif 


//#if -813997128 
import java.util.Collection;
//#endif 


//#if 1826758312 
import java.util.Iterator;
//#endif 


//#if -1093783010 
import java.util.Set;
//#endif 


//#if 1786548316 
import java.util.TreeSet;
//#endif 


//#if -2039225889 
import javax.swing.AbstractListModel;
//#endif 


//#if -804277345 
public class SortedListModel extends 
//#if 1248083800 
AbstractListModel
//#endif 

 implements 
//#if -865371825 
Collection
//#endif 

  { 

//#if -371010574 
private Set delegate = new TreeSet(new PathComparator());
//#endif 


//#if -96459785 
public Iterator iterator()
    { 

//#if -1942549119 
return delegate.iterator();
//#endif 

} 

//#endif 


//#if -1588038866 
public Object[] toArray(Object[] a)
    { 

//#if -839860218 
return delegate.toArray(a);
//#endif 

} 

//#endif 


//#if 444176798 
public boolean retainAll(Collection c)
    { 

//#if -1705897047 
int size = delegate.size();
//#endif 


//#if -532114929 
boolean status =  delegate.retainAll(c);
//#endif 


//#if -1729798127 
fireContentsChanged(this, 0, size - 1);
//#endif 


//#if -75523251 
return status;
//#endif 

} 

//#endif 


//#if 268738919 
public boolean remove(Object obj)
    { 

//#if -1041832574 
int index = indexOf(obj);
//#endif 


//#if 2107658059 
boolean rv = delegate.remove(obj);
//#endif 


//#if 1847995872 
if(index >= 0)//1
{ 

//#if -1767843069 
fireIntervalRemoved(this, index, index);
//#endif 

} 

//#endif 


//#if -559695563 
return rv;
//#endif 

} 

//#endif 


//#if -1772472890 
public boolean add(Object obj)
    { 

//#if 757386967 
boolean status = delegate.add(obj);
//#endif 


//#if -1636326741 
int index = indexOf(obj);
//#endif 


//#if 68066362 
fireIntervalAdded(this, index, index);
//#endif 


//#if 1581760254 
return status;
//#endif 

} 

//#endif 


//#if -356669640 
public boolean containsAll(Collection c)
    { 

//#if 391130208 
return delegate.containsAll(c);
//#endif 

} 

//#endif 


//#if -1135083004 
public Object[] toArray()
    { 

//#if 1737537763 
return delegate.toArray();
//#endif 

} 

//#endif 


//#if 2146505246 
public boolean addAll(Collection c)
    { 

//#if 302173548 
boolean status = delegate.addAll(c);
//#endif 


//#if -1109709310 
fireContentsChanged(this, 0, delegate.size() - 1);
//#endif 


//#if 695013522 
return status;
//#endif 

} 

//#endif 


//#if 785742400 
public void clear()
    { 

//#if 325999098 
int index1 = delegate.size() - 1;
//#endif 


//#if 1439296375 
delegate.clear();
//#endif 


//#if 154740398 
if(index1 >= 0)//1
{ 

//#if -811353957 
fireIntervalRemoved(this, 0, index1);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1487620960 
public boolean contains(Object elem)
    { 

//#if 1271738162 
return delegate.contains(elem);
//#endif 

} 

//#endif 


//#if 408750391 
public int size()
    { 

//#if 766487034 
return getSize();
//#endif 

} 

//#endif 


//#if -1711879664 
public Object getElementAt(int index)
    { 

//#if 1387639116 
Object result = null;
//#endif 


//#if -552626066 
Iterator it = delegate.iterator();
//#endif 


//#if -1972944521 
while (index >= 0) //1
{ 

//#if -1229552481 
if(it.hasNext())//1
{ 

//#if 897910311 
result = it.next();
//#endif 

} 
else
{ 

//#if -143042290 
throw new ArrayIndexOutOfBoundsException();
//#endif 

} 

//#endif 


//#if -1677036376 
index--;
//#endif 

} 

//#endif 


//#if -555164587 
return result;
//#endif 

} 

//#endif 


//#if 1296748758 
public boolean isEmpty()
    { 

//#if -1939909831 
return delegate.isEmpty();
//#endif 

} 

//#endif 


//#if -1564924051 
public int indexOf(Object o)
    { 

//#if 518416391 
int index = 0;
//#endif 


//#if 130537865 
Iterator it = delegate.iterator();
//#endif 


//#if -1570714639 
if(o == null)//1
{ 

//#if 2058186623 
while (it.hasNext()) //1
{ 

//#if 1608794540 
if(o == it.next())//1
{ 

//#if 1475779847 
return index;
//#endif 

} 

//#endif 


//#if -1166054440 
index++;
//#endif 

} 

//#endif 

} 
else
{ 

//#if -339403120 
while (it.hasNext()) //1
{ 

//#if -700818543 
if(o.equals(it.next()))//1
{ 

//#if 1447635973 
return index;
//#endif 

} 

//#endif 


//#if 665752289 
index++;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2080520841 
return -1;
//#endif 

} 

//#endif 


//#if 1201085219 
public int getSize()
    { 

//#if 1720350193 
return delegate.size();
//#endif 

} 

//#endif 


//#if 701350685 
public boolean removeAll(Collection c)
    { 

//#if -191116721 
boolean status = false;
//#endif 


//#if -1289104370 
for (Object o : c) //1
{ 

//#if 1747484802 
status = status | remove(o);
//#endif 

} 

//#endif 


//#if -832115163 
return status;
//#endif 

} 

//#endif 


//#if -1753101054 
@Override
    public String toString()
    { 

//#if 1960130744 
return delegate.toString();
//#endif 

} 

//#endif 


//#if -1277968837 
public Object get(int index)
    { 

//#if -850908625 
return getElementAt(index);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

