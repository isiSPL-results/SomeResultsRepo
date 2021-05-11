
//#if 178058513 
// Compilation Unit of /LeftArrowIcon.java 
 

//#if -860897781 
package org.argouml.swingext;
//#endif 


//#if -155956647 
import java.awt.Color;
//#endif 


//#if 789354367 
import java.awt.Component;
//#endif 


//#if -2102986161 
import java.awt.Graphics;
//#endif 


//#if 1640176418 
import java.awt.Polygon;
//#endif 


//#if -1727209473 
import javax.swing.Icon;
//#endif 


//#if -943400926 
public class LeftArrowIcon implements 
//#if 242709005 
Icon
//#endif 

  { 

//#if 426822090 
public int getIconWidth()
    { 

//#if -907454034 
return 9;
//#endif 

} 

//#endif 


//#if -2069123248 
public void paintIcon(Component c, Graphics g, int x, int y)
    { 

//#if -1702561461 
int w = getIconWidth(), h = getIconHeight();
//#endif 


//#if -1947066151 
g.setColor(Color.black);
//#endif 


//#if 311758796 
Polygon p = new Polygon();
//#endif 


//#if 2089567803 
p.addPoint(x + 1, y + h / 2 + 1);
//#endif 


//#if -36332133 
p.addPoint(x + w, y);
//#endif 


//#if -555337288 
p.addPoint(x + w, y + h);
//#endif 


//#if -1237654377 
g.fillPolygon(p);
//#endif 

} 

//#endif 


//#if 850397253 
public int getIconHeight()
    { 

//#if -935097426 
return 9;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

