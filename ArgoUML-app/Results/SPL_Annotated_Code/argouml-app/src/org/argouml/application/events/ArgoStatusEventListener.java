// Compilation Unit of /ArgoStatusEventListener.java 
 
package org.argouml.application.events;
import org.argouml.application.api.ArgoEventListener;
public interface ArgoStatusEventListener extends ArgoEventListener
  { 
public void projectModified(ArgoStatusEvent e);
public void statusText(ArgoStatusEvent e);
public void statusCleared(ArgoStatusEvent e);
public void projectLoaded(ArgoStatusEvent e);
public void projectSaved(ArgoStatusEvent e);
 } 


