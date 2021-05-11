
//#if 45064809 
// Compilation Unit of /CrNoGuard.java 
 

//#if -1891235271 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -1930821440 
import java.util.HashSet;
//#endif 


//#if 808527634 
import java.util.Set;
//#endif 


//#if -253024547 
import org.argouml.cognitive.Critic;
//#endif 


//#if -1363899962 
import org.argouml.cognitive.Designer;
//#endif 


//#if 2114932013 
import org.argouml.model.Model;
//#endif 


//#if 739582447 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -917867430 
public class CrNoGuard extends 
//#if 1372844731 
CrUML
//#endif 

  { 

//#if 1816916856 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if -1048458041 
if(!(Model.getFacade().isATransition(dm)))//1
{ 

//#if 656318432 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -202551335 
Object sourceVertex = Model.getFacade().getSource(dm);
//#endif 


//#if 1834850553 
if(!(Model.getFacade().isAPseudostate(sourceVertex)))//1
{ 

//#if 343433817 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1870347356 
if(!Model.getFacade().equalsPseudostateKind(
                    Model.getFacade().getKind(sourceVertex),
                    Model.getPseudostateKind().getChoice()))//1
{ 

//#if -1499922384 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 158677441 
Object guard = Model.getFacade().getGuard(dm);
//#endif 


//#if 293830027 
boolean noGuard =
            (guard == null
             || Model.getFacade().getExpression(guard) == null
             || Model.getFacade().getBody(
                 Model.getFacade().getExpression(guard)) == null
             || ((String) Model.getFacade().getBody(
                     Model.getFacade().getExpression(guard)))
             .length() == 0);
//#endif 


//#if -2031925381 
if(noGuard)//1
{ 

//#if 576233794 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if -2032780592 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1349440921 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if 1228365111 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if 211864189 
ret.add(Model.getMetaTypes().getTransition());
//#endif 


//#if -1652276225 
return ret;
//#endif 

} 

//#endif 


//#if 1868818307 
public CrNoGuard()
    { 

//#if 985144347 
setupHeadAndDesc();
//#endif 


//#if -97743371 
addSupportedDecision(UMLDecision.STATE_MACHINES);
//#endif 


//#if 468928445 
setKnowledgeTypes(Critic.KT_COMPLETENESS);
//#endif 


//#if -275197772 
addTrigger("guard");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

