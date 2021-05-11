
//#if -547636819 
// Compilation Unit of /CrNoIncomingTransitions.java 
 

//#if -1721229893 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -1162726586 
import java.util.Collection;
//#endif 


//#if -292376322 
import java.util.HashSet;
//#endif 


//#if 1271375440 
import java.util.Set;
//#endif 


//#if 1818275400 
import org.argouml.cognitive.Designer;
//#endif 


//#if 439768811 
import org.argouml.model.Model;
//#endif 


//#if 1603356461 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 134818155 
public class CrNoIncomingTransitions extends 
//#if 1187740065 
CrUML
//#endif 

  { 

//#if -672077998 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if -2125658920 
if(!(Model.getFacade().isAStateVertex(dm)))//1
{ 

//#if 830662516 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1432532111 
Object sv = /*(MStateVertex)*/ dm;
//#endif 


//#if -47410308 
if(Model.getFacade().isAState(sv))//1
{ 

//#if 1479686195 
Object sm = Model.getFacade().getStateMachine(sv);
//#endif 


//#if -440564393 
if(sm != null && Model.getFacade().getTop(sm) == sv)//1
{ 

//#if -1060803441 
return NO_PROBLEM;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1937913534 
if(Model.getFacade().isAPseudostate(sv))//1
{ 

//#if -162838328 
Object k = Model.getFacade().getKind(sv);
//#endif 


//#if 1705338419 
if(k.equals(Model.getPseudostateKind().getChoice()))//1
{ 

//#if -698312877 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 4121632 
if(k.equals(Model.getPseudostateKind().getJunction()))//1
{ 

//#if 886757846 
return NO_PROBLEM;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1451123996 
Collection incoming = Model.getFacade().getIncomings(sv);
//#endif 


//#if -620081545 
boolean needsIncoming = incoming == null || incoming.size() == 0;
//#endif 


//#if -568224973 
if(Model.getFacade().isAPseudostate(sv))//2
{ 

//#if -164216889 
if(Model.getFacade().getKind(sv)
                    .equals(Model.getPseudostateKind().getInitial()))//1
{ 

//#if -1508269394 
needsIncoming = false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -47406159 
if(needsIncoming)//1
{ 

//#if 1726880418 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if -420645959 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1198870067 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if 1270129258 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if -1252430112 
ret.add(Model.getMetaTypes().getStateVertex());
//#endif 


//#if -381148430 
return ret;
//#endif 

} 

//#endif 


//#if -1977932164 
public CrNoIncomingTransitions()
    { 

//#if 1788550918 
setupHeadAndDesc();
//#endif 


//#if 2114970528 
addSupportedDecision(UMLDecision.STATE_MACHINES);
//#endif 


//#if -1651097196 
addTrigger("incoming");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

