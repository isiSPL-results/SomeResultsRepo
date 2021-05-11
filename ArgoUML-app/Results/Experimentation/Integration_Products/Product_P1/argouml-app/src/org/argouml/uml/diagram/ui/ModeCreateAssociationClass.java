package org.argouml.uml.diagram.ui;
import java.awt.Rectangle;
import org.apache.log4j.Logger;
import org.argouml.ui.ProjectBrowser;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.uml.diagram.DiagramSettings;
import org.tigris.gef.base.Editor;
import org.tigris.gef.base.Layer;
import org.tigris.gef.base.LayerPerspective;
import org.tigris.gef.base.ModeCreatePolyEdge;
import org.tigris.gef.graph.MutableGraphModel;
import org.tigris.gef.presentation.FigEdge;
public class ModeCreateAssociationClass extends ModeCreatePolyEdge
  { 
private static final long serialVersionUID = -8656139458297932182L;
private static final Logger LOG =
        Logger.getLogger(ModeCreateAssociationClass.class);
private static final int DISTANCE = 80;
@Override
    protected void endAttached(FigEdge fe)
    { 
Layer lay = editor.getLayerManager().getActiveLayer();
FigAssociationClass thisFig =
            (FigAssociationClass) lay.presentationFor(getNewEdge());
buildParts(editor, thisFig, lay);
} 
public static void buildInActiveLayer(Editor editor, Object element)
    { 
Layer layer = editor.getLayerManager().getActiveLayer();
FigAssociationClass thisFig =
            (FigAssociationClass) layer.presentationFor(element);
if(thisFig != null)//1
{ 
buildParts(editor, thisFig, layer);
} 
} 
private static void buildParts(Editor editor, FigAssociationClass thisFig,
                                   Layer lay)
    { 
thisFig.removePathItem(thisFig.getMiddleGroup());
MutableGraphModel mutableGraphModel =
            (MutableGraphModel) editor.getGraphModel();
mutableGraphModel.addNode(thisFig.getOwner());
Rectangle drawingArea =
            ProjectBrowser.getInstance()
            .getEditorPane().getBounds();
thisFig.makeEdgePort();
FigEdgePort tee = thisFig.getEdgePort();
thisFig.calcBounds();
int x = tee.getX();
int y = tee.getY();
DiagramSettings settings = ((ArgoDiagram) ((LayerPerspective) lay)
                                    .getDiagram()).getDiagramSettings();
LOG.info("Creating Class box for association class");
FigClassAssociationClass figNode =
            new FigClassAssociationClass(thisFig.getOwner(),
                                         new Rectangle(x, y, 0, 0),
                                         settings);
y = y - DISTANCE;
if(y < 0)//1
{ 
y = tee.getY() + figNode.getHeight() + DISTANCE;
} 
if(x + figNode.getWidth() > drawingArea.getWidth())//1
{ 
x = tee.getX() - DISTANCE;
} 
figNode.setLocation(x, y);
lay.add(figNode);
FigEdgeAssociationClass dashedEdge =
            new FigEdgeAssociationClass(figNode, thisFig, settings);
lay.add(dashedEdge);
dashedEdge.damage();
figNode.damage();
} 

 } 
