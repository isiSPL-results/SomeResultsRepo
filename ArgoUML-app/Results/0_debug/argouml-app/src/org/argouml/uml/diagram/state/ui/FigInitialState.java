
//#if -142678259 
// Compilation Unit of /FigInitialState.java 
 

//#if 1647528947 
package org.argouml.uml.diagram.state.ui;
//#endif 


//#if 977716974 
import java.awt.Color;
//#endif 


//#if 1740652386 
import java.awt.Rectangle;
//#endif 


//#if -871719652 
import java.awt.event.MouseEvent;
//#endif 


//#if -1545823881 
import java.util.Collection;
//#endif 


//#if 1396946983 
import java.util.Iterator;
//#endif 


//#if -964201737 
import java.util.List;
//#endif 


//#if -683641062 
import org.argouml.model.Model;
//#endif 


//#if -1325419267 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -105848743 
import org.argouml.uml.diagram.activity.ui.SelectionActionState;
//#endif 


//#if -567759630 
import org.tigris.gef.base.Selection;
//#endif 


//#if 1719792710 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if 1516467105 
import org.tigris.gef.presentation.FigCircle;
//#endif 


//#if -1229140765 
public class FigInitialState extends 
//#if -471686065 
FigStateVertex
//#endif 

  { 

//#if -534914446 
private static final int X = X0;
//#endif 


//#if -533989964 
private static final int Y = Y0;
//#endif 


//#if 2046823365 
private static final int STATE_WIDTH = 16;
//#endif 


//#if -1879563156 
private static final int HEIGHT = 16;
//#endif 


//#if 1896283724 
private FigCircle head;
//#endif 


//#if -1215542606 
static final long serialVersionUID = 6572261327347541373L;
//#endif 


//#if -87306628 
@Override
    public void setLineColor(Color col)
    { 

//#if -955881961 
head.setLineColor(col);
//#endif 

} 

//#endif 


//#if 2016883790 
public FigInitialState(Object owner, Rectangle bounds,
                           DiagramSettings settings)
    { 

//#if -1082619815 
super(owner, bounds, settings);
//#endif 


//#if -113248914 
initFigs();
//#endif 

} 

//#endif 


//#if 1081381108 
@Override
    public void setLineWidth(int w)
    { 

//#if 1062579828 
head.setLineWidth(w);
//#endif 

} 

//#endif 


//#if -1889093263 
@Override
    public List getGravityPoints()
    { 

//#if 628663729 
return getCircleGravityPoints();
//#endif 

} 

//#endif 


//#if -605208607 
@Override
    public void mouseClicked(MouseEvent me)
    { 
} 

//#endif 


//#if -1777660629 

//#if -162933131 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigInitialState(@SuppressWarnings("unused") GraphModel gm,
                           Object node)
    { 

//#if -531284749 
this();
//#endif 


//#if 324546114 
setOwner(node);
//#endif 

} 

//#endif 


//#if 1188085800 
@Override
    public Object clone()
    { 

//#if -74368329 
FigInitialState figClone = (FigInitialState) super.clone();
//#endif 


//#if 1057389069 
Iterator it = figClone.getFigs().iterator();
//#endif 


//#if -860401393 
setBigPort((FigCircle) it.next());
//#endif 


//#if -1645553133 
figClone.head = (FigCircle) it.next();
//#endif 


//#if 1048002028 
return figClone;
//#endif 

} 

//#endif 


//#if -2074356236 

//#if 1952199358 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigInitialState()
    { 

//#if -147192419 
initFigs();
//#endif 

} 

//#endif 


//#if -2026594274 
@Override
    public boolean isFilled()
    { 

//#if -1175352927 
return true;
//#endif 

} 

//#endif 


//#if -1554066724 
@Override
    public void setFilled(boolean f)
    { 
} 

//#endif 


//#if 400387306 
@Override
    public Selection makeSelection()
    { 

//#if -2007988716 
Object pstate = getOwner();
//#endif 


//#if -2016326567 
Selection sel = null;
//#endif 


//#if 799036899 
if(pstate != null)//1
{ 

//#if -1752045769 
if(Model.getFacade().isAActivityGraph(
                        Model.getFacade().getStateMachine(
                            Model.getFacade().getContainer(pstate))))//1
{ 

//#if -906492731 
sel = new SelectionActionState(this);
//#endif 


//#if 1257786642 
((SelectionActionState) sel).setIncomingButtonEnabled(false);
//#endif 


//#if -1578639676 
Collection outs = Model.getFacade().getOutgoings(getOwner());
//#endif 


//#if -999598314 
((SelectionActionState) sel)
                .setOutgoingButtonEnabled(outs.isEmpty());
//#endif 

} 
else
{ 

//#if -1012705099 
sel = new SelectionState(this);
//#endif 


//#if -65482066 
((SelectionState) sel).setIncomingButtonEnabled(false);
//#endif 


//#if -459749494 
Collection outs = Model.getFacade().getOutgoings(getOwner());
//#endif 


//#if 1540448506 
((SelectionState) sel)
                .setOutgoingButtonEnabled(outs.isEmpty());
//#endif 

} 

//#endif 

} 

//#endif 


//#if -678423995 
return sel;
//#endif 

} 

//#endif 


//#if 857568569 
private void initFigs()
    { 

//#if -514054873 
setEditable(false);
//#endif 


//#if -1572819622 
FigCircle bigPort =
            new FigCircle(X, Y, STATE_WIDTH, HEIGHT, DEBUG_COLOR, DEBUG_COLOR);
//#endif 


//#if 1706820186 
head = new FigCircle(X, Y, STATE_WIDTH, HEIGHT, LINE_COLOR,
                             SOLID_FILL_COLOR);
//#endif 


//#if -1768642054 
addFig(bigPort);
//#endif 


//#if 2018569483 
addFig(head);
//#endif 


//#if 496525366 
setBigPort(bigPort);
//#endif 


//#if 1544436057 
setBlinkPorts(false);
//#endif 

} 

//#endif 


//#if -1268210697 
@Override
    public Color getFillColor()
    { 

//#if 1562996124 
return head.getFillColor();
//#endif 

} 

//#endif 


//#if 1509473489 
@Override
    public boolean isResizable()
    { 

//#if -1749796339 
return false;
//#endif 

} 

//#endif 


//#if -280939531 
@Override
    public int getLineWidth()
    { 

//#if -1148905858 
return head.getLineWidth();
//#endif 

} 

//#endif 


//#if 1014113683 
@Override
    protected void setStandardBounds(int x, int y, int w, int h)
    { 

//#if -1828794679 
if(getNameFig() == null)//1
{ 

//#if -2113275916 
return;
//#endif 

} 

//#endif 


//#if -1811255606 
Rectangle oldBounds = getBounds();
//#endif 


//#if 1654342720 
getBigPort().setBounds(x, y, w, h);
//#endif 


//#if -1882252940 
head.setBounds(x, y, w, h);
//#endif 


//#if 629311707 
calcBounds();
//#endif 


//#if 1672342370 
updateEdges();
//#endif 


//#if -876201705 
firePropChange("bounds", oldBounds, getBounds());
//#endif 

} 

//#endif 


//#if -2094696346 
@Override
    public Color getLineColor()
    { 

//#if -310288473 
return head.getLineColor();
//#endif 

} 

//#endif 


//#if -1300834035 
@Override
    public void setFillColor(Color col)
    { 

//#if -1955294865 
head.setFillColor(col);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

