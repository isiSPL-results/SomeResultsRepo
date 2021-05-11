
//#if 1243991382 
// Compilation Unit of /ActivityDiagramRenderer.java 
 

//#if -543192700 
package org.argouml.uml.diagram.activity.ui;
//#endif 


//#if 40566048 
import java.util.Map;
//#endif 


//#if -132381108 
import org.argouml.uml.diagram.state.ui.StateDiagramRenderer;
//#endif 


//#if -1659353899 
import org.argouml.uml.diagram.ui.UMLDiagram;
//#endif 


//#if -1861426778 
import org.tigris.gef.base.Diagram;
//#endif 


//#if 358968424 
import org.tigris.gef.base.Layer;
//#endif 


//#if -544831662 
import org.tigris.gef.base.LayerPerspective;
//#endif 


//#if 1346258209 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if 194587018 
import org.tigris.gef.presentation.FigNode;
//#endif 


//#if -364501228 
public class ActivityDiagramRenderer extends 
//#if -411918293 
StateDiagramRenderer
//#endif 

  { 

//#if 2127784710 
@Override
    public FigNode getFigNodeFor(GraphModel gm, Layer lay, Object node,
                                 Map styleAttributes)
    { 

//#if -1351519210 
FigNode figNode = null;
//#endif 


//#if 136087636 
Diagram diag = ((LayerPerspective) lay).getDiagram();
//#endif 


//#if -638277088 
if(diag instanceof UMLDiagram
                && ((UMLDiagram) diag).doesAccept(node))//1
{ 

//#if -1049017579 
figNode = ((UMLDiagram) diag).drop(node, null);
//#endif 

} 
else
{ 

//#if -147032021 
figNode =  super.getFigNodeFor(gm, lay, node, styleAttributes);
//#endif 


//#if -2061929980 
if(figNode == null)//1
{ 

//#if -547874568 
return null;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -14024600 
lay.add(figNode);
//#endif 


//#if -1751802236 
return figNode;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

