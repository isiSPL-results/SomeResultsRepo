package org.argouml.uml.cognitive.critics;
import java.util.Collection;
import java.util.Iterator;
import org.argouml.cognitive.Critic;
import org.argouml.cognitive.Designer;
import org.argouml.model.Model;
import org.argouml.uml.cognitive.UMLDecision;
public class CrConflictingComposites extends CrUML
  { 
public boolean predicate2(Object classifier, Designer dsgr)
    { 
if(!(Model.getFacade().isAClassifier(classifier)))//1
{ 
return NO_PROBLEM;
} 
Collection conns = Model.getFacade().getAssociationEnds(classifier);
if(conns == null)//1
{ 
return NO_PROBLEM;
} 
int compositeCount = 0;
Iterator assocEnds = conns.iterator();
while (assocEnds.hasNext()) //1
{ 
Object myEnd = assocEnds.next();
if(Model.getCoreHelper()
                    .equalsAggregationKind(myEnd, "composite"))//1
{ 
continue;
} 
if(Model.getFacade().getLower(myEnd) == 0)//1
{ 
continue;
} 
Object asc = Model.getFacade().getAssociation(myEnd);
if(asc != null
                    && Model.getCoreHelper().hasCompositeEnd(asc))//1
{ 
compositeCount++;
} 
} 
if(compositeCount > 1)//1
{ 
return PROBLEM_FOUND;
} 
return NO_PROBLEM;
} 
public CrConflictingComposites()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.CONTAINMENT);
setKnowledgeTypes(Critic.KT_SEMANTICS);
} 

 } 
