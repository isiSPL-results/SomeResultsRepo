
//#if -1208890559 
// Compilation Unit of /SpacerPanel.java 
 

//#if 1107661653 
package org.argouml.swingext;
//#endif 


//#if -1659661524 
import java.awt.Dimension;
//#endif 


//#if -676092780 
import javax.swing.JPanel;
//#endif 


//#if -1626609655 
public class SpacerPanel extends 
//#if -380834137 
JPanel
//#endif 

  { 

//#if -1423595399 
private int w = 10, h = 10;
//#endif 


//#if 214062312 
public Dimension getSize()
    { 

//#if 1243876937 
return new Dimension(w, h);
//#endif 

} 

//#endif 


//#if -1575460982 
public Dimension getMinimumSize()
    { 

//#if -1846973254 
return new Dimension(w, h);
//#endif 

} 

//#endif 


//#if 1108438690 
public SpacerPanel(int width, int height)
    { 

//#if 1813235920 
w = width;
//#endif 


//#if 1179814058 
h = height;
//#endif 

} 

//#endif 


//#if -1709561181 
public SpacerPanel()
    { 
} 

//#endif 


//#if 1722325821 
public Dimension getPreferredSize()
    { 

//#if -1447945689 
return new Dimension(w, h);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

