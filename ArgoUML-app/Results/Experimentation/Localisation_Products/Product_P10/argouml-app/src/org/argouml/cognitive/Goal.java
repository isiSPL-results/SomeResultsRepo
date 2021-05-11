package org.argouml.cognitive;
public class Goal  { 
private static final Goal UNSPEC = new Goal("label.goal.unspecified", 1);
private String name;
private int priority;
public Goal(String n, int p)
    { 
name = Translator.localize(n);
priority = p;
} 
public static Goal getUnspecifiedGoal()
    { 
return UNSPEC;
} 
public void setName(String n)
    { 
name = n;
} 
public boolean equals(Object d2)
    { 
if(!(d2 instanceof Goal))//1
{ 
return false;
} 
return ((Goal) d2).getName().equals(getName());
} 
public int getPriority()
    { 
return priority;
} 
public String toString()
    { 
return getName();
} 
public String getName()
    { 
return name;
} 
public int hashCode()
    { 
if(name == null)//1
{ 
return 0;
} 
return name.hashCode();
} 
public void setPriority(int p)
    { 
priority = p;
} 

 } 
