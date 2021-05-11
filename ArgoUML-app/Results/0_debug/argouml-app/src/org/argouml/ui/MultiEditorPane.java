
//#if -1806043217 
// Compilation Unit of /MultiEditorPane.java 
 

//#if -1855429337 
package org.argouml.ui;
//#endif 


//#if 155503985 
import java.awt.BorderLayout;
//#endif 


//#if -571211406 
import java.awt.Component;
//#endif 


//#if 290569769 
import java.awt.Dimension;
//#endif 


//#if 276791104 
import java.awt.Rectangle;
//#endif 


//#if 498820990 
import java.awt.event.MouseEvent;
//#endif 


//#if -1460016566 
import java.awt.event.MouseListener;
//#endif 


//#if -1553273588 
import java.util.ArrayList;
//#endif 


//#if 948010681 
import java.util.Arrays;
//#endif 


//#if 86856149 
import java.util.List;
//#endif 


//#if 1274138513 
import javax.swing.JPanel;
//#endif 


//#if -1237286963 
import javax.swing.JTabbedPane;
//#endif 


//#if 2057691706 
import javax.swing.SwingConstants;
//#endif 


//#if 1568051637 
import javax.swing.event.ChangeEvent;
//#endif 


//#if 512721075 
import javax.swing.event.ChangeListener;
//#endif 


//#if 1564959663 
import org.argouml.application.api.AbstractArgoJPanel;
//#endif 


//#if 2018969241 
import org.argouml.ui.targetmanager.TargetEvent;
//#endif 


//#if -858640049 
import org.argouml.ui.targetmanager.TargetListener;
//#endif 


//#if -1250591258 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 733899862 
import org.argouml.uml.diagram.ui.ModeLabelDragFactory;
//#endif 


//#if -157861539 
import org.argouml.uml.diagram.ui.TabDiagram;
//#endif 


//#if 461090928 
import org.tigris.gef.base.Globals;
//#endif 


//#if 976258650 
import org.tigris.gef.base.ModeDragScrollFactory;
//#endif 


//#if 1949367321 
import org.tigris.gef.base.ModeFactory;
//#endif 


//#if 692410005 
import org.tigris.gef.base.ModePopupFactory;
//#endif 


//#if -1474921675 
import org.tigris.gef.base.ModeSelectFactory;
//#endif 


//#if 1541752457 
import org.apache.log4j.Logger;
//#endif 


//#if -1854414974 
public class MultiEditorPane extends 
//#if 2102571244 
JPanel
//#endif 

 implements 
//#if 616308662 
ChangeListener
//#endif 

, 
//#if 2001612551 
MouseListener
//#endif 

