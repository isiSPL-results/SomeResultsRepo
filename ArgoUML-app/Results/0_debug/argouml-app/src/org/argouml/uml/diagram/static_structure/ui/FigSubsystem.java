
//#if 166298169 
// Compilation Unit of /FigSubsystem.java 
 

//#if 659457727 
package org.argouml.uml.diagram.static_structure.ui;
//#endif 


//#if -688230428 
import java.awt.Polygon;
//#endif 


//#if 1716339087 
import java.awt.Rectangle;
//#endif 


//#if -309739280 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -1532714183 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if -351335656 
import org.tigris.gef.presentation.FigPoly;
//#endif 


//#if 483967078 
public class FigSubsystem extends 
//#if 426104648 
FigPackage
//#endif 

  { 

//#if -1528935703 
private FigPoly figPoly = new FigPoly(LINE_COLOR, SOLID_FILL_COLOR);
//#endif 


//#if 1305757403 
@Override
    protected void setStandardBounds(int x, int y, int w, int h)
    { 

//#if 103885848 
if(figPoly != null)//1
{ 

//#if 557184808 
Rectangle oldBounds = getBounds();
//#endif 


//#if -1040957518 
figPoly.translate((x - oldBounds.x) + (w - oldBounds.width), y
                              - oldBounds.y);
//#endif 

} 

//#endif 


//#if 356841679 
super.setStandardBounds(x, y, w, h);
//#endif 

} 

//#endif 


//#if 1769688175 

//#if -436540425 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigSubsystem(Object modelElement, int x, int y)
    { 

//#if -746573223 
super(modelElement, x, y);
//#endif 


//#if -1084343070 
constructFigs();
//#endif 

} 

//#endif 


//#if 141445622 
private void constructFigs()
    { 

//#if 253080816 
int[] xpoints = {125, 125, 130, 130, 130, 135, 135};
//#endif 


//#if 2089191901 
int[] ypoints = {45, 40, 40, 35, 40, 40, 45};
//#endif 


//#if 1539683937 
Polygon polygon = new Polygon(xpoints, ypoints, 7);
//#endif 


//#if -1293937520 
figPoly.setPolygon(polygon);
//#endif 


//#if -2023794179 
figPoly.setFilled(false);
//#endif 


//#if -262355213 
addFig(figPoly);
//#endif 


//#if -792344941 
Rectangle r = getBounds();
//#endif 


//#if 285586461 
setBounds(r.x, r.y, r.width, r.height);
//#endif 


//#if 1911077315 
updateEdges();
//#endif 

} 

//#endif 


//#if 1118604377 
@Deprecated
    public FigSubsystem(@SuppressWarnings("unused") GraphModel gm,
                        Object node)
    { 

//#if 1379754086 
this(node, 0, 0);
//#endif 

} 

//#endif 


//#if -1338165218 
public FigSubsystem(Object owner, Rectangle bounds,
                        DiagramSettings settings)
    { 

//#if -165137826 
super(owner, bounds, settings);
//#endif 


//#if 1297374556 
constructFigs();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

