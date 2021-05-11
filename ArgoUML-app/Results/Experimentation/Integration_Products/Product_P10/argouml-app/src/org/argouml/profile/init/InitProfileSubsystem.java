package org.argouml.profile.init;
import org.argouml.profile.ProfileFacade;
import org.argouml.uml.ui.PropPanelFactory;
import org.argouml.uml.ui.PropPanelFactoryManager;
import org.argouml.profile.internal.ui.ProfilePropPanelFactory;
public class InitProfileSubsystem  { 
public void init()
    { 
ProfileFacade.setManager(
            new org.argouml.profile.internal.ProfileManagerImpl());
PropPanelFactory factory = new ProfilePropPanelFactory();
PropPanelFactoryManager.addPropPanelFactory(factory);
new ProfileLoader().doLoad();
} 

 } 
