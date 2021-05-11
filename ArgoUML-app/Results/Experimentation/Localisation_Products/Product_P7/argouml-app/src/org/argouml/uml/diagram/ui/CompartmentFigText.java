package org.argouml.uml.diagram.ui;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Arrays;
import org.apache.log4j.Logger;
import org.argouml.notation.NotationProvider;
import org.argouml.ui.targetmanager.TargetEvent;
import org.argouml.ui.targetmanager.TargetListener;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.diagram.DiagramSettings;
import org.tigris.gef.base.Globals;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigGroup;
import org.tigris.gef.presentation.FigText;
public class CompartmentFigText extends FigSingleLineTextWithNotation
 implements TargetListener
  { 
private static final int MARGIN = 3;
private static final long serialVersionUID = 3830572062785308980L;
private static final Logger LOG =
        Logger.getLogger(CompartmentFigText.class);
@Deprecated
    private Fig refFig;
private boolean highlighted;
public CompartmentFigText(Object element, Rectangle bounds,
                              DiagramSettings settings)
    { 
super(element, bounds, settings, true);
TargetManager.getInstance().addTargetListener(this);
setJustification(FigText.JUSTIFY_LEFT);
setRightMargin(MARGIN);
setLeftMargin(MARGIN);
} 
@Override
    public void removeFromDiagram()
    { 
super.removeFromDiagram();
Fig fg = getGroup();
if(fg instanceof FigGroup)//1
{ 
((FigGroup) fg).removeFig(this);
setGroup(null);
} 
TargetManager.getInstance().removeTargetListener(this);
} 
public CompartmentFigText(Object owner, Rectangle bounds,
                              DiagramSettings settings, String[] properties)
    { 
super(owner, bounds, settings, true, properties);
TargetManager.getInstance().addTargetListener(this);
} 
public boolean isHighlighted()
    { 
return highlighted;
} 
public void setHighlighted(boolean flag)
    { 
highlighted = flag;
} 
public void targetRemoved(TargetEvent e)
    { 
if(e.getRemovedTargetCollection().contains(getOwner()))//1
{ 
setHighlighted(false);
this.damage();
} 
} 
@Deprecated
    public CompartmentFigText(int x, int y, int w, int h, Fig aFig,
                              String property)
    { 
this(x, y, w, h, aFig, new String[] {property});
} 
public void targetAdded(TargetEvent e)
    { 
if(Arrays.asList(e.getNewTargets()).contains(getOwner()))//1
{ 
setHighlighted(true);
this.damage();
} 
} 
protected void textEdited()
    { 
setHighlighted(true);
super.textEdited();
} 
@Override
    public boolean isFilled()
    { 
return false;
} 
public void targetSet(TargetEvent e)
    { 
setHighlighted((Arrays.asList(e.getNewTargets()).contains(getOwner())));
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public CompartmentFigText(int x, int y, int w, int h, Fig aFig,
                              NotationProvider np)
    { 
super(x, y, w, h, true);
if(np == null)//1
{ 
LOG.warn("Need a NotationProvider for CompartmentFigText.");
} 
setNotationProvider(np);
refFig = aFig;
if(refFig == null)//1
{ 
LOG.warn(this.getClass().toString()
                     + ": Cannot create with null compartment fig");
} 
setJustification(FigText.JUSTIFY_LEFT);
setRightMargin(MARGIN);
setLeftMargin(MARGIN);
} 
@Override
    public Color getLineColor()
    { 
if(refFig != null)//1
{ 
return refFig.getLineColor();
} 
else
{ 
return super.getLineColor();
} 
} 
@Deprecated
    public CompartmentFigText(Object element, Rectangle bounds,
                              DiagramSettings settings, NotationProvider np)
    { 
super(element, bounds, settings, true);
if(np == null)//1
{ 
LOG.warn("Need a NotationProvider for CompartmentFigText.");
} 
setNotationProvider(np);
setJustification(FigText.JUSTIFY_LEFT);
setRightMargin(MARGIN);
setLeftMargin(MARGIN);
} 
@Override
    public void paint(Graphics g)
    { 
super.paint(g);
if(highlighted)//1
{ 
final int x = getX();
final int y = getY();
final int w = getWidth();
final int h = getHeight();
g.setColor(Globals.getPrefs().handleColorFor(this));
g.drawRect(x - 1, y - 1, w + 2, h + 2);
g.drawRect(x, y, w, h);
} 
} 
public CompartmentFigText(Object owner, Rectangle bounds,
                              DiagramSettings settings, String property)
    { 
this(owner, bounds, settings, new String[] {property});
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public CompartmentFigText(int x, int y, int w, int h, Fig aFig,
                              String[] properties)
    { 
super(x, y, w, h, true, properties);
if(aFig == null)//1
{ 
throw new IllegalArgumentException("A refFig must be provided");
} 
refFig = aFig;
} 

 } 
