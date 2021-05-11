
//#if -70254133 
// Compilation Unit of /PropPanelStateMachine.java 
 

//#if -1883041432 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if -502732230 
import javax.swing.ImageIcon;
//#endif 


//#if 1188800134 
import javax.swing.JList;
//#endif 


//#if 190442351 
import javax.swing.JScrollPane;
//#endif 


//#if -1115323463 
import org.argouml.i18n.Translator;
//#endif 


//#if 2074119231 
import org.argouml.uml.ui.ActionNavigateNamespace;
//#endif 


//#if 187517570 
import org.argouml.uml.ui.UMLComboBox2;
//#endif 


//#if 1829497 
import org.argouml.uml.ui.UMLComboBoxModel2;
//#endif 


//#if -1531054051 
import org.argouml.uml.ui.UMLComboBoxNavigator;
//#endif 


//#if 1058017832 
import org.argouml.uml.ui.UMLLinkedList;
//#endif 


//#if 1883598707 
import org.argouml.uml.ui.foundation.core.PropPanelModelElement;
//#endif 


//#if 1280277488 
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
//#endif 


//#if -900434514 
public class PropPanelStateMachine extends 
//#if 796185285 
PropPanelModelElement
//#endif 

  { 

//#if 922697497 
private static final long serialVersionUID = -2157218581140487530L;
//#endif 


//#if 400285529 
protected UMLComboBoxModel2 getContextComboBoxModel()
    { 

//#if -140297664 
return new UMLStateMachineContextComboBoxModel();
//#endif 

} 

//#endif 


//#if 114390691 
public PropPanelStateMachine(String name, ImageIcon icon)
    { 

//#if 105642284 
super(name, icon);
//#endif 


//#if -984580617 
initialize();
//#endif 

} 

//#endif 


//#if 1831505828 
protected void initialize()
    { 

//#if -1620827452 
addField("label.name", getNameTextField());
//#endif 


//#if -2022067700 
addField("label.namespace",
                 getNamespaceSelector());
//#endif 


//#if -635686595 
UMLComboBox2 contextComboBox =
            new UMLComboBox2(
            getContextComboBoxModel(),
            ActionSetContextStateMachine.getInstance());
//#endif 


//#if -1170881463 
addField("label.context",
                 new UMLComboBoxNavigator(
                     Translator.localize("label.context.navigate.tooltip"),
                     contextComboBox));
//#endif 


//#if -1726217759 
JList topList = new UMLLinkedList(new UMLStateMachineTopListModel());
//#endif 


//#if 1007424510 
addField("label.top-state",
                 new JScrollPane(topList));
//#endif 


//#if 1742077139 
addSeparator();
//#endif 


//#if -2128778361 
JList transitionList = new UMLLinkedList(
            new UMLStateMachineTransitionListModel());
//#endif 


//#if -1229979218 
addField("label.transition",
                 new JScrollPane(transitionList));
//#endif 


//#if 2038614273 
JList submachineStateList = new UMLLinkedList(
            new UMLStateMachineSubmachineStateListModel());
//#endif 


//#if 731302392 
addField("label.submachinestate",
                 new JScrollPane(submachineStateList));
//#endif 


//#if -1829685765 
addAction(new ActionNavigateNamespace());
//#endif 


//#if -871523581 
addAction(new ActionNewStereotype());
//#endif 


//#if -1798951754 
addAction(getDeleteAction());
//#endif 

} 

//#endif 


//#if 1638800224 
public PropPanelStateMachine()
    { 

//#if -1888088446 
this("label.statemachine", lookupIcon("StateMachine"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

