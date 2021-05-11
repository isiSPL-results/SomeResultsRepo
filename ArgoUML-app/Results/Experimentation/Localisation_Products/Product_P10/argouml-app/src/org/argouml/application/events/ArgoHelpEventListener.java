package org.argouml.application.events;
import org.argouml.application.api.ArgoEventListener;
public interface ArgoHelpEventListener extends ArgoEventListener
  { 
public void helpRemoved(ArgoHelpEvent e);public void helpChanged(ArgoHelpEvent e);
 } 
