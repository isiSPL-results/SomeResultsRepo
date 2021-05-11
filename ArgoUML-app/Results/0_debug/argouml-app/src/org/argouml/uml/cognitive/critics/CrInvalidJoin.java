
//#if -971723631 
// Compilation Unit of /CrInvalidJoin.java 
 

//#if -108237845 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -752478858 
import java.util.Collection;
//#endif 


//#if 1971682510 
import java.util.HashSet;
//#endif 


//#if 152623648 
import java.util.Set;
//#endif 


//#if -1581017992 
import org.argouml.cognitive.Designer;
//#endif 


//#if -1347090757 
import org.argouml.model.Model;
//#endif 


//#if -2139616515 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -647732283 
public class CrInvalidJoin extends 
//#if 1585959074 
CrUML
//#endif 

  { 

//#if 271033713 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 386345469 
if(!(Model.getFacade().isAPseudostate(dm)))//1
{ 

//#if 736390655 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1258756704 
Object k = Model.getFacade().getKind(dm);
//#endif 


//#if 748419386 
if(!Model.getFacade().equalsPseudostateKind(k,
                Model.getPseudostateKind().getJoin()))//1
{ 

//#if -290023518 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1709548239 
Collection outgoing = Model.getFacade().getOutgoings(dm);
//#endif 


//#if 1741790757 
Collection incoming = Model.getFacade().getIncomings(dm);
//#endif 


//#if -228449777 
int nOutgoing = outgoing == null ? 0 : outgoing.size();
//#endif 


//#if -209271927 
int nIncoming = incoming == null ? 0 : incoming.size();
//#endif 


//#if -445412514 
if(nOutgoing > 1)//1
{ 

//#if 1600376659 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if -1646582692 
if(nIncoming == 1)//1
{ 

//#if -788677647 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if 1681525110 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -16411769 
public CrInvalidJoin()
    { 

//#if 1643526597 
setupHeadAndDesc();
//#endif 


//#if -1573984737 
addSupportedDecision(UMLDecision.STATE_MACHINES);
//#endif 


//#if 386177997 
addTrigger("outgoing");
//#endif 

} 

//#endif 


//#if -2027178098 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if -1000712007 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if -1367078353 
ret.add(Model.getMetaTypes().getPseudostate());
//#endif 


//#if 811703809 
return ret;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

