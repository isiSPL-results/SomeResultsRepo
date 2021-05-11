package org.argouml.application;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ToolTipManager;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import org.apache.log4j.PropertyConfigurator;
import org.argouml.application.api.Argo;
import org.argouml.application.api.CommandLineInterface;
import org.argouml.application.security.ArgoAwtExceptionHandler;
import org.argouml.configuration.Configuration;
import org.argouml.i18n.Translator;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.Model;
import org.argouml.moduleloader.InitModuleLoader;
import org.argouml.moduleloader.ModuleLoader2;
import org.argouml.notation.InitNotation;
import org.argouml.notation.providers.java.InitNotationJava;
import org.argouml.notation.providers.uml.InitNotationUml;
import org.argouml.notation.ui.InitNotationUI;
import org.argouml.persistence.PersistenceManager;
import org.argouml.profile.init.InitProfileSubsystem;
import org.argouml.ui.LookAndFeelMgr;
import org.argouml.ui.ProjectBrowser;
import org.argouml.ui.SplashScreen;
import org.argouml.ui.cmd.ActionExit;
import org.argouml.ui.cmd.InitUiCmdSubsystem;
import org.argouml.ui.cmd.PrintManager;
import org.argouml.uml.diagram.static_structure.ui.InitClassDiagram;
import org.argouml.uml.diagram.ui.InitDiagramAppearanceUI;
import org.argouml.uml.ui.InitUmlUI;
import org.argouml.util.ArgoFrame;
import org.argouml.util.JavaRuntimeUtility;
import org.argouml.util.logging.AwtExceptionHandler;
import org.argouml.util.logging.SimpleTimer;
import org.tigris.gef.util.Util;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.argouml.cognitive.AbstractCognitiveTranslator;
import org.argouml.cognitive.Designer;
import org.argouml.cognitive.checklist.ui.InitCheckListUI;
import org.argouml.cognitive.ui.InitCognitiveUI;
import org.argouml.cognitive.ui.ToDoPane;
import org.argouml.uml.diagram.collaboration.ui.InitCollaborationDiagram;
import org.argouml.uml.diagram.deployment.ui.InitDeploymentDiagram;
import org.argouml.uml.diagram.state.ui.InitStateDiagram;
import org.argouml.uml.diagram.use_case.ui.InitUseCaseDiagram;
import org.argouml.uml.diagram.activity.ui.InitActivityDiagram;
class PostLoad implements Runnable
  { 
private List<Runnable> postLoadActions;
private static final Logger LOG = Logger.getLogger(PostLoad.class);
public PostLoad(List<Runnable> actions)
    { 
postLoadActions = actions;
} 
public void run()
    { 
try//1
{ 
Thread.sleep(1000);
} 
catch (Exception ex) //1
{ 
LOG.error("post load no sleep", ex);
} 
for (Runnable r : postLoadActions) //1
{ 
r.run();
try//1
{ 
Thread.sleep(100);
} 
catch (Exception ex) //1
{ 
LOG.error("post load no sleep2", ex);
} 
} 
} 

 } 
class LoadModules implements Runnable
  { 
private static final String[] OPTIONAL_INTERNAL_MODULES = {
        "org.argouml.dev.DeveloperModule",
    };
private static final Logger LOG = Logger.getLogger(LoadModules.class);
private void huntForInternalModules()
    { 
for (String module : OPTIONAL_INTERNAL_MODULES) //1
{ 
try//1
{ 
ModuleLoader2.addClass(module);
} 
catch (ClassNotFoundException e) //1
{ 
LOG.debug("Module " + module + " not found");
} 
} 
} 
public void run()
    { 
huntForInternalModules();
LOG.info("Module loading done");
} 

 } 
