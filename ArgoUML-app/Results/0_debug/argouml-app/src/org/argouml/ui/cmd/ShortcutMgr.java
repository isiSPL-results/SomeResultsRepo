
//#if -871331238 
// Compilation Unit of /ShortcutMgr.java 
 

//#if -1128837213 
package org.argouml.ui.cmd;
//#endif 


//#if -785870583 
import java.awt.Toolkit;
//#endif 


//#if 73997867 
import java.awt.event.InputEvent;
//#endif 


//#if -563341056 
import java.awt.event.KeyEvent;
//#endif 


//#if 1699999030 
import java.lang.reflect.Field;
//#endif 


//#if 778691185 
import java.util.Arrays;
//#endif 


//#if -777172395 
import java.util.Comparator;
//#endif 


//#if -189532579 
import java.util.HashMap;
//#endif 


//#if 425807293 
import java.util.Iterator;
//#endif 


//#if -355777651 
import java.util.List;
//#endif 


//#if -2026473275 
import java.util.StringTokenizer;
//#endif 


//#if 1548244939 
import javax.swing.AbstractAction;
//#endif 


//#if -388114320 
import javax.swing.JComponent;
//#endif 


//#if 1641420183 
import javax.swing.JMenuItem;
//#endif 


//#if 1766860105 
import javax.swing.JPanel;
//#endif 


//#if -966530276 
import javax.swing.KeyStroke;
//#endif 


//#if 1667740330 
import org.argouml.configuration.Configuration;
//#endif 


//#if 2062893150 
import org.argouml.ui.ActionExportXMI;
//#endif 


//#if -315998257 
import org.argouml.ui.ActionImportXMI;
//#endif 


//#if -1870573822 
import org.argouml.ui.ActionProjectSettings;
//#endif 


//#if -355974091 
import org.argouml.ui.ActionSettings;
//#endif 


//#if 2005703274 
import org.argouml.ui.ProjectActions;
//#endif 


//#if -248906337 
import org.argouml.ui.ProjectBrowser;
//#endif 


//#if 559818197 
import org.argouml.ui.explorer.ActionPerspectiveConfig;
//#endif 


//#if -1952138121 
import org.argouml.uml.ui.ActionClassDiagram;
//#endif 


//#if -945228145 
import org.argouml.uml.ui.ActionDeleteModelElements;
//#endif 


//#if -728300072 
import org.argouml.uml.ui.ActionGenerateAll;
//#endif 


//#if -727881293 
import org.argouml.uml.ui.ActionGenerateOne;
//#endif 


//#if -26793613 
import org.argouml.uml.ui.ActionGenerateProjectCode;
//#endif 


//#if 1281067543 
import org.argouml.uml.ui.ActionGenerationSettings;
//#endif 


//#if -5366053 
import org.argouml.uml.ui.ActionImportFromSources;
//#endif 


//#if -956613451 
import org.argouml.uml.ui.ActionOpenProject;
//#endif 


//#if 823141564 
import org.argouml.uml.ui.ActionRevertToSaved;
//#endif 


//#if -839013355 
import org.argouml.uml.ui.ActionSaveAllGraphics;
//#endif 


//#if -1693098198 
import org.argouml.uml.ui.ActionSaveGraphics;
//#endif 


//#if -911573098 
import org.argouml.uml.ui.ActionSaveProjectAs;
//#endif 


//#if 594852196 
import org.argouml.util.KeyEventUtils;
//#endif 


//#if -330776531 
import org.tigris.gef.base.AlignAction;
//#endif 


//#if 1405872535 
import org.tigris.gef.base.DistributeAction;
//#endif 


//#if -598139337 
import org.tigris.gef.base.ReorderAction;
//#endif 


//#if -485430875 
import org.tigris.gef.base.ZoomAction;
//#endif 


//#if 791659473 
import org.apache.log4j.Logger;
//#endif 


//#if 898896550 
import org.argouml.cognitive.critics.ui.ActionOpenCritics;
//#endif 


//#if -555363573 
import org.argouml.cognitive.ui.ActionAutoCritique;
//#endif 


//#if 1868197629 
import org.argouml.cognitive.ui.ActionOpenDecisions;
//#endif 


//#if -444550924 
import org.argouml.cognitive.ui.ActionOpenGoals;
//#endif 


//#if 1737025860 
import org.argouml.uml.ui.ActionCollaborationDiagram;
//#endif 


//#if -660222730 
import org.argouml.uml.ui.ActionDeploymentDiagram;
//#endif 


//#if -1617654734 
import org.argouml.uml.ui.ActionSequenceDiagram;
//#endif 


//#if -1980911984 
import org.argouml.uml.ui.ActionStateDiagram;
//#endif 


//#if -1785236586 
import org.argouml.uml.ui.ActionUseCaseDiagram;
//#endif 


//#if -274802304 
import org.argouml.uml.ui.ActionActivityDiagram;
//#endif 


//#if 2031069742 
public class ShortcutMgr  { 

//#if -1736799206 
public static final String ACTION_NEW_PROJECT = "newProject";
//#endif 


//#if 1819431112 
public static final String ACTION_OPEN_PROJECT = "openProject";
//#endif 


//#if -1268770206 
public static final String ACTION_SAVE_PROJECT = "saveProject";
//#endif 


//#if 1891908575 
public static final String ACTION_SAVE_PROJECT_AS = "saveProjectAs";
//#endif 


//#if -1599748757 
public static final String ACTION_PRINT = "print";
//#endif 


//#if -1353754716 
public static final String ACTION_SELECT_ALL = "selectAll";
//#endif 


//#if 77462365 
public static final String ACTION_UNDO = "undo";
//#endif 


//#if -1411291887 
public static final String ACTION_REDO = "redo";
//#endif 


//#if 289940663 
public static final String ACTION_REMOVE_FROM_DIAGRAM = "removeFromDiagram";
//#endif 


//#if -313419041 
public static final String ACTION_DELETE_MODEL_ELEMENTS =
        "deleteModelElements";
//#endif 


//#if -1559521834 
public static final String ACTION_ZOOM_OUT = "zoomOut";
//#endif 


//#if -1075386128 
public static final String ACTION_ZOOM_IN = "zoomIn";
//#endif 


//#if -1160728889 
public static final String ACTION_FIND = "find";
//#endif 


//#if -751948627 
public static final String ACTION_GENERATE_ALL_CLASSES =
        "generateAllClasses";
//#endif 


//#if -240272568 
public static final String ACTION_ALIGN_RIGHTS = "alignRights";
//#endif 


//#if 929648288 
public static final String ACTION_ALIGN_LEFTS = "alignLefts";
//#endif 


//#if -1800977515 
public static final String ACTION_REVERT_TO_SAVED = "revertToSaved";
//#endif 


//#if -1919408846 
public static final String ACTION_IMPORT_XMI = "importXmi";
//#endif 


//#if 1478874708 
public static final String ACTION_EXPORT_XMI = "exportXmi";
//#endif 


//#if 2035287543 
public static final String ACTION_IMPORT_FROM_SOURCES = "importFromSources";
//#endif 


//#if -1809577680 
public static final String ACTION_PROJECT_SETTINGS = "projectSettings";
//#endif 


//#if -1809523970 
public static final String ACTION_PAGE_SETUP = "pageSetup";
//#endif 


//#if 1554079676 
public static final String ACTION_SAVE_GRAPHICS = "saveGraphics";
//#endif 


//#if 95749583 
public static final String ACTION_SAVE_ALL_GRAPHICS = "saveAllGraphics";
//#endif 


//#if 1427891049 
public static final String ACTION_NAVIGATE_FORWARD =
        "navigateTargetForward";
//#endif 


//#if 91925605 
public static final String ACTION_NAVIGATE_BACK = "navigateTargetBack";
//#endif 


//#if -1595657358 
public static final String ACTION_SELECT_INVERT = "selectInvert";
//#endif 


//#if -1016362154 
public static final String ACTION_PERSPECTIVE_CONFIG = "perspectiveConfig";
//#endif 


//#if -1815995365 
public static final String ACTION_SETTINGS = "settings";
//#endif 


//#if -1700197991 
public static final String ACTION_NOTATION = "notation";
//#endif 


//#if -1278773291 
public static final String ACTION_GO_TO_DIAGRAM = "goToDiagram";
//#endif 


//#if -1812156874 
public static final String ACTION_ZOOM_RESET = "zoomReset";
//#endif 


//#if 1765438706 
public static final String ACTION_ADJUST_GRID = "adjustGrid";
//#endif 


//#if -937514146 
public static final String ACTION_ADJUST_GUIDE = "adjustGuide";
//#endif 


//#if -1323956261 
public static final String ACTION_ADJUST_PAGE_BREAKS = "adjustPageBreaks";
//#endif 


//#if 2027495131 
public static final String ACTION_SHOW_XML_DUMP = "showXmlDump";
//#endif 


//#if 905333559 
public static final String ACTION_CLASS_DIAGRAM = "classDiagrams";
//#endif 


//#if 818778642 
public static final String ACTION_GENERATE_ONE = "generateOne";
//#endif 


//#if -1634388609 
public static final String ACTION_GENERATE_PROJECT_CODE =
        "generateProjectCode";
//#endif 


//#if -646081844 
public static final String ACTION_GENERATION_SETTINGS =
        "generationSettings";
//#endif 


//#if 2054713024 
public static final String ACTION_PREFERRED_SIZE = "preferredSize";
//#endif 


//#if -544917046 
public static final String ACTION_AUTO_CRITIQUE = "autoCritique";
//#endif 


//#if -625140728 
public static final String ACTION_OPEN_DECISIONS = "openDecisions";
//#endif 


//#if -1255959704 
public static final String ACTION_OPEN_GOALS = "openGoals";
//#endif 


//#if -2072766505 
public static final String ACTION_HELP = "help";
//#endif 


//#if -1790223474 
public static final String ACTION_SYSTEM_INFORMATION = "systemInfo";
//#endif 


//#if -1328315554 
public static final String ACTION_ABOUT_ARGOUML = "aboutArgoUml";
//#endif 


//#if -445884760 
public static final String ACTION_ALIGN_TOPS = "alignTops";
//#endif 


//#if 743079384 
public static final String ACTION_ALIGN_BOTTOMS = "alignBottoms";
//#endif 


//#if -889109863 
public static final String ACTION_ALIGN_H_CENTERS = "alignHCenters";
//#endif 


//#if 1088945661 
public static final String ACTION_ALIGN_V_CENTERS = "alignVCenters";
//#endif 


//#if 1509123713 
public static final String ACTION_ALIGN_TO_GRID = "alignToGrid";
//#endif 


//#if -1547866081 
public static final String ACTION_DISTRIBUTE_H_SPACING =
        "distributeHSpacing";
//#endif 


//#if 695309333 
public static final String ACTION_DISTRIBUTE_H_CENTERS =
        "distributeHCenters";
//#endif 


//#if 612143967 
public static final String ACTION_DISTRIBUTE_V_SPACING =
        "distributeVSpacing";
//#endif 


//#if -1439647915 
public static final String ACTION_DISTRIBUTE_V_CENTERS =
        "distributeVCenters";
//#endif 


//#if 1794977682 
public static final String ACTION_REORDER_FORWARD = "reorderForward";
//#endif 


//#if -643337356 
public static final String ACTION_REORDER_BACKWARD = "reorderBackward";
//#endif 


//#if -1576885967 
public static final String ACTION_REORDER_TO_FRONT = "reorderToFront";
//#endif 


//#if -2012463903 
public static final String ACTION_REORDER_TO_BACK = "reorderToBack";
//#endif 


//#if 163372665 
private static final int DEFAULT_MASK = Toolkit.getDefaultToolkit()
                                            .getMenuShortcutKeyMask();
//#endif 


//#if 149782186 
private static final int SHIFTED_DEFAULT_MASK = Toolkit.getDefaultToolkit()
            .getMenuShortcutKeyMask() | KeyEvent.SHIFT_DOWN_MASK;
//#endif 


//#if -1668720299 
private static HashMap<String, ActionWrapper> shortcutHash =
        new HashMap<String, ActionWrapper>(90);
//#endif 


//#if -740941858 
private static HashMap<KeyStroke, KeyStroke> duplicate =
        new HashMap<KeyStroke, KeyStroke>(10);
//#endif 


//#if -1634048552 
public static final String ACTION_USE_CASE_DIAGRAM = "useCaseDiagrams";
//#endif 


//#if -1647937429 
public static final String ACTION_SEQUENCE_DIAGRAM = "sequenceDiagrams";
//#endif 


//#if 962797463 
public static final String ACTION_COLLABORATION_DIAGRAM =
        "collaborationDiagrams";
//#endif 


//#if 981696023 
public static final String ACTION_STATE_DIAGRAM = "stateDiagrams";
//#endif 


//#if 1926216819 
public static final String ACTION_DEPLOYMENT_DIAGRAM = "deploymentDiagrams";
//#endif 


//#if -1348200824 
public static final String ACTION_OPEN_CRITICS = "openCritics";
//#endif 


//#if -1951090470 
private static final Logger LOG = Logger.getLogger(ShortcutMgr.class);
//#endif 


//#if -739294073 
public static final String ACTION_ACTIVITY_DIAGRAM = "activityDiagrams";
//#endif 


//#if -68640874 
static
    {
        // First of all, let's set up the duplicate hash. This hash contains
        // all the duplicate key for another key.
        //
        // TODO: every duplicate.put() is done twice - but how to avoid this?
        duplicate.put(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, DEFAULT_MASK),
                      KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, DEFAULT_MASK));
        duplicate.put(KeyStroke.getKeyStroke(
                          KeyEvent.VK_SUBTRACT, DEFAULT_MASK),
                      KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, DEFAULT_MASK));
        duplicate.put(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, DEFAULT_MASK),
                      KeyStroke.getKeyStroke(KeyEvent.VK_ADD, DEFAULT_MASK));
        duplicate.put(KeyStroke.getKeyStroke(KeyEvent.VK_ADD, DEFAULT_MASK),
                      KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, DEFAULT_MASK));

        // file menu
        putDefaultShortcut(ACTION_NEW_PROJECT, KeyStroke.getKeyStroke(
                               KeyEvent.VK_N, DEFAULT_MASK), new ActionNew());
        putDefaultShortcut(ACTION_OPEN_PROJECT, KeyStroke.getKeyStroke(
                               KeyEvent.VK_O, DEFAULT_MASK), new ActionOpenProject());
        putDefaultShortcut(ACTION_SAVE_PROJECT, KeyStroke.getKeyStroke(
                               KeyEvent.VK_S, DEFAULT_MASK),
                           ProjectBrowser.getInstance().getSaveAction());
        putDefaultShortcut(ACTION_SAVE_PROJECT_AS, null,
                           new ActionSaveProjectAs());
        putDefaultShortcut(ACTION_REVERT_TO_SAVED, null,
                           new ActionRevertToSaved());
        putDefaultShortcut(ACTION_IMPORT_XMI, null, new ActionImportXMI());
        putDefaultShortcut(ACTION_EXPORT_XMI, null, new ActionExportXMI());
        putDefaultShortcut(ACTION_IMPORT_FROM_SOURCES, null,
                           ActionImportFromSources.getInstance());
        putDefaultShortcut(ACTION_PROJECT_SETTINGS, null,
                           new ActionProjectSettings());
        putDefaultShortcut(ACTION_PAGE_SETUP, null, new ActionPageSetup());
        putDefaultShortcut(ACTION_SAVE_GRAPHICS, null,
                           new ActionSaveGraphics());
        putDefaultShortcut(ACTION_SAVE_ALL_GRAPHICS, null,
                           new ActionSaveAllGraphics());
        putDefaultShortcut(ACTION_NOTATION, null, new ActionNotation());
        putDefaultShortcut(ACTION_PRINT, KeyStroke.getKeyStroke(KeyEvent.VK_P,
                           DEFAULT_MASK), new ActionPrint());

        // edit menu
        putDefaultShortcut(ACTION_SELECT_ALL, KeyStroke.getKeyStroke(
                               KeyEvent.VK_A, DEFAULT_MASK),
                           new ActionSelectAll());
        putDefaultShortcut(ACTION_REDO, KeyStroke.getKeyStroke(KeyEvent.VK_Y,
                           DEFAULT_MASK), ProjectActions.getInstance().getRedoAction());
        putDefaultShortcut(ACTION_UNDO, KeyStroke.getKeyStroke(KeyEvent.VK_Z,
                           DEFAULT_MASK), ProjectActions.getInstance().getUndoAction());
        putDefaultShortcut(ACTION_NAVIGATE_FORWARD, null,
                           new NavigateTargetForwardAction());
        putDefaultShortcut(ACTION_NAVIGATE_BACK, null,
                           new NavigateTargetBackAction());
        putDefaultShortcut(ACTION_SELECT_INVERT, null,
                           new ActionSelectInvert());
        putDefaultShortcut(ACTION_PERSPECTIVE_CONFIG, null,
                           new ActionPerspectiveConfig());
        putDefaultShortcut(ACTION_SETTINGS, null, new ActionSettings());
        putDefaultShortcut(ACTION_REMOVE_FROM_DIAGRAM, KeyStroke.getKeyStroke(
                               KeyEvent.VK_DELETE, 0), ProjectActions.getInstance()
                           .getRemoveFromDiagramAction());
        putDefaultShortcut(ACTION_DELETE_MODEL_ELEMENTS, KeyStroke
                           .getKeyStroke(KeyEvent.VK_DELETE, DEFAULT_MASK),
                           ActionDeleteModelElements.getTargetFollower());

        // view menu
        putDefaultShortcut(ACTION_GO_TO_DIAGRAM, null, new ActionGotoDiagram());
        putDefaultShortcut(ACTION_ZOOM_RESET, null, new ZoomAction(0.0));

        List gridActions = ActionAdjustGrid.createAdjustGridActions(true);
        Iterator i = gridActions.iterator();
        while (i.hasNext()) {
            AbstractAction cmdAG = (AbstractAction) i.next();
            putDefaultShortcut(ACTION_ADJUST_GRID + cmdAG.getValue("ID"),
                               (KeyStroke) cmdAG.getValue("shortcut"), cmdAG);
        }

        List snapActions = ActionAdjustSnap.createAdjustSnapActions();
        i = snapActions.iterator();
        while (i.hasNext()) {
            AbstractAction cmdAS = (AbstractAction) i.next();
            putDefaultShortcut(ACTION_ADJUST_GUIDE + cmdAS.getValue("ID"),
                               (KeyStroke) cmdAS.getValue("shortcut"), cmdAS);
        }

        putDefaultShortcut(ACTION_ADJUST_PAGE_BREAKS, null,
                           new ActionAdjustPageBreaks());
        putDefaultShortcut(ACTION_SHOW_XML_DUMP, null, new ActionShowXMLDump());

        putDefaultShortcut(ACTION_ZOOM_IN, KeyStroke.getKeyStroke(
                               KeyEvent.VK_PLUS, DEFAULT_MASK), new ZoomActionProxy(
                               (1.0) / (GenericArgoMenuBar.ZOOM_FACTOR)));

        putDefaultShortcut(ACTION_ZOOM_OUT, KeyStroke.getKeyStroke(
                               KeyEvent.VK_MINUS, DEFAULT_MASK), new ZoomActionProxy(
                               GenericArgoMenuBar.ZOOM_FACTOR));

        putDefaultShortcut(ACTION_FIND, KeyStroke.getKeyStroke(KeyEvent.VK_F3,
                           0), new ActionFind());

        // create menu





        putDefaultShortcut(ACTION_CLASS_DIAGRAM, null,
                           new ActionClassDiagram());

























        // generate menu
        putDefaultShortcut(ACTION_GENERATE_ONE, null, new ActionGenerateOne());
        putDefaultShortcut(ACTION_GENERATE_PROJECT_CODE, null,
                           new ActionGenerateProjectCode());
        putDefaultShortcut(ACTION_GENERATION_SETTINGS, null,
                           new ActionGenerationSettings());
        putDefaultShortcut(ACTION_GENERATE_ALL_CLASSES, KeyStroke.getKeyStroke(
                               KeyEvent.VK_F7, 0), new ActionGenerateAll());














        // help menu
        putDefaultShortcut(ACTION_SYSTEM_INFORMATION, null,
                           new ActionSystemInfo());
        putDefaultShortcut(ACTION_ABOUT_ARGOUML, null,
                           new ActionAboutArgoUML());

        // arrange menu
        putDefaultShortcut(ACTION_PREFERRED_SIZE, null,
                           new CmdSetPreferredSize());

        // align submenu
        putDefaultShortcut(ACTION_ALIGN_TOPS, null, new AlignAction(
                               AlignAction.ALIGN_TOPS));
        putDefaultShortcut(ACTION_ALIGN_BOTTOMS, null, new AlignAction(
                               AlignAction.ALIGN_BOTTOMS));
        putDefaultShortcut(ACTION_ALIGN_RIGHTS, KeyStroke.getKeyStroke(
                               KeyEvent.VK_R, DEFAULT_MASK),
                           new AlignAction(AlignAction.ALIGN_RIGHTS));
        putDefaultShortcut(ACTION_ALIGN_LEFTS, KeyStroke.getKeyStroke(
                               KeyEvent.VK_L, DEFAULT_MASK),
                           new AlignAction(AlignAction.ALIGN_LEFTS));
        putDefaultShortcut(ACTION_ALIGN_H_CENTERS, null, new AlignAction(
                               AlignAction.ALIGN_H_CENTERS));
        putDefaultShortcut(ACTION_ALIGN_V_CENTERS, null, new AlignAction(
                               AlignAction.ALIGN_V_CENTERS));
        putDefaultShortcut(ACTION_ALIGN_TO_GRID, null, new AlignAction(
                               AlignAction.ALIGN_TO_GRID));

        // distribute submenu
        putDefaultShortcut(ACTION_DISTRIBUTE_H_SPACING, null,
                           new DistributeAction(DistributeAction.H_SPACING));
        putDefaultShortcut(ACTION_DISTRIBUTE_H_CENTERS, null,
                           new DistributeAction(DistributeAction.H_CENTERS));
        putDefaultShortcut(ACTION_DISTRIBUTE_V_SPACING, null,
                           new DistributeAction(DistributeAction.V_SPACING));
        putDefaultShortcut(ACTION_DISTRIBUTE_V_CENTERS, null,
                           new DistributeAction(DistributeAction.V_CENTERS));

        // reorder submenu
        // TODO: I think this requires I18N, but not sure - tfm
        putDefaultShortcut(ACTION_REORDER_FORWARD, KeyStroke.getKeyStroke(
                               KeyEvent.VK_F, DEFAULT_MASK), new ReorderAction("Forward",
                                       ReorderAction.BRING_FORWARD));
        putDefaultShortcut(ACTION_REORDER_BACKWARD, KeyStroke.getKeyStroke(
                               KeyEvent.VK_B, DEFAULT_MASK), new ReorderAction(
                               "Backward",
                               ReorderAction.SEND_BACKWARD));
        putDefaultShortcut(ACTION_REORDER_TO_FRONT, KeyStroke.getKeyStroke(
                               KeyEvent.VK_F, SHIFTED_DEFAULT_MASK), new ReorderAction(
                               "ToFront",
                               ReorderAction.BRING_TO_FRONT));
        putDefaultShortcut(ACTION_REORDER_TO_BACK, KeyStroke.getKeyStroke(
                               KeyEvent.VK_B, SHIFTED_DEFAULT_MASK), new ReorderAction(
                               "ToBack",
                               ReorderAction.SEND_TO_BACK));

        // help menu
        putDefaultShortcut(ACTION_HELP,
                           KeyStroke.getKeyStroke( KeyEvent.VK_F1, 0),
                           new ActionHelp());
    }
