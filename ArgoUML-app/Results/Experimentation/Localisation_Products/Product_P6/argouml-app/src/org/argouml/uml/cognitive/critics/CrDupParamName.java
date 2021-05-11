package org.argouml.uml.cognitive.critics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.argouml.cognitive.Critic;
import org.argouml.cognitive.Designer;
import org.argouml.model.Model;
import org.argouml.uml.cognitive.UMLDecision;
public class CrDupParamName extends CrUML
  { 
@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 
if(!Model.getFacade().isABehavioralFeature(dm))//1
{ 
return NO_PROBLEM;
} 
Object bf = dm;
Collection<String> namesSeen = new ArrayList<String>();
Iterator params = Model.getFacade().getParameters(bf).iterator();
while (params.hasNext()) //1
{ 
Object p = params.next();
String pName = Model.getFacade().getName(p);
if(pName == null || "".equals(pName))//1
{ 
continue;
} 
if(namesSeen.contains(pName))//1
{ 
return PROBLEM_FOUND;
} 
namesSeen.add(pName);
} 
return NO_PROBLEM;
} 
public CrDupParamName()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.CONTAINMENT);
setKnowledgeTypes(Critic.KT_SYNTAX);
} 
public Set<Object> getCriticizedDesignMaterials()
    { 
Set<Object> ret = new HashSet<Object>();
ret.add(Model.getMetaTypes().getOperation());
return ret;
} 

 } 
