
//#if 698692663 
// Compilation Unit of /DeploymentDiagramRenderer.java 
 

//#if 2047726365 
package org.argouml.uml.diagram.deployment.ui;
//#endif 


//#if -6614497 
import java.util.Collection;
//#endif 


//#if 769658845 
import java.util.Map;
//#endif 


//#if -1015270913 
import org.apache.log4j.Logger;
//#endif 


//#if 832265586 
import org.argouml.model.Model;
//#endif 


//#if -2144700108 
import org.argouml.uml.CommentEdge;
//#endif 


//#if -1179982799 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if 1865608021 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -2009360183 
import org.argouml.uml.diagram.UmlDiagramRenderer;
//#endif 


//#if -1952773722 
import org.argouml.uml.diagram.static_structure.ui.FigEdgeNote;
//#endif 


//#if 1575606107 
import org.argouml.uml.diagram.static_structure.ui.FigLink;
//#endif 


//#if -196327212 
import org.argouml.uml.diagram.ui.FigAssociation;
//#endif 


//#if 900374762 
import org.argouml.uml.diagram.ui.FigAssociationClass;
//#endif 


//#if 961891239 
import org.argouml.uml.diagram.ui.FigAssociationEnd;
//#endif 


//#if 97417750 
import org.argouml.uml.diagram.ui.FigDependency;
//#endif 


//#if 1879243269 
import org.argouml.uml.diagram.ui.FigGeneralization;
//#endif 


//#if -157273966 
import org.argouml.uml.diagram.ui.UMLDiagram;
//#endif 


//#if -801643101 
import org.tigris.gef.base.Diagram;
//#endif 


//#if 109792165 
import org.tigris.gef.base.Layer;
//#endif 


//#if -912019467 
import org.tigris.gef.base.LayerPerspective;
//#endif 


//#if 974979742 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if 1143937068 
import org.tigris.gef.presentation.FigEdge;
//#endif 


//#if 1152573575 
import org.tigris.gef.presentation.FigNode;
//#endif 


