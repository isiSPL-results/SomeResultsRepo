
//#if 414398769 
// Compilation Unit of /CrIllegalGeneralization.java 
 

//#if 21540206 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -2109515541 
import java.util.HashSet;
//#endif 


//#if -407155523 
import java.util.Set;
//#endif 


//#if 529207163 
import org.argouml.cognitive.Designer;
//#endif 


//#if 1404213528 
import org.argouml.model.Model;
//#endif 


//#if -1392265574 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -1939940749 
public class CrIllegalGeneralization extends 
//#if 1722227363 
CrUML
//#endif 

  { 

//#if 1263472696 
@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 1053632111 
if(!(Model.getFacade().isAGeneralization(dm)))//1
{ 

//#if -2037537898 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -394931941 
Object gen = dm;
//#endif 


//#if 1019216570 
Object cls1 = Model.getFacade().getGeneral(gen);
//#endif 


//#if -1297364715 
Object cls2 = Model.getFacade().getSpecific(gen);
//#endif 


//#if 1530767525 
if(cls1 == null || cls2 == null)//1
{ 

//#if -946354011 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1685899450 
java.lang.Class javaClass1 = cls1.getClass();
//#endif 


//#if 395424090 
java.lang.Class javaClass2 = cls2.getClass();
//#endif 


//#if -765151941 
if(javaClass1 != javaClass2)//1
{ 

//#if -451495716 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if -759802049 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1647047783 
public CrIllegalGeneralization()
    { 

//#if -2003326820 
setupHeadAndDesc();
//#endif 


//#if -1965647694 
addSupportedDecision(UMLDecision.INHERITANCE);
//#endif 


//#if 2038865347 
addTrigger("supertype");
//#endif 


//#if 195156062 
addTrigger("subtype");
//#endif 

} 

//#endif 


//#if -942673841 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if 123702279 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if -615981503 
ret.add(Model.getMetaTypes().getGeneralizableElement());
//#endif 


//#if -1058974001 
return ret;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

