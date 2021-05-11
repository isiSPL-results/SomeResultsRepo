
//#if 1901611058 
// Compilation Unit of /ArgoStatusEventListener.java 
 

//#if -1157949785 
package org.argouml.application.events;
//#endif 


//#if -649152288 
import org.argouml.application.api.ArgoEventListener;
//#endif 


//#if -1332562151 
public interface ArgoStatusEventListener extends 
//#if 144691147 
ArgoEventListener
//#endif 

  { 

//#if -121839482 
public void projectModified(ArgoStatusEvent e);
//#endif 


//#if -667462671 
public void statusText(ArgoStatusEvent e);
//#endif 


//#if 1630974750 
public void statusCleared(ArgoStatusEvent e);
//#endif 


//#if 1263561538 
public void projectLoaded(ArgoStatusEvent e);
//#endif 


//#if 1041957664 
public void projectSaved(ArgoStatusEvent e);
//#endif 

 } 

//#endif 


//#endif 

