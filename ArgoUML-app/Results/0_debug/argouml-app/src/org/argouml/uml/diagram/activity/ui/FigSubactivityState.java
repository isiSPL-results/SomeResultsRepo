
//#if 372827227 
// Compilation Unit of /FigSubactivityState.java 
 

//#if -2141278728 
package org.argouml.uml.diagram.activity.ui;
//#endif 


//#if 70749223 
import java.awt.Color;
//#endif 


//#if -1782841596 
import java.awt.Dimension;
//#endif 


//#if -1796620261 
import java.awt.Rectangle;
//#endif 


//#if -160980624 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -826317676 
import java.util.HashSet;
//#endif 


//#if -2140325664 
import java.util.Iterator;
//#endif 


//#if -1168534298 
import java.util.Set;
//#endif 


//#if 876442595 
import org.argouml.model.AssociationChangeEvent;
//#endif 


//#if -1411137090 
import org.argouml.model.AttributeChangeEvent;
//#endif 


//#if 599228929 
import org.argouml.model.Model;
//#endif 


//#if -1687547420 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 1972419148 
import org.argouml.uml.diagram.state.ui.FigStateVertex;
//#endif 


//#if -1039194067 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if -1798642972 
import org.tigris.gef.presentation.FigLine;
//#endif 


//#if 226908424 
import org.tigris.gef.presentation.FigRRect;
//#endif 


//#if -1791363893 
import org.tigris.gef.presentation.FigText;
//#endif 


