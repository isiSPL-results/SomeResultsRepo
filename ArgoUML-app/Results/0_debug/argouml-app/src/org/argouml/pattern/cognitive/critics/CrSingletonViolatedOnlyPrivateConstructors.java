
//#if -728725628 
// Compilation Unit of /CrSingletonViolatedOnlyPrivateConstructors.java 
 

//#if -143963105 
package org.argouml.pattern.cognitive.critics;
//#endif 


//#if -1568296746 
import java.util.Iterator;
//#endif 


//#if 2007577960 
import org.argouml.cognitive.Designer;
//#endif 


//#if 487592314 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 1159304139 
import org.argouml.model.Model;
//#endif 


//#if 1310227469 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 606502759 
import org.argouml.uml.cognitive.critics.CrUML;
//#endif 


//#if -1703940817 
public class CrSingletonViolatedOnlyPrivateConstructors extends 
//#if 1862098310 
CrUML
//#endif 

  { 

//#if 914549005 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 2079186892 
if(!(Model.getFacade().isAClass(dm)))//1
{ 

//#if -1197004334 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 977469892 
if(!(Model.getFacade().isSingleton(dm)))//1
{ 

//#if -809870418 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -619085925 
Iterator operations = Model.getFacade().getOperations(dm).iterator();
//#endif 


//#if -48961133 
while (operations.hasNext()) //1
{ 

//#if -1257821644 
Object o = operations.next();
//#endif 


//#if -224475731 
if(!(Model.getFacade().isConstructor(o)))//1
{ 

//#if 2015192950 
continue;
//#endif 

} 

//#endif 


//#if -1035822026 
if(!(Model.getFacade().isPrivate(o)))//1
{ 

//#if -352639850 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2090876638 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 285660859 
public CrSingletonViolatedOnlyPrivateConstructors()
    { 

//#if -1211339496 
setupHeadAndDesc();
//#endif 


//#if -901699013 
addSupportedDecision(UMLDecision.PATTERNS);
//#endif 


//#if -1674658555 
setPriority(ToDoItem.MED_PRIORITY);
//#endif 


//#if 122636826 
addTrigger("stereotype");
//#endif 


//#if -930245085 
addTrigger("structuralFeature");
//#endif 


//#if -1654790222 
addTrigger("associationEnd");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

