
//#if 151787900 
// Compilation Unit of /InitUmlUI.java 
 

//#if 522145018 
package org.argouml.uml.ui;
//#endif 


//#if -1977995015 
import java.util.ArrayList;
//#endif 


//#if 395175035 
import java.util.Collections;
//#endif 


//#if -1082880568 
import java.util.List;
//#endif 


//#if 1739199394 
import org.argouml.application.api.AbstractArgoJPanel;
//#endif 


//#if 1581616829 
import org.argouml.application.api.GUISettingsTabInterface;
//#endif 


//#if -1980795680 
import org.argouml.application.api.InitSubsystem;
//#endif 


//#if 384935641 
public class InitUmlUI implements 
//#if -15906216 
InitSubsystem
//#endif 

  { 

//#if -1462229873 
public List<GUISettingsTabInterface> getProjectSettingsTabs()
    { 

//#if -1940332467 
return Collections.emptyList();
//#endif 

} 

//#endif 


//#if 682776565 
public void init()
    { 

//#if 66440163 
PropPanelFactory elementFactory = new ElementPropPanelFactory();
//#endif 


//#if -1078442564 
PropPanelFactoryManager.addPropPanelFactory(elementFactory);
//#endif 


//#if 414127989 
PropPanelFactory umlObjectFactory = new UmlObjectPropPanelFactory();
//#endif 


//#if 584521317 
PropPanelFactoryManager.addPropPanelFactory(umlObjectFactory);
//#endif 

} 

//#endif 


//#if -99244178 
public List<GUISettingsTabInterface> getSettingsTabs()
    { 

//#if 1678553722 
return Collections.emptyList();
//#endif 

} 

//#endif 


//#if -904709498 
public List<AbstractArgoJPanel> getDetailsTabs()
    { 

//#if -342141078 
List<AbstractArgoJPanel> result =
            new ArrayList<AbstractArgoJPanel>();
//#endif 


//#if 1725030879 
result.add(new TabProps());
//#endif 


//#if -1796077015 
result.add(new TabDocumentation());
//#endif 


//#if -54055520 
result.add(new TabStyle());
//#endif 


//#if 452127571 
result.add(new TabSrc());
//#endif 


//#if -1759437147 
result.add(new TabConstraints());
//#endif 


//#if 472382249 
result.add(new TabStereotype());
//#endif 


//#if -1700234587 
result.add(new TabTaggedValues());
//#endif 


//#if 1841572677 
return result;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

