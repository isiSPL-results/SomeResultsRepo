package org.argouml.uml.diagram.static_structure.layout;
import org.argouml.uml.diagram.layout.LayoutedEdge;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigEdge;
import org.tigris.gef.presentation.FigPoly;
public abstract class ClassdiagramEdge implements LayoutedEdge
  { 
private static int vGap;
private static int hGap;
private FigEdge currentEdge = null;
private FigPoly underlyingFig = null;
private Fig destFigNode;
private Fig sourceFigNode;
public static int getHGap()
    { 
return hGap;
} 
Fig getDestFigNode()
    { 
return destFigNode;
} 
public abstract void layout();Fig getSourceFigNode()
    { 
return sourceFigNode;
} 
protected FigPoly getUnderlyingFig()
    { 
return underlyingFig;
} 
protected FigEdge getCurrentEdge()
    { 
return currentEdge;
} 
public static int getVGap()
    { 
return vGap;
} 
public static void setHGap(int h)
    { 
hGap = h;
} 
public static void setVGap(int v)
    { 
vGap = v;
} 
public ClassdiagramEdge(FigEdge edge)
    { 
currentEdge = edge;
underlyingFig = new FigPoly();
underlyingFig.setLineColor(edge.getFig().getLineColor());
destFigNode = edge.getDestFigNode();
sourceFigNode = edge.getSourceFigNode();
} 

 } 