//#if -1244806753 
public class FigSubactivityState extends 
//#if -690536970 
FigStateVertex
//#endif 

  { 

//#if 2069458196 
private static final int PADDING = 8;
//#endif 


//#if -345099879 
private static final int X = X0;
//#endif 


//#if -344175397 
private static final int Y = Y0;
//#endif 


//#if -346053191 
private static final int W = 90;
//#endif 


//#if -359912578 
private static final int H = 25;
//#endif 


//#if -348938981 
private static final int SX = 3;
//#endif 


//#if -348909190 
private static final int SY = 3;
//#endif 


//#if -348968586 
private static final int SW = 9;
//#endif 


//#if -349415575 
private static final int SH = 5;
//#endif 


//#if 1053740948 
private FigRRect cover;
//#endif 


//#if -637470803 
private FigRRect s1;
//#endif 


//#if -637470772 
private FigRRect s2;
//#endif 


//#if 1971525089 
private FigLine s3;
//#endif 


//#if 1625584320 
public FigSubactivityState(Object owner, Rectangle bounds,
                               DiagramSettings settings)
    { 

//#if 784246136 
super(owner, bounds, settings);
//#endif 


//#if 319581261 
initFigs();
//#endif 

} 

//#endif 


//#if 115532585 
private void makeSubStatesIcon(int x, int y)
    { 

//#if -166313622 
s1 = new FigRRect(x - 22, y + 3, 8, 6, LINE_COLOR, FILL_COLOR);
//#endif 


//#if 614974063 
s2 = new FigRRect(x - 11, y + 9, 8, 6, LINE_COLOR, FILL_COLOR);
//#endif 


//#if -1625531256 
s1.setFilled(true);
//#endif 


//#if 1672363687 
s2.setFilled(true);
//#endif 


//#if 1067995841 
s1.setLineWidth(LINE_WIDTH);
//#endif 


//#if 2029609858 
s2.setLineWidth(LINE_WIDTH);
//#endif 


//#if -2003127990 
s1.setCornerRadius(SH);
//#endif 


//#if 253783017 
s2.setCornerRadius(SH);
//#endif 


//#if -1931421824 
s3 = new FigLine(x - 18, y + 6, x - 7, y + 12, LINE_COLOR);
//#endif 


//#if 887283691 
addFig(s3);
//#endif 


//#if 887281769 
addFig(s1);
//#endif 


//#if 887282730 
addFig(s2);
//#endif 

} 

//#endif 


//#if -698560416 
public Color getFillColor()
    { 

//#if 935098695 
return cover.getFillColor();
//#endif 

} 

//#endif 


//#if -1905783955 
@Override
    public void setLineWidth(int w)
    { 

//#if 796929317 
cover.setLineWidth(w);
//#endif 

} 

//#endif 


//#if -1525046065 
public Color getLineColor()
    { 

//#if 1749842084 
return cover.getLineColor();
//#endif 

} 

//#endif 


//#if 599440901 
@Override
    public boolean isFilled()
    { 

//#if 2050043551 
return cover.isFilled();
//#endif 

} 

//#endif 


//#if -940444934 
@Override
    protected void setStandardBounds(int x, int y, int w, int h)
    { 

//#if 840642623 
if(getNameFig() == null)//1
{ 

//#if -951841765 
return;
//#endif 

} 

//#endif 


//#if 213475264 
Rectangle oldBounds = getBounds();
//#endif 


//#if -63014824 
getNameFig().setBounds(x + PADDING, y, w - PADDING * 2, h - PADDING);
//#endif 


//#if -3509750 
getBigPort().setBounds(x, y, w, h);
//#endif 


//#if 315010551 
cover.setBounds(x, y, w, h);
//#endif 


//#if -706038542 
((FigRRect) getBigPort()).setCornerRadius(h);
//#endif 


//#if 1789422117 
cover.setCornerRadius(h);
//#endif 


//#if -430581790 
s1.setBounds(x + w - 2 * (SX + SW), y + h - 1 * (SY + SH), SW, SH);
//#endif 


//#if -1752099869 
s2.setBounds(x + w - 1 * (SX + SW), y + h - 2 * (SY + SH), SW, SH);
//#endif 


//#if 1246543505 
s3.setShape(x + w - (SX * 2 + SW + SW / 2), y + h - (SY + SH / 2),
                    x + w - (SX + SW / 2), y + h - (SY * 2 + SH + SH / 2));
//#endif 


//#if -1296241839 
calcBounds();
//#endif 


//#if 2109724588 
updateEdges();
//#endif 


//#if -338657779 
firePropChange("bounds", oldBounds, getBounds());
//#endif 

} 

//#endif 


//#if 624528176 

//#if 1276455074 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigSubactivityState()
    { 

//#if -1438546328 
initFigs();
//#endif 

} 

//#endif 


//#if -1949871652 
@Override
    public int getLineWidth()
    { 

//#if -686033848 
return cover.getLineWidth();
//#endif 

} 

//#endif 


//#if 333096835 
@Override
    public void setFilled(boolean f)
    { 

//#if -1166369121 
cover.setFilled(f);
//#endif 

} 

//#endif 


//#if 1809060989 
@Override
    protected void updateNameText()
    { 

//#if 436733297 
String s = "";
//#endif 


//#if -1361835995 
if(getOwner() != null)//1
{ 

//#if 1010194096 
Object machine = Model.getFacade().getSubmachine(getOwner());
//#endif 


//#if -1833690171 
if(machine != null)//1
{ 

//#if -308978657 
s = Model.getFacade().getName(machine);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 954960198 
if(s == null)//1
{ 

//#if -416370316 
s = "";
//#endif 

} 

//#endif 


//#if -2090200655 
getNameFig().setText(s);
//#endif 

} 

//#endif 


//#if 374111079 

//#if -1513357402 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigSubactivityState(@SuppressWarnings("unused") GraphModel gm,
                               Object node)
    { 

//#if 1375827667 
this();
//#endif 


//#if 295471138 
setOwner(node);
//#endif 

} 

//#endif 


//#if -1083709041 
@Override
    public Object clone()
    { 

//#if -1891422697 
FigSubactivityState figClone = (FigSubactivityState) super.clone();
//#endif 


//#if -1167017459 
Iterator it = figClone.getFigs().iterator();
//#endif 


//#if -522682080 
figClone.setBigPort((FigRRect) it.next());
//#endif 


//#if 1912399496 
figClone.cover = (FigRRect) it.next();
//#endif 


//#if 273135851 
figClone.setNameFig((FigText) it.next());
//#endif 


//#if 171015660 
return figClone;
//#endif 

} 

//#endif 


//#if 1423216687 
@Override
    protected void modelChanged(PropertyChangeEvent mee)
    { 

//#if 192130434 
super.modelChanged(mee);
//#endif 


//#if -2004813813 
if(mee instanceof AssociationChangeEvent
                || mee instanceof AttributeChangeEvent)//1
{ 

//#if 1169371153 
renderingChanged();
//#endif 


//#if 283408299 
updateListeners(getOwner(), getOwner());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1783166659 
@Override
    protected void updateListeners(Object oldOwner, Object newOwner)
    { 

//#if 1403047319 
Set<Object[]> l = new HashSet<Object[]>();
//#endif 


//#if 787464195 
if(newOwner != null)//1
{ 

//#if -2009835832 
l.add(new Object[] {newOwner, null});
//#endif 


//#if 1368674557 
Object machine = Model.getFacade().getSubmachine(newOwner);
//#endif 


//#if -767033059 
if(machine != null)//1
{ 

//#if 1845376660 
l.add(new Object[] {machine, null});
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1828140072 
updateElementListeners(l);
//#endif 

} 

//#endif 


//#if -2062248828 
public void setFillColor(Color col)
    { 

//#if 2116940264 
cover.setFillColor(col);
//#endif 

} 

//#endif 


//#if 492765618 
private void initFigs()
    { 

//#if -540318301 
FigRRect bigPort = new FigRRect(X, Y, W, H, DEBUG_COLOR, DEBUG_COLOR);
//#endif 


//#if -2071788595 
bigPort.setCornerRadius(bigPort.getHeight() / 2);
//#endif 


//#if 1156845412 
cover = new FigRRect(X, Y, W, H, LINE_COLOR, FILL_COLOR);
//#endif 


//#if -1383968784 
cover.setCornerRadius(getHeight() / 2);
//#endif 


//#if -1916874076 
bigPort.setLineWidth(0);
//#endif 


//#if 1527586215 
getNameFig().setLineWidth(0);
//#endif 


//#if 923159338 
getNameFig().setBounds(10 + PADDING, 10, 90 - PADDING * 2, 25);
//#endif 


//#if -276996364 
getNameFig().setFilled(false);
//#endif 


//#if 425818981 
getNameFig().setReturnAction(FigText.INSERT);
//#endif 


//#if -1153939274 
getNameFig().setEditable(false);
//#endif 


//#if 1790863899 
addFig(bigPort);
//#endif 


//#if 1169475761 
addFig(cover);
//#endif 


//#if -1877905618 
addFig(getNameFig());
//#endif 


//#if -1684345893 
makeSubStatesIcon(X + W, Y);
//#endif 


//#if 1219700695 
setBigPort(bigPort);
//#endif 


//#if 577213696 
setBounds(getBounds());
//#endif 

} 

//#endif 


//#if 1439287984 
@Override
    public Dimension getMinimumSize()
    { 

//#if -506638929 
Dimension nameDim = getNameFig().getMinimumSize();
//#endif 


//#if 632164255 
int w = nameDim.width + PADDING * 2;
//#endif 


//#if 319214567 
int h = nameDim.height + PADDING;
//#endif 


//#if 1380056060 
return new Dimension(Math.max(w, W / 2), Math.max(h, H / 2));
//#endif 

} 

//#endif 


//#if -719625099 
@Override
    public void setLineColor(Color col)
    { 

//#if 622827923 
cover.setLineColor(col);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

