// Compilation Unit of /CrMissingClassName.java 
 
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
public class CrMissingClassName extends CrUML
  { 
public CrMissingClassName()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.NAMING);
setKnowledgeTypes(Critic.KT_COMPLETENESS, Critic.KT_SYNTAX);
addTrigger("name");
} 

public Icon getClarifier()
    { 
return ClClassName.getTheInstance();
} 

public Set<Object> getCriticizedDesignMaterials()
    { 
Set<Object> ret = new HashSet<Object>();
ret.add(Model.getMetaTypes().getUMLClass());
return ret;
} 

public Class getWizardClass(ToDoItem item)
    { 
return WizMEName.class;
} 

public boolean predicate2(Object dm, Designer dsgr)
    { 
if(!(Model.getFacade().isAModelElement(dm)))//1
{ 
return NO_PROBLEM;
} 

Object e = dm;
String myName = Model.getFacade().getName(e);
if(myName == null || myName.equals("") || myName.length() == 0)//1
{ 
return PROBLEM_FOUND;
} 

return NO_PROBLEM;
} 

public void initWizard(Wizard w)
    { 
if(w instanceof WizMEName)//1
{ 
ToDoItem item = (ToDoItem) w.getToDoItem();
Object me = item.getOffenders().get(0);
String ins = super.getInstructions();
String sug = super.getDefaultSuggestion();
int count = 1;
if(Model.getFacade().getNamespace(me) != null)//1
{ 
count =
                    Model.getFacade().getOwnedElements(
                        Model.getFacade().getNamespace(me)).size();
} 

sug = Model.getFacade().getUMLClassName(me) + (count + 1);
((WizMEName) w).setInstructions(ins);
((WizMEName) w).setSuggestion(sug);
} 

} 

 } 


