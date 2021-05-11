
//#if -180588464 
// Compilation Unit of /ActionStateDiagram.java 
 

//#if 1940581027 
package org.argouml.uml.ui;
//#endif 


//#if -1613365960 
import org.argouml.kernel.Project;
//#endif 


//#if 863184561 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 1126733970 
import org.argouml.model.Model;
//#endif 


//#if -2139671664 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -493326511 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if -1614831916 
import org.argouml.uml.diagram.DiagramFactory;
//#endif 


//#if 1621767410 
import org.argouml.uml.diagram.state.ui.UMLStateDiagram;
//#endif 


//#if -1275128946 
public class ActionStateDiagram extends 
//#if -595818919 
ActionNewDiagram
//#endif 

  { 

//#if -1601674068 
private static final long serialVersionUID = -5197718695001757808L;
//#endif 


//#if 1096977330 
public ActionStateDiagram()
    { 

//#if -716968566 
super("action.state-diagram");
//#endif 

} 

//#endif 


//#if 752756398 
private boolean hasNoDiagramYet(Object machine)
    { 

//#if -1911088137 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 1756745188 
for (ArgoDiagram d : p.getDiagramList()) //1
{ 

//#if -672606714 
if(d instanceof UMLStateDiagram)//1
{ 

//#if 733262169 
if(((UMLStateDiagram) d).getStateMachine() == machine)//1
{ 

//#if 1431326944 
return false;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1081877330 
return true;
//#endif 

} 

//#endif 


//#if -1872973798 
protected ArgoDiagram createDiagram(Object namespace)
    { 

//#if -1745397883 
Object target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if -774054282 
if(Model.getFacade().isAUMLElement(target)
                && Model.getModelManagementHelper().isReadOnly(target))//1
{ 

//#if -1551217222 
target = namespace;
//#endif 

} 

//#endif 


//#if 1872130095 
Object machine = null;
//#endif 


//#if -1685758937 
if(Model.getStateMachinesHelper().isAddingStatemachineAllowed(
                    target))//1
{ 

//#if -34693138 
machine = Model.getStateMachinesFactory().buildStateMachine(target);
//#endif 

} 
else

//#if -760725818 
if(Model.getFacade().isAStateMachine(target)
                   && hasNoDiagramYet(target))//1
{ 

//#if 1435894962 
machine = target;
//#endif 

} 
else
{ 

//#if 1543018036 
machine = Model.getStateMachinesFactory().createStateMachine();
//#endif 


//#if 269537562 
if(Model.getFacade().isANamespace(target))//1
{ 

//#if 78099769 
namespace = target;
//#endif 

} 

//#endif 


//#if 2111232311 
Model.getCoreHelper().setNamespace(machine, namespace);
//#endif 


//#if 17915136 
Model.getStateMachinesFactory()
            .buildCompositeStateOnStateMachine(machine);
//#endif 

} 

//#endif 


//#endif 


//#if -1740496665 
return DiagramFactory.getInstance().createDiagram(
                   DiagramFactory.DiagramType.State,
                   Model.getFacade().getNamespace(machine),
                   machine);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

