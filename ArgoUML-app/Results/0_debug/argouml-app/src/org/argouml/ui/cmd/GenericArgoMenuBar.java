
//#if 1078834694 
// Compilation Unit of /GenericArgoMenuBar.java 
 

//#if -676522864 
package org.argouml.ui.cmd;
//#endif 


//#if -1843348136 
import java.awt.event.InputEvent;
//#endif 


//#if 1307287405 
import java.awt.event.KeyEvent;
//#endif 


//#if 1288508225 
import java.util.ArrayList;
//#endif 


//#if -1666319808 
import java.util.Collection;
//#endif 


//#if 218062464 
import java.util.List;
//#endif 


//#if 312814528 
import javax.swing.Action;
//#endif 


//#if 1848377683 
import javax.swing.ButtonGroup;
//#endif 


//#if 2048109079 
import javax.swing.JMenu;
//#endif 


//#if 912470860 
import javax.swing.JMenuBar;
//#endif 


//#if -1771154620 
import javax.swing.JMenuItem;
//#endif 


//#if 557158433 
import javax.swing.JRadioButtonMenuItem;
//#endif 


//#if 532660997 
import javax.swing.JToolBar;
//#endif 


//#if -84137783 
import javax.swing.KeyStroke;
//#endif 


//#if 1415436298 
import javax.swing.SwingUtilities;
//#endif 


//#if -1987016598 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 483933547 
import org.argouml.i18n.Translator;
//#endif 


//#if -2030889647 
import org.argouml.ui.ActionExportXMI;
//#endif 


//#if -114813758 
import org.argouml.ui.ActionImportXMI;
//#endif 


//#if -900046411 
import org.argouml.ui.ActionProjectSettings;
//#endif 


//#if -2012052254 
import org.argouml.ui.ActionSettings;
//#endif 


//#if 1900482731 
import org.argouml.ui.ArgoJMenu;
//#endif 


//#if -569007440 
import org.argouml.ui.ArgoToolbarManager;
//#endif 


//#if 349625111 
import org.argouml.ui.ProjectActions;
//#endif 


//#if -1904984500 
import org.argouml.ui.ProjectBrowser;
//#endif 


//#if 915957781 
import org.argouml.ui.ZoomSliderButton;
//#endif 


//#if 1421636930 
import org.argouml.ui.explorer.ActionPerspectiveConfig;
//#endif 


//#if -1818737788 
import org.argouml.ui.targetmanager.TargetEvent;
//#endif 


//#if 2040678532 
import org.argouml.ui.targetmanager.TargetListener;
//#endif 


//#if 89861137 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -1930559452 
import org.argouml.uml.ui.ActionClassDiagram;
//#endif 


//#if -1809209790 
import org.argouml.uml.ui.ActionDeleteModelElements;
//#endif 


//#if 242227339 
import org.argouml.uml.ui.ActionGenerateAll;
//#endif 


//#if 242646118 
import org.argouml.uml.ui.ActionGenerateOne;
//#endif 


//#if -890775258 
import org.argouml.uml.ui.ActionGenerateProjectCode;
//#endif 


//#if 1945933828 
import org.argouml.uml.ui.ActionGenerationSettings;
//#endif 


//#if -538108082 
import org.argouml.uml.ui.ActionImportFromSources;
//#endif 


//#if -13791723 
import org.argouml.uml.ui.ActionLayout;
//#endif 


//#if 13913960 
import org.argouml.uml.ui.ActionOpenProject;
//#endif 


//#if 1492080303 
import org.argouml.uml.ui.ActionRevertToSaved;
//#endif 


//#if 2060987720 
import org.argouml.uml.ui.ActionSaveAllGraphics;
//#endif 


//#if -1671519529 
import org.argouml.uml.ui.ActionSaveGraphics;
//#endif 


//#if -242634359 
import org.argouml.uml.ui.ActionSaveProjectAs;
//#endif 


//#if 986791339 
import org.argouml.util.osdep.OSXAdapter;
//#endif 


//#if -885822944 
import org.argouml.util.osdep.OsUtil;
//#endif 


//#if 1610975642 
import org.tigris.gef.base.AlignAction;
//#endif 


//#if -1918567350 
import org.tigris.gef.base.DistributeAction;
//#endif 


//#if 1409892452 
import org.tigris.gef.base.ReorderAction;
//#endif 


//#if -974747588 
import org.tigris.toolbar.ToolBarFactory;
//#endif 


//#if -1632679362 
import org.apache.log4j.Logger;
//#endif 


//#if 26275865 
import org.argouml.cognitive.critics.ui.ActionOpenCritics;
//#endif 


//#if 109502712 
import org.argouml.cognitive.ui.ActionAutoCritique;
//#endif 


//#if 1004215984 
import org.argouml.cognitive.ui.ActionOpenDecisions;
//#endif 


//#if -1839517145 
import org.argouml.cognitive.ui.ActionOpenGoals;
//#endif 


//#if 723398641 
import org.argouml.uml.ui.ActionCollaborationDiagram;
//#endif 


//#if -1192964759 
import org.argouml.uml.ui.ActionDeploymentDiagram;
//#endif 


//#if 1282346341 
import org.argouml.uml.ui.ActionSequenceDiagram;
//#endif 


//#if -1959333315 
import org.argouml.uml.ui.ActionStateDiagram;
//#endif 


//#if 1771995139 
import org.argouml.uml.ui.ActionUseCaseDiagram;
//#endif 


//#if -1669768525 
import org.argouml.uml.ui.ActionActivityDiagram;
//#endif 


//#if 1348003579 
public class GenericArgoMenuBar extends 
//#if -1153409292 
JMenuBar
//#endif 

 implements 
