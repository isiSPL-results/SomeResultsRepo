
//#if 1199597841 
// Compilation Unit of /CrInvalidInitial.java 
 

//#if 1153553227 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 1919542486 
import java.util.Collection;
//#endif 


//#if -1971132050 
import java.util.HashSet;
//#endif 


//#if 302356160 
import java.util.Set;
//#endif 


//#if 194227160 
import org.argouml.cognitive.Designer;
//#endif 


//#if -2083095717 
import org.argouml.model.Model;
//#endif 


//#if -1675565155 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -1843177943 
public class CrInvalidInitial extends 
//#if 1312654251 
CrUML
//#endif 

  { 

//#if -732000425 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if 683696035 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if -526422779 
ret.add(Model.getMetaTypes().getPseudostate());
//#endif 


//#if 1910863211 
return ret;
//#endif 

} 

//#endif 


//#if -881762240 
public CrInvalidInitial()
    { 

//#if -312617593 
setupHeadAndDesc();
//#endif 


//#if 1224540769 
addSupportedDecision(UMLDecision.STATE_MACHINES);
//#endif 


//#if 701793935 
addTrigger("outgoing");
//#endif 

} 

//#endif 


//#if -1765396344 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 180174206 
if(!(Model.getFacade().isAPseudostate(dm)))//1
{ 

//#if -448461594 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -795407839 
Object k = Model.getFacade().getKind(dm);
//#endif 


//#if -503008839 
if(!Model.getFacade().equalsPseudostateKind(
                    k,
                    Model.getPseudostateKind().getInitial()))//1
{ 

//#if 128559607 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1116299186 
Collection outgoing = Model.getFacade().getOutgoings(dm);
//#endif 


//#if -434621040 
int nOutgoing = outgoing == null ? 0 : outgoing.size();
//#endif 


//#if 1906719327 
if(nOutgoing > 1)//1
{ 

//#if -1784856775 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if -43714987 
return NO_PROBLEM;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

