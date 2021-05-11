package org.argouml.uml.ui.behavior.common_behavior;
import java.util.Collection;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.Model;
import org.argouml.model.RemoveAssociationEvent;
import org.argouml.model.UmlChangeEvent;
import org.argouml.uml.ui.UMLComboBoxModel2;
public class UMLReceptionSignalComboBoxModel extends UMLComboBoxModel2
  { 
public void modelChanged(UmlChangeEvent evt)
    { 
if(evt instanceof RemoveAssociationEvent)//1
{ 
if("ownedElement".equals(evt.getPropertyName()))//1
{ 
Object o = getChangedElement(evt);
if(contains(o))//1
{ 
buildingModel = true;
if(o instanceof Collection)//1
{ 
removeAll((Collection) o);
} 
else
{ 
removeElement(o);
} 
buildingModel = false;
} 
} 
} 
else
{ 
super.propertyChange(evt);
} 
} 
protected Object getSelectedModelElement()
    { 
if(getTarget() != null)//1
{ 
return Model.getFacade().getSignal(getTarget());
} 
return null;
} 
protected void buildModelList()
    { 
Object target = getTarget();
if(Model.getFacade().isAReception(target))//1
{ 
Object rec = /*(MReception)*/ target;
removeAllElements();
Project p = ProjectManager.getManager().getCurrentProject();
Object model = p.getRoot();
setElements(Model.getModelManagementHelper()
                        .getAllModelElementsOfKindWithModel(
                            model,
                            Model.getMetaTypes().getSignal()));
setSelectedItem(Model.getFacade().getSignal(rec));
} 
} 
public UMLReceptionSignalComboBoxModel()
    { 
super("signal", false);
Model.getPump().addClassModelEventListener(this,
                Model.getMetaTypes().getNamespace(), "ownedElement");
} 
protected boolean isValidElement(Object m)
    { 
return Model.getFacade().isASignal(m);
} 

 } 
