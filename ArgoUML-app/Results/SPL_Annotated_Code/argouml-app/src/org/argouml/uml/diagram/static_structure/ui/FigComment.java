// Compilation Unit of /FigComment.java 
 
package org.argouml.uml.diagram.static_structure.ui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.VetoableChangeListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.SwingUtilities;
import org.apache.log4j.Logger;
import org.argouml.kernel.DelayedChangeNotify;
import org.argouml.kernel.DelayedVChangeListener;
import org.argouml.model.AttributeChangeEvent;
import org.argouml.model.Model;
import org.argouml.model.RemoveAssociationEvent;
import org.argouml.model.UmlChangeEvent;
import org.argouml.ui.ArgoJMenu;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.ui.FigMultiLineText;
import org.argouml.uml.diagram.ui.FigNodeModelElement;
import org.tigris.gef.base.Geometry;
import org.tigris.gef.base.Selection;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigPoly;
import org.tigris.gef.presentation.FigRect;
import org.tigris.gef.presentation.FigText;
public class FigComment extends FigNodeModelElement
 implements VetoableChangeListener
, DelayedVChangeListener
, MouseListener
, KeyListener
, PropertyChangeListener
  { 
private static final Logger LOG = Logger.getLogger(FigComment.class);
private int width = 80;
private int height = 60;
private int dogear = 10;
private boolean readyToEdit = true;
private FigText bodyTextFig;
private FigPoly outlineFig;
private FigPoly urCorner;
private boolean newlyCreated;
private static final long serialVersionUID = 7242542877839921267L;
private String retrieveBody()
    { 
return (getOwner() != null)
               ? (String) Model.getFacade().getBody(getOwner())
               : null;
} 

@Override
    public Object clone()
    { 
FigComment figClone = (FigComment) super.clone();
Iterator thisIter = this.getFigs().iterator();
while (thisIter.hasNext()) //1
{ 
Object thisFig = thisIter.next();
if(thisFig == outlineFig)//1
{ 
figClone.outlineFig = (FigPoly) thisFig;
} 

if(thisFig == urCorner)//1
{ 
figClone.urCorner = (FigPoly) thisFig;
} 

if(thisFig == bodyTextFig)//1
{ 
figClone.bodyTextFig = (FigText) thisFig;
} 

} 

return figClone;
} 

@Override
    public void vetoableChange(PropertyChangeEvent pce)
    { 
Object src = pce.getSource();
if(src == getOwner())//1
{ 
DelayedChangeNotify delayedNotify =
                new DelayedChangeNotify(this, pce);
SwingUtilities.invokeLater(delayedNotify);
} 
else
{ 
LOG.debug("FigNodeModelElement got vetoableChange"
                      + " from non-owner:" + src);
} 

} 

@Override
    public void keyReleased(KeyEvent ke)
    { 
} 

@Override
    public Point getClosestPoint(Point anotherPt)
    { 
Rectangle r = getBounds();
int[] xs = {
            r.x, r.x + r.width - dogear, r.x + r.width,
            r.x + r.width,  r.x,            r.x,
        };
int[] ys = {
            r.y, r.y,                    r.y + dogear,
            r.y + r.height, r.y + r.height, r.y,
        };
Point p =
            Geometry.ptClosestTo(
                xs,
                ys,
                6,
                anotherPt);
return p;
} 

@Override
    public Rectangle getNameBounds()
    { 
return null;
} 

@Override
    public void setFilled(boolean f)
    { 
bodyTextFig.setFilled(false);
outlineFig.setFilled(f);
urCorner.setFilled(f);
} 

@Override
    public void setEnclosingFig(Fig encloser)
    { 
super.setEnclosingFig(encloser);
} 

public FigComment(Object owner, Rectangle bounds,
                      DiagramSettings settings)
    { 
super(owner, bounds, settings);
bodyTextFig = new FigMultiLineText(getOwner(),
                                           new Rectangle(2, 2, width - 2 - dogear, height - 4),
                                           getSettings(), true);
initialize();
updateBody();
if(bounds != null)//1
{ 
setLocation(bounds.x, bounds.y);
} 

} 

@Override
    public Color getLineColor()
    { 
return outlineFig.getLineColor();
} 

@Override
    public void setFillColor(Color col)
    { 
outlineFig.setFillColor(col);
urCorner.setFillColor(col);
} 

@Override
    protected void textEditStarted(FigText ft)
    { 
showHelp("parsing.help.comment");
} 

@Override
    protected void updateStereotypeText()
    { 
Object me = getOwner();
if(me == null)//1
{ 
return;
} 

Rectangle rect = getBounds();
Dimension stereoMin = getStereotypeFig().getMinimumSize();
if(Model.getFacade().getStereotypes(me).isEmpty())//1
{ 
if(getStereotypeFig().isVisible())//1
{ 
getStereotypeFig().setVisible(false);
rect.y += stereoMin.height;
rect.height -= stereoMin.height;
setBounds(rect.x, rect.y, rect.width, rect.height);
calcBounds();
} 

} 
else
{ 
getStereotypeFig().setOwner(getOwner());
if(!getStereotypeFig().isVisible())//1
{ 
getStereotypeFig().setVisible(true);
if(!newlyCreated)//1
{ 
rect.y -= stereoMin.height;
rect.height += stereoMin.height;
rect.width =
                        Math.max(getMinimumSize().width, rect.width);
setBounds(rect.x, rect.y, rect.width, rect.height);
calcBounds();
} 

} 

} 

newlyCreated = false;
} 

public final void storeBody(String body)
    { 
if(getOwner() != null)//1
{ 
Model.getCoreHelper().setBody(getOwner(), body);
} 

} 

private void initialize()
    { 
Color fg = super.getLineColor();
Color fill = super.getFillColor();
outlineFig = new FigPoly(fg, fill);
outlineFig.addPoint(0, 0);
outlineFig.addPoint(width - 1 - dogear, 0);
outlineFig.addPoint(width - 1, dogear);
outlineFig.addPoint(width - 1, height - 1);
outlineFig.addPoint(0, height - 1);
outlineFig.addPoint(0, 0);
outlineFig.setFilled(true);
outlineFig.setLineWidth(LINE_WIDTH);
urCorner = new FigPoly(fg, fill);
urCorner.addPoint(width - 1 - dogear, 0);
urCorner.addPoint(width - 1, dogear);
urCorner.addPoint(width - 1 - dogear, dogear);
urCorner.addPoint(width - 1 - dogear, 0);
urCorner.setFilled(true);
Color col = outlineFig.getFillColor();
urCorner.setFillColor(col.darker());
urCorner.setLineWidth(LINE_WIDTH);
setBigPort(new FigRect(0, 0, width, height, null, null));
getBigPort().setFilled(false);
getBigPort().setLineWidth(0);
addFig(getBigPort());
addFig(outlineFig);
addFig(urCorner);
addFig(getStereotypeFig());
addFig(bodyTextFig);
col = outlineFig.getFillColor();
urCorner.setFillColor(col.darker());
setBlinkPorts(false);
Rectangle r = getBounds();
setBounds(r.x, r.y, r.width, r.height);
updateEdges();
readyToEdit = false;
newlyCreated = true;
} 

@Override
    public boolean getUseTrapRect()
    { 
return true;
} 

@Override
    public void setLineWidth(int w)
    { 
bodyTextFig.setLineWidth(0);
outlineFig.setLineWidth(w);
urCorner.setLineWidth(w);
} 

@Override
    public Dimension getMinimumSize()
    { 
Dimension aSize = bodyTextFig.getMinimumSize();
if(getStereotypeFig().isVisible())//1
{ 
Dimension stereoMin = getStereotypeFig().getMinimumSize();
aSize.width =
                Math.max(aSize.width,
                         stereoMin.width);
aSize.height += stereoMin.height;
} 

return new Dimension(aSize.width + 4 + dogear,
                             aSize.height + 4);
} 

@Override
    protected ArgoJMenu buildShowPopUp()
    { 
return new ArgoJMenu("menu.popup.show");
} 

@Override
    public void mouseClicked(MouseEvent me)
    { 
if(!readyToEdit)//1
{ 
Object owner = getOwner();
if(Model.getFacade().isAModelElement(owner)
                    && !Model.getModelManagementHelper().isReadOnly(owner))//1
{ 
readyToEdit = true;
} 
else
{ 
LOG.debug("not ready to edit note");
return;
} 

} 

if(me.isConsumed())//1
{ 
return;
} 

if(me.getClickCount() >= 2
                && !(me.isPopupTrigger()
                     || me.getModifiers() == InputEvent.BUTTON3_MASK))//1
{ 
if(getOwner() == null)//1
{ 
return;
} 

Fig f = hitFig(new Rectangle(me.getX() - 2, me.getY() - 2, 4, 4));
if(f instanceof MouseListener)//1
{ 
((MouseListener) f).mouseClicked(me);
} 

} 

me.consume();
} 

@SuppressWarnings("deprecation")

    @Deprecated
    @Override
    public void setOwner(Object own)
    { 
super.setOwner(own);
updateBody();
} 

@Override
    public String placeString()
    { 
String placeString = retrieveBody();
if(placeString == null)//1
{ 
placeString = "new note";
} 

return placeString;
} 

public String getBody()
    { 
return bodyTextFig.getText();
} 

@Override
    protected final void updateLayout(UmlChangeEvent mee)
    { 
super.updateLayout(mee);
if(mee instanceof AttributeChangeEvent
                && mee.getPropertyName().equals("body"))//1
{ 
bodyTextFig.setText(mee.getNewValue().toString());
calcBounds();
setBounds(getBounds());
damage();
} 
else
if(mee instanceof RemoveAssociationEvent
                   && mee.getPropertyName().equals("annotatedElement"))//1
{ 
Collection<FigEdgeNote> toRemove = new ArrayList<FigEdgeNote>();
Collection c = getFigEdges();
for (Iterator i = c.iterator(); i.hasNext(); ) //1
{ 
FigEdgeNote fen = (FigEdgeNote) i.next();
Object otherEnd = fen.getDestination();
if(otherEnd == getOwner())//1
{ 
otherEnd = fen.getSource();
} 

if(otherEnd == mee.getOldValue())//1
{ 
toRemove.add(fen);
} 

} 

for (FigEdgeNote fen : toRemove) //1
{ 
fen.removeFromDiagram();
} 

} 


} 

@Override
    public boolean isFilled()
    { 
return outlineFig.isFilled();
} 

@Override
    public int getLineWidth()
    { 
return outlineFig.getLineWidth();
} 

@Override
    public void keyTyped(KeyEvent ke)
    { 
if(Character.isISOControl(ke.getKeyChar()))//1
{ 
return;
} 

if(!readyToEdit)//1
{ 
Object owner = getOwner();
if(Model.getFacade().isAModelElement(owner)
                    && !Model.getModelManagementHelper().isReadOnly(owner))//1
{ 
storeBody("");
readyToEdit = true;
} 
else
{ 
LOG.debug("not ready to edit note");
return;
} 

} 

if(ke.isConsumed())//1
{ 
return;
} 

if(getOwner() == null)//1
{ 
return;
} 

bodyTextFig.keyTyped(ke);
} 

@Override
    protected void updateBounds()
    { 
Rectangle bbox = getBounds();
Dimension minSize = getMinimumSize();
bbox.width = Math.max(bbox.width, minSize.width);
bbox.height = Math.max(bbox.height, minSize.height);
setBounds(bbox.x, bbox.y, bbox.width, bbox.height);
} 

private void updateBody()
    { 
if(getOwner() != null)//1
{ 
String body = (String) Model.getFacade().getBody(getOwner());
if(body != null)//1
{ 
bodyTextFig.setText(body);
} 

} 

} 

@Override
    public Selection makeSelection()
    { 
return new SelectionComment(this);
} 

@SuppressWarnings("deprecation")

    @Deprecated
    public FigComment()
    { 
bodyTextFig = new FigMultiLineText(2, 2, width - 2 - dogear,
                                           height - 4, true);
initialize();
} 

@Override
    public Color getFillColor()
    { 
return outlineFig.getFillColor();
} 

@Override
    public void propertyChange(PropertyChangeEvent pve)
    { 
Object src = pve.getSource();
String pName = pve.getPropertyName();
if(pName.equals("editing")
                && Boolean.FALSE.equals(pve.getNewValue()))//1
{ 
textEdited((FigText) src);
Rectangle bbox = getBounds();
Dimension minSize = getMinimumSize();
bbox.width = Math.max(bbox.width, minSize.width);
bbox.height = Math.max(bbox.height, minSize.height);
setBounds(bbox.x, bbox.y, bbox.width, bbox.height);
endTrans();
} 
else
{ 
super.propertyChange(pve);
} 

} 

@Override
    protected void setStandardBounds(int px, int py, int w, int h)
    { 
if(bodyTextFig == null)//1
{ 
return;
} 

Dimension stereoMin = getStereotypeFig().getMinimumSize();
int stereotypeHeight = 0;
if(getStereotypeFig().isVisible())//1
{ 
stereotypeHeight = stereoMin.height;
} 

Rectangle oldBounds = getBounds();
bodyTextFig.setBounds(px + 2, py + 2 + stereotypeHeight,
                              w - 4 - dogear, h - 4 - stereotypeHeight);
getStereotypeFig().setBounds(px + 2, py + 2,
                                     w - 4 - dogear, stereoMin.height);
getBigPort().setBounds(px, py, w, h);
Polygon newPoly = new Polygon();
newPoly.addPoint(px, py);
newPoly.addPoint(px + w - 1 - dogear, py);
newPoly.addPoint(px + w - 1, py + dogear);
newPoly.addPoint(px + w - 1, py + h - 1);
newPoly.addPoint(px, py + h - 1);
newPoly.addPoint(px, py);
outlineFig.setPolygon(newPoly);
urCorner.setBounds(px + w - 1 - dogear, py, dogear, dogear);
calcBounds();
firePropChange("bounds", oldBounds, getBounds());
} 

@Override
    protected void textEdited(FigText ft)
    { 
if(ft == bodyTextFig)//1
{ 
storeBody(ft.getText());
} 

} 

@Override
    public void setLineColor(Color col)
    { 
outlineFig.setLineColor(col);
urCorner.setLineColor(col);
} 

@Override
    public void delayedVetoableChange(PropertyChangeEvent pce)
    { 
renderingChanged();
endTrans();
} 

@Deprecated
    public FigComment(@SuppressWarnings("unused") GraphModel gm, Object node)
    { 
this();
setOwner(node);
} 

@Override
    public void keyPressed(KeyEvent ke)
    { 
} 

 } 


