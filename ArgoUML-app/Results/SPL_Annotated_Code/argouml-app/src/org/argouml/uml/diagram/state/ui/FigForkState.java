// Compilation Unit of /FigForkState.java 
 
package org.argouml.uml.diagram.state.ui;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import org.argouml.uml.diagram.DiagramSettings;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.presentation.FigRect;
public class FigForkState extends FigStateVertex
  { 
private static final int X = X0;
private static final int Y = Y0;
private static final int STATE_WIDTH = 80;
private static final int HEIGHT = 7;
private FigRect head;
static final long serialVersionUID = 6702818473439087473L;
@Override
    public int getLineWidth()
    { 
return head.getLineWidth();
} 

@Override
    public void setLineWidth(int w)
    { 
head.setLineWidth(w);
} 

@Override
    public void setLineColor(Color col)
    { 
head.setLineColor(col);
} 

@SuppressWarnings("deprecation")

    @Deprecated
    public FigForkState(@SuppressWarnings("unused") GraphModel gm,
                        Object node)
    { 
this();
setOwner(node);
} 

@Override
    public Color getLineColor()
    { 
return head.getLineColor();
} 

@Override
    public Object clone()
    { 
FigForkState figClone = (FigForkState) super.clone();
Iterator it = figClone.getFigs().iterator();
figClone.setBigPort((FigRect) it.next());
figClone.head = (FigRect) it.next();
return figClone;
} 

@Override
    public void mouseClicked(MouseEvent me)
    { 
} 

@SuppressWarnings("deprecation")

    @Deprecated
    public FigForkState()
    { 
super();
initFigs();
} 

@Override
    protected void setStandardBounds(int x, int y, int w, int h)
    { 
Rectangle oldBounds = getBounds();
if(w > h)//1
{ 
h = HEIGHT;
} 
else
{ 
w = HEIGHT;
} 

getBigPort().setBounds(x, y, w, h);
head.setBounds(x, y, w, h);
calcBounds();
updateEdges();
firePropChange("bounds", oldBounds, getBounds());
} 

public FigForkState(Object owner, Rectangle bounds,
                        DiagramSettings settings)
    { 
super(owner, bounds, settings);
initFigs();
} 

private void initFigs()
    { 
setEditable(false);
setBigPort(new FigRect(X, Y, STATE_WIDTH, HEIGHT, DEBUG_COLOR,
                               DEBUG_COLOR));
head = new FigRect(X, Y, STATE_WIDTH, HEIGHT, LINE_COLOR,
                           SOLID_FILL_COLOR);
addFig(getBigPort());
addFig(head);
setBlinkPorts(false);
} 

@Override
    public void setFilled(boolean f)
    { 
} 

@Override
    public Color getFillColor()
    { 
return head.getFillColor();
} 

@Override
    public boolean isFilled()
    { 
return true;
} 

@Override
    public void setFillColor(Color col)
    { 
head.setFillColor(col);
} 

 } 


