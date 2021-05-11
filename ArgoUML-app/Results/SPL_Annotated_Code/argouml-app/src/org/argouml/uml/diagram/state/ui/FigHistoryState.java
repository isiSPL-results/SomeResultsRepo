// Compilation Unit of /FigHistoryState.java 
 
package org.argouml.uml.diagram.state.ui;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import org.argouml.uml.diagram.DiagramSettings;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.presentation.FigCircle;
import org.tigris.gef.presentation.FigText;
public abstract class FigHistoryState extends FigStateVertex
  { 
private static final int X = X0;
private static final int Y = Y0;
private static final int WIDTH = 24;
private static final int HEIGHT = 24;
private FigText h;
private FigCircle head;
static final long serialVersionUID = 6572261327347541373L;
@Override
    public String placeString()
    { 
return "H";
} 

@Override
    public void setLineWidth(int w)
    { 
head.setLineWidth(w);
} 

@Override
    public int getLineWidth()
    { 
return head.getLineWidth();
} 

@Override
    public void setLineColor(Color col)
    { 
head.setLineColor(col);
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
    public FigHistoryState()
    { 
initFigs();
} 

@Override
    public Color getFillColor()
    { 
return head.getFillColor();
} 

public FigHistoryState(Object owner, Rectangle bounds,
                           DiagramSettings settings)
    { 
super(owner, bounds, settings);
initFigs();
} 

private void initFigs()
    { 
setEditable(false);
setBigPort(new FigCircle(X, Y, WIDTH, HEIGHT, DEBUG_COLOR,
                                 DEBUG_COLOR));
head = new FigCircle(X, Y, WIDTH, HEIGHT, LINE_COLOR, FILL_COLOR);
h = new FigText(X, Y, WIDTH - 10, HEIGHT - 10);
h.setFont(getSettings().getFontPlain());
h.setText(getH());
h.setTextColor(TEXT_COLOR);
h.setFilled(false);
h.setLineWidth(0);
addFig(getBigPort());
addFig(head);
addFig(h);
setBlinkPorts(false);
} 

@Override
    public void mouseClicked(MouseEvent me)
    { 
} 

@SuppressWarnings("deprecation")

    @Deprecated
    public FigHistoryState(@SuppressWarnings("unused") GraphModel gm,
                           Object node)
    { 
this();
setOwner(node);
} 

@Override
    public Object clone()
    { 
FigHistoryState figClone = (FigHistoryState) super.clone();
Iterator it = figClone.getFigs().iterator();
figClone.setBigPort((FigCircle) it.next());
figClone.head = (FigCircle) it.next();
figClone.h = (FigText) it.next();
return figClone;
} 

protected abstract String getH();
@Override
    public boolean isResizable()
    { 
return false;
} 

@Override
    public void setFillColor(Color col)
    { 
head.setFillColor(col);
} 

@Override
    protected void setStandardBounds(int x, int y,
                                     int width, int height)
    { 
if(getNameFig() == null)//1
{ 
return;
} 

Rectangle oldBounds = getBounds();
getBigPort().setBounds(x, y, WIDTH, HEIGHT);
head.setBounds(x, y, WIDTH, HEIGHT);
this.h.setBounds(x, y, WIDTH - 10, HEIGHT - 10);
this.h.calcBounds();
calcBounds();
updateEdges();
firePropChange("bounds", oldBounds, getBounds());
} 

@Override
    public void setFilled(boolean f)
    { 
} 

 } 


