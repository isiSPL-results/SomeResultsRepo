
//#if 922892985 
// Compilation Unit of /CrNWayAgg.java 
 

//#if 603082319 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 1336162010 
import java.util.Collection;
//#endif 


//#if 434468330 
import java.util.HashSet;
//#endif 


//#if -1710665142 
import java.util.Iterator;
//#endif 


//#if -994459332 
import java.util.Set;
//#endif 


//#if 2093593459 
import org.argouml.cognitive.Critic;
//#endif 


//#if -1121826596 
import org.argouml.cognitive.Designer;
//#endif 


//#if 161790679 
import org.argouml.model.Model;
//#endif 


//#if 1725718041 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 911112896 
public class CrNWayAgg extends 
//#if -2110174231 
CrUML
//#endif 

  { 

//#if 2130247055 
private static final long serialVersionUID = 5318978944855930303L;
//#endif 


//#if -2097599979 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if -1122351952 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if -1536230568 
ret.add(Model.getMetaTypes().getAssociationClass());
//#endif 


//#if -713486152 
return ret;
//#endif 

} 

//#endif 


//#if 1080572141 
public CrNWayAgg()
    { 

//#if 1659142048 
setupHeadAndDesc();
//#endif 


//#if 769169558 
addSupportedDecision(UMLDecision.CONTAINMENT);
//#endif 


//#if -981241175 
setKnowledgeTypes(Critic.KT_SEMANTICS);
//#endif 


//#if -1388866698 
addTrigger("connection");
//#endif 


//#if -1705274282 
addTrigger("end_aggregation");
//#endif 

} 

//#endif 


//#if -1255258614 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if -2009011732 
if(!(Model.getFacade().isAAssociation(dm)))//1
{ 

//#if -470960483 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1675874089 
Object asc = /*(MAssociation)*/ dm;
//#endif 


//#if -956991540 
if(Model.getFacade().isAAssociationRole(asc))//1
{ 

//#if 348840300 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1498451841 
Collection conns = Model.getFacade().getConnections(asc);
//#endif 


//#if 804697000 
if((conns == null) || (conns.size() <= 2))//1
{ 

//#if -1620726283 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 567716694 
Iterator assocEnds = conns.iterator();
//#endif 


//#if 1631633421 
while (assocEnds.hasNext()) //1
{ 

//#if -2058637364 
Object ae = /*(MAssociationEnd)*/ assocEnds.next();
//#endif 


//#if 998023451 
if(Model.getFacade().isAggregate(ae)
                    || Model.getFacade().isComposite(ae))//1
{ 

//#if 1336529027 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -560751303 
return NO_PROBLEM;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

