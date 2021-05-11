
//#if -561304435 
// Compilation Unit of /CrTooManyStates.java 
 

//#if 484526443 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 1784976118 
import java.util.Collection;
//#endif 


//#if 798224206 
import java.util.HashSet;
//#endif 


//#if -45839200 
import java.util.Set;
//#endif 


//#if -517787144 
import org.argouml.cognitive.Designer;
//#endif 


//#if 549689659 
import org.argouml.model.Model;
//#endif 


//#if 290733437 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -1335748807 
public class CrTooManyStates extends 
//#if -901334387 
AbstractCrTooMany
//#endif 

  { 

//#if 2087740259 
private static final int STATES_THRESHOLD = 20;
//#endif 


//#if -1328930706 
private static final long serialVersionUID = -7320341818814870066L;
//#endif 


//#if 1202046889 
public CrTooManyStates()
    { 

//#if 2055656002 
setupHeadAndDesc();
//#endif 


//#if -883997220 
addSupportedDecision(UMLDecision.STATE_MACHINES);
//#endif 


//#if 1278092274 
setThreshold(STATES_THRESHOLD);
//#endif 


//#if -1930965819 
addTrigger("substate");
//#endif 

} 

//#endif 


//#if -638744068 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if 176447958 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if -188688175 
ret.add(Model.getMetaTypes().getCompositeState());
//#endif 


//#if 895635806 
return ret;
//#endif 

} 

//#endif 


//#if -238367421 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 1019018355 
if(!(Model.getFacade().isACompositeState(dm)))//1
{ 

//#if -1931250909 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1889695669 
Collection subs = Model.getFacade().getSubvertices(dm);
//#endif 


//#if 1135990346 
if(subs.size() <= getThreshold())//1
{ 

//#if -1336254500 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -476507006 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

