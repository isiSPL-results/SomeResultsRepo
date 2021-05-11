
//#if 323145220 
// Compilation Unit of /InitProfileSubsystem.java 
 

//#if -758144715 
package org.argouml.profile.init;
//#endif 


//#if 1963680657 
import org.argouml.profile.ProfileFacade;
//#endif 


//#if 1344930406 
import org.argouml.uml.ui.PropPanelFactory;
//#endif 


//#if 1291162051 
import org.argouml.uml.ui.PropPanelFactoryManager;
//#endif 


//#if 473741707 
import org.argouml.profile.internal.ui.ProfilePropPanelFactory;
//#endif 


//#if 1964024339 
public class InitProfileSubsystem  { 

//#if 1295613531 
public void init()
    { 

//#if -1185207966 
ProfileFacade.setManager(
            new org.argouml.profile.internal.ProfileManagerImpl());
//#endif 


//#if -114619914 
PropPanelFactory factory = new ProfilePropPanelFactory();
//#endif 


//#if -135830402 
PropPanelFactoryManager.addPropPanelFactory(factory);
//#endif 


//#if -2026838450 
new ProfileLoader().doLoad();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

