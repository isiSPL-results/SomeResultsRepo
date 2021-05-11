
//#if 1312390951 
// Compilation Unit of /UMLDiagram.java 
 

//#if -926505315 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -799241753 
import java.awt.Component;
//#endif 


//#if 261836852 
import java.awt.Point;
//#endif 


//#if 48760757 
import java.awt.Rectangle;
//#endif 


//#if 1736182255 
import java.beans.PropertyVetoException;
//#endif 


//#if -2085096182 
import javax.swing.Action;
//#endif 


//#if 1589839583 
import javax.swing.ButtonModel;
//#endif 


//#if -1757060657 
import javax.swing.JToolBar;
//#endif 


//#if -2059878604 
import org.apache.log4j.Logger;
//#endif 


//#if -695763004 
import org.argouml.gefext.ArgoModeCreateFigCircle;
//#endif 


//#if -1120761508 
import org.argouml.gefext.ArgoModeCreateFigInk;
//#endif 


//#if -381242528 
import org.argouml.gefext.ArgoModeCreateFigLine;
//#endif 


//#if -377371000 
import org.argouml.gefext.ArgoModeCreateFigPoly;
//#endif 


//#if 1216649228 
import org.argouml.gefext.ArgoModeCreateFigRRect;
//#endif 


//#if -375830672 
import org.argouml.gefext.ArgoModeCreateFigRect;
//#endif 


//#if 814437603 
import org.argouml.gefext.ArgoModeCreateFigSpline;
//#endif 


//#if 118638433 
import org.argouml.i18n.Translator;
//#endif 


//#if 1922496259 
import org.argouml.kernel.Project;
//#endif 


//#if -212342105 
import org.argouml.model.Model;
//#endif 


//#if -1070615539 
import org.argouml.ui.CmdCreateNode;
//#endif 


//#if 1168914440 
import org.argouml.uml.UUIDHelper;
//#endif 


//#if 1903259174 
import org.argouml.uml.diagram.ArgoDiagramImpl;
//#endif 


//#if 2069917322 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 316499238 
import org.argouml.uml.diagram.Relocatable;
//#endif 


//#if -1183658525 
import org.argouml.uml.diagram.UMLMutableGraphSupport;
//#endif 


//#if 1631712430 
import org.argouml.util.ToolBarUtility;
//#endif 


//#if -1537277728 
import org.tigris.gef.base.LayerPerspective;
//#endif 


//#if 1978493361 
import org.tigris.gef.base.ModeBroom;
//#endif 


//#if 835673955 
import org.tigris.gef.base.ModeCreatePolyEdge;
//#endif 


//#if -1921635801 
import org.tigris.gef.base.ModePlace;
//#endif 


//#if -1263809780 
import org.tigris.gef.base.ModeSelect;
//#endif 


//#if -86938414 
import org.tigris.gef.graph.GraphFactory;
//#endif 


//#if -483947821 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if -668711364 
import org.tigris.gef.presentation.FigNode;
//#endif 


//#if -1980579406 
import org.tigris.toolbar.ToolBarFactory;
//#endif 


//#if 1926281071 
import org.tigris.toolbar.ToolBarManager;
//#endif 


//#if -818309721 
import org.tigris.toolbar.toolbutton.ToolButton;
//#endif 


//#if 447372158 
public abstract class UMLDiagram extends 
//#if -361662659 
ArgoDiagramImpl
//#endif 

 implements 
