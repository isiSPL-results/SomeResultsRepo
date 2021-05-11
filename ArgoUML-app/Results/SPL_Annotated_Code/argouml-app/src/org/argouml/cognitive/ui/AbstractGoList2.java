// Compilation Unit of /AbstractGoList2.java 
 

//#if COGNITIVE 
package org.argouml.cognitive.ui;
//#endif 


//#if COGNITIVE 
import javax.swing.tree.TreeModel;
//#endif 


//#if COGNITIVE 
import org.argouml.util.Predicate;
//#endif 


//#if COGNITIVE 
import org.argouml.util.PredicateTrue;
//#endif 


//#if COGNITIVE 
public abstract class AbstractGoList2 extends AbstractGoList
 implements TreeModel
  { 
private Predicate listPredicate = PredicateTrue.getInstance();
public void setListPredicate(Predicate newPredicate)
    { 
listPredicate = newPredicate;
} 

public Object getRoot()
    { 
throw new UnsupportedOperationException();
} 

public Predicate getPredicate()
    { 
return listPredicate;
} 

public void setRoot(Object r)
    { 
} 

 } 

//#endif 


