
//#if 1755433709 
// Compilation Unit of /CrInvalidJoinTriggerOrGuard.java 
 

//#if -1277703397 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 774444958 
import java.util.HashSet;
//#endif 


//#if 1457151216 
import java.util.Set;
//#endif 


//#if 964561832 
import org.argouml.cognitive.Designer;
//#endif 


//#if -1664268917 
import org.argouml.model.Model;
//#endif 


//#if -913170995 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -2123474017 
public class CrInvalidJoinTriggerOrGuard extends 
//#if 1629046195 
CrUML
//#endif 

  { 

//#if 818076644 
private static final long serialVersionUID = 1052354516940735748L;
//#endif 


//#if 66481570 
public CrInvalidJoinTriggerOrGuard()
    { 

//#if -1886645563 
setupHeadAndDesc();
//#endif 


//#if -289210593 
addSupportedDecision(UMLDecision.STATE_MACHINES);
//#endif 


//#if -1609115497 
addTrigger("trigger");
//#endif 


//#if 893628234 
addTrigger("guard");
//#endif 

} 

//#endif 


//#if 599152512 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 1918146966 
if(!(Model.getFacade().isATransition(dm)))//1
{ 

//#if 659029187 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1552537853 
Object tr = dm;
//#endif 


//#if 973699169 
Object t = Model.getFacade().getTrigger(tr);
//#endif 


//#if 1985702855 
Object g = Model.getFacade().getGuard(tr);
//#endif 


//#if 869186900 
Object dv = Model.getFacade().getTarget(tr);
//#endif 


//#if 1494733117 
if(!(Model.getFacade().isAPseudostate(dv)))//1
{ 

//#if -1310831261 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -236814240 
Object k = Model.getFacade().getKind(dv);
//#endif 


//#if 1398851875 
if(!Model.getFacade().
                equalsPseudostateKind(k,
                                      Model.getPseudostateKind().getJoin()))//1
{ 

//#if -504172883 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 777871721 
boolean hasTrigger =
            (t != null && Model.getFacade().getName(t) != null
             && Model.getFacade().getName(t).length() > 0);
//#endif 


//#if -857751386 
if(hasTrigger)//1
{ 

//#if -984522860 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if -1743584690 
boolean noGuard =
            (g == null
             || Model.getFacade().getExpression(g) == null
             || Model.getFacade().getBody(Model.getFacade()
                                          .getExpression(g)) == null
             || Model.getFacade().getBody(Model.getFacade()
                                          .getExpression(g)).toString().length() == 0);
//#endif 


//#if 1006689931 
if(!noGuard)//1
{ 

//#if -230540342 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if 345572383 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -445429921 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if 1972428793 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if 1439646399 
ret.add(Model.getMetaTypes().getTransition());
//#endif 


//#if 1880274241 
return ret;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

