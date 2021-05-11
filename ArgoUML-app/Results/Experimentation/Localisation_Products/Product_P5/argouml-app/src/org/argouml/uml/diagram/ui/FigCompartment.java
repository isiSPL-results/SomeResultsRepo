package org.argouml.uml.diagram.ui;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.Collection;
import org.argouml.uml.diagram.DiagramSettings;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigRect;
public abstract class FigCompartment extends ArgoFigGroup
  { 
private Fig bigPort;
@SuppressWarnings("deprecation")

    @Deprecated
    public FigCompartment(int x, int y, int w, int h)
    { 
constructFigs(x, y, w, h);
} 
protected abstract void createModelElement();public FigCompartment(Object owner, Rectangle bounds,
                          DiagramSettings settings)
    { 
super(owner, settings);
constructFigs(bounds.x, bounds.y, bounds.width, bounds.height);
} 
@Override
    public Dimension getMinimumSize()
    { 
int minWidth = 0;
int minHeight = 0;
for (Fig fig : (Collection<Fig>) getFigs()) //1
{ 
if(fig.isVisible() && fig != getBigPort())//1
{ 
int fw = fig.getMinimumSize().width;
if(fw > minWidth)//1
{ 
minWidth = fw;
} 
minHeight += fig.getMinimumSize().height;
} 
} 
minHeight += 2;
return new Dimension(minWidth, minHeight);
} 
private void constructFigs(int x, int y, int w, int h)
    { 
bigPort = new FigRect(x, y, w, h, LINE_COLOR, FILL_COLOR);
bigPort.setFilled(true);
setFilled(true);
bigPort.setLineWidth(0);
setLineWidth(0);
addFig(bigPort);
} 
public Fig getBigPort()
    { 
return bigPort;
} 
@Override
    protected void setBoundsImpl(int x, int y, int w, int h)
    { 
int newW = w;
int newH = h;
int fw;
int yy = y;
for  (Fig fig : (Collection<Fig>) getFigs()) //1
{ 
if(fig.isVisible() && fig != getBigPort())//1
{ 
fw = fig.getMinimumSize().width;
fig.setBounds(x + 1, yy + 1, fw, fig.getMinimumSize().height);
if(newW < fw + 2)//1
{ 
newW = fw + 2;
} 
yy += fig.getMinimumSize().height;
} 
} 
getBigPort().setBounds(x, y, newW, newH);
calcBounds();
} 

 } 