//#endif 


//#if 980451855 
static
    {
        // First of all, let's set up the duplicate hash. This hash contains
        // all the duplicate key for another key.
        //
        // TODO: every duplicate.put() is done twice - but how to avoid this?
        duplicate.put(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, DEFAULT_MASK),
                      KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, DEFAULT_MASK));
        duplicate.put(KeyStroke.getKeyStroke(
                          KeyEvent.VK_SUBTRACT, DEFAULT_MASK),
                      KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, DEFAULT_MASK));
        duplicate.put(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, DEFAULT_MASK),
                      KeyStroke.getKeyStroke(KeyEvent.VK_ADD, DEFAULT_MASK));
        duplicate.put(KeyStroke.getKeyStroke(KeyEvent.VK_ADD, DEFAULT_MASK),
                      KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, DEFAULT_MASK));

        // file menu
        putDefaultShortcut(ACTION_NEW_PROJECT, KeyStroke.getKeyStroke(
                               KeyEvent.VK_N, DEFAULT_MASK), new ActionNew());
        putDefaultShortcut(ACTION_OPEN_PROJECT, KeyStroke.getKeyStroke(
                               KeyEvent.VK_O, DEFAULT_MASK), new ActionOpenProject());
        putDefaultShortcut(ACTION_SAVE_PROJECT, KeyStroke.getKeyStroke(
                               KeyEvent.VK_S, DEFAULT_MASK),
                           ProjectBrowser.getInstance().getSaveAction());
        putDefaultShortcut(ACTION_SAVE_PROJECT_AS, null,
                           new ActionSaveProjectAs());
        putDefaultShortcut(ACTION_REVERT_TO_SAVED, null,
                           new ActionRevertToSaved());
        putDefaultShortcut(ACTION_IMPORT_XMI, null, new ActionImportXMI());
        putDefaultShortcut(ACTION_EXPORT_XMI, null, new ActionExportXMI());
        putDefaultShortcut(ACTION_IMPORT_FROM_SOURCES, null,
                           ActionImportFromSources.getInstance());
        putDefaultShortcut(ACTION_PROJECT_SETTINGS, null,
                           new ActionProjectSettings());
        putDefaultShortcut(ACTION_PAGE_SETUP, null, new ActionPageSetup());
        putDefaultShortcut(ACTION_SAVE_GRAPHICS, null,
                           new ActionSaveGraphics());
        putDefaultShortcut(ACTION_SAVE_ALL_GRAPHICS, null,
                           new ActionSaveAllGraphics());
        putDefaultShortcut(ACTION_NOTATION, null, new ActionNotation());
        putDefaultShortcut(ACTION_PRINT, KeyStroke.getKeyStroke(KeyEvent.VK_P,
                           DEFAULT_MASK), new ActionPrint());

        // edit menu
        putDefaultShortcut(ACTION_SELECT_ALL, KeyStroke.getKeyStroke(
                               KeyEvent.VK_A, DEFAULT_MASK),
                           new ActionSelectAll());
        putDefaultShortcut(ACTION_REDO, KeyStroke.getKeyStroke(KeyEvent.VK_Y,
                           DEFAULT_MASK), ProjectActions.getInstance().getRedoAction());
        putDefaultShortcut(ACTION_UNDO, KeyStroke.getKeyStroke(KeyEvent.VK_Z,
                           DEFAULT_MASK), ProjectActions.getInstance().getUndoAction());
        putDefaultShortcut(ACTION_NAVIGATE_FORWARD, null,
                           new NavigateTargetForwardAction());
        putDefaultShortcut(ACTION_NAVIGATE_BACK, null,
                           new NavigateTargetBackAction());
        putDefaultShortcut(ACTION_SELECT_INVERT, null,
                           new ActionSelectInvert());
        putDefaultShortcut(ACTION_PERSPECTIVE_CONFIG, null,
                           new ActionPerspectiveConfig());
        putDefaultShortcut(ACTION_SETTINGS, null, new ActionSettings());
        putDefaultShortcut(ACTION_REMOVE_FROM_DIAGRAM, KeyStroke.getKeyStroke(
                               KeyEvent.VK_DELETE, 0), ProjectActions.getInstance()
                           .getRemoveFromDiagramAction());
        putDefaultShortcut(ACTION_DELETE_MODEL_ELEMENTS, KeyStroke
                           .getKeyStroke(KeyEvent.VK_DELETE, DEFAULT_MASK),
                           ActionDeleteModelElements.getTargetFollower());

        // view menu
        putDefaultShortcut(ACTION_GO_TO_DIAGRAM, null, new ActionGotoDiagram());
        putDefaultShortcut(ACTION_ZOOM_RESET, null, new ZoomAction(0.0));

        List gridActions = ActionAdjustGrid.createAdjustGridActions(true);
        Iterator i = gridActions.iterator();
        while (i.hasNext()) {
            AbstractAction cmdAG = (AbstractAction) i.next();
            putDefaultShortcut(ACTION_ADJUST_GRID + cmdAG.getValue("ID"),
                               (KeyStroke) cmdAG.getValue("shortcut"), cmdAG);
        }

        List snapActions = ActionAdjustSnap.createAdjustSnapActions();
        i = snapActions.iterator();
        while (i.hasNext()) {
            AbstractAction cmdAS = (AbstractAction) i.next();
            putDefaultShortcut(ACTION_ADJUST_GUIDE + cmdAS.getValue("ID"),
                               (KeyStroke) cmdAS.getValue("shortcut"), cmdAS);
        }

        putDefaultShortcut(ACTION_ADJUST_PAGE_BREAKS, null,
                           new ActionAdjustPageBreaks());
        putDefaultShortcut(ACTION_SHOW_XML_DUMP, null, new ActionShowXMLDump());

        putDefaultShortcut(ACTION_ZOOM_IN, KeyStroke.getKeyStroke(
                               KeyEvent.VK_PLUS, DEFAULT_MASK), new ZoomActionProxy(
                               (1.0) / (GenericArgoMenuBar.ZOOM_FACTOR)));

        putDefaultShortcut(ACTION_ZOOM_OUT, KeyStroke.getKeyStroke(
                               KeyEvent.VK_MINUS, DEFAULT_MASK), new ZoomActionProxy(
                               GenericArgoMenuBar.ZOOM_FACTOR));

        putDefaultShortcut(ACTION_FIND, KeyStroke.getKeyStroke(KeyEvent.VK_F3,
                           0), new ActionFind());

        // create menu


        putDefaultShortcut(ACTION_USE_CASE_DIAGRAM, null,
                           new ActionUseCaseDiagram());

        putDefaultShortcut(ACTION_CLASS_DIAGRAM, null,
                           new ActionClassDiagram());


        putDefaultShortcut(ACTION_SEQUENCE_DIAGRAM, null,
                           new ActionSequenceDiagram());



        putDefaultShortcut(ACTION_COLLABORATION_DIAGRAM, null,
                           new ActionCollaborationDiagram());



        putDefaultShortcut(ACTION_STATE_DIAGRAM, null,
                           new ActionStateDiagram());








        putDefaultShortcut(ACTION_DEPLOYMENT_DIAGRAM, null,
                           new ActionDeploymentDiagram());

        // generate menu
        putDefaultShortcut(ACTION_GENERATE_ONE, null, new ActionGenerateOne());
        putDefaultShortcut(ACTION_GENERATE_PROJECT_CODE, null,
                           new ActionGenerateProjectCode());
        putDefaultShortcut(ACTION_GENERATION_SETTINGS, null,
                           new ActionGenerationSettings());
        putDefaultShortcut(ACTION_GENERATE_ALL_CLASSES, KeyStroke.getKeyStroke(
                               KeyEvent.VK_F7, 0), new ActionGenerateAll());




        // critique menu
        // TODO: This dependency should be inverted with the Critics subsystem
        // registering its desired shortcuts with us - tfm
        putDefaultShortcut(ACTION_AUTO_CRITIQUE, null,
                           new ActionAutoCritique());
        putDefaultShortcut(ACTION_OPEN_DECISIONS, null,
                           new ActionOpenDecisions());
        putDefaultShortcut(ACTION_OPEN_GOALS, null, new ActionOpenGoals());
        putDefaultShortcut(ACTION_OPEN_CRITICS, null, new ActionOpenCritics());

        // help menu
        putDefaultShortcut(ACTION_SYSTEM_INFORMATION, null,
                           new ActionSystemInfo());
        putDefaultShortcut(ACTION_ABOUT_ARGOUML, null,
                           new ActionAboutArgoUML());

        // arrange menu
        putDefaultShortcut(ACTION_PREFERRED_SIZE, null,
                           new CmdSetPreferredSize());

        // align submenu
        putDefaultShortcut(ACTION_ALIGN_TOPS, null, new AlignAction(
                               AlignAction.ALIGN_TOPS));
        putDefaultShortcut(ACTION_ALIGN_BOTTOMS, null, new AlignAction(
                               AlignAction.ALIGN_BOTTOMS));
        putDefaultShortcut(ACTION_ALIGN_RIGHTS, KeyStroke.getKeyStroke(
                               KeyEvent.VK_R, DEFAULT_MASK),
                           new AlignAction(AlignAction.ALIGN_RIGHTS));
        putDefaultShortcut(ACTION_ALIGN_LEFTS, KeyStroke.getKeyStroke(
                               KeyEvent.VK_L, DEFAULT_MASK),
                           new AlignAction(AlignAction.ALIGN_LEFTS));
        putDefaultShortcut(ACTION_ALIGN_H_CENTERS, null, new AlignAction(
                               AlignAction.ALIGN_H_CENTERS));
        putDefaultShortcut(ACTION_ALIGN_V_CENTERS, null, new AlignAction(
                               AlignAction.ALIGN_V_CENTERS));
        putDefaultShortcut(ACTION_ALIGN_TO_GRID, null, new AlignAction(
                               AlignAction.ALIGN_TO_GRID));

        // distribute submenu
        putDefaultShortcut(ACTION_DISTRIBUTE_H_SPACING, null,
                           new DistributeAction(DistributeAction.H_SPACING));
        putDefaultShortcut(ACTION_DISTRIBUTE_H_CENTERS, null,
                           new DistributeAction(DistributeAction.H_CENTERS));
        putDefaultShortcut(ACTION_DISTRIBUTE_V_SPACING, null,
                           new DistributeAction(DistributeAction.V_SPACING));
        putDefaultShortcut(ACTION_DISTRIBUTE_V_CENTERS, null,
                           new DistributeAction(DistributeAction.V_CENTERS));

        // reorder submenu
        // TODO: I think this requires I18N, but not sure - tfm
        putDefaultShortcut(ACTION_REORDER_FORWARD, KeyStroke.getKeyStroke(
                               KeyEvent.VK_F, DEFAULT_MASK), new ReorderAction("Forward",
                                       ReorderAction.BRING_FORWARD));
        putDefaultShortcut(ACTION_REORDER_BACKWARD, KeyStroke.getKeyStroke(
                               KeyEvent.VK_B, DEFAULT_MASK), new ReorderAction(
                               "Backward",
                               ReorderAction.SEND_BACKWARD));
        putDefaultShortcut(ACTION_REORDER_TO_FRONT, KeyStroke.getKeyStroke(
                               KeyEvent.VK_F, SHIFTED_DEFAULT_MASK), new ReorderAction(
                               "ToFront",
                               ReorderAction.BRING_TO_FRONT));
        putDefaultShortcut(ACTION_REORDER_TO_BACK, KeyStroke.getKeyStroke(
                               KeyEvent.VK_B, SHIFTED_DEFAULT_MASK), new ReorderAction(
                               "ToBack",
                               ReorderAction.SEND_TO_BACK));

        // help menu
        putDefaultShortcut(ACTION_HELP,
                           KeyStroke.getKeyStroke( KeyEvent.VK_F1, 0),
                           new ActionHelp());
    }
