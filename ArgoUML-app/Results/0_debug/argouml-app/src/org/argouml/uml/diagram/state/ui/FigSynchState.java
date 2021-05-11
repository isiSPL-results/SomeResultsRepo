
//#if 1336714573 
// Compilation Unit of /FigSynchState.java 
 

//#if 1155145006 
package org.argouml.uml.diagram.state.ui;
//#endif 


//#if -1477123693 
import java.awt.Color;
//#endif 


//#if 1340596753 
import java.awt.Font;
//#endif 


//#if -974749817 
import java.awt.Rectangle;
//#endif 


//#if -1511532201 
import java.awt.event.MouseEvent;
//#endif 


//#if -293298468 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -1318455220 
import java.util.Iterator;
//#endif 


//#if -702183915 
import org.argouml.model.Model;
//#endif 


//#if -1500156424 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -846079935 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if -25612452 
import org.tigris.gef.presentation.FigCircle;
//#endif 


//#if -1058931448 
import org.tigris.gef.presentation.FigRect;
//#endif 


//#if -1057064225 
import org.tigris.gef.presentation.FigText;
//#endif 


//#if 444674389 
public class FigSynchState extends 
//#if -1226544890 
FigStateVertex
//#endif 

  { 

//#if 172180649 
private static final int X = X0;
//#endif 


//#if 173105131 
private static final int Y = Y0;
//#endif 


//#if 1591605100 
private static final int WIDTH = 25;
//#endif 


//#if 880773175 
private static final int HEIGHT = 25;
//#endif 


//#if 1042144896 
private FigText bound;
//#endif 


//#if 322424245 
private FigCircle head;
//#endif 


//#if 875603018 
@Override
    public void mouseClicked(MouseEvent me)
    { 
} 

//#endif 


//#if 2117848933 
@Override
    public void setLineColor(Color col)
    { 

//#if -239279498 
head.setLineColor(col);
//#endif 

} 

//#endif 


//#if -386614371 
@Override
    public Color getLineColor()
    { 

//#if 925107883 
return head.getLineColor();
//#endif 

} 

//#endif 


//#if 904321526 
@Override
    public void setFillColor(Color col)
    { 

//#if -1075122580 
head.setFillColor(col);
//#endif 

} 

//#endif 


//#if 1968062986 
@Override
    protected void setStandardBounds(int x, int y, int w, int h)
    { 

//#if 686750881 
if(getNameFig() == null)//1
{ 

//#if -1393318468 
return;
//#endif 

} 

//#endif 


//#if 279370402 
Rectangle oldBounds = getBounds();
//#endif 


//#if 629210812 
getBigPort().setBounds(x, y, WIDTH, HEIGHT);
//#endif 


//#if 27204616 
head.setBounds(x, y, WIDTH, HEIGHT);
//#endif 


//#if 889580269 
bound.setBounds(x - 2, y + 2, 0, 0);
//#endif 


//#if -1426281469 
bound.calcBounds();
//#endif 


//#if -22627661 
calcBounds();
//#endif 


//#if -1357908854 
updateEdges();
//#endif 


//#if -1619004177 
firePropChange("bounds", oldBounds, getBounds());
//#endif 

} 

//#endif 


//#if 396802585 

//#if 937431037 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigSynchState(@SuppressWarnings("unused") GraphModel gm,
                         Object node)
    { 

//#if 103718035 
this();
//#endif 


//#if 1613229538 
setOwner(node);
//#endif 

} 

//#endif 


//#if 935960494 
public FigSynchState(Object owner, Rectangle bounds,
                         DiagramSettings settings)
    { 

//#if 286578536 
super(owner, bounds, settings);
//#endif 


//#if -1272956355 
initFigs();
//#endif 

} 

//#endif 


//#if -221024675 
@Override
    public void setLineWidth(int w)
    { 

//#if -1935805056 
head.setLineWidth(w);
//#endif 

} 

//#endif 


//#if 439871278 
@Override
    public Color getFillColor()
    { 

//#if -541623798 
return head.getFillColor();
//#endif 

} 

