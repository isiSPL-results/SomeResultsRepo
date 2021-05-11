package org.argouml.uml.cognitive.critics;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.argouml.cognitive.Designer;
import org.argouml.model.Model;
import org.argouml.uml.cognitive.UMLDecision;
public class CrInvalidFork extends CrUML
  { 
public Set<Object> getCriticizedDesignMaterials()
    { 
Set<Object> ret = new HashSet<Object>();
ret.add(Model.getMetaTypes().getPseudostate());
return ret;
} 
public CrInvalidFork()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.STATE_MACHINES);
addTrigger("incoming");
} 
public boolean predicate2(Object dm, Designer dsgr)
    { 
if(!(Model.getFacade().isAPseudostate(dm)))//1
{ 
return NO_PROBLEM;
} 
Object k = Model.getFacade().getKind(dm);
if(!Model.getFacade().equalsPseudostateKind(
                    k,
                    Model.getPseudostateKind().getFork()))//1
{ 
return NO_PROBLEM;
} 
Collection outgoing = Model.getFacade().getOutgoings(dm);
Collection incoming = Model.getFacade().getIncomings(dm);
int nOutgoing = outgoing == null ? 0 : outgoing.size();
int nIncoming = incoming == null ? 0 : incoming.size();
if(nIncoming > 1)//1
{ 
return PROBLEM_FOUND;
} 
if(nOutgoing == 1)//1
{ 
return PROBLEM_FOUND;
} 
return NO_PROBLEM;
} 

 } 
