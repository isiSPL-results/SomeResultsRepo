// Compilation Unit of /CrAlreadyRealizes.java 
 

//#if COGNITIVE 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if COGNITIVE 
import java.util.Collection;
//#endif 


//#if COGNITIVE 
import java.util.HashSet;
//#endif 


//#if COGNITIVE 
import java.util.Set;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Critic;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Designer;
//#endif 


//#if COGNITIVE 
import org.argouml.model.Model;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if COGNITIVE 
public class CrAlreadyRealizes extends CrUML
  { 
private static final long serialVersionUID = -8264991005828634274L;
public CrAlreadyRealizes()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.INHERITANCE);
setKnowledgeTypes(Critic.KT_SEMANTICS, Critic.KT_PRESENTATION);
addTrigger("generalization");
addTrigger("realization");
} 

public boolean predicate2(Object dm, Designer dsgr)
    { 
boolean problem = NO_PROBLEM;
if(Model.getFacade().isAClass(dm))//1
{ 
Collection col =
                Model.getCoreHelper().getAllRealizedInterfaces(dm);
Set set = new HashSet();
set.addAll(col);
if(set.size() < col.size())//1
{ 
problem = PROBLEM_FOUND;
} 

} 

return problem;
} 

public Set<Object> getCriticizedDesignMaterials()
    { 
Set<Object> ret = new HashSet<Object>();
ret.add(Model.getMetaTypes().getUMLClass());
return ret;
} 

 } 

//#endif 


