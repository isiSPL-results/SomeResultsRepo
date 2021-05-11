package org.argouml.uml.diagram.use_case.ui;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.beans.PropertyChangeEvent;
import java.util.HashSet;
import java.util.Set;
import org.argouml.model.Model;
import org.argouml.notation.providers.uml.NotationUtilityUml;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.ui.ArgoFigText;
import org.argouml.uml.diagram.ui.FigEdgeModelElement;
import org.argouml.uml.diagram.ui.FigTextGroup;
import org.argouml.uml.diagram.ui.PathItemPlacement;
import org.tigris.gef.presentation.ArrowHeadGreater;
import org.tigris.gef.presentation.Fig;
public class FigExtend extends FigEdgeModelElement
  { 
private static final int DEFAULT_WIDTH = 90;
private static final long serialVersionUID = -8026008987096598742L;
private ArgoFigText label;
private ArgoFigText condition;
private FigTextGroup fg;
private ArrowHeadGreater endArrow = new ArrowHeadGreater();
public FigExtend(Object owner, DiagramSettings settings)
    { 
super(owner, settings);
initialize(owner);
} 
@Override
    public void renderingChanged()
    { 
super.renderingChanged();
updateConditionText();
updateLabel();
} 
protected void updateLabel()
    { 
label.setText(getLabel());
} 
@Override
    public void paint(Graphics g)
    { 
endArrow.setLineColor(getLineColor());
super.paint(g);
} 
@Override
    public void setFig(Fig f)
    { 
super.setFig(f);
setDashed(true);
} 
protected void updateConditionText()
    { 
if(getOwner() == null)//1
{ 
return;
} 
Object c = Model.getFacade().getCondition(getOwner());
if(c == null)//1
{ 
condition.setText("");
} 
else
{ 
Object expr = Model.getFacade().getBody(c);
if(expr == null)//1
{ 
condition.setText("");
} 
else
{ 
condition.setText((String) expr);
} 
} 
fg.calcBounds();
endTrans();
} 
@Override
    protected void modelChanged(PropertyChangeEvent e)
    { 
Object extend = getOwner();
if(extend == null)//1
{ 
return;
} 
super.modelChanged(e);
if("condition".equals(e.getPropertyName()))//1
{ 
renderingChanged();
} 
} 
@Override
    protected boolean canEdit(Fig f)
    { 
return false;
} 
private void initialize(Object owner)
    { 
int y = Y0 + STEREOHEIGHT;
label = new ArgoFigText(owner,
                                new Rectangle(X0, y, DEFAULT_WIDTH, STEREOHEIGHT),
                                getSettings(), false);
y = y + STEREOHEIGHT;
label.setFilled(false);
label.setLineWidth(0);
label.setEditable(false);
label.setText(getLabel());
label.calcBounds();
condition = new ArgoFigText(owner,
                                    new Rectangle(X0, y, DEFAULT_WIDTH, STEREOHEIGHT),
                                    getSettings(), false);
y = y + STEREOHEIGHT;
condition.setFilled(false);
condition.setLineWidth(0);
fg = new FigTextGroup(owner, getSettings());
fg.addFig(label);
fg.addFig(condition);
fg.calcBounds();
addPathItem(fg, new PathItemPlacement(this, fg, 50, 10));
setDashed(true);
setDestArrowHead(endArrow);
setBetweenNearestPoints(true);
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public FigExtend()
    { 
initialize(null);
} 
@Override
    protected void updateListeners(Object oldOwner, Object newOwner)
    { 
Set<Object[]> listeners = new HashSet<Object[]>();
if(newOwner != null)//1
{ 
listeners.add(
                new Object[] {newOwner,
                              new String[] {"condition", "remove"}
                             });
} 
updateElementListeners(listeners);
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public FigExtend(Object edge)
    { 
this();
setOwner(edge);
} 
private String getLabel()
    { 
return NotationUtilityUml.formatStereotype(
                   "extend",
                   getNotationSettings().isUseGuillemets());
} 

 } 
