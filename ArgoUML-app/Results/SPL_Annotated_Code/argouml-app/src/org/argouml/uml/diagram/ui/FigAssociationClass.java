// Compilation Unit of /FigAssociationClass.java 
 
package org.argouml.uml.diagram.ui;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.Iterator;
import java.util.List;
import org.argouml.uml.diagram.AttributesCompartmentContainer;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.OperationsCompartmentContainer;
import org.argouml.uml.diagram.PathContainer;
import org.tigris.gef.base.Layer;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigNode;
import org.tigris.gef.presentation.FigPoly;
import org.tigris.gef.presentation.FigText;
public class FigAssociationClass extends FigAssociation
 implements AttributesCompartmentContainer
, PathContainer
, OperationsCompartmentContainer
  { 
private static final long serialVersionUID = 3643715304027095083L;
public void setOperationsVisible(boolean visible)
    { 
if(getAssociationClass() != null)//1
{ 
getAssociationClass().setOperationsVisible(visible);
} 

} 

protected void createNameLabel(Object owner, DiagramSettings settings)
    { 
} 

@SuppressWarnings("deprecation")

    @Deprecated
    public FigAssociationClass(Object ed, Layer lay)
    { 
this();
setLayer(lay);
setOwner(ed);
} 

public boolean isPathVisible()
    { 
if(getAssociationClass() != null)//1
{ 
return getAssociationClass().isPathVisible();
} 
else
{ 
return false;
} 

} 

@Override
    protected FigText getNameFig()
    { 
return null;
} 

@Override
    public Color getFillColor()
    { 
if(getAssociationClass() != null)//1
{ 
return getAssociationClass().getFillColor();
} 
else
{ 
return FILL_COLOR;
} 

} 

public boolean isOperationsVisible()
    { 
if(getAssociationClass() != null)//1
{ 
return getAssociationClass().isOperationsVisible();
} 
else
{ 
return true;
} 

} 

public void setPathVisible(boolean visible)
    { 
if(getAssociationClass() != null)//1
{ 
getAssociationClass().setPathVisible(visible);
} 

} 

public Rectangle getAttributesBounds()
    { 
if(getAssociationClass() != null)//1
{ 
return getAssociationClass().getAttributesBounds();
} 
else
{ 
return new Rectangle(0, 0, 0, 0);
} 

} 

public FigAssociationClass(Object element, DiagramSettings settings)
    { 
super(element, settings);
setBetweenNearestPoints(true);
((FigPoly) getFig()).setRectilinear(false);
setDashed(false);
} 

public void setAttributesVisible(boolean visible)
    { 
if(getAssociationClass() != null)//1
{ 
getAssociationClass().setAttributesVisible(visible);
} 

} 

@Override
    public void setFillColor(Color color)
    { 
if(getAssociationClass() != null)//1
{ 
getAssociationClass().setFillColor(color);
} 

} 

public FigClassAssociationClass getAssociationClass()
    { 
FigEdgeAssociationClass figEdgeLink = null;
List edges = null;
FigEdgePort figEdgePort = this.getEdgePort();
if(figEdgePort != null)//1
{ 
edges = figEdgePort.getFigEdges();
} 

if(edges != null)//1
{ 
for (Iterator it = edges.iterator(); it.hasNext()
                    && figEdgeLink == null;) //1
{ 
Object o = it.next();
if(o instanceof FigEdgeAssociationClass)//1
{ 
figEdgeLink = (FigEdgeAssociationClass) o;
} 

} 

} 

FigNode figClassBox = null;
if(figEdgeLink != null)//1
{ 
figClassBox = figEdgeLink.getDestFigNode();
if(!(figClassBox instanceof FigClassAssociationClass))//1
{ 
figClassBox = figEdgeLink.getSourceFigNode();
} 

} 

return (FigClassAssociationClass) figClassBox;
} 

public Rectangle getOperationsBounds()
    { 
if(getAssociationClass() != null)//1
{ 
return getAssociationClass().getOperationsBounds();
} 
else
{ 
return new Rectangle(0, 0, 0, 0);
} 

} 

@Override
    public void setFig(Fig f)
    { 
super.setFig(f);
getFig().setDashed(false);
} 

@Override
    protected void removeFromDiagramImpl()
    { 
FigEdgeAssociationClass figEdgeLink = null;
List edges = null;
FigEdgePort figEdgePort = getEdgePort();
if(figEdgePort != null)//1
{ 
edges = figEdgePort.getFigEdges();
} 

if(edges != null)//1
{ 
for (Iterator it = edges.iterator(); it.hasNext()
                    && figEdgeLink == null;) //1
{ 
Object o = it.next();
if(o instanceof FigEdgeAssociationClass)//1
{ 
figEdgeLink = (FigEdgeAssociationClass) o;
} 

} 

} 

if(figEdgeLink != null)//1
{ 
FigNode figClassBox = figEdgeLink.getDestFigNode();
if(!(figClassBox instanceof FigClassAssociationClass))//1
{ 
figClassBox = figEdgeLink.getSourceFigNode();
} 

figEdgeLink.removeFromDiagramImpl();
((FigClassAssociationClass) figClassBox).removeFromDiagramImpl();
} 

super.removeFromDiagramImpl();
} 

public FigEdgeAssociationClass getFigEdgeAssociationClass()
    { 
FigEdgeAssociationClass figEdgeLink = null;
List edges = null;
FigEdgePort figEdgePort = this.getEdgePort();
if(figEdgePort != null)//1
{ 
edges = figEdgePort.getFigEdges();
} 

if(edges != null)//1
{ 
for (Iterator it = edges.iterator(); it.hasNext()
                    && figEdgeLink == null;) //1
{ 
Object o = it.next();
if(o instanceof FigEdgeAssociationClass)//1
{ 
figEdgeLink = (FigEdgeAssociationClass) o;
} 

} 

} 

return figEdgeLink;
} 

public boolean isAttributesVisible()
    { 
if(getAssociationClass() != null)//1
{ 
return getAssociationClass().isAttributesVisible();
} 
else
{ 
return true;
} 

} 

@Override
    public void setLineColor(Color arg0)
    { 
super.setLineColor(arg0);
if(getAssociationClass() != null)//1
{ 
getAssociationClass().setLineColor(arg0);
} 

if(getFigEdgeAssociationClass() != null)//1
{ 
getFigEdgeAssociationClass().setLineColor(arg0);
} 

} 

@SuppressWarnings("deprecation")

    @Deprecated
    public FigAssociationClass()
    { 
super();
setBetweenNearestPoints(true);
((FigPoly) getFig()).setRectilinear(false);
setDashed(false);
} 

 } 


