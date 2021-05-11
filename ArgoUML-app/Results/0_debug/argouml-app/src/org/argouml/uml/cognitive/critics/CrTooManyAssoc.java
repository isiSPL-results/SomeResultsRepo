
//#if -1050043455 
// Compilation Unit of /CrTooManyAssoc.java 
 

//#if -36812959 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -800745620 
import java.util.Collection;
//#endif 


//#if -604492136 
import java.util.HashSet;
//#endif 


//#if -797966102 
import java.util.Set;
//#endif 


//#if 1442421486 
import org.argouml.cognitive.Designer;
//#endif 


//#if -448153339 
import org.argouml.model.Model;
//#endif 


//#if -329649209 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 375572980 
public class CrTooManyAssoc extends 
//#if 911564752 
AbstractCrTooMany
//#endif 

  { 

//#if -196292149 
private static final int ASSOCIATIONS_THRESHOLD = 7;
//#endif 


//#if -531942688 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 4713197 
if(!(Model.getFacade().isAClassifier(dm)))//1
{ 

//#if -1170743302 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1798272492 
int threshold = getThreshold();
//#endif 


//#if 2090858602 
Collection aes = Model.getFacade().getAssociationEnds(dm);
//#endif 


//#if -350434050 
if(aes == null || aes.size() <= threshold)//1
{ 

//#if 1316866214 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1831725297 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if -1149642753 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if 1999902992 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if -492370235 
ret.add(Model.getMetaTypes().getUMLClass());
//#endif 


//#if -729572072 
return ret;
//#endif 

} 

//#endif 


//#if 108970637 
public CrTooManyAssoc()
    { 

//#if -486887153 
setupHeadAndDesc();
//#endif 


//#if -1771910192 
addSupportedDecision(UMLDecision.RELATIONSHIPS);
//#endif 


//#if -20001265 
setThreshold(ASSOCIATIONS_THRESHOLD);
//#endif 


//#if -1434656023 
addTrigger("associationEnd");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

