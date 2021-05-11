package org.argouml.cognitive.checklist;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;
public class Checklist extends ArrayList<CheckItem>
 implements List<CheckItem>
,Serializable
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
