package org.argouml.ui;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.KeyboardFocusManager;
import java.awt.Window;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import org.argouml.application.api.AbstractArgoJPanel;
import org.argouml.application.api.Argo;
import org.argouml.application.events.ArgoEventPump;
import org.argouml.application.events.ArgoEventTypes;
import org.argouml.application.events.ArgoStatusEvent;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.configuration.Configuration;
import org.argouml.configuration.ConfigurationKey;
import org.argouml.i18n.Translator;
import org.argouml.kernel.Command;
import org.argouml.kernel.NonUndoableCommand;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.Model;
import org.argouml.model.XmiReferenceException;
import org.argouml.persistence.AbstractFilePersister;
import org.argouml.persistence.OpenException;
import org.argouml.persistence.PersistenceManager;
import org.argouml.persistence.ProjectFilePersister;
import org.argouml.persistence.ProjectFileView;
import org.argouml.persistence.UmlVersionException;
import org.argouml.persistence.VersionException;
import org.argouml.persistence.XmiFormatException;
import org.argouml.taskmgmt.ProgressMonitor;
import org.argouml.ui.cmd.GenericArgoMenuBar;
import org.argouml.ui.targetmanager.TargetEvent;
import org.argouml.ui.targetmanager.TargetListener;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.uml.diagram.DiagramUtils;
import org.argouml.uml.diagram.UMLMutableGraphSupport;
import org.argouml.uml.diagram.ui.ActionRemoveFromDiagram;
import org.argouml.uml.ui.ActionSaveProject;
import org.argouml.uml.ui.TabProps;
import org.argouml.util.ArgoFrame;
import org.argouml.util.JavaRuntimeUtility;
import org.argouml.util.ThreadUtils;
import org.tigris.gef.base.Editor;
import org.tigris.gef.base.Globals;
import org.tigris.gef.base.Layer;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.ui.IStatusBar;
import org.tigris.gef.util.Util;
import org.tigris.swidgets.BorderSplitPane;
import org.tigris.swidgets.Horizontal;
import org.tigris.swidgets.Orientation;
import org.tigris.swidgets.Vertical;
import org.tigris.toolbar.layouts.DockBorderLayout;
import org.argouml.cognitive.Designer;
public final class ProjectBrowser extends JFrame
 implements PropertyChangeListener
