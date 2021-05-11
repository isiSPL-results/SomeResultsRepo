
//#if 90930479 
// Compilation Unit of /ActionSetAssociationRoleBase.java 
 

//#if 954221061 
package org.argouml.uml.ui.behavior.collaborations;
//#endif 


//#if 485451819 
import java.awt.event.ActionEvent;
//#endif 


//#if -1316506256 
import org.argouml.model.Model;
//#endif 


//#if -60757005 
import org.argouml.uml.ui.UMLComboBox2;
//#endif 


//#if 1341281217 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -2044150092 
public class ActionSetAssociationRoleBase extends 
//#if 1879790108 
UndoableAction
//#endif 

  { 

//#if 61580165 
public void actionPerformed(ActionEvent e)
    { 

//#if -1138356138 
super.actionPerformed(e);
//#endif 


//#if -282529053 
if(e.getSource() instanceof UMLComboBox2)//1
{ 

//#if -1186054880 
UMLComboBox2 source = (UMLComboBox2) e.getSource();
//#endif 


//#if 490462159 
Object assoc = source.getSelectedItem();
//#endif 


//#if 1339479084 
Object ar = source.getTarget();
//#endif 


//#if 773973344 
if(Model.getFacade().getBase(ar) == assoc)//1
{ 

//#if 364566562 
return;
//#endif 

} 

//#endif 


//#if 1394730546 
if(Model.getFacade().isAAssociation(assoc)
                    && Model.getFacade().isAAssociationRole(ar))//1
{ 

//#if -1185225949 
Model.getCollaborationsHelper().setBase(ar, assoc);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -2121338674 
public ActionSetAssociationRoleBase()
    { 

//#if 751194580 
super();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

