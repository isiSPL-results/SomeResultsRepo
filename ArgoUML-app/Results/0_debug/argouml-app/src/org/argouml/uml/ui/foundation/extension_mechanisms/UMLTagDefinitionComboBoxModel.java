
//#if -1085917402 
// Compilation Unit of /UMLTagDefinitionComboBoxModel.java 
 

//#if 1257670307 
package org.argouml.uml.ui.foundation.extension_mechanisms;
//#endif 


//#if -1464904087 
import java.util.ArrayList;
//#endif 


//#if -1122755560 
import java.util.Collection;
//#endif 


//#if -1800681108 
import java.util.HashSet;
//#endif 


//#if 1975108184 
import java.util.List;
//#endif 


//#if 1865033150 
import java.util.Set;
//#endif 


//#if -562711556 
import java.util.TreeSet;
//#endif 


//#if -336873114 
import org.apache.log4j.Logger;
//#endif 


//#if -1470072943 
import org.argouml.kernel.Project;
//#endif 


//#if -934017480 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 1510663385 
import org.argouml.model.Model;
//#endif 


//#if 292382942 
import org.argouml.model.UmlChangeEvent;
//#endif 


//#if 875653855 
import org.argouml.uml.ui.UMLComboBoxModel2;
//#endif 


//#if 299208880 
import org.argouml.uml.util.PathComparator;
//#endif 


//#if -716002620 
public class UMLTagDefinitionComboBoxModel extends 
//#if 196655177 
UMLComboBoxModel2
//#endif 

  { 

//#if 422578350 
private static final Logger LOG =
        Logger.getLogger(UMLTagDefinitionComboBoxModel.class);
//#endif 


//#if -267376956 
private static final long serialVersionUID = -4194727034416788372L;
//#endif 


//#if 1304812297 
@Override
    public void setSelectedItem(Object o)
    { 

//#if -1662262228 
setFireListEvents(false);
//#endif 


//#if 716591910 
super.setSelectedItem(o);
//#endif 


//#if -606691895 
setFireListEvents(true);
//#endif 

} 

//#endif 


//#if -2065345631 
@Override
    public void modelChanged(UmlChangeEvent evt)
    { 

//#if 159591556 
if(Model.getFacade().isATagDefinition(evt.getSource()))//1
{ 

//#if -1960969794 
LOG.debug("Got TagDefinition event " + evt.toString());
//#endif 


//#if -830748705 
setModelInvalid();
//#endif 

} 
else

//#if -671794469 
if("stereotype".equals(evt.getPropertyName()))//1
{ 

//#if 2136532980 
LOG.debug("Got stereotype event " + evt.toString());
//#endif 


//#if 2065318632 
setModelInvalid();
//#endif 

} 
else
{ 

//#if 232894296 
LOG.debug("Got other event " + evt.toString());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -747026071 
@Override
    protected void addOtherModelEventListeners(Object target)
    { 

//#if -1147637872 
Model.getPump().addClassModelEventListener(this,
                Model.getMetaTypes().getTagDefinition(), (String[]) null);
//#endif 

} 

//#endif 


//#if 1079096067 
@Override
    public boolean isLazy()
    { 

//#if -1432357619 
return true;
//#endif 

} 

//#endif 


//#if -1942343063 
private Collection getApplicableTagDefinitions(Object element)
    { 

//#if -1387461731 
Set<List<String>> paths = new HashSet<List<String>>();
//#endif 


//#if -1842181548 
Set<Object> availableTagDefs =
            new TreeSet<Object>(new PathComparator());
//#endif 


//#if -454590213 
Collection stereotypes = Model.getFacade().getStereotypes(element);
//#endif 


//#if -1436779409 
Project project = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 807818199 
for (Object model : project.getModels()) //1
{ 

//#if 1711114708 
addAllUniqueModelElementsFrom(availableTagDefs, paths,
                                          Model.getModelManagementHelper().getAllModelElementsOfKind(
                                              model,
                                              Model.getMetaTypes().getTagDefinition()));
//#endif 

} 

//#endif 


//#if -946146811 
addAllUniqueModelElementsFrom(availableTagDefs, paths, project
                                      .getProfileConfiguration().findByMetaType(
                                          Model.getMetaTypes().getTagDefinition()));
//#endif 


//#if -890868764 
List notValids = new ArrayList();
//#endif 


//#if 1701813354 
for (Object tagDef : availableTagDefs) //1
{ 

//#if -1753565825 
Object owner = Model.getFacade().getOwner(tagDef);
//#endif 


//#if -269231198 
if(owner != null && !stereotypes.contains(owner))//1
{ 

//#if 1048097006 
notValids.add(tagDef);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1938075099 
int size = availableTagDefs.size();
//#endif 


//#if 1907240080 
availableTagDefs.removeAll(notValids);
//#endif 


//#if -71735952 
int delta = size - availableTagDefs.size();
//#endif 


//#if 84250270 
return availableTagDefs;
//#endif 

} 

//#endif 


//#if -1972524070 
public UMLTagDefinitionComboBoxModel()
    { 

//#if -2092045308 
super("stereotype", false);
//#endif 

} 

//#endif 


//#if -543192855 
protected Object getSelectedModelElement()
    { 

//#if 639249418 
return getSelectedItem();
//#endif 

} 

//#endif 


//#if 970751915 
protected void buildModelList()
    { 

//#if 1929340168 
removeAllElements();
//#endif 


//#if 1297807102 
Object target = getTarget();
//#endif 


//#if 18214999 
addAll(getApplicableTagDefinitions(target));
//#endif 

} 

//#endif 


//#if 1306440159 
protected boolean isValidElement(Object element)
    { 

//#if 2095568345 
Object owner = Model.getFacade().getOwner(element);
//#endif 


//#if 817844848 
return (Model.getFacade().isATagDefinition(element)
                && (owner == null || Model
                    .getFacade().getStereotypes(getTarget()).contains(owner)));
//#endif 

} 

//#endif 


//#if -1428617862 
@Override
    protected void removeOtherModelEventListeners(Object target)
    { 

//#if 1144117184 
Model.getPump().addClassModelEventListener(this,
                Model.getMetaTypes().getTagDefinition(), (String[]) null);
//#endif 

} 

//#endif 


//#if -196812532 
private static void addAllUniqueModelElementsFrom(Set elements,
            Set<List<String>> paths, Collection sources)
    { 

//#if 1026989265 
for (Object source : sources) //1
{ 

//#if -1147695693 
List<String> path = Model.getModelManagementHelper().getPathList(
                                    source);
//#endif 


//#if 1058887989 
if(!paths.contains(path))//1
{ 

//#if -242032484 
paths.add(path);
//#endif 


//#if 854466669 
elements.add(source);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

