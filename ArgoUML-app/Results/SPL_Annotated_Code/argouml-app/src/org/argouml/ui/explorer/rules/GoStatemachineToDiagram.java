// Compilation Unit of /GoStatemachineToDiagram.java 
 

//#if STATE 
package org.argouml.ui.explorer.rules;
//#endif 


//#if STATE 
import java.util.Collection;
//#endif 


//#if STATE 
import java.util.Collections;
//#endif 


//#if STATE 
import java.util.HashSet;
//#endif 


//#if STATE 
import java.util.Set;
//#endif 


//#if STATE 
import org.argouml.i18n.Translator;
//#endif 


//#if STATE 
import org.argouml.kernel.Project;
//#endif 


//#if STATE 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if STATE 
import org.argouml.model.Model;
//#endif 


//#if STATE 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if STATE 
import org.argouml.uml.diagram.state.ui.UMLStateDiagram;
//#endif 


//#if (( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
import org.argouml.uml.diagram.activity.ui.UMLActivityDiagram;
//#endif 


//#if STATE 
public class GoStatemachineToDiagram extends AbstractPerspectiveRule
  { 
public String getRuleName()
    { 
return Translator.localize("misc.state-machine.diagram");
} 

public Collection getChildren(Object parent)
    { 
if(Model.getFacade().isAStateMachine(parent))//1
{ 
Set<ArgoDiagram> returnList = new HashSet<ArgoDiagram>();
Project proj = ProjectManager.getManager().getCurrentProject();
for (ArgoDiagram diagram : proj.getDiagramList()) //1
{ 

//#if (( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
if(diagram instanceof UMLActivityDiagram)//1
{ 
UMLActivityDiagram activityDiagram =
                        (UMLActivityDiagram) diagram;
Object activityGraph = activityDiagram.getStateMachine();
if(activityGraph == parent)//1
{ 
returnList.add(activityDiagram);
continue;
} 

} 

//#endif 

if(diagram instanceof UMLStateDiagram)//1
{ 
UMLStateDiagram stateDiagram = (UMLStateDiagram) diagram;
Object stateMachine = stateDiagram.getStateMachine();
if(stateMachine == parent)//1
{ 
returnList.add(stateDiagram);
continue;
} 

} 

} 

return returnList;
} 

return Collections.EMPTY_SET;
} 

public Set getDependencies(Object parent)
    { 
return Collections.EMPTY_SET;
} 

 } 

//#endif 


