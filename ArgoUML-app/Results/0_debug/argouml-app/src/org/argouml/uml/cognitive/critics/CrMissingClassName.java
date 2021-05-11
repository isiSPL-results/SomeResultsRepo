
//#if 2108235401 
// Compilation Unit of /CrMissingClassName.java 
 

//#if -1015596251 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 550939220 
import java.util.HashSet;
//#endif 


//#if 142195366 
import java.util.Set;
//#endif 


//#if -506468211 
import javax.swing.Icon;
//#endif 


//#if -1436649271 
import org.argouml.cognitive.Critic;
//#endif 


//#if -660926286 
import org.argouml.cognitive.Designer;
//#endif 


//#if 2114055364 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if -213041085 
import org.argouml.cognitive.critics.Wizard;
//#endif 


//#if 53704641 
import org.argouml.model.Model;
//#endif 


//#if -729728637 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -935316973 
public class CrMissingClassName extends 
//#if -1117197862 
CrUML
//#endif 

  { 

//#if -1089177343 
public CrMissingClassName()
    { 

//#if -1585298663 
setupHeadAndDesc();
//#endif 


//#if -652188831 
addSupportedDecision(UMLDecision.NAMING);
//#endif 


//#if -2141985008 
setKnowledgeTypes(Critic.KT_COMPLETENESS, Critic.KT_SYNTAX);
//#endif 


//#if -808071134 
addTrigger("name");
//#endif 

} 

//#endif 


//#if 262500183 
public Icon getClarifier()
    { 

//#if -1188003938 
return ClClassName.getTheInstance();
//#endif 

} 

//#endif 


//#if 1189989062 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if -734811624 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if 900272077 
ret.add(Model.getMetaTypes().getUMLClass());
//#endif 


//#if 2083678240 
return ret;
//#endif 

} 

//#endif 


//#if -1516316816 
public Class getWizardClass(ToDoItem item)
    { 

//#if 37783583 
return WizMEName.class;
//#endif 

} 

//#endif 


//#if -1564849351 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if -1168326902 
if(!(Model.getFacade().isAModelElement(dm)))//1
{ 

//#if -683822639 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -369658494 
Object e = dm;
//#endif 


//#if 1223831442 
String myName = Model.getFacade().getName(e);
//#endif 


//#if 709375777 
if(myName == null || myName.equals("") || myName.length() == 0)//1
{ 

//#if 53232378 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if -257918447 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -101370942 
public void initWizard(Wizard w)
    { 

//#if -1663893030 
if(w instanceof WizMEName)//1
{ 

//#if 857216258 
ToDoItem item = (ToDoItem) w.getToDoItem();
//#endif 


//#if 88765845 
Object me = item.getOffenders().get(0);
//#endif 


//#if -2118187285 
String ins = super.getInstructions();
//#endif 


//#if 1725913238 
String sug = super.getDefaultSuggestion();
//#endif 


//#if -1945014706 
int count = 1;
//#endif 


//#if 831278381 
if(Model.getFacade().getNamespace(me) != null)//1
{ 

//#if 785951408 
count =
                    Model.getFacade().getOwnedElements(
                        Model.getFacade().getNamespace(me)).size();
//#endif 

} 

//#endif 


//#if 1020297455 
sug = Model.getFacade().getUMLClassName(me) + (count + 1);
//#endif 


//#if 1380629690 
((WizMEName) w).setInstructions(ins);
//#endif 


//#if 804928944 
((WizMEName) w).setSuggestion(sug);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

