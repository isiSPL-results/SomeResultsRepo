
//#if -294498293 
// Compilation Unit of /PredicateGefWrapper.java 
 

//#if 8626479 
package org.argouml.util;
//#endif 


//#if -38800020 

//#if 690142219 
@Deprecated
//#endif 

public class PredicateGefWrapper implements 
//#if 744665487 
Predicate
//#endif 

  { 

//#if 1576927348 
private org.tigris.gef.util.Predicate predicate;
//#endif 


//#if 1450772838 
public PredicateGefWrapper(org.tigris.gef.util.Predicate gefPredicate)
    { 

//#if -281051682 
predicate = gefPredicate;
//#endif 

} 

//#endif 


//#if 1589402771 
public boolean evaluate(Object object)
    { 

//#if 261685422 
return predicate.predicate(object);
//#endif 

} 

//#endif 


//#if -2093612052 
public org.tigris.gef.util.Predicate getGefPredicate()
    { 

//#if -1236320966 
return predicate;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

