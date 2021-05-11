// Compilation Unit of /CrInterfaceOperOnly.java 
 
package org.argouml.uml.cognitive.critics;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.argouml.cognitive.Critic;
import org.argouml.cognitive.Designer;
import org.argouml.model.Model;
import org.argouml.uml.cognitive.UMLDecision;
public class CrInterfaceOperOnly extends CrUML
  { 
public Set<Object> getCriticizedDesignMaterials()
    { 
Set<Object> ret = new HashSet<Object>();
ret.add(Model.getMetaTypes().getInterface());
return ret;
} 

public boolean predicate2(Object dm, Designer dsgr)
    { 
if(!(Model.getFacade().isAInterface(dm)))//1
{ 
return NO_PROBLEM;
} 

Object inf = dm;
Collection sf = Model.getFacade().getFeatures(inf);
if(sf == null)//1
{ 
return NO_PROBLEM;
} 

for (Iterator iter = sf.iterator(); iter.hasNext();) //1
{ 
if(Model.getFacade().isAStructuralFeature(iter.next()))//1
{ 
return PROBLEM_FOUND;
} 

} 

return NO_PROBLEM;
} 

public CrInterfaceOperOnly()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.PLANNED_EXTENSIONS);
setKnowledgeTypes(Critic.KT_SYNTAX);
addTrigger("structuralFeature");
} 

 } 


