
//#if -49392040 
// Compilation Unit of /FigHistoryState.java 
 

//#if -749172092 
package org.argouml.uml.diagram.state.ui;
//#endif 


//#if 1645574141 
import java.awt.Color;
//#endif 


//#if -1214131983 
import java.awt.Rectangle;
//#endif 


//#if -1640235859 
import java.awt.event.MouseEvent;
//#endif 


//#if -1557837386 
import java.util.Iterator;
//#endif 


//#if -1423572274 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 1985454871 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if 582287794 
import org.tigris.gef.presentation.FigCircle;
//#endif 


//#if -1449727307 
import org.tigris.gef.presentation.FigText;
//#endif 


//#if 1720914438 
public abstract class FigHistoryState extends 
//#if 103979314 
FigStateVertex
//#endif 

  { 

//#if 1682870997 
private static final int X = X0;
//#endif 


//#if 1683795479 
private static final int Y = Y0;
//#endif 


//#if 150884217 
private static final int WIDTH = 24;
//#endif 


//#if -831900308 
private static final int HEIGHT = 24;
//#endif 


//#if -269139070 
private FigText h;
//#endif 


//#if -1555606519 
private FigCircle head;
//#endif 


//#if 1937665135 
static final long serialVersionUID = 6572261327347541373L;
//#endif 


//#if 1646070356 
@Override
    public String placeString()
    { 

//#if 483326870 
return "H";
//#endif 

} 

//#endif 


//#if -422327119 
@Override
    public void setLineWidth(int w)
    { 

//#if -1774521089 
head.setLineWidth(w);
//#endif 

} 

//#endif 


//#if 2131809816 
@Override
    public int getLineWidth()
    { 

//#if -836760909 
return head.getLineWidth();
//#endif 

} 

//#endif 


//#if -1552096327 
@Override
    public void setLineColor(Color col)
    { 

//#if 1788529223 
head.setLineColor(col);
//#endif 

} 

//#endif 


//#if 386155073 
@Override
    public boolean isFilled()
    { 

//#if -650335781 
return true;
//#endif 

} 

//#endif 


//#if 1570053577 
@Override
    public Color getLineColor()
    { 

//#if -965702433 
return head.getLineColor();
//#endif 

} 

//#endif 


//#if -100510713 

//#if -760478562 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigHistoryState()
    { 

//#if 485241357 
initFigs();
//#endif 

} 

//#endif 


//#if -1898428070 
@Override
    public Color getFillColor()
    { 

//#if 387868387 
return head.getFillColor();
//#endif 

} 

//#endif 


//#if -243088383 
public FigHistoryState(Object owner, Rectangle bounds,
                           DiagramSettings settings)
    { 

//#if -1916578676 
super(owner, bounds, settings);
//#endif 


//#if 1814853729 
initFigs();
//#endif 

} 

//#endif 


//#if 1700645622 
private void initFigs()
    { 

//#if 122867868 
setEditable(false);
//#endif 


//#if -395732337 
setBigPort(new FigCircle(X, Y, WIDTH, HEIGHT, DEBUG_COLOR,
                                 DEBUG_COLOR));
//#endif 


//#if -46288317 
head = new FigCircle(X, Y, WIDTH, HEIGHT, LINE_COLOR, FILL_COLOR);
//#endif 


//#if -859597181 
h = new FigText(X, Y, WIDTH - 10, HEIGHT - 10);
//#endif 


//#if -1174199968 
h.setFont(getSettings().getFontPlain());
//#endif 


//#if -1406662821 
h.setText(getH());
//#endif 


//#if -395798118 
h.setTextColor(TEXT_COLOR);
//#endif 


//#if 927482388 
h.setFilled(false);
//#endif 


//#if 180967047 
h.setLineWidth(0);
//#endif 


//#if 205459724 
addFig(getBigPort());
//#endif 


//#if -642345920 
addFig(head);
//#endif 


//#if -25685716 
addFig(h);
//#endif 


//#if -553133170 
setBlinkPorts(false);
//#endif 

} 

//#endif 


//#if -278434146 
@Override
    public void mouseClicked(MouseEvent me)
    { 
} 

//#endif 


//#if -1842790274 

//#if 1306172232 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigHistoryState(@SuppressWarnings("unused") GraphModel gm,
                           Object node)
    { 

//#if -1188331557 
this();
//#endif 


//#if -1194260182 
setOwner(node);
//#endif 

} 

//#endif 


//#if -2118849589 
@Override
    public Object clone()
    { 

//#if -1741018618 
FigHistoryState figClone = (FigHistoryState) super.clone();
//#endif 


//#if -620710500 
Iterator it = figClone.getFigs().iterator();
//#endif 


//#if 1612678583 
figClone.setBigPort((FigCircle) it.next());
//#endif 


//#if -488592158 
figClone.head = (FigCircle) it.next();
//#endif 


//#if -1706087247 
figClone.h = (FigText) it.next();
//#endif 


//#if -371110341 
return figClone;
//#endif 

} 

//#endif 


//#if -701618893 
protected abstract String getH();
//#endif 


//#if -847395890 
@Override
    public boolean isResizable()
    { 

//#if 385014341 
return false;
//#endif 

} 

//#endif 


//#if 1529343562 
@Override
    public void setFillColor(Color col)
    { 

//#if -809756538 
head.setFillColor(col);
//#endif 

} 

//#endif 


//#if -250987170 
@Override
    protected void setStandardBounds(int x, int y,
                                     int width, int height)
    { 

//#if 185305950 
if(getNameFig() == null)//1
{ 

//#if 727922284 
return;
//#endif 

} 

//#endif 


//#if -1332041825 
Rectangle oldBounds = getBounds();
//#endif 


//#if 371880825 
getBigPort().setBounds(x, y, WIDTH, HEIGHT);
//#endif 


//#if 1943248325 
head.setBounds(x, y, WIDTH, HEIGHT);
//#endif 


//#if -321691489 
this.h.setBounds(x, y, WIDTH - 10, HEIGHT - 10);
//#endif 


//#if 1440674842 
this.h.calcBounds();
//#endif 


//#if 1342029040 
calcBounds();
//#endif 


//#if -2003224083 
updateEdges();
//#endif 


//#if 238823404 
firePropChange("bounds", oldBounds, getBounds());
//#endif 

} 

//#endif 


//#if -924381505 
@Override
    public void setFilled(boolean f)
    { 
} 

//#endif 

 } 

//#endif 


//#endif 

