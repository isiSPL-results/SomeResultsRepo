package org.argouml.uml.cognitive.critics;
import java.util.HashSet;
import java.util.Set;
import org.argouml.cognitive.Critic;
import org.argouml.cognitive.Designer;
import org.argouml.cognitive.ListSet;
import org.argouml.cognitive.ToDoItem;
import org.argouml.cognitive.critics.Wizard;
import org.argouml.model.Model;
import org.argouml.uml.cognitive.UMLDecision;
import org.argouml.uml.cognitive.UMLToDoItem;
public class CrUnconventionalOperName extends AbstractCrUnconventionalName
  { 
protected ListSet computeOffenders(Object dm)
    { 
ListSet offs = new ListSet(dm);
offs.add(Model.getFacade().getOwner(dm));
return offs;
} 
public CrUnconventionalOperName()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.NAMING);
setKnowledgeTypes(Critic.KT_SYNTAX);
addTrigger("feature_name");
} 
@Override
    public boolean stillValid(ToDoItem i, Designer dsgr)
    { 
if(!isActive())//1
{ 
return false;
} 
ListSet offs = i.getOffenders();
Object f = offs.get(0);
if(!predicate(f, dsgr))//1
{ 
return false;
} 
ListSet newOffs = computeOffenders(f);
boolean res = offs.equals(newOffs);
return res;
} 
public Set<Object> getCriticizedDesignMaterials()
    { 
Set<Object> ret = new HashSet<Object>();
ret.add(Model.getMetaTypes().getOperation());
return ret;
} 
@Override
    public void initWizard(Wizard w)
    { 
if(w instanceof WizOperName)//1
{ 
ToDoItem item = (ToDoItem) w.getToDoItem();
Object me = item.getOffenders().get(0);
String sug = Model.getFacade().getName(me);
sug = computeSuggestion(sug);
boolean cand = candidateForConstructor(me);
String ins;
if(cand)//1
{ 
ins = super.getLocalizedString("-ins-ext");
} 
else
{ 
ins = super.getInstructions();
} 
((WizOperName) w).setInstructions(ins);
((WizOperName) w).setSuggestion(sug);
((WizOperName) w).setPossibleConstructor(cand);
} 
} 
@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 
if(!(Model.getFacade().isAOperation(dm)))//1
{ 
return NO_PROBLEM;
} 
Object oper = dm;
String myName = Model.getFacade().getName(oper);
if(myName == null || myName.equals(""))//1
{ 
return NO_PROBLEM;
} 
String nameStr = myName;
if(nameStr == null || nameStr.length() == 0)//1
{ 
return NO_PROBLEM;
} 
char initalChar = nameStr.charAt(0);
for (Object stereo : Model.getFacade().getStereotypes(oper)) //1
{ 
if("create".equals(Model.getFacade().getName(stereo))
                    || "constructor".equals(
                        Model.getFacade().getName(stereo)))//1
{ 
return NO_PROBLEM;
} 
} 
if(!Character.isLowerCase(initalChar))//1
{ 
return PROBLEM_FOUND;
} 
return NO_PROBLEM;
} 
@Override
    public ToDoItem toDoItem(Object dm, Designer dsgr)
    { 
Object f = dm;
ListSet offs = computeOffenders(f);
return new UMLToDoItem(this, offs, dsgr);
} 
@Override
    public Class getWizardClass(ToDoItem item)
    { 
return WizOperName.class;
} 
protected boolean candidateForConstructor(Object me)
    { 
if(!(Model.getFacade().isAOperation(me)))//1
{ 
return false;
} 
Object oper = me;
String myName = Model.getFacade().getName(oper);
if(myName == null || myName.equals(""))//1
{ 
return false;
} 
Object cl = Model.getFacade().getOwner(oper);
String nameCl = Model.getFacade().getName(cl);
if(nameCl == null || nameCl.equals(""))//1
{ 
return false;
} 
if(myName.equals(nameCl))//1
{ 
return true;
} 
return false;
} 
public String computeSuggestion(String sug)
    { 
if(sug == null)//1
{ 
return "";
} 
return sug.substring(0, 1).toLowerCase() + sug.substring(1);
} 

 } 
