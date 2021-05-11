// Compilation Unit of /CrCircularInheritance.java 
 

//#if COGNITIVE 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if COGNITIVE 
import java.util.HashSet;
//#endif 


//#if COGNITIVE 
import java.util.Set;
//#endif 


//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
import org.apache.log4j.Logger;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Critic;
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
public class CrCircularInheritance extends CrUML
  { 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
private static final Logger LOG =
        Logger.getLogger(CrCircularInheritance.class);
//#endif 

public CrCircularInheritance()
    { 
setupHeadAndDesc();
setPriority(ToDoItem.HIGH_PRIORITY);
addSupportedDecision(UMLDecision.INHERITANCE);
setKnowledgeTypes(Critic.KT_SYNTAX);
addTrigger("generalization");
} 

public boolean predicate2(Object dm, Designer dsgr)
    { 
boolean problem = NO_PROBLEM;
if(Model.getFacade().isAGeneralizableElement(dm))//1
{ 
try //1
{ 
Model.getCoreHelper().getChildren(dm);
} 

//#if COGNITIVE 
catch (IllegalStateException ex) //1
{ 
problem = PROBLEM_FOUND;

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.info("problem found for: " + this);
//#endif 

} 

//#endif 


} 

return problem;
} 

public Set<Object> getCriticizedDesignMaterials()
    { 
Set<Object> ret = new HashSet<Object>();
ret.add(Model.getMetaTypes().getGeneralizableElement());
return ret;
} 

 } 

//#endif 


