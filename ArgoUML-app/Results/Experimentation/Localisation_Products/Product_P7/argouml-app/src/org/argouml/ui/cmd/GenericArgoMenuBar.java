package org.argouml.ui.cmd;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.i18n.Translator;
import org.argouml.ui.ActionExportXMI;
import org.argouml.ui.ActionImportXMI;
import org.argouml.ui.ActionProjectSettings;
import org.argouml.ui.ActionSettings;
import org.argouml.ui.ArgoJMenu;
import org.argouml.ui.ArgoToolbarManager;
import org.argouml.ui.ProjectActions;
import org.argouml.ui.ProjectBrowser;
import org.argouml.ui.ZoomSliderButton;
import org.argouml.ui.explorer.ActionPerspectiveConfig;
import org.argouml.ui.targetmanager.TargetEvent;
import org.argouml.ui.targetmanager.TargetListener;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.ui.ActionClassDiagram;
import org.argouml.uml.ui.ActionDeleteModelElements;
import org.argouml.uml.ui.ActionGenerateAll;
import org.argouml.uml.ui.ActionGenerateOne;
import org.argouml.uml.ui.ActionGenerateProjectCode;
import org.argouml.uml.ui.ActionGenerationSettings;
import org.argouml.uml.ui.ActionImportFromSources;
import org.argouml.uml.ui.ActionLayout;
import org.argouml.uml.ui.ActionOpenProject;
import org.argouml.uml.ui.ActionRevertToSaved;
import org.argouml.uml.ui.ActionSaveAllGraphics;
import org.argouml.uml.ui.ActionSaveGraphics;
import org.argouml.uml.ui.ActionSaveProjectAs;
import org.argouml.util.osdep.OSXAdapter;
import org.argouml.util.osdep.OsUtil;
import org.tigris.gef.base.AlignAction;
import org.tigris.gef.base.DistributeAction;
import org.tigris.gef.base.ReorderAction;
import org.tigris.toolbar.ToolBarFactory;
import org.apache.log4j.Logger;
import org.argouml.cognitive.critics.ui.ActionOpenCritics;
import org.argouml.cognitive.ui.ActionAutoCritique;
import org.argouml.cognitive.ui.ActionOpenDecisions;
import org.argouml.cognitive.ui.ActionOpenGoals;
import org.argouml.uml.ui.ActionCollaborationDiagram;
import org.argouml.uml.ui.ActionSequenceDiagram;
import org.argouml.uml.ui.ActionStateDiagram;
import org.argouml.uml.ui.ActionUseCaseDiagram;
import org.argouml.uml.ui.ActionActivityDiagram;
public class GenericArgoMenuBar extends JMenuBar
 implements TargetListener
  { 
private static List<JMenu> moduleMenus = new ArrayList<JMenu>();
private static List<Action> moduleCreateDiagramActions =
        new ArrayList<Action>();
private Collection<Action> disableableActions = new ArrayList<Action>();
public static final double ZOOM_FACTOR = 0.9;
private static final String MENU = "menu.";
private static final String MENUITEM = "menu.item.";
private JToolBar fileToolbar;
private JToolBar editToolbar;
private JToolBar viewToolbar;
private JToolBar createDiagramToolbar;
private LastRecentlyUsedMenuList mruList;
private JMenu edit;
private JMenu select;
private ArgoJMenu view;
private JMenu createDiagramMenu;
private JMenu tools;
private JMenu generate;
private ArgoJMenu arrange;
private JMenu help;
private Action navigateTargetForwardAction;
private Action navigateTargetBackAction;
private ActionSettings settingsAction;
private ActionAboutArgoUML aboutAction;
private ActionExit exitAction;
private ActionOpenProject openAction;
private static final long serialVersionUID = 2904074534530273119L;
private static final Logger LOG =
        Logger.getLogger(GenericArgoMenuBar.class);
private ArgoJMenu critique;
protected static final String menuLocalize(String key)
    { 
return Translator.localize(MENU + prepareKey(key));
} 
public void macAbout()
    { 
aboutAction.actionPerformed(null);
} 
public JMenu getCreateDiagramMenu()
    { 
return createDiagramMenu;
} 
protected static final void setMnemonic(JMenuItem item, String key)
    { 
String propertykey = "";
if(item instanceof JMenu)//1
{ 
propertykey = MENU + prepareKey(key) + ".mnemonic";
} 
else
{ 
propertykey = MENUITEM + prepareKey(key) + ".mnemonic";
} 
String localMnemonic = Translator.localize(propertykey);
char mnemonic = ' ';
if(localMnemonic != null && localMnemonic.length() == 1)//1
{ 
mnemonic = localMnemonic.charAt(0);
} 
item.setMnemonic(mnemonic);
} 
private void initModulesMenus()
    { 
for (JMenu menu : moduleMenus) //1
{ 
add(menu);
} 
} 
public JToolBar getEditToolbar()
    { 
if(editToolbar == null)//1
{ 
Collection<Action> c = new ArrayList<Action>();
for (Object mi : edit.getMenuComponents()) //1
{ 
if(mi instanceof JMenuItem)//1
{ 
if(((JMenuItem) mi).getIcon() != null)//1
{ 
c.add(((JMenuItem) mi).getAction());
} 
} 
} 
editToolbar = (new ToolBarFactory(c)).createToolBar();
editToolbar.setName(Translator.localize("misc.toolbar.edit"));
editToolbar.setFloatable(true);
} 
return editToolbar;
} 
protected void initMenus()
    { 
initMenuFile();
initMenuEdit();
initMenuView();
initMenuCreate();
initMenuArrange();
initMenuGeneration();
initMenuCritique();
initMenuTools();
initMenuHelp();
} 
public void targetRemoved(TargetEvent e)
    { 
setTarget();
} 
public void macOpenFile(String filename)
    { 
openAction.doCommand(filename);
} 
public JToolBar getFileToolbar()
    { 
return fileToolbar;
} 
private void initMenuGeneration()
    { 
generate = add(new JMenu(menuLocalize("Generation")));
setMnemonic(generate, "Generation");
JMenuItem genOne = generate.add(new ActionGenerateOne());
setMnemonic(genOne, "Generate Selected Classes");
ShortcutMgr.assignAccelerator(genOne, ShortcutMgr.ACTION_GENERATE_ONE);
JMenuItem genAllItem = generate.add(new ActionGenerateAll());
setMnemonic(genAllItem, "Generate all classes");
ShortcutMgr.assignAccelerator(genAllItem,
                                      ShortcutMgr.ACTION_GENERATE_ALL_CLASSES);
generate.addSeparator();
JMenuItem genProject = generate.add(new ActionGenerateProjectCode());
setMnemonic(genProject, "Generate code for project");
ShortcutMgr.assignAccelerator(genProject,
                                      ShortcutMgr.ACTION_GENERATE_PROJECT_CODE);
JMenuItem generationSettings = generate
                                       .add(new ActionGenerationSettings());
setMnemonic(generationSettings, "Settings for project code generation");
ShortcutMgr.assignAccelerator(generationSettings,
                                      ShortcutMgr.ACTION_GENERATION_SETTINGS);
} 
private void initMenuCritique()
    { 
critique =
            (ArgoJMenu) add(new ArgoJMenu(MENU + prepareKey("Critique")));
setMnemonic(critique, "Critique");
JMenuItem toggleAutoCritique = critique
                                       .addCheckItem(new ActionAutoCritique());
setMnemonic(toggleAutoCritique, "Toggle Auto Critique");
ShortcutMgr.assignAccelerator(toggleAutoCritique,
                                      ShortcutMgr.ACTION_AUTO_CRITIQUE);
critique.addSeparator();
JMenuItem designIssues = critique.add(new ActionOpenDecisions());
setMnemonic(designIssues, "Design Issues");
ShortcutMgr.assignAccelerator(designIssues,
                                      ShortcutMgr.ACTION_OPEN_DECISIONS);
JMenuItem designGoals = critique.add(new ActionOpenGoals());
setMnemonic(designGoals, "Design Goals");
ShortcutMgr.assignAccelerator(designGoals,
                                      ShortcutMgr.ACTION_OPEN_GOALS);
JMenuItem browseCritics = critique.add(new ActionOpenCritics());
setMnemonic(browseCritics, "Browse Critics");
ShortcutMgr.assignAccelerator(designIssues,
                                      ShortcutMgr.ACTION_OPEN_CRITICS);
} 
public static void registerCreateDiagramAction(Action action)
    { 
moduleCreateDiagramActions.add(action);
} 
private void initMenuArrange()
    { 
arrange = (ArgoJMenu) add(new ArgoJMenu(MENU + prepareKey("Arrange")));
setMnemonic(arrange, "Arrange");
JMenu align = (JMenu) arrange.add(new JMenu(menuLocalize("Align")));
setMnemonic(align, "Align");
JMenu distribute = (JMenu) arrange.add(new JMenu(
                menuLocalize("Distribute")));
setMnemonic(distribute, "Distribute");
JMenu reorder = (JMenu) arrange.add(new JMenu(menuLocalize("Reorder")));
setMnemonic(reorder, "Reorder");
JMenuItem preferredSize = arrange.add(new CmdSetPreferredSize());
setMnemonic(preferredSize, "Preferred Size");
ShortcutMgr.assignAccelerator(preferredSize,
                                      ShortcutMgr.ACTION_PREFERRED_SIZE);
Action layout = new ActionLayout();
disableableActions.add(layout);
arrange.add(layout);
initAlignMenu(align);
initDistributeMenu(distribute);
initReorderMenu(reorder);
} 
private static void initDistributeMenu(JMenu distribute)
    { 
DistributeAction a = new DistributeAction(
            DistributeAction.H_SPACING);
a.putValue(Action.SMALL_ICON,
                   ResourceLoaderWrapper.lookupIcon(
                       "DistributeHorizontalSpacing"));
JMenuItem distributeHSpacing = distribute.add(a);
setMnemonic(distributeHSpacing,
                    "distribute horizontal spacing");
ShortcutMgr.assignAccelerator(distributeHSpacing,
                                      ShortcutMgr.ACTION_DISTRIBUTE_H_SPACING);
a = new DistributeAction(
            DistributeAction.H_CENTERS);
a.putValue(Action.SMALL_ICON,
                   ResourceLoaderWrapper.lookupIcon(
                       "DistributeHorizontalCenters"));
JMenuItem distributeHCenters = distribute.add(a);
setMnemonic(distributeHCenters,
                    "distribute horizontal centers");
ShortcutMgr.assignAccelerator(distributeHCenters,
                                      ShortcutMgr.ACTION_DISTRIBUTE_H_CENTERS);
a = new DistributeAction(
            DistributeAction.V_SPACING);
a.putValue(Action.SMALL_ICON,
                   ResourceLoaderWrapper.lookupIcon("DistributeVerticalSpacing"));
JMenuItem distributeVSpacing = distribute.add(a);
setMnemonic(distributeVSpacing,
                    "distribute vertical spacing");
ShortcutMgr.assignAccelerator(distributeVSpacing,
                                      ShortcutMgr.ACTION_DISTRIBUTE_V_SPACING);
a = new DistributeAction(
            DistributeAction.V_CENTERS);
a.putValue(Action.SMALL_ICON,
                   ResourceLoaderWrapper.lookupIcon("DistributeVerticalCenters"));
JMenuItem distributeVCenters = distribute.add(a);
setMnemonic(distributeVCenters,
                    "distribute vertical centers");
ShortcutMgr.assignAccelerator(distributeVCenters,
                                      ShortcutMgr.ACTION_DISTRIBUTE_V_CENTERS);
} 
private void setTarget()
    { 
SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                for (Action action : disableableActions) {
                    action.setEnabled(action.isEnabled());
                }
            }
        });
} 
public JMenu getTools()
    { 
return tools;
} 
static final String menuItemLocalize(String key)
    { 
return Translator.localize(MENUITEM + prepareKey(key));
} 
public void macPreferences()
    { 
settingsAction.actionPerformed(null);
} 
private static void initAlignMenu(JMenu align)
    { 
AlignAction a = new AlignAction(AlignAction.ALIGN_TOPS);
a.putValue(Action.SMALL_ICON,
                   ResourceLoaderWrapper.lookupIcon("AlignTops"));
JMenuItem alignTops = align.add(a);
setMnemonic(alignTops, "align tops");
ShortcutMgr.assignAccelerator(alignTops, ShortcutMgr.ACTION_ALIGN_TOPS);
a = new AlignAction(
            AlignAction.ALIGN_BOTTOMS);
a.putValue(Action.SMALL_ICON,
                   ResourceLoaderWrapper.lookupIcon("AlignBottoms"));
JMenuItem alignBottoms = align.add(a);
setMnemonic(alignBottoms, "align bottoms");
ShortcutMgr.assignAccelerator(alignBottoms,
                                      ShortcutMgr.ACTION_ALIGN_BOTTOMS);
a = new AlignAction(
            AlignAction.ALIGN_RIGHTS);
a.putValue(Action.SMALL_ICON,
                   ResourceLoaderWrapper.lookupIcon("AlignRights"));
JMenuItem alignRights = align.add(a);
setMnemonic(alignRights, "align rights");
ShortcutMgr.assignAccelerator(alignRights,
                                      ShortcutMgr.ACTION_ALIGN_RIGHTS);
a = new AlignAction(
            AlignAction.ALIGN_LEFTS);
a.putValue(Action.SMALL_ICON,
                   ResourceLoaderWrapper.lookupIcon("AlignLefts"));
JMenuItem alignLefts = align.add(a);
setMnemonic(alignLefts, "align lefts");
ShortcutMgr.assignAccelerator(alignLefts,
                                      ShortcutMgr.ACTION_ALIGN_LEFTS);
a = new AlignAction(
            AlignAction.ALIGN_H_CENTERS);
a.putValue(Action.SMALL_ICON,
                   ResourceLoaderWrapper.lookupIcon("AlignHorizontalCenters"));
JMenuItem alignHCenters = align.add(a);
setMnemonic(alignHCenters,
                    "align horizontal centers");
ShortcutMgr.assignAccelerator(alignHCenters,
                                      ShortcutMgr.ACTION_ALIGN_H_CENTERS);
a = new AlignAction(
            AlignAction.ALIGN_V_CENTERS);
a.putValue(Action.SMALL_ICON,
                   ResourceLoaderWrapper.lookupIcon("AlignVerticalCenters"));
JMenuItem alignVCenters = align.add(a);
setMnemonic(alignVCenters, "align vertical centers");
ShortcutMgr.assignAccelerator(alignVCenters,
                                      ShortcutMgr.ACTION_ALIGN_V_CENTERS);
a = new AlignAction(
            AlignAction.ALIGN_TO_GRID);
a.putValue(Action.SMALL_ICON,
                   ResourceLoaderWrapper.lookupIcon("AlignToGrid"));
JMenuItem alignToGrid = align.add(a);
setMnemonic(alignToGrid, "align to grid");
ShortcutMgr.assignAccelerator(alignToGrid,
                                      ShortcutMgr.ACTION_ALIGN_TO_GRID);
} 
public JToolBar getCreateDiagramToolbar()
    { 
return createDiagramToolbar;
} 
private static void initReorderMenu(JMenu reorder)
    { 
JMenuItem reorderBringForward = reorder.add(new ReorderAction(
                                            Translator.localize("action.bring-forward"),
                                            ResourceLoaderWrapper.lookupIcon("Forward"),
                                            ReorderAction.BRING_FORWARD));
setMnemonic(reorderBringForward,
                    "reorder bring forward");
ShortcutMgr.assignAccelerator(reorderBringForward,
                                      ShortcutMgr.ACTION_REORDER_FORWARD);
JMenuItem reorderSendBackward = reorder.add(new ReorderAction(
                                            Translator.localize("action.send-backward"),
                                            ResourceLoaderWrapper.lookupIcon("Backward"),
                                            ReorderAction.SEND_BACKWARD));
setMnemonic(reorderSendBackward,
                    "reorder send backward");
ShortcutMgr.assignAccelerator(reorderSendBackward,
                                      ShortcutMgr.ACTION_REORDER_BACKWARD);
JMenuItem reorderBringToFront = reorder.add(new ReorderAction(
                                            Translator.localize("action.bring-to-front"),
                                            ResourceLoaderWrapper.lookupIcon("ToFront"),
                                            ReorderAction.BRING_TO_FRONT));
setMnemonic(reorderBringToFront,
                    "reorder bring to front");
ShortcutMgr.assignAccelerator(reorderBringToFront,
                                      ShortcutMgr.ACTION_REORDER_TO_FRONT);
JMenuItem reorderSendToBack = reorder.add(new ReorderAction(
                                          Translator.localize("action.send-to-back"),
                                          ResourceLoaderWrapper.lookupIcon("ToBack"),
                                          ReorderAction.SEND_TO_BACK));
setMnemonic(reorderSendToBack,
                    "reorder send to back");
ShortcutMgr.assignAccelerator(reorderSendToBack,
                                      ShortcutMgr.ACTION_REORDER_TO_BACK);
} 
public GenericArgoMenuBar()
    { 
initActions();
initMenus();
initModulesUI();
registerForMacEvents();
} 
private void initMenuCreate()
    { 
Collection<Action> toolbarTools = new ArrayList<Action>();
createDiagramMenu = add(new JMenu(menuLocalize("Create Diagram")));
setMnemonic(createDiagramMenu, "Create Diagram");
JMenuItem usecaseDiagram = createDiagramMenu
                                   .add(new ActionUseCaseDiagram());
setMnemonic(usecaseDiagram, "Usecase Diagram");
toolbarTools.add((new ActionUseCaseDiagram()));
ShortcutMgr.assignAccelerator(usecaseDiagram,
                                      ShortcutMgr.ACTION_USE_CASE_DIAGRAM);
JMenuItem classDiagram =
            createDiagramMenu.add(new ActionClassDiagram());
setMnemonic(classDiagram, "Class Diagram");
toolbarTools.add((new ActionClassDiagram()));
ShortcutMgr.assignAccelerator(classDiagram,
                                      ShortcutMgr.ACTION_CLASS_DIAGRAM);
JMenuItem sequenzDiagram =
            createDiagramMenu.add(new ActionSequenceDiagram());
setMnemonic(sequenzDiagram, "Sequenz Diagram");
toolbarTools.add((new ActionSequenceDiagram()));
ShortcutMgr.assignAccelerator(sequenzDiagram,
                                      ShortcutMgr.ACTION_SEQUENCE_DIAGRAM);
JMenuItem collaborationDiagram =
            createDiagramMenu.add(new ActionCollaborationDiagram());
setMnemonic(collaborationDiagram, "Collaboration Diagram");
toolbarTools.add((new ActionCollaborationDiagram()));
ShortcutMgr.assignAccelerator(collaborationDiagram,
                                      ShortcutMgr.ACTION_COLLABORATION_DIAGRAM);
JMenuItem stateDiagram =
            createDiagramMenu.add(new ActionStateDiagram());
setMnemonic(stateDiagram, "Statechart Diagram");
toolbarTools.add((new ActionStateDiagram()));
ShortcutMgr.assignAccelerator(stateDiagram,
                                      ShortcutMgr.ACTION_STATE_DIAGRAM);
JMenuItem activityDiagram =
            createDiagramMenu.add(new ActionActivityDiagram());
setMnemonic(activityDiagram, "Activity Diagram");
toolbarTools.add((new ActionActivityDiagram()));
ShortcutMgr.assignAccelerator(activityDiagram,
                                      ShortcutMgr.ACTION_ACTIVITY_DIAGRAM);
createDiagramToolbar =
            (new ToolBarFactory(toolbarTools)).createToolBar();
createDiagramToolbar.setName(
            Translator.localize("misc.toolbar.create-diagram"));
createDiagramToolbar.setFloatable(true);
} 
private void initModulesActions()
    { 
for (Action action : moduleCreateDiagramActions) //1
{ 
createDiagramToolbar.add(action);
} 
} 
private void initModulesUI ()
    { 
initModulesMenus();
initModulesActions();
} 
private void registerForMacEvents()
    { 
if(OsUtil.isMacOSX())//1
{ 
try//1
{ 
OSXAdapter.setQuitHandler(this, getClass().getDeclaredMethod(
                                              "macQuit", (Class[]) null));
OSXAdapter.setAboutHandler(this, getClass().getDeclaredMethod(
                                               "macAbout", (Class[]) null));
OSXAdapter.setPreferencesHandler(this, getClass()
                                                 .getDeclaredMethod("macPreferences", (Class[]) null));
OSXAdapter.setFileHandler(this, getClass().getDeclaredMethod(
                                              "macOpenFile", new Class[] {String.class}));
} 
catch (Exception e) //1
{ 
LOG.error("Error while loading the OSXAdapter:", e);
} 
} 
} 
public void addFileSaved(String filename)
    { 
mruList.addEntry(filename);
} 
private void initActions()
    { 
navigateTargetForwardAction = new NavigateTargetForwardAction();
disableableActions.add(navigateTargetForwardAction);
navigateTargetBackAction = new NavigateTargetBackAction();
disableableActions.add(navigateTargetBackAction);
TargetManager.getInstance().addTargetListener(this);
} 
private static String prepareKey(String str)
    { 
return str.toLowerCase().replace(' ', '-');
} 
private void initMenuHelp()
    { 
help = new JMenu(menuLocalize("Help"));
setMnemonic(help, "Help");
if(help.getItemCount() > 0)//1
{ 
help.insertSeparator(0);
} 
JMenuItem argoHelp = help.add(new ActionHelp());
setMnemonic(argoHelp, "ArgoUML help");
ShortcutMgr.assignAccelerator(argoHelp, ShortcutMgr.ACTION_HELP);
help.addSeparator();
JMenuItem systemInfo = help.add(new ActionSystemInfo());
setMnemonic(systemInfo, "System Information");
ShortcutMgr.assignAccelerator(systemInfo,
                                      ShortcutMgr.ACTION_SYSTEM_INFORMATION);
aboutAction = new ActionAboutArgoUML();
if(!OsUtil.isMacOSX())//1
{ 
help.addSeparator();
JMenuItem aboutArgoUML = help.add(aboutAction);
setMnemonic(aboutArgoUML, "About ArgoUML");
ShortcutMgr.assignAccelerator(aboutArgoUML,
                                          ShortcutMgr.ACTION_ABOUT_ARGOUML);
} 
add(help);
} 
public static void registerMenuItem(JMenu menu)
    { 
moduleMenus.add(menu);
} 
private void initMenuView()
    { 
view = (ArgoJMenu) add(new ArgoJMenu(MENU + prepareKey("View")));
setMnemonic(view, "View");
JMenuItem gotoDiagram = view.add(new ActionGotoDiagram());
setMnemonic(gotoDiagram, "Goto-Diagram");
ShortcutMgr.assignAccelerator(gotoDiagram,
                                      ShortcutMgr.ACTION_GO_TO_DIAGRAM);
JMenuItem findItem = view.add(new ActionFind());
setMnemonic(findItem, "Find");
ShortcutMgr.assignAccelerator(findItem, ShortcutMgr.ACTION_FIND);
view.addSeparator();
JMenu zoom = (JMenu) view.add(new JMenu(menuLocalize("Zoom")));
setMnemonic(zoom, "Zoom");
ZoomActionProxy zoomOutAction = new ZoomActionProxy(ZOOM_FACTOR);
JMenuItem zoomOut = zoom.add(zoomOutAction);
setMnemonic(zoomOut, "Zoom Out");
ShortcutMgr.assignAccelerator(zoomOut, ShortcutMgr.ACTION_ZOOM_OUT);
JMenuItem zoomReset = zoom.add(new ZoomActionProxy(0.0));
setMnemonic(zoomReset, "Zoom Reset");
ShortcutMgr.assignAccelerator(zoomReset, ShortcutMgr.ACTION_ZOOM_RESET);
ZoomActionProxy zoomInAction =
            new ZoomActionProxy((1.0) / (ZOOM_FACTOR));
JMenuItem zoomIn = zoom.add(zoomInAction);
setMnemonic(zoomIn, "Zoom In");
ShortcutMgr.assignAccelerator(zoomIn, ShortcutMgr.ACTION_ZOOM_IN);
view.addSeparator();
JMenu grid = (JMenu) view.add(new JMenu(menuLocalize("Adjust Grid")));
setMnemonic(grid, "Grid");
List<Action> gridActions =
            ActionAdjustGrid.createAdjustGridActions(false);
ButtonGroup groupGrid = new ButtonGroup();
ActionAdjustGrid.setGroup(groupGrid);
for ( Action cmdAG : gridActions) //1
{ 
JRadioButtonMenuItem mi = new JRadioButtonMenuItem(cmdAG);
groupGrid.add(mi);
JMenuItem adjustGrid = grid.add(mi);
setMnemonic(adjustGrid, (String) cmdAG.getValue(Action.NAME));
ShortcutMgr.assignAccelerator(adjustGrid,
                                          ShortcutMgr.ACTION_ADJUST_GRID + cmdAG.getValue("ID"));
} 
JMenu snap = (JMenu) view.add(new JMenu(menuLocalize("Adjust Snap")));
setMnemonic(snap, "Snap");
List<Action> snapActions = ActionAdjustSnap.createAdjustSnapActions();
ButtonGroup groupSnap = new ButtonGroup();
ActionAdjustSnap.setGroup(groupSnap);
for ( Action cmdAS : snapActions) //1
{ 
JRadioButtonMenuItem mi = new JRadioButtonMenuItem(cmdAS);
groupSnap.add(mi);
JMenuItem adjustSnap = snap.add(mi);
setMnemonic(adjustSnap, (String) cmdAS.getValue(Action.NAME));
ShortcutMgr.assignAccelerator(adjustSnap,
                                          ShortcutMgr.ACTION_ADJUST_GUIDE + cmdAS.getValue("ID"));
} 
Action pba  = new ActionAdjustPageBreaks();
JMenuItem adjustPageBreaks = view.add(pba);
setMnemonic(adjustPageBreaks, "Adjust Pagebreaks");
ShortcutMgr.assignAccelerator(adjustPageBreaks,
                                      ShortcutMgr.ACTION_ADJUST_PAGE_BREAKS);
view.addSeparator();
JMenu menuToolbars = ArgoToolbarManager.getInstance().getMenu();
menuToolbars.setText(menuLocalize("toolbars"));
setMnemonic(menuToolbars, "toolbars");
view.add(menuToolbars);
view.addSeparator();
JMenuItem showSaved = view.add(new ActionShowXMLDump());
setMnemonic(showSaved, "Show Saved");
ShortcutMgr.assignAccelerator(showSaved,
                                      ShortcutMgr.ACTION_SHOW_XML_DUMP);
} 
public void targetAdded(TargetEvent e)
    { 
setTarget();
} 
public JToolBar getViewToolbar()
    { 
if(viewToolbar == null)//1
{ 
Collection<Object> c = new ArrayList<Object>();
c.add(new ActionFind());
c.add(new ZoomSliderButton());
viewToolbar = (new ToolBarFactory(c)).createToolBar();
viewToolbar.setName(Translator.localize("misc.toolbar.view"));
viewToolbar.setFloatable(true);
} 
return viewToolbar;
} 
public void targetSet(TargetEvent e)
    { 
setTarget();
} 
private void initMenuEdit()
    { 
edit = add(new JMenu(menuLocalize("Edit")));
setMnemonic(edit, "Edit");
select = new JMenu(menuLocalize("Select"));
setMnemonic(select, "Select");
edit.add(select);
JMenuItem selectAllItem = select.add(new ActionSelectAll());
setMnemonic(selectAllItem, "Select All");
ShortcutMgr.assignAccelerator(selectAllItem,
                                      ShortcutMgr.ACTION_SELECT_ALL);
select.addSeparator();
JMenuItem backItem = select.add(navigateTargetBackAction);
setMnemonic(backItem, "Navigate Back");
ShortcutMgr.assignAccelerator(backItem,
                                      ShortcutMgr.ACTION_NAVIGATE_BACK);
JMenuItem forwardItem = select.add(navigateTargetForwardAction);
setMnemonic(forwardItem, "Navigate Forward");
ShortcutMgr.assignAccelerator(forwardItem,
                                      ShortcutMgr.ACTION_NAVIGATE_FORWARD);
select.addSeparator();
JMenuItem selectInvert = select.add(new ActionSelectInvert());
setMnemonic(selectInvert, "Invert Selection");
ShortcutMgr.assignAccelerator(selectInvert,
                                      ShortcutMgr.ACTION_SELECT_INVERT);
edit.addSeparator();
Action removeFromDiagram = ProjectActions.getInstance()
                                   .getRemoveFromDiagramAction();
JMenuItem removeItem = edit.add(removeFromDiagram);
setMnemonic(removeItem, "Remove from Diagram");
ShortcutMgr.assignAccelerator(removeItem,
                                      ShortcutMgr.ACTION_REMOVE_FROM_DIAGRAM);
JMenuItem deleteItem = edit.add(ActionDeleteModelElements
                                        .getTargetFollower());
setMnemonic(deleteItem, "Delete from Model");
ShortcutMgr.assignAccelerator(deleteItem,
                                      ShortcutMgr.ACTION_DELETE_MODEL_ELEMENTS);
edit.addSeparator();
ShortcutMgr.assignAccelerator(edit.add(new ActionPerspectiveConfig()),
                                      ShortcutMgr.ACTION_PERSPECTIVE_CONFIG);
settingsAction = new ActionSettings();
if(!OsUtil.isMacOSX())//1
{ 
JMenuItem settingsItem = edit.add(settingsAction);
setMnemonic(settingsItem, "Settings");
ShortcutMgr.assignAccelerator(settingsItem,
                                          ShortcutMgr.ACTION_SETTINGS);
} 
} 
private void initMenuTools()
    { 
tools = new JMenu(menuLocalize("Tools"));
setMnemonic(tools, "Tools");
add(tools);
} 
public void macQuit()
    { 
exitAction.actionPerformed(null);
} 
private void initMenuFile()
    { 
Collection<Action> toolbarTools = new ArrayList<Action>();
JMenu file = new JMenu(menuLocalize("File"));
add(file);
setMnemonic(file, "File");
JMenuItem newItem = file.add(new ActionNew());
setMnemonic(newItem, "New");
ShortcutMgr.assignAccelerator(newItem, ShortcutMgr.ACTION_NEW_PROJECT);
toolbarTools.add((new ActionNew()));
openAction = new ActionOpenProject();
JMenuItem openProjectItem = file.add(openAction);
setMnemonic(openProjectItem, "Open");
ShortcutMgr.assignAccelerator(openProjectItem,
                                      ShortcutMgr.ACTION_OPEN_PROJECT);
toolbarTools.add(new ActionOpenProject());
file.addSeparator();
JMenuItem saveProjectItem = file.add(ProjectBrowser.getInstance()
                                             .getSaveAction());
setMnemonic(saveProjectItem, "Save");
ShortcutMgr.assignAccelerator(saveProjectItem,
                                      ShortcutMgr.ACTION_SAVE_PROJECT);
toolbarTools.add((ProjectBrowser.getInstance().getSaveAction()));
JMenuItem saveProjectAsItem = file.add(new ActionSaveProjectAs());
setMnemonic(saveProjectAsItem, "SaveAs");
ShortcutMgr.assignAccelerator(saveProjectAsItem,
                                      ShortcutMgr.ACTION_SAVE_PROJECT_AS);
JMenuItem revertToSavedItem = file.add(new ActionRevertToSaved());
setMnemonic(revertToSavedItem, "Revert To Saved");
ShortcutMgr.assignAccelerator(revertToSavedItem,
                                      ShortcutMgr.ACTION_REVERT_TO_SAVED);
file.addSeparator();
ShortcutMgr.assignAccelerator(file.add(new ActionImportXMI()),
                                      ShortcutMgr.ACTION_IMPORT_XMI);
ShortcutMgr.assignAccelerator(file.add(new ActionExportXMI()),
                                      ShortcutMgr.ACTION_EXPORT_XMI);
JMenuItem importFromSources = file.add(ActionImportFromSources
                                               .getInstance());
setMnemonic(importFromSources, "Import");
ShortcutMgr.assignAccelerator(importFromSources,
                                      ShortcutMgr.ACTION_IMPORT_FROM_SOURCES);
file.addSeparator();
Action a = new ActionProjectSettings();
toolbarTools.add(a);
JMenuItem pageSetupItem = file.add(new ActionPageSetup());
setMnemonic(pageSetupItem, "PageSetup");
ShortcutMgr.assignAccelerator(pageSetupItem,
                                      ShortcutMgr.ACTION_PAGE_SETUP);
JMenuItem printItem = file.add(new ActionPrint());
setMnemonic(printItem, "Print");
ShortcutMgr.assignAccelerator(printItem, ShortcutMgr.ACTION_PRINT);
toolbarTools.add((new ActionPrint()));
JMenuItem saveGraphicsItem = file.add(new ActionSaveGraphics());
setMnemonic(saveGraphicsItem, "SaveGraphics");
ShortcutMgr.assignAccelerator(saveGraphicsItem,
                                      ShortcutMgr.ACTION_SAVE_GRAPHICS);
ShortcutMgr.assignAccelerator(file.add(new ActionSaveAllGraphics()),
                                      ShortcutMgr.ACTION_SAVE_ALL_GRAPHICS);
file.addSeparator();
JMenu notation = (JMenu) file.add(new ActionNotation().getMenu());
setMnemonic(notation, "Notation");
JMenuItem propertiesItem = file.add(new ActionProjectSettings());
setMnemonic(propertiesItem, "Properties");
ShortcutMgr.assignAccelerator(propertiesItem,
                                      ShortcutMgr.ACTION_PROJECT_SETTINGS);
file.addSeparator();
mruList = new LastRecentlyUsedMenuList(file);
exitAction = new ActionExit();
if(!OsUtil.isMacOSX())//1
{ 
file.addSeparator();
JMenuItem exitItem = file.add(exitAction);
setMnemonic(exitItem, "Exit");
exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,
                                    InputEvent.ALT_MASK));
} 
fileToolbar = (new ToolBarFactory(toolbarTools)).createToolBar();
fileToolbar.setName(Translator.localize("misc.toolbar.file"));
fileToolbar.setFloatable(true);
} 

 } 
