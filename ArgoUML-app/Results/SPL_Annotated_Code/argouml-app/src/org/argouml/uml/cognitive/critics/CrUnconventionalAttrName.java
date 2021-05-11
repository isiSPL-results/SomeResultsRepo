// Compilation Unit of /CrUnconventionalAttrName.java 
 
package org.argouml.uml.cognitive.critics;
import java.util.HashSet;
import java.util.Set;
import javax.swing.Icon;
import org.argouml.cognitive.Critic;
import org.argouml.cognitive.Designer;
import org.argouml.cognitive.ListSet;
import org.argouml.cognitive.ToDoItem;
import org.argouml.cognitive.critics.Wizard;
import org.argouml.model.Model;
import org.argouml.uml.cognitive.UMLDecision;
import org.argouml.uml.cognitive.UMLToDoItem;
public class CrUnconventionalAttrName extends AbstractCrUnconventionalName
  { 
private static final long serialVersionUID = 4741909365018862474L;
public Set<Object> getCriticizedDesignMaterials()
    { 
Set<Object> ret = new HashSet<Object>();
ret.add(Model.getMetaTypes().getAttribute());
return ret;
} 

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

public Icon getClarifier()
    { 
return ClAttributeCompartment.getTheInstance();
} 

public boolean predicate2(Object dm, Designer dsgr)
    { 
if(!Model.getFacade().isAAttribute(dm))//1
{ 
return NO_PROBLEM;
} 

Object attr = /*(MAttribute)*/ dm;
String nameStr = Model.getFacade().getName(attr);
if(nameStr == null || nameStr.equals(""))//1
{ 
return NO_PROBLEM;
} 

int pos = 0;
int length = nameStr.length();
for (; pos < length && nameStr.charAt(pos) == '_'; pos++) //1
{ 
} 

if(pos >= length)//1
{ 
return PROBLEM_FOUND;
} 

char initalChar = nameStr.charAt(pos);
boolean allCapitals = true;
for (; pos < length; pos++) //1
{ 
if(!Character.isUpperCase(nameStr.charAt(pos))
                    && nameStr.charAt(pos) != '_')//1
{ 
allCapitals = false;
break;

} 

} 

if(allCapitals)//1
{ 
return NO_PROBLEM;
} 

if(Model.getFacade().isReadOnly(attr))//1
{ 
return NO_PROBLEM;
} 

if(!Character.isLowerCase(initalChar))//1
{ 
return PROBLEM_FOUND;
} 

return NO_PROBLEM;
} 

public CrUnconventionalAttrName()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.NAMING);
setKnowledgeTypes(Critic.KT_SYNTAX);
addTrigger("feature_name");
} 

@Override
    public Class getWizardClass(ToDoItem item)
    { 
return WizMEName.class;
} 

public String computeSuggestion(String name)
    { 
String sug;
int nu;
if(name == null)//1
{ 
return "attr";
} 

for (nu = 0; nu < name.length(); nu++) //1
{ 
if(name.charAt(nu) != '_')//1
{ 
break;

} 

} 

if(nu > 0)//1
{ 
sug = name.substring(0, nu);
} 
else
{ 
sug = "";
} 

if(nu < name.length())//1
{ 
sug += Character.toLowerCase(name.charAt(nu));
} 

if(nu + 1 < name.length())//1
{ 
sug += name.substring(nu + 1);
} 

return sug;
} 

public void initWizard(Wizard w)
    { 
if(w instanceof WizMEName)//1
{ 
ToDoItem item = (ToDoItem) w.getToDoItem();
Object me = item.getOffenders().get(0);
String sug = computeSuggestion(Model.getFacade().getName(me));
String ins = super.getInstructions();
((WizMEName) w).setInstructions(ins);
((WizMEName) w).setSuggestion(sug);
} 

} 

protected ListSet computeOffenders(Object dm)
    { 
ListSet offs = new ListSet(dm);
offs.add(Model.getFacade().getOwner(dm));
return offs;
} 

public ToDoItem toDoItem(Object dm, Designer dsgr)
    { 
Object f = dm;
ListSet offs = computeOffenders(f);
return new UMLToDoItem(this, offs, dsgr);
} 

 } 


