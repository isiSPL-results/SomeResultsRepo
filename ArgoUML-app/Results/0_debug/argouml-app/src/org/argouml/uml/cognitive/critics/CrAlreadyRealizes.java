
//#if 1003857905 
// Compilation Unit of /CrAlreadyRealizes.java 
 

//#if -1030899961 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 1766113682 
import java.util.Collection;
//#endif 


//#if 1693951538 
import java.util.HashSet;
//#endif 


//#if 1891587460 
import java.util.Set;
//#endif 


//#if 1802503723 
import org.argouml.cognitive.Critic;
//#endif 


//#if -1686188652 
import org.argouml.cognitive.Designer;
//#endif 


//#if 1259574559 
import org.argouml.model.Model;
//#endif 


//#if -1376019871 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 604066333 
public class CrAlreadyRealizes extends 
//#if 1021594056 
CrUML
//#endif 

  { 

//#if 521490127 
private static final long serialVersionUID = -8264991005828634274L;
//#endif 


//#if -1591328991 
public CrAlreadyRealizes()
    { 

//#if 712661277 
setupHeadAndDesc();
//#endif 


//#if -635789423 
addSupportedDecision(UMLDecision.INHERITANCE);
//#endif 


//#if 704720832 
setKnowledgeTypes(Critic.KT_SEMANTICS, Critic.KT_PRESENTATION);
//#endif 


//#if 1527242837 
addTrigger("generalization");
//#endif 


//#if 251721649 
addTrigger("realization");
//#endif 

} 

//#endif 


//#if -127062261 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 583522634 
boolean problem = NO_PROBLEM;
//#endif 


//#if 815544792 
if(Model.getFacade().isAClass(dm))//1
{ 

//#if 1835187218 
Collection col =
                Model.getCoreHelper().getAllRealizedInterfaces(dm);
//#endif 


//#if 1826987101 
Set set = new HashSet();
//#endif 


//#if 628936010 
set.addAll(col);
//#endif 


//#if 1270241359 
if(set.size() < col.size())//1
{ 

//#if 1374414449 
problem = PROBLEM_FOUND;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2075783170 
return problem;
//#endif 

} 

//#endif 


//#if -1483251404 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if -241312383 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if -1153316298 
ret.add(Model.getMetaTypes().getUMLClass());
//#endif 


//#if 1954385097 
return ret;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

