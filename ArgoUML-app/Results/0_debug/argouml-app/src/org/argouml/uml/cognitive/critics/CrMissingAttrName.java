
//#if 261292049 
// Compilation Unit of /CrMissingAttrName.java 
 

//#if 973932854 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -1236413405 
import java.util.HashSet;
//#endif 


//#if -1628167179 
import java.util.Set;
//#endif 


//#if 821348574 
import javax.swing.Icon;
//#endif 


//#if -2136447078 
import org.argouml.cognitive.Critic;
//#endif 


//#if 1143246659 
import org.argouml.cognitive.Designer;
//#endif 


//#if -376738987 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 463982100 
import org.argouml.cognitive.critics.Wizard;
//#endif 


//#if 152160848 
import org.argouml.model.Model;
//#endif 


//#if -1216846382 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 1712881275 
public class CrMissingAttrName extends 
//#if 1248126015 
CrUML
//#endif 

  { 

//#if 1479642919 
public void initWizard(Wizard w)
    { 

//#if -95221974 
if(w instanceof WizMEName)//1
{ 

//#if -1375257103 
ToDoItem item = (ToDoItem) w.getToDoItem();
//#endif 


//#if -1575318778 
Object me = item.getOffenders().get(0);
//#endif 


//#if -37239652 
String ins = super.getInstructions();
//#endif 


//#if -506560123 
String sug = super.getDefaultSuggestion();
//#endif 


//#if 1805185785 
if(Model.getFacade().isAAttribute(me))//1
{ 

//#if -163852758 
Object a = me;
//#endif 


//#if 18896553 
int count = 1;
//#endif 


//#if -1000386193 
if(Model.getFacade().getOwner(a) != null)//1

//#if -1414306930 
count = Model.getFacade().getFeatures(
                                Model.getFacade().getOwner(a)).size();
//#endif 


//#endif 


//#if -1068840699 
sug = "attr" + (count + 1);
//#endif 

} 

//#endif 


//#if -283454933 
((WizMEName) w).setInstructions(ins);
//#endif 


//#if -1409090719 
((WizMEName) w).setSuggestion(sug);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1594046254 
public Icon getClarifier()
    { 

//#if -1673505248 
return ClAttributeCompartment.getTheInstance();
//#endif 

} 

//#endif 


//#if 1827505780 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if -547579618 
if(!(Model.getFacade().isAAttribute(dm)))//1
{ 

//#if 595768184 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 650986563 
Object attr = dm;
//#endif 


//#if -1584575325 
String myName = Model.getFacade().getName(attr);
//#endif 


//#if 77897908 
if(myName == null
                || "".equals(myName))//1
{ 

//#if 1191992193 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if 72729319 
if(myName.length() == 0)//1
{ 

//#if 681847291 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if 1620583276 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1923086485 
public Class getWizardClass(ToDoItem item)
    { 

//#if -1687562221 
return WizMEName.class;
//#endif 

} 

//#endif 


//#if 678383557 
public CrMissingAttrName()
    { 

//#if 758862569 
setupHeadAndDesc();
//#endif 


//#if 341882673 
addSupportedDecision(UMLDecision.NAMING);
//#endif 


//#if -712861950 
setKnowledgeTypes(Critic.KT_SYNTAX);
//#endif 


//#if 1536090098 
addTrigger("name");
//#endif 

} 

//#endif 


//#if -1021184277 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if 1069266147 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if -493582322 
ret.add(Model.getMetaTypes().getAttribute());
//#endif 


//#if 1690360491 
return ret;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

