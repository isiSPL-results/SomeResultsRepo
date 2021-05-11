
//#if -375647868 
// Compilation Unit of /CrNoInstanceVariables.java 
 

//#if 135700616 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 13739665 
import java.util.HashSet;
//#endif 


//#if -1868351869 
import java.util.Iterator;
//#endif 


//#if 1831755107 
import java.util.Set;
//#endif 


//#if 446034096 
import javax.swing.Icon;
//#endif 


//#if -1639816084 
import org.argouml.cognitive.Critic;
//#endif 


//#if 1664262037 
import org.argouml.cognitive.Designer;
//#endif 


//#if 144276391 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if -1918314266 
import org.argouml.cognitive.critics.Wizard;
//#endif 


//#if -1126329794 
import org.argouml.model.Model;
//#endif 


//#if -2053589696 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -1646521496 
public class CrNoInstanceVariables extends 
//#if -1135104588 
CrUML
//#endif 

  { 

//#if 2089491154 
private static final int MAX_DEPTH = 50;
//#endif 


//#if 1505246503 
@Override
    public Icon getClarifier()
    { 

//#if 931033579 
return ClAttributeCompartment.getTheInstance();
//#endif 

} 

//#endif 


//#if -45272686 
private boolean findChangeableInstanceAttributeInInherited(Object dm,
            int depth)
    { 

//#if 589442962 
Iterator attribs = Model.getFacade().getAttributes(dm).iterator();
//#endif 


//#if -1826857619 
while (attribs.hasNext()) //1
{ 

//#if -1381983585 
Object attr = attribs.next();
//#endif 


//#if -1633207587 
if(!Model.getFacade().isStatic(attr)
                    && !Model.getFacade().isReadOnly(attr))//1
{ 

//#if 1872857200 
return true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1673398679 
if(depth > MAX_DEPTH)//1
{ 

//#if -1472375483 
return false;
//#endif 

} 

//#endif 


//#if -1019013597 
Iterator iter = Model.getFacade().getGeneralizations(dm).iterator();
//#endif 


//#if 684288868 
while (iter.hasNext()) //1
{ 

//#if 23615497 
Object parent = Model.getFacade().getGeneral(iter.next());
//#endif 


//#if 1575542643 
if(parent == dm)//1
{ 

//#if -1278143008 
continue;
//#endif 

} 

//#endif 


//#if 1860366408 
if(Model.getFacade().isAClassifier(parent)
                    && findChangeableInstanceAttributeInInherited(
                        parent, depth + 1))//1
{ 

//#if 1217318845 
return true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1657620373 
return false;
//#endif 

} 

//#endif 


//#if -897798240 
@Override
    public Class getWizardClass(ToDoItem item)
    { 

//#if -228905343 
return WizAddInstanceVariable.class;
//#endif 

} 

//#endif 


//#if 1602914290 
@Override
    public void initWizard(Wizard w)
    { 

//#if -912069319 
if(w instanceof WizAddInstanceVariable)//1
{ 

//#if -1289477639 
String ins = super.getInstructions();
//#endif 


//#if 2002187848 
String sug = super.getDefaultSuggestion();
//#endif 


//#if 178283771 
((WizAddInstanceVariable) w).setInstructions(ins);
//#endif 


//#if -1301347791 
((WizAddInstanceVariable) w).setSuggestion(sug);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1734768007 
public CrNoInstanceVariables()
    { 

//#if -488141805 
setupHeadAndDesc();
//#endif 


//#if -451342388 
addSupportedDecision(UMLDecision.STORAGE);
//#endif 


//#if 2103009477 
setKnowledgeTypes(Critic.KT_COMPLETENESS);
//#endif 


//#if 862447368 
addTrigger("structuralFeature");
//#endif 

} 

//#endif 


//#if -848224736 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if 910319756 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if 2141459009 
ret.add(Model.getMetaTypes().getUMLClass());
//#endif 


//#if -72464492 
return ret;
//#endif 

} 

//#endif 


//#if 861003017 
@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if -799873184 
if(!(Model.getFacade().isAClass(dm)))//1
{ 

//#if -1793209355 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1575323034 
if(!(Model.getFacade().isPrimaryObject(dm)))//1
{ 

//#if -79678965 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1811905984 
if((Model.getFacade().getName(dm) == null)
                || ("".equals(Model.getFacade().getName(dm))))//1
{ 

//#if -400432481 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 619365429 
if(Model.getFacade().isType(dm))//1
{ 

//#if -1309830822 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -313211183 
if(Model.getFacade().isUtility(dm))//1
{ 

//#if -1141391234 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 385020572 
if(findChangeableInstanceAttributeInInherited(dm, 0))//1
{ 

//#if -1068224823 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -693201755 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

