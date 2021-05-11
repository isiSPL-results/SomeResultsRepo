
//#if 1054286428 
// Compilation Unit of /FigFinalState.java 
 

//#if -1532230342 
package org.argouml.uml.diagram.state.ui;
//#endif 


//#if 1061960967 
import java.awt.Color;
//#endif 


//#if -495255301 
import java.awt.Rectangle;
//#endif 


//#if -2072474269 
import java.awt.event.MouseEvent;
//#endif 


//#if -838960704 
import java.util.Iterator;
//#endif 


//#if -879957744 
import java.util.List;
//#endif 


//#if 1563151649 
import org.argouml.model.Model;
//#endif 


//#if 1176771844 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 1961273138 
import org.argouml.uml.diagram.activity.ui.SelectionActionState;
//#endif 


//#if -947457771 
import org.tigris.gef.base.Globals;
//#endif 


//#if -771284551 
import org.tigris.gef.base.Selection;
//#endif 


//#if -594128051 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if -742379160 
import org.tigris.gef.presentation.FigCircle;
//#endif 


//#if -899551560 
public class FigFinalState extends 
//#if -262709350 
FigStateVertex
//#endif 

  { 

//#if 1373193697 
private static final int WIDTH = 24;
//#endif 


//#if -1595012092 
private static final int HEIGHT = 24;
//#endif 


//#if -111359028 
private FigCircle inCircle;
//#endif 


//#if -214633545 
private FigCircle outCircle;
//#endif 


//#if -312866809 
static final long serialVersionUID = -3506578343969467480L;
//#endif 


//#if -2142475265 
@Override
    public Selection makeSelection()
    { 

//#if -166864813 
Object pstate = getOwner();
//#endif 


//#if -1718814248 
Selection sel = null;
//#endif 


//#if 1431984196 
if(pstate != null)//1
{ 

//#if 398729038 
if(Model.getFacade().isAActivityGraph(
                        Model.getFacade().getStateMachine(
                            Model.getFacade().getContainer(pstate))))//1
{ 

//#if -1880236903 
sel = new SelectionActionState(this);
//#endif 


//#if -1167069088 
((SelectionActionState) sel).setOutgoingButtonEnabled(false);
//#endif 

} 
else
{ 

//#if -284178446 
sel = new SelectionState(this);
//#endif 


//#if -1666700251 
((SelectionState) sel).setOutgoingButtonEnabled(false);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 196390596 
return sel;
//#endif 

} 

//#endif 


//#if 304766003 
@Override
    public Object clone()
    { 

//#if -1320678066 
FigFinalState figClone = (FigFinalState) super.clone();
//#endif 


//#if -810324124 
Iterator it = figClone.getFigs().iterator();
//#endif 


//#if 29623535 
figClone.setBigPort((FigCircle) it.next());
//#endif 


//#if 1554128124 
figClone.outCircle = (FigCircle) it.next();
//#endif 


//#if -1899398049 
figClone.inCircle = (FigCircle) it.next();
//#endif 


//#if 1401205251 
return figClone;
//#endif 

} 

//#endif 


//#if 2129180292 

//#if 606182781 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigFinalState(@SuppressWarnings("unused") GraphModel gm,
                         Object node)
    { 

//#if -2119886574 
this();
//#endif 


//#if -1185580191 
setOwner(node);
//#endif 

} 

//#endif 


//#if 1795279810 
@Override
    public Color getFillColor()
    { 

//#if 589636728 
return outCircle.getFillColor();
//#endif 

} 

//#endif 


//#if 968794161 
@Override
    public Color getLineColor()
    { 

//#if 1108659853 
return outCircle.getLineColor();
//#endif 

} 

//#endif 


//#if -1203471930 
@Override
    public List getGravityPoints()
    { 

//#if 2139472944 
return getCircleGravityPoints();
//#endif 

} 

//#endif 


//#if 1767002441 
@Override
    public void setLineWidth(int w)
    { 

//#if -11055070 
outCircle.setLineWidth(w);
//#endif 

} 

//#endif 


//#if -1795473751 
@Override
    public boolean isFilled()
    { 

//#if 949922578 
return true;
//#endif 

} 

//#endif 


//#if -1155373342 
@Override
    public void setFillColor(Color col)
    { 

//#if -1960696010 
if(Color.black.equals(col))//1
{ 

//#if -1867430455 
col = Color.white;
//#endif 

} 

//#endif 


//#if -358505735 
outCircle.setFillColor(col);
//#endif 

} 

//#endif 


//#if -1774641881 
@Override
    public void setFilled(boolean f)
    { 
} 

//#endif 


//#if -1359022195 

//#if -1413325755 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigFinalState()
    { 

//#if -1268853452 
super();
//#endif 


//#if -871709306 
initFigs();
//#endif 

} 

//#endif 


//#if -49819008 
@Override
    public int getLineWidth()
    { 

//#if -760264078 
return outCircle.getLineWidth();
//#endif 

} 

//#endif 


//#if -420970610 
private void initFigs()
    { 

//#if 1715307203 
setEditable(false);
//#endif 


//#if -785482251 
Color handleColor = Globals.getPrefs().getHandleColor();
//#endif 


//#if 1728621155 
FigCircle bigPort =
            new FigCircle(X0, Y0, WIDTH, HEIGHT, LINE_COLOR, FILL_COLOR);
//#endif 


//#if -1132110668 
outCircle =
            new FigCircle(X0, Y0, WIDTH, HEIGHT, LINE_COLOR, FILL_COLOR);
//#endif 


//#if 1536623883 
inCircle =
            new FigCircle(
            X0 + 5,
            Y0 + 5,
            WIDTH - 10,
            HEIGHT - 10,
            handleColor,
            LINE_COLOR);
//#endif 


//#if -540962427 
outCircle.setLineWidth(LINE_WIDTH);
//#endif 


//#if 1861608805 
outCircle.setLineColor(LINE_COLOR);
//#endif 


//#if 1417133587 
inCircle.setLineWidth(0);
//#endif 


//#if -300052002 
addFig(bigPort);
//#endif 


//#if -488410117 
addFig(outCircle);
//#endif 


//#if -66663332 
addFig(inCircle);
//#endif 


//#if 887272986 
setBigPort(bigPort);
//#endif 


//#if 772710389 
setBlinkPorts(false);
//#endif 

} 

//#endif 


//#if 58154065 
@Override
    public void setLineColor(Color col)
    { 

//#if 419416996 
outCircle.setLineColor(col);
//#endif 


//#if 1093520612 
inCircle.setFillColor(col);
//#endif 

} 

//#endif 


//#if 1117836702 
@Override
    protected void setStandardBounds(int x, int y, int w, int h)
    { 

//#if -152013476 
if(getNameFig() == null)//1
{ 

//#if 1568048849 
return;
//#endif 

} 

//#endif 


//#if 702257949 
Rectangle oldBounds = getBounds();
//#endif 


//#if -2031115699 
getBigPort().setBounds(x, y, w, h);
//#endif 


//#if -368071525 
outCircle.setBounds(x, y, w, h);
//#endif 


//#if 1319086738 
inCircle.setBounds(x + 5, y + 5, w - 10, h - 10);
//#endif 


//#if -1604111378 
calcBounds();
//#endif 


//#if 1155703471 
updateEdges();
//#endif 


//#if -120430742 
firePropChange("bounds", oldBounds, getBounds());
//#endif 

} 

//#endif 


//#if 1328963659 
public FigFinalState(Object owner, Rectangle bounds,
                         DiagramSettings settings)
    { 

//#if -714475779 
super(owner, bounds, settings);
//#endif 


//#if -848263918 
initFigs();
//#endif 

} 

//#endif 


//#if 1988398694 
@Override
    public boolean isResizable()
    { 

//#if -1944663336 
return false;
//#endif 

} 

//#endif 


//#if 1707334454 
@Override
    public void mouseClicked(MouseEvent me)
    { 
} 

//#endif 

 } 

//#endif 


//#endif 

