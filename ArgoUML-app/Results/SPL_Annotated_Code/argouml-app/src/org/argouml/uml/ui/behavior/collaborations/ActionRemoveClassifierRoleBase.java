// Compilation Unit of /ActionRemoveClassifierRoleBase.java 
 
package org.argouml.uml.ui.behavior.collaborations;
import java.awt.event.ActionEvent;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.uml.ui.AbstractActionRemoveElement;
public class ActionRemoveClassifierRoleBase extends AbstractActionRemoveElement
  { 
private static final ActionRemoveClassifierRoleBase SINGLETON =
        new ActionRemoveClassifierRoleBase();
public static ActionRemoveClassifierRoleBase getInstance()
    { 
return SINGLETON;
} 

public void actionPerformed(ActionEvent e)
    { 
super.actionPerformed(e);
Model.getCollaborationsHelper()
        .removeBase(getTarget(), getObjectToRemove());
} 

protected ActionRemoveClassifierRoleBase()
    { 
super(Translator.localize("menu.popup.remove"));
} 

 } 


