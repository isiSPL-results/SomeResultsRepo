
//#if -1753320794 
// Compilation Unit of /CrNoOperations.java 
 

//#if 987007451 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -1749810978 
import java.util.HashSet;
//#endif 


//#if -703846954 
import java.util.Iterator;
//#endif 


//#if -1832131024 
import java.util.Set;
//#endif 


//#if 1913166019 
import javax.swing.Icon;
//#endif 


//#if 179472383 
import org.argouml.cognitive.Critic;
//#endif 


//#if 1948789352 
import org.argouml.cognitive.Designer;
//#endif 


//#if 428803706 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 143767929 
import org.argouml.cognitive.critics.Wizard;
//#endif 


//#if -61587765 
import org.argouml.model.Model;
//#endif 


//#if 1741416205 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -1390948615 
public class CrNoOperations extends 
//#if 33812098 
CrUML
//#endif 

  { 

//#if -108145003 
private boolean findInstanceOperationInInherited(Object dm, int depth)
    { 

//#if 1186219867 
Iterator ops = Model.getFacade().getOperations(dm).iterator();
//#endif 


//#if 1474498529 
while (ops.hasNext()) //1
{ 

//#if -966813863 
if(!Model.getFacade().isStatic(ops.next()))//1
{ 

//#if 440366346 
return true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 429866951 
if(depth > 50)//1
{ 

//#if 813074511 
return false;
//#endif 

} 

//#endif 


//#if -188668722 
Iterator iter = Model.getFacade().getGeneralizations(dm).iterator();
//#endif 


//#if -2039991207 
while (iter.hasNext()) //1
{ 

//#if 1725488761 
Object parent = Model.getFacade().getGeneral(iter.next());
//#endif 


//#if -2120173085 
if(parent == dm)//1
{ 

//#if 144460652 
continue;
//#endif 

} 

//#endif 


//#if 1745140739 
if(Model.getFacade().isAClassifier(parent)
                    && findInstanceOperationInInherited(parent, depth + 1))//1
{ 

//#if -1466591823 
return true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1463949322 
return false;
//#endif 

} 

//#endif 


//#if -2050814455 
public CrNoOperations()
    { 

//#if -719356842 
setupHeadAndDesc();
//#endif 


//#if -55121112 
addSupportedDecision(UMLDecision.BEHAVIOR);
//#endif 


//#if 1738265890 
setKnowledgeTypes(Critic.KT_COMPLETENESS);
//#endif 


//#if 153208005 
addTrigger("behavioralFeature");
//#endif 

} 

//#endif 


//#if 1465912919 
@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if -741401204 
if(!(Model.getFacade().isAClass(dm)
                || Model.getFacade().isAInterface(dm)))//1
{ 

//#if 246351698 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1832732878 
if(!(Model.getFacade().isPrimaryObject(dm)))//1
{ 

//#if 822017548 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 2131098536 
if((Model.getFacade().getName(dm) == null)
                || ("".equals(Model.getFacade().getName(dm))))//1
{ 

//#if 1642771150 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1939053005 
if(Model.getFacade().isType(dm))//1
{ 

//#if 1130070811 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1631262151 
if(Model.getFacade().isUtility(dm))//1
{ 

//#if -524377277 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -248014689 
if(findInstanceOperationInInherited(dm, 0))//1
{ 

//#if -1194768902 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1088929267 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if 309624174 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if 1447955504 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if 380361189 
ret.add(Model.getMetaTypes().getUMLClass());
//#endif 


//#if -185842818 
ret.add(Model.getMetaTypes().getInterface());
//#endif 


//#if 370620472 
return ret;
//#endif 

} 

//#endif 


//#if -1611261724 
@Override
    public void initWizard(Wizard w)
    { 

//#if -252475282 
if(w instanceof WizAddOperation)//1
{ 

//#if -631836626 
String ins = super.getInstructions();
//#endif 


//#if -534396621 
String sug = super.getDefaultSuggestion();
//#endif 


//#if -221684230 
((WizAddOperation) w).setInstructions(ins);
//#endif 


//#if -2043662608 
((WizAddOperation) w).setSuggestion(sug);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -590455563 
@Override
    public Icon getClarifier()
    { 

//#if 1015722382 
return ClOperationCompartment.getTheInstance();
//#endif 

} 

//#endif 


//#if 635779602 
@Override
    public Class getWizardClass(ToDoItem item)
    { 

//#if -816786827 
return WizAddOperation.class;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

