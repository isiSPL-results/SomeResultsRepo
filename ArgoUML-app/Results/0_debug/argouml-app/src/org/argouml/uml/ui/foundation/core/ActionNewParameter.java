
//#if -302285147 
// Compilation Unit of /ActionNewParameter.java 
 

//#if 1967424555 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 1569313077 
import java.awt.event.ActionEvent;
//#endif 


//#if 1857414059 
import javax.swing.Action;
//#endif 


//#if 303054304 
import org.argouml.i18n.Translator;
//#endif 


//#if -288312156 
import org.argouml.kernel.Project;
//#endif 


//#if -1052017211 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -1835337562 
import org.argouml.model.Model;
//#endif 


//#if 281907964 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 609641841 
import org.argouml.uml.ui.AbstractActionNewModelElement;
//#endif 


//#if 1831022561 
public class ActionNewParameter extends 
//#if 845989622 
AbstractActionNewModelElement
//#endif 

  { 

//#if 1029599374 
public ActionNewParameter()
    { 

//#if 418099707 
super("button.new-parameter");
//#endif 


//#if -9045155 
putValue(Action.NAME, Translator.localize("button.new-parameter"));
//#endif 

} 

//#endif 


//#if -992179064 
public void actionPerformed(ActionEvent e)
    { 

//#if 1312656101 
Object target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if 375585767 
if(Model.getFacade().isAParameter(target))//1
{ 

//#if 958582057 
target = Model.getFacade().getModelElementContainer(target);
//#endif 

} 

//#endif 


//#if -416135657 
if(target != null)//1
{ 

//#if -1413186766 
super.actionPerformed(e);
//#endif 


//#if 991739448 
Project currentProject =
                ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -1005055353 
Object paramType = currentProject.getDefaultParameterType();
//#endif 


//#if -2047343752 
TargetManager.getInstance().setTarget(
                Model.getCoreFactory().buildParameter(
                    target, paramType));
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

