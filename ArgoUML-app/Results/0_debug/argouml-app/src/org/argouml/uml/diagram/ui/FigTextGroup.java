
//#if -262809299 
// Compilation Unit of /FigTextGroup.java 
 

//#if -1989265503 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -1234671440 
import java.awt.Point;
//#endif 


//#if -734232015 
import java.awt.Rectangle;
//#endif 


//#if -1464638611 
import java.awt.event.MouseEvent;
//#endif 


//#if -1725385733 
import java.awt.event.MouseListener;
//#endif 


//#if 746288454 
import java.util.List;
//#endif 


//#if 1782749582 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -1141900126 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 369942901 
import org.tigris.gef.presentation.FigText;
//#endif 


//#if -1435355541 
public class FigTextGroup extends 
//#if 1743755749 
ArgoFigGroup
//#endif 

 implements 
//#if -2021973624 
MouseListener
//#endif 

  { 

//#if 1653168160 
private boolean supressCalcBounds = false;
//#endif 


//#if 803721443 
public boolean hit(Rectangle r)
    { 

//#if -1394788589 
return this.intersects(r);
//#endif 

} 

//#endif 


//#if -1619296099 
@Override
    public void deleteFromModel()
    { 

//#if -727936327 
for (Fig fig : (List<Fig>) getFigs()) //1
{ 

//#if -556142169 
fig.deleteFromModel();
//#endif 

} 

//#endif 


//#if 604675376 
super.deleteFromModel();
//#endif 

} 

//#endif 


//#if 1092645946 
@Override
    public void addFig(Fig f)
    { 

//#if 115459848 
super.addFig(f);
//#endif 


//#if -1622252819 
updateFigTexts();
//#endif 


//#if -145668274 
calcBounds();
//#endif 

} 

//#endif 


//#if -2122708786 
@Override
    public void removeFromDiagram()
    { 

//#if 761374071 
for (Fig fig : (List<Fig>) getFigs()) //1
{ 

//#if -558197957 
fig.removeFromDiagram();
//#endif 

} 

//#endif 


//#if -931158495 
super.removeFromDiagram();
//#endif 

} 

//#endif 


//#if -373449564 
public void mouseClicked(MouseEvent me)
    { 

//#if 920011773 
if(me.isConsumed())//1
{ 

//#if -1287879302 
return;
//#endif 

} 

//#endif 


//#if -1474029761 
if(me.getClickCount() >= 2)//1
{ 

//#if -788903180 
Fig f = hitFig(new Rectangle(me.getX() - 2, me.getY() - 2, 4, 4));
//#endif 


//#if 2048540919 
if(f instanceof MouseListener)//1
{ 

//#if 1019536284 
((MouseListener) f).mouseClicked(me);
//#endif 

} 

//#endif 


//#if 1283930345 
if(me.isConsumed())//1
{ 

//#if -1523094190 
return;
//#endif 

} 

//#endif 


//#if -840266742 
for (Object o : this.getFigs()) //1
{ 

//#if 279570065 
f = (Fig) o;
//#endif 


//#if 186763208 
if(f instanceof MouseListener && f instanceof FigText)//1
{ 

//#if 766582660 
if(((FigText) f).getEditable())//1
{ 

//#if 1865967029 
((MouseListener) f).mouseClicked(me);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1824549597 
me.consume();
//#endif 

} 

//#endif 


//#if 1499232899 
@Override
    public void calcBounds()
    { 

//#if -15490372 
updateFigTexts();
//#endif 


//#if -1907602486 
if(!supressCalcBounds)//1
{ 

//#if -520913835 
super.calcBounds();
//#endif 


//#if 761726687 
int maxWidth = 0;
//#endif 


//#if 1259346074 
int height = 0;
//#endif 


//#if 1524790312 
for (Fig fig : (List<Fig>) getFigs()) //1
{ 

//#if -1159094692 
if(fig.getWidth() > maxWidth)//1
{ 

//#if -1787068420 
maxWidth = fig.getWidth();
//#endif 

} 

//#endif 


//#if 1929845440 
fig.setHeight(fig.getMinimumSize().height);
//#endif 


//#if -1445781286 
height += fig.getHeight();
//#endif 

} 

//#endif 


//#if 40610620 
_w = maxWidth;
//#endif 


//#if 1609023784 
_h = height;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 109744122 

//#if -1145602487 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigTextGroup()
    { 

//#if -1758737164 
super();
//#endif 

} 

//#endif 


//#if -173170360 
public void mouseReleased(MouseEvent me)
    { 
} 

//#endif 


//#if 1716403700 
public void mouseEntered(MouseEvent me)
    { 
} 

//#endif 


//#if -697075704 
public void mouseExited(MouseEvent me)
    { 
} 

//#endif 


//#if -342559977 
public boolean contains(int x, int y)
    { 

//#if -1482503626 
return (_x <= x) && (x <= _x + _w) && (_y <= y) && (y <= _y + _h);
//#endif 

} 

//#endif 


//#if -1827625633 
public void mousePressed(MouseEvent me)
    { 
} 

//#endif 


//#if -273669134 
private void updateFigTexts()
    { 

//#if -1383732475 
int height = 0;
//#endif 


//#if -1599661731 
for (Fig fig : (List<Fig>) getFigs()) //1
{ 

//#if -1080826192 
int figHeight = fig.getMinimumSize().height;
//#endif 


//#if 2147419101 
fig.setBounds(getX(), getY() + height, fig.getWidth(), figHeight);
//#endif 


//#if 2120501576 
fig.endTrans();
//#endif 


//#if 1393014203 
height += fig.getHeight();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -792921752 
public FigTextGroup(Object owner, DiagramSettings settings)
    { 

//#if -1189892345 
super(owner, settings);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

