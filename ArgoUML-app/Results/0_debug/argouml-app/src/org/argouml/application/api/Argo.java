
//#if 1341421354 
// Compilation Unit of /Argo.java 
 

//#if 710453540 
package org.argouml.application.api;
//#endif 


//#if -758343331 
import org.argouml.configuration.Configuration;
//#endif 


//#if -277619334 
import org.argouml.configuration.ConfigurationKey;
//#endif 


//#if 2054620310 
import org.apache.log4j.Category;
//#endif 


//#if 1066385982 
import org.apache.log4j.Level;
//#endif 


//#if 1489575426 
public final class Argo  { 

//#if 246104364 
@Deprecated
    public static final String ARGOINI = "/org/argouml/argo.ini";
//#endif 


//#if -537873125 
public static final ConfigurationKey KEY_STARTUP_DIR =
        Configuration.makeKey("default", "user", "dir");
//#endif 


//#if -938203039 
public static final ConfigurationKey KEY_SPLASH =
        Configuration.makeKey("init", "splash");
//#endif 


//#if -1177267935 
public static final ConfigurationKey KEY_EDEM =
        Configuration.makeKey("init", "edem");
//#endif 


//#if 1829024860 
public static final ConfigurationKey KEY_MOST_RECENT_PROJECT_FILE =
        Configuration.makeKey("project", "mostrecent", "file");
//#endif 


//#if 479975159 
public static final ConfigurationKey KEY_MOST_RECENT_EXPORT_DIRECTORY =
        Configuration.makeKey("project", "mostrecent", "exportdirectory");
//#endif 


//#if -221160549 
public static final ConfigurationKey KEY_RELOAD_RECENT_PROJECT =
        Configuration.makeKey("init", "project", "loadmostrecent");
//#endif 


//#if 1444167229 
public static final ConfigurationKey KEY_NUMBER_LAST_RECENT_USED =
        Configuration.makeKey("project", "mostrecent", "maxNumber");
//#endif 


//#if -806079110 
public static final ConfigurationKey KEY_SCREEN_TOP_Y =
        Configuration.makeKey("screen", "top");
//#endif 


//#if -1039091221 
public static final ConfigurationKey KEY_SCREEN_LEFT_X =
        Configuration.makeKey("screen", "left");
//#endif 


//#if -1608160078 
public static final ConfigurationKey KEY_SCREEN_WIDTH =
        Configuration.makeKey("screen", "width");
//#endif 


//#if 252124050 
public static final ConfigurationKey KEY_SCREEN_HEIGHT =
        Configuration.makeKey("screen", "height");
//#endif 


//#if 454273550 
public static final ConfigurationKey KEY_SCREEN_MAXIMIZED =
        Configuration.makeKey("screen", "maximized");
//#endif 


//#if -657615471 
public static final ConfigurationKey KEY_SCREEN_SOUTHWEST_WIDTH =
        Configuration.makeKey("screen", "southwest", "width");
//#endif 


//#if -1204143839 
public static final ConfigurationKey KEY_SCREEN_NORTHWEST_WIDTH =
        Configuration.makeKey("screen", "northwest", "width");
//#endif 


//#if -1898452107 
public static final ConfigurationKey KEY_SCREEN_SOUTHEAST_WIDTH =
        Configuration.makeKey("screen", "southeast", "width");
//#endif 


//#if 1849986821 
public static final ConfigurationKey KEY_SCREEN_NORTHEAST_WIDTH =
        Configuration.makeKey("screen", "northeast", "width");
//#endif 


//#if 525791435 
public static final ConfigurationKey KEY_SCREEN_WEST_WIDTH =
        Configuration.makeKey("screen", "west", "width");
//#endif 


//#if -948531829 
public static final ConfigurationKey KEY_SCREEN_EAST_WIDTH =
        Configuration.makeKey("screen", "east", "width");
//#endif 


//#if 760277529 
public static final ConfigurationKey KEY_SCREEN_SOUTH_HEIGHT =
        Configuration.makeKey("screen", "south", "height");
//#endif 


//#if -1792424679 
public static final ConfigurationKey KEY_SCREEN_NORTH_HEIGHT =
        Configuration.makeKey("screen", "north", "height");
//#endif 


//#if -707274452 
public static final ConfigurationKey KEY_SCREEN_THEME =
        Configuration.makeKey("screen", "theme");
//#endif 


//#if 1403893516 
public static final ConfigurationKey KEY_LOOK_AND_FEEL_CLASS =
        Configuration.makeKey("screen", "lookAndFeelClass");
//#endif 


//#if -1272740558 
public static final ConfigurationKey KEY_THEME_CLASS =
        Configuration.makeKey("screen", "themeClass");
//#endif 


//#if -992260908 
public static final ConfigurationKey KEY_SMOOTH_EDGES =
        Configuration.makeKey("screen", "diagram-antialiasing");
//#endif 


//#if -378826488 
public static final ConfigurationKey KEY_USER_EMAIL =
        Configuration.makeKey("user", "email");
//#endif 


//#if 650239122 
public static final ConfigurationKey KEY_USER_FULLNAME =
        Configuration.makeKey("user", "fullname");
//#endif 


//#if 187020956 
public static final ConfigurationKey KEY_USER_IMPORT_CLASSPATH =
        Configuration.makeKey("import", "clazzpath");
//#endif 


//#if 272876669 
public static final ConfigurationKey KEY_IMPORT_GENERAL_SETTINGS_FLAGS =
        Configuration.makeKey("import", "general", "flags");
//#endif 


//#if 162599442 
public static final ConfigurationKey KEY_IMPORT_GENERAL_DETAIL_LEVEL =
        Configuration.makeKey("import", "general", "detail", "level");
//#endif 


//#if -228867137 
public static final ConfigurationKey KEY_INPUT_SOURCE_ENCODING =
        Configuration.makeKey("import", "file", "encoding");
//#endif 


//#if 1105740236 
public static final ConfigurationKey KEY_XMI_STRIP_DIAGRAMS =
        Configuration.makeKey("import", "xmi", "stripDiagrams");
//#endif 


//#if -1026467094 
public static final ConfigurationKey KEY_DEFAULT_MODEL =
        Configuration.makeKey("defaultModel");
//#endif 


//#if -1257588516 
public static final ConfigurationKey KEY_USER_EXPLORER_PERSPECTIVES =
        Configuration.makeKey("explorer", "perspectives");
//#endif 


//#if 1044741579 
public static final ConfigurationKey KEY_LOCALE =
        Configuration.makeKey("locale");
//#endif 


//#if -1598617741 
public static final ConfigurationKey KEY_GRID =
        Configuration.makeKey("grid");
//#endif 


//#if 1701982059 
public static final ConfigurationKey KEY_SNAP =
        Configuration.makeKey("snap");
//#endif 


//#if 846829305 
public static final String ARGO_CONSOLE_SUPPRESS = "argo.console.suppress";
//#endif 


//#if 843571225 
public static final String ARGO_CONSOLE_PREFIX = "argo.console.prefix";
//#endif 


//#if -395249312 
public static final String DOCUMENTATION_TAG = "documentation";
//#endif 


//#if 1733084118 
public static final String AUTHOR_TAG = "author";
//#endif 


//#if 1910205792 
public static final String SINCE_TAG = "since";
//#endif 


//#if 1702900352 
public static final String SEE_TAG = "see";
//#endif 


//#if 1443523494 
public static final String DEPRECATED_TAG = "deprecated";
//#endif 


//#if 115428640 
public static final String VERSION_TAG = "version";
//#endif 


//#if 313097588 
@Deprecated
    public static final String DOCUMENTATION_TAG_ALT = "javadocs";
//#endif 


//#if 544208444 
public static final int SCOPE_APPLICATION = 0;
//#endif 


//#if 618842610 
public static final int SCOPE_PROJECT = 1;
//#endif 


//#if -258451445 
public static final String CONSOLE_LOG = "argo.console.log";
//#endif 


//#if 1945767146 
static
    {
        if (System.getProperty(ARGO_CONSOLE_SUPPRESS) != null) {
            Category.getRoot().getLoggerRepository().setThreshold(Level.OFF);
        }
    }
//#endif 


//#if 68229430 
public static void setDirectory(String dir)
    { 

//#if 482930756 
org.tigris.gef.base.Globals.setLastDirectory(dir);
//#endif 

} 

//#endif 


//#if 1186832441 
public static String getEncoding()
    { 

//#if 2062079947 
return "UTF-8";
//#endif 

} 

//#endif 


//#if -1244882391 
public static String getDirectory()
    { 

//#if -398928796 
return Configuration.getString(KEY_STARTUP_DIR,
                                       org.tigris.gef.base.Globals
                                       .getLastDirectory());
//#endif 

} 

//#endif 


//#if 1735882100 
private Argo()
    { 
} 

//#endif 

 } 

//#endif 


//#endif 

