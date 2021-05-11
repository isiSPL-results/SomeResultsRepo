
//#if 1847486314 
// Compilation Unit of /CrUselessInterface.java 
 

//#if 1029367359 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 1984446458 
import java.util.HashSet;
//#endif 


//#if -905983430 
import java.util.Iterator;
//#endif 


//#if -1447816372 
import java.util.Set;
//#endif 


//#if -1765867677 
import org.argouml.cognitive.Critic;
//#endif 


//#if 787765452 
import org.argouml.cognitive.Designer;
//#endif 


//#if 1641980836 
import org.argouml.cognitive.Goal;
//#endif 


//#if 229357799 
import org.argouml.model.Model;
//#endif 


//#if 965050409 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -1713267639 
public class CrUselessInterface extends 
//#if -551208441 
CrUML
//#endif 

  { 

//#if 616886929 
private static final long serialVersionUID = -6586457111453473553L;
//#endif 


//#if 1019646643 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if 451675590 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if -1560366424 
ret.add(Model.getMetaTypes().getInterface());
//#endif 


//#if -1470693042 
return ret;
//#endif 

} 

//#endif 


//#if -1847438932 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if -1008365951 
if(!Model.getFacade().isAInterface(dm))//1
{ 

//#if 1751618896 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1375137832 
if(!Model.getFacade().isPrimaryObject(dm))//1
{ 

//#if -1518219487 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -2067252849 
Iterator iter =
            Model.getFacade().getSupplierDependencies(dm).iterator();
//#endif 


//#if 1964661406 
while (iter.hasNext()) //1
{ 

//#if -2013957035 
if(Model.getFacade().isRealize(iter.next()))//1
{ 

//#if 1124516024 
return NO_PROBLEM;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 934603312 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if 1695270928 
public CrUselessInterface()
    { 

//#if -1977899812 
setupHeadAndDesc();
//#endif 


//#if -1493765006 
addSupportedDecision(UMLDecision.INHERITANCE);
//#endif 


//#if 1957626189 
addSupportedGoal(Goal.getUnspecifiedGoal());
//#endif 


//#if -29133348 
setKnowledgeTypes(Critic.KT_COMPLETENESS);
//#endif 


//#if -2124036334 
addTrigger("realization");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

