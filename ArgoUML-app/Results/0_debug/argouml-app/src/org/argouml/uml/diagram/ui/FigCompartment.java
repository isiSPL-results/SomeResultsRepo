
//#if -720709277 
// Compilation Unit of /FigCompartment.java 
 

//#if -1080928823 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 1940952562 
import java.awt.Dimension;
//#endif 


//#if 1927173897 
import java.awt.Rectangle;
//#endif 


//#if 1607689054 
import java.util.Collection;
//#endif 


//#if 698530742 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -385300790 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 398973382 
import org.tigris.gef.presentation.FigRect;
//#endif 


//#if -1594595423 
public abstract class FigCompartment extends 
//#if -1612480604 
ArgoFigGroup
//#endif 

  { 

//#if 349451243 
private Fig bigPort;
//#endif 


//#if 204713465 

//#if 1319937509 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigCompartment(int x, int y, int w, int h)
    { 

//#if -1670791468 
constructFigs(x, y, w, h);
//#endif 

} 

//#endif 


//#if 1788990628 
protected abstract void createModelElement();
//#endif 


//#if 2019351153 
public FigCompartment(Object owner, Rectangle bounds,
                          DiagramSettings settings)
    { 

//#if 443412776 
super(owner, settings);
//#endif 


//#if -1482196031 
constructFigs(bounds.x, bounds.y, bounds.width, bounds.height);
//#endif 

} 

//#endif 


//#if 800823995 
@Override
    public Dimension getMinimumSize()
    { 

//#if 1038288797 
int minWidth = 0;
//#endif 


//#if 559943622 
int minHeight = 0;
//#endif 


//#if -310033896 
for (Fig fig : (Collection<Fig>) getFigs()) //1
{ 

//#if 947510198 
if(fig.isVisible() && fig != getBigPort())//1
{ 

//#if -1534183405 
int fw = fig.getMinimumSize().width;
//#endif 


//#if 145948109 
if(fw > minWidth)//1
{ 

//#if 736160464 
minWidth = fw;
//#endif 

} 

//#endif 


//#if 748507622 
minHeight += fig.getMinimumSize().height;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -128008484 
minHeight += 2;
//#endif 


//#if 204472077 
return new Dimension(minWidth, minHeight);
//#endif 

} 

//#endif 


//#if -1886128748 
private void constructFigs(int x, int y, int w, int h)
    { 

//#if 378767774 
bigPort = new FigRect(x, y, w, h, LINE_COLOR, FILL_COLOR);
//#endif 


//#if 1146005094 
bigPort.setFilled(true);
//#endif 


//#if 1865579193 
setFilled(true);
//#endif 


//#if -1475012084 
bigPort.setLineWidth(0);
//#endif 


//#if -755437985 
setLineWidth(0);
//#endif 


//#if 1625725315 
addFig(bigPort);
//#endif 

} 

//#endif 


//#if 213289815 
public Fig getBigPort()
    { 

//#if -512349114 
return bigPort;
//#endif 

} 

//#endif 


//#if 1914297026 
@Override
    protected void setBoundsImpl(int x, int y, int w, int h)
    { 

//#if 163493067 
int newW = w;
//#endif 


//#if 163045737 
int newH = h;
//#endif 


//#if 2045620555 
int fw;
//#endif 


//#if -1236056000 
int yy = y;
//#endif 


//#if -1095561216 
for  (Fig fig : (Collection<Fig>) getFigs()) //1
{ 

//#if -1507782590 
if(fig.isVisible() && fig != getBigPort())//1
{ 

//#if 213904054 
fw = fig.getMinimumSize().width;
//#endif 


//#if 1764289762 
fig.setBounds(x + 1, yy + 1, fw, fig.getMinimumSize().height);
//#endif 


//#if 471623197 
if(newW < fw + 2)//1
{ 

//#if -1244000953 
newW = fw + 2;
//#endif 

} 

//#endif 


//#if 311471871 
yy += fig.getMinimumSize().height;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 874831973 
getBigPort().setBounds(x, y, newW, newH);
//#endif 


//#if -410109536 
calcBounds();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

