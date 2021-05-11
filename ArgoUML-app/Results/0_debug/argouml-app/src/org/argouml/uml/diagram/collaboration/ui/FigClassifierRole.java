
//#if 222662790 
// Compilation Unit of /FigClassifierRole.java 
 

//#if -153512716 
package org.argouml.uml.diagram.collaboration.ui;
//#endif 


//#if 2055730369 
import java.awt.Color;
//#endif 


//#if 638749342 
import java.awt.Dimension;
//#endif 


//#if 624970677 
import java.awt.Rectangle;
//#endif 


//#if 281265274 
import java.util.Iterator;
//#endif 


//#if -1831678506 
import org.argouml.model.AddAssociationEvent;
//#endif 


//#if 1451916376 
import org.argouml.model.AttributeChangeEvent;
//#endif 


//#if 295718608 
import org.argouml.model.UmlChangeEvent;
//#endif 


//#if -1316909852 
import org.argouml.notation.NotationProviderFactory2;
//#endif 


//#if 1167764106 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 1253826199 
import org.argouml.uml.diagram.ui.FigNodeModelElement;
//#endif 


//#if 636263322 
import org.tigris.gef.base.Layer;
//#endif 


//#if -2097037633 
import org.tigris.gef.base.Selection;
//#endif 


//#if 962447059 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if 1896895130 
import org.tigris.gef.presentation.FigRect;
//#endif 


//#if 1898762353 
import org.tigris.gef.presentation.FigText;
//#endif 


//#if -1996999494 
public class FigClassifierRole extends 
//#if -27153487 
FigNodeModelElement
//#endif 

  { 

//#if 889771018 
private static final int DEFAULT_HEIGHT = 50;
//#endif 


//#if 1591901837 
private static final int DEFAULT_WIDTH = 90;
//#endif 


//#if -1284505100 
private static final int PADDING = 5;
//#endif 


//#if 548743857 
private FigRect cover;
//#endif 


//#if 1649425240 

//#if 1343213366 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigClassifierRole(@SuppressWarnings("unused")
                             GraphModel gm, Layer lay, Object node)
    { 

//#if 678067025 
this();
//#endif 


//#if 287219848 
setLayer(lay);
//#endif 


//#if 2054172320 
setOwner(node);
//#endif 

} 

//#endif 


//#if -1579403936 
@Override
    public Selection makeSelection()
    { 

//#if -1361806217 
return new SelectionClassifierRole(this);
//#endif 

} 

//#endif 


//#if -1209705469 
@Override
    public void setFillColor(Color col)
    { 

//#if -1022564855 
cover.setFillColor(col);
//#endif 

} 

//#endif 


//#if -2141321313 
@Override
    protected int getNotationProviderType()
    { 

//#if -1718560609 
return NotationProviderFactory2.TYPE_CLASSIFIERROLE;
//#endif 

} 

//#endif 


//#if -1954896526 
@Override
    public Object clone()
    { 

//#if 191883245 
FigClassifierRole figClone = (FigClassifierRole) super.clone();
//#endif 


//#if 1579344067 
Iterator it = figClone.getFigs().iterator();
//#endif 


//#if -484686204 
figClone.setBigPort((FigRect) it.next());
//#endif 


//#if -2132195550 
figClone.cover   = (FigRect) it.next();
//#endif 


//#if 749480980 
it.next();
//#endif 


//#if -1023745163 
figClone.setNameFig((FigText) it.next());
//#endif 


//#if -1655464926 
return figClone;
//#endif 

} 

//#endif 


//#if -294203288 
@Override
    public boolean isFilled()
    { 

//#if -118808411 
return cover.isFilled();
//#endif 

} 

//#endif 


