
//#if 583873935 
// Compilation Unit of /ActionWrapper.java 
 

//#if -989255505 
package org.argouml.ui.cmd;
//#endif 


//#if 1148090687 
import javax.swing.AbstractAction;
//#endif 


//#if 27504936 
import javax.swing.KeyStroke;
//#endif 


//#if 975893468 
class ActionWrapper  { 

//#if -1119744605 
private KeyStroke defaultShortcut;
//#endif 


//#if -1792096917 
private KeyStroke currentShortcut;
//#endif 


//#if -2082433643 
private String key;
//#endif 


//#if 715900784 
private AbstractAction actionInstance;
//#endif 


//#if -1292784660 
private String actionInstanceName;
//#endif 


//#if -582365983 
protected ActionWrapper(String actionKey, KeyStroke currentKeyStroke,
                            KeyStroke defaultKeyStroke, AbstractAction action,
                            String actionName)
    { 

//#if 1391581049 
this.key = actionKey;
//#endif 


//#if 2034069430 
this.currentShortcut = currentKeyStroke;
//#endif 


//#if -77439674 
this.defaultShortcut = defaultKeyStroke;
//#endif 


//#if -1049513732 
this.actionInstance = action;
//#endif 


//#if -332207268 
this.actionInstanceName = actionName;
//#endif 

} 

//#endif 


//#if 779800933 
public KeyStroke getDefaultShortcut()
    { 

//#if -1567462246 
return defaultShortcut;
//#endif 

} 

//#endif 


//#if -709030365 
public String getActionName()
    { 

//#if 252051854 
return actionInstanceName;
//#endif 

} 

//#endif 


//#if -827757761 
public String getKey()
    { 

//#if -795794314 
return key;
//#endif 

} 

//#endif 


//#if 935385969 
public void setCurrentShortcut(KeyStroke actualShortcut)
    { 

//#if 1494628213 
this.currentShortcut = actualShortcut;
//#endif 

} 

//#endif 


//#if 1411715741 
public KeyStroke getCurrentShortcut()
    { 

//#if -520491173 
return currentShortcut;
//#endif 

} 

//#endif 


//#if -1276320282 
public AbstractAction getActionInstance()
    { 

//#if -1542127935 
return this.actionInstance;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

