
//#if -866844880 
// Compilation Unit of /UMLTagDefinitionOwnerComboBoxModel.java 
 

//#if 1567628998 
package org.argouml.uml.ui.foundation.extension_mechanisms;
//#endif 


//#if -162122226 
import org.argouml.kernel.Project;
//#endif 


//#if -1526763237 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -160366724 
import org.argouml.model.Model;
//#endif 


//#if -1002639076 
import org.argouml.uml.ui.UMLComboBoxModel2;
//#endif 


//#if 286952158 
public class UMLTagDefinitionOwnerComboBoxModel extends 
//#if -800305012 
UMLComboBoxModel2
//#endif 

  { 

//#if -397631030 
public UMLTagDefinitionOwnerComboBoxModel()
    { 

//#if 1634169765 
super("owner", true);
//#endif 


//#if -1137462102 
Model.getPump().addClassModelEventListener(
            this,
            Model.getMetaTypes().getNamespace(),
            "ownedElement");
//#endif 

} 

//#endif 


//#if -981729201 
protected boolean isValidElement(Object o)
    { 

//#if 1865825002 
return Model.getFacade().isAStereotype(o);
//#endif 

} 

//#endif 


//#if -2031528634 
protected Object getSelectedModelElement()
    { 

//#if 452554572 
Object owner = null;
//#endif 


//#if -990745670 
if(getTarget() != null
                && Model.getFacade().isATagDefinition(getTarget()))//1
{ 

//#if 1208583290 
owner = Model.getFacade().getOwner(getTarget());
//#endif 

} 

//#endif 


//#if -1183885737 
return owner;
//#endif 

} 

//#endif 


//#if -233387154 
protected void buildModelList()
    { 

//#if 196500811 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 58036590 
Object model = p.getRoot();
//#endif 


//#if 1781184590 
setElements(Model.getModelManagementHelper()
                    .getAllModelElementsOfKindWithModel(model,
                            Model.getMetaTypes().getStereotype()));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

