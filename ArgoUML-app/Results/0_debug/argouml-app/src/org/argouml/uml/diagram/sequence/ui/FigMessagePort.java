
//#if 2129415828 
// Compilation Unit of /FigMessagePort.java 
 

//#if -873243930 
package org.argouml.uml.diagram.sequence.ui;
//#endif 


//#if 1958449622 
import java.awt.Point;
//#endif 


//#if -865802539 
import java.util.ArrayList;
//#endif 


//#if -355557780 
import java.util.List;
//#endif 


//#if 541799378 
import org.apache.log4j.Logger;
//#endif 


//#if -98244708 
import org.argouml.uml.diagram.sequence.MessageNode;
//#endif 


//#if -1138113008 
import org.argouml.uml.diagram.ui.ArgoFigGroup;
//#endif 


//#if -1730444228 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -68683224 
import org.tigris.gef.presentation.FigLine;
//#endif 


//#if 1676883495 
public class FigMessagePort extends 
//#if -1311491979 
ArgoFigGroup
//#endif 

  { 

//#if -497053778 
private static final long serialVersionUID = -7805833566723101923L;
//#endif 


//#if -2082807055 
private static final Logger LOG = Logger.getLogger(FigMessagePort.class);
//#endif 


//#if 1593854706 
private MessageNode node;
//#endif 


//#if 1214567979 
void setNode(MessageNode n)
    { 

//#if 1234487327 
node = n;
//#endif 

} 

//#endif 


//#if 193747613 
protected void setBoundsImpl(int x, int y, int w, int h)
    { 

//#if 330193998 
if(w != 20)//1
{ 

//#if -1595500407 
throw new IllegalArgumentException();
//#endif 

} 

//#endif 


//#if 1134353039 
if(getFigs().size() > 0)//1
{ 

//#if -2029881042 
getMyLine().setShape(x, y, x + w, y);
//#endif 


//#if 1166583436 
calcBounds();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1901441807 
public FigMessagePort(Object owner)
    { 

//#if 1429445423 
setVisible(false);
//#endif 


//#if 627463680 
setOwner(owner);
//#endif 

} 

//#endif 


//#if 710262313 
public void calcBounds()
    { 

//#if -698093916 
if(getFigs().size() > 0)//1
{ 

//#if -980885988 
FigLine line = getMyLine();
//#endif 


//#if 1553004283 
_x = line.getX();
//#endif 


//#if 1047475449 
_y = line.getY();
//#endif 


//#if -688256946 
_w = line.getWidth();
//#endif 


//#if -149566697 
_h = 1;
//#endif 


//#if -1679357707 
firePropChange("bounds", null, null);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1696294433 
private FigLine getMyLine()
    { 

//#if 604949376 
return (FigLine) getFigs().get(0);
//#endif 

} 

//#endif 


//#if 578202026 
public int getY1()
    { 

//#if -963367639 
return getMyLine().getY1();
//#endif 

} 

//#endif 


//#if 1573586884 
public List getGravityPoints()
    { 

//#if 1480675906 
ArrayList ret = new ArrayList();
//#endif 


//#if 1533197211 
FigLine myLine = getMyLine();
//#endif 


//#if -334528081 
Point p1 = new Point(myLine.getX(), myLine.getY());
//#endif 


//#if -466276995 
Point p2 =
            new Point(myLine.getX() + myLine.getWidth(),
                      myLine.getY() + myLine.getHeight());
//#endif 


//#if 1004988345 
ret.add(p1);
//#endif 


//#if 1004989306 
ret.add(p2);
//#endif 


//#if -185804900 
return ret;
//#endif 

} 

//#endif 


//#if 1440735281 
public FigMessagePort(Object owner, int x, int y, int x2)
    { 

//#if -1700667558 
super();
//#endif 


//#if -2044958007 
setOwner(owner);
//#endif 


//#if 405769240 
FigLine myLine = new FigLine(x, y, x2, y, LINE_COLOR);
//#endif 


//#if -1142149348 
addFig(myLine);
//#endif 


//#if 1622647224 
setVisible(false);
//#endif 

} 

//#endif 


//#if -1734861408 
public void addFig(Fig toAdd)
    { 

//#if 238980415 
if(!(toAdd instanceof FigLine))//1
{ 

//#if -1237321225 
throw new IllegalArgumentException("Unexpect Fig " + toAdd);
//#endif 

} 

//#endif 


//#if -656502455 
if(getFigs().size() == 0)//1
{ 

//#if -966332783 
toAdd.setVisible(false);
//#endif 


//#if -1019593262 
super.addFig(toAdd);
//#endif 

} 
else
{ 
} 

//#endif 

} 

//#endif 


//#if -1661181039 
MessageNode getNode()
    { 

//#if -1106341184 
if(node == null)//1
{ 

//#if -1579574440 
((FigClassifierRole) this.getGroup().getGroup())
            .setMatchingNode(this);
//#endif 

} 

//#endif 


//#if 1144677101 
return node;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

