
//#if 728272093 
// Compilation Unit of /CompartmentFigText.java 
 

//#if 687847657 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -286731531 
import java.awt.Color;
//#endif 


//#if 1812749363 
import java.awt.Graphics;
//#endif 


//#if -1528893463 
import java.awt.Rectangle;
//#endif 


//#if 539428258 
import java.util.Arrays;
//#endif 


//#if -368126080 
import org.apache.log4j.Logger;
//#endif 


//#if -1165330248 
import org.argouml.notation.NotationProvider;
//#endif 


//#if -1723817342 
import org.argouml.ui.targetmanager.TargetEvent;
//#endif 


//#if -567762746 
import org.argouml.ui.targetmanager.TargetListener;
//#endif 


//#if 1114096527 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 1400139478 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 1744170471 
import org.tigris.gef.base.Globals;
//#endif 


//#if 1221564906 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -1605705363 
import org.tigris.gef.presentation.FigGroup;
//#endif 


//#if -1010001219 
import org.tigris.gef.presentation.FigText;
//#endif 


//#if 1239735124 
public class CompartmentFigText extends 
//#if -2070302188 
FigSingleLineTextWithNotation
//#endif 

 implements 
//#if 952771974 
TargetListener
//#endif 

  { 

//#if -1074577202 
private static final int MARGIN = 3;
//#endif 


//#if -225501364 
private static final long serialVersionUID = 3830572062785308980L;
//#endif 


//#if 384511692 
private static final Logger LOG =
        Logger.getLogger(CompartmentFigText.class);
//#endif 


//#if -1809915433 
@Deprecated
    private Fig refFig;
//#endif 


//#if -1932586354 
private boolean highlighted;
//#endif 


//#if 1238080902 
public CompartmentFigText(Object element, Rectangle bounds,
                              DiagramSettings settings)
    { 

//#if 324480312 
super(element, bounds, settings, true);
//#endif 


//#if 1384291183 
TargetManager.getInstance().addTargetListener(this);
//#endif 


//#if -75034348 
setJustification(FigText.JUSTIFY_LEFT);
//#endif 


//#if -358239369 
setRightMargin(MARGIN);
//#endif 


//#if -2096964646 
setLeftMargin(MARGIN);
//#endif 

} 

//#endif 


//#if -783428578 
@Override
    public void removeFromDiagram()
    { 

//#if 872526994 
super.removeFromDiagram();
//#endif 


//#if -1104274161 
Fig fg = getGroup();
//#endif 


//#if -684266575 
if(fg instanceof FigGroup)//1
{ 

//#if -1673543985 
((FigGroup) fg).removeFig(this);
//#endif 


//#if -876578745 
setGroup(null);
//#endif 

} 

//#endif 


//#if 522095825 
TargetManager.getInstance().removeTargetListener(this);
//#endif 

} 

//#endif 


//#if 302697393 
public CompartmentFigText(Object owner, Rectangle bounds,
                              DiagramSettings settings, String[] properties)
    { 

//#if 1034431973 
super(owner, bounds, settings, true, properties);
//#endif 


//#if 2118490284 
TargetManager.getInstance().addTargetListener(this);
//#endif 

} 

//#endif 


//#if -1746672052 
public boolean isHighlighted()
    { 

//#if 2115607074 
return highlighted;
//#endif 

} 

//#endif 


//#if 1489444238 
public void setHighlighted(boolean flag)
    { 

//#if -1489448735 
highlighted = flag;
//#endif 

} 

//#endif 


//#if -351746314 
public void targetRemoved(TargetEvent e)
    { 

//#if 1138190640 
if(e.getRemovedTargetCollection().contains(getOwner()))//1
{ 

//#if 797630971 
setHighlighted(false);
//#endif 


//#if -845082824 
this.damage();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -114411838 
@Deprecated
    public CompartmentFigText(int x, int y, int w, int h, Fig aFig,
                              String property)
    { 

//#if 425109363 
this(x, y, w, h, aFig, new String[] {property});
//#endif 

} 

//#endif 


//#if 488656854 
public void targetAdded(TargetEvent e)
    { 

//#if -571693183 
if(Arrays.asList(e.getNewTargets()).contains(getOwner()))//1
{ 

//#if 1719174960 
setHighlighted(true);
//#endif 


//#if -299196702 
this.damage();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -446655528 
protected void textEdited()
    { 

//#if -1345225753 
setHighlighted(true);
//#endif 


//#if 1916859617 
super.textEdited();
//#endif 

} 

//#endif 


//#if 803913761 
@Override
    public boolean isFilled()
    { 

//#if -1497774798 
return false;
//#endif 

} 

//#endif 


//#if -696647688 
public void targetSet(TargetEvent e)
    { 

//#if -1408568065 
setHighlighted((Arrays.asList(e.getNewTargets()).contains(getOwner())));
//#endif 

} 

//#endif 


//#if 635037939 

//#if -523387304 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public CompartmentFigText(int x, int y, int w, int h, Fig aFig,
                              NotationProvider np)
    { 

//#if -1585166973 
super(x, y, w, h, true);
//#endif 


//#if -323103482 
if(np == null)//1
{ 

//#if 5839532 
LOG.warn("Need a NotationProvider for CompartmentFigText.");
//#endif 

} 

//#endif 


//#if 1481992701 
setNotationProvider(np);
//#endif 


//#if 25195554 
refFig = aFig;
//#endif 


//#if -1104948107 
if(refFig == null)//1
{ 

//#if -1772919226 
LOG.warn(this.getClass().toString()
                     + ": Cannot create with null compartment fig");
//#endif 

} 

//#endif 


//#if -1280799385 
setJustification(FigText.JUSTIFY_LEFT);
//#endif 


//#if 486028746 
setRightMargin(MARGIN);
//#endif 


//#if -268614873 
setLeftMargin(MARGIN);
//#endif 

} 

//#endif 


//#if -690773079 
@Override
    public Color getLineColor()
    { 

//#if 514055949 
if(refFig != null)//1
{ 

//#if 757848127 
return refFig.getLineColor();
//#endif 

} 
else
{ 

//#if -1905242266 
return super.getLineColor();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 704584988 
@Deprecated
    public CompartmentFigText(Object element, Rectangle bounds,
                              DiagramSettings settings, NotationProvider np)
    { 

//#if -1858767617 
super(element, bounds, settings, true);
//#endif 


//#if 1327683980 
if(np == null)//1
{ 

//#if -118623518 
LOG.warn("Need a NotationProvider for CompartmentFigText.");
//#endif 

} 

//#endif 


//#if -607773641 
setNotationProvider(np);
//#endif 


//#if 1770643437 
setJustification(FigText.JUSTIFY_LEFT);
//#endif 


//#if -135572400 
setRightMargin(MARGIN);
//#endif 


//#if -427213855 
setLeftMargin(MARGIN);
//#endif 

} 

//#endif 


//#if -2045848353 
@Override
    public void paint(Graphics g)
    { 

//#if 1841955954 
super.paint(g);
//#endif 


//#if -1757289606 
if(highlighted)//1
{ 

//#if 401990100 
final int x = getX();
//#endif 


//#if -1405434572 
final int y = getY();
//#endif 


//#if 64666181 
final int w = getWidth();
//#endif 


//#if -563529679 
final int h = getHeight();
//#endif 


//#if -1937176674 
g.setColor(Globals.getPrefs().handleColorFor(this));
//#endif 


//#if 923076833 
g.drawRect(x - 1, y - 1, w + 2, h + 2);
//#endif 


//#if -330009333 
g.drawRect(x, y, w, h);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1295437199 
public CompartmentFigText(Object owner, Rectangle bounds,
                              DiagramSettings settings, String property)
    { 

//#if -380524543 
this(owner, bounds, settings, new String[] {property});
//#endif 

} 

//#endif 


//#if -624738430 

//#if -1138142571 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public CompartmentFigText(int x, int y, int w, int h, Fig aFig,
                              String[] properties)
    { 

//#if 1592096719 
super(x, y, w, h, true, properties);
//#endif 


//#if -243392554 
if(aFig == null)//1
{ 

//#if -1258781734 
throw new IllegalArgumentException("A refFig must be provided");
//#endif 

} 

//#endif 


//#if -738328685 
refFig = aFig;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

