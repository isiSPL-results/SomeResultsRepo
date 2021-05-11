// Compilation Unit of /UMLCollaborationRepresentedOperationComboBoxModel.java 
 
package org.argouml.uml.ui.behavior.collaborations;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.Collection;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.Model;
import org.argouml.model.UmlChangeEvent;
import org.argouml.uml.ui.UMLComboBoxModel2;
class UMLCollaborationRepresentedOperationComboBoxModel extends UMLComboBoxModel2
  { 
protected boolean isValidElement(Object element)
    { 
return Model.getFacade().isAOperation(element)
               && Model.getFacade().getRepresentedOperation(getTarget())
               == element;
} 

protected Object getSelectedModelElement()
    { 
return Model.getFacade().getRepresentedOperation(getTarget());
} 

@Override
    public void modelChanged(UmlChangeEvent evt)
    { 
} 

public UMLCollaborationRepresentedOperationComboBoxModel()
    { 
super("representedOperation", true);
} 

protected void buildModelList()
    { 
Collection operations = new ArrayList();
Project p = ProjectManager.getManager().getCurrentProject();
for (Object model : p.getUserDefinedModelList()) //1
{ 
Collection c = Model.getModelManagementHelper()
                           .getAllModelElementsOfKind(model,
                                   Model.getMetaTypes().getOperation());
for (Object oper : c) //1
{ 
Object ns = Model.getFacade().getOwner(oper);
Collection s = Model.getModelManagementHelper()
                               .getAllSurroundingNamespaces(ns);
if(!s.contains(getTarget()))//1
{ 
operations.add(oper);
} 

} 

} 

setElements(operations);
} 

 } 


