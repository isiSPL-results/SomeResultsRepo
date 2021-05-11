// Compilation Unit of /PredicateTrue.java 
 
package org.argouml.util;
public class PredicateTrue implements Predicate
  { 
private static PredicateTrue theInstance = new PredicateTrue();
public static PredicateTrue getInstance()
    { 
return theInstance;
} 

private PredicateTrue()
    { 
} 

public boolean evaluate(Object obj)
    { 
return true;
} 

 } 


