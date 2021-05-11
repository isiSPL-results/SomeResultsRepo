
//#if -732448953 
// Compilation Unit of /CrTooManyAttr.java 
 

//#if -1953213851 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -1039042192 
import java.util.Collection;
//#endif 


//#if 716385044 
import java.util.HashSet;
//#endif 


//#if -1561181600 
import java.util.Iterator;
//#endif 


//#if 540318566 
import java.util.Set;
//#endif 


//#if -10106894 
import org.argouml.cognitive.Designer;
//#endif 


//#if 39610497 
import org.argouml.model.Model;
//#endif 


//#if 1171642947 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -2130689874 
public class CrTooManyAttr extends 
//#if 1112450907 
AbstractCrTooMany
//#endif 

  { 

//#if -1347269573 
private static final int ATTRIBUTES_THRESHOLD = 7;
//#endif 


//#if -133823004 
private static final long serialVersionUID = 1281218975903539324L;
//#endif 


//#if 933337674 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if -875446984 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if 1276248813 
ret.add(Model.getMetaTypes().getUMLClass());
//#endif 


//#if -483253440 
return ret;
//#endif 

} 

//#endif 


//#if -464749771 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 649312271 
if(!(Model.getFacade().isAClassifier(dm)))//1
{ 

//#if 378956289 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1188451246 
Collection features = Model.getFacade().getFeatures(dm);
//#endif 


//#if -1656948655 
if(features == null)//1
{ 

//#if 1667043070 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 2130997507 
int n = 0;
//#endif 


//#if -1488487010 
for (Iterator iter = features.iterator(); iter.hasNext();) //1
{ 

//#if 664821162 
if(Model.getFacade().isAStructuralFeature(iter.next()))//1
{ 

//#if 2056841630 
n++;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1648465768 
if(n <= getThreshold())//1
{ 

//#if 738185500 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1340905073 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if 920681254 
public CrTooManyAttr()
    { 

//#if -1940033973 
setupHeadAndDesc();
//#endif 


//#if -394514796 
addSupportedDecision(UMLDecision.STORAGE);
//#endif 


//#if 1635893456 
setThreshold(ATTRIBUTES_THRESHOLD);
//#endif 


//#if -2070585392 
addTrigger("structuralFeature");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

