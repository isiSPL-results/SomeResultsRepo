// Compilation Unit of /PredicateType.java 
 
package org.argouml.util;
public class PredicateType implements Predicate
  { 
private Class patterns[];
private int patternCount;
private String printString = null;
protected PredicateType(Class pats[], int numPats)
    { 
patterns = pats;
patternCount = numPats;
} 

public static PredicateType create()
    { 
return new PredicateType(null, 0);
} 

public static PredicateType create(Class c0)
    { 
Class classes[] = new Class[1];
classes[0] = c0;
return new PredicateType(classes);
} 

public boolean evaluate(Object o)
    { 
if(patternCount == 0)//1
{ 
return true;
} 

for (int i = 0; i < patternCount; i++) //1
{ 
if(patterns[i].isInstance(o))//1
{ 
return true;
} 

} 

return false;
} 

public static PredicateType create(Class c0, Class c1, Class c2)
    { 
Class classes[] = new Class[3];
classes[0] = c0;
classes[1] = c1;
classes[2] = c2;
return new PredicateType(classes);
} 

public static PredicateType create(Class c0, Class c1)
    { 
Class classes[] = new Class[2];
classes[0] = c0;
classes[1] = c1;
return new PredicateType(classes);
} 

@Override
    public String toString()
    { 
if(printString != null)//1
{ 
return printString;
} 

if(patternCount == 0)//1
{ 
return "Any Type";
} 

String res = "";
for (int i = 0; i < patternCount; i++) //1
{ 
String clsName = patterns[i].getName();
int lastDot = clsName.lastIndexOf(".");
clsName = clsName.substring(lastDot + 1);
res += clsName;
if(i < patternCount - 1)//1
{ 
res += ", ";
} 

} 

printString = res;
return res;
} 

protected PredicateType(Class pats[])
    { 
this(pats, pats.length);
} 

 } 


