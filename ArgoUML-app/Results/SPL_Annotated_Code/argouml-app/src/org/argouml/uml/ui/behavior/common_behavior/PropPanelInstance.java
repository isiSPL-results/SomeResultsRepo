// Compilation Unit of /PropPanelInstance.java 
 
package org.argouml.uml.ui.behavior.common_behavior;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import org.argouml.uml.ui.foundation.core.PropPanelModelElement;
public abstract class PropPanelInstance extends PropPanelModelElement
  { 
private JPanel stimuliSenderScroll;
private JPanel stimuliReceiverScroll;
private static UMLInstanceSenderStimulusListModel stimuliSenderListModel
        = new UMLInstanceSenderStimulusListModel();
private static UMLInstanceReceiverStimulusListModel
    stimuliReceiverListModel = new UMLInstanceReceiverStimulusListModel();
protected JPanel getStimuliSenderScroll()
    { 
if(stimuliSenderScroll == null)//1
{ 
stimuliSenderScroll = getSingleRowScroll(stimuliSenderListModel);
} 

return stimuliSenderScroll;
} 

public PropPanelInstance(String name, ImageIcon icon)
    { 
super(name, icon);
} 

protected JPanel getStimuliReceiverScroll()
    { 
if(stimuliReceiverScroll == null)//1
{ 
stimuliReceiverScroll =
                getSingleRowScroll(stimuliReceiverListModel);
} 

return stimuliReceiverScroll;
} 

 } 


