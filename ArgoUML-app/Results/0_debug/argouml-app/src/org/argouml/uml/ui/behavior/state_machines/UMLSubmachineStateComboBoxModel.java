
//#if 783043659 
// Compilation Unit of /UMLSubmachineStateComboBoxModel.java 
 

//#if -1581045697 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if 1673311220 
import org.argouml.kernel.Project;
//#endif 


//#if -1072651147 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -1380992170 
import org.argouml.model.Model;
//#endif 


//#if -1696348286 
import org.argouml.uml.ui.UMLComboBoxModel2;
//#endif 


//#if -1086095004 
public class UMLSubmachineStateComboBoxModel extends 
//#if -1077785848 
UMLComboBoxModel2
//#endif 

  { 

//#if 1834270750 
protected boolean isValidElement(Object element)
    { 

//#if 1797475233 
return (Model.getFacade().isAStateMachine(element)
                && element != Model.getStateMachinesHelper()
                .getStateMachine(getTarget()));
//#endif 

} 

//#endif 


//#if -1709486262 
protected Object getSelectedModelElement()
    { 

//#if -2043264162 
if(getTarget() != null)//1
{ 

//#if 1945540245 
return Model.getFacade().getSubmachine(getTarget());
//#endif 

} 

//#endif 


//#if 2066834702 
return null;
//#endif 

} 

//#endif 


//#if -1419207940 
public UMLSubmachineStateComboBoxModel()
    { 

//#if 755365084 
super("submachine", true);
//#endif 

} 

//#endif 


//#if -706941974 
protected void buildModelList()
    { 

//#if -985276599 
removeAllElements();
//#endif 


//#if -1036586717 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 1700979699 
Object model = p.getModel();
//#endif 


//#if 1939876830 
setElements(Model.getStateMachinesHelper()
                    .getAllPossibleStatemachines(model, getTarget()));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