//#endif 


//#if -334721883 
static
    {
        // First of all, let's set up the duplicate hash. This hash contains
        // all the duplicate key for another key.
        //
        // TODO: every duplicate.put() is done twice - but how to avoid this?
        duplicate.put(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, DEFAULT_MASK),
                      KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, DEFAULT_MASK));
        duplicate.put(KeyStroke.getKeyStroke(
                          KeyEvent.VK_SUBTRACT, DEFAULT_MASK),
                      KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, DEFAULT_MASK));
        duplicate.put(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, DEFAULT_MASK),
                      KeyStroke.getKeyStroke(KeyEvent.VK_ADD, DEFAULT_MASK));
        duplicate.put(KeyStroke.getKeyStroke(KeyEvent.VK_ADD, DEFAULT_MASK),
                      KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, DEFAULT_MASK));

        // file menu
        putDefaultShortcut(ACTION_NEW_PROJECT, KeyStroke.getKeyStroke(
                               KeyEvent.VK_N, DEFAULT_MASK), new ActionNew());
        putDefaultShortcut(ACTION_OPEN_PROJECT, KeyStroke.getKeyStroke(
                               KeyEvent.VK_O, DEFAULT_MASK), new ActionOpenProject());
        putDefaultShortcut(ACTION_SAVE_PROJECT, KeyStroke.getKeyStroke(
                               KeyEvent.VK_S, DEFAULT_MASK),
                           ProjectBrowser.getInstance().getSaveAction());
        putDefaultShortcut(ACTION_SAVE_PROJECT_AS, null,
                           new ActionSaveProjectAs());
        putDefaultShortcut(ACTION_REVERT_TO_SAVED, null,
                           new ActionRevertToSaved());
        putDefaultShortcut(ACTION_IMPORT_XMI, null, new ActionImportXMI());
        putDefaultShortcut(ACTION_EXPORT_XMI, null, new ActionExportXMI());
        putDefaultShortcut(ACTION_IMPORT_FROM_SOURCES, null,
                           ActionImportFromSources.getInstance());
        putDefaultShortcut(ACTION_PROJECT_SETTINGS, null,
                           new ActionProjectSettings());
        putDefaultShortcut(ACTION_PAGE_SETUP, null, new ActionPageSetup());
        putDefaultShortcut(ACTION_SAVE_GRAPHICS, null,
                           new ActionSaveGraphics());
        putDefaultShortcut(ACTION_SAVE_ALL_GRAPHICS, null,
                           new ActionSaveAllGraphics());
        putDefaultShortcut(ACTION_NOTATION, null, new ActionNotation());
        putDefaultShortcut(ACTION_PRINT, KeyStroke.getKeyStroke(KeyEvent.VK_P,
                           DEFAULT_MASK), new ActionPrint());

        // edit menu
        putDefaultShortcut(ACTION_SELECT_ALL, KeyStroke.getKeyStroke(
                               KeyEvent.VK_A, DEFAULT_MASK),
                           new ActionSelectAll());
        putDefaultShortcut(ACTION_REDO, KeyStroke.getKeyStroke(KeyEvent.VK_Y,
                           DEFAULT_MASK), ProjectActions.getInstance().getRedoAction());
        putDefaultShortcut(ACTION_UNDO, KeyStroke.getKeyStroke(KeyEvent.VK_Z,
                           DEFAULT_MASK), ProjectActions.getInstance().getUndoAction());
        putDefaultShortcut(ACTION_NAVIGATE_FORWARD, null,
                           new NavigateTargetForwardAction());
        putDefaultShortcut(ACTION_NAVIGATE_BACK, null,
                           new NavigateTargetBackAction());
        putDefaultShortcut(ACTION_SELECT_INVERT, null,
                           new ActionSelectInvert());
        putDefaultShortcut(ACTION_PERSPECTIVE_CONFIG, null,
                           new ActionPerspectiveConfig());
        putDefaultShortcut(ACTION_SETTINGS, null, new ActionSettings());
        putDefaultShortcut(ACTION_REMOVE_FROM_DIAGRAM, KeyStroke.getKeyStroke(
                               KeyEvent.VK_DELETE, 0), ProjectActions.getInstance()
                           .getRemoveFromDiagramAction());
        putDefaultShortcut(ACTION_DELETE_MODEL_ELEMENTS, KeyStroke
                           .getKeyStroke(KeyEvent.VK_DELETE, DEFAULT_MASK),
                           ActionDeleteModelElements.getTargetFollower());

        // view menu
        putDefaultShortcut(ACTION_GO_TO_DIAGRAM, null, new ActionGotoDiagram());
        putDefaultShortcut(ACTION_ZOOM_RESET, null, new ZoomAction(0.0));

        List gridActions = ActionAdjustGrid.createAdjustGridActions(true);
        Iterator i = gridActions.iterator();
        while (i.hasNext()) {
            AbstractAction cmdAG = (AbstractAction) i.next();
            putDefaultShortcut(ACTION_ADJUST_GRID + cmdAG.getValue("ID"),
                               (KeyStroke) cmdAG.getValue("shortcut"), cmdAG);
        }

        List snapActions = ActionAdjustSnap.createAdjustSnapActions();
        i = snapActions.iterator();
        while (i.hasNext()) {
            AbstractAction cmdAS = (AbstractAction) i.next();
            putDefaultShortcut(ACTION_ADJUST_GUIDE + cmdAS.getValue("ID"),
                               (KeyStroke) cmdAS.getValue("shortcut"), cmdAS);
        }

        putDefaultShortcut(ACTION_ADJUST_PAGE_BREAKS, null,
                           new ActionAdjustPageBreaks());
        putDefaultShortcut(ACTION_SHOW_XML_DUMP, null, new ActionShowXMLDump());

        putDefaultShortcut(ACTION_ZOOM_IN, KeyStroke.getKeyStroke(
                               KeyEvent.VK_PLUS, DEFAULT_MASK), new ZoomActionProxy(
                               (1.0) / (GenericArgoMenuBar.ZOOM_FACTOR)));

        putDefaultShortcut(ACTION_ZOOM_OUT, KeyStroke.getKeyStroke(
                               KeyEvent.VK_MINUS, DEFAULT_MASK), new ZoomActionProxy(
                               GenericArgoMenuBar.ZOOM_FACTOR));

        putDefaultShortcut(ACTION_FIND, KeyStroke.getKeyStroke(KeyEvent.VK_F3,
                           0), new ActionFind());

        // create menu


        putDefaultShortcut(ACTION_USE_CASE_DIAGRAM, null,
                           new ActionUseCaseDiagram());

        putDefaultShortcut(ACTION_CLASS_DIAGRAM, null,
                           new ActionClassDiagram());


        putDefaultShortcut(ACTION_SEQUENCE_DIAGRAM, null,
                           new ActionSequenceDiagram());



        putDefaultShortcut(ACTION_COLLABORATION_DIAGRAM, null,
                           new ActionCollaborationDiagram());



        putDefaultShortcut(ACTION_STATE_DIAGRAM, null,
                           new ActionStateDiagram());



        putDefaultShortcut(ACTION_ACTIVITY_DIAGRAM, null,
                           new ActionActivityDiagram());



        putDefaultShortcut(ACTION_DEPLOYMENT_DIAGRAM, null,
                           new ActionDeploymentDiagram());

        // generate menu
        putDefaultShortcut(ACTION_GENERATE_ONE, null, new ActionGenerateOne());
        putDefaultShortcut(ACTION_GENERATE_PROJECT_CODE, null,
                           new ActionGenerateProjectCode());
        putDefaultShortcut(ACTION_GENERATION_SETTINGS, null,
                           new ActionGenerationSettings());
        putDefaultShortcut(ACTION_GENERATE_ALL_CLASSES, KeyStroke.getKeyStroke(
                               KeyEvent.VK_F7, 0), new ActionGenerateAll());




        // critique menu
        // TODO: This dependency should be inverted with the Critics subsystem
        // registering its desired shortcuts with us - tfm
        putDefaultShortcut(ACTION_AUTO_CRITIQUE, null,
                           new ActionAutoCritique());
        putDefaultShortcut(ACTION_OPEN_DECISIONS, null,
                           new ActionOpenDecisions());
        putDefaultShortcut(ACTION_OPEN_GOALS, null, new ActionOpenGoals());
        putDefaultShortcut(ACTION_OPEN_CRITICS, null, new ActionOpenCritics());

        // help menu
        putDefaultShortcut(ACTION_SYSTEM_INFORMATION, null,
                           new ActionSystemInfo());
        putDefaultShortcut(ACTION_ABOUT_ARGOUML, null,
                           new ActionAboutArgoUML());

        // arrange menu
        putDefaultShortcut(ACTION_PREFERRED_SIZE, null,
                           new CmdSetPreferredSize());

        // align submenu
        putDefaultShortcut(ACTION_ALIGN_TOPS, null, new AlignAction(
                               AlignAction.ALIGN_TOPS));
        putDefaultShortcut(ACTION_ALIGN_BOTTOMS, null, new AlignAction(
                               AlignAction.ALIGN_BOTTOMS));
        putDefaultShortcut(ACTION_ALIGN_RIGHTS, KeyStroke.getKeyStroke(
                               KeyEvent.VK_R, DEFAULT_MASK),
                           new AlignAction(AlignAction.ALIGN_RIGHTS));
        putDefaultShortcut(ACTION_ALIGN_LEFTS, KeyStroke.getKeyStroke(
                               KeyEvent.VK_L, DEFAULT_MASK),
                           new AlignAction(AlignAction.ALIGN_LEFTS));
        putDefaultShortcut(ACTION_ALIGN_H_CENTERS, null, new AlignAction(
                               AlignAction.ALIGN_H_CENTERS));
        putDefaultShortcut(ACTION_ALIGN_V_CENTERS, null, new AlignAction(
                               AlignAction.ALIGN_V_CENTERS));
        putDefaultShortcut(ACTION_ALIGN_TO_GRID, null, new AlignAction(
                               AlignAction.ALIGN_TO_GRID));

        // distribute submenu
        putDefaultShortcut(ACTION_DISTRIBUTE_H_SPACING, null,
                           new DistributeAction(DistributeAction.H_SPACING));
        putDefaultShortcut(ACTION_DISTRIBUTE_H_CENTERS, null,
                           new DistributeAction(DistributeAction.H_CENTERS));
        putDefaultShortcut(ACTION_DISTRIBUTE_V_SPACING, null,
                           new DistributeAction(DistributeAction.V_SPACING));
        putDefaultShortcut(ACTION_DISTRIBUTE_V_CENTERS, null,
                           new DistributeAction(DistributeAction.V_CENTERS));

        // reorder submenu
        // TODO: I think this requires I18N, but not sure - tfm
        putDefaultShortcut(ACTION_REORDER_FORWARD, KeyStroke.getKeyStroke(
                               KeyEvent.VK_F, DEFAULT_MASK), new ReorderAction("Forward",
                                       ReorderAction.BRING_FORWARD));
        putDefaultShortcut(ACTION_REORDER_BACKWARD, KeyStroke.getKeyStroke(
                               KeyEvent.VK_B, DEFAULT_MASK), new ReorderAction(
                               "Backward",
                               ReorderAction.SEND_BACKWARD));
        putDefaultShortcut(ACTION_REORDER_TO_FRONT, KeyStroke.getKeyStroke(
                               KeyEvent.VK_F, SHIFTED_DEFAULT_MASK), new ReorderAction(
                               "ToFront",
                               ReorderAction.BRING_TO_FRONT));
        putDefaultShortcut(ACTION_REORDER_TO_BACK, KeyStroke.getKeyStroke(
                               KeyEvent.VK_B, SHIFTED_DEFAULT_MASK), new ReorderAction(
                               "ToBack",
                               ReorderAction.SEND_TO_BACK));

        // help menu
        putDefaultShortcut(ACTION_HELP,
                           KeyStroke.getKeyStroke( KeyEvent.VK_F1, 0),
                           new ActionHelp());
    }
