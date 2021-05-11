package org.argouml.uml.cognitive.critics;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.Icon;
import org.argouml.cognitive.Critic;
import org.argouml.cognitive.Designer;
import org.argouml.cognitive.ToDoItem;
import org.argouml.cognitive.critics.Wizard;
import org.argouml.model.Model;
import org.argouml.uml.cognitive.UMLDecision;
public class CrDisambigClassName extends CrUML
  { 
public boolean predicate2(Object dm, Designer dsgr)
    { 
if(!(Model.getFacade().isAClassifier(dm)))//1
{ 
return NO_PROBLEM;
} 
Object classifier = dm;
String designMaterialName = Model.getFacade().getName(classifier);
if(designMaterialName != null && designMaterialName.length() == 0)//1
{ 
return NO_PROBLEM;
} 
Collection elementImports =
            Model.getFacade().getElementImports2(classifier);
if(elementImports == null)//1
{ 
return NO_PROBLEM;
} 
for (Iterator iter = elementImports.iterator(); iter.hasNext();) //1
{ 
Object imp = iter.next();
Object pack = Model.getFacade().getPackage(imp);
String alias = Model.getFacade().getAlias(imp);
if(alias == null || alias.length() == 0)//1
{ 
alias = designMaterialName;
} 
Collection siblings = Model.getFacade().getOwnedElements(pack);
if(siblings == null)//1
{ 
return NO_PROBLEM;
} 
Iterator elems = siblings.iterator();
while (elems.hasNext()) //1
{ 
Object eo = elems.next();
Object me = /*Model.getFacade().getModelElement(*/eo/*)*/;
if(!(Model.getFacade().isAClassifier(me)))//1
{ 
continue;
} 
if(me == classifier)//1
{ 
continue;
} 
String meName = Model.getFacade().getName(me);
if(meName == null || meName.equals(""))//1
{ 
continue;
} 
if(meName.equals(alias))//1
{ 
return PROBLEM_FOUND;
} 
} 
} 
return NO_PROBLEM;
} 
public void initWizard(Wizard w)
    { 
if(w instanceof WizMEName)//1
{ 
ToDoItem item = (ToDoItem) w.getToDoItem();
Object me = item.getOffenders().get(0);
String sug = Model.getFacade().getName(me);
String ins = super.getInstructions();
((WizMEName) w).setInstructions(ins);
((WizMEName) w).setSuggestion(sug);
((WizMEName) w).setMustEdit(true);
} 
} 
public CrDisambigClassName()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.NAMING);
setKnowledgeTypes(Critic.KT_SYNTAX);
addTrigger("name");
addTrigger("elementOwnership");
} 
public Icon getClarifier()
    { 
return ClClassName.getTheInstance();
} 
public Class getWizardClass(ToDoItem item)
    { 
return WizMEName.class;
} 

 } 
