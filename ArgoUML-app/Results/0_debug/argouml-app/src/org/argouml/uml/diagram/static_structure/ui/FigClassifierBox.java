
//#if 816255626 
// Compilation Unit of /FigClassifierBox.java 
 

//#if 1092267854 
package org.argouml.uml.diagram.static_structure.ui;
//#endif 


//#if -409501986 
import java.awt.Rectangle;
//#endif 


//#if -680510944 
import java.awt.event.MouseEvent;
//#endif 


//#if -1707715661 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -753207389 
import java.util.Iterator;
//#endif 


//#if -31865106 
import java.util.Vector;
//#endif 


//#if 1751608371 
import javax.swing.Action;
//#endif 


//#if -1044639731 
import org.argouml.model.AddAssociationEvent;
//#endif 


//#if -357536154 
import org.argouml.model.AssociationChangeEvent;
//#endif 


//#if -89029346 
import org.argouml.model.Model;
//#endif 


//#if 401801010 
import org.argouml.model.RemoveAssociationEvent;
//#endif 


//#if -1979300295 
import org.argouml.model.UmlChangeEvent;
//#endif 


//#if 1069936350 
import org.argouml.ui.ArgoJMenu;
//#endif 


//#if 1597782785 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 1068170148 
import org.argouml.uml.diagram.OperationsCompartmentContainer;
//#endif 


//#if -1274755332 
import org.argouml.uml.diagram.ui.ActionAddNote;
//#endif 


//#if -109305577 
import org.argouml.uml.diagram.ui.ActionCompartmentDisplay;
//#endif 


//#if 935202843 
import org.argouml.uml.diagram.ui.ActionEdgesDisplay;
//#endif 


//#if 971185116 
import org.argouml.uml.diagram.ui.FigCompartmentBox;
//#endif 


//#if 1738051760 
import org.argouml.uml.diagram.ui.FigEmptyRect;
//#endif 


//#if 1523666523 
import org.argouml.uml.diagram.ui.FigOperationsCompartment;
//#endif 


//#if -279357774 
import org.argouml.uml.ui.foundation.core.ActionAddOperation;
//#endif 


//#if 101257735 
import org.tigris.gef.base.Editor;
//#endif 


//#if 994468498 
import org.tigris.gef.base.Globals;
//#endif 


//#if 1404053494 
import org.tigris.gef.base.Selection;
//#endif 


//#if 1613742357 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 906028302 
public abstract class FigClassifierBox extends 
//#if -211091233 
FigCompartmentBox
//#endif 

 implements 
