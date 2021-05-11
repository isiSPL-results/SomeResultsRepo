package org.argouml.uml.ui.foundation.core;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLComboBoxModel2;
import org.argouml.uml.util.PathComparator;
public class UMLGeneralizationPowertypeComboBoxModel extends UMLComboBoxModel2
  { 
@Override
    protected boolean isLazy()
    { 
return true;
} 
public UMLGeneralizationPowertypeComboBoxModel()
    { 
super("powertype", true);
Model.getPump().addClassModelEventListener(this,
                Model.getMetaTypes().getNamespace(), "ownedElement");
} 
protected void buildModelList()
    { 
Set<Object> elements = new TreeSet<Object>(new PathComparator());
Project p = ProjectManager.getManager().getCurrentProject();
for (Object model : p.getUserDefinedModelList()) //1
{ 
elements.addAll(Model.getModelManagementHelper()
                            .getAllModelElementsOfKind(model,
                                    Model.getMetaTypes().getClassifier()));
} 
elements.addAll(p.getProfileConfiguration().findByMetaType(
                            Model.getMetaTypes().getClassifier()));
removeAllElements();
addAll(elements);
} 
protected boolean isValidElement(Object element)
    { 
return Model.getFacade().isAClassifier(element);
} 
protected Object getSelectedModelElement()
    { 
if(getTarget() != null)//1
{ 
return Model.getFacade().getPowertype(getTarget());
} 
return null;
} 
@Override
    protected void buildMinimalModelList()
    { 
Collection list = new ArrayList(1);
Object element = getSelectedModelElement();
if(element == null)//1
{ 
element = " ";
} 
list.add(element);
setElements(list);
setModelInvalid();
} 

 } 