//#if 555916911 
TargetListener
//#endif 

  { 

//#if 335290881 
private static List<JMenu> moduleMenus = new ArrayList<JMenu>();
//#endif 


//#if 1312995997 
private static List<Action> moduleCreateDiagramActions =
        new ArrayList<Action>();
//#endif 


//#if -1447397448 
private Collection<Action> disableableActions = new ArrayList<Action>();
//#endif 


//#if -260170328 
public static final double ZOOM_FACTOR = 0.9;
//#endif 


//#if -1311842716 
private static final String MENU = "menu.";
//#endif 


//#if -1031373764 
private static final String MENUITEM = "menu.item.";
//#endif 


//#if -1402086074 
private JToolBar fileToolbar;
//#endif 


//#if -1888819244 
private JToolBar editToolbar;
//#endif 


//#if -430577297 
private JToolBar viewToolbar;
//#endif 


//#if 1928017197 
private JToolBar createDiagramToolbar;
//#endif 


//#if -1593946050 
private LastRecentlyUsedMenuList mruList;
//#endif 


//#if -415303455 
private JMenu edit;
//#endif 


//#if -103517137 
private JMenu select;
//#endif 


//#if 2123820255 
private ArgoJMenu view;
//#endif 


//#if 531942741 
private JMenu createDiagramMenu;
//#endif 


//#if 450263632 
private JMenu tools;
//#endif 


//#if 1307248342 
private JMenu generate;
//#endif 


//#if -922217786 
private ArgoJMenu arrange;
//#endif 


//#if -412500342 
private JMenu help;
//#endif 


//#if -1104318415 
private Action navigateTargetForwardAction;
//#endif 


//#if 305114509 
private Action navigateTargetBackAction;
//#endif 


//#if -41203664 
private ActionSettings settingsAction;
//#endif 


//#if 1352962805 
private ActionAboutArgoUML aboutAction;
//#endif 


//#if 1782307450 
private ActionExit exitAction;
//#endif 


//#if -335580005 
private ActionOpenProject openAction;
//#endif 


//#if -1379403214 
private static final long serialVersionUID = 2904074534530273119L;
//#endif 


//#if 1301715752 
private static final Logger LOG =
        Logger.getLogger(GenericArgoMenuBar.class);
//#endif 


//#if -996836846 
private ArgoJMenu critique;
//#endif 


//#if 119416934 
protected static final String menuLocalize(String key)
    { 

//#if 1141366822 
return Translator.localize(MENU + prepareKey(key));
//#endif 

} 

//#endif 


//#if 1790530982 
public void macAbout()
    { 

//#if 1607572376 
aboutAction.actionPerformed(null);
//#endif 

} 

//#endif 


//#if -320492201 
public JMenu getCreateDiagramMenu()
    { 

//#if -98408666 
return createDiagramMenu;
//#endif 

} 

//#endif 


//#if 1206328404 
protected static final void setMnemonic(JMenuItem item, String key)
    { 

//#if -62136980 
String propertykey = "";
//#endif 


//#if 1474285202 
if(item instanceof JMenu)//1
{ 

//#if -581129633 
propertykey = MENU + prepareKey(key) + ".mnemonic";
//#endif 

} 
else
{ 

//#if 992863907 
propertykey = MENUITEM + prepareKey(key) + ".mnemonic";
//#endif 

} 

//#endif 


//#if 1471786309 
String localMnemonic = Translator.localize(propertykey);
//#endif 


//#if 372149057 
char mnemonic = ' ';
//#endif 


//#if 1703279169 
if(localMnemonic != null && localMnemonic.length() == 1)//1
{ 

//#if 1211269499 
mnemonic = localMnemonic.charAt(0);
//#endif 

} 

//#endif 


//#if -237147384 
item.setMnemonic(mnemonic);
//#endif 

} 

//#endif 


//#if -1173890485 
private void initModulesMenus()
    { 

//#if 501755673 
for (JMenu menu : moduleMenus) //1
{ 

//#if -588973027 
add(menu);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1985288928 
public JToolBar getEditToolbar()
    { 

//#if -1668853079 
if(editToolbar == null)//1
{ 

//#if -1031087874 
Collection<Action> c = new ArrayList<Action>();
//#endif 


//#if -933020837 
for (Object mi : edit.getMenuComponents()) //1
{ 

//#if -961392552 
if(mi instanceof JMenuItem)//1
{ 

//#if 1256719162 
if(((JMenuItem) mi).getIcon() != null)//1
{ 

//#if 1542147093 
c.add(((JMenuItem) mi).getAction());
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -957087962 
editToolbar = (new ToolBarFactory(c)).createToolBar();
//#endif 


//#if -860470802 
editToolbar.setName(Translator.localize("misc.toolbar.edit"));
//#endif 


//#if -1299215422 
editToolbar.setFloatable(true);
//#endif 

} 

//#endif 


//#if -1981454098 
return editToolbar;
//#endif 

} 

//#endif 


//#if -2052294483 
protected void initMenus()
    { 

//#if 366331703 
initMenuFile();
//#endif 


//#if -666641431 
initMenuEdit();
//#endif 


//#if 1675560302 
initMenuView();
//#endif 


//#if 1825118583 
initMenuCreate();
//#endif 


//#if -2144253259 
initMenuArrange();
//#endif 


//#if 115988315 
initMenuGeneration();
//#endif 


//#if 949901793 
initMenuCritique();
//#endif 


//#if -1774438426 
initMenuTools();
//#endif 


//#if 2027150162 
initMenuHelp();
//#endif 

} 

//#endif 


//#if 940857325 
public void targetRemoved(TargetEvent e)
    { 

//#if -619693904 
setTarget();
//#endif 

} 

//#endif 


//#if 1319346775 
public void macOpenFile(String filename)
    { 

//#if -518926026 
openAction.doCommand(filename);
//#endif 

} 

//#endif 


//#if 218537454 
public JToolBar getFileToolbar()
    { 

//#if 1379136927 
return fileToolbar;
//#endif 

} 

//#endif 


//#if 1082017973 
private void initMenuGeneration()
    { 

//#if 176291942 
generate = add(new JMenu(menuLocalize("Generation")));
//#endif 


//#if 1838712777 
setMnemonic(generate, "Generation");
//#endif 


//#if 885044607 
JMenuItem genOne = generate.add(new ActionGenerateOne());
//#endif 


//#if 959621714 
setMnemonic(genOne, "Generate Selected Classes");
//#endif 


//#if 340205169 
ShortcutMgr.assignAccelerator(genOne, ShortcutMgr.ACTION_GENERATE_ONE);
//#endif 


//#if 507991720 
JMenuItem genAllItem = generate.add(new ActionGenerateAll());
//#endif 


//#if 130849208 
setMnemonic(genAllItem, "Generate all classes");
//#endif 


//#if 1385897057 
ShortcutMgr.assignAccelerator(genAllItem,
                                      ShortcutMgr.ACTION_GENERATE_ALL_CLASSES);
//#endif 


//#if 452257729 
generate.addSeparator();
//#endif 


//#if -1374240462 
JMenuItem genProject = generate.add(new ActionGenerateProjectCode());
//#endif 


//#if -1833005093 
setMnemonic(genProject, "Generate code for project");
//#endif 


//#if -1248987399 
ShortcutMgr.assignAccelerator(genProject,
                                      ShortcutMgr.ACTION_GENERATE_PROJECT_CODE);
//#endif 


//#if -540602930 
JMenuItem generationSettings = generate
                                       .add(new ActionGenerationSettings());
//#endif 


//#if 846185187 
setMnemonic(generationSettings, "Settings for project code generation");
//#endif 


//#if 207465524 
ShortcutMgr.assignAccelerator(generationSettings,
                                      ShortcutMgr.ACTION_GENERATION_SETTINGS);
//#endif 

} 

//#endif 


//#if 617959087 
private void initMenuCritique()
    { 

//#if -540811669 
critique =
            (ArgoJMenu) add(new ArgoJMenu(MENU + prepareKey("Critique")));
//#endif 


//#if -1104605662 
setMnemonic(critique, "Critique");
//#endif 


//#if 1989294040 
JMenuItem toggleAutoCritique = critique
                                       .addCheckItem(new ActionAutoCritique());
//#endif 


//#if 1216232796 
setMnemonic(toggleAutoCritique, "Toggle Auto Critique");
//#endif 


//#if 2099023106 
ShortcutMgr.assignAccelerator(toggleAutoCritique,
                                      ShortcutMgr.ACTION_AUTO_CRITIQUE);
//#endif 


//#if -1316977650 
critique.addSeparator();
//#endif 


//#if -1746337232 
JMenuItem designIssues = critique.add(new ActionOpenDecisions());
//#endif 


//#if -588068330 
setMnemonic(designIssues, "Design Issues");
//#endif 


//#if 1726980169 
ShortcutMgr.assignAccelerator(designIssues,
                                      ShortcutMgr.ACTION_OPEN_DECISIONS);
//#endif 


//#if -1272703853 
JMenuItem designGoals = critique.add(new ActionOpenGoals());
//#endif 


//#if -494598030 
setMnemonic(designGoals, "Design Goals");
//#endif 


//#if -1194516348 
ShortcutMgr.assignAccelerator(designGoals,
                                      ShortcutMgr.ACTION_OPEN_GOALS);
//#endif 


//#if -1380609147 
JMenuItem browseCritics = critique.add(new ActionOpenCritics());
//#endif 


//#if -446564654 
setMnemonic(browseCritics, "Browse Critics");
//#endif 


//#if 1631544497 
ShortcutMgr.assignAccelerator(designIssues,
                                      ShortcutMgr.ACTION_OPEN_CRITICS);
//#endif 

} 

//#endif 


//#if 1015987114 
public static void registerCreateDiagramAction(Action action)
    { 

//#if 6233723 
moduleCreateDiagramActions.add(action);
//#endif 

} 

//#endif 


//#if 1661506193 
private void initMenuArrange()
    { 

//#if -198878403 
arrange = (ArgoJMenu) add(new ArgoJMenu(MENU + prepareKey("Arrange")));
//#endif 


//#if 34453278 
setMnemonic(arrange, "Arrange");
//#endif 


//#if -984495720 
JMenu align = (JMenu) arrange.add(new JMenu(menuLocalize("Align")));
//#endif 


//#if -84298818 
setMnemonic(align, "Align");
//#endif 


//#if 779496968 
JMenu distribute = (JMenu) arrange.add(new JMenu(
                menuLocalize("Distribute")));
//#endif 


//#if -1697389520 
setMnemonic(distribute, "Distribute");
//#endif 


//#if -994906068 
JMenu reorder = (JMenu) arrange.add(new JMenu(menuLocalize("Reorder")));
//#endif 


//#if 2045248062 
setMnemonic(reorder, "Reorder");
//#endif 


//#if -603513851 
JMenuItem preferredSize = arrange.add(new CmdSetPreferredSize());
//#endif 


//#if 2139857502 
setMnemonic(preferredSize, "Preferred Size");
//#endif 


//#if 295501860 
ShortcutMgr.assignAccelerator(preferredSize,
                                      ShortcutMgr.ACTION_PREFERRED_SIZE);
//#endif 


//#if -819261393 
Action layout = new ActionLayout();
//#endif 


//#if -593785650 
disableableActions.add(layout);
//#endif 


//#if -1744417043 
arrange.add(layout);
//#endif 


//#if 1563754555 
initAlignMenu(align);
//#endif 


//#if -1524798845 
initDistributeMenu(distribute);
//#endif 


//#if -2618073 
initReorderMenu(reorder);
//#endif 

} 

//#endif 


//#if 1866949788 
private static void initDistributeMenu(JMenu distribute)
    { 

//#if -130111254 
DistributeAction a = new DistributeAction(
            DistributeAction.H_SPACING);
//#endif 


//#if 882472945 
a.putValue(Action.SMALL_ICON,
                   ResourceLoaderWrapper.lookupIcon(
                       "DistributeHorizontalSpacing"));
//#endif 


//#if 876383171 
JMenuItem distributeHSpacing = distribute.add(a);
//#endif 


//#if 2084379659 
setMnemonic(distributeHSpacing,
                    "distribute horizontal spacing");
//#endif 


//#if -584972636 
ShortcutMgr.assignAccelerator(distributeHSpacing,
                                      ShortcutMgr.ACTION_DISTRIBUTE_H_SPACING);
//#endif 


//#if 566508238 
a = new DistributeAction(
            DistributeAction.H_CENTERS);
//#endif 


//#if 142056684 
a.putValue(Action.SMALL_ICON,
                   ResourceLoaderWrapper.lookupIcon(
                       "DistributeHorizontalCenters"));
//#endif 


//#if 366375272 
JMenuItem distributeHCenters = distribute.add(a);
//#endif 


//#if -735176149 
setMnemonic(distributeHCenters,
                    "distribute horizontal centers");
//#endif 


//#if 583057178 
ShortcutMgr.assignAccelerator(distributeHCenters,
                                      ShortcutMgr.ACTION_DISTRIBUTE_H_CENTERS);
//#endif 


//#if 884791713 
a = new DistributeAction(
            DistributeAction.V_SPACING);
//#endif 


//#if 400977823 
a.putValue(Action.SMALL_ICON,
                   ResourceLoaderWrapper.lookupIcon("DistributeVerticalSpacing"));
//#endif 


//#if 1454077521 
JMenuItem distributeVSpacing = distribute.add(a);
//#endif 


//#if -1001627889 
setMnemonic(distributeVSpacing,
                    "distribute vertical spacing");
//#endif 


//#if 954917604 
ShortcutMgr.assignAccelerator(distributeVSpacing,
                                      ShortcutMgr.ACTION_DISTRIBUTE_V_SPACING);
//#endif 


//#if 1178992988 
a = new DistributeAction(
            DistributeAction.V_CENTERS);
//#endif 


//#if -339438438 
a.putValue(Action.SMALL_ICON,
                   ResourceLoaderWrapper.lookupIcon("DistributeVerticalCenters"));
//#endif 


//#if 944069622 
JMenuItem distributeVCenters = distribute.add(a);
//#endif 


//#if 387760111 
setMnemonic(distributeVCenters,
                    "distribute vertical centers");
//#endif 


//#if 2122947418 
ShortcutMgr.assignAccelerator(distributeVCenters,
                                      ShortcutMgr.ACTION_DISTRIBUTE_V_CENTERS);
//#endif 

} 

//#endif 


//#if -1959185977 
private void setTarget()
    { 

//#if 1088785983 
SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                for (Action action : disableableActions) {
                    action.setEnabled(action.isEnabled());
                }
            }
        });
//#endif 

} 

//#endif 


//#if 1686071228 
public JMenu getTools()
    { 

//#if 1328021808 
return tools;
//#endif 

} 

//#endif 


//#if -1490958023 
static final String menuItemLocalize(String key)
    { 

//#if 1724767545 
return Translator.localize(MENUITEM + prepareKey(key));
//#endif 

} 

//#endif 


//#if 1289568337 
public void macPreferences()
    { 

//#if -997780364 
settingsAction.actionPerformed(null);
//#endif 

} 

//#endif 


//#if -1572915650 
private static void initAlignMenu(JMenu align)
    { 

//#if 1219501426 
AlignAction a = new AlignAction(AlignAction.ALIGN_TOPS);
//#endif 


//#if -2012695818 
a.putValue(Action.SMALL_ICON,
                   ResourceLoaderWrapper.lookupIcon("AlignTops"));
//#endif 


//#if -1466426196 
JMenuItem alignTops = align.add(a);
//#endif 


//#if -999515705 
setMnemonic(alignTops, "align tops");
//#endif 


//#if 901194663 
ShortcutMgr.assignAccelerator(alignTops, ShortcutMgr.ACTION_ALIGN_TOPS);
//#endif 


//#if 1016169307 
a = new AlignAction(
            AlignAction.ALIGN_BOTTOMS);
//#endif 


//#if 243376770 
a.putValue(Action.SMALL_ICON,
                   ResourceLoaderWrapper.lookupIcon("AlignBottoms"));
//#endif 


//#if -1584465978 
JMenuItem alignBottoms = align.add(a);
//#endif 


//#if -1229692683 
setMnemonic(alignBottoms, "align bottoms");
//#endif 


//#if 398818229 
ShortcutMgr.assignAccelerator(alignBottoms,
                                      ShortcutMgr.ACTION_ALIGN_BOTTOMS);
//#endif 


//#if -512147320 
a = new AlignAction(
            AlignAction.ALIGN_RIGHTS);
//#endif 


//#if -374869297 
a.putValue(Action.SMALL_ICON,
                   ResourceLoaderWrapper.lookupIcon("AlignRights"));
//#endif 


//#if -982013179 
JMenuItem alignRights = align.add(a);
//#endif 


//#if -1378476953 
setMnemonic(alignRights, "align rights");
//#endif 


//#if -2018673127 
ShortcutMgr.assignAccelerator(alignRights,
                                      ShortcutMgr.ACTION_ALIGN_RIGHTS);
//#endif 


//#if 1193644095 
a = new AlignAction(
            AlignAction.ALIGN_LEFTS);
//#endif 


//#if -1119405466 
a.putValue(Action.SMALL_ICON,
                   ResourceLoaderWrapper.lookupIcon("AlignLefts"));
//#endif 


//#if 1382634602 
JMenuItem alignLefts = align.add(a);
//#endif 


//#if 2146301293 
setMnemonic(alignLefts, "align lefts");
//#endif 


//#if 1038884213 
ShortcutMgr.assignAccelerator(alignLefts,
                                      ShortcutMgr.ACTION_ALIGN_LEFTS);
//#endif 


//#if 130925946 
a = new AlignAction(
            AlignAction.ALIGN_H_CENTERS);
//#endif 


//#if -1373019500 
a.putValue(Action.SMALL_ICON,
                   ResourceLoaderWrapper.lookupIcon("AlignHorizontalCenters"));
//#endif 


//#if -524583388 
JMenuItem alignHCenters = align.add(a);
//#endif 


//#if 562168625 
setMnemonic(alignHCenters,
                    "align horizontal centers");
//#endif 


//#if -46151222 
ShortcutMgr.assignAccelerator(alignHCenters,
                                      ShortcutMgr.ACTION_ALIGN_H_CENTERS);
//#endif 


//#if 743410696 
a = new AlignAction(
            AlignAction.ALIGN_V_CENTERS);
//#endif 


//#if -2097437630 
a.putValue(Action.SMALL_ICON,
                   ResourceLoaderWrapper.lookupIcon("AlignVerticalCenters"));
//#endif 


//#if 1007399638 
JMenuItem alignVCenters = align.add(a);
//#endif 


//#if -1551177263 
setMnemonic(alignVCenters, "align vertical centers");
//#endif 


//#if -1769196698 
ShortcutMgr.assignAccelerator(alignVCenters,
                                      ShortcutMgr.ACTION_ALIGN_V_CENTERS);
//#endif 


//#if -650176035 
a = new AlignAction(
            AlignAction.ALIGN_TO_GRID);
//#endif 


//#if 1293251673 
a.putValue(Action.SMALL_ICON,
                   ResourceLoaderWrapper.lookupIcon("AlignToGrid"));
//#endif 


//#if 100681743 
JMenuItem alignToGrid = align.add(a);
//#endif 


//#if -1763038137 
setMnemonic(alignToGrid, "align to grid");
//#endif 


//#if 582441890 
ShortcutMgr.assignAccelerator(alignToGrid,
                                      ShortcutMgr.ACTION_ALIGN_TO_GRID);
//#endif 

} 

//#endif 


//#if 1259095223 
public JToolBar getCreateDiagramToolbar()
    { 

//#if 240193546 
return createDiagramToolbar;
//#endif 

} 

//#endif 


//#if -1502368834 
private static void initReorderMenu(JMenu reorder)
    { 

//#if -238955836 
JMenuItem reorderBringForward = reorder.add(new ReorderAction(
                                            Translator.localize("action.bring-forward"),
                                            ResourceLoaderWrapper.lookupIcon("Forward"),
                                            ReorderAction.BRING_FORWARD));
//#endif 


//#if 1060645209 
setMnemonic(reorderBringForward,
                    "reorder bring forward");
//#endif 


//#if 1552732473 
ShortcutMgr.assignAccelerator(reorderBringForward,
                                      ShortcutMgr.ACTION_REORDER_FORWARD);
//#endif 


//#if -2016604414 
JMenuItem reorderSendBackward = reorder.add(new ReorderAction(
                                            Translator.localize("action.send-backward"),
                                            ResourceLoaderWrapper.lookupIcon("Backward"),
                                            ReorderAction.SEND_BACKWARD));
//#endif 


//#if -997156199 
setMnemonic(reorderSendBackward,
                    "reorder send backward");
//#endif 


//#if -1860969813 
ShortcutMgr.assignAccelerator(reorderSendBackward,
                                      ShortcutMgr.ACTION_REORDER_BACKWARD);
//#endif 


//#if 108464450 
JMenuItem reorderBringToFront = reorder.add(new ReorderAction(
                                            Translator.localize("action.bring-to-front"),
                                            ResourceLoaderWrapper.lookupIcon("ToFront"),
                                            ReorderAction.BRING_TO_FRONT));
//#endif 


//#if -2133144167 
setMnemonic(reorderBringToFront,
                    "reorder bring to front");
//#endif 


//#if 1040170942 
ShortcutMgr.assignAccelerator(reorderBringToFront,
                                      ShortcutMgr.ACTION_REORDER_TO_FRONT);
//#endif 


//#if -200858326 
JMenuItem reorderSendToBack = reorder.add(new ReorderAction(
                                          Translator.localize("action.send-to-back"),
                                          ResourceLoaderWrapper.lookupIcon("ToBack"),
                                          ReorderAction.SEND_TO_BACK));
//#endif 


//#if -1488468071 
setMnemonic(reorderSendToBack,
                    "reorder send to back");
//#endif 


//#if 1725340488 
ShortcutMgr.assignAccelerator(reorderSendToBack,
                                      ShortcutMgr.ACTION_REORDER_TO_BACK);
//#endif 

} 

//#endif 


//#if -1681557832 
public GenericArgoMenuBar()
    { 

//#if 58886894 
initActions();
//#endif 


//#if -412607017 
initMenus();
//#endif 


//#if 562207376 
initModulesUI();
//#endif 


//#if -1513390601 
registerForMacEvents();
//#endif 

} 

//#endif 


//#if -1820490343 
private void initMenuCreate()
    { 

//#if -2080426255 
Collection<Action> toolbarTools = new ArrayList<Action>();
//#endif 


//#if 899095555 
createDiagramMenu = add(new JMenu(menuLocalize("Create Diagram")));
//#endif 


//#if -575358472 
setMnemonic(createDiagramMenu, "Create Diagram");
//#endif 


//#if 1685907540 
JMenuItem usecaseDiagram = createDiagramMenu
                                   .add(new ActionUseCaseDiagram());
//#endif 


//#if 1538378229 
setMnemonic(usecaseDiagram, "Usecase Diagram");
//#endif 


//#if -1771230584 
toolbarTools.add((new ActionUseCaseDiagram()));
//#endif 


//#if -1532049856 
ShortcutMgr.assignAccelerator(usecaseDiagram,
                                      ShortcutMgr.ACTION_USE_CASE_DIAGRAM);
//#endif 


//#if 299879730 
JMenuItem classDiagram =
            createDiagramMenu.add(new ActionClassDiagram());
//#endif 


//#if -1992827593 
setMnemonic(classDiagram, "Class Diagram");
//#endif 


//#if -1208677463 
toolbarTools.add((new ActionClassDiagram()));
//#endif 


//#if -1775421331 
ShortcutMgr.assignAccelerator(classDiagram,
                                      ShortcutMgr.ACTION_CLASS_DIAGRAM);
//#endif 


//#if -506607228 
JMenuItem sequenzDiagram =
            createDiagramMenu.add(new ActionSequenceDiagram());
//#endif 


//#if -2077825027 
setMnemonic(sequenzDiagram, "Sequenz Diagram");
//#endif 


//#if 863403806 
toolbarTools.add((new ActionSequenceDiagram()));
//#endif 


//#if 951574069 
ShortcutMgr.assignAccelerator(sequenzDiagram,
                                      ShortcutMgr.ACTION_SEQUENCE_DIAGRAM);
//#endif 


//#if 285995224 
JMenuItem collaborationDiagram =
            createDiagramMenu.add(new ActionCollaborationDiagram());
//#endif 


//#if -1468288623 
setMnemonic(collaborationDiagram, "Collaboration Diagram");
//#endif 


//#if 90400502 
toolbarTools.add((new ActionCollaborationDiagram()));
//#endif 


//#if -1112930681 
ShortcutMgr.assignAccelerator(collaborationDiagram,
                                      ShortcutMgr.ACTION_COLLABORATION_DIAGRAM);
//#endif 


//#if 1999344960 
JMenuItem stateDiagram =
            createDiagramMenu.add(new ActionStateDiagram());
//#endif 


//#if 279082167 
setMnemonic(stateDiagram, "Statechart Diagram");
//#endif 


//#if -1512748734 
toolbarTools.add((new ActionStateDiagram()));
//#endif 


//#if -2101791713 
ShortcutMgr.assignAccelerator(stateDiagram,
                                      ShortcutMgr.ACTION_STATE_DIAGRAM);
//#endif 


//#if -292657976 
JMenuItem activityDiagram =
            createDiagramMenu.add(new ActionActivityDiagram());
//#endif 


//#if 1684915929 
setMnemonic(activityDiagram, "Activity Diagram");
//#endif 


//#if -1344440980 
toolbarTools.add((new ActionActivityDiagram()));
//#endif 


//#if 476752165 
ShortcutMgr.assignAccelerator(activityDiagram,
                                      ShortcutMgr.ACTION_ACTIVITY_DIAGRAM);
//#endif 


//#if -29095416 
JMenuItem deploymentDiagram =
            createDiagramMenu.add(new ActionDeploymentDiagram());
//#endif 


//#if -398794471 
setMnemonic(deploymentDiagram, "Deployment Diagram");
//#endif 


//#if 1008494242 
toolbarTools.add((new ActionDeploymentDiagram()));
//#endif 


//#if 2121817125 
ShortcutMgr.assignAccelerator(deploymentDiagram,
                                      ShortcutMgr.ACTION_DEPLOYMENT_DIAGRAM);
//#endif 


//#if 1328961876 
createDiagramToolbar =
            (new ToolBarFactory(toolbarTools)).createToolBar();
//#endif 


//#if -1293075535 
createDiagramToolbar.setName(
            Translator.localize("misc.toolbar.create-diagram"));
//#endif 


//#if -1432542505 
createDiagramToolbar.setFloatable(true);
//#endif 

} 

//#endif 


//#if -1118392172 
private void initModulesActions()
    { 

//#if 768143638 
for (Action action : moduleCreateDiagramActions) //1
{ 

//#if 112872541 
createDiagramToolbar.add(action);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 816171743 
private void initModulesUI ()
    { 

//#if 895530136 
initModulesMenus();
//#endif 


//#if -1246726801 
initModulesActions();
//#endif 

} 

//#endif 


//#if -1100996496 
private void registerForMacEvents()
    { 

//#if -914351750 
if(OsUtil.isMacOSX())//1
{ 

//#if -2097025491 
try //1
{ 

//#if 317130638 
OSXAdapter.setQuitHandler(this, getClass().getDeclaredMethod(
                                              "macQuit", (Class[]) null));
//#endif 


//#if 1419356722 
OSXAdapter.setAboutHandler(this, getClass().getDeclaredMethod(
                                               "macAbout", (Class[]) null));
//#endif 


//#if 486649490 
OSXAdapter.setPreferencesHandler(this, getClass()
                                                 .getDeclaredMethod("macPreferences", (Class[]) null));
//#endif 


//#if 1705264101 
OSXAdapter.setFileHandler(this, getClass().getDeclaredMethod(
                                              "macOpenFile", new Class[] {String.class}));
//#endif 

} 

//#if 1987846509 
catch (Exception e) //1
{ 

//#if -2095034876 
LOG.error("Error while loading the OSXAdapter:", e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if 12155002 
public void addFileSaved(String filename)
    { 

//#if -88372650 
mruList.addEntry(filename);
//#endif 

} 

//#endif 


//#if -791790655 
private void initActions()
    { 

//#if 1468851202 
navigateTargetForwardAction = new NavigateTargetForwardAction();
//#endif 


//#if 381341164 
disableableActions.add(navigateTargetForwardAction);
//#endif 


//#if 1278504190 
navigateTargetBackAction = new NavigateTargetBackAction();
//#endif 


//#if 647466544 
disableableActions.add(navigateTargetBackAction);
//#endif 


//#if 792972833 
TargetManager.getInstance().addTargetListener(this);
//#endif 

} 

//#endif 


//#if -1458058335 
private static String prepareKey(String str)
    { 

//#if 94774899 
return str.toLowerCase().replace(' ', '-');
//#endif 

} 

//#endif 


//#if -1385615970 
private void initMenuHelp()
    { 

//#if -2106067033 
help = new JMenu(menuLocalize("Help"));
//#endif 


//#if 806560848 
setMnemonic(help, "Help");
//#endif 


//#if -578663157 
if(help.getItemCount() > 0)//1
{ 

//#if 1391396714 
help.insertSeparator(0);
//#endif 

} 

//#endif 


//#if 835737445 
JMenuItem argoHelp = help.add(new ActionHelp());
//#endif 


//#if 648163284 
setMnemonic(argoHelp, "ArgoUML help");
//#endif 


//#if -488042402 
ShortcutMgr.assignAccelerator(argoHelp, ShortcutMgr.ACTION_HELP);
//#endif 


//#if -1351075791 
help.addSeparator();
//#endif 


//#if 1471292030 
JMenuItem systemInfo = help.add(new ActionSystemInfo());
//#endif 


//#if 1346974518 
setMnemonic(systemInfo, "System Information");
//#endif 


//#if -295889188 
ShortcutMgr.assignAccelerator(systemInfo,
                                      ShortcutMgr.ACTION_SYSTEM_INFORMATION);
//#endif 


//#if 817300120 
aboutAction = new ActionAboutArgoUML();
//#endif 


//#if 592694082 
if(!OsUtil.isMacOSX())//1
{ 

//#if -746812484 
help.addSeparator();
//#endif 


//#if 870444935 
JMenuItem aboutArgoUML = help.add(aboutAction);
//#endif 


//#if -2039872053 
setMnemonic(aboutArgoUML, "About ArgoUML");
//#endif 


//#if -418347343 
ShortcutMgr.assignAccelerator(aboutArgoUML,
                                          ShortcutMgr.ACTION_ABOUT_ARGOUML);
//#endif 

} 

//#endif 


//#if -425673758 
add(help);
//#endif 

} 

//#endif 


//#if 1585179135 
public static void registerMenuItem(JMenu menu)
    { 

//#if -13776596 
moduleMenus.add(menu);
//#endif 

} 

//#endif 


//#if -981315582 
private void initMenuView()
    { 

//#if -734590748 
view = (ArgoJMenu) add(new ArgoJMenu(MENU + prepareKey("View")));
//#endif 


//#if 1159958491 
setMnemonic(view, "View");
//#endif 


//#if -1656749175 
JMenuItem gotoDiagram = view.add(new ActionGotoDiagram());
//#endif 


//#if 617629598 
setMnemonic(gotoDiagram, "Goto-Diagram");
//#endif 


//#if 42434692 
ShortcutMgr.assignAccelerator(gotoDiagram,
                                      ShortcutMgr.ACTION_GO_TO_DIAGRAM);
//#endif 


//#if -1905709284 
JMenuItem findItem = view.add(new ActionFind());
//#endif 


//#if -1487762720 
setMnemonic(findItem, "Find");
//#endif 


//#if 1545468757 
ShortcutMgr.assignAccelerator(findItem, ShortcutMgr.ACTION_FIND);
//#endif 


//#if 1139709794 
view.addSeparator();
//#endif 


//#if 471729086 
JMenu zoom = (JMenu) view.add(new JMenu(menuLocalize("Zoom")));
//#endif 


//#if 1372093055 
setMnemonic(zoom, "Zoom");
//#endif 


//#if 974988678 
ZoomActionProxy zoomOutAction = new ZoomActionProxy(ZOOM_FACTOR);
//#endif 


//#if 1257756426 
JMenuItem zoomOut = zoom.add(zoomOutAction);
//#endif 


//#if -2075423119 
setMnemonic(zoomOut, "Zoom Out");
//#endif 


//#if 1234010259 
ShortcutMgr.assignAccelerator(zoomOut, ShortcutMgr.ACTION_ZOOM_OUT);
//#endif 


//#if -307687214 
JMenuItem zoomReset = zoom.add(new ZoomActionProxy(0.0));
//#endif 


//#if -1205200559 
setMnemonic(zoomReset, "Zoom Reset");
//#endif 


//#if -325311595 
ShortcutMgr.assignAccelerator(zoomReset, ShortcutMgr.ACTION_ZOOM_RESET);
//#endif 


//#if -1713371373 
ZoomActionProxy zoomInAction =
            new ZoomActionProxy((1.0) / (ZOOM_FACTOR));
//#endif 


//#if -90437500 
JMenuItem zoomIn = zoom.add(zoomInAction);
//#endif 


//#if 46480629 
setMnemonic(zoomIn, "Zoom In");
//#endif 


//#if -1279004819 
ShortcutMgr.assignAccelerator(zoomIn, ShortcutMgr.ACTION_ZOOM_IN);
//#endif 


//#if 1378044848 
view.addSeparator();
//#endif 


//#if 1966200521 
JMenu grid = (JMenu) view.add(new JMenu(menuLocalize("Adjust Grid")));
//#endif 


//#if -1193130983 
setMnemonic(grid, "Grid");
//#endif 


//#if -371502437 
List<Action> gridActions =
            ActionAdjustGrid.createAdjustGridActions(false);
//#endif 


//#if -1631911555 
ButtonGroup groupGrid = new ButtonGroup();
//#endif 


//#if -820124134 
ActionAdjustGrid.setGroup(groupGrid);
//#endif 


//#if -1313973861 
for ( Action cmdAG : gridActions) //1
{ 

//#if 302369842 
JRadioButtonMenuItem mi = new JRadioButtonMenuItem(cmdAG);
//#endif 


//#if -1480154147 
groupGrid.add(mi);
//#endif 


//#if -929962414 
JMenuItem adjustGrid = grid.add(mi);
//#endif 


//#if 731147859 
setMnemonic(adjustGrid, (String) cmdAG.getValue(Action.NAME));
//#endif 


//#if -797692951 
ShortcutMgr.assignAccelerator(adjustGrid,
                                          ShortcutMgr.ACTION_ADJUST_GRID + cmdAG.getValue("ID"));
//#endif 

} 

//#endif 


//#if -1394115647 
JMenu snap = (JMenu) view.add(new JMenu(menuLocalize("Adjust Snap")));
//#endif 


//#if 135778577 
setMnemonic(snap, "Snap");
//#endif 


//#if 311506408 
List<Action> snapActions = ActionAdjustSnap.createAdjustSnapActions();
//#endif 


//#if 562679041 
ButtonGroup groupSnap = new ButtonGroup();
//#endif 


//#if 575770522 
ActionAdjustSnap.setGroup(groupSnap);
//#endif 


//#if 280109731 
for ( Action cmdAS : snapActions) //1
{ 

//#if -1050522715 
JRadioButtonMenuItem mi = new JRadioButtonMenuItem(cmdAS);
//#endif 


//#if 1134890432 
groupSnap.add(mi);
//#endif 


//#if 2128453387 
JMenuItem adjustSnap = snap.add(mi);
//#endif 


//#if -114649846 
setMnemonic(adjustSnap, (String) cmdAS.getValue(Action.NAME));
//#endif 


//#if 301165762 
ShortcutMgr.assignAccelerator(adjustSnap,
                                          ShortcutMgr.ACTION_ADJUST_GUIDE + cmdAS.getValue("ID"));
//#endif 

} 

//#endif 


//#if -347982549 
Action pba  = new ActionAdjustPageBreaks();
//#endif 


//#if 2138270197 
JMenuItem adjustPageBreaks = view.add(pba);
//#endif 


//#if -1501463455 
setMnemonic(adjustPageBreaks, "Adjust Pagebreaks");
//#endif 


//#if 1977289718 
ShortcutMgr.assignAccelerator(adjustPageBreaks,
                                      ShortcutMgr.ACTION_ADJUST_PAGE_BREAKS);
//#endif 


//#if 1378044849 
view.addSeparator();
//#endif 


//#if -534639080 
JMenu menuToolbars = ArgoToolbarManager.getInstance().getMenu();
//#endif 


//#if 1053392622 
menuToolbars.setText(menuLocalize("toolbars"));
//#endif 


//#if 1704734070 
setMnemonic(menuToolbars, "toolbars");
//#endif 


//#if 133881956 
view.add(menuToolbars);
//#endif 


//#if 1378044850 
view.addSeparator();
//#endif 


//#if -1096944927 
JMenuItem showSaved = view.add(new ActionShowXMLDump());
//#endif 


//#if 991063569 
setMnemonic(showSaved, "Show Saved");
//#endif 


//#if -62016126 
ShortcutMgr.assignAccelerator(showSaved,
                                      ShortcutMgr.ACTION_SHOW_XML_DUMP);
//#endif 

} 

//#endif 


//#if 2063184525 
public void targetAdded(TargetEvent e)
    { 

//#if 1834372503 
setTarget();
//#endif 

} 

//#endif 


//#if 270538469 
public JToolBar getViewToolbar()
    { 

//#if 1263558944 
if(viewToolbar == null)//1
{ 

//#if -1311455774 
Collection<Object> c = new ArrayList<Object>();
//#endif 


//#if -120920723 
c.add(new ActionFind());
//#endif 


//#if 1725094788 
c.add(new ZoomSliderButton());
//#endif 


//#if 1451752381 
viewToolbar = (new ToolBarFactory(c)).createToolBar();
//#endif 


//#if 597645330 
viewToolbar.setName(Translator.localize("misc.toolbar.view"));
//#endif 


//#if -1473742375 
viewToolbar.setFloatable(true);
//#endif 

} 

//#endif 


//#if 660048315 
return viewToolbar;
//#endif 

} 

//#endif 


//#if 1307223151 
public void targetSet(TargetEvent e)
    { 

//#if -221474595 
setTarget();
//#endif 

} 

//#endif 


//#if -1472512473 
private void initMenuEdit()
    { 

//#if 2046003648 
edit = add(new JMenu(menuLocalize("Edit")));
//#endif 


//#if -1279096477 
setMnemonic(edit, "Edit");
//#endif 


//#if 2099770840 
select = new JMenu(menuLocalize("Select"));
//#endif 


//#if -1102645633 
setMnemonic(select, "Select");
//#endif 


//#if 2104262934 
edit.add(select);
//#endif 


//#if 579318365 
JMenuItem selectAllItem = select.add(new ActionSelectAll());
//#endif 


//#if -1398856138 
setMnemonic(selectAllItem, "Select All");
//#endif 


//#if 320400414 
ShortcutMgr.assignAccelerator(selectAllItem,
                                      ShortcutMgr.ACTION_SELECT_ALL);
//#endif 


//#if 1164951271 
select.addSeparator();
//#endif 


//#if 880674592 
JMenuItem backItem = select.add(navigateTargetBackAction);
//#endif 


//#if 861574309 
setMnemonic(backItem, "Navigate Back");
//#endif 


//#if 1754458465 
ShortcutMgr.assignAccelerator(backItem,
                                      ShortcutMgr.ACTION_NAVIGATE_BACK);
//#endif 


//#if -135465232 
JMenuItem forwardItem = select.add(navigateTargetForwardAction);
//#endif 


//#if -8872057 
setMnemonic(forwardItem, "Navigate Forward");
//#endif 


//#if -196232585 
ShortcutMgr.assignAccelerator(forwardItem,
                                      ShortcutMgr.ACTION_NAVIGATE_FORWARD);
//#endif 


//#if 1727609355 
select.addSeparator();
//#endif 


//#if -21454956 
JMenuItem selectInvert = select.add(new ActionSelectInvert());
//#endif 


//#if -662893267 
setMnemonic(selectInvert, "Invert Selection");
//#endif 


//#if -1957072627 
ShortcutMgr.assignAccelerator(selectInvert,
                                      ShortcutMgr.ACTION_SELECT_INVERT);
//#endif 


//#if -588984139 
edit.addSeparator();
//#endif 


//#if -1472309190 
Action removeFromDiagram = ProjectActions.getInstance()
                                   .getRemoveFromDiagramAction();
//#endif 


//#if -220848743 
JMenuItem removeItem = edit.add(removeFromDiagram);
//#endif 


//#if 965621859 
setMnemonic(removeItem, "Remove from Diagram");
//#endif 


//#if 655817000 
ShortcutMgr.assignAccelerator(removeItem,
                                      ShortcutMgr.ACTION_REMOVE_FROM_DIAGRAM);
//#endif 


//#if -162458140 
JMenuItem deleteItem = edit.add(ActionDeleteModelElements
                                        .getTargetFollower());
//#endif 


//#if 2139636123 
setMnemonic(deleteItem, "Delete from Model");
//#endif 


//#if 1628159337 
ShortcutMgr.assignAccelerator(deleteItem,
                                      ShortcutMgr.ACTION_DELETE_MODEL_ELEMENTS);
//#endif 


//#if -1485034115 
edit.addSeparator();
//#endif 


//#if 379067768 
ShortcutMgr.assignAccelerator(edit.add(new ActionPerspectiveConfig()),
                                      ShortcutMgr.ACTION_PERSPECTIVE_CONFIG);
//#endif 


//#if -1396227518 
settingsAction = new ActionSettings();
//#endif 


//#if 139869287 
if(!OsUtil.isMacOSX())//1
{ 

//#if -1348605200 
JMenuItem settingsItem = edit.add(settingsAction);
//#endif 


//#if 69001030 
setMnemonic(settingsItem, "Settings");
//#endif 


//#if 1156933423 
ShortcutMgr.assignAccelerator(settingsItem,
                                          ShortcutMgr.ACTION_SETTINGS);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1950264832 
private void initMenuTools()
    { 

//#if 1042386974 
tools = new JMenu(menuLocalize("Tools"));
//#endif 


//#if -624338467 
setMnemonic(tools, "Tools");
//#endif 


//#if -447800387 
add(tools);
//#endif 

} 

//#endif 


//#if 948832312 
public void macQuit()
    { 

//#if -361910344 
exitAction.actionPerformed(null);
//#endif 

} 

//#endif 


//#if -1439190759 
private void initMenuFile()
    { 

//#if 1960239706 
Collection<Action> toolbarTools = new ArrayList<Action>();
//#endif 


//#if -2017962456 
JMenu file = new JMenu(menuLocalize("File"));
//#endif 


//#if -54222645 
add(file);
//#endif 


//#if 863473964 
setMnemonic(file, "File");
//#endif 


//#if 1812071878 
JMenuItem newItem = file.add(new ActionNew());
//#endif 


//#if 449189955 
setMnemonic(newItem, "New");
//#endif 


//#if 1633764598 
ShortcutMgr.assignAccelerator(newItem, ShortcutMgr.ACTION_NEW_PROJECT);
//#endif 


//#if 62304327 
toolbarTools.add((new ActionNew()));
//#endif 


//#if 2067769882 
openAction = new ActionOpenProject();
//#endif 


//#if -1221166358 
JMenuItem openProjectItem = file.add(openAction);
//#endif 


//#if 719496620 
setMnemonic(openProjectItem, "Open");
//#endif 


//#if 876397307 
ShortcutMgr.assignAccelerator(openProjectItem,
                                      ShortcutMgr.ACTION_OPEN_PROJECT);
//#endif 


//#if -84823477 
toolbarTools.add(new ActionOpenProject());
//#endif 


//#if 1957066842 
file.addSeparator();
//#endif 


//#if -1682124576 
JMenuItem saveProjectItem = file.add(ProjectBrowser.getInstance()
                                             .getSaveAction());
//#endif 


//#if -93495988 
setMnemonic(saveProjectItem, "Save");
//#endif 


//#if -336087525 
ShortcutMgr.assignAccelerator(saveProjectItem,
                                      ShortcutMgr.ACTION_SAVE_PROJECT);
//#endif 


//#if -185993687 
toolbarTools.add((ProjectBrowser.getInstance().getSaveAction()));
//#endif 


//#if -1503917662 
JMenuItem saveProjectAsItem = file.add(new ActionSaveProjectAs());
//#endif 


//#if 2109435816 
setMnemonic(saveProjectAsItem, "SaveAs");
//#endif 


//#if -1022715992 
ShortcutMgr.assignAccelerator(saveProjectAsItem,
                                      ShortcutMgr.ACTION_SAVE_PROJECT_AS);
//#endif 


//#if 261490390 
JMenuItem revertToSavedItem = file.add(new ActionRevertToSaved());
//#endif 


//#if -1489130749 
setMnemonic(revertToSavedItem, "Revert To Saved");
//#endif 


//#if 1768284722 
ShortcutMgr.assignAccelerator(revertToSavedItem,
                                      ShortcutMgr.ACTION_REVERT_TO_SAVED);
//#endif 


//#if -1202706504 
file.addSeparator();
//#endif 


//#if 1336462273 
ShortcutMgr.assignAccelerator(file.add(new ActionImportXMI()),
                                      ShortcutMgr.ACTION_IMPORT_XMI);
//#endif 


//#if 1691615583 
ShortcutMgr.assignAccelerator(file.add(new ActionExportXMI()),
                                      ShortcutMgr.ACTION_EXPORT_XMI);
//#endif 


//#if 317007300 
JMenuItem importFromSources = file.add(ActionImportFromSources
                                               .getInstance());
//#endif 


//#if 1187441258 
setMnemonic(importFromSources, "Import");
//#endif 


//#if -22242909 
ShortcutMgr.assignAccelerator(importFromSources,
                                      ShortcutMgr.ACTION_IMPORT_FROM_SOURCES);
//#endif 


//#if -1202706503 
file.addSeparator();
//#endif 


//#if -2123609076 
Action a = new ActionProjectSettings();
//#endif 


//#if 1201191604 
toolbarTools.add(a);
//#endif 


//#if -55322334 
JMenuItem pageSetupItem = file.add(new ActionPageSetup());
//#endif 


//#if -1224859069 
setMnemonic(pageSetupItem, "PageSetup");
//#endif 


//#if 991132003 
ShortcutMgr.assignAccelerator(pageSetupItem,
                                      ShortcutMgr.ACTION_PAGE_SETUP);
//#endif 


//#if 1319398944 
JMenuItem printItem = file.add(new ActionPrint());
//#endif 


//#if 1900571939 
setMnemonic(printItem, "Print");
//#endif 


//#if 2130938076 
ShortcutMgr.assignAccelerator(printItem, ShortcutMgr.ACTION_PRINT);
//#endif 


//#if -1452728294 
toolbarTools.add((new ActionPrint()));
//#endif 


//#if -1000980620 
JMenuItem saveGraphicsItem = file.add(new ActionSaveGraphics());
//#endif 


//#if -892434431 
setMnemonic(saveGraphicsItem, "SaveGraphics");
//#endif 


//#if -1598737979 
ShortcutMgr.assignAccelerator(saveGraphicsItem,
                                      ShortcutMgr.ACTION_SAVE_GRAPHICS);
//#endif 


//#if 1811272392 
ShortcutMgr.assignAccelerator(file.add(new ActionSaveAllGraphics()),
                                      ShortcutMgr.ACTION_SAVE_ALL_GRAPHICS);
//#endif 


//#if -1202706502 
file.addSeparator();
//#endif 


//#if 704791578 
JMenu notation = (JMenu) file.add(new ActionNotation().getMenu());
//#endif 


//#if 367831840 
setMnemonic(notation, "Notation");
//#endif 


//#if 1188031265 
JMenuItem propertiesItem = file.add(new ActionProjectSettings());
//#endif 


//#if -1598731029 
setMnemonic(propertiesItem, "Properties");
//#endif 


//#if -90351904 
ShortcutMgr.assignAccelerator(propertiesItem,
                                      ShortcutMgr.ACTION_PROJECT_SETTINGS);
//#endif 


//#if -1202706501 
file.addSeparator();
//#endif 


//#if -1494133917 
mruList = new LastRecentlyUsedMenuList(file);
//#endif 


//#if 1943234681 
exitAction = new ActionExit();
//#endif 


//#if -954359788 
if(!OsUtil.isMacOSX())//1
{ 

//#if 1000492431 
file.addSeparator();
//#endif 


//#if 105680676 
JMenuItem exitItem = file.add(exitAction);
//#endif 


//#if 491524480 
setMnemonic(exitItem, "Exit");
//#endif 


//#if -1303281793 
exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,
                                    InputEvent.ALT_MASK));
//#endif 

} 

//#endif 


//#if -321988420 
fileToolbar = (new ToolBarFactory(toolbarTools)).createToolBar();
//#endif 


//#if -957413869 
fileToolbar.setName(Translator.localize("misc.toolbar.file"));
//#endif 


//#if 1383133295 
fileToolbar.setFloatable(true);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

