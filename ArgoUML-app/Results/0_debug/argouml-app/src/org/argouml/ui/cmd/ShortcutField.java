
//#if 377923035 
// Compilation Unit of /ShortcutField.java 
 

//#if 1567367971 
package org.argouml.ui.cmd;
//#endif 


//#if 456133171 
import java.awt.KeyboardFocusManager;
//#endif 


//#if -1450496896 
import java.awt.event.KeyEvent;
//#endif 


//#if -1336349176 
import java.awt.event.KeyListener;
//#endif 


//#if 189205142 
import java.util.Collections;
//#endif 


//#if -301257696 
import javax.swing.JTextField;
//#endif 


//#if 221372060 
import javax.swing.KeyStroke;
//#endif 


//#if 704892251 
import javax.swing.event.EventListenerList;
//#endif 


//#if 241219044 
import org.argouml.util.KeyEventUtils;
//#endif 


//#if 2050992912 
public class ShortcutField extends 
//#if 1988725188 
JTextField
//#endif 

  { 

//#if -311800258 
private static final long serialVersionUID = -62483698420802557L;
//#endif 


//#if -1984206003 
private EventListenerList listenerList = new EventListenerList();
//#endif 


//#if 1683728476 
public void addShortcutChangedListener(ShortcutChangedListener listener)
    { 

//#if -1021691906 
listenerList.add(ShortcutChangedListener.class, listener);
//#endif 

} 

//#endif 


//#if 158784742 
protected void fireShortcutChangedEvent(String text)
    { 

//#if -1061262975 
ShortcutChangedEvent event = null;
//#endif 


//#if -1505168853 
Object[] listeners = listenerList.getListenerList();
//#endif 


//#if -1057577517 
KeyStroke keyStroke = ShortcutMgr.decodeKeyStroke(text);
//#endif 


//#if -268802893 
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 

//#if 867957179 
if(listeners[i] == ShortcutChangedListener.class)//1
{ 

//#if -1412692158 
if(event == null)//1
{ 

//#if -229323228 
event = new ShortcutChangedEvent(this, keyStroke);
//#endif 

} 

//#endif 


//#if -961610572 
((ShortcutChangedListener) listeners[i + 1])
                .shortcutChange(event);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -90588789 
public ShortcutField(String text, int columns)
    { 

//#if 507631989 
super(null, text, columns);
//#endif 


//#if -1620015595 
this.setFocusTraversalKeys(
            KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS,
            Collections.EMPTY_SET);
//#endif 


//#if 917439269 
this.setFocusTraversalKeys(
            KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS,
            Collections.EMPTY_SET);
//#endif 


//#if 1796092032 
this.addKeyListener(new KeyListener() {
            private int currentKeyCode = 0;
            public void keyPressed(KeyEvent ke) {
                ke.consume();
                JTextField tf = (JTextField) ke.getSource();
                tf.setText(toString(ke));
            }

            public void keyReleased(KeyEvent ke) {
                ke.consume();
                JTextField tf = (JTextField) ke.getSource();
                switch(currentKeyCode) {
                case KeyEvent.VK_ALT:
                case KeyEvent.VK_ALT_GRAPH:
                case KeyEvent.VK_CONTROL:
                case KeyEvent.VK_SHIFT:
                    tf.setText("");
                    return;
                }
            }

            public void keyTyped(KeyEvent ke) {
                ke.consume();
            }

            private String toString(KeyEvent ke) {
                currentKeyCode = ke.getKeyCode();
                int keyCode = currentKeyCode;
                String modifText =
                    KeyEventUtils.getModifiersText(ke.getModifiers());

                if ("".equals(modifText)) {
                    // no modifiers - let's check if the key is valid
                    if (KeyEventUtils.isActionEvent(ke)) {
                        return KeyEventUtils.getKeyText(keyCode);
                    } else {
                        return "";
                    }
                } else {
                    switch(keyCode) {
                    case KeyEvent.VK_ALT:
                    case KeyEvent.VK_ALT_GRAPH:
                    case KeyEvent.VK_CONTROL:
                    case KeyEvent.VK_SHIFT:
                        return modifText; // middle of shortcut
                    default:
                        modifText += KeyEventUtils.getKeyText(ke.getKeyCode());
                        fireShortcutChangedEvent(modifText);
                        return modifText;
                    }
                }
            }
        });
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

