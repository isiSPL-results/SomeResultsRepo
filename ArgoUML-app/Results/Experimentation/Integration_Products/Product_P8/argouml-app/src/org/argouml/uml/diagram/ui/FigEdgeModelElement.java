package org.argouml.uml.diagram.ui;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.VetoableChangeListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;
import org.apache.log4j.Logger;
import org.argouml.application.events.ArgoDiagramAppearanceEvent;
import org.argouml.application.events.ArgoDiagramAppearanceEventListener;
import org.argouml.application.events.ArgoEventPump;
import org.argouml.application.events.ArgoEventTypes;
import org.argouml.application.events.ArgoHelpEvent;
import org.argouml.application.events.ArgoNotationEvent;
import org.argouml.application.events.ArgoNotationEventListener;
import org.argouml.cognitive.Designer;
import org.argouml.cognitive.Highlightable;
import org.argouml.cognitive.ToDoItem;
import org.argouml.cognitive.ToDoList;
import org.argouml.cognitive.ui.ActionGoToCritique;
import org.argouml.i18n.Translator;
import org.argouml.kernel.DelayedChangeNotify;
import org.argouml.kernel.DelayedVChangeListener;
import org.argouml.kernel.Project;
import org.argouml.model.AddAssociationEvent;
import org.argouml.model.AssociationChangeEvent;
import org.argouml.model.AttributeChangeEvent;
import org.argouml.model.DeleteInstanceEvent;
import org.argouml.model.DiElement;
import org.argouml.model.InvalidElementException;
import org.argouml.model.Model;
import org.argouml.model.RemoveAssociationEvent;
import org.argouml.model.UmlChangeEvent;
import org.argouml.notation.Notation;
import org.argouml.notation.NotationName;
import org.argouml.notation.NotationProvider;
import org.argouml.notation.NotationProviderFactory2;
import org.argouml.notation.NotationSettings;
import org.argouml.ui.ArgoJMenu;
import org.argouml.ui.Clarifier;
import org.argouml.ui.ProjectActions;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.StereotypeUtility;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.ui.ActionDeleteModelElements;
import org.argouml.util.IItemUID;
import org.argouml.util.ItemUID;
import org.tigris.gef.base.Globals;
import org.tigris.gef.base.Layer;
import org.tigris.gef.base.Selection;
import org.tigris.gef.persistence.pgml.PgmlUtility;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigEdge;
import org.tigris.gef.presentation.FigEdgePoly;
import org.tigris.gef.presentation.FigGroup;
import org.tigris.gef.presentation.FigNode;
import org.tigris.gef.presentation.FigPoly;
import org.tigris.gef.presentation.FigText;
public abstract class FigEdgeModelElement extends FigEdgePoly
 implements VetoableChangeListener
