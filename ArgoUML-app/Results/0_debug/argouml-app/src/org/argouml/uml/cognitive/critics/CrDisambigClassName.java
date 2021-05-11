
//#if 2096219783 
// Compilation Unit of /CrDisambigClassName.java 
 

//#if -750926214 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 1332774469 
import java.util.Collection;
//#endif 


//#if -722960267 
import java.util.Iterator;
//#endif 


//#if 925437730 
import javax.swing.Icon;
//#endif 


//#if 124872670 
import org.argouml.cognitive.Critic;
//#endif 


//#if 1018072711 
import org.argouml.cognitive.Designer;
//#endif 


//#if -501912935 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 731794008 
import org.argouml.cognitive.critics.Wizard;
//#endif 


//#if -1972195444 
import org.argouml.model.Model;
//#endif 


//#if -1504611826 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -221149422 
public class CrDisambigClassName extends 
//#if -514513885 
CrUML
//#endif 

  { 

//#if -499943664 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 778275266 
if(!(Model.getFacade().isAClassifier(dm)))//1
{ 

//#if -1531776087 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1028848984 
Object classifier = dm;
//#endif 


//#if 672185157 
String designMaterialName = Model.getFacade().getName(classifier);
//#endif 


//#if -1646015714 
if(designMaterialName != null && designMaterialName.length() == 0)//1
{ 

//#if 669529538 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -2144690187 
Collection elementImports =
            Model.getFacade().getElementImports2(classifier);
//#endif 


//#if 1652833625 
if(elementImports == null)//1
{ 

//#if 678154168 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1071980694 
for (Iterator iter = elementImports.iterator(); iter.hasNext();) //1
{ 

//#if -834080734 
Object imp = iter.next();
//#endif 


//#if -178699604 
Object pack = Model.getFacade().getPackage(imp);
//#endif 


//#if 1945551153 
String alias = Model.getFacade().getAlias(imp);
//#endif 


//#if 1172285318 
if(alias == null || alias.length() == 0)//1
{ 

//#if 2025268155 
alias = designMaterialName;
//#endif 

} 

//#endif 


//#if -752783906 
Collection siblings = Model.getFacade().getOwnedElements(pack);
//#endif 


//#if 136792586 
if(siblings == null)//1
{ 

//#if 1938495560 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -2055083945 
Iterator elems = siblings.iterator();
//#endif 


//#if 1543308180 
while (elems.hasNext()) //1
{ 

//#if 1682621979 
Object eo = elems.next();
//#endif 


//#if -1752310329 
Object me = /*Model.getFacade().getModelElement(*/eo/*)*/;
//#endif 


//#if -998989806 
if(!(Model.getFacade().isAClassifier(me)))//1
{ 

//#if 1104400466 
continue;
//#endif 

} 

//#endif 


//#if -1717034054 
if(me == classifier)//1
{ 

//#if -1191809548 
continue;
//#endif 

} 

//#endif 


//#if -300232630 
String meName = Model.getFacade().getName(me);
//#endif 


//#if 1105883504 
if(meName == null || meName.equals(""))//1
{ 

//#if -1741773094 
continue;
//#endif 

} 

//#endif 


//#if 1775371672 
if(meName.equals(alias))//1
{ 

//#if -469726516 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 2010210199 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1122409717 
public void initWizard(Wizard w)
    { 

//#if 1320175910 
if(w instanceof WizMEName)//1
{ 

//#if -240510008 
ToDoItem item = (ToDoItem) w.getToDoItem();
//#endif 


//#if 668292239 
Object me = item.getOffenders().get(0);
//#endif 


//#if -1919500721 
String sug = Model.getFacade().getName(me);
//#endif 


//#if 1837718629 
String ins = super.getInstructions();
//#endif 


//#if 1960156084 
((WizMEName) w).setInstructions(ins);
//#endif 


//#if 465867562 
((WizMEName) w).setSuggestion(sug);
//#endif 


//#if 1195986526 
((WizMEName) w).setMustEdit(true);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 486270724 
public CrDisambigClassName()
    { 

//#if -407861361 
setupHeadAndDesc();
//#endif 


//#if -2006955177 
addSupportedDecision(UMLDecision.NAMING);
//#endif 


//#if -868973796 
setKnowledgeTypes(Critic.KT_SYNTAX);
//#endif 


//#if 369366168 
addTrigger("name");
//#endif 


//#if 319751120 
addTrigger("elementOwnership");
//#endif 

} 

//#endif 


//#if 1676744302 
public Icon getClarifier()
    { 

//#if 1321778452 
return ClClassName.getTheInstance();
//#endif 

} 

//#endif 


//#if 1036730233 
public Class getWizardClass(ToDoItem item)
    { 

//#if -178317518 
return WizMEName.class;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

