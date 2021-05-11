package org.argouml.uml.diagram.static_structure.ui;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.Action;
import org.argouml.model.AddAssociationEvent;
import org.argouml.model.AssociationChangeEvent;
import org.argouml.model.Model;
import org.argouml.model.RemoveAssociationEvent;
import org.argouml.model.UmlChangeEvent;
import org.argouml.ui.ArgoJMenu;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.OperationsCompartmentContainer;
import org.argouml.uml.diagram.ui.ActionAddNote;
import org.argouml.uml.diagram.ui.ActionCompartmentDisplay;
import org.argouml.uml.diagram.ui.ActionEdgesDisplay;
import org.argouml.uml.diagram.ui.FigCompartmentBox;
import org.argouml.uml.diagram.ui.FigEmptyRect;
import org.argouml.uml.diagram.ui.FigOperationsCompartment;
import org.argouml.uml.ui.foundation.core.ActionAddOperation;
import org.tigris.gef.base.Editor;
import org.tigris.gef.base.Globals;
import org.tigris.gef.base.Selection;
import org.tigris.gef.presentation.Fig;
public abstract class FigClassifierBox extends FigCompartmentBox
 implements OperationsCompartmentContainer
  { 
private FigOperationsCompartment operationsFig;
protected Fig borderFig;
protected void updateOperations()
    { 
if(!isOperationsVisible())//1
{ 
return;
} 
operationsFig.populate();
setBounds(getBounds());
damage();
} 
public Rectangle getOperationsBounds()
    { 
return operationsFig.getBounds();
} 
protected FigOperationsCompartment getOperationsFig()
    { 
return operationsFig;
} 
public void propertyChange(PropertyChangeEvent event)
    { 
if(event.getPropertyName().equals("generalization")
                && Model.getFacade().isAGeneralization(event.getOldValue()))//1
{ 
return;
} 
else
if(event.getPropertyName().equals("association")
                   && Model.getFacade().isAAssociationEnd(event.getOldValue()))//1
{ 
return;
} 
else
if(event.getPropertyName().equals("supplierDependency")
                   && Model.getFacade().isAUsage(event.getOldValue()))//1
{ 
return;
} 
else
if(event.getPropertyName().equals("clientDependency")
                   && Model.getFacade().isAAbstraction(event.getOldValue()))//1
{ 
return;
} 
super.propertyChange(event);
} 
public void setOperationsVisible(boolean isVisible)
    { 
setCompartmentVisible(operationsFig, isVisible);
} 
private Rectangle getDefaultBounds()
    { 
Rectangle bounds = new Rectangle(DEFAULT_COMPARTMENT_BOUNDS);
bounds.y = DEFAULT_COMPARTMENT_BOUNDS.y + ROWHEIGHT + 1;
return bounds;
} 
protected ArgoJMenu buildAddMenu()
    { 
ArgoJMenu addMenu = new ArgoJMenu("menu.popup.add");
Action addOperation = new ActionAddOperation();
addOperation.setEnabled(isSingleTarget());
addMenu.insert(addOperation, 0);
addMenu.add(new ActionAddNote());
addMenu.add(ActionEdgesDisplay.getShowEdges());
addMenu.add(ActionEdgesDisplay.getHideEdges());
return addMenu;
} 
protected ArgoJMenu buildShowPopUp()
    { 
ArgoJMenu showMenu = super.buildShowPopUp();
Iterator i = ActionCompartmentDisplay.getActions().iterator();
while (i.hasNext()) //1
{ 
showMenu.add((Action) i.next());
} 
return showMenu;
} 
public Vector getPopUpActions(MouseEvent me)
    { 
Vector popUpActions = super.getPopUpActions(me);
ArgoJMenu addMenu = buildAddMenu();
popUpActions.add(
            popUpActions.size() - getPopupAddOffset(),
            addMenu);
popUpActions.add(
            popUpActions.size() - getPopupAddOffset(),
            buildModifierPopUp());
popUpActions.add(
            popUpActions.size() - getPopupAddOffset(),
            buildVisibilityPopUp());
return popUpActions;
} 
public void renderingChanged()
    { 
super.renderingChanged();
updateOperations();
} 
private void constructFigs()
    { 
getStereotypeFig().setFilled(true);
getStereotypeFig().setLineWidth(LINE_WIDTH);
getStereotypeFig().setHeight(STEREOHEIGHT + 1);
borderFig = new FigEmptyRect(X0, Y0, 0, 0);
borderFig.setLineWidth(LINE_WIDTH);
borderFig.setLineColor(LINE_COLOR);
getBigPort().setLineWidth(0);
getBigPort().setFillColor(FILL_COLOR);
} 
protected void updateLayout(UmlChangeEvent event)
    { 
super.updateLayout(event);
if(event instanceof AssociationChangeEvent
                && getOwner().equals(event.getSource()))//1
{ 
Object o = null;
if(event instanceof AddAssociationEvent)//1
{ 
o = event.getNewValue();
} 
else
if(event instanceof RemoveAssociationEvent)//1
{ 
o = event.getOldValue();
} 
if(Model.getFacade().isAOperation(o)
                    || Model.getFacade().isAReception(o))//1
{ 
updateOperations();
} 
} 
} 
@SuppressWarnings("deprecation")

    @Deprecated
    FigClassifierBox()
    { 
super();
Rectangle bounds = getDefaultBounds();
operationsFig = new FigOperationsCompartment(bounds.x, bounds.y,
                bounds.width, bounds.height);
constructFigs();
} 
protected Object buildModifierPopUp()
    { 
return buildModifierPopUp(ABSTRACT | LEAF | ROOT);
} 
public Object clone()
    { 
FigClassifierBox figClone = (FigClassifierBox) super.clone();
Iterator thisIter = this.getFigs().iterator();
while (thisIter.hasNext()) //1
{ 
Fig thisFig = (Fig) thisIter.next();
if(thisFig == operationsFig)//1
{ 
figClone.operationsFig = (FigOperationsCompartment) thisFig;
return figClone;
} 
} 
return figClone;
} 
public String classNameAndBounds()
    { 
return super.classNameAndBounds()
               + "operationsVisible=" + isOperationsVisible() + ";";
} 
public boolean isOperationsVisible()
    { 
return operationsFig != null && operationsFig.isVisible();
} 
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
public FigClassifierBox(Object owner, Rectangle bounds,
                            DiagramSettings settings)
    { 
super(owner, bounds, settings);
operationsFig = new FigOperationsCompartment(owner, getDefaultBounds(),
                getSettings());
constructFigs();
} 

 } 
