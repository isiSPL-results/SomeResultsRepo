
//#if 1937725873 
// Compilation Unit of /CrNavFromInterface.java 
 

//#if -1019428057 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 717379090 
import java.util.HashSet;
//#endif 


//#if -1530366174 
import java.util.Iterator;
//#endif 


//#if 1612510564 
import java.util.Set;
//#endif 


//#if 786606667 
import org.argouml.cognitive.Critic;
//#endif 


//#if 1289284020 
import org.argouml.cognitive.Designer;
//#endif 


//#if -1118642945 
import org.argouml.model.Model;
//#endif 


//#if 1081055809 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -942642172 
public class CrNavFromInterface extends 
//#if -1634635709 
CrUML
//#endif 

  { 

//#if 452873253 
private static final long serialVersionUID = 2660051106458704056L;
//#endif 


//#if -1508803225 
public CrNavFromInterface()
    { 

//#if -1108839887 
setupHeadAndDesc();
//#endif 


//#if 585594350 
addSupportedDecision(UMLDecision.RELATIONSHIPS);
//#endif 


//#if 132051130 
setKnowledgeTypes(Critic.KT_SYNTAX);
//#endif 


//#if -1131450420 
addTrigger("end_navigable");
//#endif 

} 

//#endif 


//#if 2112175599 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if 747509808 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if 617336536 
ret.add(Model.getMetaTypes().getAssociationClass());
//#endif 


//#if -2041691080 
return ret;
//#endif 

} 

//#endif 


//#if 820203248 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 1477121495 
if(!(Model.getFacade().isAAssociation(dm)))//1
{ 

//#if -181359154 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 331307985 
if(Model.getFacade().isAAssociationRole(dm))//1
{ 

//#if -2072915206 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1866418063 
Iterator assocEnds = Model.getFacade().getConnections(dm).iterator();
//#endif 


//#if -1748382881 
boolean haveInterfaceEnd  = false;
//#endif 


//#if -1641059215 
boolean otherEndNavigable = false;
//#endif 


//#if 1839854786 
while (assocEnds.hasNext()) //1
{ 

//#if -860619364 
Object ae = assocEnds.next();
//#endif 


//#if -1773547612 
Object type = Model.getFacade().getType(ae);
//#endif 


//#if 1310112750 
if(Model.getFacade().isAInterface(type))//1
{ 

//#if 960681851 
haveInterfaceEnd = true;
//#endif 

} 
else

//#if 232352234 
if(Model.getFacade().isNavigable(ae))//1
{ 

//#if -1341141396 
otherEndNavigable = true;
//#endif 

} 

//#endif 


//#endif 


//#if 187314419 
if(haveInterfaceEnd && otherEndNavigable)//1
{ 

//#if 1574112633 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1799780718 
return NO_PROBLEM;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

