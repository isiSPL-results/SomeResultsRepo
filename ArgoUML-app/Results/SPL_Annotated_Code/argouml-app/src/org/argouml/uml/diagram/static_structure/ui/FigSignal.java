// Compilation Unit of /FigSignal.java 
 
package org.argouml.uml.diagram.static_structure.ui;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.util.Vector;
import org.argouml.model.AssociationChangeEvent;
import org.argouml.model.AttributeChangeEvent;
import org.argouml.uml.diagram.DiagramSettings;
import org.tigris.gef.base.Selection;
import org.tigris.gef.graph.GraphModel;
public class FigSignal extends FigClassifierBoxWithAttributes
  { 
@SuppressWarnings("deprecation")

    @Deprecated
    public FigSignal(@SuppressWarnings("unused") GraphModel gm, Object node)
    { 
this();
setOwner(node);
} 

private void constructFigs()
    { 
getStereotypeFig().setKeyword("signal");
addFig(getBigPort());
addFig(getStereotypeFig());
addFig(getNameFig());
addFig(getOperationsFig());
addFig(getAttributesFig());
addFig(borderFig);
setOperationsVisible(false);
setAttributesVisible(false);
} 

public FigSignal(Object owner, Rectangle bounds, DiagramSettings settings)
    { 
super(owner, bounds, settings);
constructFigs();
} 

@Override
    protected void modelChanged(PropertyChangeEvent mee)
    { 
super.modelChanged(mee);
if(mee instanceof AssociationChangeEvent
                || mee instanceof AttributeChangeEvent)//1
{ 
renderingChanged();
updateListeners(getOwner(), getOwner());
} 

} 

@SuppressWarnings("deprecation")

    @Deprecated
    public FigSignal()
    { 
super();
constructFigs();
} 

@Override
    public Selection makeSelection()
    { 
return new SelectionSignal(this);
} 

@Override
    public Vector getPopUpActions(MouseEvent me)
    { 
Vector popUpActions = super.getPopUpActions(me);
return popUpActions;
} 

 } 


