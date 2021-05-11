// Compilation Unit of /FigDependency.java 
 
package org.argouml.uml.diagram.ui;
import java.awt.Color;
import java.awt.Graphics;
import org.argouml.uml.diagram.DiagramSettings;
import org.tigris.gef.base.Layer;
import org.tigris.gef.presentation.ArrowHead;
import org.tigris.gef.presentation.ArrowHeadGreater;
import org.tigris.gef.presentation.Fig;
public class FigDependency extends FigEdgeModelElement
  { 
private static final long serialVersionUID = -1779182458484724448L;
private FigTextGroup middleGroup;
private void constructFigs()
    { 
middleGroup.addFig(getNameFig());
middleGroup.addFig(getStereotypeFig());
addPathItem(middleGroup,
                    new PathItemPlacement(this, middleGroup, 50, 25));
setDestArrowHead(createEndArrow());
setBetweenNearestPoints(true);
getFig().setDashed(true);
} 

@Override
    protected void updateNameText()
    { 
super.updateNameText();
middleGroup.calcBounds();
} 

@Override
    public void setFig(Fig f)
    { 
super.setFig(f);
getFig().setDashed(true);
} 

protected ArrowHead createEndArrow()
    { 
return new ArrowHeadGreater();
} 

@Override
    protected boolean canEdit(Fig f)
    { 
return false;
} 

public FigDependency(Object owner, DiagramSettings settings)
    { 
super(owner, settings);
middleGroup = new FigTextGroup(owner, settings);
constructFigs();
} 

@SuppressWarnings("deprecation")

    @Deprecated
    public FigDependency(Object dependency)
    { 
this();
setOwner(dependency);
} 

@Override
    protected void updateStereotypeText()
    { 
super.updateStereotypeText();
middleGroup.calcBounds();
} 

public void setLineColor(Color color)
    { 
ArrowHead arrow = getDestArrowHead();
if(arrow != null)//1
{ 
arrow.setLineColor(getLineColor());
} 

} 

@SuppressWarnings("deprecation")

    @Deprecated
    public FigDependency()
    { 
super();
middleGroup = new FigTextGroup();
constructFigs();
} 

@SuppressWarnings("deprecation")

    @Deprecated
    public FigDependency(Object dependency, Layer lay)
    { 
this();
setOwner(dependency);
setLayer(lay);
} 

 } 


