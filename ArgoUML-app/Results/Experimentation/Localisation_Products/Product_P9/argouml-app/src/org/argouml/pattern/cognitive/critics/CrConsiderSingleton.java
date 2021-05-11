package org.argouml.pattern.cognitive.critics;
import java.util.Iterator;
import org.argouml.cognitive.Designer;
import org.argouml.cognitive.ToDoItem;
import org.argouml.model.Model;
import org.argouml.uml.cognitive.UMLDecision;
import org.argouml.uml.cognitive.critics.CrUML;
public class CrConsiderSingleton extends CrUML
  { 
private static final long serialVersionUID = -178026888698499288L;
public CrConsiderSingleton()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.PATTERNS);
setPriority(ToDoItem.LOW_PRIORITY);
addTrigger("stereotype");
addTrigger("structuralFeature");
addTrigger("associationEnd");
} 
@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 
if(!(Model.getFacade().isAClass(dm)))//1
{ 
return NO_PROBLEM;
} 
if(Model.getFacade().isAAssociationClass(dm))//1
{ 
return NO_PROBLEM;
} 
if(Model.getFacade().getName(dm) == null
                || "".equals(Model.getFacade().getName(dm)))//1
{ 
return NO_PROBLEM;
} 
if(!(Model.getFacade().isPrimaryObject(dm)))//1
{ 
return NO_PROBLEM;
} 
if(Model.getFacade().isAbstract(dm))//1
{ 
return NO_PROBLEM;
} 
if(Model.getFacade().isSingleton(dm))//1
{ 
return NO_PROBLEM;
} 
if(Model.getFacade().isUtility(dm))//1
{ 
return NO_PROBLEM;
} 
Iterator iter = Model.getFacade().getAttributes(dm).iterator();
while (iter.hasNext()) //1
{ 
if(!Model.getFacade().isStatic(iter.next()))//1
{ 
return NO_PROBLEM;
} 
} 
Iterator ends = Model.getFacade().getAssociationEnds(dm).iterator();
while (ends.hasNext()) //1
{ 
Iterator otherends =
                Model.getFacade()
                .getOtherAssociationEnds(ends.next()).iterator();
while (otherends.hasNext()) //1
{ 
if(Model.getFacade().isNavigable(otherends.next()))//1
{ 
return NO_PROBLEM;
} 
} 
} 
return PROBLEM_FOUND;
} 

 } 
