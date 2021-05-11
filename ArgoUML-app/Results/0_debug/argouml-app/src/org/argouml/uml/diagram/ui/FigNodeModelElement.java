
//#if 2022222233 
// Compilation Unit of /FigNodeModelElement.java 
 

//#if 728810669 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 1700992654 
import java.awt.Dimension;
//#endif 


//#if -1999474893 
import java.awt.Font;
//#endif 


//#if 115379447 
import java.awt.Graphics;
//#endif 


//#if -1770537543 
import java.awt.Image;
//#endif 


//#if 1687213989 
import java.awt.Rectangle;
//#endif 


//#if 1675308766 
import java.awt.event.InputEvent;
//#endif 


//#if 1887484531 
import java.awt.event.KeyEvent;
//#endif 


//#if -909461707 
import java.awt.event.KeyListener;
//#endif 


//#if -1479687303 
import java.awt.event.MouseEvent;
//#endif 


//#if 930596975 
import java.awt.event.MouseListener;
//#endif 


//#if -607798790 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -600918450 
import java.beans.PropertyChangeListener;
//#endif 


//#if 1807889887 
import java.beans.PropertyVetoException;
//#endif 


//#if 2003622527 
import java.beans.VetoableChangeListener;
//#endif 


//#if -779837113 
import java.util.ArrayList;
//#endif 


//#if -1360515846 
import java.util.Collection;
//#endif 


//#if -714118640 
import java.util.HashMap;
//#endif 


//#if -713935926 
import java.util.HashSet;
//#endif 


//#if 1343508586 
import java.util.Iterator;
//#endif 


//#if 412918970 
import java.util.List;
//#endif 


//#if 152071964 
import java.util.Set;
//#endif 


//#if 1834001781 
import java.util.Vector;
//#endif 


//#if -446642950 
import javax.swing.Action;
//#endif 


//#if 1669486679 
import javax.swing.Icon;
//#endif 


//#if 1346679733 
import javax.swing.JSeparator;
//#endif 


//#if -1175349436 
import javax.swing.SwingUtilities;
//#endif 


//#if -1052482236 
import org.apache.log4j.Logger;
//#endif 


//#if 194058792 
import org.argouml.application.events.ArgoDiagramAppearanceEvent;
//#endif 


//#if 194039508 
import org.argouml.application.events.ArgoDiagramAppearanceEventListener;
//#endif 


//#if -1224344183 
import org.argouml.application.events.ArgoEventPump;
//#endif 


//#if 818327276 
import org.argouml.application.events.ArgoEventTypes;
//#endif 


//#if -1373103950 
import org.argouml.application.events.ArgoHelpEvent;
//#endif 


//#if -358008653 
import org.argouml.application.events.ArgoNotationEvent;
//#endif 


//#if -657247649 
import org.argouml.application.events.ArgoNotationEventListener;
//#endif 


//#if -2063526148 
import org.argouml.cognitive.Designer;
//#endif 


//#if 36903201 
import org.argouml.cognitive.Highlightable;
//#endif 


//#if 711455502 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 713912035 
import org.argouml.cognitive.ToDoList;
//#endif 


//#if 1181232042 
import org.argouml.cognitive.ui.ActionGoToCritique;
//#endif 


//#if 1773954417 
import org.argouml.i18n.Translator;
//#endif 


//#if 877140785 
import org.argouml.kernel.DelayedChangeNotify;
//#endif 


//#if -1565418606 
import org.argouml.kernel.DelayedVChangeListener;
//#endif 


//#if 36230899 
import org.argouml.kernel.Project;
//#endif 


//#if 807790573 
import org.argouml.model.AssociationChangeEvent;
//#endif 


//#if -1433554872 
import org.argouml.model.AttributeChangeEvent;
//#endif 


//#if 219234854 
import org.argouml.model.DeleteInstanceEvent;
//#endif 


//#if -2113652631 
import org.argouml.model.DiElement;
//#endif 


//#if 1833350134 
import org.argouml.model.InvalidElementException;
//#endif 


//#if 795054263 
import org.argouml.model.Model;
//#endif 


//#if -1521142080 
import org.argouml.model.UmlChangeEvent;
//#endif 


//#if -360769171 
import org.argouml.notation.Notation;
//#endif 


//#if -92006622 
import org.argouml.notation.NotationName;
//#endif 


//#if -159211652 
import org.argouml.notation.NotationProvider;
//#endif 


//#if -1557591308 
import org.argouml.notation.NotationProviderFactory2;
//#endif 


//#if 1912254346 
import org.argouml.notation.NotationSettings;
//#endif 


//#if -1588242843 
import org.argouml.ui.ArgoJMenu;
//#endif 


//#if 1979808086 
import org.argouml.ui.Clarifier;
//#endif 


//#if -1185867363 
import org.argouml.ui.ProjectActions;
//#endif 


//#if 1755750189 
import org.argouml.ui.UndoableAction;
//#endif 


//#if -401787061 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -368940773 
import org.argouml.uml.StereotypeUtility;
//#endif 


//#if -1357948938 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if -378635271 
import org.argouml.uml.diagram.DiagramAppearance;
//#endif 


//#if 1912468634 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 1049232084 
import org.argouml.uml.diagram.PathContainer;
//#endif 


//#if -1658076887 
import org.argouml.uml.diagram.DiagramSettings.StereotypeStyle;
//#endif 


//#if -1836725508 
import org.argouml.uml.ui.ActionDeleteModelElements;
//#endif 


//#if -1182995429 
import org.argouml.util.IItemUID;
//#endif 


//#if -121700310 
import org.argouml.util.ItemUID;
//#endif 


//#if 2088431208 
import org.tigris.gef.base.Diagram;
//#endif 


//#if 1785133483 
import org.tigris.gef.base.Globals;
//#endif 


//#if -1290550870 
import org.tigris.gef.base.Layer;
//#endif 


//#if -2134002480 
import org.tigris.gef.base.LayerPerspective;
//#endif 


//#if 1023892687 
import org.tigris.gef.base.Selection;
//#endif 


//#if 1737050065 
import org.tigris.gef.graph.MutableGraphSupport;
//#endif 


//#if 1351426990 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -49229271 
import org.tigris.gef.presentation.FigGroup;
//#endif 


//#if 2980557 
import org.tigris.gef.presentation.FigImage;
//#endif 


//#if 974607436 
import org.tigris.gef.presentation.FigNode;
//#endif 


//#if 978003114 
import org.tigris.gef.presentation.FigRect;
//#endif 


//#if 979870337 
import org.tigris.gef.presentation.FigText;
//#endif 


//#if -1394179670 
public abstract class FigNodeModelElement extends 
//#if 1386570880 
FigNode
//#endif 

 implements 
//#if -281438258 
VetoableChangeListener
//#endif 

, 
//#if 213061950 
DelayedVChangeListener
//#endif 

, 
//#if -1566171821 
MouseListener
//#endif 

, 
//#if -1846242419 
KeyListener
//#endif 

, 
//#if -504003041 
PropertyChangeListener
//#endif 

, 
//#if 2051542710 
PathContainer
//#endif 

, 
//#if -753034314 
ArgoDiagramAppearanceEventListener
//#endif 

, 
//#if -722489587 
ArgoNotationEventListener
//#endif 

, 
//#if 2115032296 
Highlightable
//#endif 

, 
//#if -1269480838 
IItemUID
//#endif 

, 
//#if 117921286 
Clarifiable
//#endif 

, 
//#if 1502625989 
ArgoFig
//#endif 

