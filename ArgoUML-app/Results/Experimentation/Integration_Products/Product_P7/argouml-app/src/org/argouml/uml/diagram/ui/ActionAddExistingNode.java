package org.argouml.uml.diagram.ui;
import java.awt.event.ActionEvent;
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
public class ActionAddExistingNode extends UndoableAction
  { 
private Object object;
public void actionPerformed(ActionEvent ae)
    { 
super.actionPerformed(ae);
Editor ce = Globals.curEditor();
GraphModel gm = ce.getGraphModel();
if(!(gm instanceof MutableGraphModel))//1
{ 
return;
} 
String instructions = null;
if(object != null)//1
{ 
instructions =
                Translator.localize(
                    "misc.message.click-on-diagram-to-add",
                    new Object[] {
                        Model.getFacade().toString(object),
                    });
Globals.showStatus(instructions);
} 
final ModeAddToDiagram placeMode = new ModeAddToDiagram(
            TargetManager.getInstance().getTargets(),
            instructions);
Globals.mode(placeMode, false);
} 
public ActionAddExistingNode(String name, Object o)
    { 
super(name);
object = o;
} 
public boolean isEnabled()
    { 
Object target = TargetManager.getInstance().getTarget();
ArgoDiagram dia = DiagramUtils.getActiveDiagram();
if(dia == null)//1
{ 
return false;
} 
if(dia instanceof UMLDiagram
                && ((UMLDiagram) dia).doesAccept(object))//1
{ 
return true;
} 
MutableGraphModel gm = (MutableGraphModel) dia.getGraphModel();
return gm.canAddNode(target);
} 

 } 
