// Compilation Unit of /FigSynchState.java 
 
package org.argouml.uml.diagram.state.ui;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.util.Iterator;
import org.argouml.model.Model;
import org.argouml.uml.diagram.DiagramSettings;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.presentation.FigCircle;
import org.tigris.gef.presentation.FigRect;
import org.tigris.gef.presentation.FigText;
public class FigSynchState extends FigStateVertex
  { 
private static final int X = X0;
private static final int Y = Y0;
private static final int WIDTH = 25;
private static final int HEIGHT = 25;
private FigText bound;
private FigCircle head;
@Override
    public void mouseClicked(MouseEvent me)
    { 
} 

@Override
    public void setLineColor(Color col)
    { 
head.setLineColor(col);
} 

@Override
    public Color getLineColor()
    { 
return head.getLineColor();
} 

@Override
    public void setFillColor(Color col)
    { 
head.setFillColor(col);
} 

@Override
    protected void setStandardBounds(int x, int y, int w, int h)
    { 
if(getNameFig() == null)//1
{ 
return;
} 

Rectangle oldBounds = getBounds();
getBigPort().setBounds(x, y, WIDTH, HEIGHT);
head.setBounds(x, y, WIDTH, HEIGHT);
bound.setBounds(x - 2, y + 2, 0, 0);
bound.calcBounds();
calcBounds();
updateEdges();
firePropChange("bounds", oldBounds, getBounds());
} 

@SuppressWarnings("deprecation")

    @Deprecated
    public FigSynchState(@SuppressWarnings("unused") GraphModel gm,
                         Object node)
    { 
this();
setOwner(node);
} 

public FigSynchState(Object owner, Rectangle bounds,
                         DiagramSettings settings)
    { 
super(owner, bounds, settings);
initFigs();
} 

@Override
    public void setLineWidth(int w)
    { 
head.setLineWidth(w);
} 

@Override
    public Color getFillColor()
    { 
return head.getFillColor();
} 

@Override
    public Object clone()
    { 
FigSynchState figClone = (FigSynchState) super.clone();
Iterator it = figClone.getFigs().iterator();
figClone.setBigPort((FigRect) it.next());
figClone.head = (FigCircle) it.next();
figClone.bound = (FigText) it.next();
return figClone;
} 

@Override
    public boolean isResizable()
    { 
return false;
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

private void initFigs()
    { 
setEditable(false);
setBigPort(new FigCircle(X, Y, WIDTH, HEIGHT, DEBUG_COLOR,
                                 DEBUG_COLOR));
head = new FigCircle(X, Y, WIDTH, HEIGHT, LINE_COLOR, FILL_COLOR);
bound = new FigText(X - 2, Y + 2, 0, 0, true);
bound.setFilled(false);
bound.setLineWidth(0);
bound.setTextColor(TEXT_COLOR);
bound.setReturnAction(FigText.END_EDITING);
bound.setTabAction(FigText.END_EDITING);
bound.setJustification(FigText.JUSTIFY_CENTER);
bound.setEditable(false);
bound.setText("*");
addFig(getBigPort());
addFig(head);
addFig(bound);
setBlinkPorts(false);
} 

@Override
    public boolean isFilled()
    { 
return true;
} 

@Override
    protected void modelChanged(PropertyChangeEvent mee)
    { 
super.modelChanged(mee);
if(mee.getPropertyName().equals("bound"))//1
{ 
if(getOwner() == null)//1
{ 
return;
} 

int b = Model.getFacade().getBound(getOwner());
String aux;
if(b <= 0)//1
{ 
aux = "*";
} 
else
{ 
aux = String.valueOf(b);
} 

bound.setText(aux);
updateBounds();
damage();
} 

} 

@SuppressWarnings("deprecation")

    @Deprecated
    public FigSynchState()
    { 
initFigs();
} 

@Override
    protected void updateFont()
    { 
super.updateFont();
Font f = getSettings().getFontPlain();
bound.setFont(f);
} 

 } 


