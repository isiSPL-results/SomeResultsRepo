// Compilation Unit of /CrNoOperations.java 
 
package org.argouml.uml.cognitive.critics;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.swing.Icon;
import org.argouml.cognitive.Critic;
import org.argouml.cognitive.Designer;
import org.argouml.cognitive.ToDoItem;
import org.argouml.cognitive.critics.Wizard;
import org.argouml.model.Model;
import org.argouml.uml.cognitive.UMLDecision;
public class CrNoOperations extends CrUML
  { 
private boolean findInstanceOperationInInherited(Object dm, int depth)
    { 
Iterator ops = Model.getFacade().getOperations(dm).iterator();
while (ops.hasNext()) //1
{ 
if(!Model.getFacade().isStatic(ops.next()))//1
{ 
return true;
} 

} 

if(depth > 50)//1
{ 
return false;
} 

Iterator iter = Model.getFacade().getGeneralizations(dm).iterator();
while (iter.hasNext()) //1
{ 
Object parent = Model.getFacade().getGeneral(iter.next());
if(parent == dm)//1
{ 
continue;
} 

if(Model.getFacade().isAClassifier(parent)
                    && findInstanceOperationInInherited(parent, depth + 1))//1
{ 
return true;
} 

} 

return false;
} 

public CrNoOperations()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.BEHAVIOR);
setKnowledgeTypes(Critic.KT_COMPLETENESS);
addTrigger("behavioralFeature");
} 

@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 
if(!(Model.getFacade().isAClass(dm)
                || Model.getFacade().isAInterface(dm)))//1
{ 
return NO_PROBLEM;
} 

if(!(Model.getFacade().isPrimaryObject(dm)))//1
{ 
return NO_PROBLEM;
} 

if((Model.getFacade().getName(dm) == null)
                || ("".equals(Model.getFacade().getName(dm))))//1
{ 
return NO_PROBLEM;
} 

if(Model.getFacade().isType(dm))//1
{ 
return NO_PROBLEM;
} 

if(Model.getFacade().isUtility(dm))//1
{ 
return NO_PROBLEM;
} 

if(findInstanceOperationInInherited(dm, 0))//1
{ 
return NO_PROBLEM;
} 

return PROBLEM_FOUND;
} 

public Set<Object> getCriticizedDesignMaterials()
    { 
Set<Object> ret = new HashSet<Object>();
ret.add(Model.getMetaTypes().getUMLClass());
ret.add(Model.getMetaTypes().getInterface());
return ret;
} 

@Override
    public void initWizard(Wizard w)
    { 
if(w instanceof WizAddOperation)//1
{ 
String ins = super.getInstructions();
String sug = super.getDefaultSuggestion();
((WizAddOperation) w).setInstructions(ins);
((WizAddOperation) w).setSuggestion(sug);
} 

} 

@Override
    public Icon getClarifier()
    { 
return ClOperationCompartment.getTheInstance();
} 

@Override
    public Class getWizardClass(ToDoItem item)
    { 
return WizAddOperation.class;
} 

 } 


