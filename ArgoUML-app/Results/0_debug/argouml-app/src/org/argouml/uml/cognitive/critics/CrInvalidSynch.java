
//#if -1863928787 
// Compilation Unit of /CrInvalidSynch.java 
 

//#if -220662747 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -1291333292 
import java.util.HashSet;
//#endif 


//#if 624059424 
import java.util.Iterator;
//#endif 


//#if 928407974 
import java.util.Set;
//#endif 


//#if -406763086 
import org.argouml.cognitive.Designer;
//#endif 


//#if 2141937345 
import org.argouml.model.Model;
//#endif 


//#if -1315381117 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -965492180 
public class CrInvalidSynch extends 
//#if 1607387006 
CrUML
//#endif 

  { 

//#if 1973050218 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if 2019618412 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if 1054433281 
ret.add(Model.getMetaTypes().getSynchState());
//#endif 


//#if -1938657932 
return ret;
//#endif 

} 

//#endif 


//#if -549852362 
public CrInvalidSynch()
    { 

//#if -369830401 
setupHeadAndDesc();
//#endif 


//#if 812769497 
addSupportedDecision(UMLDecision.STATE_MACHINES);
//#endif 


//#if -623258611 
addTrigger("incoming");
//#endif 


//#if 159812359 
addTrigger("outgoing");
//#endif 

} 

//#endif 


//#if 1369904661 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 888227265 
Object destinationRegion = null;
//#endif 


//#if 814502654 
Object sourceRegion = null;
//#endif 


//#if -1750585245 
Object aux = null;
//#endif 


//#if 487091533 
Object tr = null;
//#endif 


//#if 255949194 
if(!Model.getFacade().isASynchState(dm))//1
{ 

//#if -483554714 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1231610861 
Iterator outgoing = Model.getFacade().getOutgoings(dm).iterator();
//#endif 


//#if 508180868 
while (outgoing.hasNext()) //1
{ 

//#if -1194215652 
tr = outgoing.next();
//#endif 


//#if 1748226176 
aux = Model.getFacade().getContainer(Model.getFacade().
                                                 getTarget(tr));
//#endif 


//#if 934604846 
if(destinationRegion == null)//1
{ 

//#if -2050984414 
destinationRegion = aux;
//#endif 

} 
else

//#if 1127256382 
if(!aux.equals(destinationRegion))//1
{ 

//#if 1298782546 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1087800673 
Iterator incoming = Model.getFacade().getIncomings(dm).iterator();
//#endif 


//#if 560541886 
while (incoming.hasNext()) //1
{ 

//#if 860448946 
tr = incoming.next();
//#endif 


//#if 31487022 
aux = Model.getFacade().getContainer(Model.getFacade().
                                                 getSource(tr));
//#endif 


//#if -897888195 
if(sourceRegion == null)//1
{ 

//#if -517028068 
sourceRegion = aux;
//#endif 

} 
else

//#if -357496233 
if(!aux.equals(sourceRegion))//1
{ 

//#if 514961671 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1970322789 
if(destinationRegion != null
                && !Model.getFacade().isAConcurrentRegion(destinationRegion))//1
{ 

//#if -920366722 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if 1704200445 
if(sourceRegion != null
                && !Model.getFacade().isAConcurrentRegion(sourceRegion))//1
{ 

//#if 888294007 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if 1157721361 
return NO_PROBLEM;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

