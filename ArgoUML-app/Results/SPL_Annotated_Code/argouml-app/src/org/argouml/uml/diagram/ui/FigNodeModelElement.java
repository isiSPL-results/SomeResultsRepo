// Compilation Unit of /FigNodeModelElement.java 
 
package org.argouml.uml.diagram.ui;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.util.ArrayList;
import java.util.Collection;
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
import org.argouml.model.AssociationChangeEvent;
import org.argouml.model.AttributeChangeEvent;
import org.argouml.model.DeleteInstanceEvent;
import org.argouml.model.DiElement;
import org.argouml.model.InvalidElementException;
import org.argouml.model.Model;
import org.argouml.model.UmlChangeEvent;
import org.argouml.notation.Notation;
import org.argouml.notation.NotationName;
import org.argouml.notation.NotationProvider;
import org.argouml.notation.NotationProviderFactory2;
import org.argouml.notation.NotationSettings;
import org.argouml.ui.ArgoJMenu;
import org.argouml.ui.Clarifier;
import org.argouml.ui.ProjectActions;
import org.argouml.ui.UndoableAction;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.StereotypeUtility;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.uml.diagram.DiagramAppearance;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.PathContainer;
import org.argouml.uml.diagram.DiagramSettings.StereotypeStyle;
import org.argouml.uml.ui.ActionDeleteModelElements;
import org.argouml.util.IItemUID;
import org.argouml.util.ItemUID;
import org.tigris.gef.base.Diagram;
import org.tigris.gef.base.Globals;
import org.tigris.gef.base.Layer;
import org.tigris.gef.base.LayerPerspective;
import org.tigris.gef.base.Selection;
import org.tigris.gef.graph.MutableGraphSupport;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigGroup;
import org.tigris.gef.presentation.FigImage;
import org.tigris.gef.presentation.FigNode;
import org.tigris.gef.presentation.FigRect;
import org.tigris.gef.presentation.FigText;
public abstract class FigNodeModelElement extends FigNode
 implements VetoableChangeListener
