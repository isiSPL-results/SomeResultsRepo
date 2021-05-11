
//#if 2096874585 
// Compilation Unit of /UMLReceptionSignalComboBoxModel.java 
 

//#if -162129188 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if -346211392 
import java.util.Collection;
//#endif 


//#if -735233735 
import org.argouml.kernel.Project;
//#endif 


//#if -308177008 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -1450851279 
import org.argouml.model.Model;
//#endif 


//#if -384276353 
import org.argouml.model.RemoveAssociationEvent;
//#endif 


//#if 2113686662 
import org.argouml.model.UmlChangeEvent;
//#endif 


//#if 836123271 
import org.argouml.uml.ui.UMLComboBoxModel2;
//#endif 


//#if -160094382 
public class UMLReceptionSignalComboBoxModel extends 
//#if 631960474 
UMLComboBoxModel2
//#endif 

  { 

//#if 1643749596 
public void modelChanged(UmlChangeEvent evt)
    { 

//#if 1861989263 
if(evt instanceof RemoveAssociationEvent)//1
{ 

//#if 2124140125 
if("ownedElement".equals(evt.getPropertyName()))//1
{ 

//#if -594232154 
Object o = getChangedElement(evt);
//#endif 


//#if -2126068488 
if(contains(o))//1
{ 

//#if 981747079 
buildingModel = true;
//#endif 


//#if 834399412 
if(o instanceof Collection)//1
{ 

//#if 650383428 
removeAll((Collection) o);
//#endif 

} 
else
{ 

//#if 1580774208 
removeElement(o);
//#endif 

} 

//#endif 


//#if -47372898 
buildingModel = false;
//#endif 

} 

//#endif 

} 

//#endif 

} 
else
{ 

//#if -663096910 
super.propertyChange(evt);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -841407880 
protected Object getSelectedModelElement()
    { 

//#if -2012399779 
if(getTarget() != null)//1
{ 

//#if -1761580635 
return Model.getFacade().getSignal(getTarget());
//#endif 

} 

//#endif 


//#if -842867025 
return null;
//#endif 

} 

//#endif 


//#if -1564259972 
protected void buildModelList()
    { 

//#if 1661604208 
Object target = getTarget();
//#endif 


//#if -76824659 
if(Model.getFacade().isAReception(target))//1
{ 

//#if 1909067139 
Object rec = /*(MReception)*/ target;
//#endif 


//#if 1798723266 
removeAllElements();
//#endif 


//#if 2032197962 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 268162447 
Object model = p.getRoot();
//#endif 


//#if -910865001 
setElements(Model.getModelManagementHelper()
                        .getAllModelElementsOfKindWithModel(
                            model,
                            Model.getMetaTypes().getSignal()));
//#endif 


//#if -1959141461 
setSelectedItem(Model.getFacade().getSignal(rec));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -97476895 
public UMLReceptionSignalComboBoxModel()
    { 

//#if -151742118 
super("signal", false);
//#endif 


//#if -2004822663 
Model.getPump().addClassModelEventListener(this,
                Model.getMetaTypes().getNamespace(), "ownedElement");
//#endif 

} 

//#endif 


//#if 1134871711 
protected boolean isValidElement(Object m)
    { 

//#if 1435136459 
return Model.getFacade().isASignal(m);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

