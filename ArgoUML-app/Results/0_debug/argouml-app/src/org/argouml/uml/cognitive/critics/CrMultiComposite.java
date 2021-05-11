
//#if 1470410058 
// Compilation Unit of /CrMultiComposite.java 
 

//#if -1735224399 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 725252168 
import java.util.HashSet;
//#endif 


//#if 775594650 
import java.util.Set;
//#endif 


//#if -354801067 
import org.argouml.cognitive.Critic;
//#endif 


//#if -386887874 
import org.argouml.cognitive.Designer;
//#endif 


//#if -1906873520 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 1077542581 
import org.argouml.model.Model;
//#endif 


//#if 1304855927 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 1003980048 
public class CrMultiComposite extends 
//#if -842219040 
CrUML
//#endif 

  { 

//#if 673263094 
public Class getWizardClass(ToDoItem item)
    { 

//#if 1658682793 
return WizAssocComposite.class;
//#endif 

} 

//#endif 


//#if -1064551604 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if 30864773 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if 1769447568 
ret.add(Model.getMetaTypes().getAssociationEnd());
//#endif 


//#if 156410317 
return ret;
//#endif 

} 

//#endif 


//#if -511628372 
public CrMultiComposite()
    { 

//#if -1024592203 
setupHeadAndDesc();
//#endif 


//#if -71148447 
addSupportedDecision(UMLDecision.CONTAINMENT);
//#endif 


//#if -373846722 
setKnowledgeTypes(Critic.KT_SEMANTICS);
//#endif 


//#if 469571517 
addTrigger("aggregation");
//#endif 


//#if 927428426 
addTrigger("multiplicity");
//#endif 

} 

//#endif 


//#if -1360481805 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if -506276521 
boolean problem = NO_PROBLEM;
//#endif 


//#if -1006554105 
if(Model.getFacade().isAAssociationEnd(dm))//1
{ 

//#if -1084043861 
if(Model.getFacade().isComposite(dm))//1
{ 

//#if -1597783927 
if(Model.getFacade().getUpper(dm) > 1)//1
{ 

//#if 1303078234 
problem = PROBLEM_FOUND;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 347920271 
return problem;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