, DelayedVChangeListener
, MouseListener
, KeyListener
, PropertyChangeListener
, PathContainer
, ArgoDiagramAppearanceEventListener
, ArgoNotationEventListener
, Highlightable
, IItemUID
, Clarifiable
, ArgoFig
, StereotypeStyled
  { 
private static final Logger LOG =
        Logger.getLogger(FigNodeModelElement.class);
protected static final int WIDTH = 64;
protected static final int NAME_FIG_HEIGHT = 21;
protected static final int NAME_V_PADDING = 2;
private DiElement diElement;
private NotationProvider notationProviderName;
private HashMap<String, Object> npArguments;
protected boolean invisibleAllowed = false;
private boolean checkSize = true;
private static int popupAddOffset;
protected static final int ROOT = 1;
protected static final int ABSTRACT = 2;
protected static final int LEAF = 4;
protected static final int ACTIVE = 8;
private Fig bigPort;
private FigText nameFig;
private FigStereotypesGroup stereotypeFig;
private FigProfileIcon stereotypeFigProfileIcon;
private List<Fig> floatingStereotypes = new ArrayList<Fig>();
private DiagramSettings.StereotypeStyle stereotypeStyle =
        DiagramSettings.StereotypeStyle.TEXTUAL;
private static final int ICON_WIDTH = 16;
private FigText originalNameFig;
private Vector<Fig> enclosedFigs = new Vector<Fig>();
private Fig encloser;
private boolean readyToEdit = true;
private boolean suppressCalcBounds;
private static boolean showBoldName;
private ItemUID itemUid;
private boolean removeFromDiagram = true;
private boolean editable = true;
private Set<Object[]> listeners = new HashSet<Object[]>();
private DiagramSettings settings;
private NotationSettings notationSettings;
@Override
    public void setEnclosingFig(Fig newEncloser)
    { 
Fig oldEncloser = encloser;
LayerPerspective layer = (LayerPerspective) getLayer();
if(layer != null)//1
{ 
ArgoDiagram diagram = (ArgoDiagram) layer.getDiagram();
diagram.encloserChanged(
                this,
                (FigNode) oldEncloser,
                (FigNode) newEncloser);
} 

super.setEnclosingFig(newEncloser);
if(layer != null && newEncloser != oldEncloser)//1
{ 
Diagram diagram = layer.getDiagram();
if(diagram instanceof ArgoDiagram)//1
{ 
ArgoDiagram umlDiagram = (ArgoDiagram) diagram;
Object namespace = null;
if(newEncloser == null)//1
{ 
umlDiagram.setModelElementNamespace(getOwner(), null);
} 
else
{ 
namespace = newEncloser.getOwner();
if(Model.getFacade().isANamespace(namespace))//1
{ 
umlDiagram.setModelElementNamespace(
                            getOwner(), namespace);
} 

} 

} 

if(encloser instanceof FigNodeModelElement)//1
{ 
((FigNodeModelElement) encloser).removeEnclosedFig(this);
} 

if(newEncloser instanceof FigNodeModelElement)//1
{ 
((FigNodeModelElement) newEncloser).addEnclosedFig(this);
} 

} 

encloser = newEncloser;
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

public void vetoableChange(PropertyChangeEvent pce)
    { 
LOG.debug("in vetoableChange");
Object src = pce.getSource();
if(src == getOwner())//1
{ 
DelayedChangeNotify delayedNotify =
                new DelayedChangeNotify(this, pce);
SwingUtilities.invokeLater(delayedNotify);
} 
else
{ 
LOG.debug("FigNodeModelElement got vetoableChange"
                      + " from non-owner:"
                      + src);
} 

} 

protected void setEditable(boolean canEdit)
    { 
this.editable = canEdit;
} 

public void setSettings(DiagramSettings renderSettings)
    { 
settings = renderSettings;
renderingChanged();
} 

protected void updateListeners(Object oldOwner, Object newOwner)
    { 
if(oldOwner == newOwner)//1
{ 
return;
} 

if(oldOwner != null)//1
{ 
removeElementListener(oldOwner);
} 

if(newOwner != null)//1
{ 
addElementListener(newOwner);
} 

} 

protected ToDoItem hitClarifier(int x, int y)
    { 
int iconX = getX();
ToDoList tdList = Designer.theDesigner().getToDoList();
List<ToDoItem> items = tdList.elementListForOffender(getOwner());
for (ToDoItem item : items) //1
{ 
Icon icon = item.getClarifier();
int width = icon.getIconWidth();
if(y >= getY() - 15
                    && y <= getY() + 10
                    && x >= iconX
                    && x <= iconX + width)//1
{ 
return item;
} 

iconX += width;
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
int width = icon.getIconWidth();
if(y >= getY() - 15
                    && y <= getY() + 10
                    && x >= iconX
                    && x <= iconX + width)//1
{ 
return item;
} 

iconX += width;
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

public void keyReleased(KeyEvent ke)
    { 
if(ke.isConsumed() || getOwner() == null)//1
{ 
return;
} 

nameFig.keyReleased(ke);
} 

@Override
    public String getTipString(MouseEvent me)
    { 
ToDoItem item = hitClarifier(me.getX(), me.getY());
String tip = "";
if(item != null
                && Globals.curEditor().getSelectionManager().containsFig(this))//1
{ 
tip = item.getHeadline() + " ";
} 
else
if(getOwner() != null)//1
{ 
tip = Model.getFacade().getTipString(getOwner());
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

public void setPathVisible(boolean visible)
    { 
NotationSettings ns = getNotationSettings();
if(ns.isShowPaths() == visible)//1
{ 
return;
} 

MutableGraphSupport.enableSaveAction();
firePropChange("pathVisible", !visible, visible);
ns.setShowPaths(visible);
if(readyToEdit)//1
{ 
renderingChanged();
damage();
} 

} 

public int getStereotypeView()
    { 
return stereotypeStyle.ordinal();
} 

protected void modelChanged(PropertyChangeEvent event)
    { 
if(event instanceof AssociationChangeEvent
                || event instanceof AttributeChangeEvent)//1
{ 
if(notationProviderName != null)//1
{ 
notationProviderName.updateListener(this, getOwner(), event);
} 

updateListeners(getOwner(), getOwner());
} 

} 

protected void setReadyToEdit(boolean v)
    { 
readyToEdit = v;
} 

@Deprecated
    protected void putNotationArgument(String key, Object value)
    { 
if(notationProviderName != null)//1
{ 
if(npArguments == null)//1
{ 
npArguments = new HashMap<String, Object>();
} 

npArguments.put(key, value);
} 

} 

protected void removeAllElementListeners()
    { 
removeElementListeners(listeners);
} 

protected FigStereotypesGroup getStereotypeFig()
    { 
return stereotypeFig;
} 

private void updateSmallIcons(int wid)
    { 
int i = this.getX() + wid - ICON_WIDTH - 2;
for (Fig ficon : floatingStereotypes) //1
{ 
ficon.setLocation(i, this.getBigPort().getY() + 2);
i -= ICON_WIDTH - 2;
} 

getNameFig().setRightMargin(
            floatingStereotypes.size() * (ICON_WIDTH + 5));
} 

protected int getNameFigFontStyle()
    { 
showBoldName = getSettings().isShowBoldNames();
return showBoldName ? Font.BOLD : Font.PLAIN;
} 

public void setItemUID(ItemUID id)
    { 
itemUid = id;
} 

public void setStereotypeView(int s)
    { 
setStereotypeStyle(StereotypeStyle.getEnum(s));
} 

protected void textEditStarted(FigText ft)
    { 
if(ft == getNameFig())//1
{ 
showHelp(notationProviderName.getParsingHelp());
ft.setText(notationProviderName.toString(getOwner(),
                       getNotationSettings()));
} 

if(ft instanceof CompartmentFigText)//1
{ 
final CompartmentFigText figText = (CompartmentFigText) ft;
showHelp(figText.getNotationProvider().getParsingHelp());
figText.setText(figText.getNotationProvider().toString(
                                figText.getOwner(), getNotationSettings()));
} 

} 

public void paintClarifiers(Graphics g)
    { 
int iconX = getX();
int iconY = getY() - 10;
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
icon.paintIcon(null, g, iconX, iconY);
iconX += icon.getIconWidth();
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
icon.paintIcon(null, g, iconX, iconY);
iconX += icon.getIconWidth();
} 

} 

} 

@Override
    public Object clone()
    { 
final FigNodeModelElement clone = (FigNodeModelElement) super.clone();
final Iterator cloneIter = clone.getFigs().iterator();
for (Object thisFig : getFigs()) //1
{ 
final Fig cloneFig = (Fig) cloneIter.next();
if(thisFig == getBigPort())//1
{ 
clone.setBigPort(cloneFig);
} 

if(thisFig == nameFig)//1
{ 
clone.nameFig = (FigSingleLineText) thisFig;
} 

if(thisFig == getStereotypeFig())//1
{ 
clone.stereotypeFig = (FigStereotypesGroup) thisFig;
} 

} 

return clone;
} 

protected FigNodeModelElement(Object element, Rectangle bounds,
                                  DiagramSettings renderSettings)
    { 
super();
super.setOwner(element);
settings = renderSettings;
super.setFillColor(FILL_COLOR);
super.setLineColor(LINE_COLOR);
super.setLineWidth(LINE_WIDTH);
super.setTextColor(TEXT_COLOR);
notationSettings = new NotationSettings(settings.getNotationSettings());
bigPort = new FigRect(X0, Y0, 0, 0, DEBUG_COLOR, DEBUG_COLOR);
nameFig = new FigNameWithAbstractAndBold(element,
                new Rectangle(X0, Y0, WIDTH, NAME_FIG_HEIGHT), getSettings(), true);
stereotypeFig = createStereotypeFig();
constructFigs();
if(element != null && !Model.getFacade().isAUMLElement(element))//1
{ 
throw new IllegalArgumentException(
                "The owner must be a model element - got a "
                + element.getClass().getName());
} 

nameFig.setText(placeString());
if(element != null)//1
{ 
notationProviderName =
                NotationProviderFactory2.getInstance().getNotationProvider(
                    getNotationProviderType(), element, this);
bindPort(element, bigPort);
addElementListener(element);
} 

if(bounds != null)//1
{ 
setLocation(bounds.x, bounds.y);
} 

readyToEdit = true;
} 

protected boolean isReadyToEdit()
    { 
return readyToEdit;
} 

@Override
    public void mouseClicked(MouseEvent me)
    { 
if(!readyToEdit)//1
{ 
if(Model.getFacade().isAModelElement(getOwner()))//1
{ 
Model.getCoreHelper().setName(getOwner(), "");
readyToEdit = true;
} 
else
{ 
LOG.debug("not ready to edit name");
return;
} 

} 

if(me.isConsumed())//1
{ 
return;
} 

if(me.getClickCount() >= 2
                && !(me.isPopupTrigger()
                     || me.getModifiers() == InputEvent.BUTTON3_MASK)
                && getOwner() != null
                && !isReadOnly())//1
{ 
Rectangle r = new Rectangle(me.getX() - 2, me.getY() - 2, 4, 4);
Fig f = hitFig(r);
if(f instanceof MouseListener && f.isVisible())//1
{ 
((MouseListener) f).mouseClicked(me);
} 
else
if(f instanceof FigGroup && f.isVisible())//1
{ 
Fig f2 = ((FigGroup) f).hitFig(r);
if(f2 instanceof MouseListener)//1
{ 
((MouseListener) f2).mouseClicked(me);
} 
else
{ 
createContainedModelElement((FigGroup) f, me);
} 

} 


} 

} 

private void stereotypeChanged(final UmlChangeEvent event)
    { 
final Object owner = getOwner();
assert owner != null;
try //1
{ 
if(event.getOldValue() != null)//1
{ 
removeElementListener(event.getOldValue());
} 

if(event.getNewValue() != null)//1
{ 
addElementListener(event.getNewValue(), "name");
} 

} 
catch (InvalidElementException e) //1
{ 
LOG.debug("stereotypeChanged method accessed deleted element ", e);
} 


} 

@Override
    protected void setBoundsImpl(final int x, final int y, final int w,
                                 final int h)
    { 
if(getPracticalView() == DiagramAppearance.STEREOTYPE_VIEW_BIG_ICON)//1
{ 
if(stereotypeFigProfileIcon != null)//1
{ 
stereotypeFigProfileIcon.setBounds(stereotypeFigProfileIcon
                                                   .getX(), stereotypeFigProfileIcon.getY(), w, h);
} 

} 
else
{ 
setStandardBounds(x, y, w, h);
if(getStereotypeView()
                    == DiagramAppearance.STEREOTYPE_VIEW_SMALL_ICON)//1
{ 
updateSmallIcons(w);
} 

} 

} 

protected void updateBounds()
    { 
if(!checkSize)//1
{ 
return;
} 

Rectangle bbox = getBounds();
Dimension minSize = getMinimumSize();
bbox.width = Math.max(bbox.width, minSize.width);
bbox.height = Math.max(bbox.height, minSize.height);
setBounds(bbox.x, bbox.y, bbox.width, bbox.height);
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

protected void updateStereotypeIcon()
    { 
if(getOwner() == null)//1
{ 
LOG.warn("Owner of [" + this.toString() + "/" + this.getClass()
                     + "] is null.");
LOG.warn("I return...");
return;
} 

if(stereotypeFigProfileIcon != null)//1
{ 
for (Object fig : getFigs()) //1
{ 
((Fig) fig).setVisible(fig != stereotypeFigProfileIcon);
} 

this.removeFig(stereotypeFigProfileIcon);
stereotypeFigProfileIcon = null;
} 

if(originalNameFig != null)//1
{ 
this.setNameFig(originalNameFig);
originalNameFig = null;
} 

for (Fig icon : floatingStereotypes) //1
{ 
this.removeFig(icon);
} 

floatingStereotypes.clear();
int practicalView = getPracticalView();
Object modelElement = getOwner();
Collection stereos = Model.getFacade().getStereotypes(modelElement);
boolean hiding =
            practicalView == DiagramAppearance.STEREOTYPE_VIEW_SMALL_ICON;
if(getStereotypeFig() != null)//1
{ 
getStereotypeFig().setHidingStereotypesWithIcon(hiding);
} 

if(practicalView == DiagramAppearance.STEREOTYPE_VIEW_BIG_ICON)//1
{ 
Image replaceIcon = null;
if(stereos.size() == 1)//1
{ 
Object stereo = stereos.iterator().next();
replaceIcon = getProject()
                              .getProfileConfiguration().getFigNodeStrategy()
                              .getIconForStereotype(stereo);
} 

if(replaceIcon != null)//1
{ 
stereotypeFigProfileIcon = new FigProfileIcon(replaceIcon,
                        getName());
stereotypeFigProfileIcon.setOwner(getOwner());
stereotypeFigProfileIcon.setLocation(getBigPort()
                                                     .getLocation());
addFig(stereotypeFigProfileIcon);
originalNameFig = this.getNameFig();
final FigText labelFig =
                    stereotypeFigProfileIcon.getLabelFig();
setNameFig(labelFig);
labelFig.addPropertyChangeListener(this);
getBigPort().setBounds(stereotypeFigProfileIcon.getBounds());
for (Object fig : getFigs()) //1
{ 
((Fig) fig).setVisible(fig == stereotypeFigProfileIcon);
} 

} 

} 
else
if(practicalView
                   == DiagramAppearance.STEREOTYPE_VIEW_SMALL_ICON)//1
{ 
int i = this.getX() + this.getWidth() - ICON_WIDTH - 2;
for (Object stereo : stereos) //1
{ 
Image icon = getProject()
                             .getProfileConfiguration().getFigNodeStrategy()
                             .getIconForStereotype(stereo);
if(icon != null)//1
{ 
FigImage fimg = new FigImage(i,
                                                 this.getBigPort().getY() + 2, icon);
fimg.setSize(ICON_WIDTH,
                                 (icon.getHeight(null) * ICON_WIDTH)
                                 / icon.getWidth(null));
addFig(fimg);
floatingStereotypes.add(fimg);
i -= ICON_WIDTH - 2;
} 

} 

updateSmallIcons(this.getWidth());
} 


updateStereotypeText();
damage();
calcBounds();
updateEdges();
updateBounds();
redraw();
} 

private boolean isReadOnly()
    { 
return Model.getModelManagementHelper().isReadOnly(getOwner());
} 

protected int getNotationProviderType()
    { 
return NotationProviderFactory2.TYPE_NAME;
} 

public void addEnclosedFig(Fig fig)
    { 
enclosedFigs.add(fig);
} 

public Fig getBigPort()
    { 
return bigPort;
} 

public void diagramFontChanged(ArgoDiagramAppearanceEvent e)
    { 
updateFont();
updateBounds();
damage();
} 

protected Object buildVisibilityPopUp()
    { 
ArgoJMenu visibilityMenu = new ArgoJMenu("menu.popup.visibility");
visibilityMenu.addRadioItem(new ActionVisibilityPublic(getOwner()));
visibilityMenu.addRadioItem(new ActionVisibilityPrivate(getOwner()));
visibilityMenu.addRadioItem(new ActionVisibilityProtected(getOwner()));
visibilityMenu.addRadioItem(new ActionVisibilityPackage(getOwner()));
return visibilityMenu;
} 

public void propertyChange(final PropertyChangeEvent pve)
    { 
final Object src = pve.getSource();
final String pName = pve.getPropertyName();
if(pve instanceof DeleteInstanceEvent && src == getOwner())//1
{ 
removeFromDiagram();
return;
} 

if(pve.getPropertyName().equals("supplierDependency")
                && Model.getFacade().isADependency(pve.getOldValue()))//1
{ 
return;
} 

if(pName.equals("editing")
                && Boolean.FALSE.equals(pve.getNewValue()))//1
{ 
try //1
{ 
textEdited((FigText) src);
final Rectangle bbox = getBounds();
final Dimension minSize = getMinimumSize();
bbox.width = Math.max(bbox.width, minSize.width);
bbox.height = Math.max(bbox.height, minSize.height);
setBounds(bbox.x, bbox.y, bbox.width, bbox.height);
endTrans();
} 
catch (PropertyVetoException ex) //1
{ 
LOG.error("could not parse the text entered. "
                          + "PropertyVetoException",
                          ex);
} 


} 
else
if(pName.equals("editing")
                   && Boolean.TRUE.equals(pve.getNewValue()))//1
{ 
if(!isReadOnly())//1
{ 
textEditStarted((FigText) src);
} 

} 
else
{ 
super.propertyChange(pve);
} 


if(Model.getFacade().isAUMLElement(src))//1
{ 
final UmlChangeEvent event = (UmlChangeEvent) pve;
final Object owner = getOwner();
if(owner == null)//1
{ 
return;
} 

try //1
{ 
modelChanged(event);
} 
catch (InvalidElementException e) //1
{ 
if(LOG.isDebugEnabled())//1
{ 
LOG.debug("modelChanged method accessed deleted element"
                              + formatEvent(event),
                              e);
} 

} 


if(event.getSource() == owner
                    && "stereotype".equals(event.getPropertyName()))//1
{ 
stereotypeChanged(event);
} 

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
SwingUtilities.invokeLater(doWorkRunnable);
} 

} 

private void deepUpdateFont(FigGroup fg)
    { 
boolean changed = false;
List<Fig> figs = fg.getFigs();
for (Fig f : figs) //1
{ 
if(f instanceof ArgoFigText)//1
{ 
((ArgoFigText) f).renderingChanged();
changed = true;
} 

if(f instanceof FigGroup)//1
{ 
deepUpdateFont((FigGroup) f);
} 

} 

if(changed)//1
{ 
fg.calcBounds();
} 

} 

protected NotationSettings getNotationSettings()
    { 
return notationSettings;
} 

public void calcBounds()
    { 
if(suppressCalcBounds)//1
{ 
return;
} 

super.calcBounds();
} 

public void setStereotypeStyle(StereotypeStyle style)
    { 
stereotypeStyle = style;
renderingChanged();
} 

@SuppressWarnings("deprecation")

    @Deprecated
    public void setProject(Project project)
    { 
throw new UnsupportedOperationException();
} 

protected void showHelp(String s)
    { 
if(s == null)//1
{ 
ArgoEventPump.fireEvent(new ArgoHelpEvent(
                                        ArgoEventTypes.HELP_CHANGED, this, ""));
} 
else
{ 
ArgoEventPump.fireEvent(new ArgoHelpEvent(
                                        ArgoEventTypes.HELP_CHANGED, this, Translator.localize(s)));
} 

} 

@Deprecated
    public void notationProviderAdded(ArgoNotationEvent event)
    { 
} 

@Override
    public void setLayer(Layer lay)
    { 
super.setLayer(lay);
determineDefaultPathVisible();
} 

protected void allowRemoveFromDiagram(boolean allowed)
    { 
this.removeFromDiagram = allowed;
} 

@Override
    public Vector getPopUpActions(MouseEvent me)
    { 
ActionList popUpActions =
            new ActionList(super.getPopUpActions(me), isReadOnly());
ArgoJMenu show = buildShowPopUp();
if(show.getMenuComponentCount() > 0)//1
{ 
popUpActions.add(show);
} 

popUpActions.add(new JSeparator());
popupAddOffset = 1;
if(removeFromDiagram)//1
{ 
popUpActions.add(
                ProjectActions.getInstance().getRemoveFromDiagramAction());
popupAddOffset++;
} 

if(!isReadOnly())//1
{ 
popUpActions.add(new ActionDeleteModelElements());
popupAddOffset++;
} 

if(TargetManager.getInstance().getTargets().size() == 1)//1
{ 
ToDoList tdList = Designer.theDesigner().getToDoList();
List<ToDoItem> items = tdList.elementListForOffender(getOwner());
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
if(item != itemUnderMouse)//1
{ 
critiques.add(new ActionGoToCritique(item));
} 

} 

popUpActions.add(0, new JSeparator());
popUpActions.add(0, critiques);
} 

final Action[] stereoActions =
                StereotypeUtility.getApplyStereotypeActions(getOwner());
if(stereoActions != null)//1
{ 
popUpActions.add(0, new JSeparator());
final ArgoJMenu stereotypes =
                    new ArgoJMenu("menu.popup.apply-stereotypes");
for (Action action : stereoActions) //1
{ 
stereotypes.addCheckItem(action);
} 

popUpActions.add(0, stereotypes);
} 

ArgoJMenu stereotypesView =
                new ArgoJMenu("menu.popup.stereotype-view");
stereotypesView.addRadioItem(new ActionStereotypeViewTextual(this));
stereotypesView.addRadioItem(new ActionStereotypeViewBigIcon(this));
stereotypesView.addRadioItem(
                new ActionStereotypeViewSmallIcon(this));
popUpActions.add(0, stereotypesView);
} 

return popUpActions;
} 

public int getStereotypeCount()
    { 
if(getStereotypeFig() == null)//1
{ 
return 0;
} 

return getStereotypeFig().getStereotypeCount();
} 

@Override
    public Fig getEnclosingFig()
    { 
return encloser;
} 

@Deprecated
    protected FigNodeModelElement(Object element, int x, int y)
    { 
this();
setOwner(element);
nameFig.setText(placeString());
readyToEdit = false;
setLocation(x, y);
} 

protected Object buildModifierPopUp(int items)
    { 
ArgoJMenu modifierMenu = new ArgoJMenu("menu.popup.modifiers");
if((items & ABSTRACT) > 0)//1
{ 
modifierMenu.addCheckItem(new ActionModifierAbstract(getOwner()));
} 

if((items & LEAF) > 0)//1
{ 
modifierMenu.addCheckItem(new ActionModifierLeaf(getOwner()));
} 

if((items & ROOT) > 0)//1
{ 
modifierMenu.addCheckItem(new ActionModifierRoot(getOwner()));
} 

if((items & ACTIVE) > 0)//1
{ 
modifierMenu.addCheckItem(new ActionModifierActive(getOwner()));
} 

return modifierMenu;
} 

public String placeString()
    { 
if(Model.getFacade().isAModelElement(getOwner()))//1
{ 
String placeString = Model.getFacade().getName(getOwner());
if(placeString == null)//1
{ 
placeString =
                    // TODO: I18N
                    "new " + Model.getFacade().getUMLClassName(getOwner());
} 

return placeString;
} 

return "";
} 

@Override
    public Selection makeSelection()
    { 
return new SelectionDefaultClarifiers(this);
} 

public void delayedVetoableChange(PropertyChangeEvent pce)
    { 
LOG.debug("in delayedVetoableChange");
renderingChanged();
endTrans();
} 

public StereotypeStyle getStereotypeStyle()
    { 
return stereotypeStyle;
} 

public boolean isEditable()
    { 
return editable;
} 

@Override
    public boolean hit(Rectangle r)
    { 
int cornersHit = countCornersContained(r.x, r.y, r.width, r.height);
if(_filled)//1
{ 
return cornersHit > 0 || intersects(r);
} 

return (cornersHit > 0 && cornersHit < 4) || intersects(r);
} 

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
if(getStereotypeFig() != null)//1
{ 
getStereotypeFig().setOwner(owner);
} 

initNotationProviders(owner);
readyToEdit = true;
renderingChanged();
bindPort(owner, bigPort);
updateListeners(null, owner);
} 

public DiElement getDiElement()
    { 
return diElement;
} 

protected void updateNameText()
    { 
if(readyToEdit)//1
{ 
if(getOwner() == null)//1
{ 
return;
} 

if(notationProviderName != null)//1
{ 
nameFig.setText(notationProviderName.toString(
                                    getOwner(), getNotationSettings()));
updateFont();
updateBounds();
} 

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

protected void updateStereotypeText()
    { 
if(getOwner() == null)//1
{ 
LOG.warn("Null owner for [" + this.toString() + "/"
                     + this.getClass());
return;
} 

if(getStereotypeFig() != null)//1
{ 
getStereotypeFig().populate();
} 

} 

public void removeEnclosedFig(Fig fig)
    { 
enclosedFigs.remove(fig);
} 

protected boolean isSingleTarget()
    { 
return TargetManager.getInstance().getSingleModelTarget()
               == getOwner();
} 

protected FigStereotypesGroup createStereotypeFig()
    { 
return new FigStereotypesGroup(getOwner(),
                                       new Rectangle(X0, Y0, WIDTH, STEREOHEIGHT), settings);
} 

public void keyPressed(KeyEvent ke)
    { 
if(ke.isConsumed() || getOwner() == null)//1
{ 
return;
} 

nameFig.keyPressed(ke);
} 

protected void setStandardBounds(final int x, final int y,
                                     final int w, final int h)
    { 
} 

protected void determineDefaultPathVisible()
    { 
Object modelElement = getOwner();
LayerPerspective layer = (LayerPerspective) getLayer();
if((layer != null)
                && Model.getFacade().isAModelElement(modelElement))//1
{ 
ArgoDiagram diagram = (ArgoDiagram) layer.getDiagram();
Object elementNs = Model.getFacade().getNamespace(modelElement);
Object diagramNs = diagram.getNamespace();
if(elementNs != null)//1
{ 
boolean visible = (elementNs != diagramNs);
getNotationSettings().setShowPaths(visible);
updateNameText();
damage();
} 

} 

} 

protected ArgoJMenu buildShowPopUp()
    { 
ArgoJMenu showMenu = new ArgoJMenu("menu.popup.show");
for (UndoableAction ua : ActionSetPath.getActions()) //1
{ 
showMenu.add(ua);
} 

return showMenu;
} 

private void constructFigs()
    { 
nameFig.setFilled(true);
nameFig.setText(placeString());
nameFig.setBotMargin(7);
nameFig.setRightMargin(4);
nameFig.setLeftMargin(4);
readyToEdit = false;
setShadowSize(getSettings().getDefaultShadowWidth());
stereotypeStyle = getSettings().getDefaultStereotypeView();
} 

protected void createContainedModelElement(FigGroup fg, InputEvent me)
    { 
} 

@Deprecated
    public void notationProviderRemoved(ArgoNotationEvent event)
    { 
} 

public void setName(String n)
    { 
nameFig.setText(n);
} 

protected void setNameFig(FigText fig)
    { 
nameFig = fig;
if(nameFig != null)//1
{ 
updateFont();
} 

} 

@Override
    public void deleteFromModel()
    { 
Object own = getOwner();
if(own != null)//1
{ 
getProject().moveToTrash(own);
} 

for (Object fig : getFigs()) //1
{ 
((Fig) fig).deleteFromModel();
} 

super.deleteFromModel();
} 

public void displace (int xInc, int yInc)
    { 
List<Fig> figsVector;
Rectangle rFig = getBounds();
setLocation(rFig.x + xInc, rFig.y + yInc);
figsVector = ((List<Fig>) getEnclosedFigs().clone());
if(!figsVector.isEmpty())//1
{ 
for (int i = 0; i < figsVector.size(); i++) //1
{ 
((FigNodeModelElement) figsVector.get(i))
                .displace(xInc, yInc);
} 

} 

} 

protected void setBigPort(Fig bp)
    { 
this.bigPort = bp;
bindPort(getOwner(), bigPort);
} 

protected boolean isPartlyOwner(Object o)
    { 
if(o == null || o == getOwner())//1
{ 
return true;
} 

for (Object fig : getFigs()) //1
{ 
if(isPartlyOwner((Fig) fig, o))//1
{ 
return true;
} 

} 

return false;
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

public void setLineWidth(int w)
    { 
super.setLineWidth(w);
getNameFig().setLineWidth(0);
if(getStereotypeFig() != null)//1
{ 
getStereotypeFig().setLineWidth(0);
} 

} 

@Deprecated
    protected HashMap<String, Object> getNotationArguments()
    { 
return npArguments;
} 

protected Fig getRemoveDelegate()
    { 
return this;
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

@Deprecated
    protected FigNodeModelElement()
    { 
notationSettings = new NotationSettings();
bigPort = new FigRect(X0, Y0, 0, 0, DEBUG_COLOR, DEBUG_COLOR);
nameFig = new FigNameWithAbstractAndBold(X0, Y0, WIDTH, NAME_FIG_HEIGHT, true);
stereotypeFig = new FigStereotypesGroup(X0, Y0, WIDTH, STEREOHEIGHT);
constructFigs();
} 

protected void removeElementListener(Object element)
    { 
listeners.remove(new Object[] {element, null});
Model.getPump().removeModelEventListener(this, element);
} 

protected Fig getEncloser()
    { 
return encloser;
} 

public void enableSizeChecking(boolean flag)
    { 
checkSize = flag;
} 

protected void addElementListener(Object element, String[] property)
    { 
listeners.add(new Object[] {element, property});
Model.getPump().addModelEventListener(this, element, property);
} 

protected void initNotationProviders(Object own)
    { 
if(notationProviderName != null)//1
{ 
notationProviderName.cleanListener(this, own);
} 

if(Model.getFacade().isAUMLElement(own))//1
{ 
NotationName notation = Notation.findNotation(
                                        getNotationSettings().getNotationLanguage());
notationProviderName =
                NotationProviderFactory2.getInstance().getNotationProvider(
                    getNotationProviderType(), own, this,
                    notation);
} 

} 

public void renderingChanged()
    { 
initNotationProviders(getOwner());
updateNameText();
updateStereotypeText();
updateStereotypeIcon();
updateBounds();
damage();
} 

public void setVisible(boolean visible)
    { 
if(!visible && !invisibleAllowed)//1
{ 
throw new IllegalArgumentException(
                "Visibility of a FigNode should never be false");
} 

} 

public boolean isPathVisible()
    { 
return getNotationSettings().isShowPaths();
} 

@Override
    public Vector<Fig> getEnclosedFigs()
    { 
return enclosedFigs;
} 

@Deprecated
    public Project getProject()
    { 
return ArgoFigUtil.getProject(this);
} 

private int getPracticalView()
    { 
int practicalView = getStereotypeView();
Object modelElement = getOwner();
if(modelElement != null)//1
{ 
int stereotypeCount = getStereotypeCount();
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
practicalView = DiagramAppearance.STEREOTYPE_VIEW_TEXTUAL;
} 

} 

return practicalView;
} 

protected void updateFont()
    { 
int style = getNameFigFontStyle();
Font f = getSettings().getFont(style);
nameFig.setFont(f);
deepUpdateFont(this);
} 

public void setDiElement(DiElement element)
    { 
this.diElement = element;
} 

@Deprecated
    @Override
    public String classNameAndBounds()
    { 
return getClass().getName()
               + "[" + getX() + ", " + getY() + ", "
               + getWidth() + ", " + getHeight() + "]"
               + "pathVisible=" + isPathVisible() + ";"
               + "stereotypeView=" + getStereotypeView() + ";";
} 

public ItemUID getItemUID()
    { 
return itemUid;
} 

public boolean isDragConnectable()
    { 
return false;
} 

protected void addElementListener(Object element, String property)
    { 
listeners.add(new Object[] {element, property});
Model.getPump().addModelEventListener(this, element, property);
} 

protected void setEncloser(Fig e)
    { 
this.encloser = e;
} 

protected static int getPopupAddOffset()
    { 
return popupAddOffset;
} 

protected boolean isCheckSize()
    { 
return checkSize;
} 

@Deprecated
    public void notationChanged(ArgoNotationEvent event)
    { 
if(getOwner() == null)//1
{ 
return;
} 

try //1
{ 
renderingChanged();
} 
catch (Exception e) //1
{ 
LOG.error("Exception", e);
} 


} 

protected void updateLayout(UmlChangeEvent event)
    { 
assert event != null;
final Object owner = getOwner();
assert owner != null;
if(owner == null)//1
{ 
return;
} 

boolean needDamage = false;
if(event instanceof AssociationChangeEvent
                || event instanceof AttributeChangeEvent)//1
{ 
if(notationProviderName != null)//1
{ 
updateNameText();
} 

needDamage = true;
} 

if(event.getSource() == owner
                && "stereotype".equals(event.getPropertyName()))//1
{ 
updateStereotypeText();
updateStereotypeIcon();
needDamage = true;
} 

if(needDamage)//1
{ 
damage();
} 

} 

protected FigText getNameFig()
    { 
return nameFig;
} 

protected boolean isPartlyOwner(Fig fig, Object o)
    { 
if(o == null)//1
{ 
return false;
} 

if(o == fig.getOwner())//1
{ 
return true;
} 

if(fig instanceof FigGroup)//1
{ 
for (Object fig2 : ((FigGroup) fig).getFigs()) //1
{ 
if(isPartlyOwner((Fig) fig2, o))//1
{ 
return true;
} 

} 

} 

return false;
} 

public Rectangle getNameBounds()
    { 
return nameFig.getBounds();
} 

public void keyTyped(KeyEvent ke)
    { 
if(!editable || isReadOnly())//1
{ 
return;
} 

if(!readyToEdit)//1
{ 
if(Model.getFacade().isAModelElement(getOwner()))//1
{ 
Model.getCoreHelper().setName(getOwner(), "");
readyToEdit = true;
} 
else
{ 
LOG.debug("not ready to edit name");
return;
} 

} 

if(ke.isConsumed() || getOwner() == null)//1
{ 
return;
} 

nameFig.keyTyped(ke);
} 

@Deprecated
    public void notationAdded(ArgoNotationEvent event)
    { 
} 

protected void setSuppressCalcBounds(boolean scb)
    { 
this.suppressCalcBounds = scb;
} 

protected void removeFromDiagramImpl()
    { 
if(notationProviderName != null)//1
{ 
notationProviderName.cleanListener(this, getOwner());
} 

removeAllElementListeners();
setShadowSize(0);
super.removeFromDiagram();
if(getStereotypeFig() != null)//1
{ 
getStereotypeFig().removeFromDiagram();
} 

} 

private String formatEvent(PropertyChangeEvent event)
    { 
return "\n\t event = " + event.getClass().getName()
               + "\n\t source = " + event.getSource()
               + "\n\t old = " + event.getOldValue()
               + "\n\t name = " + event.getPropertyName();
} 

protected void addElementListener(Object element)
    { 
listeners.add(new Object[] {element, null});
Model.getPump().addModelEventListener(this, element);
} 

protected void textEdited(FigText ft) throws PropertyVetoException
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

if(ft instanceof CompartmentFigText)//1
{ 
final CompartmentFigText figText = (CompartmentFigText) ft;
figText.getNotationProvider().parse(ft.getOwner(), ft.getText());
ft.setText(figText.getNotationProvider().toString(
                           ft.getOwner(), getNotationSettings()));
} 

} 

@Deprecated
    public void notationRemoved(ArgoNotationEvent event)
    { 
} 

public String getName()
    { 
return nameFig.getText();
} 

protected void moveIntoComponent(Fig newEncloser)
    { 
final Object component = newEncloser.getOwner();
final Object owner = getOwner();
assert Model.getFacade().isAComponent(component);
assert Model.getFacade().isAUMLElement(owner);
final Collection er1 = Model.getFacade().getElementResidences(owner);
final Collection er2 = Model.getFacade().getResidentElements(component);
boolean found = false;
final Collection<Object> common = new ArrayList<Object>(er1);
common.retainAll(er2);
for (Object elementResidence : common) //1
{ 
if(!found)//1
{ 
found = true;
} 
else
{ 
Model.getUmlFactory().delete(elementResidence);
} 

} 

if(!found)//1
{ 
Model.getCoreFactory().buildElementResidence(
                owner, component);
} 

} 

class SelectionDefaultClarifiers extends SelectionNodeClarifiers2
  { 
private SelectionDefaultClarifiers(Fig f)
        { 
super(f);
} 

@Override
        protected boolean isReverseEdge(int index)
        { 
return false;
} 

@Override
        protected Icon[] getIcons()
        { 
return null;
} 

@Override
        protected String getInstructions(int index)
        { 
return null;
} 

@Override
        protected Object getNewEdgeType(int index)
        { 
return null;
} 

@Override
        protected Object getNewNodeType(int index)
        { 
return null;
} 

 } 

 } 


