package org.argouml.util.logging;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
public class SimpleTimer  { 
private List<Long> points = new ArrayList<Long>();
private List<String> labels = new ArrayList<String>();
public Enumeration result()
    { 
mark();
return new SimpleTimerEnumeration();
} 
public String toString()
    { 
StringBuffer sb = new StringBuffer("");
for (Enumeration e = result(); e.hasMoreElements();) //1
{ 
sb.append((String) e.nextElement());
sb.append("\n");
} 
return sb.toString();
} 
public SimpleTimer()
    { 
} 
public void mark()
    { 
points.add(new Long(System.currentTimeMillis()));
labels.add(null);
} 
public void mark(String label)
    { 
mark();
labels.set(labels.size() - 1, label);
} 
class SimpleTimerEnumeration implements Enumeration<String>
  { 
private int count = 1;
public boolean hasMoreElements()
        { 
return count <= points.size();
} 
public String nextElement()
        { 
StringBuffer res = new StringBuffer();
synchronized (points) //1
{ 
if(count < points.size())//1
{ 
if(labels.get(count - 1) == null)//1
{ 
res.append("phase ").append(count);
} 
else
{ 
res.append(labels.get(count - 1));
} 
res.append("                            ");
res.append("                            ");
res.setLength(60);
res.append(points.get(count) - points.get(count - 1));
} 
else
if(count == points.size())//1
{ 
res.append("Total                      ");
res.setLength(18);
res.append(points.get(points.size() - 1) - (points.get(0)));
} 
} 
count++;
return res.toString();
} 

 } 

 } 