,TargetListener
  { 
public static final int DEFAULT_COMPONENTWIDTH = 400;
public static final int DEFAULT_COMPONENTHEIGHT = 350;
private static boolean isMainApplication;
private static ProjectBrowser theInstance;
private String appName = "ProjectBrowser";
private MultiEditorPane editorPane;
private DetailsPane northEastPane;
private DetailsPane northPane;
private DetailsPane northWestPane;
private DetailsPane eastPane;
private DetailsPane southEastPane;
private DetailsPane southPane;
private Map<Position, DetailsPane> detailsPanesByCompassPoint =
        new HashMap<Position, DetailsPane>();
private GenericArgoMenuBar menuBar;
private StatusBar statusBar = new ArgoStatusBar();
private Font defaultFont = new Font("Dialog", Font.PLAIN, 10);
private BorderSplitPane workAreaPane;
private NavigatorPane explorerPane;
private JPanel todoPane;
private TitleHandler titleHandler = new TitleHandler();
private AbstractAction saveAction;
private final ActionRemoveFromDiagram removeFromDiagram =
        new ActionRemoveFromDiagram(
        Translator.localize("action.remove-from-diagram"));
private static final long serialVersionUID = 6974246679451284917L;
static
    {
        assert Position.Center.toString().equals(BorderSplitPane.CENTER);
        assert Position.North.toString().equals(BorderSplitPane.NORTH);
        assert Position.NorthEast.toString().equals(BorderSplitPane.NORTHEAST);
        assert Position.South.toString().equals(BorderSplitPane.SOUTH);
    }
private void reportError(ProgressMonitor monitor, final String message,
                             boolean showUI, final Throwable ex)
    { 
if(showUI)//1
{ 
if(monitor != null)//1
{ 
monitor.notifyMessage(
                    Translator.localize("dialog.error.title"),
                    message,
                    ExceptionDialog.formatException(
                        message, ex, ex instanceof OpenException));
} 
else
{ 
SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        JDialog dialog =
                            new ExceptionDialog(
                            ArgoFrame.getInstance(),
                            Translator.localize("dialog.error.title"),
                            message,
                            ExceptionDialog.formatException(
                                message, ex,
                                ex instanceof OpenException));
                        dialog.setVisible(true);
                    }
                });
} 
} 
else
{ 
StringWriter sw = new StringWriter();
PrintWriter pw = new PrintWriter(sw);
ex.printStackTrace(pw);
String exception = sw.toString();
reportError(monitor, "Please report the error below to the ArgoUML"
                        + "development team at http://argouml.tigris.org.\n"
                        + message + "\n\n" + exception, showUI);
} 
} 
public boolean askConfirmationAndSave()
    { 
ProjectBrowser pb = ProjectBrowser.getInstance();
Project p = ProjectManager.getManager().getCurrentProject();
if(p != null && saveAction.isEnabled())//1
{ 
String t =
                MessageFormat.format(Translator.localize(
                                         "optionpane.open-project-save-changes-to"),
                                     new Object[] {p.getName()});
int response =
                JOptionPane.showConfirmDialog(pb, t, t,
                                              JOptionPane.YES_NO_CANCEL_OPTION);
if(response == JOptionPane.CANCEL_OPTION
                    || response == JOptionPane.CLOSED_OPTION)//1
{ 
return false;
} 
if(response == JOptionPane.YES_OPTION)//1
{ 
trySave(ProjectManager.getManager().getCurrentProject() != null
                        && ProjectManager.getManager().getCurrentProject()
                        .getURI() != null);
if(saveAction.isEnabled())//1
{ 
return false;
} 
} 
} 
return true;
} 
private void targetChanged(Object target)
    { 
if(target instanceof ArgoDiagram)//1
{ 
titleHandler.buildTitle(null, (ArgoDiagram) target);
} 
determineRemoveEnabled();
Project p = ProjectManager.getManager().getCurrentProject();
Object theCurrentNamespace = null;
target = TargetManager.getInstance().getTarget();
if(target instanceof ArgoDiagram)//2
{ 
theCurrentNamespace = ((ArgoDiagram) target).getNamespace();
} 
else
if(Model.getFacade().isANamespace(target))//1
{ 
theCurrentNamespace = target;
} 
else
if(Model.getFacade().isAModelElement(target))//1
{ 
theCurrentNamespace = Model.getFacade().getNamespace(target);
} 
else
{ 
theCurrentNamespace = p.getRoot();
} 
p.setCurrentNamespace(theCurrentNamespace);
if(target instanceof ArgoDiagram)//3
{ 
p.setActiveDiagram((ArgoDiagram) target);
} 
} 
@Override
    public JMenuBar getJMenuBar()
    { 
return menuBar;
} 
private int getSavedHeight(ConfigurationKey height)
    { 
return Configuration.getInteger(height, DEFAULT_COMPONENTHEIGHT);
} 
protected void createPanels(SplashScreen splash, JPanel leftBottomPane)
    { 
if(splash != null)//1
{ 
splash.getStatusBar().showStatus(
                Translator.localize("statusmsg.bar.making-project-browser"));
splash.getStatusBar().showProgress(10);
splash.setVisible(true);
} 
editorPane = new MultiEditorPane();
if(splash != null)//2
{ 
splash.getStatusBar().showStatus(
                Translator.localize(
                    "statusmsg.bar.making-project-browser-explorer"));
splash.getStatusBar().incProgress(5);
} 
explorerPane = new NavigatorPane(splash);
workAreaPane = new BorderSplitPane();
if(splash != null)//3
{ 
splash.getStatusBar().showStatus(Translator.localize(
                                                 "statusmsg.bar.making-project-browser-to-do-pane"));
splash.getStatusBar().incProgress(5);
} 
todoPane = leftBottomPane;
createDetailsPanes();
restorePanelSizes();
} 
private ProjectBrowser()
    { 
this("ArgoUML", null, true, null);
} 
public void clearDialogs()
    { 
Window[] windows = getOwnedWindows();
for (int i = 0; i < windows.length; i++) //1
{ 
if(!(windows[i] instanceof FindDialog))//1
{ 
windows[i].dispose();
} 
} 
FindDialog.getInstance().reset();
} 
private void updateStatus(String status)
    { 
ArgoEventPump.fireEvent(new ArgoStatusEvent(ArgoEventTypes.STATUS_TEXT,
                                this, status));
} 
@Override
    public void setVisible(boolean b)
    { 
super.setVisible(b);
if(b)//1
{ 
Globals.setStatusBar(getStatusBar());
} 
} 
private void determineRemoveEnabled()
    { 
Editor editor = Globals.curEditor();
Collection figs = editor.getSelectionManager().getFigs();
boolean removeEnabled = !figs.isEmpty();
GraphModel gm = editor.getGraphModel();
if(gm instanceof UMLMutableGraphSupport)//1
{ 
removeEnabled =
                ((UMLMutableGraphSupport) gm).isRemoveFromDiagramAllowed(figs);
} 
removeFromDiagram.setEnabled(removeEnabled);
} 
public AbstractAction getSaveAction()
    { 
return saveAction;
} 
public void targetSet(TargetEvent e)
    { 
targetChanged(e.getNewTarget());
} 
private void restorePanelSizes()
    { 
if(northPane != null)//1
{ 
northPane.setPreferredSize(new Dimension(
                                           0, getSavedHeight(Argo.KEY_SCREEN_NORTH_HEIGHT)));
} 
if(southPane != null)//1
{ 
southPane.setPreferredSize(new Dimension(
                                           0, getSavedHeight(Argo.KEY_SCREEN_SOUTH_HEIGHT)));
} 
if(eastPane != null)//1
{ 
eastPane.setPreferredSize(new Dimension(
                                          getSavedWidth(Argo.KEY_SCREEN_EAST_WIDTH), 0));
} 
if(explorerPane != null)//1
{ 
explorerPane.setPreferredSize(new Dimension(
                                              getSavedWidth(Argo.KEY_SCREEN_WEST_WIDTH), 0));
} 
if(northWestPane != null)//1
{ 
northWestPane.setPreferredSize(getSavedDimensions(
                                               Argo.KEY_SCREEN_NORTHWEST_WIDTH,
                                               Argo.KEY_SCREEN_NORTH_HEIGHT));
} 
if(todoPane != null)//1
{ 
todoPane.setPreferredSize(getSavedDimensions(
                                          Argo.KEY_SCREEN_SOUTHWEST_WIDTH,
                                          Argo.KEY_SCREEN_SOUTH_HEIGHT));
} 
if(northEastPane != null)//1
{ 
northEastPane.setPreferredSize(getSavedDimensions(
                                               Argo.KEY_SCREEN_NORTHEAST_WIDTH,
                                               Argo.KEY_SCREEN_NORTH_HEIGHT));
} 
if(southEastPane != null)//1
{ 
southEastPane.setPreferredSize(getSavedDimensions(
                                               Argo.KEY_SCREEN_SOUTHEAST_WIDTH,
                                               Argo.KEY_SCREEN_SOUTH_HEIGHT));
} 
} 
public AbstractAction getRemoveFromDiagramAction()
    { 
return removeFromDiagram;
} 
public MultiEditorPane getEditorPane()
    { 
return editorPane;
} 
public Font getDefaultFont()
    { 
return defaultFont;
} 
public static synchronized ProjectBrowser getInstance()
    { 
assert theInstance != null;
return theInstance;
} 
public void trySave(boolean overwrite)
    { 
this.trySave(overwrite, false);
} 
public NavigatorPane getExplorerPane()
    { 
return explorerPane;
} 
public boolean trySave(boolean overwrite,
                           File file,
                           ProgressMonitor pmw)
    { 
Project project = ProjectManager.getManager().getCurrentProject();
PersistenceManager pm = PersistenceManager.getInstance();
ProjectFilePersister persister = null;
try//1
{ 
if(!PersistenceManager.getInstance().confirmOverwrite(
                        ArgoFrame.getInstance(), overwrite, file))//1
{ 
return false;
} 
if(this.isFileReadonly(file))//1
{ 
JOptionPane.showMessageDialog(this,
                                              Translator.localize(
                                                  "optionpane.save-project-cant-write"),
                                              Translator.localize(
                                                  "optionpane.save-project-cant-write-title"),
                                              JOptionPane.INFORMATION_MESSAGE);
return false;
} 
String sStatus =
                MessageFormat.format(Translator.localize(
                                         "statusmsg.bar.save-project-status-writing"),
                                     new Object[] {file});
updateStatus (sStatus);
persister = pm.getSavePersister();
pm.setSavePersister(null);
if(persister == null)//1
{ 
persister = pm.getPersisterFromFileName(file.getName());
} 
if(persister == null)//2
{ 
throw new IllegalStateException("Filename " + project.getName()
                                                + " is not of a known file type");
} 
testSimulateErrors();
String report = project.repair();
if(report.length() > 0)//1
{ 
report =
                    "An inconsistency has been detected when saving the model."
                    + "These have been repaired and are reported below. "
                    + "The save will continue with the model having been "
                    + "amended as described.\n" + report;
reportError(
                    pmw,
                    Translator.localize("dialog.repair") + report, true);
} 
if(pmw != null)//1
{ 
pmw.updateProgress(25);
persister.addProgressListener(pmw);
} 
project.preSave();
persister.save(project, file);
project.postSave();
ArgoEventPump.fireEvent(new ArgoStatusEvent(
                                        ArgoEventTypes.STATUS_PROJECT_SAVED, this,
                                        file.getAbsolutePath()));
saveAction.setEnabled(false);
addFileSaved(file);
Configuration.setString(Argo.KEY_MOST_RECENT_PROJECT_FILE,
                                    file.getCanonicalPath());
return true;
} 
catch (Exception ex) //1
{ 
String sMessage =
                MessageFormat.format(Translator.localize(
                                         "optionpane.save-project-general-exception"),
                                     new Object[] {ex.getMessage()});
JOptionPane.showMessageDialog(this, sMessage,
                                          Translator.localize(
                                              "optionpane.save-project-general-exception-title"),
                                          JOptionPane.ERROR_MESSAGE);
reportError(
                pmw,
                Translator.localize(
                    "dialog.error.save.error",
                    new Object[] {file.getName()}),
                true, ex);
} 
return false;
} 
public void dispose()
    { 
} 
public void trySave(boolean overwrite, boolean saveNewFile)
    { 
URI uri = ProjectManager.getManager().getCurrentProject().getURI();
File file = null;
if(uri != null && !saveNewFile)//1
{ 
file = new File(uri);
if(!file.exists())//1
{ 
int response = JOptionPane.showConfirmDialog(
                                   this,
                                   Translator.localize(
                                       "optionpane.save-project-file-not-found"),
                                   Translator.localize(
                                       "optionpane.save-project-file-not-found-title"),
                                   JOptionPane.YES_NO_OPTION);
if(response == JOptionPane.YES_OPTION)//1
{ 
saveNewFile = true;
} 
else
{ 
return;
} 
} 
} 
else
{ 
saveNewFile = true;
} 
if(saveNewFile)//1
{ 
file = getNewFile();
if(file == null)//1
{ 
return;
} 
} 
trySaveWithProgressMonitor(overwrite, file);
} 
@Override
    public Locale getLocale()
    { 
return Locale.getDefault();
} 
public void showSaveIndicator()
    { 
titleHandler.buildTitle(null, null);
} 
private void testSimulateErrors()
    { 
if(false)//1
{ 
Layer lay =
                Globals.curEditor().getLayerManager().getActiveLayer();
List figs = lay.getContentsNoEdges();
if(figs.size() > 0)//1
{ 
Fig fig = (Fig) figs.get(0);
fig.setOwner(null);
} 
if(figs.size() > 1)//1
{ 
Fig fig = (Fig) figs.get(1);
fig.setLayer(null);
} 
if(figs.size() > 2)//1
{ 
Fig fig = (Fig) figs.get(2);
Object owner = fig.getOwner();
Model.getUmlFactory().delete(owner);
} 
} 
} 
private void saveScreenConfiguration()
    { 
if(explorerPane != null)//1
{ 
Configuration.setInteger(Argo.KEY_SCREEN_WEST_WIDTH,
                                     explorerPane.getWidth());
} 
if(eastPane != null)//1
{ 
Configuration.setInteger(Argo.KEY_SCREEN_EAST_WIDTH,
                                     eastPane.getWidth());
} 
if(northPane != null)//1
{ 
Configuration.setInteger(Argo.KEY_SCREEN_NORTH_HEIGHT,
                                     northPane.getHeight());
} 
if(southPane != null)//1
{ 
Configuration.setInteger(Argo.KEY_SCREEN_SOUTH_HEIGHT,
                                     southPane.getHeight());
} 
if(todoPane != null)//1
{ 
Configuration.setInteger(Argo.KEY_SCREEN_SOUTHWEST_WIDTH,
                                     todoPane.getWidth());
} 
if(southEastPane != null)//1
{ 
Configuration.setInteger(Argo.KEY_SCREEN_SOUTHEAST_WIDTH,
                                     southEastPane.getWidth());
} 
if(northWestPane != null)//1
{ 
Configuration.setInteger(Argo.KEY_SCREEN_NORTHWEST_WIDTH,
                                     northWestPane.getWidth());
} 
if(northEastPane != null)//1
{ 
Configuration.setInteger(Argo.KEY_SCREEN_NORTHEAST_WIDTH,
                                     northEastPane.getWidth());
} 
boolean maximized = getExtendedState() == MAXIMIZED_BOTH;
if(!maximized)//1
{ 
Configuration.setInteger(Argo.KEY_SCREEN_WIDTH, getWidth());
Configuration.setInteger(Argo.KEY_SCREEN_HEIGHT, getHeight());
Configuration.setInteger(Argo.KEY_SCREEN_LEFT_X, getX());
Configuration.setInteger(Argo.KEY_SCREEN_TOP_Y, getY());
} 
Configuration.setBoolean(Argo.KEY_SCREEN_MAXIMIZED,
                                 maximized);
} 
public void tryExit()
    { 
if(saveAction != null && saveAction.isEnabled())//1
{ 
Project p = ProjectManager.getManager().getCurrentProject();
String t =
                MessageFormat.format(Translator.localize(
                                         "optionpane.exit-save-changes-to"),
                                     new Object[] {p.getName()});
int response =
                JOptionPane.showConfirmDialog(
                    this, t, t, JOptionPane.YES_NO_CANCEL_OPTION);
if(response == JOptionPane.CANCEL_OPTION
                    || response == JOptionPane.CLOSED_OPTION)//1
{ 
return;
} 
if(response == JOptionPane.YES_OPTION)//1
{ 
trySave(ProjectManager.getManager().getCurrentProject() != null
                        && ProjectManager.getManager().getCurrentProject()
                        .getURI() != null);
if(saveAction.isEnabled())//1
{ 
return;
} 
} 
} 
saveScreenConfiguration();
Configuration.save();
System.exit(0);
} 
public void setAppName(String n)
    { 
appName = n;
} 
private void setTarget(Object o)
    { 
TargetManager.getInstance().setTarget(o);
} 
public void loadProjectWithProgressMonitor(File file, boolean showUI)
    { 
LoadSwingWorker worker = new LoadSwingWorker(file, showUI);
worker.start();
} 
public void addPanel(Component comp, Position position)
    { 
workAreaPane.add(comp, position.toString());
} 
protected File getNewFile()
    { 
ProjectBrowser pb = ProjectBrowser.getInstance();
Project p = ProjectManager.getManager().getCurrentProject();
JFileChooser chooser = null;
URI uri = p.getURI();
if(uri != null)//1
{ 
File projectFile = new File(uri);
if(projectFile.length() > 0)//1
{ 
chooser = new JFileChooser(projectFile);
} 
else
{ 
chooser = new JFileChooser();
} 
chooser.setSelectedFile(projectFile);
} 
else
{ 
chooser = new JFileChooser();
} 
String sChooserTitle =
            Translator.localize("filechooser.save-as-project");
chooser.setDialogTitle(sChooserTitle + " " + p.getName());
chooser.setFileView(ProjectFileView.getInstance());
chooser.setAcceptAllFileFilterUsed(false);
PersistenceManager.getInstance().setSaveFileChooserFilters(
            chooser,
            uri != null ? Util.URIToFilename(uri.toString()) : null);
int retval = chooser.showSaveDialog(pb);
if(retval == JFileChooser.APPROVE_OPTION)//1
{ 
File theFile = chooser.getSelectedFile();
AbstractFilePersister filter =
                (AbstractFilePersister) chooser.getFileFilter();
if(theFile != null)//1
{ 
Configuration.setString(
                    PersistenceManager.KEY_PROJECT_NAME_PATH,
                    PersistenceManager.getInstance().getBaseName(
                        theFile.getPath()));
String name = theFile.getName();
if(!name.endsWith("." + filter.getExtension()))//1
{ 
theFile =
                        new File(
                        theFile.getParent(),
                        name + "." + filter.getExtension());
} 
} 
PersistenceManager.getInstance().setSavePersister(filter);
return theFile;
} 
return null;
} 
public void addFileSaved(File file) throws IOException
    { 
GenericArgoMenuBar menu = (GenericArgoMenuBar) getJMenuBar();
if(menu != null)//1
{ 
menu.addFileSaved(file.getCanonicalPath());
} 
} 
public StatusBar getStatusBar()
    { 
return statusBar;
} 
public void targetAdded(TargetEvent e)
    { 
targetChanged(e.getNewTarget());
} 
public void targetRemoved(TargetEvent e)
    { 
targetChanged(e.getNewTarget());
} 
private void addKeyboardFocusListener()
    { 
KeyboardFocusManager kfm =
            KeyboardFocusManager.getCurrentKeyboardFocusManager();
kfm.addPropertyChangeListener(new PropertyChangeListener() {
            private Object obj;

            /*
             * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
             */
            public void propertyChange(PropertyChangeEvent evt) {
                if ("focusOwner".equals(evt.getPropertyName())
                        && (evt.getNewValue() != null)
                        /* We get many many events (why?), so let's filter: */
                        && (obj != evt.getNewValue())) {
                    obj = evt.getNewValue();
                    // TODO: Bob says -
                    // We're looking at focus change to
                    // flag the start of an interaction. This
                    // is to detect when focus is gained in a prop
                    // panel field on the assumption editing of that
                    // field is about to start.
                    // Not a good assumption. We Need to see if we can get
                    // rid of this.
                    Project p =
                        ProjectManager.getManager().getCurrentProject();
                    if (p != null) {
                        p.getUndoManager().startInteraction("Focus");
                    }
                    /* This next line is ideal for debugging the taborder
                     * (focus traversal), see e.g. issue 1849.
                     */
//                      System.out.println("Focus changed " + obj);
                }
            }
        });
} 
private void reportError(ProgressMonitor monitor, final String message,
                             final String explanation, boolean showUI)
    { 
if(showUI)//1
{ 
if(monitor != null)//1
{ 
monitor.notifyMessage(
                    Translator.localize("dialog.error.title"),
                    explanation,
                    message);
} 
else
{ 
SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        JDialog dialog =
                            new ExceptionDialog(
                            ArgoFrame.getInstance(),
                            Translator.localize("dialog.error.title"),
                            explanation,
                            message);
                        dialog.setVisible(true);
                    }
                });
} 
} 
else
{ 
reportError(monitor, message + "\n" + explanation + "\n\n",
                        showUI);
} 
} 
private void reportError(ProgressMonitor monitor, final String message,
                             boolean showUI)
    { 
if(showUI)//1
{ 
if(monitor != null)//1
{ 
monitor.notifyMessage(
                    Translator.localize("dialog.error.title"),
                    Translator.localize("dialog.error.open.save.error"),
                    message);
} 
else
{ 
SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        JDialog dialog =
                            new ExceptionDialog(
                            ArgoFrame.getInstance(),
                            Translator.localize("dialog.error.title"),
                            Translator.localize(
                                "dialog.error.open.save.error"),
                            message);
                        dialog.setVisible(true);
                    }
                });
} 
} 
else
{ 
System.err.print(message);
} 
} 
public JPanel getDetailsPane()
    { 
return southPane;
} 
private void createDetailsPanes()
    { 
eastPane  =
            makeDetailsPane(BorderSplitPane.EAST,  Vertical.getInstance());
southPane =
            makeDetailsPane(BorderSplitPane.SOUTH, Horizontal.getInstance());
southEastPane =
            makeDetailsPane(BorderSplitPane.SOUTHEAST,
                            Horizontal.getInstance());
northWestPane =
            makeDetailsPane(BorderSplitPane.NORTHWEST,
                            Horizontal.getInstance());
northPane =
            makeDetailsPane(BorderSplitPane.NORTH, Horizontal.getInstance());
northEastPane =
            makeDetailsPane(BorderSplitPane.NORTHEAST,
                            Horizontal.getInstance());
if(southPane != null)//1
{ 
detailsPanesByCompassPoint.put(Position.South, southPane);
} 
if(southEastPane != null)//1
{ 
detailsPanesByCompassPoint.put(Position.SouthEast,
                                           southEastPane);
} 
if(eastPane != null)//1
{ 
detailsPanesByCompassPoint.put(Position.East, eastPane);
} 
if(northWestPane != null)//1
{ 
detailsPanesByCompassPoint.put(Position.NorthWest,
                                           northWestPane);
} 
if(northPane != null)//1
{ 
detailsPanesByCompassPoint.put(Position.North, northPane);
} 
if(northEastPane != null)//1
{ 
detailsPanesByCompassPoint.put(Position.NorthEast,
                                           northEastPane);
} 
Iterator it = detailsPanesByCompassPoint.entrySet().iterator();
while (it.hasNext()) //1
{ 
TargetManager.getInstance().addTargetListener(
                (DetailsPane) ((Map.Entry) it.next()).getValue());
} 
} 
public void propertyChange(PropertyChangeEvent evt)
    { 
if(evt.getPropertyName()
                .equals(ProjectManager.CURRENT_PROJECT_PROPERTY_NAME))//1
{ 
Project p = (Project) evt.getNewValue();
if(p != null)//1
{ 
titleHandler.buildTitle(p.getName(), null);
Designer.setCritiquingRoot(p);
TargetManager.getInstance().setTarget(p.getInitialTarget());
} 
ArgoEventPump.fireEvent(new ArgoStatusEvent(
                                        ArgoEventTypes.STATUS_PROJECT_LOADED, this, p.getName()));
} 
} 
public void removePanel(Component comp)
    { 
workAreaPane.remove(comp);
workAreaPane.validate();
workAreaPane.repaint();
} 
private int getSavedWidth(ConfigurationKey width)
    { 
return Configuration.getInteger(width, DEFAULT_COMPONENTWIDTH);
} 
public static ProjectBrowser makeInstance(SplashScreen splash,
            boolean mainApplication, JPanel leftBottomPane)
    { 
return new ProjectBrowser("ArgoUML", splash,
                                  mainApplication, leftBottomPane);
} 
private ProjectBrowser(String applicationName, SplashScreen splash,
                           boolean mainApplication, JPanel leftBottomPane)
    { 
super(applicationName);
theInstance = this;
isMainApplication = mainApplication;
getContentPane().setFont(defaultFont);
saveAction = new ActionSaveProject();
ProjectManager.getManager().setSaveAction(saveAction);
createPanels(splash, leftBottomPane);
if(isMainApplication)//1
{ 
menuBar = new GenericArgoMenuBar();
getContentPane().setLayout(new BorderLayout());
this.setJMenuBar(menuBar);
getContentPane().add(assemblePanels(), BorderLayout.CENTER);
JPanel bottom = new JPanel();
bottom.setLayout(new BorderLayout());
bottom.add(statusBar, BorderLayout.CENTER);
bottom.add(new HeapMonitor(), BorderLayout.EAST);
getContentPane().add(bottom, BorderLayout.SOUTH);
setAppName(applicationName);
setDefaultCloseOperation(ProjectBrowser.DO_NOTHING_ON_CLOSE);
addWindowListener(new WindowCloser());
setApplicationIcon();
ProjectManager.getManager().addPropertyChangeListener(this);
TargetManager.getInstance().addTargetListener(this);
addKeyboardFocusListener();
} 
} 
private void setApplicationIcon()
    { 
final ImageIcon argoImage16x16 =
            ResourceLoaderWrapper.lookupIconResource("ArgoIcon16x16");
if(JavaRuntimeUtility.isJre5())//1
{ 
setIconImage(argoImage16x16.getImage());
} 
else
{ 
final ImageIcon argoImage32x32 =
                ResourceLoaderWrapper.lookupIconResource("ArgoIcon32x32");
final List<Image> argoImages = new ArrayList<Image>(2);
argoImages.add(argoImage16x16.getImage());
argoImages.add(argoImage32x32.getImage());
try//1
{ 
final Method m =
                    getClass().getMethod("setIconImages", List.class);
m.invoke(this, argoImages);
} 
catch (InvocationTargetException e) //1
{ 
} 
catch (NoSuchMethodException e) //1
{ 
} 
catch (IllegalArgumentException e) //1
{ 
} 
catch (IllegalAccessException e) //1
{ 
} 
} 
} 
@Deprecated
    public void setToDoItem(Object o)
    { 
Iterator it = detailsPanesByCompassPoint.values().iterator();
while (it.hasNext()) //1
{ 
DetailsPane detailsPane = (DetailsPane) it.next();
if(detailsPane.setToDoItem(o))//1
{ 
return;
} 
} 
} 
public boolean loadProject(File file, boolean showUI,
                               ProgressMonitor pmw)
    { 
PersistenceManager pm = PersistenceManager.getInstance();
Project oldProject = ProjectManager.getManager().getCurrentProject();
if(oldProject != null)//1
{ 
Project p = ProjectManager.getManager().makeEmptyProject();
ProjectManager.getManager().setCurrentProject(p);
ProjectManager.getManager().removeProject(oldProject);
oldProject = p;
} 
boolean success = false;
Designer.disableCritiquing();
Designer.clearCritiquing();
clearDialogs();
Project project = null;
if(!(file.canRead()))//1
{ 
reportError(pmw, "File not found " + file + ".", showUI);
Designer.enableCritiquing();
success = false;
} 
else
{ 
final AbstractAction rememberedSaveAction = this.saveAction;
this.saveAction = null;
ProjectManager.getManager().setSaveAction(null);
try//1
{ 
ProjectFilePersister persister =
                    pm.getPersisterFromFileName(file.getName());
if(persister == null)//1
{ 
throw new IllegalStateException("Filename "
                                                    + file.getName()
                                                    + " is not of a known file type");
} 
if(pmw != null)//1
{ 
persister.addProgressListener(pmw);
} 
project = persister.doLoad(file);
if(pmw != null)//2
{ 
persister.removeProgressListener(pmw);
} 
ThreadUtils.checkIfInterrupted();
this.addFileSaved(file);
Configuration.setString(Argo.KEY_MOST_RECENT_PROJECT_FILE,
                                        file.getCanonicalPath());
updateStatus(
                    Translator.localize(
                        "statusmsg.bar.open-project-status-read",
                        new Object[] {file.getName(), }));
success = true;
} 
catch (VersionException ex) //1
{ 
reportError(
                    pmw,
                    Translator.localize(
                        "dialog.error.file.version.error",
                        new Object[] {ex.getMessage()}),
                    showUI);
} 
catch (OutOfMemoryError ex) //1
{ 
reportError(
                    pmw,
                    Translator.localize("dialog.error.memory.limit"),
                    showUI);
} 
catch (java.lang.InterruptedException ex) //1
{ 
} 
catch (UmlVersionException ex) //1
{ 
reportError(
                    pmw,
                    Translator.localize(
                        "dialog.error.file.version.error",
                        new Object[] {ex.getMessage()}),
                    showUI, ex);
} 
catch (XmiFormatException ex) //1
{ 
if(ex.getCause() instanceof XmiReferenceException)//1
{ 
String reference =
                        ((XmiReferenceException) ex.getCause()).getReference();
reportError(
                        pmw,
                        Translator.localize(
                            "dialog.error.xmi.reference.error",
                            new Object[] {reference, ex.getMessage()}),
                        ex.toString(),
                        showUI);
} 
else
{ 
reportError(
                        pmw,
                        Translator.localize(
                            "dialog.error.xmi.format.error",
                            new Object[] {ex.getMessage()}),
                        showUI, ex);
} 
} 
catch (IOException ex) //1
{ 
reportError(
                    pmw,
                    Translator.localize(
                        "dialog.error.open.error",
                        new Object[] {file.getName()}),
                    showUI, ex);
} 
catch (OpenException ex) //1
{ 
reportError(
                    pmw,
                    Translator.localize(
                        "dialog.error.open.error",
                        new Object[] {file.getName()}),
                    showUI, ex);
} 
catch (RuntimeException ex) //1
{ 
reportError(
                    pmw,
                    Translator.localize(
                        "dialog.error.open.error",
                        new Object[] {file.getName()}),
                    showUI, ex);
} 
finally { 
try//1
{ 
if(!success)//1
{ 
project =
                            ProjectManager.getManager().makeEmptyProject();
} 
ProjectManager.getManager().setCurrentProject(project);
if(oldProject != null)//1
{ 
ProjectManager.getManager().removeProject(oldProject);
} 
project.getProjectSettings().init();
Command cmd = new NonUndoableCommand() {
                        public Object execute() {
                            // This is temporary. Load project
                            // should create a new project
                            // with its own UndoManager and so
                            // there should be no Command
                            return null;
                        }
                    };
project.getUndoManager().addCommand(cmd);
Designer.enableCritiquing();
} 
finally { 
this.saveAction = rememberedSaveAction;
SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            ProjectManager.getManager().setSaveAction(
                                rememberedSaveAction);
                            rememberedSaveAction.setEnabled(false);
                        }
                    });
} 
} 
} 
return success;
} 
public void buildTitleWithCurrentProjectName()
    { 
titleHandler.buildTitle(
            ProjectManager.getManager().getCurrentProject().getName(),
            null);
} 
private Dimension getSavedDimensions(ConfigurationKey width,
                                         ConfigurationKey height)
    { 
return new Dimension(getSavedWidth(width), getSavedHeight(height));
} 
@Deprecated
    public AbstractArgoJPanel getTab(Class tabClass)
    { 
for (DetailsPane detailsPane : detailsPanesByCompassPoint.values())  //1
{ 
AbstractArgoJPanel tab = detailsPane.getTab(tabClass);
if(tab != null)//1
{ 
return tab;
} 
} 
throw new IllegalStateException("No " + tabClass.getName()
                                        + " tab found");
} 
public JPanel getTodoPane()
    { 
return todoPane;
} 
public void trySaveWithProgressMonitor(boolean overwrite, File file)
    { 
SaveSwingWorker worker = new SaveSwingWorker(overwrite, file);
Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
worker.start();
} 
public String getAppName()
    { 
return appName;
} 
private Component assemblePanels()
    { 
addPanel(editorPane, Position.Center);
addPanel(explorerPane, Position.West);
addPanel(todoPane, Position.SouthWest);
for (Map.Entry<Position, DetailsPane> entry
                : detailsPanesByCompassPoint.entrySet()) //1
{ 
Position position = entry.getKey();
addPanel(entry.getValue(), position);
} 
final JPanel toolbarBoundary = new JPanel();
toolbarBoundary.setLayout(new DockBorderLayout());
final String toolbarPosition = BorderLayout.NORTH;
toolbarBoundary.add(menuBar.getFileToolbar(), toolbarPosition);
toolbarBoundary.add(menuBar.getEditToolbar(), toolbarPosition);
toolbarBoundary.add(menuBar.getViewToolbar(), toolbarPosition);
toolbarBoundary.add(menuBar.getCreateDiagramToolbar(),
                            toolbarPosition);
toolbarBoundary.add(workAreaPane, BorderLayout.CENTER);
ArgoToolbarManager.getInstance().registerToolbar(
            menuBar.getFileToolbar(), menuBar.getFileToolbar(), 0);
ArgoToolbarManager.getInstance().registerToolbar(
            menuBar.getEditToolbar(), menuBar.getEditToolbar(), 1);
ArgoToolbarManager.getInstance().registerToolbar(
            menuBar.getViewToolbar(), menuBar.getViewToolbar(), 2);
ArgoToolbarManager.getInstance().registerToolbar(
            menuBar.getCreateDiagramToolbar(),
            menuBar.getCreateDiagramToolbar(), 3);
final JToolBar[] toolbars = new JToolBar[] {menuBar.getFileToolbar(),
                menuBar.getEditToolbar(), menuBar.getViewToolbar(),
                menuBar.getCreateDiagramToolbar()
                                                   };
for (JToolBar toolbar : toolbars) //1
{ 
toolbar.addComponentListener(new ComponentAdapter() {
                public void componentHidden(ComponentEvent e) {
                    boolean allHidden = true;
                    for (JToolBar bar : toolbars) {
                        if (bar.isVisible()) {
                            allHidden = false;
                            break;
                        }
                    }

                    if (allHidden) {
                        for (JToolBar bar : toolbars) {
                            toolbarBoundary.getLayout().removeLayoutComponent(
                                bar);
                        }
                        toolbarBoundary.getLayout().layoutContainer(
                            toolbarBoundary);
                    }
                }

                public void componentShown(ComponentEvent e) {
                    JToolBar oneVisible = null;
                    for (JToolBar bar : toolbars) {
                        if (bar.isVisible()) {
                            oneVisible = bar;
                            break;
                        }
                    }

                    if (oneVisible != null) {
                        toolbarBoundary.add(oneVisible, toolbarPosition);
                        toolbarBoundary.getLayout().layoutContainer(
                            toolbarBoundary);
                    }
                }
            });
} 
return toolbarBoundary;
} 
private boolean isFileReadonly(File file)
    { 
try//1
{ 
return (file == null)
                   || (file.exists() && !file.canWrite())
                   || (!file.exists() && !file.createNewFile());
} 
catch (IOException ioExc) //1
{ 
return true;
} 
} 
private DetailsPane makeDetailsPane(String compassPoint,
                                        Orientation orientation)
    { 
DetailsPane detailsPane =
            new DetailsPane(compassPoint.toLowerCase(), orientation);
if(!detailsPane.hasTabs())//1
{ 
return null;
} 
return detailsPane;
} 
class WindowCloser extends WindowAdapter
  { 
public void windowClosing(WindowEvent e)
        { 
tryExit();
} 
public WindowCloser()
        { 
} 

 } 
