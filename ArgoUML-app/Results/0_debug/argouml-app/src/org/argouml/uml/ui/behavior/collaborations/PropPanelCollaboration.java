
//#if 1393442169 
// Compilation Unit of /PropPanelCollaboration.java 
 

//#if -1501488660 
package org.argouml.uml.ui.behavior.collaborations;
//#endif 


//#if -1994186937 
import javax.swing.JScrollPane;
//#endif 


//#if 157354897 
import org.argouml.i18n.Translator;
//#endif 


//#if 1479463769 
import org.argouml.uml.ui.ActionNavigateContainerElement;
//#endif 


//#if 1808868954 
import org.argouml.uml.ui.UMLComboBox2;
//#endif 


//#if 1460960245 
import org.argouml.uml.ui.UMLComboBoxNavigator;
//#endif 


//#if -219696816 
import org.argouml.uml.ui.UMLLinkedList;
//#endif 


//#if -1431402611 
import org.argouml.uml.ui.foundation.core.PropPanelNamespace;
//#endif 


//#if 1755217176 
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
//#endif 


//#if 1081805621 
public class PropPanelCollaboration extends 
//#if -52631286 
PropPanelNamespace
//#endif 

  { 

//#if -1634320508 
private static final long serialVersionUID = 5642815840272293391L;
//#endif 


//#if 1648732638 
public PropPanelCollaboration()
    { 

//#if -1718553884 
super("label.collaboration", lookupIcon("Collaboration"));
//#endif 


//#if -1237745430 
addField(Translator.localize("label.name"), getNameTextField());
//#endif 


//#if 129953392 
addField(Translator.localize("label.namespace"),
                 getNamespaceSelector());
//#endif 


//#if 1453389311 
UMLComboBox2 representedClassifierComboBox =
            new UMLComboBox2(
            new UMLCollaborationRepresentedClassifierComboBoxModel(),
            new ActionSetRepresentedClassifierCollaboration());
//#endif 


//#if -2096642333 
addField(Translator.localize("label.represented-classifier"),
                 new UMLComboBoxNavigator(
                     Translator.localize(
                         "label.represented-classifier."
                         + "navigate.tooltip"),
                     representedClassifierComboBox));
//#endif 


//#if -1408511147 
UMLComboBox2 representedOperationComboBox =
            new UMLComboBox2(
            new UMLCollaborationRepresentedOperationComboBoxModel(),
            new ActionSetRepresentedOperationCollaboration());
//#endif 


//#if 929158543 
addField(Translator.localize("label.represented-operation"),
                 new UMLComboBoxNavigator(
                     Translator.localize(
                         "label.represented-operation."
                         + "navigate.tooltip"),
                     representedOperationComboBox));
//#endif 


//#if 611695177 
addSeparator();
//#endif 


//#if -2036726995 
addField(Translator.localize("label.interaction"),
                 getSingleRowScroll(new UMLCollaborationInteractionListModel()));
//#endif 


//#if -434412681 
UMLLinkedList constrainingList =
            new UMLLinkedList(
            new UMLCollaborationConstrainingElementListModel());
//#endif 


//#if 525273444 
addField(Translator.localize("label.constraining-elements"),
                 new JScrollPane(constrainingList));
//#endif 


//#if -535172247 
addSeparator();
//#endif 


//#if 1638434685 
addField(Translator.localize("label.owned-elements"),
                 getOwnedElementsScroll());
//#endif 


//#if 1441943639 
addAction(new ActionNavigateContainerElement());
//#endif 


//#if 892994381 
addAction(new ActionNewStereotype());
//#endif 


//#if -1212537940 
addAction(getDeleteAction());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

