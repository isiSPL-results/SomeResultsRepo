package org.argouml.uml.ui.behavior.collaborations;
import java.awt.event.ActionEvent;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLComboBox2;
import org.argouml.uml.ui.UMLComboBoxModel2;
import org.argouml.uml.ui.UMLListCellRenderer2;
import org.argouml.uml.ui.UMLUserInterfaceContainer;
public class UMLMessageActivatorComboBox extends UMLComboBox2
  { 
protected void doIt(ActionEvent event)
    { 
Object o = getModel().getElementAt(getSelectedIndex());
Object activator = o;
Object mes = getTarget();
if(activator != Model.getFacade().getActivator(mes))//1
{ 
Model.getCollaborationsHelper().setActivator(mes, activator);
} 
} 
public UMLMessageActivatorComboBox(
        UMLUserInterfaceContainer container,
        UMLComboBoxModel2 arg0)
    { 
super(arg0);
setRenderer(new UMLListCellRenderer2(true));
} 

 } 
