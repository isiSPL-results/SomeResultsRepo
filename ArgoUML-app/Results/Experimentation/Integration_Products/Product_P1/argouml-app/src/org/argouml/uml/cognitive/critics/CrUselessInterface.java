package org.argouml.uml.cognitive.critics;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.argouml.cognitive.Critic;
import org.argouml.cognitive.Designer;
import org.argouml.cognitive.Goal;
import org.argouml.model.Model;
import org.argouml.uml.cognitive.UMLDecision;
public class CrUselessInterface extends CrUML
  { 
private static final long serialVersionUID = -6586457111453473553L;
public Set<Object> getCriticizedDesignMaterials()
    { 
Set<Object> ret = new HashSet<Object>();
ret.add(Model.getMetaTypes().getInterface());
return ret;
} 
public boolean predicate2(Object dm, Designer dsgr)
    { 
if(!Model.getFacade().isAInterface(dm))//1
{ 
return NO_PROBLEM;
} 
if(!Model.getFacade().isPrimaryObject(dm))//1
{ 
return NO_PROBLEM;
} 
Iterator iter =
            Model.getFacade().getSupplierDependencies(dm).iterator();
while (iter.hasNext()) //1
{ 
if(Model.getFacade().isRealize(iter.next()))//1
{ 
return NO_PROBLEM;
} 
} 
return PROBLEM_FOUND;
} 
public CrUselessInterface()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.INHERITANCE);
addSupportedGoal(Goal.getUnspecifiedGoal());
setKnowledgeTypes(Critic.KT_COMPLETENESS);
addTrigger("realization");
} 

 } 
