
//#if -86236094 
// Compilation Unit of /CrTooManyClasses.java 
 

//#if 147325036 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -235810070 
import java.util.ArrayList;
//#endif 


//#if -1675546697 
import java.util.Collection;
//#endif 


//#if -105549267 
import java.util.HashSet;
//#endif 


//#if 153114367 
import java.util.Set;
//#endif 


//#if -1254649479 
import org.argouml.cognitive.Designer;
//#endif 


//#if 214513882 
import org.argouml.model.Model;
//#endif 


//#if 652122844 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 831697552 
public class CrTooManyClasses extends 
//#if 1453567854 
AbstractCrTooMany
//#endif 

  { 

//#if 1144604718 
private static final int CLASS_THRESHOLD = 20;
//#endif 


//#if 1382756620 
private static final long serialVersionUID = -3270186791825482658L;
//#endif 


//#if -1102761982 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if -1342380417 
if(!(Model.getFacade().isANamespace(dm)))//1
{ 

//#if -1165373575 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1319255699 
Collection subs = Model.getFacade().getOwnedElements(dm);
//#endif 


//#if 1011127466 
Collection<Object> classes = new ArrayList<Object>();
//#endif 


//#if -1952737151 
for (Object me : subs) //1
{ 

//#if -1420821344 
if(Model.getFacade().isAClass(me))//1
{ 

//#if -729773846 
classes.add(me);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -226801226 
if(classes.size() <= getThreshold())//1
{ 

//#if 793698343 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 929566151 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if 681508672 
public CrTooManyClasses()
    { 

//#if 60747538 
setupHeadAndDesc();
//#endif 


//#if 220634199 
addSupportedDecision(UMLDecision.CLASS_SELECTION);
//#endif 


//#if -333023916 
setThreshold(CLASS_THRESHOLD);
//#endif 


//#if 1257138319 
addTrigger("ownedElement");
//#endif 

} 

//#endif 


//#if -1665171683 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if -1030099960 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if 433831368 
ret.add(Model.getMetaTypes().getNamespace());
//#endif 


//#if -953207280 
return ret;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

