
//#if -1071238628 
// Compilation Unit of /CrMissingOperName.java 
 

//#if 1502662274 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -2029576873 
import java.util.HashSet;
//#endif 


//#if 2106205993 
import java.util.Set;
//#endif 


//#if 1787631078 
import org.argouml.cognitive.Critic;
//#endif 


//#if 1201068687 
import org.argouml.cognitive.Designer;
//#endif 


//#if -318916959 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 1766813792 
import org.argouml.cognitive.critics.Wizard;
//#endif 


//#if 280255620 
import org.argouml.model.Model;
//#endif 


//#if 516230406 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -83827828 
public class CrMissingOperName extends 
//#if -37035364 
CrUML
//#endif 

  { 

//#if -1662013176 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if -1816950364 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if 1835289016 
ret.add(Model.getMetaTypes().getOperation());
//#endif 


//#if -1873502548 
return ret;
//#endif 

} 

//#endif 


//#if 823627786 
@Override
    public void initWizard(Wizard w)
    { 

//#if -1543786748 
if(w instanceof WizMEName)//1
{ 

//#if -1609933890 
ToDoItem item = (ToDoItem) w.getToDoItem();
//#endif 


//#if 2096105561 
Object me = item.getOffenders().get(0);
//#endif 


//#if -663586129 
String ins = super.getInstructions();
//#endif 


//#if -741236910 
String sug = super.getDefaultSuggestion();
//#endif 


//#if 353960273 
if(Model.getFacade().isAOperation(me))//1
{ 

//#if -768187521 
Object a = me;
//#endif 


//#if -585438210 
int count = 1;
//#endif 


//#if 911692154 
if(Model.getFacade().getOwner(a) != null)//1

//#if -367542718 
count = Model.getFacade().getFeatures(
                                Model.getFacade().getOwner(a)).size();
//#endif 


//#endif 


//#if -1437851401 
sug = "oper" + (count + 1);
//#endif 

} 

//#endif 


//#if -906997890 
((WizMEName) w).setInstructions(ins);
//#endif 


//#if -2035437196 
((WizMEName) w).setSuggestion(sug);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -355436104 
@Override
    public Class getWizardClass(ToDoItem item)
    { 

//#if 1836474470 
return WizMEName.class;
//#endif 

} 

//#endif 


//#if 170067953 
@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if -1814980499 
if(!(Model.getFacade().isAOperation(dm)))//1
{ 

//#if 2059203920 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -141741734 
Object oper = dm;
//#endif 


//#if 639399750 
String myName = Model.getFacade().getName(oper);
//#endif 


//#if -749130450 
if(myName == null || myName.equals(""))//1
{ 

//#if -313738794 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if 1244644205 
if(myName.length() == 0)//1
{ 

//#if -1476872527 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if 736496114 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -2093199297 
public CrMissingOperName()
    { 

//#if -1398291568 
setupHeadAndDesc();
//#endif 


//#if 338960536 
addSupportedDecision(UMLDecision.NAMING);
//#endif 


//#if -1448171205 
setKnowledgeTypes(Critic.KT_SYNTAX);
//#endif 


//#if -621064039 
addTrigger("name");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

