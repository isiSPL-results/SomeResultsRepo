
//#if -130641308 
// Compilation Unit of /CrForkOutgoingTransition.java 
 

//#if 935103620 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -1388195051 
import java.util.HashSet;
//#endif 


//#if -1231983641 
import java.util.Set;
//#endif 


//#if 29747601 
import org.argouml.cognitive.Designer;
//#endif 


//#if 775113666 
import org.argouml.model.Model;
//#endif 


//#if 1662613444 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 251456280 
public class CrForkOutgoingTransition extends 
//#if 1102061346 
CrUML
//#endif 

  { 

//#if -1361546273 
public CrForkOutgoingTransition()
    { 

//#if -1274808265 
setupHeadAndDesc();
//#endif 


//#if -1278914287 
addSupportedDecision(UMLDecision.STATE_MACHINES);
//#endif 


//#if 373936447 
addTrigger("outgoing");
//#endif 

} 

//#endif 


//#if -2000034290 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if 631365359 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if 788432437 
ret.add(Model.getMetaTypes().getTransition());
//#endif 


//#if -1286505545 
return ret;
//#endif 

} 

//#endif 


//#if 1657382641 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 63684412 
if(!(Model.getFacade().isATransition(dm)))//1
{ 

//#if -1333257476 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 363941527 
Object tr = dm;
//#endif 


//#if -793489701 
Object target = Model.getFacade().getTarget(tr);
//#endif 


//#if -1467129529 
Object source = Model.getFacade().getSource(tr);
//#endif 


//#if 1326619296 
if(!(Model.getFacade().isAPseudostate(source)))//1
{ 

//#if -423570350 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1737587732 
if(!Model.getFacade().equalsPseudostateKind(
                    Model.getFacade().getKind(source),
                    Model.getPseudostateKind().getFork()))//1
{ 

//#if -119719208 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 270339354 
if(Model.getFacade().isAState(target))//1
{ 

//#if 747956248 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -442976626 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

