
//#if 1114708296 
// Compilation Unit of /CrInvalidForkTriggerOrGuard.java 
 

//#if 899131770 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -1525017761 
import java.util.HashSet;
//#endif 


//#if -380018383 
import java.util.Set;
//#endif 


//#if 1165095303 
import org.argouml.cognitive.Designer;
//#endif 


//#if -1117213556 
import org.argouml.model.Model;
//#endif 


//#if -527913202 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -1036110024 
public class CrInvalidForkTriggerOrGuard extends 
//#if -1857601836 
CrUML
//#endif 

  { 

//#if -191728708 
private static final long serialVersionUID = -713044875133409390L;
//#endif 


//#if -590842213 
public CrInvalidForkTriggerOrGuard()
    { 

//#if 991899988 
setupHeadAndDesc();
//#endif 


//#if 1284864366 
addSupportedDecision(UMLDecision.STATE_MACHINES);
//#endif 


//#if -175637592 
addTrigger("trigger");
//#endif 


//#if -65772901 
addTrigger("guard");
//#endif 

} 

//#endif 


//#if -1361029249 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 1075498620 
if(!(Model.getFacade().isATransition(dm)))//1
{ 

//#if 638309348 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1274435415 
Object tr = dm;
//#endif 


//#if 1263145031 
Object t = Model.getFacade().getTrigger(tr);
//#endif 


//#if -829635283 
Object g = Model.getFacade().getGuard(tr);
//#endif 


//#if -1023991489 
Object sv = Model.getFacade().getSource(tr);
//#endif 


//#if 1514789416 
if(!(Model.getFacade().isAPseudostate(sv)))//1
{ 

//#if -1194472913 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1058288587 
Object k = Model.getFacade().getKind(sv);
//#endif 


//#if 2015433713 
if(!Model.getFacade().
                equalsPseudostateKind(k,
                                      Model.getPseudostateKind().getFork()))//1
{ 

//#if -627442050 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 158058831 
boolean hasTrigger =
            (t != null && Model.getFacade().getName(t) != null
             && Model.getFacade().getName(t).length() > 0);
//#endif 


//#if 1025911436 
if(hasTrigger)//1
{ 

//#if -1489237950 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if -400626136 
boolean noGuard =
            (g == null || Model.getFacade().getExpression(g) == null
             || Model.getFacade().getBody(Model.getFacade()
                                          .getExpression(g)) == null
             || Model.getFacade().getBody(Model.getFacade()
                                          .getExpression(g)).toString().length() == 0);
//#endif 


//#if 1048873457 
if(!noGuard)//1
{ 

//#if 2081485593 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if -2065732091 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1081522368 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if 1914566602 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if -522090160 
ret.add(Model.getMetaTypes().getTransition());
//#endif 


//#if 880898130 
return ret;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

