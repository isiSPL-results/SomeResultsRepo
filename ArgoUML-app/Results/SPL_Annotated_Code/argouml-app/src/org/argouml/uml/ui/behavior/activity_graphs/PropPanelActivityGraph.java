// Compilation Unit of /PropPanelActivityGraph.java 
 
package org.argouml.uml.ui.behavior.activity_graphs;
import javax.swing.JList;
import javax.swing.JScrollPane;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLComboBoxModel2;
import org.argouml.uml.ui.UMLLinkedList;
import org.argouml.uml.ui.UMLModelElementListModel2;
import org.argouml.uml.ui.behavior.state_machines.PropPanelStateMachine;
public class PropPanelActivityGraph extends PropPanelStateMachine
  { 
@Override
    protected UMLComboBoxModel2 getContextComboBoxModel()
    { 
return new UMLActivityGraphContextComboBoxModel();
} 

public PropPanelActivityGraph()
    { 
super("label.activity-graph-title", lookupIcon("ActivityGraph"));
} 

@Override
    protected void initialize()
    { 
super.initialize();
addSeparator();
JList partitionList = new UMLLinkedList(
            new UMLActivityGraphPartiitionListModel());
addField(Translator.localize("label.partition"),
                 new JScrollPane(partitionList));
} 

public class UMLActivityGraphPartiitionListModel extends UMLModelElementListModel2
  { 
protected boolean isValidElement(Object element)
        { 
return Model.getFacade().getPartitions(getTarget())
                   .contains(element);
} 

protected void buildModelList()
        { 
setAllElements(Model.getFacade().getPartitions(getTarget()));
} 

public UMLActivityGraphPartiitionListModel()
        { 
super("partition");
} 

 } 

 } 


