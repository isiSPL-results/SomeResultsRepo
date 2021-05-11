
//#if -1227716120 
// Compilation Unit of /PropPanelEvent.java 
 

//#if -1281535128 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if -1828672454 
import javax.swing.ImageIcon;
//#endif 


//#if 503605382 
import javax.swing.JList;
//#endif 


//#if 1567173999 
import javax.swing.JScrollPane;
//#endif 


//#if 613023617 
import org.argouml.uml.ui.ActionNavigateContainerElement;
//#endif 


//#if -1123348440 
import org.argouml.uml.ui.UMLLinkedList;
//#endif 


//#if -428024358 
import org.argouml.uml.ui.UMLMutableLinkedList;
//#endif 


//#if 392957712 
import org.argouml.uml.ui.foundation.core.ActionNewParameter;
//#endif 


//#if 212233587 
import org.argouml.uml.ui.foundation.core.PropPanelModelElement;
//#endif 


//#if 1947990512 
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
//#endif 


//#if -933948416 
public abstract class PropPanelEvent extends 
//#if -1072605268 
PropPanelModelElement
//#endif 

  { 

//#if 776911845 
private JScrollPane paramScroll;
//#endif 


//#if -771969766 
private UMLEventParameterListModel paramListModel;
//#endif 


//#if -654977522 
public PropPanelEvent(String name, ImageIcon icon)
    { 

//#if 1059430884 
super(name, icon);
//#endif 


//#if -1760869713 
initialize();
//#endif 

} 

//#endif 


//#if -989273286 
protected JScrollPane getParameterScroll()
    { 

//#if -10193858 
if(paramScroll == null)//1
{ 

//#if 1861853701 
paramListModel = new UMLEventParameterListModel();
//#endif 


//#if -734248719 
JList paramList = new UMLMutableLinkedList(paramListModel,
                    new ActionNewParameter());
//#endif 


//#if -1354508719 
paramList.setVisibleRowCount(3);
//#endif 


//#if -1115923357 
paramScroll = new JScrollPane(paramList);
//#endif 

} 

//#endif 


//#if -156245871 
return paramScroll;
//#endif 

} 

//#endif 


//#if -1600370421 
protected void initialize()
    { 

//#if 368893859 
paramScroll = getParameterScroll();
//#endif 


//#if 1340411349 
addField("label.name", getNameTextField());
//#endif 


//#if 179415579 
addField("label.namespace", getNamespaceSelector());
//#endif 


//#if 29118562 
addSeparator();
//#endif 


//#if -1377844280 
addField("label.parameters", getParameterScroll());
//#endif 


//#if -2104722742 
JList transitionList = new UMLLinkedList(
            new UMLEventTransitionListModel());
//#endif 


//#if -332001048 
transitionList.setVisibleRowCount(2);
//#endif 


//#if 1463593599 
addField("label.transition",
                 new JScrollPane(transitionList));
//#endif 


//#if -112266576 
addSeparator();
//#endif 


//#if 1299333744 
addAction(new ActionNavigateContainerElement());
//#endif 


//#if -31693100 
addAction(new ActionNewStereotype());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

