
//#if -526077201 
// Compilation Unit of /CrCircularComposition.java 
 

//#if 1849084766 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -536093445 
import java.util.HashSet;
//#endif 


//#if -1979164467 
import java.util.Set;
//#endif 


//#if -766728779 
import org.apache.log4j.Logger;
//#endif 


//#if 2134435778 
import org.argouml.cognitive.Critic;
//#endif 


//#if -527063701 
import org.argouml.cognitive.Designer;
//#endif 


//#if 1136464828 
import org.argouml.cognitive.ListSet;
//#endif 


//#if -2047049347 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 1080807720 
import org.argouml.model.Model;
//#endif 


//#if 170196749 
import org.argouml.uml.GenCompositeClasses2;
//#endif 


//#if -17722710 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -233494131 
import org.argouml.uml.cognitive.UMLToDoItem;
//#endif 


//#if -871484228 
public class CrCircularComposition extends 
//#if -1173394920 
CrUML
//#endif 

  { 

//#if 1959289939 
private static final Logger LOG =
        Logger.getLogger(CrCircularComposition.class);
//#endif 


//#if 1092864046 
public Class getWizardClass(ToDoItem item)
    { 

//#if -1343568102 
return WizBreakCircularComp.class;
//#endif 

} 

//#endif 


//#if -35215173 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if -786793172 
if(!(Model.getFacade().isAClassifier(dm)))//1
{ 

//#if 1581774530 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -692516334 
ListSet reach =
            (new ListSet(dm)).reachable(GenCompositeClasses2.getInstance());
//#endif 


//#if -656616548 
if(reach.contains(dm))//1
{ 

//#if -351034454 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if -584010239 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -539443162 
public boolean stillValid(ToDoItem i, Designer dsgr)
    { 

//#if 1333423833 
if(!isActive())//1
{ 

//#if -1058699130 
return false;
//#endif 

} 

//#endif 


//#if -1873614254 
ListSet offs = i.getOffenders();
//#endif 


//#if -1515476175 
Object dm =  offs.get(0);
//#endif 


//#if -698018267 
if(!predicate(dm, dsgr))//1
{ 

//#if 1745428583 
return false;
//#endif 

} 

//#endif 


//#if -1360016499 
ListSet newOffs = computeOffenders(dm);
//#endif 


//#if -925173764 
boolean res = offs.equals(newOffs);
//#endif 


//#if 11635671 
LOG.debug("offs=" + offs.toString()
                  + " newOffs=" + newOffs.toString()
                  + " res = " + res);
//#endif 


//#if 238034549 
return res;
//#endif 

} 

//#endif 


//#if 659838943 
protected ListSet computeOffenders(Object dm)
    { 

//#if 1406588649 
ListSet offs = new ListSet(dm);
//#endif 


//#if 926615989 
ListSet above = offs.reachable(GenCompositeClasses2.getInstance());
//#endif 


//#if 1885969490 
for (Object cls2 : above) //1
{ 

//#if 737154736 
ListSet trans = (new ListSet(cls2))
                            .reachable(GenCompositeClasses2.getInstance());
//#endif 


//#if -1625374785 
if(trans.contains(dm))//1
{ 

//#if 1032659852 
offs.add(cls2);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 38367430 
return offs;
//#endif 

} 

//#endif 


//#if -1547059897 
public CrCircularComposition()
    { 

//#if 211851858 
setupHeadAndDesc();
//#endif 


//#if -88908124 
addSupportedDecision(UMLDecision.CONTAINMENT);
//#endif 


//#if 575270585 
setKnowledgeTypes(Critic.KT_SYNTAX);
//#endif 


//#if -319491145 
setPriority(ToDoItem.LOW_PRIORITY);
//#endif 

} 

//#endif 


//#if -1047845024 
public ToDoItem toDoItem(Object dm, Designer dsgr)
    { 

//#if -1434326686 
ListSet offs = computeOffenders(dm);
//#endif 


//#if 855512104 
return new UMLToDoItem(this, offs, dsgr);
//#endif 

} 

//#endif 


//#if 1364008324 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if -812976010 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if 888348715 
ret.add(Model.getMetaTypes().getUMLClass());
//#endif 


//#if 463990782 
return ret;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

