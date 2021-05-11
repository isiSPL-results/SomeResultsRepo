
//#if 1180278374 
// Compilation Unit of /CrReservedName.java 
 

//#if -72246856 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -911586530 
import java.util.ArrayList;
//#endif 


//#if 1440114529 
import java.util.HashSet;
//#endif 


//#if -397676413 
import java.util.List;
//#endif 


//#if 1372849715 
import java.util.Set;
//#endif 


//#if 76404192 
import javax.swing.Icon;
//#endif 


//#if 991691164 
import org.argouml.cognitive.Critic;
//#endif 


//#if 806990021 
import org.argouml.cognitive.Designer;
//#endif 


//#if -712995625 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 107628054 
import org.argouml.cognitive.critics.Wizard;
//#endif 


//#if 1797242172 
import org.argouml.kernel.Project;
//#endif 


//#if 1429609005 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -429754610 
import org.argouml.model.Model;
//#endif 


//#if 621080080 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 476748316 
public class CrReservedName extends 
//#if -72736459 
CrUML
//#endif 

  { 

//#if -1321875773 
private static List<String> names;
//#endif 


//#if -660134271 
private static List<String> umlReserved = new ArrayList<String>();
//#endif 


//#if 1651570786 
private static final long serialVersionUID = -5839267391209851505L;
//#endif 


//#if -598113875 
static
    {
        umlReserved.add("none");
        umlReserved.add("interface");
        umlReserved.add("sequential");
        umlReserved.add("guarded");
        umlReserved.add("concurrent");
        umlReserved.add("frozen");
        umlReserved.add("aggregate");
        umlReserved.add("composite");
    }
//#endif 


//#if 151747794 
static
    {
        // TODO: This could just work off the names in the UML profile
        // TODO: It doesn't look like it matches what's in the UML 1.4 spec
        umlReserved.add("becomes");
        umlReserved.add("call");
        umlReserved.add("component");
        //umlReserved.add("copy");
        //umlReserved.add("create");
        umlReserved.add("deletion");
        umlReserved.add("derived");
        //umlReserved.add("document");
        umlReserved.add("enumeration");
        umlReserved.add("extends");
    }
//#endif 


//#if 266316457 
static
    {
        umlReserved.add("facade");
        //umlReserved.add("file");
        umlReserved.add("framework");
        umlReserved.add("friend");
        umlReserved.add("import");
        umlReserved.add("inherits");
        umlReserved.add("instance");
        umlReserved.add("invariant");
        umlReserved.add("library");
        //umlReserved.add("node");
        umlReserved.add("metaclass");
        umlReserved.add("powertype");
        umlReserved.add("private");
        umlReserved.add("process");
        umlReserved.add("requirement");
        //umlReserved.add("send");
        umlReserved.add("stereotype");
        umlReserved.add("stub");
        umlReserved.add("subclass");
        umlReserved.add("subtype");
        umlReserved.add("system");
        umlReserved.add("table");
        umlReserved.add("thread");
        umlReserved.add("type");
    }
//#endif 


//#if -1842460492 
static
    {
        umlReserved.add("useCaseModel");
        umlReserved.add("uses");
        umlReserved.add("utility");
        //umlReserved.add("destroy");
        umlReserved.add("implementationClass");
        umlReserved.add("postcondition");
        umlReserved.add("precondition");
        umlReserved.add("topLevelPackage");
        umlReserved.add("subtraction");

        //     umlReserved.add("initial");
        //     umlReserved.add("final");
        //     umlReserved.add("fork");
        //     umlReserved.add("join");
        //     umlReserved.add("history");
    }
//#endif 


//#if -460044143 
@Override
    public void initWizard(Wizard w)
    { 

//#if 1431009278 
if(w instanceof WizMEName)//1
{ 

//#if 1242017655 
ToDoItem item = (ToDoItem) w.getToDoItem();
//#endif 


//#if -707607295 
String sug =
                Model.getFacade().getName(item.getOffenders().get(0));
//#endif 


//#if 1912338262 
String ins = super.getInstructions();
//#endif 


//#if 655179365 
((WizMEName) w).setInstructions(ins);
//#endif 


//#if 540487195 
((WizMEName) w).setSuggestion(sug);
//#endif 


//#if -879816371 
((WizMEName) w).setMustEdit(true);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1482782079 
@Override
    public Class getWizardClass(ToDoItem item)
    { 

//#if -113382903 
return WizMEName.class;
//#endif 

} 

//#endif 


//#if -1046770102 
@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if -757751197 
if(!(Model.getFacade().isPrimaryObject(dm)))//1
{ 

//#if -1147978290 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1288816368 
if(!(Model.getFacade().isAModelElement(dm)))//1
{ 

//#if -231858452 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 777998650 
String meName = Model.getFacade().getName(dm);
//#endif 


//#if 616582097 
if(meName == null || meName.equals(""))//1
{ 

//#if -2117248559 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -690841667 
String nameStr = meName;
//#endif 


//#if -1651324108 
if(nameStr == null || nameStr.length() == 0)//1
{ 

//#if 1032792160 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -783954606 
if(isBuiltin(nameStr))//1
{ 

//#if 1796848966 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1324924932 
for (String name : names) //1
{ 

//#if -2026814700 
if(name.equalsIgnoreCase(nameStr))//1
{ 

//#if 277014420 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1085219479 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1325621151 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if 1600180503 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if -629846743 
ret.add(Model.getMetaTypes().getClassifier());
//#endif 


//#if -1883982939 
ret.add(Model.getMetaTypes().getOperation());
//#endif 


//#if 457743183 
ret.add(Model.getMetaTypes().getState());
//#endif 


//#if -1453467905 
ret.add(Model.getMetaTypes().getAssociation());
//#endif 


//#if 791072735 
return ret;
//#endif 

} 

//#endif 


//#if -17672920 
@Override
    public Icon getClarifier()
    { 

//#if 1825196216 
return ClClassName.getTheInstance();
//#endif 

} 

//#endif 


//#if -40018052 
public CrReservedName()
    { 

//#if 840894732 
this(umlReserved);
//#endif 

} 

//#endif 


//#if -1681652187 
public CrReservedName(List<String> reservedNames)
    { 

//#if -1895819479 
setupHeadAndDesc();
//#endif 


//#if -714043546 
setPriority(ToDoItem.HIGH_PRIORITY);
//#endif 


//#if -1864316047 
addSupportedDecision(UMLDecision.NAMING);
//#endif 


//#if -1982407998 
setKnowledgeTypes(Critic.KT_SYNTAX);
//#endif 


//#if -1118591950 
addTrigger("name");
//#endif 


//#if -1171220759 
addTrigger("feature_name");
//#endif 


//#if -1246420042 
names = reservedNames;
//#endif 

} 

//#endif 


//#if 419022164 
protected boolean isBuiltin(String name)
    { 

//#if 1813644577 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 1854522696 
Object type = p.findTypeInDefaultModel(name);
//#endif 


//#if -1723568375 
return type != null;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

