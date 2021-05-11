
//#if -308458904 
// Compilation Unit of /CrCircularAssocClass.java 
 

//#if 1738952729 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -709180892 
import java.util.Collection;
//#endif 


//#if -1132871968 
import java.util.HashSet;
//#endif 


//#if 1241393172 
import java.util.Iterator;
//#endif 


//#if -258673358 
import java.util.Set;
//#endif 


//#if -1863494467 
import org.argouml.cognitive.Critic;
//#endif 


//#if 1457700774 
import org.argouml.cognitive.Designer;
//#endif 


//#if 52425549 
import org.argouml.model.Model;
//#endif 


//#if 393777167 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 501571468 
public class CrCircularAssocClass extends 
//#if 1249406376 
CrUML
//#endif 

  { 

//#if -2038709900 
private static final long serialVersionUID = 5265695413303517728L;
//#endif 


//#if -1876236501 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if -826884050 
if(!Model.getFacade().isAAssociationClass(dm))//1
{ 

//#if -1730214967 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 2022996715 
Collection participants = Model.getFacade().getConnections(dm);
//#endif 


//#if -542981838 
if(participants == null)//1
{ 

//#if 2056530500 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 134799405 
Iterator iter = participants.iterator();
//#endif 


//#if 827044607 
while (iter.hasNext()) //1
{ 

//#if -429337144 
Object aEnd = iter.next();
//#endif 


//#if -1008693344 
if(Model.getFacade().isAAssociationEnd(aEnd))//1
{ 

//#if -1194206039 
Object type = Model.getFacade().getType(aEnd);
//#endif 


//#if 2035221969 
if(Model.getFacade().isAAssociationClass(type))//1
{ 

//#if 742132736 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1459167522 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 126922004 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if 2057923567 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if 513655959 
ret.add(Model.getMetaTypes().getAssociationClass());
//#endif 


//#if -1473296201 
return ret;
//#endif 

} 

//#endif 


//#if -1029635976 
public CrCircularAssocClass()
    { 

//#if 1437548198 
setupHeadAndDesc();
//#endif 


//#if -1869702759 
addSupportedDecision(UMLDecision.RELATIONSHIPS);
//#endif 


//#if -636587345 
setKnowledgeTypes(Critic.KT_SEMANTICS);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

