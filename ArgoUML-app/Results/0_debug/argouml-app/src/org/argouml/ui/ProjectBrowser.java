
//#if 151954224 
// Compilation Unit of /ProjectBrowser.java 
 

//#if -744295827 
package org.argouml.ui;
//#endif 


//#if 2106969655 
import java.awt.BorderLayout;
//#endif 


//#if -105765268 
import java.awt.Component;
//#endif 


//#if 756015907 
import java.awt.Dimension;
//#endif 


//#if 1092835710 
import java.awt.Font;
//#endif 


//#if -398189362 
import java.awt.Image;
//#endif 


//#if 445844017 
import java.awt.KeyboardFocusManager;
//#endif 


//#if -21407363 
import java.awt.Window;
//#endif 


//#if 234543047 
import java.awt.event.ComponentAdapter;
//#endif 


//#if 1557197980 
import java.awt.event.ComponentEvent;
//#endif 


//#if -1981180226 
import java.awt.event.WindowAdapter;
//#endif 


//#if 75564371 
import java.awt.event.WindowEvent;
//#endif 


//#if -1125953777 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -843674343 
import java.beans.PropertyChangeListener;
//#endif 


//#if -1476307883 
import java.io.File;
//#endif 


//#if -2033052516 
import java.io.IOException;
//#endif 


//#if -1412832283 
import java.io.PrintWriter;
//#endif 


//#if -1645133587 
import java.io.StringWriter;
//#endif 


//#if -1768053728 
import java.lang.reflect.InvocationTargetException;
//#endif 


//#if -103315161 
import java.lang.reflect.Method;
//#endif 


//#if 343961374 
import java.net.URI;
//#endif 


//#if -943462304 
import java.text.MessageFormat;
//#endif 


//#if -9345198 
import java.util.ArrayList;
//#endif 


//#if 1049897039 
import java.util.Collection;
//#endif 


//#if -883149093 
import java.util.HashMap;
//#endif 


//#if 398531839 
import java.util.Iterator;
//#endif 


//#if 1785267151 
import java.util.List;
//#endif 


//#if 2106263827 
import java.util.Locale;
//#endif 


//#if -1050767443 
import java.util.Map;
//#endif 


//#if 453887245 
import javax.swing.AbstractAction;
//#endif 


//#if -1737693891 
import javax.swing.ImageIcon;
//#endif 


//#if 544647327 
import javax.swing.JDialog;
//#endif 


//#if -1330542896 
import javax.swing.JFileChooser;
//#endif 


//#if 1468613186 
import javax.swing.JFrame;
//#endif 


//#if -666279589 
import javax.swing.JMenuBar;
//#endif 


//#if 674322698 
import javax.swing.JOptionPane;
//#endif 


//#if 1739584651 
import javax.swing.JPanel;
//#endif 


//#if -1046089452 
import javax.swing.JToolBar;
//#endif 


//#if -370737447 
import javax.swing.SwingUtilities;
//#endif 


//#if 606907817 
import org.argouml.application.api.AbstractArgoJPanel;
//#endif 


//#if 1358962245 
import org.argouml.application.api.Argo;
//#endif 


//#if -180712994 
import org.argouml.application.events.ArgoEventPump;
//#endif 


//#if -1188844233 
import org.argouml.application.events.ArgoEventTypes;
//#endif 


//#if -854634568 
import org.argouml.application.events.ArgoStatusEvent;
//#endif 


//#if -2038130629 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 919167144 
import org.argouml.configuration.Configuration;
//#endif 


//#if -1802514865 
import org.argouml.configuration.ConfigurationKey;
//#endif 


//#if 947122300 
import org.argouml.i18n.Translator;
//#endif 


//#if 1237004438 
import org.argouml.kernel.Command;
//#endif 


//#if 1153414037 
import org.argouml.kernel.NonUndoableCommand;
//#endif 


//#if 840842888 
import org.argouml.kernel.Project;
//#endif 


//#if -1561474207 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 1847089474 
import org.argouml.model.Model;
//#endif 


//#if -1322878509 
import org.argouml.model.XmiReferenceException;
//#endif 


//#if 1924512978 
import org.argouml.persistence.AbstractFilePersister;
//#endif 


//#if -1517236144 
import org.argouml.persistence.OpenException;
//#endif 


//#if -431528557 
import org.argouml.persistence.PersistenceManager;
//#endif 


//#if 1409188629 
import org.argouml.persistence.ProjectFilePersister;
//#endif 


//#if -1342296805 
import org.argouml.persistence.ProjectFileView;
//#endif 


//#if -380285078 
import org.argouml.persistence.UmlVersionException;
//#endif 


//#if -1736073750 
import org.argouml.persistence.VersionException;
//#endif 


//#if 867571965 
import org.argouml.persistence.XmiFormatException;
//#endif 


//#if -240357877 
import org.argouml.taskmgmt.ProgressMonitor;
//#endif 


//#if -495858412 
import org.argouml.ui.cmd.GenericArgoMenuBar;
//#endif 


//#if 2140263443 
import org.argouml.ui.targetmanager.TargetEvent;
//#endif 


//#if 549435797 
import org.argouml.ui.targetmanager.TargetListener;
//#endif 


//#if -650980128 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 1576839169 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if -1984901603 
import org.argouml.uml.diagram.DiagramUtils;
//#endif 


//#if 1728585960 
import org.argouml.uml.diagram.UMLMutableGraphSupport;
//#endif 


//#if -1390071002 
import org.argouml.uml.diagram.ui.ActionRemoveFromDiagram;
//#endif 


//#if -1100269654 
import org.argouml.uml.ui.ActionSaveProject;
//#endif 


//#if 276484011 
import org.argouml.uml.ui.TabProps;
//#endif 


//#if 1281783752 
import org.argouml.util.ArgoFrame;
//#endif 


//#if -1152518716 
import org.argouml.util.JavaRuntimeUtility;
//#endif 


//#if 1047988533 
import org.argouml.util.ThreadUtils;
//#endif 


//#if 1901206371 
import org.tigris.gef.base.Editor;
//#endif 


//#if 958301366 
import org.tigris.gef.base.Globals;
//#endif 


//#if 397972341 
import org.tigris.gef.base.Layer;
//#endif 


//#if -888590738 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if -1826475719 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -668427493 
import org.tigris.gef.ui.IStatusBar;
//#endif 


//#if 607770911 
import org.tigris.gef.util.Util;
//#endif 


//#if -1094675893 
import org.tigris.swidgets.BorderSplitPane;
//#endif 


//#if -1694101839 
import org.tigris.swidgets.Horizontal;
//#endif 


//#if -429624943 
import org.tigris.swidgets.Orientation;
//#endif 


//#if 1287478303 
import org.tigris.swidgets.Vertical;
//#endif 


//#if -899534514 
import org.tigris.toolbar.layouts.DockBorderLayout;
//#endif 


//#if -447025 
import org.apache.log4j.Logger;
//#endif 


//#if 1713286161 
import org.argouml.cognitive.Designer;
//#endif 


//#if -1403198205 
public final class ProjectBrowser extends 
//#if 1855787837 
JFrame
//#endif 

 implements 
//#if -1234103853 
PropertyChangeListener
//#endif 

