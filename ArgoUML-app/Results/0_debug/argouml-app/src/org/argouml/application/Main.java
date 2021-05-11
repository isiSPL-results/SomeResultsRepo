
//#if 52457784 
// Compilation Unit of /Main.java 
 

//#if -1823735372 
package org.argouml.application;
//#endif 


//#if -391557720 
import java.awt.Cursor;
//#endif 


//#if 356370695 
import java.awt.EventQueue;
//#endif 


//#if -899857909 
import java.awt.Frame;
//#endif 


//#if -572342896 
import java.awt.GraphicsEnvironment;
//#endif 


//#if 548972489 
import java.awt.Rectangle;
//#endif 


//#if -944902364 
import java.io.File;
//#endif 


//#if 565674733 
import java.io.IOException;
//#endif 


//#if -1452615412 
import java.io.InputStream;
//#endif 


//#if -979765479 
import java.net.InetAddress;
//#endif 


//#if 875366986 
import java.net.URL;
//#endif 


//#if 1840306848 
import java.net.UnknownHostException;
//#endif 


//#if -1705585245 
import java.util.ArrayList;
//#endif 


//#if -1439320013 
import java.util.Enumeration;
//#endif 


//#if 1364862686 
import java.util.List;
//#endif 


//#if -490702807 
import java.util.Properties;
//#endif 


//#if -618318117 
import javax.swing.JOptionPane;
//#endif 


//#if 1546319898 
import javax.swing.JPanel;
//#endif 


//#if -1037241718 
import javax.swing.ToolTipManager;
//#endif 


//#if 1242096622 
import javax.swing.UIDefaults;
//#endif 


//#if 1597263305 
import javax.swing.UIManager;
//#endif 


//#if -853590522 
import org.apache.log4j.PropertyConfigurator;
//#endif 


//#if 369769364 
import org.argouml.application.api.Argo;
//#endif 


//#if 987266675 
import org.argouml.application.api.CommandLineInterface;
//#endif 


//#if 162756047 
import org.argouml.application.security.ArgoAwtExceptionHandler;
//#endif 


//#if 588348537 
import org.argouml.configuration.Configuration;
//#endif 


//#if 1873968589 
import org.argouml.i18n.Translator;
//#endif 


//#if 2133284850 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 554448659 
import org.argouml.model.Model;
//#endif 


//#if 1669264345 
import org.argouml.moduleloader.InitModuleLoader;
//#endif 


//#if 153678523 
import org.argouml.moduleloader.ModuleLoader2;
//#endif 


//#if 892227481 
import org.argouml.notation.InitNotation;
//#endif 


//#if -2112896585 
import org.argouml.notation.providers.java.InitNotationJava;
//#endif 


//#if 1447377295 
import org.argouml.notation.providers.uml.InitNotationUml;
//#endif 


//#if -505691701 
import org.argouml.notation.ui.InitNotationUI;
//#endif 


//#if 1101294626 
import org.argouml.persistence.PersistenceManager;
//#endif 


//#if -1741352120 
import org.argouml.profile.init.InitProfileSubsystem;
//#endif 


//#if -1220980573 
import org.argouml.ui.LookAndFeelMgr;
//#endif 


//#if -1816138194 
import org.argouml.ui.ProjectBrowser;
//#endif 


//#if -1162361014 
import org.argouml.ui.SplashScreen;
//#endif 


//#if 141475189 
import org.argouml.ui.cmd.ActionExit;
//#endif 


//#if -265720240 
import org.argouml.ui.cmd.InitUiCmdSubsystem;
//#endif 


//#if -1386333271 
import org.argouml.ui.cmd.PrintManager;
//#endif 


//#if -8505487 
import org.argouml.uml.diagram.static_structure.ui.InitClassDiagram;
//#endif 


//#if -1949155319 
import org.argouml.uml.diagram.ui.InitDiagramAppearanceUI;
//#endif 


//#if -843997369 
import org.argouml.uml.ui.InitUmlUI;
//#endif 


//#if 896040023 
import org.argouml.util.ArgoFrame;
//#endif 


//#if 1867948565 
import org.argouml.util.JavaRuntimeUtility;
//#endif 


//#if -1394544351 
import org.argouml.util.logging.AwtExceptionHandler;
//#endif 


//#if 1426409927 
import org.argouml.util.logging.SimpleTimer;
//#endif 


//#if -809388690 
import org.tigris.gef.util.Util;
//#endif 


//#if -1435314173 
import org.apache.log4j.BasicConfigurator;
//#endif 


//#if -189049950 
import org.apache.log4j.Level;
//#endif 


//#if -1293087840 
import org.apache.log4j.Logger;
//#endif 


//#if 992374393 
import org.argouml.cognitive.AbstractCognitiveTranslator;
//#endif 


//#if 1046335776 
import org.argouml.cognitive.Designer;
//#endif 


