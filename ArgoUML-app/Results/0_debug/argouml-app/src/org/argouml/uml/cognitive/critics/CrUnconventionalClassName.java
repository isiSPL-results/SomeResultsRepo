
//#if -1941930441 
// Compilation Unit of /CrUnconventionalClassName.java 
 

//#if 1277257280 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -855975463 
import java.util.HashSet;
//#endif 


//#if 1816425643 
import java.util.Set;
//#endif 


//#if -967494552 
import javax.swing.Icon;
//#endif 


//#if 1549915172 
import org.argouml.cognitive.Critic;
//#endif 


//#if 389349709 
import org.argouml.cognitive.Designer;
//#endif 


//#if -1130635937 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if -99020642 
import org.argouml.cognitive.critics.Wizard;
//#endif 


//#if -992661626 
import org.argouml.model.Model;
//#endif 


//#if -1490062200 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -2029264451 
public class CrUnconventionalClassName extends 
//#if 991901283 
AbstractCrUnconventionalName
//#endif 

  { 

//#if 285415933 
private static final long serialVersionUID = -3341858698991522822L;
//#endif 


//#if 1314846483 
@Override
    public void initWizard(Wizard w)
    { 

//#if 21154548 
if(w instanceof WizMEName)//1
{ 

//#if 1889917120 
ToDoItem item = (ToDoItem) w.getToDoItem();
//#endif 


//#if -412910953 
Object me = item.getOffenders().get(0);
//#endif 


//#if -300769193 
String sug = Model.getFacade().getName(me);
//#endif 


//#if 1889897271 
sug = computeSuggestion(sug);
//#endif 


//#if 1224303725 
String ins = super.getInstructions();
//#endif 


//#if 878952892 
((WizMEName) w).setInstructions(ins);
//#endif 


//#if -147547342 
((WizMEName) w).setSuggestion(sug);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1689425535 
@Override
    public Class getWizardClass(ToDoItem item)
    { 

//#if -1947631179 
return WizMEName.class;
//#endif 

} 

//#endif 


//#if -1566497761 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if 1068377443 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if -662368232 
ret.add(Model.getMetaTypes().getUMLClass());
//#endif 


//#if -459347157 
return ret;
//#endif 

} 

//#endif 


//#if -556305400 
@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if -1598419788 
if(!(Model.getFacade().isAClass(dm))
                && !(Model.getFacade().isAInterface(dm)))//1
{ 

//#if 1096295909 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 620871253 
Object cls = /*(MClassifier)*/ dm;
//#endif 


//#if 1028113820 
String myName = Model.getFacade().getName(cls);
//#endif 


//#if 617415540 
if(myName == null || myName.equals(""))//1
{ 

//#if 660314342 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 824951550 
String nameStr = myName;
//#endif 


//#if 277106057 
if(nameStr == null || nameStr.length() == 0)//1
{ 

//#if -2077792452 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -46984830 
char initialChar = nameStr.charAt(0);
//#endif 


//#if -955369769 
if(Character.isDigit(initialChar)
                || !Character.isUpperCase(initialChar))//1
{ 

//#if 848990737 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if 1964643308 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1363242674 
public String computeSuggestion(String sug)
    { 

//#if -1246246976 
if(sug == null)//1
{ 

//#if 372809257 
return "";
//#endif 

} 

//#endif 


//#if -943178406 
StringBuffer sb = new StringBuffer(sug);
//#endif 


//#if 1224115332 
while (sb.length() > 0 && Character.isDigit(sb.charAt(0))) //1
{ 

//#if 1144980421 
sb.deleteCharAt(0);
//#endif 

} 

//#endif 


//#if 386900774 
if(sb.length() == 0)//1
{ 

//#if -1167791327 
return "";
//#endif 

} 

//#endif 


//#if -1887518074 
return sb.replace(0, 1,
                          Character.toString(Character.toUpperCase(sb.charAt(0))))
               .toString();
//#endif 

} 

//#endif 


//#if -1762583194 
@Override
    public Icon getClarifier()
    { 

//#if 336598081 
return ClClassName.getTheInstance();
//#endif 

} 

//#endif 


//#if 78224005 
public CrUnconventionalClassName()
    { 

//#if 893693232 
setupHeadAndDesc();
//#endif 


//#if -2092166600 
addSupportedDecision(UMLDecision.NAMING);
//#endif 


//#if -1903283301 
setKnowledgeTypes(Critic.KT_SYNTAX);
//#endif 


//#if 1670920761 
addTrigger("name");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

