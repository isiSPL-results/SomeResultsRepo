
//#if 1349560950 
// Compilation Unit of /PropPanelSignalEvent.java 
 

//#if -2053402194 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if -1168575924 
import javax.swing.JList;
//#endif 


//#if -1971008843 
import javax.swing.JScrollPane;
//#endif 


//#if 498970070 
import org.argouml.uml.ui.foundation.core.ActionNewParameter;
//#endif 


//#if -1992602604 
public class PropPanelSignalEvent extends 
//#if -799866295 
PropPanelEvent
//#endif 

  { 

//#if -1923858517 
public PropPanelSignalEvent()
    { 

//#if -1387311151 
super("label.signal.event", lookupIcon("SignalEvent"));
//#endif 

} 

//#endif 


//#if -686347702 
@Override
    public void initialize()
    { 

//#if -1166604015 
super.initialize();
//#endif 


//#if -1162340431 
JList signalList = new UMLSignalEventSignalList(
            new UMLSignalEventSignalListModel());
//#endif 


//#if -16045853 
signalList.setVisibleRowCount(2);
//#endif 


//#if -290855439 
addField("label.signal",
                 new JScrollPane(signalList));
//#endif 


//#if -776349637 
addAction(new ActionNewParameter());
//#endif 


//#if 730329139 
addAction(getDeleteAction());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

