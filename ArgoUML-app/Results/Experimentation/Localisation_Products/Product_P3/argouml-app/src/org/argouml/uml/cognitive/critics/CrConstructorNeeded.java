package org.argouml.uml.cognitive.critics;
import java.util.Collection;
import java.util.Iterator;
import org.argouml.cognitive.Critic;
import org.argouml.cognitive.Designer;
import org.argouml.cognitive.ToDoItem;
import org.argouml.cognitive.critics.Wizard;
import org.argouml.model.Model;
import org.argouml.uml.cognitive.UMLDecision;
public class CrConstructorNeeded extends CrUML
  { 
@Override
    public Class getWizardClass(ToDoItem item)
    { 
return WizAddConstructor.class;
} 
public CrConstructorNeeded()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.STORAGE);
addKnowledgeType(Critic.KT_CORRECTNESS);
addTrigger("behavioralFeature");
addTrigger("structuralFeature");
} 
@Override
    public void initWizard(Wizard w)
    { 
if(w instanceof WizAddConstructor)//1
{ 
ToDoItem item = (ToDoItem) w.getToDoItem();
Object me = item.getOffenders().get(0);
String ins = super.getInstructions();
String sug = null;
if(me != null)//1
{ 
sug = Model.getFacade().getName(me);
} 
if("".equals(sug))//1
{ 
sug = super.getDefaultSuggestion();
} 
((WizAddConstructor) w).setInstructions(ins);
((WizAddConstructor) w).setSuggestion(sug);
} 
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
if(Model.getFacade().isType(dm))//1
{ 
return NO_PROBLEM;
} 
if(Model.getFacade().isUtility(dm))//1
{ 
return NO_PROBLEM;
} 
Collection operations = Model.getFacade().getOperations(dm);
Iterator opers = operations.iterator();
while (opers.hasNext()) //1
{ 
if(Model.getFacade().isConstructor(opers.next()))//1
{ 
return NO_PROBLEM;
} 
} 
Iterator attrs = Model.getFacade().getAttributes(dm).iterator();
while (attrs.hasNext()) //1
{ 
Object attr = attrs.next();
if(Model.getFacade().isStatic(attr))//1
{ 
continue;
} 
if(Model.getFacade().isInitialized(attr))//1
{ 
continue;
} 
return PROBLEM_FOUND;
} 
return NO_PROBLEM;
} 

 } 
