
//#if 2134663162 
// Compilation Unit of /UMLMessageActivatorComboBox.java 
 

//#if -108935000 
package org.argouml.uml.ui.behavior.collaborations;
//#endif 


//#if -213607640 
import java.awt.event.ActionEvent;
//#endif 


//#if 810986387 
import org.argouml.model.Model;
//#endif 


//#if -717943018 
import org.argouml.uml.ui.UMLComboBox2;
//#endif 


//#if -723787163 
import org.argouml.uml.ui.UMLComboBoxModel2;
//#endif 


//#if -998490052 
import org.argouml.uml.ui.UMLListCellRenderer2;
//#endif 


//#if -316487816 
import org.argouml.uml.ui.UMLUserInterfaceContainer;
//#endif 


//#if -1857933622 
public class UMLMessageActivatorComboBox extends 
//#if 101867988 
UMLComboBox2
//#endif 

  { 

//#if -1727985712 
protected void doIt(ActionEvent event)
    { 

//#if -739714410 
Object o = getModel().getElementAt(getSelectedIndex());
//#endif 


//#if 287111667 
Object activator = o;
//#endif 


//#if -1962264780 
Object mes = getTarget();
//#endif 


//#if -1349151561 
if(activator != Model.getFacade().getActivator(mes))//1
{ 

//#if 1717127039 
Model.getCollaborationsHelper().setActivator(mes, activator);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 270702466 
public UMLMessageActivatorComboBox(
        UMLUserInterfaceContainer container,
        UMLComboBoxModel2 arg0)
    { 

//#if 1600097070 
super(arg0);
//#endif 


//#if 496143464 
setRenderer(new UMLListCellRenderer2(true));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

