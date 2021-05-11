
//#if 1166798602 
// Compilation Unit of /UseCaseDiagramRenderer.java 
 

//#if 167365879 
package org.argouml.uml.diagram.use_case.ui;
//#endif 


//#if -244346298 
import java.util.Map;
//#endif 


//#if -723614424 
import org.apache.log4j.Logger;
//#endif 


//#if 1123922075 
import org.argouml.model.Model;
//#endif 


//#if -1536356387 
import org.argouml.uml.CommentEdge;
//#endif 


//#if 1982120410 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if 2059652222 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 1988882276 
import org.argouml.uml.diagram.DiagramUtils;
//#endif 


//#if 503238993 
import org.argouml.uml.diagram.GraphChangeAdapter;
//#endif 


//#if 2030418688 
import org.argouml.uml.diagram.UmlDiagramRenderer;
//#endif 


//#if -1367443249 
import org.argouml.uml.diagram.static_structure.ui.FigEdgeNote;
//#endif 


//#if 1596556221 
import org.argouml.uml.diagram.ui.FigAssociation;
//#endif 


//#if 1817820685 
import org.argouml.uml.diagram.ui.FigDependency;
//#endif 


//#if 892291656 
import org.argouml.uml.diagram.ui.FigEdgeModelElement;
//#endif 


//#if 1456302716 
import org.argouml.uml.diagram.ui.FigGeneralization;
//#endif 


//#if -1361419741 
import org.argouml.uml.diagram.ui.FigNodeModelElement;
//#endif 


//#if 2082031611 
import org.argouml.uml.diagram.ui.UMLDiagram;
//#endif 


//#if 1218803854 
import org.tigris.gef.base.Layer;
//#endif 


//#if -1671067796 
import org.tigris.gef.base.LayerPerspective;
//#endif 


//#if -1200481081 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if 11072981 
import org.tigris.gef.presentation.FigEdge;
//#endif 


//#if 19709488 
import org.tigris.gef.presentation.FigNode;
//#endif 