//#endif 


//#if -808204485 
static
    {
        // First of all, let's set up the duplicate hash. This hash contains
        // all the duplicate key for another key.
        //
        // TODO: every duplicate.put() is done twice - but how to avoid this?
        duplicate.put(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, DEFAULT_MASK),
                      KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, DEFAULT_MASK));
        duplicate.put(KeyStroke.getKeyStroke(
                          KeyEvent.VK_SUBTRACT, DEFAULT_MASK),
                      KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, DEFAULT_MASK));
        duplicate.put(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, DEFAULT_MASK),
                      KeyStroke.getKeyStroke(KeyEvent.VK_ADD, DEFAULT_MASK));
        duplicate.put(KeyStroke.getKeyStroke(KeyEvent.VK_ADD, DEFAULT_MASK),
                      KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, DEFAULT_MASK));

        // file menu
        putDefaultShortcut(ACTION_NEW_PROJECT, KeyStroke.getKeyStroke(
                               KeyEvent.VK_N, DEFAULT_MASK), new ActionNew());
        putDefaultShortcut(ACTION_OPEN_PROJECT, KeyStroke.getKeyStroke(
                               KeyEvent.VK_O, DEFAULT_MASK), new ActionOpenProject());
        putDefaultShortcut(ACTION_SAVE_PROJECT, KeyStroke.getKeyStroke(
                               KeyEvent.VK_S, DEFAULT_MASK),
                           ProjectBrowser.getInstance().getSaveAction());
        putDefaultShortcut(ACTION_SAVE_PROJECT_AS, null,
                           new ActionSaveProjectAs());
        putDefaultShortcut(ACTION_REVERT_TO_SAVED, null,
                           new ActionRevertToSaved());
        putDefaultShortcut(ACTION_IMPORT_XMI, null, new ActionImportXMI());
        putDefaultShortcut(ACTION_EXPORT_XMI, null, new ActionExportXMI());
        putDefaultShortcut(ACTION_IMPORT_FROM_SOURCES, null,
                           ActionImportFromSources.getInstance());
        putDefaultShortcut(ACTION_PROJECT_SETTINGS, null,
                           new ActionProjectSettings());
        putDefaultShortcut(ACTION_PAGE_SETUP, null, new ActionPageSetup());
        putDefaultShortcut(ACTION_SAVE_GRAPHICS, null,
                           new ActionSaveGraphics());
        putDefaultShortcut(ACTION_SAVE_ALL_GRAPHICS, null,
                           new ActionSaveAllGraphics());
        putDefaultShortcut(ACTION_NOTATION, null, new ActionNotation());
        putDefaultShortcut(ACTION_PRINT, KeyStroke.getKeyStroke(KeyEvent.VK_P,
                           DEFAULT_MASK), new ActionPrint());

        // edit menu
        putDefaultShortcut(ACTION_SELECT_ALL, KeyStroke.getKeyStroke(
                               KeyEvent.VK_A, DEFAULT_MASK),
                           new ActionSelectAll());
        putDefaultShortcut(ACTION_REDO, KeyStroke.getKeyStroke(KeyEvent.VK_Y,
                           DEFAULT_MASK), ProjectActions.getInstance().getRedoAction());
        putDefaultShortcut(ACTION_UNDO, KeyStroke.getKeyStroke(KeyEvent.VK_Z,
                           DEFAULT_MASK), ProjectActions.getInstance().getUndoAction());
        putDefaultShortcut(ACTION_NAVIGATE_FORWARD, null,
                           new NavigateTargetForwardAction());
        putDefaultShortcut(ACTION_NAVIGATE_BACK, null,
                           new NavigateTargetBackAction());
        putDefaultShortcut(ACTION_SELECT_INVERT, null,
                           new ActionSelectInvert());
        putDefaultShortcut(ACTION_PERSPECTIVE_CONFIG, null,
                           new ActionPerspectiveConfig());
        putDefaultShortcut(ACTION_SETTINGS, null, new ActionSettings());
        putDefaultShortcut(ACTION_REMOVE_FROM_DIAGRAM, KeyStroke.getKeyStroke(
                               KeyEvent.VK_DELETE, 0), ProjectActions.getInstance()
                           .getRemoveFromDiagramAction());
        putDefaultShortcut(ACTION_DELETE_MODEL_ELEMENTS, KeyStroke
                           .getKeyStroke(KeyEvent.VK_DELETE, DEFAULT_MASK),
                           ActionDeleteModelElements.getTargetFollower());

        // view menu
        putDefaultShortcut(ACTION_GO_TO_DIAGRAM, null, new ActionGotoDiagram());
        putDefaultShortcut(ACTION_ZOOM_RESET, null, new ZoomAction(0.0));

        List gridActions = ActionAdjustGrid.createAdjustGridActions(true);
        Iterator i = gridActions.iterator();
        while (i.hasNext()) {
            AbstractAction cmdAG = (AbstractAction) i.next();
            putDefaultShortcut(ACTION_ADJUST_GRID + cmdAG.getValue("ID"),
                               (KeyStroke) cmdAG.getValue("shortcut"), cmdAG);
        }

        List snapActions = ActionAdjustSnap.createAdjustSnapActions();
        i = snapActions.iterator();
        while (i.hasNext()) {
            AbstractAction cmdAS = (AbstractAction) i.next();
            putDefaultShortcut(ACTION_ADJUST_GUIDE + cmdAS.getValue("ID"),
                               (KeyStroke) cmdAS.getValue("shortcut"), cmdAS);
        }

        putDefaultShortcut(ACTION_ADJUST_PAGE_BREAKS, null,
                           new ActionAdjustPageBreaks());
        putDefaultShortcut(ACTION_SHOW_XML_DUMP, null, new ActionShowXMLDump());

        putDefaultShortcut(ACTION_ZOOM_IN, KeyStroke.getKeyStroke(
                               KeyEvent.VK_PLUS, DEFAULT_MASK), new ZoomActionProxy(
                               (1.0) / (GenericArgoMenuBar.ZOOM_FACTOR)));

        putDefaultShortcut(ACTION_ZOOM_OUT, KeyStroke.getKeyStroke(
                               KeyEvent.VK_MINUS, DEFAULT_MASK), new ZoomActionProxy(
                               GenericArgoMenuBar.ZOOM_FACTOR));

        putDefaultShortcut(ACTION_FIND, KeyStroke.getKeyStroke(KeyEvent.VK_F3,
                           0), new ActionFind());

        // create menu


        putDefaultShortcut(ACTION_USE_CASE_DIAGRAM, null,
                           new ActionUseCaseDiagram());

        putDefaultShortcut(ACTION_CLASS_DIAGRAM, null,
                           new ActionClassDiagram());


        putDefaultShortcut(ACTION_SEQUENCE_DIAGRAM, null,
                           new ActionSequenceDiagram());



        putDefaultShortcut(ACTION_COLLABORATION_DIAGRAM, null,
                           new ActionCollaborationDiagram());



        putDefaultShortcut(ACTION_STATE_DIAGRAM, null,
                           new ActionStateDiagram());



        putDefaultShortcut(ACTION_ACTIVITY_DIAGRAM, null,
                           new ActionActivityDiagram());



        putDefaultShortcut(ACTION_DEPLOYMENT_DIAGRAM, null,
                           new ActionDeploymentDiagram());

        // generate menu
        putDefaultShortcut(ACTION_GENERATE_ONE, null, new ActionGenerateOne());
        putDefaultShortcut(ACTION_GENERATE_PROJECT_CODE, null,
                           new ActionGenerateProjectCode());
        putDefaultShortcut(ACTION_GENERATION_SETTINGS, null,
                           new ActionGenerationSettings());
        putDefaultShortcut(ACTION_GENERATE_ALL_CLASSES, KeyStroke.getKeyStroke(
                               KeyEvent.VK_F7, 0), new ActionGenerateAll());














        // help menu
        putDefaultShortcut(ACTION_SYSTEM_INFORMATION, null,
                           new ActionSystemInfo());
        putDefaultShortcut(ACTION_ABOUT_ARGOUML, null,
                           new ActionAboutArgoUML());

        // arrange menu
        putDefaultShortcut(ACTION_PREFERRED_SIZE, null,
                           new CmdSetPreferredSize());

        // align submenu
        putDefaultShortcut(ACTION_ALIGN_TOPS, null, new AlignAction(
                               AlignAction.ALIGN_TOPS));
        putDefaultShortcut(ACTION_ALIGN_BOTTOMS, null, new AlignAction(
                               AlignAction.ALIGN_BOTTOMS));
        putDefaultShortcut(ACTION_ALIGN_RIGHTS, KeyStroke.getKeyStroke(
                               KeyEvent.VK_R, DEFAULT_MASK),
                           new AlignAction(AlignAction.ALIGN_RIGHTS));
        putDefaultShortcut(ACTION_ALIGN_LEFTS, KeyStroke.getKeyStroke(
                               KeyEvent.VK_L, DEFAULT_MASK),
                           new AlignAction(AlignAction.ALIGN_LEFTS));
        putDefaultShortcut(ACTION_ALIGN_H_CENTERS, null, new AlignAction(
                               AlignAction.ALIGN_H_CENTERS));
        putDefaultShortcut(ACTION_ALIGN_V_CENTERS, null, new AlignAction(
                               AlignAction.ALIGN_V_CENTERS));
        putDefaultShortcut(ACTION_ALIGN_TO_GRID, null, new AlignAction(
                               AlignAction.ALIGN_TO_GRID));

        // distribute submenu
        putDefaultShortcut(ACTION_DISTRIBUTE_H_SPACING, null,
                           new DistributeAction(DistributeAction.H_SPACING));
        putDefaultShortcut(ACTION_DISTRIBUTE_H_CENTERS, null,
                           new DistributeAction(DistributeAction.H_CENTERS));
        putDefaultShortcut(ACTION_DISTRIBUTE_V_SPACING, null,
                           new DistributeAction(DistributeAction.V_SPACING));
        putDefaultShortcut(ACTION_DISTRIBUTE_V_CENTERS, null,
                           new DistributeAction(DistributeAction.V_CENTERS));

        // reorder submenu
        // TODO: I think this requires I18N, but not sure - tfm
        putDefaultShortcut(ACTION_REORDER_FORWARD, KeyStroke.getKeyStroke(
                               KeyEvent.VK_F, DEFAULT_MASK), new ReorderAction("Forward",
                                       ReorderAction.BRING_FORWARD));
        putDefaultShortcut(ACTION_REORDER_BACKWARD, KeyStroke.getKeyStroke(
                               KeyEvent.VK_B, DEFAULT_MASK), new ReorderAction(
                               "Backward",
                               ReorderAction.SEND_BACKWARD));
        putDefaultShortcut(ACTION_REORDER_TO_FRONT, KeyStroke.getKeyStroke(
                               KeyEvent.VK_F, SHIFTED_DEFAULT_MASK), new ReorderAction(
                               "ToFront",
                               ReorderAction.BRING_TO_FRONT));
        putDefaultShortcut(ACTION_REORDER_TO_BACK, KeyStroke.getKeyStroke(
                               KeyEvent.VK_B, SHIFTED_DEFAULT_MASK), new ReorderAction(
                               "ToBack",
                               ReorderAction.SEND_TO_BACK));

        // help menu
        putDefaultShortcut(ACTION_HELP,
                           KeyStroke.getKeyStroke( KeyEvent.VK_F1, 0),
                           new ActionHelp());
    }
//#endif 


