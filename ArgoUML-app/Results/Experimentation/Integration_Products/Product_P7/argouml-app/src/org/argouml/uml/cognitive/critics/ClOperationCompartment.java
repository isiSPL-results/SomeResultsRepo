package org.argouml.uml.cognitive.critics;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import org.argouml.cognitive.ToDoItem;
import org.argouml.ui.Clarifier;
import org.argouml.uml.diagram.OperationsCompartmentContainer;
import org.tigris.gef.presentation.Fig;
public class ClOperationCompartment implements Clarifier
  { 
private static ClOperationCompartment theInstance =
        new ClOperationCompartment();
private static final int WAVE_LENGTH = 4;
private static final int WAVE_HEIGHT = 2;
private Fig fig;
public int getIconWidth()
    { 
return 0;
} 
public void setToDoItem(ToDoItem i) { 
} 
public int getIconHeight()
    { 
return 0;
} 
public void setFig(Fig f)
    { 
fig = f;
} 
public static ClOperationCompartment getTheInstance()
    { 
return theInstance;
} 
public boolean hit(int x, int y)
    { 
if(!(fig instanceof OperationsCompartmentContainer))//1
{ 
return false;
} 
OperationsCompartmentContainer fc =
            (OperationsCompartmentContainer) fig;
Rectangle fr = fc.getOperationsBounds();
boolean res = fr.contains(x, y);
fig = null;
return res;
} 
public void paintIcon(Component c, Graphics g, int x, int y)
    { 
if(fig instanceof OperationsCompartmentContainer)//1
{ 
OperationsCompartmentContainer fc =
                (OperationsCompartmentContainer) fig;
if(!fc.isOperationsVisible())//1
{ 
fig = null;
return;
} 
Rectangle fr = fc.getOperationsBounds();
int left  = fr.x + 10;
int height = fr.y + fr.height - 7;
int right = fr.x + fr.width - 10;
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
