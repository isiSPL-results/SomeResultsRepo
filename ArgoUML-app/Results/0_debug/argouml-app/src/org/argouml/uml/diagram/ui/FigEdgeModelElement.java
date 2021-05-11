
//#if -878374679 
// Compilation Unit of /FigEdgeModelElement.java 
 

//#if -2028870685 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 663378363 
import java.awt.Color;
//#endif 


//#if -114375447 
import java.awt.Font;
//#endif 


//#if -1592846419 
import java.awt.Graphics;
//#endif 


//#if 1035467054 
import java.awt.Point;
//#endif 


//#if 271819695 
import java.awt.Rectangle;
//#endif 


//#if -405936983 
import java.awt.event.KeyEvent;
//#endif 


//#if 109959487 
import java.awt.event.KeyListener;
//#endif 


//#if -2139539409 
import java.awt.event.MouseEvent;
//#endif 


//#if 1341820921 
import java.awt.event.MouseListener;
//#endif 


//#if -558577916 
import java.beans.PropertyChangeEvent;
//#endif 


//#if 1154290948 
import java.beans.PropertyChangeListener;
//#endif 


//#if -536135371 
import java.beans.VetoableChangeListener;
//#endif 


//#if 1872622790 
import java.util.HashMap;
//#endif 


//#if 1872805504 
import java.util.HashSet;
//#endif 


//#if -71885708 
import java.util.Iterator;
//#endif 


//#if -1278540348 
import java.util.List;
//#endif 


//#if 2037171410 
import java.util.Set;
//#endif 


//#if -160764929 
import java.util.Vector;
//#endif 


//#if -1862037244 
import javax.swing.Action;
//#endif 


//#if -325280031 
import javax.swing.Icon;
//#endif 


//#if -1775342913 
import javax.swing.JSeparator;
//#endif 


//#if -155928242 
import javax.swing.SwingUtilities;
//#endif 


//#if 949063546 
import org.apache.log4j.Logger;
//#endif 


//#if -1328793890 
import org.argouml.application.events.ArgoDiagramAppearanceEvent;
//#endif 


//#if 714528138 
import org.argouml.application.events.ArgoDiagramAppearanceEventListener;
//#endif 


//#if 313291027 
import org.argouml.application.events.ArgoEventPump;
//#endif 


//#if 1240378530 
import org.argouml.application.events.ArgoEventTypes;
//#endif 


//#if 164531260 
import org.argouml.application.events.ArgoHelpEvent;
//#endif 


//#if 1601623869 
import org.argouml.application.events.ArgoNotationEvent;
//#endif 


//#if 1510385385 
import org.argouml.application.events.ArgoNotationEventListener;
//#endif 


//#if -2014305274 
import org.argouml.cognitive.Designer;
//#endif 


//#if -1129012649 
import org.argouml.cognitive.Highlightable;
//#endif 


//#if 760676376 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 763132909 
import org.argouml.cognitive.ToDoList;
//#endif 


//#if -708829472 
import org.argouml.cognitive.ui.ActionGoToCritique;
//#endif 


//#if -983726937 
import org.argouml.i18n.Translator;
//#endif 


//#if 478576187 
import org.argouml.kernel.DelayedChangeNotify;
//#endif 


//#if 381215816 
import org.argouml.kernel.DelayedVChangeListener;
//#endif 


//#if 1055652093 
import org.argouml.kernel.Project;
//#endif 


//#if 417689500 
import org.argouml.model.AddAssociationEvent;
//#endif 


//#if 39301239 
import org.argouml.model.AssociationChangeEvent;
//#endif 


//#if -1832119470 
import org.argouml.model.AttributeChangeEvent;
//#endif 


//#if 760567260 
import org.argouml.model.DeleteInstanceEvent;
//#endif 


//#if -576366689 
import org.argouml.model.DiElement;
//#endif 


//#if -514982740 
import org.argouml.model.InvalidElementException;
//#endif 


//#if -1498367251 
import org.argouml.model.Model;
//#endif 


//#if 798638403 
import org.argouml.model.RemoveAssociationEvent;
//#endif 


//#if -1464522422 
import org.argouml.model.UmlChangeEvent;
//#endif 


//#if -497728733 
import org.argouml.notation.Notation;
//#endif 


//#if 1663202776 
import org.argouml.notation.NotationName;
//#endif 


//#if 382120754 
import org.argouml.notation.NotationProvider;
//#endif 


//#if -1135540054 
import org.argouml.notation.NotationProviderFactory2;
//#endif 


//#if -1841380544 
import org.argouml.notation.NotationSettings;
//#endif 


//#if 330134255 
import org.argouml.ui.ArgoJMenu;
//#endif 


//#if -396782112 
import org.argouml.ui.Clarifier;
//#endif 


//#if -1322826925 
import org.argouml.ui.ProjectActions;
//#endif 


//#if -185662123 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 1386268625 
import org.argouml.uml.StereotypeUtility;
//#endif 


//#if -1853099312 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -299090298 
import org.argouml.uml.ui.ActionDeleteModelElements;
//#endif 


//#if -1842847535 
import org.argouml.util.IItemUID;
//#endif 


//#if 1796676788 
import org.argouml.util.ItemUID;
//#endif 


//#if -972547871 
import org.tigris.gef.base.Globals;
//#endif 


//#if -1950402976 
import org.tigris.gef.base.Layer;
//#endif 


//#if 886933125 
import org.tigris.gef.base.Selection;
//#endif 


//#if -50530521 
import org.tigris.gef.persistence.pgml.PgmlUtility;
//#endif 


//#if -1417693212 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -199944921 
import org.tigris.gef.presentation.FigEdge;
//#endif 


//#if 218378427 
import org.tigris.gef.presentation.FigEdgePoly;
//#endif 


//#if -1832882253 
import org.tigris.gef.presentation.FigGroup;
//#endif 


//#if -191308414 
import org.tigris.gef.presentation.FigNode;
//#endif 


//#if -189453064 
import org.tigris.gef.presentation.FigPoly;
//#endif 


//#if -186045513 
import org.tigris.gef.presentation.FigText;
//#endif 


//#if -488368869 
public abstract class FigEdgeModelElement extends 
//#if -309607232 
FigEdgePoly
//#endif 

 implements 
//#if -1214426091 
VetoableChangeListener
//#endif 

, 
//#if -719925883 
DelayedVChangeListener
//#endif 

, 
//#if 641410348 
MouseListener
//#endif 

, 
//#if 1722531238 
KeyListener
//#endif 

, 
//#if -1436990874 
PropertyChangeListener
//#endif 

, 
//#if 1665317222 
ArgoNotationEventListener
//#endif 

