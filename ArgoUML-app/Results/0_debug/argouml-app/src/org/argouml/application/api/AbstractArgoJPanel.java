
//#if 18732409 
// Compilation Unit of /AbstractArgoJPanel.java 
 

//#if 1254200884 
package org.argouml.application.api;
//#endif 


//#if 706666268 
import java.awt.BorderLayout;
//#endif 


//#if 1229450740 
import java.awt.Point;
//#endif 


//#if 898614645 
import java.awt.Rectangle;
//#endif 


//#if 1409448487 
import javax.swing.Icon;
//#endif 


//#if 1097379524 
import javax.swing.JDialog;
//#endif 


//#if 1895962054 
import javax.swing.JPanel;
//#endif 


//#if 148689592 
import javax.swing.JTabbedPane;
//#endif 


//#if 2135799060 
import javax.swing.SwingUtilities;
//#endif 


//#if 1340342689 
import org.argouml.i18n.Translator;
//#endif 


//#if -506647037 
import org.argouml.util.ArgoFrame;
//#endif 


//#if -1148188719 
import org.tigris.swidgets.Orientable;
//#endif 


//#if -1217566666 
import org.tigris.swidgets.Orientation;
//#endif 


//#if -1367238284 
import org.apache.log4j.Logger;
//#endif 


//#if 992789652 
public abstract class AbstractArgoJPanel extends 
//#if 524329607 
JPanel
//#endif 

 implements 
//#if 368514634 
Cloneable
//#endif 

, 
//#if 1526676332 
Orientable
//#endif 

  { 

//#if -857200057 
private static final int OVERLAPP = 30;
//#endif 


//#if -582890924 
private String title = "untitled";
//#endif 


//#if -564603265 
private Icon icon = null;
//#endif 


//#if -959684831 
private boolean tear = false;
//#endif 


//#if -2007653147 
private Orientation orientation;
//#endif 


//#if -348635722 
private static final Logger LOG =
        Logger.getLogger(AbstractArgoJPanel.class);
//#endif 


//#if -632183307 
public Orientation getOrientation()
    { 

//#if -2057751851 
return orientation;
//#endif 

} 

//#endif 


//#if 1125322121 
public Object clone()
    { 

//#if 1389549901 
try //1
{ 

//#if -2065491632 
return this.getClass().newInstance();
//#endif 

} 

//#if -1784327558 
catch (Exception ex) //1
{ 

//#if 1494624838 
LOG.error("exception in clone()", ex);
//#endif 

} 

//#endif 


//#endif 


//#if -1496846291 
return null;
//#endif 

} 

//#endif 


//#if -974932594 
public void setTitle(String t)
    { 

//#if -2096665347 
title = t;
//#endif 

} 

//#endif 


//#if 1649762602 
public String getTitle()
    { 

//#if 1533425182 
return title;
//#endif 

} 

//#endif 


//#if 1105043884 
public AbstractArgoJPanel()
    { 

//#if -1125660968 
this(Translator.localize("tab.untitled"), false);
//#endif 

} 

//#endif 


//#if 1076534257 
public AbstractArgoJPanel spawn()
    { 

//#if -53312414 
JDialog f = new JDialog(ArgoFrame.getInstance());
//#endif 


//#if -1849424952 
f.getContentPane().setLayout(new BorderLayout());
//#endif 


//#if -736522237 
f.setTitle(Translator.localize(title));
//#endif 


//#if -40428968 
AbstractArgoJPanel newPanel = (AbstractArgoJPanel) clone();
//#endif 


//#if -2103306103 
if(newPanel == null)//1
{ 

//#if 1537964336 
return null;
//#endif 

} 

//#endif 


//#if 900890667 
newPanel.setTitle(Translator.localize(title));
//#endif 


//#if -468025885 
f.getContentPane().add(newPanel, BorderLayout.CENTER);
//#endif 


//#if 1186032061 
Rectangle bounds = getBounds();
//#endif 


//#if 1530020301 
bounds.height += OVERLAPP * 2;
//#endif 


//#if 753506293 
f.setBounds(bounds);
//#endif 


//#if -1385346138 
Point loc = new Point(0, 0);
//#endif 


//#if -166143885 
SwingUtilities.convertPointToScreen(loc, this);
//#endif 


//#if -698795156 
loc.y -= OVERLAPP;
//#endif 


//#if 1461266852 
f.setLocation(loc);
//#endif 


//#if 1088147739 
f.setVisible(true);
//#endif 


//#if -917356336 
if(tear && (getParent() instanceof JTabbedPane))//1
{ 

//#if 947313217 
((JTabbedPane) getParent()).remove(this);
//#endif 

} 

//#endif 


//#if 1888175538 
return newPanel;
//#endif 

} 

//#endif 


//#if 1939041071 
public void setIcon(Icon theIcon)
    { 

//#if 596148561 
this.icon = theIcon;
//#endif 

} 

//#endif 


//#if -1266226079 
public Icon getIcon()
    { 

//#if 10167787 
return icon;
//#endif 

} 

//#endif 


//#if -784454945 
public AbstractArgoJPanel(String title)
    { 

//#if -910981972 
this(title, false);
//#endif 

} 

//#endif 


//#if -459799621 
public AbstractArgoJPanel(String title, boolean t)
    { 

//#if 67145481 
setTitle(title);
//#endif 


//#if 895621361 
tear = t;
//#endif 

} 

//#endif 


//#if 582660186 
public void setOrientation(Orientation o)
    { 

//#if 331727933 
this.orientation = o;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

