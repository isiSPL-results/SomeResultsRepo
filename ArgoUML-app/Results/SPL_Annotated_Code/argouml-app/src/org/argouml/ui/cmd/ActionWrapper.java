// Compilation Unit of /ActionWrapper.java 
 
package org.argouml.ui.cmd;
import javax.swing.AbstractAction;
import javax.swing.KeyStroke;
class ActionWrapper  { 
private KeyStroke defaultShortcut;
private KeyStroke currentShortcut;
private String key;
private AbstractAction actionInstance;
private String actionInstanceName;
protected ActionWrapper(String actionKey, KeyStroke currentKeyStroke,
                            KeyStroke defaultKeyStroke, AbstractAction action,
                            String actionName)
    { 
this.key = actionKey;
this.currentShortcut = currentKeyStroke;
this.defaultShortcut = defaultKeyStroke;
this.actionInstance = action;
this.actionInstanceName = actionName;
} 

public KeyStroke getDefaultShortcut()
    { 
return defaultShortcut;
} 

public String getActionName()
    { 
return actionInstanceName;
} 

public String getKey()
    { 
return key;
} 

public void setCurrentShortcut(KeyStroke actualShortcut)
    { 
this.currentShortcut = actualShortcut;
} 

public KeyStroke getCurrentShortcut()
    { 
return currentShortcut;
} 

public AbstractAction getActionInstance()
    { 
return this.actionInstance;
} 

 } 


