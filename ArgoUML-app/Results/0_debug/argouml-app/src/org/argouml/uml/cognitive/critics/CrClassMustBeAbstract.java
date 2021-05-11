
//#if 1997862633 
// Compilation Unit of /CrClassMustBeAbstract.java 
 

//#if 822994597 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -1252684076 
import java.util.HashSet;
//#endif 


//#if 1822185120 
import java.util.Iterator;
//#endif 


//#if 1964957478 
import java.util.Set;
//#endif 


//#if 188466249 
import org.argouml.cognitive.Critic;
//#endif 


//#if 2001959986 
import org.argouml.cognitive.Designer;
//#endif 


//#if 1091894337 
import org.argouml.model.Model;
//#endif 


//#if -987701757 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 441205776 
public class CrClassMustBeAbstract extends 
//#if 1881692821 
CrUML
//#endif 

  { 

//#if -817654634 
private static final long serialVersionUID = -3881153331169214357L;
//#endif 


//#if -2130269986 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if -805459257 
if(!(Model.getFacade().isAClass(dm)))//1
{ 

//#if -584063444 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -898757802 
if(Model.getFacade().isAbstract(dm))//1
{ 

//#if -2020693924 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1808638950 
Iterator ops = Model.getFacade().getOperations(dm).iterator();
//#endif 


//#if -1225254880 
while (ops.hasNext()) //1
{ 

//#if -1895635231 
if(Model.getFacade().isAbstract(ops.next()))//1
{ 

//#if -1598983567 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 920908935 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 841818561 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if 1708048447 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if 1950027508 
ret.add(Model.getMetaTypes().getUMLClass());
//#endif 


//#if -504536825 
return ret;
//#endif 

} 

//#endif 


//#if 958651007 
public CrClassMustBeAbstract()
    { 

//#if 703425203 
setupHeadAndDesc();
//#endif 


//#if -960544709 
addSupportedDecision(UMLDecision.INHERITANCE);
//#endif 


//#if -877046621 
addSupportedDecision(UMLDecision.METHODS);
//#endif 


//#if 289609276 
setKnowledgeTypes(Critic.KT_SEMANTICS);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

