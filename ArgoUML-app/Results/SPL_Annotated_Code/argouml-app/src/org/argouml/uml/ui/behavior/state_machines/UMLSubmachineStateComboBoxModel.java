// Compilation Unit of /UMLSubmachineStateComboBoxModel.java 
 
package org.argouml.uml.ui.behavior.state_machines;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLComboBoxModel2;
public class UMLSubmachineStateComboBoxModel extends UMLComboBoxModel2
  { 
protected boolean isValidElement(Object element)
    { 
return (Model.getFacade().isAStateMachine(element)
                && element != Model.getStateMachinesHelper()
                .getStateMachine(getTarget()));
} 

protected Object getSelectedModelElement()
    { 
if(getTarget() != null)//1
{ 
return Model.getFacade().getSubmachine(getTarget());
} 

return null;
} 

public UMLSubmachineStateComboBoxModel()
    { 
super("submachine", true);
} 

protected void buildModelList()
    { 
removeAllElements();
Project p = ProjectManager.getManager().getCurrentProject();
Object model = p.getModel();
setElements(Model.getStateMachinesHelper()
                    .getAllPossibleStatemachines(model, getTarget()));
} 

 } 


