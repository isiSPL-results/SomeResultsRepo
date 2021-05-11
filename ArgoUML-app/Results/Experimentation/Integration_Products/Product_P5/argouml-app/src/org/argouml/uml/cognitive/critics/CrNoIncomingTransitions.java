package org.argouml.uml.cognitive.critics;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.argouml.cognitive.Designer;
import org.argouml.model.Model;
import org.argouml.uml.cognitive.UMLDecision;
public class CrNoIncomingTransitions extends CrUML
  { 
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
} 
Collection incoming = Model.getFacade().getIncomings(sv);
boolean needsIncoming = incoming == null || incoming.size() == 0;
if(Model.getFacade().isAPseudostate(sv))//2
{ 
if(Model.getFacade().getKind(sv)
                    .equals(Model.getPseudostateKind().getInitial()))//1
{ 
needsIncoming = false;
} 
} 
if(needsIncoming)//1
{ 
return PROBLEM_FOUND;
} 
return NO_PROBLEM;
} 
public Set<Object> getCriticizedDesignMaterials()
    { 
Set<Object> ret = new HashSet<Object>();
ret.add(Model.getMetaTypes().getStateVertex());
return ret;
} 
public CrNoIncomingTransitions()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.STATE_MACHINES);
addTrigger("incoming");
} 

 } 