//#if 435790342 
private void initClassifierRoleFigs()
    { 

//#if 801545210 
setBigPort(new FigRect(X0, Y0, DEFAULT_WIDTH, DEFAULT_HEIGHT,
                               DEBUG_COLOR, DEBUG_COLOR));
//#endif 


//#if 2092621947 
cover = new FigRect(X0, Y0, DEFAULT_WIDTH, DEFAULT_HEIGHT, LINE_COLOR,
                            FILL_COLOR);
//#endif 


//#if 1641656145 
getStereotypeFig().setLineWidth(0);
//#endif 


//#if 775622513 
getStereotypeFig().setVisible(true);
//#endif 


//#if 2040083910 
getStereotypeFig().setFillColor(DEBUG_COLOR);
//#endif 


//#if -1442617476 
getStereotypeFig().setBounds(X0, Y0,
                                     DEFAULT_WIDTH, getStereotypeFig().getHeight());
//#endif 


//#if -1060593942 
getNameFig().setLineWidth(0);
//#endif 


//#if -219409591 
getNameFig().setReturnAction(FigText.END_EDITING);
//#endif 


//#if 1093797393 
getNameFig().setFilled(false);
//#endif 


//#if 1778039518 
getNameFig().setUnderline(true);
//#endif 


//#if 1479078741 
getNameFig().setBounds(X0, Y0,
                               DEFAULT_WIDTH, getStereotypeFig().getHeight());
//#endif 


//#if 1024069529 
addFig(getBigPort());
//#endif 


//#if 189614542 
addFig(cover);
//#endif 


//#if -1702821590 
addFig(getStereotypeFig());
//#endif 


//#if 194503537 
addFig(getNameFig());
//#endif 

} 

//#endif 


//#if 580697648 
@Override
    public Color getLineColor()
    { 

//#if -71654957 
return cover.getLineColor();
//#endif 

} 

//#endif 


//#if -1394148408 

//#if -448368762 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigClassifierRole()
    { 

//#if 150147610 
initClassifierRoleFigs();
//#endif 


//#if -1378657441 
Rectangle r = getBounds();
//#endif 


//#if -966440239 
setBounds(r.x, r.y, r.width, r.height);
//#endif 

} 

//#endif 


//#if -123444515 
@Override
    protected void setStandardBounds(int x, int y, int w, int h)
    { 

//#if -1988459847 
if(getNameFig() == null)//1
{ 

//#if 1850544309 
return;
//#endif 

} 

//#endif 


//#if 361459386 
Rectangle oldBounds = getBounds();
//#endif 


//#if -1727734250 
Dimension minSize   = getMinimumSize();
//#endif 


//#if 397783457 
int newW = (minSize.width  > w) ? minSize.width  : w;
//#endif 


//#if -527593652 
int newH = (minSize.height > h) ? minSize.height : h;
//#endif 


//#if -66630220 
Dimension stereoMin = getStereotypeFig().getMinimumSize();
//#endif 


//#if 35981006 
Dimension nameMin   = getNameFig().getMinimumSize();
//#endif 


//#if 1052496342 
int extraEach = (newH - nameMin.height - stereoMin.height) / 2;
//#endif 


//#if -6099477 
if(!(stereoMin.height == 0 && stereoMin.width == 0))//1
{ 

//#if -1072015077 
getStereotypeFig().setBounds(x, y + extraEach, newW,
                                         getStereotypeFig().getHeight());
//#endif 

} 

//#endif 


//#if -1589791834 
getNameFig().setBounds(x, y + stereoMin.height + extraEach, newW,
                               nameMin.height);
//#endif 


//#if -877016166 
getBigPort().setBounds(x, y, newW, newH);
//#endif 


//#if 973909243 
cover.setBounds(x, y, newW, newH);
//#endif 


//#if 1545111362 
_x = x;
//#endif 


//#if 1545141184 
_y = y;
//#endif 


//#if 352703556 
_w = newW;
//#endif 


//#if -74950236 
_h = newH;
//#endif 


//#if 547969287 
firePropChange("bounds", oldBounds, getBounds());
//#endif 


//#if 2004569458 
updateEdges();
//#endif 

} 

