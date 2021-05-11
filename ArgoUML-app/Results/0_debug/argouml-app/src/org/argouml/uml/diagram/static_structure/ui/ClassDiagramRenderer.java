
//#if -1525635925 
// Compilation Unit of /ClassDiagramRenderer.java 
 

//#if 649247291 
package org.argouml.uml.diagram.static_structure.ui;
//#endif 


//#if 783657952 
import java.util.Collection;
//#endif 


//#if 1232108860 
import java.util.Map;
//#endif 


//#if 1275507870 
import org.apache.log4j.Logger;
//#endif 


//#if -287160369 
import org.argouml.model.CoreFactory;
//#endif 


//#if -1171922927 
import org.argouml.model.Model;
//#endif 


//#if -463170477 
import org.argouml.uml.CommentEdge;
//#endif 


//#if 1877176400 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if -372748 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 1087050267 
import org.argouml.uml.diagram.GraphChangeAdapter;
//#endif 


//#if -1680737334 
import org.argouml.uml.diagram.UmlDiagramRenderer;
//#endif 


//#if -446904786 
import org.argouml.uml.diagram.ui.FigAbstraction;
//#endif 


//#if 1892483507 
import org.argouml.uml.diagram.ui.FigAssociation;
//#endif 


//#if 23436139 
import org.argouml.uml.diagram.ui.FigAssociationClass;
//#endif 


//#if -1059130776 
import org.argouml.uml.diagram.ui.FigAssociationEnd;
//#endif 


//#if -1913411241 
import org.argouml.uml.diagram.ui.FigDependency;
//#endif 


//#if -1560668654 
import org.argouml.uml.diagram.ui.FigEdgeModelElement;
//#endif 


//#if -141778746 
import org.argouml.uml.diagram.ui.FigGeneralization;
//#endif 


//#if 480587245 
import org.argouml.uml.diagram.ui.FigNodeModelElement;
//#endif 


//#if 35325779 
import org.argouml.uml.diagram.ui.FigPermission;
//#endif 


//#if 646257491 
import org.argouml.uml.diagram.ui.FigUsage;
//#endif 


//#if 15085809 
import org.argouml.uml.diagram.ui.UMLDiagram;
//#endif 


//#if 879886530 
import org.tigris.gef.base.Diagram;
//#endif 


//#if -1770020220 
import org.tigris.gef.base.Layer;
//#endif 


//#if -629364810 
import org.tigris.gef.base.LayerPerspective;
//#endif 


//#if 1871083069 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if -93871029 
import org.tigris.gef.presentation.FigEdge;
//#endif 


//#if -85234522 
import org.tigris.gef.presentation.FigNode;
//#endif 


