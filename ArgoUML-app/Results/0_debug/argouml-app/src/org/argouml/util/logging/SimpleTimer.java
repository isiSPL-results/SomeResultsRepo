
//#if 1123883950 
// Compilation Unit of /SimpleTimer.java 
 

//#if -179594521 
package org.argouml.util.logging;
//#endif 


//#if 1209457931 
import java.util.ArrayList;
//#endif 


//#if -401504869 
import java.util.Enumeration;
//#endif 


//#if -1052959114 
import java.util.List;
//#endif 


//#if -952521434 
public class SimpleTimer  { 

//#if -1893711744 
private List<Long> points = new ArrayList<Long>();
//#endif 


//#if 19815868 
private List<String> labels = new ArrayList<String>();
//#endif 


//#if -1532558126 
public Enumeration result()
    { 

//#if 58376796 
mark();
//#endif 


//#if -194914201 
return new SimpleTimerEnumeration();
//#endif 

} 

//#endif 


//#if 364092081 
public String toString()
    { 

//#if 1590230346 
StringBuffer sb = new StringBuffer("");
//#endif 


//#if -261669666 
for (Enumeration e = result(); e.hasMoreElements();) //1
{ 

//#if -1410076420 
sb.append((String) e.nextElement());
//#endif 


//#if -1078316985 
sb.append("\n");
//#endif 

} 

//#endif 


//#if -1866198693 
return sb.toString();
//#endif 

} 

//#endif 


//#if 924927585 
public SimpleTimer()
    { 
} 

//#endif 


//#if -543177547 
public void mark()
    { 

//#if 1453762699 
points.add(new Long(System.currentTimeMillis()));
//#endif 


//#if 168100819 
labels.add(null);
//#endif 

} 

//#endif 


//#if -420008166 
public void mark(String label)
    { 

//#if -325353960 
mark();
//#endif 


//#if 334773167 
labels.set(labels.size() - 1, label);
//#endif 

} 

//#endif 


//#if -2054720894 
class SimpleTimerEnumeration implements 
//#if 385030288 
Enumeration<String>
//#endif 

  { 

//#if -332340916 
private int count = 1;
//#endif 


//#if 1696482544 
public boolean hasMoreElements()
        { 

//#if 560464043 
return count <= points.size();
//#endif 

} 

//#endif 


//#if -514918744 
public String nextElement()
        { 

//#if 767200513 
StringBuffer res = new StringBuffer();
//#endif 


//#if 2142972533 
synchronized (points) //1
{ 

//#if 749842166 
if(count < points.size())//1
{ 

//#if -677105278 
if(labels.get(count - 1) == null)//1
{ 

//#if -1530352629 
res.append("phase ").append(count);
//#endif 

} 
else
{ 

//#if -1791482218 
res.append(labels.get(count - 1));
//#endif 

} 

//#endif 


//#if -365211541 
res.append("                            ");
//#endif 


//#if -864810489 
res.append("                            ");
//#endif 


//#if 813650721 
res.setLength(60);
//#endif 


//#if -650276138 
res.append(points.get(count) - points.get(count - 1));
//#endif 

} 
else

//#if 454382394 
if(count == points.size())//1
{ 

//#if 1870006638 
res.append("Total                      ");
//#endif 


//#if 186883075 
res.setLength(18);
//#endif 


//#if -1731757871 
res.append(points.get(points.size() - 1) - (points.get(0)));
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1385173302 
count++;
//#endif 


//#if -1307341722 
return res.toString();
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

