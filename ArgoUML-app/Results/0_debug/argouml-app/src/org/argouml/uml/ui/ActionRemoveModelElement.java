
//#if -1421725240 
// Compilation Unit of /ActionRemoveModelElement.java 
 

//#if 1948978413 
package org.argouml.uml.ui;
//#endif 


//#if 1830531135 
import java.awt.event.ActionEvent;
//#endif 


//#if -27094098 
import org.argouml.kernel.Project;
//#endif 


//#if 1903984507 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -1077981511 
public class ActionRemoveModelElement extends 
//#if -349186703 
AbstractActionRemoveElement
//#endif 

  { 

//#if -395816804 
public static final ActionRemoveModelElement SINGLETON =
        new ActionRemoveModelElement();
//#endif 


//#if 1279931080 
public boolean isEnabled()
    { 

//#if 2108030864 
return getObjectToRemove() != null;
//#endif 

} 

//#endif 


//#if -52517698 
public void actionPerformed(ActionEvent e)
    { 

//#if 728523586 
super.actionPerformed(e);
//#endif 


//#if 114588706 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 976547499 
if(getObjectToRemove() != null
                && ActionDeleteModelElements.sureRemove(getObjectToRemove()))//1
{ 

//#if -1634790806 
p.moveToTrash(getObjectToRemove());
//#endif 

} 

//#endif 


//#if -1752610427 
setObjectToRemove(null);
//#endif 

} 

//#endif 


//#if -1453323283 
protected ActionRemoveModelElement()
    { 

//#if -579978363 
super();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

