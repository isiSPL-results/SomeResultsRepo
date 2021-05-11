
//#if -555537373 
// Compilation Unit of /CrEmptyPackage.java 
 

//#if -1358013649 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -1913238598 
import java.util.Collection;
//#endif 


//#if 276204810 
import java.util.HashSet;
//#endif 


//#if 749955164 
import java.util.Set;
//#endif 


//#if -311374204 
import org.apache.log4j.Logger;
//#endif 


//#if -486029892 
import org.argouml.cognitive.Designer;
//#endif 


//#if 1536162295 
import org.argouml.model.Model;
//#endif 


//#if -1139104455 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -1036211719 
public class CrEmptyPackage extends 
//#if 1698339465 
CrUML
//#endif 

  { 

//#if 1462880026 
private static final Logger LOG = Logger.getLogger(CrEmptyPackage.class);
//#endif 


//#if 14366606 
public CrEmptyPackage()
    { 

//#if 249937713 
setupHeadAndDesc();
//#endif 


//#if -1072434219 
addSupportedDecision(UMLDecision.MODULARITY);
//#endif 


//#if 1051634094 
addTrigger("ownedElement");
//#endif 

} 

//#endif 


//#if 1018066945 
@Override
    public Set<Object> getCriticizedDesignMaterials()
    { 

//#if -298465132 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if 2116752295 
ret.add(Model.getMetaTypes().getPackage());
//#endif 


//#if -1611683428 
return ret;
//#endif 

} 

//#endif 


//#if -1847489890 
@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if -67937494 
if(!(Model.getFacade().isAPackage(dm)))//1
{ 

//#if 1669134957 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1060555088 
Collection elems = Model.getFacade().getOwnedElements(dm);
//#endif 


//#if -963008235 
if(elems.size() == 0)//1
{ 

//#if -1152020315 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if -1542542730 
return NO_PROBLEM;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