, 
//#if 2115904893 
ArgoDiagramAppearanceEventListener
//#endif 

, 
//#if 27647169 
Highlightable
//#endif 

, 
//#if -1961953535 
IItemUID
//#endif 

, 
//#if -736469154 
ArgoFig
//#endif 

, 
//#if -608272353 
Clarifiable
//#endif 

  { 

//#if 1061318923 
private static final Logger LOG =
        Logger.getLogger(FigEdgeModelElement.class);
//#endif 


//#if -717355507 
private DiElement diElement = null;
//#endif 


//#if -1733943773 
private boolean removeFromDiagram = true;
//#endif 


//#if 1247218088 
private static int popupAddOffset;
//#endif 


//#if -1851236972 
private NotationProvider notationProviderName;
//#endif 


//#if 1296972886 
@Deprecated
    private HashMap<String, Object> npArguments;
//#endif 


//#if 1256299709 
private FigText nameFig;
//#endif 


//#if -26728139 
private FigStereotypesGroup stereotypeFig;
//#endif 


//#if -344384495 
private FigEdgePort edgePort;
//#endif 


//#if -734778523 
private ItemUID itemUid;
//#endif 


//#if 1453287770 
private Set<Object[]> listeners = new HashSet<Object[]>();
//#endif 


//#if 2032826840 
private DiagramSettings settings;
//#endif 


//#if -1807353620 
public void mouseReleased(MouseEvent me)
    { 
} 

//#endif 


//#if -401044398 
protected int getNameFigFontStyle()
    { 

//#if -288112685 
return Font.PLAIN;
//#endif 

} 

//#endif 


//#if 1049064709 
protected void modelAssociationRemoved(RemoveAssociationEvent rae)
    { 
} 

//#endif 


//#if 29714604 
public void mouseExited(MouseEvent me)
    { 
} 

//#endif 


//#if -2067536016 
@Override
    public void propertyChange(final PropertyChangeEvent pve)
    { 

//#if -2092316106 
Object src = pve.getSource();
//#endif 


//#if 1211027052 
String pName = pve.getPropertyName();
//#endif 


//#if -1781509130 
if(pve instanceof DeleteInstanceEvent && src == getOwner())//1
{ 

//#if -1144585602 
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
//#endif 


//#if 1468229971 
SwingUtilities.invokeLater(doWorkRunnable);
//#endif 


//#if -1411836835 
return;
//#endif 

} 

//#endif 


//#if 359937442 
if(pName.equals("editing")
                && Boolean.FALSE.equals(pve.getNewValue()))//1
{ 

//#if 1204892312 
LOG.debug("finished editing");
//#endif 


//#if -1006429329 
textEdited((FigText) src);
//#endif 


//#if -1987295977 
calcBounds();
//#endif 


//#if 520747732 
endTrans();
//#endif 

} 
else

//#if -831147909 
if(pName.equals("editing")
                   && Boolean.TRUE.equals(pve.getNewValue()))//1
{ 

//#if 1376820576 
textEditStarted((FigText) src);
//#endif 

} 
else
{ 

//#if 1288553161 
super.propertyChange(pve);
//#endif 

} 

//#endif 


//#endif 


//#if 636357168 
if(Model.getFacade().isAUMLElement(src)
                && getOwner() != null
                && !Model.getUmlFactory().isRemoved(getOwner()))//1
{ 

//#if 694841340 
modelChanged(pve);
//#endif 


//#if 896308750 
final UmlChangeEvent event = (UmlChangeEvent) pve;
//#endif 


//#if -14827976 
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
//#endif 


//#if 855197817 
SwingUtilities.invokeLater(doWorkRunnable);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 571913238 
protected int getNotationProviderType()
    { 

//#if -1775750081 
return NotationProviderFactory2.TYPE_NAME;
//#endif 

} 

//#endif 


//#if 1324159318 
protected NotationSettings getNotationSettings()
    { 

//#if 1146616004 
return getSettings().getNotationSettings();
//#endif 

} 

//#endif 


//#if 228058117 
protected void updateLayout(UmlChangeEvent event)
    { 
} 

//#endif 


//#if -1743743237 
public String getName()
    { 

//#if -1526245755 
return nameFig.getText();
//#endif 

} 

//#endif 


//#if 1578692588 
@Override
    public void damage()
    { 

//#if 218693576 
super.damage();
//#endif 


//#if 1402736060 
getFig().damage();
//#endif 

} 

//#endif 


//#if 1301242914 
public void vetoableChange(PropertyChangeEvent pce)
    { 

//#if 1934353146 
Object src = pce.getSource();
//#endif 


//#if -1485576516 
if(src == getOwner())//1
{ 

//#if -869327409 
DelayedChangeNotify delayedNotify =
                new DelayedChangeNotify(this, pce);
//#endif 


//#if -1400369216 
SwingUtilities.invokeLater(delayedNotify);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1407242602 
@Deprecated
    public FigEdgeModelElement(Object edge)
    { 

//#if 1959947804 
this();
//#endif 


//#if -1558912154 
setOwner(edge);
//#endif 

} 

//#endif 


//#if -328227817 
protected void updateNameText()
    { 

//#if -13361842 
if(getOwner() == null)//1
{ 

//#if -931367352 
return;
//#endif 

} 

//#endif 


//#if -1413564630 
if(notationProviderName != null)//1
{ 

//#if -2059125191 
String nameStr = notationProviderName.toString(
                                 getOwner(), getNotationSettings());
//#endif 


//#if -738511131 
nameFig.setText(nameStr);
//#endif 


//#if -1254897123 
updateFont();
//#endif 


//#if -641869781 
calcBounds();
//#endif 


//#if 2013836584 
setBounds(getBounds());
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1283994086 
public DiagramSettings getSettings()
    { 

//#if -1186767012 
if(settings == null)//1
{ 

//#if -1978386988 
LOG.debug("Falling back to project-wide settings");
//#endif 


//#if 72489665 
Project p = getProject();
//#endif 


//#if 1249161888 
if(p != null)//1
{ 

//#if -2034536722 
return p.getProjectSettings().getDefaultDiagramSettings();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 243554919 
return settings;
//#endif 

} 

//#endif 


//#if -331404497 
public ItemUID getItemUID()
    { 

//#if -1951417481 
return itemUid;
//#endif 

} 

//#endif 


//#if -1349697328 
public void delayedVetoableChange(PropertyChangeEvent pce)
    { 

//#if -772706193 
renderingChanged();
//#endif 


//#if -229561769 
Rectangle bbox = getBounds();
//#endif 


//#if 820042790 
setBounds(bbox.x, bbox.y, bbox.width, bbox.height);
//#endif 


//#if -554289334 
endTrans();
//#endif 

} 

//#endif 


//#if -1775875857 
protected void initNotationProviders(Object own)
    { 

//#if -1697177716 
if(notationProviderName != null)//1
{ 

//#if -725295353 
notationProviderName.cleanListener(this, own);
//#endif 

} 

//#endif 


//#if -2001874610 
if(Model.getFacade().isAModelElement(own))//1
{ 

//#if -409396528 
NotationName notation = Notation.findNotation(
                                        getNotationSettings().getNotationLanguage());
//#endif 


//#if -360830735 
notationProviderName =
                NotationProviderFactory2.getInstance().getNotationProvider(
                    getNotationProviderType(), own, this,
                    notation);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1062245463 
public FigEdgePort getEdgePort()
    { 

//#if 883908963 
return edgePort;
//#endif 

} 

//#endif 


//#if 503773826 
private void deepUpdateFontRecursive(Font f, Object pathFig)
    { 

//#if 673633535 
if(pathFig instanceof ArgoFigText)//1
{ 

//#if 764659590 
((ArgoFigText) pathFig).updateFont();
//#endif 

} 
else

//#if 1599652998 
if(pathFig instanceof FigText)//1
{ 

//#if 1304961819 
((FigText) pathFig).setFont(f);
//#endif 

} 
else

//#if -319691284 
if(pathFig instanceof FigGroup)//1
{ 

//#if -705685680 
for (Object fge : ((FigGroup) pathFig).getFigs()) //1
{ 

//#if 2000464274 
deepUpdateFontRecursive(f, fge);
//#endif 

} 

//#endif 

} 

//#endif 


//#endif 


//#endif 

} 

//#endif 


//#if 225395568 
@Deprecated
    public void notationProviderRemoved(ArgoNotationEvent event)
    { 
} 

//#endif 


//#if -858527517 
private void deepUpdateFont(FigEdge fe)
    { 

//#if 800996156 
Font f = getSettings().getFont(Font.PLAIN);
//#endif 


//#if 480151378 
for (Object pathFig : fe.getPathItemFigs()) //1
{ 

//#if -3626736 
deepUpdateFontRecursive(f, pathFig);
//#endif 

} 

//#endif 


//#if 1392847299 
fe.calcBounds();
//#endif 

} 

//#endif 


//#if -900682881 
private boolean isReadOnly()
    { 

//#if -978047152 
Object owner = getOwner();
//#endif 


//#if -1049770992 
if(Model.getFacade().isAUMLElement(owner))//1
{ 

//#if 1183316934 
return Model.getModelManagementHelper().isReadOnly(owner);
//#endif 

} 

//#endif 


//#if -1017948052 
return false;
//#endif 

} 

//#endif 


//#if -33641157 

//#if 1192266754 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public void setProject(Project project)
    { 

//#if -2018008450 
throw new UnsupportedOperationException();
//#endif 

} 

//#endif 


//#if 1658991483 
@Override
    public Selection makeSelection()
    { 

//#if 123597703 
return new SelectionRerouteEdge(this);
//#endif 

} 

//#endif 


//#if -1521062390 
private void initFigs()
    { 

//#if -2112685780 
nameFig.setTextFilled(false);
//#endif 


//#if -542688086 
setBetweenNearestPoints(true);
//#endif 

} 

//#endif 


//#if -1843706988 
protected FigText getNameFig()
    { 

//#if -76933537 
return nameFig;
//#endif 

} 

//#endif 


//#if -398895127 
public ToDoItem hitClarifier(int x, int y)
    { 

//#if -1485080274 
int iconPos = 25, xOff = -4, yOff = -4;
//#endif 


//#if 880193655 
Point p = new Point();
//#endif 


//#if 1761942963 
ToDoList tdList = Designer.theDesigner().getToDoList();
//#endif 


//#if 454815998 
List<ToDoItem> items = tdList.elementListForOffender(getOwner());
//#endif 


//#if -2036957661 
for (ToDoItem item : items) //1
{ 

//#if -1562232827 
Icon icon = item.getClarifier();
//#endif 


//#if 378239425 
stuffPointAlongPerimeter(iconPos, p);
//#endif 


//#if 959245016 
int width = icon.getIconWidth();
//#endif 


//#if -1721588426 
int height = icon.getIconHeight();
//#endif 


//#if -1025013490 
if(y >= p.y + yOff
                    && y <= p.y + height + yOff
                    && x >= p.x + xOff
                    && x <= p.x + width + xOff)//1
{ 

//#if 830466461 
return item;
//#endif 

} 

//#endif 


//#if -1544240698 
iconPos += width;
//#endif 

} 

//#endif 


//#if 587322798 
for (ToDoItem item : items) //2
{ 

//#if 964141320 
Icon icon = item.getClarifier();
//#endif 


//#if 983100656 
if(icon instanceof Clarifier)//1
{ 

//#if -357920832 
((Clarifier) icon).setFig(this);
//#endif 


//#if 144713896 
((Clarifier) icon).setToDoItem(item);
//#endif 


//#if 467736262 
if(((Clarifier) icon).hit(x, y))//1
{ 

//#if 1047344859 
return item;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1505735561 
items = tdList.elementListForOffender(this);
//#endif 


//#if 587352590 
for (ToDoItem item : items) //3
{ 

//#if -368212851 
Icon icon = item.getClarifier();
//#endif 


//#if -2114812871 
stuffPointAlongPerimeter(iconPos, p);
//#endif 


//#if -2141702304 
int width = icon.getIconWidth();
//#endif 


//#if -1024659522 
int height = icon.getIconHeight();
//#endif 


//#if 1101395334 
if(y >= p.y + yOff
                    && y <= p.y + height + yOff
                    && x >= p.x + xOff
                    && x <= p.x + width + xOff)//1
{ 

//#if -1677845381 
return item;
//#endif 

} 

//#endif 


//#if -1154147250 
iconPos += width;
//#endif 

} 

//#endif 


//#if 587382382 
for (ToDoItem item : items) //4
{ 

//#if 1559423899 
Icon icon = item.getClarifier();
//#endif 


//#if -2037975875 
if(icon instanceof Clarifier)//1
{ 

//#if 1108383814 
((Clarifier) icon).setFig(this);
//#endif 


//#if -328694814 
((Clarifier) icon).setToDoItem(item);
//#endif 


//#if 837227980 
if(((Clarifier) icon).hit(x, y))//1
{ 

//#if 585020011 
return item;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1926556326 
return null;
//#endif 

} 

//#endif 


//#if -344167484 
@Override
    public final void removeFromDiagram()
    { 

//#if 1294947667 
Fig delegate = getRemoveDelegate();
//#endif 


//#if -882037911 
if(delegate instanceof FigNodeModelElement)//1
{ 

//#if 1083864043 
((FigNodeModelElement) delegate).removeFromDiagramImpl();
//#endif 

} 
else

//#if -273681462 
if(delegate instanceof FigEdgeModelElement)//1
{ 

//#if 725096564 
((FigEdgeModelElement) delegate).removeFromDiagramImpl();
//#endif 

} 
else

//#if 1020948953 
if(delegate != null)//1
{ 

//#if 1935138462 
removeFromDiagramImpl();
//#endif 

} 

//#endif 


//#endif 


//#endif 

} 

//#endif 


//#if 1846763299 
@Override
    public String getTipString(MouseEvent me)
    { 

//#if -1693072999 
ToDoItem item = hitClarifier(me.getX(), me.getY());
//#endif 


//#if -1207448941 
String tip = "";
//#endif 


//#if 1419862256 
if(item != null
                && Globals.curEditor().getSelectionManager().containsFig(this))//1
{ 

//#if -1346676717 
tip = item.getHeadline();
//#endif 

} 
else

//#if 1409989834 
if(getOwner() != null)//1
{ 

//#if 285502138 
try //1
{ 

//#if -1941793514 
tip = Model.getFacade().getTipString(getOwner());
//#endif 

} 

//#if 908743230 
catch (InvalidElementException e) //1
{ 

//#if 188658900 
LOG.warn("A deleted element still exists on the diagram");
//#endif 


//#if 1252895534 
return Translator.localize("misc.name.deleted");
//#endif 

} 

//#endif 


//#endif 

} 
else
{ 

//#if 274906871 
tip = toString();
//#endif 

} 

//#endif 


//#endif 


//#if 1185957479 
if(tip != null && tip.length() > 0 && !tip.endsWith(" "))//1
{ 

//#if 139975579 
tip += " ";
//#endif 

} 

//#endif 


//#if 1305303525 
return tip;
//#endif 

} 

//#endif 


//#if 99629041 
@Override
    public boolean hit(Rectangle r)
    { 

//#if -1764506089 
Iterator it = getPathItemFigs().iterator();
//#endif 


//#if -843280215 
while (it.hasNext()) //1
{ 

//#if -521065539 
Fig f = (Fig) it.next();
//#endif 


//#if 2146471264 
if(f.hit(r))//1
{ 

//#if 413863011 
return true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1930504787 
return super.hit(r);
//#endif 

} 

//#endif 


//#if -1986502301 
public DiElement getDiElement()
    { 

//#if -1237871856 
return diElement;
//#endif 

} 

//#endif 


//#if -739534175 
@Deprecated
    public void notationRemoved(ArgoNotationEvent event)
    { 
} 

//#endif 


//#if -2003257177 
public void setSettings(DiagramSettings renderSettings)
    { 

//#if -1738178036 
settings = renderSettings;
//#endif 


//#if 1065842446 
renderingChanged();
//#endif 

} 

//#endif 


//#if -1639000383 
public void keyTyped(KeyEvent ke)
    { 

//#if 1336724752 
if(!ke.isConsumed()
                && !isReadOnly()
                && nameFig != null
                && canEdit(nameFig))//1
{ 

//#if -25059537 
nameFig.keyTyped(ke);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -200086671 
protected void removeFromDiagramImpl()
    { 

//#if 1954986976 
Object o = getOwner();
//#endif 


//#if -840054305 
if(o != null)//1
{ 

//#if 884923358 
removeElementListener(o);
//#endif 

} 

//#endif 


//#if 1917206276 
if(notationProviderName != null)//1
{ 

//#if 415964981 
notationProviderName.cleanListener(this, getOwner());
//#endif 

} 

//#endif 


//#if 1014927784 
Iterator it = getPathItemFigs().iterator();
//#endif 


//#if -1753035142 
while (it.hasNext()) //1
{ 

//#if -529778556 
Fig fig = (Fig) it.next();
//#endif 


//#if -731057009 
fig.removeFromDiagram();
//#endif 

} 

//#endif 


//#if -1818167528 
super.removeFromDiagram();
//#endif 


//#if 688509851 
damage();
//#endif 

} 

//#endif 


//#if 1863730862 
@Deprecated
    public Project getProject()
    { 

//#if -608922150 
return ArgoFigUtil.getProject(this);
//#endif 

} 

//#endif 


//#if -523426837 
private Fig getNoEdgePresentationFor(Object element)
    { 

//#if -1297493426 
if(element == null)//1
{ 

//#if 124031176 
throw new IllegalArgumentException("Can't search for a null owner");
//#endif 

} 

//#endif 


//#if -1921364094 
List contents = PgmlUtility.getContentsNoEdges(getLayer());
//#endif 


//#if 112698998 
int figCount = contents.size();
//#endif 


//#if -1368674128 
for (int figIndex = 0; figIndex < figCount; ++figIndex) //1
{ 

//#if -1926173612 
Fig fig = (Fig) contents.get(figIndex);
//#endif 


//#if -1740423885 
if(fig.getOwner() == element)//1
{ 

//#if 1639399696 
return fig;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 796940544 
throw new IllegalStateException("Can't find a FigNode representing "
                                        + Model.getFacade().getName(element));
//#endif 

} 

//#endif 


//#if 1804516764 
protected void showHelp(String s)
    { 

//#if 353230121 
ArgoEventPump.fireEvent(new ArgoHelpEvent(
                                    ArgoEventTypes.HELP_CHANGED, this,
                                    Translator.localize(s)));
//#endif 

} 

//#endif 


//#if -400164814 
protected void allowRemoveFromDiagram(boolean allowed)
    { 

//#if 1551192106 
this.removeFromDiagram = allowed;
//#endif 

} 

//#endif 


//#if -184480368 
protected void addElementListener(Object element, String property)
    { 

//#if -863123800 
listeners.add(new Object[] {element, property});
//#endif 


//#if 152072445 
Model.getPump().addModelEventListener(this, element, property);
//#endif 

} 

//#endif 


//#if -1522900528 
public void mouseEntered(MouseEvent me)
    { 
} 

//#endif 


//#if 1790735302 
@Deprecated
    public FigEdgeModelElement()
    { 

//#if 1112127457 
nameFig = new FigNameWithAbstract(X0, Y0 + 20, 90, 20, false);
//#endif 


//#if -182060151 
stereotypeFig = new FigStereotypesGroup(X0, Y0, 90, 15);
//#endif 


//#if -1526178623 
initFigs();
//#endif 

} 

//#endif 


//#if 323735346 
protected Object getSource()
    { 

//#if 822732333 
Object owner = getOwner();
//#endif 


//#if -1490166662 
if(owner != null)//1
{ 

//#if 801451025 
return Model.getCoreHelper().getSource(owner);
//#endif 

} 

//#endif 


//#if -1104835971 
return null;
//#endif 

} 

//#endif 


//#if 1577913182 
public void keyReleased(KeyEvent ke)
    { 
} 

//#endif 


//#if -1648602873 
protected void textEdited(FigText ft)
    { 

//#if 1545480330 
if(ft == nameFig)//1
{ 

//#if 1051199997 
if(getOwner() == null)//1
{ 

//#if 42292416 
return;
//#endif 

} 

//#endif 


//#if 518248058 
notationProviderName.parse(getOwner(), ft.getText());
//#endif 


//#if 630488611 
ft.setText(notationProviderName.toString(getOwner(),
                       getNotationSettings()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2026191937 
protected void indicateBounds(FigText f, Graphics g)
    { 
} 

//#endif 


//#if 1802697721 
@Deprecated
    protected HashMap<String, Object> getNotationArguments()
    { 

//#if 53210308 
return npArguments;
//#endif 

} 

//#endif 


//#if -386860690 
protected void addElementListener(Object element, String[] property)
    { 

//#if 788441765 
listeners.add(new Object[] {element, property});
//#endif 


//#if -482624774 
Model.getPump().addModelEventListener(this, element, property);
//#endif 

} 

//#endif 


//#if 387789082 
protected boolean determineFigNodes()
    { 

//#if -887421568 
Object owner = getOwner();
//#endif 


//#if -1815243605 
if(owner == null)//1
{ 

//#if -1532645625 
LOG.error("The FigEdge has no owner");
//#endif 


//#if -782420133 
return false;
//#endif 

} 

//#endif 


//#if 2084323618 
if(getLayer() == null)//1
{ 

//#if 271849917 
LOG.error("The FigEdge has no layer");
//#endif 


//#if -1602635665 
return false;
//#endif 

} 

//#endif 


//#if 1976512286 
Object newSource = getSource();
//#endif 


//#if 127268916 
Object newDest = getDestination();
//#endif 


//#if -1534706104 
Fig currentSourceFig = getSourceFigNode();
//#endif 


//#if 923740136 
Fig currentDestFig = getDestFigNode();
//#endif 


//#if -539948904 
Object currentSource = null;
//#endif 


//#if -915484801 
Object currentDestination = null;
//#endif 


//#if 1309223070 
if(currentSourceFig != null && currentDestFig != null)//1
{ 

//#if -451970485 
currentSource = currentSourceFig.getOwner();
//#endif 


//#if -460277507 
currentDestination = currentDestFig.getOwner();
//#endif 

} 

//#endif 


//#if -608030745 
if(newSource != currentSource || newDest != currentDestination)//1
{ 

//#if -1282098034 
Fig newSourceFig = getNoEdgePresentationFor(newSource);
//#endif 


//#if -1017962148 
Fig newDestFig = getNoEdgePresentationFor(newDest);
//#endif 


//#if -1533929526 
if(newSourceFig != currentSourceFig)//1
{ 

//#if 1678681094 
setSourceFigNode((FigNode) newSourceFig);
//#endif 


//#if -1385188674 
setSourcePortFig(newSourceFig);
//#endif 

} 

//#endif 


//#if -350333316 
if(newDestFig != currentDestFig)//1
{ 

//#if -950625922 
setDestFigNode((FigNode) newDestFig);
//#endif 


//#if -1770181224 
setDestPortFig(newDestFig);
//#endif 

} 

//#endif 


//#if -713435364 
((FigNode) newSourceFig).updateEdges();
//#endif 


//#if 1478984053 
((FigNode) newDestFig).updateEdges();
//#endif 


//#if 1084903410 
calcBounds();
//#endif 


//#if -1931292544 
if(newSourceFig == newDestFig)//1
{ 

//#if -614418828 
layoutThisToSelf();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1314397993 
return true;
//#endif 

} 

//#endif 


//#if -2033309544 
public void setLineColor(Color c)
    { 

//#if -98684938 
super.setLineColor(c);
//#endif 

} 

//#endif 


//#if -980894499 
protected void updateListeners(Object oldOwner, Object newOwner)
    { 

//#if -906240952 
Set<Object[]> l = new HashSet<Object[]>();
//#endif 


//#if 1646908722 
if(newOwner != null)//1
{ 

//#if -1893002782 
l.add(new Object[] {newOwner, "remove"});
//#endif 

} 

//#endif 


//#if 1408631897 
updateElementListeners(l);
//#endif 

} 

//#endif 


//#if -87482963 
public void paintClarifiers(Graphics g)
    { 

//#if -1650318018 
int iconPos = 25, gap = 1, xOff = -4, yOff = -4;
//#endif 


//#if -681644795 
Point p = new Point();
//#endif 


//#if 723039937 
ToDoList tdList = Designer.theDesigner().getToDoList();
//#endif 


//#if 1959137420 
List<ToDoItem> items = tdList.elementListForOffender(getOwner());
//#endif 


//#if 158878897 
for (ToDoItem item : items) //1
{ 

//#if -589024564 
Icon icon = item.getClarifier();
//#endif 


//#if 79598508 
if(icon instanceof Clarifier)//1
{ 

//#if 1198264581 
((Clarifier) icon).setFig(this);
//#endif 


//#if 325429891 
((Clarifier) icon).setToDoItem(item);
//#endif 

} 

//#endif 


//#if 737495866 
if(icon != null)//1
{ 

//#if 1624025449 
stuffPointAlongPerimeter(iconPos, p);
//#endif 


//#if 523211444 
icon.paintIcon(null, g, p.x + xOff, p.y + yOff);
//#endif 


//#if -1572129492 
iconPos += icon.getIconWidth() + gap;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1241563387 
items = tdList.elementListForOffender(this);
//#endif 


//#if 107336800 
for (ToDoItem item : items) //2
{ 

//#if 242620445 
Icon icon = item.getClarifier();
//#endif 


//#if 90790011 
if(icon instanceof Clarifier)//1
{ 

//#if 1184785336 
((Clarifier) icon).setFig(this);
//#endif 


//#if -498462800 
((Clarifier) icon).setToDoItem(item);
//#endif 

} 

//#endif 


//#if 1035985419 
if(icon != null)//1
{ 

//#if -30232525 
stuffPointAlongPerimeter(iconPos, p);
//#endif 


//#if -2024785366 
icon.paintIcon(null, g, p.x + xOff, p.y + yOff);
//#endif 


//#if -894586206 
iconPos += icon.getIconWidth() + gap;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1761364738 
protected void updateStereotypeText()
    { 

//#if 1230657705 
if(getOwner() == null)//1
{ 

//#if 228186139 
return;
//#endif 

} 

//#endif 


//#if 874828833 
Object modelElement = getOwner();
//#endif 


//#if 476909189 
stereotypeFig.populate();
//#endif 

} 

//#endif 


//#if -885256905 
protected void updateElementListeners(Set<Object[]> listenerSet)
    { 

//#if -1509449399 
Set<Object[]> removes = new HashSet<Object[]>(listeners);
//#endif 


//#if -1011608784 
removes.removeAll(listenerSet);
//#endif 


//#if -748455386 
removeElementListeners(removes);
//#endif 


//#if -614951653 
Set<Object[]> adds = new HashSet<Object[]>(listenerSet);
//#endif 


//#if -147664400 
adds.removeAll(listeners);
//#endif 


//#if 564365902 
addElementListeners(adds);
//#endif 

} 

//#endif 


//#if -933927703 
@Deprecated
    @Override
    public void setOwner(Object owner)
    { 

//#if -866023429 
if(owner == null)//1
{ 

//#if 1582155031 
throw new IllegalArgumentException("An owner must be supplied");
//#endif 

} 

//#endif 


//#if -1715692848 
if(getOwner() != null)//1
{ 

//#if 340911875 
throw new IllegalStateException(
                "The owner cannot be changed once set");
//#endif 

} 

//#endif 


//#if 835060643 
if(!Model.getFacade().isAUMLElement(owner))//1
{ 

//#if 1417716032 
throw new IllegalArgumentException(
                "The owner must be a model element - got a "
                + owner.getClass().getName());
//#endif 

} 

//#endif 


//#if -1439628187 
super.setOwner(owner);
//#endif 


//#if 1605729575 
nameFig.setOwner(owner);
//#endif 


//#if 1856797104 
if(edgePort != null)//1
{ 

//#if -1276902100 
edgePort.setOwner(getOwner());
//#endif 

} 

//#endif 


//#if 947476814 
stereotypeFig.setOwner(owner);
//#endif 


//#if 1036918569 
initNotationProviders(owner);
//#endif 


//#if 8234838 
updateListeners(null, owner);
//#endif 

} 

//#endif 


//#if 1204450631 
private void removeElementListeners(Set<Object[]> listenerSet)
    { 

//#if -2085416740 
for (Object[] listener : listenerSet) //1
{ 

//#if 657887725 
Object property = listener[1];
//#endif 


//#if -1129278293 
if(property == null)//1
{ 

//#if 1057152545 
Model.getPump().removeModelEventListener(this, listener[0]);
//#endif 

} 
else

//#if -1784326342 
if(property instanceof String[])//1
{ 

//#if 963008364 
Model.getPump().removeModelEventListener(this, listener[0],
                        (String[]) property);
//#endif 

} 
else

//#if 124900572 
if(property instanceof String)//1
{ 

//#if 1240954576 
Model.getPump().removeModelEventListener(this, listener[0],
                        (String) property);
//#endif 

} 
else
{ 

//#if -1813417812 
throw new RuntimeException(
                    "Internal error in removeAllElementListeners");
//#endif 

} 

//#endif 


//#endif 


//#endif 

} 

//#endif 


//#if -518432614 
listeners.removeAll(listenerSet);
//#endif 

} 

//#endif 


//#if -1158728867 
protected void textEditStarted(FigText ft)
    { 

//#if -1792203923 
if(ft == getNameFig())//1
{ 

//#if 1418109119 
showHelp(notationProviderName.getParsingHelp());
//#endif 


//#if -910554893 
ft.setText(notationProviderName.toString(getOwner(),
                       getNotationSettings()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1495840885 
public void setFig(Fig f)
    { 

//#if -1633443707 
super.setFig(f);
//#endif 


//#if -2127143105 
f.setLineColor(getLineColor());
//#endif 


//#if 1484826655 
f.setLineWidth(getLineWidth());
//#endif 

} 

//#endif 


//#if -1342643288 
public void setItemUID(ItemUID newId)
    { 

//#if -244160305 
itemUid = newId;
//#endif 

} 

//#endif 


//#if 1390366621 
protected void removeElementListener(Object element)
    { 

//#if -1426567876 
listeners.remove(new Object[] {element, null});
//#endif 


//#if 787330552 
Model.getPump().removeModelEventListener(this, element);
//#endif 

} 

//#endif 


//#if 1332309505 
@Deprecated
    public void notationAdded(ArgoNotationEvent event)
    { 
} 

//#endif 


//#if -563633031 
@Override
    public void deleteFromModel()
    { 

//#if -967431848 
Object own = getOwner();
//#endif 


//#if -289494731 
if(own != null)//1
{ 

//#if 1429457387 
getProject().moveToTrash(own);
//#endif 

} 

//#endif 


//#if -1119950105 
Iterator it = getPathItemFigs().iterator();
//#endif 


//#if -1883879047 
while (it.hasNext()) //1
{ 

//#if -276518541 
((Fig) it.next()).deleteFromModel();
//#endif 

} 

//#endif 


//#if -2053787864 
super.deleteFromModel();
//#endif 

} 

//#endif 


//#if -771962565 
public void mousePressed(MouseEvent me)
    { 
} 

//#endif 


//#if -464435866 
protected int getSquaredDistance(Point p1, Point p2)
    { 

//#if 311439263 
int xSquared = p2.x - p1.x;
//#endif 


//#if -1622098055 
xSquared *= xSquared;
//#endif 


//#if 354471104 
int ySquared = p2.y - p1.y;
//#endif 


//#if 20942907 
ySquared *= ySquared;
//#endif 


//#if 1477611986 
return xSquared + ySquared;
//#endif 

} 

//#endif 


//#if 1600341536 
@Deprecated
    protected void putNotationArgument(String key, Object element)
    { 

//#if 931891297 
if(notationProviderName != null)//1
{ 

//#if -440968901 
if(npArguments == null)//1
{ 

//#if -1005490129 
npArguments = new HashMap<String, Object>();
//#endif 

} 

//#endif 


//#if -438984501 
npArguments.put(key, element);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1777597985 
protected static int getPopupAddOffset()
    { 

//#if 312986397 
return popupAddOffset;
//#endif 

} 

//#endif 


//#if -656948848 
protected void modelAttributeChanged(AttributeChangeEvent ace)
    { 
} 

//#endif 


//#if 708527872 
protected void superRemoveFromDiagram()
    { 

//#if -52789256 
super.removeFromDiagram();
//#endif 

} 

//#endif 


//#if -1256416023 
protected void modelAssociationAdded(AddAssociationEvent aae)
    { 
} 

//#endif 


//#if 211024958 
protected FigEdgeModelElement(Object element,
                                  DiagramSettings renderSettings)
    { 

//#if -1416378102 
super();
//#endif 


//#if -289759021 
settings = renderSettings;
//#endif 


//#if -2051078649 
super.setLineColor(LINE_COLOR);
//#endif 


//#if -158682585 
super.setLineWidth(LINE_WIDTH);
//#endif 


//#if 1985123985 
getFig().setLineColor(LINE_COLOR);
//#endif 


//#if -417447247 
getFig().setLineWidth(LINE_WIDTH);
//#endif 


//#if 1808342513 
nameFig = new FigNameWithAbstract(element,
                                          new Rectangle(X0, Y0 + 20, 90, 20),
                                          renderSettings, false);
//#endif 


//#if -1229576617 
stereotypeFig = new FigStereotypesGroup(element,
                                                new Rectangle(X0, Y0, 90, 15),
                                                settings);
//#endif 


//#if -2027013648 
initFigs();
//#endif 


//#if 761735646 
initOwner(element);
//#endif 

} 

//#endif 


//#if -1010935970 
protected FigStereotypesGroup getStereotypeFig()
    { 

//#if -985339182 
return stereotypeFig;
//#endif 

} 

//#endif 


//#if 2125632720 
@Override
    public Vector getPopUpActions(MouseEvent me)
    { 

//#if 990120174 
ActionList popUpActions =
            new ActionList(super.getPopUpActions(me), isReadOnly());
//#endif 


//#if -290854314 
popUpActions.add(new JSeparator());
//#endif 


//#if -1478341517 
popupAddOffset = 1;
//#endif 


//#if -702926386 
if(removeFromDiagram)//1
{ 

//#if 874713077 
popUpActions.add(
                ProjectActions.getInstance().getRemoveFromDiagramAction());
//#endif 


//#if -681612642 
popupAddOffset++;
//#endif 

} 

//#endif 


//#if -291826070 
popUpActions.add(new ActionDeleteModelElements());
//#endif 


//#if -1478359001 
popupAddOffset++;
//#endif 


//#if 1075291401 
if(TargetManager.getInstance().getTargets().size() == 1)//1
{ 

//#if 1571691326 
ToDoList list = Designer.theDesigner().getToDoList();
//#endif 


//#if 314305737 
List<ToDoItem> items = list.elementListForOffender(getOwner());
//#endif 


//#if 1918105735 
if(items != null && items.size() > 0)//1
{ 

//#if -1928627420 
ArgoJMenu critiques = new ArgoJMenu("menu.popup.critiques");
//#endif 


//#if -551126357 
ToDoItem itemUnderMouse = hitClarifier(me.getX(), me.getY());
//#endif 


//#if 1160394880 
if(itemUnderMouse != null)//1
{ 

//#if 1156235007 
critiques.add(new ActionGoToCritique(itemUnderMouse));
//#endif 


//#if -1741400386 
critiques.addSeparator();
//#endif 

} 

//#endif 


//#if -559543889 
for (ToDoItem item : items) //1
{ 

//#if -1970501893 
if(item == itemUnderMouse)//1
{ 

//#if -1503316334 
continue;
//#endif 

} 

//#endif 


//#if -1126646548 
critiques.add(new ActionGoToCritique(item));
//#endif 

} 

//#endif 


//#if 1429131844 
popUpActions.add(0, new JSeparator());
//#endif 


//#if 76253193 
popUpActions.add(0, critiques);
//#endif 

} 

//#endif 


//#if -1325154308 
Action[] stereoActions = getApplyStereotypeActions();
//#endif 


//#if -1161800821 
if(stereoActions != null && stereoActions.length > 0)//1
{ 

//#if -885491304 
popUpActions.add(0, new JSeparator());
//#endif 


//#if -1957981897 
ArgoJMenu stereotypes = new ArgoJMenu(
                    "menu.popup.apply-stereotypes");
//#endif 


//#if 31314269 
for (int i = 0; i < stereoActions.length; ++i) //1
{ 

//#if 1535092230 
stereotypes.addCheckItem(stereoActions[i]);
//#endif 

} 

//#endif 


//#if -442854595 
popUpActions.add(0, stereotypes);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1699527470 
return popUpActions;
//#endif 

} 

//#endif 


//#if -631875559 
@Override
    public void setLayer(Layer lay)
    { 

//#if 2088929875 
super.setLayer(lay);
//#endif 


//#if 1581312537 
getFig().setLayer(lay);
//#endif 


//#if 823593539 
for (Fig f : (List<Fig>) getPathItemFigs()) //1
{ 

//#if 992187463 
f.setLayer(lay);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -958280197 
protected Action[] getApplyStereotypeActions()
    { 

//#if 294306585 
return StereotypeUtility.getApplyStereotypeActions(getOwner());
//#endif 

} 

//#endif 


//#if -697457168 
protected void addElementListener(Object element)
    { 

//#if 2109555882 
listeners.add(new Object[] {element, null});
//#endif 


//#if -1628215436 
Model.getPump().addModelEventListener(this, element);
//#endif 

} 

//#endif 


//#if 1212112531 
public void renderingChanged()
    { 

//#if 264029751 
initNotationProviders(getOwner());
//#endif 


//#if 1162820202 
updateNameText();
//#endif 


//#if 1485349347 
updateStereotypeText();
//#endif 


//#if 1281045372 
damage();
//#endif 

} 

//#endif 


//#if 1148650258 
protected boolean canEdit(Fig f)
    { 

//#if 1350859152 
return true;
//#endif 

} 

//#endif 


//#if -377643686 
private void layoutThisToSelf()
    { 

//#if -1215935894 
FigPoly edgeShape = new FigPoly();
//#endif 


//#if 268271567 
Point fcCenter =
            new Point(getSourceFigNode().getX() / 2,
                      getSourceFigNode().getY() / 2);
//#endif 


//#if 748741574 
Point centerRight =
            new Point(
            (int) (fcCenter.x
                   + getSourceFigNode().getSize().getWidth() / 2),
            fcCenter.y);
//#endif 


//#if 1700954301 
int yoffset = (int) ((getSourceFigNode().getSize().getHeight() / 2));
//#endif 


//#if -194594439 
edgeShape.addPoint(fcCenter.x, fcCenter.y);
//#endif 


//#if 2086685571 
edgeShape.addPoint(centerRight.x, centerRight.y);
//#endif 


//#if 1065774229 
edgeShape.addPoint(centerRight.x + 30, centerRight.y);
//#endif 


//#if 675634454 
edgeShape.addPoint(centerRight.x + 30, centerRight.y + yoffset);
//#endif 


//#if -1409257980 
edgeShape.addPoint(centerRight.x, centerRight.y + yoffset);
//#endif 


//#if -454051980 
this.setBetweenNearestPoints(true);
//#endif 


//#if -1168518926 
edgeShape.setLineColor(LINE_COLOR);
//#endif 


//#if -194049890 
edgeShape.setFilled(false);
//#endif 


//#if -843849952 
edgeShape.setComplete(true);
//#endif 


//#if 399240279 
this.setFig(edgeShape);
//#endif 

} 

//#endif 


//#if -1034961929 
public void makeEdgePort()
    { 

//#if -2003720720 
if(edgePort == null)//1
{ 

//#if 1250886702 
edgePort = new FigEdgePort(getOwner(), new Rectangle(),
                                       getSettings());
//#endif 


//#if -1742454556 
edgePort.setVisible(false);
//#endif 


//#if -1166642729 
addPathItem(edgePort,
                        new PathItemPlacement(this, edgePort, 50, 0));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 270374513 
protected void modelChanged(PropertyChangeEvent e)
    { 

//#if 1034867456 
if(e instanceof DeleteInstanceEvent)//1
{ 

//#if 1828447776 
return;
//#endif 

} 

//#endif 


//#if -1175350148 
if(e instanceof AssociationChangeEvent
                || e instanceof AttributeChangeEvent)//1
{ 

//#if -669748427 
if(notationProviderName != null)//1
{ 

//#if 336209262 
notationProviderName.updateListener(this, getOwner(), e);
//#endif 


//#if -1750547061 
updateNameText();
//#endif 

} 

//#endif 


//#if 114911853 
updateListeners(getOwner(), getOwner());
//#endif 

} 

//#endif 


//#if 558875222 
determineFigNodes();
//#endif 

} 

//#endif 


//#if 800032697 
public void keyPressed(KeyEvent ke)
    { 
} 

//#endif 


//#if 744503931 
private void initOwner(Object element)
    { 

//#if 1972557995 
if(element != null)//1
{ 

//#if -792906002 
if(!Model.getFacade().isAUMLElement(element))//1
{ 

//#if -755217661 
throw new IllegalArgumentException(
                    "The owner must be a model element - got a "
                    + element.getClass().getName());
//#endif 

} 

//#endif 


//#if -447371870 
super.setOwner(element);
//#endif 


//#if 889125092 
nameFig.setOwner(element);
//#endif 


//#if -448613636 
if(edgePort != null)//1
{ 

//#if 989402336 
edgePort.setOwner(getOwner());
//#endif 

} 

//#endif 


//#if 1969221707 
stereotypeFig.setOwner(element);
//#endif 


//#if 1291932981 
notationProviderName =
                NotationProviderFactory2.getInstance().getNotationProvider(
                    getNotationProviderType(), element, this);
//#endif 


//#if 1974119519 
addElementListener(element, "remove");
//#endif 

} 

//#endif 

} 

//#endif 


//#if 682213504 
public void mouseClicked(MouseEvent me)
    { 

//#if 1483478633 
if(!me.isConsumed() && !isReadOnly() && me.getClickCount() >= 2)//1
{ 

//#if -1044952722 
Fig f = hitFig(new Rectangle(me.getX() - 2, me.getY() - 2, 4, 4));
//#endif 


//#if 431143586 
if(f instanceof MouseListener && canEdit(f))//1
{ 

//#if -2128071995 
((MouseListener) f).mouseClicked(me);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 876098277 
me.consume();
//#endif 

} 

//#endif 


//#if 84426843 
public void setDiElement(DiElement element)
    { 

//#if 1424727254 
this.diElement = element;
//#endif 

} 

//#endif 


//#if 1610492149 
@Deprecated
    public void notationChanged(ArgoNotationEvent event)
    { 

//#if -1168016741 
if(getOwner() == null)//1
{ 

//#if -1973184727 
return;
//#endif 

} 

//#endif 


//#if 2041628757 
renderingChanged();
//#endif 

} 

//#endif 


//#if 1699612254 
public Rectangle getNameBounds()
    { 

//#if -2029264611 
return nameFig.getBounds();
//#endif 

} 

//#endif 


//#if -1665378292 
protected void removeAllElementListeners()
    { 

//#if -1549363661 
removeElementListeners(listeners);
//#endif 

} 

//#endif 


//#if 470744720 
@Deprecated
    public void notationProviderAdded(ArgoNotationEvent event)
    { 
} 

//#endif 


//#if -1174727047 
protected Object getDestination()
    { 

//#if 1189648119 
Object owner = getOwner();
//#endif 


//#if 1394759024 
if(owner != null)//1
{ 

//#if -1849696306 
return Model.getCoreHelper().getDestination(owner);
//#endif 

} 

//#endif 


//#if 1245682247 
return null;
//#endif 

} 

//#endif 


//#if 1704600336 
private void addElementListeners(Set<Object[]> listenerSet)
    { 

//#if -1273747360 
for (Object[] listener : listenerSet) //1
{ 

//#if 425856034 
Object property = listener[1];
//#endif 


//#if 717036192 
if(property == null)//1
{ 

//#if 750259903 
addElementListener(listener[0]);
//#endif 

} 
else

//#if 1914227731 
if(property instanceof String[])//1
{ 

//#if -23479318 
addElementListener(listener[0], (String[]) property);
//#endif 

} 
else

//#if 730111548 
if(property instanceof String)//1
{ 

//#if -778916090 
addElementListener(listener[0], (String) property);
//#endif 

} 
else
{ 

//#if -609582107 
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


//#if 1404035389 
protected Fig getRemoveDelegate()
    { 

//#if 1607692277 
return this;
//#endif 

} 

//#endif 


//#if 480459731 
@Deprecated
    public void diagramFontChanged(ArgoDiagramAppearanceEvent e)
    { 

//#if 1715344189 
updateFont();
//#endif 


//#if -1966595765 
calcBounds();
//#endif 


//#if 925032222 
redraw();
//#endif 

} 

//#endif 


//#if -1043978418 
protected void updateFont()
    { 

//#if 1867870128 
int style = getNameFigFontStyle();
//#endif 


//#if -1329784480 
Font f = getSettings().getFont(style);
//#endif 


//#if 756750982 
nameFig.setFont(f);
//#endif 


//#if 1150121454 
deepUpdateFont(this);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

