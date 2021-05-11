
//#if 2035909228 
// Compilation Unit of /PredicateEquals.java 
 

//#if 580639468 
package org.argouml.util;
//#endif 


//#if -1730957315 
public class PredicateEquals implements 
//#if 1929049931 
Predicate
//#endif 

  { 

//#if -10794239 
private Object pattern;
//#endif 


//#if -1252120416 
public PredicateEquals(Object patternObject)
    { 

//#if 515934211 
pattern = patternObject;
//#endif 

} 

//#endif 


//#if 140554063 
public boolean evaluate(Object object)
    { 

//#if -1117051164 
if(pattern == null)//1
{ 

//#if 1064633291 
return object == null;
//#endif 

} 

//#endif 


//#if -2054088452 
return pattern.equals(object);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

