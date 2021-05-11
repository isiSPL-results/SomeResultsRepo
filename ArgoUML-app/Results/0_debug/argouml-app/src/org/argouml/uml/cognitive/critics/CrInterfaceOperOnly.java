
//#if -1718694860 
// Compilation Unit of /CrInterfaceOperOnly.java 
 

//#if 812445682 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 1953571261 
import java.util.Collection;
//#endif 


//#if -386126361 
import java.util.HashSet;
//#endif 


//#if -1379296787 
import java.util.Iterator;
//#endif 


//#if 87949241 
import java.util.Set;
//#endif 


//#if 465242966 
import org.argouml.cognitive.Critic;
//#endif 


//#if 1696412671 
import org.argouml.cognitive.Designer;
//#endif 


//#if -1944141548 
import org.argouml.model.Model;
//#endif 


//#if -1717815914 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 237373136 
public class CrInterfaceOperOnly extends 
//#if -1013869718 
CrUML
//#endif 

  { 

//#if 1107394646 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if 105830717 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if 2084361489 
ret.add(Model.getMetaTypes().getInterface());
//#endif 


//#if -1004291195 
return ret;
//#endif 

} 

//#endif 


//#if -1567513687 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if -468230923 
if(!(Model.getFacade().isAInterface(dm)))//1
{ 

//#if -937156900 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 740595845 
Object inf = dm;
//#endif 


//#if -1209682974 
Collection sf = Model.getFacade().getFeatures(inf);
//#endif 


//#if 2083945051 
if(sf == null)//1
{ 

//#if -862673161 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1002990356 
for (Iterator iter = sf.iterator(); iter.hasNext();) //1
{ 

//#if -581439212 
if(Model.getFacade().isAStructuralFeature(iter.next()))//1
{ 

//#if 1709551352 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1799647768 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -793620543 
public CrInterfaceOperOnly()
    { 

//#if 1481780598 
setupHeadAndDesc();
//#endif 


//#if 1289882437 
addSupportedDecision(UMLDecision.PLANNED_EXTENSIONS);
//#endif 


//#if -132872171 
setKnowledgeTypes(Critic.KT_SYNTAX);
//#endif 


//#if 785374853 
addTrigger("structuralFeature");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

