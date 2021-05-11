
//#if 247455965 
// Compilation Unit of /AddExistingNodeCommand.java 
 

//#if -1829839512 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 1770711945 
import java.awt.Point;
//#endif 


//#if 1514139786 
import java.awt.Rectangle;
//#endif 


//#if -355181086 
import java.awt.dnd.DropTargetDropEvent;
//#endif 


//#if -941568268 
import java.awt.event.MouseEvent;
//#endif 


//#if -784695764 
import org.argouml.i18n.Translator;
//#endif 


//#if -366395662 
import org.argouml.model.Model;
//#endif 


//#if 1894942129 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if -713644435 
import org.argouml.uml.diagram.DiagramUtils;
//#endif 


//#if -834377813 
import org.tigris.gef.base.Command;
//#endif 


//#if 598415283 
import org.tigris.gef.base.Editor;
//#endif 


//#if -773516698 
import org.tigris.gef.base.Globals;
//#endif 


//#if 1852561970 
import org.tigris.gef.base.ModePlace;
//#endif 


//#if 168435549 
import org.tigris.gef.graph.GraphFactory;
//#endif 


//#if 1567712286 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if -131233444 
import org.tigris.gef.graph.MutableGraphModel;
//#endif 


//#if 629827305 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -2080045101 
public class AddExistingNodeCommand implements 
//#if -996403225 
Command
//#endif 

, 
//#if 1091853504 
GraphFactory
//#endif 

  { 

//#if -805923650 
private Object object;
//#endif 


//#if 517438389 
private Point location;
//#endif 


//#if -843363748 
private int count;
//#endif 


//#if -1652175278 
public GraphModel makeGraphModel()
    { 

//#if 1785425914 
return null;
//#endif 

} 

//#endif 


//#if -1795961067 
public void execute()
    { 

//#if -1964581970 
Editor ce = Globals.curEditor();
//#endif 


//#if 416956260 
GraphModel gm = ce.getGraphModel();
//#endif 


//#if -1750047543 
if(!(gm instanceof MutableGraphModel))//1
{ 

//#if -777578720 
return;
//#endif 

} 

//#endif 


//#if 815102328 
String instructions = null;
//#endif 


//#if 2075682792 
ModePlace placeMode = null;
//#endif 


//#if 1634813418 
if(object != null)//1
{ 

//#if -69508253 
ArgoDiagram activeDiagram = DiagramUtils.getActiveDiagram();
//#endif 


//#if -475235814 
if(activeDiagram instanceof UMLDiagram
                    && ((UMLDiagram) activeDiagram).doesAccept(object))//1
{ 

//#if 1736548481 
instructions = ((UMLDiagram) activeDiagram).
                               getInstructions(object);
//#endif 


//#if -2123641821 
placeMode = ((UMLDiagram) activeDiagram).
                            getModePlace(this, instructions);
//#endif 


//#if 2128369789 
placeMode.setAddRelatedEdges(true);
//#endif 

} 
else
{ 

//#if -1853925657 
instructions =
                    Translator.localize(
                        "misc.message.click-on-diagram-to-add",
                        new Object[] {Model.getFacade().toString(object), });
//#endif 


//#if 67429276 
placeMode = new ModePlace(this, instructions);
//#endif 


//#if -1744122030 
placeMode.setAddRelatedEdges(true);
//#endif 

} 

//#endif 


//#if -1074620680 
Globals.showStatus(instructions);
//#endif 

} 

//#endif 


//#if -1959256508 
if(location == null)//1
{ 

//#if -2085130484 
Globals.mode(placeMode, false);
//#endif 

} 
else
{ 

//#if -620271911 
Point p =
                new Point(
                location.x + (count * 100),
                location.y);
//#endif 


//#if -485686711 
Rectangle r = ce.getJComponent().getVisibleRect();
//#endif 


//#if -110319540 
p.translate(r.x, r.y);
//#endif 


//#if 178973148 
MouseEvent me =
                new MouseEvent(
                ce.getJComponent(),
                0,
                0,
                0,
                p.x,
                p.y,
                0,
                false);
//#endif 


//#if -2081596458 
placeMode.mousePressed(me);
//#endif 


//#if 53986897 
me =
                new MouseEvent(
                ce.getJComponent(),
                0,
                0,
                0,
                p.x,
                p.y,
                0,
                false);
//#endif 


//#if 33377487 
placeMode.mouseReleased(me);
//#endif 


//#if -162302180 
ArgoDiagram diagram = DiagramUtils.getActiveDiagram();
//#endif 


//#if -1782811530 
Fig aFig = diagram.presentationFor(object);
//#endif 


//#if 233813397 
aFig.setSize(aFig.getPreferredSize());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1587966936 
public Object makeEdge()
    { 

//#if -457151658 
return null;
//#endif 

} 

//#endif 


//#if -1160066025 
public AddExistingNodeCommand(Object o)
    { 

//#if -824250296 
object = o;
//#endif 

} 

//#endif 


//#if -527560212 
public AddExistingNodeCommand(Object o, DropTargetDropEvent event,
                                  int cnt)
    { 

//#if 1585602051 
object = o;
//#endif 


//#if 1060655044 
location = event.getLocation();
//#endif 


//#if -224175577 
count = cnt;
//#endif 

} 

//#endif 


//#if 1855698653 
public Object makeNode()
    { 

//#if 670204748 
return object;
//#endif 

} 

//#endif 


//#if -317674243 
public AddExistingNodeCommand(Object o, Point dropLocation,
                                  int cnt)
    { 

//#if -2086092578 
object = o;
//#endif 


//#if -1385326213 
location = dropLocation;
//#endif 


//#if 1917407916 
count = cnt;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

