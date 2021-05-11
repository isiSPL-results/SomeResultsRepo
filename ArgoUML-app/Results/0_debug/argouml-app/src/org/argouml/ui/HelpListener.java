
//#if -811708006 
// Compilation Unit of /HelpListener.java 
 

//#if -285844314 
package org.argouml.ui;
//#endif 


//#if -76828306 
import org.argouml.application.events.ArgoHelpEvent;
//#endif 


//#if 1771749402 
import org.argouml.application.events.ArgoHelpEventListener;
//#endif 


//#if -313492222 
public class HelpListener implements 
//#if 1449039111 
ArgoHelpEventListener
//#endif 

  { 

//#if 867722033 
private StatusBar myStatusBar;
//#endif 


//#if -455467087 
public void helpRemoved(ArgoHelpEvent e)
    { 

//#if 2072604052 
myStatusBar.showStatus("");
//#endif 

} 

//#endif 


//#if -1816509947 
public void helpChanged(ArgoHelpEvent e)
    { 

//#if -1475826540 
myStatusBar.showStatus(e.getHelpText());
//#endif 

} 

//#endif 


//#if 959461850 
public HelpListener(StatusBar bar)
    { 

//#if 557239290 
myStatusBar = bar;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

