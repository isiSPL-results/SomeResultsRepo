package org.argouml.uml.cognitive.critics;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import org.argouml.cognitive.ToDoItem;
import org.argouml.ui.Clarifier;
import org.argouml.uml.diagram.ui.FigEdgeModelElement;
import org.argouml.uml.diagram.ui.FigNodeModelElement;
import org.tigris.gef.presentation.Fig;
public class ClClassName implements Clarifier
  { 
private static ClClassName theInstance = new ClClassName();
private static final int WAVE_LENGTH = 4;
private static final int WAVE_HEIGHT = 2;
private Fig fig;
public int getIconWidth()
    { 
return 0;
} 
public void setFig(Fig f)
    { 
fig = f;
} 
public int getIconHeight()
    { 
return 0;
} 
public static ClClassName getTheInstance()
    { 
return theInstance;
} 
public void setToDoItem(ToDoItem i) { 
} 
public boolean hit(int x, int y)
    { 
Rectangle rect = null;
if(fig instanceof FigNodeModelElement)//1
{ 
FigNodeModelElement fnme = (FigNodeModelElement) fig;
rect = fnme.getNameBounds();
} 
else
if(fig instanceof FigEdgeModelElement)//1
{ 
FigEdgeModelElement feme = (FigEdgeModelElement) fig;
rect = feme.getNameBounds();
} 
fig = null;
return (rect != null) && rect.contains(x, y);
} 
public void paintIcon(Component c, Graphics g, int x, int y)
    { 
Rectangle rect = null;
if(fig instanceof FigNodeModelElement)//1
{ 
FigNodeModelElement fnme = (FigNodeModelElement) fig;
rect = fnme.getNameBounds();
} 
else
if(fig instanceof FigEdgeModelElement)//1
{ 
FigEdgeModelElement feme = (FigEdgeModelElement) fig;
rect = feme.getNameBounds();
} 
if(rect != null)//1
{ 
int left  = rect.x + 6;
int height = rect.y + rect.height - 4;
int right = rect.x + rect.width - 6;
g.setColor(Color.red);
int i = left;
while (true) //1
{ 
g.drawLine(i, height, i + WAVE_LENGTH, height + WAVE_HEIGHT);
i += WAVE_LENGTH;
if(i >= right)//1
{ 
break;

} 
g.drawLine(i, height + WAVE_HEIGHT, i + WAVE_LENGTH, height);
i += WAVE_LENGTH;
if(i >= right)//2
{ 
break;

} 
g.drawLine(i, height, i + WAVE_LENGTH,
                           height + WAVE_HEIGHT / 2);
i += WAVE_LENGTH;
if(i >= right)//3
{ 
break;

} 
g.drawLine(i, height + WAVE_HEIGHT / 2, i + WAVE_LENGTH,
                           height);
i += WAVE_LENGTH;
if(i >= right)//4
{ 
break;

} 
} 
fig = null;
} 
} 

 } 
