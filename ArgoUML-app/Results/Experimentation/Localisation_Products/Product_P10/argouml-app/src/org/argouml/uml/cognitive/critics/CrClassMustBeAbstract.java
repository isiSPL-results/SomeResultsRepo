package org.argouml.uml.cognitive.critics;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.argouml.cognitive.Critic;
import org.argouml.cognitive.Designer;
import org.argouml.model.Model;
import org.argouml.uml.cognitive.UMLDecision;
public class CrClassMustBeAbstract extends CrUML
  { 
private static final long serialVersionUID = -3881153331169214357L;
public boolean predicate2(Object dm, Designer dsgr)
    { 
if(!(Model.getFacade().isAClass(dm)))//1
{ 
return NO_PROBLEM;
} 
if(Model.getFacade().isAbstract(dm))//1
{ 
return NO_PROBLEM;
} 
Iterator ops = Model.getFacade().getOperations(dm).iterator();
while (ops.hasNext()) //1
{ 
if(Model.getFacade().isAbstract(ops.next()))//1
{ 
return PROBLEM_FOUND;
} 
} 
return NO_PROBLEM;
} 
public Set<Object> getCriticizedDesignMaterials()
    { 
Set<Object> ret = new HashSet<Object>();
ret.add(Model.getMetaTypes().getUMLClass());
return ret;
} 
public CrClassMustBeAbstract()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.INHERITANCE);
addSupportedDecision(UMLDecision.METHODS);
setKnowledgeTypes(Critic.KT_SEMANTICS);
} 

 } 
