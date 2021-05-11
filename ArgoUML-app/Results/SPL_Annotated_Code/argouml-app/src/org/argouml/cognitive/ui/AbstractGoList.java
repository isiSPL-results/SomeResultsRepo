// Compilation Unit of /AbstractGoList.java 
 

//#if COGNITIVE 
package org.argouml.cognitive.ui;
//#endif 


//#if COGNITIVE 
import javax.swing.tree.TreeModel;
//#endif 


//#if COGNITIVE 
import org.tigris.gef.util.Predicate;
//#endif 


//#if COGNITIVE 
import org.tigris.gef.util.PredicateTrue;
//#endif 


//#if COGNITIVE 
public abstract class AbstractGoList implements TreeModel
  { 
private Predicate listPredicate = new PredicateTrue();
public void setListPredicate(Predicate newPredicate)
    { 
listPredicate = newPredicate;
} 

public Object getRoot()
    { 
throw new UnsupportedOperationException();
} 

public Predicate getListPredicate()
    { 
return listPredicate;
} 

public void setRoot(Object r)
    { 
} 

 } 

//#endif 