private class TitleHandler implements PropertyChangeListener
  { 
private ArgoDiagram monitoredDiagram = null;
protected void buildTitle(String projectFileName,
                                  ArgoDiagram activeDiagram)
        { 
if(projectFileName == null || "".equals(projectFileName))//1
{ 
if(ProjectManager.getManager().getCurrentProject() != null)//1
{ 
projectFileName = ProjectManager.getManager()
                                      .getCurrentProject().getName();
} 
} 
if(activeDiagram == null)//1
{ 
activeDiagram = DiagramUtils.getActiveDiagram();
} 
String changeIndicator = "";
if(saveAction != null && saveAction.isEnabled())//1
{ 
changeIndicator = " *";
} 
if(activeDiagram != null)//1
{ 
if(monitoredDiagram != null)//1
{ 
monitoredDiagram.removePropertyChangeListener("name", this);
} 
activeDiagram.addPropertyChangeListener("name", this);
monitoredDiagram = activeDiagram;
setTitle(projectFileName + " - " + activeDiagram.getName()
                         + " - " + getAppName() + changeIndicator);
} 
else
{ 
setTitle(projectFileName + " - " + getAppName()
                         + changeIndicator);
} 
} 
public void propertyChange(PropertyChangeEvent evt)
        { 
if(evt.getPropertyName().equals("name")
                    && evt.getSource() instanceof ArgoDiagram)//1
{ 
buildTitle(
                    ProjectManager.getManager().getCurrentProject().getName(),
                    (ArgoDiagram) evt.getSource());
} 
} 

 } 
public enum Position {
Center,

North,

South,

East,

West,

NorthEast,

SouthEast,

SouthWest,

NorthWest,

;
 } 

 } 
