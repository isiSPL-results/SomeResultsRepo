
//#if -96268755 
// Compilation Unit of /ActionAddExistingNode.java 
 

//#if 1412406844 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 1361718293 
import java.awt.event.ActionEvent;
//#endif 


//#if -1837416704 
import org.argouml.i18n.Translator;
//#endif 


//#if -2114745914 
import org.argouml.model.Model;
//#endif 


//#if 287059420 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 236925573 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if -572550119 
import org.argouml.uml.diagram.DiagramUtils;
//#endif 


//#if 564456543 
import org.tigris.gef.base.Editor;
//#endif 


//#if -1826237638 
import org.tigris.gef.base.Globals;
//#endif 


//#if 469605106 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if -1978549240 
import org.tigris.gef.graph.MutableGraphModel;
//#endif 


//#if 1363643819 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if 1244934550 
public class ActionAddExistingNode extends 
//#if -649859445 
UndoableAction
//#endif 

  { 

//#if -465909487 
private Object object;
//#endif 


//#if -2057525965 
public void actionPerformed(ActionEvent ae)
    { 

//#if 552913684 
super.actionPerformed(ae);
//#endif 


//#if -405074964 
Editor ce = Globals.curEditor();
//#endif 


//#if 1028931174 
GraphModel gm = ce.getGraphModel();
//#endif 


//#if 1150017415 
if(!(gm instanceof MutableGraphModel))//1
{ 

//#if -1276654173 
return;
//#endif 

} 

//#endif 


//#if 473406074 
String instructions = null;
//#endif 


//#if -1906635864 
if(object != null)//1
{ 

//#if 345686335 
instructions =
                Translator.localize(
                    "misc.message.click-on-diagram-to-add",
                    new Object[] {
                        Model.getFacade().toString(object),
                    });
//#endif 


//#if -1138491886 
Globals.showStatus(instructions);
//#endif 

} 

//#endif 


//#if -1442912290 
final ModeAddToDiagram placeMode = new ModeAddToDiagram(
            TargetManager.getInstance().getTargets(),
            instructions);
//#endif 


//#if 2098222841 
Globals.mode(placeMode, false);
//#endif 

} 

//#endif 


//#if -1391536647 
public ActionAddExistingNode(String name, Object o)
    { 

//#if 1861816515 
super(name);
//#endif 


//#if -1972557775 
object = o;
//#endif 

} 

//#endif 


//#if -475169648 
public boolean isEnabled()
    { 

//#if 4713669 
Object target = TargetManager.getInstance().getTarget();
//#endif 


//#if -1334156257 
ArgoDiagram dia = DiagramUtils.getActiveDiagram();
//#endif 


//#if -194009009 
if(dia == null)//1
{ 

//#if 827364312 
return false;
//#endif 

} 

//#endif 


//#if 703354733 
if(dia instanceof UMLDiagram
                && ((UMLDiagram) dia).doesAccept(object))//1
{ 

//#if 1029635818 
return true;
//#endif 

} 

//#endif 


//#if -1495138330 
MutableGraphModel gm = (MutableGraphModel) dia.getGraphModel();
//#endif 


//#if 1187038671 
return gm.canAddNode(target);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

