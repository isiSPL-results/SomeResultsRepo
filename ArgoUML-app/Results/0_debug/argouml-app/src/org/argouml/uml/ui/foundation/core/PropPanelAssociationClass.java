
//#if 2035581235 
// Compilation Unit of /PropPanelAssociationClass.java 
 

//#if 942348772 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -443132058 
import javax.swing.JList;
//#endif 


//#if -926649265 
import javax.swing.JScrollPane;
//#endif 


//#if 1052810393 
import org.argouml.i18n.Translator;
//#endif 


//#if 158635871 
import org.argouml.uml.ui.ActionNavigateNamespace;
//#endif 


//#if -1119779512 
import org.argouml.uml.ui.UMLLinkedList;
//#endif 


//#if 754030352 
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
//#endif 


//#if -768606833 
public class PropPanelAssociationClass extends 
//#if 967956730 
PropPanelClassifier
//#endif 

  { 

//#if 1689897702 
private static final long serialVersionUID = -7620821534700927917L;
//#endif 


//#if -1987508106 
private JScrollPane attributeScroll;
//#endif 


//#if -993971381 
private JScrollPane operationScroll;
//#endif 


//#if -1438563452 
private JScrollPane assocEndScroll;
//#endif 


//#if -504519431 
private static UMLClassAttributeListModel attributeListModel =
        new UMLClassAttributeListModel();
//#endif 


//#if -439884646 
private static UMLClassOperationListModel operationListModel =
        new UMLClassOperationListModel();
//#endif 


//#if -512014200 
public PropPanelAssociationClass()
    { 

//#if -946915630 
super("label.association-class", lookupIcon("AssociationClass"));
//#endif 


//#if -411748183 
addField(Translator.localize("label.name"),
                 getNameTextField());
//#endif 


//#if -879985263 
addField(Translator.localize("label.namespace"),
                 getNamespaceSelector());
//#endif 


//#if -897560068 
getModifiersPanel().add(new UMLClassActiveCheckBox());
//#endif 


//#if 2046123388 
add(getModifiersPanel());
//#endif 


//#if 1622558340 
add(getVisibilityPanel());
//#endif 


//#if 21859336 
addSeparator();
//#endif 


//#if -769962206 
addField(Translator.localize("label.client-dependencies"),
                 getClientDependencyScroll());
//#endif 


//#if -1585873022 
addField(Translator.localize("label.supplier-dependencies"),
                 getSupplierDependencyScroll());
//#endif 


//#if 941018164 
addField(Translator.localize("label.generalizations"),
                 getGeneralizationScroll());
//#endif 


//#if -810687596 
addField(Translator.localize("label.specializations"),
                 getSpecializationScroll());
//#endif 


//#if -1201549071 
JList assocEndList = new UMLLinkedList(
            new UMLAssociationConnectionListModel());
//#endif 


//#if 753585155 
assocEndScroll = new JScrollPane(assocEndList);
//#endif 


//#if -1216167131 
addField(Translator.localize("label.connections"),
                 assocEndScroll);
//#endif 


//#if -1623503542 
addSeparator();
//#endif 


//#if -408933916 
addField(Translator.localize("label.attributes"),
                 getAttributeScroll());
//#endif 


//#if 1030327540 
JList connections = new UMLLinkedList(
            new UMLClassifierAssociationEndListModel());
//#endif 


//#if -2139311894 
JScrollPane connectionsScroll = new JScrollPane(connections);
//#endif 


//#if -2105803133 
addField(Translator.localize("label.association-ends"),
                 connectionsScroll);
//#endif 


//#if 1702594042 
addField(Translator.localize("label.operations"),
                 getOperationScroll());
//#endif 


//#if 1498603836 
addField(Translator.localize("label.owned-elements"),
                 getOwnedElementsScroll());
//#endif 


//#if -2067350426 
addAction(new ActionNavigateNamespace());
//#endif 


//#if 1333061957 
addAction(new ActionAddAttribute());
//#endif 


//#if -1420839280 
addAction(new ActionAddOperation());
//#endif 


//#if 1451739791 
addAction(getActionNewReception());
//#endif 


//#if 688344190 
addAction(new ActionNewInnerClass());
//#endif 


//#if 573924098 
addAction(new ActionNewClass());
//#endif 


//#if 535105262 
addAction(new ActionNewStereotype());
//#endif 


//#if -54232277 
addAction(getDeleteAction());
//#endif 

} 

//#endif 


//#if -1106203215 
@Override
    public JScrollPane getOperationScroll()
    { 

//#if 1981413417 
if(operationScroll == null)//1
{ 

//#if -435143531 
JList list = new UMLLinkedList(operationListModel);
//#endif 


//#if 1474160393 
operationScroll = new JScrollPane(list);
//#endif 

} 

//#endif 


//#if -848600888 
return operationScroll;
//#endif 

} 

//#endif 


//#if -1841070618 
@Override
    public JScrollPane getAttributeScroll()
    { 

//#if 1748086298 
if(attributeScroll == null)//1
{ 

//#if -1794109868 
JList list = new UMLLinkedList(attributeListModel);
//#endif 


//#if 1957551570 
attributeScroll = new JScrollPane(list);
//#endif 

} 

//#endif 


//#if -213721681 
return attributeScroll;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

