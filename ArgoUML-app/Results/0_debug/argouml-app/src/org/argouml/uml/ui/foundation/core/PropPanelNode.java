
//#if 1277888701 
// Compilation Unit of /PropPanelNode.java 
 

//#if 1042293215 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -1900152799 
import javax.swing.JList;
//#endif 


//#if 1105288394 
import javax.swing.JScrollPane;
//#endif 


//#if -1779511404 
import org.argouml.i18n.Translator;
//#endif 


//#if -145849254 
import org.argouml.model.Model;
//#endif 


//#if 619078428 
import org.argouml.uml.ui.ActionNavigateContainerElement;
//#endif 


//#if -1317865683 
import org.argouml.uml.ui.UMLLinkedList;
//#endif 


//#if -1109552118 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -1352436427 
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
//#endif 


//#if 994585301 
public class PropPanelNode extends 
//#if -120192724 
PropPanelClassifier
//#endif 

  { 

//#if 1943376714 
private static final long serialVersionUID = 2681345252220104772L;
//#endif 


//#if 887264773 
public PropPanelNode()
    { 

//#if -806698371 
super("label.node", lookupIcon("Node"));
//#endif 


//#if -1506788143 
addField(Translator.localize("label.name"), getNameTextField());
//#endif 


//#if -1066424727 
addField(Translator.localize("label.namespace"),
                 getNamespaceSelector());
//#endif 


//#if -402440284 
add(getModifiersPanel());
//#endif 


//#if 398491696 
addSeparator();
//#endif 


//#if -2105650740 
addField("Generalizations:", getGeneralizationScroll());
//#endif 


//#if 437610796 
addField("Specializations:", getSpecializationScroll());
//#endif 


//#if 176556066 
addSeparator();
//#endif 


//#if 495566649 
JList resList = new UMLLinkedList(
            new UMLNodeDeployedComponentListModel());
//#endif 


//#if -107257051 
addField(Translator.localize("label.deployedcomponents"),
                 new JScrollPane(resList));
//#endif 


//#if 848542270 
addAction(new ActionNavigateContainerElement());
//#endif 


//#if -2116085065 
addAction(getActionNewReception());
//#endif 


//#if 1601684422 
addAction(new ActionNewStereotype());
//#endif 


//#if 256182611 
addAction(getDeleteAction());
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 743510419 
class UMLNodeDeployedComponentListModel extends 
//#if 1822294960 
UMLModelElementListModel2
//#endif 

  { 

//#if 1936710877 
private static final long serialVersionUID = -7137518645846584922L;
//#endif 


//#if -566804737 
protected boolean isValidElement(Object o)
    { 

//#if 480643141 
return (Model.getFacade().isAComponent(o));
//#endif 

} 

//#endif 


//#if 718388612 
public UMLNodeDeployedComponentListModel()
    { 

//#if -1891466876 
super("deployedComponent");
//#endif 

} 

//#endif 


//#if -413161954 
protected void buildModelList()
    { 

//#if -1487876997 
if(Model.getFacade().isANode(getTarget()))//1
{ 

//#if -1610178236 
setAllElements(
                Model.getFacade().getDeployedComponents(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

