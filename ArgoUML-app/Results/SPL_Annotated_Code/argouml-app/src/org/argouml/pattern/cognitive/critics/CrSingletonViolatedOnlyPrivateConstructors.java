// Compilation Unit of /CrSingletonViolatedOnlyPrivateConstructors.java 
 

//#if COGNITIVE 
package org.argouml.pattern.cognitive.critics;
//#endif 


//#if COGNITIVE 
import java.util.Iterator;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Designer;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if COGNITIVE 
import org.argouml.model.Model;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.critics.CrUML;
//#endif 


//#if COGNITIVE 
public class CrSingletonViolatedOnlyPrivateConstructors extends CrUML
  { 
public boolean predicate2(Object dm, Designer dsgr)
    { 
if(!(Model.getFacade().isAClass(dm)))//1
{ 
return NO_PROBLEM;
} 

if(!(Model.getFacade().isSingleton(dm)))//1
{ 
return NO_PROBLEM;
} 

Iterator operations = Model.getFacade().getOperations(dm).iterator();
while (operations.hasNext()) //1
{ 
Object o = operations.next();
if(!(Model.getFacade().isConstructor(o)))//1
{ 
continue;
} 

if(!(Model.getFacade().isPrivate(o)))//1
{ 
return PROBLEM_FOUND;
} 

} 

return NO_PROBLEM;
} 

public CrSingletonViolatedOnlyPrivateConstructors()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.PATTERNS);
setPriority(ToDoItem.MED_PRIORITY);
addTrigger("stereotype");
addTrigger("structuralFeature");
addTrigger("associationEnd");
} 

 } 

//#endif 


