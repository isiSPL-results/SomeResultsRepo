// Compilation Unit of /CrMultipleAgg.java 
 
package org.argouml.uml.cognitive.critics;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.argouml.cognitive.Critic;
import org.argouml.cognitive.Designer;
import org.argouml.cognitive.ToDoItem;
import org.argouml.model.Model;
import org.argouml.uml.cognitive.UMLDecision;
public class CrMultipleAgg extends CrUML
  { 
public Class getWizardClass(ToDoItem item)
    { 
return WizAssocComposite.class;
} 

public Set<Object> getCriticizedDesignMaterials()
    { 
Set<Object> ret = new HashSet<Object>();
ret.add(Model.getMetaTypes().getAssociationClass());
return ret;
} 

public boolean predicate2(Object dm, Designer dsgr)
    { 
if(!(Model.getFacade().isAAssociation(dm)))//1
{ 
return NO_PROBLEM;
} 

Object asc = /*(MAssociation)*/ dm;
if(Model.getFacade().isAAssociationRole(asc))//1
{ 
return NO_PROBLEM;
} 

Collection   conns = Model.getFacade().getConnections(asc);
if((conns == null) || (conns.size() != 2))//1
{ 
return NO_PROBLEM;
} 

int      aggCount = 0;
Iterator assocEnds = conns.iterator();
while (assocEnds.hasNext()) //1
{ 
Object ae = /*(MAssociationEnd)*/ assocEnds.next();
if(Model.getFacade().isAggregate(ae)
                    || Model.getFacade().isComposite(ae))//1
{ 
aggCount++;
} 

} 

if(aggCount > 1)//1
{ 
return PROBLEM_FOUND;
} 
else
{ 
return NO_PROBLEM;
} 

} 

public CrMultipleAgg()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.CONTAINMENT);
setKnowledgeTypes(Critic.KT_SEMANTICS);
addTrigger("end_aggregation");
} 

 } 


