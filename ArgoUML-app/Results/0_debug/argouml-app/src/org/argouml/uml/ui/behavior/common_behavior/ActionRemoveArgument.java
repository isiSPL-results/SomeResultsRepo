
//#if 877551504 
// Compilation Unit of /ActionRemoveArgument.java 
 

//#if -1607945388 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if 681614402 
import java.awt.event.ActionEvent;
//#endif 


//#if -1445800845 
import org.argouml.i18n.Translator;
//#endif 


//#if -1176010831 
import org.argouml.kernel.Project;
//#endif 


//#if 1182374424 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 2041472601 
import org.argouml.uml.ui.AbstractActionRemoveElement;
//#endif 


//#if -1909934682 
public class ActionRemoveArgument extends 
//#if 1412507308 
AbstractActionRemoveElement
//#endif 

  { 

//#if 1503720825 
public void actionPerformed(ActionEvent e)
    { 

//#if 724856217 
super.actionPerformed(e);
//#endif 


//#if -504264862 
if(getObjectToRemove() != null)//1
{ 

//#if 903321208 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 1394376193 
Object o = getObjectToRemove();
//#endif 


//#if -299584401 
setObjectToRemove(null);
//#endif 


//#if 1128463321 
p.moveToTrash(o);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 501738706 
protected ActionRemoveArgument()
    { 

//#if 650668456 
super(Translator.localize("menu.popup.delete"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

