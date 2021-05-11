package org.argouml.uml.ui;
import org.argouml.model.Model;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.uml.diagram.DiagramFactory;
public class ActionActivityDiagram extends ActionNewDiagram
  { 
private static final long serialVersionUID = -28844322376391273L;
public ActionActivityDiagram()
    { 
super("action.activity-diagram");
} 
protected ArgoDiagram createDiagram(Object namespace)
    { 
Object context = TargetManager.getInstance().getModelTarget();
if(!Model.getActivityGraphsHelper().isAddingActivityGraphAllowed(
                    context)
                || Model.getModelManagementHelper().isReadOnly(context))//1
{ 
context = namespace;
} 
Object graph =
            Model.getActivityGraphsFactory().buildActivityGraph(context);
return DiagramFactory.getInstance().createDiagram(
                   DiagramFactory.DiagramType.Activity,
                   Model.getFacade().getNamespace(graph),
                   graph);
} 

 } 
