
//#if -837585400 
// Compilation Unit of /FigModel.java 
 

//#if -926962750 
package org.argouml.uml.diagram.static_structure.ui;
//#endif 


//#if 1622288231 
import java.awt.Polygon;
//#endif 


//#if 1626678354 
import java.awt.Rectangle;
//#endif 


//#if 2011186701 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 1229755734 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if 939959989 
import org.tigris.gef.presentation.FigPoly;
//#endif 


//#if -701972573 
public class FigModel extends 
//#if 613612330 
FigPackage
//#endif 

  { 

//#if 396403147 
private FigPoly figPoly = new FigPoly(LINE_COLOR, SOLID_FILL_COLOR);
//#endif 


//#if 2040720957 
@Override
    protected void setStandardBounds(int x, int y, int w, int h)
    { 

//#if -2041650489 
if(figPoly != null)//1
{ 

//#if -1202158574 
Rectangle oldBounds = getBounds();
//#endif 


//#if 833604892 
figPoly.translate((x - oldBounds.x) + (w - oldBounds.width), y
                              - oldBounds.y);
//#endif 

} 

//#endif 


//#if -2143562112 
super.setStandardBounds(x, y, w, h);
//#endif 

} 

//#endif 


//#if -1997837864 
private void constructFigs()
    { 

//#if 2027488346 
int[] xpoints = {125, 130, 135, 125};
//#endif 


//#if 1704394907 
int[] ypoints = {45, 40, 45, 45};
//#endif 


//#if 681423603 
Polygon polygon = new Polygon(xpoints, ypoints, 4);
//#endif 


//#if 1888465947 
figPoly.setPolygon(polygon);
//#endif 


//#if -1294475694 
figPoly.setFilled(false);
//#endif 


//#if 254746366 
addFig(figPoly);
//#endif 


//#if 1104457260 
setBounds(getBounds());
//#endif 


//#if 418879630 
updateEdges();
//#endif 

} 

//#endif 


//#if 868607618 
public FigModel(Object owner, Rectangle bounds, DiagramSettings settings)
    { 

//#if 1290888833 
super(owner, bounds, settings);
//#endif 


//#if 1863986265 
constructFigs();
//#endif 

} 

//#endif 


//#if -907816975 
@Deprecated
    public FigModel(@SuppressWarnings("unused") GraphModel gm, Object node)
    { 

//#if 464780193 
this(node, 0, 0);
//#endif 

} 

//#endif 


//#if -2084482553 

//#if -871764799 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigModel(Object modelElement, int x, int y)
    { 

//#if 1505005460 
super(modelElement, x, y);
//#endif 


//#if -1189804771 
constructFigs();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

