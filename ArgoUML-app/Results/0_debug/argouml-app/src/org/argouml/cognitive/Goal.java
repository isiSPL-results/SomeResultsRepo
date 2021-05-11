
//#if 1799591477 
// Compilation Unit of /Goal.java 
 

//#if -243591529 
package org.argouml.cognitive;
//#endif 


//#if -801259371 
public class Goal  { 

//#if -1181554908 
private static final Goal UNSPEC = new Goal("label.goal.unspecified", 1);
//#endif 


//#if 1204289919 
private String name;
//#endif 


//#if -544858104 
private int priority;
//#endif 


//#if -970532368 
public Goal(String n, int p)
    { 

//#if -962613083 
name = Translator.localize(n);
//#endif 


//#if 179313698 
priority = p;
//#endif 

} 

//#endif 


//#if 99142690 
public static Goal getUnspecifiedGoal()
    { 

//#if 1440736389 
return UNSPEC;
//#endif 

} 

//#endif 


//#if -1271210489 
public void setName(String n)
    { 

//#if -434853381 
name = n;
//#endif 

} 

//#endif 


//#if 2052258319 
public boolean equals(Object d2)
    { 

//#if -1601003497 
if(!(d2 instanceof Goal))//1
{ 

//#if 958542020 
return false;
//#endif 

} 

//#endif 


//#if -1765834005 
return ((Goal) d2).getName().equals(getName());
//#endif 

} 

//#endif 


//#if 158785112 
public int getPriority()
    { 

//#if 1300034334 
return priority;
//#endif 

} 

//#endif 


//#if 1235708842 
public String toString()
    { 

//#if 901804390 
return getName();
//#endif 

} 

//#endif 


//#if 764334309 
public String getName()
    { 

//#if 1894048864 
return name;
//#endif 

} 

//#endif 


//#if 438998719 
public int hashCode()
    { 

//#if -1467801919 
if(name == null)//1
{ 

//#if 731506842 
return 0;
//#endif 

} 

//#endif 


//#if 1033529808 
return name.hashCode();
//#endif 

} 

//#endif 


//#if 2113011334 
public void setPriority(int p)
    { 

//#if -320918481 
priority = p;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

