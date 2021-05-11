
//#if 1667135353 
// Compilation Unit of /ClassdiagramEdge.java 
 

//#if 521798937 
package org.argouml.uml.diagram.static_structure.layout;
//#endif 


//#if 527304364 
import org.argouml.uml.diagram.layout.LayoutedEdge;
//#endif 


//#if 906107860 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -303824617 
import org.tigris.gef.presentation.FigEdge;
//#endif 


//#if -293332760 
import org.tigris.gef.presentation.FigPoly;
//#endif 


//#if -1160474335 
public abstract class ClassdiagramEdge implements 
//#if -1837899343 
LayoutedEdge
//#endif 

  { 

//#if 444687698 
private static int vGap;
//#endif 


//#if 431758404 
private static int hGap;
//#endif 


//#if 837141988 
private FigEdge currentEdge = null;
//#endif 


//#if 1189857670 
private FigPoly underlyingFig = null;
//#endif 


//#if -2026150717 
private Fig destFigNode;
//#endif 


//#if -1789515204 
private Fig sourceFigNode;
//#endif 


//#if -190071624 
public static int getHGap()
    { 

//#if -55702494 
return hGap;
//#endif 

} 

//#endif 


//#if -1294139896 
Fig getDestFigNode()
    { 

//#if -948869479 
return destFigNode;
//#endif 

} 

//#endif 


//#if 2036148213 
public abstract void layout();
//#endif 


//#if 1817837551 
Fig getSourceFigNode()
    { 

//#if 1010513399 
return sourceFigNode;
//#endif 

} 

//#endif 


//#if -845923585 
protected FigPoly getUnderlyingFig()
    { 

//#if 1285921083 
return underlyingFig;
//#endif 

} 

//#endif 


//#if -388980641 
protected FigEdge getCurrentEdge()
    { 

//#if 1785232956 
return currentEdge;
//#endif 

} 

//#endif 


//#if 210736490 
public static int getVGap()
    { 

//#if -1770163735 
return vGap;
//#endif 

} 

//#endif 


//#if -1565732670 
public static void setHGap(int h)
    { 

//#if -573340339 
hGap = h;
//#endif 

} 

//#endif 


//#if -21954010 
public static void setVGap(int v)
    { 

//#if 886973443 
vGap = v;
//#endif 

} 

//#endif 


//#if -2070130649 
public ClassdiagramEdge(FigEdge edge)
    { 

//#if 978167914 
currentEdge = edge;
//#endif 


//#if 702094727 
underlyingFig = new FigPoly();
//#endif 


//#if 474801505 
underlyingFig.setLineColor(edge.getFig().getLineColor());
//#endif 


//#if 641699809 
destFigNode = edge.getDestFigNode();
//#endif 


//#if -57078381 
sourceFigNode = edge.getSourceFigNode();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

