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
public class ActionAddClientDependencyAction extends AbstractActionAddModelElement2
  { 
protected List getSelected()
    { 
List v = new ArrayList();
Collection c =  Model.getFacade().getClientDependencies(getTarget());
for (Object cd : c) //1
{ 
v.addAll(Model.getFacade().getSuppliers(cd));
} 
return v;
} 
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
protected String getDialogTitle()
    { 
return Translator.localize("dialog.title.add-client-dependency");
} 
public ActionAddClientDependencyAction()
    { 
super();
setMultiSelect(true);
} 
protected void doIt(Collection selected)
    { 
Set oldSet = new HashSet(getSelected());
for (Object client : selected) //1
{ 
if(oldSet.contains(client))//1
{ 
oldSet.remove(client);
} 
else
{ 
Model.getCoreFactory().buildDependency(getTarget(), client);
} 
} 
Collection toBeDeleted = new ArrayList();
Collection dependencies = Model.getFacade().getClientDependencies(
                                      getTarget());
for (Object dependency : dependencies) //1
{ 
if(oldSet.containsAll(Model.getFacade().getSuppliers(dependency)))//1
{ 
toBeDeleted.add(dependency);
} 
} 
ProjectManager.getManager().getCurrentProject()
        .moveToTrash(toBeDeleted);
} 

 } 
