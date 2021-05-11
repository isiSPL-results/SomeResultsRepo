// Compilation Unit of /UMLTagDefinitionOwnerComboBoxModel.java 
 
package org.argouml.uml.ui.foundation.extension_mechanisms;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLComboBoxModel2;
public class UMLTagDefinitionOwnerComboBoxModel extends UMLComboBoxModel2
  { 
public UMLTagDefinitionOwnerComboBoxModel()
    { 
super("owner", true);
Model.getPump().addClassModelEventListener(
            this,
            Model.getMetaTypes().getNamespace(),
            "ownedElement");
} 

protected boolean isValidElement(Object o)
    { 
return Model.getFacade().isAStereotype(o);
} 

protected Object getSelectedModelElement()
    { 
Object owner = null;
if(getTarget() != null
                && Model.getFacade().isATagDefinition(getTarget()))//1
{ 
owner = Model.getFacade().getOwner(getTarget());
} 

return owner;
} 

protected void buildModelList()
    { 
Project p = ProjectManager.getManager().getCurrentProject();
Object model = p.getRoot();
setElements(Model.getModelManagementHelper()
                    .getAllModelElementsOfKindWithModel(model,
                            Model.getMetaTypes().getStereotype()));
} 

 } 


