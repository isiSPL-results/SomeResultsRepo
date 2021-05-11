
//#if -159846254 
// Compilation Unit of /AbstractGoList.java 
 

//#if -494100017 
package org.argouml.cognitive.ui;
//#endif 


//#if -941143020 
import javax.swing.tree.TreeModel;
//#endif 


//#if 966455028 
import org.tigris.gef.util.Predicate;
//#endif 


//#if 91764358 
import org.tigris.gef.util.PredicateTrue;
//#endif 


//#if -326200362 
public abstract class AbstractGoList implements 
//#if 1682650052 
TreeModel
//#endif 

  { 

//#if 680861622 
private Predicate listPredicate = new PredicateTrue();
//#endif 


//#if 31395912 
public void setListPredicate(Predicate newPredicate)
    { 

//#if -619807859 
listPredicate = newPredicate;
//#endif 

} 

//#endif 


//#if -337416566 
public Object getRoot()
    { 

//#if -524734299 
throw new UnsupportedOperationException();
//#endif 

} 

//#endif 


//#if -1080636469 
public Predicate getListPredicate()
    { 

//#if -173696980 
return listPredicate;
//#endif 

} 

//#endif 


//#if -1248278850 
public void setRoot(Object r)
    { 
} 

//#endif 

 } 

//#endif 


//#endif 

