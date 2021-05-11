
//#if -1240596824 
// Compilation Unit of /UpArrowIcon.java 
 

//#if -1004304121 
package org.argouml.swingext;
//#endif 


//#if -934763811 
import java.awt.Color;
//#endif 


//#if -168227325 
import java.awt.Component;
//#endif 


//#if -2133875893 
import java.awt.Graphics;
//#endif 


//#if 530801318 
import java.awt.Polygon;
//#endif 


//#if 1458382723 
import javax.swing.Icon;
//#endif 


//#if 429043146 
public class UpArrowIcon implements 
//#if 866917304 
Icon
//#endif 

  { 

//#if 3016261 
public void paintIcon(Component c, Graphics g, int x, int y)
    { 

//#if 1164209953 
int w = getIconWidth(), h = getIconHeight();
//#endif 


//#if 1975706927 
g.setColor(Color.black);
//#endif 


//#if -1521028702 
Polygon p = new Polygon();
//#endif 


//#if -1256313374 
p.addPoint(x, y + h);
//#endif 


//#if -641408134 
p.addPoint(x + w / 2 + 1, y);
//#endif 


//#if 390240526 
p.addPoint(x + w, y + h);
//#endif 


//#if 1492956417 
g.fillPolygon(p);
//#endif 

} 

//#endif 


//#if -279203265 
public int getIconWidth()
    { 

//#if 1511101984 
return 9;
//#endif 

} 

//#endif 


//#if 438447728 
public int getIconHeight()
    { 

//#if -848896285 
return 9;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