//#endif 


//#if 2101639327 
@Override
    public Object clone()
    { 

//#if -851128502 
FigSynchState figClone = (FigSynchState) super.clone();
//#endif 


//#if 657203776 
Iterator it = figClone.getFigs().iterator();
//#endif 


//#if -514432665 
figClone.setBigPort((FigRect) it.next());
//#endif 


//#if -592223098 
figClone.head = (FigCircle) it.next();
//#endif 


//#if -798449245 
figClone.bound = (FigText) it.next();
//#endif 


//#if 337199071 
return figClone;
//#endif 

} 

//#endif 


//#if -1374560134 
@Override
    public boolean isResizable()
    { 

//#if 990072796 
return false;
//#endif 

} 

//#endif 


//#if 1021026963 
@Override
    public void setFilled(boolean f)
    { 
} 

//#endif 


//#if -609888020 
@Override
    public int getLineWidth()
    { 

//#if -1526130344 
return head.getLineWidth();
//#endif 

} 

//#endif 


//#if -716290910 
private void initFigs()
    { 

//#if -1957177874 
setEditable(false);
//#endif 


//#if -125570079 
setBigPort(new FigCircle(X, Y, WIDTH, HEIGHT, DEBUG_COLOR,
                                 DEBUG_COLOR));
//#endif 


//#if 719598769 
head = new FigCircle(X, Y, WIDTH, HEIGHT, LINE_COLOR, FILL_COLOR);
//#endif 


//#if 1090803942 
bound = new FigText(X - 2, Y + 2, 0, 0, true);
//#endif 


//#if -1804476036 
bound.setFilled(false);
//#endif 


//#if -876991969 
bound.setLineWidth(0);
//#endif 


//#if -917483262 
bound.setTextColor(TEXT_COLOR);
//#endif 


//#if 1319045940 
bound.setReturnAction(FigText.END_EDITING);
//#endif 


//#if -1407149857 
bound.setTabAction(FigText.END_EDITING);
//#endif 


//#if 1247443574 
bound.setJustification(FigText.JUSTIFY_CENTER);
//#endif 


//#if -183088834 
bound.setEditable(false);
//#endif 


//#if -1433095170 
bound.setText("*");
//#endif 


//#if -1558705698 
addFig(getBigPort());
//#endif 


//#if -235503854 
addFig(head);
//#endif 


//#if 564376368 
addFig(bound);
//#endif 


//#if 1977668704 
setBlinkPorts(false);
//#endif 

} 

//#endif 


//#if 1939424533 
@Override
    public boolean isFilled()
    { 

//#if 1954393702 
return true;
//#endif 

} 

//#endif 


//#if -1072078017 
@Override
    protected void modelChanged(PropertyChangeEvent mee)
    { 

//#if 336641584 
super.modelChanged(mee);
//#endif 


//#if 2016177740 
if(mee.getPropertyName().equals("bound"))//1
{ 

//#if -1133024380 
if(getOwner() == null)//1
{ 

//#if -474372471 
return;
//#endif 

} 

//#endif 


//#if 2054402712 
int b = Model.getFacade().getBound(getOwner());
//#endif 


//#if 1323780668 
String aux;
//#endif 


//#if -1422156340 
if(b <= 0)//1
{ 

//#if 1570939251 
aux = "*";
//#endif 

} 
else
{ 

//#if -1356856596 
aux = String.valueOf(b);
//#endif 

} 

//#endif 


//#if 139227833 
bound.setText(aux);
//#endif 


//#if -1531805272 
updateBounds();
//#endif 


//#if -1136549257 
damage();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -923682206 

//#if 1316989738 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigSynchState()
    { 

//#if 761386075 
initFigs();
//#endif 

} 

//#endif 


//#if 1516748228 
@Override
    protected void updateFont()
    { 

//#if -578962734 
super.updateFont();
//#endif 


//#if -1470461314 
Font f = getSettings().getFontPlain();
//#endif 


//#if -2134855948 
bound.setFont(f);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

