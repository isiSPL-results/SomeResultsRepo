
//#if 1327921865 
// Compilation Unit of /PropPanelAssociation.java 
 

//#if -248196156 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 736414022 
import javax.swing.JList;
//#endif 


//#if 1460964846 
import javax.swing.JPanel;
//#endif 


//#if -2043806161 
import javax.swing.JScrollPane;
//#endif 


//#if -1231931783 
import org.argouml.i18n.Translator;
//#endif 


//#if -88645567 
import org.argouml.uml.ui.ActionNavigateContainerElement;
//#endif 


//#if 331683688 
import org.argouml.uml.ui.UMLLinkedList;
//#endif 


//#if 911642928 
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
//#endif 


//#if -690985079 
public class PropPanelAssociation extends 
//#if 449672637 
PropPanelRelationship
//#endif 

  { 

//#if 719693877 
private static final long serialVersionUID = 4272135235664638209L;
//#endif 


//#if 1239733360 
private JScrollPane assocEndScroll;
//#endif 


//#if 1390144687 
private JScrollPane associationRoleScroll;
//#endif 


//#if 770785613 
private JScrollPane linksScroll;
//#endif 


//#if 1214969970 
private JPanel modifiersPanel;
//#endif 


//#if 1817538310 
public PropPanelAssociation()
    { 

//#if -84613090 
this("label.association");
//#endif 


//#if 2136774458 
addField("label.name", getNameTextField());
//#endif 


//#if -6430122 
addField("label.namespace", getNamespaceSelector());
//#endif 


//#if 1048162202 
add(modifiersPanel);
//#endif 


//#if -1753642467 
addSeparator();
//#endif 


//#if 480351774 
addField("label.connections", assocEndScroll);
//#endif 


//#if 1219500821 
addSeparator();
//#endif 


//#if 1760263041 
addField("label.association-roles", associationRoleScroll);
//#endif 


//#if 1063471591 
addField("label.association-links", linksScroll);
//#endif 


//#if -1532899285 
addAction(new ActionNavigateContainerElement());
//#endif 


//#if 1522278393 
addAction(new ActionNewStereotype());
//#endif 


//#if -31739776 
addAction(getDeleteAction());
//#endif 

} 

//#endif 


//#if 17018700 
private void initialize()
    { 

//#if -713103978 
modifiersPanel = createBorderPanel(
                             Translator.localize("label.modifiers"));
//#endif 


//#if 1209968115 
modifiersPanel.add(new UMLGeneralizableElementAbstractCheckBox());
//#endif 


//#if 361947311 
modifiersPanel.add(new UMLGeneralizableElementLeafCheckBox());
//#endif 


//#if 1188797491 
modifiersPanel.add(new UMLGeneralizableElementRootCheckBox());
//#endif 

} 

//#endif 


//#if -1702559016 
protected PropPanelAssociation(String title)
    { 

//#if 289968940 
super(title, lookupIcon("Association"));
//#endif 


//#if -988455414 
initialize();
//#endif 


//#if 1926908351 
JList assocEndList = new UMLLinkedList(
            new UMLAssociationConnectionListModel());
//#endif 


//#if -516836107 
assocEndScroll = new JScrollPane(assocEndList);
//#endif 


//#if 1539320093 
JList baseList = new UMLLinkedList(
            new UMLAssociationAssociationRoleListModel());
//#endif 


//#if -2079884527 
associationRoleScroll = new JScrollPane(baseList);
//#endif 


//#if -849497897 
JList linkList = new UMLLinkedList(new UMLAssociationLinkListModel());
//#endif 


//#if 594858140 
linksScroll = new JScrollPane(linkList);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

