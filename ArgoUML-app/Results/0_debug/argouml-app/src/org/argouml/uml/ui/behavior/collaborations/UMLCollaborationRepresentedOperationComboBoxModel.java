
//#if -279177317 
// Compilation Unit of /UMLCollaborationRepresentedOperationComboBoxModel.java 
 

//#if -295580835 
package org.argouml.uml.ui.behavior.collaborations;
//#endif 


//#if -1507022135 
import java.beans.PropertyChangeEvent;
//#endif 


//#if 220994520 
import java.util.ArrayList;
//#endif 


//#if -399506295 
import java.util.Collection;
//#endif 


//#if -762411198 
import org.argouml.kernel.Project;
//#endif 


//#if 1924603239 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -21407032 
import org.argouml.model.Model;
//#endif 


//#if 1908617167 
import org.argouml.model.UmlChangeEvent;
//#endif 


//#if 1433948496 
import org.argouml.uml.ui.UMLComboBoxModel2;
//#endif 


//#if 1414875090 
class UMLCollaborationRepresentedOperationComboBoxModel extends 
//#if 1246449443 
UMLComboBoxModel2
//#endif 

  { 

//#if -614670919 
protected boolean isValidElement(Object element)
    { 

//#if 1110045617 
return Model.getFacade().isAOperation(element)
               && Model.getFacade().getRepresentedOperation(getTarget())
               == element;
//#endif 

} 

//#endif 


//#if -539501361 
protected Object getSelectedModelElement()
    { 

//#if 2036706408 
return Model.getFacade().getRepresentedOperation(getTarget());
//#endif 

} 

//#endif 


//#if -1970634745 
@Override
    public void modelChanged(UmlChangeEvent evt)
    { 
} 

//#endif 


//#if 346218492 
public UMLCollaborationRepresentedOperationComboBoxModel()
    { 

//#if 298225750 
super("representedOperation", true);
//#endif 

} 

//#endif 


//#if 248618885 
protected void buildModelList()
    { 

//#if 1746276539 
Collection operations = new ArrayList();
//#endif 


//#if -1293330213 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -733728208 
for (Object model : p.getUserDefinedModelList()) //1
{ 

//#if -1442778213 
Collection c = Model.getModelManagementHelper()
                           .getAllModelElementsOfKind(model,
                                   Model.getMetaTypes().getOperation());
//#endif 


//#if -2132362911 
for (Object oper : c) //1
{ 

//#if 894368400 
Object ns = Model.getFacade().getOwner(oper);
//#endif 


//#if -312254646 
Collection s = Model.getModelManagementHelper()
                               .getAllSurroundingNamespaces(ns);
//#endif 


//#if 1703671553 
if(!s.contains(getTarget()))//1
{ 

//#if 916148666 
operations.add(oper);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1405801928 
setElements(operations);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

