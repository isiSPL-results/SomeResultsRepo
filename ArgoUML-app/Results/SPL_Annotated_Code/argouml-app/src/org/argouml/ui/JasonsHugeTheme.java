// Compilation Unit of /JasonsHugeTheme.java 
 
package org.argouml.ui;
import java.awt.Font;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.metal.MetalTheme;
public class JasonsHugeTheme extends MetalTheme
  { 
private final ColorUIResource primary1 = new ColorUIResource(102, 102, 153);
private final ColorUIResource primary2 = new ColorUIResource(153, 153, 204);
private final ColorUIResource primary3 = new ColorUIResource(204, 204, 255);
private final ColorUIResource secondary1 =
        new ColorUIResource(102, 102, 102);
private final ColorUIResource secondary2 =
        new ColorUIResource(153, 153, 153);
private final ColorUIResource secondary3 =
        new ColorUIResource(204, 204, 204);
private final FontUIResource controlFont =
        new FontUIResource("SansSerif", Font.BOLD, 16);
private final FontUIResource systemFont =
        new FontUIResource("Dialog", Font.PLAIN, 16);
private final FontUIResource windowTitleFont =
        new FontUIResource("SansSerif", Font.BOLD, 16);
private final FontUIResource userFont =
        new FontUIResource("SansSerif", Font.PLAIN, 16);
private final FontUIResource smallFont =
        new FontUIResource("Dialog", Font.PLAIN, 14);
protected ColorUIResource getPrimary3()
    { 
return primary3;
} 

public FontUIResource getMenuTextFont()
    { 
return controlFont;
} 

public FontUIResource getSubTextFont()
    { 
return smallFont;
} 

protected ColorUIResource getPrimary1()
    { 
return primary1;
} 

public FontUIResource getUserTextFont()
    { 
return userFont;
} 

protected ColorUIResource getSecondary3()
    { 
return secondary3;
} 

protected ColorUIResource getSecondary1()
    { 
return secondary1;
} 

public String getName()
    { 
return "Very Large Fonts";
} 

protected ColorUIResource getSecondary2()
    { 
return secondary2;
} 

protected ColorUIResource getPrimary2()
    { 
return primary2;
} 

public FontUIResource getWindowTitleFont()
    { 
return windowTitleFont;
} 

public FontUIResource getControlTextFont()
    { 
return controlFont;
} 

public FontUIResource getSystemTextFont()
    { 
return systemFont;
} 

 } 


