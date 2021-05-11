package org.argouml.uml.cognitive.critics;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.swing.Icon;
import org.argouml.cognitive.Critic;
import org.argouml.cognitive.Designer;
import org.argouml.cognitive.ToDoItem;
import org.argouml.cognitive.critics.Wizard;
import org.argouml.model.Model;
import org.argouml.uml.cognitive.UMLDecision;
public class CrNoInstanceVariables extends CrUML
  { 
private static final int MAX_DEPTH = 50;
@Override
    public Icon getClarifier()
    { 
return ClAttributeCompartment.getTheInstance();
} 
private boolean findChangeableInstanceAttributeInInherited(Object dm,
            int depth)
    { 
Iterator attribs = Model.getFacade().getAttributes(dm).iterator();
while (attribs.hasNext()) //1
{ 
Object attr = attribs.next();
if(!Model.getFacade().isStatic(attr)
                    && !Model.getFacade().isReadOnly(attr))//1
{ 
return true;
} 
} 
if(depth > MAX_DEPTH)//1
{ 
return false;
} 
Iterator iter = Model.getFacade().getGeneralizations(dm).iterator();
while (iter.hasNext()) //1
{ 
Object parent = Model.getFacade().getGeneral(iter.next());
if(parent == dm)//1
{ 
continue;
} 
if(Model.getFacade().isAClassifier(parent)
                    && findChangeableInstanceAttributeInInherited(
                        parent, depth + 1))//1
{ 
return true;
} 
} 
return false;
} 
@Override
    public Class getWizardClass(ToDoItem item)
    { 
return WizAddInstanceVariable.class;
} 
@Override
    public void initWizard(Wizard w)
    { 
if(w instanceof WizAddInstanceVariable)//1
{ 
String ins = super.getInstructions();
String sug = super.getDefaultSuggestion();
((WizAddInstanceVariable) w).setInstructions(ins);
((WizAddInstanceVariable) w).setSuggestion(sug);
} 
} 
public CrNoInstanceVariables()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.STORAGE);
setKnowledgeTypes(Critic.KT_COMPLETENESS);
addTrigger("structuralFeature");
} 
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
return NO_PROBLEM;
} 
if(!(Model.getFacade().isPrimaryObject(dm)))//1
{ 
return NO_PROBLEM;
} 
if((Model.getFacade().getName(dm) == null)
                || ("".equals(Model.getFacade().getName(dm))))//1
{ 
return NO_PROBLEM;
} 
if(Model.getFacade().isType(dm))//1
{ 
return NO_PROBLEM;
} 
if(Model.getFacade().isUtility(dm))//1
{ 
return NO_PROBLEM;
} 
if(findChangeableInstanceAttributeInInherited(dm, 0))//1
{ 
return NO_PROBLEM;
} 
return PROBLEM_FOUND;
} 

 } 
