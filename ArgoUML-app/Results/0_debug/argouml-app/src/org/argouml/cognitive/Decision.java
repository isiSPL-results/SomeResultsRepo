
//#if 588087783 
// Compilation Unit of /Decision.java 
 

//#if -1942406004 
package org.argouml.cognitive;
//#endif 


//#if -416873325 
public class Decision  { 

//#if 1108992145 
public static final Decision UNSPEC =
        new Decision("misc.decision.uncategorized", 1);
//#endif 


//#if -15133238 
private String name;
//#endif 


//#if 307729693 
private int priority;
//#endif 


//#if 1396995922 
public void setName(String n)
    { 

//#if -1517526981 
name = n;
//#endif 

} 

//#endif 


//#if -1456791212 
@Override
    public boolean equals(Object d2)
    { 

//#if -1998368048 
if(!(d2 instanceof Decision))//1
{ 

//#if 1843577113 
return false;
//#endif 

} 

//#endif 


//#if 1124909088 
return ((Decision) d2).getName().equals(getName());
//#endif 

} 

//#endif 


//#if -938926012 
@Override
    public int hashCode()
    { 

//#if -1451513145 
if(name == null)//1
{ 

//#if 769652874 
return 0;
//#endif 

} 

//#endif 


//#if 139882890 
return name.hashCode();
//#endif 

} 

//#endif 


//#if 478729092 
public Decision(String n, int p)
    { 

//#if -1160628813 
name = Translator.localize(n);
//#endif 


//#if -928095916 
priority = p;
//#endif 

} 

//#endif 


//#if -1517504507 
@Override
    public String toString()
    { 

//#if -1326899660 
return getName();
//#endif 

} 

//#endif 


//#if -834743005 
public int getPriority()
    { 

//#if -1950613920 
return priority;
//#endif 

} 

//#endif 


//#if -1071935845 
public void setPriority(int p)
    { 

//#if -1003562013 
priority = p;
//#endif 

} 

//#endif 


//#if -237546310 
public String getName()
    { 

//#if 441018505 
return name;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

