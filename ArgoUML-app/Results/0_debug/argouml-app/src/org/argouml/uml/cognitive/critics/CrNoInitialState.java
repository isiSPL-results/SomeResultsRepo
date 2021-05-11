
//#if 613684501 
// Compilation Unit of /CrNoInitialState.java 
 

//#if -960880975 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 1588165308 
import java.util.Collection;
//#endif 


//#if -549483192 
import java.util.HashSet;
//#endif 


//#if 2146576044 
import java.util.Iterator;
//#endif 


//#if 1913796506 
import java.util.Set;
//#endif 


//#if -694838722 
import org.argouml.cognitive.Designer;
//#endif 


//#if -10792011 
import org.argouml.model.Model;
//#endif 


//#if 1500453495 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -2045906224 
public class CrNoInitialState extends 
//#if -835902748 
CrUML
//#endif 

  { 

//#if 289293679 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 1095945019 
if(!(Model.getFacade().isACompositeState(dm)))//1
{ 

//#if 843928918 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 476543243 
Object cs = /*(MCompositeState)*/ dm;
//#endif 


//#if -1466582000 
if(Model.getFacade().getStateMachine(cs) == null)//1
{ 

//#if 1795845658 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 2084858698 
Collection peers = Model.getFacade().getSubvertices(cs);
//#endif 


//#if 1789325956 
int initialStateCount = 0;
//#endif 


//#if 945206310 
if(peers == null)//1
{ 

//#if 392375877 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if 1199296099 
for (Iterator iter = peers.iterator(); iter.hasNext();) //1
{ 

//#if -1703410682 
Object sv = iter.next();
//#endif 


//#if 345845364 
if(Model.getFacade().isAPseudostate(sv)
                    && (Model.getFacade().getKind(sv).equals(
                            Model.getPseudostateKind().getInitial())))//1
{ 

//#if -1542454282 
initialStateCount++;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -911740336 
if(initialStateCount == 0)//1
{ 

//#if 265137321 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if 459895833 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1461119152 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if -780879973 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if -674156074 
ret.add(Model.getMetaTypes().getCompositeState());
//#endif 


//#if -797191325 
return ret;
//#endif 

} 

//#endif 


//#if -279677208 
public CrNoInitialState()
    { 

//#if 1953927972 
setupHeadAndDesc();
//#endif 


//#if 78630718 
addSupportedDecision(UMLDecision.STATE_MACHINES);
//#endif 


//#if -1788326745 
addTrigger("substate");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

