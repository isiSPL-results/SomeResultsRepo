package org.argouml.uml.cognitive.critics;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.argouml.cognitive.Designer;
import org.argouml.model.Model;
import org.argouml.uml.cognitive.UMLDecision;
public class CrInvalidSynch extends CrUML
  { 
public Set<Object> getCriticizedDesignMaterials()
    { 
Set<Object> ret = new HashSet<Object>();
ret.add(Model.getMetaTypes().getSynchState());
return ret;
} 
public CrInvalidSynch()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.STATE_MACHINES);
addTrigger("incoming");
addTrigger("outgoing");
} 
public boolean predicate2(Object dm, Designer dsgr)
    { 
Object destinationRegion = null;
Object sourceRegion = null;
Object aux = null;
Object tr = null;
if(!Model.getFacade().isASynchState(dm))//1
{ 
return NO_PROBLEM;
} 
Iterator outgoing = Model.getFacade().getOutgoings(dm).iterator();
while (outgoing.hasNext()) //1
{ 
tr = outgoing.next();
aux = Model.getFacade().getContainer(Model.getFacade().
                                                 getTarget(tr));
if(destinationRegion == null)//1
{ 
destinationRegion = aux;
} 
else
if(!aux.equals(destinationRegion))//1
{ 
return PROBLEM_FOUND;
} 
} 
Iterator incoming = Model.getFacade().getIncomings(dm).iterator();
while (incoming.hasNext()) //1
{ 
tr = incoming.next();
aux = Model.getFacade().getContainer(Model.getFacade().
                                                 getSource(tr));
if(sourceRegion == null)//1
{ 
sourceRegion = aux;
} 
else
if(!aux.equals(sourceRegion))//1
{ 
return PROBLEM_FOUND;
} 
} 
if(destinationRegion != null
                && !Model.getFacade().isAConcurrentRegion(destinationRegion))//1
{ 
return PROBLEM_FOUND;
} 
if(sourceRegion != null
                && !Model.getFacade().isAConcurrentRegion(sourceRegion))//1
{ 
return PROBLEM_FOUND;
} 
return NO_PROBLEM;
} 

 } 
