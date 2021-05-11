// Compilation Unit of /ActionRemoveModelElement.java 
 
package org.argouml.uml.ui;
import java.awt.event.ActionEvent;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectManager;
public class ActionRemoveModelElement extends AbstractActionRemoveElement
  { 
public static final ActionRemoveModelElement SINGLETON =
        new ActionRemoveModelElement();
public boolean isEnabled()
    { 
return getObjectToRemove() != null;
} 

public void actionPerformed(ActionEvent e)
    { 
super.actionPerformed(e);
Project p = ProjectManager.getManager().getCurrentProject();
if(getObjectToRemove() != null
                && ActionDeleteModelElements.sureRemove(getObjectToRemove()))//1
{ 
p.moveToTrash(getObjectToRemove());
} 

setObjectToRemove(null);
} 

protected ActionRemoveModelElement()
    { 
super();
} 

 } 


