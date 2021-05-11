package org.argouml.profile.init;
import org.argouml.profile.ProfileFacade;
import org.argouml.uml.ui.PropPanelFactory;
import org.argouml.uml.ui.PropPanelFactoryManager;
public class InitProfileSubsystem  { 
public void init()
    { 
ProfileFacade.setManager(
            new org.argouml.profile.internal.ProfileManagerImpl());
new ProfileLoader().doLoad();
} 

 } 
