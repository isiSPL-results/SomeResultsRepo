
//#if 1240483155 
// Compilation Unit of /FigAssociationClass.java 
 

//#if -1867664466 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -1860060144 
import java.awt.Color;
//#endif 


//#if 1073206148 
import java.awt.Rectangle;
//#endif 


//#if 729500745 
import java.util.Iterator;
//#endif 


//#if 492988441 
import java.util.List;
//#endif 


//#if 767050943 
import org.argouml.uml.diagram.AttributesCompartmentContainer;
//#endif 


//#if 516909595 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -1203473078 
import org.argouml.uml.diagram.OperationsCompartmentContainer;
//#endif 


//#if 1619846293 
import org.argouml.uml.diagram.PathContainer;
//#endif 


//#if -1659732757 
import org.tigris.gef.base.Layer;
//#endif 


//#if -540497361 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 456766029 
import org.tigris.gef.presentation.FigNode;
//#endif 


//#if 458621379 
import org.tigris.gef.presentation.FigPoly;
//#endif 


//#if 462028930 
import org.tigris.gef.presentation.FigText;
//#endif 


//#if 282792139 
public class FigAssociationClass extends 
//#if -1015028432 
FigAssociation
//#endif 

 implements 
//#if -1116041831 
AttributesCompartmentContainer
//#endif 

, 
//#if -534555607 
PathContainer
//#endif 

