package org.argouml.uml.ui.behavior.activity_graphs;
import java.util.ArrayList;
import java.util.Collection;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.Model;
import org.argouml.model.UmlChangeEvent;
import org.argouml.uml.ui.UMLComboBoxModel2;
class UMLActivityGraphContextComboBoxModel extends UMLComboBoxModel2
  { 
public UMLActivityGraphContextComboBoxModel()
    { 
super("context", false);
} 
protected boolean isValidElement(Object element)
    { 
return Model.getFacade().isAClassifier(element)
               || Model.getFacade().isABehavioralFeature(element)
               || Model.getFacade().isAPackage(element);
} 
protected void buildModelList()
    { 
Collection elements = new ArrayList();
Project p = ProjectManager.getManager().getCurrentProject();
for (Object model : p.getUserDefinedModelList()) //1
{ 
elements.addAll(Model
                            .getModelManagementHelper().getAllModelElementsOfKind(
                                model, Model.getMetaTypes().getClassifier()));
elements.addAll(Model
                            .getModelManagementHelper().getAllModelElementsOfKind(
                                model,
                                Model.getMetaTypes().getBehavioralFeature()));
elements.addAll(Model
                            .getModelManagementHelper().getAllModelElementsOfKind(
                                model, Model.getMetaTypes().getPackage()));
} 
setElements(elements);
} 
public void modelChange(UmlChangeEvent evt)
    { 
} 
protected Object getSelectedModelElement()
    { 
return Model.getFacade().getContext(getTarget());
} 

 } 
