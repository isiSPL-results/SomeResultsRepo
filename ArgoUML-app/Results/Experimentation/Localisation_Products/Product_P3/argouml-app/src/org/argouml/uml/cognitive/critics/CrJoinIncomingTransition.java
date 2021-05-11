package org.argouml.uml.cognitive.critics;
import java.util.HashSet;
import java.util.Set;
import org.argouml.cognitive.Designer;
import org.argouml.model.Model;
import org.argouml.uml.cognitive.UMLDecision;
public class CrJoinIncomingTransition extends CrUML
  { 
public boolean predicate2(Object dm, Designer dsgr)
    { 
if(!(Model.getFacade().isATransition(dm)))//1
{ 
return NO_PROBLEM;
} 
Object tr = dm;
Object target = Model.getFacade().getTarget(tr);
Object source = Model.getFacade().getSource(tr);
if(!(Model.getFacade().isAPseudostate(target)))//1
{ 
return NO_PROBLEM;
} 
if(!Model.getFacade().equalsPseudostateKind(
                    Model.getFacade().getKind(target),
                    Model.getPseudostateKind().getJoin()))//1
{ 
return NO_PROBLEM;
} 
if(Model.getFacade().isAState(source))//1
{ 
return NO_PROBLEM;
} 
return PROBLEM_FOUND;
} 
public CrJoinIncomingTransition()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.STATE_MACHINES);
addTrigger("incoming");
} 
public Set<Object> getCriticizedDesignMaterials()
    { 
Set<Object> ret = new HashSet<Object>();
ret.add(Model.getMetaTypes().getTransition());
return ret;
} 

 } 
