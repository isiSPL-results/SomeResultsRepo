package org.argouml.uml.cognitive.critics;
import java.util.HashSet;
import java.util.Set;
import org.argouml.cognitive.Critic;
import org.argouml.cognitive.Designer;
import org.argouml.cognitive.ListSet;
import org.argouml.cognitive.ToDoItem;
import org.argouml.model.Model;
import org.argouml.uml.GenCompositeClasses2;
import org.argouml.uml.cognitive.UMLDecision;
import org.argouml.uml.cognitive.UMLToDoItem;
public class CrCircularComposition extends CrUML
  { 
public Class getWizardClass(ToDoItem item)
    { 
return WizBreakCircularComp.class;
} 
public boolean predicate2(Object dm, Designer dsgr)
    { 
if(!(Model.getFacade().isAClassifier(dm)))//1
{ 
return NO_PROBLEM;
} 
ListSet reach =
            (new ListSet(dm)).reachable(GenCompositeClasses2.getInstance());
if(reach.contains(dm))//1
{ 
return PROBLEM_FOUND;
} 
return NO_PROBLEM;
} 
public boolean stillValid(ToDoItem i, Designer dsgr)
    { 
if(!isActive())//1
{ 
return false;
} 
ListSet offs = i.getOffenders();
Object dm =  offs.get(0);
if(!predicate(dm, dsgr))//1
{ 
return false;
} 
ListSet newOffs = computeOffenders(dm);
boolean res = offs.equals(newOffs);
return res;
} 
protected ListSet computeOffenders(Object dm)
    { 
ListSet offs = new ListSet(dm);
ListSet above = offs.reachable(GenCompositeClasses2.getInstance());
for (Object cls2 : above) //1
{ 
ListSet trans = (new ListSet(cls2))
                            .reachable(GenCompositeClasses2.getInstance());
if(trans.contains(dm))//1
{ 
offs.add(cls2);
} 
} 
return offs;
} 
public CrCircularComposition()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.CONTAINMENT);
setKnowledgeTypes(Critic.KT_SYNTAX);
setPriority(ToDoItem.LOW_PRIORITY);
} 
public ToDoItem toDoItem(Object dm, Designer dsgr)
    { 
ListSet offs = computeOffenders(dm);
return new UMLToDoItem(this, offs, dsgr);
} 
public Set<Object> getCriticizedDesignMaterials()
    { 
Set<Object> ret = new HashSet<Object>();
ret.add(Model.getMetaTypes().getUMLClass());
return ret;
} 

 } 
