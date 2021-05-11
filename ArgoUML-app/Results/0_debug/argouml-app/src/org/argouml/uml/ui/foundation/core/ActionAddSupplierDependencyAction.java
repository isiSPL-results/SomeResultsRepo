
//#if -28425451 
// Compilation Unit of /ActionAddSupplierDependencyAction.java 
 

//#if -1753608758 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -1347026859 
import java.util.ArrayList;
//#endif 


//#if -1763528788 
import java.util.Collection;
//#endif 


//#if 720109144 
import java.util.HashSet;
//#endif 


//#if 613651692 
import java.util.List;
//#endif 


//#if 1128378538 
import java.util.Set;
//#endif 


//#if 131913343 
import org.argouml.i18n.Translator;
//#endif 


//#if -1136336092 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -929908539 
import org.argouml.model.Model;
//#endif 


//#if -1651242893 
import org.argouml.uml.ui.AbstractActionAddModelElement2;
//#endif 


//#if 1516291573 
public class ActionAddSupplierDependencyAction extends 
//#if -77647770 
AbstractActionAddModelElement2
//#endif 

  { 

//#if 1593942745 
protected List getChoices()
    { 

//#if -1986225640 
List ret = new ArrayList();
//#endif 


//#if 1820008176 
Object model =
            ProjectManager.getManager().getCurrentProject().getModel();
//#endif 


//#if -270423559 
if(getTarget() != null)//1
{ 

//#if -937990426 
ret.addAll(Model.getModelManagementHelper()
                       .getAllModelElementsOfKind(model,
                                                  "org.omg.uml.foundation.core.ModelElement"));
//#endif 


//#if -1026279724 
ret.remove(getTarget());
//#endif 

} 

//#endif 


//#if -1758196517 
return ret;
//#endif 

} 

//#endif 


//#if -24252874 
protected List getSelected()
    { 

//#if 89349135 
List v = new ArrayList();
//#endif 


//#if 113026548 
Collection c =  Model.getFacade().getSupplierDependencies(getTarget());
//#endif 


//#if -1174135723 
for (Object supplierDependency : c) //1
{ 

//#if -1004967141 
v.addAll(Model.getFacade().getClients(supplierDependency));
//#endif 

} 

//#endif 


//#if 2045837508 
return v;
//#endif 

} 

//#endif 


//#if -1080154806 
protected String getDialogTitle()
    { 

//#if -1252649790 
return Translator.localize("dialog.title.add-supplier-dependency");
//#endif 

} 

//#endif 


//#if -343192112 
protected void doIt(Collection selected)
    { 

//#if -71467271 
Set oldSet = new HashSet(getSelected());
//#endif 


//#if 1532891754 
for (Object supplier : oldSet) //1
{ 

//#if 1281809081 
if(oldSet.contains(supplier))//1
{ 

//#if 1446529433 
oldSet.remove(supplier);
//#endif 

} 
else
{ 

//#if -154104278 
Model.getCoreFactory().buildDependency(supplier, getTarget());
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1426169478 
Collection toBeDeleted = new ArrayList();
//#endif 


//#if -977308742 
Collection c =  Model.getFacade().getSupplierDependencies(getTarget());
//#endif 


//#if -2103372061 
for (Object dependency : c) //1
{ 

//#if 1297229691 
if(oldSet.containsAll(
                        Model.getFacade().getClients(dependency)))//1
{ 

//#if -1353714558 
toBeDeleted.add(dependency);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1482301803 
ProjectManager.getManager().getCurrentProject()
        .moveToTrash(toBeDeleted);
//#endif 

} 

//#endif 


//#if 2076426112 
public ActionAddSupplierDependencyAction()
    { 

//#if -39367472 
super();
//#endif 


//#if 578031876 
setMultiSelect(true);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