//#if -871339313 
static
    {
        // First of all, let's set up the duplicate hash. This hash contains
        // all the duplicate key for another key.
        //
        // TODO: every duplicate.put() is done twice - but how to avoid this?
        duplicate.put(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, DEFAULT_MASK),
                      KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, DEFAULT_MASK));
        duplicate.put(KeyStroke.getKeyStroke(
                          KeyEvent.VK_SUBTRACT, DEFAULT_MASK),
                      KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, DEFAULT_MASK));
        duplicate.put(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, DEFAULT_MASK),
                      KeyStroke.getKeyStroke(KeyEvent.VK_ADD, DEFAULT_MASK));
        duplicate.put(KeyStroke.getKeyStroke(KeyEvent.VK_ADD, DEFAULT_MASK),
                      KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, DEFAULT_MASK));

        // file menu
        putDefaultShortcut(ACTION_NEW_PROJECT, KeyStroke.getKeyStroke(
                               KeyEvent.VK_N, DEFAULT_MASK), new ActionNew());
        putDefaultShortcut(ACTION_OPEN_PROJECT, KeyStroke.getKeyStroke(
                               KeyEvent.VK_O, DEFAULT_MASK), new ActionOpenProject());
        putDefaultShortcut(ACTION_SAVE_PROJECT, KeyStroke.getKeyStroke(
                               KeyEvent.VK_S, DEFAULT_MASK),
                           ProjectBrowser.getInstance().getSaveAction());
        putDefaultShortcut(ACTION_SAVE_PROJECT_AS, null,
                           new ActionSaveProjectAs());
        putDefaultShortcut(ACTION_REVERT_TO_SAVED, null,
                           new ActionRevertToSaved());
        putDefaultShortcut(ACTION_IMPORT_XMI, null, new ActionImportXMI());
        putDefaultShortcut(ACTION_EXPORT_XMI, null, new ActionExportXMI());
        putDefaultShortcut(ACTION_IMPORT_FROM_SOURCES, null,
                           ActionImportFromSources.getInstance());
        putDefaultShortcut(ACTION_PROJECT_SETTINGS, null,
                           new ActionProjectSettings());
        putDefaultShortcut(ACTION_PAGE_SETUP, null, new ActionPageSetup());
        putDefaultShortcut(ACTION_SAVE_GRAPHICS, null,
                           new ActionSaveGraphics());
        putDefaultShortcut(ACTION_SAVE_ALL_GRAPHICS, null,
                           new ActionSaveAllGraphics());
        putDefaultShortcut(ACTION_NOTATION, null, new ActionNotation());
        putDefaultShortcut(ACTION_PRINT, KeyStroke.getKeyStroke(KeyEvent.VK_P,
                           DEFAULT_MASK), new ActionPrint());

        // edit menu
        putDefaultShortcut(ACTION_SELECT_ALL, KeyStroke.getKeyStroke(
                               KeyEvent.VK_A, DEFAULT_MASK),
                           new ActionSelectAll());
        putDefaultShortcut(ACTION_REDO, KeyStroke.getKeyStroke(KeyEvent.VK_Y,
                           DEFAULT_MASK), ProjectActions.getInstance().getRedoAction());
        putDefaultShortcut(ACTION_UNDO, KeyStroke.getKeyStroke(KeyEvent.VK_Z,
                           DEFAULT_MASK), ProjectActions.getInstance().getUndoAction());
        putDefaultShortcut(ACTION_NAVIGATE_FORWARD, null,
                           new NavigateTargetForwardAction());
        putDefaultShortcut(ACTION_NAVIGATE_BACK, null,
                           new NavigateTargetBackAction());
        putDefaultShortcut(ACTION_SELECT_INVERT, null,
                           new ActionSelectInvert());
        putDefaultShortcut(ACTION_PERSPECTIVE_CONFIG, null,
                           new ActionPerspectiveConfig());
        putDefaultShortcut(ACTION_SETTINGS, null, new ActionSettings());
        putDefaultShortcut(ACTION_REMOVE_FROM_DIAGRAM, KeyStroke.getKeyStroke(
                               KeyEvent.VK_DELETE, 0), ProjectActions.getInstance()
                           .getRemoveFromDiagramAction());
        putDefaultShortcut(ACTION_DELETE_MODEL_ELEMENTS, KeyStroke
                           .getKeyStroke(KeyEvent.VK_DELETE, DEFAULT_MASK),
                           ActionDeleteModelElements.getTargetFollower());

        // view menu
        putDefaultShortcut(ACTION_GO_TO_DIAGRAM, null, new ActionGotoDiagram());
        putDefaultShortcut(ACTION_ZOOM_RESET, null, new ZoomAction(0.0));

        List gridActions = ActionAdjustGrid.createAdjustGridActions(true);
        Iterator i = gridActions.iterator();
        while (i.hasNext()) {
            AbstractAction cmdAG = (AbstractAction) i.next();
            putDefaultShortcut(ACTION_ADJUST_GRID + cmdAG.getValue("ID"),
                               (KeyStroke) cmdAG.getValue("shortcut"), cmdAG);
        }

        List snapActions = ActionAdjustSnap.createAdjustSnapActions();
        i = snapActions.iterator();
        while (i.hasNext()) {
            AbstractAction cmdAS = (AbstractAction) i.next();
            putDefaultShortcut(ACTION_ADJUST_GUIDE + cmdAS.getValue("ID"),
                               (KeyStroke) cmdAS.getValue("shortcut"), cmdAS);
        }

        putDefaultShortcut(ACTION_ADJUST_PAGE_BREAKS, null,
                           new ActionAdjustPageBreaks());
        putDefaultShortcut(ACTION_SHOW_XML_DUMP, null, new ActionShowXMLDump());

        putDefaultShortcut(ACTION_ZOOM_IN, KeyStroke.getKeyStroke(
                               KeyEvent.VK_PLUS, DEFAULT_MASK), new ZoomActionProxy(
                               (1.0) / (GenericArgoMenuBar.ZOOM_FACTOR)));

        putDefaultShortcut(ACTION_ZOOM_OUT, KeyStroke.getKeyStroke(
                               KeyEvent.VK_MINUS, DEFAULT_MASK), new ZoomActionProxy(
                               GenericArgoMenuBar.ZOOM_FACTOR));

        putDefaultShortcut(ACTION_FIND, KeyStroke.getKeyStroke(KeyEvent.VK_F3,
                           0), new ActionFind());

        // create menu


        putDefaultShortcut(ACTION_USE_CASE_DIAGRAM, null,
                           new ActionUseCaseDiagram());

        putDefaultShortcut(ACTION_CLASS_DIAGRAM, null,
                           new ActionClassDiagram());







        putDefaultShortcut(ACTION_COLLABORATION_DIAGRAM, null,
                           new ActionCollaborationDiagram());



        putDefaultShortcut(ACTION_STATE_DIAGRAM, null,
                           new ActionStateDiagram());



        putDefaultShortcut(ACTION_ACTIVITY_DIAGRAM, null,
                           new ActionActivityDiagram());



        putDefaultShortcut(ACTION_DEPLOYMENT_DIAGRAM, null,
                           new ActionDeploymentDiagram());

        // generate menu
        putDefaultShortcut(ACTION_GENERATE_ONE, null, new ActionGenerateOne());
        putDefaultShortcut(ACTION_GENERATE_PROJECT_CODE, null,
                           new ActionGenerateProjectCode());
        putDefaultShortcut(ACTION_GENERATION_SETTINGS, null,
                           new ActionGenerationSettings());
        putDefaultShortcut(ACTION_GENERATE_ALL_CLASSES, KeyStroke.getKeyStroke(
                               KeyEvent.VK_F7, 0), new ActionGenerateAll());




        // critique menu
        // TODO: This dependency should be inverted with the Critics subsystem
        // registering its desired shortcuts with us - tfm
        putDefaultShortcut(ACTION_AUTO_CRITIQUE, null,
                           new ActionAutoCritique());
        putDefaultShortcut(ACTION_OPEN_DECISIONS, null,
                           new ActionOpenDecisions());
        putDefaultShortcut(ACTION_OPEN_GOALS, null, new ActionOpenGoals());
        putDefaultShortcut(ACTION_OPEN_CRITICS, null, new ActionOpenCritics());

        // help menu
        putDefaultShortcut(ACTION_SYSTEM_INFORMATION, null,
                           new ActionSystemInfo());
        putDefaultShortcut(ACTION_ABOUT_ARGOUML, null,
                           new ActionAboutArgoUML());

        // arrange menu
        putDefaultShortcut(ACTION_PREFERRED_SIZE, null,
                           new CmdSetPreferredSize());

        // align submenu
        putDefaultShortcut(ACTION_ALIGN_TOPS, null, new AlignAction(
                               AlignAction.ALIGN_TOPS));
        putDefaultShortcut(ACTION_ALIGN_BOTTOMS, null, new AlignAction(
                               AlignAction.ALIGN_BOTTOMS));
        putDefaultShortcut(ACTION_ALIGN_RIGHTS, KeyStroke.getKeyStroke(
                               KeyEvent.VK_R, DEFAULT_MASK),
                           new AlignAction(AlignAction.ALIGN_RIGHTS));
        putDefaultShortcut(ACTION_ALIGN_LEFTS, KeyStroke.getKeyStroke(
                               KeyEvent.VK_L, DEFAULT_MASK),
                           new AlignAction(AlignAction.ALIGN_LEFTS));
        putDefaultShortcut(ACTION_ALIGN_H_CENTERS, null, new AlignAction(
                               AlignAction.ALIGN_H_CENTERS));
        putDefaultShortcut(ACTION_ALIGN_V_CENTERS, null, new AlignAction(
                               AlignAction.ALIGN_V_CENTERS));
        putDefaultShortcut(ACTION_ALIGN_TO_GRID, null, new AlignAction(
                               AlignAction.ALIGN_TO_GRID));

        // distribute submenu
        putDefaultShortcut(ACTION_DISTRIBUTE_H_SPACING, null,
                           new DistributeAction(DistributeAction.H_SPACING));
        putDefaultShortcut(ACTION_DISTRIBUTE_H_CENTERS, null,
                           new DistributeAction(DistributeAction.H_CENTERS));
        putDefaultShortcut(ACTION_DISTRIBUTE_V_SPACING, null,
                           new DistributeAction(DistributeAction.V_SPACING));
        putDefaultShortcut(ACTION_DISTRIBUTE_V_CENTERS, null,
                           new DistributeAction(DistributeAction.V_CENTERS));

        // reorder submenu
        // TODO: I think this requires I18N, but not sure - tfm
        putDefaultShortcut(ACTION_REORDER_FORWARD, KeyStroke.getKeyStroke(
                               KeyEvent.VK_F, DEFAULT_MASK), new ReorderAction("Forward",
                                       ReorderAction.BRING_FORWARD));
        putDefaultShortcut(ACTION_REORDER_BACKWARD, KeyStroke.getKeyStroke(
                               KeyEvent.VK_B, DEFAULT_MASK), new ReorderAction(
                               "Backward",
                               ReorderAction.SEND_BACKWARD));
        putDefaultShortcut(ACTION_REORDER_TO_FRONT, KeyStroke.getKeyStroke(
                               KeyEvent.VK_F, SHIFTED_DEFAULT_MASK), new ReorderAction(
                               "ToFront",
                               ReorderAction.BRING_TO_FRONT));
        putDefaultShortcut(ACTION_REORDER_TO_BACK, KeyStroke.getKeyStroke(
                               KeyEvent.VK_B, SHIFTED_DEFAULT_MASK), new ReorderAction(
                               "ToBack",
                               ReorderAction.SEND_TO_BACK));

        // help menu
        putDefaultShortcut(ACTION_HELP,
                           KeyStroke.getKeyStroke( KeyEvent.VK_F1, 0),
                           new ActionHelp());
    }
//#endif 


//#if 431207142 
static
    {
        // First of all, let's set up the duplicate hash. This hash contains
        // all the duplicate key for another key.
        //
        // TODO: every duplicate.put() is done twice - but how to avoid this?
        duplicate.put(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, DEFAULT_MASK),
                      KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, DEFAULT_MASK));
        duplicate.put(KeyStroke.getKeyStroke(
                          KeyEvent.VK_SUBTRACT, DEFAULT_MASK),
                      KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, DEFAULT_MASK));
        duplicate.put(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, DEFAULT_MASK),
                      KeyStroke.getKeyStroke(KeyEvent.VK_ADD, DEFAULT_MASK));
        duplicate.put(KeyStroke.getKeyStroke(KeyEvent.VK_ADD, DEFAULT_MASK),
                      KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, DEFAULT_MASK));

        // file menu
        putDefaultShortcut(ACTION_NEW_PROJECT, KeyStroke.getKeyStroke(
                               KeyEvent.VK_N, DEFAULT_MASK), new ActionNew());
        putDefaultShortcut(ACTION_OPEN_PROJECT, KeyStroke.getKeyStroke(
                               KeyEvent.VK_O, DEFAULT_MASK), new ActionOpenProject());
        putDefaultShortcut(ACTION_SAVE_PROJECT, KeyStroke.getKeyStroke(
                               KeyEvent.VK_S, DEFAULT_MASK),
                           ProjectBrowser.getInstance().getSaveAction());
        putDefaultShortcut(ACTION_SAVE_PROJECT_AS, null,
                           new ActionSaveProjectAs());
        putDefaultShortcut(ACTION_REVERT_TO_SAVED, null,
                           new ActionRevertToSaved());
        putDefaultShortcut(ACTION_IMPORT_XMI, null, new ActionImportXMI());
        putDefaultShortcut(ACTION_EXPORT_XMI, null, new ActionExportXMI());
        putDefaultShortcut(ACTION_IMPORT_FROM_SOURCES, null,
                           ActionImportFromSources.getInstance());
        putDefaultShortcut(ACTION_PROJECT_SETTINGS, null,
                           new ActionProjectSettings());
        putDefaultShortcut(ACTION_PAGE_SETUP, null, new ActionPageSetup());
        putDefaultShortcut(ACTION_SAVE_GRAPHICS, null,
                           new ActionSaveGraphics());
        putDefaultShortcut(ACTION_SAVE_ALL_GRAPHICS, null,
                           new ActionSaveAllGraphics());
        putDefaultShortcut(ACTION_NOTATION, null, new ActionNotation());
        putDefaultShortcut(ACTION_PRINT, KeyStroke.getKeyStroke(KeyEvent.VK_P,
                           DEFAULT_MASK), new ActionPrint());

        // edit menu
        putDefaultShortcut(ACTION_SELECT_ALL, KeyStroke.getKeyStroke(
                               KeyEvent.VK_A, DEFAULT_MASK),
                           new ActionSelectAll());
        putDefaultShortcut(ACTION_REDO, KeyStroke.getKeyStroke(KeyEvent.VK_Y,
                           DEFAULT_MASK), ProjectActions.getInstance().getRedoAction());
        putDefaultShortcut(ACTION_UNDO, KeyStroke.getKeyStroke(KeyEvent.VK_Z,
                           DEFAULT_MASK), ProjectActions.getInstance().getUndoAction());
        putDefaultShortcut(ACTION_NAVIGATE_FORWARD, null,
                           new NavigateTargetForwardAction());
        putDefaultShortcut(ACTION_NAVIGATE_BACK, null,
                           new NavigateTargetBackAction());
        putDefaultShortcut(ACTION_SELECT_INVERT, null,
                           new ActionSelectInvert());
        putDefaultShortcut(ACTION_PERSPECTIVE_CONFIG, null,
                           new ActionPerspectiveConfig());
        putDefaultShortcut(ACTION_SETTINGS, null, new ActionSettings());
        putDefaultShortcut(ACTION_REMOVE_FROM_DIAGRAM, KeyStroke.getKeyStroke(
                               KeyEvent.VK_DELETE, 0), ProjectActions.getInstance()
                           .getRemoveFromDiagramAction());
        putDefaultShortcut(ACTION_DELETE_MODEL_ELEMENTS, KeyStroke
                           .getKeyStroke(KeyEvent.VK_DELETE, DEFAULT_MASK),
                           ActionDeleteModelElements.getTargetFollower());

        // view menu
        putDefaultShortcut(ACTION_GO_TO_DIAGRAM, null, new ActionGotoDiagram());
        putDefaultShortcut(ACTION_ZOOM_RESET, null, new ZoomAction(0.0));

        List gridActions = ActionAdjustGrid.createAdjustGridActions(true);
        Iterator i = gridActions.iterator();
        while (i.hasNext()) {
            AbstractAction cmdAG = (AbstractAction) i.next();
            putDefaultShortcut(ACTION_ADJUST_GRID + cmdAG.getValue("ID"),
                               (KeyStroke) cmdAG.getValue("shortcut"), cmdAG);
        }

        List snapActions = ActionAdjustSnap.createAdjustSnapActions();
        i = snapActions.iterator();
        while (i.hasNext()) {
            AbstractAction cmdAS = (AbstractAction) i.next();
            putDefaultShortcut(ACTION_ADJUST_GUIDE + cmdAS.getValue("ID"),
                               (KeyStroke) cmdAS.getValue("shortcut"), cmdAS);
        }

        putDefaultShortcut(ACTION_ADJUST_PAGE_BREAKS, null,
                           new ActionAdjustPageBreaks());
        putDefaultShortcut(ACTION_SHOW_XML_DUMP, null, new ActionShowXMLDump());

        putDefaultShortcut(ACTION_ZOOM_IN, KeyStroke.getKeyStroke(
                               KeyEvent.VK_PLUS, DEFAULT_MASK), new ZoomActionProxy(
                               (1.0) / (GenericArgoMenuBar.ZOOM_FACTOR)));

        putDefaultShortcut(ACTION_ZOOM_OUT, KeyStroke.getKeyStroke(
                               KeyEvent.VK_MINUS, DEFAULT_MASK), new ZoomActionProxy(
                               GenericArgoMenuBar.ZOOM_FACTOR));

        putDefaultShortcut(ACTION_FIND, KeyStroke.getKeyStroke(KeyEvent.VK_F3,
                           0), new ActionFind());

        // create menu





        putDefaultShortcut(ACTION_CLASS_DIAGRAM, null,
                           new ActionClassDiagram());


        putDefaultShortcut(ACTION_SEQUENCE_DIAGRAM, null,
                           new ActionSequenceDiagram());



        putDefaultShortcut(ACTION_COLLABORATION_DIAGRAM, null,
                           new ActionCollaborationDiagram());



        putDefaultShortcut(ACTION_STATE_DIAGRAM, null,
                           new ActionStateDiagram());



        putDefaultShortcut(ACTION_ACTIVITY_DIAGRAM, null,
                           new ActionActivityDiagram());



        putDefaultShortcut(ACTION_DEPLOYMENT_DIAGRAM, null,
                           new ActionDeploymentDiagram());

        // generate menu
        putDefaultShortcut(ACTION_GENERATE_ONE, null, new ActionGenerateOne());
        putDefaultShortcut(ACTION_GENERATE_PROJECT_CODE, null,
                           new ActionGenerateProjectCode());
        putDefaultShortcut(ACTION_GENERATION_SETTINGS, null,
                           new ActionGenerationSettings());
        putDefaultShortcut(ACTION_GENERATE_ALL_CLASSES, KeyStroke.getKeyStroke(
                               KeyEvent.VK_F7, 0), new ActionGenerateAll());




        // critique menu
        // TODO: This dependency should be inverted with the Critics subsystem
        // registering its desired shortcuts with us - tfm
        putDefaultShortcut(ACTION_AUTO_CRITIQUE, null,
                           new ActionAutoCritique());
        putDefaultShortcut(ACTION_OPEN_DECISIONS, null,
                           new ActionOpenDecisions());
        putDefaultShortcut(ACTION_OPEN_GOALS, null, new ActionOpenGoals());
        putDefaultShortcut(ACTION_OPEN_CRITICS, null, new ActionOpenCritics());

        // help menu
        putDefaultShortcut(ACTION_SYSTEM_INFORMATION, null,
                           new ActionSystemInfo());
        putDefaultShortcut(ACTION_ABOUT_ARGOUML, null,
                           new ActionAboutArgoUML());

        // arrange menu
        putDefaultShortcut(ACTION_PREFERRED_SIZE, null,
                           new CmdSetPreferredSize());

        // align submenu
        putDefaultShortcut(ACTION_ALIGN_TOPS, null, new AlignAction(
                               AlignAction.ALIGN_TOPS));
        putDefaultShortcut(ACTION_ALIGN_BOTTOMS, null, new AlignAction(
                               AlignAction.ALIGN_BOTTOMS));
        putDefaultShortcut(ACTION_ALIGN_RIGHTS, KeyStroke.getKeyStroke(
                               KeyEvent.VK_R, DEFAULT_MASK),
                           new AlignAction(AlignAction.ALIGN_RIGHTS));
        putDefaultShortcut(ACTION_ALIGN_LEFTS, KeyStroke.getKeyStroke(
                               KeyEvent.VK_L, DEFAULT_MASK),
                           new AlignAction(AlignAction.ALIGN_LEFTS));
        putDefaultShortcut(ACTION_ALIGN_H_CENTERS, null, new AlignAction(
                               AlignAction.ALIGN_H_CENTERS));
        putDefaultShortcut(ACTION_ALIGN_V_CENTERS, null, new AlignAction(
                               AlignAction.ALIGN_V_CENTERS));
        putDefaultShortcut(ACTION_ALIGN_TO_GRID, null, new AlignAction(
                               AlignAction.ALIGN_TO_GRID));

        // distribute submenu
        putDefaultShortcut(ACTION_DISTRIBUTE_H_SPACING, null,
                           new DistributeAction(DistributeAction.H_SPACING));
        putDefaultShortcut(ACTION_DISTRIBUTE_H_CENTERS, null,
                           new DistributeAction(DistributeAction.H_CENTERS));
        putDefaultShortcut(ACTION_DISTRIBUTE_V_SPACING, null,
                           new DistributeAction(DistributeAction.V_SPACING));
        putDefaultShortcut(ACTION_DISTRIBUTE_V_CENTERS, null,
                           new DistributeAction(DistributeAction.V_CENTERS));

        // reorder submenu
        // TODO: I think this requires I18N, but not sure - tfm
        putDefaultShortcut(ACTION_REORDER_FORWARD, KeyStroke.getKeyStroke(
                               KeyEvent.VK_F, DEFAULT_MASK), new ReorderAction("Forward",
                                       ReorderAction.BRING_FORWARD));
        putDefaultShortcut(ACTION_REORDER_BACKWARD, KeyStroke.getKeyStroke(
                               KeyEvent.VK_B, DEFAULT_MASK), new ReorderAction(
                               "Backward",
                               ReorderAction.SEND_BACKWARD));
        putDefaultShortcut(ACTION_REORDER_TO_FRONT, KeyStroke.getKeyStroke(
                               KeyEvent.VK_F, SHIFTED_DEFAULT_MASK), new ReorderAction(
                               "ToFront",
                               ReorderAction.BRING_TO_FRONT));
        putDefaultShortcut(ACTION_REORDER_TO_BACK, KeyStroke.getKeyStroke(
                               KeyEvent.VK_B, SHIFTED_DEFAULT_MASK), new ReorderAction(
                               "ToBack",
                               ReorderAction.SEND_TO_BACK));

        // help menu
        putDefaultShortcut(ACTION_HELP,
                           KeyStroke.getKeyStroke( KeyEvent.VK_F1, 0),
                           new ActionHelp());
    }
