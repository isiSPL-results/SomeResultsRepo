package org.argouml.uml.ui;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
public class PropPanelFactoryManager  { 
private static List<PropPanelFactory> ppfactories =
        new ArrayList<PropPanelFactory>();
public static void removePropPanelFactory(PropPanelFactory factory)
    { 
ppfactories.remove(factory);
} 
public static void addPropPanelFactory(PropPanelFactory factory)
    { 
ppfactories.add(0, factory);
} 
static Collection<PropPanelFactory> getFactories()
    { 
return ppfactories;
} 

 } 
