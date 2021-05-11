
//#if 1760345612 
// Compilation Unit of /PropPanelDependency.java 
 

//#if -1951169311 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 1484973271 
import javax.swing.ImageIcon;
//#endif 


//#if -1156745309 
import javax.swing.JList;
//#endif 


//#if -885017908 
import javax.swing.JScrollPane;
//#endif 


//#if -61975402 
import org.argouml.i18n.Translator;
//#endif 


//#if 319440322 
import org.argouml.uml.ui.ActionNavigateNamespace;
//#endif 


//#if 1718109035 
import org.argouml.uml.ui.UMLLinkedList;
//#endif 


//#if -63200525 
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
//#endif 


//#if 1113029600 
public class PropPanelDependency extends 
//#if 449802776 
PropPanelRelationship
//#endif 

  { 

//#if 517491457 
private static final long serialVersionUID = 3665986064546532722L;
//#endif 


//#if 1928887365 
private JScrollPane supplierScroll;
//#endif 


//#if 2036523558 
private JScrollPane clientScroll;
//#endif 


//#if -374262211 
protected JScrollPane getClientScroll()
    { 

//#if -87060865 
return clientScroll;
//#endif 

} 

//#endif 


//#if 2133019491 
public PropPanelDependency()
    { 

//#if -73278627 
this("label.dependency", lookupIcon("Dependency"));
//#endif 


//#if -475859950 
addField(Translator.localize("label.name"),
                 getNameTextField());
//#endif 


//#if 163612744 
addField(Translator.localize("label.namespace"),
                 getNamespaceSelector());
//#endif 


//#if 1875975537 
addSeparator();
//#endif 


//#if -634999792 
addField(Translator.localize("label.suppliers"),
                 supplierScroll);
//#endif 


//#if -2030685618 
addField(Translator.localize("label.clients"),
                 clientScroll);
//#endif 


//#if 970679069 
addAction(new ActionNavigateNamespace());
//#endif 


//#if -590370523 
addAction(new ActionNewStereotype());
//#endif 


//#if 1815404756 
addAction(getDeleteAction());
//#endif 

} 

//#endif 


//#if 1412467262 
protected JScrollPane getSupplierScroll()
    { 

//#if -2094604454 
return supplierScroll;
//#endif 

} 

//#endif 


//#if -1741718877 
protected PropPanelDependency(String name, ImageIcon icon)
    { 

//#if -47809157 
super(name, icon);
//#endif 


//#if 1403984185 
JList supplierList = new UMLLinkedList(
            new UMLDependencySupplierListModel(), true);
//#endif 


//#if 176846021 
supplierScroll = new JScrollPane(supplierList);
//#endif 


//#if 1742038903 
JList clientList = new UMLLinkedList(
            new UMLDependencyClientListModel(), true);
//#endif 


//#if -1069036285 
clientScroll = new JScrollPane(clientList);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

