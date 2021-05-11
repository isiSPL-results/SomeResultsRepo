package org.argouml.ui.explorer.rules;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.argouml.i18n.Translator;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.Model;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.uml.diagram.state.ui.UMLStateDiagram;
import org.argouml.uml.diagram.activity.ui.UMLActivityDiagram;
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
