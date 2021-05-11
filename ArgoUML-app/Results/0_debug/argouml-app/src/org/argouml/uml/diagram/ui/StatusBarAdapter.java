
//#if -267208937 
// Compilation Unit of /StatusBarAdapter.java 
 

//#if -554515560 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -2048241154 
import org.argouml.application.events.ArgoEventPump;
//#endif 


//#if 1047324951 
import org.argouml.application.events.ArgoEventTypes;
//#endif 


//#if -252866600 
import org.argouml.application.events.ArgoStatusEvent;
//#endif 


//#if -1934843077 
import org.tigris.gef.ui.IStatusBar;
//#endif 


//#if -1754519692 
public class StatusBarAdapter implements 
//#if -1046768004 
IStatusBar
//#endif 

  { 

//#if -1106366111 
public void showStatus(String statusText)
    { 

//#if 1266087990 
ArgoEventPump.fireEvent(new ArgoStatusEvent(ArgoEventTypes.STATUS_TEXT,
                                this, statusText));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

