package org.argouml.uml;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import org.argouml.model.Model;
import org.tigris.gef.util.ChildGenerator;
public class GenDescendantClasses implements ChildGenerator
  { 
private static final GenDescendantClasses SINGLETON =
        new GenDescendantClasses();
public Enumeration gen(Object o)
    { 
Set res = new HashSet();
if(Model.getFacade().isAGeneralizableElement(o))//1
{ 
Object cls = o;
accumulateDescendants(cls, res);
} 
return Collections.enumeration(res);
} 
private void accumulateDescendants(final Object cls, Collection accum)
    { 
Collection gens = Model.getFacade().getSpecializations(cls);
if(gens == null)//1
{ 
return;
} 
for (Object g : gens) //1
{ 
Object ge = Model.getFacade().getSpecific(g);
if(!accum.contains(ge))//1
{ 
accum.add(ge);
accumulateDescendants(cls, accum);
} 
} 
} 
public static GenDescendantClasses getSINGLETON()
    { 
return SINGLETON;
} 

 } 
