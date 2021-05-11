package org.argouml.uml.ui.behavior.common_behavior;
import java.awt.event.ActionEvent;
import org.argouml.i18n.Translator;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectManager;
import org.argouml.uml.ui.AbstractActionRemoveElement;
public class ActionRemoveArgument extends AbstractActionRemoveElement
  { 
public void actionPerformed(ActionEvent e)
    { 
super.actionPerformed(e);
if(getObjectToRemove() != null)//1
{ 
Project p = ProjectManager.getManager().getCurrentProject();
Object o = getObjectToRemove();
setObjectToRemove(null);
p.moveToTrash(o);
} 
} 
protected ActionRemoveArgument()
    { 
super(Translator.localize("menu.popup.delete"));
} 

 } 
