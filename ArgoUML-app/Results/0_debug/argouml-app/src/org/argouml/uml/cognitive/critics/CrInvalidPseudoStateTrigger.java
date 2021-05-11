
//#if -909314036 
// Compilation Unit of /CrInvalidPseudoStateTrigger.java 
 

//#if 1775137307 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 1699975326 
import java.util.HashSet;
//#endif 


//#if 808015344 
import java.util.Set;
//#endif 


//#if 1256207016 
import org.argouml.cognitive.Designer;
//#endif 


//#if 511245963 
import org.argouml.model.Model;
//#endif 


//#if 331749069 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 1543192560 
public class CrInvalidPseudoStateTrigger extends 
//#if -899279107 
CrUML
//#endif 

  { 

//#if 1669988726 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 1507097540 
if(!(Model.getFacade().isATransition(dm)))//1
{ 

//#if -1449554607 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 436388111 
Object tr = dm;
//#endif 


//#if -1757568625 
Object t = Model.getFacade().getTrigger(tr);
//#endif 


//#if 250262151 
Object sv = Model.getFacade().getSource(tr);
//#endif 


//#if 2009454048 
if(!(Model.getFacade().isAPseudostate(sv)))//1
{ 

//#if -1824799305 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -935106685 
Object k = Model.getFacade().getKind(sv);
//#endif 


//#if 763619614 
if(Model.getFacade().
                equalsPseudostateKind(k,
                                      Model.getPseudostateKind().getFork()))//1
{ 

//#if 1078289127 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1909384553 
boolean hasTrigger =
            (t != null && Model.getFacade().getName(t) != null
             && Model.getFacade().getName(t).length() > 0);
//#endif 


//#if -1116793900 
if(hasTrigger)//1
{ 

//#if -139477352 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if 86529869 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1261044611 
public CrInvalidPseudoStateTrigger()
    { 

//#if -1921716424 
setupHeadAndDesc();
//#endif 


//#if 391434322 
addSupportedDecision(UMLDecision.STATE_MACHINES);
//#endif 


//#if 1566884676 
addTrigger("trigger");
//#endif 

} 

//#endif 


//#if -1609245655 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if -314792783 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if -1862893193 
ret.add(Model.getMetaTypes().getTransition());
//#endif 


//#if -1565593607 
return ret;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

