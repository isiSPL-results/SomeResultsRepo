
//#if -1266698878 
// Compilation Unit of /FigSubmachineState.java 
 

//#if 1749676772 
package org.argouml.uml.diagram.state.ui;
//#endif 


//#if -1903219811 
import java.awt.Color;
//#endif 


//#if -475335814 
import java.awt.Dimension;
//#endif 


//#if -489114479 
import java.awt.Rectangle;
//#endif 


//#if -1578265370 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -832819882 
import java.util.Iterator;
//#endif 


//#if -2107840693 
import org.argouml.model.Model;
//#endif 


//#if 1707057966 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -1933615553 
import org.argouml.uml.diagram.ui.FigSingleLineText;
//#endif 


//#if -2025348233 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if -949966546 
import org.tigris.gef.presentation.FigLine;
//#endif 


//#if 766073854 
import org.tigris.gef.presentation.FigRRect;
//#endif 


//#if -944554690 
import org.tigris.gef.presentation.FigRect;
//#endif 


//#if -942687467 
import org.tigris.gef.presentation.FigText;
//#endif 


//#if -1730162813 
public class FigSubmachineState extends 
//#if -1667368630 
FigState
//#endif 

  { 

//#if 122192439 
private static final int INCLUDE_HEIGHT = NAME_FIG_HEIGHT;
//#endif 


//#if -2031251552 
private static final int WIDTH = 90;
//#endif 


//#if 971113318 
private FigRect cover;
//#endif 


//#if 1756069332 
private FigLine divider;
//#endif 


//#if -1396425776 
private FigLine divider2;
//#endif 


//#if 85440124 
private FigRect circle1;
//#endif 


//#if 85440155 
private FigRect circle2;
//#endif 


//#if 1211531619 
private FigLine circle1tocircle2;
//#endif 


//#if 2100410974 
private FigText include;
//#endif 


//#if 1461982732 
public FigSubmachineState(Object owner, Rectangle bounds,
                              DiagramSettings settings)
    { 

//#if -1160774240 
super(owner, bounds, settings);
//#endif 


//#if 1071914753 
include = new FigSingleLineText(owner,
                                        new Rectangle(X0, Y0, WIDTH, INCLUDE_HEIGHT), settings, true);
//#endif 


//#if -1187053963 
initFigs();
//#endif 

} 

//#endif 


//#if 832765798 
private void updateInclude()
    { 

//#if 429332758 
include.setText(generateSubmachine(getOwner()));
//#endif 


//#if 1739732746 
calcBounds();
//#endif 


//#if -774420153 
setBounds(getBounds());
//#endif 


//#if 467859429 
damage();
//#endif 

} 

//#endif 


//#if -1387117299 
protected int getInitialX()
    { 

//#if -1040978813 
return 0;
//#endif 

} 

//#endif 


//#if 1491605787 
@Override
    public void setFilled(boolean f)
    { 

//#if -116034758 
cover.setFilled(f);
//#endif 


//#if -1575096299 
getBigPort().setFilled(f);
//#endif 

} 

//#endif 


//#if 1913361309 
@Deprecated
    public FigSubmachineState(@SuppressWarnings("unused") GraphModel gm,
                              Object node)
    { 

//#if -1049294688 
this();
//#endif 


//#if -608437009 
setOwner(node);
//#endif 

} 

//#endif 


//#if 40085904 
private String generateSubmachine(Object m)
    { 

//#if -742541954 
Object c = Model.getFacade().getSubmachine(m);
//#endif 


//#if 1062177356 
String s = "include / ";
//#endif 


//#if -861495743 
if((c == null)
                || (Model.getFacade().getName(c) == null)
                || (Model.getFacade().getName(c).length() == 0))//1
{ 

//#if -612299960 
return s;
//#endif 

} 

//#endif 


//#if 893434422 
return (s + Model.getFacade().getName(c));
//#endif 

} 

//#endif 


//#if 1253177639 
@Override
    public Object clone()
    { 

//#if 259468959 
FigSubmachineState figClone = (FigSubmachineState) super.clone();
//#endif 


//#if -1089636887 
Iterator it = figClone.getFigs().iterator();
//#endif 


//#if 1368880286 
figClone.setBigPort((FigRect) it.next());
//#endif 


//#if 2122289340 
figClone.cover = (FigRect) it.next();
//#endif 


//#if 829821327 
figClone.setNameFig((FigText) it.next());
//#endif 


//#if -141729330 
figClone.divider = (FigLine) it.next();
//#endif 


//#if 314336004 
figClone.include = (FigText) it.next();
//#endif 


//#if 281748516 
figClone.divider2 = (FigLine) it.next();
//#endif 


//#if -818745795 
figClone.setInternal((FigText) it.next());
//#endif 


//#if 1415795912 
return figClone;
//#endif 

} 

//#endif 


//#if 1661328868 

//#if -2084509130 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    @Override
    public void setOwner(Object node)
    { 

//#if 374262292 
super.setOwner(node);
//#endif 


//#if -195001441 
updateInclude();
//#endif 

} 

//#endif 


//#if -1093047077 
protected int getInitialWidth()
    { 

//#if 1932178970 
return 180;
//#endif 

} 

//#endif 


//#if -1925106104 
@Override
    public Dimension getMinimumSize()
    { 

//#if -1465394371 
Dimension nameDim = getNameFig().getMinimumSize();
//#endif 


//#if -910086225 
Dimension internalDim = getInternal().getMinimumSize();
//#endif 


//#if 1949618724 
Dimension includeDim = include.getMinimumSize();
//#endif 


//#if 1638192160 
int h =
            SPACE_TOP + nameDim.height
            + SPACE_MIDDLE + includeDim.height
            + SPACE_MIDDLE + internalDim.height
            + SPACE_BOTTOM;
//#endif 


//#if 472236784 
int waux =
            Math.max(nameDim.width,
                     internalDim.width) + 2 * MARGIN;
//#endif 


//#if 1501573430 
int w = Math.max(waux, includeDim.width + 50);
//#endif 


//#if 2075822163 
return new Dimension(w, h);
//#endif 

} 

//#endif 


//#if -1615940499 
private void updateListenersX(Object newOwner, Object oldV)
    { 

//#if -486390472 
this.updateListeners(getOwner(), newOwner);
//#endif 


//#if 1849043454 
if(oldV != null)//1
{ 

//#if -270706429 
removeElementListener(oldV);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1714101834 
@Override
    public Color getFillColor()
    { 

//#if -1953177871 
return cover.getFillColor();
//#endif 

} 

//#endif 


//#if -916716269 
@Override
    public boolean getUseTrapRect()
    { 

//#if -890711419 
return true;
//#endif 

} 

//#endif 


//#if 1872365269 
@Override
    public void setLineWidth(int w)
    { 

//#if 1521668719 
cover.setLineWidth(w);
//#endif 


//#if -1619294835 
divider.setLineWidth(w);
//#endif 


//#if -771201025 
divider2.setLineWidth(w);
//#endif 

} 

//#endif 


//#if 1144813166 
@Override
    public void setFillColor(Color col)
    { 

//#if 1201566555 
cover.setFillColor(col);
//#endif 

} 

//#endif 


//#if -1936626723 
@Override
    public void setLineColor(Color col)
    { 

//#if -897799633 
cover.setLineColor(col);
//#endif 


//#if -1213870259 
divider.setLineColor(col);
//#endif 


//#if -1193766837 
divider2.setLineColor(col);
//#endif 


//#if 1823674373 
circle1.setLineColor(col);
//#endif 


//#if 1414850148 
circle2.setLineColor(col);
//#endif 


//#if -1013762530 
circle1tocircle2.setLineColor(col);
//#endif 

} 

//#endif 


//#if 979093332 
protected int getInitialHeight()
    { 

//#if 1590159872 
return 150;
//#endif 

} 

//#endif 


//#if 1160875611 
@Override
    protected void updateListeners(Object oldOwner, Object newOwner)
    { 

//#if 1999331417 
super.updateListeners(oldOwner, newOwner);
//#endif 


//#if 286584098 
if(newOwner != null)//1
{ 

//#if -1921740893 
Object newSm = Model.getFacade().getSubmachine(newOwner);
//#endif 


//#if -1626599543 
if(newSm != null)//1
{ 

//#if 1653646842 
addElementListener(newSm);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1887751450 
private void initFigs()
    { 

//#if -1700467022 
cover =
            new FigRRect(getInitialX(), getInitialY(),
                         getInitialWidth(), getInitialHeight(),
                         LINE_COLOR, FILL_COLOR);
//#endif 


//#if 2042873345 
getBigPort().setLineWidth(0);
//#endif 


//#if 1415596337 
divider =
            new FigLine(getInitialX(),
                        getInitialY() + 2 + getNameFig().getBounds().height + 1,
                        getInitialWidth() - 1,
                        getInitialY() + 2 + getNameFig().getBounds().height + 1,
                        LINE_COLOR);
//#endif 


//#if -819263807 
include.setText(placeString());
//#endif 


//#if -456171774 
include.setBounds(getInitialX() + 2, getInitialY() + 2,
                          getInitialWidth() - 4, include.getBounds().height);
//#endif 


//#if 804043298 
include.setEditable(false);
//#endif 


//#if 1695424866 
include.setBotMargin(4);
//#endif 


//#if -1163869369 
divider2 =
            new FigLine(getInitialX(),
                        getInitialY() + 2 + getNameFig().getBounds().height + 1,
                        getInitialWidth() - 1,
                        getInitialY() + 2 + getNameFig().getBounds().height + 1,
                        LINE_COLOR);
//#endif 


//#if 148491875 
circle1 =
            new FigRRect(getInitialX() + getInitialWidth() - 55,
                         getInitialY() + getInitialHeight() - 15,
                         20, 10,
                         LINE_COLOR, FILL_COLOR);
//#endif 


//#if -281475227 
circle2 =
            new FigRRect(getInitialX() + getInitialWidth() - 25,
                         getInitialY() + getInitialHeight() - 15,
                         20, 10,
                         LINE_COLOR, FILL_COLOR);
//#endif 


//#if -310805875 
circle1tocircle2 =
            new FigLine(getInitialX() + getInitialWidth() - 35,
                        getInitialY() + getInitialHeight() - 10,
                        getInitialX() + getInitialWidth() - 25,
                        getInitialY() + getInitialHeight() - 10,
                        LINE_COLOR);
//#endif 


//#if 1371137752 
addFig(getBigPort());
//#endif 


//#if 526355311 
addFig(cover);
//#endif 


//#if 541571760 
addFig(getNameFig());
//#endif 


//#if -254672687 
addFig(divider);
//#endif 


//#if -159049056 
addFig(include);
//#endif 


//#if 695089445 
addFig(divider2);
//#endif 


//#if -594927892 
addFig(getInternal());
//#endif 


//#if 2133285145 
addFig(circle1);
//#endif 


//#if 2133286106 
addFig(circle2);
//#endif 


//#if 1837972978 
addFig(circle1tocircle2);
//#endif 


//#if 2117666818 
setBounds(getBounds());
//#endif 

} 

//#endif 


//#if 123183762 
@Override
    protected void setStandardBounds(int x, int y, int w, int h)
    { 

//#if 1108666907 
if(getNameFig() == null)//1
{ 

//#if 1008706948 
return;
//#endif 

} 

//#endif 


//#if 1419723932 
Rectangle oldBounds = getBounds();
//#endif 


//#if -1734954054 
Dimension nameDim = getNameFig().getMinimumSize();
//#endif 


//#if -2046188063 
Dimension includeDim = include.getMinimumSize();
//#endif 


//#if -296881051 
getNameFig().setBounds(x + MARGIN,
                               y + SPACE_TOP,
                               w - 2 * MARGIN,
                               nameDim.height);
//#endif 


//#if -1186624867 
divider.setShape(x,
                         y + DIVIDER_Y + nameDim.height,
                         x + w - 1,
                         y + DIVIDER_Y + nameDim.height);
//#endif 


//#if -1479865528 
include.setBounds(x + MARGIN,
                          y + SPACE_TOP + nameDim.height + SPACE_TOP,
                          w - 2 * MARGIN,
                          includeDim.height);
//#endif 


//#if 1641941591 
divider2.setShape(x,
                          y + nameDim.height + DIVIDER_Y + includeDim.height + DIVIDER_Y,
                          x + w - 1,
                          y + nameDim.height + DIVIDER_Y + includeDim.height + DIVIDER_Y);
//#endif 


//#if -208672327 
getInternal().setBounds(
            x + MARGIN,
            y + SPACE_TOP + nameDim.height
            + SPACE_TOP + includeDim.height + SPACE_MIDDLE,
            w - 2 * MARGIN,
            h - SPACE_TOP - nameDim.height
            - SPACE_TOP - includeDim.height
            - SPACE_MIDDLE - SPACE_BOTTOM);
//#endif 


//#if 1925755440 
circle1.setBounds(x + w - 55,
                          y + h - 15,
                          20, 10);
//#endif 


//#if -22883282 
circle2.setBounds(x + w - 25,
                          y + h - 15,
                          20, 10);
//#endif 


//#if -1811121393 
circle1tocircle2.setShape(x + w - 35,
                                  y + h - 10,
                                  x + w - 25,
                                  y + h - 10);
//#endif 


//#if -1264506706 
getBigPort().setBounds(x, y, w, h);
//#endif 


//#if 583034835 
cover.setBounds(x, y, w, h);
//#endif 


//#if -688287955 
calcBounds();
//#endif 


//#if -518541488 
updateEdges();
//#endif 


//#if 1701391081 
firePropChange("bounds", oldBounds, getBounds());
//#endif 

} 

//#endif 


//#if -1387116338 
protected int getInitialY()
    { 

//#if -1929459352 
return 0;
//#endif 

} 

//#endif 


//#if 1356840166 

//#if 337480053 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigSubmachineState()
    { 

//#if 2132429179 
super();
//#endif 


//#if -328818051 
include = new FigSingleLineText(X0, Y0, WIDTH, INCLUDE_HEIGHT, true);
//#endif 


//#if -129296417 
initFigs();
//#endif 

} 

//#endif 


//#if -708623971 
@Override
    public boolean isFilled()
    { 

//#if -2017194321 
return cover.isFilled();
//#endif 

} 

//#endif 


//#if 1754379813 
@Override
    public Color getLineColor()
    { 

//#if -1956582739 
return cover.getLineColor();
//#endif 

} 

//#endif 


//#if 336491993 
protected void modelChanged(PropertyChangeEvent mee)
    { 

//#if -963233053 
super.modelChanged(mee);
//#endif 


//#if 2051292138 
if(getOwner() == null)//1
{ 

//#if 872066318 
return;
//#endif 

} 

//#endif 


//#if -1191231161 
if((mee.getSource().equals(getOwner())))//1
{ 

//#if 226984322 
if((mee.getPropertyName()).equals("submachine"))//1
{ 

//#if -163247901 
updateInclude();
//#endif 


//#if 121351528 
if(mee.getOldValue() != null)//1
{ 

//#if -1373430542 
updateListenersX(getOwner(), mee.getOldValue());
//#endif 

} 

//#endif 

} 

//#endif 

} 
else
{ 

//#if 827400516 
if(mee.getSource()
                    == Model.getFacade().getSubmachine(getOwner()))//1
{ 

//#if 243691503 
if(mee.getPropertyName().equals("name"))//1
{ 

//#if -2055293246 
updateInclude();
//#endif 

} 

//#endif 


//#if 735668719 
if(mee.getPropertyName().equals("top"))//1
{ 

//#if -1535240526 
updateListeners(getOwner(), null);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1037030772 
@Override
    public int getLineWidth()
    { 

//#if 1350028699 
return cover.getLineWidth();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

