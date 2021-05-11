
//#if -1451768585 
// Compilation Unit of /UMLCollaborationRepresentedClassifierComboBoxModel.java 
 

//#if 1952959859 
package org.argouml.uml.ui.behavior.collaborations;
//#endif 


//#if 1240956910 
import java.util.ArrayList;
//#endif 


//#if 1154556723 
import java.util.Collection;
//#endif 


//#if -1908113812 
import org.argouml.kernel.Project;
//#endif 


//#if 1587454717 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 1617478622 
import org.argouml.model.Model;
//#endif 


//#if -1565941895 
import org.argouml.model.UmlChangeEvent;
//#endif 


//#if -924132358 
import org.argouml.uml.ui.UMLComboBoxModel2;
//#endif 


//#if -1824260536 
class UMLCollaborationRepresentedClassifierComboBoxModel extends 
//#if -141997896 
UMLComboBoxModel2
//#endif 

  { 

//#if -1974894486 
public void modelChange(UmlChangeEvent evt)
    { 
} 

//#endif 


//#if 203743642 
protected void buildModelList()
    { 

//#if 1391891256 
Collection classifiers = new ArrayList();
//#endif 


//#if -1808194492 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -1150386983 
for (Object model : p.getUserDefinedModelList()) //1
{ 

//#if 961819881 
Collection c = Model.getModelManagementHelper()
                           .getAllModelElementsOfKind(model,
                                   Model.getMetaTypes().getClassifier());
//#endif 


//#if -1139670609 
for (Object cls : c) //1
{ 

//#if -1519927947 
Collection s = Model.getModelManagementHelper()
                               .getAllSurroundingNamespaces(cls);
//#endif 


//#if -1839630411 
if(!s.contains(getTarget()))//1
{ 

//#if -1069213213 
classifiers.add(cls);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1094743475 
setElements(classifiers);
//#endif 

} 

//#endif 


//#if -824579174 
protected Object getSelectedModelElement()
    { 

//#if 1140315471 
return Model.getFacade().getRepresentedClassifier(getTarget());
//#endif 

} 

//#endif 


//#if 1154334625 
public UMLCollaborationRepresentedClassifierComboBoxModel()
    { 

//#if -774740293 
super("representedClassifier", true);
//#endif 

} 

//#endif 


//#if 1004230094 
protected boolean isValidElement(Object element)
    { 

//#if 1276591404 
return Model.getFacade().isAClassifier(element)
               && Model.getFacade().getRepresentedClassifier(getTarget())
               == element;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

