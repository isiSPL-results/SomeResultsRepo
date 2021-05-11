// Compilation Unit of /ActionAddExistingNodes.java 
 
package org.argouml.uml.diagram.ui;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.util.Collection;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.uml.diagram.DiagramUtils;
import org.tigris.gef.base.Editor;
import org.tigris.gef.base.Globals;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.graph.MutableGraphModel;
import org.tigris.gef.undo.UndoableAction;
public class ActionAddExistingNodes extends UndoableAction
  { 
private Collection objects;
@Override
    public void actionPerformed(ActionEvent ae)
    { 
super.actionPerformed(ae);
Editor ce = Globals.curEditor();
GraphModel gm = ce.getGraphModel();
if(!(gm instanceof MutableGraphModel))//1
{ 
return;
} 

String instructions =
            Translator.localize(
                "misc.message.click-on-diagram-to-add");
Globals.showStatus(instructions);
final ModeAddToDiagram placeMode = new ModeAddToDiagram(
            objects,
            instructions);
Globals.mode(placeMode, false);
} 

@Override
    public boolean isEnabled()
    { 
ArgoDiagram dia = DiagramUtils.getActiveDiagram();
if(dia == null)//1
{ 
return false;
} 

MutableGraphModel gm = (MutableGraphModel) dia.getGraphModel();
for (Object o : objects) //1
{ 
if(gm.canAddNode(o))//1
{ 
return true;
} 

} 

return false;
} 

public ActionAddExistingNodes(String name, Collection coll)
    { 
super(name);
objects = coll;
} 

public static void addNodes(Collection modelElements,
                                Point location, ArgoDiagram diagram)
    { 
MutableGraphModel gm = (MutableGraphModel) diagram.getGraphModel();
Collection oldTargets = TargetManager.getInstance().getTargets();
int count = 0;
for (Object me : modelElements) //1
{ 
if(diagram instanceof UMLDiagram
                    && ((UMLDiagram) diagram).doesAccept(me))//1
{ 
((UMLDiagram) diagram).drop(me, location);
} 
else
if(Model.getFacade().isANaryAssociation(me))//1
{ 
AddExistingNodeCommand cmd =
                    new AddExistingNodeCommand(me, location,
                                               count++);
cmd.execute();
} 
else
if(Model.getFacade().isAUMLElement(me))//1
{ 
if(gm.canAddEdge(me))//1
{ 
gm.addEdge(me);
if(Model.getFacade().isAAssociationClass(me))//1
{ 
ModeCreateAssociationClass.buildInActiveLayer(
                            Globals.curEditor(),
                            me);
} 

} 
else
if(gm.canAddNode(me))//1
{ 
AddExistingNodeCommand cmd =
                        new AddExistingNodeCommand(me, location,
                                                   count++);
cmd.execute();
} 


} 



} 

TargetManager.getInstance().setTargets(oldTargets);
} 

 } 


