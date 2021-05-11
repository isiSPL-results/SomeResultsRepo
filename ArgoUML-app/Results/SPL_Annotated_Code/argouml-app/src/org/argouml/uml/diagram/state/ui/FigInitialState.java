// Compilation Unit of /FigInitialState.java 
 
package org.argouml.uml.diagram.state.ui;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.argouml.model.Model;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.activity.ui.SelectionActionState;
import org.tigris.gef.base.Selection;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.presentation.FigCircle;
public class FigInitialState extends FigStateVertex
  { 
private static final int X = X0;
private static final int Y = Y0;
private static final int STATE_WIDTH = 16;
private static final int HEIGHT = 16;
private FigCircle head;
static final long serialVersionUID = 6572261327347541373L;
@Override
    public void setLineColor(Color col)
    { 
head.setLineColor(col);
} 

public FigInitialState(Object owner, Rectangle bounds,
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
    public List getGravityPoints()
    { 
return getCircleGravityPoints();
} 

@Override
    public void mouseClicked(MouseEvent me)
    { 
} 

@SuppressWarnings("deprecation")

    @Deprecated
    public FigInitialState(@SuppressWarnings("unused") GraphModel gm,
                           Object node)
    { 
this();
setOwner(node);
} 

@Override
    public Object clone()
    { 
FigInitialState figClone = (FigInitialState) super.clone();
Iterator it = figClone.getFigs().iterator();
setBigPort((FigCircle) it.next());
figClone.head = (FigCircle) it.next();
return figClone;
} 

@SuppressWarnings("deprecation")

    @Deprecated
    public FigInitialState()
    { 
initFigs();
} 

@Override
    public boolean isFilled()
    { 
return true;
} 

@Override
    public void setFilled(boolean f)
    { 
} 

@Override
    public Selection makeSelection()
    { 
Object pstate = getOwner();
Selection sel = null;
if(pstate != null)//1
{ 
if(Model.getFacade().isAActivityGraph(
                        Model.getFacade().getStateMachine(
                            Model.getFacade().getContainer(pstate))))//1
{ 
sel = new SelectionActionState(this);
((SelectionActionState) sel).setIncomingButtonEnabled(false);
Collection outs = Model.getFacade().getOutgoings(getOwner());
((SelectionActionState) sel)
                .setOutgoingButtonEnabled(outs.isEmpty());
} 
else
{ 
sel = new SelectionState(this);
((SelectionState) sel).setIncomingButtonEnabled(false);
Collection outs = Model.getFacade().getOutgoings(getOwner());
((SelectionState) sel)
                .setOutgoingButtonEnabled(outs.isEmpty());
} 

} 

return sel;
} 

private void initFigs()
    { 
setEditable(false);
FigCircle bigPort =
            new FigCircle(X, Y, STATE_WIDTH, HEIGHT, DEBUG_COLOR, DEBUG_COLOR);
head = new FigCircle(X, Y, STATE_WIDTH, HEIGHT, LINE_COLOR,
                             SOLID_FILL_COLOR);
addFig(bigPort);
addFig(head);
setBigPort(bigPort);
setBlinkPorts(false);
} 

@Override
    public Color getFillColor()
    { 
return head.getFillColor();
} 

@Override
    public boolean isResizable()
    { 
return false;
} 

@Override
    public int getLineWidth()
    { 
return head.getLineWidth();
} 

@Override
    protected void setStandardBounds(int x, int y, int w, int h)
    { 
if(getNameFig() == null)//1
{ 
return;
} 

Rectangle oldBounds = getBounds();
getBigPort().setBounds(x, y, w, h);
head.setBounds(x, y, w, h);
calcBounds();
updateEdges();
firePropChange("bounds", oldBounds, getBounds());
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

 } 


