// Compilation Unit of /CrUselessAbstract.java 
 
package org.argouml.uml.cognitive.critics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.argouml.cognitive.Designer;
import org.argouml.cognitive.Goal;
import org.argouml.cognitive.ListSet;
import org.argouml.model.Model;
import org.argouml.uml.cognitive.UMLDecision;
import org.argouml.util.ChildGenerator;
class ChildGenDerivedClasses implements ChildGenerator
  { 
public Iterator childIterator(Object o)
    { 
Object c = o;
Collection specs = new ArrayList(Model.getFacade()
                                         .getSpecializations(c));
if(specs == null)//1
{ 
return Collections.emptySet().iterator();
} 

List specClasses = new ArrayList(specs.size());
for (Object g : specs) //1
{ 
Object ge = Model.getFacade().getSpecific(g);
if(ge != null)//1
{ 
specClasses.add(ge);
} 

} 

return specClasses.iterator();
} 

 } 

public class CrUselessAbstract extends CrUML
  { 
@Override
    public Set<Object> getCriticizedDesignMaterials()
    { 
Set<Object> ret = new HashSet<Object>();
ret.add(Model.getMetaTypes().getUMLClass());
return ret;
} 

@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 
if(!(Model.getFacade().isAClass(dm)))//1
{ 
return false;
} 

Object cls = dm;
if(!Model.getFacade().isAbstract(cls))//1
{ 
return false;
} 

ListSet derived =
            (new ListSet(cls)).reachable(new ChildGenDerivedClasses());
for (Object c : derived) //1
{ 
if(!Model.getFacade().isAbstract(c))//1
{ 
return false;
} 

} 

return true;
} 

public CrUselessAbstract()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.INHERITANCE);
addSupportedGoal(Goal.getUnspecifiedGoal());
addTrigger("specialization");
addTrigger("isAbstract");
} 

 } 