//#if -1097213447 
OperationsCompartmentContainer
//#endif 

  { 

//#if -150126966 
private FigOperationsCompartment operationsFig;
//#endif 


//#if -1036465545 
protected Fig borderFig;
//#endif 


//#if -2108058790 
protected void updateOperations()
    { 

//#if 2030332863 
if(!isOperationsVisible())//1
{ 

//#if -483135299 
return;
//#endif 

} 

//#endif 


//#if -1969495126 
operationsFig.populate();
//#endif 


//#if 659047005 
setBounds(getBounds());
//#endif 


//#if -398463109 
damage();
//#endif 

} 

//#endif 


//#if -1603945424 
public Rectangle getOperationsBounds()
    { 

//#if 2017706384 
return operationsFig.getBounds();
//#endif 

} 

//#endif 


//#if 1780338037 
protected FigOperationsCompartment getOperationsFig()
    { 

//#if 1122750017 
return operationsFig;
//#endif 

} 

//#endif 


//#if -1532362212 
public void propertyChange(PropertyChangeEvent event)
    { 

//#if -157921587 
if(event.getPropertyName().equals("generalization")
                && Model.getFacade().isAGeneralization(event.getOldValue()))//1
{ 

//#if -506765561 
return;
//#endif 

} 
else

//#if -1203971976 
if(event.getPropertyName().equals("association")
                   && Model.getFacade().isAAssociationEnd(event.getOldValue()))//1
{ 

//#if 511741727 
return;
//#endif 

} 
else

//#if 1486424265 
if(event.getPropertyName().equals("supplierDependency")
                   && Model.getFacade().isAUsage(event.getOldValue()))//1
{ 

//#if -2105000745 
return;
//#endif 

} 
else

//#if 447300267 
if(event.getPropertyName().equals("clientDependency")
                   && Model.getFacade().isAAbstraction(event.getOldValue()))//1
{ 

//#if 854043064 
return;
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#if 674297628 
super.propertyChange(event);
//#endif 

} 

//#endif 


//#if -1303293024 
public void setOperationsVisible(boolean isVisible)
    { 

//#if 2119607727 
setCompartmentVisible(operationsFig, isVisible);
//#endif 

} 

//#endif 


//#if 633480779 
private Rectangle getDefaultBounds()
    { 

//#if -58317884 
Rectangle bounds = new Rectangle(DEFAULT_COMPARTMENT_BOUNDS);
//#endif 


//#if 129722533 
bounds.y = DEFAULT_COMPARTMENT_BOUNDS.y + ROWHEIGHT + 1;
//#endif 


//#if 1760655688 
return bounds;
//#endif 

} 

//#endif 


//#if -2032466989 
protected ArgoJMenu buildAddMenu()
    { 

//#if -362413373 
ArgoJMenu addMenu = new ArgoJMenu("menu.popup.add");
//#endif 


//#if -1702496983 
Action addOperation = new ActionAddOperation();
//#endif 


//#if -1378104307 
addOperation.setEnabled(isSingleTarget());
//#endif 


//#if 1646331463 
addMenu.insert(addOperation, 0);
//#endif 


//#if 1456732475 
addMenu.add(new ActionAddNote());
//#endif 


//#if 697706167 
addMenu.add(ActionEdgesDisplay.getShowEdges());
//#endif 


//#if 1588126226 
addMenu.add(ActionEdgesDisplay.getHideEdges());
//#endif 


//#if 363493633 
return addMenu;
//#endif 

} 

//#endif 


//#if -1712923198 
protected ArgoJMenu buildShowPopUp()
    { 

//#if 860309871 
ArgoJMenu showMenu = super.buildShowPopUp();
//#endif 


//#if 1233438918 
Iterator i = ActionCompartmentDisplay.getActions().iterator();
//#endif 


//#if -74436844 
while (i.hasNext()) //1
{ 

//#if -843278234 
showMenu.add((Action) i.next());
//#endif 

} 

//#endif 


//#if 899226857 
return showMenu;
//#endif 

} 

//#endif 


//#if -673667535 
public Vector getPopUpActions(MouseEvent me)
    { 

//#if -1447736547 
Vector popUpActions = super.getPopUpActions(me);
//#endif 


//#if 518249765 
ArgoJMenu addMenu = buildAddMenu();
//#endif 


//#if -838788163 
popUpActions.add(
            popUpActions.size() - getPopupAddOffset(),
            addMenu);
//#endif 


//#if 1437276111 
popUpActions.add(
            popUpActions.size() - getPopupAddOffset(),
            buildModifierPopUp());
//#endif 


//#if -1715643340 
popUpActions.add(
            popUpActions.size() - getPopupAddOffset(),
            buildVisibilityPopUp());
//#endif 


//#if -766456752 
return popUpActions;
//#endif 

} 

//#endif 


//#if -489665852 
public void renderingChanged()
    { 

//#if -1995406028 
super.renderingChanged();
//#endif 


//#if -1333763654 
updateOperations();
//#endif 

} 

//#endif 


//#if 215776494 
private void constructFigs()
    { 

//#if -41717036 
getStereotypeFig().setFilled(true);
//#endif 


//#if -89681419 
getStereotypeFig().setLineWidth(LINE_WIDTH);
//#endif 


//#if 560599590 
getStereotypeFig().setHeight(STEREOHEIGHT + 1);
//#endif 


//#if -475468316 
borderFig = new FigEmptyRect(X0, Y0, 0, 0);
//#endif 


//#if -270418354 
borderFig.setLineWidth(LINE_WIDTH);
//#endif 


//#if 2132152878 
borderFig.setLineColor(LINE_COLOR);
//#endif 


//#if -1760385109 
getBigPort().setLineWidth(0);
//#endif 


//#if 365941282 
getBigPort().setFillColor(FILL_COLOR);
//#endif 

} 

//#endif 


//#if -1813871114 
protected void updateLayout(UmlChangeEvent event)
    { 

//#if -533856613 
super.updateLayout(event);
//#endif 


//#if 551045825 
if(event instanceof AssociationChangeEvent
                && getOwner().equals(event.getSource()))//1
{ 

//#if 78025196 
Object o = null;
//#endif 


//#if 210212908 
if(event instanceof AddAssociationEvent)//1
{ 

//#if -714267504 
o = event.getNewValue();
//#endif 

} 
else

//#if -1652569153 
if(event instanceof RemoveAssociationEvent)//1
{ 

//#if 2107591827 
o = event.getOldValue();
//#endif 

} 

//#endif 


//#endif 


//#if -464677360 
if(Model.getFacade().isAOperation(o)
                    || Model.getFacade().isAReception(o))//1
{ 

//#if -1702269740 
updateOperations();
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1948808708 

//#if 815977421 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    FigClassifierBox()
    { 

//#if -1816685833 
super();
//#endif 


//#if -1328974295 
Rectangle bounds = getDefaultBounds();
//#endif 


//#if 2065067541 
operationsFig = new FigOperationsCompartment(bounds.x, bounds.y,
                bounds.width, bounds.height);
//#endif 


//#if 557888812 
constructFigs();
//#endif 

} 

//#endif 


//#if 41071351 
protected Object buildModifierPopUp()
    { 

//#if -744383610 
return buildModifierPopUp(ABSTRACT | LEAF | ROOT);
//#endif 

} 

//#endif 


//#if -1534870952 
public Object clone()
    { 

//#if -2116951200 
FigClassifierBox figClone = (FigClassifierBox) super.clone();
//#endif 


//#if -1922571324 
Iterator thisIter = this.getFigs().iterator();
//#endif 


//#if -1508315394 
while (thisIter.hasNext()) //1
{ 

//#if 1407186084 
Fig thisFig = (Fig) thisIter.next();
//#endif 


//#if -1130186974 
if(thisFig == operationsFig)//1
{ 

//#if 771659137 
figClone.operationsFig = (FigOperationsCompartment) thisFig;
//#endif 


//#if -1686543579 
return figClone;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 657447561 
return figClone;
//#endif 

} 

//#endif 


//#if 102224930 
public String classNameAndBounds()
    { 

//#if -1998087679 
return super.classNameAndBounds()
               + "operationsVisible=" + isOperationsVisible() + ";";
//#endif 

} 

//#endif 


//#if 1382027548 
public boolean isOperationsVisible()
    { 

//#if 1750200795 
return operationsFig != null && operationsFig.isVisible();
//#endif 

} 

//#endif 


//#if 942514755 
public void translate(int dx, int dy)
    { 

//#if 1900732363 
super.translate(dx, dy);
//#endif 


//#if -413370126 
Editor ce = Globals.curEditor();
//#endif 


//#if -773844079 
if(ce != null)//1
{ 

//#if 1499879443 
Selection sel = ce.getSelectionManager().findSelectionFor(this);
//#endif 


//#if -319491605 
if(sel instanceof SelectionClass)//1
{ 

//#if -1187860250 
((SelectionClass) sel).hideButtons();
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -203506421 
public FigClassifierBox(Object owner, Rectangle bounds,
                            DiagramSettings settings)
    { 

//#if -1806317411 
super(owner, bounds, settings);
//#endif 


//#if -2091199826 
operationsFig = new FigOperationsCompartment(owner, getDefaultBounds(),
                getSettings());
//#endif 


//#if -1472951107 
constructFigs();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

