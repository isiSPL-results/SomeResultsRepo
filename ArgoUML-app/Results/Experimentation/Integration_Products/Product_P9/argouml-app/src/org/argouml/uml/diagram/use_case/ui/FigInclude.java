package org.argouml.uml.diagram.use_case.ui;
import java.awt.Graphics;
import java.awt.Rectangle;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.ui.FigEdgeModelElement;
import org.argouml.uml.diagram.ui.FigSingleLineText;
import org.argouml.uml.diagram.ui.PathItemPlacement;
import org.tigris.gef.presentation.ArrowHeadGreater;
import org.tigris.gef.presentation.Fig;
public class FigInclude extends FigEdgeModelElement
  { 
private static final long serialVersionUID = 6199364390483239154L;
private FigSingleLineText label;
private ArrowHeadGreater endArrow = new ArrowHeadGreater();
@Override
    public void setFig(Fig f)
    { 
super.setFig(f);
setDashed(true);
} 
@Override
    protected boolean canEdit(Fig f)
    { 
return false;
} 
private void initialize()
    { 
label.setTextColor(TEXT_COLOR);
label.setTextFilled(false);
label.setFilled(false);
label.setLineWidth(0);
label.setEditable(false);
label.setText("<<include>>");
addPathItem(label, new PathItemPlacement(this, label, 50, 10));
setDashed(true);
setDestArrowHead(endArrow);
setBetweenNearestPoints(true);
} 
@Override
    public void paint(Graphics g)
    { 
endArrow.setLineColor(getLineColor());
super.paint(g);
} 
public FigInclude(Object edge, DiagramSettings settings)
    { 
super(edge, settings);
label = new FigSingleLineText(edge, new Rectangle(X0, Y0 + 20, 90, 20),
                                      settings, false);
initialize();
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public FigInclude(Object edge)
    { 
this();
setOwner(edge);
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public FigInclude()
    { 
label = new FigSingleLineText(X0, Y0 + 20, 90, 20, false);
initialize();
} 

 } 
