
//#if -1916899748 
// Compilation Unit of /FigStereotypeDeclaration.java 
 

//#if 578862902 
package org.argouml.uml.diagram.static_structure.ui;
//#endif 


//#if -793780305 
import java.awt.Dimension;
//#endif 


//#if -807558970 
import java.awt.Rectangle;
//#endif 


//#if 1598268216 
import java.awt.event.MouseEvent;
//#endif 


//#if 1410390427 
import java.beans.PropertyChangeEvent;
//#endif 


//#if 1422344841 
import java.util.HashSet;
//#endif 


//#if -494881445 
import java.util.Set;
//#endif 


//#if -36748586 
import java.util.Vector;
//#endif 


//#if 1353551387 
import javax.swing.Action;
//#endif 


//#if 1546302030 
import org.argouml.model.AssociationChangeEvent;
//#endif 


//#if 810786537 
import org.argouml.model.AttributeChangeEvent;
//#endif 


//#if 704402486 
import org.argouml.model.Model;
//#endif 


//#if -103480634 
import org.argouml.ui.ArgoJMenu;
//#endif 


//#if -1527391719 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 629082852 
import org.argouml.uml.diagram.ui.ActionAddNote;
//#endif 


//#if 789044271 
import org.argouml.uml.diagram.ui.ActionCompartmentDisplay;
//#endif 


//#if -2095448781 
import org.argouml.uml.diagram.ui.ActionEdgesDisplay;
//#endif 


//#if -1288930026 
import org.argouml.uml.diagram.ui.CompartmentFigText;
//#endif 


//#if 457780164 
import org.argouml.uml.diagram.ui.FigCompartmentBox;
//#endif 


//#if -75740994 
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewTagDefinition;
//#endif 


//#if -2097593074 
import org.tigris.gef.base.Selection;
//#endif 


