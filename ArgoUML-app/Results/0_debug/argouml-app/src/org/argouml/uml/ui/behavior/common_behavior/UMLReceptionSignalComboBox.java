
//#if -1708813681 
// Compilation Unit of /UMLReceptionSignalComboBox.java 
 

//#if 713650948 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if -1246042126 
import java.awt.event.ActionEvent;
//#endif 


//#if -922836215 
import org.argouml.model.Model;
//#endif 


//#if 897659020 
import org.argouml.uml.ui.UMLComboBox2;
//#endif 


//#if -581420369 
import org.argouml.uml.ui.UMLComboBoxModel2;
//#endif 


//#if 1117948850 
import org.argouml.uml.ui.UMLListCellRenderer2;
//#endif 


//#if 462370242 
import org.argouml.uml.ui.UMLUserInterfaceContainer;
//#endif 


//#if -1092954049 
public class UMLReceptionSignalComboBox extends 
//#if -326106205 
UMLComboBox2
//#endif 

  { 

//#if 1979764001 
protected void doIt(ActionEvent event)
    { 

//#if 678789751 
Object o = getModel().getElementAt(getSelectedIndex());
//#endif 


//#if 67145825 
Object signal = o;
//#endif 


//#if -1305908639 
Object reception = getTarget();
//#endif 


//#if 328471420 
if(signal != Model.getFacade().getSignal(reception))//1
{ 

//#if 325359645 
Model.getCommonBehaviorHelper().setSignal(reception, signal);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1564805270 
public UMLReceptionSignalComboBox(
        UMLUserInterfaceContainer container,
        UMLComboBoxModel2 arg0)
    { 

//#if 1813568536 
super(arg0);
//#endif 


//#if 1237950014 
setRenderer(new UMLListCellRenderer2(true));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

