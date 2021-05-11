
//#if -326596429 
// Compilation Unit of /CrJoinIncomingTransition.java 
 

//#if 974778458 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -513691521 
import java.util.HashSet;
//#endif 


//#if 1396477521 
import java.util.Set;
//#endif 


//#if -1259689881 
import org.argouml.cognitive.Designer;
//#endif 


//#if 932049324 
import org.argouml.model.Model;
//#endif 


//#if -1795261394 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -1953197552 
public class CrJoinIncomingTransition extends 
//#if -1696733905 
CrUML
//#endif 

  { 

//#if 662066052 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if -793694892 
if(!(Model.getFacade().isATransition(dm)))//1
{ 

//#if 147118561 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1846500735 
Object tr = dm;
//#endif 


//#if -1650869005 
Object target = Model.getFacade().getTarget(tr);
//#endif 


//#if 1970458463 
Object source = Model.getFacade().getSource(tr);
//#endif 


//#if 939054206 
if(!(Model.getFacade().isAPseudostate(target)))//1
{ 

//#if 687372708 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1799962738 
if(!Model.getFacade().equalsPseudostateKind(
                    Model.getFacade().getKind(target),
                    Model.getPseudostateKind().getJoin()))//1
{ 

//#if 2090498081 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1100076776 
if(Model.getFacade().isAState(source))//1
{ 

//#if -1208792652 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 470637942 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if -369010732 
public CrJoinIncomingTransition()
    { 

//#if -442288373 
setupHeadAndDesc();
//#endif 


//#if 912909541 
addSupportedDecision(UMLDecision.STATE_MACHINES);
//#endif 


//#if -1491546343 
addTrigger("incoming");
//#endif 

} 

//#endif 


//#if 1504889819 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if -913930699 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if 755453435 
ret.add(Model.getMetaTypes().getTransition());
//#endif 


//#if -1136808323 
return ret;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

