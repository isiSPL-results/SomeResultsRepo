// Compilation Unit of /CrTooManyAssoc.java 
 
package org.argouml.uml.cognitive.critics;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.argouml.cognitive.Designer;
import org.argouml.model.Model;
import org.argouml.uml.cognitive.UMLDecision;
public class CrTooManyAssoc extends AbstractCrTooMany
  { 
private static final int ASSOCIATIONS_THRESHOLD = 7;
public boolean predicate2(Object dm, Designer dsgr)
    { 
if(!(Model.getFacade().isAClassifier(dm)))//1
{ 
return NO_PROBLEM;
} 

int threshold = getThreshold();
Collection aes = Model.getFacade().getAssociationEnds(dm);
if(aes == null || aes.size() <= threshold)//1
{ 
return NO_PROBLEM;
} 

return PROBLEM_FOUND;
} 

public Set<Object> getCriticizedDesignMaterials()
    { 
Set<Object> ret = new HashSet<Object>();
ret.add(Model.getMetaTypes().getUMLClass());
return ret;
} 

public CrTooManyAssoc()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.RELATIONSHIPS);
setThreshold(ASSOCIATIONS_THRESHOLD);
addTrigger("associationEnd");
} 

 } 


