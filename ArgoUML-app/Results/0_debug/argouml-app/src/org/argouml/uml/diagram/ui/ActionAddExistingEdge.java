
//#if -132012827 
// Compilation Unit of /ActionAddExistingEdge.java 
 

//#if 1867463774 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -563265101 
import java.awt.event.ActionEvent;
//#endif 


//#if 357271784 
import org.argouml.model.Model;
//#endif 


//#if 1886144378 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -2015916377 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if -1691173833 
import org.argouml.uml.diagram.DiagramUtils;
//#endif 


//#if -1371180708 
import org.tigris.gef.base.Globals;
//#endif 


//#if 1060852902 
import org.tigris.gef.graph.MutableGraphModel;
//#endif 


//#if 182592841 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if 1736749043 
public class ActionAddExistingEdge extends 
//#if 1289177008 
UndoableAction
//#endif 

  { 

//#if 1964430144 
private static final long serialVersionUID = 736094733140639882L;
//#endif 


//#if 849389978 
private Object edge = null;
//#endif 


//#if -1674773162 
@Override
    public void actionPerformed(ActionEvent arg0)
    { 

//#if -1008178396 
super.actionPerformed(arg0);
//#endif 


//#if -1074498768 
if(edge == null)//1
{ 

//#if 47806148 
return;
//#endif 

} 

//#endif 


//#if 1222530146 
MutableGraphModel gm = (MutableGraphModel) DiagramUtils
                               .getActiveDiagram().getGraphModel();
//#endif 


//#if 513076990 
if(gm.canAddEdge(edge))//1
{ 

//#if 808469899 
gm.addEdge(edge);
//#endif 


//#if 1754700131 
if(Model.getFacade().isAAssociationClass(edge))//1
{ 

//#if 661961646 
ModeCreateAssociationClass.buildInActiveLayer(Globals
                        .curEditor(), edge);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -706588119 
@Override
    public boolean isEnabled()
    { 

//#if 976867964 
Object target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if 1649270919 
ArgoDiagram dia = DiagramUtils.getActiveDiagram();
//#endif 


//#if 1924405479 
if(dia == null)//1
{ 

//#if -1941597846 
return false;
//#endif 

} 

//#endif 


//#if -1869209522 
MutableGraphModel gm = (MutableGraphModel) dia.getGraphModel();
//#endif 


//#if 1998181644 
return gm.canAddEdge(target);
//#endif 

} 

//#endif 


//#if 516209624 
public ActionAddExistingEdge(String name, Object edgeObject)
    { 

//#if 1467516124 
super(name);
//#endif 


//#if 1476752081 
edge = edgeObject;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

