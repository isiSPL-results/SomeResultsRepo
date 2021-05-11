
//#if 1906477220 
// Compilation Unit of /CrMultipleAgg.java 
 

//#if -587405245 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -374305842 
import java.util.Collection;
//#endif 


//#if 1035887990 
import java.util.HashSet;
//#endif 


//#if -246524866 
import java.util.Iterator;
//#endif 


//#if 1479562952 
import java.util.Set;
//#endif 


//#if 276550759 
import org.argouml.cognitive.Critic;
//#endif 


//#if 751828176 
import org.argouml.cognitive.Designer;
//#endif 


//#if -768157470 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if -893988509 
import org.argouml.model.Model;
//#endif 


//#if -544338011 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -67650179 
public class CrMultipleAgg extends 
//#if 399185589 
CrUML
//#endif 

  { 

//#if 602017163 
public Class getWizardClass(ToDoItem item)
    { 

//#if -121514955 
return WizAssocComposite.class;
//#endif 

} 

//#endif 


//#if -455952927 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if 270318358 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if 594798014 
ret.add(Model.getMetaTypes().getAssociationClass());
//#endif 


//#if 253213342 
return ret;
//#endif 

} 

//#endif 


//#if -1756491586 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 92457844 
if(!(Model.getFacade().isAAssociation(dm)))//1
{ 

//#if -1093736194 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1637617313 
Object asc = /*(MAssociation)*/ dm;
//#endif 


//#if -79358124 
if(Model.getFacade().isAAssociationRole(asc))//1
{ 

//#if 1078997901 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -277059319 
Collection   conns = Model.getFacade().getConnections(asc);
//#endif 


//#if 1481916315 
if((conns == null) || (conns.size() != 2))//1
{ 

//#if -440113312 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -986123708 
int      aggCount = 0;
//#endif 


//#if 32665294 
Iterator assocEnds = conns.iterator();
//#endif 


//#if 1685224837 
while (assocEnds.hasNext()) //1
{ 

//#if -1730374824 
Object ae = /*(MAssociationEnd)*/ assocEnds.next();
//#endif 


//#if -967050585 
if(Model.getFacade().isAggregate(ae)
                    || Model.getFacade().isComposite(ae))//1
{ 

//#if -731010446 
aggCount++;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1173468347 
if(aggCount > 1)//1
{ 

//#if 1509371568 
return PROBLEM_FOUND;
//#endif 

} 
else
{ 

//#if 396653665 
return NO_PROBLEM;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1864024234 
public CrMultipleAgg()
    { 

//#if -1919743364 
setupHeadAndDesc();
//#endif 


//#if 1745232954 
addSupportedDecision(UMLDecision.CONTAINMENT);
//#endif 


//#if 352057221 
setKnowledgeTypes(Critic.KT_SEMANTICS);
//#endif 


//#if -155392006 
addTrigger("end_aggregation");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

