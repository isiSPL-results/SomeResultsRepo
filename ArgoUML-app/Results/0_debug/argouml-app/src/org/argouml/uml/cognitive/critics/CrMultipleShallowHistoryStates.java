
//#if 1449631801 
// Compilation Unit of /CrMultipleShallowHistoryStates.java 
 

//#if 66145824 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -152188821 
import java.util.Collection;
//#endif 


//#if -1214597639 
import java.util.HashSet;
//#endif 


//#if -1065918261 
import java.util.Set;
//#endif 


//#if 97011763 
import org.apache.log4j.Logger;
//#endif 


//#if 2079578413 
import org.argouml.cognitive.Designer;
//#endif 


//#if 1774739386 
import org.argouml.cognitive.ListSet;
//#endif 


//#if 559592767 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 1944548262 
import org.argouml.model.Model;
//#endif 


//#if 308805800 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 93034379 
import org.argouml.uml.cognitive.UMLToDoItem;
//#endif 


//#if -104204573 
public class CrMultipleShallowHistoryStates extends 
//#if -1979437406 
CrUML
//#endif 

  { 

//#if -1972217236 
private static final Logger LOG =
        Logger.getLogger(CrMultipleShallowHistoryStates.class);
//#endif 


//#if 362493618 
private static final long serialVersionUID = -8324054401013865193L;
//#endif 


//#if 406062711 
@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if -1576363576 
if(!(Model.getFacade().isAPseudostate(dm)))//1
{ 

//#if 341035458 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 818040939 
Object k = Model.getFacade().getKind(dm);
//#endif 


//#if -565501159 
if(!Model.getFacade()
                .equalsPseudostateKind(k,
                                       Model.getPseudostateKind().getShallowHistory()))//1
{ 

//#if 1444819966 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -845979545 
Object cs = Model.getFacade().getContainer(dm);
//#endif 


//#if -1932055381 
if(cs == null)//1
{ 

//#if -127897091 
LOG.debug("null parent state");
//#endif 


//#if 766099600 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1936914762 
int initialStateCount = 0;
//#endif 


//#if 214342652 
Collection peers = Model.getFacade().getSubvertices(cs);
//#endif 


//#if 534902175 
for (Object sv : peers) //1
{ 

//#if -932472324 
if(Model.getFacade().isAPseudostate(sv)
                    && Model.getFacade().equalsPseudostateKind(
                        Model.getFacade().getKind(sv),
                        Model.getPseudostateKind().getShallowHistory()))//1
{ 

//#if -533520163 
initialStateCount++;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 522361617 
if(initialStateCount > 1)//1
{ 

//#if -635882820 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if -675867189 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1974345138 
public CrMultipleShallowHistoryStates()
    { 

//#if 1020776316 
setupHeadAndDesc();
//#endif 


//#if 1816453526 
addSupportedDecision(UMLDecision.STATE_MACHINES);
//#endif 


//#if -2095116538 
addTrigger("parent");
//#endif 


//#if -634580260 
addTrigger("kind");
//#endif 

} 

//#endif 


//#if 255269354 
@Override
    public boolean stillValid(ToDoItem i, Designer dsgr)
    { 

//#if -1336826388 
if(!isActive())//1
{ 

//#if -711580076 
return false;
//#endif 

} 

//#endif 


//#if -808281761 
ListSet offs = i.getOffenders();
//#endif 


//#if 444446526 
Object dm = offs.get(0);
//#endif 


//#if 111969248 
ListSet newOffs = computeOffenders(dm);
//#endif 


//#if 881775055 
boolean res = offs.equals(newOffs);
//#endif 


//#if -1249044344 
return res;
//#endif 

} 

//#endif 


//#if 628957732 
@Override
    public ToDoItem toDoItem(Object dm, Designer dsgr)
    { 

//#if -1594624980 
ListSet offs = computeOffenders(dm);
//#endif 


//#if 947497458 
return new UMLToDoItem(this, offs, dsgr);
//#endif 

} 

//#endif 


//#if -1236095141 
protected ListSet computeOffenders(Object ps)
    { 

//#if 2107756965 
ListSet offs = new ListSet(ps);
//#endif 


//#if 1604296417 
Object cs = Model.getFacade().getContainer(ps);
//#endif 


//#if -197408469 
if(cs == null)//1
{ 

//#if 984104467 
LOG.debug("null parent in still valid");
//#endif 


//#if 1204767643 
return offs;
//#endif 

} 

//#endif 


//#if -531507076 
Collection peers = Model.getFacade().getSubvertices(cs);
//#endif 


//#if -2014557921 
for (Object sv : peers) //1
{ 

//#if -601156083 
if(Model.getFacade().isAPseudostate(sv)
                    && Model.getFacade().equalsPseudostateKind(
                        Model.getFacade().getKind(sv),
                        Model.getPseudostateKind().getShallowHistory()))//1
{ 

//#if -1440909955 
offs.add(sv);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -166026104 
return offs;
//#endif 

} 

//#endif 


//#if -1638754930 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if -1840055058 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if 1531192026 
ret.add(Model.getMetaTypes().getPseudostate());
//#endif 


//#if 1833998966 
return ret;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

