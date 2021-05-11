
//#if -392493202 
// Compilation Unit of /CrMissingStateName.java 
 

//#if -2043278072 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 1615440401 
import java.util.HashSet;
//#endif 


//#if 338960611 
import java.util.Set;
//#endif 


//#if -1303413456 
import javax.swing.Icon;
//#endif 


//#if 1368207596 
import org.argouml.cognitive.Critic;
//#endif 


//#if 1862028309 
import org.argouml.cognitive.Designer;
//#endif 


//#if 342042663 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 27207014 
import org.argouml.cognitive.critics.Wizard;
//#endif 


//#if -937101890 
import org.argouml.model.Model;
//#endif 


//#if -1871972160 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 1251501839 
public class CrMissingStateName extends 
//#if -722318784 
CrUML
//#endif 

  { 

//#if 1967628796 
private static final long serialVersionUID = 1181623952639408440L;
//#endif 


//#if 776064947 
@Override
    public Icon getClarifier()
    { 

//#if 1192506283 
return ClClassName.getTheInstance();
//#endif 

} 

//#endif 


//#if -408830315 
@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 279328001 
if(!Model.getFacade().isAStateVertex(dm))//1
{ 

//#if -351460921 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -442102414 
if(Model.getFacade().isACompositeState(dm)
                && Model.getFacade().isTop(dm))//1
{ 

//#if 383513805 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -179008688 
if(Model.getFacade().isAFinalState(dm))//1
{ 

//#if -1227034354 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1797124642 
if(Model.getFacade().isAPseudostate(dm))//1
{ 

//#if -82964451 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1877687226 
if(Model.getFacade().isAActionState(dm))//1
{ 

//#if 841693977 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 697461071 
if(Model.getFacade().isAObjectFlowState(dm))//1
{ 

//#if 140073113 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 89649358 
String myName = Model.getFacade().getName(dm);
//#endif 


//#if 538693683 
if(myName == null || myName.equals("") || myName.length() == 0)//1
{ 

//#if -1164738191 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if -1831256897 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -992916564 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if -1073158910 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if 1654791496 
ret.add(Model.getMetaTypes().getStateVertex());
//#endif 


//#if -943819894 
return ret;
//#endif 

} 

//#endif 


//#if 441456820 
public CrMissingStateName()
    { 

//#if 1822449122 
setupHeadAndDesc();
//#endif 


//#if -1539288726 
addSupportedDecision(UMLDecision.NAMING);
//#endif 


//#if 59884761 
setKnowledgeTypes(Critic.KT_COMPLETENESS, Critic.KT_SYNTAX);
//#endif 


//#if -1695290645 
addTrigger("name");
//#endif 

} 

//#endif 


//#if 185773286 
@Override
    public void initWizard(Wizard w)
    { 

//#if -175615793 
if(w instanceof WizMEName)//1
{ 

//#if 1190565718 
ToDoItem item = (ToDoItem) w.getToDoItem();
//#endif 


//#if 526332865 
Object me = item.getOffenders().get(0);
//#endif 


//#if 335896599 
String ins = super.getInstructions();
//#endif 


//#if 2059262698 
String sug = super.getDefaultSuggestion();
//#endif 


//#if -1513012009 
if(Model.getFacade().isAStateVertex(me))//1
{ 

//#if -1122252155 
Object sv = me;
//#endif 


//#if -1672843318 
int count = 1;
//#endif 


//#if 7659428 
if(Model.getFacade().getContainer(sv) != null)//1
{ 

//#if -1665211428 
count =
                        Model.getFacade().getSubvertices(
                            Model.getFacade().getContainer(sv)).size();
//#endif 

} 

//#endif 


//#if 660537230 
sug = "S" + (count + 1);
//#endif 

} 

//#endif 


//#if 1818196710 
((WizMEName) w).setInstructions(ins);
//#endif 


//#if -1035954468 
((WizMEName) w).setSuggestion(sug);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1088277612 
@Override
    public Class getWizardClass(ToDoItem item)
    { 

//#if -1373529936 
return WizMEName.class;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

