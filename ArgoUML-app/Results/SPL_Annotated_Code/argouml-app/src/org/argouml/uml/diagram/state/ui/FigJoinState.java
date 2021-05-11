// Compilation Unit of /FigJoinState.java 
 
package org.argouml.uml.diagram.state.ui;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import org.argouml.uml.diagram.DiagramSettings;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.presentation.FigRect;
public class FigJoinState extends FigStateVertex
  { 
private static final int X = X0;
private static final int Y = Y0;
private static final int STATE_WIDTH = 80;
private static final int HEIGHT = 7;
private FigRect head;
static final long serialVersionUID = 2075803883819230367L;
@SuppressWarnings("deprecation")

    @Deprecated
    public FigJoinState()
    { 
super();
initFigs();
} 

@Override
    public void setLineColor(Color col)
    { 
head.setLineColor(col);
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

@Override
    public void setFillColor(Color col)
    { 
head.setFillColor(col);
} 

@Override
    public void setFilled(boolean f)
    { 
} 

@Override
    public int getLineWidth()
    { 
return head.getLineWidth();
} 

@Override
    public void mouseClicked(MouseEvent me)
    { 
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
    public Object clone()
    { 
FigJoinState figClone = (FigJoinState) super.clone();
Iterator it = figClone.getFigs().iterator();
figClone.setBigPort((FigRect) it.next());
figClone.head = (FigRect) it.next();
return figClone;
} 

@Override
    public void setLineWidth(int w)
    { 
head.setLineWidth(w);
} 

@Override
    public boolean isFilled()
    { 
return true;
} 

@Override
    public Color getLineColor()
    { 
return head.getLineColor();
} 

@SuppressWarnings("deprecation")

    @Deprecated
    public FigJoinState(@SuppressWarnings("unused") GraphModel gm,
                        Object node)
    { 
this();
setOwner(node);
} 

@Override
    public Color getFillColor()
    { 
return head.getFillColor();
} 

public FigJoinState(Object owner, Rectangle bounds,
                        DiagramSettings settings)
    { 
super(owner, bounds, settings);
initFigs();
} 

 } 