//#endif 


//#if -1569906353 
static
    {
        // First of all, let's set up the duplicate hash. This hash contains
        // all the duplicate key for another key.
        //
        // TODO: every duplicate.put() is done twice - but how to avoid this?
        duplicate.put(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, DEFAULT_MASK),
                      KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, DEFAULT_MASK));
        duplicate.put(KeyStroke.getKeyStroke(
                          KeyEvent.VK_SUBTRACT, DEFAULT_MASK),
                      KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, DEFAULT_MASK));
        duplicate.put(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, DEFAULT_MASK),
                      KeyStroke.getKeyStroke(KeyEvent.VK_ADD, DEFAULT_MASK));
        duplicate.put(KeyStroke.getKeyStroke(KeyEvent.VK_ADD, DEFAULT_MASK),
                      KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, DEFAULT_MASK));

        // file menu
        putDefaultShortcut(ACTION_NEW_PROJECT, KeyStroke.getKeyStroke(
                               KeyEvent.VK_N, DEFAULT_MASK), new ActionNew());
        putDefaultShortcut(ACTION_OPEN_PROJECT, KeyStroke.getKeyStroke(
                               KeyEvent.VK_O, DEFAULT_MASK), new ActionOpenProject());
        putDefaultShortcut(ACTION_SAVE_PROJECT, KeyStroke.getKeyStroke(
                               KeyEvent.VK_S, DEFAULT_MASK),
                           ProjectBrowser.getInstance().getSaveAction());
        putDefaultShortcut(ACTION_SAVE_PROJECT_AS, null,
                           new ActionSaveProjectAs());
        putDefaultShortcut(ACTION_REVERT_TO_SAVED, null,
                           new ActionRevertToSaved());
        putDefaultShortcut(ACTION_IMPORT_XMI, null, new ActionImportXMI());
        putDefaultShortcut(ACTION_EXPORT_XMI, null, new ActionExportXMI());
        putDefaultShortcut(ACTION_IMPORT_FROM_SOURCES, null,
                           ActionImportFromSources.getInstance());
        putDefaultShortcut(ACTION_PROJECT_SETTINGS, null,
                           new ActionProjectSettings());
        putDefaultShortcut(ACTION_PAGE_SETUP, null, new ActionPageSetup());
        putDefaultShortcut(ACTION_SAVE_GRAPHICS, null,
                           new ActionSaveGraphics());
        putDefaultShortcut(ACTION_SAVE_ALL_GRAPHICS, null,
                           new ActionSaveAllGraphics());
        putDefaultShortcut(ACTION_NOTATION, null, new ActionNotation());
        putDefaultShortcut(ACTION_PRINT, KeyStroke.getKeyStroke(KeyEvent.VK_P,
                           DEFAULT_MASK), new ActionPrint());

        // edit menu
        putDefaultShortcut(ACTION_SELECT_ALL, KeyStroke.getKeyStroke(
                               KeyEvent.VK_A, DEFAULT_MASK),
                           new ActionSelectAll());
        putDefaultShortcut(ACTION_REDO, KeyStroke.getKeyStroke(KeyEvent.VK_Y,
                           DEFAULT_MASK), ProjectActions.getInstance().getRedoAction());
        putDefaultShortcut(ACTION_UNDO, KeyStroke.getKeyStroke(KeyEvent.VK_Z,
                           DEFAULT_MASK), ProjectActions.getInstance().getUndoAction());
        putDefaultShortcut(ACTION_NAVIGATE_FORWARD, null,
                           new NavigateTargetForwardAction());
        putDefaultShortcut(ACTION_NAVIGATE_BACK, null,
                           new NavigateTargetBackAction());
        putDefaultShortcut(ACTION_SELECT_INVERT, null,
                           new ActionSelectInvert());
        putDefaultShortcut(ACTION_PERSPECTIVE_CONFIG, null,
                           new ActionPerspectiveConfig());
        putDefaultShortcut(ACTION_SETTINGS, null, new ActionSettings());
        putDefaultShortcut(ACTION_REMOVE_FROM_DIAGRAM, KeyStroke.getKeyStroke(
                               KeyEvent.VK_DELETE, 0), ProjectActions.getInstance()
                           .getRemoveFromDiagramAction());
        putDefaultShortcut(ACTION_DELETE_MODEL_ELEMENTS, KeyStroke
                           .getKeyStroke(KeyEvent.VK_DELETE, DEFAULT_MASK),
                           ActionDeleteModelElements.getTargetFollower());

        // view menu
        putDefaultShortcut(ACTION_GO_TO_DIAGRAM, null, new ActionGotoDiagram());
        putDefaultShortcut(ACTION_ZOOM_RESET, null, new ZoomAction(0.0));

        List gridActions = ActionAdjustGrid.createAdjustGridActions(true);
        Iterator i = gridActions.iterator();
        while (i.hasNext()) {
            AbstractAction cmdAG = (AbstractAction) i.next();
            putDefaultShortcut(ACTION_ADJUST_GRID + cmdAG.getValue("ID"),
                               (KeyStroke) cmdAG.getValue("shortcut"), cmdAG);
        }

        List snapActions = ActionAdjustSnap.createAdjustSnapActions();
        i = snapActions.iterator();
        while (i.hasNext()) {
            AbstractAction cmdAS = (AbstractAction) i.next();
            putDefaultShortcut(ACTION_ADJUST_GUIDE + cmdAS.getValue("ID"),
                               (KeyStroke) cmdAS.getValue("shortcut"), cmdAS);
        }

        putDefaultShortcut(ACTION_ADJUST_PAGE_BREAKS, null,
                           new ActionAdjustPageBreaks());
        putDefaultShortcut(ACTION_SHOW_XML_DUMP, null, new ActionShowXMLDump());

        putDefaultShortcut(ACTION_ZOOM_IN, KeyStroke.getKeyStroke(
                               KeyEvent.VK_PLUS, DEFAULT_MASK), new ZoomActionProxy(
                               (1.0) / (GenericArgoMenuBar.ZOOM_FACTOR)));

        putDefaultShortcut(ACTION_ZOOM_OUT, KeyStroke.getKeyStroke(
                               KeyEvent.VK_MINUS, DEFAULT_MASK), new ZoomActionProxy(
                               GenericArgoMenuBar.ZOOM_FACTOR));

        putDefaultShortcut(ACTION_FIND, KeyStroke.getKeyStroke(KeyEvent.VK_F3,
                           0), new ActionFind());

        // create menu


        putDefaultShortcut(ACTION_USE_CASE_DIAGRAM, null,
                           new ActionUseCaseDiagram());

        putDefaultShortcut(ACTION_CLASS_DIAGRAM, null,
                           new ActionClassDiagram());


        putDefaultShortcut(ACTION_SEQUENCE_DIAGRAM, null,
                           new ActionSequenceDiagram());



        putDefaultShortcut(ACTION_COLLABORATION_DIAGRAM, null,
                           new ActionCollaborationDiagram());



        putDefaultShortcut(ACTION_STATE_DIAGRAM, null,
                           new ActionStateDiagram());



        putDefaultShortcut(ACTION_ACTIVITY_DIAGRAM, null,
                           new ActionActivityDiagram());






        // generate menu
        putDefaultShortcut(ACTION_GENERATE_ONE, null, new ActionGenerateOne());
        putDefaultShortcut(ACTION_GENERATE_PROJECT_CODE, null,
                           new ActionGenerateProjectCode());
        putDefaultShortcut(ACTION_GENERATION_SETTINGS, null,
                           new ActionGenerationSettings());
        putDefaultShortcut(ACTION_GENERATE_ALL_CLASSES, KeyStroke.getKeyStroke(
                               KeyEvent.VK_F7, 0), new ActionGenerateAll());




        // critique menu
        // TODO: This dependency should be inverted with the Critics subsystem
        // registering its desired shortcuts with us - tfm
        putDefaultShortcut(ACTION_AUTO_CRITIQUE, null,
                           new ActionAutoCritique());
        putDefaultShortcut(ACTION_OPEN_DECISIONS, null,
                           new ActionOpenDecisions());
        putDefaultShortcut(ACTION_OPEN_GOALS, null, new ActionOpenGoals());
        putDefaultShortcut(ACTION_OPEN_CRITICS, null, new ActionOpenCritics());

        // help menu
        putDefaultShortcut(ACTION_SYSTEM_INFORMATION, null,
                           new ActionSystemInfo());
        putDefaultShortcut(ACTION_ABOUT_ARGOUML, null,
                           new ActionAboutArgoUML());

        // arrange menu
        putDefaultShortcut(ACTION_PREFERRED_SIZE, null,
                           new CmdSetPreferredSize());

        // align submenu
        putDefaultShortcut(ACTION_ALIGN_TOPS, null, new AlignAction(
                               AlignAction.ALIGN_TOPS));
        putDefaultShortcut(ACTION_ALIGN_BOTTOMS, null, new AlignAction(
                               AlignAction.ALIGN_BOTTOMS));
        putDefaultShortcut(ACTION_ALIGN_RIGHTS, KeyStroke.getKeyStroke(
                               KeyEvent.VK_R, DEFAULT_MASK),
                           new AlignAction(AlignAction.ALIGN_RIGHTS));
        putDefaultShortcut(ACTION_ALIGN_LEFTS, KeyStroke.getKeyStroke(
                               KeyEvent.VK_L, DEFAULT_MASK),
                           new AlignAction(AlignAction.ALIGN_LEFTS));
        putDefaultShortcut(ACTION_ALIGN_H_CENTERS, null, new AlignAction(
                               AlignAction.ALIGN_H_CENTERS));
        putDefaultShortcut(ACTION_ALIGN_V_CENTERS, null, new AlignAction(
                               AlignAction.ALIGN_V_CENTERS));
        putDefaultShortcut(ACTION_ALIGN_TO_GRID, null, new AlignAction(
                               AlignAction.ALIGN_TO_GRID));

        // distribute submenu
        putDefaultShortcut(ACTION_DISTRIBUTE_H_SPACING, null,
                           new DistributeAction(DistributeAction.H_SPACING));
        putDefaultShortcut(ACTION_DISTRIBUTE_H_CENTERS, null,
                           new DistributeAction(DistributeAction.H_CENTERS));
        putDefaultShortcut(ACTION_DISTRIBUTE_V_SPACING, null,
                           new DistributeAction(DistributeAction.V_SPACING));
        putDefaultShortcut(ACTION_DISTRIBUTE_V_CENTERS, null,
                           new DistributeAction(DistributeAction.V_CENTERS));

        // reorder submenu
        // TODO: I think this requires I18N, but not sure - tfm
        putDefaultShortcut(ACTION_REORDER_FORWARD, KeyStroke.getKeyStroke(
                               KeyEvent.VK_F, DEFAULT_MASK), new ReorderAction("Forward",
                                       ReorderAction.BRING_FORWARD));
        putDefaultShortcut(ACTION_REORDER_BACKWARD, KeyStroke.getKeyStroke(
                               KeyEvent.VK_B, DEFAULT_MASK), new ReorderAction(
                               "Backward",
                               ReorderAction.SEND_BACKWARD));
        putDefaultShortcut(ACTION_REORDER_TO_FRONT, KeyStroke.getKeyStroke(
                               KeyEvent.VK_F, SHIFTED_DEFAULT_MASK), new ReorderAction(
                               "ToFront",
                               ReorderAction.BRING_TO_FRONT));
        putDefaultShortcut(ACTION_REORDER_TO_BACK, KeyStroke.getKeyStroke(
                               KeyEvent.VK_B, SHIFTED_DEFAULT_MASK), new ReorderAction(
                               "ToBack",
                               ReorderAction.SEND_TO_BACK));

        // help menu
        putDefaultShortcut(ACTION_HELP,
                           KeyStroke.getKeyStroke( KeyEvent.VK_F1, 0),
                           new ActionHelp());
    }
//#endif 


