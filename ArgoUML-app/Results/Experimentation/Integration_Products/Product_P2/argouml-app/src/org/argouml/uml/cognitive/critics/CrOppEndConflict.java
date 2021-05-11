package org.argouml.uml.cognitive.critics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.argouml.cognitive.Critic;
import org.argouml.cognitive.Designer;
import org.argouml.model.Model;
import org.argouml.uml.cognitive.UMLDecision;
public class CrOppEndConflict extends CrUML
  { 
public boolean predicate2(Object dm, Designer dsgr)
    { 
boolean problem = NO_PROBLEM;
if(Model.getFacade().isAClassifier(dm))//1
{ 
Collection col = Model.getCoreHelper().getAssociations(dm);
List names = new ArrayList();
Iterator it = col.iterator();
String name = null;
while (it.hasNext()) //1
{ 
name = Model.getFacade().getName(it.next());
if(name == null || name.equals(""))//1
{ 
continue;
} 
if(names.contains(name))//1
{ 
problem = PROBLEM_FOUND;
break;

} 
} 
} 
return problem;
} 
public CrOppEndConflict()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.INHERITANCE);
addSupportedDecision(UMLDecision.RELATIONSHIPS);
addSupportedDecision(UMLDecision.NAMING);
setKnowledgeTypes(Critic.KT_SYNTAX);
addTrigger("associationEnd");
} 
public Set<Object> getCriticizedDesignMaterials()
    { 
Set<Object> ret = new HashSet<Object>();
ret.add(Model.getMetaTypes().getAssociationEnd());
return ret;
} 

 } 
