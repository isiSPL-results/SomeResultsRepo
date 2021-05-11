// Compilation Unit of /PredicateStringMatch.java 
 
package org.argouml.util;
import java.util.StringTokenizer;
public class PredicateStringMatch implements Predicate
  { 
public static int MAX_PATS = 10;
private String patterns[];
private int patternCount;
protected PredicateStringMatch(String matchPatterns[], int count)
    { 
patterns = matchPatterns;
patternCount = count;
} 

public boolean evaluate(Object o)
    { 
if(o == null)//1
{ 
return false;
} 

String target = o.toString();
if(!target.startsWith(patterns[0]))//1
{ 
return false;
} 

if(!target.endsWith(patterns[patternCount - 1]))//1
{ 
return false;
} 

for (String pattern : patterns) //1
{ 
int index = (target + "*").indexOf(pattern);
if(index == -1)//1
{ 
return false;
} 

target = target.substring(index + pattern.length());
} 

return true;
} 

public static Predicate create(String pattern)
    { 
pattern = pattern.trim();
if("*".equals(pattern) || "".equals(pattern))//1
{ 
return PredicateTrue.getInstance();
} 

String pats[] = new String[MAX_PATS];
int count = 0;
if(pattern.startsWith("*"))//1
{ 
pats[count++] = "";
} 

StringTokenizer st = new StringTokenizer(pattern, "*");
while (st.hasMoreElements()) //1
{ 
String token = st.nextToken();
pats[count++] = token;
} 

if(pattern.endsWith("*"))//1
{ 
pats[count++] = "";
} 

if(count == 0)//1
{ 
return PredicateTrue.getInstance();
} 

if(count == 1)//1
{ 
return new PredicateEquals(pats[0]);
} 

return new PredicateStringMatch(pats, count);
} 

 } 


