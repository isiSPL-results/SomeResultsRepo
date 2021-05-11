// Compilation Unit of /FigTextGroup.java 
 
package org.argouml.uml.diagram.ui;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import org.argouml.uml.diagram.DiagramSettings;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigText;
public class FigTextGroup extends ArgoFigGroup
 implements MouseListener
  { 
private boolean supressCalcBounds = false;
public boolean hit(Rectangle r)
    { 
return this.intersects(r);
} 

@Override
    public void deleteFromModel()
    { 
for (Fig fig : (List<Fig>) getFigs()) //1
{ 
fig.deleteFromModel();
} 

super.deleteFromModel();
} 

@Override
    public void addFig(Fig f)
    { 
super.addFig(f);
updateFigTexts();
calcBounds();
} 

@Override
    public void removeFromDiagram()
    { 
for (Fig fig : (List<Fig>) getFigs()) //1
{ 
fig.removeFromDiagram();
} 

super.removeFromDiagram();
} 

public void mouseClicked(MouseEvent me)
    { 
if(me.isConsumed())//1
{ 
return;
} 

if(me.getClickCount() >= 2)//1
{ 
Fig f = hitFig(new Rectangle(me.getX() - 2, me.getY() - 2, 4, 4));
if(f instanceof MouseListener)//1
{ 
((MouseListener) f).mouseClicked(me);
} 

if(me.isConsumed())//1
{ 
return;
} 

for (Object o : this.getFigs()) //1
{ 
f = (Fig) o;
if(f instanceof MouseListener && f instanceof FigText)//1
{ 
if(((FigText) f).getEditable())//1
{ 
((MouseListener) f).mouseClicked(me);
} 

} 

} 

} 

me.consume();
} 

@Override
    public void calcBounds()
    { 
updateFigTexts();
if(!supressCalcBounds)//1
{ 
super.calcBounds();
int maxWidth = 0;
int height = 0;
for (Fig fig : (List<Fig>) getFigs()) //1
{ 
if(fig.getWidth() > maxWidth)//1
{ 
maxWidth = fig.getWidth();
} 

fig.setHeight(fig.getMinimumSize().height);
height += fig.getHeight();
} 

_w = maxWidth;
_h = height;
} 

} 

@SuppressWarnings("deprecation")

    @Deprecated
    public FigTextGroup()
    { 
super();
} 

public void mouseReleased(MouseEvent me)
    { 
} 

public void mouseEntered(MouseEvent me)
    { 
} 

public void mouseExited(MouseEvent me)
    { 
} 

public boolean contains(int x, int y)
    { 
return (_x <= x) && (x <= _x + _w) && (_y <= y) && (y <= _y + _h);
} 

public void mousePressed(MouseEvent me)
    { 
} 

private void updateFigTexts()
    { 
int height = 0;
for (Fig fig : (List<Fig>) getFigs()) //1
{ 
int figHeight = fig.getMinimumSize().height;
fig.setBounds(getX(), getY() + height, fig.getWidth(), figHeight);
fig.endTrans();
height += fig.getHeight();
} 

} 

public FigTextGroup(Object owner, DiagramSettings settings)
    { 
super(owner, settings);
} 

 } 


