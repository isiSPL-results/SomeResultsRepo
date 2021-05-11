
//#if 367779747 
// Compilation Unit of /FigEditableCompartment.java 
 

//#if 1636061636 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 681780119 
import java.awt.Dimension;
//#endif 


//#if 668001454 
import java.awt.Rectangle;
//#endif 


//#if 1984312670 
import java.util.ArrayList;
//#endif 


//#if -1571218493 
import java.util.Collection;
//#endif 


//#if 1945542211 
import java.util.List;
//#endif 


//#if 1147147739 
import org.apache.log4j.Logger;
//#endif 


//#if -229241651 
import org.argouml.model.InvalidElementException;
//#endif 


//#if 1205205971 
import org.argouml.notation.NotationProvider;
//#endif 


//#if -1142188239 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 156650821 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -1336600911 
import org.tigris.gef.presentation.FigLine;
//#endif 


//#if 1450368834 
public abstract class FigEditableCompartment extends 
//#if -600900080 
FigCompartment
//#endif 

  { 

//#if 678974906 
private static final Logger LOG = Logger.getLogger(FigCompartment.class);
//#endif 


//#if -1683466757 
private static final int MIN_HEIGHT = FigNodeModelElement.NAME_FIG_HEIGHT;
//#endif 


//#if -1288767538 
private FigSeperator compartmentSeperator;
//#endif 


//#if 1796961748 
@Override
    protected void setBoundsImpl(int x, int y, int w, int h)
    { 

//#if 284260570 
int newW = w;
//#endif 


//#if 283813240 
int newH = h;
//#endif 


//#if 579523802 
int fw;
//#endif 


//#if -1405762545 
int yy = y;
//#endif 


//#if -1139454461 
int lineWidth = getLineWidth();
//#endif 


//#if -24813807 
for (Fig fig : (List<Fig>) getFigs()) //1
{ 

//#if -1124901292 
if(fig.isVisible() && fig != getBigPort())//1
{ 

//#if 1395977591 
if(fig instanceof FigSeperator)//1
{ 

//#if -746545113 
fw = w;
//#endif 

} 
else
{ 

//#if -499304598 
fw = fig.getMinimumSize().width;
//#endif 

} 

//#endif 


//#if -1087456040 
fig.setBounds(x + lineWidth, yy + lineWidth, fw,
                              fig.getMinimumSize().height);
//#endif 


//#if -1327818289 
if(newW < fw + 2 * lineWidth)//1
{ 

//#if 1454116282 
newW = fw + 2 * lineWidth;
//#endif 

} 

//#endif 


//#if -114909143 
yy += fig.getMinimumSize().height;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -309236574 
getBigPort().setBounds(x + lineWidth, y + lineWidth,
                               newW - 2 * lineWidth, newH - 2 * lineWidth);
//#endif 


//#if -1808021711 
calcBounds();
//#endif 

} 

//#endif 


//#if -2081583823 
protected FigSeperator getSeperatorFig()
    { 

//#if -1912081938 
return compartmentSeperator;
//#endif 

} 

//#endif 


//#if -1210702796 
abstract FigSingleLineTextWithNotation createFigText(Object owner,
            Rectangle bounds,
            DiagramSettings settings);
//#endif 


//#if -1029072435 
@Override
    public Dimension getMinimumSize()
    { 

//#if -105585587 
Dimension d = super.getMinimumSize();
//#endif 


//#if 242287034 
if(d.height < MIN_HEIGHT)//1
{ 

//#if -1886905125 
d.height = MIN_HEIGHT;
//#endif 

} 

//#endif 


//#if 1664632133 
return d;
//#endif 

} 

//#endif 


//#if 1486920042 
public void populate()
    { 

//#if -1486986863 
if(!isVisible())//1
{ 

//#if -1512599166 
return;
//#endif 

} 

//#endif 


//#if 1949459733 
Fig bigPort = this.getBigPort();
//#endif 


//#if 1844143279 
int xpos = bigPort.getX();
//#endif 


//#if 1435348845 
int ypos = bigPort.getY();
//#endif 


//#if -1810732987 
List<Fig> figs = getElementFigs();
//#endif 


//#if 756159750 
for (Fig f : figs) //1
{ 

//#if 2074176932 
removeFig(f);
//#endif 

} 

//#endif 


//#if -1432045711 
FigSingleLineTextWithNotation comp = null;
//#endif 


//#if 840273856 
try //1
{ 

//#if 957088669 
int acounter = -1;
//#endif 


//#if -1295191151 
for (Object umlObject : getUmlCollection()) //1
{ 

//#if 470504682 
comp = findCompartmentFig(figs, umlObject);
//#endif 


//#if -1049194899 
acounter++;
//#endif 


//#if -890466026 
if(comp == null)//1
{ 

//#if -375636022 
comp = createFigText(umlObject, new Rectangle(
                                             xpos + 1 /*?LINE_WIDTH?*/,
                                             ypos + 1 /*?LINE_WIDTH?*/ + acounter
                                             * ROWHEIGHT,
                                             0,
                                             ROWHEIGHT - 2 /*? 2*LINE_WIDTH? */),
                                         getSettings());
//#endif 

} 
else
{ 

//#if -512285217 
Rectangle b = comp.getBounds();
//#endif 


//#if -1854999473 
b.y = ypos + 1 /*?LINE_WIDTH?*/ + acounter * ROWHEIGHT;
//#endif 


//#if 2110202687 
comp.setBounds(b);
//#endif 

} 

//#endif 


//#if -563450250 
comp.initNotationProviders();
//#endif 


//#if 705798739 
addFig(comp);
//#endif 


//#if -648720513 
String ftText = comp.getNotationProvider().toString(umlObject,
                                comp.getNotationSettings());
//#endif 


//#if -1923748830 
if(ftText == null)//1
{ 

//#if -531494099 
ftText = "";
//#endif 

} 

//#endif 


//#if -1717225838 
comp.setText(ftText);
//#endif 


//#if -320521351 
comp.setBotMargin(0);
//#endif 

} 

//#endif 

} 

//#if 945849807 
catch (InvalidElementException e) //1
{ 

//#if -56986031 
LOG.debug("Attempted to populate a FigEditableCompartment"
                      + " using a deleted model element - aborting", e);
//#endif 

} 

//#endif 


//#endif 


//#if 2053644347 
if(comp != null)//1
{ 

//#if -34922561 
comp.setBotMargin(6);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1994161230 
private void constructFigs()
    { 

//#if -1706489018 
compartmentSeperator = new FigSeperator(X0, Y0, 11);
//#endif 


//#if -150813824 
addFig(compartmentSeperator);
//#endif 

} 

//#endif 


//#if 524696378 

//#if -1958680179 
@SuppressWarnings("deprecation")
//#endif 


    protected FigSingleLineTextWithNotation createFigText(Object owner,
            Rectangle bounds,
            @SuppressWarnings("unused") DiagramSettings settings,
            NotationProvider np)
    { 

//#if -1509123397 
FigSingleLineTextWithNotation comp = createFigText(
                bounds.x,
                bounds.y,
                bounds.width,
                bounds.height,
                this.getBigPort(),
                np);
//#endif 


//#if 1976352836 
comp.setOwner(owner);
//#endif 


//#if 646685555 
return comp;
//#endif 

} 

//#endif 


//#if 128774290 
protected abstract int getNotationType();
//#endif 


//#if -427838613 
@Override
    public void addFig(Fig fig)
    { 

//#if 1980289922 
if(fig != getBigPort()
                && !(fig instanceof CompartmentFigText)
                && !(fig instanceof FigSeperator))//1
{ 

//#if -202209604 
LOG.error("Illegal Fig added to a FigEditableCompartment");
//#endif 


//#if -877060683 
throw new IllegalArgumentException(
                "A FigEditableCompartment can only "
                + "contain CompartmentFigTexts, "
                + "received a " + fig.getClass().getName());
//#endif 

} 

//#endif 


//#if 1602148857 
super.addFig(fig);
//#endif 

} 

//#endif 


//#if 1200190295 
private CompartmentFigText findCompartmentFig(List<Fig> figs,
            Object umlObject)
    { 

//#if 96505424 
for (Fig fig : figs) //1
{ 

//#if -1799416178 
if(fig instanceof CompartmentFigText)//1
{ 

//#if -122319697 
CompartmentFigText candidate = (CompartmentFigText) fig;
//#endif 


//#if -1346203804 
if(candidate.getOwner() == umlObject)//1
{ 

//#if -1114290463 
return candidate;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 293468034 
return null;
//#endif 

} 

//#endif 


//#if -2095133578 
@Deprecated
    protected FigSingleLineTextWithNotation createFigText(
        int x, int y, int w, int h, Fig aFig, NotationProvider np)
    { 

//#if 1176189935 
return null;
//#endif 

} 

//#endif 


//#if -628914802 
@Override
    public void setVisible(boolean visible)
    { 

//#if 2136123968 
if(isVisible() == visible)//1
{ 

//#if 301662143 
return;
//#endif 

} 

//#endif 


//#if -2022960069 
super.setVisible(visible);
//#endif 


//#if 1526917995 
if(visible)//1
{ 

//#if -2005343234 
populate();
//#endif 

} 
else
{ 

//#if 838569175 
for (int i = getFigs().size() - 1; i >= 0; --i) //1
{ 

//#if -2128610841 
Fig f = getFigAt(i);
//#endif 


//#if 158470518 
if(f instanceof CompartmentFigText)//1
{ 

//#if -199827889 
removeFig(f);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -669167837 
public FigEditableCompartment(Object owner, Rectangle bounds,
                                  DiagramSettings settings)
    { 

//#if -748171454 
super(owner, bounds, settings);
//#endif 


//#if -637297160 
constructFigs();
//#endif 

} 

//#endif 


//#if 660298383 

//#if 2071073122 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigEditableCompartment(int x, int y, int w, int h)
    { 

//#if 1967699732 
super(x, y, w, h);
//#endif 


//#if -1582447407 
constructFigs();
//#endif 

} 

//#endif 


//#if 1347729378 
public Dimension updateFigGroupSize(
        int x,
        int y,
        int w,
        int h,
        boolean checkSize,
        int rowHeight)
    { 

//#if 69473217 
return getMinimumSize();
//#endif 

} 

//#endif 


//#if -1208578711 
protected abstract Collection getUmlCollection();
//#endif 


//#if -1471123123 
private List<Fig> getElementFigs()
    { 

//#if 696070403 
List<Fig> figs = new ArrayList<Fig>(getFigs());
//#endif 


//#if 988273415 
if(figs.size() > 1)//1
{ 

//#if 1127492467 
figs.remove(1);
//#endif 


//#if 1127491506 
figs.remove(0);
//#endif 

} 

//#endif 


//#if 786583686 
return figs;
//#endif 

} 

//#endif 


//#if 740527867 
protected static class FigSeperator extends 
//#if 658804102 
FigLine
//#endif 

  { 

//#if -1558607457 
private static final long serialVersionUID = -2222511596507221760L;
//#endif 


//#if -493552269 
@Override
        public void setBoundsImpl(int x, int y, int w, int h)
        { 

//#if -181087818 
setX1(x);
//#endif 


//#if -152457706 
setY1(y);
//#endif 


//#if -1656422448 
setX2((x + w) - 1);
//#endif 


//#if -151534185 
setY2(y);
//#endif 

} 

//#endif 


//#if 1581598101 
@Override
        public Dimension getSize()
        { 

//#if 1167880088 
return new Dimension((_x2 - _x1) + 1, getLineWidth());
//#endif 

} 

//#endif 


//#if -2042148757 
FigSeperator(int x, int y, int len)
        { 

//#if -1808803941 
super(x, y, (x + len) - 1, y, LINE_COLOR);
//#endif 


//#if 1308667700 
setLineWidth(LINE_WIDTH);
//#endif 

} 

//#endif 


//#if 1200800317 
@Override
        public Dimension getMinimumSize()
        { 

//#if 785888700 
return new Dimension(0, getLineWidth());
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

