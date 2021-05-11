
//#if -839308237 
// Compilation Unit of /FigDataType.java 
 

//#if -1105100633 
package org.argouml.uml.diagram.static_structure.ui;
//#endif 


//#if -1776087968 
import java.awt.Dimension;
//#endif 


//#if -1789866633 
import java.awt.Rectangle;
//#endif 


//#if -1450229070 
import org.apache.log4j.Logger;
//#endif 


//#if 397307429 
import org.argouml.model.Model;
//#endif 


//#if 891115293 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 289636452 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if -739494392 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 1635432352 
import org.tigris.gef.base.Editor;
//#endif 


//#if 1309241369 
import org.tigris.gef.base.Globals;
//#endif 


//#if -1041895491 
import org.tigris.gef.base.Selection;
//#endif 


//#if 1341763665 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if 403878684 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 511684677 
public class FigDataType extends 
//#if 752966751 
FigClassifierBox
//#endif 

  { 

//#if -110849077 
private static final Logger LOG = Logger.getLogger(FigDataType.class);
//#endif 


//#if -1381451958 
private static final int MIN_WIDTH = 40;
//#endif 


//#if 613599332 
@Override
    protected void setStandardBounds(final int x, final int y, final int w,
                                     final int h)
    { 

//#if 2075435015 
Rectangle oldBounds = getBounds();
//#endif 


//#if 1882667683 
getBigPort().setBounds(x, y, w, h);
//#endif 


//#if 50781567 
borderFig.setBounds(x, y, w, h);
//#endif 


//#if -793720673 
int currentHeight = 0;
//#endif 


//#if 1592015699 
if(getStereotypeFig().isVisible())//1
{ 

//#if -576537597 
int stereotypeHeight = getStereotypeFig().getMinimumSize().height;
//#endif 


//#if 298199248 
getStereotypeFig().setBounds(
                x,
                y,
                w,
                stereotypeHeight);
//#endif 


//#if -1042813588 
currentHeight = stereotypeHeight;
//#endif 

} 

//#endif 


//#if -2088440970 
int nameHeight = getNameFig().getMinimumSize().height;
//#endif 


//#if 297979310 
getNameFig().setBounds(x, y + currentHeight, w, nameHeight);
//#endif 


//#if -1532828273 
currentHeight += nameHeight;
//#endif 


//#if 1834149593 
if(getOperationsFig().isVisible())//1
{ 

//#if -612469982 
int operationsY = y + currentHeight;
//#endif 


//#if -310545527 
int operationsHeight = (h + y) - operationsY - LINE_WIDTH;
//#endif 


//#if 702059807 
getOperationsFig().setBounds(
                x,
                operationsY,
                w,
                operationsHeight);
//#endif 

} 

//#endif 


//#if 1733066584 
calcBounds();
//#endif 


//#if 1529005189 
updateEdges();
//#endif 


//#if -613920684 
firePropChange("bounds", oldBounds, getBounds());
//#endif 

} 

//#endif 


//#if -265886403 

//#if 1281660506 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigDataType(@SuppressWarnings("unused") GraphModel gm, Object node)
    { 

//#if 880145426 
this();
//#endif 


//#if 656103009 
setOwner(node);
//#endif 


//#if -133441504 
enableSizeChecking(true);
//#endif 

} 

//#endif 


//#if -621136320 
@Override
    public void setEnclosingFig(Fig encloser)
    { 

//#if -758656766 
Fig oldEncloser = getEnclosingFig();
//#endif 


//#if -2118393428 
if(encloser == null
                || (encloser != null
                    && !Model.getFacade().isAInstance(encloser.getOwner())))//1
{ 

//#if 260281312 
super.setEnclosingFig(encloser);
//#endif 

} 

//#endif 


//#if -585333854 
if(!(Model.getFacade().isAUMLElement(getOwner())))//1
{ 

//#if -362312360 
return;
//#endif 

} 

//#endif 


//#if -1350962438 
if(!isVisible())//1
{ 

//#if 965923638 
return;
//#endif 

} 

//#endif 


//#if -749613352 
Object me = getOwner();
//#endif 


//#if 1818130372 
Object m = null;
//#endif 


//#if -1847793737 
try //1
{ 

//#if 452609847 
if(encloser != null
                    && oldEncloser != encloser
                    && Model.getFacade().isAPackage(encloser.getOwner()))//1
{ 

//#if 391279479 
Model.getCoreHelper().setNamespace(me, encloser.getOwner());
//#endif 

} 

//#endif 


//#if -1289451135 
if(Model.getFacade().getNamespace(me) == null
                    && (TargetManager.getInstance().getTarget()
                        instanceof ArgoDiagram))//1
{ 

//#if 928447610 
m =
                    ((ArgoDiagram) TargetManager.getInstance().getTarget())
                    .getNamespace();
//#endif 


//#if -1388260916 
Model.getCoreHelper().setNamespace(me, m);
//#endif 

} 

//#endif 

} 

//#if -1048451796 
catch (Exception e) //1
{ 

//#if 680859879 
LOG.error("could not set package due to:" + e
                      + "' at " + encloser, e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 102282886 

//#if -230731598 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigDataType()
    { 

//#if -1866590981 
constructFigs();
//#endif 

} 

//#endif 


//#if 1286765882 
protected String getKeyword()
    { 

//#if 763769568 
return "datatype";
//#endif 

} 

//#endif 


//#if 728920728 
@Override
    public void translate(int dx, int dy)
    { 

//#if 2019437318 
super.translate(dx, dy);
//#endif 


//#if -1197790227 
Editor ce = Globals.curEditor();
//#endif 


//#if 423872972 
if(ce != null)//1
{ 

//#if -8106105 
Selection sel = ce.getSelectionManager().findSelectionFor(this);
//#endif 


//#if -49106185 
if(sel instanceof SelectionClass)//1
{ 

//#if -106897852 
((SelectionClass) sel).hideButtons();
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 360860969 
private void constructFigs()
    { 

//#if 1278830661 
getStereotypeFig().setKeyword(getKeyword());
//#endif 


//#if -763328202 
setSuppressCalcBounds(true);
//#endif 


//#if -1328260108 
addFig(getBigPort());
//#endif 


//#if -1237754555 
addFig(getStereotypeFig());
//#endif 


//#if 2137141196 
addFig(getNameFig());
//#endif 


//#if -288617653 
addFig(getOperationsFig());
//#endif 


//#if 1422305556 
addFig(borderFig);
//#endif 


//#if 2071946847 
setSuppressCalcBounds(false);
//#endif 


//#if 1900527355 
enableSizeChecking(true);
//#endif 


//#if -173253663 
super.setStandardBounds(X0, Y0, WIDTH, NAME_FIG_HEIGHT + ROWHEIGHT);
//#endif 

} 

//#endif 


//#if 1576208132 
@Override
    public Dimension getMinimumSize()
    { 

//#if -1837975140 
Dimension aSize = getNameFig().getMinimumSize();
//#endif 


//#if -1778447170 
aSize.height += NAME_V_PADDING * 2;
//#endif 


//#if -1947934953 
aSize.height = Math.max(NAME_FIG_HEIGHT, aSize.height);
//#endif 


//#if 447140546 
aSize = addChildDimensions(aSize, getStereotypeFig());
//#endif 


//#if 1396277448 
aSize = addChildDimensions(aSize, getOperationsFig());
//#endif 


//#if 96138190 
aSize.width = Math.max(MIN_WIDTH, aSize.width);
//#endif 


//#if -984252443 
return aSize;
//#endif 

} 

//#endif 


//#if -111369097 
@Override
    public String classNameAndBounds()
    { 

//#if -1682073127 
return super.classNameAndBounds()
               + "operationsVisible=" + isOperationsVisible();
//#endif 

} 

//#endif 


//#if -2042773805 
public FigDataType(GraphModel gm, Object node, String keyword)
    { 

//#if 296807886 
this(gm, node);
//#endif 


//#if 1514231757 
getStereotypeFig().setKeyword(keyword);
//#endif 

} 

//#endif 


//#if -114289073 
@Override
    public Selection makeSelection()
    { 

//#if 1099210835 
return new SelectionDataType(this);
//#endif 

} 

//#endif 


//#if 1665436114 
public FigDataType(Object owner, Rectangle bounds,
                       DiagramSettings settings)
    { 

//#if 972425595 
super(owner, bounds, settings);
//#endif 


//#if 1747335967 
constructFigs();
//#endif 

} 

//#endif 


//#if 390865456 
@Override
    public int getLineWidth()
    { 

//#if -751809037 
return borderFig.getLineWidth();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

