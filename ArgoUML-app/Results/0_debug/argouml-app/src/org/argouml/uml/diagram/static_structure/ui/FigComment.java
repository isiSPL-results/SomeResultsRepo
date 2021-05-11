
//#if 399103629 
// Compilation Unit of /FigComment.java 
 

//#if 1522196247 
package org.argouml.uml.diagram.static_structure.ui;
//#endif 


//#if 1140124147 
import java.awt.Color;
//#endif 


//#if -658663728 
import java.awt.Dimension;
//#endif 


//#if 1512212838 
import java.awt.Point;
//#endif 


//#if 1633303612 
import java.awt.Polygon;
//#endif 


//#if -672442393 
import java.awt.Rectangle;
//#endif 


//#if -1245822884 
import java.awt.event.InputEvent;
//#endif 


//#if -497675407 
import java.awt.event.KeyEvent;
//#endif 


//#if -1270229641 
import java.awt.event.KeyListener;
//#endif 


//#if -105851657 
import java.awt.event.MouseEvent;
//#endif 


//#if 2124963377 
import java.awt.event.MouseListener;
//#endif 


//#if 422045500 
import java.beans.PropertyChangeEvent;
//#endif 


//#if 538929612 
import java.beans.PropertyChangeListener;
//#endif 


//#if -1151496707 
import java.beans.VetoableChangeListener;
//#endif 


//#if -914740923 
import java.util.ArrayList;
//#endif 


//#if -1247566660 
import java.util.Collection;
//#endif 


//#if -1016147796 
import java.util.Iterator;
//#endif 


//#if -1536117370 
import javax.swing.SwingUtilities;
//#endif 


//#if 857325122 
import org.apache.log4j.Logger;
//#endif 


//#if 819062387 
import org.argouml.kernel.DelayedChangeNotify;
//#endif 


//#if -907153136 
import org.argouml.kernel.DelayedVChangeListener;
//#endif 


//#if -1491633270 
import org.argouml.model.AttributeChangeEvent;
//#endif 


//#if -1590105675 
import org.argouml.model.Model;
//#endif 


//#if 1588362107 
import org.argouml.model.RemoveAssociationEvent;
//#endif 


//#if 316742530 
import org.argouml.model.UmlChangeEvent;
//#endif 


//#if 1781210407 
import org.argouml.ui.ArgoJMenu;
//#endif 


//#if 112038296 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -1860845794 
import org.argouml.uml.diagram.ui.FigMultiLineText;
//#endif 


//#if 1865911241 
import org.argouml.uml.diagram.ui.FigNodeModelElement;
//#endif 


//#if 1703013163 
import org.tigris.gef.base.Geometry;
//#endif 


//#if -605454515 
import org.tigris.gef.base.Selection;
//#endif 


//#if -145253407 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if -1083138388 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 1153789888 
import org.tigris.gef.presentation.FigPoly;
//#endif 


//#if 1155330216 
import org.tigris.gef.presentation.FigRect;
//#endif 


//#if 1157197439 
import org.tigris.gef.presentation.FigText;
//#endif 


//#if 1381810798 
public class FigComment extends 
//#if 716113471 
FigNodeModelElement
//#endif 

 implements 
//#if 1318996546 
VetoableChangeListener
//#endif 

, 
//#if 1813496754 
DelayedVChangeListener
//#endif 

, 
//#if 1700599903 
MouseListener
//#endif 

, 
//#if -1878597223 
KeyListener
//#endif 

