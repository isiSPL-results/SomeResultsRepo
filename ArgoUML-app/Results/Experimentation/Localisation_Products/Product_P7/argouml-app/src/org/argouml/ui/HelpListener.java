package org.argouml.ui;
import org.argouml.application.events.ArgoHelpEvent;
import org.argouml.application.events.ArgoHelpEventListener;
public class HelpListener implements ArgoHelpEventListener
  { 
private StatusBar myStatusBar;
public void helpRemoved(ArgoHelpEvent e)
    { 
myStatusBar.showStatus("");
} 
public void helpChanged(ArgoHelpEvent e)
    { 
myStatusBar.showStatus(e.getHelpText());
} 
public HelpListener(StatusBar bar)
    { 
myStatusBar = bar;
} 

 } 
