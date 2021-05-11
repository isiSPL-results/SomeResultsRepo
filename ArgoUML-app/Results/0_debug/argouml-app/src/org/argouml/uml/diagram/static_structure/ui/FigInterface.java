
//#if -1156369852 
// Compilation Unit of /FigInterface.java 
 

//#if 167052166 
package org.argouml.uml.diagram.static_structure.ui;
//#endif 


//#if -1819744257 
import java.awt.Dimension;
//#endif 


//#if -1833522922 
import java.awt.Rectangle;
//#endif 


//#if 132960883 
import org.apache.log4j.Logger;
//#endif 


//#if 1980497382 
import org.argouml.model.Model;
//#endif 


//#if -10353220 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -846563675 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if -1956895799 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -883522497 
import org.tigris.gef.base.Editor;
//#endif 


//#if 531052378 
import org.tigris.gef.base.Globals;
//#endif 


//#if -1557206338 
import org.tigris.gef.base.Selection;
//#endif 


//#if 49278738 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if -888606243 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 264456823 
public class FigInterface extends 
//#if -1993456806 
FigClassifierBox
//#endif 

  { 

//#if -501172305 
private static final Logger LOG = Logger.getLogger(FigInterface.class);
//#endif 


//#if -706793499 
@Override
    public void setEnclosingFig(Fig encloser)
    { 

//#if -500518486 
Fig oldEncloser = getEnclosingFig();
//#endif 


//#if 831158276 
if(encloser == null
                || (encloser != null
                    && !Model.getFacade().isAInstance(encloser.getOwner())))//1
{ 

//#if 2013022989 
super.setEnclosingFig(encloser);
//#endif 

} 

//#endif 


//#if -2091357537 
if(!(Model.getFacade().isAModelElement(getOwner())))//1
{ 

//#if -170111613 
return;
//#endif 

} 

//#endif 


//#if -1170630238 
if(!isVisible())//1
{ 

//#if -1401485239 
return;
//#endif 

} 

//#endif 


//#if 545717552 
Object me = getOwner();
//#endif 


//#if -823509908 
Object m = null;
//#endif 


//#if 241930255 
try //1
{ 

//#if -1521185982 
if(encloser != null
                    && oldEncloser != encloser
                    && Model.getFacade().isAPackage(encloser.getOwner()))//1
{ 

//#if -929575854 
Model.getCoreHelper().setNamespace(me, encloser.getOwner());
//#endif 

} 

//#endif 


//#if -540846196 
if(Model.getFacade().getNamespace(me) == null
                    && (TargetManager.getInstance().getTarget()
                        instanceof ArgoDiagram))//1
{ 

//#if -1262726064 
m =
                    ((ArgoDiagram) TargetManager.getInstance().getTarget())
                    .getNamespace();
//#endif 


//#if 1190960310 
Model.getCoreHelper().setNamespace(me, m);
//#endif 

} 

//#endif 

} 

//#if 456249430 
catch (Exception e) //1
{ 

//#if -159970365 
LOG.error("could not set package due to:" + e
                      + "' at " + encloser, e);
//#endif 

} 

//#endif 


//#endif 


//#if 1927010273 
if(encloser != null
                && (Model.getFacade().isAComponent(encloser.getOwner())))//1
{ 

//#if 388428066 
moveIntoComponent(encloser);
//#endif 


//#if -1391596953 
super.setEnclosingFig(encloser);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1929447435 

//#if -1446287984 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigInterface(@SuppressWarnings("unused") GraphModel gm,
                        Object node)
    { 

//#if 1897412286 
this();
//#endif 


//#if -464114419 
setOwner(node);
//#endif 


//#if 735791052 
enableSizeChecking(true);
//#endif 

} 

//#endif 


//#if -1959959578 
public FigInterface(Object owner, Rectangle bounds,
                        DiagramSettings settings)
    { 

//#if -1394913348 
super(owner, bounds, settings);
//#endif 


//#if -626834688 
initialize();
//#endif 

} 

//#endif 


//#if -1351795660 
private void initialize()
    { 

//#if 459362562 
getStereotypeFig().setKeyword("interface");
//#endif 


//#if 1491357654 
enableSizeChecking(false);
//#endif 


//#if -1173964590 
setSuppressCalcBounds(true);
//#endif 


//#if 685494853 
Dimension size = new Dimension(0, 0);
//#endif 


//#if -1074248744 
addFig(getBigPort());
//#endif 


//#if 2074135081 
addFig(getStereotypeFig());
//#endif 


//#if 1912173829 
addChildDimensions(size, getStereotypeFig());
//#endif 


//#if -1903814736 
addFig(getNameFig());
//#endif 


//#if -1275127924 
addChildDimensions(size, getNameFig());
//#endif 


//#if -1271695313 
addFig(getOperationsFig());
//#endif 


//#if -1433656565 
addChildDimensions(size, getOperationsFig());
//#endif 


//#if -449156176 
addFig(borderFig);
//#endif 


//#if -2067846589 
setSuppressCalcBounds(false);
//#endif 


//#if -89320225 
enableSizeChecking(true);
//#endif 


//#if -1778359568 
setBounds(X0, Y0, size.width, size.height);
//#endif 

} 

//#endif 


//#if 1634359135 
@Override
    protected void setStandardBounds(final int x, final int y, final int w,
                                     final int h)
    { 

//#if -1073393942 
Rectangle oldBounds = getBounds();
//#endif 


//#if -1241749472 
getBigPort().setBounds(x, y, w, h);
//#endif 


//#if 208398626 
borderFig.setBounds(x, y, w, h);
//#endif 


//#if -1635879934 
int currentHeight = 0;
//#endif 


//#if -1952386058 
if(getStereotypeFig().isVisible())//1
{ 

//#if -1903457063 
int stereotypeHeight = getStereotypeFig().getMinimumSize().height;
//#endif 


//#if -1472205530 
getStereotypeFig().setBounds(
                x,
                y,
                w,
                stereotypeHeight);
//#endif 


//#if -1324771774 
currentHeight = stereotypeHeight;
//#endif 

} 

//#endif 


//#if -1571534119 
int nameHeight = getNameFig().getMinimumSize().height;
//#endif 


//#if 1899873169 
getNameFig().setBounds(x, y + currentHeight, w, nameHeight);
//#endif 


//#if -1153223476 
currentHeight += nameHeight;
//#endif 


//#if -1710252164 
if(getOperationsFig().isVisible())//1
{ 

//#if -1486351652 
int operationsY = y + currentHeight;
//#endif 


//#if -1454886905 
int operationsHeight = (h + y) - operationsY - 1;
//#endif 


//#if 2118438105 
getOperationsFig().setBounds(
                x,
                operationsY,
                w,
                operationsHeight);
//#endif 

} 

//#endif 


//#if -569691909 
calcBounds();
//#endif 


//#if -1137031358 
updateEdges();
//#endif 


//#if 2067585335 
firePropChange("bounds", oldBounds, getBounds());
//#endif 

} 

//#endif 


//#if 55018740 
@Override
    public Selection makeSelection()
    { 

//#if 217649568 
return new SelectionInterface(this);
//#endif 

} 

//#endif 


//#if -615318052 
@Override
    public String classNameAndBounds()
    { 

//#if -1297590565 
return super.classNameAndBounds()
               + "operationsVisible=" + isOperationsVisible();
//#endif 

} 

//#endif 


//#if -1765184257 
@Override
    public Dimension getMinimumSize()
    { 

//#if 283156098 
Dimension aSize = getNameFig().getMinimumSize();
//#endif 


//#if 1079434276 
aSize.height += NAME_V_PADDING * 2;
//#endif 


//#if 1226623857 
aSize.height = Math.max(NAME_FIG_HEIGHT, aSize.height);
//#endif 


//#if -420285656 
aSize = addChildDimensions(aSize, getStereotypeFig());
//#endif 


//#if 528851246 
aSize = addChildDimensions(aSize, getOperationsFig());
//#endif 


//#if 1446076213 
aSize.width = Math.max(WIDTH, aSize.width);
//#endif 


//#if 363089471 
return aSize;
//#endif 

} 

//#endif 


//#if 224971773 
@Override
    public void translate(int dx, int dy)
    { 

//#if -487544258 
super.translate(dx, dy);
//#endif 


//#if 930046245 
Editor ce = Globals.curEditor();
//#endif 


//#if -1308294908 
if(ce != null)//1
{ 

//#if -177737168 
Selection sel = ce.getSelectionManager().findSelectionFor(this);
//#endif 


//#if -624366098 
if(sel instanceof SelectionClass)//1
{ 

//#if 727452797 
((SelectionClass) sel).hideButtons();
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -134256834 

//#if 1058833056 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigInterface()
    { 

//#if 1962032623 
initialize();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