//#if -1794695188 
public class UseCaseDiagramRenderer extends 
//#if 763624687 
UmlDiagramRenderer
//#endif 

  { 

//#if 1955123488 
static final long serialVersionUID = 2217410137377934879L;
//#endif 


//#if 995046272 
private static final Logger LOG =
        Logger.getLogger(UseCaseDiagramRenderer.class);
//#endif 


//#if -281329889 
public FigNode getFigNodeFor(GraphModel gm, Layer lay, Object node,
                                 Map styleAttributes)
    { 

//#if 536267763 
FigNodeModelElement figNode = null;
//#endif 


//#if 1376878170 
ArgoDiagram diag = DiagramUtils.getActiveDiagram();
//#endif 


//#if 1593498704 
if(diag instanceof UMLDiagram
                && ((UMLDiagram) diag).doesAccept(node))//1
{ 

//#if -1809445061 
figNode =
                (FigNodeModelElement) ((UMLDiagram) diag).drop(node, null);
//#endif 

} 
else
{ 

//#if 1814454128 
LOG.debug(this.getClass().toString()
                      + ": getFigNodeFor(" + gm.toString() + ", "
                      + lay.toString() + ", " + node.toString()
                      + ") - cannot create this sort of node.");
//#endif 


//#if -823771952 
return null;
//#endif 

} 

//#endif 


//#if -73311176 
lay.add(figNode);
//#endif 


//#if -175417762 
figNode.setDiElement(
            GraphChangeAdapter.getInstance().createElement(gm, node));
//#endif 


//#if -1078963020 
return figNode;
//#endif 

} 

//#endif 


//#if -1504212208 
public FigEdge getFigEdgeFor(GraphModel gm, Layer lay, Object edge,
                                 Map styleAttributes)
    { 

//#if 1014347764 
if(LOG.isDebugEnabled())//1
{ 

//#if -1524704296 
LOG.debug("making figedge for " + edge);
//#endif 

} 

//#endif 


//#if 883682197 
if(edge == null)//1
{ 

//#if -427652384 
throw new IllegalArgumentException("A model edge must be supplied");
//#endif 

} 

//#endif 


//#if 1954452407 
DiagramSettings settings = ((ArgoDiagram) ((LayerPerspective) lay)
                                    .getDiagram()).getDiagramSettings();
//#endif 


//#if -1676047147 
FigEdge newEdge = null;
//#endif 


//#if 2059231105 
if(Model.getFacade().isAAssociation(edge))//1
{ 

//#if -102651322 
newEdge = new FigAssociation(edge, settings);
//#endif 

} 
else

//#if 42143898 
if(Model.getFacade().isAGeneralization(edge))//1
{ 

//#if 951731907 
newEdge = new FigGeneralization(edge, settings);
//#endif 

} 
else

//#if 2114845653 
if(Model.getFacade().isAExtend(edge))//1
{ 

//#if -1710723376 
newEdge = new FigExtend(edge, settings);
//#endif 


//#if 278858569 
Object base = Model.getFacade().getBase(edge);
//#endif 


//#if -1935536231 
Object extension = Model.getFacade().getExtension(edge);
//#endif 


//#if 477765917 
FigNode baseFN = (FigNode) lay.presentationFor(base);
//#endif 


//#if -550772087 
FigNode extensionFN = (FigNode) lay.presentationFor(extension);
//#endif 


//#if 1143670078 
newEdge.setSourcePortFig(extensionFN);
//#endif 


//#if 605096033 
newEdge.setSourceFigNode(extensionFN);
//#endif 


//#if 338039277 
newEdge.setDestPortFig(baseFN);
//#endif 


//#if 2008900842 
newEdge.setDestFigNode(baseFN);
//#endif 

} 
else

//#if -152893715 
if(Model.getFacade().isAInclude(edge))//1
{ 

//#if -2128982371 
newEdge = new FigInclude(edge, settings);
//#endif 


//#if 534327804 
Object base = Model.getFacade().getBase(edge);
//#endif 


//#if -842557402 
Object addition = Model.getFacade().getAddition(edge);
//#endif 


//#if -2114243184 
FigNode baseFN = (FigNode) lay.presentationFor(base);
//#endif 


//#if -1515687578 
FigNode additionFN = (FigNode) lay.presentationFor(addition);
//#endif 


//#if -1509758695 
newEdge.setSourcePortFig(baseFN);
//#endif 


//#if 161102870 
newEdge.setSourceFigNode(baseFN);
//#endif 


//#if -878927541 
newEdge.setDestPortFig(additionFN);
//#endif 


//#if 489172424 
newEdge.setDestFigNode(additionFN);
//#endif 

} 
else

//#if -1303130261 
if(Model.getFacade().isADependency(edge))//1
{ 

//#if 1309292092 
newEdge = new FigDependency(edge, settings);
//#endif 


//#if -1772889318 
Object supplier =
                ((Model.getFacade().getSuppliers(edge).toArray())[0]);
//#endif 


//#if 512240860 
Object client =
                ((Model.getFacade().getClients(edge).toArray())[0]);
//#endif 


//#if 46801080 
FigNode supplierFN = (FigNode) lay.presentationFor(supplier);
//#endif 


//#if -1765956170 
FigNode clientFN = (FigNode) lay.presentationFor(client);
//#endif 


//#if -1023817531 
newEdge.setSourcePortFig(clientFN);
//#endif 


//#if -1643622270 
newEdge.setSourceFigNode(clientFN);
//#endif 


//#if 1911583565 
newEdge.setDestPortFig(supplierFN);
//#endif 


//#if -1015283766 
newEdge.setDestFigNode(supplierFN);
//#endif 

} 
else

//#if -1963423551 
if(edge instanceof CommentEdge)//1
{ 

//#if -161583701 
newEdge = new FigEdgeNote(edge, settings);
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#if 806354659 
if(newEdge == null)//1
{ 

//#if -1086298430 
throw new IllegalArgumentException(
                "Don't know how to create FigEdge for model type "
                + edge.getClass().getName());
//#endif 

} 
else
{ 

//#if -1853987709 
setPorts(lay, newEdge);
//#endif 

} 

//#endif 


//#if 103276124 
lay.add(newEdge);
//#endif 


//#if 1103346512 
newEdge.setLayer(lay);
//#endif 


//#if 718690000 
return newEdge;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

