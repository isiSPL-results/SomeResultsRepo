// Compilation Unit of /CrInvalidPseudoStateTrigger.java 
 
package org.argouml.uml.cognitive.critics;
import java.util.HashSet;
import java.util.Set;
import org.argouml.cognitive.Designer;
import org.argouml.model.Model;
import org.argouml.uml.cognitive.UMLDecision;
public class CrInvalidPseudoStateTrigger extends CrUML
  { 
public boolean predicate2(Object dm, Designer dsgr)
    { 
if(!(Model.getFacade().isATransition(dm)))//1
{ 
return NO_PROBLEM;
} 

Object tr = dm;
Object t = Model.getFacade().getTrigger(tr);
Object sv = Model.getFacade().getSource(tr);
if(!(Model.getFacade().isAPseudostate(sv)))//1
{ 
return NO_PROBLEM;
} 

Object k = Model.getFacade().getKind(sv);
if(Model.getFacade().
                equalsPseudostateKind(k,
                                      Model.getPseudostateKind().getFork()))//1
{ 
return NO_PROBLEM;
} 

boolean hasTrigger =
            (t != null && Model.getFacade().getName(t) != null
             && Model.getFacade().getName(t).length() > 0);
if(hasTrigger)//1
{ 
return PROBLEM_FOUND;
} 

return NO_PROBLEM;
} 

public CrInvalidPseudoStateTrigger()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.STATE_MACHINES);
addTrigger("trigger");
} 

public Set<Object> getCriticizedDesignMaterials()
    { 
Set<Object> ret = new HashSet<Object>();
ret.add(Model.getMetaTypes().getTransition());
return ret;
} 

 } 


