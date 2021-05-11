// Compilation Unit of /ActionSetAssociationRoleBase.java 
 
package org.argouml.uml.ui.behavior.collaborations;
import java.awt.event.ActionEvent;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLComboBox2;
import org.tigris.gef.undo.UndoableAction;
public class ActionSetAssociationRoleBase extends UndoableAction
  { 
public void actionPerformed(ActionEvent e)
    { 
super.actionPerformed(e);
if(e.getSource() instanceof UMLComboBox2)//1
{ 
UMLComboBox2 source = (UMLComboBox2) e.getSource();
Object assoc = source.getSelectedItem();
Object ar = source.getTarget();
if(Model.getFacade().getBase(ar) == assoc)//1
{ 
return;
} 

if(Model.getFacade().isAAssociation(assoc)
                    && Model.getFacade().isAAssociationRole(ar))//1
{ 
Model.getCollaborationsHelper().setBase(ar, assoc);
} 

} 

} 

public ActionSetAssociationRoleBase()
    { 
super();
} 

 } 


