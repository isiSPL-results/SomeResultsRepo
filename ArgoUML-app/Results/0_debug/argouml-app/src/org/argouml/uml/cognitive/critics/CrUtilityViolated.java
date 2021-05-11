
//#if 485538044 
// Compilation Unit of /CrUtilityViolated.java 
 

//#if -2046183578 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 702302000 
import java.util.ArrayList;
//#endif 


//#if 1636123697 
import java.util.Collection;
//#endif 


//#if 807157747 
import java.util.HashSet;
//#endif 


//#if 1252772193 
import java.util.Iterator;
//#endif 


//#if 1307637701 
import java.util.Set;
//#endif 


//#if -527444621 
import org.argouml.cognitive.Designer;
//#endif 


//#if -1506534880 
import org.argouml.model.Model;
//#endif 


//#if 1764411810 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -1847693289 
public class CrUtilityViolated extends 
//#if -206928949 
CrUML
//#endif 

  { 

//#if 373513245 
public CrUtilityViolated()
    { 

//#if -527657395 
setupHeadAndDesc();
//#endif 


//#if -2050808750 
addSupportedDecision(UMLDecision.STORAGE);
//#endif 


//#if 401568088 
addSupportedDecision(UMLDecision.STEREOTYPES);
//#endif 


//#if -1352479300 
addSupportedDecision(UMLDecision.CLASS_SELECTION);
//#endif 


//#if 1932982159 
addTrigger("stereotype");
//#endif 


//#if 1283642414 
addTrigger("behavioralFeature");
//#endif 

} 

//#endif 


//#if -1904025760 
@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if -50381301 
if(!(Model.getFacade().isAClassifier(dm)))//1
{ 

//#if -784797971 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1647168703 
if(!(Model.getFacade().isUtility(dm)))//1
{ 

//#if 1195637442 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1228134613 
Collection classesToCheck = new ArrayList();
//#endif 


//#if 1108545348 
classesToCheck.addAll(Model.getCoreHelper().getSupertypes(dm));
//#endif 


//#if 869923351 
classesToCheck.addAll(
            Model.getCoreHelper().getAllRealizedInterfaces(dm));
//#endif 


//#if -1756396257 
classesToCheck.add(dm);
//#endif 


//#if -646353313 
Iterator it = classesToCheck.iterator();
//#endif 


//#if -572170220 
while (it.hasNext()) //1
{ 

//#if -1550048674 
Object o = it.next();
//#endif 


//#if -1148526493 
if(!Model.getFacade().isAInterface(o))//1
{ 

//#if 599283923 
Iterator it2 = Model.getFacade().getAttributes(o).iterator();
//#endif 


//#if 1917089470 
while (it2.hasNext()) //1
{ 

//#if -1572334092 
if(!Model.getFacade().isStatic(it2.next()))//1
{ 

//#if 1455547644 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 244178737 
Iterator it2 = Model.getFacade().getOperations(o).iterator();
//#endif 


//#if -1976157685 
while (it2.hasNext()) //1
{ 

//#if 642715098 
if(!Model.getFacade().isStatic(it2.next()))//1
{ 

//#if -1984017354 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 151071584 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 163145591 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if -1785333931 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if -1806287385 
ret.add(Model.getMetaTypes().getClassifier());
//#endif 


//#if -1146599523 
return ret;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

