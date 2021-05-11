
//#if 1448419906 
// Compilation Unit of /ClAttributeCompartment.java 
 

//#if 690998147 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 416156101 
import java.awt.Color;
//#endif 


//#if 639680747 
import java.awt.Component;
//#endif 


//#if -722341021 
import java.awt.Graphics;
//#endif 


//#if 1487683257 
import java.awt.Rectangle;
//#endif 


//#if 189942448 
import org.apache.log4j.Logger;
//#endif 


//#if 668818466 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 1840267626 
import org.argouml.ui.Clarifier;
//#endif 


//#if 865204596 
import org.argouml.uml.diagram.AttributesCompartmentContainer;
//#endif 


//#if 29678874 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 842089252 
public class ClAttributeCompartment implements 
//#if 1287930667 
Clarifier
//#endif 

  { 

//#if 1942629369 
private static final Logger LOG =
        Logger.getLogger(ClAttributeCompartment.class);
//#endif 


//#if -220411282 
private static ClAttributeCompartment theInstance =
        new ClAttributeCompartment();
//#endif 


//#if -1126405938 
private static final int WAVE_LENGTH = 4;
//#endif 


//#if 1655168687 
private static final int WAVE_HEIGHT = 2;
//#endif 


//#if -259456404 
private Fig fig;
//#endif 


//#if -429688950 
public int getIconWidth()
    { 

//#if 2141796211 
return 0;
//#endif 

} 

//#endif 


//#if 5312476 
public boolean hit(int x, int y)
    { 

//#if -160291983 
if(!(fig instanceof AttributesCompartmentContainer))//1
{ 

//#if 906931287 
LOG.debug("not a FigClass");
//#endif 


//#if 482133872 
return false;
//#endif 

} 

//#endif 


//#if -891791472 
AttributesCompartmentContainer fc =
            (AttributesCompartmentContainer) fig;
//#endif 


//#if -1443283957 
Rectangle fr = fc.getAttributesBounds();
//#endif 


//#if 1663431335 
boolean res = fr.contains(x, y);
//#endif 


//#if -621437569 
fig = null;
//#endif 


//#if -2057484729 
return res;
//#endif 

} 

//#endif 


//#if 1274297616 
public void paintIcon(Component c, Graphics g, int x, int y)
    { 

//#if 1246932683 
if(fig instanceof AttributesCompartmentContainer)//1
{ 

//#if 677707641 
AttributesCompartmentContainer fc =
                (AttributesCompartmentContainer) fig;
//#endif 


//#if 572085042 
if(!fc.isAttributesVisible())//1
{ 

//#if 2065105745 
fig = null;
//#endif 


//#if 768124769 
return;
//#endif 

} 

//#endif 


//#if 1394067444 
Rectangle fr = fc.getAttributesBounds();
//#endif 


//#if -616583968 
int left  = fr.x + 6;
//#endif 


//#if -1500027260 
int height = fr.y + fr.height - 5;
//#endif 


//#if 2094773142 
int right = fr.x + fr.width - 6;
//#endif 


//#if -273693077 
g.setColor(Color.red);
//#endif 


//#if -99051260 
int i = left;
//#endif 


//#if 634911200 
while (true) //1
{ 

//#if -1974621875 
g.drawLine(i, height, i + WAVE_LENGTH, height + WAVE_HEIGHT);
//#endif 


//#if 1304952915 
i += WAVE_LENGTH;
//#endif 


//#if -1398286000 
if(i >= right)//1
{ 

//#if 237048664 
break;

//#endif 

} 

//#endif 


//#if 1626440393 
g.drawLine(i, height + WAVE_HEIGHT, i + WAVE_LENGTH, height);
//#endif 


//#if 2103341343 
i += WAVE_LENGTH;
//#endif 


//#if 549654369 
if(i >= right)//2
{ 

//#if 1624722211 
break;

//#endif 

} 

//#endif 


//#if 764094384 
g.drawLine(i, height, i + WAVE_LENGTH,
                           height + WAVE_HEIGHT / 2);
//#endif 


//#if 2103341344 
i += WAVE_LENGTH;
//#endif 


//#if 549684161 
if(i >= right)//3
{ 

//#if -80449067 
break;

//#endif 

} 

//#endif 


//#if 1238760710 
g.drawLine(i, height + WAVE_HEIGHT / 2, i + WAVE_LENGTH,
                           height);
//#endif 


//#if 2103341345 
i += WAVE_LENGTH;
//#endif 


//#if 549713953 
if(i >= right)//4
{ 

//#if -118856380 
break;

//#endif 

} 

//#endif 

} 

//#endif 


//#if -113643288 
fig = null;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1795754574 
public void setFig(Fig f)
    { 

//#if 784041181 
fig = f;
//#endif 

} 

//#endif 


//#if 68358789 
public int getIconHeight()
    { 

//#if 2145456904 
return 0;
//#endif 

} 

//#endif 


//#if 812292539 
public static ClAttributeCompartment getTheInstance()
    { 

//#if 187833064 
return theInstance;
//#endif 

} 

//#endif 


//#if 622614775 
public void setToDoItem(ToDoItem i) { 
} 

//#endif 

 } 

//#endif 


//#endif 

