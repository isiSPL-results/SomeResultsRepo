
//#if -1520842327 
// Compilation Unit of /FigForkState.java 
 

//#if 1866386435 
package org.argouml.uml.diagram.state.ui;
//#endif 


//#if -1322540834 
import java.awt.Color;
//#endif 


//#if -876175022 
import java.awt.Rectangle;
//#endif 


//#if -1436603092 
import java.awt.event.MouseEvent;
//#endif 


//#if -1219880425 
import java.util.Iterator;
//#endif 


//#if -170989299 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 93206614 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if -455718243 
import org.tigris.gef.presentation.FigRect;
//#endif 


//#if -377346711 
public class FigForkState extends 
//#if 610479641 
FigStateVertex
//#endif 

  { 

//#if -1300495044 
private static final int X = X0;
//#endif 


//#if -1299570562 
private static final int Y = Y0;
//#endif 


//#if 1889983388 
private static final int STATE_WIDTH = 80;
//#endif 


//#if 1738655800 
private static final int HEIGHT = 7;
//#endif 


//#if 108998254 
private FigRect head;
//#endif 


//#if -694606655 
static final long serialVersionUID = 6702818473439087473L;
//#endif 


//#if -2038259905 
@Override
    public int getLineWidth()
    { 

//#if 179887140 
return head.getLineWidth();
//#endif 

} 

//#endif 


//#if 514106346 
@Override
    public void setLineWidth(int w)
    { 

//#if -1450691409 
head.setLineWidth(w);
//#endif 

} 

//#endif 


//#if 1278047858 
@Override
    public void setLineColor(Color col)
    { 

//#if -508578740 
head.setLineColor(col);
//#endif 

} 

//#endif 


//#if -333366505 

//#if -1773895198 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigForkState(@SuppressWarnings("unused") GraphModel gm,
                        Object node)
    { 

//#if -1890499173 
this();
//#endif 


//#if 1991577322 
setOwner(node);
//#endif 

} 

//#endif 


//#if 1337538864 
@Override
    public Color getLineColor()
    { 

//#if -1936129671 
return head.getLineColor();
//#endif 

} 

//#endif 


//#if -95461262 
@Override
    public Object clone()
    { 

//#if -1817262741 
FigForkState figClone = (FigForkState) super.clone();
//#endif 


//#if 1775461119 
Iterator it = figClone.getFigs().iterator();
//#endif 


//#if -1032549176 
figClone.setBigPort((FigRect) it.next());
//#endif 


//#if 140450033 
figClone.head = (FigRect) it.next();
//#endif 


//#if 1997828446 
return figClone;
//#endif 

} 

//#endif 


//#if -743572265 
@Override
    public void mouseClicked(MouseEvent me)
    { 
} 

//#endif 


//#if -849176864 

//#if -654521461 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigForkState()
    { 

//#if -828635310 
super();
//#endif 


//#if 1131804328 
initFigs();
//#endif 

} 

//#endif 


//#if -1379066403 
@Override
    protected void setStandardBounds(int x, int y, int w, int h)
    { 

//#if 1994661111 
Rectangle oldBounds = getBounds();
//#endif 


//#if -1111942394 
if(w > h)//1
{ 

//#if -2115869400 
h = HEIGHT;
//#endif 

} 
else
{ 

//#if -1707173838 
w = HEIGHT;
//#endif 

} 

//#endif 


//#if -621323341 
getBigPort().setBounds(x, y, w, h);
//#endif 


//#if -465087513 
head.setBounds(x, y, w, h);
//#endif 


//#if 1283872840 
calcBounds();
//#endif 


//#if 488901013 
updateEdges();
//#endif 


//#if 2136993092 
firePropChange("bounds", oldBounds, getBounds());
//#endif 

} 

//#endif 


//#if 429632348 
public FigForkState(Object owner, Rectangle bounds,
                        DiagramSettings settings)
    { 

//#if -591821264 
super(owner, bounds, settings);
//#endif 


//#if -618886395 
initFigs();
//#endif 

} 

//#endif 


//#if -615631825 
private void initFigs()
    { 

//#if 1752617228 
setEditable(false);
//#endif 


//#if -283689595 
setBigPort(new FigRect(X, Y, STATE_WIDTH, HEIGHT, DEBUG_COLOR,
                               DEBUG_COLOR));
//#endif 


//#if -1452753087 
head = new FigRect(X, Y, STATE_WIDTH, HEIGHT, LINE_COLOR,
                           SOLID_FILL_COLOR);
//#endif 


//#if -1268468356 
addFig(getBigPort());
//#endif 


//#if -465590096 
addFig(head);
//#endif 


//#if -2027061250 
setBlinkPorts(false);
//#endif 

} 

//#endif 


//#if -1959715162 
@Override
    public void setFilled(boolean f)
    { 
} 

//#endif 


//#if -2130942783 
@Override
    public Color getFillColor()
    { 

//#if -768964280 
return head.getFillColor();
//#endif 

} 

//#endif 


//#if 511052648 
@Override
    public boolean isFilled()
    { 

//#if 1964286413 
return true;
//#endif 

} 

//#endif 


//#if 64520451 
@Override
    public void setFillColor(Color col)
    { 

//#if 200464113 
head.setFillColor(col);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

