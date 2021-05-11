
//#if 2050722628 
// Compilation Unit of /Checklist.java 
 

//#if -589069074 
package org.argouml.cognitive.checklist;
//#endif 


//#if -1658830403 
import java.io.Serializable;
//#endif 


//#if 153719655 
import java.util.ArrayList;
//#endif 


//#if 273572713 
import java.util.Collections;
//#endif 


//#if -1353706249 
import java.util.Enumeration;
//#endif 


//#if 401661594 
import java.util.List;
//#endif 


//#if -394401963 
import java.util.Vector;
//#endif 


//#if -1948809675 
public class Checklist extends 
//#if 918829876 
ArrayList<CheckItem>
//#endif 

 implements 
//#if -467997579 
List<CheckItem>
//#endif 

, 
//#if 351174251 
Serializable
//#endif 

  { 

//#if 903252707 
private String nextCategory = "General";
//#endif 


//#if 2064337712 
public synchronized void addAll(Checklist list)
    { 

//#if -743619920 
for (CheckItem item : list) //1
{ 

//#if -1104249996 
add(item);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1258204466 
public Checklist()
    { 

//#if -2098079475 
super();
//#endif 

} 

//#endif 


//#if -1583573246 
public void setNextCategory(String cat)
    { 

//#if -1301044884 
nextCategory = cat;
//#endif 

} 

//#endif 


//#if 1577417255 
@Override
    public String toString()
    { 

//#if 1832936458 
StringBuilder sb = new StringBuilder();
//#endif 


//#if -605477274 
sb.append(getClass().getName() + " {\n");
//#endif 


//#if 328245651 
for (CheckItem item : this) //1
{ 

//#if -59055780 
sb.append("    " + item.toString() + "\n");
//#endif 

} 

//#endif 


//#if 1044369512 
sb.append("  }");
//#endif 


//#if -1470692383 
return sb.toString();
//#endif 

} 

//#endif 


//#if -340615952 
public List<CheckItem> getCheckItemList()
    { 

//#if -257343701 
return this;
//#endif 

} 

//#endif 


//#if -1987946693 
public void addItem(String description)
    { 

//#if -988091043 
add(new CheckItem(nextCategory, description));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

