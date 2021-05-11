
//#if 979876753 
// Compilation Unit of /FigNodeAssociation.java 
 

//#if -306918968 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -745618506 
import java.awt.Color;
//#endif 


//#if -260122861 
import java.awt.Dimension;
//#endif 


//#if -273901526 
import java.awt.Rectangle;
//#endif 


//#if -501882817 
import java.util.Collection;
//#endif 


//#if -617606929 
import java.util.Iterator;
//#endif 


//#if 1607430079 
import java.util.List;
//#endif 


//#if -493593774 
import org.argouml.model.Model;
//#endif 


//#if -1862740098 
import org.argouml.model.RemoveAssociationEvent;
//#endif 


//#if 1675569797 
import org.argouml.model.UmlChangeEvent;
//#endif 


//#if -1523308235 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 1040072213 
import org.tigris.gef.base.LayerPerspective;
//#endif 


//#if -1613854001 
import org.tigris.gef.graph.GraphEdgeRenderer;
//#endif 


//#if -794156930 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if 1197089020 
import org.tigris.gef.graph.MutableGraphModel;
//#endif 


//#if 55074489 
import org.tigris.gef.presentation.FigDiamond;
//#endif 


//#if 1899644428 
import org.tigris.gef.presentation.FigEdge;
//#endif 


//#if 1908280935 
import org.tigris.gef.presentation.FigNode;
//#endif 


//#if 1913543836 
import org.tigris.gef.presentation.FigText;
//#endif 


