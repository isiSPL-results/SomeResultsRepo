// Compilation Unit of /ActionStateDiagram.java 
 
package org.argouml.uml.ui;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.Model;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.uml.diagram.DiagramFactory;
import org.argouml.uml.diagram.state.ui.UMLStateDiagram;
public class ActionStateDiagram extends ActionNewDiagram
  { 
private static final long serialVersionUID = -5197718695001757808L;
public ActionStateDiagram()
    { 
super("action.state-diagram");
} 

private boolean hasNoDiagramYet(Object machine)
    { 
Project p = ProjectManager.getManager().getCurrentProject();
for (ArgoDiagram d : p.getDiagramList()) //1
{ 
if(d instanceof UMLStateDiagram)//1
{ 
if(((UMLStateDiagram) d).getStateMachine() == machine)//1
{ 
return false;
} 

} 

} 

return true;
} 

protected ArgoDiagram createDiagram(Object namespace)
    { 
Object target = TargetManager.getInstance().getModelTarget();
if(Model.getFacade().isAUMLElement(target)
                && Model.getModelManagementHelper().isReadOnly(target))//1
{ 
target = namespace;
} 

Object machine = null;
if(Model.getStateMachinesHelper().isAddingStatemachineAllowed(
                    target))//1
{ 
machine = Model.getStateMachinesFactory().buildStateMachine(target);
} 
else
if(Model.getFacade().isAStateMachine(target)
                   && hasNoDiagramYet(target))//1
{ 
machine = target;
} 
else
{ 
machine = Model.getStateMachinesFactory().createStateMachine();
if(Model.getFacade().isANamespace(target))//1
{ 
namespace = target;
} 

Model.getCoreHelper().setNamespace(machine, namespace);
Model.getStateMachinesFactory()
            .buildCompositeStateOnStateMachine(machine);
} 


return DiagramFactory.getInstance().createDiagram(
                   DiagramFactory.DiagramType.State,
                   Model.getFacade().getNamespace(machine),
                   machine);
} 

 } 