//#if -1868077997 
import org.argouml.cognitive.checklist.ui.InitCheckListUI;
//#endif 


//#if -1490077561 
import org.argouml.cognitive.ui.InitCognitiveUI;
//#endif 


//#if 323348867 
import org.argouml.cognitive.ui.ToDoPane;
//#endif 


//#if 1224522429 
import org.argouml.uml.diagram.collaboration.ui.InitCollaborationDiagram;
//#endif 


//#if 346179359 
import org.argouml.uml.diagram.deployment.ui.InitDeploymentDiagram;
//#endif 


//#if -1242350121 
import org.argouml.uml.diagram.sequence.ui.InitSequenceDiagram;
//#endif 


//#if 2055284541 
import org.argouml.uml.diagram.state.ui.InitStateDiagram;
//#endif 


//#if -2057270710 
import org.argouml.uml.diagram.use_case.ui.InitUseCaseDiagram;
//#endif 


//#if -1383105421 
import org.argouml.uml.diagram.activity.ui.InitActivityDiagram;
//#endif 


//#if 351175876 
class PostLoad implements 
//#if -1829584140 
Runnable
//#endif 

  { 

//#if 1528755635 
private List<Runnable> postLoadActions;
//#endif 


//#if 1736513245 
private static final Logger LOG = Logger.getLogger(PostLoad.class);
//#endif 


//#if 1210136753 
public PostLoad(List<Runnable> actions)
    { 

//#if -133778910 
postLoadActions = actions;
//#endif 

} 

//#endif 


//#if 1645473752 
public void run()
    { 

//#if 584538956 
try //1
{ 

//#if -2034542176 
Thread.sleep(1000);
//#endif 

} 

//#if 1877357484 
catch (Exception ex) //1
{ 

//#if 415684912 
LOG.error("post load no sleep", ex);
//#endif 

} 

//#endif 


//#endif 


//#if 5933541 
for (Runnable r : postLoadActions) //1
{ 

//#if -722884218 
r.run();
//#endif 


//#if -1659324143 
try //1
{ 

//#if 1459251580 
Thread.sleep(100);
//#endif 

} 

//#if 1454767244 
catch (Exception ex) //1
{ 

//#if -1391976778 
LOG.error("post load no sleep2", ex);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#if -816804893 
class LoadModules implements 
//#if -1166427677 
Runnable
//#endif 

  { 

//#if -1866969430 
private static final String[] OPTIONAL_INTERNAL_MODULES = {
        "org.argouml.dev.DeveloperModule",
    };
//#endif 


//#if -1007654639 
private static final Logger LOG = Logger.getLogger(LoadModules.class);
//#endif 


//#if 374991142 
private void huntForInternalModules()
    { 

//#if -1263411721 
for (String module : OPTIONAL_INTERNAL_MODULES) //1
{ 

//#if -1291597160 
try //1
{ 

//#if -1978577965 
ModuleLoader2.addClass(module);
//#endif 

} 

//#if -738399430 
catch (ClassNotFoundException e) //1
{ 

//#if 286512031 
LOG.debug("Module " + module + " not found");
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if 874847753 
public void run()
    { 

//#if 2098079241 
huntForInternalModules();
//#endif 


//#if 1106296273 
LOG.info("Module loading done");
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -1463468274 
public class Main  { 

//#if -11119691 
private static final String DEFAULT_MODEL_IMPLEMENTATION =
        "org.argouml.model.mdr.MDRModelImplementation";
//#endif 


//#if 742465354 
private static List<Runnable> postLoadActions = new ArrayList<Runnable>();
//#endif 


//#if -1409137633 
private static boolean doSplash = true;
//#endif 


//#if 1663544260 
private static boolean reloadRecent = false;
//#endif 


//#if -486172360 
private static boolean batch = false;
//#endif 


//#if -1305648967 
private static List<String> commands;
//#endif 


//#if -1253326657 
private static String projectName = null;
//#endif 


//#if -139423641 
private static String theTheme;
//#endif 


//#if 1130941266 
private static final Logger LOG;
//#endif 


//#if 350807212 
public static final String DEFAULT_LOGGING_CONFIGURATION =
        "org/argouml/resource/default.lcf";
//#endif 


//#if -906040159 
static
    {
        File argoDir = new File(System.getProperty("user.home")
                                + File.separator + ".argouml");
        if (!argoDir.exists()) {
            argoDir.mkdir();
        }
    }
//#endif 


//#if -1401098314 
static
    {

        /*
         * Install the trap to "eat" SecurityExceptions.
         *
         * NOTE: This is temporary and will go away in a "future" release
         * http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=4714232
         */
        System.setProperty(
            "sun.awt.exception.handler",
            ArgoAwtExceptionHandler.class.getName());
















































    }
//#endif 


//#if 529108778 
static
    {

        /*
         * Install the trap to "eat" SecurityExceptions.
         *
         * NOTE: This is temporary and will go away in a "future" release
         * http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=4714232
         */
        System.setProperty(
            "sun.awt.exception.handler",
            ArgoAwtExceptionHandler.class.getName());




        /*
         *  The string <code>log4j.configuration</code> is the
         *  same string found in
         *  {@link org.apache.log4j.Configuration.DEFAULT_CONFIGURATION_FILE}
         *  but if we use the reference, then log4j configures itself
         *  and clears the system property and we never know if it was
         *  set.
         *
         *  If it is set, then we let the static initializer in
         * {@link Argo} perform the initialization.
         */

        // JavaWebStart properties for logs are :
        // deployment.user.logdir & deployment.user.tmp
        if (System.getProperty("log4j.configuration") == null) {
            Properties props = new Properties();
            InputStream stream = null;
            try {
                stream =
                    Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream(
                        DEFAULT_LOGGING_CONFIGURATION);
                if (stream != null) {
                    props.load(stream);
                }
            } catch (IOException io) {
                io.printStackTrace();
                System.exit(-1);
            }
            PropertyConfigurator.configure(props);
            if (stream == null) {
                BasicConfigurator.configure();
                Logger.getRootLogger().getLoggerRepository().setThreshold(
                    Level.ERROR); // default level is DEBUG
                Logger.getRootLogger().error(
                    "Failed to find valid log4j properties"
                    + "in log4j.configuration"
                    + "using default logging configuration");
            }
        }

        // initLogging();
        LOG = Logger.getLogger(Main.class);

    }
//#endif 


//#if 839968774 
private static void setSystemProperties()
    { 

//#if 1209073225 
System.setProperty("gef.imageLocation", "/org/argouml/Images");
//#endif 


//#if -1599875059 
System.setProperty("apple.laf.useScreenMenuBar", "true");
//#endif 


//#if -840528641 
System.setProperty(
            "com.apple.mrj.application.apple.menu.about.name",
            "ArgoUML");
//#endif 

} 

//#endif 


//#if 196114870 
private static SplashScreen initializeSplash()
    { 

//#if -1340181575 
SplashScreen splash = new SplashScreen();
//#endif 


//#if 1153568674 
splash.setVisible(true);
//#endif 


//#if 1376581540 
if(!EventQueue.isDispatchThread()
                && Runtime.getRuntime().availableProcessors() == 1)//1
{ 

//#if 1950261986 
synchronized (splash) //1
{ 

//#if 967154129 
while (!splash.isPaintCalled()) //1
{ 

//#if -771997477 
try //1
{ 

//#if -854154129 
splash.wait();
//#endif 

} 

//#if -407125422 
catch (InterruptedException e) //1
{ 
} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1119701389 
return splash;
//#endif 

} 

//#endif 


//#if -598120287 
private static void checkJVMVersion()
    { 

//#if -1237617925 
if(!JavaRuntimeUtility.isJreSupported())//1
{ 

//#if -935306751 
System.err.println("You are using Java "
                               + JavaRuntimeUtility.getJreVersion()
                               + ", Please use Java 5 (aka 1.5) or later"
                               + " with ArgoUML");
//#endif 


//#if 1929551485 
System.exit(0);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -877362501 
private static void initModel()
    { 

//#if 168728627 
String className = System.getProperty(
                               "argouml.model.implementation",
                               DEFAULT_MODEL_IMPLEMENTATION);
//#endif 


//#if -1849512593 
Throwable ret = Model.initialise(className);
//#endif 


//#if -1885259593 
if(ret != null)//1
{ 

//#if -603331658 
LOG.fatal("Model component not correctly initialized.", ret);
//#endif 


//#if 113131604 
System.err.println(className
                               + " is not a working Model implementation.");
//#endif 


//#if -410741403 
System.exit(1);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -878273029 
private static void openProject(SimpleTimer st, SplashScreen splash,
                                    ProjectBrowser pb, URL urlToOpen)
    { 

//#if 588017285 
if(splash != null)//1
{ 

//#if -415054721 
splash.getStatusBar().showProgress(40);
//#endif 

} 

//#endif 


//#if 1065720577 
st.mark("open project");
//#endif 


//#if 1763597710 
Designer.disableCritiquing();
//#endif 


//#if 407475465 
Designer.clearCritiquing();
//#endif 


//#if -590734265 
boolean projectLoaded = false;
//#endif 


//#if 985581196 
if(urlToOpen != null)//1
{ 

//#if 546324969 
if(splash != null)//1
{ 

//#if -657953531 
Object[] msgArgs = {projectName};
//#endif 


//#if -763296814 
splash.getStatusBar().showStatus(
                    Translator.messageFormat(
                        "statusmsg.bar.readingproject",
                        msgArgs));
//#endif 

} 

//#endif 


//#if -305918477 
String filename = urlToOpen.getFile();
//#endif 


//#if -558479978 
File file = new File(filename);
//#endif 


//#if -169041173 
System.err.println("The url of the file to open is "
                               + urlToOpen);
//#endif 


//#if -790932369 
System.err.println("The filename is " + filename);
//#endif 


//#if 765381849 
System.err.println("The file is " + file);
//#endif 


//#if -483500460 
System.err.println("File.exists = " + file.exists());
//#endif 


//#if -565320763 
projectLoaded = pb.loadProject(file, true, null);
//#endif 

} 
else
{ 

//#if -870683251 
if(splash != null)//1
{ 

//#if 25108318 
splash.getStatusBar().showStatus(
                    Translator.localize(
                        "statusmsg.bar.defaultproject"));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1795544408 
if(!projectLoaded)//1
{ 

//#if 2145122273 
ProjectManager.getManager().setCurrentProject(
                ProjectManager.getManager().getCurrentProject());
//#endif 


//#if -1271970667 
ProjectManager.getManager().setSaveEnabled(false);
//#endif 

} 

//#endif 


//#if 449092449 
st.mark("set project");
//#endif 


//#if 1580905117 
Designer.enableCritiquing();
//#endif 

} 

//#endif 


//#if 262575888 
public static void addPostLoadAction(Runnable r)
    { 

//#if -1866969538 
postLoadActions.add(r);
//#endif 

} 

//#endif 


//#if -1441466934 
private static void updateProgress(SplashScreen splash, int percent,
                                       String message)
    { 

//#if -348108554 
if(splash != null)//1
{ 

//#if -1697146477 
splash.getStatusBar().showStatus(Translator.localize(message));
//#endif 


//#if 773061278 
splash.getStatusBar().showProgress(percent);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 721128962 
private static String getMostRecentProject()
    { 

//#if 1762128709 
String s = Configuration.getString(
                       Argo.KEY_MOST_RECENT_PROJECT_FILE, "");
//#endif 


//#if -1248143200 
if(!("".equals(s)))//1
{ 

//#if -761032939 
File file = new File(s);
//#endif 


//#if 1050745517 
if(file.exists())//1
{ 

//#if -645486240 
LOG.info("Re-opening project " + s);
//#endif 


//#if 1425665445 
return s;
//#endif 

} 
else
{ 

//#if 1056232259 
LOG.warn("Cannot re-open " + s
                         + " because it does not exist");
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1693782290 
return null;
//#endif 

} 

//#endif 


//#if -1360216356 
private static void parseCommandLine(String[] args)
    { 

//#if 1608912868 
doSplash = Configuration.getBoolean(Argo.KEY_SPLASH, true);
//#endif 


//#if 1102829349 
reloadRecent = Configuration.getBoolean(
                           Argo.KEY_RELOAD_RECENT_PROJECT, false);
//#endif 


//#if -222473122 
commands = new ArrayList<String>();
//#endif 


//#if 1324729904 
theTheme = null;
//#endif 


//#if 1112750380 
for (int i = 0; i < args.length; i++) //1
{ 

//#if 207712224 
if(args[i].startsWith("-"))//1
{ 

//#if 1747587917 
String themeName = LookAndFeelMgr.getInstance()
                                   .getThemeClassNameFromArg(args[i]);
//#endif 


//#if -815199909 
if(themeName != null)//1
{ 

//#if 205600537 
theTheme = themeName;
//#endif 

} 
else

//#if -76852959 
if(args[i].equalsIgnoreCase("-help")
                    || args[i].equalsIgnoreCase("-h")
                    || args[i].equalsIgnoreCase("--help")
                    || args[i].equalsIgnoreCase("/?"))//1
{ 

//#if -544423544 
printUsage();
//#endif 


//#if 314226745 
System.exit(0);
//#endif 

} 
else

//#if -1710691914 
if(args[i].equalsIgnoreCase("-nosplash"))//1
{ 

//#if -2118633738 
doSplash = false;
//#endif 

} 
else

//#if -1176114766 
if(args[i].equalsIgnoreCase("-norecentfile"))//1
{ 

//#if 1093080729 
reloadRecent = false;
//#endif 

} 
else

//#if -180004358 
if(args[i].equalsIgnoreCase("-command")
                           && i + 1 < args.length)//1
{ 

//#if 1174431830 
commands.add(args[i + 1]);
//#endif 


//#if -913477865 
i++;
//#endif 

} 
else

//#if -2078649080 
if(args[i].equalsIgnoreCase("-locale")
                           && i + 1 < args.length)//1
{ 

//#if -944226902 
Translator.setLocale(args[i + 1]);
//#endif 


//#if -1248100610 
i++;
//#endif 

} 
else

//#if -2115402203 
if(args[i].equalsIgnoreCase("-batch"))//1
{ 

//#if -446587560 
batch = true;
//#endif 

} 
else

//#if 866983143 
if(args[i].equalsIgnoreCase("-open")
                           && i + 1 < args.length)//1
{ 

//#if 95441418 
projectName = args[++i];
//#endif 

} 
else

//#if 776980029 
if(args[i].equalsIgnoreCase("-print")
                           && i + 1 < args.length)//1
{ 

//#if -176334942 
String projectToBePrinted =
                        PersistenceManager.getInstance().fixExtension(
                            args[++i]);
//#endif 


//#if -176417346 
URL urlToBePrinted = projectUrl(projectToBePrinted,
                                                    null);
//#endif 


//#if 1845963519 
ProjectBrowser.getInstance().loadProject(
                        new File(urlToBePrinted.getFile()), true, null);
//#endif 


//#if 1016283308 
PrintManager.getInstance().print();
//#endif 


//#if -1570760954 
System.exit(0);
//#endif 

} 
else
{ 

//#if -830675890 
System.err
                    .println("Ignoring unknown/incomplete option '"
                             + args[i] + "'");
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 

} 
else
{ 

//#if -1425225696 
if(projectName == null)//1
{ 

//#if -1405486932 
System.out.println(
                        "Setting projectName to '" + args[i] + "'");
//#endif 


//#if 841623055 
projectName = args[i];
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1411102075 
private static void initPreinitialize()
    { 

//#if -546610022 
checkJVMVersion();
//#endif 


//#if -1289253476 
checkHostsFile();
//#endif 


//#if -1916044931 
Configuration.load();
//#endif 


//#if -602902226 
String directory = Argo.getDirectory();
//#endif 


//#if -745379706 
org.tigris.gef.base.Globals.setLastDirectory(directory);
//#endif 


//#if -1794461199 
initVersion();
//#endif 


//#if 1861592625 
initTranslator();
//#endif 


//#if -1224096267 
org.argouml.util.Tools.logVersionInfo();
//#endif 


//#if 1247568341 
setSystemProperties();
//#endif 

} 

//#endif 


//#if 309482090 
private static void initTranslator()
    { 

//#if 1028667537 
Translator.init(Configuration.getString(Argo.KEY_LOCALE));
//#endif 


//#if -1880854267 
org.argouml.cognitive.Translator.setTranslator(
        new AbstractCognitiveTranslator() {
            public String i18nlocalize(String key) {
                return Translator.localize(key);
            }

            public String i18nmessageFormat(String key,
                                            Object[] iArgs) {
                return Translator.messageFormat(key, iArgs);
            }
        });
//#endif 

} 

//#endif 


//#if 1207586580 
private static void printUsage()
    { 

//#if -494954428 
System.err.println("Usage: [options] [project-file]");
//#endif 


//#if 949135335 
System.err.println("Options include: ");
//#endif 


//#if 453981949 
System.err.println("  -help           display this information");
//#endif 


//#if -381744307 
LookAndFeelMgr.getInstance().printThemeArgs();
//#endif 


//#if 941914617 
System.err.println("  -nosplash       don't display logo at startup");
//#endif 


//#if 1968723854 
System.err.println("  -norecentfile   don't reload last saved file");
//#endif 


//#if -1799833068 
System.err.println("  -command <arg>  command to perform on startup");
//#endif 


//#if -1108739365 
System.err.println("  -batch          don't start GUI");
//#endif 


//#if 1062943065 
System.err.println("  -locale <arg>   set the locale (e.g. 'en_GB')");
//#endif 


//#if 1571742993 
System.err.println("");
//#endif 


//#if -943771683 
System.err.println("You can also set java settings which influence "
                           + "the behaviour of ArgoUML:");
//#endif 


//#if 1903328101 
System.err.println("  -Xms250M -Xmx500M  [makes ArgoUML reserve "
                           + "more memory for large projects]");
//#endif 


//#if -426815123 
System.err.println("\n\n");
//#endif 

} 

//#endif 


//#if -1081416421 
public static void main(String[] args)
    { 

//#if 954974047 
try //1
{ 

//#if -422556238 
LOG.info("ArgoUML Started.");
//#endif 


//#if -2053911190 
SimpleTimer st = new SimpleTimer();
//#endif 


//#if 1129570443 
st.mark("begin");
//#endif 


//#if -1813718677 
initPreinitialize();
//#endif 


//#if 581043390 
st.mark("arguments");
//#endif 


//#if -1236714089 
parseCommandLine(args);
//#endif 


//#if 1740836787 
AwtExceptionHandler.registerExceptionHandler();
//#endif 


//#if -695892335 
st.mark("create splash");
//#endif 


//#if 1326787109 
SplashScreen splash = null;
//#endif 


//#if -826561544 
if(!batch)//1
{ 

//#if 1839288890 
st.mark("initialize laf");
//#endif 


//#if -1135465835 
LookAndFeelMgr.getInstance().initializeLookAndFeel();
//#endif 


//#if 419876193 
if(theTheme != null)//1
{ 

//#if 1288497924 
LookAndFeelMgr.getInstance().setCurrentTheme(theTheme);
//#endif 

} 

//#endif 


//#if -2041355880 
if(doSplash)//1
{ 

//#if -467203233 
splash = initializeSplash();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -211071048 
ProjectBrowser pb = initializeSubsystems(st, splash);
//#endif 


//#if -1642844085 
st.mark("perform commands");
//#endif 


//#if -1735840341 
if(batch)//1
{ 

//#if -1220746698 
performCommandsInternal(commands);
//#endif 


//#if 658397177 
commands = null;
//#endif 


//#if 1479980220 
System.out.println("Exiting because we are running in batch.");
//#endif 


//#if 262227188 
new ActionExit().doCommand(null);
//#endif 


//#if -371489711 
return;
//#endif 

} 

//#endif 


//#if 686893960 
if(reloadRecent && projectName == null)//1
{ 

//#if -1268451322 
projectName = getMostRecentProject();
//#endif 

} 

//#endif 


//#if -594046928 
URL urlToOpen = null;
//#endif 


//#if -1291394952 
if(projectName != null)//1
{ 

//#if -1643947245 
projectName =
                    PersistenceManager.getInstance().fixExtension(projectName);
//#endif 


//#if -1399761181 
urlToOpen = projectUrl(projectName, urlToOpen);
//#endif 

} 

//#endif 


//#if -909393965 
openProject(st, splash, pb, urlToOpen);
//#endif 


//#if 563701437 
st.mark("perspectives");
//#endif 


//#if 453980009 
if(splash != null)//1
{ 

//#if -503564573 
splash.getStatusBar().showProgress(75);
//#endif 

} 

//#endif 


//#if -1536438566 
st.mark("open window");
//#endif 


//#if 1151931664 
updateProgress(splash, 95, "statusmsg.bar.open-project-browser");
//#endif 


//#if -2134460696 
ArgoFrame.getInstance().setVisible(true);
//#endif 


//#if -897677547 
st.mark("close splash");
//#endif 


//#if -333490520 
if(splash != null)//2
{ 

//#if -451391301 
splash.setVisible(false);
//#endif 


//#if 752840057 
splash.dispose();
//#endif 


//#if 286757255 
splash = null;
//#endif 

} 

//#endif 


//#if 236113005 
performCommands(commands);
//#endif 


//#if -2064203469 
commands = null;
//#endif 


//#if 1622424279 
st.mark("start critics");
//#endif 


//#if -236097204 
Runnable startCritics = new StartCritics();
//#endif 


//#if -1310817413 
Main.addPostLoadAction(startCritics);
//#endif 


//#if -1206161657 
st.mark("start loading modules");
//#endif 


//#if 1059252396 
Runnable moduleLoader = new LoadModules();
//#endif 


//#if 1408367837 
Main.addPostLoadAction(moduleLoader);
//#endif 


//#if -2097017728 
PostLoad pl = new PostLoad(postLoadActions);
//#endif 


//#if 24226969 
Thread postLoadThead = new Thread(pl);
//#endif 


//#if 1917530764 
postLoadThead.start();
//#endif 


//#if 151155118 
LOG.info("");
//#endif 


//#if -1564534361 
LOG.info("profile of load time ############");
//#endif 


//#if -108068999 
for (Enumeration i = st.result(); i.hasMoreElements();) //1
{ 

//#if 451080645 
LOG.info(i.nextElement());
//#endif 

} 

//#endif 


//#if -941159881 
LOG.info("#################################");
//#endif 


//#if 1936440804 
LOG.info("");
//#endif 


//#if -94489268 
st = null;
//#endif 


//#if 1153364157 
ArgoFrame.getInstance().setCursor(
                Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
//#endif 


//#if 1649806941 
ToolTipManager.sharedInstance().setDismissDelay(50000000);
//#endif 

} 

//#if -1729725154 
catch (Throwable t) //1
{ 

//#if -1484215663 
System.out.println("Fatal error on startup.  "
                               + "ArgoUML failed to start.");
//#endif 


//#if -1168137079 
t.printStackTrace();
//#endif 


//#if 817006489 
System.exit(1);
//#endif 


//#if -1493867307 
try //1
{ 

//#if 1323696427 
LOG.fatal("Fatal error on startup.  ArgoUML failed to start",
                          t);
//#endif 

} 
finally { 

//#if 1973778740 
System.out.println("Fatal error on startup.  "
                                   + "ArgoUML failed to start.");
//#endif 


//#if 978843718 
t.printStackTrace();
//#endif 


//#if -509996612 
System.exit(1);
//#endif 

} 

//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -429272532 
public static void performCommands(List<String> list)
    { 

//#if -1555287062 
performCommandsInternal(list);
//#endif 

} 

//#endif 


//#if 891558173 
private static ProjectBrowser initializeSubsystems(SimpleTimer st,
            SplashScreen splash)
    { 

//#if 1920654577 
ProjectBrowser pb = null;
//#endif 


//#if -1127445181 
st.mark("initialize model subsystem");
//#endif 


//#if 1661326362 
initModel();
//#endif 


//#if 967279010 
updateProgress(splash, 5, "statusmsg.bar.model-subsystem");
//#endif 


//#if 2070697384 
st.mark("initialize the profile subsystem");
//#endif 


//#if 428997338 
new InitProfileSubsystem().init();
//#endif 


//#if 764691268 
st.mark("initialize gui");
//#endif 


//#if -124739992 
pb = initializeGUI(splash);
//#endif 


//#if -887087995 
st.mark("initialize subsystems");
//#endif 


//#if -669341237 
SubsystemUtility.initSubsystem(new InitUiCmdSubsystem());
//#endif 


//#if -712195112 
SubsystemUtility.initSubsystem(new InitNotationUI());
//#endif 


//#if 717439876 
SubsystemUtility.initSubsystem(new InitNotation());
//#endif 


//#if 490206582 
SubsystemUtility.initSubsystem(new InitNotationUml());
//#endif 


//#if -1400750010 
SubsystemUtility.initSubsystem(new InitNotationJava());
//#endif 


//#if -1792133905 
SubsystemUtility.initSubsystem(new InitDiagramAppearanceUI());
//#endif 


//#if 920324424 
SubsystemUtility.initSubsystem(new InitActivityDiagram());
//#endif 


//#if 276965840 
SubsystemUtility.initSubsystem(new InitCollaborationDiagram());
//#endif 


//#if 1199969170 
SubsystemUtility.initSubsystem(new InitDeploymentDiagram());
//#endif 


//#if -671022762 
SubsystemUtility.initSubsystem(new InitSequenceDiagram());
//#endif 


//#if -1327581436 
SubsystemUtility.initSubsystem(new InitStateDiagram());
//#endif 


//#if 1176079293 
SubsystemUtility.initSubsystem(new InitClassDiagram());
//#endif 


//#if -1299791170 
SubsystemUtility.initSubsystem(new InitUseCaseDiagram());
//#endif 


//#if 2051865644 
SubsystemUtility.initSubsystem(new InitUmlUI());
//#endif 


//#if 199139038 
SubsystemUtility.initSubsystem(new InitCheckListUI());
//#endif 


//#if -1972527246 
SubsystemUtility.initSubsystem(new InitCognitiveUI());
//#endif 


//#if -877675528 
st.mark("initialize modules");
//#endif 


//#if -1002097887 
SubsystemUtility.initSubsystem(new InitModuleLoader());
//#endif 


//#if 118707360 
return pb;
//#endif 

} 

//#endif 


//#if -1148898821 
private static void performCommandsInternal(List<String> list)
    { 

//#if -1101416767 
for (String commandString : list) //1
{ 

//#if 786724097 
int pos = commandString.indexOf('=');
//#endif 


//#if 599924733 
String commandName;
//#endif 


//#if 1960477579 
String commandArgument;
//#endif 


//#if -653644324 
if(pos == -1)//1
{ 

//#if 136153493 
commandName = commandString;
//#endif 


//#if -544314768 
commandArgument = null;
//#endif 

} 
else
{ 

//#if 741734821 
commandName = commandString.substring(0, pos);
//#endif 


//#if -654699975 
commandArgument = commandString.substring(pos + 1);
//#endif 

} 

//#endif 


//#if -1115386071 
Class c;
//#endif 


//#if 1095942141 
try //1
{ 

//#if -1665076164 
c = Class.forName(commandName);
//#endif 

} 

//#if 682209222 
catch (ClassNotFoundException e) //1
{ 

//#if 1130828907 
System.out.println("Cannot find the command: " + commandName);
//#endif 


//#if 2031841550 
continue;
//#endif 

} 

//#endif 


//#endif 


//#if 780426048 
Object o = null;
//#endif 


//#if -1128985196 
try //2
{ 

//#if 1602691133 
o = c.newInstance();
//#endif 

} 

//#if 1073024339 
catch (InstantiationException e) //1
{ 

//#if 1019859161 
System.out.println(commandName
                                   + " could not be instantiated - skipping"
                                   + " (InstantiationException)");
//#endif 


//#if 341209847 
continue;
//#endif 

} 

//#endif 


//#if -1078677056 
catch (IllegalAccessException e) //1
{ 

//#if 1136957931 
System.out.println(commandName
                                   + " could not be instantiated - skipping"
                                   + " (IllegalAccessException)");
//#endif 


//#if 2121506710 
continue;
//#endif 

} 

//#endif 


//#endif 


//#if -1579817483 
if(o == null || !(o instanceof CommandLineInterface))//1
{ 

//#if 169775660 
System.out.println(commandName
                                   + " is not a command - skipping.");
//#endif 


//#if 463956942 
continue;
//#endif 

} 

//#endif 


//#if 90708768 
CommandLineInterface clio = (CommandLineInterface) o;
//#endif 


//#if 679922123 
System.out.println("Performing command "
                               + commandName + "( "
                               + (commandArgument == null
                                  ? "" : commandArgument) + " )");
//#endif 


//#if 996102706 
boolean result = clio.doCommand(commandArgument);
//#endif 


//#if -1834800958 
if(!result)//1
{ 

//#if -952163375 
System.out.println("There was an error executing "
                                   + "the command "
                                   + commandName + "( "
                                   + (commandArgument == null
                                      ? "" : commandArgument) + " )");
//#endif 


//#if 336978221 
System.out.println("Aborting the rest of the commands.");
//#endif 


//#if -79960163 
return;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 59091108 
private static URL projectUrl(final String theProjectName, URL urlToOpen)
    { 

//#if 983777028 
File projectFile = new File(theProjectName);
//#endif 


//#if -380659293 
if(!projectFile.exists())//1
{ 

//#if 1258877454 
System.err.println("Project file '" + projectFile
                               + "' does not exist.");
//#endif 

} 
else
{ 

//#if -251986852 
try //1
{ 

//#if -1267615134 
urlToOpen = Util.fileToURL(projectFile);
//#endif 

} 

//#if 1052152810 
catch (Exception e) //1
{ 

//#if -1097415644 
LOG.error("Exception opening project in main()", e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1866547450 
return urlToOpen;
//#endif 

} 

//#endif 


//#if -2147462753 
private static void checkHostsFile()
    { 

//#if 434902127 
try //1
{ 

//#if 1439677136 
InetAddress.getLocalHost();
//#endif 

} 

//#if -1599722061 
catch (UnknownHostException e) //1
{ 

//#if -603661198 
System.err.println("ERROR: unable to get localhost information.");
//#endif 


//#if -938577663 
e.printStackTrace(System.err);
//#endif 


//#if 1471587770 
System.err.println("On Unix systems this usually indicates that"
                               + "your /etc/hosts file is incorrectly setup.");
//#endif 


//#if -333422487 
System.err.println("Stopping execution of ArgoUML.");
//#endif 


//#if 1600508533 
System.exit(0);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1563941288 
private static ProjectBrowser initializeGUI(SplashScreen splash)
    { 

//#if 262360470 
JPanel todoPanel;
//#endif 


//#if 1744534558 
todoPanel = new JPanel();
//#endif 


//#if -1944683119 
todoPanel = new ToDoPane(splash);
//#endif 


//#if -1406385132 
ProjectBrowser pb = ProjectBrowser.makeInstance(splash, true,todoPanel);
//#endif 


//#if 603927293 
JOptionPane.setRootFrame(pb);
//#endif 


//#if -782098542 
pb.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
//#endif 


//#if 1885407457 
Rectangle scrSize = GraphicsEnvironment.getLocalGraphicsEnvironment()
                            .getMaximumWindowBounds();
//#endif 


//#if 1966756723 
int configFrameWidth =
            Configuration.getInteger(Argo.KEY_SCREEN_WIDTH, scrSize.width);
//#endif 


//#if 300207778 
int w = Math.min(configFrameWidth, scrSize.width);
//#endif 


//#if -1457508755 
if(w == 0)//1
{ 

//#if 1383183492 
w = 600;
//#endif 

} 

//#endif 


//#if -458095330 
int configFrameHeight =
            Configuration.getInteger(Argo.KEY_SCREEN_HEIGHT, scrSize.height);
//#endif 


//#if 1637240117 
int h = Math.min(configFrameHeight, scrSize.height);
//#endif 


//#if -1829860004 
if(h == 0)//1
{ 

//#if -793885805 
h = 400;
//#endif 

} 

//#endif 


//#if -1431549305 
int x = Configuration.getInteger(Argo.KEY_SCREEN_LEFT_X, 0);
//#endif 


//#if -287428717 
int y = Configuration.getInteger(Argo.KEY_SCREEN_TOP_Y, 0);
//#endif 


//#if 898724137 
pb.setLocation(x, y);
//#endif 


//#if -816002141 
pb.setSize(w, h);
//#endif 


//#if 1882745933 
pb.setExtendedState(Configuration.getBoolean(
                                Argo.KEY_SCREEN_MAXIMIZED, false)
                            ? Frame.MAXIMIZED_BOTH : Frame.NORMAL);
//#endif 


//#if 1406316927 
UIManager.put("Button.focusInputMap", new UIDefaults.LazyInputMap(
                          new Object[] {
                              "ENTER", "pressed",
                              "released ENTER", "released",
                              "SPACE", "pressed",
                              "released SPACE", "released"
                          })
                     );
//#endif 


//#if -1240495462 
return pb;
//#endif 

} 

//#endif 


//#if 1822653240 
public static void initVersion()
    { 

//#if -284070471 
ArgoVersion.init();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

