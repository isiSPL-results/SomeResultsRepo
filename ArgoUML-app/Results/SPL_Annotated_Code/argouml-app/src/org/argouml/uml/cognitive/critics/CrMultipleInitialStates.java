// Compilation Unit of /CrMultipleInitialStates.java 
 
package org.argouml.uml.cognitive.critics;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.argouml.cognitive.Designer;
import org.argouml.cognitive.ListSet;
import org.argouml.cognitive.ToDoItem;
import org.argouml.model.Model;
import org.argouml.uml.cognitive.UMLDecision;
import org.argouml.uml.cognitive.UMLToDoItem;
public class CrMultipleInitialStates extends CrUML
  { 
private static final Logger LOG =
        Logger.getLogger(CrMultipleInitialStates.class);
private static final long serialVersionUID = 4151051235876065649L;
public CrMultipleInitialStates()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.STATE_MACHINES);
addTrigger("parent");
addTrigger("kind");
} 

public Set<Object> getCriticizedDesignMaterials()
    { 
Set<Object> ret = new HashSet<Object>();
ret.add(Model.getMetaTypes().getPseudostate());
return ret;
} 

@Override
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
for (Object sv : peers) //1
{ 
if(Model.getFacade().isAPseudostate(sv)
                    && Model.getFacade().equalsPseudostateKind(
                        Model.getFacade().getKind(sv),
                        Model.getPseudostateKind().getInitial()))//1
{ 
offs.add(sv);
} 

} 

return offs;
} 

@Override
    public ToDoItem toDoItem(Object dm, Designer dsgr)
    { 
ListSet offs = computeOffenders(dm);
return new UMLToDoItem(this, offs, dsgr);
} 

@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 
if(!(Model.getFacade().isAPseudostate(dm)))//1
{ 
return NO_PROBLEM;
} 

Object k = Model.getFacade().getKind(dm);
if(!Model.getFacade().equalsPseudostateKind(
                    k,
                    Model.getPseudostateKind().getInitial()))//1
{ 
return NO_PROBLEM;
} 

Object cs = Model.getFacade().getContainer(dm);
if(cs == null)//1
{ 
LOG.debug("null parent state");
return NO_PROBLEM;
} 

int initialStateCount = 0;
Collection peers = Model.getFacade().getSubvertices(cs);
for (Object sv : peers) //1
{ 
if(Model.getFacade().isAPseudostate(sv)
                    && Model.getFacade().
                    equalsPseudostateKind(
                        Model.getFacade().getKind(sv),
                        Model.getPseudostateKind().getInitial()))//1
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

 } 


