// Compilation Unit of /CrCircularAssocClass.java 
 

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
import java.util.Iterator;
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
public class CrCircularAssocClass extends CrUML
  { 
private static final long serialVersionUID = 5265695413303517728L;
public boolean predicate2(Object dm, Designer dsgr)
    { 
if(!Model.getFacade().isAAssociationClass(dm))//1
{ 
return NO_PROBLEM;
} 

Collection participants = Model.getFacade().getConnections(dm);
if(participants == null)//1
{ 
return NO_PROBLEM;
} 

Iterator iter = participants.iterator();
while (iter.hasNext()) //1
{ 
Object aEnd = iter.next();
if(Model.getFacade().isAAssociationEnd(aEnd))//1
{ 
Object type = Model.getFacade().getType(aEnd);
if(Model.getFacade().isAAssociationClass(type))//1
{ 
return PROBLEM_FOUND;
} 

} 

} 

return NO_PROBLEM;
} 

public Set<Object> getCriticizedDesignMaterials()
    { 
Set<Object> ret = new HashSet<Object>();
ret.add(Model.getMetaTypes().getAssociationClass());
return ret;
} 

public CrCircularAssocClass()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.RELATIONSHIPS);
setKnowledgeTypes(Critic.KT_SEMANTICS);
} 

 } 

//#endif 


