
//#if 142724318 
// Compilation Unit of /CrCrossNamespaceAssoc.java 
 

//#if -2095714147 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 587691484 
import java.util.HashSet;
//#endif 


//#if -1255714664 
import java.util.Iterator;
//#endif 


//#if 1873644078 
import java.util.Set;
//#endif 


//#if 1588635713 
import org.argouml.cognitive.Critic;
//#endif 


//#if -1054916054 
import org.argouml.cognitive.Designer;
//#endif 


//#if 1286569289 
import org.argouml.model.Model;
//#endif 


//#if -626986741 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 1030387436 
public class CrCrossNamespaceAssoc extends 
//#if 2046330052 
CrUML
//#endif 

  { 

//#if -1216184433 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 797378252 
if(!Model.getFacade().isAAssociation(dm))//1
{ 

//#if -154003941 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1663746547 
Object ns = Model.getFacade().getNamespace(dm);
//#endif 


//#if -643863435 
if(ns == null)//1
{ 

//#if -1872455720 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if 1344370399 
Iterator assocEnds = Model.getFacade().getConnections(dm).iterator();
//#endif 


//#if 1348678036 
while (assocEnds.hasNext()) //1
{ 

//#if 563960750 
Object clf = Model.getFacade().getType(assocEnds.next());
//#endif 


//#if -1784754575 
if(clf != null && ns != Model.getFacade().getNamespace(clf))//1
{ 

//#if 2002978937 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1592189248 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -886300368 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if 1184469599 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if -1949103353 
ret.add(Model.getMetaTypes().getAssociationClass());
//#endif 


//#if 353016615 
return ret;
//#endif 

} 

//#endif 


//#if 267277954 
public CrCrossNamespaceAssoc()
    { 

//#if 1898170108 
setupHeadAndDesc();
//#endif 


//#if 1536132064 
addSupportedDecision(UMLDecision.MODULARITY);
//#endif 


//#if -1880855729 
setKnowledgeTypes(Critic.KT_SYNTAX);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

