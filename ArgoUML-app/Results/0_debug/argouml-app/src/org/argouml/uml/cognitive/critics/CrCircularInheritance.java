
//#if -1213291444 
// Compilation Unit of /CrCircularInheritance.java 
 

//#if -121833229 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 1574837958 
import java.util.HashSet;
//#endif 


//#if 423704600 
import java.util.Set;
//#endif 


//#if -1841618112 
import org.apache.log4j.Logger;
//#endif 


//#if -1090377449 
import org.argouml.cognitive.Critic;
//#endif 


//#if 1393812864 
import org.argouml.cognitive.Designer;
//#endif 


//#if -126172782 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 5918387 
import org.argouml.model.Model;
//#endif 


//#if 862191861 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 93834919 
public class CrCircularInheritance extends 
//#if -1535285629 
CrUML
//#endif 

  { 

//#if -2094039576 
private static final Logger LOG =
        Logger.getLogger(CrCircularInheritance.class);
//#endif 


//#if 514847698 
public CrCircularInheritance()
    { 

//#if -2036051002 
setupHeadAndDesc();
//#endif 


//#if 1489207401 
setPriority(ToDoItem.HIGH_PRIORITY);
//#endif 


//#if 1199719240 
addSupportedDecision(UMLDecision.INHERITANCE);
//#endif 


//#if 220842949 
setKnowledgeTypes(Critic.KT_SYNTAX);
//#endif 


//#if -109356098 
addTrigger("generalization");
//#endif 

} 

//#endif 


//#if -1447993168 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 1675959332 
boolean problem = NO_PROBLEM;
//#endif 


//#if -355995197 
if(Model.getFacade().isAGeneralizableElement(dm))//1
{ 

//#if -313067365 
try //1
{ 

//#if 96281195 
Model.getCoreHelper().getChildren(dm);
//#endif 

} 

//#if -1456322631 
catch (IllegalStateException ex) //1
{ 

//#if -88322700 
problem = PROBLEM_FOUND;
//#endif 


//#if -2138084996 
LOG.info("problem found for: " + this);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 525412828 
return problem;
//#endif 

} 

//#endif 


//#if 517563439 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if -1433651225 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if 1648941601 
ret.add(Model.getMetaTypes().getGeneralizableElement());
//#endif 


//#if -1591928145 
return ret;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