, 
//#if 646623115 
StereotypeStyled
//#endif 

  { 

//#if -1999708087 
private static final Logger LOG =
        Logger.getLogger(FigNodeModelElement.class);
//#endif 


//#if -228201321 
protected static final int WIDTH = 64;
//#endif 


//#if -1911798170 
protected static final int NAME_FIG_HEIGHT = 21;
//#endif 


//#if -1331711101 
protected static final int NAME_V_PADDING = 2;
//#endif 


//#if 2054044958 
private DiElement diElement;
//#endif 


//#if -2059919219 
private NotationProvider notationProviderName;
//#endif 


//#if -772465866 
private HashMap<String, Object> npArguments;
//#endif 


//#if 442669786 
protected boolean invisibleAllowed = false;
//#endif 


//#if 1759405518 
private boolean checkSize = true;
//#endif 


//#if -1545017841 
private static int popupAddOffset;
//#endif 


//#if -970920618 
protected static final int ROOT = 1;
//#endif 


//#if 1066249653 
protected static final int ABSTRACT = 2;
//#endif 


//#if 1994354103 
protected static final int LEAF = 4;
//#endif 


//#if 27574603 
protected static final int ACTIVE = 8;
//#endif 


//#if 1849394305 
private Fig bigPort;
//#endif 


//#if -2105679754 
private FigText nameFig;
//#endif 


//#if 1052397742 
private FigStereotypesGroup stereotypeFig;
//#endif 


//#if -1647540944 
private FigProfileIcon stereotypeFigProfileIcon;
//#endif 


//#if 743372312 
private List<Fig> floatingStereotypes = new ArrayList<Fig>();
//#endif 


//#if -230761 
private DiagramSettings.StereotypeStyle stereotypeStyle =
        DiagramSettings.StereotypeStyle.TEXTUAL;
//#endif 


//#if 801282845 
private static final int ICON_WIDTH = 16;
//#endif 


//#if 730241383 
private FigText originalNameFig;
//#endif 


//#if -312325692 
private Vector<Fig> enclosedFigs = new Vector<Fig>();
//#endif 


//#if 2039955537 
private Fig encloser;
//#endif 


//#if 595959501 
private boolean readyToEdit = true;
//#endif 


//#if -28337999 
private boolean suppressCalcBounds;
//#endif 


//#if 741858577 
private static boolean showBoldName;
//#endif 


//#if 198209310 
private ItemUID itemUid;
//#endif 


//#if -452669110 
private boolean removeFromDiagram = true;
//#endif 


//#if 1611931135 
private boolean editable = true;
//#endif 


//#if 924380801 
private Set<Object[]> listeners = new HashSet<Object[]>();
//#endif 


//#if -759409089 
private DiagramSettings settings;
//#endif 


//#if -955722636 
private NotationSettings notationSettings;
//#endif 


//#if -1609458791 
@Override
    public void setEnclosingFig(Fig newEncloser)
    { 

//#if -2146066040 
Fig oldEncloser = encloser;
//#endif 


//#if 309319883 
LayerPerspective layer = (LayerPerspective) getLayer();
//#endif 


//#if -1229633992 
if(layer != null)//1
{ 

//#if -250823957 
ArgoDiagram diagram = (ArgoDiagram) layer.getDiagram();
//#endif 


//#if 912841149 
diagram.encloserChanged(
                this,
                (FigNode) oldEncloser,
                (FigNode) newEncloser);
//#endif 

} 

//#endif 


//#if -1940627923 
super.setEnclosingFig(newEncloser);
//#endif 


//#if -1055597021 
if(layer != null && newEncloser != oldEncloser)//1
{ 

//#if 71353487 
Diagram diagram = layer.getDiagram();
//#endif 


//#if 1268364994 
if(diagram instanceof ArgoDiagram)//1
{ 

//#if 321223871 
ArgoDiagram umlDiagram = (ArgoDiagram) diagram;
//#endif 


//#if -1600201033 
Object namespace = null;
//#endif 


//#if -2025458973 
if(newEncloser == null)//1
{ 

//#if -386575495 
umlDiagram.setModelElementNamespace(getOwner(), null);
//#endif 

} 
else
{ 

//#if 210819075 
namespace = newEncloser.getOwner();
//#endif 


//#if -420681446 
if(Model.getFacade().isANamespace(namespace))//1
{ 

//#if -1793652152 
umlDiagram.setModelElementNamespace(
                            getOwner(), namespace);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1204364339 
if(encloser instanceof FigNodeModelElement)//1
{ 

//#if 698343408 
((FigNodeModelElement) encloser).removeEnclosedFig(this);
//#endif 

} 

//#endif 


//#if 748386961 
if(newEncloser instanceof FigNodeModelElement)//1
{ 

//#if 1391001082 
((FigNodeModelElement) newEncloser).addEnclosedFig(this);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1593745387 
encloser = newEncloser;
//#endif 

} 

//#endif 


//#if -1022871415 
private void addElementListeners(Set<Object[]> listenerSet)
    { 

//#if -1468887019 
for (Object[] listener : listenerSet) //1
{ 

//#if -2049825107 
Object property = listener[1];
//#endif 


//#if -909461141 
if(property == null)//1
{ 

//#if -116719849 
addElementListener(listener[0]);
//#endif 

} 
else

//#if -1789365389 
if(property instanceof String[])//1
{ 

//#if 1327018952 
addElementListener(listener[0], (String[]) property);
//#endif 

} 
else

//#if 149140687 
if(property instanceof String)//1
{ 

//#if -1595915699 
addElementListener(listener[0], (String) property);
//#endif 

} 
else
{ 

//#if -68867862 
throw new RuntimeException(
                    "Internal error in addElementListeners");
//#endif 

} 

//#endif 


//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if -1658649957 
public void vetoableChange(PropertyChangeEvent pce)
    { 

//#if -1888103292 
LOG.debug("in vetoableChange");
//#endif 


//#if -442920215 
Object src = pce.getSource();
//#endif 


//#if -1371740629 
if(src == getOwner())//1
{ 

//#if 1718977433 
DelayedChangeNotify delayedNotify =
                new DelayedChangeNotify(this, pce);
//#endif 


//#if -39144566 
SwingUtilities.invokeLater(delayedNotify);
//#endif 

} 
else
{ 

//#if 2143809638 
LOG.debug("FigNodeModelElement got vetoableChange"
                      + " from non-owner:"
                      + src);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1337369447 
protected void setEditable(boolean canEdit)
    { 

//#if -1733970770 
this.editable = canEdit;
//#endif 

} 

//#endif 


//#if -1881771360 
public void setSettings(DiagramSettings renderSettings)
    { 

//#if -2066078044 
settings = renderSettings;
//#endif 


//#if 976507766 
renderingChanged();
//#endif 

} 

//#endif 


//#if 1394444484 
protected void updateListeners(Object oldOwner, Object newOwner)
    { 

//#if -1646084297 
if(oldOwner == newOwner)//1
{ 

//#if -436875186 
return;
//#endif 

} 

//#endif 


//#if 1779817575 
if(oldOwner != null)//1
{ 

//#if 2125355169 
removeElementListener(oldOwner);
//#endif 

} 

//#endif 


//#if 783441870 
if(newOwner != null)//1
{ 

//#if -1391393016 
addElementListener(newOwner);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -241569545 
protected ToDoItem hitClarifier(int x, int y)
    { 

//#if 1489142108 
int iconX = getX();
//#endif 


//#if 1232334042 
ToDoList tdList = Designer.theDesigner().getToDoList();
//#endif 


//#if 1701526373 
List<ToDoItem> items = tdList.elementListForOffender(getOwner());
//#endif 


//#if 1004171274 
for (ToDoItem item : items) //1
{ 

//#if -1497958714 
Icon icon = item.getClarifier();
//#endif 


//#if 1023519129 
int width = icon.getIconWidth();
//#endif 


//#if 1832325602 
if(y >= getY() - 15
                    && y <= getY() + 10
                    && x >= iconX
                    && x <= iconX + width)//1
{ 

//#if -438549858 
return item;
//#endif 

} 

//#endif 


//#if 567190379 
iconX += width;
//#endif 

} 

//#endif 


//#if 819283559 
for (ToDoItem item : items) //2
{ 

//#if 1997680108 
Icon icon = item.getClarifier();
//#endif 


//#if -1336935284 
if(icon instanceof Clarifier)//1
{ 

//#if 912787179 
((Clarifier) icon).setFig(this);
//#endif 


//#if -451578787 
((Clarifier) icon).setToDoItem(item);
//#endif 


//#if 1847422769 
if(((Clarifier) icon).hit(x, y))//1
{ 

//#if 1185318341 
return item;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 684298334 
items = tdList.elementListForOffender(this);
//#endif 


//#if 819313351 
for (ToDoItem item : items) //3
{ 

//#if 766028127 
Icon icon = item.getClarifier();
//#endif 


//#if -1007461326 
int width = icon.getIconWidth();
//#endif 


//#if 1388638907 
if(y >= getY() - 15
                    && y <= getY() + 10
                    && x >= iconX
                    && x <= iconX + width)//1
{ 

//#if 1893879496 
return item;
//#endif 

} 

//#endif 


//#if 868395012 
iconX += width;
//#endif 

} 

//#endif 


//#if 819343143 
for (ToDoItem item : items) //4
{ 

//#if -1081952434 
Icon icon = item.getClarifier();
//#endif 


//#if 1978703722 
if(icon instanceof Clarifier)//1
{ 

//#if 841667450 
((Clarifier) icon).setFig(this);
//#endif 


//#if 53946670 
((Clarifier) icon).setToDoItem(item);
//#endif 


//#if -2074127360 
if(((Clarifier) icon).hit(x, y))//1
{ 

//#if -2094493086 
return item;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1855688109 
return null;
//#endif 

} 

//#endif 


//#if -1701221883 
public void keyReleased(KeyEvent ke)
    { 

//#if 1116581453 
if(ke.isConsumed() || getOwner() == null)//1
{ 

//#if 1007452837 
return;
//#endif 

} 

//#endif 


//#if -1657864591 
nameFig.keyReleased(ke);
//#endif 

} 

//#endif 


//#if -188379766 
@Override
    public String getTipString(MouseEvent me)
    { 

//#if -1140451552 
ToDoItem item = hitClarifier(me.getX(), me.getY());
//#endif 


//#if -254496294 
String tip = "";
//#endif 


//#if -329770359 
if(item != null
                && Globals.curEditor().getSelectionManager().containsFig(this))//1
{ 

//#if 1465725085 
tip = item.getHeadline() + " ";
//#endif 

} 
else

//#if 874600000 
if(getOwner() != null)//1
{ 

//#if 1738195348 
tip = Model.getFacade().getTipString(getOwner());
//#endif 

} 
else
{ 

//#if 1851598294 
tip = toString();
//#endif 

} 

//#endif 


//#endif 


//#if 618430574 
if(tip != null && tip.length() > 0 && !tip.endsWith(" "))//1
{ 

//#if -784023803 
tip += " ";
//#endif 

} 

//#endif 


//#if -1786245122 
return tip;
//#endif 

} 

//#endif 


//#if 1837258565 
public void setPathVisible(boolean visible)
    { 

//#if 1206309164 
NotationSettings ns = getNotationSettings();
//#endif 


//#if 1874881494 
if(ns.isShowPaths() == visible)//1
{ 

//#if 1295620910 
return;
//#endif 

} 

//#endif 


//#if 364585367 
MutableGraphSupport.enableSaveAction();
//#endif 


//#if -1416894217 
firePropChange("pathVisible", !visible, visible);
//#endif 


//#if 900349518 
ns.setShowPaths(visible);
//#endif 


//#if -73059253 
if(readyToEdit)//1
{ 

//#if -1069704296 
renderingChanged();
//#endif 


//#if 1944867025 
damage();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -230644530 
public int getStereotypeView()
    { 

//#if -548798049 
return stereotypeStyle.ordinal();
//#endif 

} 

//#endif 


//#if 1906196291 
protected void modelChanged(PropertyChangeEvent event)
    { 

//#if -375986544 
if(event instanceof AssociationChangeEvent
                || event instanceof AttributeChangeEvent)//1
{ 

//#if -937838034 
if(notationProviderName != null)//1
{ 

//#if -330885408 
notationProviderName.updateListener(this, getOwner(), event);
//#endif 

} 

//#endif 


//#if -2025729370 
updateListeners(getOwner(), getOwner());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1254509077 
protected void setReadyToEdit(boolean v)
    { 

//#if -792902105 
readyToEdit = v;
//#endif 

} 

//#endif 


//#if 925971780 
@Deprecated
    protected void putNotationArgument(String key, Object value)
    { 

//#if 488580162 
if(notationProviderName != null)//1
{ 

//#if -307158142 
if(npArguments == null)//1
{ 

//#if -1446980804 
npArguments = new HashMap<String, Object>();
//#endif 

} 

//#endif 


//#if -1211184743 
npArguments.put(key, value);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -586252411 
protected void removeAllElementListeners()
    { 

//#if 2127271043 
removeElementListeners(listeners);
//#endif 

} 

//#endif 


//#if 308887575 
protected FigStereotypesGroup getStereotypeFig()
    { 

//#if -1808705681 
return stereotypeFig;
//#endif 

} 

//#endif 


//#if 2138264555 
private void updateSmallIcons(int wid)
    { 

//#if -918790299 
int i = this.getX() + wid - ICON_WIDTH - 2;
//#endif 


//#if -1886393752 
for (Fig ficon : floatingStereotypes) //1
{ 

//#if -314216942 
ficon.setLocation(i, this.getBigPort().getY() + 2);
//#endif 


//#if 1570627005 
i -= ICON_WIDTH - 2;
//#endif 

} 

//#endif 


//#if -1701558141 
getNameFig().setRightMargin(
            floatingStereotypes.size() * (ICON_WIDTH + 5));
//#endif 

} 

//#endif 


//#if 614787833 
protected int getNameFigFontStyle()
    { 

//#if 1255963124 
showBoldName = getSettings().isShowBoldNames();
//#endif 


//#if -1575773370 
return showBoldName ? Font.BOLD : Font.PLAIN;
//#endif 

} 

//#endif 


//#if -821194213 
public void setItemUID(ItemUID id)
    { 

//#if -73501237 
itemUid = id;
//#endif 

} 

//#endif 


//#if -1018593741 
public void setStereotypeView(int s)
    { 

//#if 472743449 
setStereotypeStyle(StereotypeStyle.getEnum(s));
//#endif 

} 

//#endif 


//#if 1785575620 
protected void textEditStarted(FigText ft)
    { 

//#if -1633731496 
if(ft == getNameFig())//1
{ 

//#if -259601311 
showHelp(notationProviderName.getParsingHelp());
//#endif 


//#if -173388395 
ft.setText(notationProviderName.toString(getOwner(),
                       getNotationSettings()));
//#endif 

} 

//#endif 


//#if -541129825 
if(ft instanceof CompartmentFigText)//1
{ 

//#if 1463399308 
final CompartmentFigText figText = (CompartmentFigText) ft;
//#endif 


//#if 202208919 
showHelp(figText.getNotationProvider().getParsingHelp());
//#endif 


//#if 593205837 
figText.setText(figText.getNotationProvider().toString(
                                figText.getOwner(), getNotationSettings()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 230943142 
public void paintClarifiers(Graphics g)
    { 

//#if 1861225248 
int iconX = getX();
//#endif 


//#if 749789770 
int iconY = getY() - 10;
//#endif 


//#if 1775166622 
ToDoList tdList = Designer.theDesigner().getToDoList();
//#endif 


//#if 81153577 
List<ToDoItem> items = tdList.elementListForOffender(getOwner());
//#endif 


//#if -1601596210 
for (ToDoItem item : items) //1
{ 

//#if 1982658210 
Icon icon = item.getClarifier();
//#endif 


//#if -1802614122 
if(icon instanceof Clarifier)//1
{ 

//#if 926560092 
((Clarifier) icon).setFig(this);
//#endif 


//#if -1708135796 
((Clarifier) icon).setToDoItem(item);
//#endif 

} 

//#endif 


//#if -1676369904 
if(icon != null)//1
{ 

//#if -2033333955 
icon.paintIcon(null, g, iconX, iconY);
//#endif 


//#if -157101221 
iconX += icon.getIconWidth();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -188830430 
items = tdList.elementListForOffender(this);
//#endif 


//#if -360924381 
for (ToDoItem item : items) //2
{ 

//#if 980882581 
Icon icon = item.getClarifier();
//#endif 


//#if 1502079747 
if(icon instanceof Clarifier)//1
{ 

//#if 75840661 
((Clarifier) icon).setFig(this);
//#endif 


//#if -200722189 
((Clarifier) icon).setToDoItem(item);
//#endif 

} 

//#endif 


//#if -641871229 
if(icon != null)//1
{ 

//#if 1367106579 
icon.paintIcon(null, g, iconX, iconY);
//#endif 


//#if -1897094095 
iconX += icon.getIconWidth();
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -429572304 
@Override
    public Object clone()
    { 

//#if -1955968448 
final FigNodeModelElement clone = (FigNodeModelElement) super.clone();
//#endif 


//#if -1206916756 
final Iterator cloneIter = clone.getFigs().iterator();
//#endif 


//#if -477778217 
for (Object thisFig : getFigs()) //1
{ 

//#if -1890447568 
final Fig cloneFig = (Fig) cloneIter.next();
//#endif 


//#if 469625576 
if(thisFig == getBigPort())//1
{ 

//#if 2017291545 
clone.setBigPort(cloneFig);
//#endif 

} 

//#endif 


//#if -938126771 
if(thisFig == nameFig)//1
{ 

//#if -1777181948 
clone.nameFig = (FigSingleLineText) thisFig;
//#endif 

} 

//#endif 


//#if 1504480633 
if(thisFig == getStereotypeFig())//1
{ 

//#if 645700189 
clone.stereotypeFig = (FigStereotypesGroup) thisFig;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -700415341 
return clone;
//#endif 

} 

//#endif 


//#if -1589043928 
protected FigNodeModelElement(Object element, Rectangle bounds,
                                  DiagramSettings renderSettings)
    { 

//#if 78367450 
super();
//#endif 


//#if -960914331 
super.setOwner(element);
//#endif 


//#if 1270153891 
settings = renderSettings;
//#endif 


//#if -723591019 
super.setFillColor(FILL_COLOR);
//#endif 


//#if 880409143 
super.setLineColor(LINE_COLOR);
//#endif 


//#if -1522162089 
super.setLineWidth(LINE_WIDTH);
//#endif 


//#if 1953324905 
super.setTextColor(TEXT_COLOR);
//#endif 


//#if 1100583363 
notationSettings = new NotationSettings(settings.getNotationSettings());
//#endif 


//#if -739208750 
bigPort = new FigRect(X0, Y0, 0, 0, DEBUG_COLOR, DEBUG_COLOR);
//#endif 


//#if 5096573 
nameFig = new FigNameWithAbstractAndBold(element,
                new Rectangle(X0, Y0, WIDTH, NAME_FIG_HEIGHT), getSettings(), true);
//#endif 


//#if 1173898986 
stereotypeFig = createStereotypeFig();
//#endif 


//#if -1967367665 
constructFigs();
//#endif 


//#if 150858802 
if(element != null && !Model.getFacade().isAUMLElement(element))//1
{ 

//#if -1548227600 
throw new IllegalArgumentException(
                "The owner must be a model element - got a "
                + element.getClass().getName());
//#endif 

} 

//#endif 


//#if -1630062910 
nameFig.setText(placeString());
//#endif 


//#if -556304169 
if(element != null)//1
{ 

//#if -1356558031 
notationProviderName =
                NotationProviderFactory2.getInstance().getNotationProvider(
                    getNotationProviderType(), element, this);
//#endif 


//#if -81915219 
bindPort(element, bigPort);
//#endif 


//#if 99689033 
addElementListener(element);
//#endif 

} 

//#endif 


//#if 1950198064 
if(bounds != null)//1
{ 

//#if 158235500 
setLocation(bounds.x, bounds.y);
//#endif 

} 

//#endif 


//#if 2090821757 
readyToEdit = true;
//#endif 

} 

//#endif 


//#if -1339632865 
protected boolean isReadyToEdit()
    { 

//#if 1743155362 
return readyToEdit;
//#endif 

} 

//#endif 


//#if 1519759833 
@Override
    public void mouseClicked(MouseEvent me)
    { 

//#if -2111860054 
if(!readyToEdit)//1
{ 

//#if -1541022458 
if(Model.getFacade().isAModelElement(getOwner()))//1
{ 

//#if -266876713 
Model.getCoreHelper().setName(getOwner(), "");
//#endif 


//#if -370861511 
readyToEdit = true;
//#endif 

} 
else
{ 

//#if 904560420 
LOG.debug("not ready to edit name");
//#endif 


//#if 689246136 
return;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2084239030 
if(me.isConsumed())//1
{ 

//#if 658100918 
return;
//#endif 

} 

//#endif 


//#if -1418386515 
if(me.getClickCount() >= 2
                && !(me.isPopupTrigger()
                     || me.getModifiers() == InputEvent.BUTTON3_MASK)
                && getOwner() != null
                && !isReadOnly())//1
{ 

//#if -1599873751 
Rectangle r = new Rectangle(me.getX() - 2, me.getY() - 2, 4, 4);
//#endif 


//#if -2041702307 
Fig f = hitFig(r);
//#endif 


//#if 792099042 
if(f instanceof MouseListener && f.isVisible())//1
{ 

//#if -1609456753 
((MouseListener) f).mouseClicked(me);
//#endif 

} 
else

//#if 320940729 
if(f instanceof FigGroup && f.isVisible())//1
{ 

//#if -2074934690 
Fig f2 = ((FigGroup) f).hitFig(r);
//#endif 


//#if 1242688837 
if(f2 instanceof MouseListener)//1
{ 

//#if -1254849162 
((MouseListener) f2).mouseClicked(me);
//#endif 

} 
else
{ 

//#if 1235060988 
createContainedModelElement((FigGroup) f, me);
//#endif 

} 

//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if -1295674876 
private void stereotypeChanged(final UmlChangeEvent event)
    { 

//#if 1111318576 
final Object owner = getOwner();
//#endif 


//#if -1930439587 
assert owner != null;
//#endif 


//#if 655556872 
try //1
{ 

//#if 38052795 
if(event.getOldValue() != null)//1
{ 

//#if -92706148 
removeElementListener(event.getOldValue());
//#endif 

} 

//#endif 


//#if 298707298 
if(event.getNewValue() != null)//1
{ 

//#if -1719317237 
addElementListener(event.getNewValue(), "name");
//#endif 

} 

//#endif 

} 

//#if 416210979 
catch (InvalidElementException e) //1
{ 

//#if -1825365302 
LOG.debug("stereotypeChanged method accessed deleted element ", e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1918964498 
@Override
    protected void setBoundsImpl(final int x, final int y, final int w,
                                 final int h)
    { 

//#if -33922550 
if(getPracticalView() == DiagramAppearance.STEREOTYPE_VIEW_BIG_ICON)//1
{ 

//#if 2088561779 
if(stereotypeFigProfileIcon != null)//1
{ 

//#if -2128900153 
stereotypeFigProfileIcon.setBounds(stereotypeFigProfileIcon
                                                   .getX(), stereotypeFigProfileIcon.getY(), w, h);
//#endif 

} 

//#endif 

} 
else
{ 

//#if -1165930937 
setStandardBounds(x, y, w, h);
//#endif 


//#if 1406916547 
if(getStereotypeView()
                    == DiagramAppearance.STEREOTYPE_VIEW_SMALL_ICON)//1
{ 

//#if -653405492 
updateSmallIcons(w);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1890271077 
protected void updateBounds()
    { 

//#if -1380187835 
if(!checkSize)//1
{ 

//#if 2106023885 
return;
//#endif 

} 

//#endif 


//#if -1718340950 
Rectangle bbox = getBounds();
//#endif 


//#if 81512807 
Dimension minSize = getMinimumSize();
//#endif 


//#if -1545877034 
bbox.width = Math.max(bbox.width, minSize.width);
//#endif 


//#if 1504209591 
bbox.height = Math.max(bbox.height, minSize.height);
//#endif 


//#if 1321374777 
setBounds(bbox.x, bbox.y, bbox.width, bbox.height);
//#endif 

} 

//#endif 


//#if 64742827 
@Override
    public final void removeFromDiagram()
    { 

//#if 1429934195 
Fig delegate = getRemoveDelegate();
//#endif 


//#if -1592183159 
if(delegate instanceof FigNodeModelElement)//1
{ 

//#if -1274199560 
((FigNodeModelElement) delegate).removeFromDiagramImpl();
//#endif 

} 
else

//#if 962308531 
if(delegate instanceof FigEdgeModelElement)//1
{ 

//#if 435702342 
((FigEdgeModelElement) delegate).removeFromDiagramImpl();
//#endif 

} 
else

//#if -201171922 
if(delegate != null)//1
{ 

//#if 1047136810 
removeFromDiagramImpl();
//#endif 

} 

//#endif 


//#endif 


//#endif 

} 

//#endif 


//#if -821208527 
protected void updateStereotypeIcon()
    { 

//#if -1697422786 
if(getOwner() == null)//1
{ 

//#if -1392648732 
LOG.warn("Owner of [" + this.toString() + "/" + this.getClass()
                     + "] is null.");
//#endif 


//#if 792557411 
LOG.warn("I return...");
//#endif 


//#if 177361049 
return;
//#endif 

} 

//#endif 


//#if 1057799884 
if(stereotypeFigProfileIcon != null)//1
{ 

//#if 1789216400 
for (Object fig : getFigs()) //1
{ 

//#if 1937685790 
((Fig) fig).setVisible(fig != stereotypeFigProfileIcon);
//#endif 

} 

//#endif 


//#if -522703632 
this.removeFig(stereotypeFigProfileIcon);
//#endif 


//#if 2054658033 
stereotypeFigProfileIcon = null;
//#endif 

} 

//#endif 


//#if 249513218 
if(originalNameFig != null)//1
{ 

//#if 810976327 
this.setNameFig(originalNameFig);
//#endif 


//#if 305841261 
originalNameFig = null;
//#endif 

} 

//#endif 


//#if -2146179379 
for (Fig icon : floatingStereotypes) //1
{ 

//#if 222976282 
this.removeFig(icon);
//#endif 

} 

//#endif 


//#if 1835256826 
floatingStereotypes.clear();
//#endif 


//#if -961935042 
int practicalView = getPracticalView();
//#endif 


//#if 1496238316 
Object modelElement = getOwner();
//#endif 


//#if -1385420410 
Collection stereos = Model.getFacade().getStereotypes(modelElement);
//#endif 


//#if -692250820 
boolean hiding =
            practicalView == DiagramAppearance.STEREOTYPE_VIEW_SMALL_ICON;
//#endif 


//#if 1822040601 
if(getStereotypeFig() != null)//1
{ 

//#if 1861881585 
getStereotypeFig().setHidingStereotypesWithIcon(hiding);
//#endif 

} 

//#endif 


//#if 634670573 
if(practicalView == DiagramAppearance.STEREOTYPE_VIEW_BIG_ICON)//1
{ 

//#if -724740015 
Image replaceIcon = null;
//#endif 


//#if 1996297409 
if(stereos.size() == 1)//1
{ 

//#if -1556537086 
Object stereo = stereos.iterator().next();
//#endif 


//#if 1683980673 
replaceIcon = getProject()
                              .getProfileConfiguration().getFigNodeStrategy()
                              .getIconForStereotype(stereo);
//#endif 

} 

//#endif 


//#if -1668059083 
if(replaceIcon != null)//1
{ 

//#if 1139426173 
stereotypeFigProfileIcon = new FigProfileIcon(replaceIcon,
                        getName());
//#endif 


//#if -1543669336 
stereotypeFigProfileIcon.setOwner(getOwner());
//#endif 


//#if -309750228 
stereotypeFigProfileIcon.setLocation(getBigPort()
                                                     .getLocation());
//#endif 


//#if 158185736 
addFig(stereotypeFigProfileIcon);
//#endif 


//#if 159413083 
originalNameFig = this.getNameFig();
//#endif 


//#if -1921993185 
final FigText labelFig =
                    stereotypeFigProfileIcon.getLabelFig();
//#endif 


//#if -778126732 
setNameFig(labelFig);
//#endif 


//#if 1924933245 
labelFig.addPropertyChangeListener(this);
//#endif 


//#if 102789876 
getBigPort().setBounds(stereotypeFigProfileIcon.getBounds());
//#endif 


//#if -231813413 
for (Object fig : getFigs()) //1
{ 

//#if -1239562464 
((Fig) fig).setVisible(fig == stereotypeFigProfileIcon);
//#endif 

} 

//#endif 

} 

//#endif 

} 
else

//#if -1905179547 
if(practicalView
                   == DiagramAppearance.STEREOTYPE_VIEW_SMALL_ICON)//1
{ 

//#if 1287206148 
int i = this.getX() + this.getWidth() - ICON_WIDTH - 2;
//#endif 


//#if -191902284 
for (Object stereo : stereos) //1
{ 

//#if 1480560298 
Image icon = getProject()
                             .getProfileConfiguration().getFigNodeStrategy()
                             .getIconForStereotype(stereo);
//#endif 


//#if -1318617582 
if(icon != null)//1
{ 

//#if 1717150002 
FigImage fimg = new FigImage(i,
                                                 this.getBigPort().getY() + 2, icon);
//#endif 


//#if 871489408 
fimg.setSize(ICON_WIDTH,
                                 (icon.getHeight(null) * ICON_WIDTH)
                                 / icon.getWidth(null));
//#endif 


//#if -105488545 
addFig(fimg);
//#endif 


//#if -1369437474 
floatingStereotypes.add(fimg);
//#endif 


//#if -1833121006 
i -= ICON_WIDTH - 2;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2040204028 
updateSmallIcons(this.getWidth());
//#endif 

} 

//#endif 


//#endif 


//#if 1041478744 
updateStereotypeText();
//#endif 


//#if 1799784113 
damage();
//#endif 


//#if 702119894 
calcBounds();
//#endif 


//#if -365571129 
updateEdges();
//#endif 


//#if 161862242 
updateBounds();
//#endif 


//#if 1730624297 
redraw();
//#endif 

} 

//#endif 


//#if -1908249928 
private boolean isReadOnly()
    { 

//#if 751778723 
return Model.getModelManagementHelper().isReadOnly(getOwner());
//#endif 

} 

//#endif 


//#if 1853187901 
protected int getNotationProviderType()
    { 

//#if -1729136487 
return NotationProviderFactory2.TYPE_NAME;
//#endif 

} 

//#endif 


//#if -2033540878 
public void addEnclosedFig(Fig fig)
    { 

//#if 44763181 
enclosedFigs.add(fig);
//#endif 

} 

//#endif 


//#if 177302273 
public Fig getBigPort()
    { 

//#if 1062819262 
return bigPort;
//#endif 

} 

//#endif 


//#if 2020629171 
public void diagramFontChanged(ArgoDiagramAppearanceEvent e)
    { 

//#if -1412018141 
updateFont();
//#endif 


//#if 703497725 
updateBounds();
//#endif 


//#if 1318636172 
damage();
//#endif 

} 

//#endif 


//#if -917936556 
protected Object buildVisibilityPopUp()
    { 

//#if 625983742 
ArgoJMenu visibilityMenu = new ArgoJMenu("menu.popup.visibility");
//#endif 


//#if -452455103 
visibilityMenu.addRadioItem(new ActionVisibilityPublic(getOwner()));
//#endif 


//#if 177246965 
visibilityMenu.addRadioItem(new ActionVisibilityPrivate(getOwner()));
//#endif 


//#if 100832928 
visibilityMenu.addRadioItem(new ActionVisibilityProtected(getOwner()));
//#endif 


//#if -265940872 
visibilityMenu.addRadioItem(new ActionVisibilityPackage(getOwner()));
//#endif 


//#if 935232403 
return visibilityMenu;
//#endif 

} 

//#endif 


//#if 768472969 
public void propertyChange(final PropertyChangeEvent pve)
    { 

//#if 1230434625 
final Object src = pve.getSource();
//#endif 


//#if 2098575991 
final String pName = pve.getPropertyName();
//#endif 


//#if 1099686133 
if(pve instanceof DeleteInstanceEvent && src == getOwner())//1
{ 

//#if 913968733 
removeFromDiagram();
//#endif 


//#if 1214668867 
return;
//#endif 

} 

//#endif 


//#if 716700362 
if(pve.getPropertyName().equals("supplierDependency")
                && Model.getFacade().isADependency(pve.getOldValue()))//1
{ 

//#if -115352946 
return;
//#endif 

} 

//#endif 


//#if -1845810493 
if(pName.equals("editing")
                && Boolean.FALSE.equals(pve.getNewValue()))//1
{ 

//#if -1592729875 
try //1
{ 

//#if 1342235417 
textEdited((FigText) src);
//#endif 


//#if 756193115 
final Rectangle bbox = getBounds();
//#endif 


//#if 2030497048 
final Dimension minSize = getMinimumSize();
//#endif 


//#if 753496015 
bbox.width = Math.max(bbox.width, minSize.width);
//#endif 


//#if 1693308446 
bbox.height = Math.max(bbox.height, minSize.height);
//#endif 


//#if -889282574 
setBounds(bbox.x, bbox.y, bbox.width, bbox.height);
//#endif 


//#if -869788674 
endTrans();
//#endif 

} 

//#if 1372916764 
catch (PropertyVetoException ex) //1
{ 

//#if 1535591296 
LOG.error("could not parse the text entered. "
                          + "PropertyVetoException",
                          ex);
//#endif 

} 

//#endif 


//#endif 

} 
else

//#if -754428197 
if(pName.equals("editing")
                   && Boolean.TRUE.equals(pve.getNewValue()))//1
{ 

//#if 1922124633 
if(!isReadOnly())//1
{ 

//#if 1503126999 
textEditStarted((FigText) src);
//#endif 

} 

//#endif 

} 
else
{ 

//#if -1943551447 
super.propertyChange(pve);
//#endif 

} 

//#endif 


//#endif 


//#if -858483906 
if(Model.getFacade().isAUMLElement(src))//1
{ 

//#if 1635806990 
final UmlChangeEvent event = (UmlChangeEvent) pve;
//#endif 


//#if -2070570010 
final Object owner = getOwner();
//#endif 


//#if -619594081 
if(owner == null)//1
{ 

//#if -1903516906 
return;
//#endif 

} 

//#endif 


//#if -1722619586 
try //1
{ 

//#if 439599694 
modelChanged(event);
//#endif 

} 

//#if -348180232 
catch (InvalidElementException e) //1
{ 

//#if 1782595871 
if(LOG.isDebugEnabled())//1
{ 

//#if 2034669355 
LOG.debug("modelChanged method accessed deleted element"
                              + formatEvent(event),
                              e);
//#endif 

} 

//#endif 

} 

//#endif 


//#endif 


//#if 1044648911 
if(event.getSource() == owner
                    && "stereotype".equals(event.getPropertyName()))//1
{ 

//#if 1772184411 
stereotypeChanged(event);
//#endif 

} 

//#endif 


//#if 1471998185 
Runnable doWorkRunnable = new Runnable() {
                public void run() {
                    try {
                        updateLayout(event);
                    } catch (InvalidElementException e) {



                        if (LOG.isDebugEnabled()) {
                            LOG.debug("updateLayout method accessed "
                                      + "deleted element "
                                      + formatEvent(event), e);
                        }

                    }
                }
            };
//#endif 


//#if -735092359 
SwingUtilities.invokeLater(doWorkRunnable);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -588361190 
private void deepUpdateFont(FigGroup fg)
    { 

//#if -937607998 
boolean changed = false;
//#endif 


//#if -1663825179 
List<Fig> figs = fg.getFigs();
//#endif 


//#if 410349225 
for (Fig f : figs) //1
{ 

//#if -1544050574 
if(f instanceof ArgoFigText)//1
{ 

//#if -647619903 
((ArgoFigText) f).renderingChanged();
//#endif 


//#if -964825957 
changed = true;
//#endif 

} 

//#endif 


//#if -2041714831 
if(f instanceof FigGroup)//1
{ 

//#if -706077709 
deepUpdateFont((FigGroup) f);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1836167928 
if(changed)//1
{ 

//#if 192839851 
fg.calcBounds();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1650984433 
protected NotationSettings getNotationSettings()
    { 

//#if -1701410225 
return notationSettings;
//#endif 

} 

//#endif 


//#if -1833554898 
public void calcBounds()
    { 

//#if -173641510 
if(suppressCalcBounds)//1
{ 

//#if -1246629978 
return;
//#endif 

} 

//#endif 


//#if 2071352037 
super.calcBounds();
//#endif 

} 

//#endif 


//#if -72493425 
public void setStereotypeStyle(StereotypeStyle style)
    { 

//#if -989377109 
stereotypeStyle = style;
//#endif 


//#if 641686959 
renderingChanged();
//#endif 

} 

//#endif 


//#if -2068784222 

//#if -460921087 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public void setProject(Project project)
    { 

//#if -607623123 
throw new UnsupportedOperationException();
//#endif 

} 

//#endif 


//#if 1437349973 
protected void showHelp(String s)
    { 

//#if -148344517 
if(s == null)//1
{ 

//#if -453820786 
ArgoEventPump.fireEvent(new ArgoHelpEvent(
                                        ArgoEventTypes.HELP_CHANGED, this, ""));
//#endif 

} 
else
{ 

//#if -1842014383 
ArgoEventPump.fireEvent(new ArgoHelpEvent(
                                        ArgoEventTypes.HELP_CHANGED, this, Translator.localize(s)));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 717181129 
@Deprecated
    public void notationProviderAdded(ArgoNotationEvent event)
    { 
} 

//#endif 


//#if 649399104 
@Override
    public void setLayer(Layer lay)
    { 

//#if 386110183 
super.setLayer(lay);
//#endif 


//#if 1355476882 
determineDefaultPathVisible();
//#endif 

} 

//#endif 


//#if 1404869401 
protected void allowRemoveFromDiagram(boolean allowed)
    { 

//#if -607764856 
this.removeFromDiagram = allowed;
//#endif 

} 

//#endif 


//#if 936933641 
@Override
    public Vector getPopUpActions(MouseEvent me)
    { 

//#if -539885107 
ActionList popUpActions =
            new ActionList(super.getPopUpActions(me), isReadOnly());
//#endif 


//#if 1349873916 
ArgoJMenu show = buildShowPopUp();
//#endif 


//#if -861468945 
if(show.getMenuComponentCount() > 0)//1
{ 

//#if 657673906 
popUpActions.add(show);
//#endif 

} 

//#endif 


//#if 1388907223 
popUpActions.add(new JSeparator());
//#endif 


//#if 1123366354 
popupAddOffset = 1;
//#endif 


//#if -2127638641 
if(removeFromDiagram)//1
{ 

//#if -667144011 
popUpActions.add(
                ProjectActions.getInstance().getRemoveFromDiagramAction());
//#endif 


//#if 1945551326 
popupAddOffset++;
//#endif 

} 

//#endif 


//#if 1461337016 
if(!isReadOnly())//1
{ 

//#if -26573764 
popUpActions.add(new ActionDeleteModelElements());
//#endif 


//#if 1053638137 
popupAddOffset++;
//#endif 

} 

//#endif 


//#if -675445912 
if(TargetManager.getInstance().getTargets().size() == 1)//1
{ 

//#if -1918170014 
ToDoList tdList = Designer.theDesigner().getToDoList();
//#endif 


//#if -603549459 
List<ToDoItem> items = tdList.elementListForOffender(getOwner());
//#endif 


//#if -76333477 
if(items != null && items.size() > 0)//1
{ 

//#if -962459082 
ArgoJMenu critiques = new ArgoJMenu("menu.popup.critiques");
//#endif 


//#if -664678951 
ToDoItem itemUnderMouse = hitClarifier(me.getX(), me.getY());
//#endif 


//#if -2641874 
if(itemUnderMouse != null)//1
{ 

//#if 1418255313 
critiques.add(new ActionGoToCritique(itemUnderMouse));
//#endif 


//#if 1399292560 
critiques.addSeparator();
//#endif 

} 

//#endif 


//#if 95675457 
for (ToDoItem item : items) //1
{ 

//#if -385761514 
if(item != itemUnderMouse)//1
{ 

//#if -605405335 
critiques.add(new ActionGoToCritique(item));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2057444950 
popUpActions.add(0, new JSeparator());
//#endif 


//#if -450508389 
popUpActions.add(0, critiques);
//#endif 

} 

//#endif 


//#if -2086998490 
final Action[] stereoActions =
                StereotypeUtility.getApplyStereotypeActions(getOwner());
//#endif 


//#if -1430477794 
if(stereoActions != null)//1
{ 

//#if -2117576055 
popUpActions.add(0, new JSeparator());
//#endif 


//#if -1947972472 
final ArgoJMenu stereotypes =
                    new ArgoJMenu("menu.popup.apply-stereotypes");
//#endif 


//#if -713950055 
for (Action action : stereoActions) //1
{ 

//#if 884209589 
stereotypes.addCheckItem(action);
//#endif 

} 

//#endif 


//#if -1478847314 
popUpActions.add(0, stereotypes);
//#endif 

} 

//#endif 


//#if -646481011 
ArgoJMenu stereotypesView =
                new ArgoJMenu("menu.popup.stereotype-view");
//#endif 


//#if -703526891 
stereotypesView.addRadioItem(new ActionStereotypeViewTextual(this));
//#endif 


//#if -150405989 
stereotypesView.addRadioItem(new ActionStereotypeViewBigIcon(this));
//#endif 


//#if 1579260642 
stereotypesView.addRadioItem(
                new ActionStereotypeViewSmallIcon(this));
//#endif 


//#if 2111610897 
popUpActions.add(0, stereotypesView);
//#endif 

} 

//#endif 


//#if -2025142067 
return popUpActions;
//#endif 

} 

//#endif 


//#if 1943609576 
public int getStereotypeCount()
    { 

//#if 1901215249 
if(getStereotypeFig() == null)//1
{ 

//#if -1718509879 
return 0;
//#endif 

} 

//#endif 


//#if -1762729352 
return getStereotypeFig().getStereotypeCount();
//#endif 

} 

//#endif 


//#if -992609382 
@Override
    public Fig getEnclosingFig()
    { 

//#if 1454904502 
return encloser;
//#endif 

} 

//#endif 


//#if -425502949 
@Deprecated
    protected FigNodeModelElement(Object element, int x, int y)
    { 

//#if 174943317 
this();
//#endif 


//#if -1596142018 
setOwner(element);
//#endif 


//#if 971924310 
nameFig.setText(placeString());
//#endif 


//#if -1446095788 
readyToEdit = false;
//#endif 


//#if -1607576801 
setLocation(x, y);
//#endif 

} 

//#endif 


//#if -116315106 
protected Object buildModifierPopUp(int items)
    { 

//#if -832205306 
ArgoJMenu modifierMenu = new ArgoJMenu("menu.popup.modifiers");
//#endif 


//#if 442212220 
if((items & ABSTRACT) > 0)//1
{ 

//#if -1164634483 
modifierMenu.addCheckItem(new ActionModifierAbstract(getOwner()));
//#endif 

} 

//#endif 


//#if -1290542528 
if((items & LEAF) > 0)//1
{ 

//#if 600589906 
modifierMenu.addCheckItem(new ActionModifierLeaf(getOwner()));
//#endif 

} 

//#endif 


//#if -2057501636 
if((items & ROOT) > 0)//1
{ 

//#if -732858826 
modifierMenu.addCheckItem(new ActionModifierRoot(getOwner()));
//#endif 

} 

//#endif 


//#if 1899665112 
if((items & ACTIVE) > 0)//1
{ 

//#if 312196836 
modifierMenu.addCheckItem(new ActionModifierActive(getOwner()));
//#endif 

} 

//#endif 


//#if 623333779 
return modifierMenu;
//#endif 

} 

//#endif 


//#if -964163751 
public String placeString()
    { 

//#if -1962644925 
if(Model.getFacade().isAModelElement(getOwner()))//1
{ 

//#if 1073162014 
String placeString = Model.getFacade().getName(getOwner());
//#endif 


//#if 769320523 
if(placeString == null)//1
{ 

//#if 518205599 
placeString =
                    // TODO: I18N
                    "new " + Model.getFacade().getUMLClassName(getOwner());
//#endif 

} 

//#endif 


//#if -498382174 
return placeString;
//#endif 

} 

//#endif 


//#if 248445680 
return "";
//#endif 

} 

//#endif 


//#if 308328674 
@Override
    public Selection makeSelection()
    { 

//#if -156884957 
return new SelectionDefaultClarifiers(this);
//#endif 

} 

//#endif 


//#if 1471813687 
public void delayedVetoableChange(PropertyChangeEvent pce)
    { 

//#if 1740318951 
LOG.debug("in delayedVetoableChange");
//#endif 


//#if 1005350995 
renderingChanged();
//#endif 


//#if -338601170 
endTrans();
//#endif 

} 

//#endif 


//#if -1353788134 
public StereotypeStyle getStereotypeStyle()
    { 

//#if -412523679 
return stereotypeStyle;
//#endif 

} 

//#endif 


//#if 1518774344 
public boolean isEditable()
    { 

//#if 26064292 
return editable;
//#endif 

} 

//#endif 


//#if 1380903704 
@Override
    public boolean hit(Rectangle r)
    { 

//#if -1864282681 
int cornersHit = countCornersContained(r.x, r.y, r.width, r.height);
//#endif 


//#if 1999191314 
if(_filled)//1
{ 

//#if -1696770932 
return cornersHit > 0 || intersects(r);
//#endif 

} 

//#endif 


//#if 941325153 
return (cornersHit > 0 && cornersHit < 4) || intersects(r);
//#endif 

} 

//#endif 


//#if 39988073 
public void setOwner(Object owner)
    { 

//#if -41884899 
if(owner == null)//1
{ 

//#if 915558360 
throw new IllegalArgumentException("An owner must be supplied");
//#endif 

} 

//#endif 


//#if -956111634 
if(getOwner() != null)//1
{ 

//#if -26589234 
throw new IllegalStateException(
                "The owner cannot be changed once set");
//#endif 

} 

//#endif 


//#if 1899706309 
if(!Model.getFacade().isAUMLElement(owner))//1
{ 

//#if 1960279604 
throw new IllegalArgumentException(
                "The owner must be a model element - got a "
                + owner.getClass().getName());
//#endif 

} 

//#endif 


//#if 940179079 
super.setOwner(owner);
//#endif 


//#if -617056567 
nameFig.setOwner(owner);
//#endif 


//#if 690532397 
if(getStereotypeFig() != null)//1
{ 

//#if -929838554 
getStereotypeFig().setOwner(owner);
//#endif 

} 

//#endif 


//#if -1632642361 
initNotationProviders(owner);
//#endif 


//#if 1556583218 
readyToEdit = true;
//#endif 


//#if 1278870924 
renderingChanged();
//#endif 


//#if -1058385258 
bindPort(owner, bigPort);
//#endif 


//#if -1463353352 
updateListeners(null, owner);
//#endif 

} 

//#endif 


//#if -889967734 
public DiElement getDiElement()
    { 

//#if -1814481958 
return diElement;
//#endif 

} 

//#endif 


//#if 768306750 
protected void updateNameText()
    { 

//#if -1759612259 
if(readyToEdit)//1
{ 

//#if -1891028992 
if(getOwner() == null)//1
{ 

//#if 1213330716 
return;
//#endif 

} 

//#endif 


//#if -2127981732 
if(notationProviderName != null)//1
{ 

//#if -2068918879 
nameFig.setText(notationProviderName.toString(
                                    getOwner(), getNotationSettings()));
//#endif 


//#if 184894960 
updateFont();
//#endif 


//#if 2033663114 
updateBounds();
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 142034003 
public DiagramSettings getSettings()
    { 

//#if 283176002 
if(settings == null)//1
{ 

//#if 1042222364 
LOG.debug("Falling back to project-wide settings");
//#endif 


//#if 1457054329 
Project p = getProject();
//#endif 


//#if 1983558232 
if(p != null)//1
{ 

//#if 647384301 
return p.getProjectSettings().getDefaultDiagramSettings();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1695609907 
return settings;
//#endif 

} 

//#endif 


//#if -504166939 
protected void updateStereotypeText()
    { 

//#if 1886692140 
if(getOwner() == null)//1
{ 

//#if 394914918 
LOG.warn("Null owner for [" + this.toString() + "/"
                     + this.getClass());
//#endif 


//#if 1134945161 
return;
//#endif 

} 

//#endif 


//#if 77239559 
if(getStereotypeFig() != null)//1
{ 

//#if 657888636 
getStereotypeFig().populate();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -999541687 
public void removeEnclosedFig(Fig fig)
    { 

//#if -469882672 
enclosedFigs.remove(fig);
//#endif 

} 

//#endif 


//#if 1884440580 
protected boolean isSingleTarget()
    { 

//#if -883930698 
return TargetManager.getInstance().getSingleModelTarget()
               == getOwner();
//#endif 

} 

//#endif 


//#if 3515069 
protected FigStereotypesGroup createStereotypeFig()
    { 

//#if -1727032335 
return new FigStereotypesGroup(getOwner(),
                                       new Rectangle(X0, Y0, WIDTH, STEREOHEIGHT), settings);
//#endif 

} 

//#endif 


//#if 140064818 
public void keyPressed(KeyEvent ke)
    { 

//#if -727781279 
if(ke.isConsumed() || getOwner() == null)//1
{ 

//#if 1568680959 
return;
//#endif 

} 

//#endif 


//#if 1828556836 
nameFig.keyPressed(ke);
//#endif 

} 

//#endif 


//#if 2111047825 
protected void setStandardBounds(final int x, final int y,
                                     final int w, final int h)
    { 
} 

//#endif 


//#if -1050791740 
protected void determineDefaultPathVisible()
    { 

//#if 1601591909 
Object modelElement = getOwner();
//#endif 


//#if 1264680479 
LayerPerspective layer = (LayerPerspective) getLayer();
//#endif 


//#if -1035013511 
if((layer != null)
                && Model.getFacade().isAModelElement(modelElement))//1
{ 

//#if -1593093950 
ArgoDiagram diagram = (ArgoDiagram) layer.getDiagram();
//#endif 


//#if -1487989600 
Object elementNs = Model.getFacade().getNamespace(modelElement);
//#endif 


//#if -1998841973 
Object diagramNs = diagram.getNamespace();
//#endif 


//#if 1250051276 
if(elementNs != null)//1
{ 

//#if 4967639 
boolean visible = (elementNs != diagramNs);
//#endif 


//#if 394139250 
getNotationSettings().setShowPaths(visible);
//#endif 


//#if -29755580 
updateNameText();
//#endif 


//#if 764766806 
damage();
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 564465802 
protected ArgoJMenu buildShowPopUp()
    { 

//#if -2101882485 
ArgoJMenu showMenu = new ArgoJMenu("menu.popup.show");
//#endif 


//#if -1187196034 
for (UndoableAction ua : ActionSetPath.getActions()) //1
{ 

//#if -761869550 
showMenu.add(ua);
//#endif 

} 

//#endif 


//#if 231619845 
return showMenu;
//#endif 

} 

//#endif 


//#if 322828214 
private void constructFigs()
    { 

//#if 1600573050 
nameFig.setFilled(true);
//#endif 


//#if -1916617540 
nameFig.setText(placeString());
//#endif 


//#if 881552138 
nameFig.setBotMargin(7);
//#endif 


//#if 810000604 
nameFig.setRightMargin(4);
//#endif 


//#if 997297951 
nameFig.setLeftMargin(4);
//#endif 


//#if -1725518546 
readyToEdit = false;
//#endif 


//#if 1232828916 
setShadowSize(getSettings().getDefaultShadowWidth());
//#endif 


//#if -1375680027 
stereotypeStyle = getSettings().getDefaultStereotypeView();
//#endif 

} 

//#endif 


//#if 379734123 
protected void createContainedModelElement(FigGroup fg, InputEvent me)
    { 
} 

//#endif 


//#if 827583337 
@Deprecated
    public void notationProviderRemoved(ArgoNotationEvent event)
    { 
} 

//#endif 


//#if 2069968106 
public void setName(String n)
    { 

//#if 256806047 
nameFig.setText(n);
//#endif 

} 

//#endif 


//#if -1247896415 
protected void setNameFig(FigText fig)
    { 

//#if 1655570218 
nameFig = fig;
//#endif 


//#if -452657592 
if(nameFig != null)//1
{ 

//#if 89475096 
updateFont();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -245206926 
@Override
    public void deleteFromModel()
    { 

//#if 1037543098 
Object own = getOwner();
//#endif 


//#if 1442371219 
if(own != null)//1
{ 

//#if -1519409627 
getProject().moveToTrash(own);
//#endif 

} 

//#endif 


//#if 1033644077 
for (Object fig : getFigs()) //1
{ 

//#if 1580603825 
((Fig) fig).deleteFromModel();
//#endif 

} 

//#endif 


//#if -1955357050 
super.deleteFromModel();
//#endif 

} 

//#endif 


//#if 403699032 
public void displace (int xInc, int yInc)
    { 

//#if 964604417 
List<Fig> figsVector;
//#endif 


//#if 712657627 
Rectangle rFig = getBounds();
//#endif 


//#if 2092616973 
setLocation(rFig.x + xInc, rFig.y + yInc);
//#endif 


//#if -1259333455 
figsVector = ((List<Fig>) getEnclosedFigs().clone());
//#endif 


//#if -682513482 
if(!figsVector.isEmpty())//1
{ 

//#if -205356136 
for (int i = 0; i < figsVector.size(); i++) //1
{ 

//#if -1976874007 
((FigNodeModelElement) figsVector.get(i))
                .displace(xInc, yInc);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -2136219164 
protected void setBigPort(Fig bp)
    { 

//#if -707169931 
this.bigPort = bp;
//#endif 


//#if 2140150491 
bindPort(getOwner(), bigPort);
//#endif 

} 

//#endif 


//#if -1864307016 
protected boolean isPartlyOwner(Object o)
    { 

//#if -579491345 
if(o == null || o == getOwner())//1
{ 

//#if 1271943740 
return true;
//#endif 

} 

//#endif 


//#if 897929311 
for (Object fig : getFigs()) //1
{ 

//#if 1577723709 
if(isPartlyOwner((Fig) fig, o))//1
{ 

//#if 1550134491 
return true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1721327421 
return false;
//#endif 

} 

//#endif 


//#if 1187871582 
protected void updateElementListeners(Set<Object[]> listenerSet)
    { 

//#if -199288446 
Set<Object[]> removes = new HashSet<Object[]>(listeners);
//#endif 


//#if 210467881 
removes.removeAll(listenerSet);
//#endif 


//#if -1518784435 
removeElementListeners(removes);
//#endif 


//#if 2059710914 
Set<Object[]> adds = new HashSet<Object[]>(listenerSet);
//#endif 


//#if 549056855 
adds.removeAll(listeners);
//#endif 


//#if 1261087157 
addElementListeners(adds);
//#endif 

} 

//#endif 


//#if -1523714676 
public void setLineWidth(int w)
    { 

//#if 1590500218 
super.setLineWidth(w);
//#endif 


//#if -2102937634 
getNameFig().setLineWidth(0);
//#endif 


//#if 349527933 
if(getStereotypeFig() != null)//1
{ 

//#if 823432335 
getStereotypeFig().setLineWidth(0);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 743737458 
@Deprecated
    protected HashMap<String, Object> getNotationArguments()
    { 

//#if 839026660 
return npArguments;
//#endif 

} 

//#endif 


//#if -1388200540 
protected Fig getRemoveDelegate()
    { 

//#if 1109397295 
return this;
//#endif 

} 

//#endif 


//#if -715177682 
private void removeElementListeners(Set<Object[]> listenerSet)
    { 

//#if -1719385150 
for (Object[] listener : listenerSet) //1
{ 

//#if 934963147 
Object property = listener[1];
//#endif 


//#if 449423625 
if(property == null)//1
{ 

//#if 468574478 
Model.getPump().removeModelEventListener(this, listener[0]);
//#endif 

} 
else

//#if 1684897098 
if(property instanceof String[])//1
{ 

//#if 101774061 
Model.getPump().removeModelEventListener(this, listener[0],
                        (String[]) property);
//#endif 

} 
else

//#if 1230821451 
if(property instanceof String)//1
{ 

//#if -1927029153 
Model.getPump().removeModelEventListener(this, listener[0],
                        (String) property);
//#endif 

} 
else
{ 

//#if 1758369809 
throw new RuntimeException(
                    "Internal error in removeAllElementListeners");
//#endif 

} 

//#endif 


//#endif 


//#endif 

} 

//#endif 


//#if -1913553036 
listeners.removeAll(listenerSet);
//#endif 

} 

//#endif 


//#if 298951513 
@Deprecated
    protected FigNodeModelElement()
    { 

//#if -1239119986 
notationSettings = new NotationSettings();
//#endif 


//#if -524834730 
bigPort = new FigRect(X0, Y0, 0, 0, DEBUG_COLOR, DEBUG_COLOR);
//#endif 


//#if 2060056323 
nameFig = new FigNameWithAbstractAndBold(X0, Y0, WIDTH, NAME_FIG_HEIGHT, true);
//#endif 


//#if 785143860 
stereotypeFig = new FigStereotypesGroup(X0, Y0, WIDTH, STEREOHEIGHT);
//#endif 


//#if 177124243 
constructFigs();
//#endif 

} 

//#endif 


//#if -171999164 
protected void removeElementListener(Object element)
    { 

//#if 1454462487 
listeners.remove(new Object[] {element, null});
//#endif 


//#if 1203250749 
Model.getPump().removeModelEventListener(this, element);
//#endif 

} 

//#endif 


//#if 1918009310 
protected Fig getEncloser()
    { 

//#if 1586759487 
return encloser;
//#endif 

} 

//#endif 


//#if -1660889924 
public void enableSizeChecking(boolean flag)
    { 

//#if -1476807365 
checkSize = flag;
//#endif 

} 

//#endif 


//#if -975210027 
protected void addElementListener(Object element, String[] property)
    { 

//#if -754824252 
listeners.add(new Object[] {element, property});
//#endif 


//#if -1167114727 
Model.getPump().addModelEventListener(this, element, property);
//#endif 

} 

//#endif 


//#if 344909078 
protected void initNotationProviders(Object own)
    { 

//#if 505701291 
if(notationProviderName != null)//1
{ 

//#if -1345245242 
notationProviderName.cleanListener(this, own);
//#endif 

} 

//#endif 


//#if -1165660712 
if(Model.getFacade().isAUMLElement(own))//1
{ 

//#if 21569311 
NotationName notation = Notation.findNotation(
                                        getNotationSettings().getNotationLanguage());
//#endif 


//#if 1908341250 
notationProviderName =
                NotationProviderFactory2.getInstance().getNotationProvider(
                    getNotationProviderType(), own, this,
                    notation);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -692178036 
public void renderingChanged()
    { 

//#if -730532142 
initNotationProviders(getOwner());
//#endif 


//#if -1313622929 
updateNameText();
//#endif 


//#if -1431780312 
updateStereotypeText();
//#endif 


//#if 1624832348 
updateStereotypeIcon();
//#endif 


//#if -1158696398 
updateBounds();
//#endif 


//#if -769097087 
damage();
//#endif 

} 

//#endif 


//#if -1427978838 
public void setVisible(boolean visible)
    { 

//#if 1502338733 
if(!visible && !invisibleAllowed)//1
{ 

//#if -1459778132 
throw new IllegalArgumentException(
                "Visibility of a FigNode should never be false");
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1412462197 
public boolean isPathVisible()
    { 

//#if -556368667 
return getNotationSettings().isShowPaths();
//#endif 

} 

//#endif 


//#if 652086071 
@Override
    public Vector<Fig> getEnclosedFigs()
    { 

//#if 1697168479 
return enclosedFigs;
//#endif 

} 

//#endif 


//#if -2112810329 
@Deprecated
    public Project getProject()
    { 

//#if 1341509971 
return ArgoFigUtil.getProject(this);
//#endif 

} 

//#endif 


//#if 251637495 
private int getPracticalView()
    { 

//#if 2074960518 
int practicalView = getStereotypeView();
//#endif 


//#if -297010741 
Object modelElement = getOwner();
//#endif 


//#if 1961903344 
if(modelElement != null)//1
{ 

//#if 15061076 
int stereotypeCount = getStereotypeCount();
//#endif 


//#if -1580152906 
if(getStereotypeView()
                    == DiagramAppearance.STEREOTYPE_VIEW_BIG_ICON
                    && (stereotypeCount != 1
                        ||  (stereotypeCount == 1
                             // TODO: Find a way to replace
                             // this dependency on Project
                             && getProject().getProfileConfiguration()
                             .getFigNodeStrategy().getIconForStereotype(
                                 getStereotypeFig().getStereotypeFigs().iterator().next().getOwner())
                             == null)))//1
{ 

//#if 213515182 
practicalView = DiagramAppearance.STEREOTYPE_VIEW_TEXTUAL;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -179738358 
return practicalView;
//#endif 

} 

//#endif 


//#if 863182069 
protected void updateFont()
    { 

//#if -1077081903 
int style = getNameFigFontStyle();
//#endif 


//#if 1536244225 
Font f = getSettings().getFont(style);
//#endif 


//#if -1067541209 
nameFig.setFont(f);
//#endif 


//#if 351982671 
deepUpdateFont(this);
//#endif 

} 

//#endif 


//#if 1163552724 
public void setDiElement(DiElement element)
    { 

//#if 2015793833 
this.diElement = element;
//#endif 

} 

//#endif 


//#if 193317219 
@Deprecated
    @Override
    public String classNameAndBounds()
    { 

//#if 2022286346 
return getClass().getName()
               + "[" + getX() + ", " + getY() + ", "
               + getWidth() + ", " + getHeight() + "]"
               + "pathVisible=" + isPathVisible() + ";"
               + "stereotypeView=" + getStereotypeView() + ";";
//#endif 

} 

//#endif 


//#if 1575755990 
public ItemUID getItemUID()
    { 

//#if -2146500803 
return itemUid;
//#endif 

} 

//#endif 


//#if 1333711150 
public boolean isDragConnectable()
    { 

//#if -1501219593 
return false;
//#endif 

} 

//#endif 


//#if 1888648119 
protected void addElementListener(Object element, String property)
    { 

//#if 646816445 
listeners.add(new Object[] {element, property});
//#endif 


//#if 499614482 
Model.getPump().addModelEventListener(this, element, property);
//#endif 

} 

//#endif 


//#if -1936480631 
protected void setEncloser(Fig e)
    { 

//#if 1807420734 
this.encloser = e;
//#endif 

} 

//#endif 


//#if -496323322 
protected static int getPopupAddOffset()
    { 

//#if 669301847 
return popupAddOffset;
//#endif 

} 

//#endif 


//#if -1623353632 
protected boolean isCheckSize()
    { 

//#if 1916669536 
return checkSize;
//#endif 

} 

//#endif 


//#if -2063410706 
@Deprecated
    public void notationChanged(ArgoNotationEvent event)
    { 

//#if 482147672 
if(getOwner() == null)//1
{ 

//#if -1413064987 
return;
//#endif 

} 

//#endif 


//#if -1082254090 
try //1
{ 

//#if 867965611 
renderingChanged();
//#endif 

} 

//#if -984891769 
catch (Exception e) //1
{ 

//#if -1745104232 
LOG.error("Exception", e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1547881662 
protected void updateLayout(UmlChangeEvent event)
    { 

//#if -382487263 
assert event != null;
//#endif 


//#if 816034043 
final Object owner = getOwner();
//#endif 


//#if 1534301928 
assert owner != null;
//#endif 


//#if -1873921548 
if(owner == null)//1
{ 

//#if -988391492 
return;
//#endif 

} 

//#endif 


//#if 526634917 
boolean needDamage = false;
//#endif 


//#if 1914903387 
if(event instanceof AssociationChangeEvent
                || event instanceof AttributeChangeEvent)//1
{ 

//#if -750732489 
if(notationProviderName != null)//1
{ 

//#if 1856320793 
updateNameText();
//#endif 

} 

//#endif 


//#if -740127342 
needDamage = true;
//#endif 

} 

//#endif 


//#if -444514470 
if(event.getSource() == owner
                && "stereotype".equals(event.getPropertyName()))//1
{ 

//#if -1988030272 
updateStereotypeText();
//#endif 


//#if 1068582388 
updateStereotypeIcon();
//#endif 


//#if -1436126489 
needDamage = true;
//#endif 

} 

//#endif 


//#if 1397363867 
if(needDamage)//1
{ 

//#if 12582997 
damage();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 546969741 
protected FigText getNameFig()
    { 

//#if 1865784240 
return nameFig;
//#endif 

} 

//#endif 


//#if -1558617754 
protected boolean isPartlyOwner(Fig fig, Object o)
    { 

//#if -1126093698 
if(o == null)//1
{ 

//#if 1708949912 
return false;
//#endif 

} 

//#endif 


//#if -185619809 
if(o == fig.getOwner())//1
{ 

//#if 1824449891 
return true;
//#endif 

} 

//#endif 


//#if 674950355 
if(fig instanceof FigGroup)//1
{ 

//#if 1632025122 
for (Object fig2 : ((FigGroup) fig).getFigs()) //1
{ 

//#if -1482335661 
if(isPartlyOwner((Fig) fig2, o))//1
{ 

//#if -1722132468 
return true;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1940099731 
return false;
//#endif 

} 

//#endif 


//#if 1332445463 
public Rectangle getNameBounds()
    { 

//#if -240142116 
return nameFig.getBounds();
//#endif 

} 

//#endif 


//#if -2006167174 
public void keyTyped(KeyEvent ke)
    { 

//#if 1924023095 
if(!editable || isReadOnly())//1
{ 

//#if -357827991 
return;
//#endif 

} 

//#endif 


//#if -793010350 
if(!readyToEdit)//1
{ 

//#if -1664283069 
if(Model.getFacade().isAModelElement(getOwner()))//1
{ 

//#if -980692263 
Model.getCoreHelper().setName(getOwner(), "");
//#endif 


//#if -839591109 
readyToEdit = true;
//#endif 

} 
else
{ 

//#if 87435982 
LOG.debug("not ready to edit name");
//#endif 


//#if -1073436466 
return;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -516789519 
if(ke.isConsumed() || getOwner() == null)//1
{ 

//#if 391588231 
return;
//#endif 

} 

//#endif 


//#if -221262644 
nameFig.keyTyped(ke);
//#endif 

} 

//#endif 


//#if 162007354 
@Deprecated
    public void notationAdded(ArgoNotationEvent event)
    { 
} 

//#endif 


//#if -1946439140 
protected void setSuppressCalcBounds(boolean scb)
    { 

//#if -1702027118 
this.suppressCalcBounds = scb;
//#endif 

} 

//#endif 


//#if 118339434 
protected void removeFromDiagramImpl()
    { 

//#if -1154141615 
if(notationProviderName != null)//1
{ 

//#if -545946332 
notationProviderName.cleanListener(this, getOwner());
//#endif 

} 

//#endif 


//#if 2022381725 
removeAllElementListeners();
//#endif 


//#if -73917094 
setShadowSize(0);
//#endif 


//#if -974557077 
super.removeFromDiagram();
//#endif 


//#if -1280317936 
if(getStereotypeFig() != null)//1
{ 

//#if 1402620467 
getStereotypeFig().removeFromDiagram();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1140880625 
private String formatEvent(PropertyChangeEvent event)
    { 

//#if -156920853 
return "\n\t event = " + event.getClass().getName()
               + "\n\t source = " + event.getSource()
               + "\n\t old = " + event.getOldValue()
               + "\n\t name = " + event.getPropertyName();
//#endif 

} 

//#endif 


//#if 622366377 
protected void addElementListener(Object element)
    { 

//#if 1211763255 
listeners.add(new Object[] {element, null});
//#endif 


//#if -1609459769 
Model.getPump().addModelEventListener(this, element);
//#endif 

} 

//#endif 


//#if 98048675 
protected void textEdited(FigText ft) throws PropertyVetoException
    { 

//#if -543643755 
if(ft == nameFig)//1
{ 

//#if 1245859660 
if(getOwner() == null)//1
{ 

//#if -1196699668 
return;
//#endif 

} 

//#endif 


//#if -250304629 
notationProviderName.parse(getOwner(), ft.getText());
//#endif 


//#if -1646826444 
ft.setText(notationProviderName.toString(getOwner(),
                       getNotationSettings()));
//#endif 

} 

//#endif 


//#if -1855262785 
if(ft instanceof CompartmentFigText)//1
{ 

//#if -1673199638 
final CompartmentFigText figText = (CompartmentFigText) ft;
//#endif 


//#if 658434298 
figText.getNotationProvider().parse(ft.getOwner(), ft.getText());
//#endif 


//#if -915895409 
ft.setText(figText.getNotationProvider().toString(
                           ft.getOwner(), getNotationSettings()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -118469734 
@Deprecated
    public void notationRemoved(ArgoNotationEvent event)
    { 
} 

//#endif 


//#if -328173534 
public String getName()
    { 

//#if -285826052 
return nameFig.getText();
//#endif 

} 

//#endif 


//#if -544836974 
protected void moveIntoComponent(Fig newEncloser)
    { 

//#if -1238218991 
final Object component = newEncloser.getOwner();
//#endif 


//#if -1778633198 
final Object owner = getOwner();
//#endif 


//#if 809671209 
assert Model.getFacade().isAComponent(component);
//#endif 


//#if -1511898944 
assert Model.getFacade().isAUMLElement(owner);
//#endif 


//#if -1239437461 
final Collection er1 = Model.getFacade().getElementResidences(owner);
//#endif 


//#if 834856234 
final Collection er2 = Model.getFacade().getResidentElements(component);
//#endif 


//#if 392870695 
boolean found = false;
//#endif 


//#if -144836457 
final Collection<Object> common = new ArrayList<Object>(er1);
//#endif 


//#if 951399164 
common.retainAll(er2);
//#endif 


//#if 332363889 
for (Object elementResidence : common) //1
{ 

//#if -1966091649 
if(!found)//1
{ 

//#if 1800906892 
found = true;
//#endif 

} 
else
{ 

//#if -1512223732 
Model.getUmlFactory().delete(elementResidence);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1240287680 
if(!found)//1
{ 

//#if -1301965504 
Model.getCoreFactory().buildElementResidence(
                owner, component);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2094862117 
class SelectionDefaultClarifiers extends 
//#if 759951129 
SelectionNodeClarifiers2
//#endif 

  { 

//#if -1019147742 
private SelectionDefaultClarifiers(Fig f)
        { 

//#if -742414206 
super(f);
//#endif 

} 

//#endif 


//#if 637829910 
@Override
        protected boolean isReverseEdge(int index)
        { 

//#if -1140714172 
return false;
//#endif 

} 

//#endif 


//#if -1421812789 
@Override
        protected Icon[] getIcons()
        { 

//#if -644636024 
return null;
//#endif 

} 

//#endif 


//#if -400779107 
@Override
        protected String getInstructions(int index)
        { 

//#if 1855305989 
return null;
//#endif 

} 

//#endif 


//#if 525792905 
@Override
        protected Object getNewEdgeType(int index)
        { 

//#if -670880579 
return null;
//#endif 

} 

//#endif 


//#if -619783666 
@Override
        protected Object getNewNodeType(int index)
        { 

//#if 470763506 
return null;
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

