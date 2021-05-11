
//#if 451573729 
// Compilation Unit of /PropPanelCreateAction.java 
 

//#if -1575217673 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if -1325037914 
import javax.swing.JScrollPane;
//#endif 


//#if 552774512 
import org.argouml.i18n.Translator;
//#endif 


//#if 1954816676 
import org.argouml.uml.ui.AbstractActionAddModelElement2;
//#endif 


//#if -456791791 
import org.argouml.uml.ui.UMLMutableLinkedList;
//#endif 


//#if -1276806399 
public class PropPanelCreateAction extends 
//#if 332768085 
PropPanelAction
//#endif 

  { 

//#if 1096892012 
private static final long serialVersionUID = 6909604490593418840L;
//#endif 


//#if 1337277929 
public PropPanelCreateAction()
    { 

//#if -462642202 
super("label.create-action", lookupIcon("CreateAction"));
//#endif 


//#if 1847324655 
AbstractActionAddModelElement2 action =
            new ActionAddCreateActionInstantiation();
//#endif 


//#if 1354240166 
UMLMutableLinkedList list =
            new UMLMutableLinkedList(
            new UMLCreateActionClassifierListModel(),
            action, null, null, true);
//#endif 


//#if -2104792859 
list.setVisibleRowCount(2);
//#endif 


//#if -17412413 
JScrollPane instantiationScroll = new JScrollPane(list);
//#endif 


//#if 2020118526 
addFieldBefore(Translator.localize("label.instantiation"),
                       instantiationScroll,
                       argumentsScroll);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

