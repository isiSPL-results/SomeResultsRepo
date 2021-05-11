
//#if 1498254056 
// Compilation Unit of /GlassPane.java 
 

//#if 9084727 
package org.argouml.swingext;
//#endif 


//#if 208746474 
import java.awt.AWTEvent;
//#endif 


//#if 1290085843 
import java.awt.Component;
//#endif 


//#if 1335795920 
import java.awt.Cursor;
//#endif 


//#if 1195439602 
import java.awt.Toolkit;
//#endif 


//#if 1558309750 
import java.awt.Window;
//#endif 


//#if -900835326 
import java.awt.event.AWTEventListener;
//#endif 


//#if -2125560734 
import java.awt.event.KeyAdapter;
//#endif 


//#if 1590496247 
import java.awt.event.KeyEvent;
//#endif 


//#if -234925336 
import java.awt.event.MouseAdapter;
//#endif 


//#if 877380605 
import java.awt.event.MouseEvent;
//#endif 


//#if -2119751015 
import javax.swing.JComponent;
//#endif 


//#if 1128978963 
import javax.swing.RootPaneContainer;
//#endif 


//#if -1120688320 
import javax.swing.SwingUtilities;
//#endif 


//#if 795939319 
public class GlassPane extends 
//#if -149523134 
JComponent
//#endif 

 implements 
//#if 1902944607 
AWTEventListener
//#endif 

  { 

//#if 761498150 
private static final long serialVersionUID = -1170784689759475601L;
//#endif 


//#if -913767650 
private Window theWindow;
//#endif 


//#if -1897960083 
private Component activeComponent;
//#endif 


//#if 108247668 
public void setVisible(boolean value)
    { 

//#if 1284655219 
if(value)//1
{ 

//#if 1003659055 
if(theWindow == null)//1
{ 

//#if 140570434 
theWindow = SwingUtilities.windowForComponent(activeComponent);
//#endif 


//#if -929496914 
if(theWindow == null)//1
{ 

//#if 1331115447 
if(activeComponent instanceof Window)//1
{ 

//#if 1993965862 
theWindow = (Window) activeComponent;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -2098848940 
getTopLevelAncestor().setCursor(
                Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
//#endif 


//#if 2025931686 
activeComponent = theWindow.getFocusOwner();
//#endif 


//#if -1520401774 
Toolkit.getDefaultToolkit().addAWTEventListener(
                this, AWTEvent.KEY_EVENT_MASK);
//#endif 


//#if -1182457749 
this.requestFocus();
//#endif 


//#if -697509944 
super.setVisible(value);
//#endif 

} 
else
{ 

//#if -1004418133 
Toolkit.getDefaultToolkit().removeAWTEventListener(this);
//#endif 


//#if -1788899219 
super.setVisible(value);
//#endif 


//#if -402442616 
if(getTopLevelAncestor() != null)//1
{ 

//#if 73117091 
getTopLevelAncestor().setCursor(null);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1117611252 
public void eventDispatched(AWTEvent event)
    { 

//#if -1865222290 
Object source = event.getSource();
//#endif 


//#if -1435908430 
boolean sourceIsComponent = (event.getSource() instanceof Component);
//#endif 


//#if -1448693741 
if((event instanceof KeyEvent)
                && event.getID() != KeyEvent.KEY_RELEASED
                && sourceIsComponent)//1
{ 

//#if 1489498615 
if((SwingUtilities.windowForComponent((Component) source)
                    == theWindow))//1
{ 

//#if 1529375184 
((KeyEvent) event).consume();
//#endif 


//#if 1689033953 
Toolkit.getDefaultToolkit().beep();
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 139335035 
private void setActiveComponent(Component aComponent)
    { 

//#if -632370167 
activeComponent = aComponent;
//#endif 

} 

//#endif 


//#if -701117422 
public static synchronized GlassPane mount(Component startComponent,
            boolean create)
    { 

//#if -1516926092 
RootPaneContainer aContainer = null;
//#endif 


//#if 981253250 
Component aComponent = startComponent;
//#endif 


//#if -1669250775 
while ((aComponent.getParent() != null)
                && !(aComponent instanceof RootPaneContainer)) //1
{ 

//#if -1129184871 
aComponent = aComponent.getParent();
//#endif 

} 

//#endif 


//#if 312464006 
if(aComponent instanceof RootPaneContainer)//1
{ 

//#if -1664732369 
aContainer = (RootPaneContainer) aComponent;
//#endif 

} 

//#endif 


//#if 1583837788 
if(aContainer != null)//1
{ 

//#if -180896455 
if((aContainer.getGlassPane() != null)
                    && (aContainer.getGlassPane() instanceof GlassPane))//1
{ 

//#if 277552296 
return (GlassPane) aContainer.getGlassPane();
//#endif 

} 
else

//#if 1752598100 
if(create)//1
{ 

//#if -1213812896 
GlassPane aGlassPane = new GlassPane(startComponent);
//#endif 


//#if 68053672 
aContainer.setGlassPane(aGlassPane);
//#endif 


//#if 1688531053 
return aGlassPane;
//#endif 

} 
else
{ 

//#if 1534358104 
return null;
//#endif 

} 

//#endif 


//#endif 

} 
else
{ 

//#if 592626346 
return null;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1124185818 
protected GlassPane(Component component)
    { 

//#if 654761692 
addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            }
        });
//#endif 


//#if 1264847230 
addKeyListener(new KeyAdapter() {
        });
//#endif 


//#if 1142294059 
setActiveComponent(component);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

