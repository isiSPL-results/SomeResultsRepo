
//#if -1977383673 
// Compilation Unit of /CustomSeparator.java 
 

//#if -1411626129 
package org.argouml.util;
//#endif 


//#if -1150279202 
public class CustomSeparator  { 

//#if 1331373466 
private char pattern[];
//#endif 


//#if -541007995 
private char match[];
//#endif 


//#if -248207774 
public CustomSeparator(char start)
    { 

//#if -1377357201 
pattern = new char[1];
//#endif 


//#if 461529584 
pattern[0] = start;
//#endif 


//#if -1553098387 
match = new char[pattern.length];
//#endif 

} 

//#endif 


//#if -1005568611 
public int getPeekCount()
    { 

//#if 744368912 
return 0;
//#endif 

} 

//#endif 


//#if 2023402947 
public boolean hasFreePart()
    { 

//#if -1746184258 
return false;
//#endif 

} 

//#endif 


//#if -1135239573 
public void reset()
    { 

//#if 180722639 
int i;
//#endif 


//#if 1472080680 
for (i = 0; i < match.length; i++) //1
{ 

//#if 170851588 
match[i] = 0;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -276807326 
public int tokenLength()
    { 

//#if 248836672 
return pattern.length;
//#endif 

} 

//#endif 


//#if 813166596 
public boolean addChar(char c)
    { 

//#if 2056327939 
int i;
//#endif 


//#if 85913752 
for (i = 0; i < match.length - 1; i++) //1
{ 

//#if -496870250 
match[i] = match[i + 1];
//#endif 

} 

//#endif 


//#if 1880787935 
match[match.length - 1] = c;
//#endif 


//#if 404452980 
for (i = 0; i < match.length; i++)//1
{ 

//#if -1193752984 
if(match[i] != pattern[i])//1
{ 

//#if 1956157133 
return false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -491718241 
return true;
//#endif 

} 

//#endif 


//#if 1617969597 
public CustomSeparator(String start)
    { 

//#if 298054238 
pattern = start.toCharArray();
//#endif 


//#if -1322144974 
match = new char[pattern.length];
//#endif 

} 

//#endif 


//#if 1752787311 
protected CustomSeparator()
    { 

//#if -2048584362 
pattern = new char[0];
//#endif 


//#if 77235913 
match = pattern;
//#endif 

} 

//#endif 


//#if 151869322 
public boolean endChar(char c)
    { 

//#if -2029454334 
return true;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