, 
//#if 1096431763 
PropertyChangeListener
//#endif 

  { 

//#if -575569073 
private static final Logger LOG = Logger.getLogger(FigComment.class);
//#endif 


//#if 396863270 
private int width = 80;
//#endif 


//#if -1767102767 
private int height = 60;
//#endif 


//#if 1251326463 
private int dogear = 10;
//#endif 


//#if -1768919335 
private boolean readyToEdit = true;
//#endif 


//#if -115649458 
private FigText bodyTextFig;
//#endif 


//#if -1261684206 
private FigPoly outlineFig;
//#endif 


//#if 295111522 
private FigPoly urCorner;
//#endif 


//#if 2072339713 
private boolean newlyCreated;
//#endif 


//#if -1618004908 
private static final long serialVersionUID = 7242542877839921267L;
//#endif 


//#if 1461898105 
private String retrieveBody()
    { 

//#if -1974597252 
return (getOwner() != null)
               ? (String) Model.getFacade().getBody(getOwner())
               : null;
//#endif 

} 

//#endif 


//#if 944720548 
@Override
    public Object clone()
    { 

//#if 1232972158 
FigComment figClone = (FigComment) super.clone();
//#endif 


//#if -456127348 
Iterator thisIter = this.getFigs().iterator();
//#endif 


//#if -884125898 
while (thisIter.hasNext()) //1
{ 

//#if -415676780 
Object thisFig = thisIter.next();
//#endif 


//#if -813067564 
if(thisFig == outlineFig)//1
{ 

//#if 274253464 
figClone.outlineFig = (FigPoly) thisFig;
//#endif 

} 

//#endif 


//#if 897532996 
if(thisFig == urCorner)//1
{ 

//#if 860381300 
figClone.urCorner = (FigPoly) thisFig;
//#endif 

} 

//#endif 


//#if 1806687731 
if(thisFig == bodyTextFig)//1
{ 

//#if -468518847 
figClone.bodyTextFig = (FigText) thisFig;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1883995985 
return figClone;
//#endif 

} 

//#endif 


//#if 597340423 
@Override
    public void vetoableChange(PropertyChangeEvent pce)
    { 

//#if -811341682 
Object src = pce.getSource();
//#endif 


//#if 473290320 
if(src == getOwner())//1
{ 

//#if -378448873 
DelayedChangeNotify delayedNotify =
                new DelayedChangeNotify(this, pce);
//#endif 


//#if -746676728 
SwingUtilities.invokeLater(delayedNotify);
//#endif 

} 
else
{ 

//#if 295761373 
LOG.debug("FigNodeModelElement got vetoableChange"
                      + " from non-owner:" + src);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1774178023 
@Override
    public void keyReleased(KeyEvent ke)
    { 
} 

//#endif 


//#if -813015230 
@Override
    public Point getClosestPoint(Point anotherPt)
    { 

//#if -2147420768 
Rectangle r = getBounds();
//#endif 


//#if -1480320785 
int[] xs = {
            r.x, r.x + r.width - dogear, r.x + r.width,
            r.x + r.width,  r.x,            r.x,
        };
//#endif 


//#if -1419092813 
int[] ys = {
            r.y, r.y,                    r.y + dogear,
            r.y + r.height, r.y + r.height, r.y,
        };
//#endif 


//#if 661356002 
Point p =
            Geometry.ptClosestTo(
                xs,
                ys,
                6,
                anotherPt);
//#endif 


//#if -777753436 
return p;
//#endif 

} 

//#endif 


//#if -2073283965 
@Override
    public Rectangle getNameBounds()
    { 

//#if -34131312 
return null;
//#endif 

} 

//#endif 


//#if -1233161640 
@Override
    public void setFilled(boolean f)
    { 

//#if 1507801200 
bodyTextFig.setFilled(false);
//#endif 


//#if 1790590992 
outlineFig.setFilled(f);
//#endif 


//#if 1815921920 
urCorner.setFilled(f);
//#endif 

} 

//#endif 


//#if 555077087 
@Override
    public void setEnclosingFig(Fig encloser)
    { 

//#if 934236585 
super.setEnclosingFig(encloser);
//#endif 

} 

//#endif 


//#if -154912070 
public FigComment(Object owner, Rectangle bounds,
                      DiagramSettings settings)
    { 

//#if 986194325 
super(owner, bounds, settings);
//#endif 


//#if -212507831 
bodyTextFig = new FigMultiLineText(getOwner(),
                                           new Rectangle(2, 2, width - 2 - dogear, height - 4),
                                           getSettings(), true);
//#endif 


//#if -1439111463 
initialize();
//#endif 


//#if 932545150 
updateBody();
//#endif 


//#if -1179255110 
if(bounds != null)//1
{ 

//#if 1568532304 
setLocation(bounds.x, bounds.y);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1718012446 
@Override
    public Color getLineColor()
    { 

//#if -639351771 
return outlineFig.getLineColor();
//#endif 

} 

//#endif 


//#if -1814677487 
@Override
    public void setFillColor(Color col)
    { 

//#if 333499186 
outlineFig.setFillColor(col);
//#endif 


//#if -606689854 
urCorner.setFillColor(col);
//#endif 

} 

//#endif 


//#if -1415585576 
@Override
    protected void textEditStarted(FigText ft)
    { 

//#if -795614136 
showHelp("parsing.help.comment");
//#endif 

} 

//#endif 


//#if -1895540743 
@Override
    protected void updateStereotypeText()
    { 

//#if -2080734265 
Object me = getOwner();
//#endif 


//#if -3867966 
if(me == null)//1
{ 

//#if 1800380996 
return;
//#endif 

} 

//#endif 


//#if -1464817175 
Rectangle rect = getBounds();
//#endif 


//#if -1711669719 
Dimension stereoMin = getStereotypeFig().getMinimumSize();
//#endif 


//#if -1344738545 
if(Model.getFacade().getStereotypes(me).isEmpty())//1
{ 

//#if -541819448 
if(getStereotypeFig().isVisible())//1
{ 

//#if -1662560095 
getStereotypeFig().setVisible(false);
//#endif 


//#if 1141302770 
rect.y += stereoMin.height;
//#endif 


//#if -509423060 
rect.height -= stereoMin.height;
//#endif 


//#if -893874608 
setBounds(rect.x, rect.y, rect.width, rect.height);
//#endif 


//#if 1897366883 
calcBounds();
//#endif 

} 

//#endif 

} 
else
{ 

//#if 947582579 
getStereotypeFig().setOwner(getOwner());
//#endif 


//#if 483707251 
if(!getStereotypeFig().isVisible())//1
{ 

//#if -1064281844 
getStereotypeFig().setVisible(true);
//#endif 


//#if -2001116898 
if(!newlyCreated)//1
{ 

//#if 1144584326 
rect.y -= stereoMin.height;
//#endif 


//#if 1361140440 
rect.height += stereoMin.height;
//#endif 


//#if 456706884 
rect.width =
                        Math.max(getMinimumSize().width, rect.width);
//#endif 


//#if 1886284542 
setBounds(rect.x, rect.y, rect.width, rect.height);
//#endif 


//#if 11886453 
calcBounds();
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 586606698 
newlyCreated = false;
//#endif 

} 

//#endif 


//#if -94026294 
public final void storeBody(String body)
    { 

//#if -757086454 
if(getOwner() != null)//1
{ 

//#if -1682693763 
Model.getCoreHelper().setBody(getOwner(), body);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2025215954 
private void initialize()
    { 

//#if -1902248120 
Color fg = super.getLineColor();
//#endif 


//#if 263363481 
Color fill = super.getFillColor();
//#endif 


//#if -1519753706 
outlineFig = new FigPoly(fg, fill);
//#endif 


//#if -1066560148 
outlineFig.addPoint(0, 0);
//#endif 


//#if -1386539187 
outlineFig.addPoint(width - 1 - dogear, 0);
//#endif 


//#if 89812360 
outlineFig.addPoint(width - 1, dogear);
//#endif 


//#if 1686976185 
outlineFig.addPoint(width - 1, height - 1);
//#endif 


//#if 405945395 
outlineFig.addPoint(0, height - 1);
//#endif 


//#if 274733414 
outlineFig.addPoint(0, 0);
//#endif 


//#if -2040598205 
outlineFig.setFilled(true);
//#endif 


//#if 1236394086 
outlineFig.setLineWidth(LINE_WIDTH);
//#endif 


//#if 494409190 
urCorner = new FigPoly(fg, fill);
//#endif 


//#if -783352451 
urCorner.addPoint(width - 1 - dogear, 0);
//#endif 


//#if -1871568968 
urCorner.addPoint(width - 1, dogear);
//#endif 


//#if 1079542801 
urCorner.addPoint(width - 1 - dogear, dogear);
//#endif 


//#if 1999465397 
urCorner.addPoint(width - 1 - dogear, 0);
//#endif 


//#if -1646458605 
urCorner.setFilled(true);
//#endif 


//#if -1560497449 
Color col = outlineFig.getFillColor();
//#endif 


//#if -532098721 
urCorner.setFillColor(col.darker());
//#endif 


//#if -724987242 
urCorner.setLineWidth(LINE_WIDTH);
//#endif 


//#if -765649006 
setBigPort(new FigRect(0, 0, width, height, null, null));
//#endif 


//#if -267953796 
getBigPort().setFilled(false);
//#endif 


//#if 1804972575 
getBigPort().setLineWidth(0);
//#endif 


//#if 202428662 
addFig(getBigPort());
//#endif 


//#if -1048128980 
addFig(outlineFig);
//#endif 


//#if 499807004 
addFig(urCorner);
//#endif 


//#if 1465288903 
addFig(getStereotypeFig());
//#endif 


//#if -1491858065 
addFig(bodyTextFig);
//#endif 


//#if -1647139954 
col = outlineFig.getFillColor();
//#endif 


//#if 971338899 
urCorner.setFillColor(col.darker());
//#endif 


//#if -556164232 
setBlinkPorts(false);
//#endif 


//#if 1551274140 
Rectangle r = getBounds();
//#endif 


//#if -180797260 
setBounds(r.x, r.y, r.width, r.height);
//#endif 


//#if -1594895974 
updateEdges();
//#endif 


//#if 711215162 
readyToEdit = false;
//#endif 


//#if 1552327416 
newlyCreated = true;
//#endif 

} 

//#endif 


//#if 653483600 
@Override
    public boolean getUseTrapRect()
    { 

//#if 642959283 
return true;
//#endif 

} 

//#endif 


//#if 121901560 
@Override
    public void setLineWidth(int w)
    { 

//#if -1887326914 
bodyTextFig.setLineWidth(0);
//#endif 


//#if -1464957054 
outlineFig.setLineWidth(w);
//#endif 


//#if -786990126 
urCorner.setLineWidth(w);
//#endif 

} 

//#endif 


//#if -496552891 
@Override
    public Dimension getMinimumSize()
    { 

//#if 426295422 
Dimension aSize = bodyTextFig.getMinimumSize();
//#endif 


//#if -1443335660 
if(getStereotypeFig().isVisible())//1
{ 

//#if 393811763 
Dimension stereoMin = getStereotypeFig().getMinimumSize();
//#endif 


//#if -696653391 
aSize.width =
                Math.max(aSize.width,
                         stereoMin.width);
//#endif 


//#if 404158325 
aSize.height += stereoMin.height;
//#endif 

} 

//#endif 


//#if -853803363 
return new Dimension(aSize.width + 4 + dogear,
                             aSize.height + 4);
//#endif 

} 

//#endif 


//#if -1697174538 
@Override
    protected ArgoJMenu buildShowPopUp()
    { 

//#if 323874114 
return new ArgoJMenu("menu.popup.show");
//#endif 

} 

//#endif 


//#if 817724645 
@Override
    public void mouseClicked(MouseEvent me)
    { 

//#if 45704080 
if(!readyToEdit)//1
{ 

//#if 1587950245 
Object owner = getOwner();
//#endif 


//#if 1746177605 
if(Model.getFacade().isAModelElement(owner)
                    && !Model.getModelManagementHelper().isReadOnly(owner))//1
{ 

//#if -744905659 
readyToEdit = true;
//#endif 

} 
else
{ 

//#if 1708606929 
LOG.debug("not ready to edit note");
//#endif 


//#if 1473653700 
return;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -403196912 
if(me.isConsumed())//1
{ 

//#if -1274672174 
return;
//#endif 

} 

//#endif 


//#if 1546833258 
if(me.getClickCount() >= 2
                && !(me.isPopupTrigger()
                     || me.getModifiers() == InputEvent.BUTTON3_MASK))//1
{ 

//#if 2061704124 
if(getOwner() == null)//1
{ 

//#if 1435239478 
return;
//#endif 

} 

//#endif 


//#if 1144568539 
Fig f = hitFig(new Rectangle(me.getX() - 2, me.getY() - 2, 4, 4));
//#endif 


//#if 677328350 
if(f instanceof MouseListener)//1
{ 

//#if -315112655 
((MouseListener) f).mouseClicked(me);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1086060182 
me.consume();
//#endif 

} 

//#endif 


//#if -904527639 

//#if -1551316921 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    @Override
    public void setOwner(Object own)
    { 

//#if -1767938582 
super.setOwner(own);
//#endif 


//#if 30994905 
updateBody();
//#endif 

} 

//#endif 


//#if -1641995667 
@Override
    public String placeString()
    { 

//#if 745836387 
String placeString = retrieveBody();
//#endif 


//#if 1713331519 
if(placeString == null)//1
{ 

//#if -28589055 
placeString = "new note";
//#endif 

} 

//#endif 


//#if -383711082 
return placeString;
//#endif 

} 

//#endif 


//#if -1854342011 
public String getBody()
    { 

//#if 1328291884 
return bodyTextFig.getText();
//#endif 

} 

//#endif 


//#if -427020839 
@Override
    protected final void updateLayout(UmlChangeEvent mee)
    { 

//#if 1421757591 
super.updateLayout(mee);
//#endif 


//#if 249603192 
if(mee instanceof AttributeChangeEvent
                && mee.getPropertyName().equals("body"))//1
{ 

//#if 1422121064 
bodyTextFig.setText(mee.getNewValue().toString());
//#endif 


//#if 820186688 
calcBounds();
//#endif 


//#if 1499796733 
setBounds(getBounds());
//#endif 


//#if -312747493 
damage();
//#endif 

} 
else

//#if 1253340055 
if(mee instanceof RemoveAssociationEvent
                   && mee.getPropertyName().equals("annotatedElement"))//1
{ 

//#if 1123032586 
Collection<FigEdgeNote> toRemove = new ArrayList<FigEdgeNote>();
//#endif 


//#if 1558584533 
Collection c = getFigEdges();
//#endif 


//#if -1095720977 
for (Iterator i = c.iterator(); i.hasNext(); ) //1
{ 

//#if -1107887218 
FigEdgeNote fen = (FigEdgeNote) i.next();
//#endif 


//#if 1911649191 
Object otherEnd = fen.getDestination();
//#endif 


//#if 1973127173 
if(otherEnd == getOwner())//1
{ 

//#if 201572657 
otherEnd = fen.getSource();
//#endif 

} 

//#endif 


//#if 598492553 
if(otherEnd == mee.getOldValue())//1
{ 

//#if -2017841559 
toRemove.add(fen);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 421507099 
for (FigEdgeNote fen : toRemove) //1
{ 

//#if -1010589167 
fen.removeFromDiagram();
//#endif 

} 

//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 691113114 
@Override
    public boolean isFilled()
    { 

//#if 508055675 
return outlineFig.isFilled();
//#endif 

} 

//#endif 


//#if -1858199439 
@Override
    public int getLineWidth()
    { 

//#if -1871265154 
return outlineFig.getLineWidth();
//#endif 

} 

//#endif 


//#if -1116929306 
@Override
    public void keyTyped(KeyEvent ke)
    { 

//#if 590579501 
if(Character.isISOControl(ke.getKeyChar()))//1
{ 

//#if 2085893859 
return;
//#endif 

} 

//#endif 


//#if -935790528 
if(!readyToEdit)//1
{ 

//#if 1513698954 
Object owner = getOwner();
//#endif 


//#if -1920700800 
if(Model.getFacade().isAModelElement(owner)
                    && !Model.getModelManagementHelper().isReadOnly(owner))//1
{ 

//#if 540290960 
storeBody("");
//#endif 


//#if -1090099681 
readyToEdit = true;
//#endif 

} 
else
{ 

//#if 940797608 
LOG.debug("not ready to edit note");
//#endif 


//#if -215935219 
return;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1717231070 
if(ke.isConsumed())//1
{ 

//#if -833466346 
return;
//#endif 

} 

//#endif 


//#if -616040898 
if(getOwner() == null)//1
{ 

//#if -1208039514 
return;
//#endif 

} 

//#endif 


//#if 2142796886 
bodyTextFig.keyTyped(ke);
//#endif 

} 

//#endif 


//#if -451713361 
@Override
    protected void updateBounds()
    { 

//#if -157931410 
Rectangle bbox = getBounds();
//#endif 


//#if -746734805 
Dimension minSize = getMinimumSize();
//#endif 


//#if 2121086362 
bbox.width = Math.max(bbox.width, minSize.width);
//#endif 


//#if 1517566067 
bbox.height = Math.max(bbox.height, minSize.height);
//#endif 


//#if -894951683 
setBounds(bbox.x, bbox.y, bbox.width, bbox.height);
//#endif 

} 

//#endif 


//#if 1237877737 
private void updateBody()
    { 

//#if 1928942083 
if(getOwner() != null)//1
{ 

//#if -474421973 
String body = (String) Model.getFacade().getBody(getOwner());
//#endif 


//#if 1032137927 
if(body != null)//1
{ 

//#if -20064918 
bodyTextFig.setText(body);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1758510318 
@Override
    public Selection makeSelection()
    { 

//#if 584621813 
return new SelectionComment(this);
//#endif 

} 

//#endif 


//#if -211730338 

//#if -1116525250 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigComment()
    { 

//#if 337850959 
bodyTextFig = new FigMultiLineText(2, 2, width - 2 - dogear,
                                           height - 4, true);
//#endif 


//#if 36599607 
initialize();
//#endif 

} 

//#endif 


//#if -891526797 
@Override
    public Color getFillColor()
    { 

//#if 1316559840 
return outlineFig.getFillColor();
//#endif 

} 

//#endif 


//#if -1300618069 
@Override
    public void propertyChange(PropertyChangeEvent pve)
    { 

//#if -1581036319 
Object src = pve.getSource();
//#endif 


//#if -1480821225 
String pName = pve.getPropertyName();
//#endif 


//#if 1080134871 
if(pName.equals("editing")
                && Boolean.FALSE.equals(pve.getNewValue()))//1
{ 

//#if -1373758126 
textEdited((FigText) src);
//#endif 


//#if 935713802 
Rectangle bbox = getBounds();
//#endif 


//#if -1459744057 
Dimension minSize = getMinimumSize();
//#endif 


//#if -218430666 
bbox.width = Math.max(bbox.width, minSize.width);
//#endif 


//#if -599902889 
bbox.height = Math.max(bbox.height, minSize.height);
//#endif 


//#if 1392047513 
setBounds(bbox.x, bbox.y, bbox.width, bbox.height);
//#endif 


//#if -1912031753 
endTrans();
//#endif 

} 
else
{ 

//#if 458957639 
super.propertyChange(pve);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -736200039 
@Override
    protected void setStandardBounds(int px, int py, int w, int h)
    { 

//#if 346470170 
if(bodyTextFig == null)//1
{ 

//#if 673589565 
return;
//#endif 

} 

//#endif 


//#if 569452504 
Dimension stereoMin = getStereotypeFig().getMinimumSize();
//#endif 


//#if 1695865281 
int stereotypeHeight = 0;
//#endif 


//#if -1506225430 
if(getStereotypeFig().isVisible())//1
{ 

//#if -516779324 
stereotypeHeight = stereoMin.height;
//#endif 

} 

//#endif 


//#if 635204830 
Rectangle oldBounds = getBounds();
//#endif 


//#if -303425278 
bodyTextFig.setBounds(px + 2, py + 2 + stereotypeHeight,
                              w - 4 - dogear, h - 4 - stereotypeHeight);
//#endif 


//#if -1961443632 
getStereotypeFig().setBounds(px + 2, py + 2,
                                     w - 4 - dogear, stereoMin.height);
//#endif 


//#if -1190072556 
getBigPort().setBounds(px, py, w, h);
//#endif 


//#if -260684778 
Polygon newPoly = new Polygon();
//#endif 


//#if 145503209 
newPoly.addPoint(px, py);
//#endif 


//#if -1889554738 
newPoly.addPoint(px + w - 1 - dogear, py);
//#endif 


//#if -1169693904 
newPoly.addPoint(px + w - 1, py + dogear);
//#endif 


//#if -111971110 
newPoly.addPoint(px + w - 1, py + h - 1);
//#endif 


//#if -1272505302 
newPoly.addPoint(px, py + h - 1);
//#endif 


//#if 1064144329 
newPoly.addPoint(px, py);
//#endif 


//#if -1670568039 
outlineFig.setPolygon(newPoly);
//#endif 


//#if -1854487036 
urCorner.setBounds(px + w - 1 - dogear, py, dogear, dogear);
//#endif 


//#if -907564049 
calcBounds();
//#endif 


//#if -1039034581 
firePropChange("bounds", oldBounds, getBounds());
//#endif 

} 

//#endif 


//#if 1810752172 
@Override
    protected void textEdited(FigText ft)
    { 

//#if -31076523 
if(ft == bodyTextFig)//1
{ 

//#if 1350890526 
storeBody(ft.getText());
//#endif 

} 

//#endif 

} 

//#endif 


//#if -601150080 
@Override
    public void setLineColor(Color col)
    { 

//#if -122128446 
outlineFig.setLineColor(col);
//#endif 


//#if -934951278 
urCorner.setLineColor(col);
//#endif 

} 

//#endif 


//#if -857630645 
@Override
    public void delayedVetoableChange(PropertyChangeEvent pce)
    { 

//#if 343622818 
renderingChanged();
//#endif 


//#if 444919421 
endTrans();
//#endif 

} 

//#endif 


//#if 1807501589 
@Deprecated
    public FigComment(@SuppressWarnings("unused") GraphModel gm, Object node)
    { 

//#if -687549436 
this();
//#endif 


//#if 554443859 
setOwner(node);
//#endif 

} 

//#endif 


//#if -835938 
@Override
    public void keyPressed(KeyEvent ke)
    { 
} 

//#endif 

 } 

//#endif 


//#endif 