,DelayedVChangeListener
,MouseListener
,KeyListener
,PropertyChangeListener
,ArgoNotationEventListener
,ArgoDiagramAppearanceEventListener
,Highlightable
,IItemUID
,ArgoFig
,Clarifiable
  { 
private static final Logger LOG =
        Logger.getLogger(FigEdgeModelElement.class);
private DiElement diElement = null;
private boolean removeFromDiagram = true;
private static int popupAddOffset;
private NotationProvider notationProviderName;
@Deprecated
    private HashMap<String, Object> npArguments;
private FigText nameFig;
private FigStereotypesGroup stereotypeFig;
private FigEdgePort edgePort;
private ItemUID itemUid;
private Set<Object[]> listeners = new HashSet<Object[]>();
private DiagramSettings settings;
public void mouseReleased(MouseEvent me)
    { 
} 
protected int getNameFigFontStyle()
    { 
return Font.PLAIN;
} 
protected void modelAssociationRemoved(RemoveAssociationEvent rae)
    { 
} 
public void mouseExited(MouseEvent me)
    { 
} 
@Override
    public void propertyChange(final PropertyChangeEvent pve)
    { 
Object src = pve.getSource();
String pName = pve.getPropertyName();
if(pve instanceof DeleteInstanceEvent && src == getOwner())//1
{ 
Runnable doWorkRunnable = new Runnable() {
                public void run() {
                    try {
                        removeFromDiagram();
                    } catch (InvalidElementException e) {



                        LOG.error("updateLayout method accessed "
                                  + "deleted element", e);

                    }
                }
            };
SwingUtilities.invokeLater(doWorkRunnable);
return;
} 
if(pName.equals("editing")
                && Boolean.FALSE.equals(pve.getNewValue()))//1
{ 
LOG.debug("finished editing");
textEdited((FigText) src);
calcBounds();
endTrans();
} 
else
if(pName.equals("editing")
                   && Boolean.TRUE.equals(pve.getNewValue()))//1
{ 
textEditStarted((FigText) src);
} 
else
{ 
super.propertyChange(pve);
} 
if(Model.getFacade().isAUMLElement(src)
                && getOwner() != null
                && !Model.getUmlFactory().isRemoved(getOwner()))//1
{ 
modelChanged(pve);
final UmlChangeEvent event = (UmlChangeEvent) pve;
Runnable doWorkRunnable = new Runnable() {
                public void run() {
                    try {
                        updateLayout(event);
                    } catch (InvalidElementException e) {


                        if (LOG.isDebugEnabled()) {
                            LOG.debug("updateLayout method accessed "
                                      + "deleted element ", e);
                        }

                    }
                }
            };
SwingUtilities.invokeLater(doWorkRunnable);
} 
} 
protected int getNotationProviderType()
    { 
return NotationProviderFactory2.TYPE_NAME;
} 
protected NotationSettings getNotationSettings()
    { 
return getSettings().getNotationSettings();
} 
protected void updateLayout(UmlChangeEvent event)
    { 
} 
public String getName()
    { 
return nameFig.getText();
} 
@Override
    public void damage()
    { 
super.damage();
getFig().damage();
} 
public void vetoableChange(PropertyChangeEvent pce)
    { 
Object src = pce.getSource();
if(src == getOwner())//1
{ 
DelayedChangeNotify delayedNotify =
                new DelayedChangeNotify(this, pce);
SwingUtilities.invokeLater(delayedNotify);
} 
} 
@Deprecated
    public FigEdgeModelElement(Object edge)
    { 
this();
setOwner(edge);
} 
protected void updateNameText()
    { 
if(getOwner() == null)//1
{ 
return;
} 
if(notationProviderName != null)//1
{ 
String nameStr = notationProviderName.toString(
                                 getOwner(), getNotationSettings());
nameFig.setText(nameStr);
updateFont();
calcBounds();
setBounds(getBounds());
} 
} 
public DiagramSettings getSettings()
    { 
if(settings == null)//1
{ 
LOG.debug("Falling back to project-wide settings");
Project p = getProject();
if(p != null)//1
{ 
return p.getProjectSettings().getDefaultDiagramSettings();
} 
} 
return settings;
} 
public ItemUID getItemUID()
    { 
return itemUid;
} 
public void delayedVetoableChange(PropertyChangeEvent pce)
    { 
renderingChanged();
Rectangle bbox = getBounds();
setBounds(bbox.x, bbox.y, bbox.width, bbox.height);
endTrans();
} 
protected void initNotationProviders(Object own)
    { 
if(notationProviderName != null)//1
{ 
notationProviderName.cleanListener(this, own);
} 
if(Model.getFacade().isAModelElement(own))//1
{ 
NotationName notation = Notation.findNotation(
                                        getNotationSettings().getNotationLanguage());
notationProviderName =
                NotationProviderFactory2.getInstance().getNotationProvider(
                    getNotationProviderType(), own, this,
                    notation);
} 
} 
public FigEdgePort getEdgePort()
    { 
return edgePort;
} 
private void deepUpdateFontRecursive(Font f, Object pathFig)
    { 
if(pathFig instanceof ArgoFigText)//1
{ 
((ArgoFigText) pathFig).updateFont();
} 
else
if(pathFig instanceof FigText)//1
{ 
((FigText) pathFig).setFont(f);
} 
else
if(pathFig instanceof FigGroup)//1
{ 
for (Object fge : ((FigGroup) pathFig).getFigs()) //1
{ 
deepUpdateFontRecursive(f, fge);
} 
} 
} 
@Deprecated
    public void notationProviderRemoved(ArgoNotationEvent event)
    { 
} 
private void deepUpdateFont(FigEdge fe)
    { 
Font f = getSettings().getFont(Font.PLAIN);
for (Object pathFig : fe.getPathItemFigs()) //1
{ 
deepUpdateFontRecursive(f, pathFig);
} 
fe.calcBounds();
} 
private boolean isReadOnly()
    { 
Object owner = getOwner();
if(Model.getFacade().isAUMLElement(owner))//1
{ 
return Model.getModelManagementHelper().isReadOnly(owner);
} 
return false;
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public void setProject(Project project)
    { 
throw new UnsupportedOperationException();
} 
@Override
    public Selection makeSelection()
    { 
return new SelectionRerouteEdge(this);
} 
private void initFigs()
    { 
nameFig.setTextFilled(false);
setBetweenNearestPoints(true);
} 
protected FigText getNameFig()
    { 
return nameFig;
} 
public ToDoItem hitClarifier(int x, int y)
    { 
int iconPos = 25, xOff = -4, yOff = -4;
Point p = new Point();
ToDoList tdList = Designer.theDesigner().getToDoList();
List<ToDoItem> items = tdList.elementListForOffender(getOwner());
for (ToDoItem item : items) //1
{ 
Icon icon = item.getClarifier();
stuffPointAlongPerimeter(iconPos, p);
int width = icon.getIconWidth();
int height = icon.getIconHeight();
if(y >= p.y + yOff
                    && y <= p.y + height + yOff
                    && x >= p.x + xOff
                    && x <= p.x + width + xOff)//1
{ 
return item;
} 
iconPos += width;
} 
for (ToDoItem item : items) //2
{ 
Icon icon = item.getClarifier();
if(icon instanceof Clarifier)//1
{ 
((Clarifier) icon).setFig(this);
((Clarifier) icon).setToDoItem(item);
if(((Clarifier) icon).hit(x, y))//1
{ 
return item;
} 
} 
} 
items = tdList.elementListForOffender(this);
for (ToDoItem item : items) //3
{ 
Icon icon = item.getClarifier();
stuffPointAlongPerimeter(iconPos, p);
int width = icon.getIconWidth();
int height = icon.getIconHeight();
if(y >= p.y + yOff
                    && y <= p.y + height + yOff
                    && x >= p.x + xOff
                    && x <= p.x + width + xOff)//1
{ 
return item;
} 
iconPos += width;
} 
for (ToDoItem item : items) //4
{ 
Icon icon = item.getClarifier();
if(icon instanceof Clarifier)//1
{ 
((Clarifier) icon).setFig(this);
((Clarifier) icon).setToDoItem(item);
if(((Clarifier) icon).hit(x, y))//1
{ 
return item;
} 
} 
} 
return null;
} 
@Override
    public final void removeFromDiagram()
    { 
Fig delegate = getRemoveDelegate();
if(delegate instanceof FigNodeModelElement)//1
{ 
((FigNodeModelElement) delegate).removeFromDiagramImpl();
} 
else
if(delegate instanceof FigEdgeModelElement)//1
{ 
((FigEdgeModelElement) delegate).removeFromDiagramImpl();
} 
else
if(delegate != null)//1
{ 
removeFromDiagramImpl();
} 
} 
@Override
    public String getTipString(MouseEvent me)
    { 
ToDoItem item = hitClarifier(me.getX(), me.getY());
String tip = "";
if(item != null
                && Globals.curEditor().getSelectionManager().containsFig(this))//1
{ 
tip = item.getHeadline();
} 
else
if(getOwner() != null)//1
{ 
try//1
{ 
tip = Model.getFacade().getTipString(getOwner());
} 
catch (InvalidElementException e) //1
{ 
LOG.warn("A deleted element still exists on the diagram");
return Translator.localize("misc.name.deleted");
} 
} 
else
{ 
tip = toString();
} 
if(tip != null && tip.length() > 0 && !tip.endsWith(" "))//1
{ 
tip += " ";
} 
return tip;
} 
@Override
    public boolean hit(Rectangle r)
    { 
Iterator it = getPathItemFigs().iterator();
while (it.hasNext()) //1
{ 
Fig f = (Fig) it.next();
if(f.hit(r))//1
{ 
return true;
} 
} 
return super.hit(r);
} 
public DiElement getDiElement()
    { 
return diElement;
} 
@Deprecated
    public void notationRemoved(ArgoNotationEvent event)
    { 
} 
public void setSettings(DiagramSettings renderSettings)
    { 
settings = renderSettings;
renderingChanged();
} 
public void keyTyped(KeyEvent ke)
    { 
if(!ke.isConsumed()
                && !isReadOnly()
                && nameFig != null
                && canEdit(nameFig))//1
{ 
nameFig.keyTyped(ke);
} 
} 
protected void removeFromDiagramImpl()
    { 
Object o = getOwner();
if(o != null)//1
{ 
removeElementListener(o);
} 
if(notationProviderName != null)//1
{ 
notationProviderName.cleanListener(this, getOwner());
} 
Iterator it = getPathItemFigs().iterator();
while (it.hasNext()) //1
{ 
Fig fig = (Fig) it.next();
fig.removeFromDiagram();
} 
super.removeFromDiagram();
damage();
} 
@Deprecated
    public Project getProject()
    { 
return ArgoFigUtil.getProject(this);
} 
private Fig getNoEdgePresentationFor(Object element)
    { 
if(element == null)//1
{ 
throw new IllegalArgumentException("Can't search for a null owner");
} 
List contents = PgmlUtility.getContentsNoEdges(getLayer());
int figCount = contents.size();
for (int figIndex = 0; figIndex < figCount; ++figIndex) //1
{ 
Fig fig = (Fig) contents.get(figIndex);
if(fig.getOwner() == element)//1
{ 
return fig;
} 
} 
throw new IllegalStateException("Can't find a FigNode representing "
                                        + Model.getFacade().getName(element));
} 
protected void showHelp(String s)
    { 
ArgoEventPump.fireEvent(new ArgoHelpEvent(
                                    ArgoEventTypes.HELP_CHANGED, this,
                                    Translator.localize(s)));
} 
protected void allowRemoveFromDiagram(boolean allowed)
    { 
this.removeFromDiagram = allowed;
} 
protected void addElementListener(Object element, String property)
    { 
listeners.add(new Object[] {element, property});
Model.getPump().addModelEventListener(this, element, property);
} 
public void mouseEntered(MouseEvent me)
    { 
} 
@Deprecated
    public FigEdgeModelElement()
    { 
nameFig = new FigNameWithAbstract(X0, Y0 + 20, 90, 20, false);
stereotypeFig = new FigStereotypesGroup(X0, Y0, 90, 15);
initFigs();
} 
protected Object getSource()
    { 
Object owner = getOwner();
if(owner != null)//1
{ 
return Model.getCoreHelper().getSource(owner);
} 
return null;
} 
public void keyReleased(KeyEvent ke)
    { 
} 
protected void textEdited(FigText ft)
    { 
if(ft == nameFig)//1
{ 
if(getOwner() == null)//1
{ 
return;
} 
notationProviderName.parse(getOwner(), ft.getText());
ft.setText(notationProviderName.toString(getOwner(),
                       getNotationSettings()));
} 
} 
protected void indicateBounds(FigText f, Graphics g)
    { 
} 
@Deprecated
    protected HashMap<String, Object> getNotationArguments()
    { 
return npArguments;
} 
protected void addElementListener(Object element, String[] property)
    { 
listeners.add(new Object[] {element, property});
Model.getPump().addModelEventListener(this, element, property);
} 
protected boolean determineFigNodes()
    { 
Object owner = getOwner();
if(owner == null)//1
{ 
LOG.error("The FigEdge has no owner");
return false;
} 
if(getLayer() == null)//1
{ 
LOG.error("The FigEdge has no layer");
return false;
} 
Object newSource = getSource();
Object newDest = getDestination();
Fig currentSourceFig = getSourceFigNode();
Fig currentDestFig = getDestFigNode();
Object currentSource = null;
Object currentDestination = null;
if(currentSourceFig != null && currentDestFig != null)//1
{ 
currentSource = currentSourceFig.getOwner();
currentDestination = currentDestFig.getOwner();
} 
if(newSource != currentSource || newDest != currentDestination)//1
{ 
Fig newSourceFig = getNoEdgePresentationFor(newSource);
Fig newDestFig = getNoEdgePresentationFor(newDest);
if(newSourceFig != currentSourceFig)//1
{ 
setSourceFigNode((FigNode) newSourceFig);
setSourcePortFig(newSourceFig);
} 
if(newDestFig != currentDestFig)//1
{ 
setDestFigNode((FigNode) newDestFig);
setDestPortFig(newDestFig);
} 
((FigNode) newSourceFig).updateEdges();
((FigNode) newDestFig).updateEdges();
calcBounds();
if(newSourceFig == newDestFig)//1
{ 
layoutThisToSelf();
} 
} 
return true;
} 
public void setLineColor(Color c)
    { 
super.setLineColor(c);
} 
protected void updateListeners(Object oldOwner, Object newOwner)
    { 
Set<Object[]> l = new HashSet<Object[]>();
if(newOwner != null)//1
{ 
l.add(new Object[] {newOwner, "remove"});
} 
updateElementListeners(l);
} 
public void paintClarifiers(Graphics g)
    { 
int iconPos = 25, gap = 1, xOff = -4, yOff = -4;
Point p = new Point();
ToDoList tdList = Designer.theDesigner().getToDoList();
List<ToDoItem> items = tdList.elementListForOffender(getOwner());
for (ToDoItem item : items) //1
{ 
Icon icon = item.getClarifier();
if(icon instanceof Clarifier)//1
{ 
((Clarifier) icon).setFig(this);
((Clarifier) icon).setToDoItem(item);
} 
if(icon != null)//1
{ 
stuffPointAlongPerimeter(iconPos, p);
icon.paintIcon(null, g, p.x + xOff, p.y + yOff);
iconPos += icon.getIconWidth() + gap;
} 
} 
items = tdList.elementListForOffender(this);
for (ToDoItem item : items) //2
{ 
Icon icon = item.getClarifier();
if(icon instanceof Clarifier)//1
{ 
((Clarifier) icon).setFig(this);
((Clarifier) icon).setToDoItem(item);
} 
if(icon != null)//1
{ 
stuffPointAlongPerimeter(iconPos, p);
icon.paintIcon(null, g, p.x + xOff, p.y + yOff);
iconPos += icon.getIconWidth() + gap;
} 
} 
} 
protected void updateStereotypeText()
    { 
if(getOwner() == null)//1
{ 
return;
} 
Object modelElement = getOwner();
stereotypeFig.populate();
} 
protected void updateElementListeners(Set<Object[]> listenerSet)
    { 
Set<Object[]> removes = new HashSet<Object[]>(listeners);
removes.removeAll(listenerSet);
removeElementListeners(removes);
Set<Object[]> adds = new HashSet<Object[]>(listenerSet);
adds.removeAll(listeners);
addElementListeners(adds);
} 
@Deprecated
    @Override
    public void setOwner(Object owner)
    { 
if(owner == null)//1
{ 
throw new IllegalArgumentException("An owner must be supplied");
} 
if(getOwner() != null)//1
{ 
throw new IllegalStateException(
                "The owner cannot be changed once set");
} 
if(!Model.getFacade().isAUMLElement(owner))//1
{ 
throw new IllegalArgumentException(
                "The owner must be a model element - got a "
                + owner.getClass().getName());
} 
super.setOwner(owner);
nameFig.setOwner(owner);
if(edgePort != null)//1
{ 
edgePort.setOwner(getOwner());
} 
stereotypeFig.setOwner(owner);
initNotationProviders(owner);
updateListeners(null, owner);
} 
private void removeElementListeners(Set<Object[]> listenerSet)
    { 
for (Object[] listener : listenerSet) //1
{ 
Object property = listener[1];
if(property == null)//1
{ 
Model.getPump().removeModelEventListener(this, listener[0]);
} 
else
if(property instanceof String[])//1
{ 
Model.getPump().removeModelEventListener(this, listener[0],
                        (String[]) property);
} 
else
if(property instanceof String)//1
{ 
Model.getPump().removeModelEventListener(this, listener[0],
                        (String) property);
} 
else
{ 
throw new RuntimeException(
                    "Internal error in removeAllElementListeners");
} 
} 
listeners.removeAll(listenerSet);
} 
protected void textEditStarted(FigText ft)
    { 
if(ft == getNameFig())//1
{ 
showHelp(notationProviderName.getParsingHelp());
ft.setText(notationProviderName.toString(getOwner(),
                       getNotationSettings()));
} 
} 
public void setFig(Fig f)
    { 
super.setFig(f);
f.setLineColor(getLineColor());
f.setLineWidth(getLineWidth());
} 
public void setItemUID(ItemUID newId)
    { 
itemUid = newId;
} 
protected void removeElementListener(Object element)
    { 
listeners.remove(new Object[] {element, null});
Model.getPump().removeModelEventListener(this, element);
} 
@Deprecated
    public void notationAdded(ArgoNotationEvent event)
    { 
} 
@Override
    public void deleteFromModel()
    { 
Object own = getOwner();
if(own != null)//1
{ 
getProject().moveToTrash(own);
} 
Iterator it = getPathItemFigs().iterator();
while (it.hasNext()) //1
{ 
((Fig) it.next()).deleteFromModel();
} 
super.deleteFromModel();
} 
public void mousePressed(MouseEvent me)
    { 
} 
protected int getSquaredDistance(Point p1, Point p2)
    { 
int xSquared = p2.x - p1.x;
xSquared *= xSquared;
int ySquared = p2.y - p1.y;
ySquared *= ySquared;
return xSquared + ySquared;
} 
@Deprecated
    protected void putNotationArgument(String key, Object element)
    { 
if(notationProviderName != null)//1
{ 
if(npArguments == null)//1
{ 
npArguments = new HashMap<String, Object>();
} 
npArguments.put(key, element);
} 
} 
protected static int getPopupAddOffset()
    { 
return popupAddOffset;
} 
protected void modelAttributeChanged(AttributeChangeEvent ace)
    { 
} 
protected void superRemoveFromDiagram()
    { 
super.removeFromDiagram();
} 
protected void modelAssociationAdded(AddAssociationEvent aae)
    { 
} 
protected FigEdgeModelElement(Object element,
                                  DiagramSettings renderSettings)
    { 
super();
settings = renderSettings;
super.setLineColor(LINE_COLOR);
super.setLineWidth(LINE_WIDTH);
getFig().setLineColor(LINE_COLOR);
getFig().setLineWidth(LINE_WIDTH);
nameFig = new FigNameWithAbstract(element,
                                          new Rectangle(X0, Y0 + 20, 90, 20),
                                          renderSettings, false);
stereotypeFig = new FigStereotypesGroup(element,
                                                new Rectangle(X0, Y0, 90, 15),
                                                settings);
initFigs();
initOwner(element);
} 
protected FigStereotypesGroup getStereotypeFig()
    { 
return stereotypeFig;
} 
@Override
    public Vector getPopUpActions(MouseEvent me)
    { 
ActionList popUpActions =
            new ActionList(super.getPopUpActions(me), isReadOnly());
popUpActions.add(new JSeparator());
popupAddOffset = 1;
if(removeFromDiagram)//1
{ 
popUpActions.add(
                ProjectActions.getInstance().getRemoveFromDiagramAction());
popupAddOffset++;
} 
popUpActions.add(new ActionDeleteModelElements());
popupAddOffset++;
if(TargetManager.getInstance().getTargets().size() == 1)//1
{ 
ToDoList list = Designer.theDesigner().getToDoList();
List<ToDoItem> items = list.elementListForOffender(getOwner());
if(items != null && items.size() > 0)//1
{ 
ArgoJMenu critiques = new ArgoJMenu("menu.popup.critiques");
ToDoItem itemUnderMouse = hitClarifier(me.getX(), me.getY());
if(itemUnderMouse != null)//1
{ 
critiques.add(new ActionGoToCritique(itemUnderMouse));
critiques.addSeparator();
} 
for (ToDoItem item : items) //1
{ 
if(item == itemUnderMouse)//1
{ 
continue;
} 
critiques.add(new ActionGoToCritique(item));
} 
popUpActions.add(0, new JSeparator());
popUpActions.add(0, critiques);
} 
Action[] stereoActions = getApplyStereotypeActions();
if(stereoActions != null && stereoActions.length > 0)//1
{ 
popUpActions.add(0, new JSeparator());
ArgoJMenu stereotypes = new ArgoJMenu(
                    "menu.popup.apply-stereotypes");
for (int i = 0; i < stereoActions.length; ++i) //1
{ 
stereotypes.addCheckItem(stereoActions[i]);
} 
popUpActions.add(0, stereotypes);
} 
} 
return popUpActions;
} 
@Override
    public void setLayer(Layer lay)
    { 
super.setLayer(lay);
getFig().setLayer(lay);
for (Fig f : (List<Fig>) getPathItemFigs()) //1
{ 
f.setLayer(lay);
} 
} 
protected Action[] getApplyStereotypeActions()
    { 
return StereotypeUtility.getApplyStereotypeActions(getOwner());
} 
protected void addElementListener(Object element)
    { 
listeners.add(new Object[] {element, null});
Model.getPump().addModelEventListener(this, element);
} 
public void renderingChanged()
    { 
initNotationProviders(getOwner());
updateNameText();
updateStereotypeText();
damage();
} 
protected boolean canEdit(Fig f)
    { 
return true;
} 
private void layoutThisToSelf()
    { 
FigPoly edgeShape = new FigPoly();
Point fcCenter =
            new Point(getSourceFigNode().getX() / 2,
                      getSourceFigNode().getY() / 2);
Point centerRight =
            new Point(
            (int) (fcCenter.x
                   + getSourceFigNode().getSize().getWidth() / 2),
            fcCenter.y);
int yoffset = (int) ((getSourceFigNode().getSize().getHeight() / 2));
edgeShape.addPoint(fcCenter.x, fcCenter.y);
edgeShape.addPoint(centerRight.x, centerRight.y);
edgeShape.addPoint(centerRight.x + 30, centerRight.y);
edgeShape.addPoint(centerRight.x + 30, centerRight.y + yoffset);
edgeShape.addPoint(centerRight.x, centerRight.y + yoffset);
this.setBetweenNearestPoints(true);
edgeShape.setLineColor(LINE_COLOR);
edgeShape.setFilled(false);
edgeShape.setComplete(true);
this.setFig(edgeShape);
} 
public void makeEdgePort()
    { 
if(edgePort == null)//1
{ 
edgePort = new FigEdgePort(getOwner(), new Rectangle(),
                                       getSettings());
edgePort.setVisible(false);
addPathItem(edgePort,
                        new PathItemPlacement(this, edgePort, 50, 0));
} 
} 
protected void modelChanged(PropertyChangeEvent e)
    { 
if(e instanceof DeleteInstanceEvent)//1
{ 
return;
} 
if(e instanceof AssociationChangeEvent
                || e instanceof AttributeChangeEvent)//1
{ 
if(notationProviderName != null)//1
{ 
notationProviderName.updateListener(this, getOwner(), e);
updateNameText();
} 
updateListeners(getOwner(), getOwner());
} 
determineFigNodes();
} 
public void keyPressed(KeyEvent ke)
    { 
} 
private void initOwner(Object element)
    { 
if(element != null)//1
{ 
if(!Model.getFacade().isAUMLElement(element))//1
{ 
throw new IllegalArgumentException(
                    "The owner must be a model element - got a "
                    + element.getClass().getName());
} 
super.setOwner(element);
nameFig.setOwner(element);
if(edgePort != null)//1
{ 
edgePort.setOwner(getOwner());
} 
stereotypeFig.setOwner(element);
notationProviderName =
                NotationProviderFactory2.getInstance().getNotationProvider(
                    getNotationProviderType(), element, this);
addElementListener(element, "remove");
} 
} 
public void mouseClicked(MouseEvent me)
    { 
if(!me.isConsumed() && !isReadOnly() && me.getClickCount() >= 2)//1
{ 
Fig f = hitFig(new Rectangle(me.getX() - 2, me.getY() - 2, 4, 4));
if(f instanceof MouseListener && canEdit(f))//1
{ 
((MouseListener) f).mouseClicked(me);
} 
} 
me.consume();
} 
public void setDiElement(DiElement element)
    { 
this.diElement = element;
} 
@Deprecated
    public void notationChanged(ArgoNotationEvent event)
    { 
if(getOwner() == null)//1
{ 
return;
} 
renderingChanged();
} 
public Rectangle getNameBounds()
    { 
return nameFig.getBounds();
} 
protected void removeAllElementListeners()
    { 
removeElementListeners(listeners);
} 
@Deprecated
    public void notationProviderAdded(ArgoNotationEvent event)
    { 
} 
protected Object getDestination()
    { 
Object owner = getOwner();
if(owner != null)//1
{ 
return Model.getCoreHelper().getDestination(owner);
} 
return null;
} 
private void addElementListeners(Set<Object[]> listenerSet)
    { 
for (Object[] listener : listenerSet) //1
{ 
Object property = listener[1];
if(property == null)//1
{ 
addElementListener(listener[0]);
} 
else
if(property instanceof String[])//1
{ 
addElementListener(listener[0], (String[]) property);
} 
else
if(property instanceof String)//1
{ 
addElementListener(listener[0], (String) property);
} 
else
{ 
throw new RuntimeException(
                    "Internal error in addElementListeners");
} 
} 
} 
protected Fig getRemoveDelegate()
    { 
return this;
} 
@Deprecated
    public void diagramFontChanged(ArgoDiagramAppearanceEvent e)
    { 
updateFont();
calcBounds();
redraw();
} 
protected void updateFont()
    { 
int style = getNameFigFontStyle();
Font f = getSettings().getFont(style);
nameFig.setFont(f);
deepUpdateFont(this);
} 

 } 