, 
//#if -690221929 
TargetListener
//#endif 

  { 

//#if 1877515127 
private final JPanel[] tabInstances = new JPanel[] {
        new TabDiagram(),
        // org.argouml.ui.TabTable
        // TabMetrics
        // TabJavaSrc | TabSrc
        // TabUMLDisplay
        // TabHash
    };
//#endif 


//#if 725238658 
private JTabbedPane tabs = new JTabbedPane(SwingConstants.BOTTOM);
//#endif 


//#if -288220875 
private List<JPanel> tabPanels =
        new ArrayList<JPanel>(Arrays.asList(tabInstances));
//#endif 


//#if -967452600 
private Component lastTab;
//#endif 


//#if 748764874 
private static final Logger LOG = Logger.getLogger(MultiEditorPane.class);
//#endif 


//#if -922828962 
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
//#endif 


//#if 519566663 
public void targetSet(TargetEvent e)
    { 

//#if -103283341 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if -1352091393 
public int getIndexOfNamedTab(String tabName)
    { 

//#if 523529960 
for (int i = 0; i < tabPanels.size(); i++) //1
{ 

//#if -764574032 
String title = tabs.getTitleAt(i);
//#endif 


//#if -1918235390 
if(title != null && title.equals(tabName))//1
{ 

//#if -1070347601 
return i;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2042086005 
return -1;
//#endif 

} 

//#endif 


//#if -510916909 
public void selectTabNamed(String tabName)
    { 

//#if 508934153 
int index = getIndexOfNamedTab(tabName);
//#endif 


//#if 1027883993 
if(index != -1)//1
{ 

//#if -958424855 
tabs.setSelectedIndex(index);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1684005319 
public void mouseReleased(MouseEvent me)
    { 
} 

//#endif 


//#if -2042123816 
public void stateChanged(ChangeEvent  e)
    { 

//#if -1813686344 
if(lastTab != null)//1
{ 

//#if 1613190465 
lastTab.setVisible(false);
//#endif 

} 

//#endif 


//#if 1438689877 
lastTab = tabs.getSelectedComponent();
//#endif 


//#if 1426189108 
LOG.debug(
            "MultiEditorPane state changed:" + lastTab.getClass().getName());
//#endif 


//#if 19841392 
lastTab.setVisible(true);
//#endif 


//#if -1895255226 
if(lastTab instanceof TabModelTarget)//1
{ 

//#if -438033521 
((TabModelTarget) lastTab).refresh();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1914859925 
public void mouseEntered(MouseEvent me)
    { 
} 

//#endif 


//#if -364797229 
protected JTabbedPane getTabs()
    { 

//#if 441169537 
return tabs;
//#endif 

} 

//#endif 


//#if 1039543653 
public void targetAdded(TargetEvent e)
    { 

//#if 1872365683 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if 564475037 
@Override
    public Dimension getMinimumSize()
    { 

//#if -1359852625 
return new Dimension(100, 100);
//#endif 

} 

//#endif 


//#if 1069424462 
private void setTarget(Object t)
    { 

//#if -162832112 
enableTabs(t);
//#endif 


//#if 230991848 
for (int i = 0; i < tabs.getTabCount(); i++) //1
{ 

//#if 631333044 
Component tab = tabs.getComponentAt(i);
//#endif 


//#if -400581352 
if(tab.isEnabled())//1
{ 

//#if -357007311 
tabs.setSelectedComponent(tab);
//#endif 


//#if -1758746150 
break;

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 2073396118 
private void enableTabs(Object t)
    { 

//#if 1878746016 
for (int i = 0; i < tabs.getTabCount(); i++) //1
{ 

//#if -442371806 
Component tab = tabs.getComponentAt(i);
//#endif 


//#if -1450567858 
if(tab instanceof TabTarget)//1
{ 

//#if 886769400 
TabTarget targetTab = (TabTarget) tab;
//#endif 


//#if -1462334933 
boolean shouldBeEnabled = targetTab.shouldBeEnabled(t);
//#endif 


//#if 1431409358 
tabs.setEnabledAt(i, shouldBeEnabled);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1842174184 
public void selectNextTab()
    { 

//#if 689857774 
int size = tabPanels.size();
//#endif 


//#if 1963766831 
int currentTab = tabs.getSelectedIndex();
//#endif 


//#if 1695405327 
for (int i = 1; i < tabPanels.size(); i++) //1
{ 

//#if -995114833 
int newTab = (currentTab + i) % size;
//#endif 


//#if 943259135 
if(tabs.isEnabledAt(newTab))//1
{ 

//#if -1113236067 
tabs.setSelectedIndex(newTab);
//#endif 


//#if -1195906504 
return;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1183738836 
public MultiEditorPane()
    { 

//#if -1388742223 
LOG.info("making MultiEditorPane");
//#endif 


//#if -998406657 
setLayout(new BorderLayout());
//#endif 


//#if -863915962 
add(tabs, BorderLayout.CENTER);
//#endif 


//#if 23669014 
for (int i = 0; i < tabPanels.size(); i++) //1
{ 

//#if -2075875589 
String title = "tab";
//#endif 


//#if -1291411773 
JPanel t = tabPanels.get(i);
//#endif 


//#if -1620743861 
if(t instanceof AbstractArgoJPanel)//1
{ 

//#if 127158911 
title = ((AbstractArgoJPanel) t).getTitle();
//#endif 

} 

//#endif 


//#if -1836077806 
tabs.addTab("As " + title, t);
//#endif 


//#if -1658349581 
tabs.setEnabledAt(i, false);
//#endif 


//#if -2043759109 
if(t instanceof TargetListener)//1
{ 

//#if 1084011897 
TargetManager.getInstance()
                .addTargetListener((TargetListener) t);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -94091371 
tabs.addChangeListener(this);
//#endif 


//#if 2120849822 
tabs.addMouseListener(this);
//#endif 


//#if -794309092 
setTarget(null);
//#endif 

} 

//#endif 


//#if -769042656 
public void mySingleClick(int tab)
    { 

//#if -753478115 
LOG.debug("single: " + tabs.getComponentAt(tab).toString());
//#endif 

} 

//#endif 


//#if 911505296 
@Override
    public Dimension getPreferredSize()
    { 

//#if -1137544197 
return new Dimension(400, 500);
//#endif 

} 

//#endif 


//#if -174993339 
public void mouseClicked(MouseEvent me)
    { 

//#if -633227288 
int tab = tabs.getSelectedIndex();
//#endif 


//#if 1493168970 
if(tab != -1)//1
{ 

//#if 1760508570 
Rectangle tabBounds = tabs.getBoundsAt(tab);
//#endif 


//#if 942028004 
if(!tabBounds.contains(me.getX(), me.getY()))//1
{ 

//#if 518846351 
return;
//#endif 

} 

//#endif 


//#if 1907814555 
if(me.getClickCount() == 1)//1
{ 

//#if -93746198 
mySingleClick(tab);
//#endif 


//#if -1148264725 
me.consume();
//#endif 

} 
else

//#if 1755734033 
if(me.getClickCount() >= 2)//1
{ 

//#if -1242698806 
myDoubleClick(tab);
//#endif 


//#if 59068596 
me.consume();
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if -1629169408 
public void mousePressed(MouseEvent me)
    { 
} 

//#endif 


//#if 769490117 
public void targetRemoved(TargetEvent e)
    { 

//#if 1626503012 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if 694799431 
public void mouseExited(MouseEvent me)
    { 
} 

//#endif 


//#if 761570871 
public void myDoubleClick(int tab)
    { 

//#if 1808841760 
LOG.debug("double: " + tabs.getComponentAt(tab).toString());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