//#if -1398872011 
public class ClassDiagramRenderer extends 
//#if 660679405 
UmlDiagramRenderer
//#endif 

  { 

//#if 1586460519 
static final long serialVersionUID = 675407719309039112L;
//#endif 


//#if 505941953 
private static final Logger LOG =
        Logger.getLogger(ClassDiagramRenderer.class);
//#endif 


//#if -453973779 
public FigEdge getFigEdgeFor(GraphModel gm, Layer lay,
                                 Object edge, Map styleAttribute)
    { 

//#if -922948375 
if(LOG.isDebugEnabled())//1
{ 

//#if 327040566 
LOG.debug("making figedge for " + edge);
//#endif 

} 

//#endif 


//#if 359521994 
if(edge == null)//1
{ 

//#if 1333074502 
throw new IllegalArgumentException("A model edge must be supplied");
//#endif 

} 

//#endif 


//#if -123304781 
assert lay instanceof LayerPerspective;
//#endif 


//#if 36362272 
ArgoDiagram diag = (ArgoDiagram) ((LayerPerspective) lay).getDiagram();
//#endif 


//#if -1953546456 
DiagramSettings settings = diag.getDiagramSettings();
//#endif 


//#if -431566464 
FigEdge newEdge = null;
//#endif 


//#if 223431994 
if(Model.getFacade().isAAssociationClass(edge))//1
{ 

//#if 1749920415 
newEdge = new FigAssociationClass(edge, settings);
//#endif 

} 
else

//#if 32453477 
if(Model.getFacade().isAAssociationEnd(edge))//1
{ 

//#if -821707736 
FigAssociationEnd asend = new FigAssociationEnd(edge, settings);
//#endif 


//#if 1640354886 
Model.getFacade().getAssociation(edge);
//#endif 


//#if 982011195 
FigNode associationFN =
                (FigNode) lay.presentationFor(
                    Model.getFacade().getAssociation(edge));
//#endif 


//#if -1748520056 
FigNode classifierFN =
                (FigNode) lay.presentationFor(Model.getFacade().getType(edge));
//#endif 


//#if 2084494274 
asend.setSourcePortFig(associationFN);
//#endif 


//#if -89087451 
asend.setSourceFigNode(associationFN);
//#endif 


//#if 1823098491 
asend.setDestPortFig(classifierFN);
//#endif 


//#if -1987795016 
asend.setDestFigNode(classifierFN);
//#endif 


//#if 1807534966 
newEdge = asend;
//#endif 

} 
else

//#if 1413366914 
if(Model.getFacade().isAAssociation(edge))//1
{ 

//#if 232597584 
newEdge = new FigAssociation(edge, settings);
//#endif 

} 
else

//#if -1854165602 
if(Model.getFacade().isALink(edge))//1
{ 

//#if 1913553623 
FigLink lnkFig = new FigLink(edge, settings);
//#endif 


//#if 946644688 
Collection linkEndsColn = Model.getFacade().getConnections(edge);
//#endif 


//#if -1130801223 
Object[] linkEnds = linkEndsColn.toArray();
//#endif 


//#if 1902614740 
Object fromInst = Model.getFacade().getInstance(linkEnds[0]);
//#endif 


//#if -1989508092 
Object toInst = Model.getFacade().getInstance(linkEnds[1]);
//#endif 


//#if -673974702 
FigNode fromFN = (FigNode) lay.presentationFor(fromInst);
//#endif 


//#if 1062984052 
FigNode toFN = (FigNode) lay.presentationFor(toInst);
//#endif 


//#if -795095668 
lnkFig.setSourcePortFig(fromFN);
//#endif 


//#if 875765897 
lnkFig.setSourceFigNode(fromFN);
//#endif 


//#if 853296676 
lnkFig.setDestPortFig(toFN);
//#endif 


//#if -986303391 
lnkFig.setDestFigNode(toFN);
//#endif 


//#if 343749218 
lnkFig.getFig().setLayer(lay);
//#endif 


//#if -1650348025 
newEdge = lnkFig;
//#endif 

} 
else

//#if 1536645965 
if(Model.getFacade().isAGeneralization(edge))//1
{ 

//#if -1686318104 
newEdge = new FigGeneralization(edge, settings);
//#endif 

} 
else

//#if 360401573 
if(Model.getFacade().isAPackageImport(edge))//1
{ 

//#if 1312932751 
newEdge = new FigPermission(edge, settings);
//#endif 

} 
else

//#if 829496730 
if(Model.getFacade().isAUsage(edge))//1
{ 

//#if 1842276708 
newEdge = new FigUsage(edge, settings);
//#endif 

} 
else

//#if 513763334 
if(Model.getFacade().isAAbstraction(edge))//1
{ 

//#if -568477194 
newEdge = new FigAbstraction(edge, settings);
//#endif 

} 
else

//#if -290368680 
if(Model.getFacade().isADependency(edge))//1
{ 

//#if 1911566789 
String name = "";
//#endif 


//#if 72365400 
for (Object stereotype : Model.getFacade().getStereotypes(edge)) //1
{ 

//#if 1785270325 
name = Model.getFacade().getName(stereotype);
//#endif 


//#if -94162612 
if(CoreFactory.REALIZE_STEREOTYPE.equals(name))//1
{ 

//#if 708421836 
break;

//#endif 

} 

//#endif 

} 

//#endif 


//#if 204575725 
if(CoreFactory.REALIZE_STEREOTYPE.equals(name))//1
{ 

//#if 1944609345 
FigAbstraction realFig = new FigAbstraction(edge, settings);
//#endif 


//#if -559945433 
Object supplier =
                    ((Model.getFacade().getSuppliers(edge).toArray())[0]);
//#endif 


//#if 1744783721 
Object client =
                    ((Model.getFacade().getClients(edge).toArray())[0]);
//#endif 


//#if -1895971965 
FigNode supFN = (FigNode) lay.presentationFor(supplier);
//#endif 


//#if -544383020 
FigNode cliFN = (FigNode) lay.presentationFor(client);
//#endif 


//#if -1116837244 
realFig.setSourcePortFig(cliFN);
//#endif 


//#if 1985102823 
realFig.setSourceFigNode(cliFN);
//#endif 


//#if 426892747 
realFig.setDestPortFig(supFN);
//#endif 


//#if -766134482 
realFig.setDestFigNode(supFN);
//#endif 


//#if 529802960 
realFig.getFig().setLayer(lay);
//#endif 


//#if 1283172121 
newEdge = realFig;
//#endif 

} 
else
{ 

//#if -72989139 
FigDependency depFig = new FigDependency(edge, settings);
//#endif 


//#if 117080797 
newEdge = depFig;
//#endif 

} 

//#endif 

} 
else

//#if -2136021659 
if(edge instanceof CommentEdge)//1
{ 

//#if 160437409 
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


//#endif 


//#endif 


//#endif 


//#if 2050835342 
if(newEdge == null)//1
{ 

//#if -1562090157 
throw new IllegalArgumentException(
                "Don't know how to create FigEdge for model type "
                + edge.getClass().getName());
//#endif 

} 

//#endif 


//#if 168047164 
setPorts(lay, newEdge);
//#endif 


//#if -1642378248 
assert newEdge != null : "There has been no FigEdge created";
//#endif 


//#if 177096538 
assert newEdge != null : "There has been no FigEdge created";
//#endif 


//#if -1076956753 
assert (newEdge.getDestFigNode() != null)
        : "The FigEdge has no dest node";
//#endif 


//#if -1169849973 
assert (newEdge.getDestPortFig() != null)
        : "The FigEdge has no dest port";
//#endif 


//#if -1018318065 
assert (newEdge.getSourceFigNode() != null)
        : "The FigEdge has no source node";
//#endif 


//#if 357986219 
assert (newEdge.getSourcePortFig() != null)
        : "The FigEdge has no source port";
//#endif 


//#if -420884079 
lay.add(newEdge);
//#endif 


//#if 1590900667 
return newEdge;
//#endif 

} 

//#endif 


//#if 34599393 
public FigNode getFigNodeFor(GraphModel gm, Layer lay,
                                 Object node, Map styleAttributes)
    { 

//#if -223263446 
FigNodeModelElement figNode = null;
//#endif 


//#if 890907830 
if(node == null)//1
{ 

//#if 238935460 
throw new IllegalArgumentException("A node must be supplied");
//#endif 

} 

//#endif 


//#if 1064230861 
Diagram diag = ((LayerPerspective) lay).getDiagram();
//#endif 


//#if 1757103623 
if(diag instanceof UMLDiagram
                && ((UMLDiagram) diag).doesAccept(node))//1
{ 

//#if 664002977 
figNode = (FigNodeModelElement) ((UMLDiagram) diag)
                      .drop(node, null);
//#endif 

} 
else
{ 

//#if -1291958044 
LOG.error("TODO: ClassDiagramRenderer getFigNodeFor " + node);
//#endif 


//#if -1149798040 
throw new IllegalArgumentException(
                "Node is not a recognised type. Received "
                + node.getClass().getName());
//#endif 

} 

//#endif 


//#if -1406108703 
lay.add(figNode);
//#endif 


//#if 202917717 
figNode.setDiElement(
            GraphChangeAdapter.getInstance().createElement(gm, node));
//#endif 


//#if 1740668331 
return figNode;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