//#if 428668258 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if -995611946 
public class FigStereotypeDeclaration extends 
//#if 1166890256 
FigCompartmentBox
//#endif 

  { 

//#if 1500422479 
private static final long serialVersionUID = -2702539988691983863L;
//#endif 


//#if 1915754523 
@Override
    public Selection makeSelection()
    { 

//#if -1794190278 
return new SelectionStereotype(this);
//#endif 

} 

//#endif 


//#if -1205967938 
public FigStereotypeDeclaration(Object owner, Rectangle bounds,
                                    DiagramSettings settings)
    { 

//#if -249523627 
super(owner, bounds, settings);
//#endif 


//#if 638343173 
constructFigs();
//#endif 


//#if -1143795495 
enableSizeChecking(true);
//#endif 

} 

//#endif 


//#if -179221804 

//#if 1359362470 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigStereotypeDeclaration()
    { 

//#if -1949742110 
constructFigs();
//#endif 

} 

//#endif 


//#if 83050168 
@Override
    public Dimension getMinimumSize()
    { 

//#if -2102802091 
Dimension aSize = getNameFig().getMinimumSize();
//#endif 


//#if 2104980411 
aSize = addChildDimensions(aSize, getStereotypeFig());
//#endif 


//#if -1541964670 
aSize.width = Math.max(WIDTH, aSize.width);
//#endif 


//#if 1018654988 
return aSize;
//#endif 

} 

//#endif 


//#if -1923345865 
@Override
    protected void modelChanged(PropertyChangeEvent mee)
    { 

//#if -1962091275 
super.modelChanged(mee);
//#endif 


//#if -585037192 
if(mee instanceof AssociationChangeEvent
                || mee instanceof AttributeChangeEvent)//1
{ 

//#if -1749311174 
renderingChanged();
//#endif 


//#if -1748387244 
updateListeners(getOwner(), getOwner());
//#endif 


//#if 1623496947 
damage();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 359545880 
@Override
    protected void setStandardBounds(final int x, final int y,
                                     final int w, final int h)
    { 

//#if 1748087276 
Rectangle oldBounds = getBounds();
//#endif 


//#if 324822366 
getBigPort().setBounds(x, y, w, h);
//#endif 


//#if 17612149 
getBorderFig().setBounds(x, y, w, h);
//#endif 


//#if -537540092 
int currentHeight = 0;
//#endif 


//#if -712798856 
if(getStereotypeFig().isVisible())//1
{ 

//#if -1173366682 
int stereotypeHeight = getStereotypeFig().getMinimumSize().height;
//#endif 


//#if 563467507 
getStereotypeFig().setBounds(
                x,
                y,
                w,
                stereotypeHeight);
//#endif 


//#if -1955113521 
currentHeight = stereotypeHeight;
//#endif 

} 

//#endif 


//#if -1130161957 
int nameHeight = getNameFig().getMinimumSize().height;
//#endif 


//#if 194101395 
getNameFig().setBounds(x, y + currentHeight, w, nameHeight);
//#endif 


//#if -1430161270 
currentHeight += nameHeight;
//#endif 


//#if 154382461 
calcBounds();
//#endif 


//#if -165562368 
updateEdges();
//#endif 


//#if -1651050439 
firePropChange("bounds", oldBounds, getBounds());
//#endif 

} 

//#endif 


//#if 1835205326 
@Override
    protected CompartmentFigText unhighlight()
    { 

//#if 709859003 
CompartmentFigText fc = super.unhighlight();
//#endif 


//#if -1707676929 
if(fc == null)//1
{ 
} 

//#endif 


//#if 1684900630 
return fc;
//#endif 

} 

//#endif 


//#if -745173968 
@Override
    public Vector getPopUpActions(MouseEvent me)
    { 

//#if -1866584256 
Vector popUpActions = super.getPopUpActions(me);
//#endif 


//#if -1995524076 
ArgoJMenu addMenu = new ArgoJMenu("menu.popup.add");
//#endif 


//#if -947162996 
addMenu.add(new ActionAddNote());
//#endif 


//#if 753292570 
addMenu.add(new ActionNewTagDefinition());
//#endif 


//#if -2125921466 
addMenu.add(ActionEdgesDisplay.getShowEdges());
//#endif 


//#if -1235501407 
addMenu.add(ActionEdgesDisplay.getHideEdges());
//#endif 


//#if -1703462022 
popUpActions.add(popUpActions.size() - getPopupAddOffset(), addMenu);
//#endif 


//#if 184113928 
ArgoJMenu showMenu = new ArgoJMenu("menu.popup.show");
//#endif 


//#if 378925840 
for (Action action : ActionCompartmentDisplay.getActions()) //1
{ 

//#if -1192073368 
showMenu.add(action);
//#endif 

} 

//#endif 


//#if 1167737685 
if(showMenu.getComponentCount() > 0)//1
{ 

//#if -1117624606 
popUpActions.add(popUpActions.size() - getPopupAddOffset(),
                             showMenu);
//#endif 

} 

//#endif 


//#if 680747596 
popUpActions.add(popUpActions.size() - getPopupAddOffset(),
                         buildModifierPopUp(ABSTRACT | LEAF | ROOT));
//#endif 


//#if -988402985 
popUpActions.add(popUpActions.size() - getPopupAddOffset(),
                         buildVisibilityPopUp());
//#endif 


//#if 11605555 
return popUpActions;
//#endif 

} 

//#endif 


//#if -601403427 
private void constructFigs()
    { 

//#if 1563209707 
getStereotypeFig().setKeyword("stereotype");
//#endif 


//#if -718354810 
enableSizeChecking(false);
//#endif 


//#if 1301169026 
setSuppressCalcBounds(true);
//#endif 


//#if -2109055192 
addFig(getBigPort());
//#endif 


//#if -2002441863 
addFig(getStereotypeFig());
//#endif 


//#if 1356346112 
addFig(getNameFig());
//#endif 


//#if -382558913 
addFig(getBorderFig());
//#endif 


//#if 1646851475 
setSuppressCalcBounds(false);
//#endif 


//#if 963938863 
setBounds(X0, Y0, WIDTH, STEREOHEIGHT + NAME_FIG_HEIGHT);
//#endif 

} 

//#endif 


//#if -1560966645 

//#if 1731759390 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigStereotypeDeclaration(@SuppressWarnings("unused") GraphModel gm,
                                    Object node)
    { 

//#if 1898868257 
this();
//#endif 


//#if 2025607536 
setOwner(node);
//#endif 


//#if -1235907473 
enableSizeChecking(true);
//#endif 

} 

//#endif 


//#if -1342468405 
@Override
    protected void updateListeners(Object oldOwner, Object newOwner)
    { 

//#if 468687254 
Set<Object[]> listeners = new HashSet<Object[]>();
//#endif 


//#if 1673310295 
if(newOwner != null)//1
{ 

//#if 1037225990 
listeners.add(new Object[] {newOwner, null});
//#endif 


//#if 233652875 
for (Object td : Model.getFacade().getTagDefinitions(newOwner)) //1
{ 

//#if 808127902 
listeners.add(new Object[] {td,
                                            new String[] {"name", "tagType", "multiplicity"}
                                           });
//#endif 

} 

//#endif 

} 

//#endif 


//#if -882906265 
updateElementListeners(listeners);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

