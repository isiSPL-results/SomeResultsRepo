
//#if -1117889654 
// Compilation Unit of /CrTooManyTransitions.java 
 

//#if 902006718 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -226750839 
import java.util.Collection;
//#endif 


//#if 157897883 
import java.util.HashSet;
//#endif 


//#if 1460838509 
import java.util.Set;
//#endif 


//#if -642805301 
import org.argouml.cognitive.Designer;
//#endif 


//#if 1165562056 
import org.argouml.model.Model;
//#endif 


//#if -779683254 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 1723308282 
public class CrTooManyTransitions extends 
//#if -427057590 
AbstractCrTooMany
//#endif 

  { 

//#if -2058102441 
private static final int TRANSITIONS_THRESHOLD = 10;
//#endif 


//#if -1645959979 
private static final long serialVersionUID = -5732942378849267065L;
//#endif 


//#if 10421497 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if -755820068 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if -598328274 
ret.add(Model.getMetaTypes().getStateVertex());
//#endif 


//#if -672398108 
return ret;
//#endif 

} 

//#endif 


//#if 1266743804 
public CrTooManyTransitions()
    { 

//#if 1352866831 
setupHeadAndDesc();
//#endif 


//#if 669919977 
addSupportedDecision(UMLDecision.STATE_MACHINES);
//#endif 


//#if -1561824579 
setThreshold(TRANSITIONS_THRESHOLD);
//#endif 


//#if 366383645 
addTrigger("incoming");
//#endif 


//#if 1149454615 
addTrigger("outgoing");
//#endif 

} 

//#endif 


//#if -2018541914 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 838754076 
if(!(Model.getFacade().isAStateVertex(dm)))//1
{ 

//#if 1622477159 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -160635963 
Collection in = Model.getFacade().getIncomings(dm);
//#endif 


//#if 1157548142 
Collection out = Model.getFacade().getOutgoings(dm);
//#endif 


//#if -1220847929 
int inSize = (in == null) ? 0 : in.size();
//#endif 


//#if -263840956 
int outSize = (out == null) ? 0 : out.size();
//#endif 


//#if 659270431 
if(inSize + outSize <= getThreshold())//1
{ 

//#if -1899041380 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1148081246 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

