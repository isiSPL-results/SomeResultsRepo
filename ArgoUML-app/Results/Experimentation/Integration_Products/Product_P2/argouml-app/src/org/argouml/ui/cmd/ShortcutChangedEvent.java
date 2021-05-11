package org.argouml.ui.cmd;
import java.util.EventObject;
import javax.swing.KeyStroke;
public class ShortcutChangedEvent extends EventObject
  { 
private static final long serialVersionUID = 961611716902568240L;
private KeyStroke keyStroke;
public KeyStroke getKeyStroke()
    { 
return keyStroke;
} 
public ShortcutChangedEvent(Object source, KeyStroke newStroke)
    { 
super(source);
this.keyStroke = newStroke;
} 

 } 