//#endif 


//#if 1451451455 
@Override
    public int getLineWidth()
    { 

//#if -87803542 
return cover.getLineWidth();
//#endif 

} 

//#endif 


//#if -892679661 
@Override
    public Dimension getMinimumSize()
    { 

//#if 978284855 
Dimension stereoMin  = getStereotypeFig().getMinimumSize();
//#endif 


//#if 1830706513 
Dimension nameMin    = getNameFig().getMinimumSize();
//#endif 


//#if -1837938520 
Dimension newMin    = new Dimension(nameMin.width, nameMin.height);
//#endif 


//#if -1851740242 
if(!(stereoMin.height == 0 && stereoMin.width == 0))//1
{ 

//#if -1453402440 
newMin.width   = Math.max(newMin.width, stereoMin.width);
//#endif 


//#if 1471275786 
newMin.height += stereoMin.height;
//#endif 

} 

//#endif 


//#if 166165757 
newMin.height += PADDING;
//#endif 


//#if 2059200791 
return newMin;
//#endif 

} 

//#endif 


//#if -2033572954 
@Override
    public void setFilled(boolean f)
    { 

//#if 1232362131 
cover.setFilled(f);
//#endif 

} 

//#endif 


//#if 3821938 
@Override
    public void setLineColor(Color col)
    { 

//#if 1624428191 
cover.setLineColor(col);
//#endif 

} 

//#endif 


//#if -856926521 
@Override
    protected void updateStereotypeText()
    { 

//#if 1152591639 
Rectangle rect = getBounds();
//#endif 


//#if -197806722 
int stereotypeHeight = 0;
//#endif 


//#if 1150772621 
if(getStereotypeFig().isVisible())//1
{ 

//#if -2602982 
stereotypeHeight = getStereotypeFig().getHeight();
//#endif 

} 

//#endif 


//#if 1540148766 
int heightWithoutStereo = getHeight() - stereotypeHeight;
//#endif 


//#if 1809483229 
getStereotypeFig().populate();
//#endif 


//#if -371735087 
stereotypeHeight = 0;
//#endif 


//#if 238272004 
if(getStereotypeFig().isVisible())//2
{ 

//#if 702070083 
stereotypeHeight = getStereotypeFig().getHeight();
//#endif 

} 

//#endif 


//#if 1278487697 
int minWidth = this.getMinimumSize().width;
//#endif 


//#if -960791103 
if(minWidth > rect.width)//1
{ 

//#if 1291616390 
rect.width = minWidth;
//#endif 

} 

//#endif 


//#if 1657504031 
setBounds(
            rect.x,
            rect.y,
            rect.width,
            heightWithoutStereo + stereotypeHeight);
//#endif 


//#if 230045586 
calcBounds();
//#endif 

} 

//#endif 


//#if 1407183297 
@Override
    public Color getFillColor()
    { 

//#if 911663539 
return cover.getFillColor();
//#endif 

} 

//#endif 


//#if 2035744490 
@Override
    public void setLineWidth(int w)
    { 

//#if 666170033 
cover.setLineWidth(w);
//#endif 

} 

//#endif 


//#if 1512798876 
@Override
    protected void updateLayout(UmlChangeEvent event)
    { 

//#if 1845328447 
super.updateLayout(event);
//#endif 


//#if 1469358706 
if(event instanceof AddAssociationEvent
                || event instanceof AttributeChangeEvent)//1
{ 

//#if -243891088 
renderingChanged();
//#endif 


//#if -1246632023 
damage();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1641622386 
public FigClassifierRole(Object owner, Rectangle bounds,
                             DiagramSettings settings)
    { 

//#if 472986473 
super(owner, bounds, settings);
//#endif 


//#if -886610681 
initClassifierRoleFigs();
//#endif 


//#if -727742066 
if(bounds != null)//1
{ 

//#if 1914815894 
setLocation(bounds.x, bounds.y);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

