
//#if -1454321782 
// Compilation Unit of /GenDescendantClasses.java 
 

//#if -1001761540 
package org.argouml.uml;
//#endif 


//#if -2137438358 
import java.util.Collection;
//#endif 


//#if -1836077863 
import java.util.Collections;
//#endif 


//#if 831610471 
import java.util.Enumeration;
//#endif 


//#if 430747482 
import java.util.HashSet;
//#endif 


//#if -1401474388 
import java.util.Set;
//#endif 


//#if 1075257415 
import org.argouml.model.Model;
//#endif 


//#if 793748229 
import org.tigris.gef.util.ChildGenerator;
//#endif 


//#if 259621786 
public class GenDescendantClasses implements 
//#if 1565526253 
ChildGenerator
//#endif 

  { 

//#if 210788327 
private static final GenDescendantClasses SINGLETON =
        new GenDescendantClasses();
//#endif 


//#if 443744441 
public Enumeration gen(Object o)
    { 

//#if -1740192597 
Set res = new HashSet();
//#endif 


//#if -644322573 
if(Model.getFacade().isAGeneralizableElement(o))//1
{ 

//#if 362125486 
Object cls = o;
//#endif 


//#if -622068308 
accumulateDescendants(cls, res);
//#endif 

} 

//#endif 


//#if -1725518140 
return Collections.enumeration(res);
//#endif 

} 

//#endif 


//#if -1600997136 
private void accumulateDescendants(final Object cls, Collection accum)
    { 

//#if 136810703 
Collection gens = Model.getFacade().getSpecializations(cls);
//#endif 


//#if 2020199304 
if(gens == null)//1
{ 

//#if 182907168 
return;
//#endif 

} 

//#endif 


//#if -185453935 
for (Object g : gens) //1
{ 

//#if 2104925025 
Object ge = Model.getFacade().getSpecific(g);
//#endif 


//#if -1304287233 
if(!accum.contains(ge))//1
{ 

//#if 1136116535 
accum.add(ge);
//#endif 


//#if 362703242 
accumulateDescendants(cls, accum);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -954486660 
public static GenDescendantClasses getSINGLETON()
    { 

//#if 774527554 
return SINGLETON;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

