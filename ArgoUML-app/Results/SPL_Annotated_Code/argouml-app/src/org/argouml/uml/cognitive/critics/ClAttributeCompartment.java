// Compilation Unit of /ClAttributeCompartment.java 
 

//#if COGNITIVE 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if COGNITIVE 
import java.awt.Color;
//#endif 


//#if COGNITIVE 
import java.awt.Component;
//#endif 


//#if COGNITIVE 
import java.awt.Graphics;
//#endif 


//#if COGNITIVE 
import java.awt.Rectangle;
//#endif 


//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
import org.apache.log4j.Logger;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if COGNITIVE 
import org.argouml.ui.Clarifier;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.diagram.AttributesCompartmentContainer;
//#endif 


//#if COGNITIVE 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if COGNITIVE 
public class ClAttributeCompartment implements Clarifier
  { 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
private static final Logger LOG =
        Logger.getLogger(ClAttributeCompartment.class);
//#endif 

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

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.debug("not a FigClass");
//#endif 

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

//#endif 


