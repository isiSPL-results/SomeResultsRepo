// Compilation Unit of /InitUmlUI.java 
 
package org.argouml.uml.ui;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.argouml.application.api.AbstractArgoJPanel;
import org.argouml.application.api.GUISettingsTabInterface;
import org.argouml.application.api.InitSubsystem;
public class InitUmlUI implements InitSubsystem
  { 
public List<GUISettingsTabInterface> getProjectSettingsTabs()
    { 
return Collections.emptyList();
} 

public void init()
    { 
PropPanelFactory elementFactory = new ElementPropPanelFactory();
PropPanelFactoryManager.addPropPanelFactory(elementFactory);
PropPanelFactory umlObjectFactory = new UmlObjectPropPanelFactory();
PropPanelFactoryManager.addPropPanelFactory(umlObjectFactory);
} 

public List<GUISettingsTabInterface> getSettingsTabs()
    { 
return Collections.emptyList();
} 

public List<AbstractArgoJPanel> getDetailsTabs()
    { 
List<AbstractArgoJPanel> result =
            new ArrayList<AbstractArgoJPanel>();
result.add(new TabProps());
result.add(new TabDocumentation());
result.add(new TabStyle());
result.add(new TabSrc());
result.add(new TabConstraints());
result.add(new TabStereotype());
result.add(new TabTaggedValues());
return result;
} 

 } 


