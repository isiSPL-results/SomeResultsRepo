package org.argouml.cognitive.ui;
import javax.swing.tree.TreeModel;
import org.tigris.gef.util.Predicate;
import org.tigris.gef.util.PredicateTrue;
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
