
//#if -568871242 
// Compilation Unit of /PropPanelStubState.java 
 

//#if 1190376970 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if -1524253879 
import javax.swing.JComboBox;
//#endif 


//#if 579316827 
import org.argouml.i18n.Translator;
//#endif 


//#if 1539723812 
import org.argouml.uml.ui.UMLComboBox2;
//#endif 


//#if -22135361 
import org.argouml.uml.ui.UMLComboBoxNavigator;
//#endif 


//#if 1984797289 
public class PropPanelStubState extends 
//#if 1950004918 
PropPanelStateVertex
//#endif 

  { 

//#if 829117324 
private static final long serialVersionUID = 5934039619236682498L;
//#endif 


//#if -1875640242 
public PropPanelStubState()
    { 

//#if -1133168700 
super("label.stub.state", lookupIcon("StubState"));
//#endif 


//#if -519607360 
addField("label.name", getNameTextField());
//#endif 


//#if 1543056586 
addField("label.container", getContainerScroll());
//#endif 


//#if 391615316 
JComboBox referencestateBox =
            new UMLComboBox2(
            new UMLStubStateComboBoxModel(),
            ActionSetStubStateReferenceState.getInstance());
//#endif 


//#if 1607725478 
addField("label.referencestate",
                 new UMLComboBoxNavigator(
                     Translator.localize("tooltip.nav-stubstate"),
                     referencestateBox));
//#endif 


//#if -2066218665 
addSeparator();
//#endif 


//#if -1992619744 
addField("label.incoming", getIncomingScroll());
//#endif 


//#if 1970330336 
addField("label.outgoing", getOutgoingScroll());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

