
//#if -1175796574 
// Compilation Unit of /CrNameConfusion.java 
 

//#if 991523844 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -18723505 
import java.util.Collection;
//#endif 


//#if 826997653 
import java.util.HashSet;
//#endif 


//#if 1867809279 
import java.util.Iterator;
//#endif 


//#if -628960153 
import java.util.Set;
//#endif 


//#if -220468436 
import javax.swing.Icon;
//#endif 


//#if -1294433048 
import org.argouml.cognitive.Critic;
//#endif 


//#if -1430089455 
import org.argouml.cognitive.Designer;
//#endif 


//#if -2079253674 
import org.argouml.cognitive.ListSet;
//#endif 


//#if 1344892195 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 189054306 
import org.argouml.cognitive.critics.Wizard;
//#endif 


//#if 870061122 
import org.argouml.model.Model;
//#endif 


//#if -1149673404 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -1365444825 
import org.argouml.uml.cognitive.UMLToDoItem;
//#endif 


//#if -1118764602 
public class CrNameConfusion extends 
//#if 997215694 
CrUML
//#endif 

  { 

//#if 1303422315 
private static final long serialVersionUID = -6659510145586121263L;
//#endif 


//#if -1947911882 
public int countDiffs(String s1, String s2)
    { 

//#if -1117822849 
int len = Math.min(s1.length(), s2.length());
//#endif 


//#if -1904020732 
int count = Math.abs(s1.length() - s2.length());
//#endif 


//#if 1999678415 
if(count > 2)//1
{ 

//#if -1080559984 
return count;
//#endif 

} 

//#endif 


//#if 764398872 
for (int i = 0; i < len; i++) //1
{ 

//#if 715057871 
if(s1.charAt(i) != s2.charAt(i))//1
{ 

//#if 179072113 
count++;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -496448437 
return count;
//#endif 

} 

//#endif 


//#if 476511674 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if 56016617 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if -1388209029 
ret.add(Model.getMetaTypes().getClassifier());
//#endif 


//#if 2069397693 
ret.add(Model.getMetaTypes().getState());
//#endif 


//#if -264675279 
return ret;
//#endif 

} 

//#endif 


//#if -2003506747 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 724840115 
if(!(Model.getFacade().isAModelElement(dm))
                || Model.getFacade().isAAssociation(dm))//1
{ 

//#if -1741796435 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 2101005024 
Object me = dm;
//#endif 


//#if 817794758 
ListSet offs = computeOffenders(me);
//#endif 


//#if -1072047568 
if(offs.size() > 1)//1
{ 

//#if -1328256689 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if 523135478 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1933462650 
public boolean confusable(String stripped1, String stripped2)
    { 

//#if 981609216 
int countDiffs = countDiffs(stripped1, stripped2);
//#endif 


//#if 423695289 
return countDiffs <= 1;
//#endif 

} 

//#endif 


//#if 859820824 
@Override
    public void initWizard(Wizard w)
    { 

//#if -1822399939 
if(w instanceof WizManyNames)//1
{ 

//#if -1841100985 
ToDoItem item = (ToDoItem) w.getToDoItem();
//#endif 


//#if 304339920 
((WizManyNames) w).setModelElements(item.getOffenders());
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1379794963 
public CrNameConfusion()
    { 

//#if -1749225708 
setupHeadAndDesc();
//#endif 


//#if -405139172 
addSupportedDecision(UMLDecision.NAMING);
//#endif 


//#if 1129568814 
setKnowledgeTypes(Critic.KT_PRESENTATION);
//#endif 


//#if -2022869449 
setKnowledgeTypes(Critic.KT_SYNTAX);
//#endif 


//#if -971998179 
addTrigger("name");
//#endif 

} 

//#endif 


//#if 1217740480 
public ListSet computeOffenders(Object dm)
    { 

//#if -594966142 
Object ns = Model.getFacade().getNamespace(dm);
//#endif 


//#if -164901923 
ListSet res = new ListSet(dm);
//#endif 


//#if -1729548509 
String n = Model.getFacade().getName(dm);
//#endif 


//#if -1843881295 
if(n == null || n.equals(""))//1
{ 

//#if 1776003514 
return res;
//#endif 

} 

//#endif 


//#if -2002635363 
String dmNameStr = n;
//#endif 


//#if 13444520 
if(dmNameStr == null || dmNameStr.length() == 0)//1
{ 

//#if 800025396 
return res;
//#endif 

} 

//#endif 


//#if -622394771 
String stripped2 = strip(dmNameStr);
//#endif 


//#if 676125920 
if(ns == null)//1
{ 

//#if 2126051272 
return res;
//#endif 

} 

//#endif 


//#if 526680730 
Collection oes = Model.getFacade().getOwnedElements(ns);
//#endif 


//#if 1943828384 
if(oes == null)//1
{ 

//#if -540601747 
return res;
//#endif 

} 

//#endif 


//#if 1465826421 
Iterator elems = oes.iterator();
//#endif 


//#if -2113515114 
while (elems.hasNext()) //1
{ 

//#if -939577926 
Object me2 = elems.next();
//#endif 


//#if 436890682 
if(me2 == dm || Model.getFacade().isAAssociation(me2))//1
{ 

//#if 237388677 
continue;
//#endif 

} 

//#endif 


//#if 1368531323 
String meName = Model.getFacade().getName(me2);
//#endif 


//#if -2089735841 
if(meName == null || meName.equals(""))//1
{ 

//#if -2112567265 
continue;
//#endif 

} 

//#endif 


//#if -1184593703 
String compareName = meName;
//#endif 


//#if 2106024101 
if(confusable(stripped2, strip(compareName))
                    && !dmNameStr.equals(compareName))//1
{ 

//#if 1500820558 
res.add(me2);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1458922454 
return res;
//#endif 

} 

//#endif 


//#if 122579976 
public String strip(String s)
    { 

//#if -467547222 
StringBuffer res = new StringBuffer(s.length());
//#endif 


//#if -1451949613 
int len = s.length();
//#endif 


//#if 1769973050 
for (int i = 0; i < len; i++) //1
{ 

//#if -1844297470 
char c = s.charAt(i);
//#endif 


//#if 1545834609 
if(Character.isLetterOrDigit(c))//1
{ 

//#if -982047158 
res.append(Character.toLowerCase(c));
//#endif 

} 
else

//#if -264062743 
if(c == ']' && i > 1 && s.charAt(i - 1) == '[')//1
{ 

//#if -1118657859 
res.append("[]");
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 2120796127 
return res.toString();
//#endif 

} 

//#endif 


//#if -97049794 
@Override
    public boolean stillValid(ToDoItem i, Designer dsgr)
    { 

//#if -28209944 
if(!isActive())//1
{ 

//#if -1496824873 
return false;
//#endif 

} 

//#endif 


//#if 1239792867 
ListSet offs = i.getOffenders();
//#endif 


//#if 18783938 
Object dm = offs.get(0);
//#endif 


//#if 1933620532 
if(!predicate(dm, dsgr))//1
{ 

//#if -461553488 
return false;
//#endif 

} 

//#endif 


//#if -92855332 
ListSet newOffs = computeOffenders(dm);
//#endif 


//#if 767610827 
boolean res = offs.equals(newOffs);
//#endif 


//#if 1710340996 
return res;
//#endif 

} 

//#endif 


//#if -1109954440 
@Override
    public ToDoItem toDoItem(Object dm, Designer dsgr)
    { 

//#if 1422146288 
Object me = dm;
//#endif 


//#if -2099853130 
ListSet offs = computeOffenders(me);
//#endif 


//#if 213020589 
return new UMLToDoItem(this, offs, dsgr);
//#endif 

} 

//#endif 


//#if -440528319 
@Override
    public Icon getClarifier()
    { 

//#if 888953623 
return ClClassName.getTheInstance();
//#endif 

} 

//#endif 


//#if -1163641244 
public Class getWizardClass(ToDoItem item)
    { 

//#if -2054574373 
return WizManyNames.class;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

