
//#if -637712091 
// Compilation Unit of /CrConflictingComposites.java 
 

//#if -82924304 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -1602333893 
import java.util.Collection;
//#endif 


//#if -1110371605 
import java.util.Iterator;
//#endif 


//#if -38412588 
import org.argouml.cognitive.Critic;
//#endif 


//#if -1280237571 
import org.argouml.cognitive.Designer;
//#endif 


//#if -546228522 
import org.argouml.model.Model;
//#endif 


//#if 356806616 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -1664031909 
public class CrConflictingComposites extends 
//#if -969361343 
CrUML
//#endif 

  { 

//#if 1974493002 
public boolean predicate2(Object classifier, Designer dsgr)
    { 

//#if 899042757 
if(!(Model.getFacade().isAClassifier(classifier)))//1
{ 

//#if -654717385 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 2025002426 
Collection conns = Model.getFacade().getAssociationEnds(classifier);
//#endif 


//#if -1164528941 
if(conns == null)//1
{ 

//#if 1167526889 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 357500121 
int compositeCount = 0;
//#endif 


//#if -950857633 
Iterator assocEnds = conns.iterator();
//#endif 


//#if -519315498 
while (assocEnds.hasNext()) //1
{ 

//#if -274378707 
Object myEnd = assocEnds.next();
//#endif 


//#if -1798489584 
if(Model.getCoreHelper()
                    .equalsAggregationKind(myEnd, "composite"))//1
{ 

//#if -1177798218 
continue;
//#endif 

} 

//#endif 


//#if -2095726366 
if(Model.getFacade().getLower(myEnd) == 0)//1
{ 

//#if 1024000460 
continue;
//#endif 

} 

//#endif 


//#if 2053941373 
Object asc = Model.getFacade().getAssociation(myEnd);
//#endif 


//#if -321050690 
if(asc != null
                    && Model.getCoreHelper().hasCompositeEnd(asc))//1
{ 

//#if -403770586 
compositeCount++;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -961945338 
if(compositeCount > 1)//1
{ 

//#if -527594170 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if 42033794 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -753772703 
public CrConflictingComposites()
    { 

//#if 1824729996 
setupHeadAndDesc();
//#endif 


//#if -1982211798 
addSupportedDecision(UMLDecision.CONTAINMENT);
//#endif 


//#if -43978603 
setKnowledgeTypes(Critic.KT_SEMANTICS);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

