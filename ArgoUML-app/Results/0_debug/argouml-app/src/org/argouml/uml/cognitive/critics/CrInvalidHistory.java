
//#if 1722150957 
// Compilation Unit of /CrInvalidHistory.java 
 

//#if 1003424440 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -729878781 
import java.util.Collection;
//#endif 


//#if 1216665185 
import java.util.HashSet;
//#endif 


//#if 51508531 
import java.util.Set;
//#endif 


//#if -1298685499 
import org.argouml.cognitive.Designer;
//#endif 


//#if 1916904974 
import org.argouml.model.Model;
//#endif 


//#if 1193663760 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -1219039834 
public class CrInvalidHistory extends 
//#if -1927844372 
CrUML
//#endif 

  { 

//#if 2026969176 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if 413069887 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if -91070231 
ret.add(Model.getMetaTypes().getPseudostate());
//#endif 


//#if 1469584135 
return ret;
//#endif 

} 

//#endif 


//#if -1212998225 
public CrInvalidHistory()
    { 

//#if 1159785 
setupHeadAndDesc();
//#endif 


//#if 1644734403 
addSupportedDecision(UMLDecision.STATE_MACHINES);
//#endif 


//#if -743759247 
addTrigger("outgoing");
//#endif 

} 

//#endif 


//#if -2092039321 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 1275793780 
if(!(Model.getFacade().isAPseudostate(dm)))//1
{ 

//#if 1601194845 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1503972329 
Object k = Model.getFacade().getKind(dm);
//#endif 


//#if 597837232 
if(!Model.getFacade().equalsPseudostateKind(k,
                Model.getPseudostateKind().getDeepHistory())
                && !Model.getFacade().equalsPseudostateKind(k,
                        Model.getPseudostateKind().getShallowHistory()))//1
{ 

//#if 1853491471 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -938025560 
Collection outgoing = Model.getFacade().getOutgoings(dm);
//#endif 


//#if 660998534 
int nOutgoing = outgoing == null ? 0 : outgoing.size();
//#endif 


//#if -1290896555 
if(nOutgoing > 1)//1
{ 

//#if -1637583735 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if 1377156767 
return NO_PROBLEM;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

