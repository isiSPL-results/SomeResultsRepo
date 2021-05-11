
//#if 722932834 
// Compilation Unit of /CrNoOutgoingTransitions.java 
 

//#if 414387797 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -204547744 
import java.util.Collection;
//#endif 


//#if 1615024420 
import java.util.HashSet;
//#endif 


//#if 1667910006 
import java.util.Set;
//#endif 


//#if 1570765794 
import org.argouml.cognitive.Designer;
//#endif 


//#if 1193001617 
import org.argouml.model.Model;
//#endif 


//#if -1855563693 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 1540321035 
public class CrNoOutgoingTransitions extends 
//#if -45896059 
CrUML
//#endif 

  { 

//#if 1372096945 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if -1419815733 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if 918234591 
ret.add(Model.getMetaTypes().getStateVertex());
//#endif 


//#if 555256979 
return ret;
//#endif 

} 

//#endif 


//#if -312048914 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if -1694242990 
if(!(Model.getFacade().isAStateVertex(dm)))//1
{ 

//#if 315899829 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1559114999 
Object sv = /*(MStateVertex)*/ dm;
//#endif 


//#if -1748492350 
if(Model.getFacade().isAState(sv))//1
{ 

//#if 1740625597 
Object sm = Model.getFacade().getStateMachine(sv);
//#endif 


//#if 1214097761 
if(sm != null && Model.getFacade().getTop(sm) == sv)//1
{ 

//#if -1439193158 
return NO_PROBLEM;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -851904892 
if(Model.getFacade().isAPseudostate(sv))//1
{ 

//#if -1974815297 
Object k = Model.getFacade().getKind(sv);
//#endif 


//#if -1548966372 
if(k.equals(Model.getPseudostateKind().getChoice()))//1
{ 

//#if 18028066 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -646591031 
if(k.equals(Model.getPseudostateKind().getJunction()))//1
{ 

//#if 1589900924 
return NO_PROBLEM;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1625756510 
Collection outgoing = Model.getFacade().getOutgoings(sv);
//#endif 


//#if -833325397 
boolean needsOutgoing = outgoing == null || outgoing.size() == 0;
//#endif 


//#if -1702066314 
if(Model.getFacade().isAFinalState(sv))//1
{ 

//#if -712719177 
needsOutgoing = false;
//#endif 

} 

//#endif 


//#if 1077859057 
if(needsOutgoing)//1
{ 

//#if -993502850 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if 1238982399 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -465236774 
public CrNoOutgoingTransitions()
    { 

//#if -2095595102 
setupHeadAndDesc();
//#endif 


//#if -1575023300 
addSupportedDecision(UMLDecision.STATE_MACHINES);
//#endif 


//#if 976547114 
addTrigger("outgoing");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

