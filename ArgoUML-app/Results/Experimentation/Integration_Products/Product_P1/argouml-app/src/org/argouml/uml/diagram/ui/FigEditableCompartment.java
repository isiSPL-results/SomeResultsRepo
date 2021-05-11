package org.argouml.uml.diagram.ui;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.log4j.Logger;
import org.argouml.model.InvalidElementException;
import org.argouml.notation.NotationProvider;
import org.argouml.uml.diagram.DiagramSettings;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigLine;
public abstract class FigEditableCompartment extends FigCompartment
  { 
private static final Logger LOG = Logger.getLogger(FigCompartment.class);
private static final int MIN_HEIGHT = FigNodeModelElement.NAME_FIG_HEIGHT;
private FigSeperator compartmentSeperator;
@Override
    protected void setBoundsImpl(int x, int y, int w, int h)
    { 
int newW = w;
int newH = h;
int fw;
int yy = y;
int lineWidth = getLineWidth();
for (Fig fig : (List<Fig>) getFigs()) //1
{ 
if(fig.isVisible() && fig != getBigPort())//1
{ 
if(fig instanceof FigSeperator)//1
{ 
fw = w;
} 
else
{ 
fw = fig.getMinimumSize().width;
} 
fig.setBounds(x + lineWidth, yy + lineWidth, fw,
                              fig.getMinimumSize().height);
if(newW < fw + 2 * lineWidth)//1
{ 
newW = fw + 2 * lineWidth;
} 
yy += fig.getMinimumSize().height;
} 
} 
getBigPort().setBounds(x + lineWidth, y + lineWidth,
                               newW - 2 * lineWidth, newH - 2 * lineWidth);
calcBounds();
} 
protected FigSeperator getSeperatorFig()
    { 
return compartmentSeperator;
} 
abstract FigSingleLineTextWithNotation createFigText(Object owner,
            Rectangle bounds,
            DiagramSettings settings);@Override
    public Dimension getMinimumSize()
    { 
Dimension d = super.getMinimumSize();
if(d.height < MIN_HEIGHT)//1
{ 
d.height = MIN_HEIGHT;
} 
return d;
} 
public void populate()
    { 
if(!isVisible())//1
{ 
return;
} 
Fig bigPort = this.getBigPort();
int xpos = bigPort.getX();
int ypos = bigPort.getY();
List<Fig> figs = getElementFigs();
for (Fig f : figs) //1
{ 
removeFig(f);
} 
FigSingleLineTextWithNotation comp = null;
try//1
{ 
int acounter = -1;
for (Object umlObject : getUmlCollection()) //1
{ 
comp = findCompartmentFig(figs, umlObject);
acounter++;
if(comp == null)//1
{ 
comp = createFigText(umlObject, new Rectangle(
                                             xpos + 1 /*?LINE_WIDTH?*/,
                                             ypos + 1 /*?LINE_WIDTH?*/ + acounter
                                             * ROWHEIGHT,
                                             0,
                                             ROWHEIGHT - 2 /*? 2*LINE_WIDTH? */),
                                         getSettings());
} 
else
{ 
Rectangle b = comp.getBounds();
b.y = ypos + 1 /*?LINE_WIDTH?*/ + acounter * ROWHEIGHT;
comp.setBounds(b);
} 
comp.initNotationProviders();
addFig(comp);
String ftText = comp.getNotationProvider().toString(umlObject,
                                comp.getNotationSettings());
if(ftText == null)//1
{ 
ftText = "";
} 
comp.setText(ftText);
comp.setBotMargin(0);
} 
} 
catch (InvalidElementException e) //1
{ 
LOG.debug("Attempted to populate a FigEditableCompartment"
                      + " using a deleted model element - aborting", e);
} 
if(comp != null)//1
{ 
comp.setBotMargin(6);
} 
} 
private void constructFigs()
    { 
compartmentSeperator = new FigSeperator(X0, Y0, 11);
addFig(compartmentSeperator);
} 
@SuppressWarnings("deprecation")

    protected FigSingleLineTextWithNotation createFigText(Object owner,
            Rectangle bounds,
            @SuppressWarnings("unused") DiagramSettings settings,
            NotationProvider np)
    { 
FigSingleLineTextWithNotation comp = createFigText(
                bounds.x,
                bounds.y,
                bounds.width,
                bounds.height,
                this.getBigPort(),
                np);
comp.setOwner(owner);
return comp;
} 
protected abstract int getNotationType();@Override
    public void addFig(Fig fig)
    { 
if(fig != getBigPort()
                && !(fig instanceof CompartmentFigText)
                && !(fig instanceof FigSeperator))//1
{ 
LOG.error("Illegal Fig added to a FigEditableCompartment");
throw new IllegalArgumentException(
                "A FigEditableCompartment can only "
                + "contain CompartmentFigTexts, "
                + "received a " + fig.getClass().getName());
} 
super.addFig(fig);
} 
private CompartmentFigText findCompartmentFig(List<Fig> figs,
            Object umlObject)
    { 
for (Fig fig : figs) //1
{ 
if(fig instanceof CompartmentFigText)//1
{ 
CompartmentFigText candidate = (CompartmentFigText) fig;
if(candidate.getOwner() == umlObject)//1
{ 
return candidate;
} 
} 
} 
return null;
} 
@Deprecated
    protected FigSingleLineTextWithNotation createFigText(
        int x, int y, int w, int h, Fig aFig, NotationProvider np)
    { 
return null;
} 
@Override
    public void setVisible(boolean visible)
    { 
if(isVisible() == visible)//1
{ 
return;
} 
super.setVisible(visible);
if(visible)//1
{ 
populate();
} 
else
{ 
for (int i = getFigs().size() - 1; i >= 0; --i) //1
{ 
Fig f = getFigAt(i);
if(f instanceof CompartmentFigText)//1
{ 
removeFig(f);
} 
} 
} 
} 
public FigEditableCompartment(Object owner, Rectangle bounds,
                                  DiagramSettings settings)
    { 
super(owner, bounds, settings);
constructFigs();
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public FigEditableCompartment(int x, int y, int w, int h)
    { 
super(x, y, w, h);
constructFigs();
} 
public Dimension updateFigGroupSize(
        int x,
        int y,
        int w,
        int h,
        boolean checkSize,
        int rowHeight)
    { 
return getMinimumSize();
} 
protected abstract Collection getUmlCollection();private List<Fig> getElementFigs()
    { 
List<Fig> figs = new ArrayList<Fig>(getFigs());
if(figs.size() > 1)//1
{ 
figs.remove(1);
figs.remove(0);
} 
return figs;
} 
protected static class FigSeperator extends FigLine
  { 
private static final long serialVersionUID = -2222511596507221760L;
@Override
        public void setBoundsImpl(int x, int y, int w, int h)
        { 
setX1(x);
setY1(y);
setX2((x + w) - 1);
setY2(y);
} 
@Override
        public Dimension getSize()
        { 
return new Dimension((_x2 - _x1) + 1, getLineWidth());
} 
FigSeperator(int x, int y, int len)
        { 
super(x, y, (x + len) - 1, y, LINE_COLOR);
setLineWidth(LINE_WIDTH);
} 
@Override
        public Dimension getMinimumSize()
        { 
return new Dimension(0, getLineWidth());
} 

 } 

 } 
