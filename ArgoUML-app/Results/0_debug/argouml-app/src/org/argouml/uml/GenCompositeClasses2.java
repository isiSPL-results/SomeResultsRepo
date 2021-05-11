
//#if 1212703895 
// Compilation Unit of /GenCompositeClasses2.java 
 

//#if 1353045262 
package org.argouml.uml;
//#endif 


//#if 1990527596 
import java.util.Iterator;
//#endif 


//#if -1070008010 
import org.argouml.util.ChildGenerator;
//#endif 


//#if 1633935798 
public class GenCompositeClasses2 extends 
//#if -837947377 
GenCompositeClasses
//#endif 

 implements 
//#if -1780371433 
ChildGenerator
//#endif 

  { 

//#if -103634223 
private static final GenCompositeClasses2 SINGLETON =
        new GenCompositeClasses2();
//#endif 


//#if -456889358 
public static GenCompositeClasses2 getInstance()
    { 

//#if 86120989 
return SINGLETON;
//#endif 

} 

//#endif 


//#if 1980433995 
public Iterator childIterator(Object parent)
    { 

//#if 1628349176 
return collectChildren(parent).iterator();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

