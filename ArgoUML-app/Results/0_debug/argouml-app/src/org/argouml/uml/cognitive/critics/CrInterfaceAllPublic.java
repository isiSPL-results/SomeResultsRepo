
//#if 1867244560 
// Compilation Unit of /CrInterfaceAllPublic.java 
 

//#if 417675848 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -269444461 
import java.util.Collection;
//#endif 


//#if 1770869969 
import java.util.HashSet;
//#endif 


//#if 1063080003 
import java.util.Iterator;
//#endif 


//#if -2122634333 
import java.util.Set;
//#endif 


//#if -1384690132 
import org.argouml.cognitive.Critic;
//#endif 


//#if 2027166037 
import org.argouml.cognitive.Designer;
//#endif 


//#if 590188670 
import org.argouml.model.Model;
//#endif 


//#if 1609483136 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -2139354038 
public class CrInterfaceAllPublic extends 
//#if 1808787088 
CrUML
//#endif 

  { 

//#if 857927327 
public CrInterfaceAllPublic()
    { 

//#if -1620134730 
setupHeadAndDesc();
//#endif 


//#if -800275835 
addSupportedDecision(UMLDecision.PLANNED_EXTENSIONS);
//#endif 


//#if 1596942549 
setKnowledgeTypes(Critic.KT_SYNTAX);
//#endif 


//#if -294049691 
addTrigger("behavioralFeature");
//#endif 

} 

//#endif 


//#if -77691908 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if -2032859390 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if 400381164 
ret.add(Model.getMetaTypes().getInterface());
//#endif 


//#if -1670310518 
return ret;
//#endif 

} 

//#endif 


//#if -1051552957 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 1296009404 
if(!(Model.getFacade().isAInterface(dm)))//1
{ 

//#if -1310458408 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -2114680418 
Object inf = dm;
//#endif 


//#if 1064844698 
Collection bf = Model.getFacade().getFeatures(inf);
//#endif 


//#if 453152229 
if(bf == null)//1
{ 

//#if -1385759759 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1065119771 
Iterator features = bf.iterator();
//#endif 


//#if 1872339701 
while (features.hasNext()) //1
{ 

//#if -1857339668 
Object f = features.next();
//#endif 


//#if 1704240735 
if(Model.getFacade().getVisibility(f) == null)//1
{ 

//#if 1619060214 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1887819165 
if(!Model.getFacade().getVisibility(f)
                    .equals(Model.getVisibilityKind().getPublic()))//1
{ 

//#if 1738322423 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2028720463 
return NO_PROBLEM;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

