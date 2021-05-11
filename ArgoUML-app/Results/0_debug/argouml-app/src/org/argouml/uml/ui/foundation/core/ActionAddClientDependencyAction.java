
//#if 997150524 
// Compilation Unit of /ActionAddClientDependencyAction.java 
 

//#if 1936850784 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 1434443243 
import java.util.ArrayList;
//#endif 


//#if -1437301546 
import java.util.Collection;
//#endif 


//#if 1000098158 
import java.util.HashSet;
//#endif 


//#if -760278634 
import java.util.List;
//#endif 


//#if 114226880 
import java.util.Set;
//#endif 


//#if -929907179 
import org.argouml.i18n.Translator;
//#endif 


//#if 530072122 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -1805132965 
import org.argouml.model.Model;
//#endif 


//#if -220038263 
import org.argouml.uml.ui.AbstractActionAddModelElement2;
//#endif 


//#if -903651958 
public class ActionAddClientDependencyAction extends 
//#if -1413124401 
AbstractActionAddModelElement2
//#endif 

  { 

//#if -1046623969 
protected List getSelected()
    { 

//#if -319748942 
List v = new ArrayList();
//#endif 


//#if 1694932630 
Collection c =  Model.getFacade().getClientDependencies(getTarget());
//#endif 


//#if -527510724 
for (Object cd : c) //1
{ 

//#if -462429106 
v.addAll(Model.getFacade().getSuppliers(cd));
//#endif 

} 

//#endif 


//#if 876546881 
return v;
//#endif 

} 

//#endif 


//#if 1283868368 
protected List getChoices()
    { 

//#if 1267311857 
List ret = new ArrayList();
//#endif 


//#if -1139821623 
Object model =
            ProjectManager.getManager().getCurrentProject().getModel();
//#endif 


//#if 1804991040 
if(getTarget() != null)//1
{ 

//#if 989336277 
ret.addAll(Model.getModelManagementHelper()
                       .getAllModelElementsOfKind(model,
                                                  "org.omg.uml.foundation.core.ModelElement"));
//#endif 


//#if 2088623365 
ret.remove(getTarget());
//#endif 

} 

//#endif 


//#if 17913186 
return ret;
//#endif 

} 

//#endif 


//#if 469742593 
protected String getDialogTitle()
    { 

//#if 1758509166 
return Translator.localize("dialog.title.add-client-dependency");
//#endif 

} 

//#endif 


//#if -1633897482 
public ActionAddClientDependencyAction()
    { 

//#if -1785667440 
super();
//#endif 


//#if 776508740 
setMultiSelect(true);
//#endif 

} 

//#endif 


//#if 1084143431 
protected void doIt(Collection selected)
    { 

//#if 444440499 
Set oldSet = new HashSet(getSelected());
//#endif 


//#if 1027799473 
for (Object client : selected) //1
{ 

//#if -2068653158 
if(oldSet.contains(client))//1
{ 

//#if -1545748103 
oldSet.remove(client);
//#endif 

} 
else
{ 

//#if 1036963251 
Model.getCoreFactory().buildDependency(getTarget(), client);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1682069504 
Collection toBeDeleted = new ArrayList();
//#endif 


//#if -318515737 
Collection dependencies = Model.getFacade().getClientDependencies(
                                      getTarget());
//#endif 


//#if 1325444927 
for (Object dependency : dependencies) //1
{ 

//#if 1299961238 
if(oldSet.containsAll(Model.getFacade().getSuppliers(dependency)))//1
{ 

//#if 63460126 
toBeDeleted.add(dependency);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -897611237 
ProjectManager.getManager().getCurrentProject()
        .moveToTrash(toBeDeleted);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

