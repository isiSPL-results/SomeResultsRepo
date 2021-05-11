
//#if 1368969030 
// Compilation Unit of /CrUnconventionalAttrName.java 
 

//#if -899205640 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -259275999 
import java.util.HashSet;
//#endif 


//#if -418561549 
import java.util.Set;
//#endif 


//#if 1407058464 
import javax.swing.Icon;
//#endif 


//#if 944491996 
import org.argouml.cognitive.Critic;
//#endif 


//#if -1601737467 
import org.argouml.cognitive.Designer;
//#endif 


//#if -1392054046 
import org.argouml.cognitive.ListSet;
//#endif 


//#if 1173244183 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if -30813610 
import org.argouml.cognitive.critics.Wizard;
//#endif 


//#if 1762919118 
import org.argouml.model.Model;
//#endif 


//#if 624355792 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 408584371 
import org.argouml.uml.cognitive.UMLToDoItem;
//#endif 


//#if -2056421126 
public class CrUnconventionalAttrName extends 
//#if -613313601 
AbstractCrUnconventionalName
//#endif 

  { 

//#if 59322321 
private static final long serialVersionUID = 4741909365018862474L;
//#endif 


//#if -1239895741 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if -1661158198 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if 1322284039 
ret.add(Model.getMetaTypes().getAttribute());
//#endif 


//#if 567047506 
return ret;
//#endif 

} 

//#endif 


//#if 1151620069 
public boolean stillValid(ToDoItem i, Designer dsgr)
    { 

//#if -76140538 
if(!isActive())//1
{ 

//#if 263731402 
return false;
//#endif 

} 

//#endif 


//#if 1902025477 
ListSet offs = i.getOffenders();
//#endif 


//#if 1032692691 
Object f = offs.get(0);
//#endif 


//#if 733470259 
if(!predicate(f, dsgr))//1
{ 

//#if -1500364572 
return false;
//#endif 

} 

//#endif 


//#if -408707015 
ListSet newOffs = computeOffenders(f);
//#endif 


//#if -1740462487 
boolean res = offs.equals(newOffs);
//#endif 


//#if 1229085858 
return res;
//#endif 

} 

//#endif 


//#if 1019400570 
public Icon getClarifier()
    { 

//#if 1429047936 
return ClAttributeCompartment.getTheInstance();
//#endif 

} 

//#endif 


//#if -1920327396 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if -1126737075 
if(!Model.getFacade().isAAttribute(dm))//1
{ 

//#if 1832012166 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -424048669 
Object attr = /*(MAttribute)*/ dm;
//#endif 


//#if 1776825796 
String nameStr = Model.getFacade().getName(attr);
//#endif 


//#if -584923614 
if(nameStr == null || nameStr.equals(""))//1
{ 

//#if 591124731 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1371351443 
int pos = 0;
//#endif 


//#if 1012882644 
int length = nameStr.length();
//#endif 


//#if 217465662 
for (; pos < length && nameStr.charAt(pos) == '_'; pos++) //1
{ 
} 

//#endif 


//#if 1863284230 
if(pos >= length)//1
{ 

//#if -316079436 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if 46271445 
char initalChar = nameStr.charAt(pos);
//#endif 


//#if 1195033668 
boolean allCapitals = true;
//#endif 


//#if 1253250683 
for (; pos < length; pos++) //1
{ 

//#if 433662050 
if(!Character.isUpperCase(nameStr.charAt(pos))
                    && nameStr.charAt(pos) != '_')//1
{ 

//#if 1658254921 
allCapitals = false;
//#endif 


//#if -492840516 
break;

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1572108185 
if(allCapitals)//1
{ 

//#if -458371595 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1548298241 
if(Model.getFacade().isReadOnly(attr))//1
{ 

//#if 353116605 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1874361484 
if(!Character.isLowerCase(initalChar))//1
{ 

//#if 440701554 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if -1737269286 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -603560136 
public CrUnconventionalAttrName()
    { 

//#if -1320137260 
setupHeadAndDesc();
//#endif 


//#if 480632796 
addSupportedDecision(UMLDecision.NAMING);
//#endif 


//#if 1688956791 
setKnowledgeTypes(Critic.KT_SYNTAX);
//#endif 


//#if 94433940 
addTrigger("feature_name");
//#endif 

} 

//#endif 


//#if -154697507 
@Override
    public Class getWizardClass(ToDoItem item)
    { 

//#if -333469020 
return WizMEName.class;
//#endif 

} 

//#endif 


//#if -609918568 
public String computeSuggestion(String name)
    { 

//#if -1209408179 
String sug;
//#endif 


//#if -595928309 
int nu;
//#endif 


//#if -1149787745 
if(name == null)//1
{ 

//#if -251243928 
return "attr";
//#endif 

} 

//#endif 


//#if 746340249 
for (nu = 0; nu < name.length(); nu++) //1
{ 

//#if 411881002 
if(name.charAt(nu) != '_')//1
{ 

//#if -1833872776 
break;

//#endif 

} 

//#endif 

} 

//#endif 


//#if 152379942 
if(nu > 0)//1
{ 

//#if -754845808 
sug = name.substring(0, nu);
//#endif 

} 
else
{ 

//#if -1404004563 
sug = "";
//#endif 

} 

//#endif 


//#if 1184611874 
if(nu < name.length())//1
{ 

//#if -733008938 
sug += Character.toLowerCase(name.charAt(nu));
//#endif 

} 

//#endif 


//#if 279784200 
if(nu + 1 < name.length())//1
{ 

//#if -108589278 
sug += name.substring(nu + 1);
//#endif 

} 

//#endif 


//#if -292602164 
return sug;
//#endif 

} 

//#endif 


//#if -308367489 
public void initWizard(Wizard w)
    { 

//#if -107708859 
if(w instanceof WizMEName)//1
{ 

//#if -1228832107 
ToDoItem item = (ToDoItem) w.getToDoItem();
//#endif 


//#if 1143154914 
Object me = item.getOffenders().get(0);
//#endif 


//#if -2089933986 
String sug = computeSuggestion(Model.getFacade().getName(me));
//#endif 


//#if 1775643000 
String ins = super.getInstructions();
//#endif 


//#if -1859948537 
((WizMEName) w).setInstructions(ins);
//#endif 


//#if 403791933 
((WizMEName) w).setSuggestion(sug);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1954731840 
protected ListSet computeOffenders(Object dm)
    { 

//#if 606025517 
ListSet offs = new ListSet(dm);
//#endif 


//#if -1483198819 
offs.add(Model.getFacade().getOwner(dm));
//#endif 


//#if 1967315210 
return offs;
//#endif 

} 

//#endif 


//#if 1800838879 
public ToDoItem toDoItem(Object dm, Designer dsgr)
    { 

//#if 1119209630 
Object f = dm;
//#endif 


//#if -1239888794 
ListSet offs = computeOffenders(f);
//#endif 


//#if 498483763 
return new UMLToDoItem(this, offs, dsgr);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

