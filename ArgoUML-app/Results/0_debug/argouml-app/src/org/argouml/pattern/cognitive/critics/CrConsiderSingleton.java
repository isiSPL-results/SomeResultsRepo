
//#if 591200321 
// Compilation Unit of /CrConsiderSingleton.java 
 

//#if 682642532 
package org.argouml.pattern.cognitive.critics;
//#endif 


//#if -1276656229 
import java.util.Iterator;
//#endif 


//#if 1298221741 
import org.argouml.cognitive.Designer;
//#endif 


//#if -221763905 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 839823910 
import org.argouml.model.Model;
//#endif 


//#if -1849696472 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 461473730 
import org.argouml.uml.cognitive.critics.CrUML;
//#endif 


//#if -605251903 
public class CrConsiderSingleton extends 
//#if 820363625 
CrUML
//#endif 

  { 

//#if 2058330821 
private static final long serialVersionUID = -178026888698499288L;
//#endif 


//#if -217528417 
public CrConsiderSingleton()
    { 

//#if 1042597016 
setupHeadAndDesc();
//#endif 


//#if 1256915387 
addSupportedDecision(UMLDecision.PATTERNS);
//#endif 


//#if -2091396611 
setPriority(ToDoItem.LOW_PRIORITY);
//#endif 


//#if 484966810 
addTrigger("stereotype");
//#endif 


//#if -1616941405 
addTrigger("structuralFeature");
//#endif 


//#if 1087299378 
addTrigger("associationEnd");
//#endif 

} 

//#endif 


//#if 1022441854 
@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if -1981193292 
if(!(Model.getFacade().isAClass(dm)))//1
{ 

//#if 186178646 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -2029590671 
if(Model.getFacade().isAAssociationClass(dm))//1
{ 

//#if 1352771709 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1794704392 
if(Model.getFacade().getName(dm) == null
                || "".equals(Model.getFacade().getName(dm)))//1
{ 

//#if 2056891034 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -147963194 
if(!(Model.getFacade().isPrimaryObject(dm)))//1
{ 

//#if 1132097439 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1629421367 
if(Model.getFacade().isAbstract(dm))//1
{ 

//#if 240342260 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1240800644 
if(Model.getFacade().isSingleton(dm))//1
{ 

//#if 129792912 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -582596571 
if(Model.getFacade().isUtility(dm))//1
{ 

//#if -2055942464 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1239940762 
Iterator iter = Model.getFacade().getAttributes(dm).iterator();
//#endif 


//#if 591488743 
while (iter.hasNext()) //1
{ 

//#if -962398075 
if(!Model.getFacade().isStatic(iter.next()))//1
{ 

//#if -2112564402 
return NO_PROBLEM;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1043625022 
Iterator ends = Model.getFacade().getAssociationEnds(dm).iterator();
//#endif 


//#if -1521994041 
while (ends.hasNext()) //1
{ 

//#if -1825747982 
Iterator otherends =
                Model.getFacade()
                .getOtherAssociationEnds(ends.next()).iterator();
//#endif 


//#if -1674478990 
while (otherends.hasNext()) //1
{ 

//#if 1352067421 
if(Model.getFacade().isNavigable(otherends.next()))//1
{ 

//#if 1282284716 
return NO_PROBLEM;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1574404857 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

