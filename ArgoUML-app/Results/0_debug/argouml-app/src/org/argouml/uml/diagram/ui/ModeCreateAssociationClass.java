
//#if -606040010 
// Compilation Unit of /ModeCreateAssociationClass.java 
 

//#if -1126560607 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 557649201 
import java.awt.Rectangle;
//#endif 


//#if 1876412216 
import org.apache.log4j.Logger;
//#endif 


//#if 254121926 
import org.argouml.ui.ProjectBrowser;
//#endif 


//#if 326855658 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if -644419954 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -764371622 
import org.tigris.gef.base.Editor;
//#endif 


//#if 173438622 
import org.tigris.gef.base.Layer;
//#endif 


//#if -1444667556 
import org.tigris.gef.base.LayerPerspective;
//#endif 


//#if -360263969 
import org.tigris.gef.base.ModeCreatePolyEdge;
//#endif 


//#if 1363987587 
import org.tigris.gef.graph.MutableGraphModel;
//#endif 


//#if -1644191771 
import org.tigris.gef.presentation.FigEdge;
//#endif 


//#if 527274259 
public class ModeCreateAssociationClass extends 
//#if 416332361 
ModeCreatePolyEdge
//#endif 

  { 

//#if 2018834741 
private static final long serialVersionUID = -8656139458297932182L;
//#endif 


//#if 747859683 
private static final Logger LOG =
        Logger.getLogger(ModeCreateAssociationClass.class);
//#endif 


//#if 2001914308 
private static final int DISTANCE = 80;
//#endif 


//#if -1782947895 
@Override
    protected void endAttached(FigEdge fe)
    { 

//#if 833763610 
Layer lay = editor.getLayerManager().getActiveLayer();
//#endif 


//#if 897475194 
FigAssociationClass thisFig =
            (FigAssociationClass) lay.presentationFor(getNewEdge());
//#endif 


//#if 350572398 
buildParts(editor, thisFig, lay);
//#endif 

} 

//#endif 


//#if 803664538 
public static void buildInActiveLayer(Editor editor, Object element)
    { 

//#if 48085401 
Layer layer = editor.getLayerManager().getActiveLayer();
//#endif 


//#if -939976089 
FigAssociationClass thisFig =
            (FigAssociationClass) layer.presentationFor(element);
//#endif 


//#if -1982876621 
if(thisFig != null)//1
{ 

//#if -668672660 
buildParts(editor, thisFig, layer);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 304132181 
private static void buildParts(Editor editor, FigAssociationClass thisFig,
                                   Layer lay)
    { 

//#if -876229880 
thisFig.removePathItem(thisFig.getMiddleGroup());
//#endif 


//#if 199101388 
MutableGraphModel mutableGraphModel =
            (MutableGraphModel) editor.getGraphModel();
//#endif 


//#if -1197696235 
mutableGraphModel.addNode(thisFig.getOwner());
//#endif 


//#if -1570202628 
Rectangle drawingArea =
            ProjectBrowser.getInstance()
            .getEditorPane().getBounds();
//#endif 


//#if 568367867 
thisFig.makeEdgePort();
//#endif 


//#if -1799403794 
FigEdgePort tee = thisFig.getEdgePort();
//#endif 


//#if 1368262653 
thisFig.calcBounds();
//#endif 


//#if -161066443 
int x = tee.getX();
//#endif 


//#if -454439659 
int y = tee.getY();
//#endif 


//#if -1437885842 
DiagramSettings settings = ((ArgoDiagram) ((LayerPerspective) lay)
                                    .getDiagram()).getDiagramSettings();
//#endif 


//#if 1000715933 
LOG.info("Creating Class box for association class");
//#endif 


//#if -798395544 
FigClassAssociationClass figNode =
            new FigClassAssociationClass(thisFig.getOwner(),
                                         new Rectangle(x, y, 0, 0),
                                         settings);
//#endif 


//#if -1179183133 
y = y - DISTANCE;
//#endif 


//#if -1120668395 
if(y < 0)//1
{ 

//#if 347758247 
y = tee.getY() + figNode.getHeight() + DISTANCE;
//#endif 

} 

//#endif 


//#if -902124434 
if(x + figNode.getWidth() > drawingArea.getWidth())//1
{ 

//#if 1044228495 
x = tee.getX() - DISTANCE;
//#endif 

} 

//#endif 


//#if 1705780595 
figNode.setLocation(x, y);
//#endif 


//#if 2032350588 
lay.add(figNode);
//#endif 


//#if 1203854447 
FigEdgeAssociationClass dashedEdge =
            new FigEdgeAssociationClass(figNode, thisFig, settings);
//#endif 


//#if 1914098332 
lay.add(dashedEdge);
//#endif 


//#if -1584873386 
dashedEdge.damage();
//#endif 


//#if -610769416 
figNode.damage();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

