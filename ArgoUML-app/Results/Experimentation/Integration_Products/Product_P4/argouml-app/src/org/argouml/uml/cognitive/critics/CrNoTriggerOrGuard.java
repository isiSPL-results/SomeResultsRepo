package org.argouml.uml.cognitive.critics;
import java.util.HashSet;
import java.util.Set;
import org.argouml.cognitive.Critic;
import org.argouml.cognitive.Designer;
import org.argouml.model.Model;
import org.argouml.uml.cognitive.UMLDecision;
public class CrNoTriggerOrGuard extends CrUML
  { 
private static final long serialVersionUID = -301548543890007262L;
public boolean predicate2(Object dm, Designer dsgr)
    { 
if(!(Model.getFacade().isATransition(dm)))//1
{ 
return NO_PROBLEM;
} 
Object transition = /*(MTransition)*/ dm;
Object target = Model.getFacade().getTarget(transition);
if(!(Model.getFacade().isAPseudostate(target)))//1
{ 
return NO_PROBLEM;
} 
Object trigger = Model.getFacade().getTrigger(transition);
Object guard = Model.getFacade().getGuard(transition);
Object source = Model.getFacade().getSource(transition);
Object k = Model.getFacade().getKind(target);
if(Model.getFacade().
                equalsPseudostateKind(k,
                                      Model.getPseudostateKind().getJoin()))//1
{ 
return NO_PROBLEM;
} 
if(!(Model.getFacade().isAState(source)))//1
{ 
return NO_PROBLEM;
} 
if(Model.getFacade().getDoActivity(source) != null)//1
{ 
return NO_PROBLEM;
} 
boolean hasTrigger =
            (trigger != null
             && Model.getFacade().getName(trigger) != null
             && Model.getFacade().getName(trigger).length() > 0);
if(hasTrigger)//1
{ 
return NO_PROBLEM;
} 
boolean noGuard =
            (guard == null
             || Model.getFacade().getExpression(guard) == null
             || Model.getFacade().getBody(
                 Model.getFacade().getExpression(guard)) == null
             || Model
             .getFacade().getBody(Model.getFacade().getExpression(guard))
             .toString().length() == 0);
if(noGuard)//1
{ 
return PROBLEM_FOUND;
} 
return NO_PROBLEM;
} 
public CrNoTriggerOrGuard()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.STATE_MACHINES);
setKnowledgeTypes(Critic.KT_COMPLETENESS);
addTrigger("trigger");
addTrigger("guard");
} 
public Set<Object> getCriticizedDesignMaterials()
    { 
Set<Object> ret = new HashSet<Object>();
ret.add(Model.getMetaTypes().getTransition());
return ret;
} 

 } 
