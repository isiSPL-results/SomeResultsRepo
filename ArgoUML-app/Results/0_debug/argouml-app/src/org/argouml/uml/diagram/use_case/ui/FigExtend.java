
//#if 553897603 
// Compilation Unit of /FigExtend.java 
 

//#if -309065277 
package org.argouml.uml.diagram.use_case.ui;
//#endif 


//#if -228252017 
import java.awt.Graphics;
//#endif 


//#if -375426803 
import java.awt.Rectangle;
//#endif 


//#if 1878095714 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -1057567390 
import java.util.HashSet;
//#endif 


//#if -346975052 
import java.util.Set;
//#endif 


//#if 1778686031 
import org.argouml.model.Model;
//#endif 


//#if 1764581687 
import org.argouml.notation.providers.uml.NotationUtilityUml;
//#endif 


//#if -728970190 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 1966892912 
import org.argouml.uml.diagram.ui.ArgoFigText;
//#endif 


//#if 544012308 
import org.argouml.uml.diagram.ui.FigEdgeModelElement;
//#endif 


//#if 1989288320 
import org.argouml.uml.diagram.ui.FigTextGroup;
//#endif 


//#if 725041051 
import org.argouml.uml.diagram.ui.PathItemPlacement;
//#endif 


//#if -382359045 
import org.tigris.gef.presentation.ArrowHeadGreater;
//#endif 


//#if 1104745286 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 2144334917 
public class FigExtend extends 
//#if -1171683798 
FigEdgeModelElement
//#endif 

  { 

//#if 2017177231 
private static final int DEFAULT_WIDTH = 90;
//#endif 


//#if -1557191398 
private static final long serialVersionUID = -8026008987096598742L;
//#endif 


//#if -543453114 
private ArgoFigText label;
//#endif 


//#if -1204482177 
private ArgoFigText condition;
//#endif 


//#if 300770099 
private FigTextGroup fg;
//#endif 


//#if -1487546802 
private ArrowHeadGreater endArrow = new ArrowHeadGreater();
//#endif 


//#if 1502619429 
public FigExtend(Object owner, DiagramSettings settings)
    { 

//#if 1451747703 
super(owner, settings);
//#endif 


//#if -2067297847 
initialize(owner);
//#endif 

} 

//#endif 


//#if -444136280 
@Override
    public void renderingChanged()
    { 

//#if 1779293946 
super.renderingChanged();
//#endif 


//#if -2144582624 
updateConditionText();
//#endif 


//#if 2113480852 
updateLabel();
//#endif 

} 

//#endif 


//#if -2117021196 
protected void updateLabel()
    { 

//#if -450321678 
label.setText(getLabel());
//#endif 

} 

//#endif 


//#if 1983097462 
@Override
    public void paint(Graphics g)
    { 

//#if -1054589603 
endArrow.setLineColor(getLineColor());
//#endif 


//#if 2085612422 
super.paint(g);
//#endif 

} 

//#endif 


//#if -1543085728 
@Override
    public void setFig(Fig f)
    { 

//#if 1855909418 
super.setFig(f);
//#endif 


//#if 463568634 
setDashed(true);
//#endif 

} 

//#endif 


//#if 1819301864 
protected void updateConditionText()
    { 

//#if 895367774 
if(getOwner() == null)//1
{ 

//#if 1894988095 
return;
//#endif 

} 

//#endif 


//#if -44269474 
Object c = Model.getFacade().getCondition(getOwner());
//#endif 


//#if 209655489 
if(c == null)//1
{ 

//#if -1150303787 
condition.setText("");
//#endif 

} 
else
{ 

//#if 753839670 
Object expr = Model.getFacade().getBody(c);
//#endif 


//#if 1314779987 
if(expr == null)//1
{ 

//#if -967243285 
condition.setText("");
//#endif 

} 
else
{ 

//#if 1308760391 
condition.setText((String) expr);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -669075651 
fg.calcBounds();
//#endif 


//#if -376774285 
endTrans();
//#endif 

} 

//#endif 


//#if -1195456964 
@Override
    protected void modelChanged(PropertyChangeEvent e)
    { 

//#if 187629528 
Object extend = getOwner();
//#endif 


//#if -1454419499 
if(extend == null)//1
{ 

//#if -503970067 
return;
//#endif 

} 

//#endif 


//#if -1990740980 
super.modelChanged(e);
//#endif 


//#if -1609053413 
if("condition".equals(e.getPropertyName()))//1
{ 

//#if -1303945709 
renderingChanged();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1344544669 
@Override
    protected boolean canEdit(Fig f)
    { 

//#if -1053383246 
return false;
//#endif 

} 

//#endif 


//#if -329823200 
private void initialize(Object owner)
    { 

//#if 1266861645 
int y = Y0 + STEREOHEIGHT;
//#endif 


//#if -792970307 
label = new ArgoFigText(owner,
                                new Rectangle(X0, y, DEFAULT_WIDTH, STEREOHEIGHT),
                                getSettings(), false);
//#endif 


//#if 1301517528 
y = y + STEREOHEIGHT;
//#endif 


//#if 1406414761 
label.setFilled(false);
//#endif 


//#if -219225518 
label.setLineWidth(0);
//#endif 


//#if 1696448555 
label.setEditable(false);
//#endif 


//#if 1644400178 
label.setText(getLabel());
//#endif 


//#if -1651558264 
label.calcBounds();
//#endif 


//#if -510556042 
condition = new ArgoFigText(owner,
                                    new Rectangle(X0, y, DEFAULT_WIDTH, STEREOHEIGHT),
                                    getSettings(), false);
//#endif 


//#if -1456024966 
y = y + STEREOHEIGHT;
//#endif 


//#if 1737459984 
condition.setFilled(false);
//#endif 


//#if -1455472629 
condition.setLineWidth(0);
//#endif 


//#if -1744292693 
fg = new FigTextGroup(owner, getSettings());
//#endif 


//#if -49158080 
fg.addFig(label);
//#endif 


//#if 1689701287 
fg.addFig(condition);
//#endif 


//#if 161356849 
fg.calcBounds();
//#endif 


//#if -1503189419 
addPathItem(fg, new PathItemPlacement(this, fg, 50, 10));
//#endif 


//#if 1933153347 
setDashed(true);
//#endif 


//#if 193650997 
setDestArrowHead(endArrow);
//#endif 


//#if -1462095301 
setBetweenNearestPoints(true);
//#endif 

} 

//#endif 


//#if 149500525 

//#if 1255672846 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigExtend()
    { 

//#if 390436148 
initialize(null);
//#endif 

} 

//#endif 


//#if -1262382040 
@Override
    protected void updateListeners(Object oldOwner, Object newOwner)
    { 

//#if -1198771371 
Set<Object[]> listeners = new HashSet<Object[]>();
//#endif 


//#if -586664520 
if(newOwner != null)//1
{ 

//#if -424100439 
listeners.add(
                new Object[] {newOwner,
                              new String[] {"condition", "remove"}
                             });
//#endif 

} 

//#endif 


//#if -759305306 
updateElementListeners(listeners);
//#endif 

} 

//#endif 


//#if 149465937 

//#if 2028124533 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigExtend(Object edge)
    { 

//#if -90883390 
this();
//#endif 


//#if -206853620 
setOwner(edge);
//#endif 

} 

//#endif 


//#if -1919490455 
private String getLabel()
    { 

//#if -436758217 
return NotationUtilityUml.formatStereotype(
                   "extend",
                   getNotationSettings().isUseGuillemets());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

