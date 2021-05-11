package org.argouml.ui;
import java.awt.Font;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.MetalTheme;
import org.argouml.application.api.Argo;
import org.argouml.configuration.Configuration;
public final class LookAndFeelMgr  { 
private static final LookAndFeelMgr	SINGLETON = new LookAndFeelMgr();
private static final String                 METAL_LAF_CLASS_NAME =
        "javax.swing.plaf.metal.MetalLookAndFeel";
private static final String			DEFAULT_KEY = "Default";
private static final MetalTheme		DEFAULT_THEME =
        new JasonsTheme();
private static final MetalTheme		BIG_THEME =
        new JasonsBigTheme();
private static final MetalTheme		HUGE_THEME =
        new JasonsHugeTheme();
private static final MetalTheme[] THEMES = {
        DEFAULT_THEME,
        BIG_THEME,
        HUGE_THEME,
        new DefaultMetalTheme(),
    };
private String				defaultLafClass;
public void setCurrentTheme(String themeClass)
    { 
MetalTheme theme = getMetalTheme(themeClass);
if(theme.getClass().getName().equals(getCurrentThemeClassName()))//1
{ 
return;
} 
setTheme(theme);
String themeValue = themeClass;
if(themeValue == null)//1
{ 
themeValue = DEFAULT_KEY;
} 
Configuration.setString(Argo.KEY_THEME_CLASS, themeValue);
} 
public void setCurrentLAFAndThemeByName(String lafName, String themeName)
    { 
String lafClass = getLookAndFeelFromName(lafName);
String currentLookAndFeel = getCurrentLookAndFeel();
if(lafClass == null && currentLookAndFeel == null)//1
{ 
return;
} 
if(lafClass == null)//1
{ 
lafClass = DEFAULT_KEY;
} 
Configuration.setString(Argo.KEY_LOOK_AND_FEEL_CLASS, lafClass);
setCurrentTheme(getThemeFromName(themeName));
} 
public String getCurrentLookAndFeel()
    { 
String value =
            Configuration.getString(Argo.KEY_LOOK_AND_FEEL_CLASS, null);
if(DEFAULT_KEY.equals(value))//1
{ 
value = null;
} 
return value;
} 
public String getLookAndFeelFromName(String name)
    { 
if(name == null || DEFAULT_KEY.equals(name))//1
{ 
return null;
} 
String className = null;
UIManager.LookAndFeelInfo[] lafs = UIManager.getInstalledLookAndFeels();
for (int i = 0; i < lafs.length; ++i) //1
{ 
if(lafs[i].getName().equals(name))//1
{ 
className = lafs[i].getClassName();
} 
} 
return className;
} 
private LookAndFeelMgr()
    { 
LookAndFeel laf = UIManager.getLookAndFeel();
if(laf != null)//1
{ 
defaultLafClass = laf.getClass().getName();
} 
else
{ 
defaultLafClass = null;
} 
} 
public Font getStandardFont()
    { 
Font font = UIManager.getDefaults().getFont("TextField.font");
if(font == null)//1
{ 
font = (new javax.swing.JTextField()).getFont();
} 
return font;
} 
public void printThemeArgs()
    { 
System.err.println("  -big            use big fonts");
System.err.println("  -huge           use huge fonts");
} 
public Font getSmallFont()
    { 
Font font = getStandardFont();
if(font.getSize2D() >= 12f)//1
{ 
return font.deriveFont(font.getSize2D() - 2f);
} 
return font;
} 
public String getThemeFromName(String name)
    { 
if(name == null)//1
{ 
return null;
} 
String className = null;
for (int i = 0; i < THEMES.length; ++i) //1
{ 
if(THEMES[i].getName().equals(name))//1
{ 
className = THEMES[i].getClass().getName();
} 
} 
return className;
} 
private MetalTheme getMetalTheme(String themeClass)
    { 
MetalTheme theme = null;
for (int i = 0; i < THEMES.length; ++i) //1
{ 
if(THEMES[i].getClass().getName().equals(themeClass))//1
{ 
theme = THEMES[i];
} 
} 
if(theme == null)//1
{ 
theme = DEFAULT_THEME;
} 
return theme;
} 
public static LookAndFeelMgr getInstance()
    { 
return SINGLETON;
} 
public String[] getAvailableThemeNames()
    { 
String[] names = new String[LookAndFeelMgr.THEMES.length];
for (int i = 0; i < THEMES.length; ++i) //1
{ 
names[i] = THEMES[i].getName();
} 
return names;
} 
public String[] getAvailableLookAndFeelNames()
    { 
UIManager.LookAndFeelInfo[] lafs = UIManager.getInstalledLookAndFeels();
String[] names = new String[lafs.length + 1];
names[0] = DEFAULT_KEY;
for (int i = 0; i < lafs.length; ++i) //1
{ 
names[i + 1] = lafs[i].getName();
} 
return names;
} 
public boolean isThemeCompatibleLookAndFeel(String lafClass)
    { 
if(lafClass == null)//1
{ 
return false;
} 
return (/*lafClass == null ||*/ lafClass.equals(METAL_LAF_CLASS_NAME));
} 
public String getCurrentThemeClassName()
    { 
String value = Configuration.getString(Argo.KEY_THEME_CLASS, null);
if(DEFAULT_KEY.equals(value))//1
{ 
value = null;
} 
return value;
} 
private void setTheme(MetalTheme theme)
    { 
String currentLookAndFeel = getCurrentLookAndFeel();
if((currentLookAndFeel != null
                && currentLookAndFeel.equals(METAL_LAF_CLASS_NAME))
                || (currentLookAndFeel == null
                    && defaultLafClass.equals(METAL_LAF_CLASS_NAME)))//1
{ 
try//1
{ 
MetalLookAndFeel.setCurrentTheme(theme);
UIManager.setLookAndFeel(METAL_LAF_CLASS_NAME);
} 
catch (UnsupportedLookAndFeelException e) //1
{ 
} 
catch (ClassNotFoundException e) //1
{ 
} 
catch (InstantiationException e) //1
{ 
} 
catch (IllegalAccessException e) //1
{ 
} 
} 
} 
public String getCurrentThemeName()
    { 
String currentThemeClassName = getCurrentThemeClassName();
if(currentThemeClassName == null)//1
{ 
return THEMES[0].getName();
} 
for (int i = 0; i < THEMES.length; ++i) //1
{ 
if(THEMES[i].getClass().getName().equals(currentThemeClassName))//1
{ 
return THEMES[i].getName();
} 
} 
return THEMES[0].getName();
} 
public String getCurrentLookAndFeelName()
    { 
String currentLookAndFeel = getCurrentLookAndFeel();
if(currentLookAndFeel == null)//1
{ 
return DEFAULT_KEY;
} 
String name = null;
UIManager.LookAndFeelInfo[] lafs =
            UIManager.getInstalledLookAndFeels();
for (int i = 0; i < lafs.length; ++i) //1
{ 
if(lafs[i].getClassName().equals(currentLookAndFeel))//1
{ 
name = lafs[i].getName();
} 
} 
return name;
} 
private void setLookAndFeel(String lafClass)
    { 
try//1
{ 
if(lafClass == null && defaultLafClass != null)//1
{ 
UIManager.setLookAndFeel(defaultLafClass);
} 
else
{ 
UIManager.setLookAndFeel(lafClass);
} 
} 
catch (UnsupportedLookAndFeelException e) //1
{ 
} 
catch (ClassNotFoundException e) //1
{ 
} 
catch (InstantiationException e) //1
{ 
} 
catch (IllegalAccessException e) //1
{ 
} 
} 
public String getThemeClassNameFromArg(String arg)
    { 
if(arg.equalsIgnoreCase("-big"))//1
{ 
return BIG_THEME.getClass().getName();
} 
else
if(arg.equalsIgnoreCase("-huge"))//1
{ 
return HUGE_THEME.getClass().getName();
} 
return null;
} 
public void initializeLookAndFeel()
    { 
String n = getCurrentLookAndFeel();
setLookAndFeel(n);
if(isThemeCompatibleLookAndFeel(n))//1
{ 
setTheme(getMetalTheme(getCurrentThemeClassName()));
} 
} 

 } 
