
//#if 866553789 
// Compilation Unit of /PropPanelSynchState.java 
 

//#if 1334007295 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if 1754003459 
import org.argouml.uml.ui.UMLTextField2;
//#endif 


//#if 337405619 
public class PropPanelSynchState extends 
//#if 722013744 
PropPanelStateVertex
//#endif 

  { 

//#if -174989044 
private static final long serialVersionUID = -6671890304679263593L;
//#endif 


//#if -986046367 
public PropPanelSynchState()
    { 

//#if -1137218708 
super("label.synch-state", lookupIcon("SynchState"));
//#endif 


//#if 1676520343 
addField("label.name", getNameTextField());
//#endif 


//#if -1837449965 
addField("label.container", getContainerScroll());
//#endif 


//#if 1888303971 
addField("label.bound",
                 new UMLTextField2(new UMLSynchStateBoundDocument()));
//#endif 


//#if -1548258336 
addSeparator();
//#endif 


//#if -700049495 
addField("label.incoming", getIncomingScroll());
//#endif 


//#if -1032066711 
addField("label.outgoing", getOutgoingScroll());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

