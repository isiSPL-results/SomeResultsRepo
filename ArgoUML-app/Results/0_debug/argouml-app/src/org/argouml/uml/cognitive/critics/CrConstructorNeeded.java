
//#if 1124512105 
// Compilation Unit of /CrConstructorNeeded.java 
 

//#if -1975422389 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -535051306 
import java.util.Collection;
//#endif 


//#if -608702906 
import java.util.Iterator;
//#endif 


//#if 106071151 
import org.argouml.cognitive.Critic;
//#endif 


//#if 129682136 
import org.argouml.cognitive.Designer;
//#endif 


//#if -1390303510 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 812008937 
import org.argouml.cognitive.critics.Wizard;
//#endif 


//#if -773571493 
import org.argouml.model.Model;
//#endif 


//#if 982050973 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 1505640179 
public class CrConstructorNeeded extends 
//#if -1090922693 
CrUML
//#endif 

  { 

//#if -567904327 
@Override
    public Class getWizardClass(ToDoItem item)
    { 

//#if 2011069517 
return WizAddConstructor.class;
//#endif 

} 

//#endif 


//#if 936076974 
public CrConstructorNeeded()
    { 

//#if 387866167 
setupHeadAndDesc();
//#endif 


//#if 193860904 
addSupportedDecision(UMLDecision.STORAGE);
//#endif 


//#if 327234014 
addKnowledgeType(Critic.KT_CORRECTNESS);
//#endif 


//#if -435767164 
addTrigger("behavioralFeature");
//#endif 


//#if -1182355612 
addTrigger("structuralFeature");
//#endif 

} 

//#endif 


//#if 189918027 
@Override
    public void initWizard(Wizard w)
    { 

//#if -169436491 
if(w instanceof WizAddConstructor)//1
{ 

//#if 719618486 
ToDoItem item = (ToDoItem) w.getToDoItem();
//#endif 


//#if 1717593441 
Object me = item.getOffenders().get(0);
//#endif 


//#if -1897498185 
String ins = super.getInstructions();
//#endif 


//#if -852287034 
String sug = null;
//#endif 


//#if 1739092073 
if(me != null)//1
{ 

//#if 636325640 
sug = Model.getFacade().getName(me);
//#endif 

} 

//#endif 


//#if 2028215341 
if("".equals(sug))//1
{ 

//#if 225063548 
sug = super.getDefaultSuggestion();
//#endif 

} 

//#endif 


//#if -216070192 
((WizAddConstructor) w).setInstructions(ins);
//#endif 


//#if -1905109434 
((WizAddConstructor) w).setSuggestion(sug);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1872000720 
@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if -117159615 
if(!(Model.getFacade().isAClass(dm)))//1
{ 

//#if 1526065142 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -620923751 
if(!(Model.getFacade().isPrimaryObject(dm)))//1
{ 

//#if 1416085786 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1792411212 
if(Model.getFacade().isType(dm))//1
{ 

//#if -1388947890 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 956771570 
if(Model.getFacade().isUtility(dm))//1
{ 

//#if 1483546518 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1139233017 
Collection operations = Model.getFacade().getOperations(dm);
//#endif 


//#if 620792493 
Iterator opers = operations.iterator();
//#endif 


//#if 1370436441 
while (opers.hasNext()) //1
{ 

//#if -1711712992 
if(Model.getFacade().isConstructor(opers.next()))//1
{ 

//#if 1637452398 
return NO_PROBLEM;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 468379515 
Iterator attrs = Model.getFacade().getAttributes(dm).iterator();
//#endif 


//#if -560372394 
while (attrs.hasNext()) //1
{ 

//#if 224036500 
Object attr = attrs.next();
//#endif 


//#if 1254064567 
if(Model.getFacade().isStatic(attr))//1
{ 

//#if 1238208586 
continue;
//#endif 

} 

//#endif 


//#if -964237029 
if(Model.getFacade().isInitialized(attr))//1
{ 

//#if 1870223294 
continue;
//#endif 

} 

//#endif 


//#if -1418070353 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if 1436260173 
return NO_PROBLEM;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