//#if 1146097179 
public class DeploymentDiagramRenderer extends 
//#if -1665200247 
UmlDiagramRenderer
//#endif 

  { 

//#if -1587204176 
static final long serialVersionUID = 8002278834226522224L;
//#endif 


//#if -489640702 
private static final Logger LOG =
        Logger.getLogger(DeploymentDiagramRenderer.class);
//#endif 


//#if -496705866 
public FigEdge getFigEdgeFor(
        GraphModel gm,
        Layer lay,
        Object edge,
        Map styleAttributes)
    { 

//#if 756838446 
assert lay instanceof LayerPerspective;
//#endif 


//#if 2005645915 
ArgoDiagram diag = (ArgoDiagram) ((LayerPerspective) lay).getDiagram();
//#endif 


//#if -432408733 
DiagramSettings settings = diag.getDiagramSettings();
//#endif 


//#if 1807815419 
FigEdge newEdge = null;
//#endif 


//#if 1744569717 
if(Model.getFacade().isAAssociationClass(edge))//1
{ 

//#if -1241884121 
newEdge = new FigAssociationClass(edge, settings);
//#endif 

} 
else

//#if -517468072 
if(Model.getFacade().isAAssociation(edge))//1
{ 

//#if -193803597 
newEdge = new FigAssociation(edge, settings);
//#endif 

} 
else

//#if -2101009901 
if(Model.getFacade().isAAssociationEnd(edge))//1
{ 

//#if -1647868339 
FigAssociationEnd asend = new FigAssociationEnd(edge, settings);
//#endif 


//#if -1530633493 
Model.getFacade().getAssociation(edge);
//#endif 


//#if -1794736522 
FigNode associationFN =
                (FigNode) lay.presentationFor(Model
                                              .getFacade().getAssociation(edge));
//#endif 


//#if 1725714371 
FigNode classifierFN =
                (FigNode) lay.presentationFor(Model
                                              .getFacade().getType(edge));
//#endif 


//#if 596731005 
asend.setSourcePortFig(associationFN);
//#endif 


//#if -1576850720 
asend.setSourceFigNode(associationFN);
//#endif 


//#if -1063522400 
asend.setDestPortFig(classifierFN);
//#endif 


//#if -579448611 
asend.setDestFigNode(classifierFN);
//#endif 


//#if 1825707313 
newEdge = asend;
//#endif 

} 
else

//#if 588238942 
if(Model.getFacade().isALink(edge))//1
{ 

//#if -556119214 
FigLink lnkFig = new FigLink(edge, settings);
//#endif 


//#if -1089808899 
Collection linkEnds = Model.getFacade().getConnections(edge);
//#endif 


//#if -912924986 
Object[] leArray = linkEnds.toArray();
//#endif 


//#if 210032660 
Object fromEnd = leArray[0];
//#endif 


//#if -1092961878 
Object fromInst = Model.getFacade().getInstance(fromEnd);
//#endif 


//#if -39274460 
Object toEnd = leArray[1];
//#endif 


//#if 1701516682 
Object toInst = Model.getFacade().getInstance(toEnd);
//#endif 


//#if -1745023561 
FigNode fromFN = (FigNode) lay.presentationFor(fromInst);
//#endif 


//#if -962958503 
FigNode toFN = (FigNode) lay.presentationFor(toInst);
//#endif 


//#if -1616297721 
lnkFig.setSourcePortFig(fromFN);
//#endif 


//#if 54563844 
lnkFig.setSourceFigNode(fromFN);
//#endif 


//#if -1836273889 
lnkFig.setDestPortFig(toFN);
//#endif 


//#if 619093340 
lnkFig.setDestFigNode(toFN);
//#endif 


//#if -810333396 
newEdge = lnkFig;
//#endif 

} 
else

//#if 812657558 
if(Model.getFacade().isADependency(edge))//1
{ 

//#if -597813147 
FigDependency depFig = new FigDependency(edge, settings);
//#endif 


//#if 823249226 
Object supplier =
                ((Model.getFacade().getSuppliers(edge).toArray())[0]);
//#endif 


//#if 475312908 
Object client =
                ((Model.getFacade().getClients(edge).toArray())[0]);
//#endif 


//#if -938578688 
FigNode supFN = (FigNode) lay.presentationFor(supplier);
//#endif 


//#if 180634769 
FigNode cliFN = (FigNode) lay.presentationFor(client);
//#endif 


//#if 165686480 
depFig.setSourcePortFig(cliFN);
//#endif 


//#if -1027340749 
depFig.setSourceFigNode(cliFN);
//#endif 


//#if -1547189481 
depFig.setDestPortFig(supFN);
//#endif 


//#if 1554750586 
depFig.setDestFigNode(supFN);
//#endif 


//#if -1666847972 
depFig.getFig().setDashed(true);
//#endif 


//#if -10269275 
newEdge = depFig;
//#endif 

} 
else

//#if -574770261 
if(Model.getFacade().isAGeneralization(edge))//1
{ 

//#if 147514044 
newEdge = new FigGeneralization(edge, settings);
//#endif 

} 
else

//#if -75163278 
if(edge instanceof CommentEdge)//1
{ 

//#if -1203545991 
newEdge = new FigEdgeNote(edge, settings);
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#if -4750071 
if(newEdge == null)//1
{ 

//#if 2078151232 
throw new IllegalArgumentException(
                "Don't know how to create FigEdge for model type "
                + edge.getClass().getName());
//#endif 

} 

//#endif 


//#if 435421431 
setPorts(lay, newEdge);
//#endif 


//#if -1731749091 
assert newEdge != null : "There has been no FigEdge created";
//#endif 


//#if 1341873172 
assert (newEdge.getDestFigNode() != null)
        : "The FigEdge has no dest node";
//#endif 


//#if 1248979952 
assert (newEdge.getDestPortFig() != null)
        : "The FigEdge has no dest port";
//#endif 


//#if 952394484 
assert (newEdge.getSourceFigNode() != null)
        : "The FigEdge has no source node";
//#endif 


//#if -1966268528 
assert (newEdge.getSourcePortFig() != null)
        : "The FigEdge has no source port";
//#endif 


//#if 79460854 
lay.add(newEdge);
//#endif 


//#if -1752239754 
return newEdge;
//#endif 

} 

//#endif 


//#if 726176453 
public FigNode getFigNodeFor(
        GraphModel gm,
        Layer lay,
        Object node,
        Map styleAttributes)
    { 

//#if -1845096939 
FigNode figNode = null;
//#endif 


//#if 2090435253 
Diagram diag = ((LayerPerspective) lay).getDiagram();
//#endif 


//#if -1952208353 
if(diag instanceof UMLDiagram
                && ((UMLDiagram) diag).doesAccept(node))//1
{ 

//#if -1513724734 
figNode = ((UMLDiagram) diag).drop(node, null);
//#endif 

} 
else
{ 

//#if 723311105 
LOG.debug("TODO: DeploymentDiagramRenderer getFigNodeFor");
//#endif 


//#if 941095946 
return null;
//#endif 

} 

//#endif 


//#if -10436919 
lay.add(figNode);
//#endif 


//#if 1143563203 
return figNode;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