//#if -1249802841 
static
    {
        // First of all, let's set up the duplicate hash. This hash contains
        // all the duplicate key for another key.
        //
        // TODO: every duplicate.put() is done twice - but how to avoid this?
        duplicate.put(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, DEFAULT_MASK),
                      KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, DEFAULT_MASK));
        duplicate.put(KeyStroke.getKeyStroke(
                          KeyEvent.VK_SUBTRACT, DEFAULT_MASK),
                      KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, DEFAULT_MASK));
        duplicate.put(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, DEFAULT_MASK),
                      KeyStroke.getKeyStroke(KeyEvent.VK_ADD, DEFAULT_MASK));
        duplicate.put(KeyStroke.getKeyStroke(KeyEvent.VK_ADD, DEFAULT_MASK),
                      KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, DEFAULT_MASK));

        // file menu
        putDefaultShortcut(ACTION_NEW_PROJECT, KeyStroke.getKeyStroke(
                               KeyEvent.VK_N, DEFAULT_MASK), new ActionNew());
        putDefaultShortcut(ACTION_OPEN_PROJECT, KeyStroke.getKeyStroke(
                               KeyEvent.VK_O, DEFAULT_MASK), new ActionOpenProject());
        putDefaultShortcut(ACTION_SAVE_PROJECT, KeyStroke.getKeyStroke(
                               KeyEvent.VK_S, DEFAULT_MASK),
                           ProjectBrowser.getInstance().getSaveAction());
        putDefaultShortcut(ACTION_SAVE_PROJECT_AS, null,
                           new ActionSaveProjectAs());
        putDefaultShortcut(ACTION_REVERT_TO_SAVED, null,
                           new ActionRevertToSaved());
        putDefaultShortcut(ACTION_IMPORT_XMI, null, new ActionImportXMI());
        putDefaultShortcut(ACTION_EXPORT_XMI, null, new ActionExportXMI());
        putDefaultShortcut(ACTION_IMPORT_FROM_SOURCES, null,
                           ActionImportFromSources.getInstance());
        putDefaultShortcut(ACTION_PROJECT_SETTINGS, null,
                           new ActionProjectSettings());
        putDefaultShortcut(ACTION_PAGE_SETUP, null, new ActionPageSetup());
        putDefaultShortcut(ACTION_SAVE_GRAPHICS, null,
                           new ActionSaveGraphics());
        putDefaultShortcut(ACTION_SAVE_ALL_GRAPHICS, null,
                           new ActionSaveAllGraphics());
        putDefaultShortcut(ACTION_NOTATION, null, new ActionNotation());
        putDefaultShortcut(ACTION_PRINT, KeyStroke.getKeyStroke(KeyEvent.VK_P,
                           DEFAULT_MASK), new ActionPrint());

        // edit menu
        putDefaultShortcut(ACTION_SELECT_ALL, KeyStroke.getKeyStroke(
                               KeyEvent.VK_A, DEFAULT_MASK),
                           new ActionSelectAll());
        putDefaultShortcut(ACTION_REDO, KeyStroke.getKeyStroke(KeyEvent.VK_Y,
                           DEFAULT_MASK), ProjectActions.getInstance().getRedoAction());
        putDefaultShortcut(ACTION_UNDO, KeyStroke.getKeyStroke(KeyEvent.VK_Z,
                           DEFAULT_MASK), ProjectActions.getInstance().getUndoAction());
        putDefaultShortcut(ACTION_NAVIGATE_FORWARD, null,
                           new NavigateTargetForwardAction());
        putDefaultShortcut(ACTION_NAVIGATE_BACK, null,
                           new NavigateTargetBackAction());
        putDefaultShortcut(ACTION_SELECT_INVERT, null,
                           new ActionSelectInvert());
        putDefaultShortcut(ACTION_PERSPECTIVE_CONFIG, null,
                           new ActionPerspectiveConfig());
        putDefaultShortcut(ACTION_SETTINGS, null, new ActionSettings());
        putDefaultShortcut(ACTION_REMOVE_FROM_DIAGRAM, KeyStroke.getKeyStroke(
                               KeyEvent.VK_DELETE, 0), ProjectActions.getInstance()
                           .getRemoveFromDiagramAction());
        putDefaultShortcut(ACTION_DELETE_MODEL_ELEMENTS, KeyStroke
                           .getKeyStroke(KeyEvent.VK_DELETE, DEFAULT_MASK),
                           ActionDeleteModelElements.getTargetFollower());

        // view menu
        putDefaultShortcut(ACTION_GO_TO_DIAGRAM, null, new ActionGotoDiagram());
        putDefaultShortcut(ACTION_ZOOM_RESET, null, new ZoomAction(0.0));

        List gridActions = ActionAdjustGrid.createAdjustGridActions(true);
        Iterator i = gridActions.iterator();
        while (i.hasNext()) {
            AbstractAction cmdAG = (AbstractAction) i.next();
            putDefaultShortcut(ACTION_ADJUST_GRID + cmdAG.getValue("ID"),
                               (KeyStroke) cmdAG.getValue("shortcut"), cmdAG);
        }

        List snapActions = ActionAdjustSnap.createAdjustSnapActions();
        i = snapActions.iterator();
        while (i.hasNext()) {
            AbstractAction cmdAS = (AbstractAction) i.next();
            putDefaultShortcut(ACTION_ADJUST_GUIDE + cmdAS.getValue("ID"),
                               (KeyStroke) cmdAS.getValue("shortcut"), cmdAS);
        }

        putDefaultShortcut(ACTION_ADJUST_PAGE_BREAKS, null,
                           new ActionAdjustPageBreaks());
        putDefaultShortcut(ACTION_SHOW_XML_DUMP, null, new ActionShowXMLDump());

        putDefaultShortcut(ACTION_ZOOM_IN, KeyStroke.getKeyStroke(
                               KeyEvent.VK_PLUS, DEFAULT_MASK), new ZoomActionProxy(
                               (1.0) / (GenericArgoMenuBar.ZOOM_FACTOR)));

        putDefaultShortcut(ACTION_ZOOM_OUT, KeyStroke.getKeyStroke(
                               KeyEvent.VK_MINUS, DEFAULT_MASK), new ZoomActionProxy(
                               GenericArgoMenuBar.ZOOM_FACTOR));

        putDefaultShortcut(ACTION_FIND, KeyStroke.getKeyStroke(KeyEvent.VK_F3,
                           0), new ActionFind());

        // create menu


        putDefaultShortcut(ACTION_USE_CASE_DIAGRAM, null,
                           new ActionUseCaseDiagram());

        putDefaultShortcut(ACTION_CLASS_DIAGRAM, null,
                           new ActionClassDiagram());


        putDefaultShortcut(ACTION_SEQUENCE_DIAGRAM, null,
                           new ActionSequenceDiagram());








        putDefaultShortcut(ACTION_STATE_DIAGRAM, null,
                           new ActionStateDiagram());



        putDefaultShortcut(ACTION_ACTIVITY_DIAGRAM, null,
                           new ActionActivityDiagram());



        putDefaultShortcut(ACTION_DEPLOYMENT_DIAGRAM, null,
                           new ActionDeploymentDiagram());

        // generate menu
        putDefaultShortcut(ACTION_GENERATE_ONE, null, new ActionGenerateOne());
        putDefaultShortcut(ACTION_GENERATE_PROJECT_CODE, null,
                           new ActionGenerateProjectCode());
        putDefaultShortcut(ACTION_GENERATION_SETTINGS, null,
                           new ActionGenerationSettings());
        putDefaultShortcut(ACTION_GENERATE_ALL_CLASSES, KeyStroke.getKeyStroke(
                               KeyEvent.VK_F7, 0), new ActionGenerateAll());




        // critique menu
        // TODO: This dependency should be inverted with the Critics subsystem
        // registering its desired shortcuts with us - tfm
        putDefaultShortcut(ACTION_AUTO_CRITIQUE, null,
                           new ActionAutoCritique());
        putDefaultShortcut(ACTION_OPEN_DECISIONS, null,
                           new ActionOpenDecisions());
        putDefaultShortcut(ACTION_OPEN_GOALS, null, new ActionOpenGoals());
        putDefaultShortcut(ACTION_OPEN_CRITICS, null, new ActionOpenCritics());

        // help menu
        putDefaultShortcut(ACTION_SYSTEM_INFORMATION, null,
                           new ActionSystemInfo());
        putDefaultShortcut(ACTION_ABOUT_ARGOUML, null,
                           new ActionAboutArgoUML());

        // arrange menu
        putDefaultShortcut(ACTION_PREFERRED_SIZE, null,
                           new CmdSetPreferredSize());

        // align submenu
        putDefaultShortcut(ACTION_ALIGN_TOPS, null, new AlignAction(
                               AlignAction.ALIGN_TOPS));
        putDefaultShortcut(ACTION_ALIGN_BOTTOMS, null, new AlignAction(
                               AlignAction.ALIGN_BOTTOMS));
        putDefaultShortcut(ACTION_ALIGN_RIGHTS, KeyStroke.getKeyStroke(
                               KeyEvent.VK_R, DEFAULT_MASK),
                           new AlignAction(AlignAction.ALIGN_RIGHTS));
        putDefaultShortcut(ACTION_ALIGN_LEFTS, KeyStroke.getKeyStroke(
                               KeyEvent.VK_L, DEFAULT_MASK),
                           new AlignAction(AlignAction.ALIGN_LEFTS));
        putDefaultShortcut(ACTION_ALIGN_H_CENTERS, null, new AlignAction(
                               AlignAction.ALIGN_H_CENTERS));
        putDefaultShortcut(ACTION_ALIGN_V_CENTERS, null, new AlignAction(
                               AlignAction.ALIGN_V_CENTERS));
        putDefaultShortcut(ACTION_ALIGN_TO_GRID, null, new AlignAction(
                               AlignAction.ALIGN_TO_GRID));

        // distribute submenu
        putDefaultShortcut(ACTION_DISTRIBUTE_H_SPACING, null,
                           new DistributeAction(DistributeAction.H_SPACING));
        putDefaultShortcut(ACTION_DISTRIBUTE_H_CENTERS, null,
                           new DistributeAction(DistributeAction.H_CENTERS));
        putDefaultShortcut(ACTION_DISTRIBUTE_V_SPACING, null,
                           new DistributeAction(DistributeAction.V_SPACING));
        putDefaultShortcut(ACTION_DISTRIBUTE_V_CENTERS, null,
                           new DistributeAction(DistributeAction.V_CENTERS));

        // reorder submenu
        // TODO: I think this requires I18N, but not sure - tfm
        putDefaultShortcut(ACTION_REORDER_FORWARD, KeyStroke.getKeyStroke(
                               KeyEvent.VK_F, DEFAULT_MASK), new ReorderAction("Forward",
                                       ReorderAction.BRING_FORWARD));
        putDefaultShortcut(ACTION_REORDER_BACKWARD, KeyStroke.getKeyStroke(
                               KeyEvent.VK_B, DEFAULT_MASK), new ReorderAction(
                               "Backward",
                               ReorderAction.SEND_BACKWARD));
        putDefaultShortcut(ACTION_REORDER_TO_FRONT, KeyStroke.getKeyStroke(
                               KeyEvent.VK_F, SHIFTED_DEFAULT_MASK), new ReorderAction(
                               "ToFront",
                               ReorderAction.BRING_TO_FRONT));
        putDefaultShortcut(ACTION_REORDER_TO_BACK, KeyStroke.getKeyStroke(
                               KeyEvent.VK_B, SHIFTED_DEFAULT_MASK), new ReorderAction(
                               "ToBack",
                               ReorderAction.SEND_TO_BACK));

        // help menu
        putDefaultShortcut(ACTION_HELP,
                           KeyStroke.getKeyStroke( KeyEvent.VK_F1, 0),
                           new ActionHelp());
    }
//#endif 


