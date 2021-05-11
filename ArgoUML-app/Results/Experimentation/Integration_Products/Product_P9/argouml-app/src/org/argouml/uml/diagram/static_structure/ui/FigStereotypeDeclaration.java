package org.argouml.uml.diagram.static_structure.ui;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import javax.swing.Action;
import org.argouml.model.AssociationChangeEvent;
import org.argouml.model.AttributeChangeEvent;
import org.argouml.model.Model;
import org.argouml.ui.ArgoJMenu;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.ui.ActionAddNote;
import org.argouml.uml.diagram.ui.ActionCompartmentDisplay;
import org.argouml.uml.diagram.ui.ActionEdgesDisplay;
import org.argouml.uml.diagram.ui.CompartmentFigText;
import org.argouml.uml.diagram.ui.FigCompartmentBox;
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewTagDefinition;
import org.tigris.gef.base.Selection;
import org.tigris.gef.graph.GraphModel;
public class FigStereotypeDeclaration extends FigCompartmentBox
  { 
private static final long serialVersionUID = -2702539988691983863L;
@Override
    public Selection makeSelection()
    { 
return new SelectionStereotype(this);
} 
public FigStereotypeDeclaration(Object owner, Rectangle bounds,
                                    DiagramSettings settings)
    { 
super(owner, bounds, settings);
constructFigs();
enableSizeChecking(true);
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public FigStereotypeDeclaration()
    { 
constructFigs();
} 
@Override
    public Dimension getMinimumSize()
    { 
Dimension aSize = getNameFig().getMinimumSize();
aSize = addChildDimensions(aSize, getStereotypeFig());
aSize.width = Math.max(WIDTH, aSize.width);
return aSize;
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
damage();
} 
} 
@Override
    protected void setStandardBounds(final int x, final int y,
                                     final int w, final int h)
    { 
Rectangle oldBounds = getBounds();
getBigPort().setBounds(x, y, w, h);
getBorderFig().setBounds(x, y, w, h);
int currentHeight = 0;
if(getStereotypeFig().isVisible())//1
{ 
int stereotypeHeight = getStereotypeFig().getMinimumSize().height;
getStereotypeFig().setBounds(
                x,
                y,
                w,
                stereotypeHeight);
currentHeight = stereotypeHeight;
} 
int nameHeight = getNameFig().getMinimumSize().height;
getNameFig().setBounds(x, y + currentHeight, w, nameHeight);
currentHeight += nameHeight;
calcBounds();
updateEdges();
firePropChange("bounds", oldBounds, getBounds());
} 
@Override
    protected CompartmentFigText unhighlight()
    { 
CompartmentFigText fc = super.unhighlight();
if(fc == null)//1
{ 
} 
return fc;
} 
@Override
    public Vector getPopUpActions(MouseEvent me)
    { 
Vector popUpActions = super.getPopUpActions(me);
ArgoJMenu addMenu = new ArgoJMenu("menu.popup.add");
addMenu.add(new ActionAddNote());
addMenu.add(new ActionNewTagDefinition());
addMenu.add(ActionEdgesDisplay.getShowEdges());
addMenu.add(ActionEdgesDisplay.getHideEdges());
popUpActions.add(popUpActions.size() - getPopupAddOffset(), addMenu);
ArgoJMenu showMenu = new ArgoJMenu("menu.popup.show");
for (Action action : ActionCompartmentDisplay.getActions()) //1
{ 
showMenu.add(action);
} 
if(showMenu.getComponentCount() > 0)//1
{ 
popUpActions.add(popUpActions.size() - getPopupAddOffset(),
                             showMenu);
} 
popUpActions.add(popUpActions.size() - getPopupAddOffset(),
                         buildModifierPopUp(ABSTRACT | LEAF | ROOT));
popUpActions.add(popUpActions.size() - getPopupAddOffset(),
                         buildVisibilityPopUp());
return popUpActions;
} 
private void constructFigs()
    { 
getStereotypeFig().setKeyword("stereotype");
enableSizeChecking(false);
setSuppressCalcBounds(true);
addFig(getBigPort());
addFig(getStereotypeFig());
addFig(getNameFig());
addFig(getBorderFig());
setSuppressCalcBounds(false);
setBounds(X0, Y0, WIDTH, STEREOHEIGHT + NAME_FIG_HEIGHT);
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public FigStereotypeDeclaration(@SuppressWarnings("unused") GraphModel gm,
                                    Object node)
    { 
this();
setOwner(node);
enableSizeChecking(true);
} 
@Override
    protected void updateListeners(Object oldOwner, Object newOwner)
    { 
Set<Object[]> listeners = new HashSet<Object[]>();
if(newOwner != null)//1
{ 
listeners.add(new Object[] {newOwner, null});
for (Object td : Model.getFacade().getTagDefinitions(newOwner)) //1
{ 
listeners.add(new Object[] {td,
                                            new String[] {"name", "tagType", "multiplicity"}
                                           });
} 
} 
updateElementListeners(listeners);
} 

 } 
