
//#if -1167185665 
// Compilation Unit of /CrTooManyOper.java 
 

//#if 2134906840 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 1246721059 
import java.util.Collection;
//#endif 


//#if 1885824321 
import java.util.HashSet;
//#endif 


//#if 331697619 
import java.util.Iterator;
//#endif 


//#if -1588661229 
import java.util.Set;
//#endif 


//#if -1847836955 
import org.argouml.cognitive.Designer;
//#endif 


//#if -1493857042 
import org.argouml.model.Model;
//#endif 


//#if -2012464144 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -960837832 
public class CrTooManyOper extends 
//#if -2061639935 
AbstractCrTooMany
//#endif 

  { 

//#if 1529515969 
private static final int OPERATIONS_THRESHOLD = 20;
//#endif 


//#if -1089991056 
private static final long serialVersionUID = 3221965323817473947L;
//#endif 


//#if 817098063 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 1239455798 
if(!(Model.getFacade().isAClassifier(dm)))//1
{ 

//#if -1384095301 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 2033641147 
Collection str = Model.getFacade().getFeatures(dm);
//#endif 


//#if -903288236 
if(str == null)//1
{ 

//#if -1484925803 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1624348266 
int n = 0;
//#endif 


//#if 1214455989 
for (Iterator iter = str.iterator(); iter.hasNext();) //1
{ 

//#if 1793243198 
if(Model.getFacade().isABehavioralFeature(iter.next()))//1
{ 

//#if 1368961050 
n++;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -529199903 
if(n <= getThreshold())//1
{ 

//#if 579602909 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -775519352 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if 2015914864 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if 1522478030 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if -439714941 
ret.add(Model.getMetaTypes().getUMLClass());
//#endif 


//#if 1437180246 
return ret;
//#endif 

} 

//#endif 


//#if -1576789783 
public CrTooManyOper()
    { 

//#if -1589949017 
setupHeadAndDesc();
//#endif 


//#if -9871569 
addSupportedDecision(UMLDecision.METHODS);
//#endif 


//#if -867344575 
setThreshold(OPERATIONS_THRESHOLD);
//#endif 


//#if -1985061100 
addTrigger("behavioralFeature");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

