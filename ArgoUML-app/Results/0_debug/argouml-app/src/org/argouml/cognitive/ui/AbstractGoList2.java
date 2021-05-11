
//#if -1085191574 
// Compilation Unit of /AbstractGoList2.java 
 

//#if -1008058462 
package org.argouml.cognitive.ui;
//#endif 


//#if 306014369 
import javax.swing.tree.TreeModel;
//#endif 


//#if 1128265820 
import org.argouml.util.Predicate;
//#endif 


//#if 959073262 
import org.argouml.util.PredicateTrue;
//#endif 


//#if -1515103185 
public abstract class AbstractGoList2 extends 
//#if -796877833 
AbstractGoList
//#endif 

 implements 
//#if 306153788 
TreeModel
//#endif 

  { 

//#if 948388031 
private Predicate listPredicate = PredicateTrue.getInstance();
//#endif 


//#if -986804800 
public void setListPredicate(Predicate newPredicate)
    { 

//#if -2079880243 
listPredicate = newPredicate;
//#endif 

} 

//#endif 


//#if -1704243198 
public Object getRoot()
    { 

//#if -2034740676 
throw new UnsupportedOperationException();
//#endif 

} 

//#endif 


//#if -1457619647 
public Predicate getPredicate()
    { 

//#if -737513315 
return listPredicate;
//#endif 

} 

//#endif 


//#if -1030025146 
public void setRoot(Object r)
    { 
} 

//#endif 

 } 

//#endif 


//#endif 

