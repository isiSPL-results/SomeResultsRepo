// Compilation Unit of /CrMultipleDeepHistoryStates.java 
 
package org.argouml.uml.cognitive.critics;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.apache.log4j.Logger;
import org.argouml.cognitive.Designer;
import org.argouml.cognitive.ListSet;
import org.argouml.cognitive.ToDoItem;
import org.argouml.model.Model;
import org.argouml.uml.cognitive.UMLDecision;
import org.argouml.uml.cognitive.UMLToDoItem;
public class CrMultipleDeepHistoryStates extends CrUML
  { 
private static final Logger LOG =
        Logger.getLogger(CrMultipleDeepHistoryStates.class);
private static final long serialVersionUID = -4893102976661022514L;
public CrMultipleDeepHistoryStates()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.STATE_MACHINES);
addTrigger("parent");
addTrigger("kind");
} 

public boolean predicate2(Object dm, Designer dsgr)
    { 
if(!(Model.getFacade().isAPseudostate(dm)))//1
{ 
return NO_PROBLEM;
} 

Object k = Model.getFacade().getKind(dm);
if(!Model.getFacade().equalsPseudostateKind(k,
                Model.getPseudostateKind().getDeepHistory()))//1
{ 
return NO_PROBLEM;
} 

Object cs = Model.getFacade().getContainer(dm);
if(cs == null)//1
{ 
LOG.debug("null parent state");
return NO_PROBLEM;
} 

Collection peers = Model.getFacade().getSubvertices(cs);
int initialStateCount = 0;
for (Iterator iter = peers.iterator(); iter.hasNext();) //1
{ 
Object sv = iter.next();
if(Model.getFacade().isAPseudostate(sv)
                    && Model.getFacade().equalsPseudostateKind(
                        Model.getFacade().getKind(sv),
                        Model.getPseudostateKind().getDeepHistory()))//1
{ 
initialStateCount++;
} 

} 

if(initialStateCount > 1)//1
{ 
return PROBLEM_FOUND;
} 

return NO_PROBLEM;
} 

public boolean stillValid(ToDoItem i, Designer dsgr)
    { 
if(!isActive())//1
{ 
return false;
} 

ListSet offs = i.getOffenders();
Object dm = offs.get(0);
ListSet newOffs = computeOffenders(dm);
boolean res = offs.equals(newOffs);
return res;
} 

public Set<Object> getCriticizedDesignMaterials()
    { 
Set<Object> ret = new HashSet<Object>();
ret.add(Model.getMetaTypes().getPseudostate());
return ret;
} 

protected ListSet computeOffenders(Object ps)
    { 
ListSet offs = new ListSet(ps);
Object cs = Model.getFacade().getContainer(ps);
if(cs == null)//1
{ 
LOG.debug("null parent in still valid");
return offs;
} 

Collection peers = Model.getFacade().getSubvertices(cs);
for (Iterator iter = peers.iterator(); iter.hasNext();) //1
{ 
Object sv = iter.next();
if(Model.getFacade().isAPseudostate(sv)
                    && Model.getFacade().equalsPseudostateKind(
                        Model.getFacade().getKind(sv),
                        Model.getPseudostateKind().getDeepHistory()))//1
{ 
offs.add(sv);
} 

} 

return offs;
} 

public ToDoItem toDoItem(Object dm, Designer dsgr)
    { 
ListSet offs = computeOffenders(dm);
return new UMLToDoItem(this, offs, dsgr);
} 

 } 


