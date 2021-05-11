
//#if 1569520783 
// Compilation Unit of /DiagramAppearance.java 
 

//#if -1359124577 
package org.argouml.uml.diagram;
//#endif 


//#if -867284005 
import java.awt.Font;
//#endif 


//#if -71712174 
import java.beans.PropertyChangeEvent;
//#endif 


//#if 1267052278 
import java.beans.PropertyChangeListener;
//#endif 


//#if 921072917 
import javax.swing.UIManager;
//#endif 


//#if 1722978284 
import org.apache.log4j.Logger;
//#endif 


//#if 901572805 
import org.argouml.configuration.Configuration;
//#endif 


//#if -1969457902 
import org.argouml.configuration.ConfigurationKey;
//#endif 


//#if 1470775974 
public final class DiagramAppearance implements 
//#if -2077129546 
PropertyChangeListener
//#endif 

  { 

//#if -1159041378 
private static final Logger LOG = Logger.getLogger(DiagramAppearance.class);
//#endif 


//#if 2129659731 
public static final ConfigurationKey KEY_FONT_NAME = Configuration.makeKey(
                "diagramappearance", "fontname");
//#endif 


//#if 960975847 
public static final ConfigurationKey KEY_FONT_SIZE = Configuration.makeKey(
                "diagramappearance", "fontsize");
//#endif 


//#if 1260707548 
private static final DiagramAppearance SINGLETON = new DiagramAppearance();
//#endif 


//#if 385857455 
public static final int STEREOTYPE_VIEW_TEXTUAL = 0;
//#endif 


//#if 1224415861 
public static final int STEREOTYPE_VIEW_BIG_ICON = 1;
//#endif 


//#if 395781659 
public static final int STEREOTYPE_VIEW_SMALL_ICON = 2;
//#endif 


//#if 1743621827 
public void propertyChange(PropertyChangeEvent pce)
    { 

//#if 949082163 
LOG.info("Diagram appearance change:" + pce.getOldValue() + " to "
                 + pce.getNewValue());
//#endif 

} 

//#endif 


//#if -481626482 
private Font getStandardFont()
    { 

//#if -455587968 
Font font = UIManager.getDefaults().getFont("TextField.font");
//#endif 


//#if 2009124043 
if(font == null)//1
{ 

//#if -144907228 
font = (new javax.swing.JTextField()).getFont();
//#endif 

} 

//#endif 


//#if -2094220098 
return font;
//#endif 

} 

//#endif 


//#if 1798296242 
private DiagramAppearance()
    { 

//#if 225029006 
Configuration.addListener(DiagramAppearance.KEY_FONT_NAME, this);
//#endif 


//#if 530994520 
Configuration.addListener(DiagramAppearance.KEY_FONT_SIZE, this);
//#endif 

} 

//#endif 


//#if -683246984 
public String getConfiguredFontName()
    { 

//#if 1672418845 
String fontName = Configuration
                          .getString(DiagramAppearance.KEY_FONT_NAME);
//#endif 


//#if 261071683 
if(fontName.equals(""))//1
{ 

//#if -1736758631 
Font f = getStandardFont();
//#endif 


//#if -1157169463 
fontName = f.getName();
//#endif 


//#if -1999669988 
Configuration.setString(DiagramAppearance.KEY_FONT_NAME, f
                                    .getName());
//#endif 


//#if 383499767 
Configuration.setInteger(DiagramAppearance.KEY_FONT_SIZE, f
                                     .getSize());
//#endif 

} 

//#endif 


//#if 347168575 
return fontName;
//#endif 

} 

//#endif 


//#if -1883737495 
public static DiagramAppearance getInstance()
    { 

//#if 1953910567 
return SINGLETON;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

