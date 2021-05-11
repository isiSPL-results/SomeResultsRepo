
//#if 164195410 
// Compilation Unit of /SettingsTabLayout.java 
 

//#if -1804776231 
package org.argouml.ui;
//#endif 


//#if 1087743907 
import java.awt.BorderLayout;
//#endif 


//#if -1628618721 
import javax.swing.BorderFactory;
//#endif 


//#if -1662542929 
import javax.swing.JLabel;
//#endif 


//#if -1547668833 
import javax.swing.JPanel;
//#endif 


//#if -757098680 
import javax.swing.SwingConstants;
//#endif 


//#if -399002238 
import org.argouml.application.api.GUISettingsTabInterface;
//#endif 


//#if 2030450452 
import org.argouml.configuration.Configuration;
//#endif 


//#if -1169403805 
import org.argouml.configuration.ConfigurationKey;
//#endif 


//#if -909244184 
import org.argouml.i18n.Translator;
//#endif 


//#if 230926004 
import org.tigris.swidgets.Property;
//#endif 


//#if 1477900409 
class SettingsTabLayout extends 
//#if -2084819135 
JPanel
//#endif 

 implements 
//#if -1524397541 
GUISettingsTabInterface
//#endif 

  { 

//#if 1623879132 
private static final long serialVersionUID = 739259705815092510L;
//#endif 


//#if -1699318762 
SettingsTabLayout()
    { 

//#if 685338624 
super();
//#endif 


//#if -6807860 
setLayout(new BorderLayout());
//#endif 


//#if 231210403 
final String[] positions = {"North", "South", "East"};
//#endif 


//#if 508033335 
final String paneColumnHeader = "Pane";
//#endif 


//#if 1891739513 
final String positionColumnHeader = "Position";
//#endif 


//#if -50178248 
JPanel top = new JPanel(new BorderLayout());
//#endif 


//#if -876653039 
top.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
//#endif 


//#if 680810080 
add(top, BorderLayout.CENTER);
//#endif 


//#if 532647633 
JLabel restart =
            new JLabel(Translator.localize("label.restart-application"));
//#endif 


//#if -1100242503 
restart.setHorizontalAlignment(SwingConstants.CENTER);
//#endif 


//#if -1944063961 
restart.setVerticalAlignment(SwingConstants.CENTER);
//#endif 


//#if -11082012 
restart.setBorder(BorderFactory.createEmptyBorder(10, 2, 10, 2));
//#endif 


//#if -1054896660 
add(restart, BorderLayout.SOUTH);
//#endif 

} 

//#endif 


//#if 657274230 
public void handleSettingsTabRefresh()
    { 
} 

//#endif 


//#if -1746329247 
public void handleSettingsTabCancel() { 
} 

//#endif 


//#if -1375475056 
private void savePosition(Property position, Class tab)
    { 

//#if -139068792 
ConfigurationKey key = makeKey(tab);
//#endif 


//#if -494942968 
Configuration.setString(key, position.getCurrentValue().toString());
//#endif 

} 

//#endif 


//#if 2066355680 
public String getTabKey()
    { 

//#if -262781897 
return "tab.layout";
//#endif 

} 

//#endif 


//#if 1887315591 
private void loadPosition(Property position, Class tab)
    { 

//#if -852350718 
ConfigurationKey key = makeKey(tab);
//#endif 


//#if -132247370 
position.setCurrentValue(Configuration.getString(key, "South"));
//#endif 

} 

//#endif 


//#if -11427441 
private Property createProperty(String text, String[] positions,
                                    Class tab)
    { 

//#if -943004290 
ConfigurationKey key = makeKey(tab);
//#endif 


//#if 458123130 
String currentValue = Configuration.getString(key, "South");
//#endif 


//#if 1758805136 
return new Property(Translator.localize(text), String.class,
                            currentValue, positions);
//#endif 

} 

//#endif 


//#if -942134468 
public JPanel getTabPanel()
    { 

//#if 966416474 
return this;
//#endif 

} 

//#endif 


//#if 620965808 
private ConfigurationKey makeKey(Class tab)
    { 

//#if 1534520634 
String className = tab.getName();
//#endif 


//#if -1507446878 
String shortClassName =
            className.substring(className.lastIndexOf('.') + 1).toLowerCase();
//#endif 


//#if -1755440740 
ConfigurationKey key = Configuration.makeKey("layout", shortClassName);
//#endif 


//#if -646467639 
return key;
//#endif 

} 

//#endif 


//#if 1587871908 
public void handleResetToDefault()
    { 
} 

//#endif 


//#if 831906084 
public void handleSettingsTabSave()
    { 
} 

//#endif 

 } 

//#endif 


//#endif 

