
//#if 1379478043 
// Compilation Unit of /TabDiagram.java 
 

//#if 1170461005 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -33332340 
import java.awt.BorderLayout;
//#endif 


//#if -2103647849 
import java.awt.Graphics;
//#endif 


//#if 1324007045 
import java.awt.Graphics2D;
//#endif 


//#if -1300162078 
import java.awt.RenderingHints;
//#endif 


//#if -960792551 
import java.awt.event.MouseEvent;
//#endif 


//#if 1112533338 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -2031236370 
import java.beans.PropertyChangeListener;
//#endif 


//#if 1333677543 
import java.util.ArrayList;
//#endif 


//#if -1803664450 
import java.util.Arrays;
//#endif 


//#if 1362203674 
import java.util.List;
//#endif 


//#if -731431723 
import java.util.Vector;
//#endif 


//#if -1784329219 
import javax.swing.JComponent;
//#endif 


//#if -1680775338 
import javax.swing.JPanel;
//#endif 


//#if 1932909855 
import javax.swing.JToolBar;
//#endif 


//#if 930282789 
import javax.swing.border.EtchedBorder;
//#endif 


//#if 458670564 
import org.apache.log4j.Logger;
//#endif 


//#if 585716212 
import org.argouml.application.api.AbstractArgoJPanel;
//#endif 


//#if 766464464 
import org.argouml.application.api.Argo;
//#endif 


//#if -898749763 
import org.argouml.configuration.Configuration;
//#endif 


//#if 1167698620 
import org.argouml.ui.TabModelTarget;
//#endif 


//#if 1619414174 
import org.argouml.ui.targetmanager.TargetEvent;
//#endif 


//#if 1324045995 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -1503935338 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if 1295336488 
import org.argouml.uml.diagram.DiagramUtils;
//#endif 


//#if 2051745616 
import org.argouml.uml.ui.ActionCopy;
//#endif 


//#if -1596376817 
import org.argouml.uml.ui.ActionCut;
//#endif 


//#if -1764885752 
import org.tigris.gef.base.Diagram;
//#endif 


//#if 2462510 
import org.tigris.gef.base.Editor;
//#endif 


//#if 1327384276 
import org.tigris.gef.base.FigModifyingMode;
//#endif 


//#if -2068183477 
import org.tigris.gef.base.Globals;
//#endif 


//#if 116569439 
import org.tigris.gef.base.LayerManager;
//#endif 


//#if -839490980 
import org.tigris.gef.base.ModeSelect;
//#endif 


//#if 1205138320 
import org.tigris.gef.event.GraphSelectionEvent;
//#endif 


//#if -605221640 
import org.tigris.gef.event.GraphSelectionListener;
//#endif 


//#if 759131045 
import org.tigris.gef.event.ModeChangeEvent;
//#endif 


//#if 1020862659 
import org.tigris.gef.event.ModeChangeListener;
//#endif 


//#if -214966909 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if -1020666464 
import org.tigris.gef.graph.presentation.JGraph;
//#endif 


//#if -1152851890 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -1187960734 
import org.tigris.toolbar.ToolBarFactory;
//#endif 


