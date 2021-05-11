// Compilation Unit of /GlassPane.java 
 
package org.argouml.swingext;
import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.RootPaneContainer;
import javax.swing.SwingUtilities;
public class GlassPane extends JComponent
 implements AWTEventListener
  { 
private static final long serialVersionUID = -1170784689759475601L;
private Window theWindow;
private Component activeComponent;
public void setVisible(boolean value)
    { 
if(value)//1
{ 
if(theWindow == null)//1
{ 
theWindow = SwingUtilities.windowForComponent(activeComponent);
if(theWindow == null)//1
{ 
if(activeComponent instanceof Window)//1
{ 
theWindow = (Window) activeComponent;
} 

} 

} 

getTopLevelAncestor().setCursor(
                Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
activeComponent = theWindow.getFocusOwner();
Toolkit.getDefaultToolkit().addAWTEventListener(
                this, AWTEvent.KEY_EVENT_MASK);
this.requestFocus();
super.setVisible(value);
} 
else
{ 
Toolkit.getDefaultToolkit().removeAWTEventListener(this);
super.setVisible(value);
if(getTopLevelAncestor() != null)//1
{ 
getTopLevelAncestor().setCursor(null);
} 

} 

} 

public void eventDispatched(AWTEvent event)
    { 
Object source = event.getSource();
boolean sourceIsComponent = (event.getSource() instanceof Component);
if((event instanceof KeyEvent)
                && event.getID() != KeyEvent.KEY_RELEASED
                && sourceIsComponent)//1
{ 
if((SwingUtilities.windowForComponent((Component) source)
                    == theWindow))//1
{ 
((KeyEvent) event).consume();
Toolkit.getDefaultToolkit().beep();
} 

} 

} 

private void setActiveComponent(Component aComponent)
    { 
activeComponent = aComponent;
} 

public static synchronized GlassPane mount(Component startComponent,
            boolean create)
    { 
RootPaneContainer aContainer = null;
Component aComponent = startComponent;
while ((aComponent.getParent() != null)
                && !(aComponent instanceof RootPaneContainer)) //1
{ 
aComponent = aComponent.getParent();
} 

if(aComponent instanceof RootPaneContainer)//1
{ 
aContainer = (RootPaneContainer) aComponent;
} 

if(aContainer != null)//1
{ 
if((aContainer.getGlassPane() != null)
                    && (aContainer.getGlassPane() instanceof GlassPane))//1
{ 
return (GlassPane) aContainer.getGlassPane();
} 
else
if(create)//1
{ 
GlassPane aGlassPane = new GlassPane(startComponent);
aContainer.setGlassPane(aGlassPane);
return aGlassPane;
} 
else
{ 
return null;
} 


} 
else
{ 
return null;
} 

} 

protected GlassPane(Component component)
    { 
addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            }
        });
addKeyListener(new KeyAdapter() {
        });
setActiveComponent(component);
} 

 } 


