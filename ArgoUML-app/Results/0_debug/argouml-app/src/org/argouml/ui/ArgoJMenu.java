
//#if 1315528314 
// Compilation Unit of /ArgoJMenu.java 
 

//#if -778413307 
package org.argouml.ui;
//#endif 


//#if 121782775 
import javax.swing.Action;
//#endif 


//#if 883486868 
import javax.swing.Icon;
//#endif 


//#if -1656627894 
import javax.swing.JCheckBoxMenuItem;
//#endif 


//#if 1626304768 
import javax.swing.JMenu;
//#endif 


//#if -1966441043 
import javax.swing.JMenuItem;
//#endif 


//#if 1750596120 
import javax.swing.JRadioButtonMenuItem;
//#endif 


//#if -1859766884 
import javax.swing.SwingConstants;
//#endif 


//#if -732220140 
import org.argouml.i18n.Translator;
//#endif 


//#if 300836578 
public class ArgoJMenu extends 
//#if -285004037 
JMenu
//#endif 

  { 

//#if 682678175 
private static final long serialVersionUID = 8318663502924796474L;
//#endif 


//#if 800561636 
public JCheckBoxMenuItem addCheckItem(Action a)
    { 

//#if 1933640499 
String name = (String) a.getValue(Action.NAME);
//#endif 


//#if 823142971 
Icon icon = (Icon) a.getValue(Action.SMALL_ICON);
//#endif 


//#if -303144837 
Boolean selected = (Boolean) a.getValue("SELECTED");
//#endif 


//#if -1272146878 
JCheckBoxMenuItem mi =
            new JCheckBoxMenuItem(name, icon,
                                  (selected == null
                                   || selected.booleanValue()));
//#endif 


//#if 1533996028 
mi.setHorizontalTextPosition(SwingConstants.RIGHT);
//#endif 


//#if 2084018507 
mi.setVerticalTextPosition(SwingConstants.CENTER);
//#endif 


//#if -950343245 
mi.setEnabled(a.isEnabled());
//#endif 


//#if -1369200297 
mi.addActionListener(a);
//#endif 


//#if 612857704 
add(mi);
//#endif 


//#if -101424869 
a.addPropertyChangeListener(createActionChangeListener(mi));
//#endif 


//#if 2129042908 
return mi;
//#endif 

} 

//#endif 


//#if -1357358326 
public ArgoJMenu(String key)
    { 

//#if 1012066002 
super();
//#endif 


//#if 642138383 
localize(this, key);
//#endif 

} 

//#endif 


//#if 1580033389 
public JRadioButtonMenuItem addRadioItem(Action a)
    { 

//#if 1210701337 
String name = (String) a.getValue(Action.NAME);
//#endif 


//#if 1863310241 
Icon icon = (Icon) a.getValue(Action.SMALL_ICON);
//#endif 


//#if -869044907 
Boolean selected = (Boolean) a.getValue("SELECTED");
//#endif 


//#if 1098222596 
JRadioButtonMenuItem mi =
            new JRadioButtonMenuItem(name, icon,
                                     (selected == null
                                      || selected.booleanValue()));
//#endif 


//#if 551647458 
mi.setHorizontalTextPosition(SwingConstants.RIGHT);
//#endif 


//#if -580069467 
mi.setVerticalTextPosition(SwingConstants.CENTER);
//#endif 


//#if -1647958247 
mi.setEnabled(a.isEnabled());
//#endif 


//#if -103472079 
mi.addActionListener(a);
//#endif 


//#if 1307436610 
add(mi);
//#endif 


//#if -660932875 
a.addPropertyChangeListener(createActionChangeListener(mi));
//#endif 


//#if -2108814782 
return mi;
//#endif 

} 

//#endif 


//#if -1938929389 
public static final void localize(JMenuItem menuItem, String key)
    { 

//#if 609535971 
menuItem.setText(Translator.localize(key));
//#endif 


//#if -1282540587 
String localMnemonic = Translator.localize(key + ".mnemonic");
//#endif 


//#if -1781106029 
if(localMnemonic != null && localMnemonic.length() == 1)//1
{ 

//#if -840820167 
menuItem.setMnemonic(localMnemonic.charAt(0));
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

