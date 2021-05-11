// Compilation Unit of /CrSingletonViolatedMissingStaticAttr.java 
 

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
public class CrSingletonViolatedMissingStaticAttr extends CrUML
  { 
public CrSingletonViolatedMissingStaticAttr()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.PATTERNS);
setPriority(ToDoItem.MED_PRIORITY);
addTrigger("stereotype");
addTrigger("structuralFeature");
addTrigger("associationEnd");
} 

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

Iterator attrs = Model.getFacade().getAttributes(dm).iterator();
while (attrs.hasNext()) //1
{ 
Object attr = attrs.next();
if(!(Model.getFacade().isStatic(attr)))//1
{ 
continue;
} 

if(Model.getFacade().getType(attr) == dm)//1
{ 
return NO_PROBLEM;
} 

} 

return PROBLEM_FOUND;
} 

 } 

//#endif 


