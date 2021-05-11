package org.argouml.uml.cognitive.critics;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.argouml.cognitive.Designer;
import org.argouml.model.Model;
import org.argouml.uml.cognitive.UMLDecision;
public class CrTooManyOper extends AbstractCrTooMany
  { 
private static final int OPERATIONS_THRESHOLD = 20;
private static final long serialVersionUID = 3221965323817473947L;
public boolean predicate2(Object dm, Designer dsgr)
    { 
if(!(Model.getFacade().isAClassifier(dm)))//1
{ 
return NO_PROBLEM;
} 
Collection str = Model.getFacade().getFeatures(dm);
if(str == null)//1
{ 
return NO_PROBLEM;
} 
int n = 0;
for (Iterator iter = str.iterator(); iter.hasNext();) //1
{ 
if(Model.getFacade().isABehavioralFeature(iter.next()))//1
{ 
n++;
} 
} 
if(n <= getThreshold())//1
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
public CrTooManyOper()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.METHODS);
setThreshold(OPERATIONS_THRESHOLD);
addTrigger("behavioralFeature");
} 

 } 