//#if 1449139441 
public class FigNodeAssociation extends 
//#if 326824343 
FigNodeModelElement
//#endif 

  { 

//#if 330067576 
private static final int X = 0;
//#endif 


//#if 330097367 
private static final int Y = 0;
//#endif 


//#if -1935549430 
private FigDiamond head;
//#endif 


//#if 1399949016 
@Override
    public void setLineColor(Color col)
    { 

//#if 325134070 
head.setLineColor(col);
//#endif 

} 

//#endif 


//#if 476121455 
@Override
    protected void updateLayout(UmlChangeEvent mee)
    { 

//#if 877866466 
super.updateLayout(mee);
//#endif 


//#if -136266389 
if(mee.getSource() == getOwner()
                && mee instanceof RemoveAssociationEvent
                && "connection".equals(mee.getPropertyName())
                && Model.getFacade().getConnections(getOwner()).size() == 2)//1
{ 

//#if 1032818756 
reduceToBinary();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -594608179 
@Override
    public List getGravityPoints()
    { 

//#if -115421552 
return getBigPort().getGravityPoints();
//#endif 

} 

//#endif 


//#if -1919101104 
@Override
    public void setLineWidth(int w)
    { 

//#if 178233279 
head.setLineWidth(w);
//#endif 

} 

//#endif 


//#if -79734784 
@Override
    public void setFilled(boolean f)
    { 
} 

//#endif 


//#if -962239463 
@Override
    public int getLineWidth()
    { 

//#if 759201474 
return head.getLineWidth();
//#endif 

} 

//#endif 


//#if -1229882286 
public FigNodeAssociation(Object owner, Rectangle bounds,
                              DiagramSettings settings)
    { 

//#if 1808796705 
super(owner, bounds, settings);
//#endif 


//#if -160801994 
initFigs();
//#endif 

} 

//#endif 


//#if 1132550939 
@Override
    public Color getFillColor()
    { 

//#if -1897107032 
return head.getFillColor();
//#endif 

} 

//#endif 


//#if -1612023881 
@Override
    protected void setStandardBounds(int x, int y, int w, int h)
    { 

//#if 1203793048 
Rectangle oldBounds = getBounds();
//#endif 


//#if -1367603293 
Rectangle nm = getNameFig().getBounds();
//#endif 


//#if 1777006472 
getNameFig().setBounds(x + (w - nm.width) / 2,
                               y + h / 2 - nm.height / 2,
                               nm.width, nm.height);
//#endif 


//#if 609130276 
if(getStereotypeFig().isVisible())//1
{ 

//#if -1349153614 
getStereotypeFig().setBounds(x, y + h / 2 - 20, w, 15);
//#endif 


//#if 368629753 
int stereotypeHeight = getStereotypeFig().getMinimumSize().height;
//#endif 


//#if 1385865286 
getStereotypeFig().setBounds(
                x,
                y,
                w,
                stereotypeHeight);
//#endif 

} 

//#endif 


//#if -1572542618 
head.setBounds(x, y, w, h);
//#endif 


//#if 631570482 
getBigPort().setBounds(x, y, w, h);
//#endif 


//#if 711065129 
calcBounds();
//#endif 


//#if 1049811685 
firePropChange("bounds", oldBounds, getBounds());
//#endif 


//#if -88268844 
updateEdges();
//#endif 

} 

//#endif 


//#if 1271078616 
private void reduceToBinary()
    { 

//#if -1191822403 
final Object association = getOwner();
//#endif 


//#if 1074809714 
assert (Model.getFacade().getConnections(association).size() == 2);
//#endif 


//#if -107216270 
final Collection<FigEdge> existingEdges = getEdges();
//#endif 


//#if -1268031898 
for (Iterator<FigEdge> it = existingEdges.iterator(); it.hasNext(); ) //1
{ 

//#if -1193319404 
FigEdge edge = it.next();
//#endif 


//#if 59225763 
if(edge instanceof FigAssociationEnd)//1
{ 

//#if 36272684 
it.remove();
//#endif 

} 
else
{ 

//#if 49014499 
removeFigEdge(edge);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -526070464 
final LayerPerspective lay = (LayerPerspective) getLayer();
//#endif 


//#if -557668248 
final MutableGraphModel gm = (MutableGraphModel) lay.getGraphModel();
//#endif 


//#if 903248328 
gm.removeNode(association);
//#endif 


//#if -906151898 
removeFromDiagram();
//#endif 


//#if -896254809 
final GraphEdgeRenderer renderer =
            lay.getGraphEdgeRenderer();
//#endif 


//#if 362687423 
final FigAssociation figEdge = (FigAssociation) renderer.getFigEdgeFor(
                                           gm, lay, association, null);
//#endif 


//#if 427408977 
lay.add(figEdge);
//#endif 


//#if 2140853714 
gm.addEdge(association);
//#endif 


//#if 1538850311 
for (FigEdge edge : existingEdges) //1
{ 

//#if 1669696491 
figEdge.makeEdgePort();
//#endif 


//#if 1629070833 
if(edge.getDestFigNode() == this)//1
{ 

//#if 400626442 
edge.setDestFigNode(figEdge.getEdgePort());
//#endif 


//#if 1444831143 
edge.setDestPortFig(figEdge.getEdgePort());
//#endif 

} 

//#endif 


//#if 321582680 
if(edge.getSourceFigNode() == this)//1
{ 

//#if -2040208208 
edge.setSourceFigNode(figEdge.getEdgePort());
//#endif 


//#if -996003507 
edge.setSourcePortFig(figEdge.getEdgePort());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1185120906 
figEdge.computeRoute();
//#endif 

} 

//#endif 


//#if 1744478796 
@Override
    public Object clone()
    { 

//#if -437118717 
FigNodeAssociation figClone = (FigNodeAssociation) super.clone();
//#endif 


//#if -453908553 
Iterator it = figClone.getFigs().iterator();
//#endif 


//#if 1551280296 
figClone.setBigPort((FigDiamond) it.next());
//#endif 


//#if 713364857 
figClone.head = (FigDiamond) it.next();
//#endif 


//#if 1265970689 
figClone.setNameFig((FigText) it.next());
//#endif 


//#if -1223463914 
return figClone;
//#endif 

} 

//#endif 


//#if -1745489003 
private void initFigs()
    { 

//#if -990489118 
setEditable(false);
//#endif 


//#if 1678509601 
setBigPort(new FigDiamond(0, 0, 70, 70, DEBUG_COLOR, DEBUG_COLOR));
//#endif 


//#if 1028758641 
head = new FigDiamond(0, 0, 70, 70, LINE_COLOR, FILL_COLOR);
//#endif 


//#if -1744402184 
getNameFig().setFilled(false);
//#endif 


//#if 1064608547 
getNameFig().setLineWidth(0);
//#endif 


//#if -2128255775 
getStereotypeFig().setBounds(X + 10, Y + NAME_FIG_HEIGHT + 1,
                                     0, NAME_FIG_HEIGHT);
//#endif 


//#if 1340963889 
getStereotypeFig().setFilled(false);
//#endif 


//#if -1883904822 
getStereotypeFig().setLineWidth(0);
//#endif 


//#if -283747118 
addFig(getBigPort());
//#endif 


//#if 1688274438 
addFig(head);
//#endif 


//#if -1180433808 
if(!Model.getFacade().isAAssociationClass(getOwner()))//1
{ 

//#if 1926445397 
addFig(getNameFig());
//#endif 


//#if -130720754 
addFig(getStereotypeFig());
//#endif 

} 

//#endif 


//#if -1042340012 
setBlinkPorts(false);
//#endif 


//#if -1807182472 
Rectangle r = getBounds();
//#endif 


//#if 1197865986 
setBounds(r);
//#endif 


//#if -430010514 
setResizable(true);
//#endif 

} 

//#endif 


//#if 306065290 
@Override
    public Color getLineColor()
    { 

//#if -1375838323 
return head.getLineColor();
//#endif 

} 

//#endif 


//#if -362447571 

//#if 895416335 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigNodeAssociation(@SuppressWarnings("unused") GraphModel gm,
                              Object node)
    { 

//#if -1530223889 
this();
//#endif 


//#if -2047485890 
setOwner(node);
//#endif 

} 

//#endif 


//#if 186421609 
@Override
    public void setFillColor(Color col)
    { 

//#if 1557683854 
head.setFillColor(col);
//#endif 

} 

//#endif 


//#if 651045494 

//#if -1921297467 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigNodeAssociation()
    { 

//#if 1821709350 
super();
//#endif 


//#if -1129199276 
initFigs();
//#endif 

} 

//#endif 


//#if 1265669422 
@Override
    protected void removeFromDiagramImpl()
    { 

//#if -2106199270 
FigEdgeAssociationClass figEdgeLink = null;
//#endif 


//#if 841986829 
final List edges = getFigEdges();
//#endif 


//#if -910697642 
if(edges != null)//1
{ 

//#if -1560058656 
for (Iterator it = edges.iterator(); it.hasNext()
                    && figEdgeLink == null;) //1
{ 

//#if -1075031361 
Object o = it.next();
//#endif 


//#if 192111586 
if(o instanceof FigEdgeAssociationClass)//1
{ 

//#if 712009274 
figEdgeLink = (FigEdgeAssociationClass) o;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1064772219 
if(figEdgeLink != null)//1
{ 

//#if 1169171939 
FigNode figClassBox = figEdgeLink.getDestFigNode();
//#endif 


//#if -113676737 
if(!(figClassBox instanceof FigClassAssociationClass))//1
{ 

//#if -1176775301 
figClassBox = figEdgeLink.getSourceFigNode();
//#endif 

} 

//#endif 


//#if 1451360030 
figEdgeLink.removeFromDiagramImpl();
//#endif 


//#if 962682761 
((FigClassAssociationClass) figClassBox).removeFromDiagramImpl();
//#endif 

} 

//#endif 


//#if 948709544 
super.removeFromDiagramImpl();
//#endif 

} 

//#endif 


//#if -154906643 
@Override
    public Dimension getMinimumSize()
    { 

//#if 1853620171 
Dimension aSize = getNameFig().getMinimumSize();
//#endif 


//#if -59255778 
if(getStereotypeFig().isVisible())//1
{ 

//#if -1319314356 
Dimension stereoMin = getStereotypeFig().getMinimumSize();
//#endif 


//#if 1232312568 
aSize.width = Math.max(aSize.width, stereoMin.width);
//#endif 


//#if -1174194290 
aSize.height += stereoMin.height;
//#endif 

} 

//#endif 


//#if -777533069 
aSize.width = Math.max(70, aSize.width);
//#endif 


//#if -1396262617 
int size = Math.max(aSize.width, aSize.height);
//#endif 


//#if 1999402378 
aSize.width = size;
//#endif 


//#if -416096003 
aSize.height = size;
//#endif 


//#if 1419197398 
return aSize;
//#endif 

} 

//#endif 


//#if 1587073090 
@Override
    public boolean isFilled()
    { 

//#if -520758739 
return true;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

