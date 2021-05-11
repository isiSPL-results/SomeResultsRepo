
//#if -1741756878 
// Compilation Unit of /GoStatemachineToDiagram.java 
 

//#if 754248363 
package org.argouml.ui.explorer.rules;
//#endif 


//#if 870150311 
import java.util.Collection;
//#endif 


//#if 1204857660 
import java.util.Collections;
//#endif 


//#if 1335514941 
import java.util.HashSet;
//#endif 


//#if 451036175 
import java.util.Set;
//#endif 


//#if 2031162660 
import org.argouml.i18n.Translator;
//#endif 


//#if 1014359264 
import org.argouml.kernel.Project;
//#endif 


//#if 1362547209 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -1458433558 
import org.argouml.model.Model;
//#endif 


//#if -1642158935 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if -1646301542 
import org.argouml.uml.diagram.state.ui.UMLStateDiagram;
//#endif 


//#if -677896600 
import org.argouml.uml.diagram.activity.ui.UMLActivityDiagram;
//#endif 


//#if -270805060 
public class GoStatemachineToDiagram extends 
//#if -1737618421 
AbstractPerspectiveRule
//#endif 

  { 

//#if -1171322535 
public String getRuleName()
    { 

//#if -1121704709 
return Translator.localize("misc.state-machine.diagram");
//#endif 

} 

//#endif 


//#if 1245423131 
public Collection getChildren(Object parent)
    { 

//#if 1891738203 
if(Model.getFacade().isAStateMachine(parent))//1
{ 

//#if -1965989386 
Set<ArgoDiagram> returnList = new HashSet<ArgoDiagram>();
//#endif 


//#if -1293473296 
Project proj = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 2079854300 
for (ArgoDiagram diagram : proj.getDiagramList()) //1
{ 

//#if -888232479 
if(diagram instanceof UMLActivityDiagram)//1
{ 

//#if 1612165492 
UMLActivityDiagram activityDiagram =
                        (UMLActivityDiagram) diagram;
//#endif 


//#if 690105351 
Object activityGraph = activityDiagram.getStateMachine();
//#endif 


//#if 1384948536 
if(activityGraph == parent)//1
{ 

//#if 1647108833 
returnList.add(activityDiagram);
//#endif 


//#if 2045113346 
continue;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -820416491 
if(diagram instanceof UMLStateDiagram)//1
{ 

//#if -1491810251 
UMLStateDiagram stateDiagram = (UMLStateDiagram) diagram;
//#endif 


//#if 809281595 
Object stateMachine = stateDiagram.getStateMachine();
//#endif 


//#if 916740778 
if(stateMachine == parent)//1
{ 

//#if 1082184078 
returnList.add(stateDiagram);
//#endif 


//#if 1439471207 
continue;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1639969420 
return returnList;
//#endif 

} 

//#endif 


//#if -1852025936 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 1011038761 
public Set getDependencies(Object parent)
    { 

//#if -1282483944 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

