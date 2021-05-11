
//#if -2064757108 
// Compilation Unit of /PropPanelFactoryManager.java 
 

//#if -652886317 
package org.argouml.uml.ui;
//#endif 


//#if 1141940946 
import java.util.ArrayList;
//#endif 


//#if -1914938161 
import java.util.Collection;
//#endif 


//#if 252876879 
import java.util.List;
//#endif 


//#if 556975294 
public class PropPanelFactoryManager  { 

//#if -398897895 
private static List<PropPanelFactory> ppfactories =
        new ArrayList<PropPanelFactory>();
//#endif 


//#if -303550740 
public static void removePropPanelFactory(PropPanelFactory factory)
    { 

//#if 49534455 
ppfactories.remove(factory);
//#endif 

} 

//#endif 


//#if -1362062979 
public static void addPropPanelFactory(PropPanelFactory factory)
    { 

//#if 892164318 
ppfactories.add(0, factory);
//#endif 

} 

//#endif 


//#if 928530340 
static Collection<PropPanelFactory> getFactories()
    { 

//#if -212106512 
return ppfactories;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