//#if 975643709 
Relocatable
//#endif 

  { 

//#if -1163928880 
private static final Logger LOG = Logger.getLogger(UMLDiagram.class);
//#endif 


//#if -1277117495 
private static Action actionComment =
        new RadioAction(new ActionAddNote());
//#endif 


//#if 514276557 
private static Action actionCommentLink =
        new RadioAction(new ActionSetAddCommentLinkMode());
//#endif 


//#if 386646867 
private static Action actionSelect =
        new ActionSetMode(ModeSelect.class, "button.select");
//#endif 


//#if 296942930 
private static Action actionBroom =
        new ActionSetMode(ModeBroom.class, "button.broom");
//#endif 


//#if 2143986440 
private static Action actionRectangle =
        new RadioAction(new ActionSetMode(ArgoModeCreateFigRect.class,
                                          "Rectangle", "misc.primitive.rectangle"));
//#endif 


//#if -43350803 
private static Action actionRRectangle =
        new RadioAction(new ActionSetMode(ArgoModeCreateFigRRect.class,
                                          "RRect", "misc.primitive.rounded-rectangle"));
//#endif 


//#if -574705705 
private static Action actionCircle =
        new RadioAction(new ActionSetMode(ArgoModeCreateFigCircle.class,
                                          "Circle", "misc.primitive.circle"));
//#endif 


//#if 371804775 
private static Action actionLine =
        new RadioAction(new ActionSetMode(ArgoModeCreateFigLine.class,
                                          "Line", "misc.primitive.line"));
//#endif 


//#if -470664373 
private static Action actionText =
        new RadioAction(new ActionSetMode(ArgoModeCreateFigText.class,
                                          "Text", "misc.primitive.text"));
//#endif 


//#if 1633326189 
private static Action actionPoly =
        new RadioAction(new ActionSetMode(ArgoModeCreateFigPoly.class,
                                          "Polygon", "misc.primitive.polygon"));
//#endif 


//#if 1971977819 
private static Action actionSpline =
        new RadioAction(new ActionSetMode(ArgoModeCreateFigSpline.class,
                                          "Spline", "misc.primitive.spline"));
//#endif 


//#if -590394981 
private static Action actionInk =
        new RadioAction(new ActionSetMode(ArgoModeCreateFigInk.class,
                                          "Ink", "misc.primitive.ink"));
//#endif 


//#if 934968279 
private JToolBar toolBar;
//#endif 


//#if -2012768402 
private Action selectedAction;
//#endif 


//#if 506226428 
protected FigNode createNaryAssociationNode(
        final Object modelElement,
        final Rectangle bounds,
        final DiagramSettings settings)
    { 

//#if -799649986 
final FigNodeAssociation diamondFig =
            new FigNodeAssociation(modelElement, bounds, settings);
//#endif 


//#if 463182033 
if(Model.getFacade().isAAssociationClass(modelElement)
                && bounds != null)//1
{ 

//#if -745664860 
final FigClassAssociationClass classBoxFig =
                new FigClassAssociationClass(
                modelElement, bounds, settings);
//#endif 


//#if -524122807 
final FigEdgeAssociationClass dashEdgeFig =
                new FigEdgeAssociationClass(
                classBoxFig, diamondFig, settings);
//#endif 


//#if -1074878244 
classBoxFig.renderingChanged();
//#endif 


//#if 1219182359 
Point location = bounds.getLocation();
//#endif 


//#if 1282150159 
location.y = (location.y - diamondFig.getHeight()) - 32;
//#endif 


//#if -183789993 
if(location.y < 16)//1
{ 

//#if 52524676 
location.y = 16;
//#endif 

} 

//#endif 


//#if -1498802706 
classBoxFig.setLocation(location);
//#endif 


//#if -672734432 
this.add(diamondFig);
//#endif 


//#if 384404133 
this.add(classBoxFig);
//#endif 


//#if 162873577 
this.add(dashEdgeFig);
//#endif 

} 

//#endif 


//#if 626138137 
return diamondFig;
//#endif 

} 

//#endif 


//#if 981648888 
public UMLDiagram(String name, Object ns, GraphModel graphModel)
    { 

//#if 1596392812 
super(name, graphModel, new LayerPerspective(name, graphModel));
//#endif 


//#if 1628099155 
setNamespace(ns);
//#endif 

} 

//#endif 


//#if 161440078 
private Object[] getCommentActions()
    { 

//#if -1790163762 
Object[] actions = {
            null,
            actionComment,
            actionCommentLink,
        };
//#endif 


//#if 2049646983 
return actions;
//#endif 

} 

//#endif 


//#if -163436159 
@Override
    public void initialize(Object owner)
    { 

//#if -827608022 
super.initialize(owner);
//#endif 


//#if -278744449 
if(Model.getFacade().isANamespace(owner))//1
{ 

//#if -1168718160 
setNamespace(owner);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1470379856 
public UMLDiagram(GraphModel graphModel)
    { 

//#if 230600984 
super("", graphModel, new LayerPerspective("", graphModel));
//#endif 

} 

//#endif 


//#if 1419899538 
public void deselectAllTools()
    { 

//#if 2024734324 
setSelectedAction(actionSelect);
//#endif 


//#if -780134504 
actionSelect.actionPerformed(null);
//#endif 

} 

//#endif 


//#if -1727601362 
protected Action makeCreateDependencyAction(
        Class modeClass,
        Object metaType,
        String descr)
    { 

//#if 1508753011 
return new RadioAction(
                   new ActionSetMode(modeClass, "edgeClass", metaType, descr));
//#endif 

} 

//#endif 


//#if 952306916 
private Object[] getShapePopupActions()
    { 

//#if 986038251 
Object[][] actions = {
            {actionRectangle, actionRRectangle },
            {actionCircle,    actionLine },
            {actionText,      actionPoly },
            {actionSpline,    actionInk },
        };
//#endif 


//#if 1579793349 
ToolBarUtility.manageDefault(actions, "diagram.shape");
//#endif 


//#if 1604059035 
return actions;
//#endif 

} 

//#endif 


//#if 443253671 
public String getClassAndModelID()
    { 

//#if 2094844076 
String s = super.getClassAndModelID();
//#endif 


//#if 1429427335 
if(getOwner() == null)//1
{ 

//#if 2139999480 
return s;
//#endif 

} 

//#endif 


//#if -437761588 
String id = UUIDHelper.getUUID(getOwner());
//#endif 


//#if -1702476572 
return s + "|" + id;
//#endif 

} 

//#endif 


//#if -1368457460 
@Deprecated
    public void resetDiagramSerial()
    { 
} 

//#endif 


//#if 182850954 
public boolean doesAccept(
        @SuppressWarnings("unused") Object objectToAccept)
    { 

//#if -1198011858 
return false;
//#endif 

} 

//#endif 


//#if -1865952930 
public ModePlace getModePlace(GraphFactory gf, String instructions)
    { 

//#if 853879813 
return new ModePlace(gf, instructions);
//#endif 

} 

//#endif 


//#if -454620561 
protected Action makeCreateEdgeAction(Object modelElement, String descr)
    { 

//#if -787847095 
return new RadioAction(
                   new ActionSetMode(ModeCreatePolyEdge.class, "edgeClass",
                                     modelElement, descr));
//#endif 

} 

//#endif 


//#if 1996037750 
@Deprecated
    protected int getNextDiagramSerial()
    { 

//#if 1372060904 
return 1;
//#endif 

} 

//#endif 


//#if -1367992628 
protected abstract Object[] getUmlActions();
//#endif 


//#if 823863839 

//#if 514126647 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public UMLDiagram()
    { 

//#if -636630964 
super();
//#endif 

} 

//#endif 


//#if -868025041 
public Object[] getActions()
    { 

//#if -1365275882 
Object[] manipulateActions = getManipulateActions();
//#endif 


//#if -691433838 
Object[] umlActions = getUmlActions();
//#endif 


//#if -544731288 
Object[] commentActions = getCommentActions();
//#endif 


//#if 2086750380 
Object[] shapeActions = getShapeActions();
//#endif 


//#if 929851584 
Object[] actions =
            new Object[manipulateActions.length
                       + umlActions.length
                       + commentActions.length
                       + shapeActions.length];
//#endif 


//#if 1761050619 
int posn = 0;
//#endif 


//#if -1788440986 
System.arraycopy(
            manipulateActions,           // source
            0,                           // source position
            actions,                     // destination
            posn,                        // destination position
            manipulateActions.length);
//#endif 


//#if 1037162082 
posn += manipulateActions.length;
//#endif 


//#if 725370812 
System.arraycopy(umlActions, 0, actions, posn, umlActions.length);
//#endif 


//#if 1660350680 
posn += umlActions.length;
//#endif 


//#if 1134631058 
System.arraycopy(commentActions, 0, actions, posn,
                         commentActions.length);
//#endif 


//#if -1079391251 
posn += commentActions.length;
//#endif 


//#if 1104190294 
System.arraycopy(shapeActions, 0, actions, posn, shapeActions.length);
//#endif 


//#if -1717373782 
return actions;
//#endif 

} 

//#endif 


//#if 408590528 
protected Action makeCreateAssociationEndAction(String descr)
    { 

//#if 1787671247 
return new RadioAction(new ActionSetAddAssociationEndMode(descr));
//#endif 

} 

//#endif 


//#if 1861290508 
private Object[] getShapeActions()
    { 

//#if 352871754 
Object[] actions = {
            null,
            getShapePopupActions(),
        };
//#endif 


//#if -1088458426 
return actions;
//#endif 

} 

//#endif 


//#if 52343121 
public JToolBar getJToolBar()
    { 

//#if 2093526503 
if(toolBar == null)//1
{ 

//#if -1196683142 
initToolBar();
//#endif 


//#if -1505378899 
toolBar.setName("misc.toolbar.diagram");
//#endif 

} 

//#endif 


//#if 718865368 
return toolBar;
//#endif 

} 

//#endif 


//#if 585640469 
private Object[] getManipulateActions()
    { 

//#if 1851913768 
Object[] actions = {
            new RadioAction(actionSelect),
            new RadioAction(actionBroom),
            null,
        };
//#endif 


//#if 1760854276 
return actions;
//#endif 

} 

//#endif 


//#if 1075005298 
public void initToolBar()
    { 

//#if -950815532 
ToolBarFactory factory = new ToolBarFactory(getActions());
//#endif 


//#if 873231384 
factory.setRollover(true);
//#endif 


//#if -1094546812 
factory.setFloatable(false);
//#endif 


//#if 1924121504 
toolBar = factory.createToolBar();
//#endif 


//#if -391409587 
toolBar.putClientProperty("ToolBar.toolTipSelectTool",
                                  Translator.localize("action.select"));
//#endif 

} 

//#endif 


//#if -1593767801 
public abstract boolean isRelocationAllowed(Object base);
//#endif 


//#if 183152364 
public Action getSelectedAction()
    { 

//#if 1905384732 
return selectedAction;
//#endif 

} 

//#endif 


//#if -1595082803 
public String getInstructions(Object droppedObject)
    { 

//#if 519596997 
return Translator.localize("misc.message.click-on-diagram-to-add",
                                   new Object[] {Model.getFacade().toString(droppedObject), });
//#endif 

} 

//#endif 


//#if 754839284 
protected Action makeCreateNodeAction(Object modelElement, String descr)
    { 

//#if 1974111879 
return new RadioAction(new CmdCreateNode(modelElement, descr));
//#endif 

} 

//#endif 


//#if 546117750 
public abstract boolean relocate(Object base);
//#endif 


//#if -700760545 
@Deprecated
    public UMLDiagram(String name, Object ns)
    { 

//#if 152809542 
this(ns);
//#endif 


//#if -1605051759 
try //1
{ 

//#if 238594593 
setName(name);
//#endif 

} 

//#if 83775754 
catch (PropertyVetoException pve) //1
{ 

//#if 1947926384 
LOG.fatal("Name not allowed in construction of diagram");
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1988501860 
protected Action makeCreateGeneralizationAction()
    { 

//#if 955775120 
return new RadioAction(
                   new ActionSetMode(
                       ModeCreateGeneralization.class,
                       "edgeClass",
                       Model.getMetaTypes().getGeneralization(),
                       "button.new-generalization"));
//#endif 

} 

//#endif 


//#if -1834113789 
protected Action makeCreateAssociationClassAction(String descr)
    { 

//#if 1355705651 
return new RadioAction(new ActionSetAddAssociationClassMode(descr));
//#endif 

} 

//#endif 


//#if -1194012621 
protected String getNewDiagramName()
    { 

//#if 1495940634 
return /*"unnamed " + */ getLabelName();
//#endif 

} 

//#endif 


//#if 896762611 
@Override
    public final void setProject(Project p)
    { 

//#if 1055123158 
super.setProject(p);
//#endif 


//#if -1470582967 
UMLMutableGraphSupport gm = (UMLMutableGraphSupport) getGraphModel();
//#endif 


//#if 620821991 
gm.setProject(p);
//#endif 

} 

//#endif 


//#if -1229638809 
public void setSelectedAction(Action theAction)
    { 

//#if -2062621461 
selectedAction = theAction;
//#endif 


//#if -1598520923 
int toolCount = toolBar.getComponentCount();
//#endif 


//#if -101335936 
for (int i = 0; i < toolCount; ++i) //1
{ 

//#if 467974879 
Component c = toolBar.getComponent(i);
//#endif 


//#if -1160028069 
if(c instanceof ToolButton)//1
{ 

//#if 2074379033 
ToolButton tb = (ToolButton) c;
//#endif 


//#if -516162790 
Action action = tb.getRealAction();
//#endif 


//#if -1771414713 
if(action instanceof RadioAction)//1
{ 

//#if -1120750739 
action = ((RadioAction) action).getAction();
//#endif 

} 

//#endif 


//#if -667410308 
Action otherAction = theAction;
//#endif 


//#if 297459126 
if(theAction instanceof RadioAction)//1
{ 

//#if -337738353 
otherAction = ((RadioAction) theAction).getAction();
//#endif 

} 

//#endif 


//#if 1710129108 
if(action != null && !action.equals(otherAction))//1
{ 

//#if 1760838582 
tb.setSelected(false);
//#endif 


//#if 213132014 
ButtonModel bm = tb.getModel();
//#endif 


//#if 1183866697 
bm.setRollover(false);
//#endif 


//#if 2116006163 
bm.setSelected(false);
//#endif 


//#if 180127805 
bm.setArmed(false);
//#endif 


//#if -757572572 
bm.setPressed(false);
//#endif 


//#if 2112382549 
if(!ToolBarManager.alwaysUseStandardRollover())//1
{ 

//#if 1789777280 
tb.setBorderPainted(false);
//#endif 

} 

//#endif 

} 
else
{ 

//#if 1429548623 
tb.setSelected(true);
//#endif 


//#if 1552940958 
ButtonModel bm = tb.getModel();
//#endif 


//#if -1498557348 
bm.setRollover(true);
//#endif 


//#if 1230020357 
if(!ToolBarManager.alwaysUseStandardRollover())//1
{ 

//#if -2028504279 
tb.setBorderPainted(true);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1804574435 
public abstract String getLabelName();
//#endif 


//#if 446522362 
protected Action makeCreateAssociationAction(
        Object aggregationKind,
        boolean unidirectional,
        String descr)
    { 

//#if -702937355 
return new RadioAction(
                   new ActionSetAddAssociationMode(aggregationKind,
                           unidirectional, descr));
//#endif 

} 

//#endif 


//#if 1951252283 
@Deprecated
    public UMLDiagram(Object ns)
    { 

//#if -1783973270 
this();
//#endif 


//#if 2062638290 
if(!Model.getFacade().isANamespace(ns))//1
{ 

//#if -1165417501 
throw new IllegalArgumentException();
//#endif 

} 

//#endif 


//#if -894956716 
setNamespace(ns);
//#endif 

} 

//#endif 


//#if -2099704087 

//#if -1065764956 
@SuppressWarnings("unused")
//#endif 


    public FigNode drop(Object droppedObject, Point location)
    { 

//#if -1364913820 
return null;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

