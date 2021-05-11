
//#if -362640010 
// Compilation Unit of /UMLStateMachineContextComboBoxModel.java 
 

//#if -2139794239 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if 508954088 
import java.util.ArrayList;
//#endif 


//#if -62694279 
import java.util.Collection;
//#endif 


//#if 576465714 
import org.argouml.kernel.Project;
//#endif 


//#if -185193609 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 901758168 
import org.argouml.model.Model;
//#endif 


//#if 593633215 
import org.argouml.model.UmlChangeEvent;
//#endif 


//#if 1027459392 
import org.argouml.uml.ui.UMLComboBoxModel2;
//#endif 


//#if 580622007 
public class UMLStateMachineContextComboBoxModel extends 
//#if -887008308 
UMLComboBoxModel2
//#endif 

  { 

//#if -461194526 
protected boolean isValidElement(Object element)
    { 

//#if 225782448 
return Model.getFacade().isAClassifier(element)
               || Model.getFacade().isABehavioralFeature(element);
//#endif 

} 

//#endif 


//#if 1651014353 
public UMLStateMachineContextComboBoxModel()
    { 

//#if 1975873227 
super("context", false);
//#endif 

} 

//#endif 


//#if 2134961838 
protected void buildModelList()
    { 

//#if -269513414 
Collection elements = new ArrayList();
//#endif 


//#if -1498397913 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -219067524 
for (Object model : p.getUserDefinedModelList()) //1
{ 

//#if 604042672 
elements.addAll(Model
                            .getModelManagementHelper().getAllModelElementsOfKind(
                                model, Model.getMetaTypes().getClassifier()));
//#endif 


//#if 3485514 
elements.addAll(Model
                            .getModelManagementHelper().getAllModelElementsOfKind(
                                model,
                                Model.getMetaTypes().getBehavioralFeature()));
//#endif 

} 

//#endif 


//#if 406529079 
setElements(elements);
//#endif 

} 

//#endif 


//#if 1941900046 
public void modelChanged(UmlChangeEvent evt)
    { 
} 

//#endif 


//#if 830777862 
protected Object getSelectedModelElement()
    { 

//#if -777832922 
return Model.getFacade().getContext(getTarget());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

