package org.argouml.uml.cognitive.critics;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.argouml.cognitive.Designer;
import org.argouml.model.Model;
import org.argouml.uml.cognitive.UMLDecision;
public class CrNoInitialState extends CrUML
  { 
public boolean predicate2(Object dm, Designer dsgr)
    { 
if(!(Model.getFacade().isACompositeState(dm)))//1
{ 
return NO_PROBLEM;
} 
Object cs = /*(MCompositeState)*/ dm;
if(Model.getFacade().getStateMachine(cs) == null)//1
{ 
return NO_PROBLEM;
} 
Collection peers = Model.getFacade().getSubvertices(cs);
int initialStateCount = 0;
if(peers == null)//1
{ 
return PROBLEM_FOUND;
} 
for (Iterator iter = peers.iterator(); iter.hasNext();) //1
{ 
Object sv = iter.next();
if(Model.getFacade().isAPseudostate(sv)
                    && (Model.getFacade().getKind(sv).equals(
                            Model.getPseudostateKind().getInitial())))//1
{ 
initialStateCount++;
} 
} 
if(initialStateCount == 0)//1
{ 
return PROBLEM_FOUND;
} 
return NO_PROBLEM;
} 
public Set<Object> getCriticizedDesignMaterials()
    { 
Set<Object> ret = new HashSet<Object>();
ret.add(Model.getMetaTypes().getCompositeState());
return ret;
} 
public CrNoInitialState()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.STATE_MACHINES);
addTrigger("substate");
} 

 } 
