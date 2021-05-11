
//#if -1989358683 
// Compilation Unit of /CrMultipleDeepHistoryStates.java 
 

//#if -916578564 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 1192299079 
import java.util.Collection;
//#endif 


//#if -326753891 
import java.util.HashSet;
//#endif 


//#if 461249783 
import java.util.Iterator;
//#endif 


//#if -1626194321 
import java.util.Set;
//#endif 


//#if -1128961833 
import org.apache.log4j.Logger;
//#endif 


//#if 1111717897 
import org.argouml.cognitive.Designer;
//#endif 


//#if 635139422 
import org.argouml.cognitive.ListSet;
//#endif 


//#if -408267749 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 718574666 
import org.argouml.model.Model;
//#endif 


//#if -1536347572 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -1752118993 
import org.argouml.uml.cognitive.UMLToDoItem;
//#endif 


//#if -198960755 
public class CrMultipleDeepHistoryStates extends 
//#if -273850082 
CrUML
//#endif 

  { 

//#if -86470148 
private static final Logger LOG =
        Logger.getLogger(CrMultipleDeepHistoryStates.class);
//#endif 


//#if 97083105 
private static final long serialVersionUID = -4893102976661022514L;
//#endif 


//#if 131320380 
public CrMultipleDeepHistoryStates()
    { 

//#if 1532743247 
setupHeadAndDesc();
//#endif 


//#if -1240109783 
addSupportedDecision(UMLDecision.STATE_MACHINES);
//#endif 


//#if 278832409 
addTrigger("parent");
//#endif 


//#if -122613329 
addTrigger("kind");
//#endif 

} 

//#endif 


//#if -813051787 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if -895151606 
if(!(Model.getFacade().isAPseudostate(dm)))//1
{ 

//#if -1195761576 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1204671827 
Object k = Model.getFacade().getKind(dm);
//#endif 


//#if -1544670079 
if(!Model.getFacade().equalsPseudostateKind(k,
                Model.getPseudostateKind().getDeepHistory()))//1
{ 

//#if -579405693 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 2006122793 
Object cs = Model.getFacade().getContainer(dm);
//#endif 


//#if -983878487 
if(cs == null)//1
{ 

//#if -1254483283 
LOG.debug("null parent state");
//#endif 


//#if -1967722176 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 939701626 
Collection peers = Model.getFacade().getSubvertices(cs);
//#endif 


//#if -67096396 
int initialStateCount = 0;
//#endif 


//#if 54139027 
for (Iterator iter = peers.iterator(); iter.hasNext();) //1
{ 

//#if 634191058 
Object sv = iter.next();
//#endif 


//#if -373436484 
if(Model.getFacade().isAPseudostate(sv)
                    && Model.getFacade().equalsPseudostateKind(
                        Model.getFacade().getKind(sv),
                        Model.getPseudostateKind().getDeepHistory()))//1
{ 

//#if 197115233 
initialStateCount++;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1444525997 
if(initialStateCount > 1)//1
{ 

//#if 2010248368 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if -10938807 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1117425580 
public boolean stillValid(ToDoItem i, Designer dsgr)
    { 

//#if -735139440 
if(!isActive())//1
{ 

//#if -1766014040 
return false;
//#endif 

} 

//#endif 


//#if -1835817157 
ListSet offs = i.getOffenders();
//#endif 


//#if -1893179110 
Object dm = offs.get(0);
//#endif 


//#if -1919588732 
ListSet newOffs = computeOffenders(dm);
//#endif 


//#if -193288589 
boolean res = offs.equals(newOffs);
//#endif 


//#if -1184235476 
return res;
//#endif 

} 

//#endif 


//#if -1274090230 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if 1730816571 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if 1955435373 
ret.add(Model.getMetaTypes().getPseudostate());
//#endif 


//#if -1505014269 
return ret;
//#endif 

} 

//#endif 


//#if 484743775 
protected ListSet computeOffenders(Object ps)
    { 

//#if -1473095367 
ListSet offs = new ListSet(ps);
//#endif 


//#if 967094733 
Object cs = Model.getFacade().getContainer(ps);
//#endif 


//#if -2108944705 
if(cs == null)//1
{ 

//#if 2017289258 
LOG.debug("null parent in still valid");
//#endif 


//#if -176107100 
return offs;
//#endif 

} 

//#endif 


//#if -644526320 
Collection peers = Model.getFacade().getSubvertices(cs);
//#endif 


//#if -1530088919 
for (Iterator iter = peers.iterator(); iter.hasNext();) //1
{ 

//#if 412514673 
Object sv = iter.next();
//#endif 


//#if 2777499 
if(Model.getFacade().isAPseudostate(sv)
                    && Model.getFacade().equalsPseudostateKind(
                        Model.getFacade().getKind(sv),
                        Model.getPseudostateKind().getDeepHistory()))//1
{ 

//#if 2003044623 
offs.add(sv);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1028336612 
return offs;
//#endif 

} 

//#endif 


//#if 728178790 
public ToDoItem toDoItem(Object dm, Designer dsgr)
    { 

//#if 1538766543 
ListSet offs = computeOffenders(dm);
//#endif 


//#if -1870306539 
return new UMLToDoItem(this, offs, dsgr);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

