
//#if 822794258 
// Compilation Unit of /CrSingletonViolatedMissingStaticAttr.java 
 

//#if -805434314 
package org.argouml.pattern.cognitive.critics;
//#endif 


//#if 1585586797 
import java.util.Iterator;
//#endif 


//#if -1630733185 
import org.argouml.cognitive.Designer;
//#endif 


//#if 1144248465 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 2078771348 
import org.argouml.model.Model;
//#endif 


//#if -927867626 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 1575731760 
import org.argouml.uml.cognitive.critics.CrUML;
//#endif 


//#if 639151291 
public class CrSingletonViolatedMissingStaticAttr extends 
//#if -1136315348 
CrUML
//#endif 

  { 

//#if 1740141962 
public CrSingletonViolatedMissingStaticAttr()
    { 

//#if 776864997 
setupHeadAndDesc();
//#endif 


//#if 1708878600 
addSupportedDecision(UMLDecision.PATTERNS);
//#endif 


//#if -1163322670 
setPriority(ToDoItem.MED_PRIORITY);
//#endif 


//#if 39916583 
addTrigger("stereotype");
//#endif 


//#if 1546900342 
addTrigger("structuralFeature");
//#endif 


//#if -953031873 
addTrigger("associationEnd");
//#endif 

} 

//#endif 


//#if -1423686361 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if -590061344 
if(!(Model.getFacade().isAClass(dm)))//1
{ 

//#if -1090523519 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1572210640 
if(!(Model.getFacade().isSingleton(dm)))//1
{ 

//#if -824360737 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1257118012 
Iterator attrs = Model.getFacade().getAttributes(dm).iterator();
//#endif 


//#if -1738087529 
while (attrs.hasNext()) //1
{ 

//#if 95259197 
Object attr = attrs.next();
//#endif 


//#if 1535546308 
if(!(Model.getFacade().isStatic(attr)))//1
{ 

//#if 1506569852 
continue;
//#endif 

} 

//#endif 


//#if -846941357 
if(Model.getFacade().getType(attr) == dm)//1
{ 

//#if -1690673457 
return NO_PROBLEM;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 411815461 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

