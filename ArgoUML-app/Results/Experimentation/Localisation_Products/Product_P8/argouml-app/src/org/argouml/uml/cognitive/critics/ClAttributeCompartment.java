package org.argouml.uml.cognitive.critics;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import org.apache.log4j.Logger;
import org.argouml.cognitive.ToDoItem;
import org.argouml.ui.Clarifier;
import org.argouml.uml.diagram.AttributesCompartmentContainer;
import org.tigris.gef.presentation.Fig;
public class ClAttributeCompartment implements Clarifier
  { 
private static final Logger LOG =
        Logger.getLogger(ClAttributeCompartment.class);
private static ClAttributeCompartment theInstance =
        new ClAttributeCompartment();
private static final int WAVE_LENGTH = 4;
private static final int WAVE_HEIGHT = 2;
private Fig fig;
public int getIconWidth()
    { 
return 0;
} 
public boolean hit(int x, int y)
    { 
if(!(fig instanceof AttributesCompartmentContainer))//1
{ 
LOG.debug("not a FigClass");
return false;
} 
AttributesCompartmentContainer fc =
            (AttributesCompartmentContainer) fig;
Rectangle fr = fc.getAttributesBounds();
boolean res = fr.contains(x, y);
fig = null;
return res;
} 
public void paintIcon(Component c, Graphics g, int x, int y)
    { 
if(fig instanceof AttributesCompartmentContainer)//1
{ 
AttributesCompartmentContainer fc =
                (AttributesCompartmentContainer) fig;
if(!fc.isAttributesVisible())//1
{ 
fig = null;
return;
} 
Rectangle fr = fc.getAttributesBounds();
int left  = fr.x + 6;
int height = fr.y + fr.height - 5;
int right = fr.x + fr.width - 6;
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
public void setFig(Fig f)
    { 
fig = f;
} 
public int getIconHeight()
    { 
return 0;
} 
public static ClAttributeCompartment getTheInstance()
    { 
return theInstance;
} 
public void setToDoItem(ToDoItem i) { 
} 

 } 
