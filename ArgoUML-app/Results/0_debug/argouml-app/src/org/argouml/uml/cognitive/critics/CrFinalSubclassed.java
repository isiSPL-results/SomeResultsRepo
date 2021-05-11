
//#if 1200293583 
// Compilation Unit of /CrFinalSubclassed.java 
 

//#if -1030829336 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 553775153 
import java.util.HashSet;
//#endif 


//#if 1987846371 
import java.util.Iterator;
//#endif 


//#if 524580611 
import java.util.Set;
//#endif 


//#if -146680116 
import org.argouml.cognitive.Critic;
//#endif 


//#if 2048850421 
import org.argouml.cognitive.Designer;
//#endif 


//#if -1344789538 
import org.argouml.model.Model;
//#endif 


//#if 727969504 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 586944468 
public class CrFinalSubclassed extends 
//#if 411869493 
CrUML
//#endif 

  { 

//#if 937114438 
public CrFinalSubclassed()
    { 

//#if -1738649750 
setupHeadAndDesc();
//#endif 


//#if 575414564 
addSupportedDecision(UMLDecision.INHERITANCE);
//#endif 


//#if 598833523 
setKnowledgeTypes(Critic.KT_SEMANTICS);
//#endif 


//#if -1075347213 
addTrigger("specialization");
//#endif 


//#if 2081492918 
addTrigger("isLeaf");
//#endif 

} 

//#endif 


//#if 1254039649 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if 1435309644 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if -2128063458 
ret.add(Model.getMetaTypes().getClassifier());
//#endif 


//#if 1124128994 
ret.add(Model.getMetaTypes().getInterface());
//#endif 


//#if -116347564 
return ret;
//#endif 

} 

//#endif 


//#if -454404546 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if -1925747159 
if(!Model.getFacade().isAGeneralizableElement(dm))//1
{ 

//#if 148832436 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1601171937 
if(!Model.getFacade().isLeaf(dm))//1
{ 

//#if -102253474 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 174786524 
Iterator specs = Model.getFacade().getSpecializations(dm).iterator();
//#endif 


//#if -648080084 
return specs.hasNext() ? PROBLEM_FOUND : NO_PROBLEM;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