public class Main  { 
private static final String DEFAULT_MODEL_IMPLEMENTATION =
        "org.argouml.model.mdr.MDRModelImplementation";
private static List<Runnable> postLoadActions = new ArrayList<Runnable>();
private static boolean doSplash = true;
private static boolean reloadRecent = false;
private static boolean batch = false;
private static List<String> commands;
private static String projectName = null;
private static String theTheme;
private static final Logger LOG;
public static final String DEFAULT_LOGGING_CONFIGURATION =
        "org/argouml/resource/default.lcf";
static
    {
        File argoDir = new File(System.getProperty("user.home")
                                + File.separator + ".argouml");
        if (!argoDir.exists()) {
            argoDir.mkdir();
        }
    }
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
private static void setSystemProperties()
    { 
System.setProperty("gef.imageLocation", "/org/argouml/Images");
System.setProperty("apple.laf.useScreenMenuBar", "true");
System.setProperty(
            "com.apple.mrj.application.apple.menu.about.name",
            "ArgoUML");
} 
private static SplashScreen initializeSplash()
    { 
SplashScreen splash = new SplashScreen();
splash.setVisible(true);
if(!EventQueue.isDispatchThread()
                && Runtime.getRuntime().availableProcessors() == 1)//1
{ 
synchronized (splash) //1
{ 
while (!splash.isPaintCalled()) //1
{ 
try//1
{ 
splash.wait();
} 
catch (InterruptedException e) //1
{ 
} 
} 
} 
} 
return splash;
} 
private static void checkJVMVersion()
    { 
if(!JavaRuntimeUtility.isJreSupported())//1
{ 
System.err.println("You are using Java "
                               + JavaRuntimeUtility.getJreVersion()
                               + ", Please use Java 5 (aka 1.5) or later"
                               + " with ArgoUML");
System.exit(0);
} 
} 
private static void initModel()
    { 
String className = System.getProperty(
                               "argouml.model.implementation",
                               DEFAULT_MODEL_IMPLEMENTATION);
Throwable ret = Model.initialise(className);
if(ret != null)//1
{ 
LOG.fatal("Model component not correctly initialized.", ret);
System.err.println(className
                               + " is not a working Model implementation.");
System.exit(1);
} 
} 
private static void openProject(SimpleTimer st, SplashScreen splash,
                                    ProjectBrowser pb, URL urlToOpen)
    { 
if(splash != null)//1
{ 
splash.getStatusBar().showProgress(40);
} 
st.mark("open project");
Designer.disableCritiquing();
Designer.clearCritiquing();
boolean projectLoaded = false;
if(urlToOpen != null)//1
{ 
if(splash != null)//1
{ 
Object[] msgArgs = {projectName};
splash.getStatusBar().showStatus(
                    Translator.messageFormat(
                        "statusmsg.bar.readingproject",
                        msgArgs));
} 
String filename = urlToOpen.getFile();
File file = new File(filename);
System.err.println("The url of the file to open is "
                               + urlToOpen);
System.err.println("The filename is " + filename);
System.err.println("The file is " + file);
System.err.println("File.exists = " + file.exists());
projectLoaded = pb.loadProject(file, true, null);
} 
else
{ 
if(splash != null)//1
{ 
splash.getStatusBar().showStatus(
                    Translator.localize(
                        "statusmsg.bar.defaultproject"));
} 
} 
if(!projectLoaded)//1
{ 
ProjectManager.getManager().setCurrentProject(
                ProjectManager.getManager().getCurrentProject());
ProjectManager.getManager().setSaveEnabled(false);
} 
st.mark("set project");
Designer.enableCritiquing();
} 
public static void addPostLoadAction(Runnable r)
    { 
postLoadActions.add(r);
} 
private static void updateProgress(SplashScreen splash, int percent,
                                       String message)
    { 
if(splash != null)//1
{ 
splash.getStatusBar().showStatus(Translator.localize(message));
splash.getStatusBar().showProgress(percent);
} 
} 
private static String getMostRecentProject()
    { 
String s = Configuration.getString(
                       Argo.KEY_MOST_RECENT_PROJECT_FILE, "");
if(!("".equals(s)))//1
{ 
File file = new File(s);
if(file.exists())//1
{ 
LOG.info("Re-opening project " + s);
return s;
} 
else
{ 
LOG.warn("Cannot re-open " + s
                         + " because it does not exist");
} 
} 
return null;
} 
private static void parseCommandLine(String[] args)
    { 
doSplash = Configuration.getBoolean(Argo.KEY_SPLASH, true);
reloadRecent = Configuration.getBoolean(
                           Argo.KEY_RELOAD_RECENT_PROJECT, false);
commands = new ArrayList<String>();
theTheme = null;
for (int i = 0; i < args.length; i++) //1
{ 
if(args[i].startsWith("-"))//1
{ 
String themeName = LookAndFeelMgr.getInstance()
                                   .getThemeClassNameFromArg(args[i]);
if(themeName != null)//1
{ 
theTheme = themeName;
} 
else
if(args[i].equalsIgnoreCase("-help")
                    || args[i].equalsIgnoreCase("-h")
                    || args[i].equalsIgnoreCase("--help")
                    || args[i].equalsIgnoreCase("/?"))//1
{ 
printUsage();
System.exit(0);
} 
else
if(args[i].equalsIgnoreCase("-nosplash"))//1
{ 
doSplash = false;
} 
else
if(args[i].equalsIgnoreCase("-norecentfile"))//1
{ 
reloadRecent = false;
} 
else
if(args[i].equalsIgnoreCase("-command")
                           && i + 1 < args.length)//1
{ 
commands.add(args[i + 1]);
i++;
} 
else
if(args[i].equalsIgnoreCase("-locale")
                           && i + 1 < args.length)//1
{ 
Translator.setLocale(args[i + 1]);
i++;
} 
else
if(args[i].equalsIgnoreCase("-batch"))//1
{ 
batch = true;
} 
else
if(args[i].equalsIgnoreCase("-open")
                           && i + 1 < args.length)//1
{ 
projectName = args[++i];
} 
else
if(args[i].equalsIgnoreCase("-print")
                           && i + 1 < args.length)//1
{ 
String projectToBePrinted =
                        PersistenceManager.getInstance().fixExtension(
                            args[++i]);
URL urlToBePrinted = projectUrl(projectToBePrinted,
                                                    null);
ProjectBrowser.getInstance().loadProject(
                        new File(urlToBePrinted.getFile()), true, null);
PrintManager.getInstance().print();
System.exit(0);
} 
else
{ 
System.err
                    .println("Ignoring unknown/incomplete option '"
                             + args[i] + "'");
} 
} 
else
{ 
if(projectName == null)//1
{ 
System.out.println(
                        "Setting projectName to '" + args[i] + "'");
projectName = args[i];
} 
} 
} 
} 
private static void initPreinitialize()
    { 
checkJVMVersion();
checkHostsFile();
Configuration.load();
String directory = Argo.getDirectory();
org.tigris.gef.base.Globals.setLastDirectory(directory);
initVersion();
initTranslator();
org.argouml.util.Tools.logVersionInfo();
setSystemProperties();
} 
private static void initTranslator()
    { 
Translator.init(Configuration.getString(Argo.KEY_LOCALE));
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
} 
private static void printUsage()
    { 
System.err.println("Usage: [options] [project-file]");
System.err.println("Options include: ");
System.err.println("  -help           display this information");
LookAndFeelMgr.getInstance().printThemeArgs();
System.err.println("  -nosplash       don't display logo at startup");
System.err.println("  -norecentfile   don't reload last saved file");
System.err.println("  -command <arg>  command to perform on startup");
System.err.println("  -batch          don't start GUI");
System.err.println("  -locale <arg>   set the locale (e.g. 'en_GB')");
System.err.println("");
System.err.println("You can also set java settings which influence "
                           + "the behaviour of ArgoUML:");
System.err.println("  -Xms250M -Xmx500M  [makes ArgoUML reserve "
                           + "more memory for large projects]");
System.err.println("\n\n");
} 
public static void main(String[] args)
    { 
try//1
{ 
LOG.info("ArgoUML Started.");
SimpleTimer st = new SimpleTimer();
st.mark("begin");
initPreinitialize();
st.mark("arguments");
parseCommandLine(args);
AwtExceptionHandler.registerExceptionHandler();
st.mark("create splash");
SplashScreen splash = null;
if(!batch)//1
{ 
st.mark("initialize laf");
LookAndFeelMgr.getInstance().initializeLookAndFeel();
if(theTheme != null)//1
{ 
LookAndFeelMgr.getInstance().setCurrentTheme(theTheme);
} 
if(doSplash)//1
{ 
splash = initializeSplash();
} 
} 
ProjectBrowser pb = initializeSubsystems(st, splash);
st.mark("perform commands");
if(batch)//1
{ 
performCommandsInternal(commands);
commands = null;
System.out.println("Exiting because we are running in batch.");
new ActionExit().doCommand(null);
return;
} 
if(reloadRecent && projectName == null)//1
{ 
projectName = getMostRecentProject();
} 
URL urlToOpen = null;
if(projectName != null)//1
{ 
projectName =
                    PersistenceManager.getInstance().fixExtension(projectName);
urlToOpen = projectUrl(projectName, urlToOpen);
} 
openProject(st, splash, pb, urlToOpen);
st.mark("perspectives");
if(splash != null)//1
{ 
splash.getStatusBar().showProgress(75);
} 
st.mark("open window");
updateProgress(splash, 95, "statusmsg.bar.open-project-browser");
ArgoFrame.getInstance().setVisible(true);
st.mark("close splash");
if(splash != null)//2
{ 
splash.setVisible(false);
splash.dispose();
splash = null;
} 
performCommands(commands);
commands = null;
st.mark("start critics");
Runnable startCritics = new StartCritics();
Main.addPostLoadAction(startCritics);
st.mark("start loading modules");
Runnable moduleLoader = new LoadModules();
Main.addPostLoadAction(moduleLoader);
PostLoad pl = new PostLoad(postLoadActions);
Thread postLoadThead = new Thread(pl);
postLoadThead.start();
LOG.info("");
LOG.info("profile of load time ############");
for (Enumeration i = st.result(); i.hasMoreElements();) //1
{ 
LOG.info(i.nextElement());
} 
LOG.info("#################################");
LOG.info("");
st = null;
ArgoFrame.getInstance().setCursor(
                Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
ToolTipManager.sharedInstance().setDismissDelay(50000000);
} 
catch (Throwable t) //1
{ 
try//1
{ 
LOG.fatal("Fatal error on startup.  ArgoUML failed to start",
                          t);
} 
finally { 
System.out.println("Fatal error on startup.  "
                                   + "ArgoUML failed to start.");
t.printStackTrace();
System.exit(1);
} 
} 
} 
public static void performCommands(List<String> list)
    { 
performCommandsInternal(list);
} 
private static ProjectBrowser initializeSubsystems(SimpleTimer st,
            SplashScreen splash)
    { 
ProjectBrowser pb = null;
st.mark("initialize model subsystem");
initModel();
updateProgress(splash, 5, "statusmsg.bar.model-subsystem");
st.mark("initialize the profile subsystem");
new InitProfileSubsystem().init();
st.mark("initialize gui");
pb = initializeGUI(splash);
st.mark("initialize subsystems");
SubsystemUtility.initSubsystem(new InitUiCmdSubsystem());
SubsystemUtility.initSubsystem(new InitNotationUI());
SubsystemUtility.initSubsystem(new InitNotation());
SubsystemUtility.initSubsystem(new InitNotationUml());
SubsystemUtility.initSubsystem(new InitNotationJava());
SubsystemUtility.initSubsystem(new InitDiagramAppearanceUI());
SubsystemUtility.initSubsystem(new InitActivityDiagram());
SubsystemUtility.initSubsystem(new InitCollaborationDiagram());
SubsystemUtility.initSubsystem(new InitDeploymentDiagram());
SubsystemUtility.initSubsystem(new InitStateDiagram());
SubsystemUtility.initSubsystem(new InitClassDiagram());
SubsystemUtility.initSubsystem(new InitUseCaseDiagram());
SubsystemUtility.initSubsystem(new InitUmlUI());
SubsystemUtility.initSubsystem(new InitCheckListUI());
SubsystemUtility.initSubsystem(new InitCognitiveUI());
st.mark("initialize modules");
SubsystemUtility.initSubsystem(new InitModuleLoader());
return pb;
} 
private static void performCommandsInternal(List<String> list)
    { 
for (String commandString : list) //1
{ 
int pos = commandString.indexOf('=');
String commandName;
String commandArgument;
if(pos == -1)//1
{ 
commandName = commandString;
commandArgument = null;
} 
else
{ 
commandName = commandString.substring(0, pos);
commandArgument = commandString.substring(pos + 1);
} 
Class c;
try//1
{ 
c = Class.forName(commandName);
} 
catch (ClassNotFoundException e) //1
{ 
System.out.println("Cannot find the command: " + commandName);
continue;
} 
Object o = null;
try//2
{ 
o = c.newInstance();
} 
catch (InstantiationException e) //1
{ 
System.out.println(commandName
                                   + " could not be instantiated - skipping"
                                   + " (InstantiationException)");
continue;
} 
catch (IllegalAccessException e) //1
{ 
System.out.println(commandName
                                   + " could not be instantiated - skipping"
                                   + " (IllegalAccessException)");
continue;
} 
if(o == null || !(o instanceof CommandLineInterface))//1
{ 
System.out.println(commandName
                                   + " is not a command - skipping.");
continue;
} 
CommandLineInterface clio = (CommandLineInterface) o;
System.out.println("Performing command "
                               + commandName + "( "
                               + (commandArgument == null
                                  ? "" : commandArgument) + " )");
boolean result = clio.doCommand(commandArgument);
if(!result)//1
{ 
System.out.println("There was an error executing "
                                   + "the command "
                                   + commandName + "( "
                                   + (commandArgument == null
                                      ? "" : commandArgument) + " )");
System.out.println("Aborting the rest of the commands.");
return;
} 
} 
} 
private static URL projectUrl(final String theProjectName, URL urlToOpen)
    { 
File projectFile = new File(theProjectName);
if(!projectFile.exists())//1
{ 
System.err.println("Project file '" + projectFile
                               + "' does not exist.");
} 
else
{ 
try//1
{ 
urlToOpen = Util.fileToURL(projectFile);
} 
catch (Exception e) //1
{ 
LOG.error("Exception opening project in main()", e);
} 
} 
return urlToOpen;
} 
private static void checkHostsFile()
    { 
try//1
{ 
InetAddress.getLocalHost();
} 
catch (UnknownHostException e) //1
{ 
System.err.println("ERROR: unable to get localhost information.");
e.printStackTrace(System.err);
System.err.println("On Unix systems this usually indicates that"
                               + "your /etc/hosts file is incorrectly setup.");
System.err.println("Stopping execution of ArgoUML.");
System.exit(0);
} 
} 
private static ProjectBrowser initializeGUI(SplashScreen splash)
    { 
JPanel todoPanel;
todoPanel = new ToDoPane(splash);
ProjectBrowser pb = ProjectBrowser.makeInstance(splash, true,todoPanel);
JOptionPane.setRootFrame(pb);
pb.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
Rectangle scrSize = GraphicsEnvironment.getLocalGraphicsEnvironment()
                            .getMaximumWindowBounds();
int configFrameWidth =
            Configuration.getInteger(Argo.KEY_SCREEN_WIDTH, scrSize.width);
int w = Math.min(configFrameWidth, scrSize.width);
if(w == 0)//1
{ 
w = 600;
} 
int configFrameHeight =
            Configuration.getInteger(Argo.KEY_SCREEN_HEIGHT, scrSize.height);
int h = Math.min(configFrameHeight, scrSize.height);
if(h == 0)//1
{ 
h = 400;
} 
int x = Configuration.getInteger(Argo.KEY_SCREEN_LEFT_X, 0);
int y = Configuration.getInteger(Argo.KEY_SCREEN_TOP_Y, 0);
pb.setLocation(x, y);
pb.setSize(w, h);
pb.setExtendedState(Configuration.getBoolean(
                                Argo.KEY_SCREEN_MAXIMIZED, false)
                            ? Frame.MAXIMIZED_BOTH : Frame.NORMAL);
UIManager.put("Button.focusInputMap", new UIDefaults.LazyInputMap(
                          new Object[] {
                              "ENTER", "pressed",
                              "released ENTER", "released",
                              "SPACE", "pressed",
                              "released SPACE", "released"
                          })
                     );
return pb;
} 
public static void initVersion()
    { 
ArgoVersion.init();
} 

 } 
