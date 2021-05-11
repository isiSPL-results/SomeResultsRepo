
//#if 1840836759 
// Compilation Unit of /FigEdgeHandler.java 
 

//#if -1584246116 
package org.argouml.persistence;
//#endif 


//#if -56840355 
import java.util.StringTokenizer;
//#endif 


//#if 1161079547 
import org.tigris.gef.persistence.pgml.PGMLStackParser;
//#endif 


//#if -1207662125 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -1393469546 
import org.tigris.gef.presentation.FigEdge;
//#endif 


//#if -1609849942 
import org.tigris.gef.presentation.FigEdgePoly;
//#endif 


//#if -1386849217 
import org.tigris.gef.presentation.FigLine;
//#endif 


//#if -1382977689 
import org.tigris.gef.presentation.FigPoly;
//#endif 


//#if -1550245655 
import org.xml.sax.SAXException;
//#endif 


//#if -1812441186 
class FigEdgeHandler extends 
//#if -1711884699 
org.tigris.gef.persistence.pgml.FigEdgeHandler
//#endif 

  { 

//#if -172973533 
public void addObject(Object o) throws SAXException
    { 

//#if 1914724902 
FigEdge edge = getFigEdge();
//#endif 


//#if 2013204923 
if(o instanceof FigLine || o instanceof FigPoly)//1
{ 

//#if -1574658281 
edge.setFig((Fig) o);
//#endif 


//#if 1509783930 
if(o instanceof FigPoly)//1
{ 

//#if -1599124181 
((FigPoly) o).setComplete(true);
//#endif 

} 

//#endif 


//#if -1291126771 
edge.calcBounds();
//#endif 


//#if -479285777 
if(edge instanceof FigEdgePoly)//1
{ 

//#if 399662316 
((FigEdgePoly) edge).setInitiallyLaidOut(true);
//#endif 

} 

//#endif 


//#if -277189717 
edge.updateAnnotationPositions();
//#endif 

} 

//#endif 


//#if -1354724653 
if(o instanceof String)//1
{ 

//#if -380744528 
PGMLStackParser parser = getPGMLStackParser();
//#endif 


//#if 535731140 
String body = (String) o;
//#endif 


//#if 858163164 
StringTokenizer st2 = new StringTokenizer(body, "=\"' \t\n");
//#endif 


//#if -1129959380 
String sourcePortFig = null;
//#endif 


//#if 916696133 
String destPortFig = null;
//#endif 


//#if -496564657 
String sourceFigNode = null;
//#endif 


//#if 1550090856 
String destFigNode = null;
//#endif 


//#if 1330312217 
while (st2.hasMoreElements()) //1
{ 

//#if -1944888692 
String attribute = st2.nextToken();
//#endif 


//#if 781010263 
String value = st2.nextToken();
//#endif 


//#if -2064481398 
if(attribute.equals("sourcePortFig"))//1
{ 

//#if -123468955 
sourcePortFig = value;
//#endif 

} 

//#endif 


//#if 1297672483 
if(attribute.equals("destPortFig"))//1
{ 

//#if -212666914 
destPortFig = value;
//#endif 

} 

//#endif 


//#if -1431086675 
if(attribute.equals("sourceFigNode"))//1
{ 

//#if -1590164426 
sourceFigNode = value;
//#endif 

} 

//#endif 


//#if 1931067206 
if(attribute.equals("destFigNode"))//1
{ 

//#if -126545746 
destFigNode = value;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 782808501 
((org.argouml.persistence.PGMLStackParser) parser).addFigEdge(
                edge,
                sourcePortFig,
                destPortFig,
                sourceFigNode,
                destFigNode);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2053221949 
public FigEdgeHandler(PGMLStackParser parser, FigEdge theEdge)
    { 

//#if 16033352 
super(parser, theEdge);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

