// Compilation Unit of /InitProfileSubsystem.java 
 
package org.argouml.profile.init;
import org.argouml.profile.ProfileFacade;
import org.argouml.uml.ui.PropPanelFactory;
import org.argouml.uml.ui.PropPanelFactoryManager;

//#if COGNITIVE 
import org.argouml.profile.internal.ui.ProfilePropPanelFactory;
//#endif 

public class InitProfileSubsystem  { 
public void init()
    { 
ProfileFacade.setManager(
            new org.argouml.profile.internal.ProfileManagerImpl());

//#if COGNITIVE 
PropPanelFactory factory = new ProfilePropPanelFactory();
//#endif 


//#if COGNITIVE 
PropPanelFactoryManager.addPropPanelFactory(factory);
//#endif 

new ProfileLoader().doLoad();
} 

 } 


