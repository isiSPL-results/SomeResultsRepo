
//#if 896119875 
// Compilation Unit of /FigTrace.java 
 

//#if 1196784705 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -524255075 
import java.awt.Color;
//#endif 


//#if 822027509 
import org.tigris.gef.presentation.ArrowHeadTriangle;
//#endif 


//#if -528148239 
import org.tigris.gef.presentation.FigEdgeLine;
//#endif 


//#if 368555582 
public class FigTrace extends 
//#if -412031674 
FigEdgeLine
//#endif 

  { 

//#if 1190782839 
static final long serialVersionUID = -2094146244090391544L;
//#endif 


//#if -1762443174 
public FigTrace()
    { 

//#if -262121802 
getFig().setLineColor(Color.red);
//#endif 


//#if -1915280283 
ArrowHeadTriangle endArrow = new ArrowHeadTriangle();
//#endif 


//#if 671562824 
endArrow.setFillColor(Color.red);
//#endif 


//#if 2114440797 
setDestArrowHead(endArrow);
//#endif 


//#if -1062448109 
setBetweenNearestPoints(true);
//#endif 

} 

//#endif 


//#if -2025851650 
public FigTrace(Object edge)
    { 

//#if -325295065 
this();
//#endif 


//#if 1668914801 
setOwner(edge);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

