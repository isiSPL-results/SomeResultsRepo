package org.argouml.uml.cognitive.critics;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.argouml.cognitive.Critic;
import org.argouml.cognitive.Designer;
import org.argouml.model.Model;
import org.argouml.uml.cognitive.UMLDecision;
public class CrNoTransitions extends CrUML
  { 
public Set<Object> getCriticizedDesignMaterials()
    { 
Set<Object> ret = new HashSet<Object>();
ret.add(Model.getMetaTypes().getStateVertex());
return ret;
} 
public CrNoTransitions()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.STATE_MACHINES);
setKnowledgeTypes(Critic.KT_COMPLETENESS);
addTrigger("incoming");
addTrigger("outgoing");
} 
public boolean predicate2(Object dm, Designer dsgr)
    { 
if(!(Model.getFacade().isAStateVertex(dm)))//1
{ 
return NO_PROBLEM;
} 
Object sv = /*(MStateVertex)*/ dm;
if(Model.getFacade().isAState(sv))//1
{ 
Object sm = Model.getFacade().getStateMachine(sv);
if(sm != null && Model.getFacade().getTop(sm) == sv)//1
{ 
return NO_PROBLEM;
} 
} 
Collection outgoing = Model.getFacade().getOutgoings(sv);
Collection incoming = Model.getFacade().getIncomings(sv);
boolean needsOutgoing = outgoing == null || outgoing.size() == 0;
boolean needsIncoming = incoming == null || incoming.size() == 0;
if(Model.getFacade().isAPseudostate(sv))//1
{ 
Object k = Model.getFacade().getKind(sv);
if(k.equals(Model.getPseudostateKind().getChoice()))//1
{ 
return NO_PROBLEM;
} 
if(k.equals(Model.getPseudostateKind().getJunction()))//1
{ 
return NO_PROBLEM;
} 
if(k.equals(Model.getPseudostateKind().getInitial()))//1
{ 
needsIncoming = false;
} 
} 
if(Model.getFacade().isAFinalState(sv))//1
{ 
needsOutgoing = false;
} 
if(needsIncoming && needsOutgoing)//1
{ 
return PROBLEM_FOUND;
} 
return NO_PROBLEM;
} 

 } 