//#if -392505984 
class ArgoEditor extends 
//#if 2044993479 
Editor
//#endif 

  { 

//#if -1742848679 
private RenderingHints  argoRenderingHints;
//#endif 


//#if 1067332403 
private static final long serialVersionUID = -799007144549997407L;
//#endif 


//#if 1231056517 
public ArgoEditor(GraphModel gm, JComponent c)
    { 

//#if 1977717449 
super(gm, c);
//#endif 


//#if 581245930 
setupRenderingHints();
//#endif 

} 

//#endif 


//#if 1968467162 
@Override
    public synchronized void paint(Graphics g)
    { 

//#if 146093389 
if(!shouldPaint())//1
{ 

//#if 1845993504 
return;
//#endif 

} 

//#endif 


//#if -1446036354 
if(g instanceof Graphics2D)//1
{ 

//#if 1895124385 
Graphics2D g2 = (Graphics2D) g;
//#endif 


//#if -1685038872 
g2.setRenderingHints(argoRenderingHints);
//#endif 


//#if 1014127670 
double scale = getScale();
//#endif 


//#if 1769859909 
g2.scale(scale, scale);
//#endif 

} 

//#endif 


//#if -411610653 
getLayerManager().paint(g);
//#endif 


//#if -404091610 
if(_canSelectElements)//1
{ 

//#if 955135545 
_selectionManager.paint(g);
//#endif 


//#if -1868069388 
_modeManager.paint(g);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1886590343 
public ArgoEditor(Diagram d)
    { 

//#if -649097469 
super(d);
//#endif 


//#if 345969507 
setupRenderingHints();
//#endif 

} 

//#endif 


//#if 481427125 
@Override
    public void mouseEntered(MouseEvent me)
    { 

//#if 1381916234 
if(getActiveTextEditor() != null)//1
{ 

//#if -1056301537 
getActiveTextEditor().requestFocus();
//#endif 

} 

//#endif 


//#if 1557635426 
translateMouseEvent(me);
//#endif 


//#if 1156443804 
Globals.curEditor(this);
//#endif 


//#if -1379345210 
pushMode((FigModifyingMode) Globals.mode());
//#endif 


//#if 1868891478 
setUnderMouse(me);
//#endif 


//#if 978127856 
_modeManager.mouseEntered(me);
//#endif 

} 

//#endif 


//#if 1979396465 
@Override
    public void mouseMoved(MouseEvent me)
    { 

//#if -1483960678 
translateMouseEvent(me);
//#endif 


//#if -1885152300 
Globals.curEditor(this);
//#endif 


//#if 1791114382 
setUnderMouse(me);
//#endif 


//#if -828227630 
Fig currentFig = getCurrentFig();
//#endif 


//#if 1898469502 
if(currentFig != null && Globals.getShowFigTips())//1
{ 

//#if 1791605808 
String tip = currentFig.getTipString(me);
//#endif 


//#if 821496341 
if(tip != null && (getJComponent() != null))//1
{ 

//#if -1583696656 
JComponent c = getJComponent();
//#endif 


//#if -1492832203 
if(c.getToolTipText() == null
                        || !(c.getToolTipText().equals(tip)))//1
{ 

//#if 173760149 
c.setToolTipText(tip);
//#endif 

} 

//#endif 

} 

//#endif 

} 
else

//#if -153049262 
if(getJComponent() != null
                   && getJComponent().getToolTipText() != null)//1
{ 

//#if -905766217 
getJComponent().setToolTipText(null);
//#endif 

} 

//#endif 


//#endif 


//#if -38827701 
_selectionManager.mouseMoved(me);
//#endif 


//#if -983629140 
_modeManager.mouseMoved(me);
//#endif 

} 

//#endif 


//#if -106796607 
private void setupRenderingHints()
    { 

//#if 1031331777 
argoRenderingHints = new RenderingHints(null);
//#endif 


//#if 1035413276 
argoRenderingHints.put(RenderingHints.KEY_FRACTIONALMETRICS,
                               RenderingHints.VALUE_FRACTIONALMETRICS_ON);
//#endif 


//#if -1728893641 
if(Configuration.getBoolean(Argo.KEY_SMOOTH_EDGES, false))//1
{ 

//#if -148838339 
argoRenderingHints.put(RenderingHints.KEY_RENDERING,
                                   RenderingHints.VALUE_RENDER_QUALITY);
//#endif 


//#if -1830214675 
argoRenderingHints.put(RenderingHints.KEY_ANTIALIASING,
                                   RenderingHints.VALUE_ANTIALIAS_ON);
//#endif 


//#if -2002212187 
argoRenderingHints.put(RenderingHints.KEY_TEXT_ANTIALIASING,
                                   RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
//#endif 

} 
else
{ 

//#if 1208385068 
argoRenderingHints.put(RenderingHints.KEY_RENDERING,
                                   RenderingHints.VALUE_RENDER_SPEED);
//#endif 


//#if 1409939404 
argoRenderingHints.put(RenderingHints.KEY_ANTIALIASING,
                                   RenderingHints.VALUE_ANTIALIAS_OFF);
//#endif 


//#if -1589705900 
argoRenderingHints.put(RenderingHints.KEY_TEXT_ANTIALIASING,
                                   RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#if -1345250737 
public class TabDiagram extends 
//#if -488842861 
AbstractArgoJPanel
//#endif 

 implements 
//#if 1595116579 
TabModelTarget
//#endif 

, 
//#if 1177371024 
GraphSelectionListener
//#endif 

, 
//#if 155584229 
ModeChangeListener
//#endif 

, 
//#if 284576919 
PropertyChangeListener
//#endif 

  { 

//#if -226448754 
private static final Logger LOG = Logger.getLogger(TabDiagram.class);
//#endif 


//#if 1428050566 
private UMLDiagram target;
//#endif 


//#if 1295076310 
private JGraph graph;
//#endif 


//#if 166963032 
private boolean updatingSelection;
//#endif 


//#if 204672886 
private JToolBar toolBar;
//#endif 


//#if 1460867063 
private static final long serialVersionUID = -3305029387374936153L;
//#endif 


//#if 689750425 
public void targetRemoved(TargetEvent e)
    { 

//#if 501229275 
setTarget(e.getNewTarget());
//#endif 


//#if -960404955 
select(e.getNewTargets());
//#endif 

} 

//#endif 


//#if -1763616578 
public JToolBar getToolBar()
    { 

//#if 281998763 
return toolBar;
//#endif 

} 

//#endif 


//#if 312345714 
public void setVisible(boolean b)
    { 

//#if 1823030871 
super.setVisible(b);
//#endif 


//#if -871175337 
getJGraph().setVisible(b);
//#endif 

} 

//#endif 


//#if 1786504386 
public Object getTarget()
    { 

//#if 45807203 
return target;
//#endif 

} 

//#endif 


//#if -1729734521 
public void modeChange(ModeChangeEvent mce)
    { 

//#if -1121417591 
LOG.debug("TabDiagram got mode change event");
//#endif 


//#if -1877977510 
if(target != null    // Target might not have been initialised yet.
                && !Globals.getSticky()
                && Globals.mode() instanceof ModeSelect)//1
{ 

//#if 891599542 
target.deselectAllTools();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -963439796 
public void removeGraphSelectionListener(GraphSelectionListener listener)
    { 

//#if 383997056 
graph.removeGraphSelectionListener(listener);
//#endif 

} 

//#endif 


//#if -1509791600 
public JGraph getJGraph()
    { 

//#if -619272678 
return graph;
//#endif 

} 

//#endif 


//#if 1378227874 
public void propertyChange(PropertyChangeEvent arg0)
    { 

//#if 1217971642 
if("remove".equals(arg0.getPropertyName()))//1
{ 

//#if 1451320907 
LOG.debug("Got remove event for diagram = " + arg0.getSource()
                      + " old value = " + arg0.getOldValue());
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1667054565 
public void targetSet(TargetEvent e)
    { 

//#if -1046430224 
setTarget(e.getNewTarget());
//#endif 


//#if -2106148230 
select(e.getNewTargets());
//#endif 

} 

//#endif 


//#if -117056715 
public boolean shouldBeEnabled(Object newTarget)
    { 

//#if -2026427153 
return newTarget instanceof ArgoDiagram;
//#endif 

} 

//#endif 


//#if -1874843706 
public TabDiagram()
    { 

//#if 1328590329 
this("Diagram");
//#endif 

} 

//#endif 


//#if 1208309100 
public void removeModeChangeListener(ModeChangeListener listener)
    { 

//#if 232006651 
graph.removeModeChangeListener(listener);
//#endif 

} 

//#endif 


//#if -845928383 
public void refresh()
    { 

//#if -835063266 
setTarget(target);
//#endif 

} 

//#endif 


//#if -64448711 
public void targetAdded(TargetEvent e)
    { 

//#if 786771142 
setTarget(e.getNewTarget());
//#endif 


//#if 2123687632 
select(e.getNewTargets());
//#endif 

} 

//#endif 


//#if -1289401432 
@Override
    public Object clone()
    { 

//#if 1704805484 
TabDiagram newPanel = new TabDiagram();
//#endif 


//#if -2104444612 
if(target != null)//1
{ 

//#if 1965173233 
newPanel.setTarget(target);
//#endif 

} 

//#endif 


//#if 1227712753 
ToolBarFactory factory = new ToolBarFactory(target.getActions());
//#endif 


//#if -1439339004 
factory.setRollover(true);
//#endif 


//#if 1318369648 
factory.setFloatable(false);
//#endif 


//#if 751778078 
newPanel.setToolBar(factory.createToolBar());
//#endif 


//#if -1546712662 
setToolBar(factory.createToolBar());
//#endif 


//#if 1562676284 
return newPanel;
//#endif 

} 

//#endif 


//#if -2129314989 
public void setToolBar(JToolBar toolbar)
    { 

//#if 36601357 
if(!Arrays.asList(getComponents()).contains(toolbar))//1
{ 

//#if 1975019578 
if(target != null)//1
{ 

//#if 375151034 
remove(((UMLDiagram) getTarget()).getJToolBar());
//#endif 

} 

//#endif 


//#if -1083413084 
add(toolbar, BorderLayout.NORTH);
//#endif 


//#if -1355301937 
toolBar = toolbar;
//#endif 


//#if -667158030 
invalidate();
//#endif 


//#if 75174135 
validate();
//#endif 


//#if -180404068 
repaint();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -769451901 
public TabDiagram(String tag)
    { 

//#if -31241347 
super(tag);
//#endif 


//#if 1648859083 
setLayout(new BorderLayout());
//#endif 


//#if -1427331381 
graph = new DnDJGraph();
//#endif 


//#if 1175766384 
graph.setDrawingSize((612 - 30) * 2, (792 - 55 - 20) * 2);
//#endif 


//#if -1619081960 
Globals.setStatusBar(new StatusBarAdapter());
//#endif 


//#if 1470028009 
JPanel p = new JPanel();
//#endif 


//#if -2074207411 
p.setLayout(new BorderLayout());
//#endif 


//#if -1076418105 
p.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
//#endif 


//#if -1455640614 
p.add(graph, BorderLayout.CENTER);
//#endif 


//#if 1490944506 
add(p, BorderLayout.CENTER);
//#endif 


//#if -557674713 
graph.addGraphSelectionListener(this);
//#endif 


//#if 600573874 
graph.addModeChangeListener(this);
//#endif 

} 

//#endif 


//#if 240887108 
public void setTarget(Object t)
    { 

//#if -1598142801 
if(!(t instanceof UMLDiagram))//1
{ 

//#if -406223676 
LOG.debug("target is null in set target or "
                      + "not an instance of UMLDiagram");
//#endif 


//#if -274692231 
return;
//#endif 

} 

//#endif 


//#if -910061783 
UMLDiagram newTarget = (UMLDiagram) t;
//#endif 


//#if -703397902 
if(target != null)//1
{ 

//#if 1621018413 
target.removePropertyChangeListener("remove", this);
//#endif 

} 

//#endif 


//#if 1266504096 
newTarget.addPropertyChangeListener("remove", this);
//#endif 


//#if 633548611 
setToolBar(newTarget.getJToolBar());
//#endif 


//#if 1448178093 
graph.removeGraphSelectionListener(this);
//#endif 


//#if -1273958015 
graph.setDiagram(newTarget);
//#endif 


//#if -338897414 
graph.addGraphSelectionListener(this);
//#endif 


//#if 2059157185 
target = newTarget;
//#endif 

} 

//#endif 


//#if 1101061723 
private void select(Object[] targets)
    { 

//#if -69834818 
LayerManager manager = graph.getEditor().getLayerManager();
//#endif 


//#if 799876110 
List<Fig> figList = new ArrayList<Fig>();
//#endif 


//#if 922367594 
for (int i = 0; i < targets.length; i++) //1
{ 

//#if 200315002 
if(targets[i] != null)//1
{ 

//#if 562559885 
Fig theTarget = null;
//#endif 


//#if -1220043369 
if(targets[i] instanceof Fig
                        && manager.getActiveLayer().getContents().contains(
                            targets[i]))//1
{ 

//#if 525172356 
theTarget = (Fig) targets[i];
//#endif 

} 
else
{ 

//#if -1783190445 
theTarget = manager.presentationFor(targets[i]);
//#endif 

} 

//#endif 


//#if -1843436483 
if(theTarget != null && !figList.contains(theTarget))//1
{ 

//#if 193048062 
figList.add(theTarget);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -180629825 
if(!figList.equals(graph.selectedFigs()))//1
{ 

//#if -861979678 
graph.deselectAll();
//#endif 


//#if -1266200082 
graph.select(new Vector<Fig>(figList));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 661117991 
public void selectionChanged(GraphSelectionEvent gse)
    { 

//#if 2048414177 
if(!updatingSelection)//1
{ 

//#if -306220508 
updatingSelection = true;
//#endif 


//#if -1979114974 
List<Fig> selections = gse.getSelections();
//#endif 


//#if -2009930221 
ActionCut.getInstance().setEnabled(
                selections != null && !selections.isEmpty());
//#endif 


//#if -570154384 
ActionCopy.getInstance()
            .setEnabled(selections != null && !selections.isEmpty());
//#endif 


//#if 900904832 
List currentSelection =
                TargetManager.getInstance().getTargets();
//#endif 


//#if -1206365909 
List removedTargets = new ArrayList(currentSelection);
//#endif 


//#if 1551790392 
List addedTargets = new ArrayList();
//#endif 


//#if -2090215283 
for (Object selection : selections) //1
{ 

//#if -569124235 
Object owner = TargetManager.getInstance().getOwner(selection);
//#endif 


//#if 713370930 
if(currentSelection.contains(owner))//1
{ 

//#if -1331007539 
removedTargets.remove(owner);
//#endif 

} 
else
{ 

//#if -1543305049 
addedTargets.add(owner);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 923100441 
if(addedTargets.size() == 1
                    && removedTargets.size() == currentSelection.size()
                    && removedTargets.size() != 0)//1
{ 

//#if 1816578656 
TargetManager.getInstance().setTarget(addedTargets.get(0));
//#endif 

} 
else
{ 

//#if -886982126 
for (Object o : removedTargets) //1
{ 

//#if -1416309951 
TargetManager.getInstance().removeTarget(o);
//#endif 

} 

//#endif 


//#if 1959653234 
for (Object o : addedTargets) //1
{ 

//#if -307550208 
TargetManager.getInstance().addTarget(o);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1319662431 
updatingSelection = false;
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

