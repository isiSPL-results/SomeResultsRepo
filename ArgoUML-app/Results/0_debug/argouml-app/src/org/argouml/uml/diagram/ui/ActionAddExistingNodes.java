
//#if 889185310 
// Compilation Unit of /ActionAddExistingNodes.java 
 

//#if -1047599636 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 1383292037 
import java.awt.Point;
//#endif 


//#if 1005268581 
import java.awt.event.ActionEvent;
//#endif 


//#if 1554736283 
import java.util.Collection;
//#endif 


//#if -2455888 
import org.argouml.i18n.Translator;
//#endif 


//#if 537536886 
import org.argouml.model.Model;
//#endif 


//#if -491876308 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -1772893643 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if 1547563625 
import org.argouml.uml.diagram.DiagramUtils;
//#endif 


//#if 208006831 
import org.tigris.gef.base.Editor;
//#endif 


//#if 8723178 
import org.tigris.gef.base.Globals;
//#endif 


//#if -1273918814 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if -363739560 
import org.tigris.gef.graph.MutableGraphModel;
//#endif 


//#if -917946373 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -418184211 
public class ActionAddExistingNodes extends 
//#if -984671673 
UndoableAction
//#endif 

  { 

//#if -1354494667 
private Collection objects;
//#endif 


//#if 1149130453 
@Override
    public void actionPerformed(ActionEvent ae)
    { 

//#if 1469367520 
super.actionPerformed(ae);
//#endif 


//#if -1435947360 
Editor ce = Globals.curEditor();
//#endif 


//#if -674451662 
GraphModel gm = ce.getGraphModel();
//#endif 


//#if -1104858821 
if(!(gm instanceof MutableGraphModel))//1
{ 

//#if -395532121 
return;
//#endif 

} 

//#endif 


//#if 814383138 
String instructions =
            Translator.localize(
                "misc.message.click-on-diagram-to-add");
//#endif 


//#if -719382183 
Globals.showStatus(instructions);
//#endif 


//#if -52982905 
final ModeAddToDiagram placeMode = new ModeAddToDiagram(
            objects,
            instructions);
//#endif 


//#if 205949637 
Globals.mode(placeMode, false);
//#endif 

} 

//#endif 


//#if 1717219890 
@Override
    public boolean isEnabled()
    { 

//#if -17438077 
ArgoDiagram dia = DiagramUtils.getActiveDiagram();
//#endif 


//#if 572808811 
if(dia == null)//1
{ 

//#if 1781302350 
return false;
//#endif 

} 

//#endif 


//#if -713879478 
MutableGraphModel gm = (MutableGraphModel) dia.getGraphModel();
//#endif 


//#if -2012856 
for (Object o : objects) //1
{ 

//#if -370585751 
if(gm.canAddNode(o))//1
{ 

//#if -1579386374 
return true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1308318541 
return false;
//#endif 

} 

//#endif 


//#if -333689504 
public ActionAddExistingNodes(String name, Collection coll)
    { 

//#if -499196774 
super(name);
//#endif 


//#if -1922741386 
objects = coll;
//#endif 

} 

//#endif 


//#if -795446843 
public static void addNodes(Collection modelElements,
                                Point location, ArgoDiagram diagram)
    { 

//#if -2093332743 
MutableGraphModel gm = (MutableGraphModel) diagram.getGraphModel();
//#endif 


//#if -614231333 
Collection oldTargets = TargetManager.getInstance().getTargets();
//#endif 


//#if 1362790339 
int count = 0;
//#endif 


//#if 1160199657 
for (Object me : modelElements) //1
{ 

//#if -1100851585 
if(diagram instanceof UMLDiagram
                    && ((UMLDiagram) diagram).doesAccept(me))//1
{ 

//#if 1695183017 
((UMLDiagram) diagram).drop(me, location);
//#endif 

} 
else

//#if 877352227 
if(Model.getFacade().isANaryAssociation(me))//1
{ 

//#if -1326527600 
AddExistingNodeCommand cmd =
                    new AddExistingNodeCommand(me, location,
                                               count++);
//#endif 


//#if 1606046204 
cmd.execute();
//#endif 

} 
else

//#if 1721716642 
if(Model.getFacade().isAUMLElement(me))//1
{ 

//#if -1799202811 
if(gm.canAddEdge(me))//1
{ 

//#if 1972884144 
gm.addEdge(me);
//#endif 


//#if -410817954 
if(Model.getFacade().isAAssociationClass(me))//1
{ 

//#if -1906245821 
ModeCreateAssociationClass.buildInActiveLayer(
                            Globals.curEditor(),
                            me);
//#endif 

} 

//#endif 

} 
else

//#if 2020400984 
if(gm.canAddNode(me))//1
{ 

//#if -1293875123 
AddExistingNodeCommand cmd =
                        new AddExistingNodeCommand(me, location,
                                                   count++);
//#endif 


//#if 470686559 
cmd.execute();
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#endif 


//#endif 

} 

//#endif 


//#if 864696860 
TargetManager.getInstance().setTargets(oldTargets);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

