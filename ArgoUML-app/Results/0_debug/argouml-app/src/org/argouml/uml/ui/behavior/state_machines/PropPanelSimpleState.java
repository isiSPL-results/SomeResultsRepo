
//#if 1271966053 
// Compilation Unit of /PropPanelSimpleState.java 
 

//#if 1679565106 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if 1920986500 
import javax.swing.ImageIcon;
//#endif 


//#if 818276413 
public class PropPanelSimpleState extends 
//#if -1486844714 
AbstractPropPanelState
//#endif 

  { 

//#if 1433555179 
private static final long serialVersionUID = 7072535148338954868L;
//#endif 


//#if -348615871 
private PropPanelSimpleState(String name, ImageIcon icon)
    { 

//#if -1917925176 
super(name, icon);
//#endif 


//#if 472716024 
addField("label.name", getNameTextField());
//#endif 


//#if -625248622 
addField("label.container", getContainerScroll());
//#endif 


//#if -361004748 
addField("label.entry", getEntryScroll());
//#endif 


//#if -1576138008 
addField("label.exit", getExitScroll());
//#endif 


//#if 978220234 
addField("label.do-activity", getDoScroll());
//#endif 


//#if 1113500385 
addField("label.deferrable", getDeferrableEventsScroll());
//#endif 


//#if 1960000799 
addSeparator();
//#endif 


//#if -703257368 
addField("label.incoming", getIncomingScroll());
//#endif 


//#if -1035274584 
addField("label.outgoing", getOutgoingScroll());
//#endif 


//#if -385275065 
addField("label.internal-transitions", getInternalTransitionsScroll());
//#endif 

} 

//#endif 


//#if 1680756332 
public PropPanelSimpleState()
    { 

//#if 1501116326 
this("label.simple.state", lookupIcon("SimpleState"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

