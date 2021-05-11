// Compilation Unit of /CrMissingStateName.java 
 
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
public class CrMissingStateName extends CrUML
  { 
private static final long serialVersionUID = 1181623952639408440L;
@Override
    public Icon getClarifier()
    { 
return ClClassName.getTheInstance();
} 

@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 
if(!Model.getFacade().isAStateVertex(dm))//1
{ 
return NO_PROBLEM;
} 

if(Model.getFacade().isACompositeState(dm)
                && Model.getFacade().isTop(dm))//1
{ 
return NO_PROBLEM;
} 

if(Model.getFacade().isAFinalState(dm))//1
{ 
return NO_PROBLEM;
} 

if(Model.getFacade().isAPseudostate(dm))//1
{ 
return NO_PROBLEM;
} 

if(Model.getFacade().isAActionState(dm))//1
{ 
return NO_PROBLEM;
} 

if(Model.getFacade().isAObjectFlowState(dm))//1
{ 
return NO_PROBLEM;
} 

String myName = Model.getFacade().getName(dm);
if(myName == null || myName.equals("") || myName.length() == 0)//1
{ 
return PROBLEM_FOUND;
} 

return NO_PROBLEM;
} 

public Set<Object> getCriticizedDesignMaterials()
    { 
Set<Object> ret = new HashSet<Object>();
ret.add(Model.getMetaTypes().getStateVertex());
return ret;
} 

public CrMissingStateName()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.NAMING);
setKnowledgeTypes(Critic.KT_COMPLETENESS, Critic.KT_SYNTAX);
addTrigger("name");
} 

@Override
    public void initWizard(Wizard w)
    { 
if(w instanceof WizMEName)//1
{ 
ToDoItem item = (ToDoItem) w.getToDoItem();
Object me = item.getOffenders().get(0);
String ins = super.getInstructions();
String sug = super.getDefaultSuggestion();
if(Model.getFacade().isAStateVertex(me))//1
{ 
Object sv = me;
int count = 1;
if(Model.getFacade().getContainer(sv) != null)//1
{ 
count =
                        Model.getFacade().getSubvertices(
                            Model.getFacade().getContainer(sv)).size();
} 

sug = "S" + (count + 1);
} 

((WizMEName) w).setInstructions(ins);
((WizMEName) w).setSuggestion(sug);
} 

} 

@Override
    public Class getWizardClass(ToDoItem item)
    { 
return WizMEName.class;
} 

 } 


