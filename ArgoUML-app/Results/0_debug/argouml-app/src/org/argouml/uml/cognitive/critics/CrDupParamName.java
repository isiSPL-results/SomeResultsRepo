
//#if -2082609361 
// Compilation Unit of /CrDupParamName.java 
 

//#if 856614361 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 965501213 
import java.util.ArrayList;
//#endif 


//#if 1205364708 
import java.util.Collection;
//#endif 


//#if -1762397920 
import java.util.HashSet;
//#endif 


//#if -1094042156 
import java.util.Iterator;
//#endif 


//#if 42092402 
import java.util.Set;
//#endif 


//#if -454477187 
import org.argouml.cognitive.Critic;
//#endif 


//#if -1686358682 
import org.argouml.cognitive.Designer;
//#endif 


//#if -885295731 
import org.argouml.model.Model;
//#endif 


//#if -148692401 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 456623075 
public class CrDupParamName extends 
//#if -1075619719 
CrUML
//#endif 

  { 

//#if -101913458 
@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if -1269451661 
if(!Model.getFacade().isABehavioralFeature(dm))//1
{ 

//#if -2021970291 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 788313457 
Object bf = dm;
//#endif 


//#if -1257289968 
Collection<String> namesSeen = new ArrayList<String>();
//#endif 


//#if 93566121 
Iterator params = Model.getFacade().getParameters(bf).iterator();
//#endif 


//#if 79433726 
while (params.hasNext()) //1
{ 

//#if 173008555 
Object p = params.next();
//#endif 


//#if -1615816954 
String pName = Model.getFacade().getName(p);
//#endif 


//#if 1256109480 
if(pName == null || "".equals(pName))//1
{ 

//#if 1910577372 
continue;
//#endif 

} 

//#endif 


//#if 1466520937 
if(namesSeen.contains(pName))//1
{ 

//#if 1514760633 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if -97267365 
namesSeen.add(pName);
//#endif 

} 

//#endif 


//#if 352825137 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1817050402 
public CrDupParamName()
    { 

//#if -667713717 
setupHeadAndDesc();
//#endif 


//#if -373152245 
addSupportedDecision(UMLDecision.CONTAINMENT);
//#endif 


//#if -868189472 
setKnowledgeTypes(Critic.KT_SYNTAX);
//#endif 

} 

//#endif 


//#if 304251557 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if -1376936321 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if -334202051 
ret.add(Model.getMetaTypes().getOperation());
//#endif 


//#if 583372615 
return ret;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

