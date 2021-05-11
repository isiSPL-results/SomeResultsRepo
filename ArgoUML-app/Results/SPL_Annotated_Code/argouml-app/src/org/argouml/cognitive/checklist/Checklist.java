// Compilation Unit of /Checklist.java 
 

//#if COGNITIVE 
package org.argouml.cognitive.checklist;
//#endif 


//#if COGNITIVE 
import java.io.Serializable;
//#endif 


//#if COGNITIVE 
import java.util.ArrayList;
//#endif 


//#if COGNITIVE 
import java.util.Collections;
//#endif 


//#if COGNITIVE 
import java.util.Enumeration;
//#endif 


//#if COGNITIVE 
import java.util.List;
//#endif 


//#if COGNITIVE 
import java.util.Vector;
//#endif 


//#if COGNITIVE 
public class Checklist extends ArrayList<CheckItem>
 implements List<CheckItem>
, Serializable
  { 
private String nextCategory = "General";
public synchronized void addAll(Checklist list)
    { 
for (CheckItem item : list) //1
{ 
add(item);
} 

} 

public Checklist()
    { 
super();
} 

public void setNextCategory(String cat)
    { 
nextCategory = cat;
} 

@Override
    public String toString()
    { 
StringBuilder sb = new StringBuilder();
sb.append(getClass().getName() + " {\n");
for (CheckItem item : this) //1
{ 
sb.append("    " + item.toString() + "\n");
} 

sb.append("  }");
return sb.toString();
} 

public List<CheckItem> getCheckItemList()
    { 
return this;
} 

public void addItem(String description)
    { 
add(new CheckItem(nextCategory, description));
} 

 } 

//#endif 


