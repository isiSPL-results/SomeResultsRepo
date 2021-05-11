
//#if 1243576039 
// Compilation Unit of /SequenceDiagramRenderer.java 
 

//#if -1421744912 
package org.argouml.uml.diagram.sequence.ui;
//#endif 


//#if 212238561 
import java.awt.Rectangle;
//#endif 


//#if -1213585754 
import java.util.Map;
//#endif 


//#if -1481432696 
import org.apache.log4j.Logger;
//#endif 


//#if 366103803 
import org.argouml.model.Model;
//#endif 


//#if -1998816195 
import org.argouml.uml.CommentEdge;
//#endif 


//#if -200159686 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if -392976162 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 1761870496 
import org.argouml.uml.diagram.UmlDiagramRenderer;
//#endif 


//#if 1724935929 
import org.argouml.uml.diagram.static_structure.ui.FigComment;
//#endif 


//#if -657877713 
import org.argouml.uml.diagram.static_structure.ui.FigEdgeNote;
//#endif 


//#if -1195082514 
import org.tigris.gef.base.Layer;
//#endif 


//#if -602274036 
import org.tigris.gef.base.LayerPerspective;
//#endif 


//#if -996910809 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if 2123760181 
import org.tigris.gef.presentation.FigEdge;
//#endif 


//#if 2132396688 
import org.tigris.gef.presentation.FigNode;
//#endif 


//#if 1616015144 
public class SequenceDiagramRenderer extends 
//#if -1678328119 
UmlDiagramRenderer
//#endif 

  { 

//#if -1716213424 
private static final long serialVersionUID = -5460387717430613088L;
//#endif 


//#if -1334495994 
private static final Logger LOG =
        Logger.getLogger(SequenceDiagramRenderer.class);
//#endif 


//#if 1163602821 
public FigNode getFigNodeFor(GraphModel gm, Layer lay, Object node,
                                 Map styleAttributes)
    { 

//#if 1964152505 
FigNode result = null;
//#endif 


//#if -1043909561 
assert lay instanceof LayerPerspective;
//#endif 


//#if 1254296756 
ArgoDiagram diag = (ArgoDiagram) ((LayerPerspective) lay).getDiagram();
//#endif 


//#if -852812868 
DiagramSettings settings = diag.getDiagramSettings();
//#endif 


//#if -2016437207 
if(Model.getFacade().isAClassifierRole(node))//1
{ 

//#if -330351037 
result = new FigClassifierRole(node);
//#endif 

} 
else

//#if 1408134827 
if(Model.getFacade().isAComment(node))//1
{ 

//#if 647496519 
result = new FigComment(node, (Rectangle) null, settings);
//#endif 

} 

//#endif 


//#endif 


//#if -1842045506 
LOG.debug("SequenceDiagramRenderer getFigNodeFor " + result);
//#endif 


//#if -1560371283 
return result;
//#endif 

} 

//#endif 


//#if -59279498 
public FigEdge getFigEdgeFor(GraphModel gm, Layer lay, Object edge,
                                 Map styleAttributes)
    { 

//#if -2138680431 
FigEdge figEdge = null;
//#endif 


//#if -281684128 
assert lay instanceof LayerPerspective;
//#endif 


//#if 99483149 
ArgoDiagram diag = (ArgoDiagram) ((LayerPerspective) lay).getDiagram();
//#endif 


//#if 1563287317 
DiagramSettings settings = diag.getDiagramSettings();
//#endif 


//#if 1164329386 
if(edge instanceof CommentEdge)//1
{ 

//#if 308770370 
figEdge = new FigEdgeNote(edge, settings);
//#endif 

} 
else
{ 

//#if 239791384 
figEdge = getFigEdgeFor(edge, styleAttributes);
//#endif 

} 

//#endif 


//#if -1163062424 
lay.add(figEdge);
//#endif 


//#if 295683652 
return figEdge;
//#endif 

} 

//#endif 


//#if -814042710 
@Override
    public FigEdge getFigEdgeFor(Object edge, Map styleAttributes)
    { 

//#if 910227360 
if(edge == null)//1
{ 

//#if -1764905106 
throw new IllegalArgumentException("A model edge must be supplied");
//#endif 

} 

//#endif 


//#if 1723709586 
if(Model.getFacade().isAMessage(edge))//1
{ 

//#if 283059168 
Object action = Model.getFacade().getAction(edge);
//#endif 


//#if -1098197440 
FigEdge result = null;
//#endif 


//#if -730283994 
if(Model.getFacade().isACallAction(action))//1
{ 

//#if -1222212378 
result = new FigCallActionMessage(edge);
//#endif 

} 
else

//#if -1480590703 
if(Model.getFacade().isAReturnAction(action))//1
{ 

//#if 1524628519 
result = new FigReturnActionMessage(edge);
//#endif 

} 
else

//#if -1949230461 
if(Model.getFacade().isADestroyAction(action))//1
{ 

//#if -685444125 
result = new FigDestroyActionMessage(edge);
//#endif 

} 
else

//#if -777476567 
if(Model.getFacade().isACreateAction(action))//1
{ 

//#if 1077376698 
result = new FigCreateActionMessage(edge);
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#if -1153103623 
return result;
//#endif 

} 

//#endif 


//#if 1185027849 
throw new IllegalArgumentException("Failed to construct a FigEdge for "
                                           + edge);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

