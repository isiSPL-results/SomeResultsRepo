package org.argouml.uml.cognitive.critics;
import java.util.HashSet;
import java.util.Set;
import javax.swing.Icon;
import org.argouml.cognitive.Critic;
import org.argouml.cognitive.Designer;
import org.argouml.cognitive.ToDoItem;
import org.argouml.cognitive.critics.Wizard;
import org.argouml.model.Model;
import org.argouml.uml.cognitive.UMLDecision;
public class CrUnconventionalPackName extends AbstractCrUnconventionalName
  { 
@Override
    public void initWizard(Wizard w)
    { 
if(w instanceof WizMEName)//1
{ 
ToDoItem item = (ToDoItem) w.getToDoItem();
Object me = item.getOffenders().get(0);
String ins = super.getInstructions();
String nameStr = Model.getFacade().getName(me);
String sug = computeSuggestion(nameStr);
((WizMEName) w).setInstructions(ins);
((WizMEName) w).setSuggestion(sug);
} 
} 
@Override
    public Class getWizardClass(ToDoItem item)
    { 
return WizMEName.class;
} 
public CrUnconventionalPackName()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.NAMING);
setKnowledgeTypes(Critic.KT_SYNTAX);
addTrigger("name");
} 
@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 
if(!(Model.getFacade().isAPackage(dm)))//1
{ 
return NO_PROBLEM;
} 
String myName = Model.getFacade().getName(dm);
if(myName == null || myName.equals(""))//1
{ 
return NO_PROBLEM;
} 
String nameStr = myName;
if(nameStr == null || nameStr.length() == 0)//1
{ 
return NO_PROBLEM;
} 
int size = nameStr.length();
for (int i = 0; i < size; i++) //1
{ 
char c = nameStr.charAt(i);
if(!Character.isLowerCase(c))//1
{ 
return PROBLEM_FOUND;
} 
} 
return NO_PROBLEM;
} 
public Set<Object> getCriticizedDesignMaterials()
    { 
Set<Object> ret = new HashSet<Object>();
ret.add(Model.getMetaTypes().getPackage());
return ret;
} 
public String computeSuggestion(String nameStr)
    { 
StringBuilder sug = new StringBuilder();
if(nameStr != null)//1
{ 
int size = nameStr.length();
for (int i = 0; i < size; i++) //1
{ 
char c = nameStr.charAt(i);
if(Character.isLowerCase(c))//1
{ 
sug.append(c);
} 
else
if(Character.isUpperCase(c))//1
{ 
sug.append(Character.toLowerCase(c));
} 
} 
} 
if(sug.toString().equals(""))//1
{ 
return "packageName";
} 
return sug.toString();
} 
public Icon getClarifier()
    { 
return ClClassName.getTheInstance();
} 

 } 