, 
//#if -1179607122 
OperationsCompartmentContainer
//#endif 

  { 

//#if 1984214792 
private static final long serialVersionUID = 3643715304027095083L;
//#endif 


//#if -316771381 
public void setOperationsVisible(boolean visible)
    { 

//#if 2024305833 
if(getAssociationClass() != null)//1
{ 

//#if 466279178 
getAssociationClass().setOperationsVisible(visible);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1730801390 
protected void createNameLabel(Object owner, DiagramSettings settings)
    { 
} 

//#endif 


//#if -125834242 

//#if -1048778093 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigAssociationClass(Object ed, Layer lay)
    { 

//#if 675983966 
this();
//#endif 


//#if 475123931 
setLayer(lay);
//#endif 


//#if 66018890 
setOwner(ed);
//#endif 

} 

//#endif 


//#if 434655160 
public boolean isPathVisible()
    { 

//#if -1043037075 
if(getAssociationClass() != null)//1
{ 

//#if 461855515 
return getAssociationClass().isPathVisible();
//#endif 

} 
else
{ 

//#if 1994245964 
return false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 528841312 
@Override
    protected FigText getNameFig()
    { 

//#if 1465282073 
return null;
//#endif 

} 

//#endif 


//#if 234384748 
@Override
    public Color getFillColor()
    { 

//#if -1013326613 
if(getAssociationClass() != null)//1
{ 

//#if -714580125 
return getAssociationClass().getFillColor();
//#endif 

} 
else
{ 

//#if -144999305 
return FILL_COLOR;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1266486191 
public boolean isOperationsVisible()
    { 

//#if 1178453974 
if(getAssociationClass() != null)//1
{ 

//#if 1287745261 
return getAssociationClass().isOperationsVisible();
//#endif 

} 
else
{ 

//#if 183715972 
return true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1146469902 
public void setPathVisible(boolean visible)
    { 

//#if -1957314140 
if(getAssociationClass() != null)//1
{ 

//#if -614166995 
getAssociationClass().setPathVisible(visible);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1216095088 
public Rectangle getAttributesBounds()
    { 

//#if 167992136 
if(getAssociationClass() != null)//1
{ 

//#if -1355585634 
return getAssociationClass().getAttributesBounds();
//#endif 

} 
else
{ 

//#if -935600568 
return new Rectangle(0, 0, 0, 0);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1289873704 
public FigAssociationClass(Object element, DiagramSettings settings)
    { 

//#if -979988366 
super(element, settings);
//#endif 


//#if -303973843 
setBetweenNearestPoints(true);
//#endif 


//#if -1617548414 
((FigPoly) getFig()).setRectilinear(false);
//#endif 


//#if -2075642944 
setDashed(false);
//#endif 

} 

//#endif 


//#if -723764736 
public void setAttributesVisible(boolean visible)
    { 

//#if -1885523694 
if(getAssociationClass() != null)//1
{ 

//#if -491141903 
getAssociationClass().setAttributesVisible(visible);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 920185013 
@Override
    public void setFillColor(Color color)
    { 

//#if -1675672448 
if(getAssociationClass() != null)//1
{ 

//#if 769732950 
getAssociationClass().setFillColor(color);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2037102311 
public FigClassAssociationClass getAssociationClass()
    { 

//#if -1356588399 
FigEdgeAssociationClass figEdgeLink = null;
//#endif 


//#if 2121001400 
List edges = null;
//#endif 


//#if -1057722672 
FigEdgePort figEdgePort = this.getEdgePort();
//#endif 


//#if 1997751225 
if(figEdgePort != null)//1
{ 

//#if 1874792476 
edges = figEdgePort.getFigEdges();
//#endif 

} 

//#endif 


//#if -2011105779 
if(edges != null)//1
{ 

//#if 748609760 
for (Iterator it = edges.iterator(); it.hasNext()
                    && figEdgeLink == null;) //1
{ 

//#if -297121208 
Object o = it.next();
//#endif 


//#if 1646592569 
if(o instanceof FigEdgeAssociationClass)//1
{ 

//#if 1302620734 
figEdgeLink = (FigEdgeAssociationClass) o;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -46593409 
FigNode figClassBox = null;
//#endif 


//#if -38201358 
if(figEdgeLink != null)//1
{ 

//#if -1922008049 
figClassBox = figEdgeLink.getDestFigNode();
//#endif 


//#if -1469974703 
if(!(figClassBox instanceof FigClassAssociationClass))//1
{ 

//#if 617237559 
figClassBox = figEdgeLink.getSourceFigNode();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1645570687 
return (FigClassAssociationClass) figClassBox;
//#endif 

} 

//#endif 


//#if 89957925 
public Rectangle getOperationsBounds()
    { 

//#if 1068922520 
if(getAssociationClass() != null)//1
{ 

//#if -2046572539 
return getAssociationClass().getOperationsBounds();
//#endif 

} 
else
{ 

//#if 558147312 
return new Rectangle(0, 0, 0, 0);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1119192919 
@Override
    public void setFig(Fig f)
    { 

//#if 1698906779 
super.setFig(f);
//#endif 


//#if -683278633 
getFig().setDashed(false);
//#endif 

} 

//#endif 


//#if 225416765 
@Override
    protected void removeFromDiagramImpl()
    { 

//#if -1001945803 
FigEdgeAssociationClass figEdgeLink = null;
//#endif 


//#if 1114140308 
List edges = null;
//#endif 


//#if 2053562664 
FigEdgePort figEdgePort = getEdgePort();
//#endif 


//#if 1007187549 
if(figEdgePort != null)//1
{ 

//#if 1847072109 
edges = figEdgePort.getFigEdges();
//#endif 

} 

//#endif 


//#if -1358302287 
if(edges != null)//1
{ 

//#if -2056562591 
for (Iterator it = edges.iterator(); it.hasNext()
                    && figEdgeLink == null;) //1
{ 

//#if -480652251 
Object o = it.next();
//#endif 


//#if -1895583812 
if(o instanceof FigEdgeAssociationClass)//1
{ 

//#if 1335725562 
figEdgeLink = (FigEdgeAssociationClass) o;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1028765034 
if(figEdgeLink != null)//1
{ 

//#if -312739658 
FigNode figClassBox = figEdgeLink.getDestFigNode();
//#endif 


//#if -1063954420 
if(!(figClassBox instanceof FigClassAssociationClass))//1
{ 

//#if 1004958030 
figClassBox = figEdgeLink.getSourceFigNode();
//#endif 

} 

//#endif 


//#if 466433649 
figEdgeLink.removeFromDiagramImpl();
//#endif 


//#if -13947812 
((FigClassAssociationClass) figClassBox).removeFromDiagramImpl();
//#endif 

} 

//#endif 


//#if -1005743997 
super.removeFromDiagramImpl();
//#endif 

} 

//#endif 


//#if 1459773695 
public FigEdgeAssociationClass getFigEdgeAssociationClass()
    { 

//#if 1388087294 
FigEdgeAssociationClass figEdgeLink = null;
//#endif 


//#if -1817476181 
List edges = null;
//#endif 


//#if -534301443 
FigEdgePort figEdgePort = this.getEdgePort();
//#endif 


//#if -1626985690 
if(figEdgePort != null)//1
{ 

//#if -587405842 
edges = figEdgePort.getFigEdges();
//#endif 

} 

//#endif 


//#if 1014838074 
if(edges != null)//1
{ 

//#if 7524938 
for (Iterator it = edges.iterator(); it.hasNext()
                    && figEdgeLink == null;) //1
{ 

//#if -1612703743 
Object o = it.next();
//#endif 


//#if 360240224 
if(o instanceof FigEdgeAssociationClass)//1
{ 

//#if -902173953 
figEdgeLink = (FigEdgeAssociationClass) o;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -307216396 
return figEdgeLink;
//#endif 

} 

//#endif 


//#if 1195543366 
public boolean isAttributesVisible()
    { 

//#if -1909685855 
if(getAssociationClass() != null)//1
{ 

//#if -985983433 
return getAssociationClass().isAttributesVisible();
//#endif 

} 
else
{ 

//#if 161329668 
return true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 932225489 
@Override
    public void setLineColor(Color arg0)
    { 

//#if -1356448669 
super.setLineColor(arg0);
//#endif 


//#if 1565224383 
if(getAssociationClass() != null)//1
{ 

//#if 1777654949 
getAssociationClass().setLineColor(arg0);
//#endif 

} 

//#endif 


//#if -862943160 
if(getFigEdgeAssociationClass() != null)//1
{ 

//#if 281202949 
getFigEdgeAssociationClass().setLineColor(arg0);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -674890445 

//#if 1465730497 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigAssociationClass()
    { 

//#if -840985160 
super();
//#endif 


//#if 1392881862 
setBetweenNearestPoints(true);
//#endif 


//#if -590871397 
((FigPoly) getFig()).setRectilinear(false);
//#endif 


//#if -379946873 
setDashed(false);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

