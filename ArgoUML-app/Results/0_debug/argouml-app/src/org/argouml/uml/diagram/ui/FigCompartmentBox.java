
//#if -368575 
// Compilation Unit of /FigCompartmentBox.java 
 

//#if -1999533574 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 1726592673 
import java.awt.Dimension;
//#endif 


//#if 1712814008 
import java.awt.Rectangle;
//#endif 


//#if 827777899 
import java.awt.event.InputEvent;
//#endif 


//#if 1967749126 
import java.awt.event.MouseEvent;
//#endif 


//#if -1597749683 
import java.util.List;
//#endif 


//#if 927567454 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 1355296359 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -1627369761 
import org.argouml.uml.diagram.static_structure.ui.SelectionClass;
//#endif 


//#if 592941281 
import org.tigris.gef.base.Editor;
//#endif 


//#if -943210760 
import org.tigris.gef.base.Globals;
//#endif 


//#if -984874276 
import org.tigris.gef.base.Selection;
//#endif 


//#if -633308549 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -1445678212 
import org.tigris.gef.presentation.FigGroup;
//#endif 


//#if -269788581 
public abstract class FigCompartmentBox extends 
//#if 1931280922 
FigNodeModelElement
//#endif 

  { 

//#if 1077505396 
protected static final Rectangle DEFAULT_COMPARTMENT_BOUNDS = new Rectangle(
        X0, Y0 + 20 /* 20 = height of name fig ?*/,
        WIDTH, ROWHEIGHT + 2 /* 2*LINE_WIDTH?  or extra padding? */ );
//#endif 


//#if 259482502 
private static CompartmentFigText highlightedFigText = null;
//#endif 


//#if 502540803 
private Fig borderFig;
//#endif 


//#if -918805085 
public FigCompartmentBox(Object owner, Rectangle bounds,
                             DiagramSettings settings)
    { 

//#if 1831178354 
super(owner, bounds, settings);
//#endif 


//#if 344043446 
initialize();
//#endif 

} 

//#endif 


//#if 378401560 
protected void setCompartmentVisible(FigCompartment compartment,
                                         boolean isVisible)
    { 

//#if 421998534 
Rectangle rect = getBounds();
//#endif 


//#if -475026345 
if(compartment.isVisible())//1
{ 

//#if -1057993034 
if(!isVisible)//1
{ 

//#if 1233827609 
damage();
//#endif 


//#if -1685565906 
for (Object f : compartment.getFigs()) //1
{ 

//#if 1071470895 
((Fig) f).setVisible(false);
//#endif 

} 

//#endif 


//#if -546913173 
compartment.setVisible(false);
//#endif 


//#if -2081489792 
Dimension aSize = this.getMinimumSize();
//#endif 


//#if 317078673 
setBounds(rect.x, rect.y,
                          (int) aSize.getWidth(), (int) aSize.getHeight());
//#endif 

} 

//#endif 

} 
else
{ 

//#if 1593424003 
if(isVisible)//1
{ 

//#if -664901609 
for (Object f : compartment.getFigs()) //1
{ 

//#if -885053418 
((Fig) f).setVisible(true);
//#endif 

} 

//#endif 


//#if 1445874835 
compartment.setVisible(true);
//#endif 


//#if -1060825495 
Dimension aSize = this.getMinimumSize();
//#endif 


//#if 81839048 
setBounds(rect.x, rect.y,
                          (int) aSize.getWidth(), (int) aSize.getHeight());
//#endif 


//#if 1321703554 
damage();
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 576500193 

//#if 1014729407 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigCompartmentBox()
    { 

//#if -1407413685 
super();
//#endif 


//#if -128034562 
initialize();
//#endif 

} 

//#endif 


//#if 17074531 
protected Dimension addChildDimensions(Dimension size, Fig child)
    { 

//#if -322519072 
if(child.isVisible())//1
{ 

//#if -1614376925 
Dimension childSize = child.getMinimumSize();
//#endif 


//#if 952967124 
size.width = Math.max(size.width, childSize.width);
//#endif 


//#if 126266039 
size.height += childSize.height;
//#endif 

} 

//#endif 


//#if -876135650 
return size;
//#endif 

} 

//#endif 


//#if -704107643 
public void setLineWidth(int w)
    { 

//#if -2145068873 
borderFig.setLineWidth(w);
//#endif 

} 

//#endif 


//#if -336805309 
@Override
    public void mouseClicked(MouseEvent mouseEvent)
    { 

//#if -1767631662 
if(mouseEvent.isConsumed())//1
{ 

//#if 974773798 
return;
//#endif 

} 

//#endif 


//#if 2013280817 
super.mouseClicked(mouseEvent);
//#endif 


//#if 825711205 
if(mouseEvent.isShiftDown()
                && TargetManager.getInstance().getTargets().size() > 0)//1
{ 

//#if -619418068 
return;
//#endif 

} 

//#endif 


//#if -80629488 
Editor ce = Globals.curEditor();
//#endif 


//#if 1513666607 
if(ce != null)//1
{ 

//#if -961080967 
Selection sel = ce.getSelectionManager().findSelectionFor(this);
//#endif 


//#if 241045573 
if(sel instanceof SelectionClass)//1
{ 

//#if -1745107692 
((SelectionClass) sel).hideButtons();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1853773816 
unhighlight();
//#endif 


//#if 1675333195 
Rectangle r =
            new Rectangle(
            mouseEvent.getX() - 1,
            mouseEvent.getY() - 1,
            2,
            2);
//#endif 


//#if 740905215 
Fig f = hitFig(r);
//#endif 


//#if 1704717474 
if(f instanceof FigEditableCompartment)//1
{ 

//#if -1919456130 
FigEditableCompartment figCompartment = (FigEditableCompartment) f;
//#endif 


//#if -1801230045 
f = figCompartment.hitFig(r);
//#endif 


//#if 1758359553 
if(f instanceof CompartmentFigText)//1
{ 

//#if 421236381 
if(highlightedFigText != null && highlightedFigText != f)//1
{ 

//#if -34664936 
highlightedFigText.setHighlighted(false);
//#endif 


//#if 1530374096 
if(highlightedFigText.getGroup() != null)//1
{ 

//#if 908469310 
highlightedFigText.getGroup().damage();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -102844703 
((CompartmentFigText) f).setHighlighted(true);
//#endif 


//#if -1358395647 
highlightedFigText = (CompartmentFigText) f;
//#endif 


//#if -1177163462 
TargetManager.getInstance().setTarget(f);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -673070318 
@Override
    public void translate(int dx, int dy)
    { 

//#if -1901215331 
super.translate(dx, dy);
//#endif 


//#if -1305529020 
Editor ce = Globals.curEditor();
//#endif 


//#if -912070813 
if(ce != null)//1
{ 

//#if -2122467374 
Selection sel = ce.getSelectionManager().findSelectionFor(this);
//#endif 


//#if -349350516 
if(sel instanceof SelectionClass)//1
{ 

//#if -482245046 
((SelectionClass) sel).hideButtons();
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1370472823 
private void initialize()
    { 

//#if -1029553955 
getStereotypeFig().setFilled(true);
//#endif 


//#if -958038516 
getStereotypeFig().setLineWidth(LINE_WIDTH);
//#endif 


//#if 1736515009 
getStereotypeFig().setHeight(STEREOHEIGHT + LINE_WIDTH);
//#endif 


//#if -598975059 
borderFig = new FigEmptyRect(X0, Y0, 0, 0);
//#endif 


//#if 1144315959 
borderFig.setLineColor(LINE_COLOR);
//#endif 


//#if -1258255273 
borderFig.setLineWidth(LINE_WIDTH);
//#endif 


//#if -1765609356 
getBigPort().setLineWidth(0);
//#endif 


//#if 832199545 
getBigPort().setFillColor(FILL_COLOR);
//#endif 

} 

//#endif 


//#if -1269419121 
protected final CompartmentFigText unhighlight(FigEditableCompartment fc)
    { 

//#if 1418958189 
Fig ft;
//#endif 


//#if 245137140 
for (int i = 1; i < fc.getFigs().size(); i++) //1
{ 

//#if -71114372 
ft = fc.getFigAt(i);
//#endif 


//#if -386170061 
if(ft instanceof CompartmentFigText
                    && ((CompartmentFigText) ft).isHighlighted())//1
{ 

//#if -1841737323 
((CompartmentFigText) ft).setHighlighted(false);
//#endif 


//#if 1394954465 
ft.getGroup().damage();
//#endif 


//#if 1082990644 
return ((CompartmentFigText) ft);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -491414464 
return null;
//#endif 

} 

//#endif 


//#if 164592398 
protected void createContainedModelElement(FigGroup fg, InputEvent ie)
    { 

//#if -2106223117 
if(!(fg instanceof FigEditableCompartment))//1
{ 

//#if 1708253065 
return;
//#endif 

} 

//#endif 


//#if 439616977 
((FigEditableCompartment) fg).createModelElement();
//#endif 


//#if 1044423990 
((FigEditableCompartment) fg).populate();
//#endif 


//#if 2073474238 
List figList = fg.getFigs();
//#endif 


//#if -750744312 
if(figList.size() > 0)//1
{ 

//#if -1359500037 
Fig fig = (Fig) figList.get(figList.size() - 1);
//#endif 


//#if -2031265134 
if(fig != null && fig instanceof CompartmentFigText)//1
{ 

//#if 201496878 
if(highlightedFigText != null)//1
{ 

//#if -1250291741 
highlightedFigText.setHighlighted(false);
//#endif 


//#if -1794318491 
if(highlightedFigText.getGroup() != null)//1
{ 

//#if -11846808 
highlightedFigText.getGroup().damage();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1283030947 
CompartmentFigText ft = (CompartmentFigText) fig;
//#endif 


//#if 811597908 
ft.startTextEditor(ie);
//#endif 


//#if -1271240035 
ft.setHighlighted(true);
//#endif 


//#if -254710828 
highlightedFigText = ft;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1603694875 
ie.consume();
//#endif 

} 

//#endif 


//#if -1042800008 
protected Fig getBorderFig()
    { 

//#if 106436191 
return borderFig;
//#endif 

} 

//#endif 


//#if -912840210 
protected CompartmentFigText unhighlight()
    { 

//#if -831935000 
Fig fc;
//#endif 


//#if -1143514829 
for (int i = 1; i < getFigs().size(); i++) //1
{ 

//#if -1165608582 
fc = getFigAt(i);
//#endif 


//#if -73103444 
if(fc instanceof FigEditableCompartment)//1
{ 

//#if -701428076 
CompartmentFigText ft =
                    unhighlight((FigEditableCompartment) fc);
//#endif 


//#if 1609397525 
if(ft != null)//1
{ 

//#if 675480621 
return ft;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1746700278 
return null;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

