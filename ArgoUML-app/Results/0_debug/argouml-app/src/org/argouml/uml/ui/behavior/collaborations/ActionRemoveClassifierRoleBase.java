
//#if 1626990286 
// Compilation Unit of /ActionRemoveClassifierRoleBase.java 
 

//#if 766235063 
package org.argouml.uml.ui.behavior.collaborations;
//#endif 


//#if -821299655 
import java.awt.event.ActionEvent;
//#endif 


//#if -791496356 
import org.argouml.i18n.Translator;
//#endif 


//#if 1207865890 
import org.argouml.model.Model;
//#endif 


//#if 294133456 
import org.argouml.uml.ui.AbstractActionRemoveElement;
//#endif 


//#if -2077910968 
public class ActionRemoveClassifierRoleBase extends 
//#if -1751745998 
AbstractActionRemoveElement
//#endif 

  { 

//#if -2059285825 
private static final ActionRemoveClassifierRoleBase SINGLETON =
        new ActionRemoveClassifierRoleBase();
//#endif 


//#if -1450809627 
public static ActionRemoveClassifierRoleBase getInstance()
    { 

//#if 830145099 
return SINGLETON;
//#endif 

} 

//#endif 


//#if 20393983 
public void actionPerformed(ActionEvent e)
    { 

//#if 1388850152 
super.actionPerformed(e);
//#endif 


//#if 1589807118 
Model.getCollaborationsHelper()
        .removeBase(getTarget(), getObjectToRemove());
//#endif 

} 

//#endif 


//#if 1527477507 
protected ActionRemoveClassifierRoleBase()
    { 

//#if 1787712646 
super(Translator.localize("menu.popup.remove"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

