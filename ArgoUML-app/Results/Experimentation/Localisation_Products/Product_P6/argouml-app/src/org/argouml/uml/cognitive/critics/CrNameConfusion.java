package org.argouml.uml.cognitive.critics;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.swing.Icon;
import org.argouml.cognitive.Critic;
import org.argouml.cognitive.Designer;
import org.argouml.cognitive.ListSet;
import org.argouml.cognitive.ToDoItem;
import org.argouml.cognitive.critics.Wizard;
import org.argouml.model.Model;
import org.argouml.uml.cognitive.UMLDecision;
import org.argouml.uml.cognitive.UMLToDoItem;
public class CrNameConfusion extends CrUML
  { 
private static final long serialVersionUID = -6659510145586121263L;
public int countDiffs(String s1, String s2)
    { 
int len = Math.min(s1.length(), s2.length());
int count = Math.abs(s1.length() - s2.length());
if(count > 2)//1
{ 
return count;
} 
for (int i = 0; i < len; i++) //1
{ 
if(s1.charAt(i) != s2.charAt(i))//1
{ 
count++;
} 
} 
return count;
} 
public Set<Object> getCriticizedDesignMaterials()
    { 
Set<Object> ret = new HashSet<Object>();
ret.add(Model.getMetaTypes().getClassifier());
ret.add(Model.getMetaTypes().getState());
return ret;
} 
public boolean predicate2(Object dm, Designer dsgr)
    { 
if(!(Model.getFacade().isAModelElement(dm))
                || Model.getFacade().isAAssociation(dm))//1
{ 
return NO_PROBLEM;
} 
Object me = dm;
ListSet offs = computeOffenders(me);
if(offs.size() > 1)//1
{ 
return PROBLEM_FOUND;
} 
return NO_PROBLEM;
} 
public boolean confusable(String stripped1, String stripped2)
    { 
int countDiffs = countDiffs(stripped1, stripped2);
return countDiffs <= 1;
} 
@Override
    public void initWizard(Wizard w)
    { 
if(w instanceof WizManyNames)//1
{ 
ToDoItem item = (ToDoItem) w.getToDoItem();
((WizManyNames) w).setModelElements(item.getOffenders());
} 
} 
public CrNameConfusion()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.NAMING);
setKnowledgeTypes(Critic.KT_PRESENTATION);
setKnowledgeTypes(Critic.KT_SYNTAX);
addTrigger("name");
} 
public ListSet computeOffenders(Object dm)
    { 
Object ns = Model.getFacade().getNamespace(dm);
ListSet res = new ListSet(dm);
String n = Model.getFacade().getName(dm);
if(n == null || n.equals(""))//1
{ 
return res;
} 
String dmNameStr = n;
if(dmNameStr == null || dmNameStr.length() == 0)//1
{ 
return res;
} 
String stripped2 = strip(dmNameStr);
if(ns == null)//1
{ 
return res;
} 
Collection oes = Model.getFacade().getOwnedElements(ns);
if(oes == null)//1
{ 
return res;
} 
Iterator elems = oes.iterator();
while (elems.hasNext()) //1
{ 
Object me2 = elems.next();
if(me2 == dm || Model.getFacade().isAAssociation(me2))//1
{ 
continue;
} 
String meName = Model.getFacade().getName(me2);
if(meName == null || meName.equals(""))//1
{ 
continue;
} 
String compareName = meName;
if(confusable(stripped2, strip(compareName))
                    && !dmNameStr.equals(compareName))//1
{ 
res.add(me2);
} 
} 
return res;
} 
public String strip(String s)
    { 
StringBuffer res = new StringBuffer(s.length());
int len = s.length();
for (int i = 0; i < len; i++) //1
{ 
char c = s.charAt(i);
if(Character.isLetterOrDigit(c))//1
{ 
res.append(Character.toLowerCase(c));
} 
else
if(c == ']' && i > 1 && s.charAt(i - 1) == '[')//1
{ 
res.append("[]");
} 
} 
return res.toString();
} 
@Override
    public boolean stillValid(ToDoItem i, Designer dsgr)
    { 
if(!isActive())//1
{ 
return false;
} 
ListSet offs = i.getOffenders();
Object dm = offs.get(0);
if(!predicate(dm, dsgr))//1
{ 
return false;
} 
ListSet newOffs = computeOffenders(dm);
boolean res = offs.equals(newOffs);
return res;
} 
@Override
    public ToDoItem toDoItem(Object dm, Designer dsgr)
    { 
Object me = dm;
ListSet offs = computeOffenders(me);
return new UMLToDoItem(this, offs, dsgr);
} 
@Override
    public Icon getClarifier()
    { 
return ClClassName.getTheInstance();
} 
public Class getWizardClass(ToDoItem item)
    { 
return WizManyNames.class;
} 

 } 
