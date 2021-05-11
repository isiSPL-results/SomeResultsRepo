
//#if 1217709682 
// Compilation Unit of /PropPanelInstance.java 
 

//#if -2142384419 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if -1551451893 
import javax.swing.ImageIcon;
//#endif 


//#if 1189438333 
import javax.swing.JPanel;
//#endif 


//#if 1554114306 
import org.argouml.uml.ui.foundation.core.PropPanelModelElement;
//#endif 


//#if 1623153984 
public abstract class PropPanelInstance extends 
//#if 1897227080 
PropPanelModelElement
//#endif 

  { 

//#if 1659647549 
private JPanel stimuliSenderScroll;
//#endif 


//#if -224270269 
private JPanel stimuliReceiverScroll;
//#endif 


//#if -2144453341 
private static UMLInstanceSenderStimulusListModel stimuliSenderListModel
        = new UMLInstanceSenderStimulusListModel();
//#endif 


//#if 1906596305 
private static UMLInstanceReceiverStimulusListModel
    stimuliReceiverListModel = new UMLInstanceReceiverStimulusListModel();
//#endif 


//#if -2016339530 
protected JPanel getStimuliSenderScroll()
    { 

//#if -1021300820 
if(stimuliSenderScroll == null)//1
{ 

//#if -1319222569 
stimuliSenderScroll = getSingleRowScroll(stimuliSenderListModel);
//#endif 

} 

//#endif 


//#if -1357098635 
return stimuliSenderScroll;
//#endif 

} 

//#endif 


//#if -1395807611 
public PropPanelInstance(String name, ImageIcon icon)
    { 

//#if -223900615 
super(name, icon);
//#endif 

} 

//#endif 


//#if 2069423792 
protected JPanel getStimuliReceiverScroll()
    { 

//#if 1878918033 
if(stimuliReceiverScroll == null)//1
{ 

//#if -1970313974 
stimuliReceiverScroll =
                getSingleRowScroll(stimuliReceiverListModel);
//#endif 

} 

//#endif 


//#if -1106307930 
return stimuliReceiverScroll;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

