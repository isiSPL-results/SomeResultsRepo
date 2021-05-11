
//#if 45359278 
// Compilation Unit of /PropPanelActivityGraph.java 
 

//#if -480887256 
package org.argouml.uml.ui.behavior.activity_graphs;
//#endif 


//#if -2108394819 
import javax.swing.JList;
//#endif 


//#if -1585417626 
import javax.swing.JScrollPane;
//#endif 


//#if 1049737008 
import org.argouml.i18n.Translator;
//#endif 


//#if 1458412022 
import org.argouml.model.Model;
//#endif 


//#if 473738466 
import org.argouml.uml.ui.UMLComboBoxModel2;
//#endif 


//#if 1471967505 
import org.argouml.uml.ui.UMLLinkedList;
//#endif 


//#if -1721018386 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -1247864771 
import org.argouml.uml.ui.behavior.state_machines.PropPanelStateMachine;
//#endif 


//#if 964519152 
public class PropPanelActivityGraph extends 
//#if -622907761 
PropPanelStateMachine
//#endif 

  { 

//#if -635578652 
@Override
    protected UMLComboBoxModel2 getContextComboBoxModel()
    { 

//#if -1702220660 
return new UMLActivityGraphContextComboBoxModel();
//#endif 

} 

//#endif 


//#if -961506448 
public PropPanelActivityGraph()
    { 

//#if -588737380 
super("label.activity-graph-title", lookupIcon("ActivityGraph"));
//#endif 

} 

//#endif 


//#if -1616814353 
@Override
    protected void initialize()
    { 

//#if -1216122222 
super.initialize();
//#endif 


//#if 1708540177 
addSeparator();
//#endif 


//#if 2104631505 
JList partitionList = new UMLLinkedList(
            new UMLActivityGraphPartiitionListModel());
//#endif 


//#if 629028090 
addField(Translator.localize("label.partition"),
                 new JScrollPane(partitionList));
//#endif 

} 

//#endif 


//#if -476950382 
public class UMLActivityGraphPartiitionListModel extends 
//#if -985966737 
UMLModelElementListModel2
//#endif 

  { 

//#if -294023023 
protected boolean isValidElement(Object element)
        { 

//#if 106526533 
return Model.getFacade().getPartitions(getTarget())
                   .contains(element);
//#endif 

} 

//#endif 


//#if 1168048733 
protected void buildModelList()
        { 

//#if 2053104612 
setAllElements(Model.getFacade().getPartitions(getTarget()));
//#endif 

} 

//#endif 


//#if 1842088658 
public UMLActivityGraphPartiitionListModel()
        { 

//#if -1482386060 
super("partition");
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

