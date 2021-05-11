
//#if -1361806755 
// Compilation Unit of /PredicateStringMatch.java 
 

//#if 2088452793 
package org.argouml.util;
//#endif 


//#if -824000835 
import java.util.StringTokenizer;
//#endif 


//#if -2049779127 
public class PredicateStringMatch implements 
//#if 2056383242 
Predicate
//#endif 

  { 

//#if -322156907 
public static int MAX_PATS = 10;
//#endif 


//#if 1290322319 
private String patterns[];
//#endif 


//#if -331309853 
private int patternCount;
//#endif 


//#if -449155028 
protected PredicateStringMatch(String matchPatterns[], int count)
    { 

//#if 1892725459 
patterns = matchPatterns;
//#endif 


//#if 1944005488 
patternCount = count;
//#endif 

} 

//#endif 


//#if 63376790 
public boolean evaluate(Object o)
    { 

//#if 1157613455 
if(o == null)//1
{ 

//#if -238310849 
return false;
//#endif 

} 

//#endif 


//#if -1677517040 
String target = o.toString();
//#endif 


//#if 283691858 
if(!target.startsWith(patterns[0]))//1
{ 

//#if 1039517076 
return false;
//#endif 

} 

//#endif 


//#if 881034288 
if(!target.endsWith(patterns[patternCount - 1]))//1
{ 

//#if 443951890 
return false;
//#endif 

} 

//#endif 


//#if 206566977 
for (String pattern : patterns) //1
{ 

//#if 1174335516 
int index = (target + "*").indexOf(pattern);
//#endif 


//#if -32910809 
if(index == -1)//1
{ 

//#if -490457563 
return false;
//#endif 

} 

//#endif 


//#if -1117921076 
target = target.substring(index + pattern.length());
//#endif 

} 

//#endif 


//#if 1213893761 
return true;
//#endif 

} 

//#endif 


//#if 1844396803 
public static Predicate create(String pattern)
    { 

//#if -762735507 
pattern = pattern.trim();
//#endif 


//#if -1813461153 
if("*".equals(pattern) || "".equals(pattern))//1
{ 

//#if -1114873546 
return PredicateTrue.getInstance();
//#endif 

} 

//#endif 


//#if 1939418861 
String pats[] = new String[MAX_PATS];
//#endif 


//#if 1298470824 
int count = 0;
//#endif 


//#if 1538023903 
if(pattern.startsWith("*"))//1
{ 

//#if -1706542107 
pats[count++] = "";
//#endif 

} 

//#endif 


//#if 1728963652 
StringTokenizer st = new StringTokenizer(pattern, "*");
//#endif 


//#if 1284838361 
while (st.hasMoreElements()) //1
{ 

//#if 1419429259 
String token = st.nextToken();
//#endif 


//#if 378378791 
pats[count++] = token;
//#endif 

} 

//#endif 


//#if 1082978392 
if(pattern.endsWith("*"))//1
{ 

//#if 832728132 
pats[count++] = "";
//#endif 

} 

//#endif 


//#if -1743511692 
if(count == 0)//1
{ 

//#if -299971880 
return PredicateTrue.getInstance();
//#endif 

} 

//#endif 


//#if -1742588171 
if(count == 1)//1
{ 

//#if 1934400793 
return new PredicateEquals(pats[0]);
//#endif 

} 

//#endif 


//#if -1526065504 
return new PredicateStringMatch(pats, count);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

