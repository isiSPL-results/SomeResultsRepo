
//#if 910060864 
// Compilation Unit of /CrUnconventionalPackName.java 
 

//#if 243635369 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 1136166992 
import java.util.HashSet;
//#endif 


//#if 1779562146 
import java.util.Set;
//#endif 


//#if 343694097 
import javax.swing.Icon;
//#endif 


//#if -1887484595 
import org.argouml.cognitive.Critic;
//#endif 


//#if -121975754 
import org.argouml.cognitive.Designer;
//#endif 


//#if -1641961400 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if -1272231737 
import org.argouml.cognitive.critics.Wizard;
//#endif 


//#if -1927419715 
import org.argouml.model.Model;
//#endif 


//#if 795099519 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -396940141 
public class CrUnconventionalPackName extends 
//#if -2088413267 
AbstractCrUnconventionalName
//#endif 

  { 

//#if 1416332253 
@Override
    public void initWizard(Wizard w)
    { 

//#if -309941841 
if(w instanceof WizMEName)//1
{ 

//#if -1783699088 
ToDoItem item = (ToDoItem) w.getToDoItem();
//#endif 


//#if 754165735 
Object me = item.getOffenders().get(0);
//#endif 


//#if -128670275 
String ins = super.getInstructions();
//#endif 


//#if -1270850010 
String nameStr = Model.getFacade().getName(me);
//#endif 


//#if 119168759 
String sug = computeSuggestion(nameStr);
//#endif 


//#if 2046029580 
((WizMEName) w).setInstructions(ins);
//#endif 


//#if -1500521342 
((WizMEName) w).setSuggestion(sug);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 277873099 
@Override
    public Class getWizardClass(ToDoItem item)
    { 

//#if -405626320 
return WizMEName.class;
//#endif 

} 

//#endif 


//#if 43273806 
public CrUnconventionalPackName()
    { 

//#if -984143525 
setupHeadAndDesc();
//#endif 


//#if 1450069027 
addSupportedDecision(UMLDecision.NAMING);
//#endif 


//#if -1832635696 
setKnowledgeTypes(Critic.KT_SYNTAX);
//#endif 


//#if -206915996 
addTrigger("name");
//#endif 

} 

//#endif 


//#if 353424510 
@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 251819499 
if(!(Model.getFacade().isAPackage(dm)))//1
{ 

//#if 117201263 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 439768356 
String myName = Model.getFacade().getName(dm);
//#endif 


//#if 1850567275 
if(myName == null || myName.equals(""))//1
{ 

//#if 818246923 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -511536345 
String nameStr = myName;
//#endif 


//#if -2049806542 
if(nameStr == null || nameStr.length() == 0)//1
{ 

//#if 313330783 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -864124246 
int size = nameStr.length();
//#endif 


//#if -562247516 
for (int i = 0; i < size; i++) //1
{ 

//#if -935654810 
char c = nameStr.charAt(i);
//#endif 


//#if 1874063164 
if(!Character.isLowerCase(c))//1
{ 

//#if -394306080 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1286168725 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1780131179 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if -2049582732 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if 174081735 
ret.add(Model.getMetaTypes().getPackage());
//#endif 


//#if 932385404 
return ret;
//#endif 

} 

//#endif 


//#if -154724265 
public String computeSuggestion(String nameStr)
    { 

//#if -280835392 
StringBuilder sug = new StringBuilder();
//#endif 


//#if -521786408 
if(nameStr != null)//1
{ 

//#if -1173148371 
int size = nameStr.length();
//#endif 


//#if -871271641 
for (int i = 0; i < size; i++) //1
{ 

//#if -786640577 
char c = nameStr.charAt(i);
//#endif 


//#if -1294269452 
if(Character.isLowerCase(c))//1
{ 

//#if 1395240242 
sug.append(c);
//#endif 

} 
else

//#if -289170855 
if(Character.isUpperCase(c))//1
{ 

//#if 1927801937 
sug.append(Character.toLowerCase(c));
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if -845020377 
if(sug.toString().equals(""))//1
{ 

//#if 885121095 
return "packageName";
//#endif 

} 

//#endif 


//#if 1614344995 
return sug.toString();
//#endif 

} 

//#endif 


//#if 1698806888 
public Icon getClarifier()
    { 

//#if -1832440651 
return ClClassName.getTheInstance();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

