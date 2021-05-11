
//#if 2139425254 
// Compilation Unit of /ActionNewActor.java 
 

//#if 1023916912 
package org.argouml.uml.ui.behavior.use_cases;
//#endif 


//#if 1048811107 
import java.awt.event.ActionEvent;
//#endif 


//#if 1944499929 
import javax.swing.Action;
//#endif 


//#if 1347362418 
import org.argouml.i18n.Translator;
//#endif 


//#if 2016422103 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -1468730824 
import org.argouml.model.Model;
//#endif 


//#if 371407914 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -1805126625 
import org.argouml.uml.ui.AbstractActionNewModelElement;
//#endif 


//#if 498193755 
public class ActionNewActor extends 
//#if 1716895548 
AbstractActionNewModelElement
//#endif 

  { 

//#if 1287708756 
public ActionNewActor()
    { 

//#if 1182120354 
super("button.new-actor");
//#endif 


//#if -254812900 
putValue(Action.NAME, Translator.localize("button.new-actor"));
//#endif 

} 

//#endif 


//#if 2054710606 
public void actionPerformed(ActionEvent e)
    { 

//#if -2030059963 
Object target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if 1642611667 
if(Model.getFacade().isAActor(target))//1
{ 

//#if -1652716865 
Object model =
                ProjectManager.getManager().getCurrentProject().getModel();
//#endif 


//#if 186616913 
TargetManager.getInstance().setTarget(
                Model.getUseCasesFactory().buildActor(target, model));
//#endif 


//#if -591170716 
super.actionPerformed(e);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

