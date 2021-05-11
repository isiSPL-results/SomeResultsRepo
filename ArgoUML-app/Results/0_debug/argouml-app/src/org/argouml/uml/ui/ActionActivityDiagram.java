
//#if -792735482 
// Compilation Unit of /ActionActivityDiagram.java 
 

//#if 710747682 
package org.argouml.uml.ui;
//#endif 


//#if -1757217647 
import org.argouml.model.Model;
//#endif 


//#if -1036486351 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 532270288 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if 1837030645 
import org.argouml.uml.diagram.DiagramFactory;
//#endif 


//#if 680064759 
public class ActionActivityDiagram extends 
//#if 822078116 
ActionNewDiagram
//#endif 

  { 

//#if 1135046155 
private static final long serialVersionUID = -28844322376391273L;
//#endif 


//#if -1344719413 
public ActionActivityDiagram()
    { 

//#if -1457228177 
super("action.activity-diagram");
//#endif 

} 

//#endif 


//#if -796442203 
protected ArgoDiagram createDiagram(Object namespace)
    { 

//#if -1934043712 
Object context = TargetManager.getInstance().getModelTarget();
//#endif 


//#if -749652509 
if(!Model.getActivityGraphsHelper().isAddingActivityGraphAllowed(
                    context)
                || Model.getModelManagementHelper().isReadOnly(context))//1
{ 

//#if -582493111 
context = namespace;
//#endif 

} 

//#endif 


//#if -1376409873 
Object graph =
            Model.getActivityGraphsFactory().buildActivityGraph(context);
//#endif 


//#if 51368230 
return DiagramFactory.getInstance().createDiagram(
                   DiagramFactory.DiagramType.Activity,
                   Model.getFacade().getNamespace(graph),
                   graph);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

