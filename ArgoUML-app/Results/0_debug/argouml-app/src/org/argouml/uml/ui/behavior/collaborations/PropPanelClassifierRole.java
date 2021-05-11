
//#if -1904897996 
// Compilation Unit of /PropPanelClassifierRole.java 
 

//#if -2122987833 
package org.argouml.uml.ui.behavior.collaborations;
//#endif 


//#if 1818764537 
import javax.swing.JList;
//#endif 


//#if 654092443 
import javax.swing.JPanel;
//#endif 


//#if -327383134 
import javax.swing.JScrollPane;
//#endif 


//#if -691483028 
import org.argouml.i18n.Translator;
//#endif 


//#if 484913140 
import org.argouml.uml.ui.ActionNavigateContainerElement;
//#endif 


//#if -272728235 
import org.argouml.uml.ui.UMLLinkedList;
//#endif 


//#if 1542405477 
import org.argouml.uml.ui.UMLMultiplicityPanel;
//#endif 


//#if -1183616499 
import org.argouml.uml.ui.UMLMutableLinkedList;
//#endif 


//#if -393646382 
import org.argouml.uml.ui.foundation.core.PropPanelClassifier;
//#endif 


//#if -923820195 
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
//#endif 


//#if 1293346338 
public class PropPanelClassifierRole extends 
//#if 378714116 
PropPanelClassifier
//#endif 

  { 

//#if 911518416 
private static final long serialVersionUID = -5407549104529347513L;
//#endif 


//#if 1037465929 
private UMLMultiplicityPanel multiplicityComboBox;
//#endif 


//#if 392166738 
public PropPanelClassifierRole()
    { 

//#if -2041244968 
super("label.classifier-role", lookupIcon("ClassifierRole"));
//#endif 


//#if -1739079911 
addField(Translator.localize("label.name"), getNameTextField());
//#endif 


//#if 1245852961 
addField(Translator.localize("label.namespace"),
                 getNamespaceSelector());
//#endif 


//#if -628628801 
addField(Translator.localize("label.multiplicity"),
                 getMultiplicityComboBox());
//#endif 


//#if -1445803550 
JList baseList =
            new UMLMutableLinkedList(new UMLClassifierRoleBaseListModel(),
                                     ActionAddClassifierRoleBase.SINGLETON,
                                     null,
                                     ActionRemoveClassifierRoleBase.getInstance(),
                                     true);
//#endif 


//#if 438501239 
addField(Translator.localize("label.base"),
                 new JScrollPane(baseList));
//#endif 


//#if -1960791432 
addSeparator();
//#endif 


//#if 1580111524 
addField(Translator.localize("label.generalizations"),
                 getGeneralizationScroll());
//#endif 


//#if -171594236 
addField(Translator.localize("label.specializations"),
                 getSpecializationScroll());
//#endif 


//#if -48430567 
addField(Translator.localize("label.associationrole-ends"),
                 getAssociationEndScroll());
//#endif 


//#if 1912688858 
addSeparator();
//#endif 


//#if -1237217123 
JList availableContentsList =
            new UMLLinkedList(
            new UMLClassifierRoleAvailableContentsListModel());
//#endif 


//#if -993880612 
addField(Translator.localize("label.available-contents"),
                 new JScrollPane(availableContentsList));
//#endif 


//#if 467293821 
JList availableFeaturesList =
            new UMLLinkedList(
            new UMLClassifierRoleAvailableFeaturesListModel());
//#endif 


//#if -756646724 
addField(Translator.localize("label.available-features"),
                 new JScrollPane(availableFeaturesList));
//#endif 


//#if -1386689402 
addAction(new ActionNavigateContainerElement());
//#endif 


//#if -264808193 
addAction(getActionNewReception());
//#endif 


//#if -1138274690 
addAction(new ActionNewStereotype());
//#endif 


//#if 991665563 
addAction(getDeleteAction());
//#endif 

} 

//#endif 


//#if 1240912745 
protected JPanel getMultiplicityComboBox()
    { 

//#if 1390388028 
if(multiplicityComboBox == null)//1
{ 

//#if -497001552 
multiplicityComboBox =
                new UMLMultiplicityPanel();
//#endif 

} 

//#endif 


//#if 1611900597 
return multiplicityComboBox;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

