
//#if 1072013055 
// Compilation Unit of /PropPanelSubmachineState.java 
 

//#if -948323270 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if -792494452 
import javax.swing.ImageIcon;
//#endif 


//#if 1517454713 
import javax.swing.JComboBox;
//#endif 


//#if 901821249 
import javax.swing.JScrollPane;
//#endif 


//#if 1153438347 
import org.argouml.i18n.Translator;
//#endif 


//#if 1107304532 
import org.argouml.uml.ui.UMLComboBox2;
//#endif 


//#if 2047794159 
import org.argouml.uml.ui.UMLComboBoxNavigator;
//#endif 


//#if -1669169236 
import org.argouml.uml.ui.UMLMutableLinkedList;
//#endif 


//#if -861735904 
import org.tigris.swidgets.Orientation;
//#endif 


//#if -1303908352 
public class PropPanelSubmachineState extends 
//#if -812047990 
PropPanelCompositeState
//#endif 

  { 

//#if 384904010 
private static final long serialVersionUID = 2384673708664550264L;
//#endif 


//#if 2134753500 
@Override
    protected void addExtraButtons()
    { 
} 

//#endif 


//#if 1611215107 
public PropPanelSubmachineState(final String name, final ImageIcon icon)
    { 

//#if 2016306552 
super(name, icon);
//#endif 


//#if -359862205 
initialize();
//#endif 

} 

//#endif 


//#if 264786642 
@Override
    protected void updateExtraButtons()
    { 
} 

//#endif 


//#if 1901526644 
public PropPanelSubmachineState()
    { 

//#if 1585967460 
super("label.submachine-state", lookupIcon("SubmachineState"));
//#endif 


//#if -240804141 
addField("label.name", getNameTextField());
//#endif 


//#if -1891504553 
addField("label.container", getContainerScroll());
//#endif 


//#if -1449735097 
final JComboBox submachineBox = new UMLComboBox2(
            new UMLSubmachineStateComboBoxModel(),
            ActionSetSubmachineStateSubmachine.getInstance());
//#endif 


//#if 1781136187 
addField("label.submachine",
                 new UMLComboBoxNavigator(Translator.localize(
                                              "tooltip.nav-submachine"), submachineBox));
//#endif 


//#if 170167801 
addField("label.entry", getEntryScroll());
//#endif 


//#if -1414691603 
addField("label.exit", getExitScroll());
//#endif 


//#if -1814858267 
addField("label.do-activity", getDoScroll());
//#endif 


//#if -962841052 
addSeparator();
//#endif 


//#if 1391512045 
addField("label.incoming", getIncomingScroll());
//#endif 


//#if 1059494829 
addField("label.outgoing", getOutgoingScroll());
//#endif 


//#if 317436066 
addField("label.internal-transitions", getInternalTransitionsScroll());
//#endif 


//#if 2088836526 
addSeparator();
//#endif 


//#if -933472863 
addField("label.subvertex",
                 new JScrollPane(new UMLMutableLinkedList(
                                     new UMLCompositeStateSubvertexListModel(), null,
                                     ActionNewStubState.getInstance())));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

