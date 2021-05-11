package org.argouml.uml.diagram.ui;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.util.List;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.static_structure.ui.SelectionClass;
import org.tigris.gef.base.Editor;
import org.tigris.gef.base.Globals;
import org.tigris.gef.base.Selection;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigGroup;
public abstract class FigCompartmentBox extends FigNodeModelElement
  { 
protected static final Rectangle DEFAULT_COMPARTMENT_BOUNDS = new Rectangle(
        X0, Y0 + 20 /* 20 = height of name fig ?*/,
        WIDTH, ROWHEIGHT + 2 /* 2*LINE_WIDTH?  or extra padding? */ );
private static CompartmentFigText highlightedFigText = null;
private Fig borderFig;
public FigCompartmentBox(Object owner, Rectangle bounds,
                             DiagramSettings settings)
    { 
super(owner, bounds, settings);
initialize();
} 
protected void setCompartmentVisible(FigCompartment compartment,
                                         boolean isVisible)
    { 
Rectangle rect = getBounds();
if(compartment.isVisible())//1
{ 
if(!isVisible)//1
{ 
damage();
for (Object f : compartment.getFigs()) //1
{ 
((Fig) f).setVisible(false);
} 
compartment.setVisible(false);
Dimension aSize = this.getMinimumSize();
setBounds(rect.x, rect.y,
                          (int) aSize.getWidth(), (int) aSize.getHeight());
} 
} 
else
{ 
if(isVisible)//1
{ 
for (Object f : compartment.getFigs()) //1
{ 
((Fig) f).setVisible(true);
} 
compartment.setVisible(true);
Dimension aSize = this.getMinimumSize();
setBounds(rect.x, rect.y,
                          (int) aSize.getWidth(), (int) aSize.getHeight());
damage();
} 
} 
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public FigCompartmentBox()
    { 
super();
initialize();
} 
protected Dimension addChildDimensions(Dimension size, Fig child)
    { 
if(child.isVisible())//1
{ 
Dimension childSize = child.getMinimumSize();
size.width = Math.max(size.width, childSize.width);
size.height += childSize.height;
} 
return size;
} 
public void setLineWidth(int w)
    { 
borderFig.setLineWidth(w);
} 
@Override
    public void mouseClicked(MouseEvent mouseEvent)
    { 
if(mouseEvent.isConsumed())//1
{ 
return;
} 
super.mouseClicked(mouseEvent);
if(mouseEvent.isShiftDown()
                && TargetManager.getInstance().getTargets().size() > 0)//1
{ 
return;
} 
Editor ce = Globals.curEditor();
if(ce != null)//1
{ 
Selection sel = ce.getSelectionManager().findSelectionFor(this);
if(sel instanceof SelectionClass)//1
{ 
((SelectionClass) sel).hideButtons();
} 
} 
unhighlight();
Rectangle r =
            new Rectangle(
            mouseEvent.getX() - 1,
            mouseEvent.getY() - 1,
            2,
            2);
Fig f = hitFig(r);
if(f instanceof FigEditableCompartment)//1
{ 
FigEditableCompartment figCompartment = (FigEditableCompartment) f;
f = figCompartment.hitFig(r);
if(f instanceof CompartmentFigText)//1
{ 
if(highlightedFigText != null && highlightedFigText != f)//1
{ 
highlightedFigText.setHighlighted(false);
if(highlightedFigText.getGroup() != null)//1
{ 
highlightedFigText.getGroup().damage();
} 
} 
((CompartmentFigText) f).setHighlighted(true);
highlightedFigText = (CompartmentFigText) f;
TargetManager.getInstance().setTarget(f);
} 
} 
} 
@Override
    public void translate(int dx, int dy)
    { 
super.translate(dx, dy);
Editor ce = Globals.curEditor();
if(ce != null)//1
{ 
Selection sel = ce.getSelectionManager().findSelectionFor(this);
if(sel instanceof SelectionClass)//1
{ 
((SelectionClass) sel).hideButtons();
} 
} 
} 
private void initialize()
    { 
getStereotypeFig().setFilled(true);
getStereotypeFig().setLineWidth(LINE_WIDTH);
getStereotypeFig().setHeight(STEREOHEIGHT + LINE_WIDTH);
borderFig = new FigEmptyRect(X0, Y0, 0, 0);
borderFig.setLineColor(LINE_COLOR);
borderFig.setLineWidth(LINE_WIDTH);
getBigPort().setLineWidth(0);
getBigPort().setFillColor(FILL_COLOR);
} 
protected final CompartmentFigText unhighlight(FigEditableCompartment fc)
    { 
Fig ft;
for (int i = 1; i < fc.getFigs().size(); i++) //1
{ 
ft = fc.getFigAt(i);
if(ft instanceof CompartmentFigText
                    && ((CompartmentFigText) ft).isHighlighted())//1
{ 
((CompartmentFigText) ft).setHighlighted(false);
ft.getGroup().damage();
return ((CompartmentFigText) ft);
} 
} 
return null;
} 
protected void createContainedModelElement(FigGroup fg, InputEvent ie)
    { 
if(!(fg instanceof FigEditableCompartment))//1
{ 
return;
} 
((FigEditableCompartment) fg).createModelElement();
((FigEditableCompartment) fg).populate();
List figList = fg.getFigs();
if(figList.size() > 0)//1
{ 
Fig fig = (Fig) figList.get(figList.size() - 1);
if(fig != null && fig instanceof CompartmentFigText)//1
{ 
if(highlightedFigText != null)//1
{ 
highlightedFigText.setHighlighted(false);
if(highlightedFigText.getGroup() != null)//1
{ 
highlightedFigText.getGroup().damage();
} 
} 
CompartmentFigText ft = (CompartmentFigText) fig;
ft.startTextEditor(ie);
ft.setHighlighted(true);
highlightedFigText = ft;
} 
} 
ie.consume();
} 
protected Fig getBorderFig()
    { 
return borderFig;
} 
protected CompartmentFigText unhighlight()
    { 
Fig fc;
for (int i = 1; i < getFigs().size(); i++) //1
{ 
fc = getFigAt(i);
if(fc instanceof FigEditableCompartment)//1
{ 
CompartmentFigText ft =
                    unhighlight((FigEditableCompartment) fc);
if(ft != null)//1
{ 
return ft;
} 
} 
} 
return null;
} 

 } 
