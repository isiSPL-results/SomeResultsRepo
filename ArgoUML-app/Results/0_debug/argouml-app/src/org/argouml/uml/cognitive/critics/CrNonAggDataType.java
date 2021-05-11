
//#if -640631326 
// Compilation Unit of /CrNonAggDataType.java 
 

//#if -237548859 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 2091574964 
import java.util.HashSet;
//#endif 


//#if -442816762 
import java.util.Set;
//#endif 


//#if -412434327 
import org.argouml.cognitive.Critic;
//#endif 


//#if 62124114 
import org.argouml.cognitive.Designer;
//#endif 


//#if -62854111 
import org.argouml.model.Model;
//#endif 


//#if -1858370077 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 547907310 
public class CrNonAggDataType extends 
//#if -741172485 
CrUML
//#endif 

  { 

//#if 1515486203 
public CrNonAggDataType()
    { 

//#if -1610022157 
setupHeadAndDesc();
//#endif 


//#if -457205405 
addSupportedDecision(UMLDecision.CONTAINMENT);
//#endif 


//#if -1432204202 
addSupportedDecision(UMLDecision.CLASS_SELECTION);
//#endif 


//#if -1350714312 
setKnowledgeTypes(Critic.KT_SYNTAX);
//#endif 

} 

//#endif 


//#if 353993383 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if -1534427850 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if -190310933 
ret.add(Model.getMetaTypes().getDataType());
//#endif 


//#if 61072574 
return ret;
//#endif 

} 

//#endif 


//#if 70751032 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 2013086565 
return NO_PROBLEM;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

