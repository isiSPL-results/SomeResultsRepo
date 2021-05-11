package org.argouml.uml.ui.foundation.core;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.argouml.i18n.Translator;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.Model;
import org.argouml.uml.ui.AbstractActionAddModelElement2;
public class ActionAddSupplierDependencyAction extends AbstractActionAddModelElement2
  { 
protected List getChoices()
    { 
List ret = new ArrayList();
Object model =
            ProjectManager.getManager().getCurrentProject().getModel();
if(getTarget() != null)//1
{ 
ret.addAll(Model.getModelManagementHelper()
                       .getAllModelElementsOfKind(model,
                                                  "org.omg.uml.foundation.core.ModelElement"));
ret.remove(getTarget());
} 
return ret;
} 
protected List getSelected()
    { 
List v = new ArrayList();
Collection c =  Model.getFacade().getSupplierDependencies(getTarget());
for (Object supplierDependency : c) //1
{ 
v.addAll(Model.getFacade().getClients(supplierDependency));
} 
return v;
} 
protected String getDialogTitle()
    { 
return Translator.localize("dialog.title.add-supplier-dependency");
} 
protected void doIt(Collection selected)
    { 
Set oldSet = new HashSet(getSelected());
for (Object supplier : oldSet) //1
{ 
if(oldSet.contains(supplier))//1
{ 
oldSet.remove(supplier);
} 
else
{ 
Model.getCoreFactory().buildDependency(supplier, getTarget());
} 
} 
Collection toBeDeleted = new ArrayList();
Collection c =  Model.getFacade().getSupplierDependencies(getTarget());
for (Object dependency : c) //1
{ 
if(oldSet.containsAll(
                        Model.getFacade().getClients(dependency)))//1
{ 
toBeDeleted.add(dependency);
} 
} 
ProjectManager.getManager().getCurrentProject()
        .moveToTrash(toBeDeleted);
} 
public ActionAddSupplierDependencyAction()
    { 
super();
setMultiSelect(true);
} 

 } 
