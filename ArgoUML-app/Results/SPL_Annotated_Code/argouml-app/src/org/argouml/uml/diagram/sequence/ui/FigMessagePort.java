// Compilation Unit of /FigMessagePort.java 
 
package org.argouml.uml.diagram.sequence.ui;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.argouml.uml.diagram.sequence.MessageNode;
import org.argouml.uml.diagram.ui.ArgoFigGroup;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigLine;
public class FigMessagePort extends ArgoFigGroup
  { 
private static final long serialVersionUID = -7805833566723101923L;
private static final Logger LOG = Logger.getLogger(FigMessagePort.class);
private MessageNode node;
void setNode(MessageNode n)
    { 
node = n;
} 

protected void setBoundsImpl(int x, int y, int w, int h)
    { 
if(w != 20)//1
{ 
throw new IllegalArgumentException();
} 

if(getFigs().size() > 0)//1
{ 
getMyLine().setShape(x, y, x + w, y);
calcBounds();
} 

} 

public FigMessagePort(Object owner)
    { 
setVisible(false);
setOwner(owner);
} 

public void calcBounds()
    { 
if(getFigs().size() > 0)//1
{ 
FigLine line = getMyLine();
_x = line.getX();
_y = line.getY();
_w = line.getWidth();
_h = 1;
firePropChange("bounds", null, null);
} 

} 

private FigLine getMyLine()
    { 
return (FigLine) getFigs().get(0);
} 

public int getY1()
    { 
return getMyLine().getY1();
} 

public List getGravityPoints()
    { 
ArrayList ret = new ArrayList();
FigLine myLine = getMyLine();
Point p1 = new Point(myLine.getX(), myLine.getY());
Point p2 =
            new Point(myLine.getX() + myLine.getWidth(),
                      myLine.getY() + myLine.getHeight());
ret.add(p1);
ret.add(p2);
return ret;
} 

public FigMessagePort(Object owner, int x, int y, int x2)
    { 
super();
setOwner(owner);
FigLine myLine = new FigLine(x, y, x2, y, LINE_COLOR);
addFig(myLine);
setVisible(false);
} 

public void addFig(Fig toAdd)
    { 
if(!(toAdd instanceof FigLine))//1
{ 
throw new IllegalArgumentException("Unexpect Fig " + toAdd);
} 

if(getFigs().size() == 0)//1
{ 
toAdd.setVisible(false);
super.addFig(toAdd);
} 
else
{ 
} 

} 

MessageNode getNode()
    { 
if(node == null)//1
{ 
((FigClassifierRole) this.getGroup().getGroup())
            .setMatchingNode(this);
} 

return node;
} 

 } 


