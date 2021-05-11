
//#if -2027194617 
// Compilation Unit of /PropPanelAssociationRole.java 
 

//#if 1374887662 
package org.argouml.uml.ui.behavior.collaborations;
//#endif 


//#if 1331686785 
import javax.swing.JComboBox;
//#endif 


//#if 2119426016 
import javax.swing.JList;
//#endif 


//#if -1527498423 
import javax.swing.JScrollPane;
//#endif 


//#if 1127306387 
import org.argouml.i18n.Translator;
//#endif 


//#if 1042513916 
import org.argouml.uml.diagram.ui.ActionAddMessage;
//#endif 


//#if 253071067 
import org.argouml.uml.ui.ActionNavigateContainerElement;
//#endif 


//#if 1114709596 
import org.argouml.uml.ui.UMLComboBox2;
//#endif 


//#if -1832562185 
import org.argouml.uml.ui.UMLComboBoxNavigator;
//#endif 


//#if -263800434 
import org.argouml.uml.ui.UMLLinkedList;
//#endif 


//#if -557099031 
import org.argouml.uml.ui.foundation.core.PropPanelAssociation;
//#endif 


//#if -1455745851 
public class PropPanelAssociationRole extends 
//#if -1597737460 
PropPanelAssociation
//#endif 

  { 

//#if -2006065969 
private static final long serialVersionUID = 7693759162647306494L;
//#endif 


//#if 1073291596 
public PropPanelAssociationRole()
    { 

//#if -1983074139 
super("label.association-role-title");
//#endif 


//#if 2040069642 
addField(Translator.localize("label.name"), getNameTextField());
//#endif 


//#if 78263632 
addField(Translator.localize("label.namespace"),
                 getNamespaceSelector());
//#endif 


//#if 785640984 
JComboBox baseComboBox =
            new UMLComboBox2(new UMLAssociationRoleBaseComboBoxModel(),
                             new ActionSetAssociationRoleBase());
//#endif 


//#if -1729764379 
addField(Translator.localize("label.base"),
                 new UMLComboBoxNavigator(
                     Translator.localize("label.association.navigate.tooltip"),
                     baseComboBox));
//#endif 


//#if -923797655 
addSeparator();
//#endif 


//#if 328212074 
JList assocEndList = new UMLLinkedList(
            new UMLAssociationRoleAssociationEndRoleListModel());
//#endif 


//#if -1069500514 
assocEndList.setVisibleRowCount(2);
//#endif 


//#if 597857846 
addField(Translator.localize("label.associationrole-ends"),
                 new JScrollPane(assocEndList));
//#endif 


//#if -53617936 
JList messageList =
            new UMLLinkedList(new UMLAssociationRoleMessageListModel());
//#endif 


//#if 156242229 
addField(Translator.localize("label.messages"),
                 new JScrollPane(messageList));
//#endif 


//#if -1255142025 
addAction(new ActionNavigateContainerElement());
//#endif 


//#if -1382482812 
addAction(ActionAddMessage.getTargetFollower());
//#endif 


//#if -2106398516 
addAction(getDeleteAction());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