, 
//#if -1009883265 
TargetListener
//#endif 

  { 

//#if -506319789 
public static final int DEFAULT_COMPONENTWIDTH = 400;
//#endif 


//#if -1802650482 
public static final int DEFAULT_COMPONENTHEIGHT = 350;
//#endif 


//#if -537491425 
private static boolean isMainApplication;
//#endif 


//#if 614869499 
private static ProjectBrowser theInstance;
//#endif 


//#if 1674360927 
private String appName = "ProjectBrowser";
//#endif 


//#if 802194113 
private MultiEditorPane editorPane;
//#endif 


//#if 453133010 
private DetailsPane northEastPane;
//#endif 


//#if 2064613071 
private DetailsPane northPane;
//#endif 


//#if 659997792 
private DetailsPane northWestPane;
//#endif 


//#if 1667232949 
private DetailsPane eastPane;
//#endif 


//#if -1687411958 
private DetailsPane southEastPane;
//#endif 


//#if 2015509255 
private DetailsPane southPane;
//#endif 


//#if 1132312352 
private Map<Position, DetailsPane> detailsPanesByCompassPoint =
        new HashMap<Position, DetailsPane>();
//#endif 


//#if 1239621876 
private GenericArgoMenuBar menuBar;
//#endif 


//#if 1789385246 
private StatusBar statusBar = new ArgoStatusBar();
//#endif 


//#if 1602886300 
private Font defaultFont = new Font("Dialog", Font.PLAIN, 10);
//#endif 


//#if 54465416 
private BorderSplitPane workAreaPane;
//#endif 


//#if -1124970370 
private NavigatorPane explorerPane;
//#endif 


//#if 1982314154 
private JPanel todoPane;
//#endif 


//#if -405740072 
private TitleHandler titleHandler = new TitleHandler();
//#endif 


//#if -697458745 
private AbstractAction saveAction;
//#endif 


//#if 1244422002 
private final ActionRemoveFromDiagram removeFromDiagram =
        new ActionRemoveFromDiagram(
        Translator.localize("action.remove-from-diagram"));
//#endif 


//#if 10511830 
private static final long serialVersionUID = 6974246679451284917L;
//#endif 


//#if 1700920867 
private static final Logger LOG =
        Logger.getLogger(ProjectBrowser.class);
//#endif 


//#if 268862482 
static
    {
        assert Position.Center.toString().equals(BorderSplitPane.CENTER);
        assert Position.North.toString().equals(BorderSplitPane.NORTH);
        assert Position.NorthEast.toString().equals(BorderSplitPane.NORTHEAST);
        assert Position.South.toString().equals(BorderSplitPane.SOUTH);
    }
//#endif 


//#if -637848837 
private void reportError(ProgressMonitor monitor, final String message,
                             boolean showUI, final Throwable ex)
    { 

//#if -1128641681 
if(showUI)//1
{ 

//#if 389652313 
if(monitor != null)//1
{ 

//#if -2041026097 
monitor.notifyMessage(
                    Translator.localize("dialog.error.title"),
                    message,
                    ExceptionDialog.formatException(
                        message, ex, ex instanceof OpenException));
//#endif 

} 
else
{ 

//#if -1306612306 
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
//#endif 

} 

//#endif 

} 
else
{ 

//#if 497491943 
StringWriter sw = new StringWriter();
//#endif 


//#if 628892068 
PrintWriter pw = new PrintWriter(sw);
//#endif 


//#if -1353282770 
ex.printStackTrace(pw);
//#endif 


//#if -1740491577 
String exception = sw.toString();
//#endif 


//#if 737755372 
reportError(monitor, "Please report the error below to the ArgoUML"
                        + "development team at http://argouml.tigris.org.\n"
                        + message + "\n\n" + exception, showUI);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2098431916 
public boolean askConfirmationAndSave()
    { 

//#if 1412781246 
ProjectBrowser pb = ProjectBrowser.getInstance();
//#endif 


//#if 830282394 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 1840845241 
if(p != null && saveAction.isEnabled())//1
{ 

//#if 344159301 
String t =
                MessageFormat.format(Translator.localize(
                                         "optionpane.open-project-save-changes-to"),
                                     new Object[] {p.getName()});
//#endif 


//#if 207047436 
int response =
                JOptionPane.showConfirmDialog(pb, t, t,
                                              JOptionPane.YES_NO_CANCEL_OPTION);
//#endif 


//#if 1489407847 
if(response == JOptionPane.CANCEL_OPTION
                    || response == JOptionPane.CLOSED_OPTION)//1
{ 

//#if -1285021331 
return false;
//#endif 

} 

//#endif 


//#if -1415576306 
if(response == JOptionPane.YES_OPTION)//1
{ 

//#if 549246702 
trySave(ProjectManager.getManager().getCurrentProject() != null
                        && ProjectManager.getManager().getCurrentProject()
                        .getURI() != null);
//#endif 


//#if 1922445777 
if(saveAction.isEnabled())//1
{ 

//#if 544201406 
return false;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 661860497 
return true;
//#endif 

} 

//#endif 


//#if 2147275767 
private void targetChanged(Object target)
    { 

//#if -1478111447 
if(target instanceof ArgoDiagram)//1
{ 

//#if 1947332039 
titleHandler.buildTitle(null, (ArgoDiagram) target);
//#endif 

} 

//#endif 


//#if 1645843841 
determineRemoveEnabled();
//#endif 


//#if 627569975 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -1938257572 
Object theCurrentNamespace = null;
//#endif 


//#if 300978500 
target = TargetManager.getInstance().getTarget();
//#endif 


//#if 1881644776 
if(target instanceof ArgoDiagram)//2
{ 

//#if 2065270102 
theCurrentNamespace = ((ArgoDiagram) target).getNamespace();
//#endif 

} 
else

//#if -1787605623 
if(Model.getFacade().isANamespace(target))//1
{ 

//#if 1909287996 
theCurrentNamespace = target;
//#endif 

} 
else

//#if 1059272515 
if(Model.getFacade().isAModelElement(target))//1
{ 

//#if 427798070 
theCurrentNamespace = Model.getFacade().getNamespace(target);
//#endif 

} 
else
{ 

//#if -586270437 
theCurrentNamespace = p.getRoot();
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#if -124518956 
p.setCurrentNamespace(theCurrentNamespace);
//#endif 


//#if 1881674568 
if(target instanceof ArgoDiagram)//3
{ 

//#if 464544588 
p.setActiveDiagram((ArgoDiagram) target);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 803405468 
@Override
    public JMenuBar getJMenuBar()
    { 

//#if 61581689 
return menuBar;
//#endif 

} 

//#endif 


//#if 476217423 
private int getSavedHeight(ConfigurationKey height)
    { 

//#if 83209784 
return Configuration.getInteger(height, DEFAULT_COMPONENTHEIGHT);
//#endif 

} 

//#endif 


//#if 280213496 
protected void createPanels(SplashScreen splash, JPanel leftBottomPane)
    { 

//#if -203141542 
if(splash != null)//1
{ 

//#if -1115433156 
splash.getStatusBar().showStatus(
                Translator.localize("statusmsg.bar.making-project-browser"));
//#endif 


//#if -2117347018 
splash.getStatusBar().showProgress(10);
//#endif 


//#if -719499729 
splash.setVisible(true);
//#endif 

} 

//#endif 


//#if -857544377 
editorPane = new MultiEditorPane();
//#endif 


//#if -180681193 
if(splash != null)//2
{ 

//#if 1162746261 
splash.getStatusBar().showStatus(
                Translator.localize(
                    "statusmsg.bar.making-project-browser-explorer"));
//#endif 


//#if 1192904772 
splash.getStatusBar().incProgress(5);
//#endif 

} 

//#endif 


//#if 2136725711 
explorerPane = new NavigatorPane(splash);
//#endif 


//#if -784473136 
workAreaPane = new BorderSplitPane();
//#endif 


//#if -180651401 
if(splash != null)//3
{ 

//#if -588368036 
splash.getStatusBar().showStatus(Translator.localize(
                                                 "statusmsg.bar.making-project-browser-to-do-pane"));
//#endif 


//#if -342180110 
splash.getStatusBar().incProgress(5);
//#endif 

} 

//#endif 


//#if -590991179 
todoPane = leftBottomPane;
//#endif 


//#if 1377924658 
createDetailsPanes();
//#endif 


//#if 851915553 
restorePanelSizes();
//#endif 

} 

//#endif 


//#if -851918343 
private ProjectBrowser()
    { 

//#if -2067116255 
this("ArgoUML", null, true, null);
//#endif 

} 

//#endif 


//#if -1489814314 
public void clearDialogs()
    { 

//#if -1119622440 
Window[] windows = getOwnedWindows();
//#endif 


//#if 1126745891 
for (int i = 0; i < windows.length; i++) //1
{ 

//#if 808649004 
if(!(windows[i] instanceof FindDialog))//1
{ 

//#if 1982106263 
windows[i].dispose();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 750601300 
FindDialog.getInstance().reset();
//#endif 

} 

//#endif 


//#if -1536390026 
private void updateStatus(String status)
    { 

//#if -35463877 
ArgoEventPump.fireEvent(new ArgoStatusEvent(ArgoEventTypes.STATUS_TEXT,
                                this, status));
//#endif 

} 

//#endif 


//#if 293516838 
@Override
    public void setVisible(boolean b)
    { 

//#if -413426748 
super.setVisible(b);
//#endif 


//#if -810795020 
if(b)//1
{ 

//#if -1621167574 
Globals.setStatusBar(getStatusBar());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1803915752 
private void determineRemoveEnabled()
    { 

//#if 255557579 
Editor editor = Globals.curEditor();
//#endif 


//#if 605426975 
Collection figs = editor.getSelectionManager().getFigs();
//#endif 


//#if -1948537798 
boolean removeEnabled = !figs.isEmpty();
//#endif 


//#if 1148159217 
GraphModel gm = editor.getGraphModel();
//#endif 


//#if -1738740331 
if(gm instanceof UMLMutableGraphSupport)//1
{ 

//#if 1480866082 
removeEnabled =
                ((UMLMutableGraphSupport) gm).isRemoveFromDiagramAllowed(figs);
//#endif 

} 

//#endif 


//#if 660492722 
removeFromDiagram.setEnabled(removeEnabled);
//#endif 

} 

//#endif 


//#if 1816301871 
public AbstractAction getSaveAction()
    { 

//#if 242185838 
return saveAction;
//#endif 

} 

//#endif 


//#if 684564831 
public void targetSet(TargetEvent e)
    { 

//#if -904987692 
targetChanged(e.getNewTarget());
//#endif 

} 

//#endif 


//#if -1519497440 
private void restorePanelSizes()
    { 

//#if -642334101 
if(northPane != null)//1
{ 

//#if 280454229 
northPane.setPreferredSize(new Dimension(
                                           0, getSavedHeight(Argo.KEY_SCREEN_NORTH_HEIGHT)));
//#endif 

} 

//#endif 


//#if -804764365 
if(southPane != null)//1
{ 

//#if 1188170869 
southPane.setPreferredSize(new Dimension(
                                           0, getSavedHeight(Argo.KEY_SCREEN_SOUTH_HEIGHT)));
//#endif 

} 

//#endif 


//#if -1785017507 
if(eastPane != null)//1
{ 

//#if 744676154 
eastPane.setPreferredSize(new Dimension(
                                          getSavedWidth(Argo.KEY_SCREEN_EAST_WIDTH), 0));
//#endif 

} 

//#endif 


//#if -22284897 
if(explorerPane != null)//1
{ 

//#if -533190903 
explorerPane.setPreferredSize(new Dimension(
                                              getSavedWidth(Argo.KEY_SCREEN_WEST_WIDTH), 0));
//#endif 

} 

//#endif 


//#if -594037254 
if(northWestPane != null)//1
{ 

//#if -722097847 
northWestPane.setPreferredSize(getSavedDimensions(
                                               Argo.KEY_SCREEN_NORTHWEST_WIDTH,
                                               Argo.KEY_SCREEN_NORTH_HEIGHT));
//#endif 

} 

//#endif 


//#if -1969480730 
if(todoPane != null)//1
{ 

//#if -1480372054 
todoPane.setPreferredSize(getSavedDimensions(
                                          Argo.KEY_SCREEN_SOUTHWEST_WIDTH,
                                          Argo.KEY_SCREEN_SOUTH_HEIGHT));
//#endif 

} 

//#endif 


//#if -944875576 
if(northEastPane != null)//1
{ 

//#if 1847351278 
northEastPane.setPreferredSize(getSavedDimensions(
                                               Argo.KEY_SCREEN_NORTHEAST_WIDTH,
                                               Argo.KEY_SCREEN_NORTH_HEIGHT));
//#endif 

} 

//#endif 


//#if 1618032272 
if(southEastPane != null)//1
{ 

//#if -418569692 
southEastPane.setPreferredSize(getSavedDimensions(
                                               Argo.KEY_SCREEN_SOUTHEAST_WIDTH,
                                               Argo.KEY_SCREEN_SOUTH_HEIGHT));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 412934273 
public AbstractAction getRemoveFromDiagramAction()
    { 

//#if -1787079406 
return removeFromDiagram;
//#endif 

} 

//#endif 


//#if 1817284001 
public MultiEditorPane getEditorPane()
    { 

//#if -412626210 
return editorPane;
//#endif 

} 

//#endif 


//#if -2006686515 
public Font getDefaultFont()
    { 

//#if 663633970 
return defaultFont;
//#endif 

} 

//#endif 


//#if 910462328 
public static synchronized ProjectBrowser getInstance()
    { 

//#if -1006797180 
assert theInstance != null;
//#endif 


//#if -1758904879 
return theInstance;
//#endif 

} 

//#endif 


//#if 555158079 
public void trySave(boolean overwrite)
    { 

//#if -383441399 
this.trySave(overwrite, false);
//#endif 

} 

//#endif 


//#if -1737987262 
public NavigatorPane getExplorerPane()
    { 

//#if -1299471841 
return explorerPane;
//#endif 

} 

//#endif 


//#if 181446812 
public boolean trySave(boolean overwrite,
                           File file,
                           ProgressMonitor pmw)
    { 

//#if -67597595 
LOG.info("Saving the project");
//#endif 


//#if 1767082402 
Project project = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 1002139448 
PersistenceManager pm = PersistenceManager.getInstance();
//#endif 


//#if -1541232911 
ProjectFilePersister persister = null;
//#endif 


//#if -2075542159 
try //1
{ 

//#if -719298618 
if(!PersistenceManager.getInstance().confirmOverwrite(
                        ArgoFrame.getInstance(), overwrite, file))//1
{ 

//#if -952497220 
return false;
//#endif 

} 

//#endif 


//#if -969588515 
if(this.isFileReadonly(file))//1
{ 

//#if 1936309530 
JOptionPane.showMessageDialog(this,
                                              Translator.localize(
                                                  "optionpane.save-project-cant-write"),
                                              Translator.localize(
                                                  "optionpane.save-project-cant-write-title"),
                                              JOptionPane.INFORMATION_MESSAGE);
//#endif 


//#if -2073732589 
return false;
//#endif 

} 

//#endif 


//#if -1074032643 
String sStatus =
                MessageFormat.format(Translator.localize(
                                         "statusmsg.bar.save-project-status-writing"),
                                     new Object[] {file});
//#endif 


//#if -726178995 
updateStatus (sStatus);
//#endif 


//#if -135766950 
persister = pm.getSavePersister();
//#endif 


//#if -1656347887 
pm.setSavePersister(null);
//#endif 


//#if -2039498040 
if(persister == null)//1
{ 

//#if -396917143 
persister = pm.getPersisterFromFileName(file.getName());
//#endif 

} 

//#endif 


//#if -2078663959 
if(persister == null)//2
{ 

//#if 1450937790 
throw new IllegalStateException("Filename " + project.getName()
                                                + " is not of a known file type");
//#endif 

} 

//#endif 


//#if 1990270870 
testSimulateErrors();
//#endif 


//#if -825831485 
String report = project.repair();
//#endif 


//#if 395003571 
if(report.length() > 0)//1
{ 

//#if 1107935144 
report =
                    "An inconsistency has been detected when saving the model."
                    + "These have been repaired and are reported below. "
                    + "The save will continue with the model having been "
                    + "amended as described.\n" + report;
//#endif 


//#if -1347163479 
reportError(
                    pmw,
                    Translator.localize("dialog.repair") + report, true);
//#endif 

} 

//#endif 


//#if 1723376317 
if(pmw != null)//1
{ 

//#if -186720745 
pmw.updateProgress(25);
//#endif 


//#if -1238459875 
persister.addProgressListener(pmw);
//#endif 

} 

//#endif 


//#if -652752910 
project.preSave();
//#endif 


//#if 446941052 
persister.save(project, file);
//#endif 


//#if -446169179 
project.postSave();
//#endif 


//#if -1835126181 
ArgoEventPump.fireEvent(new ArgoStatusEvent(
                                        ArgoEventTypes.STATUS_PROJECT_SAVED, this,
                                        file.getAbsolutePath()));
//#endif 


//#if 1782173661 
LOG.debug ("setting most recent project file to "
                       + file.getCanonicalPath());
//#endif 


//#if 1573999716 
saveAction.setEnabled(false);
//#endif 


//#if -472951095 
addFileSaved(file);
//#endif 


//#if 1160082315 
Configuration.setString(Argo.KEY_MOST_RECENT_PROJECT_FILE,
                                    file.getCanonicalPath());
//#endif 


//#if 1881263418 
return true;
//#endif 

} 

//#if -701066926 
catch (Exception ex) //1
{ 

//#if -1622730198 
String sMessage =
                MessageFormat.format(Translator.localize(
                                         "optionpane.save-project-general-exception"),
                                     new Object[] {ex.getMessage()});
//#endif 


//#if -1508133866 
JOptionPane.showMessageDialog(this, sMessage,
                                          Translator.localize(
                                              "optionpane.save-project-general-exception-title"),
                                          JOptionPane.ERROR_MESSAGE);
//#endif 


//#if 1661389399 
reportError(
                pmw,
                Translator.localize(
                    "dialog.error.save.error",
                    new Object[] {file.getName()}),
                true, ex);
//#endif 


//#if 1192981701 
LOG.error(sMessage, ex);
//#endif 

} 

//#endif 


//#endif 


//#if 1636946723 
return false;
//#endif 

} 

//#endif 


//#if 767598281 
public void dispose()
    { 
} 

//#endif 


//#if 1997596592 
public void trySave(boolean overwrite, boolean saveNewFile)
    { 

//#if 340622019 
URI uri = ProjectManager.getManager().getCurrentProject().getURI();
//#endif 


//#if -760286466 
File file = null;
//#endif 


//#if 1305757913 
if(uri != null && !saveNewFile)//1
{ 

//#if -1742101407 
file = new File(uri);
//#endif 


//#if 579095601 
if(!file.exists())//1
{ 

//#if 1577865873 
int response = JOptionPane.showConfirmDialog(
                                   this,
                                   Translator.localize(
                                       "optionpane.save-project-file-not-found"),
                                   Translator.localize(
                                       "optionpane.save-project-file-not-found-title"),
                                   JOptionPane.YES_NO_OPTION);
//#endif 


//#if 947320931 
if(response == JOptionPane.YES_OPTION)//1
{ 

//#if -1234765657 
saveNewFile = true;
//#endif 

} 
else
{ 

//#if 540522311 
return;
//#endif 

} 

//#endif 

} 

//#endif 

} 
else
{ 

//#if 1447112966 
saveNewFile = true;
//#endif 

} 

//#endif 


//#if -381936149 
if(saveNewFile)//1
{ 

//#if -1492831347 
file = getNewFile();
//#endif 


//#if 273130556 
if(file == null)//1
{ 

//#if 1955655705 
return;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2146721511 
trySaveWithProgressMonitor(overwrite, file);
//#endif 

} 

//#endif 


//#if -402478564 
@Override
    public Locale getLocale()
    { 

//#if -499607376 
return Locale.getDefault();
//#endif 

} 

//#endif 


//#if 1848931583 
public void showSaveIndicator()
    { 

//#if -1439751219 
titleHandler.buildTitle(null, null);
//#endif 

} 

//#endif 


//#if -1292596737 
private void testSimulateErrors()
    { 

//#if 571906607 
if(false)//1
{ 

//#if 666096727 
Layer lay =
                Globals.curEditor().getLayerManager().getActiveLayer();
//#endif 


//#if 280367824 
List figs = lay.getContentsNoEdges();
//#endif 


//#if -1324575355 
if(figs.size() > 0)//1
{ 

//#if 887170846 
Fig fig = (Fig) figs.get(0);
//#endif 


//#if -1798854564 
LOG.error("Setting owner of "
                          + fig.getClass().getName() + " to null");
//#endif 


//#if -53546391 
fig.setOwner(null);
//#endif 

} 

//#endif 


//#if -1323651834 
if(figs.size() > 1)//1
{ 

//#if 1011020506 
Fig fig = (Fig) figs.get(1);
//#endif 


//#if 1611950384 
fig.setLayer(null);
//#endif 

} 

//#endif 


//#if -1322728313 
if(figs.size() > 2)//1
{ 

//#if -975652702 
Fig fig = (Fig) figs.get(2);
//#endif 


//#if -355616597 
Object owner = fig.getOwner();
//#endif 


//#if -1765756851 
Model.getUmlFactory().delete(owner);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -797529679 
private void saveScreenConfiguration()
    { 

//#if -599071843 
if(explorerPane != null)//1
{ 

//#if -68196609 
Configuration.setInteger(Argo.KEY_SCREEN_WEST_WIDTH,
                                     explorerPane.getWidth());
//#endif 

} 

//#endif 


//#if 527198299 
if(eastPane != null)//1
{ 

//#if -605774318 
Configuration.setInteger(Argo.KEY_SCREEN_EAST_WIDTH,
                                     eastPane.getWidth());
//#endif 

} 

//#endif 


//#if -1978088147 
if(northPane != null)//1
{ 

//#if -1841933306 
Configuration.setInteger(Argo.KEY_SCREEN_NORTH_HEIGHT,
                                     northPane.getHeight());
//#endif 

} 

//#endif 


//#if -2140518411 
if(southPane != null)//1
{ 

//#if 1319746854 
Configuration.setInteger(Argo.KEY_SCREEN_SOUTH_HEIGHT,
                                     southPane.getHeight());
//#endif 

} 

//#endif 


//#if 342735076 
if(todoPane != null)//1
{ 

//#if -288220202 
Configuration.setInteger(Argo.KEY_SCREEN_SOUTHWEST_WIDTH,
                                     todoPane.getWidth());
//#endif 

} 

//#endif 


//#if 917506130 
if(southEastPane != null)//1
{ 

//#if -1970893305 
Configuration.setInteger(Argo.KEY_SCREEN_SOUTHEAST_WIDTH,
                                     southEastPane.getWidth());
//#endif 

} 

//#endif 


//#if -1294563396 
if(northWestPane != null)//1
{ 

//#if 888865019 
Configuration.setInteger(Argo.KEY_SCREEN_NORTHWEST_WIDTH,
                                     northWestPane.getWidth());
//#endif 

} 

//#endif 


//#if -1645401718 
if(northEastPane != null)//1
{ 

//#if -1722422624 
Configuration.setInteger(Argo.KEY_SCREEN_NORTHEAST_WIDTH,
                                     northEastPane.getWidth());
//#endif 

} 

//#endif 


//#if -512519517 
boolean maximized = getExtendedState() == MAXIMIZED_BOTH;
//#endif 


//#if -1807988374 
if(!maximized)//1
{ 

//#if -1386197846 
Configuration.setInteger(Argo.KEY_SCREEN_WIDTH, getWidth());
//#endif 


//#if -338386964 
Configuration.setInteger(Argo.KEY_SCREEN_HEIGHT, getHeight());
//#endif 


//#if 1474005504 
Configuration.setInteger(Argo.KEY_SCREEN_LEFT_X, getX());
//#endif 


//#if -1882330540 
Configuration.setInteger(Argo.KEY_SCREEN_TOP_Y, getY());
//#endif 

} 

//#endif 


//#if -733148594 
Configuration.setBoolean(Argo.KEY_SCREEN_MAXIMIZED,
                                 maximized);
//#endif 

} 

//#endif 


//#if 225551267 
public void tryExit()
    { 

//#if -395578374 
if(saveAction != null && saveAction.isEnabled())//1
{ 

//#if 1887323658 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -209563297 
String t =
                MessageFormat.format(Translator.localize(
                                         "optionpane.exit-save-changes-to"),
                                     new Object[] {p.getName()});
//#endif 


//#if -160014402 
int response =
                JOptionPane.showConfirmDialog(
                    this, t, t, JOptionPane.YES_NO_CANCEL_OPTION);
//#endif 


//#if -777824763 
if(response == JOptionPane.CANCEL_OPTION
                    || response == JOptionPane.CLOSED_OPTION)//1
{ 

//#if -631935531 
return;
//#endif 

} 

//#endif 


//#if -712097364 
if(response == JOptionPane.YES_OPTION)//1
{ 

//#if -261824149 
trySave(ProjectManager.getManager().getCurrentProject() != null
                        && ProjectManager.getManager().getCurrentProject()
                        .getURI() != null);
//#endif 


//#if -925674610 
if(saveAction.isEnabled())//1
{ 

//#if 219638314 
return;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 895333305 
saveScreenConfiguration();
//#endif 


//#if 641631609 
Configuration.save();
//#endif 


//#if -34797589 
System.exit(0);
//#endif 

} 

//#endif 


//#if 1904647027 
public void setAppName(String n)
    { 

//#if 688054848 
appName = n;
//#endif 

} 

//#endif 


//#if 1153275595 
private void setTarget(Object o)
    { 

//#if 733668818 
TargetManager.getInstance().setTarget(o);
//#endif 

} 

//#endif 


//#if 1447429735 
public void loadProjectWithProgressMonitor(File file, boolean showUI)
    { 

//#if -1973830503 
LoadSwingWorker worker = new LoadSwingWorker(file, showUI);
//#endif 


//#if 86047833 
worker.start();
//#endif 

} 

//#endif 


//#if -1310138135 
public void addPanel(Component comp, Position position)
    { 

//#if -1096813258 
workAreaPane.add(comp, position.toString());
//#endif 

} 

//#endif 


//#if 1238943639 
protected File getNewFile()
    { 

//#if 119007072 
ProjectBrowser pb = ProjectBrowser.getInstance();
//#endif 


//#if 1813376696 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -658382961 
JFileChooser chooser = null;
//#endif 


//#if -1997587081 
URI uri = p.getURI();
//#endif 


//#if 722586810 
if(uri != null)//1
{ 

//#if -1586887454 
File projectFile = new File(uri);
//#endif 


//#if 2114697497 
if(projectFile.length() > 0)//1
{ 

//#if -63624162 
chooser = new JFileChooser(projectFile);
//#endif 

} 
else
{ 

//#if 378331753 
chooser = new JFileChooser();
//#endif 

} 

//#endif 


//#if -1945752071 
chooser.setSelectedFile(projectFile);
//#endif 

} 
else
{ 

//#if -1582248725 
chooser = new JFileChooser();
//#endif 

} 

//#endif 


//#if 2115058048 
String sChooserTitle =
            Translator.localize("filechooser.save-as-project");
//#endif 


//#if -1197656481 
chooser.setDialogTitle(sChooserTitle + " " + p.getName());
//#endif 


//#if 312837700 
chooser.setFileView(ProjectFileView.getInstance());
//#endif 


//#if 330165974 
chooser.setAcceptAllFileFilterUsed(false);
//#endif 


//#if -1817343779 
PersistenceManager.getInstance().setSaveFileChooserFilters(
            chooser,
            uri != null ? Util.URIToFilename(uri.toString()) : null);
//#endif 


//#if -581797637 
int retval = chooser.showSaveDialog(pb);
//#endif 


//#if 688028459 
if(retval == JFileChooser.APPROVE_OPTION)//1
{ 

//#if -2016108805 
File theFile = chooser.getSelectedFile();
//#endif 


//#if -66030240 
AbstractFilePersister filter =
                (AbstractFilePersister) chooser.getFileFilter();
//#endif 


//#if 454471932 
if(theFile != null)//1
{ 

//#if -845009299 
Configuration.setString(
                    PersistenceManager.KEY_PROJECT_NAME_PATH,
                    PersistenceManager.getInstance().getBaseName(
                        theFile.getPath()));
//#endif 


//#if -1199107782 
String name = theFile.getName();
//#endif 


//#if -848756636 
if(!name.endsWith("." + filter.getExtension()))//1
{ 

//#if 979531565 
theFile =
                        new File(
                        theFile.getParent(),
                        name + "." + filter.getExtension());
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1729840931 
PersistenceManager.getInstance().setSavePersister(filter);
//#endif 


//#if -839043091 
return theFile;
//#endif 

} 

//#endif 


//#if 2016876630 
return null;
//#endif 

} 

//#endif 


//#if -1013704142 
public void addFileSaved(File file) throws IOException
    { 

//#if 586687073 
GenericArgoMenuBar menu = (GenericArgoMenuBar) getJMenuBar();
//#endif 


//#if -1273604347 
if(menu != null)//1
{ 

//#if 1175298586 
menu.addFileSaved(file.getCanonicalPath());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1588908394 
public StatusBar getStatusBar()
    { 

//#if 57457449 
return statusBar;
//#endif 

} 

//#endif 


//#if 688993149 
public void targetAdded(TargetEvent e)
    { 

//#if 476458581 
targetChanged(e.getNewTarget());
//#endif 

} 

//#endif 


//#if -1102095139 
public void targetRemoved(TargetEvent e)
    { 

//#if -1576062566 
targetChanged(e.getNewTarget());
//#endif 

} 

//#endif 


//#if -1077369214 
private void addKeyboardFocusListener()
    { 

//#if 1278434460 
KeyboardFocusManager kfm =
            KeyboardFocusManager.getCurrentKeyboardFocusManager();
//#endif 


//#if -397728330 
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
//#endif 

} 

//#endif 


//#if -788663316 
private void reportError(ProgressMonitor monitor, final String message,
                             final String explanation, boolean showUI)
    { 

//#if 1148402415 
if(showUI)//1
{ 

//#if 711916887 
if(monitor != null)//1
{ 

//#if -1093361780 
monitor.notifyMessage(
                    Translator.localize("dialog.error.title"),
                    explanation,
                    message);
//#endif 

} 
else
{ 

//#if -164313314 
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
//#endif 

} 

//#endif 

} 
else
{ 

//#if 997063227 
reportError(monitor, message + "\n" + explanation + "\n\n",
                        showUI);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 299259470 
private void reportError(ProgressMonitor monitor, final String message,
                             boolean showUI)
    { 

//#if -410493159 
if(showUI)//1
{ 

//#if -2071781312 
if(monitor != null)//1
{ 

//#if -1762216038 
monitor.notifyMessage(
                    Translator.localize("dialog.error.title"),
                    Translator.localize("dialog.error.open.save.error"),
                    message);
//#endif 

} 
else
{ 

//#if -1911813789 
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
//#endif 

} 

//#endif 

} 
else
{ 

//#if 900270372 
System.err.print(message);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 283477394 
public JPanel getDetailsPane()
    { 

//#if -1326450668 
return southPane;
//#endif 

} 

//#endif 


//#if -251604701 
private void createDetailsPanes()
    { 

//#if 1253818236 
eastPane  =
            makeDetailsPane(BorderSplitPane.EAST,  Vertical.getInstance());
//#endif 


//#if 451008866 
southPane =
            makeDetailsPane(BorderSplitPane.SOUTH, Horizontal.getInstance());
//#endif 


//#if -945058872 
southEastPane =
            makeDetailsPane(BorderSplitPane.SOUTHEAST,
                            Horizontal.getInstance());
//#endif 


//#if -642695436 
northWestPane =
            makeDetailsPane(BorderSplitPane.NORTHWEST,
                            Horizontal.getInstance());
//#endif 


//#if 1691720434 
northPane =
            makeDetailsPane(BorderSplitPane.NORTH, Horizontal.getInstance());
//#endif 


//#if 1203691864 
northEastPane =
            makeDetailsPane(BorderSplitPane.NORTHEAST,
                            Horizontal.getInstance());
//#endif 


//#if -688235880 
if(southPane != null)//1
{ 

//#if -2106725691 
detailsPanesByCompassPoint.put(Position.South, southPane);
//#endif 

} 

//#endif 


//#if -874507915 
if(southEastPane != null)//1
{ 

//#if -1480112608 
detailsPanesByCompassPoint.put(Position.SouthEast,
                                           southEastPane);
//#endif 

} 

//#endif 


//#if 2098066776 
if(eastPane != null)//1
{ 

//#if -1670462209 
detailsPanesByCompassPoint.put(Position.East, eastPane);
//#endif 

} 

//#endif 


//#if 1208389855 
if(northWestPane != null)//1
{ 

//#if 480253419 
detailsPanesByCompassPoint.put(Position.NorthWest,
                                           northWestPane);
//#endif 

} 

//#endif 


//#if -525805616 
if(northPane != null)//1
{ 

//#if -1218377829 
detailsPanesByCompassPoint.put(Position.North, northPane);
//#endif 

} 

//#endif 


//#if 857551533 
if(northEastPane != null)//1
{ 

//#if -930444313 
detailsPanesByCompassPoint.put(Position.NorthEast,
                                           northEastPane);
//#endif 

} 

//#endif 


//#if 2000870974 
Iterator it = detailsPanesByCompassPoint.entrySet().iterator();
//#endif 


//#if -729290419 
while (it.hasNext()) //1
{ 

//#if 1346513167 
TargetManager.getInstance().addTargetListener(
                (DetailsPane) ((Map.Entry) it.next()).getValue());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1573980847 
public void propertyChange(PropertyChangeEvent evt)
    { 

//#if -140277539 
if(evt.getPropertyName()
                .equals(ProjectManager.CURRENT_PROJECT_PROPERTY_NAME))//1
{ 

//#if 200944964 
Project p = (Project) evt.getNewValue();
//#endif 


//#if 1996198020 
if(p != null)//1
{ 

//#if -1808212716 
titleHandler.buildTitle(p.getName(), null);
//#endif 


//#if 1963147803 
Designer.setCritiquingRoot(p);
//#endif 


//#if -1216575190 
TargetManager.getInstance().setTarget(p.getInitialTarget());
//#endif 

} 

//#endif 


//#if -1326545033 
ArgoEventPump.fireEvent(new ArgoStatusEvent(
                                        ArgoEventTypes.STATUS_PROJECT_LOADED, this, p.getName()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 562504252 
public void removePanel(Component comp)
    { 

//#if -1615253769 
workAreaPane.remove(comp);
//#endif 


//#if 1562354774 
workAreaPane.validate();
//#endif 


//#if -132430499 
workAreaPane.repaint();
//#endif 

} 

//#endif 


//#if 125391013 
private int getSavedWidth(ConfigurationKey width)
    { 

//#if -745397489 
return Configuration.getInteger(width, DEFAULT_COMPONENTWIDTH);
//#endif 

} 

//#endif 


//#if -1662652379 
public static ProjectBrowser makeInstance(SplashScreen splash,
            boolean mainApplication, JPanel leftBottomPane)
    { 

//#if -666219166 
return new ProjectBrowser("ArgoUML", splash,
                                  mainApplication, leftBottomPane);
//#endif 

} 

//#endif 


//#if 1364086200 
private ProjectBrowser(String applicationName, SplashScreen splash,
                           boolean mainApplication, JPanel leftBottomPane)
    { 

//#if -531310880 
super(applicationName);
//#endif 


//#if 1237380038 
theInstance = this;
//#endif 


//#if -954525964 
isMainApplication = mainApplication;
//#endif 


//#if -1408979575 
getContentPane().setFont(defaultFont);
//#endif 


//#if -1667782678 
saveAction = new ActionSaveProject();
//#endif 


//#if -150615212 
ProjectManager.getManager().setSaveAction(saveAction);
//#endif 


//#if 1871645428 
createPanels(splash, leftBottomPane);
//#endif 


//#if 1714010026 
if(isMainApplication)//1
{ 

//#if 480043724 
menuBar = new GenericArgoMenuBar();
//#endif 


//#if 1012406392 
getContentPane().setLayout(new BorderLayout());
//#endif 


//#if -1586798969 
this.setJMenuBar(menuBar);
//#endif 


//#if 214251665 
getContentPane().add(assemblePanels(), BorderLayout.CENTER);
//#endif 


//#if -973170773 
JPanel bottom = new JPanel();
//#endif 


//#if -1129633257 
bottom.setLayout(new BorderLayout());
//#endif 


//#if 1679423447 
bottom.add(statusBar, BorderLayout.CENTER);
//#endif 


//#if -1840943449 
bottom.add(new HeapMonitor(), BorderLayout.EAST);
//#endif 


//#if -44339028 
getContentPane().add(bottom, BorderLayout.SOUTH);
//#endif 


//#if 2132472764 
setAppName(applicationName);
//#endif 


//#if 1727683934 
setDefaultCloseOperation(ProjectBrowser.DO_NOTHING_ON_CLOSE);
//#endif 


//#if 998639501 
addWindowListener(new WindowCloser());
//#endif 


//#if 973592582 
setApplicationIcon();
//#endif 


//#if -494706329 
ProjectManager.getManager().addPropertyChangeListener(this);
//#endif 


//#if -327181677 
TargetManager.getInstance().addTargetListener(this);
//#endif 


//#if 1635795689 
addKeyboardFocusListener();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1830514117 
private void setApplicationIcon()
    { 

//#if 581660886 
final ImageIcon argoImage16x16 =
            ResourceLoaderWrapper.lookupIconResource("ArgoIcon16x16");
//#endif 


//#if 1704170384 
if(JavaRuntimeUtility.isJre5())//1
{ 

//#if -613528444 
setIconImage(argoImage16x16.getImage());
//#endif 

} 
else
{ 

//#if 1420175806 
final ImageIcon argoImage32x32 =
                ResourceLoaderWrapper.lookupIconResource("ArgoIcon32x32");
//#endif 


//#if -707321165 
final List<Image> argoImages = new ArrayList<Image>(2);
//#endif 


//#if 837361468 
argoImages.add(argoImage16x16.getImage());
//#endif 


//#if -1532683908 
argoImages.add(argoImage32x32.getImage());
//#endif 


//#if -596523322 
try //1
{ 

//#if 1881042966 
final Method m =
                    getClass().getMethod("setIconImages", List.class);
//#endif 


//#if 1802072142 
m.invoke(this, argoImages);
//#endif 

} 

//#if -648974322 
catch (InvocationTargetException e) //1
{ 

//#if 841818318 
LOG.error("Exception", e);
//#endif 

} 

//#endif 


//#if -128425482 
catch (NoSuchMethodException e) //1
{ 

//#if 111914208 
LOG.error("Exception", e);
//#endif 

} 

//#endif 


//#if -1717078302 
catch (IllegalArgumentException e) //1
{ 

//#if 246584690 
LOG.error("Exception", e);
//#endif 

} 

//#endif 


//#if -1079409911 
catch (IllegalAccessException e) //1
{ 

//#if -2125959108 
LOG.error("Exception", e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if -44703684 
@Deprecated
    public void setToDoItem(Object o)
    { 

//#if -2014608504 
Iterator it = detailsPanesByCompassPoint.values().iterator();
//#endif 


//#if -2110172219 
while (it.hasNext()) //1
{ 

//#if -672463782 
DetailsPane detailsPane = (DetailsPane) it.next();
//#endif 


//#if -526962446 
if(detailsPane.setToDoItem(o))//1
{ 

//#if 682135110 
return;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 716062575 
public boolean loadProject(File file, boolean showUI,
                               ProgressMonitor pmw)
    { 

//#if 1908988832 
LOG.info("Loading project.");
//#endif 


//#if -1512628024 
PersistenceManager pm = PersistenceManager.getInstance();
//#endif 


//#if -649427843 
Project oldProject = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 1385245309 
if(oldProject != null)//1
{ 

//#if -1837757201 
Project p = ProjectManager.getManager().makeEmptyProject();
//#endif 


//#if 573195983 
ProjectManager.getManager().setCurrentProject(p);
//#endif 


//#if -1167177500 
ProjectManager.getManager().removeProject(oldProject);
//#endif 


//#if -710303227 
oldProject = p;
//#endif 

} 

//#endif 


//#if -560333041 
boolean success = false;
//#endif 


//#if 1946760827 
Designer.disableCritiquing();
//#endif 


//#if 939509046 
Designer.clearCritiquing();
//#endif 


//#if -1186234991 
clearDialogs();
//#endif 


//#if 1277063298 
Project project = null;
//#endif 


//#if -1680009867 
if(!(file.canRead()))//1
{ 

//#if 1993663140 
reportError(pmw, "File not found " + file + ".", showUI);
//#endif 


//#if 284543217 
Designer.enableCritiquing();
//#endif 


//#if 252271742 
success = false;
//#endif 

} 
else
{ 

//#if -1043144682 
final AbstractAction rememberedSaveAction = this.saveAction;
//#endif 


//#if 455949356 
this.saveAction = null;
//#endif 


//#if -1449453290 
ProjectManager.getManager().setSaveAction(null);
//#endif 


//#if 898013028 
try //1
{ 

//#if 1614461541 
ProjectFilePersister persister =
                    pm.getPersisterFromFileName(file.getName());
//#endif 


//#if 1026405093 
if(persister == null)//1
{ 

//#if -1172231558 
throw new IllegalStateException("Filename "
                                                    + file.getName()
                                                    + " is not of a known file type");
//#endif 

} 

//#endif 


//#if 551957658 
if(pmw != null)//1
{ 

//#if 1383810379 
persister.addProgressListener(pmw);
//#endif 

} 

//#endif 


//#if -767800780 
project = persister.doLoad(file);
//#endif 


//#if -2059110441 
if(pmw != null)//2
{ 

//#if -543875532 
persister.removeProgressListener(pmw);
//#endif 

} 

//#endif 


//#if 1272865654 
ThreadUtils.checkIfInterrupted();
//#endif 


//#if 2127225980 
this.addFileSaved(file);
//#endif 


//#if -21159794 
Configuration.setString(Argo.KEY_MOST_RECENT_PROJECT_FILE,
                                        file.getCanonicalPath());
//#endif 


//#if -3310824 
updateStatus(
                    Translator.localize(
                        "statusmsg.bar.open-project-status-read",
                        new Object[] {file.getName(), }));
//#endif 


//#if -1925000173 
success = true;
//#endif 

} 

//#if -303704198 
catch (VersionException ex) //1
{ 

//#if -1321723535 
reportError(
                    pmw,
                    Translator.localize(
                        "dialog.error.file.version.error",
                        new Object[] {ex.getMessage()}),
                    showUI);
//#endif 

} 

//#endif 


//#if -960245915 
catch (OutOfMemoryError ex) //1
{ 

//#if -1219340246 
LOG.error("Out of memory while loading project", ex);
//#endif 


//#if 101872538 
reportError(
                    pmw,
                    Translator.localize("dialog.error.memory.limit"),
                    showUI);
//#endif 

} 

//#endif 


//#if 46853892 
catch (java.lang.InterruptedException ex) //1
{ 

//#if -1840807438 
LOG.error("Project loading interrupted by user");
//#endif 

} 

//#endif 


//#if 1361100062 
catch (UmlVersionException ex) //1
{ 

//#if 1134939985 
reportError(
                    pmw,
                    Translator.localize(
                        "dialog.error.file.version.error",
                        new Object[] {ex.getMessage()}),
                    showUI, ex);
//#endif 

} 

//#endif 


//#if -930626361 
catch (XmiFormatException ex) //1
{ 

//#if -815891047 
if(ex.getCause() instanceof XmiReferenceException)//1
{ 

//#if -1465101162 
String reference =
                        ((XmiReferenceException) ex.getCause()).getReference();
//#endif 


//#if -966107586 
reportError(
                        pmw,
                        Translator.localize(
                            "dialog.error.xmi.reference.error",
                            new Object[] {reference, ex.getMessage()}),
                        ex.toString(),
                        showUI);
//#endif 

} 
else
{ 

//#if 1437150573 
reportError(
                        pmw,
                        Translator.localize(
                            "dialog.error.xmi.format.error",
                            new Object[] {ex.getMessage()}),
                        showUI, ex);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1944201532 
catch (IOException ex) //1
{ 

//#if -1324718786 
LOG.error("Exception while loading project", ex);
//#endif 


//#if -873823781 
reportError(
                    pmw,
                    Translator.localize(
                        "dialog.error.open.error",
                        new Object[] {file.getName()}),
                    showUI, ex);
//#endif 

} 

//#endif 


//#if 2022566264 
catch (OpenException ex) //1
{ 

//#if -1292882352 
LOG.error("Exception while loading project", ex);
//#endif 


//#if -1451722487 
reportError(
                    pmw,
                    Translator.localize(
                        "dialog.error.open.error",
                        new Object[] {file.getName()}),
                    showUI, ex);
//#endif 

} 

//#endif 


//#if 1024246906 
catch (RuntimeException ex) //1
{ 

//#if -14296550 
LOG.error("Exception while loading project", ex);
//#endif 


//#if 946433151 
reportError(
                    pmw,
                    Translator.localize(
                        "dialog.error.open.error",
                        new Object[] {file.getName()}),
                    showUI, ex);
//#endif 

} 

//#endif 

finally { 

//#if 272898831 
try //1
{ 

//#if 925713617 
if(!success)//1
{ 

//#if -1169018768 
project =
                            ProjectManager.getManager().makeEmptyProject();
//#endif 

} 

//#endif 


//#if 237982245 
ProjectManager.getManager().setCurrentProject(project);
//#endif 


//#if -1603638076 
if(oldProject != null)//1
{ 

//#if 1479335089 
ProjectManager.getManager().removeProject(oldProject);
//#endif 

} 

//#endif 


//#if 1867247580 
project.getProjectSettings().init();
//#endif 


//#if -1049587677 
Command cmd = new NonUndoableCommand() {
                        public Object execute() {
                            // This is temporary. Load project
                            // should create a new project
                            // with its own UndoManager and so
                            // there should be no Command
                            return null;
                        }
                    };
//#endif 


//#if -611895569 
project.getUndoManager().addCommand(cmd);
//#endif 


//#if -1154740433 
LOG.info("There are " + project.getDiagramList().size()
                             + " diagrams in the current project");
//#endif 


//#if -1072522711 
Designer.enableCritiquing();
//#endif 

} 
finally { 

//#if -1855173510 
this.saveAction = rememberedSaveAction;
//#endif 


//#if -281538186 
SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            ProjectManager.getManager().setSaveAction(
                                rememberedSaveAction);
                            rememberedSaveAction.setEnabled(false);
                        }
                    });
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1861339923 
return success;
//#endif 

} 

//#endif 


//#if -1927098989 
public void buildTitleWithCurrentProjectName()
    { 

//#if -2107298597 
titleHandler.buildTitle(
            ProjectManager.getManager().getCurrentProject().getName(),
            null);
//#endif 

} 

//#endif 


//#if -1488086627 
private Dimension getSavedDimensions(ConfigurationKey width,
                                         ConfigurationKey height)
    { 

//#if 551536754 
return new Dimension(getSavedWidth(width), getSavedHeight(height));
//#endif 

} 

//#endif 


//#if 1210157632 
@Deprecated
    public AbstractArgoJPanel getTab(Class tabClass)
    { 

//#if -1103693026 
for (DetailsPane detailsPane : detailsPanesByCompassPoint.values())  //1
{ 

//#if 1656981816 
AbstractArgoJPanel tab = detailsPane.getTab(tabClass);
//#endif 


//#if 1513061658 
if(tab != null)//1
{ 

//#if 1660856043 
return tab;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1931950983 
throw new IllegalStateException("No " + tabClass.getName()
                                        + " tab found");
//#endif 

} 

//#endif 


//#if -1690467992 
public JPanel getTodoPane()
    { 

//#if 853572244 
return todoPane;
//#endif 

} 

//#endif 


//#if -749011222 
public void trySaveWithProgressMonitor(boolean overwrite, File file)
    { 

//#if -90267865 
SaveSwingWorker worker = new SaveSwingWorker(overwrite, file);
//#endif 


//#if -511425706 
Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
//#endif 


//#if -591383273 
worker.start();
//#endif 

} 

//#endif 


//#if 1633831403 
public String getAppName()
    { 

//#if -1047059555 
return appName;
//#endif 

} 

//#endif 


//#if -866571690 
private Component assemblePanels()
    { 

//#if -446254376 
addPanel(editorPane, Position.Center);
//#endif 


//#if -630110460 
addPanel(explorerPane, Position.West);
//#endif 


//#if 502776228 
addPanel(todoPane, Position.SouthWest);
//#endif 


//#if -1875895865 
for (Map.Entry<Position, DetailsPane> entry
                : detailsPanesByCompassPoint.entrySet()) //1
{ 

//#if -1964477305 
Position position = entry.getKey();
//#endif 


//#if 1596151015 
addPanel(entry.getValue(), position);
//#endif 

} 

//#endif 


//#if -364722490 
final JPanel toolbarBoundary = new JPanel();
//#endif 


//#if -872839595 
toolbarBoundary.setLayout(new DockBorderLayout());
//#endif 


//#if 997865520 
final String toolbarPosition = BorderLayout.NORTH;
//#endif 


//#if 789480928 
toolbarBoundary.add(menuBar.getFileToolbar(), toolbarPosition);
//#endif 


//#if -1223285614 
toolbarBoundary.add(menuBar.getEditToolbar(), toolbarPosition);
//#endif 


//#if 1260277527 
toolbarBoundary.add(menuBar.getViewToolbar(), toolbarPosition);
//#endif 


//#if 1442990361 
toolbarBoundary.add(menuBar.getCreateDiagramToolbar(),
                            toolbarPosition);
//#endif 


//#if 263545963 
toolbarBoundary.add(workAreaPane, BorderLayout.CENTER);
//#endif 


//#if -2081869041 
ArgoToolbarManager.getInstance().registerToolbar(
            menuBar.getFileToolbar(), menuBar.getFileToolbar(), 0);
//#endif 


//#if -184470768 
ArgoToolbarManager.getInstance().registerToolbar(
            menuBar.getEditToolbar(), menuBar.getEditToolbar(), 1);
//#endif 


//#if 833781361 
ArgoToolbarManager.getInstance().registerToolbar(
            menuBar.getViewToolbar(), menuBar.getViewToolbar(), 2);
//#endif 


//#if 47812220 
ArgoToolbarManager.getInstance().registerToolbar(
            menuBar.getCreateDiagramToolbar(),
            menuBar.getCreateDiagramToolbar(), 3);
//#endif 


//#if -1239225726 
final JToolBar[] toolbars = new JToolBar[] {menuBar.getFileToolbar(),
                menuBar.getEditToolbar(), menuBar.getViewToolbar(),
                menuBar.getCreateDiagramToolbar()
                                                   };
//#endif 


//#if -2097255375 
for (JToolBar toolbar : toolbars) //1
{ 

//#if 1408581094 
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
//#endif 

} 

//#endif 


//#if -1784379576 
return toolbarBoundary;
//#endif 

} 

//#endif 


//#if 1249807696 
private boolean isFileReadonly(File file)
    { 

//#if 1327521221 
try //1
{ 

//#if -1251775765 
return (file == null)
                   || (file.exists() && !file.canWrite())
                   || (!file.exists() && !file.createNewFile());
//#endif 

} 

//#if 7255578 
catch (IOException ioExc) //1
{ 

//#if -2054461950 
return true;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -892177063 
private DetailsPane makeDetailsPane(String compassPoint,
                                        Orientation orientation)
    { 

//#if 1680544757 
DetailsPane detailsPane =
            new DetailsPane(compassPoint.toLowerCase(), orientation);
//#endif 


//#if 927133296 
if(!detailsPane.hasTabs())//1
{ 

//#if 1029178903 
return null;
//#endif 

} 

//#endif 


//#if 1578041368 
return detailsPane;
//#endif 

} 

//#endif 


//#if -1045011736 
class WindowCloser extends 
//#if 771254568 
WindowAdapter
//#endif 

  { 

//#if 1937871991 
public void windowClosing(WindowEvent e)
        { 

//#if 1090114321 
tryExit();
//#endif 

} 

//#endif 


//#if -1453998421 
public WindowCloser()
        { 
} 

//#endif 

 } 

//#endif 


//#if 523838913 
private class TitleHandler implements 
//#if -548654611 
PropertyChangeListener
//#endif 

  { 

//#if 1113771292 
private ArgoDiagram monitoredDiagram = null;
//#endif 


//#if 1704122665 
protected void buildTitle(String projectFileName,
                                  ArgoDiagram activeDiagram)
        { 

//#if -769185091 
if(projectFileName == null || "".equals(projectFileName))//1
{ 

//#if 775966659 
if(ProjectManager.getManager().getCurrentProject() != null)//1
{ 

//#if 856133427 
projectFileName = ProjectManager.getManager()
                                      .getCurrentProject().getName();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1007152346 
if(activeDiagram == null)//1
{ 

//#if 1944937042 
activeDiagram = DiagramUtils.getActiveDiagram();
//#endif 

} 

//#endif 


//#if 23918743 
String changeIndicator = "";
//#endif 


//#if 466154993 
if(saveAction != null && saveAction.isEnabled())//1
{ 

//#if 1288820043 
changeIndicator = " *";
//#endif 

} 

//#endif 


//#if 200258498 
if(activeDiagram != null)//1
{ 

//#if -1969994936 
if(monitoredDiagram != null)//1
{ 

//#if 5906550 
monitoredDiagram.removePropertyChangeListener("name", this);
//#endif 

} 

//#endif 


//#if 1848551632 
activeDiagram.addPropertyChangeListener("name", this);
//#endif 


//#if -1672247799 
monitoredDiagram = activeDiagram;
//#endif 


//#if 1455276804 
setTitle(projectFileName + " - " + activeDiagram.getName()
                         + " - " + getAppName() + changeIndicator);
//#endif 

} 
else
{ 

//#if -1148791151 
setTitle(projectFileName + " - " + getAppName()
                         + changeIndicator);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -817897911 
public void propertyChange(PropertyChangeEvent evt)
        { 

//#if 655106786 
if(evt.getPropertyName().equals("name")
                    && evt.getSource() instanceof ArgoDiagram)//1
{ 

//#if -53239176 
buildTitle(
                    ProjectManager.getManager().getCurrentProject().getName(),
                    (ArgoDiagram) evt.getSource());
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#if -1360563474 
public enum Position {

//#if -274672419 
Center,

//#endif 


//#if 1387073405 
North,

//#endif 


//#if 1391693893 
South,

//#endif 


//#if -1063915899 
East,

//#endif 


//#if -1063375817 
West,

//#endif 


//#if 244310298 
NorthEast,

//#endif 


//#if -1835483678 
SouthEast,

//#endif 


//#if -1834943596 
SouthWest,

//#endif 


//#if 244850380 
NorthWest,

//#endif 

;
 } 

//#endif 

 } 

//#endif 


//#endif 

