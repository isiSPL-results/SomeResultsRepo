package org.argouml.ui;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.argouml.application.api.AbstractArgoJPanel;
import org.argouml.ui.targetmanager.TargetEvent;
import org.argouml.ui.targetmanager.TargetListener;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.diagram.ui.ModeLabelDragFactory;
import org.argouml.uml.diagram.ui.TabDiagram;
import org.tigris.gef.base.Globals;
import org.tigris.gef.base.ModeDragScrollFactory;
import org.tigris.gef.base.ModeFactory;
import org.tigris.gef.base.ModePopupFactory;
import org.tigris.gef.base.ModeSelectFactory;
public class MultiEditorPane extends JPanel
 implements ChangeListener
,MouseListener
,TargetListener
  { 
private final JPanel[] tabInstances = new JPanel[] {
        new TabDiagram(),
        // org.argouml.ui.TabTable
        // TabMetrics
        // TabJavaSrc | TabSrc
        // TabUMLDisplay
        // TabHash
    };
private JTabbedPane tabs = new JTabbedPane(SwingConstants.BOTTOM);
private List<JPanel> tabPanels =
        new ArrayList<JPanel>(Arrays.asList(tabInstances));
private Component lastTab;
{
        // I hate this so much even before I start writing it.
        // Re-initialising a global in a place where no-one will see it just
        // feels wrong.  Oh well, here goes.
        ArrayList<ModeFactory> modeFactories = new ArrayList<ModeFactory>();
        modeFactories.add(new ModeLabelDragFactory());
        modeFactories.add(new ModeSelectFactory());
        modeFactories.add(new ModePopupFactory());
        modeFactories.add(new ModeDragScrollFactory());
        Globals.setDefaultModeFactories(modeFactories);
    }
public void targetSet(TargetEvent e)
    { 
setTarget(e.getNewTarget());
} 
public int getIndexOfNamedTab(String tabName)
    { 
for (int i = 0; i < tabPanels.size(); i++) //1
{ 
String title = tabs.getTitleAt(i);
if(title != null && title.equals(tabName))//1
{ 
return i;
} 
} 
return -1;
} 
public void selectTabNamed(String tabName)
    { 
int index = getIndexOfNamedTab(tabName);
if(index != -1)//1
{ 
tabs.setSelectedIndex(index);
} 
} 
public void mouseReleased(MouseEvent me)
    { 
} 
public void stateChanged(ChangeEvent  e)
    { 
if(lastTab != null)//1
{ 
lastTab.setVisible(false);
} 
lastTab = tabs.getSelectedComponent();
lastTab.setVisible(true);
if(lastTab instanceof TabModelTarget)//1
{ 
((TabModelTarget) lastTab).refresh();
} 
} 
public void mouseEntered(MouseEvent me)
    { 
} 
protected JTabbedPane getTabs()
    { 
return tabs;
} 
public void targetAdded(TargetEvent e)
    { 
setTarget(e.getNewTarget());
} 
@Override
    public Dimension getMinimumSize()
    { 
return new Dimension(100, 100);
} 
private void setTarget(Object t)
    { 
enableTabs(t);
for (int i = 0; i < tabs.getTabCount(); i++) //1
{ 
Component tab = tabs.getComponentAt(i);
if(tab.isEnabled())//1
{ 
tabs.setSelectedComponent(tab);
break;

} 
} 
} 
private void enableTabs(Object t)
    { 
for (int i = 0; i < tabs.getTabCount(); i++) //1
{ 
Component tab = tabs.getComponentAt(i);
if(tab instanceof TabTarget)//1
{ 
TabTarget targetTab = (TabTarget) tab;
boolean shouldBeEnabled = targetTab.shouldBeEnabled(t);
tabs.setEnabledAt(i, shouldBeEnabled);
} 
} 
} 
public void selectNextTab()
    { 
int size = tabPanels.size();
int currentTab = tabs.getSelectedIndex();
for (int i = 1; i < tabPanels.size(); i++) //1
{ 
int newTab = (currentTab + i) % size;
if(tabs.isEnabledAt(newTab))//1
{ 
tabs.setSelectedIndex(newTab);
return;
} 
} 
} 
public MultiEditorPane()
    { 
setLayout(new BorderLayout());
add(tabs, BorderLayout.CENTER);
for (int i = 0; i < tabPanels.size(); i++) //1
{ 
String title = "tab";
JPanel t = tabPanels.get(i);
if(t instanceof AbstractArgoJPanel)//1
{ 
title = ((AbstractArgoJPanel) t).getTitle();
} 
tabs.addTab("As " + title, t);
tabs.setEnabledAt(i, false);
if(t instanceof TargetListener)//1
{ 
TargetManager.getInstance()
                .addTargetListener((TargetListener) t);
} 
} 
tabs.addChangeListener(this);
tabs.addMouseListener(this);
setTarget(null);
} 
public void mySingleClick(int tab)
    { 
} 
@Override
    public Dimension getPreferredSize()
    { 
return new Dimension(400, 500);
} 
public void mouseClicked(MouseEvent me)
    { 
int tab = tabs.getSelectedIndex();
if(tab != -1)//1
{ 
Rectangle tabBounds = tabs.getBoundsAt(tab);
if(!tabBounds.contains(me.getX(), me.getY()))//1
{ 
return;
} 
if(me.getClickCount() == 1)//1
{ 
mySingleClick(tab);
me.consume();
} 
else
if(me.getClickCount() >= 2)//1
{ 
myDoubleClick(tab);
me.consume();
} 
} 
} 
public void mousePressed(MouseEvent me)
    { 
} 
public void targetRemoved(TargetEvent e)
    { 
setTarget(e.getNewTarget());
} 
public void mouseExited(MouseEvent me)
    { 
} 
public void myDoubleClick(int tab)
    { 
} 

 } 
