
//#if 1902196802 
// Compilation Unit of /ClassdiagramInheritanceEdge.java 
 

//#if 939216327 
package org.argouml.uml.diagram.static_structure.layout;
//#endif 


//#if 1313596156 
import org.apache.log4j.Logger;
//#endif 


//#if -503879322 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -596363863 
import org.tigris.gef.presentation.FigEdge;
//#endif 


//#if 1041234773 
public abstract class ClassdiagramInheritanceEdge extends 
//#if -1991140588 
ClassdiagramEdge
//#endif 

  { 

//#if 1393665970 
private static final Logger LOG = Logger
                                      .getLogger(ClassdiagramInheritanceEdge.class);
//#endif 


//#if -974960313 
private static final int EPSILON = 5;
//#endif 


//#if 1103088404 
private Fig high, low;
//#endif 


//#if 1230558784 
private int offset;
//#endif 


//#if -2131899532 
public int getCenterLow()
    { 

//#if 1006233377 
return (int) (low.getLocation().getX() + low.getSize().width / 2)
               + getOffset();
//#endif 

} 

//#endif 


//#if 872290166 
public int getVerticalOffset()
    { 

//#if 2104393570 
return (getVGap() / 2) - 10 + getOffset();
//#endif 

} 

//#endif 


//#if -1983906999 
public int getDownGap()
    { 

//#if -438728214 
return (int) (low.getLocation().getY() - getVerticalOffset());
//#endif 

} 

//#endif 


//#if -1784848924 
public int getCenterHigh()
    { 

//#if -564099284 
return (int) (high.getLocation().getX() + high.getSize().width / 2)
               + getOffset();
//#endif 

} 

//#endif 


//#if -861213216 
public int getOffset()
    { 

//#if 664963257 
return offset;
//#endif 

} 

//#endif 


//#if 301959564 
public ClassdiagramInheritanceEdge(FigEdge edge)
    { 

//#if -1807707691 
super(edge);
//#endif 


//#if 577688010 
high = getDestFigNode();
//#endif 


//#if 744904675 
low = getSourceFigNode();
//#endif 


//#if 535656540 
offset = 0;
//#endif 

} 

//#endif 


//#if 1764831910 
public void setOffset(int anOffset)
    { 

//#if -1242497987 
offset = anOffset;
//#endif 

} 

//#endif 


//#if 888505188 
public void layout()
    { 

//#if -180419125 
Fig fig = getUnderlyingFig();
//#endif 


//#if -1297383197 
int centerHigh = getCenterHigh();
//#endif 


//#if -1215479229 
int centerLow = getCenterLow();
//#endif 


//#if 1872350210 
int difference = centerHigh - centerLow;
//#endif 


//#if -15890894 
if(Math.abs(difference) < EPSILON)//1
{ 

//#if -189722461 
fig.addPoint(centerLow + (difference / 2 + (difference % 2)),
                         (int) (low.getLocation().getY()));
//#endif 


//#if 680527737 
fig.addPoint(centerHigh - (difference / 2),
                         high.getLocation().y + high.getSize().height);
//#endif 

} 
else
{ 

//#if -1867590448 
fig.addPoint(centerLow, (int) (low.getLocation().getY()));
//#endif 


//#if 1487406495 
if(LOG.isDebugEnabled())//1
{ 

//#if 513009340 
LOG.debug("Point: x: " + centerLow + " y: "
                          + low.getLocation().y);
//#endif 

} 

//#endif 


//#if 939834558 
getUnderlyingFig().addPoint(centerHigh - difference, getDownGap());
//#endif 


//#if 823428914 
getUnderlyingFig().addPoint(centerHigh, getDownGap());
//#endif 


//#if 149376178 
if(LOG.isDebugEnabled())//2
{ 

//#if -633269313 
LOG.debug("Point: x: " + (centerHigh - difference) + " y: "
                          + getDownGap());
//#endif 


//#if -2038875238 
LOG.debug("Point: x: " + centerHigh + " y: " + getDownGap());
//#endif 

} 

//#endif 


//#if 1682321624 
fig.addPoint(centerHigh,
                         high.getLocation().y + high.getSize().height);
//#endif 


//#if 149405970 
if(LOG.isDebugEnabled())//3
{ 

//#if 1029684117 
LOG.debug("Point x: " + centerHigh + " y: "
                          + (high.getLocation().y + high.getSize().height));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1950532744 
fig.setFilled(false);
//#endif 


//#if 1772746812 
getCurrentEdge().setFig(getUnderlyingFig());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

