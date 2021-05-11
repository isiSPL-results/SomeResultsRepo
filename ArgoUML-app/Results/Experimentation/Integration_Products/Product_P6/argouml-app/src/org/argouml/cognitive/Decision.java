package org.argouml.cognitive;
public class Decision  { 
public static final Decision UNSPEC =
        new Decision("misc.decision.uncategorized", 1);
private String name;
private int priority;
public void setName(String n)
    { 
name = n;
} 
@Override
    public boolean equals(Object d2)
    { 
if(!(d2 instanceof Decision))//1
{ 
return false;
} 
return ((Decision) d2).getName().equals(getName());
} 
@Override
    public int hashCode()
    { 
if(name == null)//1
{ 
return 0;
} 
return name.hashCode();
} 
public Decision(String n, int p)
    { 
name = Translator.localize(n);
priority = p;
} 
@Override
    public String toString()
    { 
return getName();
} 
public int getPriority()
    { 
return priority;
} 
public void setPriority(int p)
    { 
priority = p;
} 
public String getName()
    { 
return name;
} 

 } 
