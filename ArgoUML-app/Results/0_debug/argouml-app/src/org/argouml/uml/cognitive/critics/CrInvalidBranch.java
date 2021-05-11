
//#if 1164700126 
// Compilation Unit of /CrInvalidBranch.java 
 

//#if 1451960017 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 144521948 
import java.util.Collection;
//#endif 


//#if -2126462680 
import java.util.HashSet;
//#endif 


//#if -980919430 
import java.util.Set;
//#endif 


//#if 258978398 
import org.argouml.cognitive.Designer;
//#endif 


//#if -2082594923 
import org.argouml.model.Model;
//#endif 


//#if 1873780311 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 240518999 
public class CrInvalidBranch extends 
//#if 1395479162 
CrUML
//#endif 

  { 

//#if -25767209 
public CrInvalidBranch()
    { 

//#if -8875840 
setupHeadAndDesc();
//#endif 


//#if -474803238 
addSupportedDecision(UMLDecision.STATE_MACHINES);
//#endif 


//#if -1097841074 
addTrigger("incoming");
//#endif 

} 

//#endif 


//#if 374085273 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 176247502 
if(!(Model.getFacade().isAPseudostate(dm)))//1
{ 

//#if 754190458 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1898803057 
Object k = Model.getFacade().getKind(dm);
//#endif 


//#if 199356347 
if((!Model.getFacade().equalsPseudostateKind(k,
                Model.getPseudostateKind().getChoice()))
                && (!Model.getFacade().equalsPseudostateKind(k,
                        Model.getPseudostateKind().getJunction())))//1
{ 

//#if 2138318166 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 818619650 
Collection outgoing = Model.getFacade().getOutgoings(dm);
//#endif 


//#if -25008650 
Collection incoming = Model.getFacade().getIncomings(dm);
//#endif 


//#if -438547744 
int nOutgoing = outgoing == null ? 0 : outgoing.size();
//#endif 


//#if -419369894 
int nIncoming = incoming == null ? 0 : incoming.size();
//#endif 


//#if 1272809387 
if(nIncoming < 1)//1
{ 

//#if 1451627670 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if -522275215 
if(nOutgoing < 1)//1
{ 

//#if -872806112 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if 572514053 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1167420262 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if -669866442 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if -934847342 
ret.add(Model.getMetaTypes().getPseudostate());
//#endif 


//#if -1198699074 
return ret;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

