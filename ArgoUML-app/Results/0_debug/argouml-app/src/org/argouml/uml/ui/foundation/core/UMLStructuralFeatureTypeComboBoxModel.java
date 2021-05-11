
//#if 1627934076 
// Compilation Unit of /UMLStructuralFeatureTypeComboBoxModel.java 
 

//#if 819904573 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 666630344 
import java.util.ArrayList;
//#endif 


//#if 530302361 
import java.util.Collection;
//#endif 


//#if 1400617821 
import java.util.Set;
//#endif 


//#if 1857380891 
import java.util.TreeSet;
//#endif 


//#if 1858681938 
import org.argouml.kernel.Project;
//#endif 


//#if 873043543 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 1664171960 
import org.argouml.model.Model;
//#endif 


//#if -1866082081 
import org.argouml.model.UmlChangeEvent;
//#endif 


//#if 1910501984 
import org.argouml.uml.ui.UMLComboBoxModel2;
//#endif 


//#if 1718064399 
import org.argouml.uml.util.PathComparator;
//#endif 


//#if -1071984899 
public class UMLStructuralFeatureTypeComboBoxModel extends 
//#if -1492159439 
UMLComboBoxModel2
//#endif 

  { 

//#if -1684162113 
@Override
    protected void addOtherModelEventListeners(Object newTarget)
    { 

//#if 1186037129 
super.addOtherModelEventListeners(newTarget);
//#endif 


//#if 736493931 
Model.getPump().addClassModelEventListener(this,
                Model.getMetaTypes().getNamespace(), "ownedElement");
//#endif 


//#if 1487257582 
Model.getPump().addClassModelEventListener(this,
                Model.getMetaTypes().getUMLClass(), "name");
//#endif 


//#if 82158169 
Model.getPump().addClassModelEventListener(this,
                Model.getMetaTypes().getInterface(), "name");
//#endif 


//#if -1638502674 
Model.getPump().addClassModelEventListener(this,
                Model.getMetaTypes().getDataType(), "name");
//#endif 

} 

//#endif 


//#if -131613028 
@Override
    protected boolean isLazy()
    { 

//#if -1290491396 
return true;
//#endif 

} 

//#endif 


//#if 1013046108 
public UMLStructuralFeatureTypeComboBoxModel()
    { 

//#if -1578554902 
super("type", true);
//#endif 

} 

//#endif 


//#if -125435449 
protected boolean isValidElement(Object element)
    { 

//#if 664178867 
return Model.getFacade().isAClass(element)
               || Model.getFacade().isAInterface(element)
               || Model.getFacade().isADataType(element);
//#endif 

} 

//#endif 


//#if 1622187923 

//#if 1135838686 
@SuppressWarnings("unchecked")
//#endif 


    protected void buildModelList()
    { 

//#if -1399332840 
Set<Object> elements = new TreeSet<Object>(new PathComparator());
//#endif 


//#if -953677892 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 997099614 
if(p == null)//1
{ 

//#if 315452391 
return;
//#endif 

} 

//#endif 


//#if -2071669167 
for (Object model : p.getUserDefinedModelList()) //1
{ 

//#if -2105074883 
elements.addAll(Model.getModelManagementHelper()
                            .getAllModelElementsOfKind(
                                model, Model.getMetaTypes().getUMLClass()));
//#endif 


//#if 1541127802 
elements.addAll(Model.getModelManagementHelper()
                            .getAllModelElementsOfKind(
                                model, Model.getMetaTypes().getInterface()));
//#endif 


//#if 1244072509 
elements.addAll(Model.getModelManagementHelper()
                            .getAllModelElementsOfKind(
                                model, Model.getMetaTypes().getDataType()));
//#endif 

} 

//#endif 


//#if -259686313 
elements.addAll(p.getProfileConfiguration().findByMetaType(
                            Model.getMetaTypes().getClassifier()));
//#endif 


//#if -1622434878 
setElements(elements);
//#endif 

} 

//#endif 


//#if -983845703 
@Override
    public void modelChanged(UmlChangeEvent evt)
    { 

//#if 1560200277 
Object newSelection = getSelectedModelElement();
//#endif 


//#if -1717953059 
if(getSelectedItem() != newSelection)//1
{ 

//#if -2114166086 
buildMinimalModelList();
//#endif 


//#if 1698479754 
setSelectedItem(newSelection);
//#endif 

} 

//#endif 


//#if -1815435675 
if(evt.getSource() != getTarget())//1
{ 

//#if 2066672576 
setModelInvalid();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -167926026 

//#if -1347240149 
@SuppressWarnings("unchecked")
//#endif 


    @Override
    protected void buildMinimalModelList()
    { 

//#if 1231333943 
Collection list = new ArrayList(1);
//#endif 


//#if -1050223438 
Object element = getSelectedModelElement();
//#endif 


//#if 147875704 
if(element != null)//1
{ 

//#if -862961272 
list.add(element);
//#endif 

} 

//#endif 


//#if -811638565 
setElements(list);
//#endif 


//#if 1626052422 
setModelInvalid();
//#endif 

} 

//#endif 


//#if 1750067201 
protected Object getSelectedModelElement()
    { 

//#if -793968651 
Object o = null;
//#endif 


//#if -1110612614 
if(getTarget() != null)//1
{ 

//#if -1598335336 
o = Model.getFacade().getType(getTarget());
//#endif 

} 

//#endif 


//#if -1422430066 
return o;
//#endif 

} 

//#endif 


//#if 1300055159 
@Override
    protected void removeOtherModelEventListeners(Object oldTarget)
    { 

//#if 1428565964 
super.removeOtherModelEventListeners(oldTarget);
//#endif 


//#if 1446404109 
Model.getPump().removeClassModelEventListener(this,
                Model.getMetaTypes().getNamespace(), "ownedElement");
//#endif 


//#if -2108947700 
Model.getPump().removeClassModelEventListener(this,
                Model.getMetaTypes().getUMLClass(), "name");
//#endif 


//#if 268944123 
Model.getPump().removeClassModelEventListener(this,
                Model.getMetaTypes().getInterface(), "name");
//#endif 


//#if -939740660 
Model.getPump().removeClassModelEventListener(this,
                Model.getMetaTypes().getDataType(), "name");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

