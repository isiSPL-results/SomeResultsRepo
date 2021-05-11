package org.argouml.uml.cognitive.critics;
import java.util.HashSet;
import java.util.Set;
import org.argouml.cognitive.Designer;
import org.argouml.model.Model;
import org.argouml.uml.cognitive.UMLDecision;
public class CrForkOutgoingTransition extends CrUML
  { 
public CrForkOutgoingTransition()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.STATE_MACHINES);
addTrigger("outgoing");
} 
public Set<Object> getCriticizedDesignMaterials()
    { 
Set<Object> ret = new HashSet<Object>();
ret.add(Model.getMetaTypes().getTransition());
return ret;
} 
public boolean predicate2(Object dm, Designer dsgr)
    { 
if(!(Model.getFacade().isATransition(dm)))//1
{ 
return NO_PROBLEM;
} 
Object tr = dm;
Object target = Model.getFacade().getTarget(tr);
Object source = Model.getFacade().getSource(tr);
if(!(Model.getFacade().isAPseudostate(source)))//1
{ 
return NO_PROBLEM;
} 
if(!Model.getFacade().equalsPseudostateKind(
                    Model.getFacade().getKind(source),
                    Model.getPseudostateKind().getFork()))//1
{ 
return NO_PROBLEM;
} 
if(Model.getFacade().isAState(target))//1
{ 
return NO_PROBLEM;
} 
return PROBLEM_FOUND;
} 

 } 
