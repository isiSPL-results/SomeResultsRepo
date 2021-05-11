
//#if 840763549 
// Compilation Unit of /CrSubclassReference.java 
 

//#if 862191571 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -1805004189 
import java.util.ArrayList;
//#endif 


//#if 1219043166 
import java.util.Collection;
//#endif 


//#if 1803322611 
import java.util.Enumeration;
//#endif 


//#if 451476454 
import java.util.HashSet;
//#endif 


//#if -1995689442 
import java.util.List;
//#endif 


//#if 1736942904 
import java.util.Set;
//#endif 


//#if -1448093705 
import org.argouml.cognitive.Critic;
//#endif 


//#if 1225874528 
import org.argouml.cognitive.Designer;
//#endif 


//#if 1747200551 
import org.argouml.cognitive.ListSet;
//#endif 


//#if -294111118 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if -1412246573 
import org.argouml.model.Model;
//#endif 


//#if 1563687180 
import org.argouml.uml.GenDescendantClasses;
//#endif 


//#if -1501753835 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -1717525256 
import org.argouml.uml.cognitive.UMLToDoItem;
//#endif 


//#if 1153653007 
public class CrSubclassReference extends 
//#if -1540438076 
CrUML
//#endif 

  { 

//#if -1323281639 
@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 1460646392 
if(!(Model.getFacade().isAClass(dm)))//1
{ 

//#if 1617663460 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1475472724 
Object cls = dm;
//#endif 


//#if -1406473504 
ListSet offs = computeOffenders(cls);
//#endif 


//#if -1804892058 
if(offs != null)//1
{ 

//#if 1253062826 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if 1652289654 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -822526839 
public ListSet computeOffenders(Object cls)
    { 

//#if -1461325742 
Collection asc = Model.getFacade().getAssociationEnds(cls);
//#endif 


//#if 1403180797 
if(asc == null || asc.size() == 0)//1
{ 

//#if -1636249821 
return null;
//#endif 

} 

//#endif 


//#if 585800535 
Enumeration descendEnum =
            GenDescendantClasses.getSINGLETON().gen(cls);
//#endif 


//#if 1460932807 
if(!descendEnum.hasMoreElements())//1
{ 

//#if -1916362386 
return null;
//#endif 

} 

//#endif 


//#if 205368634 
ListSet descendants = new ListSet();
//#endif 


//#if 1708130406 
while (descendEnum.hasMoreElements()) //1
{ 

//#if -989433607 
descendants.add(descendEnum.nextElement());
//#endif 

} 

//#endif 


//#if -1982217040 
ListSet offs = null;
//#endif 


//#if -1721612272 
for (Object ae : asc) //1
{ 

//#if -598080065 
Object a = Model.getFacade().getAssociation(ae);
//#endif 


//#if -1896238740 
List conn = new ArrayList(Model.getFacade().getConnections(a));
//#endif 


//#if -1191906098 
if(conn.size() != 2)//1
{ 

//#if 613882255 
continue;
//#endif 

} 

//#endif 


//#if -210010838 
Object otherEnd = conn.get(0);
//#endif 


//#if 319883069 
if(ae == conn.get(0))//1
{ 

//#if 1804193997 
otherEnd = conn.get(1);
//#endif 

} 

//#endif 


//#if 282567392 
if(!Model.getFacade().isNavigable(otherEnd))//1
{ 

//#if 1295395502 
continue;
//#endif 

} 

//#endif 


//#if -912493308 
Object otherCls = Model.getFacade().getType(otherEnd);
//#endif 


//#if -1274191590 
if(descendants.contains(otherCls))//1
{ 

//#if -855987946 
if(offs == null)//1
{ 

//#if 1541100715 
offs = new ListSet();
//#endif 


//#if 159176505 
offs.add(cls);
//#endif 

} 

//#endif 


//#if -718564438 
offs.add(a);
//#endif 


//#if 279395445 
offs.add(otherCls);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 534313208 
return offs;
//#endif 

} 

//#endif 


//#if 157530434 
@Override
    public ToDoItem toDoItem(Object dm, Designer dsgr)
    { 

//#if -1546061857 
Object cls = dm;
//#endif 


//#if 1060459405 
ListSet offs = computeOffenders(cls);
//#endif 


//#if -1774374800 
return new UMLToDoItem(this, offs, dsgr);
//#endif 

} 

//#endif 


//#if -1814797944 
@Override
    public boolean stillValid(ToDoItem i, Designer dsgr)
    { 

//#if -1318628095 
if(!isActive())//1
{ 

//#if -143925730 
return false;
//#endif 

} 

//#endif 


//#if -784590038 
ListSet offs = i.getOffenders();
//#endif 


//#if 1423913993 
Object dm = offs.get(0);
//#endif 


//#if 609122229 
ListSet newOffs = computeOffenders(dm);
//#endif 


//#if -1987708892 
boolean res = offs.equals(newOffs);
//#endif 


//#if 148483229 
return res;
//#endif 

} 

//#endif 


//#if -675822565 
public CrSubclassReference()
    { 

//#if 1940402581 
setupHeadAndDesc();
//#endif 


//#if -1324932854 
addSupportedDecision(UMLDecision.RELATIONSHIPS);
//#endif 


//#if -369735772 
addSupportedDecision(UMLDecision.PLANNED_EXTENSIONS);
//#endif 


//#if -1494771682 
setKnowledgeTypes(Critic.KT_SEMANTICS);
//#endif 


//#if -1138169506 
addTrigger("specialization");
//#endif 


//#if 1342174191 
addTrigger("associationEnd");
//#endif 

} 

//#endif 


//#if -237067216 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if 1161206853 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if 1168213242 
ret.add(Model.getMetaTypes().getUMLClass());
//#endif 


//#if -1097516915 
return ret;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

