// Compilation Unit of /TabDiagram.java 
 
package org.argouml.uml.diagram.ui;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.EtchedBorder;
import org.apache.log4j.Logger;
import org.argouml.application.api.AbstractArgoJPanel;
import org.argouml.application.api.Argo;
import org.argouml.configuration.Configuration;
import org.argouml.ui.TabModelTarget;
import org.argouml.ui.targetmanager.TargetEvent;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.uml.diagram.DiagramUtils;
import org.argouml.uml.ui.ActionCopy;
import org.argouml.uml.ui.ActionCut;
import org.tigris.gef.base.Diagram;
import org.tigris.gef.base.Editor;
import org.tigris.gef.base.FigModifyingMode;
import org.tigris.gef.base.Globals;
import org.tigris.gef.base.LayerManager;
import org.tigris.gef.base.ModeSelect;
import org.tigris.gef.event.GraphSelectionEvent;
import org.tigris.gef.event.GraphSelectionListener;
import org.tigris.gef.event.ModeChangeEvent;
import org.tigris.gef.event.ModeChangeListener;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.graph.presentation.JGraph;
import org.tigris.gef.presentation.Fig;
import org.tigris.toolbar.ToolBarFactory;
class ArgoEditor extends Editor
  { 
private RenderingHints  argoRenderingHints;
private static final long serialVersionUID = -799007144549997407L;
public ArgoEditor(GraphModel gm, JComponent c)
    { 
super(gm, c);
setupRenderingHints();
} 

@Override
    public synchronized void paint(Graphics g)
    { 
if(!shouldPaint())//1
{ 
return;
} 

if(g instanceof Graphics2D)//1
{ 
Graphics2D g2 = (Graphics2D) g;
g2.setRenderingHints(argoRenderingHints);
double scale = getScale();
g2.scale(scale, scale);
} 

getLayerManager().paint(g);
if(_canSelectElements)//1
{ 
_selectionManager.paint(g);
_modeManager.paint(g);
} 

} 

public ArgoEditor(Diagram d)
    { 
super(d);
setupRenderingHints();
} 

@Override
    public void mouseEntered(MouseEvent me)
    { 
if(getActiveTextEditor() != null)//1
{ 
getActiveTextEditor().requestFocus();
} 

translateMouseEvent(me);
Globals.curEditor(this);
pushMode((FigModifyingMode) Globals.mode());
setUnderMouse(me);
_modeManager.mouseEntered(me);
} 

@Override
    public void mouseMoved(MouseEvent me)
    { 
translateMouseEvent(me);
Globals.curEditor(this);
setUnderMouse(me);
Fig currentFig = getCurrentFig();
if(currentFig != null && Globals.getShowFigTips())//1
{ 
String tip = currentFig.getTipString(me);
if(tip != null && (getJComponent() != null))//1
{ 
JComponent c = getJComponent();
if(c.getToolTipText() == null
                        || !(c.getToolTipText().equals(tip)))//1
{ 
c.setToolTipText(tip);
} 

} 

} 
else
if(getJComponent() != null
                   && getJComponent().getToolTipText() != null)//1
{ 
getJComponent().setToolTipText(null);
} 


_selectionManager.mouseMoved(me);
_modeManager.mouseMoved(me);
} 

private void setupRenderingHints()
    { 
argoRenderingHints = new RenderingHints(null);
argoRenderingHints.put(RenderingHints.KEY_FRACTIONALMETRICS,
                               RenderingHints.VALUE_FRACTIONALMETRICS_ON);
if(Configuration.getBoolean(Argo.KEY_SMOOTH_EDGES, false))//1
{ 
argoRenderingHints.put(RenderingHints.KEY_RENDERING,
                                   RenderingHints.VALUE_RENDER_QUALITY);
argoRenderingHints.put(RenderingHints.KEY_ANTIALIASING,
                                   RenderingHints.VALUE_ANTIALIAS_ON);
argoRenderingHints.put(RenderingHints.KEY_TEXT_ANTIALIASING,
                                   RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
} 
else
{ 
argoRenderingHints.put(RenderingHints.KEY_RENDERING,
                                   RenderingHints.VALUE_RENDER_SPEED);
argoRenderingHints.put(RenderingHints.KEY_ANTIALIASING,
                                   RenderingHints.VALUE_ANTIALIAS_OFF);
argoRenderingHints.put(RenderingHints.KEY_TEXT_ANTIALIASING,
                                   RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
} 

} 

 } 

public class TabDiagram extends AbstractArgoJPanel
 implements TabModelTarget
, GraphSelectionListener
, ModeChangeListener
, PropertyChangeListener
  { 
private static final Logger LOG = Logger.getLogger(TabDiagram.class);
private UMLDiagram target;
private JGraph graph;
private boolean updatingSelection;
private JToolBar toolBar;
private static final long serialVersionUID = -3305029387374936153L;
public void targetRemoved(TargetEvent e)
    { 
setTarget(e.getNewTarget());
select(e.getNewTargets());
} 

public JToolBar getToolBar()
    { 
return toolBar;
} 

public void setVisible(boolean b)
    { 
super.setVisible(b);
getJGraph().setVisible(b);
} 

public Object getTarget()
    { 
return target;
} 

public void modeChange(ModeChangeEvent mce)
    { 
LOG.debug("TabDiagram got mode change event");
if(target != null    // Target might not have been initialised yet.
                && !Globals.getSticky()
                && Globals.mode() instanceof ModeSelect)//1
{ 
target.deselectAllTools();
} 

} 

public void removeGraphSelectionListener(GraphSelectionListener listener)
    { 
graph.removeGraphSelectionListener(listener);
} 

public JGraph getJGraph()
    { 
return graph;
} 

public void propertyChange(PropertyChangeEvent arg0)
    { 
if("remove".equals(arg0.getPropertyName()))//1
{ 
LOG.debug("Got remove event for diagram = " + arg0.getSource()
                      + " old value = " + arg0.getOldValue());
} 

} 

public void targetSet(TargetEvent e)
    { 
setTarget(e.getNewTarget());
select(e.getNewTargets());
} 

public boolean shouldBeEnabled(Object newTarget)
    { 
return newTarget instanceof ArgoDiagram;
} 

public TabDiagram()
    { 
this("Diagram");
} 

public void removeModeChangeListener(ModeChangeListener listener)
    { 
graph.removeModeChangeListener(listener);
} 

public void refresh()
    { 
setTarget(target);
} 

public void targetAdded(TargetEvent e)
    { 
setTarget(e.getNewTarget());
select(e.getNewTargets());
} 

@Override
    public Object clone()
    { 
TabDiagram newPanel = new TabDiagram();
if(target != null)//1
{ 
newPanel.setTarget(target);
} 

ToolBarFactory factory = new ToolBarFactory(target.getActions());
factory.setRollover(true);
factory.setFloatable(false);
newPanel.setToolBar(factory.createToolBar());
setToolBar(factory.createToolBar());
return newPanel;
} 

public void setToolBar(JToolBar toolbar)
    { 
if(!Arrays.asList(getComponents()).contains(toolbar))//1
{ 
if(target != null)//1
{ 
remove(((UMLDiagram) getTarget()).getJToolBar());
} 

add(toolbar, BorderLayout.NORTH);
toolBar = toolbar;
invalidate();
validate();
repaint();
} 

} 

public TabDiagram(String tag)
    { 
super(tag);
setLayout(new BorderLayout());
graph = new DnDJGraph();
graph.setDrawingSize((612 - 30) * 2, (792 - 55 - 20) * 2);
Globals.setStatusBar(new StatusBarAdapter());
JPanel p = new JPanel();
p.setLayout(new BorderLayout());
p.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
p.add(graph, BorderLayout.CENTER);
add(p, BorderLayout.CENTER);
graph.addGraphSelectionListener(this);
graph.addModeChangeListener(this);
} 

public void setTarget(Object t)
    { 
if(!(t instanceof UMLDiagram))//1
{ 
LOG.debug("target is null in set target or "
                      + "not an instance of UMLDiagram");
return;
} 

UMLDiagram newTarget = (UMLDiagram) t;
if(target != null)//1
{ 
target.removePropertyChangeListener("remove", this);
} 

newTarget.addPropertyChangeListener("remove", this);
setToolBar(newTarget.getJToolBar());
graph.removeGraphSelectionListener(this);
graph.setDiagram(newTarget);
graph.addGraphSelectionListener(this);
target = newTarget;
} 

private void select(Object[] targets)
    { 
LayerManager manager = graph.getEditor().getLayerManager();
List<Fig> figList = new ArrayList<Fig>();
for (int i = 0; i < targets.length; i++) //1
{ 
if(targets[i] != null)//1
{ 
Fig theTarget = null;
if(targets[i] instanceof Fig
                        && manager.getActiveLayer().getContents().contains(
                            targets[i]))//1
{ 
theTarget = (Fig) targets[i];
} 
else
{ 
theTarget = manager.presentationFor(targets[i]);
} 

if(theTarget != null && !figList.contains(theTarget))//1
{ 
figList.add(theTarget);
} 

} 

} 

if(!figList.equals(graph.selectedFigs()))//1
{ 
graph.deselectAll();
graph.select(new Vector<Fig>(figList));
} 

} 

public void selectionChanged(GraphSelectionEvent gse)
    { 
if(!updatingSelection)//1
{ 
updatingSelection = true;
List<Fig> selections = gse.getSelections();
ActionCut.getInstance().setEnabled(
                selections != null && !selections.isEmpty());
ActionCopy.getInstance()
            .setEnabled(selections != null && !selections.isEmpty());
List currentSelection =
                TargetManager.getInstance().getTargets();
List removedTargets = new ArrayList(currentSelection);
List addedTargets = new ArrayList();
for (Object selection : selections) //1
{ 
Object owner = TargetManager.getInstance().getOwner(selection);
if(currentSelection.contains(owner))//1
{ 
removedTargets.remove(owner);
} 
else
{ 
addedTargets.add(owner);
} 

} 

if(addedTargets.size() == 1
                    && removedTargets.size() == currentSelection.size()
                    && removedTargets.size() != 0)//1
{ 
TargetManager.getInstance().setTarget(addedTargets.get(0));
} 
else
{ 
for (Object o : removedTargets) //1
{ 
TargetManager.getInstance().removeTarget(o);
} 

for (Object o : addedTargets) //1
{ 
TargetManager.getInstance().addTarget(o);
} 

} 

updatingSelection = false;
} 

} 

 } 


