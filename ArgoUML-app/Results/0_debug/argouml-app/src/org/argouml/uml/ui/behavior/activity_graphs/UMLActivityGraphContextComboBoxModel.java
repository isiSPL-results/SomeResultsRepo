
//#if -931475448 
// Compilation Unit of /UMLActivityGraphContextComboBoxModel.java 
 

//#if -878193099 
package org.argouml.uml.ui.behavior.activity_graphs;
//#endif 


//#if -970465959 
import java.util.ArrayList;
//#endif 


//#if 1319924520 
import java.util.Collection;
//#endif 


//#if 880755361 
import org.argouml.kernel.Project;
//#endif 


//#if 186493224 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 1762030537 
import org.argouml.model.Model;
//#endif 


//#if 1852549102 
import org.argouml.model.UmlChangeEvent;
//#endif 


//#if 1524212207 
import org.argouml.uml.ui.UMLComboBoxModel2;
//#endif 


//#if 1884864944 
class UMLActivityGraphContextComboBoxModel extends 
//#if -1903677548 
UMLComboBoxModel2
//#endif 

  { 

//#if 854437048 
public UMLActivityGraphContextComboBoxModel()
    { 

//#if -242192097 
super("context", false);
//#endif 

} 

//#endif 


//#if -775054678 
protected boolean isValidElement(Object element)
    { 

//#if -1075643165 
return Model.getFacade().isAClassifier(element)
               || Model.getFacade().isABehavioralFeature(element)
               || Model.getFacade().isAPackage(element);
//#endif 

} 

//#endif 


//#if -963355018 
protected void buildModelList()
    { 

//#if 1662136298 
Collection elements = new ArrayList();
//#endif 


//#if 180984439 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -920615220 
for (Object model : p.getUserDefinedModelList()) //1
{ 

//#if 930133075 
elements.addAll(Model
                            .getModelManagementHelper().getAllModelElementsOfKind(
                                model, Model.getMetaTypes().getClassifier()));
//#endif 


//#if 1167278919 
elements.addAll(Model
                            .getModelManagementHelper().getAllModelElementsOfKind(
                                model,
                                Model.getMetaTypes().getBehavioralFeature()));
//#endif 


//#if -2054352678 
elements.addAll(Model
                            .getModelManagementHelper().getAllModelElementsOfKind(
                                model, Model.getMetaTypes().getPackage()));
//#endif 

} 

//#endif 


//#if 1706577639 
setElements(elements);
//#endif 

} 

//#endif 


//#if -314662386 
public void modelChange(UmlChangeEvent evt)
    { 
} 

//#endif 


//#if 835652926 
protected Object getSelectedModelElement()
    { 

//#if -3792016 
return Model.getFacade().getContext(getTarget());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

