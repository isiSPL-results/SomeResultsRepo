
//#if -1134357995 
// Compilation Unit of /CrUnconventionalOperName.java 
 

//#if -1080289985 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -1314443014 
import java.util.HashSet;
//#endif 


//#if 70485068 
import java.util.Set;
//#endif 


//#if 1901031011 
import org.argouml.cognitive.Critic;
//#endif 


//#if -1490745396 
import org.argouml.cognitive.Designer;
//#endif 


//#if -1804115653 
import org.argouml.cognitive.ListSet;
//#endif 


//#if 1284236254 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 2040789981 
import org.argouml.cognitive.critics.Wizard;
//#endif 


//#if -2007897625 
import org.argouml.model.Model;
//#endif 


//#if 419557673 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 203786252 
import org.argouml.uml.cognitive.UMLToDoItem;
//#endif 


//#if 2140141406 
public class CrUnconventionalOperName extends 
//#if 1045128984 
AbstractCrUnconventionalName
//#endif 

  { 

//#if -1804489639 
protected ListSet computeOffenders(Object dm)
    { 

//#if 1471393767 
ListSet offs = new ListSet(dm);
//#endif 


//#if 728095191 
offs.add(Model.getFacade().getOwner(dm));
//#endif 


//#if -45873724 
return offs;
//#endif 

} 

//#endif 


//#if -1050298194 
public CrUnconventionalOperName()
    { 

//#if -1974298049 
setupHeadAndDesc();
//#endif 


//#if 610417159 
addSupportedDecision(UMLDecision.NAMING);
//#endif 


//#if -402381204 
setKnowledgeTypes(Critic.KT_SYNTAX);
//#endif 


//#if 103916543 
addTrigger("feature_name");
//#endif 

} 

//#endif 


//#if 377626030 
@Override
    public boolean stillValid(ToDoItem i, Designer dsgr)
    { 

//#if -757396056 
if(!isActive())//1
{ 

//#if -859888041 
return false;
//#endif 

} 

//#endif 


//#if 229131299 
ListSet offs = i.getOffenders();
//#endif 


//#if -818831115 
Object f = offs.get(0);
//#endif 


//#if 470730321 
if(!predicate(f, dsgr))//1
{ 

//#if 1141719581 
return false;
//#endif 

} 

//#endif 


//#if -1723499817 
ListSet newOffs = computeOffenders(f);
//#endif 


//#if -130416501 
boolean res = offs.equals(newOffs);
//#endif 


//#if -1050149820 
return res;
//#endif 

} 

//#endif 


//#if -1248623286 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if -1970958086 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if 362160930 
ret.add(Model.getMetaTypes().getOperation());
//#endif 


//#if -136436350 
return ret;
//#endif 

} 

//#endif 


//#if 1908509064 
@Override
    public void initWizard(Wizard w)
    { 

//#if 1106761523 
if(w instanceof WizOperName)//1
{ 

//#if 1031364922 
ToDoItem item = (ToDoItem) w.getToDoItem();
//#endif 


//#if -709929891 
Object me = item.getOffenders().get(0);
//#endif 


//#if -1146083555 
String sug = Model.getFacade().getName(me);
//#endif 


//#if -1208583503 
sug = computeSuggestion(sug);
//#endif 


//#if 740639136 
boolean cand = candidateForConstructor(me);
//#endif 


//#if 1299857407 
String ins;
//#endif 


//#if -499392602 
if(cand)//1
{ 

//#if -462740021 
ins = super.getLocalizedString("-ins-ext");
//#endif 

} 
else
{ 

//#if -1362700217 
ins = super.getInstructions();
//#endif 

} 

//#endif 


//#if 586586156 
((WizOperName) w).setInstructions(ins);
//#endif 


//#if 1550470562 
((WizOperName) w).setSuggestion(sug);
//#endif 


//#if -1380408364 
((WizOperName) w).setPossibleConstructor(cand);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1252558285 
@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if -2014563371 
if(!(Model.getFacade().isAOperation(dm)))//1
{ 

//#if 1969479944 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1676791102 
Object oper = dm;
//#endif 


//#if -1252701986 
String myName = Model.getFacade().getName(oper);
//#endif 


//#if 684095126 
if(myName == null || myName.equals(""))//1
{ 

//#if 914662118 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1570283620 
String nameStr = myName;
//#endif 


//#if -1841205465 
if(nameStr == null || nameStr.length() == 0)//1
{ 

//#if 1110855030 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 973621793 
char initalChar = nameStr.charAt(0);
//#endif 


//#if -1168093236 
for (Object stereo : Model.getFacade().getStereotypes(oper)) //1
{ 

//#if 1718117372 
if("create".equals(Model.getFacade().getName(stereo))
                    || "constructor".equals(
                        Model.getFacade().getName(stereo)))//1
{ 

//#if 610010505 
return NO_PROBLEM;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 506774308 
if(!Character.isLowerCase(initalChar))//1
{ 

//#if -1061061826 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if -1402425462 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -394377496 
@Override
    public ToDoItem toDoItem(Object dm, Designer dsgr)
    { 

//#if 951171895 
Object f = dm;
//#endif 


//#if -1420516499 
ListSet offs = computeOffenders(f);
//#endif 


//#if 591050636 
return new UMLToDoItem(this, offs, dsgr);
//#endif 

} 

//#endif 


//#if -425251402 
@Override
    public Class getWizardClass(ToDoItem item)
    { 

//#if 849986693 
return WizOperName.class;
//#endif 

} 

//#endif 


//#if 258230813 
protected boolean candidateForConstructor(Object me)
    { 

//#if 824366587 
if(!(Model.getFacade().isAOperation(me)))//1
{ 

//#if 1250208419 
return false;
//#endif 

} 

//#endif 


//#if -1155817942 
Object oper = me;
//#endif 


//#if 999582567 
String myName = Model.getFacade().getName(oper);
//#endif 


//#if 529738797 
if(myName == null || myName.equals(""))//1
{ 

//#if -328226930 
return false;
//#endif 

} 

//#endif 


//#if -1560688405 
Object cl = Model.getFacade().getOwner(oper);
//#endif 


//#if -1194156315 
String nameCl = Model.getFacade().getName(cl);
//#endif 


//#if -28376141 
if(nameCl == null || nameCl.equals(""))//1
{ 

//#if -454219693 
return false;
//#endif 

} 

//#endif 


//#if -1558778857 
if(myName.equals(nameCl))//1
{ 

//#if -658761699 
return true;
//#endif 

} 

//#endif 


//#if 1278866591 
return false;
//#endif 

} 

//#endif 


//#if -2084152701 
public String computeSuggestion(String sug)
    { 

//#if -1581848476 
if(sug == null)//1
{ 

//#if 543932125 
return "";
//#endif 

} 

//#endif 


//#if 1439942912 
return sug.substring(0, 1).toLowerCase() + sug.substring(1);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

