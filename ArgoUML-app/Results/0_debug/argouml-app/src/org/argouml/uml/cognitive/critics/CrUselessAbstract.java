
//#if 910745199 
// Compilation Unit of /CrUselessAbstract.java 
 

//#if 1465435644 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 708878170 
import java.util.ArrayList;
//#endif 


//#if 1839984967 
import java.util.Collection;
//#endif 


//#if 1204960924 
import java.util.Collections;
//#endif 


//#if -1288922467 
import java.util.HashSet;
//#endif 


//#if 698794999 
import java.util.Iterator;
//#endif 


//#if -1788287289 
import java.util.List;
//#endif 


//#if 635254639 
import java.util.Set;
//#endif 


//#if -844521719 
import org.argouml.cognitive.Designer;
//#endif 


//#if -1040019359 
import org.argouml.cognitive.Goal;
//#endif 


//#if 294940254 
import org.argouml.cognitive.ListSet;
//#endif 


//#if -1359196854 
import org.argouml.model.Model;
//#endif 


//#if -400741556 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -1594336885 
import org.argouml.util.ChildGenerator;
//#endif 


//#if 1213147332 
class ChildGenDerivedClasses implements 
//#if -761782248 
ChildGenerator
//#endif 

  { 

//#if -1527491121 
public Iterator childIterator(Object o)
    { 

//#if -1658660859 
Object c = o;
//#endif 


//#if -2080381122 
Collection specs = new ArrayList(Model.getFacade()
                                         .getSpecializations(c));
//#endif 


//#if -515020804 
if(specs == null)//1
{ 

//#if -1332799767 
return Collections.emptySet().iterator();
//#endif 

} 

//#endif 


//#if -1216538933 
List specClasses = new ArrayList(specs.size());
//#endif 


//#if -1178298833 
for (Object g : specs) //1
{ 

//#if -540793541 
Object ge = Model.getFacade().getSpecific(g);
//#endif 


//#if 586273744 
if(ge != null)//1
{ 

//#if -253841730 
specClasses.add(ge);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1638360391 
return specClasses.iterator();
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -1129058251 
public class CrUselessAbstract extends 
//#if -479068810 
CrUML
//#endif 

  { 

//#if -2051620876 
@Override
    public Set<Object> getCriticizedDesignMaterials()
    { 

//#if -407335694 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if 829585575 
ret.add(Model.getMetaTypes().getUMLClass());
//#endif 


//#if 1240999802 
return ret;
//#endif 

} 

//#endif 


//#if -1115228085 
@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 783034942 
if(!(Model.getFacade().isAClass(dm)))//1
{ 

//#if 2086030010 
return false;
//#endif 

} 

//#endif 


//#if -1316209114 
Object cls = dm;
//#endif 


//#if 640425329 
if(!Model.getFacade().isAbstract(cls))//1
{ 

//#if 240106596 
return false;
//#endif 

} 

//#endif 


//#if 1681210891 
ListSet derived =
            (new ListSet(cls)).reachable(new ChildGenDerivedClasses());
//#endif 


//#if -371478538 
for (Object c : derived) //1
{ 

//#if -991893121 
if(!Model.getFacade().isAbstract(c))//1
{ 

//#if -1471606277 
return false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1927520643 
return true;
//#endif 

} 

//#endif 


//#if -714207300 
public CrUselessAbstract()
    { 

//#if -138730483 
setupHeadAndDesc();
//#endif 


//#if 2023915169 
addSupportedDecision(UMLDecision.INHERITANCE);
//#endif 


//#if 1925532476 
addSupportedGoal(Goal.getUnspecifiedGoal());
//#endif 


//#if -840358442 
addTrigger("specialization");
//#endif 


//#if 1834411733 
addTrigger("isAbstract");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

