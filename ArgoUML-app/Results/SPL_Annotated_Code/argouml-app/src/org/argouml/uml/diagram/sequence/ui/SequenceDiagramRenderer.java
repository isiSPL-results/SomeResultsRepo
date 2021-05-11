// Compilation Unit of /SequenceDiagramRenderer.java 
 
package org.argouml.uml.diagram.sequence.ui;
import java.awt.Rectangle;
import java.util.Map;
import org.apache.log4j.Logger;
import org.argouml.model.Model;
import org.argouml.uml.CommentEdge;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.UmlDiagramRenderer;
import org.argouml.uml.diagram.static_structure.ui.FigComment;
import org.argouml.uml.diagram.static_structure.ui.FigEdgeNote;
import org.tigris.gef.base.Layer;
import org.tigris.gef.base.LayerPerspective;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.presentation.FigEdge;
import org.tigris.gef.presentation.FigNode;
public class SequenceDiagramRenderer extends UmlDiagramRenderer
  { 
private static final long serialVersionUID = -5460387717430613088L;
private static final Logger LOG =
        Logger.getLogger(SequenceDiagramRenderer.class);
public FigNode getFigNodeFor(GraphModel gm, Layer lay, Object node,
                                 Map styleAttributes)
    { 
FigNode result = null;
assert lay instanceof LayerPerspective;
ArgoDiagram diag = (ArgoDiagram) ((LayerPerspective) lay).getDiagram();
DiagramSettings settings = diag.getDiagramSettings();
if(Model.getFacade().isAClassifierRole(node))//1
{ 
result = new FigClassifierRole(node);
} 
else
if(Model.getFacade().isAComment(node))//1
{ 
result = new FigComment(node, (Rectangle) null, settings);
} 


LOG.debug("SequenceDiagramRenderer getFigNodeFor " + result);
return result;
} 

public FigEdge getFigEdgeFor(GraphModel gm, Layer lay, Object edge,
                                 Map styleAttributes)
    { 
FigEdge figEdge = null;
assert lay instanceof LayerPerspective;
ArgoDiagram diag = (ArgoDiagram) ((LayerPerspective) lay).getDiagram();
DiagramSettings settings = diag.getDiagramSettings();
if(edge instanceof CommentEdge)//1
{ 
figEdge = new FigEdgeNote(edge, settings);
} 
else
{ 
figEdge = getFigEdgeFor(edge, styleAttributes);
} 

lay.add(figEdge);
return figEdge;
} 

@Override
    public FigEdge getFigEdgeFor(Object edge, Map styleAttributes)
    { 
if(edge == null)//1
{ 
throw new IllegalArgumentException("A model edge must be supplied");
} 

if(Model.getFacade().isAMessage(edge))//1
{ 
Object action = Model.getFacade().getAction(edge);
FigEdge result = null;
if(Model.getFacade().isACallAction(action))//1
{ 
result = new FigCallActionMessage(edge);
} 
else
if(Model.getFacade().isAReturnAction(action))//1
{ 
result = new FigReturnActionMessage(edge);
} 
else
if(Model.getFacade().isADestroyAction(action))//1
{ 
result = new FigDestroyActionMessage(edge);
} 
else
if(Model.getFacade().isACreateAction(action))//1
{ 
result = new FigCreateActionMessage(edge);
} 




return result;
} 

throw new IllegalArgumentException("Failed to construct a FigEdge for "
                                           + edge);
} 

 } 


