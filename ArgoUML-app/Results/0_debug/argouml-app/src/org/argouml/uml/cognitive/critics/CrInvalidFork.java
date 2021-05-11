
//#if -745705204 
// Compilation Unit of /CrInvalidFork.java 
 

//#if 466808968 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 400441555 
import java.util.Collection;
//#endif 


//#if 1705727633 
import java.util.HashSet;
//#endif 


//#if 576720227 
import java.util.Set;
//#endif 


//#if -510201963 
import org.argouml.cognitive.Designer;
//#endif 


//#if -1548533186 
import org.argouml.model.Model;
//#endif 


//#if 750413120 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -913806048 
public class CrInvalidFork extends 
//#if -2011655103 
CrUML
//#endif 

  { 

//#if -138640275 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if 1595078951 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if 108820737 
ret.add(Model.getMetaTypes().getPseudostate());
//#endif 


//#if 586345455 
return ret;
//#endif 

} 

//#endif 


//#if 2137121470 
public CrInvalidFork()
    { 

//#if 315327402 
setupHeadAndDesc();
//#endif 


//#if 93950276 
addSupportedDecision(UMLDecision.STATE_MACHINES);
//#endif 


//#if 939242552 
addTrigger("incoming");
//#endif 

} 

//#endif 


//#if -1746255694 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if -189553034 
if(!(Model.getFacade().isAPseudostate(dm)))//1
{ 

//#if 159535759 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1629612825 
Object k = Model.getFacade().getKind(dm);
//#endif 


//#if -801984951 
if(!Model.getFacade().equalsPseudostateKind(
                    k,
                    Model.getPseudostateKind().getFork()))//1
{ 

//#if -1532971692 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1172525226 
Collection outgoing = Model.getFacade().getOutgoings(dm);
//#endif 


//#if 328896926 
Collection incoming = Model.getFacade().getIncomings(dm);
//#endif 


//#if -804348280 
int nOutgoing = outgoing == null ? 0 : outgoing.size();
//#endif 


//#if -785170430 
int nIncoming = incoming == null ? 0 : incoming.size();
//#endif 


//#if -922740591 
if(nIncoming > 1)//1
{ 

//#if -212608566 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if 1110020477 
if(nOutgoing == 1)//1
{ 

//#if 691884117 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if -747083171 
return NO_PROBLEM;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

