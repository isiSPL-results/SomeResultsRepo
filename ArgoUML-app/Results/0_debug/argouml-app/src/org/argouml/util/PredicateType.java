
//#if 1149028789 
// Compilation Unit of /PredicateType.java 
 

//#if 1220640829 
package org.argouml.util;
//#endif 


//#if -246260663 
public class PredicateType implements 
//#if 1180477481 
Predicate
//#endif 

  { 

//#if 260866451 
private Class patterns[];
//#endif 


//#if 764311490 
private int patternCount;
//#endif 


//#if 1753966543 
private String printString = null;
//#endif 


//#if 250638921 
protected PredicateType(Class pats[], int numPats)
    { 

//#if -956045821 
patterns = pats;
//#endif 


//#if -1360875727 
patternCount = numPats;
//#endif 

} 

//#endif 


//#if 185302601 
public static PredicateType create()
    { 

//#if -1448098222 
return new PredicateType(null, 0);
//#endif 

} 

//#endif 


//#if 2146467620 
public static PredicateType create(Class c0)
    { 

//#if -1760664236 
Class classes[] = new Class[1];
//#endif 


//#if -1539282952 
classes[0] = c0;
//#endif 


//#if 1283796982 
return new PredicateType(classes);
//#endif 

} 

//#endif 


//#if 1597376983 
public boolean evaluate(Object o)
    { 

//#if 170618190 
if(patternCount == 0)//1
{ 

//#if -1932532416 
return true;
//#endif 

} 

//#endif 


//#if 1217359255 
for (int i = 0; i < patternCount; i++) //1
{ 

//#if -1271155132 
if(patterns[i].isInstance(o))//1
{ 

//#if -1813071248 
return true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1114038104 
return false;
//#endif 

} 

//#endif 


//#if 1321651727 
public static PredicateType create(Class c0, Class c1, Class c2)
    { 

//#if -931022117 
Class classes[] = new Class[3];
//#endif 


//#if -565332525 
classes[0] = c0;
//#endif 


//#if -536703343 
classes[1] = c1;
//#endif 


//#if -508074161 
classes[2] = c2;
//#endif 


//#if 763026705 
return new PredicateType(classes);
//#endif 

} 

//#endif 


//#if 1183746442 
public static PredicateType create(Class c0, Class c1)
    { 

//#if 840725191 
Class classes[] = new Class[2];
//#endif 


//#if 2003469574 
classes[0] = c0;
//#endif 


//#if 2032098756 
classes[1] = c1;
//#endif 


//#if -174889596 
return new PredicateType(classes);
//#endif 

} 

//#endif 


//#if -772207611 
@Override
    public String toString()
    { 

//#if 948039200 
if(printString != null)//1
{ 

//#if -926755559 
return printString;
//#endif 

} 

//#endif 


//#if -1815544240 
if(patternCount == 0)//1
{ 

//#if -1967121295 
return "Any Type";
//#endif 

} 

//#endif 


//#if 430791339 
String res = "";
//#endif 


//#if 954238805 
for (int i = 0; i < patternCount; i++) //1
{ 

//#if 1963949004 
String clsName = patterns[i].getName();
//#endif 


//#if 2079173465 
int lastDot = clsName.lastIndexOf(".");
//#endif 


//#if -641342117 
clsName = clsName.substring(lastDot + 1);
//#endif 


//#if 1017202880 
res += clsName;
//#endif 


//#if -1659280047 
if(i < patternCount - 1)//1
{ 

//#if -107783902 
res += ", ";
//#endif 

} 

//#endif 

} 

//#endif 


//#if 720364924 
printString = res;
//#endif 


//#if -241729331 
return res;
//#endif 

} 

//#endif 


//#if -2058725610 
protected PredicateType(Class pats[])
    { 

//#if 1405168156 
this(pats, pats.length);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

