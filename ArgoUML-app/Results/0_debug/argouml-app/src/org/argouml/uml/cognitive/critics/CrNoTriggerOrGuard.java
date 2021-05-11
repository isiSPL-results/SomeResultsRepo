
//#if -905738643 
// Compilation Unit of /CrNoTriggerOrGuard.java 
 

//#if -1768230781 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -143272650 
import java.util.HashSet;
//#endif 


//#if 1754637960 
import java.util.Set;
//#endif 


//#if -1168831321 
import org.argouml.cognitive.Critic;
//#endif 


//#if -985914096 
import org.argouml.cognitive.Designer;
//#endif 


//#if -1618251485 
import org.argouml.model.Model;
//#endif 


//#if 1559240549 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 1885865183 
public class CrNoTriggerOrGuard extends 
//#if -83426708 
CrUML
//#endif 

  { 

//#if 1248244924 
private static final long serialVersionUID = -301548543890007262L;
//#endif 


//#if -2087747865 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 1015291523 
if(!(Model.getFacade().isATransition(dm)))//1
{ 

//#if 637719654 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1128725892 
Object transition = /*(MTransition)*/ dm;
//#endif 


//#if 875274553 
Object target = Model.getFacade().getTarget(transition);
//#endif 


//#if -276281169 
if(!(Model.getFacade().isAPseudostate(target)))//1
{ 

//#if 249828865 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -654721815 
Object trigger = Model.getFacade().getTrigger(transition);
//#endif 


//#if -1310652855 
Object guard = Model.getFacade().getGuard(transition);
//#endif 


//#if 2142341029 
Object source = Model.getFacade().getSource(transition);
//#endif 


//#if -1090511406 
Object k = Model.getFacade().getKind(target);
//#endif 


//#if -1063021609 
if(Model.getFacade().
                equalsPseudostateKind(k,
                                      Model.getPseudostateKind().getJoin()))//1
{ 

//#if -1354398344 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1257080379 
if(!(Model.getFacade().isAState(source)))//1
{ 

//#if 1736876789 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1999378286 
if(Model.getFacade().getDoActivity(source) != null)//1
{ 

//#if 1976204802 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 297104794 
boolean hasTrigger =
            (trigger != null
             && Model.getFacade().getName(trigger) != null
             && Model.getFacade().getName(trigger).length() > 0);
//#endif 


//#if -616170733 
if(hasTrigger)//1
{ 

//#if -463880554 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1353935359 
boolean noGuard =
            (guard == null
             || Model.getFacade().getExpression(guard) == null
             || Model.getFacade().getBody(
                 Model.getFacade().getExpression(guard)) == null
             || Model
             .getFacade().getBody(Model.getFacade().getExpression(guard))
             .toString().length() == 0);
//#endif 


//#if 403914047 
if(noGuard)//1
{ 

//#if -697241158 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if 587153036 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1624304797 
public CrNoTriggerOrGuard()
    { 

//#if -568755263 
setupHeadAndDesc();
//#endif 


//#if 789546779 
addSupportedDecision(UMLDecision.STATE_MACHINES);
//#endif 


//#if 947498327 
setKnowledgeTypes(Critic.KT_COMPLETENESS);
//#endif 


//#if -635240933 
addTrigger("trigger");
//#endif 


//#if -1201445426 
addTrigger("guard");
//#endif 

} 

//#endif 


//#if -2134962984 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if -544912559 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if -1541971945 
ret.add(Model.getMetaTypes().getTransition());
//#endif 


//#if 2091556505 
return ret;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

