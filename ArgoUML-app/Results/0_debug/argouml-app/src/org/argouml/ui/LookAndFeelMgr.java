
//#if -32909132 
// Compilation Unit of /LookAndFeelMgr.java 
 

//#if 1980611038 
package org.argouml.ui;
//#endif 


//#if 1842039087 
import java.awt.Font;
//#endif 


//#if 1689353060 
import javax.swing.LookAndFeel;
//#endif 


//#if -460661143 
import javax.swing.UIManager;
//#endif 


//#if -517499876 
import javax.swing.UnsupportedLookAndFeelException;
//#endif 


//#if -1114253275 
import javax.swing.plaf.metal.DefaultMetalTheme;
//#endif 


//#if -751893801 
import javax.swing.plaf.metal.MetalLookAndFeel;
//#endif 


//#if -1478737300 
import javax.swing.plaf.metal.MetalTheme;
//#endif 


//#if -1157560588 
import org.argouml.application.api.Argo;
//#endif 


//#if -1604246247 
import org.argouml.configuration.Configuration;
//#endif 


//#if 1021441088 
import org.apache.log4j.Logger;
//#endif 


//#if 1854645855 
public final class LookAndFeelMgr  { 

//#if -1670281704 
private static final LookAndFeelMgr	SINGLETON = new LookAndFeelMgr();
//#endif 


//#if 1191310786 
private static final String                 METAL_LAF_CLASS_NAME =
        "javax.swing.plaf.metal.MetalLookAndFeel";
//#endif 


//#if 640258929 
private static final String			DEFAULT_KEY = "Default";
//#endif 


//#if -1589251831 
private static final MetalTheme		DEFAULT_THEME =
        new JasonsTheme();
//#endif 


//#if 1775270874 
private static final MetalTheme		BIG_THEME =
        new JasonsBigTheme();
//#endif 


//#if 1222546490 
private static final MetalTheme		HUGE_THEME =
        new JasonsHugeTheme();
//#endif 


//#if -1136960822 
private static final MetalTheme[] THEMES = {
        DEFAULT_THEME,
        BIG_THEME,
        HUGE_THEME,
        new DefaultMetalTheme(),
    };
//#endif 


//#if -1221509248 
private String				defaultLafClass;
//#endif 


//#if 1056308129 
private static final Logger LOG = Logger.getLogger(LookAndFeelMgr.class);
//#endif 


//#if -6438737 
public void setCurrentTheme(String themeClass)
    { 

//#if 581185013 
MetalTheme theme = getMetalTheme(themeClass);
//#endif 


//#if 1828928063 
if(theme.getClass().getName().equals(getCurrentThemeClassName()))//1
{ 

//#if 1000485965 
return;
//#endif 

} 

//#endif 


//#if 1643427336 
setTheme(theme);
//#endif 


//#if 1277259030 
String themeValue = themeClass;
//#endif 


//#if 1730166484 
if(themeValue == null)//1
{ 

//#if -1259357253 
themeValue = DEFAULT_KEY;
//#endif 

} 

//#endif 


//#if -1842674626 
Configuration.setString(Argo.KEY_THEME_CLASS, themeValue);
//#endif 

} 

//#endif 


//#if 994786661 
public void setCurrentLAFAndThemeByName(String lafName, String themeName)
    { 

//#if -1554703954 
String lafClass = getLookAndFeelFromName(lafName);
//#endif 


//#if -289437620 
String currentLookAndFeel = getCurrentLookAndFeel();
//#endif 


//#if 1914542003 
if(lafClass == null && currentLookAndFeel == null)//1
{ 

//#if 336747268 
return;
//#endif 

} 

//#endif 


//#if -1620693241 
if(lafClass == null)//1
{ 

//#if -1833192039 
lafClass = DEFAULT_KEY;
//#endif 

} 

//#endif 


//#if -2073630292 
Configuration.setString(Argo.KEY_LOOK_AND_FEEL_CLASS, lafClass);
//#endif 


//#if 1733197367 
setCurrentTheme(getThemeFromName(themeName));
//#endif 

} 

//#endif 


//#if -493821893 
public String getCurrentLookAndFeel()
    { 

//#if -1594340598 
String value =
            Configuration.getString(Argo.KEY_LOOK_AND_FEEL_CLASS, null);
//#endif 


//#if 981114532 
if(DEFAULT_KEY.equals(value))//1
{ 

//#if 871581656 
value = null;
//#endif 

} 

//#endif 


//#if -1567957715 
return value;
//#endif 

} 

//#endif 


//#if -225548957 
public String getLookAndFeelFromName(String name)
    { 

//#if 252423355 
if(name == null || DEFAULT_KEY.equals(name))//1
{ 

//#if 49572552 
return null;
//#endif 

} 

//#endif 


//#if -682986211 
String className = null;
//#endif 


//#if 1648959166 
UIManager.LookAndFeelInfo[] lafs = UIManager.getInstalledLookAndFeels();
//#endif 


//#if 1596522162 
for (int i = 0; i < lafs.length; ++i) //1
{ 

//#if 1096047377 
if(lafs[i].getName().equals(name))//1
{ 

//#if -1379641217 
className = lafs[i].getClassName();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1958798100 
return className;
//#endif 

} 

//#endif 


//#if -220177353 
private LookAndFeelMgr()
    { 

//#if 1794296660 
LookAndFeel laf = UIManager.getLookAndFeel();
//#endif 


//#if 464762738 
if(laf != null)//1
{ 

//#if 1961208451 
defaultLafClass = laf.getClass().getName();
//#endif 

} 
else
{ 

//#if 1753936938 
defaultLafClass = null;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -43006684 
public Font getStandardFont()
    { 

//#if -763755021 
Font font = UIManager.getDefaults().getFont("TextField.font");
//#endif 


//#if -705496322 
if(font == null)//1
{ 

//#if 1157712477 
font = (new javax.swing.JTextField()).getFont();
//#endif 

} 

//#endif 


//#if -983675599 
return font;
//#endif 

} 

//#endif 


//#if 1816194654 
public void printThemeArgs()
    { 

//#if -2020833079 
System.err.println("  -big            use big fonts");
//#endif 


//#if -1700351145 
System.err.println("  -huge           use huge fonts");
//#endif 

} 

//#endif 


//#if -908639648 
public Font getSmallFont()
    { 

//#if 804191144 
Font font = getStandardFont();
//#endif 


//#if 1040527527 
if(font.getSize2D() >= 12f)//1
{ 

//#if -575451944 
return font.deriveFont(font.getSize2D() - 2f);
//#endif 

} 

//#endif 


//#if 1027309133 
return font;
//#endif 

} 

//#endif 


//#if 65446766 
public String getThemeFromName(String name)
    { 

//#if -952835214 
if(name == null)//1
{ 

//#if 986439049 
return null;
//#endif 

} 

//#endif 


//#if -1156973418 
String className = null;
//#endif 


//#if -796212847 
for (int i = 0; i < THEMES.length; ++i) //1
{ 

//#if 1391389260 
if(THEMES[i].getName().equals(name))//1
{ 

//#if -1056251540 
className = THEMES[i].getClass().getName();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1164366843 
return className;
//#endif 

} 

//#endif 


//#if -1673850597 
private MetalTheme getMetalTheme(String themeClass)
    { 

//#if 1888551572 
MetalTheme theme = null;
//#endif 


//#if -681170104 
for (int i = 0; i < THEMES.length; ++i) //1
{ 

//#if -660365304 
if(THEMES[i].getClass().getName().equals(themeClass))//1
{ 

//#if -1709969301 
theme = THEMES[i];
//#endif 

} 

//#endif 

} 

//#endif 


//#if -502451977 
if(theme == null)//1
{ 

//#if -148733248 
theme = DEFAULT_THEME;
//#endif 

} 

//#endif 


//#if -399936116 
return theme;
//#endif 

} 

//#endif 


//#if 631496852 
public static LookAndFeelMgr getInstance()
    { 

//#if 1381056809 
return SINGLETON;
//#endif 

} 

//#endif 


//#if 809231926 
public String[] getAvailableThemeNames()
    { 

//#if -688943850 
String[] names = new String[LookAndFeelMgr.THEMES.length];
//#endif 


//#if -19515538 
for (int i = 0; i < THEMES.length; ++i) //1
{ 

//#if 690282883 
names[i] = THEMES[i].getName();
//#endif 

} 

//#endif 


//#if -1155731309 
return names;
//#endif 

} 

//#endif 


//#if 1213597025 
public String[] getAvailableLookAndFeelNames()
    { 

//#if -252586376 
UIManager.LookAndFeelInfo[] lafs = UIManager.getInstalledLookAndFeels();
//#endif 


//#if 1152049682 
String[] names = new String[lafs.length + 1];
//#endif 


//#if 454648901 
names[0] = DEFAULT_KEY;
//#endif 


//#if 784888504 
for (int i = 0; i < lafs.length; ++i) //1
{ 

//#if -77909116 
names[i + 1] = lafs[i].getName();
//#endif 

} 

//#endif 


//#if 866413973 
return names;
//#endif 

} 

//#endif 


//#if -167191508 
public boolean isThemeCompatibleLookAndFeel(String lafClass)
    { 

//#if -685375394 
if(lafClass == null)//1
{ 

//#if 729088387 
return false;
//#endif 

} 

//#endif 


//#if 395457982 
return (/*lafClass == null ||*/ lafClass.equals(METAL_LAF_CLASS_NAME));
//#endif 

} 

//#endif 


//#if 374838047 
public String getCurrentThemeClassName()
    { 

//#if -1004988668 
String value = Configuration.getString(Argo.KEY_THEME_CLASS, null);
//#endif 


//#if -553578417 
if(DEFAULT_KEY.equals(value))//1
{ 

//#if -93796643 
value = null;
//#endif 

} 

//#endif 


//#if 1850511960 
return value;
//#endif 

} 

//#endif 


//#if -388719821 
private void setTheme(MetalTheme theme)
    { 

//#if 1281598818 
String currentLookAndFeel = getCurrentLookAndFeel();
//#endif 


//#if -1967054288 
if((currentLookAndFeel != null
                && currentLookAndFeel.equals(METAL_LAF_CLASS_NAME))
                || (currentLookAndFeel == null
                    && defaultLafClass.equals(METAL_LAF_CLASS_NAME)))//1
{ 

//#if -1379656265 
try //1
{ 

//#if -1144641703 
MetalLookAndFeel.setCurrentTheme(theme);
//#endif 


//#if -278626378 
UIManager.setLookAndFeel(METAL_LAF_CLASS_NAME);
//#endif 

} 

//#if 391474111 
catch (UnsupportedLookAndFeelException e) //1
{ 

//#if 676566285 
LOG.error(e);
//#endif 

} 

//#endif 


//#if 1358827405 
catch (ClassNotFoundException e) //1
{ 

//#if -1955701068 
LOG.error(e);
//#endif 

} 

//#endif 


//#if -62878637 
catch (InstantiationException e) //1
{ 

//#if 1599123720 
LOG.error(e);
//#endif 

} 

//#endif 


//#if 2080387264 
catch (IllegalAccessException e) //1
{ 

//#if 239878858 
LOG.error(e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if -108490447 
public String getCurrentThemeName()
    { 

//#if -1072926430 
String currentThemeClassName = getCurrentThemeClassName();
//#endif 


//#if 1698722679 
if(currentThemeClassName == null)//1
{ 

//#if -1243497132 
return THEMES[0].getName();
//#endif 

} 

//#endif 


//#if -549321762 
for (int i = 0; i < THEMES.length; ++i) //1
{ 

//#if 413882321 
if(THEMES[i].getClass().getName().equals(currentThemeClassName))//1
{ 

//#if -689153185 
return THEMES[i].getName();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -80268295 
return THEMES[0].getName();
//#endif 

} 

//#endif 


//#if -1233083610 
public String getCurrentLookAndFeelName()
    { 

//#if -223991285 
String currentLookAndFeel = getCurrentLookAndFeel();
//#endif 


//#if 1810290340 
if(currentLookAndFeel == null)//1
{ 

//#if -1790314072 
return DEFAULT_KEY;
//#endif 

} 

//#endif 


//#if -614072050 
String name = null;
//#endif 


//#if -1207303889 
UIManager.LookAndFeelInfo[] lafs =
            UIManager.getInstalledLookAndFeels();
//#endif 


//#if 1679693217 
for (int i = 0; i < lafs.length; ++i) //1
{ 

//#if 1266859379 
if(lafs[i].getClassName().equals(currentLookAndFeel))//1
{ 

//#if 806264457 
name = lafs[i].getName();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -845693787 
return name;
//#endif 

} 

//#endif 


//#if 1048471445 
private void setLookAndFeel(String lafClass)
    { 

//#if 719233033 
try //1
{ 

//#if -1345431357 
if(lafClass == null && defaultLafClass != null)//1
{ 

//#if 1843895695 
UIManager.setLookAndFeel(defaultLafClass);
//#endif 

} 
else
{ 

//#if 1640768616 
UIManager.setLookAndFeel(lafClass);
//#endif 

} 

//#endif 

} 

//#if -1699601743 
catch (UnsupportedLookAndFeelException e) //1
{ 

//#if -447722612 
LOG.error(e);
//#endif 

} 

//#endif 


//#if 1154768987 
catch (ClassNotFoundException e) //1
{ 

//#if -1568301078 
LOG.error(e);
//#endif 

} 

//#endif 


//#if -266937055 
catch (InstantiationException e) //1
{ 

//#if 298099036 
LOG.error(e);
//#endif 

} 

//#endif 


//#if 1876328846 
catch (IllegalAccessException e) //1
{ 

//#if 1366877339 
LOG.error(e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1822761393 
public String getThemeClassNameFromArg(String arg)
    { 

//#if -1002381488 
if(arg.equalsIgnoreCase("-big"))//1
{ 

//#if 1176892421 
return BIG_THEME.getClass().getName();
//#endif 

} 
else

//#if 103536063 
if(arg.equalsIgnoreCase("-huge"))//1
{ 

//#if 13793266 
return HUGE_THEME.getClass().getName();
//#endif 

} 

//#endif 


//#endif 


//#if 57600628 
return null;
//#endif 

} 

//#endif 


//#if 1636815435 
public void initializeLookAndFeel()
    { 

//#if -228464559 
String n = getCurrentLookAndFeel();
//#endif 


//#if 1926231494 
setLookAndFeel(n);
//#endif 


//#if 1908867655 
if(isThemeCompatibleLookAndFeel(n))//1
{ 

//#if 590869315 
setTheme(getMetalTheme(getCurrentThemeClassName()));
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

