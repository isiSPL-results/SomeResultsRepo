
//#if -818802326 
// Compilation Unit of /CrNoTransitions.java 
 

//#if -32424418 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -2097255191 
import java.util.Collection;
//#endif 


//#if -45444549 
import java.util.HashSet;
//#endif 


//#if -1552699891 
import java.util.Set;
//#endif 


//#if -711955838 
import org.argouml.cognitive.Critic;
//#endif 


//#if -15239125 
import org.argouml.cognitive.Designer;
//#endif 


//#if -123890072 
import org.argouml.model.Model;
//#endif 


//#if 1560356842 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -695150994 
public class CrNoTransitions extends 
//#if 1210370072 
CrUML
//#endif 

  { 

//#if 2077031300 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if 1052874484 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if 439296022 
ret.add(Model.getMetaTypes().getStateVertex());
//#endif 


//#if 988852220 
return ret;
//#endif 

} 

//#endif 


//#if -461262151 
public CrNoTransitions()
    { 

//#if -1825720104 
setupHeadAndDesc();
//#endif 


//#if 566559218 
addSupportedDecision(UMLDecision.STATE_MACHINES);
//#endif 


//#if 269788768 
setKnowledgeTypes(Critic.KT_COMPLETENESS);
//#endif 


//#if -1530682778 
addTrigger("incoming");
//#endif 


//#if -747611808 
addTrigger("outgoing");
//#endif 

} 

//#endif 


//#if -1259140421 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 1022237957 
if(!(Model.getFacade().isAStateVertex(dm)))//1
{ 

//#if 793113349 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1670104764 
Object sv = /*(MStateVertex)*/ dm;
//#endif 


//#if 1990206639 
if(Model.getFacade().isAState(sv))//1
{ 

//#if -193918450 
Object sm = Model.getFacade().getStateMachine(sv);
//#endif 


//#if 1838107762 
if(sm != null && Model.getFacade().getTop(sm) == sv)//1
{ 

//#if -1459493264 
return NO_PROBLEM;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1915240619 
Collection outgoing = Model.getFacade().getOutgoings(sv);
//#endif 


//#if 1536098377 
Collection incoming = Model.getFacade().getIncomings(sv);
//#endif 


//#if 145320094 
boolean needsOutgoing = outgoing == null || outgoing.size() == 0;
//#endif 


//#if -564080028 
boolean needsIncoming = incoming == null || incoming.size() == 0;
//#endif 


//#if -1138567759 
if(Model.getFacade().isAPseudostate(sv))//1
{ 

//#if -329056875 
Object k = Model.getFacade().getKind(sv);
//#endif 


//#if 2084455686 
if(k.equals(Model.getPseudostateKind().getChoice()))//1
{ 

//#if 1332675682 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -736404941 
if(k.equals(Model.getPseudostateKind().getJunction()))//1
{ 

//#if -1977170923 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -251204875 
if(k.equals(Model.getPseudostateKind().getInitial()))//1
{ 

//#if -717159609 
needsIncoming = false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1434218839 
if(Model.getFacade().isAFinalState(sv))//1
{ 

//#if -1284060014 
needsOutgoing = false;
//#endif 

} 

//#endif 


//#if 855254555 
if(needsIncoming && needsOutgoing)//1
{ 

//#if -2393626 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if -764322708 
return NO_PROBLEM;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