//#if -47743169 
static
    {
        // First of all, let's set up the duplicate hash. This hash contains
        // all the duplicate key for another key.
        //
        // TODO: every duplicate.put() is done twice - but how to avoid this?
        duplicate.put(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, DEFAULT_MASK),
                      KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, DEFAULT_MASK));
        duplicate.put(KeyStroke.getKeyStroke(
                          KeyEvent.VK_SUBTRACT, DEFAULT_MASK),
                      KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, DEFAULT_MASK));
        duplicate.put(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, DEFAULT_MASK),
                      KeyStroke.getKeyStroke(KeyEvent.VK_ADD, DEFAULT_MASK));
        duplicate.put(KeyStroke.getKeyStroke(KeyEvent.VK_ADD, DEFAULT_MASK),
                      KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, DEFAULT_MASK));

        // file menu
        putDefaultShortcut(ACTION_NEW_PROJECT, KeyStroke.getKeyStroke(
                               KeyEvent.VK_N, DEFAULT_MASK), new ActionNew());
        putDefaultShortcut(ACTION_OPEN_PROJECT, KeyStroke.getKeyStroke(
                               KeyEvent.VK_O, DEFAULT_MASK), new ActionOpenProject());
        putDefaultShortcut(ACTION_SAVE_PROJECT, KeyStroke.getKeyStroke(
                               KeyEvent.VK_S, DEFAULT_MASK),
                           ProjectBrowser.getInstance().getSaveAction());
        putDefaultShortcut(ACTION_SAVE_PROJECT_AS, null,
                           new ActionSaveProjectAs());
        putDefaultShortcut(ACTION_REVERT_TO_SAVED, null,
                           new ActionRevertToSaved());
        putDefaultShortcut(ACTION_IMPORT_XMI, null, new ActionImportXMI());
        putDefaultShortcut(ACTION_EXPORT_XMI, null, new ActionExportXMI());
        putDefaultShortcut(ACTION_IMPORT_FROM_SOURCES, null,
                           ActionImportFromSources.getInstance());
        putDefaultShortcut(ACTION_PROJECT_SETTINGS, null,
                           new ActionProjectSettings());
        putDefaultShortcut(ACTION_PAGE_SETUP, null, new ActionPageSetup());
        putDefaultShortcut(ACTION_SAVE_GRAPHICS, null,
                           new ActionSaveGraphics());
        putDefaultShortcut(ACTION_SAVE_ALL_GRAPHICS, null,
                           new ActionSaveAllGraphics());
        putDefaultShortcut(ACTION_NOTATION, null, new ActionNotation());
        putDefaultShortcut(ACTION_PRINT, KeyStroke.getKeyStroke(KeyEvent.VK_P,
                           DEFAULT_MASK), new ActionPrint());

        // edit menu
        putDefaultShortcut(ACTION_SELECT_ALL, KeyStroke.getKeyStroke(
                               KeyEvent.VK_A, DEFAULT_MASK),
                           new ActionSelectAll());
        putDefaultShortcut(ACTION_REDO, KeyStroke.getKeyStroke(KeyEvent.VK_Y,
                           DEFAULT_MASK), ProjectActions.getInstance().getRedoAction());
        putDefaultShortcut(ACTION_UNDO, KeyStroke.getKeyStroke(KeyEvent.VK_Z,
                           DEFAULT_MASK), ProjectActions.getInstance().getUndoAction());
        putDefaultShortcut(ACTION_NAVIGATE_FORWARD, null,
                           new NavigateTargetForwardAction());
        putDefaultShortcut(ACTION_NAVIGATE_BACK, null,
                           new NavigateTargetBackAction());
        putDefaultShortcut(ACTION_SELECT_INVERT, null,
                           new ActionSelectInvert());
        putDefaultShortcut(ACTION_PERSPECTIVE_CONFIG, null,
                           new ActionPerspectiveConfig());
        putDefaultShortcut(ACTION_SETTINGS, null, new ActionSettings());
        putDefaultShortcut(ACTION_REMOVE_FROM_DIAGRAM, KeyStroke.getKeyStroke(
                               KeyEvent.VK_DELETE, 0), ProjectActions.getInstance()
                           .getRemoveFromDiagramAction());
        putDefaultShortcut(ACTION_DELETE_MODEL_ELEMENTS, KeyStroke
                           .getKeyStroke(KeyEvent.VK_DELETE, DEFAULT_MASK),
                           ActionDeleteModelElements.getTargetFollower());

        // view menu
        putDefaultShortcut(ACTION_GO_TO_DIAGRAM, null, new ActionGotoDiagram());
        putDefaultShortcut(ACTION_ZOOM_RESET, null, new ZoomAction(0.0));

        List gridActions = ActionAdjustGrid.createAdjustGridActions(true);
        Iterator i = gridActions.iterator();
        while (i.hasNext()) {
            AbstractAction cmdAG = (AbstractAction) i.next();
            putDefaultShortcut(ACTION_ADJUST_GRID + cmdAG.getValue("ID"),
                               (KeyStroke) cmdAG.getValue("shortcut"), cmdAG);
        }

        List snapActions = ActionAdjustSnap.createAdjustSnapActions();
        i = snapActions.iterator();
        while (i.hasNext()) {
            AbstractAction cmdAS = (AbstractAction) i.next();
            putDefaultShortcut(ACTION_ADJUST_GUIDE + cmdAS.getValue("ID"),
                               (KeyStroke) cmdAS.getValue("shortcut"), cmdAS);
        }

        putDefaultShortcut(ACTION_ADJUST_PAGE_BREAKS, null,
                           new ActionAdjustPageBreaks());
        putDefaultShortcut(ACTION_SHOW_XML_DUMP, null, new ActionShowXMLDump());

        putDefaultShortcut(ACTION_ZOOM_IN, KeyStroke.getKeyStroke(
                               KeyEvent.VK_PLUS, DEFAULT_MASK), new ZoomActionProxy(
                               (1.0) / (GenericArgoMenuBar.ZOOM_FACTOR)));

        putDefaultShortcut(ACTION_ZOOM_OUT, KeyStroke.getKeyStroke(
                               KeyEvent.VK_MINUS, DEFAULT_MASK), new ZoomActionProxy(
                               GenericArgoMenuBar.ZOOM_FACTOR));

        putDefaultShortcut(ACTION_FIND, KeyStroke.getKeyStroke(KeyEvent.VK_F3,
                           0), new ActionFind());

        // create menu


        putDefaultShortcut(ACTION_USE_CASE_DIAGRAM, null,
                           new ActionUseCaseDiagram());

        putDefaultShortcut(ACTION_CLASS_DIAGRAM, null,
                           new ActionClassDiagram());


        putDefaultShortcut(ACTION_SEQUENCE_DIAGRAM, null,
                           new ActionSequenceDiagram());



        putDefaultShortcut(ACTION_COLLABORATION_DIAGRAM, null,
                           new ActionCollaborationDiagram());








        putDefaultShortcut(ACTION_ACTIVITY_DIAGRAM, null,
                           new ActionActivityDiagram());



        putDefaultShortcut(ACTION_DEPLOYMENT_DIAGRAM, null,
                           new ActionDeploymentDiagram());

        // generate menu
        putDefaultShortcut(ACTION_GENERATE_ONE, null, new ActionGenerateOne());
        putDefaultShortcut(ACTION_GENERATE_PROJECT_CODE, null,
                           new ActionGenerateProjectCode());
        putDefaultShortcut(ACTION_GENERATION_SETTINGS, null,
                           new ActionGenerationSettings());
        putDefaultShortcut(ACTION_GENERATE_ALL_CLASSES, KeyStroke.getKeyStroke(
                               KeyEvent.VK_F7, 0), new ActionGenerateAll());




        // critique menu
        // TODO: This dependency should be inverted with the Critics subsystem
        // registering its desired shortcuts with us - tfm
        putDefaultShortcut(ACTION_AUTO_CRITIQUE, null,
                           new ActionAutoCritique());
        putDefaultShortcut(ACTION_OPEN_DECISIONS, null,
                           new ActionOpenDecisions());
        putDefaultShortcut(ACTION_OPEN_GOALS, null, new ActionOpenGoals());
        putDefaultShortcut(ACTION_OPEN_CRITICS, null, new ActionOpenCritics());

        // help menu
        putDefaultShortcut(ACTION_SYSTEM_INFORMATION, null,
                           new ActionSystemInfo());
        putDefaultShortcut(ACTION_ABOUT_ARGOUML, null,
                           new ActionAboutArgoUML());

        // arrange menu
        putDefaultShortcut(ACTION_PREFERRED_SIZE, null,
                           new CmdSetPreferredSize());

        // align submenu
        putDefaultShortcut(ACTION_ALIGN_TOPS, null, new AlignAction(
                               AlignAction.ALIGN_TOPS));
        putDefaultShortcut(ACTION_ALIGN_BOTTOMS, null, new AlignAction(
                               AlignAction.ALIGN_BOTTOMS));
        putDefaultShortcut(ACTION_ALIGN_RIGHTS, KeyStroke.getKeyStroke(
                               KeyEvent.VK_R, DEFAULT_MASK),
                           new AlignAction(AlignAction.ALIGN_RIGHTS));
        putDefaultShortcut(ACTION_ALIGN_LEFTS, KeyStroke.getKeyStroke(
                               KeyEvent.VK_L, DEFAULT_MASK),
                           new AlignAction(AlignAction.ALIGN_LEFTS));
        putDefaultShortcut(ACTION_ALIGN_H_CENTERS, null, new AlignAction(
                               AlignAction.ALIGN_H_CENTERS));
        putDefaultShortcut(ACTION_ALIGN_V_CENTERS, null, new AlignAction(
                               AlignAction.ALIGN_V_CENTERS));
        putDefaultShortcut(ACTION_ALIGN_TO_GRID, null, new AlignAction(
                               AlignAction.ALIGN_TO_GRID));

        // distribute submenu
        putDefaultShortcut(ACTION_DISTRIBUTE_H_SPACING, null,
                           new DistributeAction(DistributeAction.H_SPACING));
        putDefaultShortcut(ACTION_DISTRIBUTE_H_CENTERS, null,
                           new DistributeAction(DistributeAction.H_CENTERS));
        putDefaultShortcut(ACTION_DISTRIBUTE_V_SPACING, null,
                           new DistributeAction(DistributeAction.V_SPACING));
        putDefaultShortcut(ACTION_DISTRIBUTE_V_CENTERS, null,
                           new DistributeAction(DistributeAction.V_CENTERS));

        // reorder submenu
        // TODO: I think this requires I18N, but not sure - tfm
        putDefaultShortcut(ACTION_REORDER_FORWARD, KeyStroke.getKeyStroke(
                               KeyEvent.VK_F, DEFAULT_MASK), new ReorderAction("Forward",
                                       ReorderAction.BRING_FORWARD));
        putDefaultShortcut(ACTION_REORDER_BACKWARD, KeyStroke.getKeyStroke(
                               KeyEvent.VK_B, DEFAULT_MASK), new ReorderAction(
                               "Backward",
                               ReorderAction.SEND_BACKWARD));
        putDefaultShortcut(ACTION_REORDER_TO_FRONT, KeyStroke.getKeyStroke(
                               KeyEvent.VK_F, SHIFTED_DEFAULT_MASK), new ReorderAction(
                               "ToFront",
                               ReorderAction.BRING_TO_FRONT));
        putDefaultShortcut(ACTION_REORDER_TO_BACK, KeyStroke.getKeyStroke(
                               KeyEvent.VK_B, SHIFTED_DEFAULT_MASK), new ReorderAction(
                               "ToBack",
                               ReorderAction.SEND_TO_BACK));

        // help menu
        putDefaultShortcut(ACTION_HELP,
                           KeyStroke.getKeyStroke( KeyEvent.VK_F1, 0),
                           new ActionHelp());
    }
//#endif 


//#if 1605977523 
public static ActionWrapper getShortcut(String actionId)
    { 

//#if -1746912183 
return shortcutHash.get(actionId);
//#endif 

} 

//#endif 


//#if 213885882 
private static int decodeModifier(String modifier)
    { 

//#if 985615191 
if(modifier == null || modifier.length() == 0)//1
{ 

//#if -1502000388 
return 0;
//#endif 

} 
else

//#if -908576426 
if(modifier.equals(KeyEventUtils.CTRL_MODIFIER))//1
{ 

//#if -2107112274 
return InputEvent.CTRL_DOWN_MASK;
//#endif 

} 
else

//#if 1894738119 
if(modifier.equals(KeyEventUtils.ALT_MODIFIER))//1
{ 

//#if -1482569489 
return InputEvent.ALT_DOWN_MASK;
//#endif 

} 
else

//#if 1582279069 
if(modifier.equals(KeyEventUtils.ALT_GRAPH_MODIFIER))//1
{ 

//#if 812054627 
return InputEvent.ALT_GRAPH_DOWN_MASK;
//#endif 

} 
else

//#if 1497030488 
if(modifier.equals(KeyEventUtils.META_MODIFIER))//1
{ 

//#if 270014651 
return InputEvent.META_DOWN_MASK;
//#endif 

} 
else

//#if -119721328 
if(modifier.equals(KeyEventUtils.SHIFT_MODIFIER))//1
{ 

//#if -1767216309 
return InputEvent.SHIFT_DOWN_MASK;
//#endif 

} 
else
{ 

//#if -1831667848 
LOG.debug("Unknown modifier: " + modifier);
//#endif 


//#if 1978383729 
return 0;
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 

} 

//#endif 


//#if 2011863028 
public static void assignAccelerator(JMenuItem menuItem,
                                         String shortcutKey)
    { 

//#if 659845605 
ActionWrapper shortcut = shortcutHash.get(shortcutKey);
//#endif 


//#if 484543600 
if(shortcut != null)//1
{ 

//#if -292238148 
KeyStroke keyStroke = shortcut.getCurrentShortcut();
//#endif 


//#if -1625282847 
if(keyStroke != null)//1
{ 

//#if -84881608 
menuItem.setAccelerator(keyStroke);
//#endif 

} 

//#endif 


//#if -2096385842 
KeyStroke alternativeKeyStroke = duplicate.get(keyStroke);
//#endif 


//#if 227825622 
if(alternativeKeyStroke != null)//1
{ 

//#if -703778812 
String actionName = (String) menuItem.getAction().getValue(
                                        AbstractAction.NAME);
//#endif 


//#if 1645812527 
menuItem.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                    alternativeKeyStroke, actionName);
//#endif 


//#if -1665704840 
menuItem.getActionMap().put(actionName, menuItem.getAction());
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1307996453 
private static void putDefaultShortcut(String shortcutKey,
                                           KeyStroke defaultKeyStroke, AbstractAction action, String actionName)
    { 

//#if -768460684 
String confCurrentShortcut = Configuration.getString(Configuration
                                     .makeKey(shortcutKey), null);
//#endif 


//#if 1318255718 
KeyStroke currentKeyStroke = null;
//#endif 


//#if 999264165 
if(confCurrentShortcut == null)//1
{ 

//#if 1609304558 
currentKeyStroke = defaultKeyStroke;
//#endif 

} 
else

//#if 978531136 
if(confCurrentShortcut.compareTo("") != 0)//1
{ 

//#if -435002458 
currentKeyStroke = decodeKeyStroke(confCurrentShortcut);
//#endif 

} 

//#endif 


//#endif 


//#if 1940391512 
ActionWrapper currentShortcut =
            new ActionWrapper(shortcutKey, currentKeyStroke,
                              defaultKeyStroke, action, actionName);
//#endif 


//#if 677919665 
shortcutHash.put(shortcutKey, currentShortcut);
//#endif 

} 

//#endif 


//#if -1260958965 
static ActionWrapper[] getShortcuts()
    { 

//#if 673253038 
ActionWrapper[] actions = shortcutHash.values().toArray(
                                      new ActionWrapper[shortcutHash.size()]);
//#endif 


//#if 1286977976 
Arrays.sort(actions, new Comparator<ActionWrapper>() {
            public int compare(ActionWrapper o1, ActionWrapper o2) {
                String name1 = o1.getActionName();
                if (name1 == null) {
                    name1 = "";
                }
                String name2 = o2.getActionName();
                if (name2 == null) {
                    name2 = "";
                }
                return name1.compareTo(name2);
            }
        });
//#endif 


//#if -2044038523 
return actions;
//#endif 

} 

//#endif 


//#if -600881499 
static void saveShortcuts(ActionWrapper[] newActions)
    { 

//#if 1155435652 
for (int i = 0; i < newActions.length; i++) //1
{ 

//#if -1955896079 
ActionWrapper oldAction = shortcutHash
                                      .get(newActions[i].getKey());
//#endif 


//#if -2140227353 
if(newActions[i].getCurrentShortcut() == null
                    && newActions[i].getDefaultShortcut() != null)//1
{ 

//#if -1347501641 
Configuration.setString(Configuration.makeKey(oldAction
                                        .getKey()), "");
//#endif 

} 
else

//#if -1080458189 
if(newActions[i].getCurrentShortcut() != null
                       && !newActions[i].getCurrentShortcut().equals(
                           newActions[i].getDefaultShortcut()))//1
{ 

//#if -1692228983 
Configuration.setString(Configuration.makeKey(oldAction
                                        .getKey()), KeyEventUtils.formatKeyStroke(newActions[i]
                                                .getCurrentShortcut()));
//#endif 

} 
else
{ 

//#if 1754298751 
Configuration.removeKey(Configuration.makeKey(oldAction
                                        .getKey()));
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if 2004139831 
private static String getActionDefaultName(AbstractAction action)
    { 

//#if -747197126 
return (String) action.getValue(AbstractAction.NAME);
//#endif 

} 

//#endif 


//#if 1138287704 
public static void assignAccelerator(JPanel panel,
                                         String shortcutKey)
    { 

//#if 457837594 
ActionWrapper shortcut = shortcutHash.get(shortcutKey);
//#endif 


//#if 483632347 
if(shortcut != null)//1
{ 

//#if -1771619331 
KeyStroke keyStroke = shortcut.getCurrentShortcut();
//#endif 


//#if -1337240512 
if(keyStroke != null)//1
{ 

//#if -245698968 
panel.registerKeyboardAction(shortcut.getActionInstance(),
                                             keyStroke, JComponent.WHEN_FOCUSED);
//#endif 

} 

//#endif 


//#if -947655857 
KeyStroke alternativeKeyStroke = duplicate.get(keyStroke);
//#endif 


//#if 948398359 
if(alternativeKeyStroke != null)//1
{ 

//#if -1662785620 
String actionName = (String)
                                    shortcut.getActionInstance().getValue(AbstractAction.NAME);
//#endif 


//#if -713511967 
panel.getInputMap(JComponent.WHEN_FOCUSED).put(
                    alternativeKeyStroke, actionName);
//#endif 


//#if 2042433816 
panel.getActionMap().put(actionName,
                                         shortcut.getActionInstance());
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -205269071 
public static KeyStroke decodeKeyStroke(String strKeyStroke)
    { 

//#if -1535983374 
assert (strKeyStroke != null);
//#endif 


//#if 1820485556 
StringTokenizer tokenizer = new StringTokenizer(strKeyStroke,
                KeyEventUtils.MODIFIER_JOINER);
//#endif 


//#if -1970580016 
int modifiers = 0;
//#endif 


//#if 1383391414 
while (tokenizer.hasMoreElements()) //1
{ 

//#if 426875196 
String nextElement = (String) tokenizer.nextElement();
//#endif 


//#if 345659215 
if(tokenizer.hasMoreTokens())//1
{ 

//#if 1632463228 
modifiers |= decodeModifier(nextElement);
//#endif 

} 
else
{ 

//#if 691601942 
try //1
{ 

//#if -962832252 
Field f = KeyEvent.class.getField("VK_" + nextElement);
//#endif 


//#if -198181129 
return KeyStroke.getKeyStroke(f.getInt(null), modifiers);
//#endif 

} 

//#if 1020869764 
catch (Exception exc) //1
{ 

//#if 1214680996 
LOG.error("Exception: " + exc);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if -205940167 
return null;
//#endif 

} 

//#endif 


//#if -671487871 
static KeyStroke getDuplicate(KeyStroke keyStroke)
    { 

//#if 1725772862 
return duplicate.get(keyStroke);
//#endif 

} 

//#endif 


//#if -1435943249 
private static void putDefaultShortcut(String shortcutKey,
                                           KeyStroke defaultKeyStroke, AbstractAction action)
    { 

//#if -1302857270 
putDefaultShortcut(shortcutKey, defaultKeyStroke, action,
                           getActionDefaultName(action));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

