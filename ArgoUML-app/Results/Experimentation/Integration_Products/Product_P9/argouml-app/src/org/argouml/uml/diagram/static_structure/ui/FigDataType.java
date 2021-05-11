package org.argouml.uml.diagram.static_structure.ui;
import java.awt.Dimension;
import java.awt.Rectangle;
import org.apache.log4j.Logger;
import org.argouml.model.Model;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.uml.diagram.DiagramSettings;
import org.tigris.gef.base.Editor;
import org.tigris.gef.base.Globals;
import org.tigris.gef.base.Selection;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.presentation.Fig;
public class FigDataType extends FigClassifierBox
  { 
private static final Logger LOG = Logger.getLogger(FigDataType.class);
private static final int MIN_WIDTH = 40;
@Override
    protected void setStandardBounds(final int x, final int y, final int w,
                                     final int h)
    { 
Rectangle oldBounds = getBounds();
getBigPort().setBounds(x, y, w, h);
borderFig.setBounds(x, y, w, h);
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
if(getOperationsFig().isVisible())//1
{ 
int operationsY = y + currentHeight;
int operationsHeight = (h + y) - operationsY - LINE_WIDTH;
getOperationsFig().setBounds(
                x,
                operationsY,
                w,
                operationsHeight);
} 
calcBounds();
updateEdges();
firePropChange("bounds", oldBounds, getBounds());
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public FigDataType(@SuppressWarnings("unused") GraphModel gm, Object node)
    { 
this();
setOwner(node);
enableSizeChecking(true);
} 
@Override
    public void setEnclosingFig(Fig encloser)
    { 
Fig oldEncloser = getEnclosingFig();
if(encloser == null
                || (encloser != null
                    && !Model.getFacade().isAInstance(encloser.getOwner())))//1
{ 
super.setEnclosingFig(encloser);
} 
if(!(Model.getFacade().isAUMLElement(getOwner())))//1
{ 
return;
} 
if(!isVisible())//1
{ 
return;
} 
Object me = getOwner();
Object m = null;
try//1
{ 
if(encloser != null
                    && oldEncloser != encloser
                    && Model.getFacade().isAPackage(encloser.getOwner()))//1
{ 
Model.getCoreHelper().setNamespace(me, encloser.getOwner());
} 
if(Model.getFacade().getNamespace(me) == null
                    && (TargetManager.getInstance().getTarget()
                        instanceof ArgoDiagram))//1
{ 
m =
                    ((ArgoDiagram) TargetManager.getInstance().getTarget())
                    .getNamespace();
Model.getCoreHelper().setNamespace(me, m);
} 
} 
catch (Exception e) //1
{ 
LOG.error("could not set package due to:" + e
                      + "' at " + encloser, e);
} 
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public FigDataType()
    { 
constructFigs();
} 
protected String getKeyword()
    { 
return "datatype";
} 
@Override
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
private void constructFigs()
    { 
getStereotypeFig().setKeyword(getKeyword());
setSuppressCalcBounds(true);
addFig(getBigPort());
addFig(getStereotypeFig());
addFig(getNameFig());
addFig(getOperationsFig());
addFig(borderFig);
setSuppressCalcBounds(false);
enableSizeChecking(true);
super.setStandardBounds(X0, Y0, WIDTH, NAME_FIG_HEIGHT + ROWHEIGHT);
} 
@Override
    public Dimension getMinimumSize()
    { 
Dimension aSize = getNameFig().getMinimumSize();
aSize.height += NAME_V_PADDING * 2;
aSize.height = Math.max(NAME_FIG_HEIGHT, aSize.height);
aSize = addChildDimensions(aSize, getStereotypeFig());
aSize = addChildDimensions(aSize, getOperationsFig());
aSize.width = Math.max(MIN_WIDTH, aSize.width);
return aSize;
} 
@Override
    public String classNameAndBounds()
    { 
return super.classNameAndBounds()
               + "operationsVisible=" + isOperationsVisible();
} 
public FigDataType(GraphModel gm, Object node, String keyword)
    { 
this(gm, node);
getStereotypeFig().setKeyword(keyword);
} 
@Override
    public Selection makeSelection()
    { 
return new SelectionDataType(this);
} 
public FigDataType(Object owner, Rectangle bounds,
                       DiagramSettings settings)
    { 
super(owner, bounds, settings);
constructFigs();
} 
@Override
    public int getLineWidth()
    { 
return borderFig.getLineWidth();
} 

 } 
